package Tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {

    BaseTest baseTest = new BaseTest();
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            baseTest.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
