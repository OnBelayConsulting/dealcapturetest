package com.onbelay.dealcapturetest.pricing.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.pricing.snapshot.PriceIndexSnapshot;

import java.util.List;

public interface SavePriceIndicesRestClient {

    public TransactionResult savePriceIndices(List<PriceIndexSnapshot> snapshotList);

}
