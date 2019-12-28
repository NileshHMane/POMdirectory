package com.adminLTE.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adminLTE.qa.base.TestBase;
import com.adminLTE.qa.util.TestUtil;

public class UserPage extends TestBase {
	@FindBy(xpath="//h3[@class='box-title']")
	WebElement tabletitle;
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-sm pull-right']")
	WebElement btnadduser;
	
	@FindBy(xpath="//li[@class='dropdown user user-menu']")
	WebElement linkLogout;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/"
			+ "table/tbody/tr[2]/td[8]/a/span")
	WebElement deletebtn;
	
	@FindBy(xpath="//a[contains(text(),'LOGOUT')]")
	WebElement logoutbtn;
	
	
	
	
	public UserPage() {
	
		PageFactory.initElements(driver, this);
		}
	
	public Adduserpage clickonAdduser() throws InterruptedException {
		btnadduser.click();
		Thread.sleep(2000);
		return new Adduserpage();
		
	}
	public boolean tabletiledisplay() {
		return tabletitle.isDisplayed();
			
	}
	
	public LoginPage clickonLogout() throws Exception {
		logoutbtn.click();
		Thread.sleep(2000);
		return new LoginPage();
	}

	public UserPage clickonDelete() throws InterruptedException {
		deletebtn.click();
		Thread.sleep(9000);
		TestUtil.alerthandledismiss();
		Thread.sleep(4000);
		return new UserPage();
	}
	
}