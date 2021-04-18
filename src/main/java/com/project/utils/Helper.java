package com.project.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {


	/**
	 * Method to capture Screenshot 
	 * @return
	 */
	public static String captureScreenshot(WebDriver driver,String ScreenshotName) {
		ScreenshotName=ScreenshotName+"_"+generateCurrentTime();
		File file=new File(System.getProperty("user.dir")+"/Screenshot/"+ScreenshotName+".png");

		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, file);
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot "+e.getMessage());
		}

		return ScreenshotName;
	}

	/**
	 * Method to generate Current date and time
	 */
	public static String generateCurrentTime() {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date=new Date();
		return sd.format(date);
	}

}
