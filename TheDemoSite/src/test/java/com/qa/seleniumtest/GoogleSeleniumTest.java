package com.qa.seleniumtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
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

public class GoogleSeleniumTest {
	
	private static WebDriver driver;
	private static WebElement target;
	// its drivers/chrome not chrome/drivers!!
	@BeforeAll
	public static void init() {
		System.setProperty(
				"webdriver.chrome.driver",
				"src/test/resources/drivers.chrome/chromedriver.exe");
		driver = new ChromeDriver( chromeCfg());
	}
	
	@Test
	public void test_GoogleKitten() throws InterruptedException {
		driver.get("http://www.google.com");
		//find google search bar
		target = driver.findElement(By.name("q"));
		target.sendKeys("Kittens");
		target.submit();
		assertEquals("Kittens - Google Search", driver.getTitle());
		// assert that image is present in this path
		target = driver.findElement(By.xpath("//*[@id=\"dimg_33\"]"));
		boolean imagePresent = target.isDisplayed();
		assertTrue(imagePresent);
		
//		List<WebElement> listToScan = driver.findElements();
//		for (WebElement handle : listToScane) {
//			if(handle.getText.equals("this")) {
//				FIND ELEMENT HAS BEEN DELETED == false;
//			}
//		}
		Thread.sleep(5000);
	}
	@Test
	@Disabled
	public void test_GooglePuppies() {
		
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
