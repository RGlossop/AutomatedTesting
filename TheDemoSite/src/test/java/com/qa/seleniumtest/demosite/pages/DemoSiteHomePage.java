package com.qa.seleniumtest.demosite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoSiteHomePage {
	private final String URL = "http://thedemosite.co.uk";
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement navAddUserPage;
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement navLoginPage;
	
	public DemoAddUsersPage addUsersPage;
	public DemoLoginPage loginPage;
	public DemoSiteHomePage(WebDriver driver) {
		driver.get(URL);
		addUsersPage = PageFactory.initElements(driver, DemoAddUsersPage.class);
		loginPage = PageFactory.initElements(driver, DemoLoginPage.class);
	}
	
	public void navAddUser() {
		navAddUserPage.click();
	}
	public void navLoginPage() {
		navLoginPage.click();
	}
}
