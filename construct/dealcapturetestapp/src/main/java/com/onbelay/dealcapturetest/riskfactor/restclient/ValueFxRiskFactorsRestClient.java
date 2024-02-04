package com.onbelay.dealcapturetest.riskfactor.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;

public interface ValueFxRiskFactorsRestClient {

    TransactionResult valueRiskFactors(String queryText);

}
