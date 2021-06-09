package com.blazedemo.qa.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.TestBase;

import com.blazedemo.pages.FindFlightPage;
import com.blazedemo.pages.LoginPage;
import com.blazedemo.pages.RegistrationPage;


public class LoginPageTest extends TestBase {
     
	FindFlightPage findFlightPage;
	LoginPage loginPage;
	RegistrationPage registrationPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		findFlightPage = new FindFlightPage();
		loginPage = findFlightPage.moveToHomeLink();
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, "BlazeDemo");
		
	}
	
	@Test(priority=2)
	public void fillLoginTest() {
		loginPage.fillLoginDetails(prop.getProperty("useremail"), prop.getProperty("userpassword"));
	}
	
	@Test(priority=3)
	public void navigateToRegistration() {
		registrationPage = loginPage.selectRegistration();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


	
}
