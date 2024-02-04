package com.onbelay.dealcapturetest.dealmodule.positions.restclientimpl;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.dealmodule.positions.restclient.GeneratePositionsRestClient;
import com.onbelay.dealcapturetest.dealmodule.positions.snapshot.EvaluationContextRequest;

public class GeneratePositionsRestClientStub implements GeneratePositionsRestClient {
    @Override
    public TransactionResult generatePositions(String queryText, EvaluationContextRequest context) {
        return new TransactionResult();
    }
}
