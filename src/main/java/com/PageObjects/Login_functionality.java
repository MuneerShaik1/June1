package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class Login_functionality extends Testbase {

	public Login_functionality() throws Throwable {
		super();
	}



	@FindBy (xpath="//input[@placeholder='example@gmail.com']")
	WebElement username;
	
	
	@FindBy (xpath="//input[@placeholder='******']")
	WebElement password;
	
	
	@FindBy (xpath="//button[text()='Login']") 
	WebElement loginbutton;
	
	
	
	public Login_functionality(WebDriver driver)throws Throwable {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public HomePage Dologin() throws Throwable {
		
	username.sendKeys(props.getProperty("username"));	
	password.sendKeys(props.getProperty("password"));
	
	loginbutton.click();
	
	return new HomePage();
	}
	
		public void DoLoginWithExcel(String username2, String password2) {
		// TODO Auto-generated method stub
		username.sendKeys(props.getProperty("username"));	
		password.sendKeys(props.getProperty("password"));
		
		loginbutton.click();
	}



	


	


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

