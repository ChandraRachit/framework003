package com.project.Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.project.BaseClasses.Test1BaseClass;
import com.project.PageObjects.LoginPage;
import com.project.utils.ExcelDataProvider;

public class Test1 extends Test1BaseClass {

	@Test
	public void test1() throws InterruptedException {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickOnSignIn();
		Thread.sleep(3000);
		loginPage.enterEmail(excel.getStringValue("Login", 0, 0));
		loginPage.enterPassword(excel.getStringValue("Login", 0, 1));
		loginPage.clickSignInSubmit();
	}
}
