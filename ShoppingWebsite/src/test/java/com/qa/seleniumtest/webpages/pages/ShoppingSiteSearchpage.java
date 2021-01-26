package com.qa.seleniumtest.webpages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingSiteSearchpage {
	
	@FindBy(linkText = "Printed Dress")
	private WebElement itemText;
	
	public ShoppingSiteSearchpage(WebDriver driver) {
		
	}
	
	public String findItem() {
		return itemText.getText();
	}
}
