package com.zf.appium.common;



import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CommonFunctions {
	public AndroidDriver<AndroidElement> driver;
	public AndroidDriver<AndroidElement> getDriver(){
		return driver;
	}
	
	public void setup(){
		
	}
	
	/**
	 * 获取ImageView的所有元素
	 * @param classname
	 * @return
	 */
	public List<AndroidElement> getAllImges(String classname){
		//List<AndroidElement> lis = driver.findElementsByClassName("android.widget.ImageView");
		List<AndroidElement> lis = driver.findElementsByClassName(classname);
		return lis;
	}
	
	/**
	 * 场景1：同一个页面有10个ImageView对象，而我们的目标元素的index为4，
	 * 而同为ImageView且index为4的页面只有2个。那我们就可以根据这2个条件来组合查询条件，提高效率。
	 * @param classname
	 * @param index
	 * @return
	 */
	public List<AndroidElement> getElementsByClassAndIndex(String classname,int index){
		List<AndroidElement> lis =null;
		lis = driver.findElementsByAndroidUIAutomator("new UiSelector().className("+classname+").index("+index+")");
		return lis;
	}
	
	/**
	 * 场景2：同一个页面有10个ImageView对象，而其中index为4的有5个，
	 * 而这时我们发现我们的目标元素的是clickable的。然后review页面发现，同时满足上述条件的只有2个。
	 * @param classname
	 * @param index
	 * @return
	 */
	public List<AndroidElement> getElementsByClassAndIndexAndClickable(String classname,int index){
		List<AndroidElement> lis =null;
		lis = driver.findElementsByAndroidUIAutomator("new UiSelector().className("+classname+").index("+index+").clickable(true)");
		return lis;
	}
	
	/**
	 * 场景3：在分析页面元素的时候发现，页面相对比较简单，而且其中只有目标元素的index为4.
	 * @param index
	 * @return
	 */
	public AndroidElement getElementByIndex(int index){
		return driver.findElementByAndroidUIAutomator("new UiSelector().index("+index+")");
	}
	
	/**
	 * 截图
	 * @param drivername
	 * @param filename
	 */
	public static void snapshot(TakesScreenshot drivername, String filename) {
       	String dateStr = String.valueOf(new Date().getTime());
        String currentPath = System.getProperty("user.dir");                                                                 
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            System.out.println("save snapshot path is:" + currentPath + "\\images\\"
                    + filename + ".jpg");
            FileUtils
                    .copyFile(scrFile, new File(currentPath + "\\images\\" + filename + ".jpg"));
        } catch (IOException e) {
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        } finally {
            System.out.println("screen shot finished, it's in " + currentPath + "\\images\\"
                    + " folder");
        }
    }
	
	/**
	 * 截图，名称是当前时间
	 * @param drivername
	 */
	public  void takeScreenshot(TakesScreenshot drivername){
		String dateStr = String.valueOf(new Date().getTime());
		String screenName = dateStr + ".jpg";
		File dir = new File("test-output/snapshot");
		String screenPath = dir.getAbsolutePath() + "/" + screenName;
		 try {
	            //File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    File scrFile = drivername.getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(scrFile, new File(screenPath));
	            System.out.println("截图是："+screenName);
	     } catch (IOException e) {
	            System.out.println("Screen shot error: " + screenPath);
	     }  
	}
	
	
	public static void main(String args[]) {
		CommonFunctions comm = new CommonFunctions();
		comm.getAllImges("android.widget.ImageView").get(5);//获取列表中第6个元素
		
		
	}

}
