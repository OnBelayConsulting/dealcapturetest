package com.onbelay.dealcapturetest.pricing.restclientimpl;

import com.onbelay.core.entity.snapshot.EntityId;
import com.onbelay.dealcapturetest.pricing.restclient.FindFxIndicesRestClient;
import com.onbelay.dealcapturetest.pricing.snapshot.FxIndexSnapshot;
import com.onbelay.dealcapturetest.pricing.snapshot.FxIndexSnapshotCollection;

import java.util.List;

public class FindFxIndicesRestStub implements FindFxIndicesRestClient {
    @Override
    public FxIndexSnapshotCollection findFxIndices(String query, long start, int limit) {
        FxIndexSnapshot snapshot = new FxIndexSnapshot();
        snapshot.setEntityId(new EntityId(3));
        return new FxIndexSnapshotCollection(0, 100, 1, List.of(snapshot));
    }
}
