package com.adminLTE.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adminLTE.qa.base.TestBase;

public class Dashboardpage extends TestBase{

	
	
	@FindBy(xpath="//*[@class='logo-lg']")
	WebElement logo;
	
	@FindBy(xpath="//a[@href='../pdf/selenium-testing-syllabus-jbk.pdf']")
	WebElement Seleniumtab;
	
	@FindBy(xpath="//div[@class='pull-left info']//p")
	WebElement username11;
	
	@FindBy(xpath="//a[@href='../pdf/java-j2ee-syllabus-jbk.pdf']")
	WebElement javatab;	
	@FindBy(xpath="//a[@href='../pdf/python-syllabus.pdf']")
	WebElement pythontab;
	
	@FindBy(xpath="//span[text()='Users']")
	WebElement userbtn;
	@FindBy(xpath= "//span[text()='Operators']")
	WebElement operatorsbtn;
	
	@FindBy(xpath= "//span[text()='     Useful Links']")
	WebElement UsefulLinks;
	
	
	public Dashboardpage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean verifycorrectUsernamedisplayed() {
		
		return username11.isDisplayed();
				
	}

	public UserPage clickonUser() {
		userbtn.click();
		return new UserPage();
	}
	
	
	public  Operatorspage clickonOperators() throws Exception {
		operatorsbtn.click();
		Thread.sleep(1000);
		return new Operatorspage();
			}
	
	public  Seleniumtestingsyllabus clickseleniumtestingsyllabustab() throws Exception {
			Seleniumtab.click();
			Thread.sleep(1000);
			return new Seleniumtestingsyllabus();
	}
	public  Pythonsyllabus clickPythonsyllabustab() throws Exception {
		pythontab.click();
		Thread.sleep(1000);
		return new Pythonsyllabus();
}
	public String gettitleofDashboadpage()
	{
		String title= driver.getTitle();
		return title;
	}
	}

