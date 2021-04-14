package com.project.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.project.utils.ExcelDataProvider;

public class LoginPage {
	
	
	@FindBy(id="sign-in")
	WebElement signin;
	
	@FindBy(xpath="//input[@id='session_email']") 
	WebElement email;
	
	@FindBy(id="session_password") 
	WebElement password;
	
	@FindBy(name="commit") 
	WebElement signInSubmit;
	
	/**
	 * Method to click on SignIn
	 */
	public void clickOnSignIn() {
		signin.click();
	}
	
	/**
	 * Method to enter Email
	 */
	public void enterEmail() {
		email.sendKeys("rachit@test.com");
	}
	
	/**
	 * Method to enter Password
	 */
	public void enterPassword() {
		password.sendKeys("Test1234");
	}
	
	/**
	 * Method to click on Submit Button
	 */
	public void clickSignInSubmit() {
		signInSubmit.click();
	}
}
