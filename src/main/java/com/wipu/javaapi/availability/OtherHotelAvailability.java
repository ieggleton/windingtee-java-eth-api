package com.wipu.javaapi.availability;

import java.util.Map;

public class OtherHotelAvailability {

    public OtherHotelAvailability() {
    }

    public OtherHotelAvailability(String hotelName, Map<String, Object> availability) {
        this.hotelName = hotelName;
        this.availability = availability;
    }

    private String hotelName;
    private Map<String, Object> availability;

    public String getHotelName() {
        return hotelName;
    }

    public Map<String, Object> getAvailability() {
        return availability;
    }
}
