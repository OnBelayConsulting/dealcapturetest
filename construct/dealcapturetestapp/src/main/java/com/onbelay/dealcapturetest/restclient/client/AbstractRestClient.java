package com.onbelay.dealcapturetest.restclient.client;

import com.onbelay.dealcapturetest.restclient.exception.ApplicationWebClientException;

import java.util.function.Predicate;

public abstract class AbstractRestClient {


    protected Predicate<Throwable> checkThrowable = (ex) -> {
        if (ex instanceof ApplicationWebClientException) {
            ApplicationWebClientException applicationWebClientException = (ApplicationWebClientException) ex;
            return applicationWebClientException.getHttpStatus().is5xxServerError();
        } else {
            return false;
        }
    };



}
