/*
 Copyright 2019, OnBelay Consulting Ltd.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.  
 */
package com.onbelay.dealcapturetest.dealmodule.deal.snapshot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.onbelay.dealcapturetest.dealmodule.deal.enums.UnitOfMeasureCode;
import com.onbelay.dealcapturetest.dealmodule.deal.enums.ValuationCode;
import com.onbelay.shared.enums.CurrencyCode;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhysicalDealDetail  {

	private String dealPriceValuationCodeValue;
	private String marketValuationCodeValue;
	private BigDecimal dealPriceValue;
	private String dealPriceCurrencyCodeValue;
	private String dealPriceUnitOfMeasureCodeValue;

	public PhysicalDealDetail() {
	}

	public void setDefaults() {
		dealPriceValuationCodeValue = ValuationCode.FIXED.getCode();
		marketValuationCodeValue = ValuationCode.INDEX.getCode();
	}
	
	public PhysicalDealDetail(
			BigDecimal dealPrice, 
			CurrencyCode currency,
			UnitOfMeasureCode unitOfMeasure) {

		dealPriceValuationCodeValue = ValuationCode.FIXED.getCode();
		this.dealPriceValue = dealPrice;
		this.dealPriceCurrencyCodeValue = currency.getCode();
		this.dealPriceUnitOfMeasureCodeValue = unitOfMeasure.getCode();
	}

	@JsonIgnore
	public ValuationCode getDealPriceValuationCode() {
		return ValuationCode.lookUp(dealPriceValuationCodeValue);
	}

	public void setDealPriceValuationCode(ValuationCode code) {
		this.dealPriceValuationCodeValue = code.getCode();
	}

	public String getDealPriceValuationCodeValue() {
		return dealPriceValuationCodeValue;
	}

	@JsonIgnore
	public ValuationCode getMarketValuationCode() {
		return ValuationCode.lookUp(marketValuationCodeValue);
	}

	public void setMarketValuationCode(ValuationCode code) {
		this.marketValuationCodeValue = code.getCode();
	}

	public String getMarketValuationCodeValue() {
		return marketValuationCodeValue;
	}

	public void setMarketValuationCodeValue(String marketValuationCodeValue) {
		this.marketValuationCodeValue = marketValuationCodeValue;
	}

	public void setDealPriceValuationCodeValue(String dealPriceValuationCodeValue) {
		this.dealPriceValuationCodeValue = dealPriceValuationCodeValue;
	}

    public BigDecimal getDealPriceValue() {
		return dealPriceValue;
	}

    public void setDealPriceValue(BigDecimal dealPriceValue) {
		this.dealPriceValue = dealPriceValue;
	}

	@JsonIgnore
	public CurrencyCode getDealPriceCurrency() {
		return CurrencyCode.lookUp(dealPriceCurrencyCodeValue);
	}

	public void setDealPriceCurrency(CurrencyCode code) {
		this.dealPriceCurrencyCodeValue = code.getCode();
	}

    public String getDealPriceCurrencyCodeValue() {
		return dealPriceCurrencyCodeValue;
	}


    public void setDealPriceCurrencyCodeValue(String dealPriceCurrencyValue) {
		this.dealPriceCurrencyCodeValue = dealPriceCurrencyValue;
	}

	@JsonIgnore
	public UnitOfMeasureCode getDealPriceUnitOfMeasure() {
		return UnitOfMeasureCode.lookUp(dealPriceUnitOfMeasureCodeValue);
	}

	public void setDealPriceUnitOfMeasure(UnitOfMeasureCode code) {
		this.dealPriceUnitOfMeasureCodeValue = code.getCode();
	}

    public String getDealPriceUnitOfMeasureCodeValue() {
		return dealPriceUnitOfMeasureCodeValue;
	}

    public void setDealPriceUnitOfMeasureCodeValue(String dealPriceUoMValue) {
		this.dealPriceUnitOfMeasureCodeValue = dealPriceUoMValue;
	}

    public void copyFrom(PhysicalDealDetail copy) {
		if (copy.dealPriceValuationCodeValue != null)
			this.dealPriceValuationCodeValue = copy.dealPriceValuationCodeValue;

		if (copy.marketValuationCodeValue != null)
			this.marketValuationCodeValue = copy.marketValuationCodeValue;

		if (copy.dealPriceValue != null)
    		this.dealPriceValue = copy.dealPriceValue;
    	
    	if (copy.dealPriceCurrencyCodeValue != null)
    		this.dealPriceCurrencyCodeValue = copy.dealPriceCurrencyCodeValue;
    	
    	if (copy.dealPriceUnitOfMeasureCodeValue != null)
    		this.dealPriceUnitOfMeasureCodeValue = copy.dealPriceUnitOfMeasureCodeValue;
    }
	
}
