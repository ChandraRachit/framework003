package com.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	public Properties pro;
	
	public ConfigDataProvider() {
		File file=new File(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		try {
			FileInputStream fin=new FileInputStream(file);
			pro =new Properties();
			pro.load(fin);
		} catch (Exception e) {
			System.out.println("unable to load Properties file "+e.getMessage());
		}
		
	}
	
	/**
	 * Method to get value from properties file
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return pro.getProperty(key);
	}

}
