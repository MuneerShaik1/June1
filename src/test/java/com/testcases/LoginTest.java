package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjects.Login_functionality;
import com.Utils.Utils;
import com.base.Testbase;

public class LoginTest extends Testbase {

	Login_functionality lf;

	public LoginTest() throws Throwable {
		super();
	}

	@BeforeMethod

	public void setup() throws Throwable {

		Initialization();

		lf = new Login_functionality(driver);

	}

	@Test

	public void Verifylogin() {

		lf.Dologin();

		String url = driver.getCurrentUrl();

		Assert.assertEquals("http://empirehome.myprojectsonline.co.in/EmpireHome/", url);

	}
	
	@Test(dataProvider="getdata",dataProviderClass=LoginTest.class)
	 public void VerfiyInvalidData(String Username,String Password)
	 {
		 lf.DoLoginWithExcel(Username,Password);
		 String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"http://empirehome.myprojectsonline.co.in/EmpireHome/Dashboard");
	 }
	@DataProvider 
	public  Object[][] getdata() throws IOException
	{
		
		
		return Utils.getdatafromexcel(sheet);
	}

	@AfterMethod

	public void teardown() {

		//driver.close();

	}

}
