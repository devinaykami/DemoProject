package com.test.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {

	private WebDriver driver;

	Actions action;

	@FindBy(xpath = "//a[contains(.,'BANK')]")
	WebElement bankElement;

	@FindBy(xpath = "//a[contains(.,'SALES')]")
	WebElement salesElement;

	@FindBy(id = "equal")
	WebElement equal;

	@FindBy(id = "bank")
	WebElement debitAcc;

	@FindBy(id = "amt7")
	WebElement debitAmt;

	@FindBy(id = "loan")
	WebElement creditAcc;

	@FindBy(id = "amt8")
	WebElement creditAmt;

	@FindBy(xpath = "//li[@data-id='2']")
	WebElement amount;

	public DragAndDropPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * Drag and Drop demo 
	 */
	public void dragDropDemo() {

		driver.get("https://demo.guru99.com/test/drag_drop.html");

		action = new Actions(driver);

		action.dragAndDrop(bankElement, debitAcc).build().perform();

		action.dragAndDrop(amount, debitAmt).build().perform();

		action.dragAndDrop(salesElement, creditAcc).build().perform();

		action.dragAndDrop(amount, creditAmt).build().perform();

		System.out.println(equal.getText());

	}
}
