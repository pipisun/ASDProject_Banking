package com.cs.framework.model.concrete;

import java.util.List;

import com.cs.framework.dao.PermissionDao;

public class Status {
	
	private String value;  
    
    public Status(String value) {
		super();
		this.value = value;
	}

	public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }  
  
    public void getPermission(Users user){
    	PermissionDao permissionDao = new PermissionDao();
    	List plist = permissionDao.searchPermissionByUser(user);
    	user.setPermissionList(plist);
        System.out.println("execute getPermission!");  
    }  
      
    public void clearPermission(Users user){
    	user.clearPermissionList();
    }
    
}
