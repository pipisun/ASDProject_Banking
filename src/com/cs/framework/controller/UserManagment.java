package com.cs.framework.controller;

import java.util.Map;

import com.cs.framework.model.abstraction.AbstractPermission;
import com.cs.framework.model.abstraction.AbstractUser;

public abstract class UserManagment {
	
	public abstract AbstractUser addUser(AbstractUser user);
	public abstract boolean deleteUser(AbstractUser user);
	public abstract AbstractUser updateUser(AbstractUser user);
	public abstract boolean searchUser(Map map);//key is user's property ,value is purpos search condition
	
	public abstract AbstractUser login();
	public abstract boolean logOut();
	public abstract boolean validatePermission(AbstractPermission permission);
	
	
	
}
