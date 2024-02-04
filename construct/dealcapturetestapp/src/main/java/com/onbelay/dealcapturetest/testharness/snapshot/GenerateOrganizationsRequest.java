package com.onbelay.dealcapturetest.testharness.snapshot;

public class GenerateOrganizationsRequest {

    private String organizationNamePrefix;
    private int total = 1;


    public String getOrganizationNamePrefix() {
        return organizationNamePrefix;
    }

    public void setOrganizationNamePrefix(String organizationNamePrefix) {
        this.organizationNamePrefix = organizationNamePrefix;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
