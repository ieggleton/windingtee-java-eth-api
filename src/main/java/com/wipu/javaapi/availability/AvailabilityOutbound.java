package com.wipu.javaapi.availability;

import java.util.List;
import java.util.Map;

public class AvailabilityOutbound {

    private Map<String, Object> availability;
    private List<OtherHotelAvailability> partnerAvailability;

    public Map<String, Object> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<String, Object> availability) {
        this.availability = availability;
    }

    public List<OtherHotelAvailability> getPartnerAvailability() {
        return partnerAvailability;
    }

    public void setPartnerAvailability(List<OtherHotelAvailability> partnerAvailability) {
        this.partnerAvailability = partnerAvailability;
    }
}
