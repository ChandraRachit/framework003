package com.project.BaseClasses;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.project.utils.BrowserFactory;
import com.project.utils.ConfigDataProvider;
import com.project.utils.ExcelDataProvider;
import com.project.utils.Helper;

public class Test1BaseClass {
	
	protected WebDriver driver;
	protected ExcelDataProvider excel;
	protected ConfigDataProvider config;
	protected ExtentReports report;
	protected ExtentTest logger;
	protected Logger log;
	
	@BeforeSuite
	public void beforeSuite() {
		log=Logger.getLogger("Test1BaseClass");
		//PropertyConfigurator.configure("log4j.properties");
		DOMConfigurator.configure("log4j2.xml");
		Reporter.log("Setting up the browser",true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/FreeCRM_"+Helper.generateCurrentTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void OpenUI() {
		this.driver=BrowserFactory.setUp(config.getValue("Browser"), config.getValue("Url"));
	}
	
	@AfterMethod
	public void resultCapture(ITestResult result) throws IOException {
		System.out.println(result);
		if(ITestResult.FAILURE==result.getStatus()) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver, result.getTestName())).build());
		}else if(ITestResult.SUCCESS==result.getStatus()) {
			logger.pass("Test Passed");
		}else if(ITestResult.SKIP==result.getStatus()) {
			logger.skip("Test Skipped");
		}
		report.flush();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
