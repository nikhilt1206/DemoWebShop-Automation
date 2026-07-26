package com.nikhil.automation.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nikhil.automation.constants.FrameworkConstants;

public class ExtentManager {
    private static ExtentReports extentReports;

    public static ExtentReports getExtentReports(){
        if(extentReports==null){
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.REPORT_PATH);
            extentSparkReporter.config().setReportName(FrameworkConstants.REPORT_NAME);
            extentSparkReporter.config().setDocumentTitle(FrameworkConstants.REPORT_TITLE   );
            extentSparkReporter.config().setTheme(Theme.DARK);
            extentReports.attachReporter(extentSparkReporter);
        }
       return extentReports;
    }
}
