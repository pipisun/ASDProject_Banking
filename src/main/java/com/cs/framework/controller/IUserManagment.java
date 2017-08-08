package main.java.com.cs.framework.controller;

import java.util.List;
import java.util.Map;

import main.java.com.cs.framework.model.abstraction.AbstractPermission;
import main.java.com.cs.framework.model.abstraction.AbstractUser;

public interface IUserManagment {
	
	public abstract AbstractUser addUser(AbstractUser user);
	public abstract boolean deleteUser(AbstractUser user);
	public abstract AbstractUser updateUser(AbstractUser user);
	public abstract List<AbstractUser> searchUser(Map map);//key is user's property ,value is purpos search condition
	

	
	
	
}
