package com.zf.appium.testcases;


import static org.testng.AssertJUnit.assertEquals;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;





public class LoginTest {
	
	
	private AndroidDriver<AndroidElement> driver;
	
	String port;
	String devicename;
    
	@BeforeMethod
	@Parameters({"port","devicename"})
   public void beforeTest(String port,String devicename) throws Exception{
	  
	    //设置apk路径
	    File classpathRoot = new File(System.getProperty("user.dir"));
	    File appDir=new File(classpathRoot,"apps");
	    File app=new File(appDir,"app-release2.apk");//要测试的app
	    //设置自动化相关参数
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("platformName","Android");
	    //capabilities.setCapability("deviceName","c3164935");
	    //capabilities.setCapability("deviceName","192.168.199.193:5555");
	    capabilities.setCapability("deviceName",devicename);
	    //设置安卓系统版本
	    capabilities.setCapability("platformVersion","6.0");
	    //设置apk路径
	    capabilities.setCapability("app", app.getAbsolutePath());
	    //支持中文 
	    capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");
	    //设置app的主包名和主类名
	    capabilities.setCapability("appPackage","me.sui.arizona");
	    capabilities.setCapability("appActivity","me.sui.arizona.ui.activity.FirstPageActivity");
	    //初始化
	    //driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:"+port+"/wd/hub"),capabilities); 	
    	//comfun=new CommonFunctions("c3164935");
    	
	  
    }
  
    @Test
    public void login() throws Exception {
    	
    	//登录
    	Thread.sleep(8000);
    	driver.findElement(By.id("me.sui.arizona:id/btn_login")).click();
    	Thread.sleep(3000);
    	System.out.println(driver.currentActivity());
    	driver.findElement(By.id("me.sui.arizona:id/et_phone")).sendKeys("15261672979");
    	Thread.sleep(1000);
    	driver.findElement(By.id("me.sui.arizona:id/et_pwd")).sendKeys("Suiyin888001");
    	driver.findElement(By.id("me.sui.arizona:id/btn_login")).click();
    	Thread.sleep(3000);
    	//assertEquals("",driver.currentActivity());
    	System.out.println(driver.currentActivity());
    	//具体事务
    	
    	
    	
    	/*//登出
    	Thread.sleep(3000);
    	int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
    	driver.swipe(width, height / 2, width *2 / 5, height / 2, 1000);
    	driver.findElement(By.className("android.widget.ImageButton")).click();//抽屉
    	Thread.sleep(1000);
    	//driver.findElement(By.name("登出")).click();
    	//driver.findElement(By.id("me.sui.arizona:id/item_doc_readtime")).click();
*/    	
    	Thread.sleep(8000);
    	/*Thread.sleep(3000);
    	assertEquals(".ui.activity.FirstPageActivity",driver.currentActivity());
    	Thread.sleep(8000);*/
       
    	
    }

    @AfterMethod
    public void afterTest() {
    	//CommonFunctions.snapshot((TakesScreenshot)driver,"Login.png");
    	//driver.closeApp();
    	//driver.removeApp("me.sui.arizona");
    	//driver.resetApp();
    	driver.quit();
    }

}


