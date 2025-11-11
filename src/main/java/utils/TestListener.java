package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.startReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.endReport();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        ExtentManager.createTest(testName);
        ExtentManager.logFail("Test Failed: " + result.getThrowable());

        String screenshotPath = ScreenshotUtils.captureScreenshot(driver, testName);
        if (screenshotPath != null) {
            try {
                ExtentManager.test.addScreenCaptureFromPath("../" + screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.logPass("Test Passed: " + result.getName());
    }
}
