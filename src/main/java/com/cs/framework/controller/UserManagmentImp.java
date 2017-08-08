package main.java.com.cs.framework.controller;

import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import main.java.com.cs.framework.dao.UserDao;
import main.java.com.cs.framework.model.abstraction.AbstractUser;
import main.java.com.cs.framework.model.concrete.Constant;
import main.java.com.cs.framework.model.concrete.Users;

public class UserManagmentImp implements IUserManagment {

	UserDao userDao = new UserDao();

	private static UserManagmentImp instance = null;

	private UserManagmentImp() {
	}

	public static UserManagmentImp getInstance() {
		if (instance == null) {
			synchronized (UserManagmentImp.class) {
				if (instance == null) {
					instance = new UserManagmentImp();
				}
			}
		}
		return instance;
	}

	@Override
	public AbstractUser addUser(AbstractUser user) {
		userDao.addUser((Users) user);
		return null;
	}

	@Override
	public boolean deleteUser(AbstractUser user) {
		userDao.deleteUser((Users) user);
		return false;
	}

	@Override
	public AbstractUser updateUser(AbstractUser user) {
		AbstractUser u = null;
		boolean result = userDao.updateUser((Users) user);
		if (result) {
			u = user;
		}
		return u;
	}

	@Override
	public List<AbstractUser> searchUser(Map map) {
		List list = userDao.searchUser(map);
		return list;
	}
	
	public static void checkJFramePermission(Users user,JFrame frame){
		for (int i = 0; i < frame.getRootPane().getMenuBar().getMenuCount(); i++) {
			JMenu menu = frame.getRootPane().getMenuBar().getMenu(i);
			for (int j = 0; j < menu.getItemCount(); j++) {
				JMenuItem item = menu.getItem(j);
				if (item != null){
					System.out.println("item.getName():"+item.getLabel() +"|item.getName():"+item.getName());
					if (Constant.isPermissionCode(item.getName())){
						if (user.validatePermissionCode(item.getName())){
							item.setEnabled(true);
						}else{
							item.setEnabled(false);
						}
					}
				}
			}
		}
	}

}
