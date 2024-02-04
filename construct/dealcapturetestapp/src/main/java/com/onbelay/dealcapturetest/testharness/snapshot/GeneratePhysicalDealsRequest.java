package com.onbelay.dealcapturetest.testharness.snapshot;

import java.math.BigDecimal;

public class GeneratePhysicalDealsRequest extends AbstractGenerateDealsRequest {

    private String marketIndexName;
    private BigDecimal dealPrice;
    private String dealPriceCurrency = "CAD";
    private String dealPriceUnitOfMeasure = "GJ";

    public String getMarketIndexName() {
        return marketIndexName;
    }

    public void setMarketIndexName(String marketIndexName) {
        this.marketIndexName = marketIndexName;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getDealPriceCurrency() {
        return dealPriceCurrency;
    }

    public void setDealPriceCurrency(String dealPriceCurrency) {
        this.dealPriceCurrency = dealPriceCurrency;
    }

    public String getDealPriceUnitOfMeasure() {
        return dealPriceUnitOfMeasure;
    }

    public void setDealPriceUnitOfMeasure(String dealPriceUnitOfMeasure) {
        this.dealPriceUnitOfMeasure = dealPriceUnitOfMeasure;
    }
}
