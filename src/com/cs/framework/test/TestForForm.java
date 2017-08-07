package com.cs.framework.test;



import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.cs.framework.dao.DBAccess;
import com.cs.framework.dao.PermissionDao;
import com.cs.framework.model.concrete.Constant;
import com.cs.framework.model.concrete.Permission;
import com.cs.framework.model.concrete.Users;
import com.cs.framework.util.DBUtil;

import bank.ui.BankMainWindow;

 

public class TestForForm {
	
	static DBAccess dBAccess = DBAccess.getInstance();
	
	public static void main(String[] args)    {
		//testForDataAccess();
		//testForUserDao();
		//testForPermissionDao();
		testForSetUserPermission();
		/*
		List list1 = Constant.getSystemPermissions();
		BankMainWindow win = new BankMainWindow("Bank Application");
		//testForForm(win);
		String sql = "select * from users where userid=18";
		ResultSet rs = dBAccess.executeQuery(sql);
		List list = (List)DBUtil.resultSetToBean(rs, Users.class);
		System.out.println(list.size());
		Users user = (Users)list.get(0);
		checkJFramePermission(user,win);
		*/
	}
	
	public static void testForForm(JFrame frame){
		/*
		Component[] cs = frame.getContentPane().getComponents(); 
		for (int i = 0; i < cs.length; i++) { 
			System.out.println("cs[i].getClass().getName():"+cs[i].getClass().getName());
		}
		*/
		//frame.getMenuBar()
		for (int i = 0; i < frame.getRootPane().getMenuBar().getMenuCount(); i++) {
			JMenu menu = frame.getRootPane().getMenuBar().getMenu(i);
			for (int j = 0; j < menu.getItemCount(); j++) {
				JMenuItem item = menu.getItem(j);
				if (item != null){
					System.out.println("item.getName():"+item.getLabel() +"|item.getName():"+item.getName());
					if (item.getLabel().equals("About...")){
						item.setEnabled(false);
					}
				}
				//System.out.println("item.getName():"+item.getName());
				/*
				for (int z = 0; z < ((Container) item).getComponentCount(); z++) {
					Component component = item.getComponent(z);
					System.out.println("item.getName():"+item.getName()+"	|component.getName():"+component.getName());	
				}
				*/
			}
			
		}
		System.out.println("testForForm end:");
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
		//System.out.println("checkJFramePermission end:");
	}
	
	public static void testForPermissionDao(){
		PermissionDao p = new PermissionDao();
		Users u  = new Users();
		u.setUserid(18);
		List list = p.searchPermissionByUser(u);
		System.out.println("permission list:"+list.size());
	}
	
	public static void testForSetUserPermission(){
		PermissionDao p = new PermissionDao();
		Users u  = new Users();
		u.setUserid(23);
		List<Permission>  list = Constant.getStaticSystemPermissions();
		p.setUserPermission(u,list);
		System.out.println("testForSetUserPermission end");
	}
	
	
	
}
