package com.adminlte.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adminLTE.qa.base.TestBase;
import com.adminLTE.qa.pages.Adduserpage;
import com.adminLTE.qa.pages.Dashboardpage;
import com.adminLTE.qa.pages.LoginPage;
import com.adminLTE.qa.pages.UserPage;
import com.adminLTE.qa.util.TestUtil;

public class AdduserTestcases extends TestBase {
		LoginPage loginpage;
		Dashboardpage dashboardpage;
		UserPage userpage;
		Adduserpage adduserpage;
		TestUtil testutil;
		String sheetname = "UDP";
		
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		loginpage= new LoginPage();
		dashboardpage= new Dashboardpage();
		userpage= new UserPage();
		adduserpage= new Adduserpage();
		testutil= new TestUtil();
		dashboardpage= loginpage.Login(prop.getProperty("un"), prop.getProperty("pa"));
		dashboardpage.clickonUser();
		userpage.clickonAdduser();
	}
	
	public AdduserTestcases()
	{
		super();
	}
	
	@Test(priority = 1)
	public void gettitleofpage() {
		String s = adduserpage.gettitleofPage();
		String expected= "JavaByKiran | Add User";
		AssertJUnit.assertEquals(s, expected, "Actual name is differnt than Expected ");
	
	}

	
	@Test(priority=2,dataProvider ="getADMINLTEtestdata")
	public void createnewUserTest(String Username, String Mobile,String Email,String Courses,String Gender,String State,String Password) throws Exception {
		adduserpage.createnewUser(Username, Mobile, Email, Courses, Gender, State, Password);
		
	}
	@DataProvider
	public Object[][] getADMINLTEtestdata(){
		
		Object da[][] = TestUtil.getTestdatafromexcel(sheetname);
		System.out.println("*****************************************");
		return da;
	}
	
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}

}