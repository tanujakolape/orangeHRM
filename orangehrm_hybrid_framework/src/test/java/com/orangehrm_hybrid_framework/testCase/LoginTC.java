package com.orangehrm_hybrid_framework.testCase;///// Normal login pge::

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm_hybrid_framework.pageObject.LoginPage;
import com.orangehrm_hybrid_framework.testBase.TestBase;

public class LoginTC extends TestBase {

	/*
	 * @Test public void LoginToOrangeHrmTC001() {
	 * 
	 * LoginPage lp =new LoginPage(driver); lp.setUserName("Admin");
	 * 
	 * lp.setPassword("admin123"); lp.clickOnLoginBtn();
	 * if(driver.findElement(By.xpath("//a[@id='menu_dashboard_index']")).
	 * isDisplayed()) { Assert.assertTrue(true); } else{
	 * Assert.assertTrue(false,"dashboard page title not contain sorange text"); }
	 * 
	 * }
	 * 
	 * 
	 */
	@Test
	public void LoginToOrangeHrmTC002() {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(ConfigDataProvider.getUsername());
		lp.setPassword(ConfigDataProvider.getPwd());

		lp.clickOnLoginBtn();

		if (driver.getPageSource().contains("Dashboard")) {
			extentTest = extentReport.createTest("Login Test");
			Assert.assertTrue(true);
			extentTest.info("Login Success With Given Test Data");
		}

		else if (driver.getPageSource().contains("Login Panel")) {
			extentTest = extentReport.createTest("Login Test");
			String invalidCredentials = driver.findElement(By.xpath("//span[text()='Invalid credentials']")).getText();
			extentTest.info("Login failed with given test data");
			Assert.assertTrue(false, invalidCredentials);
		}

	}

}
