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
import com.adminLTE.qa.pages.Operatorspage;
import com.adminLTE.qa.pages.Pythonsyllabus;
import com.adminLTE.qa.pages.Seleniumtestingsyllabus;
import com.adminLTE.qa.pages.UserPage;
import com.adminLTE.qa.util.TestUtil;

public class DashboardTest extends TestBase{
	LoginPage loginpage;
	Dashboardpage dashboardpage;
	TestUtil testUtil;
	Operatorspage operator1;
	UserPage userpage;
	Seleniumtestingsyllabus seleniumtestingsyllabuss;
	Pythonsyllabus pythonsyllabustab;
	
	public DashboardTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		dashboardpage= new Dashboardpage();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		operator1= new Operatorspage();
		userpage = new UserPage();
		seleniumtestingsyllabuss= new Seleniumtestingsyllabus();
		pythonsyllabustab = new Pythonsyllabus();
		
		dashboardpage= loginpage.Login(prop.getProperty("un"), prop.getProperty("pa"));
		
	}
	@Test(priority = 1)
	public void verifycorrectUsernamedisplayedTest() {
		boolean flag= dashboardpage.verifycorrectUsernamedisplayed();
		AssertJUnit.assertTrue(flag);
		}
	@Test(priority = 2)
	public void clickonUserTest() {
		
				userpage= dashboardpage.clickonUser();
	}
	
	@Test(priority = 3)
	public void clickonOperatorsTest() throws Exception {
			operator1= dashboardpage.clickonOperators();
		
	}
	@Test(priority = 4)
	public void clickseleniumtestingsyllabustabTest() throws Exception {
		seleniumtestingsyllabuss = dashboardpage.clickseleniumtestingsyllabustab();
	}
	@Test(priority = 5)
	public void clickPythonsyllabustabTest() throws Exception {
		pythonsyllabustab = dashboardpage.clickPythonsyllabustab();
	}
	
	
	@AfterMethod
	public void tearDown() {		
		driver.quit();
	}
}
