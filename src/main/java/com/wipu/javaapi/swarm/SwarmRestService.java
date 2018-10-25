package com.wipu.javaapi.swarm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipu.javaapi.availability.AvailabilityOutbound;
import com.wipu.javaapi.availability.AvailabilityService;
import com.wipu.javaapi.availability.AvailabilityWrapper;
import com.wipu.javaapi.availability.OtherHotelAvailability;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SwarmRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwarmRestService.class);
    private static final String DESCRIPTION_URI_OBJ = "descriptionUri";

    private final RestTemplate restTemplate;
    private final String swarmUrl;
    private final ObjectMapper objectMapper;

    public SwarmRestService(RestTemplate restTemplate, @Value("${swarm.url}") String swarmUrl, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.swarmUrl = swarmUrl;
        this.objectMapper = objectMapper;
    }

    public JSONObject getBaseDataUris(String dataUri) {
        HttpEntity httpEntity = buildCloudflareAvoidanceEntity();
        String json = restTemplate.exchange(swarmUrl + dataUri, HttpMethod.GET, httpEntity, String.class)
                .getBody();
        return new JSONObject(json);
    }

    private HttpEntity buildCloudflareAvoidanceEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3584.0 Safari/537.36");

        return new HttpEntity(null, headers);
    }

    public Map<String, Object> getAvailability(String availabilityUri) {
        Map<String, Object> availability = new HashMap<>();
        HttpEntity httpEntity = buildCloudflareAvoidanceEntity();
        String availabilityJson = restTemplate.exchange(swarmUrl + availabilityUri, HttpMethod.GET, httpEntity, String.class)
                .getBody();
        try {
            availability.putAll(
                    objectMapper.readValue(availabilityJson, AvailabilityWrapper.class)
                            .getLatestSnapshot()
                            .getAvailability()
            );
        } catch (Exception ex) {
            LOGGER.error("Blah", ex);
        }
        return availability;
    }

    public AvailabilityOutbound getMultiAvailability(List<JSONObject> hotelPartnerDataUris, AvailabilityOutbound availabilityOutbound) {
        availabilityOutbound.setPartnerAvailability(
                hotelPartnerDataUris.stream()
                        .map(dataURI -> {
                            String availabilityURI = (String) dataURI.get(AvailabilityService.AVAILABILITY_URI_OBJ);
                            String descriptionURI = (String) dataURI.get(DESCRIPTION_URI_OBJ);
                            return new OtherHotelAvailability(getHotelName(descriptionURI), getAvailability(availabilityURI));
                        })
                        .collect(Collectors.toList())
        );
        return availabilityOutbound;
    }

    private String getHotelName(String descriptionUri) {
        HttpEntity httpEntity = buildCloudflareAvoidanceEntity();
        String descriptionJson = restTemplate.exchange(swarmUrl + descriptionUri, HttpMethod.GET, httpEntity, String.class)
                .getBody();
        return (String) new JSONObject(descriptionJson).get("name");
    }
}
