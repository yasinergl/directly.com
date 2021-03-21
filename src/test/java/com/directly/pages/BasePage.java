package com.directly.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.directly.util.Driver;

public class BasePage {
	public static String PAGE_URL_LOGIN = "loginPageURL";
	public static String PAGE_URL_HOME = "homePageURL";

	public WebDriver driver;
	private String url;
	private Map<String, String> urlMap;

	@BeforeClass
	public void setup() {

		fillUrlMap();
		System.out.println("BasePage= > @BeforeClass - setup()");

		driver = Driver.getDriver();
				
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	private void fillUrlMap() {
		urlMap = new HashMap<String, String>();
		urlMap.put(PAGE_URL_LOGIN, "https://www.directly.com/login/auth?format=html");
		urlMap.put(PAGE_URL_HOME, "https://www.directly.com/");
	}

	public String getPageUrl(String pageName) {
		return this.urlMap.get(pageName);
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void tearDown() {
		Driver.closeDriver();
	}

}