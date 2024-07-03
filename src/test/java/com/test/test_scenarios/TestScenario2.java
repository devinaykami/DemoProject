package com.test.test_scenarios;

import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.pagesObjects.DragAndDropPage;
import com.test.pagesObjects.FileUploadPage;
import com.test.pagesObjects.TablePage;
import com.test.utilities.BaseClass;
import com.test.utilities.DriverManager;

import io.qameta.allure.Description;

public class TestScenario2 extends BaseClass {

	protected WebDriver driver;
	TablePage tp;
	FileUploadPage fu;
	DragAndDropPage dd;
	String absolutePath = Paths.get("./testdata/punch-camo-brochure.pdf").toAbsolutePath().toString();

	@BeforeClass
	public void setup_2() {

		driver = DriverManager.getDriver();
		tp = new TablePage(driver);
		fu = new FileUploadPage(driver);
		dd = new DragAndDropPage(driver);

	}

	@Test(description = "Validate html table")
	@Description("Verify whether user is able to get data from html table")
	public void validate_HTML_Table() {

		List<String> data = tp.fetchTableData();

		for (String str : data) {

			System.out.print(str + "\t");
		}

		test.log(Status.INFO, "Fetched html table data successfully");

	}

	@Test(description = "Validate file upload")
	@Description("Verify whether user is able to upload a file")
	public void validateFileUpload() throws InterruptedException {

		fu.uploadFile(absolutePath);

		test.log(Status.INFO, "File upload validation completed");
	}

	@Test(description = "Validate drag and drop functionality")
	@Description("Verify whether user is able to drag and drop")
	public void validated_Drag_Drop() {

		dd.dragDropDemo();

		test.log(Status.INFO, "Drag and drop validated successfully");
	}

	@Test(description = "Validate date picker")
	@Description("Verify whether user is able to select a date")
	public void validateDatePicker() throws InterruptedException {

		tp.testDatePicker("01041986", "1755PM");

		test.log(Status.INFO, "Date picker validated successfully");
	}

}
