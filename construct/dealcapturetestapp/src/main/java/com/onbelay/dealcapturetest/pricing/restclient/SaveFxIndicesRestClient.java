package com.onbelay.dealcapturetest.pricing.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.pricing.snapshot.FxIndexSnapshot;

import java.util.List;

public interface SaveFxIndicesRestClient {

    TransactionResult saveFxIndices(List<FxIndexSnapshot> snapshots);

}
