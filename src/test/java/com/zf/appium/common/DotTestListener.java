package com.zf.appium.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.Date;

//import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.zf.appium.common.ScreenShot;
/**
 * 监听错误，重写onTestFailure方法
 * @author Administrator
 *
 */
public class DotTestListener extends TestListenerAdapter {
	
	@Override
	public void onTestFailure(ITestResult tr) {
		
		try {
            CommonFunctions cf = (CommonFunctions) tr.getInstance();
            AndroidDriver<AndroidElement> driver = cf.getDriver();
            /*ScreenShot dr= new ScreenShot(driver);
            dr.takeScreenshot();  */
            cf.takeScreenshot(driver);
            //System.out.println(driver.getTitle());
            //System.out.println(String.valueOf(new Date().getTime())+driver.getTitle());
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {         
            e.printStackTrace();
        }
		
    }

}
