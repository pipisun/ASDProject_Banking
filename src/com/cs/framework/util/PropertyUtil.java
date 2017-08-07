package com.cs.framework.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Parameter;
import java.util.Properties;

/**
 * PropertyUtil read util
 */
public class PropertyUtil {

	/**
	 *  property 
	 */
	//public static final String PROPERTY_FILE = WindowsUtil.getOSName().equals("Windows XP")? "c:/windows/config.properties":"d:\\config.properties";
	public static final String LOG_FILE = "c:/windows/EcollectLog.properties";

	/**
	 *  
	 * 
	 * @param key
	 * @param filepath
	 * @return
	 */
	public static String readData(String key,String filepath) {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(filepath));
			props.load(in);
			in.close();
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	/**
	 *  
	 * 
	 * @param key
	 * @param value
	 * @param filepath
	 */
	public static void writeData(String key, String value,String filepath) {
		Properties prop = new Properties();
		try {
			File file = new File(filepath);
			if (!file.exists())
				file.createNewFile();
			InputStream fis = new FileInputStream(file);
			prop.load(fis);
			fis.close();// 
			OutputStream fos = new FileOutputStream(filepath);
			prop.setProperty(key, value);
			prop.store(fos, "Update '" + key + "' value");
			fos.close();
		} catch (IOException e) {
			System.err.println("Visit " + filepath + " for updating "
					+ value + " value error");
		}
	}
	/**
	 * get Parameter
	 * @return
	 */
	public static Parameter getParameterByFile(String filepath){
		Parameter p = null;
		File f = new File(filepath);
		if(f.exists()){
			
			//p = new Parameter(null, 0, null, 0);
			/*
			p.setIp(readData("ip"));	
			p.setPort(readData("port"));
			p.setLocalFolder(readData("localFolder"));
			p.setLocalFolder2(readData("localFolder2"));
			p.setLocalFolder3(readData("localFolder3"));
			p.setUsername(readData("username"));
			p.setPassword(readData("password"));
			*/
		}
		return p;
	}
	
	
	public static void writeData(String key, String value){
		String filepath = Class.class.getClass().getResource("/").getPath();
		filepath +="test";
		System.out.println(filepath);
		PropertyUtil.writeData( key,  value,filepath); 
	}
	
	
	public static void main(String[] args) {
		PropertyUtil.writeData("ip", "192.168.1.1");
		PropertyUtil.writeData("port", "21");
		PropertyUtil.writeData("username", "ddb");
		PropertyUtil.writeData("password", "ddd2");
		PropertyUtil.writeData("localFolder", "d:\\dwg");
		
	}
}
