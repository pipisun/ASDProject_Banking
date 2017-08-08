package main.java.com.cs.framework.dao;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Map;

public interface IDataAccess<T> {
	
	ResultSet executeQuery(String sql);
	boolean   execute(String sql);
	Collection search(  T t  ,  Map m );
	Collection search(  T t ,  String sqlParamter );
	boolean  add ( T t );
	boolean  update ( T t  ); 
	boolean  delete ( T t );
}
