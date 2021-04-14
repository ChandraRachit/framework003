package com.project.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver driver;
	
	public static WebDriver setUp (String browser,String url) {
		if(browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.contains("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/Drivers/iedriver.exe");
			driver = new InternetExplorerDriver();
		}else if(browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

}
