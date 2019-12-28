package com.adminLTE.qa.base;

import java.awt.Window;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.adminLTE.qa.util.TestUtil;
import com.adminLTE.qa.util.WebEventListener;


public class TestBase{
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase(){
		try {
			
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main"
					+ "/java/com/adminLTE/qa/config/config.properties");
			prop.load(fis);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void initialization() {
		
		String browsername = prop.getProperty("browser");
		
		if (browsername.equals("chrom")) {
			
			System.setProperty("webdriver.chrome.driver","F:\\Selenium practice\\wdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browsername.equals("ff"))
		{
			System.setProperty("webDriver.gecko.drivers","F:\\Selenium practice\\wdrivers\\geckodriver");
			driver= new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Pageload_timeunit, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implcitwaittimeunit, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		
	}

	

}
