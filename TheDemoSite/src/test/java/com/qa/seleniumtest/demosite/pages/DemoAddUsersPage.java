package com.qa.seleniumtest.demosite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoAddUsersPage {
	@FindBy(name = "username")
	private WebElement user;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	private WebElement submit;
	public DemoAddUsersPage(WebDriver driver) {

	}

	public void signUp(String username, String password) {
		this.user.sendKeys(username);
		this.password.sendKeys(password);
		this.submit.click();
	}
}
