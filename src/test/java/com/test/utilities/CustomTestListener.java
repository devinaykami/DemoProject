package com.test.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test " + result.getName() + " started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test " + result.getName() + " passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test " + result.getName() + " failed due to " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test " + result.getName() + " skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Implement if needed
	}

	@Override
	public void onStart(ITestContext context) {
		// Implement if needed
	}

	@Override
	public void onFinish(ITestContext context) {
		// Implement if needed
	}

}
