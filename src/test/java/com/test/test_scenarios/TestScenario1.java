package com.test.test_scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.pagesObjects.HomePage;
import com.test.pagesObjects.LoginPage;
import com.test.pagesObjects.ToolTipPage;
import com.test.utilities.BaseClass;
import com.test.utilities.DriverManager;

import io.qameta.allure.Description;

public class TestScenario1 extends BaseClass {

	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	ToolTipPage tp;

	@BeforeClass
	public void setup_1() {

		// TODO Auto-generated constructor stub

		driver = DriverManager.getDriver();

		hp = new HomePage(driver);

		lp = new LoginPage(driver);

		tp = new ToolTipPage(driver);

	}

	@Test(dataProvider = "getLinkData", description = "Validate homepage links")
	@Description("Validated links from home page")
	public void validateHomePageLikns(String linkName) throws InterruptedException {

		// hp.validateEmail();

		// Assert.assertTrue(hp.validateLink(linkName), "link is not available");

		Assert.assertTrue(hp.validateLink(linkName), linkName + "is not available");

		test.log(Status.INFO, "Validated homepage links successfully");

	}

	
	@Test(description = "validate login functionality", dataProvider = "logindata")
	@Description("Verify login functionality")
	public void validate_Login(String username, String pwd) throws InterruptedException {

		lp.login(username, pwd);

		Thread.sleep(1000);

		Assert.assertEquals(lp.getLoginMessage(), "Successfully Logged in...");

		test.log(Status.INFO, "login successsful");
	}

	@Test(description = "Tool tip demo")
	@Description("validate content of tooltip")
	public void toolTipDemo() {

		tp.getToolTip();

		test.log(Status.INFO, "tooltip validation completed");

	}

	@DataProvider
	public Object[][] getLinkData() {

		return new Object[][] { { "Insurance Project" }, { "Agile Project" }, { "Bank Project" },
				{ "Security Project" }, { "Telecom Project" }, { "Payment Gateway Project" }, { "New Tours" },
				{ "SEO" } };
	}

	@DataProvider(name = "logindata")
	public Object[][] getLoginData() {

		return new Object[][] { { "test1@mailinator.com", "Test@123" }, { "test2@mailinator.com", "Test@123" },
				{ "test3@mailinator.com", "Test@123" }, { "test4@mailinator.com", "Test@123" },
				{ "test5@mailinator.com", "Test@123" } };
	}

}
