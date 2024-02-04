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
import com.onbelay.core.entity.snapshot.AbstractDetail;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDetail extends AbstractDetail {
	
	private Boolean isHoldingParent;

	public Boolean getIsHoldingParent() {
		return isHoldingParent;
	}

	public void setIsHoldingParent(Boolean isRoot) {
		this.isHoldingParent = isRoot;
	}

	public void copyFrom(CompanyDetail copy) {
		if (copy.isHoldingParent != null)
			this.isHoldingParent = copy.isHoldingParent;
	}

}
