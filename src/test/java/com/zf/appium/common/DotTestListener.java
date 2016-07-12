package com.zf.appium.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.text.SimpleDateFormat;
import java.util.Date;

//import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
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
	
	/*private void takeScreenShot(ITestResult tr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String mDateTime = formatter.format(new Date());
		String fileName = mDateTime + "" + tr.getName();
		String filePath = OrangeiOS.driver.getScreenshotAs(fileName);
		Reporter.setCurrentTestResult(tr);
		Reporter.log(filePath);

		//这里实现把图片链接直接输出到结果文件中，通过邮件发送结果则可以直接显示图片
		//Reporter.log(“<img src=\”../” + filePath + “\”/>”);
		Reporter.log(“<img src=\”../” + filePath + “\”/>”);

    }*/

}
