package com.test.pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//input[@name='emailid']")
	WebElement emailID;

	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement submit;

	
	private WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void validateEmail() throws InterruptedException {

		Thread.sleep(5000);

		emailID.sendKeys("test1@mailinator.com");

		submit.click();
	}

	public boolean validateLink(String linkName) {

		WebElement link= driver.findElement(By.xpath("//a[contains(.,'" + linkName + "')]"));

		return link.isDisplayed();
	}

}
