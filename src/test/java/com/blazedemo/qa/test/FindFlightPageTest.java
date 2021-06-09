package com.blazedemo.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.TestBase;
import com.blazedemo.pages.ChooseFlightPage;
import com.blazedemo.pages.FindFlightPage;
import com.blazedemo.pages.LoginPage;

public class FindFlightPageTest extends TestBase{
	FindFlightPage findFlightPage;
	ChooseFlightPage chooseFlightPage;
	LoginPage loginPage;
	
	public FindFlightPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		findFlightPage = new FindFlightPage();
	}
	
	@Test(priority=1)
	public void findFlightPageTitleTest() {
		String title = findFlightPage.validateBlazeDemoTitle();
		Assert.assertEquals(title, "BlazeDemo","Page title not matching");
		
	}
	
	@Test(priority=2)
	public void navigaTeToHomeLinkTest() {
		loginPage = findFlightPage.moveToHomeLink();
		
	}
	
	@Test(priority=3)
	public void findFlightTest() {
		chooseFlightPage = findFlightPage.findflights(prop.getProperty("journeyFrom"), prop.getProperty("journeyTo"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
