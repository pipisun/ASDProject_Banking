package com.cs.framework.controller;

import java.util.List;

import com.cs.framework.model.concrete.Permission;
import com.cs.framework.model.concrete.Users;

public interface IPermission {
	
	public static List<Permission> getSystemPermissions(){
		return getSystemPermissionsImp();
	}
	
	static List<Permission>  getSystemPermissionsImp() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public default List<Permission>  getPermissionByUser(Users user){
		return getPermissionByUserImp(user);
	}
	
	List<Permission>  getPermissionByUserImp(Users user);
	
	
}
