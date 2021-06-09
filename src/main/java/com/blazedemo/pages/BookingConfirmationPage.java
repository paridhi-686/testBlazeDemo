package com.blazedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.TestBase;

public class BookingConfirmationPage extends TestBase {
	
	//Page Factory
		@FindBy(how=How.XPATH,using="//*[@class='table']/tbody/tr[1]/td[2]") 
		WebElement confirmationID;
		
		@FindBy(how=How.XPATH,using="//*[text()='Thank you for your purchase today!']") 
		WebElement textVerify;
		
		public BookingConfirmationPage(){
			PageFactory.initElements(driver, this);
		}

		public String validateBookingConfirmationPageTitle() {
			return driver.getTitle();
		}
	    
		public boolean successText() {
			return confirmationID.isDisplayed();
		}
		
		
		public boolean checkConfirmationID() {
			return confirmationID.isDisplayed();
		}
		
		public String getConfirmationID() {
			return confirmationID.getText();
		}
		
		

}
