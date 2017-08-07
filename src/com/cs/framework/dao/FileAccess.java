package com.cs.framework.dao;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Map;

public class FileAccess<T> implements IDataAccess<T>{

	@Override
	public ResultSet executeQuery(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean execute(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection search(T t, Map m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection search(T t, String sqlParamter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

}
