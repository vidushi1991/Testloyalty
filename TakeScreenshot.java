package com.clavax.novusloyality.transactionsScripts;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	static WebDriver driver;

	static File source;
	 public static void getscreenshot(WebDriver webDriver)   {
   
		 try { 
			 source = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			 String destination = "D://Vidushi Mishra//Novus//Automation//Screenshot//test-outputclaimsScreenShot"+timestamp()+".png";
			 File dest = new File(destination);
		        
			 FileUtils.copyFile(source, dest);
			 System.out.println("Screenshot Taken!!!!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		 
            
     }
	 public static String timestamp() {
		    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		}


}
