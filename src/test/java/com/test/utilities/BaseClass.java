package com.test.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {

	protected WebDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;

	
	@BeforeClass
	public void setUpMethod() {

		extent = ExtentManager.getInstance();
		test = extent.createTest(this.getClass().getSimpleName());

	}

	@BeforeSuite
	public void setUpSuite() {
		
		
		DriverManager.initializeDriver();
		
		// Create a new test in the report
				
	}

	@AfterSuite
	public void tearDownSuite() {

		DriverManager.quitDriver();

		extent.flush();
	}

}
