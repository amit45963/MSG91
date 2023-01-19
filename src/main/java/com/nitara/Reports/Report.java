package com.nitara.Reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report extends  TestWatcher {

	// A little set up to give the report a date in the file name
	private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private Date date = new Date();
	private String fileDate = dateFormat.format(date);
	private String reportName = "./Test_Report.html";

	public ExtentReports extent;
	ArrayList<ExtentTest> testList = new ArrayList<>();

	public Report() 
	{
		extent = createReport();
		
	}

	// If test passed, watcher will record this with Extent Reports
	protected void succeeded(Description description) {

		ExtentTest test = extent.startTest(description.getMethodName());
		test.log(LogStatus.PASS, "Test Run Successful");
		testList.add(test);
		flushReports(testList);

	}

	// Likewise in case of failure

	
	protected void failed(Throwable e, Description description)
	{

		ExtentTest test = extent.startTest(description.getMethodName());

		test.log(LogStatus.FAIL, "Test Failure: " + e.getMessage());

		testList.add(test);

		flushReports(testList);

	}

	private ExtentReports createReport() 
	{

		// Create the report - Extent just needs a little config

		ExtentReports extent = new ExtentReports(reportName, false);

		extent.config().reportName("Test Report: " + fileDate);

		return extent;

	}

	public void flushReports(List<ExtentTest> testList) {

		// This ends the test and then sends (flushes) everything to the html
		// document

		for (ExtentTest test : testList)
			extent.endTest(test);

		extent.flush();

	}

	public List<ExtentTest> getTests() {

		return testList;

	}

}
