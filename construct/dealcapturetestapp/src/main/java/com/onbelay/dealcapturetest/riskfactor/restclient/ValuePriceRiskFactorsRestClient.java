package com.onbelay.dealcapturetest.riskfactor.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;

public interface ValuePriceRiskFactorsRestClient {

    TransactionResult valueRiskFactors(String queryText);

}
