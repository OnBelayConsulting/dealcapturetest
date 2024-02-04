package com.onbelay.dealcapturetest.testharness.snapshot;

import com.onbelay.dealcapturetest.dealmodule.deal.enums.DealStatusCode;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AbstractGenerateDealsRequest {

    private int dealsTotal = 1;

    private String companyName = "ML_";
    private String counterpartyName = "CP_";
    private LocalDate startDate = LocalDate.of(2023, 1, 1);
    private LocalDate endDate= LocalDate.of(2023, 12, 31);
    private String dealStatus = DealStatusCode.VERIFIED.getCode();
    private String ticketNoPrefix = "tk_";
    private String unitOfMeasureCode = "GJ";
    private String reportingCurrency = "CAD";
    private BigDecimal volumeQuantity = BigDecimal.valueOf(100);

    public int getDealsTotal() {
        return dealsTotal;
    }

    public void setDealsTotal(int dealsTotal) {
        this.dealsTotal = dealsTotal;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCounterpartyName() {
        return counterpartyName;
    }

    public void setCounterpartyName(String counterpartyName) {
        this.counterpartyName = counterpartyName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getTicketNoPrefix() {
        return ticketNoPrefix;
    }

    public void setTicketNoPrefix(String ticketNoPrefix) {
        this.ticketNoPrefix = ticketNoPrefix;
    }

    public String getUnitOfMeasureCode() {
        return unitOfMeasureCode;
    }

    public void setUnitOfMeasureCode(String unitOfMeasureCode) {
        this.unitOfMeasureCode = unitOfMeasureCode;
    }

    public String getReportingCurrency() {
        return reportingCurrency;
    }

    public void setReportingCurrency(String reportingCurrency) {
        this.reportingCurrency = reportingCurrency;
    }

    public BigDecimal getVolumeQuantity() {
        return volumeQuantity;
    }

    public void setVolumeQuantity(BigDecimal volumeQuantity) {
        this.volumeQuantity = volumeQuantity;
    }
}
