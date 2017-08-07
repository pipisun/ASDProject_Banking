package com.cs.framework.model.concrete;



import java.util.ArrayList;
import java.util.List;

import com.cs.framework.dao.UserDao;
import com.cs.framework.model.abstraction.AbstractPermission;
import com.cs.framework.model.abstraction.AbstractUser;

public class Users extends AbstractUser{

	private int userid;
	private String fullname;
	private int gender;//male 1    female 0
	private String state;
	private String city;
	private String street;
	private int zipcode;
	private int birthyear;
	private String email;
	private String password;
	private Status status;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public int getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void recognizePermisson(Users user) {  
        if (status.getValue().equals("login")) {  
        	status.getPermission(user);  
        } else if (status.getValue().equals("logout")) {  
        	status.clearPermission(user);  
        }  
    }
	
	public void setPermissionList(List<AbstractPermission> plist) {
		this.permissionList = plist;
	}
	
	void clearPermissionList() {
		this.permissionList = new ArrayList<AbstractPermission>();
	}
	
	@Override
	public void addPermission(AbstractPermission permission) {
		this.permissionList.add(permission);
	}
	@Override
	public void removePermission(AbstractPermission permission) {
		this.permissionList.remove(permission);
	}
 
	@Override
	public boolean validatePermission(AbstractPermission permission) {
		/*
		List<Permission> systemPermissions = Constant.getSystemPermissions();
		boolean result = systemPermissions.contains(permission);
		for(int i = 0;i<systemPermissions.size();i++){
			
		}
		*/
		boolean result = this.permissionList.contains(permission);
		//judge user's role's permissionList
		return result;
	}
	
	@Override
	public AbstractUser login(String userName, String password) {
		UserDao dao = new UserDao();
		Users user = dao.login(userName, password);
		user.setStatus(new Status("login"));
		user.recognizePermisson(user);
		return user;
	}
	@Override
	public boolean logOut(AbstractUser user) {
		Users u = (Users)user;
		u.setStatus(new Status("logout"));
		u.recognizePermisson(u);
		return true;
	}
	
	public boolean validatePermissionCode(String permissionCode) {
		boolean result = false;
		for(AbstractPermission permission: this.permissionList){
    		result = ((Permission)permission).equalsPermissionCode(permissionCode);
			if (result) break;
		}
		return result;
	}
	
	//test for permission
	public static void main(String[] args) {
		testForUserPermission();
	}
	
	public static void testForUserPermission (){
		AbstractPermission permission = new Permission(111,"Form1.Menu1.Item111","Form1.Menu1.Item111",null);
		Users users = new Users();
		users.addPermission(permission);
		Permission permission1 = new Permission(111,"Form1.Menu1.Item111","Form1.Menu1.Item111",null);
		boolean b = users.validatePermission(permission1);
		System.err.println(b);
		 
	}
	
	public static void testForPermission (){
		AbstractPermission permission = new Permission(111,"Form1.Menu1.Item111","Form1.Menu1.Item111",null);
		Users users = new Users();
		boolean b = users.validatePermission(permission);
		System.err.println(b);
		/*
		Permission permission1 = new Permission(111,"Form1.Menu1.Item111","Form1.Menu1.Item111",null);
		System.err.println(permission.equals(permission1));
		*/
	}
	
	
}

