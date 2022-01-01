package com.orangehrm_hybrid_framework.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
WebDriver driver;
	
	public DashboardPage(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver,this);
		}

	//object Repository
	@FindBy(id="welcome")
	@CacheLookup
	WebElement userId;
	
	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	WebElement logoutLink;

	public void logoutOrangeHRM()
	{
		try {
			userId.click();
			Thread.sleep(5000);
			logoutLink.click();
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
