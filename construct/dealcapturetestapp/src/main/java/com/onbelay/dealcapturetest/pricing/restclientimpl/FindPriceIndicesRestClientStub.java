package com.onbelay.dealcapturetest.pricing.restclientimpl;

import com.onbelay.core.entity.snapshot.EntityId;
import com.onbelay.dealcapturetest.pricing.restclient.FindPriceIndicesRestClient;
import com.onbelay.dealcapturetest.pricing.snapshot.PriceIndexSnapshot;
import com.onbelay.dealcapturetest.pricing.snapshot.PriceIndexSnapshotCollection;

import java.util.List;

public class FindPriceIndicesRestClientStub implements FindPriceIndicesRestClient {
    @Override
    public PriceIndexSnapshotCollection findPriceIndices(String query, long start, int limit) {
        PriceIndexSnapshot snapshot = new PriceIndexSnapshot();
        snapshot.setEntityId(new EntityId(3));
        return new PriceIndexSnapshotCollection(0, 100, 1, List.of(snapshot));
    }
}
