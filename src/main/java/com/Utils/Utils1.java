package com.Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.Testbase;

public class Utils1 extends Testbase{

	public Utils1() throws Throwable {
		super();
	}
	
	public static void actionMethods(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).click().perform();

}

}