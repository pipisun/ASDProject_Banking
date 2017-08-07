package com.cs.framework.controller;

import com.cs.framework.model.abstraction.AbstractPermission;
import com.cs.framework.model.abstraction.AbstractUser;

public interface IUser {
	public abstract AbstractUser login(String userName,String password);
	public abstract boolean logOut(AbstractUser user);
	public abstract boolean validatePermission(AbstractPermission permission);
	
}
