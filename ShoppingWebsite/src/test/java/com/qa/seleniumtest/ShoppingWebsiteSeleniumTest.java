package com.qa.seleniumtest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.qa.seleniumtest.webpages.pages.ShoppingSiteHomepage;

public class ShoppingWebsiteSeleniumTest {
	
	private static WebDriver driver;
	private static WebElement target;
	
	// its drivers/chrome not chrome/drivers!!
	@BeforeAll
	public static void init() {
		System.setProperty(
				"webdriver.chrome.driver",
				"src/test/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver( chromeCfg());
	}
	
	@Test
	@Disabled
	public void test_FindDress() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		
		target = driver.findElement(By.id("search_query_top"));
		target.sendKeys("dress");
		target = driver.findElement(By.xpath(
				"/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button"));
		target.click();
		
		Thread.sleep(2000);
		
		target = driver.findElement(By.linkText("Printed Dress"));
		
		assertTrue(target.getText().contains("Printed Dress"));
		Thread.sleep(5000);
	}
	
	@Test
	public void test_FindDressPOM() throws InterruptedException {
		ShoppingSiteHomepage website = PageFactory.initElements(driver, ShoppingSiteHomepage.class);
		website.searchItem("Dress");
		
		Thread.sleep(2000);
		assertEquals(website.searchPage.findItem(), "Printed Dress");
	}
	
	@AfterAll
	public static void cleanUp() {
		driver.quit();
	}
	
	// Designed to return ChromeOptions to configure new ChromeDrivers in Selenium
	public static ChromeOptions chromeCfg() {
	 Map<String, Object> prefs = new HashMap<String, Object>();
	 ChromeOptions cOptions = new ChromeOptions();
	  
	 // Settings
	 prefs.put("profile.default_content_setting_values.cookies", 2);
	 prefs.put("network.cookie.cookieBehavior", 2);
	 prefs.put("profile.block_third_party_cookies", true);

	 // Create ChromeOptions to disable Cookies pop-up
	 cOptions.setExperimentalOption("prefs", prefs);

	 return cOptions;
	 }
}
