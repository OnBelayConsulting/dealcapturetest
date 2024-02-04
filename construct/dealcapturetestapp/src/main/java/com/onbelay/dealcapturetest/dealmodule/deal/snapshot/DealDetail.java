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
import com.onbelay.dealcapturetest.dealmodule.deal.enums.DealStatusCode;
import com.onbelay.dealcapturetest.dealmodule.deal.enums.UnitOfMeasureCode;
import com.onbelay.shared.enums.BuySellCode;
import com.onbelay.shared.enums.CurrencyCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DealDetail {

	private String commodityCodeValue;
	private String dealStatusCodeValue;
	private String buySellCodeValue;
	private String ticketNo;
	private LocalDate startDate;
	private LocalDate endDate;
	private BigDecimal volumeQuantity;
	private String volumeUnitOfMeasureCodeValue;
	private String reportingCurrencyCodeValue;
	
	public DealDetail() {
		
	}


	public BigDecimal getVolumeQuantity() {
		return volumeQuantity;
	}

	public void setVolumeQuantity(BigDecimal volumeQuantity) {
		this.volumeQuantity = volumeQuantity;
	}

	@JsonIgnore
	public UnitOfMeasureCode getVolumeUnitOfMeasure() {
		return UnitOfMeasureCode.lookUp(volumeUnitOfMeasureCodeValue);
	}

	public void setVolumeUnitOfMeasure(UnitOfMeasureCode code) {
		this.volumeUnitOfMeasureCodeValue = code.getCode();
	}

	public String getVolumeUnitOfMeasureCodeValue() {
		return volumeUnitOfMeasureCodeValue;
	}

	public void setVolumeUnitOfMeasureCodeValue(String volumeUnitOfMeasureCodeValue) {
		this.volumeUnitOfMeasureCodeValue = volumeUnitOfMeasureCodeValue;
	}

	@JsonIgnore
	public CurrencyCode getReportingCurrencyCode() {
		return CurrencyCode.lookUp(reportingCurrencyCodeValue);
	}

	public void setReportingCurrencyCode(CurrencyCode code) {
		this.reportingCurrencyCodeValue = code.getCode();
	}

	public String getReportingCurrencyCodeValue() {
		return reportingCurrencyCodeValue;
	}

	public void setReportingCurrencyCodeValue(String reportingCurrencyCodeValue) {
		this.reportingCurrencyCodeValue = reportingCurrencyCodeValue;
	}

	public String getCommodityCodeValue() {
		return commodityCodeValue;
	}

	public void setCommodityCodeValue(String commodityCodeValue) {
		this.commodityCodeValue = commodityCodeValue;
	}

	@JsonIgnore
	public DealStatusCode getDealStatus() {
		return DealStatusCode.lookUp(dealStatusCodeValue);
	}
	
	public void setDealStatus(DealStatusCode status) {
		this.dealStatusCodeValue = status.getCode();
	}
	
	public String getDealStatusCodeValue() {
		return dealStatusCodeValue;
	}

	public void setDealStatusCodeValue(String dealStatusCodeValue) {
		this.dealStatusCodeValue = dealStatusCodeValue;
	}

	@JsonIgnore
	public BuySellCode getBuySell() {
		return BuySellCode.lookUp(buySellCodeValue);
	}
	
	public void setBuySell(BuySellCode type) {
		buySellCodeValue = type.getCode();
	}
	
	public String getBuySellCodeValue() {
		return buySellCodeValue;
	}
	public void setBuySellCodeValue(String buySellCodeValue) {
		this.buySellCodeValue = buySellCodeValue;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	
	public void copyFrom(DealDetail copy) {
		if (copy.commodityCodeValue != null)
			this.commodityCodeValue = copy.commodityCodeValue;

		if (copy.dealStatusCodeValue != null)
			this.dealStatusCodeValue = copy.dealStatusCodeValue;
		
		if (copy.endDate != null)
			this.endDate = copy.endDate;
		
		if (copy.startDate != null)
			this.startDate = copy.startDate;
		
		if (copy.ticketNo != null)
			this.ticketNo = copy.ticketNo;
		
		if (copy.buySellCodeValue != null)
			this.buySellCodeValue = copy.buySellCodeValue;
		
		if (copy.volumeQuantity != null)
			this.volumeQuantity = copy.volumeQuantity;
		
		if (copy.volumeUnitOfMeasureCodeValue != null)
			this.volumeUnitOfMeasureCodeValue = copy.volumeUnitOfMeasureCodeValue;

		if (copy.reportingCurrencyCodeValue != null)
			this.reportingCurrencyCodeValue = copy.reportingCurrencyCodeValue;
	}
	
}
