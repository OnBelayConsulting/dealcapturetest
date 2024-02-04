package com.onbelay.dealcapturetest.restclient.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onbelay.core.entity.snapshot.ErrorHoldingSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class ApplicationExceptionFactoryBean implements ApplicationExceptionFactory {

    @Autowired
    private ObjectMapper objectMapper;

    public ApplicationWebClientException newApplicationWebClientExceptionTimeout(String target) {
        ErrorHoldingSnapshot errorHoldingSnapshot = new ErrorHoldingSnapshot("DCT_8000");
        errorHoldingSnapshot.setErrorMessage("Application Time-out");
        try {
            String json = objectMapper.writeValueAsString(errorHoldingSnapshot);
            return new ApplicationWebClientException(HttpStatus.GATEWAY_TIMEOUT, json);
        } catch (JsonProcessingException e) {
            return new ApplicationWebClientException(HttpStatus.BAD_REQUEST, "{}");
        }
    }

}
