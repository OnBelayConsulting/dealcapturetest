package com.onbelay.dealcapturetest.testharness.snapshot;

import java.math.BigDecimal;

public class GeneratePhysicalDealsRequest extends AbstractGenerateDealsRequest {

    private String marketIndexName;
    private BigDecimal fixedPrice;
    private String dealIndexName;
    private String fixedPriceCurrency = "CAD";
    private String fixedPriceUnitOfMeasure = "GJ";

    public String getMarketIndexName() {
        return marketIndexName;
    }

    public void setMarketIndexName(String marketIndexName) {
        this.marketIndexName = marketIndexName;
    }

    public BigDecimal getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(BigDecimal fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public String getFixedPriceCurrency() {
        return fixedPriceCurrency;
    }

    public void setFixedPriceCurrency(String fixedPriceCurrency) {
        this.fixedPriceCurrency = fixedPriceCurrency;
    }

    public String getFixedPriceUnitOfMeasure() {
        return fixedPriceUnitOfMeasure;
    }

    public void setFixedPriceUnitOfMeasure(String fixedPriceUnitOfMeasure) {
        this.fixedPriceUnitOfMeasure = fixedPriceUnitOfMeasure;
    }

    public String getDealIndexName() {
        return dealIndexName;
    }

    public void setDealIndexName(String dealIndexName) {
        this.dealIndexName = dealIndexName;
    }
}
