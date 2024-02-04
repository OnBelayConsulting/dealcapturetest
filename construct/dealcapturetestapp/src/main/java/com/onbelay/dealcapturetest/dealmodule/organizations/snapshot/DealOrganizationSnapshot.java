/*
 * Copyright (c) 2018-2019 OnBelay Consulting
 * All Rights Reserved
*/
package com.onbelay.dealcapturetest.dealmodule.organizations.snapshot;

import com.onbelay.core.entity.snapshot.AbstractSnapshot;

import java.util.List;

public class DealOrganizationSnapshot extends AbstractSnapshot {

	private DealOrganizationDetail detail = new DealOrganizationDetail();

	public DealOrganizationSnapshot() {
	}

	public DealOrganizationSnapshot(String errorCode) {
		super(errorCode);
	}

	public DealOrganizationSnapshot(String errorCode, boolean isPermissionException) {
		super(errorCode, isPermissionException);
	}

	public DealOrganizationSnapshot(String errorCode, List<String> parameters) {
		super(errorCode, parameters);
	}

	public DealOrganizationDetail getDetail() {
		return detail;
	}

	public void setDetail(DealOrganizationDetail detail) {
		this.detail = detail;
	}
	
	public String toString() {
		
		return getEntityId() + " " + detail.toString();
	}

}
