package com.onbelay.dealcapturetest.restclient.exception;

import org.springframework.stereotype.Component;

@Component
public interface ApplicationExceptionFactory {

    public ApplicationWebClientException newApplicationWebClientExceptionTimeout(String target);

}
