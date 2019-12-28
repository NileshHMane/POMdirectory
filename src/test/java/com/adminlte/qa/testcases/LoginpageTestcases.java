package com.adminlte.qa.testcases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adminLTE.qa.base.TestBase;
import com.adminLTE.qa.pages.Dashboardpage;
import com.adminLTE.qa.pages.LoginPage;

public class LoginpageTestcases extends TestBase {
	
	LoginPage loginpage;
	Dashboardpage dashboardpage;

	public LoginpageTestcases() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage= new LoginPage();
	}
	
	
	@Test(priority = 1)
		public void loginpageTitletest() {
		
		String title = loginpage.validatepagetile();
		String expected="JavaByKiran | Log in";
			
			AssertJUnit.assertEquals(title, expected);
			
	}
	@Test(priority=2)
	public void checklogotest() {
		boolean flag= loginpage.checklogo();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(invocationCount = 2 ,priority=3)
	public void loginTestwith_Invalid_data() {
		System.out.println("***********************************************Fail Test case*********************************************************");
		dashboardpage = loginpage.Login("Nilesh", "23456");
		String actual = driver.getTitle();
		//System.out.println(actual);
		
		String expected=dashboardpage.gettitleofDashboadpage();
		
		//System.out.println(expected);
		
		Assert.assertEquals(actual, expected);
	}
	
	
	@Test(priority =4)
	public void LoginTest() {	
		dashboardpage= loginpage.Login(prop.getProperty("un"), prop.getProperty("pa"));
		
		
	}
	

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
