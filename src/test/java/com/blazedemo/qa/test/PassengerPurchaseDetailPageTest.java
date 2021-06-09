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

public class PassengerPurchaseDetailPageTest extends TestBase {
	
	FindFlightPage findFlightPage;
	ChooseFlightPage chooseFlightPage;
	PassengerPurchaseDetailPage passengerPurchaseDetailPage;
	BookingConfirmationPage bookingConfirmationPage;

	public PassengerPurchaseDetailPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		findFlightPage = new FindFlightPage();
		chooseFlightPage = findFlightPage.findflights(prop.getProperty("journeyFrom"),prop.getProperty("journeyTo"));
		passengerPurchaseDetailPage = chooseFlightPage.chooseflight();
		
	}
	
	@Test(priority=1)
	public void verifyDetailsPageTitleTest() {
		String title = passengerPurchaseDetailPage.validatePassengerDetailPageTitle();
		Assert.assertEquals(title, "BlazeDemo Purchase","Page title doesnot match");
		
	}
	
	@Test(priority=2)
	public void fillFullDetails() {
		passengerPurchaseDetailPage.fillName(prop.getProperty("pName"));
		passengerPurchaseDetailPage.fillAddressDetails(prop.getProperty("pAddress"),prop.getProperty("pCity"),prop.getProperty("pState"),prop.getProperty("pZipcode"));
		passengerPurchaseDetailPage.fillCreditCardDetails(prop.getProperty("cardNumber"),prop.getProperty("month"),prop.getProperty("year"),prop.getProperty("cardHolderName"));
		bookingConfirmationPage = passengerPurchaseDetailPage.purchaseFlight();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}

