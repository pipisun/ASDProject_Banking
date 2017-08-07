package com.cs.framework.model.abstraction;

import java.util.ArrayList;
import java.util.List;

import com.cs.framework.controller.IUser;

public abstract class AbstractUser implements IUser{
	private AbstractOrgDept deptment ;
	private String email;		//email is ACCOUNT NAME
	private String password;
	private List<AbstractRole> roleList;
	protected List<AbstractPermission> permissionList = new ArrayList<AbstractPermission>();
	
	public abstract void addPermission(AbstractPermission permission);
	public abstract void removePermission(AbstractPermission permission);

	public abstract boolean validatePermission(AbstractPermission permission);
	
	//observer 
	
	public void addRole(AbstractRole role){
		if (role != null)
			this.roleList.add(role);
	}
	
	public void removeRole(AbstractRole role){
		if (role != null)
			this.roleList.remove(role);
	}
	
	public AbstractOrgDept getDeptment(){
		return deptment;
	}
	
	public void setDeptment(AbstractOrgDept d){
		this.deptment = d ;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<AbstractPermission> getPermissionList() {
		return permissionList;
	}
	
	
}
