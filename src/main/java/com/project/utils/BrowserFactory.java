package com.project.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public WebDriver driver;

	public WebDriver setUp(String browser, String url) {
		// String remote_url_chrome = "http://localhost:4444/wd/hub";
		// String remote_url_firefox = "http://localhost:4444/wd/hub";
		if (browser.contains("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);

			/*
			 * ChromeOptions options = new ChromeOptions(); try { driver = new
			 * RemoteWebDriver(new URL(remote_url_chrome), options); } catch
			 * (MalformedURLException e) { e.printStackTrace(); }
			 */
		} else if (browser.contains("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			/*
			 * ChromeOptions options = new ChromeOptions(); try { driver = new
			 * RemoteWebDriver(new URL(remote_url_firefox), options); } catch
			 * (MalformedURLException e) { e.printStackTrace(); }
			 */
		} else {

		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

}
