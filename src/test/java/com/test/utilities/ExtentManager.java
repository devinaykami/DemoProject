package com.test.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
	private static ExtentSparkReporter sparkReporter;

	public static ExtentReports getInstance() {
		if (extent == null) {
			sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extent-report.html");
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setDocumentTitle("Automation Test Report");
			sparkReporter.config().setEncoding("utf-8");
			sparkReporter.config().setReportName("Automation Test Results");

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Host Name", "Your Host Name");
			extent.setSystemInfo("Environment", "Automation Testing");
			extent.setSystemInfo("User Name", "Your Name");
		}
		return extent;
	}

}
