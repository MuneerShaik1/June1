package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class MoveStack_Pageobjects extends Testbase {

	public MoveStack_Pageobjects() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//i[@class='fa fa-houzz']")
	WebElement hover;

	@FindBy(xpath = "//a[text()='Move Stock']")
	WebElement movestack;

	@FindBy(xpath = "//select[@id='movedFromD']")
	WebElement movefrom;

	@FindBy(id = "movedToD")
	WebElement moveto;

	@FindBy(id = "MoStNot")
	WebElement refno;

	@FindBy(xpath = "(//table[@id='daiomndsData']/tbody/tr/td/span)[1]")
	WebElement modelno;

	@FindBy(id = "qtymoving")
	WebElement movingqnty;

	@FindBy(id = "btnAdd")
	WebElement add;

	@FindBy(id = "btnSave")
	WebElement save;

	@FindBy(xpath = "//span[contains(@class,'search--dropdown')]")
	WebElement searchModelno;

	@FindBy(xpath = "//span[contains(@class,'dropdown--above')]/span[2]/ul/li[4]")
	WebElement modelnoVal;

	public MoveStack_Pageobjects(WebDriver driver) throws Throwable {
		PageFactory.initElements(driver, this);
	}

	public void movestocktfromWtoS() {

		try {
			Utils.actionMethods(hover);
			movestack.click();
			Thread.sleep(3000);
			Utils.selectvalue(movefrom, props.getProperty("movefromvalue"));
			Utils.selectvalue(moveto, props.getProperty("movetovalue"));
			refno.sendKeys(props.getProperty("RefNo"));
			modelno.click();
			modelnoVal.click();
			movingqnty.clear();
			movingqnty.sendKeys(props.getProperty("qty"));
			add.click();
			Thread.sleep(1000);
			save.click();
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void movestocktfromStoW() {

		try {
			Utils.actionMethods(hover);
			movestack.click();
			Thread.sleep(3000);
			Utils.selectvalue(movefrom, props.getProperty("movefromSvalue"));
			Utils.selectvalue(moveto, props.getProperty("movetoSvalue"));
			refno.sendKeys(props.getProperty("RefNo"));
			modelno.click();
			modelnoVal.click();
			movingqnty.clear();
			movingqnty.sendKeys(props.getProperty("qty"));
			add.click();
			Thread.sleep(1000);
			save.click();
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}