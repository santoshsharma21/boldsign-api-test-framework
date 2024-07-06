/**
 * 
 */
package com.boldsignapi.extentreport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * 
 */
public class ListenerClass extends ReportManager implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		setupReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.assignAuthor("SANTOSH");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			try {
				extentTest.log(Status.PASS,
						MarkupHelper.createLabel(result.getName() + " - PASSED", ExtentColor.GREEN));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String throwMsg = result.getThrowable().getMessage().replaceAll(",", "<br>");
			String formatedMsg = "<details> <summary> Click For Details </summary> " + throwMsg + "</details>";
			try {
				extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - FAILED", ExtentColor.RED));
				extentTest.info(MarkupHelper.createLabel(formatedMsg, ExtentColor.RED));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - SKIPPED", ExtentColor.YELLOW));
	}

	@Override
	public void onFinish(ITestContext context) {
		endReport();
	}
}