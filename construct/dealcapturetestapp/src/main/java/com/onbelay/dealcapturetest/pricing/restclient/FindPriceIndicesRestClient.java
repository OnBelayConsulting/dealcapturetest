package com.onbelay.dealcapturetest.pricing.restclient;

import com.onbelay.dealcapturetest.pricing.snapshot.PriceIndexSnapshotCollection;

public interface FindPriceIndicesRestClient {

    PriceIndexSnapshotCollection findPriceIndices(
            String query,
            long start,
            int limit);

}
