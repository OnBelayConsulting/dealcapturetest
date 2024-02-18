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

            snapshot.getDetail().setDealPriceValuationCode(
                    determineValuationCode(
                        request.getDealIndexName(),
                        request.getFixedPrice()));

            // set deal pricing
            if (snapshot.getDetail().getDealPriceValuationCode() == ValuationCode.FIXED) {
                snapshot.getDetail().setFixedPriceCurrencyCodeValue(request.getFixedPriceCurrency());
                snapshot.getDetail().setFixedPriceValue(request.getFixedPrice());
                snapshot.getDetail().setFixedPriceUnitOfMeasureCodeValue(request.getFixedPriceUnitOfMeasure());
            } else if (snapshot.getDetail().getDealPriceValuationCode() == ValuationCode.INDEX) {
                snapshot.setDealPriceIndexId(new EntityId(request.getDealIndexName()));
            } else {
                snapshot.getDetail().setFixedPriceCurrencyCodeValue(request.getFixedPriceCurrency());
                snapshot.getDetail().setFixedPriceValue(request.getFixedPrice());
                snapshot.getDetail().setFixedPriceUnitOfMeasureCodeValue(request.getFixedPriceUnitOfMeasure());
                snapshot.setDealPriceIndexId(new EntityId(request.getDealIndexName()));
            }

            snapshot.getDetail().setMarketValuationCode(
                    determineValuationCode(
                            request.getMarketIndexName(),
                            request.getFixedPrice()));

            if (snapshot.getDetail().getMarketValuationCode() == ValuationCode.INDEX) {
                snapshot.setMarketPriceIndexId(new EntityId(request.getMarketIndexName()));
            } else {
                snapshot.setMarketPriceIndexId(new EntityId(request.getMarketIndexName()));
                snapshot.getDetail().setFixedPriceCurrencyCodeValue(request.getFixedPriceCurrency());
                snapshot.getDetail().setFixedPriceValue(request.getFixedPrice());
                snapshot.getDetail().setFixedPriceUnitOfMeasureCodeValue(request.getFixedPriceUnitOfMeasure());
            }
            snapshot.setCompanyRoleId(new EntityId(request.getCompanyName()));
            snapshot.setCounterpartyRoleId(new EntityId(request.getCounterpartyName()));

            snapshot.getDealDetail().setDealStatusCodeValue(request.getDealStatus());
            snapshot.getDealDetail().setBuySellCodeValue(request.getBuySellCode());
            snapshot.getDealDetail().setStartDate(request.getStartDate());
            snapshot.getDealDetail().setEndDate(request.getEndDate());
            snapshot.getDealDetail().setReportingCurrencyCodeValue(request.getReportingCurrency());
            snapshot.getDealDetail().setVolumeQuantity(request.getVolumeQuantity());
            snapshot.getDealDetail().setVolumeUnitOfMeasureCodeValue(request.getFixedPriceUnitOfMeasure());
            snapshot.getDealDetail().setVolumeQuantity(request.getVolumeQuantity());

            deals.add(snapshot);
        }

        return deals;
    }

    /*
    Determine the valuation code from the fixed price and/or deal price or market price indices
     */
    private ValuationCode determineValuationCode(
            String indexName,
            BigDecimal fixedPrice) {

        if (fixedPrice != null) {
            if (indexName == null)
                return ValuationCode.FIXED;
            else
                return ValuationCode.INDEX_PLUS;
        }  else {
            return ValuationCode.INDEX;
        }

    }
}
