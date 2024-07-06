/**
 * 
 */
package com.boldsignapi.extentreport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 */
public class ReportManager {
	
	// instances
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	// init reports
	public void setupReport() {
		
		String dt = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String fileName = "Test-Report_" + dt;
		String destPath = System.getProperty("user.dir") + "/test-report/" + fileName + ".png";
		
		sparkReporter = new ExtentSparkReporter(destPath);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Http Method Test Execution Report");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Project Name", "BoldSign RestApi Automation Test");
		extentReports.setSystemInfo("Windows Version", System.getProperty("os.version"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}
	
	// end report
	public void endReport() {
		extentReports.flush();
	}
}