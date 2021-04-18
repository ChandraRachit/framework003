package com.project.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.BaseClasses.Test1BaseClass;
import com.project.utils.ExcelDataProvider;

public class LoginPage extends Test1BaseClass{
	
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
	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}
	
	/**
	 * Method to enter Password
	 */
	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}
	
	/**
	 * Method to click on Submit Button
	 */
	public void clickSignInSubmit() {
		signInSubmit.click();
	}
}
