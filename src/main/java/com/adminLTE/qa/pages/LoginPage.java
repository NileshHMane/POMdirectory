package com.adminLTE.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adminLTE.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath ="//*[contains(text(),'Java By Kiran')]")
	WebElement logotext;
	@FindBy(id ="email")
	WebElement email;
	@FindBy(id ="password")
	WebElement password;
	@FindBy(xpath="//*[@type='submit']")
	WebElement SignIn;
	@FindBy(xpath="//a[@class='text-center']")
	WebElement Register_a_new_membership;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatepagetile() {
		
		return driver.getTitle();
	}
	
	public	boolean checklogo() {
		return logotext.isDisplayed();
		}
	
	public Dashboardpage Login(String un, String pass) {
		email.sendKeys(un);
		password.sendKeys(pass);
		SignIn.click();
		return new Dashboardpage();
	}
}
