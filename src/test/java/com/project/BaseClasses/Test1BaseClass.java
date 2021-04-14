package com.project.BaseClasses;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.project.utils.BrowserFactory;
import com.project.utils.ConfigDataProvider;
import com.project.utils.ExcelDataProvider;

public class Test1BaseClass {
	
	protected WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() {
		ExcelDataProvider excel;
		ConfigDataProvider config;
	}
	
	@BeforeClass
	public void OpenUI() {
		this.driver=BrowserFactory.setUp("chrome", "http://a.testaddressbook.com/");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
