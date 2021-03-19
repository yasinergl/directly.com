package com.directly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage extends BasePage {

	@BeforeClass
	public void setup() {

		super.setup();
		driver.get(getPageUrl(BasePage.PAGE_URL_HOME));

	}

	@BeforeMethod
	public void refresh() {
		try {

			driver.navigate().refresh();
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// Throws Exception()
		}
	}

//	@Test(priority = 1)
	public void customLogoIsEnable() {

		driver.findElement(By.xpath("//img[@class='custom-logo']")).isEnabled();

	}

//	@Test(priority = 2)
	public void loginButtonIsSelected() {

		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).isSelected();

	}

	@Test(priority = 3)
	public void clickLoginButton() throws Exception {

		// Best Solution = Advanced Solution
		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='cookie_action_close_header']")));

		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

	}

	// @Test(priority = 4)
	public void clickDemoButton() {
		driver.findElement(By.xpath("//li[@id='menu-item-2062']//a[contains(text(),'Demo')]")).click();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
