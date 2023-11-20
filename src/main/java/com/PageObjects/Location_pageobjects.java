package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class Location_pageobjects extends Testbase {

	public Location_pageobjects() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//i[@class='fa fa-database']")
	WebElement hover;

	@FindBy(xpath = "//li//a[text()='Location ']")
	WebElement location;

	@FindBy(xpath = "//a[contains(@class,'btn btn-add')]/i[@class='fa fa-plus']")
	WebElement addnew;

	//// span[contains(@class,'dropdown--above')]/span[2]/ul/li[4]

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement locationname;

	
	@FindBy(xpath = "//button[@type='submit'][1]")
	WebElement savebutton;

	public Location_pageobjects(WebDriver driver) throws Throwable {
		PageFactory.initElements(driver, this);
		;
	}

	public void verifyLocation() throws Throwable {
		Utils.actionMethods(hover);
		location.click();
		Thread.sleep(5);
		addnew.click();
		Thread.sleep(5);
		locationname.sendKeys(props.getProperty("locationname"));

		locationname.click();
	}

}