package com.test.pagesObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.test.utilities.BaseClass;

public class FileUploadPage {

	private WebDriver driver;

	private WebDriverWait wait;

	@FindBy(id = "uploadfile_0")
	WebElement uploadFile;

	@FindBy(id = "terms")
	WebElement terms;

	@FindBy(id = "submitbutton")
	WebElement submitButton;

	@FindBy(xpath = "//h3[@id='res']")
	WebElement uploadStatus;

	public FileUploadPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void uploadFile(String filePath) throws InterruptedException {

		driver.get("https://demo.guru99.com/test/upload/");

		uploadFile.sendKeys(filePath);

		terms.click();

		submitButton.click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("res")));

		System.out.println(uploadStatus.getText());
		

	}
}
