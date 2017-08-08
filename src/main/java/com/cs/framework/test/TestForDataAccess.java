package main.java.com.cs.framework.test;


import java.sql.ResultSet;
import java.util.Collection;

import main.java.com.cs.framework.controller.UserImp;
import main.java.com.cs.framework.dao.DBAccess;
import main.java.com.cs.framework.dao.UserDao;
import main.java.com.cs.framework.model.concrete.Users;
import main.java.com.cs.framework.util.DBUtil;

public class TestForDataAccess {

	
	public static void main(String[] args)    {
		//testForDataAccess();
		//testForUserDao();
		testForAddDao();
	}
	
	public static void testForDataAccess(){
		Users user = new Users();
		user.setUserid(0);
		user.setEmail("fullname@email.com");
		user.setFullname("fullname");
		user.setPassword("password");
		DBAccess dBAccess = DBAccess.getInstance();
		boolean result = dBAccess.add(user);
		System.out.println("result:"+result);
		Users u1 = new Users();
		u1.setUserid(15);
		u1.setFullname("fullname-modify");
		dBAccess.update(u1);
		
		String sql = "select * from users ";
		ResultSet rs = dBAccess.executeQuery(sql);
		Collection list = DBUtil.resultSetToBean(rs, Users.class);
		System.out.println(list.size());
		
		//String result = db1.retrieveUserFullname("hi");
		//System.out.println(result);
	}
	
	/*
    public static void testForDBUtil(){
    	DataAccess dataAccess = new DataAccess();
    	DBUtil dbUtil = new DBUtil();
    	try {
    		String  search = "select * from users ";
    		ResultSet rs = dataAccess.executeQuery(search);
    		List list = (List)DBUtil.resultSetToBean(rs, Users.class);
    		System.out.println(list.size());
    		Users user =  (Users)list.get(0);
    		dbUtil.generInsertString(user);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	 */
	
    public static void testForUserDao(){
    	//UserDao userDao = new UserDao();
    	//AbstractUser user = userDao.login("test@gmail.com", "test");
    	UserImp  userImp = new UserImp();
    	Users user = (Users) userImp.login("test@gmail.com", "test");
    	System.out.println(user.getFullname());
    }
    
    
    public static void testForAddDao(){
    	UserDao  userDao = new UserDao();
    	Users user  = new Users();
    	user.setZipcode(52557);
    	user.setStreet("street");
    	user.setState("state");
    	user.setPassword("paul");
    	user.setGender(1);
    	user.setFullname("fullname");
    	user.setEmail("paul@gmail.com");
    	user.setBirthyear(1985);
    	user.setCity("city");
    	Users user1 = (Users) userDao.addUser(user);
    	System.out.println(user.getFullname());
    }
	
	
}
