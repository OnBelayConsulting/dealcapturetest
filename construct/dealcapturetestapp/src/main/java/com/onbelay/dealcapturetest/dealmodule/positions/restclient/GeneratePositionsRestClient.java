package com.onbelay.dealcapturetest.dealmodule.positions.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.dealmodule.positions.snapshot.EvaluationContextRequest;

public interface GeneratePositionsRestClient {

    TransactionResult generatePositions(
            String queryText,
            EvaluationContextRequest context);

}
