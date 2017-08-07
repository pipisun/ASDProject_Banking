package com.cs.framework.model.concrete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cs.framework.controller.IPermission;
import com.cs.framework.dao.PermissionDao;


public class Constant implements IPermission{
	
	private static List<Permission> systemPermissions = null;
	
	@Override
	public List<Permission> getSystemPermissionsImp() {
		return Constant.getStaticSystemPermissions();
	}
	
    public static List<Permission> getStaticSystemPermissions() {
		if(systemPermissions == null){
			systemPermissions = generateSystemPermissions();
		}
		return systemPermissions;
    }
    
    //init the SystemPermissions need to manage
    private static List<Permission> generateSystemPermissions(){
    	List<Permission> list = new ArrayList<Permission>();
    	/*
    	
    	list.add( new Permission(1,"BankMainWindow.Menu1.Item11","Form1.Menu1.Item111",null) );
    	list.add( new Permission(2,"BankMainWindow.Menu1.Item12","Form1.Menu1.Item111",null) );
    	list.add( new Permission(3,"BankMainWindow.Menu1.Item13","Form1.Menu1.Item111",null) );
    	
    	list.add( new Permission(4,"BankMainWindow.Menu2.Item21","Form1.Menu1.Item111",null) );
    	list.add( new Permission(5,"BankMainWindow.Menu2.Item22","Form1.Menu1.Item111",null) );
    	list.add( new Permission(6,"BankMainWindow.Menu2.Item23","Form1.Menu1.Item111",null) );
    	
    	list.add( new Permission(7,"BankMainWindow.Menu3.Item31","Form1.Menu1.Item111",null) );
    	list.add( new Permission(8,"BankMainWindow.Menu3.Item32","Form1.Menu1.Item111",null) );
    	list.add( new Permission(9,"BankMainWindow.Menu3.Item33","Form1.Menu1.Item111",null) );
    	
    	list.add( new Permission(10,"BankMainWindow.Menu4.Item41","Form1.Menu1.Item111",null) );
    	list.add( new Permission(11,"BankMainWindow.Menu4.Item42","Form1.Menu1.Item111",null) );
    	list.add( new Permission(12,"BankMainWindow.Menu4.Item43","Form1.Menu1.Item111",null) );
    	*/
    	PermissionDao permissionDao = new PermissionDao();
    	list = permissionDao.searchPermission(new HashMap());
    	return list;
    }
    
    public static boolean isPermissionCode(String permissionCode){
    	boolean result = false;
    	for(Permission permission: Constant.getStaticSystemPermissions()){
    		result = permission.equalsPermissionCode(permissionCode);
			if (result) break;
		}
    	return result;
    }
    
	
	public static void main(String[] args) {
		List<Permission>  list = generateSystemPermissions();
		for (int i = 1; i < 20; i++) {
			Permission p = list.get(i);
			System.out.println(p.getPermissionname());
		}
		
	}

	@Override
	public List<Permission> getPermissionByUserImp(Users user) {
		PermissionDao permissionDao = new PermissionDao();
		List<Permission> list = permissionDao.searchPermissionByUser(user);
		return list;
	}

	
	
}
