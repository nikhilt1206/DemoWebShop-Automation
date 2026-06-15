package com.nikhil.automation.listeners;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.utils.LoggerUtils;
import com.nikhil.automation.utils.ScreenshotUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerUtils.logError("Test Failed: "+result.getName());
        ScreenshotUtils.captureScreenshot(BaseTest.getDriver(),result.getName());
        LoggerUtils.logInfo("Screenshot captured for: "+result.getName());
    }
}
