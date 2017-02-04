package com.zf.appium.common;

import java.util.Iterator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
//解决报告中失败测试用例重跑后重复计数的问题
public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext context) { 
        Iterator<ITestResult> listOfFailedTests = context.getFailedTests().getAllResults().iterator();
        while (listOfFailedTests.hasNext()) {
            ITestResult failedTest = listOfFailedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                listOfFailedTests.remove();
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    listOfFailedTests.remove();
                }
            }
        }
    }

    // Following are all the method stubs that you do not have to implement

    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onTestFailure(ITestResult result) {
        // TODO  Auto-generated method stub
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
}
