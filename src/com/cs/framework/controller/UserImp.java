package com.cs.framework.controller;


import com.cs.framework.dao.UserDao;
import com.cs.framework.model.abstraction.AbstractPermission;
import com.cs.framework.model.abstraction.AbstractUser;

public class UserImp implements IUser{

	@Override
	public AbstractUser login(String userName, String password) {
		UserDao userDao = new UserDao();
		return userDao.login(userName, password);
	}

	@Override
	public boolean logOut(AbstractUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validatePermission(AbstractPermission permission) {
		// TODO Auto-generated method stub
		return false;
	}

	 

}
