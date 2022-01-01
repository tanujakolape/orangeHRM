package com.orangehrm_hybrid_framework.testCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm_hybrid_framework.pageObject.DashboardPage;
import com.orangehrm_hybrid_framework.pageObject.LoginPage;
import com.orangehrm_hybrid_framework.testBase.TestBase;

public class LoginExcelTC02 extends TestBase {
	@Test
	public void  loginToOrangeHrmTC01()throws InterruptedException{
		
		LoginPage lp=new LoginPage(driver);
		//String uname=excelDataProvider.getStringCellData(0,1,0);
		//String pwd=excelDataProvider.getStringCellData(0,1,1);
		
		
		
		String uname=excelDataProvider.getStringCellData("Sheet1",1,0);
		String pwd=excelDataProvider.getStringCellData("Sheet1",1,1);
		
		
		lp.setUserName(uname);
		lp.setPassword(pwd);
	 	
		DashboardPage dp=lp.clickOnLoginBtn();
	
	
	
if(driver.findElement(By.xpath("//a[@id='menu_dashboard_index']")).isDisplayed())
		
	{
		Assert.assertTrue(true);
		Thread.sleep(5000);
		dp.logoutOrangeHRM();
	}
	else
		{
		Assert.assertTrue(false,"dashboard page title not contain so range text");
	}
	

}}
