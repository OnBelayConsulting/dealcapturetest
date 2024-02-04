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
package com.onbelay.dealcapturetest.pricing.snapshot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceIndexDetail {

	private String name;
	private String description;
	private Integer daysOffsetForExpiry;
	private String indexTypeValue;
	private String currencyCodeValue;
	private String unitOfMeasureCodeValue;
	private String frequencyCodeValue;
	
	public PriceIndexDetail() {
		
	}
	
	@JsonIgnore
	public void setDefaults() {
		daysOffsetForExpiry = 0;

	}

	public String getCurrencyCodeValue() {
		return currencyCodeValue;
	}

	public void setCurrencyCodeValue(String currencyCodeValue) {
		this.currencyCodeValue = currencyCodeValue;
	}


	public String getFrequencyCodeValue() {
		return frequencyCodeValue;
	}

	public void setFrequencyCodeValue(String frequencyCodeValue) {
		this.frequencyCodeValue = frequencyCodeValue;
	}

	public String getUnitOfMeasureCodeValue() {
		return unitOfMeasureCodeValue;
	}

	public void setUnitOfMeasureCodeValue(String unitOfMeasureCodeValue) {
		this.unitOfMeasureCodeValue = unitOfMeasureCodeValue;
	}

	public String getIndexTypeValue() {
		return indexTypeValue;
	}

	public void setIndexTypeValue(String indexTypeValue) {
		this.indexTypeValue = indexTypeValue;
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


	public Integer getDaysOffsetForExpiry() {
		return daysOffsetForExpiry;
	}


	public void setDaysOffsetForExpiry(Integer daysOffsetForExpiry) {
		this.daysOffsetForExpiry = daysOffsetForExpiry;
	}


	public void copyFrom(PriceIndexDetail copy) {
		
		if (copy.name != null)
			this.name = copy.name;
		
		if (copy.frequencyCodeValue != null)
			this.frequencyCodeValue = copy.frequencyCodeValue;

		if (copy.currencyCodeValue != null)
			this.currencyCodeValue = copy.currencyCodeValue;

		if (copy.unitOfMeasureCodeValue != null)
			this.unitOfMeasureCodeValue = copy.unitOfMeasureCodeValue;
		
		if (copy.description != null)
			this.description = copy.description;
		
		if (copy.daysOffsetForExpiry != null)
			this.daysOffsetForExpiry = copy.daysOffsetForExpiry;
		
		if (copy.indexTypeValue != null)
			this.indexTypeValue = copy.getIndexTypeValue();
	}
	
}
