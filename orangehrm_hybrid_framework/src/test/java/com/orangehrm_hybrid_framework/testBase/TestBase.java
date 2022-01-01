package com.orangehrm_hybrid_framework.testBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm_hybrid_framework.Utility.ConfigDataProvider;
import com.orangehrm_hybrid_framework.Utility.ExcelDataProvider;
import com.orangehrm_hybrid_framework.Utility.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver = null;
	public static ConfigDataProvider ConfigDataProvider = null;
	public static ExcelDataProvider excelDataProvider = null;
	public static String configDataPath = "./Config/config.properties";
	public static String excelDataPath = "./Data/TestData.xlsx";

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;

	@BeforeSuite
	public void init() {
		ConfigDataProvider = new ConfigDataProvider(configDataPath);
		excelDataProvider = new ExcelDataProvider(excelDataPath);

		String currentDir = System.getProperty("user.dir") + "//Report//orangehrm_" + Helper.getCurrentDateTime()
				+ ".html";

		htmlReporter = new ExtentHtmlReporter(currentDir);
		htmlReporter.config().setDocumentTitle("Automation Test Reports");
		htmlReporter.config().setReportName("Regression Test Reports");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extentReport = new ExtentReports();

		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("HostName", "Local Host");
		extentReport.setSystemInfo("OS", "Windows");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("TE", "Tanuja");
		extentReport.setSystemInfo("TestCase", "RT");

	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void setUP(@Optional("Chrome") String browser) {

		if (browser.equals("Chrome")) {
			// System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else {
			System.out.println("Browser not matched");
		}

		driver.manage().window().maximize();
		driver.get(ConfigDataProvider.getUrl());
	}

	@AfterMethod

	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// Helper.capturescreenshots(driver);

			extentTest.log(Status.FAIL, "TEST CASE FAILED" + result.getName());

			extentTest.log(Status.FAIL, "TEST CASE FAILED" + result.getThrowable());
			// String screenshotpath=Helper.capturescreenshots(driver);
			// extentTest.addScreenCaptureFromPath(screenshotpath);
			// System.out.println(screenshotpath);
			extentTest.fail("Test Case Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshots(driver)).build());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "TEST CASE SUCCESS" + result.getName());
		}
		// driver.quit();
	}

	@AfterTest
	public void flushReports() {
		extentReport.flush();
		driver.quit();
	}

}