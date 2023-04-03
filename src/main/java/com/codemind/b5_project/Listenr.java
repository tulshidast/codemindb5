package com.codemind.b5_project;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenr implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test case started "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case success "+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed "+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
