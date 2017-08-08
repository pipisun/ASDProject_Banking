package main.java.com.cs.framework.model.concrete;

import main.java.com.cs.framework.model.abstraction.AbstractPermission;

public class Permission extends AbstractPermission {
	private int permissionid;
	private String permissioncode;
	private String permissionname;
	private String description;
	
	 
	public Permission() {
		super();
	}

	public Permission(int permissionid, String permissioncode,
			String permissionname, String description) {
		super();
		this.permissionid = permissionid;
		this.permissioncode = permissioncode;
		this.permissionname = permissionname;
		this.description = description;
	}
	
	//private boolean checked;
	public int getPermissionid() {
		return permissionid;
	}
	public void setPermissionid(int permissionid) {
		this.permissionid = permissionid;
	}
	public String getPermissionname() {
		return permissionname;
	}
	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPermissioncode() {
		return permissioncode;
	}
	public void setPermissioncode(String permissioncode) {
		this.permissioncode = permissioncode;
	}
	
	@Override
	public boolean equals(Object obj) {   
        if (obj instanceof AbstractPermission) {   
        	Permission p = (Permission) obj;   
            return  this.permissionid == p.permissionid
            		&& this.permissioncode.equals(p.permissioncode)   
                    && this.permissionname.equals(permissionname);   
        }   
        return super.equals(obj);
	}
	
	public boolean equalsPermissionCode(String permissionCode) {
		return this.permissioncode.equals(permissionCode);
	}
}
