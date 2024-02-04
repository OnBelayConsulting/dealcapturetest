/*
 * Copyright (c) 2018-2019 OnBelay Consulting
 * All Rights Reserved
*/
package com.onbelay.dealcapturetest.dealmodule.organizations.snapshot;

import com.onbelay.core.entity.snapshot.AbstractDetail;

public class DealOrganizationDetail extends AbstractDetail {

	private String shortName;
	private boolean isShortNameNull;
	
	private String legalName;
	private boolean isLegalNameNull;

	private Integer externalReferenceId;

	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		isShortNameNull = isNull(shortName);
		this.shortName = shortName;
	}
	
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		isLegalNameNull = isNull(legalName);
		this.legalName = legalName;
	}

	public Integer getExternalReferenceId() {
		return externalReferenceId;
	}

	public void setExternalReferenceId(Integer externalReferenceId) {
		this.externalReferenceId = externalReferenceId;
	}

	public void copyFrom(DealOrganizationDetail copy) {
		
		if (copy.shortName != null || copy.isShortNameNull)
			this.shortName = copy.shortName;
		
		if (copy.legalName != null || copy.isLegalNameNull)
			this.legalName = copy.legalName;

		if (copy.externalReferenceId != null)
			this.externalReferenceId = copy.externalReferenceId;
	}
	
	public String toString() {
		return shortName + " : " + legalName;
	}
}
