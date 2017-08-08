package main.java.com.cs.framework.model.concrete;

import main.java.com.cs.framework.model.abstraction.AbstractPermission;

public class UserPermission extends AbstractPermission {
	
	private int userpermissionid;
	private int permissionid;
	private int userid;
	private int roleid;
	
	public UserPermission() {
		super();
	}

	public int getUserpermissionid() {
		return userpermissionid;
	}

	public void setUserpermissionid(int userpermissionid) {
		this.userpermissionid = userpermissionid;
	}

	public int getPermissionid() {
		return permissionid;
	}

	public void setPermissionid(int permissionid) {
		this.permissionid = permissionid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
}
