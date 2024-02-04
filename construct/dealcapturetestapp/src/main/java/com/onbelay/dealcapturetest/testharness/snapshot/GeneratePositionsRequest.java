package com.onbelay.dealcapturetest.testharness.snapshot;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GeneratePositionsRequest {

    private String query;
    private String currencyCode;
    private LocalDate startDate = LocalDate.of(2023, 1, 1);
    private LocalDate endDate = LocalDate.of(2023, 12, 31);
    private LocalDateTime observedDateTime = LocalDateTime.now();


    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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

    public LocalDateTime getObservedDateTime() {
        return observedDateTime;
    }

    public void setObservedDateTime(LocalDateTime observedDateTime) {
        this.observedDateTime = observedDateTime;
    }
}
