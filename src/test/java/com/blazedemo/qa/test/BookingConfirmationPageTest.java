package com.blazedemo.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.TestBase;
import com.blazedemo.pages.BookingConfirmationPage;
import com.blazedemo.pages.ChooseFlightPage;
import com.blazedemo.pages.FindFlightPage;
import com.blazedemo.pages.PassengerPurchaseDetailPage;

public class BookingConfirmationPageTest extends TestBase {
	FindFlightPage findFlightPage;
	ChooseFlightPage chooseFlightPage;
	PassengerPurchaseDetailPage passengerPurchaseDetailPage;
	BookingConfirmationPage bookingConfirmationPage;
	
	public BookingConfirmationPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		findFlightPage = new FindFlightPage();
		chooseFlightPage = findFlightPage.findflights(prop.getProperty("journeyFrom"),prop.getProperty("journeyTo"));
		passengerPurchaseDetailPage = chooseFlightPage.chooseflight();
		bookingConfirmationPage = passengerPurchaseDetailPage.purchaseFlight();
		
	}
	
	@Test(priority=1)
	public void bookingConfirmPageTitleTest() {
		String title = bookingConfirmationPage.validateBookingConfirmationPageTitle();
		Assert.assertEquals(title, "BlazeDemo Confirmation","Page title doesnot match");
		
	}
	
	@Test(priority=2)
	public void verifyBookingSuccessTest() {
		boolean flag = bookingConfirmationPage.successText();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void checkConfirmIDTest() {
		boolean flag = bookingConfirmationPage.checkConfirmationID();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=4)
	public void getConfirmIDTest() {
		String confirmID = bookingConfirmationPage.getConfirmationID();
		System.out.println("ConfirmationID is" +confirmID);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
