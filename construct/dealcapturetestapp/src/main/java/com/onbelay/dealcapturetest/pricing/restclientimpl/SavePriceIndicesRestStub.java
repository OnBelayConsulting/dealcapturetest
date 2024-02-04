package com.onbelay.dealcapturetest.pricing.restclientimpl;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.pricing.restclient.SavePriceIndicesRestClient;
import com.onbelay.dealcapturetest.pricing.snapshot.PriceIndexSnapshot;

import java.util.List;

public class SavePriceIndicesRestStub implements SavePriceIndicesRestClient {
    @Override
    public TransactionResult savePriceIndices(List<PriceIndexSnapshot> snapshotList) {
        return new TransactionResult();
    }
}
