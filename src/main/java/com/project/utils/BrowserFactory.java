package com.project.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver driver;
	
	public static WebDriver setUp (String browser,String url) {
		if(browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--incognito");
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver(options);
		}else if(browser.contains("InternetExplorer")) {
			//System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/Drivers/iedriver.exe");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else if(browser.contains("Firefox")) {
			//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

}
