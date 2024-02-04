package com.onbelay.dealcapturetest.testharness.snapshot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GenerateCurvesRequest {

    private String query;
    private LocalDate startDate = LocalDate.of(2023, 1, 1);
    private LocalDate endDate = LocalDate.of(2023, 12, 31);
    private LocalDateTime observedDateTime = LocalDateTime.now();
    private String frequencyCode;
    private BigDecimal value;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal fxValue) {
        this.value = fxValue;
    }

    public String getFrequencyCode() {
        return frequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
    }
}
