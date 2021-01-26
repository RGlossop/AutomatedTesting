package com.qa.seleniumtest.webpages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingSiteHomepage {

	private final String URL = "http://automationpractice.com/index.php";
	
	@FindBy(id = "search_query_top")
	private WebElement searchBar;
	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button")
	private WebElement searchSubmit;
	
	public ShoppingSiteSearchpage searchPage;
	
	public ShoppingSiteHomepage(WebDriver driver) {
		driver.get(URL);
		searchPage = PageFactory.initElements(driver, ShoppingSiteSearchpage.class);
	}
	
	public void searchItem(String item) {
		searchBar.sendKeys(item);
		searchSubmit.click();
	}
}
