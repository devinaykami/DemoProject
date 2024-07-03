package com.test.pagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.test.utilities.BaseClass;

public class ToolTipPage {

	private WebDriver driver;

	public ToolTipPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='download_now']")
	WebElement downloadNow;

	Actions action;

	public void getToolTip() {

		action = new Actions(driver);

		driver.get("https://demo.guru99.com/test/tooltip.html");

		action.moveToElement(downloadNow).build().perform();


		WebElement tooltip = driver.findElement(By.xpath("//div[@class='tooltip']"));

		List<WebElement> rows = tooltip.findElements(By.tagName("tr"));

		// Print the table data
		for (WebElement row : rows) {
			List<WebElement> columns = row.findElements(By.tagName("td"));
			for (WebElement column : columns) {
				System.out.print(column.getText() + "\t");
			}
			System.out.println();
		}

	}
}
