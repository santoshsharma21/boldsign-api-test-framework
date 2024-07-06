/**
 * 
 */
package com.boldsignapi.extentreport;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * 
 */
public class ReportLogs {
	
	// method logs string
	public static void logText(String text) {
		ReportManager.extentTest.info(MarkupHelper.createLabel(text, ExtentColor.TEAL));
	}
	
	// method adds json into report
	public static void logJson(String json) {
		ReportManager.extentTest.info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
	}
}