package com.wipu.javaapi.availability;

import java.util.Date;
import java.util.Map;

public class LatestSnapshot {

    private Map<String, Object> availability;
    private Date updatedAt;

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Map<String, Object> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<String, Object> availability) {
        this.availability = availability;
    }
}
