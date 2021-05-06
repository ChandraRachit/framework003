package com.project.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Test Start");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success");
	}

	public void onStart(ITestContext context) {
		System.out.println("Test Start");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test Finish");
	}

}
