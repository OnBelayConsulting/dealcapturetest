package com.onbelay.dealcapturetest.dealmodule.deal.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.dealmodule.deal.snapshot.BaseDealSnapshot;

import java.util.List;

public interface SaveDealsRestClient {

    public TransactionResult createDeals(List<BaseDealSnapshot> snapshotList);

}
