package com.clavax.novusloyality.transactionsScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class LoginNovus {
public static  WebDriver  openBrowser() {
		
		
		System.setProperty(browserDriver, driverpath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		 return driver = new ChromeDriver( options );
		
	
	
}
static WebDriver driver;
WebElement Select;

public static String browserDriver = "webdriver.chrome.driver";
public static String driverpath = "C://Users//Vidushi Mishra//workspace//Bookfari//Lib//chromedriver_win32//chromedriver.exe";
public static String prodVendUrl = "https://tempegolfrange.vendhq.com/signin";
public static String testVendUrl = "https://ecater1.vendhq.com/signin";

//public static String vendUserNameID = "signin_username";
//public static String vendUserName = "Clavax";
//public static String vendPasswordID = "signin_password";
//public static String vendPassowrd = "Cla@12345";
//public static String vendSignInButtonID = "signin_submit";




	
	@BeforeTest
	public static void startTest() {
		openBrowser();
		System.out.println("browser open");
	}
	
	@Test(priority=1)	
	public static void loadWebsite() throws Exception{
		
		
		try {
			
			driver.get(testVendUrl);
			TakeScreenshot.getscreenshot(driver);
			String url =driver.getCurrentUrl();
			Assert.assertTrue(true);
			System.out.println("website load :" + url );
		
		
		} catch (Exception e) {
			System.out.println("I am in Exception" +e.getMessage());
			TakeScreenshot.getscreenshot(driver);
			System.out.println("website not load ");
			Assert.assertTrue(false);
		}
	}
	@Test (priority=2)
	public static void testLogin()
	{
		try {
			driver.findElement(By.id("signin_username")).sendKeys("mark@ecater.com.au");
			driver.findElement(By.id("signin_password")).sendKeys("ecater@01");
			driver.findElement(By.name("signin_submit")).click();
			Thread.sleep(100000);
		//	driver.wait(10000);
			 WebDriverWait wait = new WebDriverWait(driver, 1000);
			 WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/nv-sidenav/div/vd-sidebar-drawer/vd-nav-item[3]/a")));
					


			System.out.println(driver.getCurrentUrl());
			//TakeScreenshot.getscreenshot(driver);
			System.out.println("user login ");
			Assert.assertTrue(true);


			
		} catch (Exception e) {
			System.out.println("I am in Exception" +e.getMessage());
			TakeScreenshot.getscreenshot(driver);
			System.out.println("user not loggedin  ");


		}
	}
	@Test (priority=3)
	public static void openSalesHistory()
	{
		try{
			driver.findElement(By.xpath("/html/body/div[1]/nv-sidenav/div/vd-sidebar-drawer/vd-nav-item[3]/a")).click();
			//TakeScreenshot.getscreenshot(driver);
			System.out.println("open history ");
			Assert.assertTrue(true);
		}
		catch (Exception e){
			System.out.println("I am in Exception" +e.getMessage());
			TakeScreenshot.getscreenshot(driver);
			System.out.println("history not opened ");
		}
	}
	@Test(priority=4)
	public static void navigatetoAllSales()
	{
	  try{
		  driver.findElement(By.xpath("/html/body/div[1]/nv-main-content/div/div/div/wr-sales-history-tabset/vd-section/div/vd-tabs/ng-transclude/vd-tab[3]/button")).click();
		  WebDriverWait wait = new WebDriverWait(driver, 40);

			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/nv-main-content/div/div/div/wr-sales-history-tabset/wr-sales-history-table/vd-section[1]/div/form/div/div[2]/div/button")));
			System.out.println("All sales  opened ");
	  }
	  catch (Exception e){
			System.out.println("I am in Exception" +e.getMessage());
			TakeScreenshot.getscreenshot(driver);
			System.out.println("All sales not opened ");
		}
	}
	@Test(priority=5)
	public static void searchTodayTransaction()
	{
		try{
			driver.findElement(By.xpath("/html/body/div[1]/nv-main-content/div/div/div/wr-sales-history-tabset/wr-sales-history-table/vd-section[1]/div/form/div/div[2]/div/a")).click();
			driver.findElement(By.xpath("/html/body/div[1]/nv-main-content/div/div/div/wr-sales-history-tabset/wr-sales-history-table/vd-section[1]/div/form/div/div[1]/div[2]/div[3]/div[2]/vd-datepicker-range/div/input")).click();
			System.out.println("clicked on date picker ");

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("I am in Exception" +e.getMessage());
			TakeScreenshot.getscreenshot(driver);
			System.out.println("not clicked on date picker ");
		}
	}
	@Test(priority=6)
	public Date   getTodaysDate(){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy/");
		System.out.println(dateFormat.format(date)); //11/16/2016
		System.out.println("the current date is " +date);
		
		return date;
	}
	


	}

	


