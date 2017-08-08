package main.java.com.cs.framework.model.concrete;

import main.java.com.cs.framework.model.abstraction.AbstractPermission;
import main.java.com.cs.framework.model.abstraction.AbstractRole;

public class Role extends AbstractRole{
	private int roleid;
	private String rolename;
	private String description;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public void addPermission(AbstractPermission permission) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removePermission(AbstractPermission permission) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean validatePermission(AbstractPermission permission) {
		// TODO Auto-generated method stub
		return false;
	}
 
	
}
