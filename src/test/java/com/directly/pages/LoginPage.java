package com.directly.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {

	@BeforeClass
	public void setup() {
		super.setup();

		System.out.println("LoginPage= > @BeforeClass - setup()");

		driver.get(getPageUrl(BasePage.PAGE_URL_LOGIN));

	}

	@BeforeMethod
	public void refresh() {

		try {
			// Thread.sleep(2000);
			// driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// Throws Exception()
		}

	}

	/*
	 * #1 -) Verify the EMAIL ADDRESS and PASSWORD fields are empty
	 */
	// @Test(priority = 1)
	public void checkEmptyUserNameEmptyPassword() {
		driver.findElement(By.xpath("//button[@class='btn btn-full-width']")).click();
	}

	/*
	 * #2 -) Verify the EMAIL ADDRESS filed is empty and PASSWORD fields are empty
	 */

//	@Test(priority = 2)
	public void checkEmptyUserNameAndFilledPassword() {

		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys("khxkjdhakjh");
		driver.findElement(By.xpath("//button[@class='btn btn-full-width']")).click();

	}

	// #3 -) Verify the EMAIL ADDRESS filled with valid but wrong email address and
	// PASSWORD fields is empty

	@Test(priority = 3)
	public void filledAndEmty() {

		driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys("yasin@coma");

		driver.findElement(By.xpath("//button[@class='btn btn-full-width']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='form-error']")).getText(),
				"Wrong email / password combination");

	}

	/*
	 * #4 -) Verify the EMAIL ADDRESS filled with valid but wrong email address and
	 * PASSWORD filled with valid but wrong password Case 1= Correct Usernaem +
	 * Correct Password
	 */

	@Test(priority = 4)
	public void checkValidUserNameValidPassword() {

		driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys("yasin@coma");
		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys("khxkjdhakjh");
		driver.findElement(By.xpath("//button[@class='btn btn-full-width']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='form-error']")).getText(),
				"Wrong email / password combination");
	}
	/*
	 * #4 -) Verify the EMAIL ADDRESS filled with valid but wrong email address and
	 * PASSWORD filled with valid but wrong password Case 1= Correct Usernaem +
	 * Correct Password Case 2- Wrong Username + Correct Password Case 3= Correct
	 * Usernaem + Worng Password Case 4- Wrong Username + Wrong Password
	 */

	@Test(priority = 5)
	public void checkValidUserNameValidPassword2() {

		driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys("yasin@coma");
		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys("khxkjdhakjh");
		driver.findElement(By.xpath("//button[@class='btn btn-full-width']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='form-error']")).getText(),
				"Wrong email / password combination");
		// driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys("yasin@gmail.com");
		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys("correctPassword");
		driver.findElement(By.xpath("//button[@class='btn btn-full-width']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='form-error']")).getText(),
				"Wrong email / password combination1");

	}

	// @AfterMethod
	@AfterClass
	public void tearDown() {
//		driver.quit();
		super.tearDown();
	}

}
