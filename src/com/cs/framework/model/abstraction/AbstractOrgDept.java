package com.cs.framework.model.abstraction;

import java.util.List;

public abstract class AbstractOrgDept {

	private AbstractOrgDept parentOrgDept;
	private List<AbstractOrgDept> childOrgDeptList;
	private int orgDeptid;
	private String name;
	
	public abstract List<AbstractUser> getUserlist();
	
	
}
