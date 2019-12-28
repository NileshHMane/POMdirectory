package com.adminlte.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adminLTE.qa.base.TestBase;
import com.adminLTE.qa.pages.Adduserpage;
import com.adminLTE.qa.pages.Dashboardpage;
import com.adminLTE.qa.pages.LoginPage;
import com.adminLTE.qa.pages.UserPage;
import com.adminLTE.qa.util.TestUtil;

public class UserPageTestcases extends TestBase{
	TestUtil testutil;
	LoginPage loginpage;
	Dashboardpage dashboardpage;
	UserPage userPage;
	Adduserpage adduser;
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		dashboardpage=new Dashboardpage();
		userPage=new UserPage();
		adduser= new Adduserpage();
		
		dashboardpage = loginpage.Login(prop.getProperty("un"), prop.getProperty("pa"));
		userPage =dashboardpage.clickonUser();
	}
	
	@Test(priority = 1)
	public void tabletiledisplayTest() {
		boolean flag= userPage.tabletiledisplay();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority = 2)
	public void clickonAdduserTest() throws InterruptedException {
		adduser=userPage.clickonAdduser();
		
	}
	@Test(priority = 3)
	public void clickondeleteTest() throws InterruptedException {
		userPage=userPage.clickonDelete();
	}
	@Test(priority =4)
	public void clickonLogoutTest() throws Exception {
		loginpage = userPage.clickonLogout();
	}
	
	
	
	public UserPageTestcases() {
		super();
	}
	
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
}
