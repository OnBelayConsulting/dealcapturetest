package com.onbelay.dealcapturetest.pricing.restclientimpl;

import com.onbelay.core.entity.snapshot.EntityId;
import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.pricing.restclient.SaveFxIndicesRestClient;
import com.onbelay.dealcapturetest.pricing.snapshot.FxIndexSnapshot;

import java.util.List;

public class SaveFxIndicesRestStub implements SaveFxIndicesRestClient {
    @Override
    public TransactionResult saveFxIndices(List<FxIndexSnapshot> snapshots) {
        return new TransactionResult(4);
    }
}
