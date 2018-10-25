package com.wipu.javaapi.availability;

import com.wipu.javaapi.smart.contract.SmartContractService;
import com.wipu.javaapi.swarm.SwarmRestService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvailabilityService {

    public static final String AVAILABILITY_URI_OBJ = "availabilityUri";

    private final SmartContractService smartContractService;
    private final SwarmRestService swarmRestService;

    public AvailabilityService(SmartContractService smartContractService, SwarmRestService swarmRestService) {
        this.smartContractService = smartContractService;
        this.swarmRestService = swarmRestService;
    }

    public Optional<AvailabilityOutbound> getAvailability(String hotelAddress) {
        return smartContractService.getHotelDataURI(hotelAddress)
                .map(dataUri -> {
                    JSONObject baseDataUris = swarmRestService.getBaseDataUris(dataUri);
                    AvailabilityOutbound availabilityOutbound = new AvailabilityOutbound();
                    availabilityOutbound.setAvailability(swarmRestService.getAvailability((String) baseDataUris.get(AVAILABILITY_URI_OBJ)));

                    List<JSONObject> partnerDataUris = smartContractService.getHotelPartnerDataUris(hotelAddress).stream()
                            .map(dataURI -> swarmRestService.getBaseDataUris(dataUri))
                            .collect(Collectors.toList());

                    availabilityOutbound = swarmRestService.getMultiAvailability(partnerDataUris, availabilityOutbound);

                    return availabilityOutbound;
                });
    }
}
