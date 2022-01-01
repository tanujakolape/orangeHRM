package com.orangehrm_hybrid_framework.testCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm_hybrid_framework.pageObject.LoginPage;
import com.orangehrm_hybrid_framework.testBase.TestBase;
	
	public class LoginTC002 extends TestBase{
		

		@Test(dataProvider="getTestData")
		public void validateLoginFunctionality(Object uname,Object pwd)
		{
			String un= uname.toString();
			String pw= pwd.toString();
			
			
			System.out.println(un+"  "+pw);
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(un);
			lp.setPassword(pw);
			lp.clickOnLoginBtn();
			
			
			if(driver.getPageSource().contains("DashBoard"))
			{
				Assert.assertTrue(true);
			}
			
			
			
			else if(driver.getPageSource().contains("DashBoard"))
				
			{
				String invalidcredentials=driver.findElement(By.xpath("//span[text()='Invalid credentials']")).getText();
				
				Assert.assertTrue(false, invalidcredentials);
			}
		
		}
		@DataProvider
		public Object[][] getTestData(){
			Object[][] data=excelDataProvider.getExcelData("Sheet1")	;
			return data;
		}
	}
	
	


