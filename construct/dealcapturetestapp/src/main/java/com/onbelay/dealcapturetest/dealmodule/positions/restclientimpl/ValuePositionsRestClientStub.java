package com.onbelay.dealcapturetest.dealmodule.positions.restclientimpl;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.dealmodule.positions.restclient.ValuePositionsRestClient;

public class ValuePositionsRestClientStub implements ValuePositionsRestClient {
    @Override
    public TransactionResult valuePositions(String queryText) {
        return new TransactionResult();
    }
}
