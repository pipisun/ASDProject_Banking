package com.cs.framework.model.abstraction;

import java.util.List;

public abstract class AbstractRole {

	private List<AbstractUser> userList;
	
	private List<AbstractPermission> permissionList;
	
	public abstract void addPermission(AbstractPermission permission);
	public abstract void removePermission(AbstractPermission permission);
	
	public abstract boolean validatePermission(AbstractPermission permission);
	
	public void addUser(AbstractUser user){
		if (user != null)
			this.userList.add(user);
	}
	
	public void removeRole(AbstractUser user){
		if (user != null)
			this.userList.remove(user);
	}
	
	public List<AbstractPermission> getPermissionList() {
		return permissionList;
	}
	
	public void setPermissionList(List<AbstractPermission> permissionList) {
		this.permissionList = permissionList;
	}
	
	
	
	
}
