package com.cs.framework.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.cs.framework.model.concrete.Permission;
import com.cs.framework.model.concrete.UserPermission;
import com.cs.framework.model.concrete.Users;
import com.cs.framework.util.DBUtil;

public class PermissionDao {
	
	DBAccess dBAccess = DBAccess.getInstance();
	
	public boolean updatePermission(Permission permission){
		boolean result = dBAccess.update(permission);
		return result ;
	}
	
	public List<Permission> searchPermission(Map hm){
		List<Permission> list = (List<Permission>) dBAccess.search(new Permission(), hm);
		//System.out.println("Permission list.size():"+list.size());
		if (list.size() != 1){
			System.out.println("list is not only one Permission");
		}else{
			//result = list.get(0);
		}
		return list ;
	}
	
	public boolean deletePermission(Permission permission){
		boolean result = dBAccess.delete(permission);
		return result ;
	}
	
	public Permission addPermission(Permission permission){
		Permission returnPermission = null; 
		boolean result = dBAccess.add(permission);
		if (result){
			returnPermission = permission;
		}
		return returnPermission ;
	}
  
	public List<Permission> searchPermissionByUser(Users user){
		StringBuffer sql = new StringBuffer("select p.* from userpermission up left join users u on up.userid=u.userid left join permission p on up.permissionid = p.permissionid where 1=1");
		sql.append(" and up.userid = "+user.getUserid());
		ResultSet rs = dBAccess.executeQuery( sql.toString());
		List list = (List)DBUtil.resultSetToBean(rs, Permission.class);
		return list ;
	}

	public Permission searchPermissionByRole(Permission permission){
		Permission returnPermission = null;
		boolean result = dBAccess.add(permission);
		if (result){
			returnPermission = permission;
		}
		return returnPermission ;
	}
	
	/*
	 * 
	 */
	public void setUserPermission(Users user,List<Permission> permissionList){
		StringBuffer sql = new StringBuffer("delete from userpermission where 1=1 ");
		sql.append(" and userid="+user.getUserid());
		boolean result = dBAccess.execute(sql.toString());
		//System.out.println("result:"+result);
		for(Permission permission : permissionList ){
			UserPermission up = new UserPermission();
			up.setUserid(user.getUserid());
			up.setPermissionid(permission.getPermissionid());
			dBAccess.add(up);
		}
	}
	
	
	
	
}
