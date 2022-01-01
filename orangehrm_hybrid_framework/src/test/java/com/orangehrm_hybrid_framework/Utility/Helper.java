package com.orangehrm_hybrid_framework.Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	// alert,dropdown,handle,iframe,authintication window,bootstrap
	// capture screenshots

	public static String capturescreenshots(WebDriver driver) {
		String screenshotpath = System.getProperty("user.dir") + "\\Screenshot\\orangehrm_" + getCurrentDateTime()
				+ ".html";
		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(screenshotpath));
			// FileUtils.copyFile(source,new
			// File("D:\\\\eclipse-workspace\\\\orangehrm_hybrid_framework\\\\Screenshots_Maven"+getCurrentDateTime()+".png"));
			System.out.println("ScreenShots Capture Successfully");
		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return screenshotpath;
	}

	public static String getCurrentDateTime() {
		SimpleDateFormat customDateTime = new SimpleDateFormat("MM_DD_YYYY_HH_MM_SS");
		Date currentDate = new Date();
		String dateformat = customDateTime.format(currentDate);
		return dateformat;
	}

}
