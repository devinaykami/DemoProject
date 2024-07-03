package com.test.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.test.utilities.BaseClass;

public class LoginPage  {

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement signIn;

	@FindBy(xpath = "//div[@class='error-box']//h3")
	WebElement loginMsg;

	private WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void login(String userName, String pwd) {

		driver.get("https://demo.guru99.com/test/login.html");

		email.sendKeys(userName);


		password.sendKeys(pwd);


		signIn.click();


	}

	public String getLoginMessage() {

		return loginMsg.getText();

	}

}
