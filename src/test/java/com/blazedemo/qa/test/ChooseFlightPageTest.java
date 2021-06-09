package com.blazedemo.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.TestBase;
import com.blazedemo.pages.ChooseFlightPage;
import com.blazedemo.pages.FindFlightPage;
import com.blazedemo.pages.PassengerPurchaseDetailPage;

public class ChooseFlightPageTest extends TestBase {
	FindFlightPage findFlightPage;
	ChooseFlightPage chooseFlightPage;
	PassengerPurchaseDetailPage passengerPurchaseDetailPage;
	
	public ChooseFlightPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		findFlightPage = new FindFlightPage();
		chooseFlightPage = findFlightPage.findflights(prop.getProperty("journeyFrom"),prop.getProperty("journeyTo"));
		
	}
	
	@Test(priority=1)
	public void verifyChooseFlightPageTitleTest() {
		String title = chooseFlightPage.validateChooseFlightTitle();
		Assert.assertEquals(title, "BlazeDemo - reserve");
		
	}
	
	@Test(priority=2)
	public void verifyTableTest() {
		boolean flag = chooseFlightPage.checkTablePresent();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void chooseFlightTest() {
		passengerPurchaseDetailPage = chooseFlightPage.chooseflight();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
