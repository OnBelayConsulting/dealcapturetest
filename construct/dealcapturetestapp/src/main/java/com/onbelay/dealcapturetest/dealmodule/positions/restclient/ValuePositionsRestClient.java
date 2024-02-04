package com.onbelay.dealcapturetest.dealmodule.positions.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;

public interface ValuePositionsRestClient {

    TransactionResult valuePositions(String queryText);

}
