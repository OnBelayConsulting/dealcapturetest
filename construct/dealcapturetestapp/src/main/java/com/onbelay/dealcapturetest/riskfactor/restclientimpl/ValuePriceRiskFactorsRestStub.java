package com.onbelay.dealcapturetest.riskfactor.restclientimpl;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.riskfactor.restclient.ValuePriceRiskFactorsRestClient;

public class ValuePriceRiskFactorsRestStub implements ValuePriceRiskFactorsRestClient {
    @Override
    public TransactionResult valueRiskFactors(String queryText) {
        return new TransactionResult();
    }
}
