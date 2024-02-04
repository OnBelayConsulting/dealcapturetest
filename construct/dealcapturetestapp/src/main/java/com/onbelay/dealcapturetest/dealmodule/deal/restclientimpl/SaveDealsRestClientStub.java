package com.onbelay.dealcapturetest.dealmodule.deal.restclientimpl;

import com.onbelay.core.entity.snapshot.EntityId;
import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.dealmodule.deal.restclient.SaveDealsRestClient;
import com.onbelay.dealcapturetest.dealmodule.deal.snapshot.BaseDealSnapshot;

import java.util.List;

public class SaveDealsRestClientStub implements SaveDealsRestClient {
    @Override
    public TransactionResult createDeals(List<BaseDealSnapshot> snapshotList) {

        return new TransactionResult(3);
    }
}
