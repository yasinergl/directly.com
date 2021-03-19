package com.directly.util;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static HashMap<String, Integer> browsers = new HashMap<String, Integer>();

	private Driver() {
	}

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			String browser = System.getProperty("browser") != null ? System.getProperty("browser")
					: ConfigurationReader.getProperty("browser");
			int type = (Integer) getBrowsers().get(browser.toLowerCase());
			switch (type) {
			case 0:
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case 1:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case 2:
			default:
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			}
		}
		return driver;
	}

	private static HashMap getBrowsers() {
		if (browsers.isEmpty()) {
			browsers.put("ie", 0);
			browsers.put("chrome", 1);
			browsers.put("firefox", 2);
		}
		return browsers;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
