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
import com.onbelay.shared.enums.CurrencyCode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FxIndexDetail {

	private String name;
	private String description;
	private String fromCurrencyCodeValue;
	private String toCurrencyCodeValue;
	private String frequencyValue;
	private Integer daysOffsetForExpiry;

	public FxIndexDetail() {

	}

	@JsonIgnore
	public void setDefaults() {
		frequencyValue = "M";
	}


	@JsonIgnore
	public CurrencyCode getFromCurrencyCode() {
		return CurrencyCode.lookUp(fromCurrencyCodeValue);
	}
	
	public void setFromCurrencyCode(CurrencyCode code) {
		if (code != null)
			this.fromCurrencyCodeValue = code.getCode();
		else 
			this.fromCurrencyCodeValue = null;
	}

	public String getFromCurrencyCodeValue() {
		return fromCurrencyCodeValue;
	}

	public void setFromCurrencyCodeValue(String fromCurrencyCodeValue) {
		this.fromCurrencyCodeValue = fromCurrencyCodeValue;
	}


	@JsonIgnore
	public CurrencyCode getToCurrencyCode() {
		return CurrencyCode.lookUp(toCurrencyCodeValue);
	}

	public void setToCurrencyCode(CurrencyCode code) {
		if (code != null)
			this.toCurrencyCodeValue = code.getCode();
		else
			this.toCurrencyCodeValue = null;
	}
	public String getToCurrencyCodeValue() {
		return toCurrencyCodeValue;
	}

	public void setToCurrencyCodeValue(String toCurrencyCodeValue) {
		this.toCurrencyCodeValue = toCurrencyCodeValue;
	}


	public String getFrequencyValue() {
		return frequencyValue;
	}

	public void setFrequencyValue(String frequencyValue) {
		this.frequencyValue = frequencyValue;
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


	public void copyFrom(FxIndexDetail copy) {
		
		if (copy.name != null)
			this.name = copy.name;
		
		if (copy.frequencyValue != null)
			this.frequencyValue = copy.frequencyValue;

		if (copy.toCurrencyCodeValue != null)
			this.toCurrencyCodeValue = copy.toCurrencyCodeValue;

		if (copy.fromCurrencyCodeValue != null)
			this.fromCurrencyCodeValue = copy.fromCurrencyCodeValue;
		
		if (copy.description != null)
			this.description = copy.description;
		
		if (copy.daysOffsetForExpiry != null)
			this.daysOffsetForExpiry = copy.daysOffsetForExpiry;
	}
	
}
