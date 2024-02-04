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
import com.onbelay.shared.enums.CurrencyCode;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DealCostDetail  {

	private BigDecimal costPerUnitValue;
	private String currencyCodeValue;
	private String unitOfMeasureCodeValue;
	private String name;
	private String description; 


    public BigDecimal getCostPerUnitValue() {
		return costPerUnitValue;
	}


	public void setCostPerUnitValue(BigDecimal costValue) {
		this.costPerUnitValue = costValue;
	}

	@JsonIgnore
	public CurrencyCode getCurrency() {
		return CurrencyCode.lookUp(currencyCodeValue);
	}

	public void setCurrency(CurrencyCode code) {
		this.currencyCodeValue = code.getCode();
	}

	public String getCurrencyCodeValue() {
		return currencyCodeValue;
	}


	public void setCurrencyCodeValue(String currencyCodeValue) {
		this.currencyCodeValue = currencyCodeValue;
	}


	@JsonIgnore
	public UnitOfMeasureCode getUnitOfMeasure() {
		return UnitOfMeasureCode.lookUp(unitOfMeasureCodeValue);
	}

	public void setUnitOfMeasure(UnitOfMeasureCode code) {
		this.unitOfMeasureCodeValue = code.getCode();
	}

    public String getUnitOfMeasureCodeValue() {
		return unitOfMeasureCodeValue;
	}


    public void setUnitOfMeasureCodeValue(String costUoMValue) {
		this.unitOfMeasureCodeValue = costUoMValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



    public void copyFrom(DealCostDetail copy) {
    	this.costPerUnitValue = copy.costPerUnitValue;
    	this.currencyCodeValue = copy.currencyCodeValue;
    	this.unitOfMeasureCodeValue = copy.unitOfMeasureCodeValue;
    	this.name = copy.name;
    	this.description = copy.description;
    }
	
}
