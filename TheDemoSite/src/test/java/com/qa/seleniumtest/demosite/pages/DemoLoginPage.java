package com.qa.seleniumtest.demosite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoLoginPage {
	@FindBy(name = "username")
	private WebElement user;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	private WebElement submit;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement successCheck;
	
	public DemoLoginPage(WebDriver driver) {

	}
	
	public void login(String username, String password) {
		this.user.sendKeys(username);
		this.password.sendKeys(password);
		this.submit.click();
	}

	public WebElement getSuccessCheck() {
		return successCheck;
	}
}
