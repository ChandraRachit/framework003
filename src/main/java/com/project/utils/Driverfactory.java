package com.project.utils;

import org.openqa.selenium.WebDriver;

public class Driverfactory {
	
	private Driverfactory() {
	}
	
	private static  Driverfactory instance = new Driverfactory();
	
	public static Driverfactory getInstance() {
		return instance;
	}
	
	ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}
}
