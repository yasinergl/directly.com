package com.directly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResourcesPage extends BasePage {

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

	@Test
	public void selectResources() {
		WebDriverWait wait = null;
		driver.findElement(By.xpath("//li[@id= 'menu-item-2498'] //a[contains(text(),'Resources')]")).click();

//		 WebDriverWait wait = new WebDriverWait(driver,5);
//		 wait.until(ExpectedConditions.invisibilityOfElementLocated
//				 (By.xpath("//li[@id='menu-item-2498'] //a[contains(text(),'Resources')]")));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// Throws Exception()
		}

		driver.findElement(By.xpath("//li[@id= 'menu-item-2427'] //a[contains(text(),'Blog')]")).click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// Throws Exception()
		}
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='alm-load-more-btn more black-border-button uk-button-large']")));

		// WebElement element =
		// driver.findElement(By.xpath("//button[@class='alm-load-more-btn more
		// black-border-button uk-button-large']"));
		WebElement element = driver.findElement(By.cssSelector(
				"body.page-template-default.page.page-id-2039.wp-custom-logo.wp-embed-responsive.elementor-default:nth-child(2) section.content-area:nth-child(5) main.site-main.uk-container article.post-2039.page.type-page.status-publish.hentry div.uk-content div.ajax-load-more-wrap.default.alm-0:nth-child(8) div.alm-btn-wrap:nth-child(3) > button.alm-load-more-btn.more.black-border-button.uk-button-large"));
//		int location = element.getLocation().getY();
//
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		jse.executeScript("window.scrollTo(0,"+location+")");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// Throws Exception()
		}
		try {
			element.click();
		} catch (StaleElementReferenceException ex) {
			driver.findElement(By.cssSelector(
					"body.page-template-default.page.page-id-2039.wp-custom-logo.wp-embed-responsive.elementor-default:nth-child(2) section.content-area:nth-child(5) main.site-main.uk-container article.post-2039.page.type-page.status-publish.hentry div.uk-content div.ajax-load-more-wrap.default.alm-0:nth-child(8) div.alm-btn-wrap:nth-child(3) > button.alm-load-more-btn.more.black-border-button.uk-button-large"))
					.click();
		}

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// Throws Exception()
		}
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.elementToBeSelected(By.xpath("//a[contains(text(),'Expert Spotlight: Andre Da Costa')]")));

		driver.findElement(By.xpath("//a[contains(text(),'Expert Spotlight: Andre Da Costa')]")).click();

		// a[contains(text(),'Expert Spotlight: Andre Da Costa')]

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
