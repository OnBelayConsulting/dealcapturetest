package com.onbelay.dealcapturetest.pricing.restclient;

import com.onbelay.dealcapturetest.pricing.snapshot.FxIndexSnapshotCollection;

public interface FindFxIndicesRestClient {

    FxIndexSnapshotCollection findFxIndices(
            String query,
            long start,
            int limit);

}
