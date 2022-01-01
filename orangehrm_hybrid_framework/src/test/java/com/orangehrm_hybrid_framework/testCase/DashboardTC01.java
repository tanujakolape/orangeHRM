package com.orangehrm_hybrid_framework.testCase;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.orangehrm_hybrid_framework.pageObject.DashboardPage;
import com.orangehrm_hybrid_framework.pageObject.LoginPage;
import com.orangehrm_hybrid_framework.testBase.TestBase;

public class DashboardTC01 extends TestBase {
	@Test
	public void logoutOrangeHrmTC01()
	{
		//WebDriver driver = null;
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		DashboardPage hp=lp.clickOnLoginBtn();
		
		if(driver.findElement(By.xpath("//a[@id='menu_dashboard_index']")).isDisplayed())
		
		{
			Assert.assertTrue(true);
			hp.logoutOrangeHRM();
		} 
		else
			{
			Assert.assertTrue(false,"dashboard page title not contain sorange text");
		}
		
		
	}
	
	
	
	

}
