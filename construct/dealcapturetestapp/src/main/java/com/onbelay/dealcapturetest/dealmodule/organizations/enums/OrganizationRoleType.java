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
package com.onbelay.dealcapturetest.dealmodule.organizations.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Defines the Organization Role types for an OrganizationRole
 * 
 * @author lefeuvrem
 *
 */
public enum OrganizationRoleType {
	COMPANY_ROLE 		("CO", "COMPANY_ROLE"),
    COUNTERPARTY_ROLE   ("CP", "COUNTERPARTY_ROLE");

	private final String code;
	private final String name;

    private static final Map<String,OrganizationRoleType> lookup 
    	= new HashMap<String,OrganizationRoleType>();

    private static final Map<String,OrganizationRoleType> lookupByName 
        = new HashMap<String,OrganizationRoleType>();

    static {
    	for(OrganizationRoleType c : EnumSet.allOf(OrganizationRoleType.class))
         lookup.put(c.code, c);
        for(OrganizationRoleType c : EnumSet.allOf(OrganizationRoleType.class))
         lookupByName.put(c.name, c);
    }
    
	private OrganizationRoleType(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
    public String getName() {
        return name;
    }
    
	public static OrganizationRoleType lookUp(String code) {
		return lookup.get(code);
	}

    public static OrganizationRoleType lookUpByName(String name) {
        return lookupByName.get(name);
    }
    
    public static OrganizationRoleType lookUpByNameOrCode(String name) {
		OrganizationRoleType rule = OrganizationRoleType.lookUp(name);
		if (rule != null) {
			return rule; 
		} else {
			return lookupByName.get(name);
		}
    }

}
