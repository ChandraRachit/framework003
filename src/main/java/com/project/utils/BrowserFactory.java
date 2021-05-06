package com.project.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public WebDriver driver;

	public WebDriver setUp(String browser, String url) {
		String remote_url_chrome = "http://localhost:4444/wd/hub";
		String remote_url_firefox = "http://localhost:4444/wd/hub";
		if (browser.contains("chrome")) {


			WebDriverManager.chromedriver().setup(); ChromeOptions options = new
					ChromeOptions(); options.addArguments("--incognito"); 
					driver = new
					ChromeDriver(options);


					/*
					 * ChromeOptions options = new ChromeOptions(); try { driver = new
					 * RemoteWebDriver(new URL(remote_url_chrome), options); } catch
					 * (MalformedURLException e) { e.printStackTrace(); }
					 */

		} else if (browser.contains("Firefox")) {
			/*
			 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
			 */

			FirefoxOptions options = new FirefoxOptions();
			try {
				driver = new RemoteWebDriver(new URL(remote_url_firefox), options);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Driver not found");
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

}
