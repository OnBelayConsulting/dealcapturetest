package com.onbelay.dealcapturetest.riskfactor.restclientimpl;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.riskfactor.restclient.ValueFxRiskFactorsRestClient;

public class ValueRxRiskFactorsRestStub implements ValueFxRiskFactorsRestClient {
    @Override
    public TransactionResult valueRiskFactors(String queryText) {
        return new TransactionResult();
    }
}
