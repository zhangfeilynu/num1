package com.zf.appium.actions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * 安装启动随米app
 * @author Administrator
 *
 */

public class FirstPageAction {
	
	private AndroidDriver<AndroidElement> driver;
	
	public FirstPageAction(){
		
	}
	
	public  FirstPageAction(String port,String devicename) throws Exception{
		
		//设置app路径
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot,"app");
		File app = new File(appDir,"app-release.apk");
		//设置自动化相关参数
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("deviceName",devicename);
		capabilities.setCapability("platformVersion","6.0");
		//设置app路径
		capabilities.setCapability("app", app.getAbsolutePath());
		//支持中文
		capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");
        //设置app的包名和启动activity
        capabilities.setCapability("appPackage","me.sui.arizona");
	    capabilities.setCapability("appActivity","me.sui.arizona.ui.activity.FirstPageActivity");
	    //初始化
	    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:"+port+"/wd/hub"),capabilities); 
		
	}

}
