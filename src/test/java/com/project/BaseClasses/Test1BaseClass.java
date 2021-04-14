package com.project.BaseClasses;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.project.utils.BrowserFactory;
import com.project.utils.ConfigDataProvider;
import com.project.utils.ExcelDataProvider;
import com.project.utils.Helper;

public class Test1BaseClass {
	
	protected WebDriver driver;
	protected ExcelDataProvider excel;
	protected ConfigDataProvider config;
	
	@BeforeSuite
	public void beforeSuite() {
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
	}
	
	@BeforeClass
	public void OpenUI() {
		this.driver=BrowserFactory.setUp(config.getValue("Browser"), config.getValue("Url"));
	}
	
	@AfterMethod
	public void resultCapture(ITestResult result) {
		System.out.println(result);
		if(ITestResult.FAILURE==result.getStatus()) {
			Helper.captureScreenshot(driver,"Test1");
			System.out.println("Screenshot Captured");
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
