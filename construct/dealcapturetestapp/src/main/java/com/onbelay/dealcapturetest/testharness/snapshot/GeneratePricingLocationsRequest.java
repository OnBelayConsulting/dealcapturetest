package com.onbelay.dealcapturetest.testharness.snapshot;

public class GeneratePricingLocationsRequest {

    private String locationNamePrefix;
    private int total;

    public String getLocationNamePrefix() {
        return locationNamePrefix;
    }

    public void setLocationNamePrefix(String locationNamePrefix) {
        this.locationNamePrefix = locationNamePrefix;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
