package com.test.pagesObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TablePage {

	private WebDriver driver;

	@FindBy(xpath = "//table[@cellspacing=1]//tr/td")
	List<WebElement> table;

	@FindBy(name = "bdaytime")
	WebElement birthDate;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	public TablePage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> fetchTableData() {

		driver.get("https://demo.guru99.com/test/table.html");

		List<String> list = new ArrayList<String>();

		for (WebElement ele : table) {

			list.add(ele.getText());
		}

		return list;
	}

	public void testDatePicker(String date, String time) throws InterruptedException {

		driver.get("https://demo.guru99.com/test/");

		// String date1="1986-04-01 17:55 PM";

		birthDate.sendKeys(date);

		birthDate.sendKeys(Keys.TAB);

		birthDate.sendKeys(time);

		submit.click();

		// Set the date using JavaScript
		// JavascriptExecutor js = (JavascriptExecutor) driver;

		// js.executeScript("arguments[0].value='2024-07-01';", birthDate);

		Thread.sleep(10000);
	}


}
