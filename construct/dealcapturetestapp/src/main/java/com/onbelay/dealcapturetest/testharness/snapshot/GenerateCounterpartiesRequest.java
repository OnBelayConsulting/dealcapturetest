package com.onbelay.dealcapturetest.testharness.snapshot;

public class GenerateCounterpartiesRequest extends GenerateOrganizationRolesRequest {

    private String settlementCurrency;

    public String getSettlementCurrency() {
        return settlementCurrency;
    }

    public void setSettlementCurrency(String settlementCurrency) {
        this.settlementCurrency = settlementCurrency;
    }
}
