package com.cs.framework.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.framework.model.concrete.Users;

public class UserDao {
	
	DBAccess dBAccess = DBAccess.getInstance();
	
	public Users login(String userName, String password){
		Users result = null;
		
		HashMap hm = new HashMap();
		hm.put("email", userName);
		hm.put("password", password);
		List<Users> list = (List<Users>) dBAccess.search(new Users(), hm);
		System.out.println("list.size():"+list.size());
		if (list.size() != 1){
			System.out.println("list is not only one user");
		}else{
			result = list.get(0);
		}
		/*
		String sql = "select * from users where ";
		ResultSet rs = dBAccess.executeQuery(sql);
		Collection list = DBUtil.resultSetToBean(rs, Users.class);
		System.out.println(list.size());
		*/
		return result ;
	}
	
	public boolean updateUser(Users user){
		boolean result = dBAccess.update(user);
		return result ;
	}
	
	public List<Users> searchUser(Map hm){
		List<Users> list = (List<Users>) dBAccess.search(new Users(), hm);
		System.out.println("list.size():"+list.size());
		if (list.size() != 1){
			System.out.println("list is not only one user");
		}else{
			//result = list.get(0);
		}
		return list ;
	}
	
	public boolean deleteUser(Users user){
		boolean result = dBAccess.delete(user);
		return result ;
	}
	public Users addUser(Users user){
		Users returnUser = null; 
		boolean result = dBAccess.add(user);
		if (result){
			returnUser = user;
		}
		return returnUser ;
	}
  
}
