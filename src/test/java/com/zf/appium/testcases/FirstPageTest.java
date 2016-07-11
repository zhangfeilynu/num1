package com.zf.appium.testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.zf.appium.actions.FirstPageAction;


public class FirstPageTest {
	
	public FirstPageAction dr;
	private AndroidDriver<AndroidElement> driver;
	
			
   @Parameters({"port","devicename"})
   @BeforeMethod
   public void beforeTest(String port,String devicename) throws Exception{
	  
	    dr = new FirstPageAction(port,devicename);
	  
    }
  
    @Test
    public void fptest() throws Exception {
    	
    	/*Thread.sleep(8000);
    	driver.findElement(By.id("me.sui.arizona:id/btn_login")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.id("me.sui.arizona:id/et_phone")).sendKeys("15261672979");
    	Thread.sleep(1000);
    	driver.findElement(By.id("me.sui.arizona:id/et_pwd")).sendKeys("Suiyin888001");
    	driver.findElement(By.id("me.sui.arizona:id/btn_login")).click();*/
         	
    }

    @AfterMethod
    public void afterTest() throws Exception {
        //driver.quit();
    }

}
