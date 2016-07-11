package com.zf.appium.testcases;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.zf.appium.common.CommonFunctions;
import com.zf.appium.common.DotTestListener;


@Listeners({DotTestListener.class})
public class DemoTest extends CommonFunctions {
	
	
	//public AndroidDriver<AndroidElement> driver;
	String port;
	String devicename;
	//CommonFunctions comm = new CommonFunctions();
    
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
    	
    	//CommonFunctions comm=new CommonFunctions();
    	Thread.sleep(8000);
    	/*driver.findElement(By.id("me.sui.arizona:id/btn_login")).click();
    	Thread.sleep(3000);*/
    	driver.findElement(By.id("me.sui.arizona:id/et_phone")).sendKeys("15261672979");
    	Thread.sleep(1000);
    	driver.findElement(By.id("me.sui.arizona:id/et_pwd")).sendKeys("Suiyin888001");
    	driver.findElement(By.id("me.sui.arizona:id/btn_login")).click();
    	Thread.sleep(5000);
    	List<AndroidElement> lis = driver.findElementsByClassName("android.widget.ImageView");//获取ImageView的所有元素
    	AndroidElement targetEle = lis.get(5);//获取列表中第一个元素
    	targetEle.click();
    	Thread.sleep(3000);
    	driver.findElement(By.id("me.sui.arizona:id/print_pop_print")).click();
    	driver.findElement(By.id("me.sui.arizona:id/number_add")).click();
    	driver.findElement(By.id("me.sui.arizona:id/tv_print_now")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.id("me.sui.arizona:id/bt_commit")).click();
    	Thread.sleep(5000);
    	driver.switchTo().frame(2);
    	Thread.sleep(5000);
    	driver.findElement(By.id("me.sui.arizona:id/bt_commit")).click();
    	Thread.sleep(8000);
    
    	//driver.openNotifications();
        //driver.lockDevice();
    	//driver.runAppInBackground(5);
    	//driver.removeApp("me.sui.arizona");
    	//driver.swipe(75, 500, 75, 0, (int) 0.8);
    	//driver.pinch(null);
    	
    	/*byte[] data = Base64.encodeBase64("some data for the file".getBytes());
    	String path = "/data/local/tmp/file.txt";
    	driver.pushFile(path, data);*/
    	
    	
    	
    	
    	/*Thread.sleep(3000);
    	driver.findElement(By.id("me.sui.arizona:id/mydoc_fab")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//android.widget.LinearLayout[5]")).click();
    	Thread.sleep(1000);*/
    	//driver.findElement(By.id("com.android.fileexplorer:id/file_name")).click();
    	//Thread.sleep(1000);
    	//driver.findElement(By.id("android:id/checkbox")).click();
    	//Thread.sleep(1000);
    	//driver.findElement(By.className("android.widget.Button")).click();
    	
    	//向下滑动
    	/*Thread.sleep(5000);
    	int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, 1000);
        //Thread.sleep(8000);
*/    	
    	/*Thread.sleep(5000);
        TouchAction gesture = new TouchAction(driver).press(936, 501).release();//文档右侧按钮
        driver.performTouchAction(gesture);
        Thread.sleep(3000);
        TouchAction gesture1 = new TouchAction(driver).press(192, 1532).release();//打印按钮
        driver.performTouchAction(gesture1);
        //driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'打印 ')]")).click();
        driver.findElement(By.name("打印")).click();
        Thread.sleep(3000);
        
        
        TouchAction action = new TouchAction(driver)
        .press(mapview, 10, 10)
        .release().
        perform();
        
        driver.findElement(By.id("me.sui.arizona:id/print_options_confirm")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("me.sui.arizona:id/btn_right")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("《周礼》.pdf")).click();
        driver.findElement(By.id("me.sui.arizona:id/printlist_settlement")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("me.sui.arizona:id/createprintorder_textview_createprint")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("me.sui.arizona:id/modepay_textview_pay")).click();
        Thread.sleep(8000);
        //System.out.print(driver.getPageSource());
*/      
    	
    }

    @AfterMethod
    public void afterTest() throws InterruptedException {
    	//CommonFunctions.snapshot((TakesScreenshot)driver,"Login.png");
    	//driver.closeApp();
    	//driver.removeApp("me.sui.arizona");
    	//driver.resetApp();
    	//CommonFunctions.snapshot(driver, "image");
    	//comm.takeScreenshot(driver);
    	Thread.sleep(5000);
    	driver.quit();
    }

}


