package com.onbelay.dealcapturetest.dealmodule.deal.generatorimpl;

import com.onbelay.core.entity.snapshot.EntityId;
import com.onbelay.dealcapturetest.dealmodule.deal.enums.ValuationCode;
import com.onbelay.dealcapturetest.dealmodule.deal.generator.PhysicalDealsGenerator;
import com.onbelay.dealcapturetest.dealmodule.deal.snapshot.BaseDealSnapshot;
import com.onbelay.dealcapturetest.dealmodule.deal.snapshot.PhysicalDealSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GeneratePhysicalDealsRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class PhysicalDealsGeneratorBean implements PhysicalDealsGenerator {

    @Override
    public List<BaseDealSnapshot> generateDeals(GeneratePhysicalDealsRequest request) {
        ArrayList<BaseDealSnapshot> deals = new ArrayList<>();

        for (int i = 0; i < request.getDealsTotal(); i++) {
            PhysicalDealSnapshot snapshot = new PhysicalDealSnapshot();
            String ticketNo = request.getTicketNoPrefix() + i;
            snapshot.getDealDetail().setTicketNo(ticketNo);
            snapshot.getDealDetail().setCommodityCodeValue("NATGAS");

            snapshot.getDetail().setDealPriceValuationCode(determineDealPriceValuationCode(
                    request.getDealIndexName(),
                    request.getDealPrice()));
            snapshot.getDetail().setMarketValuationCode(ValuationCode.INDEX);

            snapshot.setMarketPriceIndexId(new EntityId(request.getMarketIndexName()));
            snapshot.setCompanyRoleId(new EntityId(request.getCompanyName()));
            snapshot.setCounterpartyRoleId(new EntityId(request.getCounterpartyName()));

            snapshot.getDealDetail().setDealStatusCodeValue(request.getDealStatus());
            snapshot.getDealDetail().setBuySellCodeValue(request.getBuySellCode());
            snapshot.getDealDetail().setStartDate(request.getStartDate());
            snapshot.getDealDetail().setEndDate(request.getEndDate());
            snapshot.getDealDetail().setReportingCurrencyCodeValue(request.getReportingCurrency());
            snapshot.getDealDetail().setVolumeQuantity(request.getVolumeQuantity());
            snapshot.getDealDetail().setVolumeUnitOfMeasureCodeValue(request.getDealPriceUnitOfMeasure());
            snapshot.getDealDetail().setVolumeQuantity(request.getVolumeQuantity());

            snapshot.getDetail().setDealPriceCurrencyCodeValue(request.getDealPriceCurrency());
            snapshot.getDetail().setDealPriceValue(request.getDealPrice());
            snapshot.getDetail().setDealPriceUnitOfMeasureCodeValue(request.getDealPriceUnitOfMeasure());
            deals.add(snapshot);
        }

        return deals;
    }

    private ValuationCode determineDealPriceValuationCode(String dealIndexName, BigDecimal dealPrice) {
        if (dealPrice != null) {
            if (dealIndexName == null)
                return ValuationCode.FIXED;
            else
                return ValuationCode.INDEX_PLUS;
        }  else {
            return ValuationCode.INDEX;
        }

    }
}
