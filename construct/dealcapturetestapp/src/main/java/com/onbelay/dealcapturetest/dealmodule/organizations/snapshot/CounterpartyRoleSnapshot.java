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
package com.onbelay.dealcapturetest.dealmodule.organizations.snapshot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.onbelay.dealcapturetest.dealmodule.organizations.enums.OrganizationRoleType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CounterpartyRoleSnapshot extends OrganizationRoleSnapshot {

	private CounterpartyDetail detail = new CounterpartyDetail();

	
	public CounterpartyRoleSnapshot() {
		super(OrganizationRoleType.COUNTERPARTY_ROLE);
	}
	
	public CounterpartyDetail getDetail() {
		return detail;
	}

	public void setDetail(CounterpartyDetail detail) {
		this.detail = detail;
	}
	
	
	
}
