package com.adminLTE.qa.pages;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.adminLTE.qa.base.TestBase;
import com.adminLTE.qa.util.TestUtil;

public class Adduserpage extends TestBase {
	
	@FindBy(id="username")
	WebElement username1;
	@FindBy(id="mobile")
	WebElement mobiles;
	@FindBy(id="email")
	WebElement email1;
	@FindBy(id="course")
	WebElement course1;
	
	@FindBy(xpath ="//input[@id ='Male']")
	WebElement gendermale;
	
	@FindBy(xpath ="//input[@id ='Female']")
	WebElement genderfemale;
	
	@FindBy(xpath ="//select[@class='form-control']")
	WebElement citydropdown;
	@FindBy(id="password")
	WebElement password1;
	
	@FindBy(xpath="//span[contains(text(),'Cancel')]")
	WebElement btnCancel;
	
	@FindBy(id ="submit")
	WebElement btnSubmit;
	
	public String gettitleofPage(){
		
		return TestUtil.gettitle();
	}
	
	public Adduserpage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createnewUser(String Username, String Mobile,String Email,String Courses,String Gender,String State,String Password) throws Exception {
		username1.sendKeys(Username);
		mobiles.sendKeys(Mobile);
		email1.sendKeys(Email);
		course1.sendKeys(Courses);
		
		if(Gender.equals("Male")) {
		gendermale.click();
		}else if(Gender.equals("Female")) {
			genderfemale.click();
		}
		Select select = new Select(citydropdown);
		select.selectByVisibleText(State);
		password1.sendKeys(Password);
		//clickonsubmitbtn();
		btnSubmit.click();
		 Thread.sleep(2000);
		 TestUtil.popuphandleaccept();
		 Thread.sleep(3000);
		
	}
	
	
	
	/*
	 * public Adduserpage clickonsubmitbtn() throws Exception { btnSubmit.click();
	 * Thread.sleep(2000); TestUtil.popuphandleaccept(); Thread.sleep(3000); return
	 * new Adduserpage(); }
	 */
	
	public UserPage clickoncancelbtn()
	{
		 btnCancel.click();
		return new UserPage();
	}
}	
