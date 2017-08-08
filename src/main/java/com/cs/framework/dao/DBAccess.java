package main.java.com.cs.framework.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

//import Model.Likes;
import main.java.com.cs.framework.util.DBUtil;

public class DBAccess<T> implements IDataAccess<T>{

	private static  String dbDriver = "com.mysql.jdbc.Driver";
	private static  String dburl = "jdbc:mysql://localhost:3306/bank";
	private static  String DBNAME_STRING = "root";
	private static  String DBNAME_P_STRING = "root"; // P is changed
	private static Connection connection = null;
	
	private static DBAccess<?> instance = null;  

    public static DBAccess<?> getInstance() {  
    	 if(instance == null){
             instance = new DBAccess();
             
         }
         return instance;
    }
	 
    private DBAccess(){
    	connection = getConection();
    }
 
	public static synchronized  Connection getConection(){
		if (connection == null){
			try {
				Class.forName(dbDriver);
				connection = DriverManager.getConnection(dburl, DBNAME_STRING,DBNAME_P_STRING);
				System.out.println("connection ok");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public static synchronized  Connection getConection(String dbDriver,String dbUrl,String dbUser,String dbPassword){
		DBAccess.dbDriver = dbDriver;
		DBAccess.dburl = dbUrl;
		DBAccess.DBNAME_STRING = dbUser;
		DBAccess.DBNAME_P_STRING = dbPassword;
		if (connection == null){
			try {
				Class.forName(DBAccess.dbDriver);
				connection = DriverManager.getConnection(dburl, DBNAME_STRING,DBNAME_P_STRING);
				System.out.println("connection ok");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public static synchronized  Connection reConection(String dbDriver,String dbUrl,String dbUser,String dbPassword){
		connection = null;
		return getConection(dbDriver,dbUrl,dbUser,dbPassword);
	}
	
	@Override
	public ResultSet executeQuery(String sql) {
	        ResultSet rs = null;
	        try{
	        	Statement stmt = connection.createStatement();
	            System.out.println(this.getClass().getSimpleName()+" the query: " + sql);
	          	rs = stmt.executeQuery(sql);
	          	/*
	            while (rs.next()) {
	            	//rs.get
	                //fullname = rs.getString("fullname");
	                System.out.println("User Fullname: " + fullname);
	            }
	            //stmt.close();
	        	*/
	        } catch (SQLException s) {
	            System.out.println("Exception thrown in retrieveUser ....");
	            s.printStackTrace();
	        }
	        return rs;
	}
	
	@Override
	public boolean execute(String sql) {
        boolean result = false;
        try{
        	Statement stmt = connection.createStatement();
            System.out.println(this.getClass().getSimpleName()+" the execute: " + sql);
            //result = stmt.execute(sql);
            stmt.execute(sql);
            int i = stmt.getUpdateCount();
            if (i>0){
            	result = true;
            }
            //stmt.close();
        } catch (SQLException s) {
            System.out.println("Exception thrown in retrieveUser ....");
            s.printStackTrace();
        }
        return result;
	}
	
	
	@Override
	public Collection search(  T t  ,  Map m ){ //p1 is like user, post,Likes Comment; p2 filter map  
		Class clazz = t.getClass();
		Collection list = null ;
		try {
			String tableName = clazz.getName().toUpperCase();
			tableName = tableName.split("\\.")[tableName.split("\\.").length-1];
			StringBuffer  sqlBuffer = new StringBuffer("select * from ");
			sqlBuffer.append(" "+tableName+" ");
			sqlBuffer.append(" where 1=1 ");
			if (m.size() != 0){
				 String paramterString = DBUtil.mapConvertParamterString(m);
				 System.out.println(this.getClass().getSimpleName()+" paramterString:"+paramterString);
				 sqlBuffer.append(paramterString);
			}
    		ResultSet rs = this.executeQuery(sqlBuffer.toString());
    		list = DBUtil.resultSetToBean(rs, t.getClass());
    		//System.out.println(list.size());
    	} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Collection search(  T t ,  String sqlParamter ){ //p1 is like user, post,Likes Comment; p2 filter map  
		Class clazz = t.getClass();
		Collection list = null ;
		try {
			String tableName = clazz.getName().toUpperCase();
			tableName = tableName.split("\\.")[tableName.split("\\.").length-1];
			StringBuffer  sqlBuffer = new StringBuffer("select * from ");
			sqlBuffer.append(" "+tableName+" ");
			if (!StringUtils.isNullOrEmpty(sqlParamter) ){
				 System.out.println(this.getClass().getSimpleName()+" paramterString:"+sqlParamter);
				 sqlBuffer.append(sqlParamter);
			}
    		ResultSet rs = this.executeQuery(sqlBuffer.toString());
    		list = DBUtil.resultSetToBean(rs, t.getClass());
    		System.out.println(list.size());
    	} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public boolean  add ( T t ){ //p1 is like user, post,Likes Comment; p2 filter map  
		boolean result = false;
		try {
			String sqlBuffer = DBUtil.generInsertString(t);
			result = this.execute(sqlBuffer.toString());
    	} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
 
	
	
	

	
	/*public List<T>  search ( Object p1  ,  Object p2 ){ //p1 is like user, post,Likes Comment; p2 filter map  
	
		
	}
	
	public boolean  add ( Object p1   ){ //p1 is like user, post,Likes Comment; p2 filter map  
 
	}*/
	@Override
	public boolean  delete ( T t   )  { //p1 is like user, post,Likes Comment; p2 filter map  
		Class clazz = t.getClass();
		boolean resutl = false;
		try{
			String tableName = clazz.getName().toUpperCase();
			tableName = tableName.split("\\.")[tableName.split("\\.").length-1];
			Field[] fields=t.getClass().getDeclaredFields(); 
			String id = fields[0].getName(); //first attribute name
			fields[0].setAccessible(true);	//make the field and value can access
			Object value = fields[0].get(t);//first felid value
			//Connection connection = DBConnection.getConection();
			Statement statement = connection.createStatement(); 
			String sqlExecute = "delete from " + tableName + " where " + id + " = " +  value.toString();
			resutl = this.execute(sqlExecute);
		} catch (Exception e) {
			e.printStackTrace();
			resutl = false;
		}
		return resutl;
		//PreparedStatement preparedStmt = connection.prepareStatement(query);
		//return preparedStmt.execute();
		//return query;
 		//delete t from tableName; //do something 
		
	}
	
	@Override
	public boolean  update ( T t  ){ //p1 is like user, post,Likes Comment; p2 filter map  
		String query = null ;
		PreparedStatement preparedStmt; 
		boolean result = false;
		try {
			Field[] fields=t.getClass().getDeclaredFields(); 
			String id = fields[0].getName(); 	//first attribute name
			fields[0].setAccessible(true);		//make the field and value be accessed
			Object value = fields[0].get(t);	//first felid value
			Statement statement = connection.createStatement(); 
			query = generateUpdateSql(t);
			preparedStmt =  connection.prepareStatement(query);
			preparedStmt.execute();
			int i = preparedStmt.getUpdateCount();// modify  this bug:getUpdateCount judge the result 
            if (i>0){
            	result = true;
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(query);
		return result;
	}
	
	
	
	public String generateUpdateSql(T model) throws IllegalArgumentException, IllegalAccessException{
		 Field[] field = model.getClass().getDeclaredFields();
		 String tableName = model.getClass().getName().toLowerCase();
		 tableName = tableName.split("\\.")[tableName.split("\\.").length-1];
		 StringBuffer sqlBufferHead = new StringBuffer("update "+tableName+"");
		 StringBuffer sqlBufferCondition = new StringBuffer(" set ");
		 String[] numberTypeArray = {"java.lang.Long","java.lang.Int","java.lang.Integer","java.lang.Short","java.lang.Float","java.lang.Double","int","long","double","float"};
		 List<String> numberTypes = Arrays.asList(numberTypeArray);
		
        for(int j=1 ; j<field.length ; j++){     	// 
              String name = field[j].getName();    	//get attribute
              field[j].setAccessible(true);
              Object value = field[j].get(model);
              String methodType = field[j].getGenericType().toString(); 
              //System.out.println("attribute:"+name +"|value:"+value +"|type:"+methodType); 
              //name = name.substring(0,1).toUpperCase()+name.substring(1); // 
              methodType = methodType.replace("class ", "");
              //System.out.println("=>:"+methodType);
            
              if (value != null && !value.equals("")) {
  					if (numberTypes.contains(methodType)) {
  						sqlBufferCondition.append(" "+name +" = "+value);
	  				} else if (methodType.equalsIgnoreCase("java.lang.Boolean")) {
	  					sqlBufferCondition.append(" "+name +" = "+value);
	  				} else if (methodType.equalsIgnoreCase("java.util.Date")) {
	  					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  					String dateString = formatter.format(value);
	  					sqlBufferCondition.append(" "+name +" = "+dateString);
	  				} else if (methodType.equalsIgnoreCase("java.lang.String")) {
	  					sqlBufferCondition.append(" "+name +" = '"+value+"'");
	  				} else if (methodType.equalsIgnoreCase("java.io.InputStream")) {
	  					System.err.println("error:");
	  				} else if (methodType.equalsIgnoreCase("char")) {
	  					sqlBufferCondition.append(" "+name +" = '"+value+"'");
	  				}
  					if (j<field.length-1){
  						sqlBufferCondition.append(",");
  					} 
  			}
              
        }
        if (sqlBufferCondition.toString().endsWith(",")) sqlBufferCondition.deleteCharAt(sqlBufferCondition.lastIndexOf(","));
        sqlBufferHead.append(sqlBufferCondition);
        field[0].setAccessible(true);
        sqlBufferHead.append(" where "+field[0].getName()+"="+field[0].get(model));
        System.out.println("generInsertString:"+sqlBufferHead.toString());
        return sqlBufferHead.toString();
	}
	
	
	public static void main(String[] args) throws SQLException, IllegalArgumentException, IllegalAccessException {
		
	}
 
	
	
	


	
}
