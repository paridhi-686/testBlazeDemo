package com.blazedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.TestBase;

public class PassengerPurchaseDetailPage extends TestBase {
	
	
	
	@FindBy(how=How.ID,using="inputName") 
	WebElement name; 
	
	@FindBy(how=How.ID,using="address") 
	WebElement address;
	
	@FindBy(how=How.ID,using="city") 
	WebElement city;
	
	@FindBy(how=How.ID,using="state") 
	WebElement state;
	
	@FindBy(how=How.ID,using="zipCode") 
	WebElement zipcode;
	
	@FindBy(how=How.ID,using="creditCardNumber") 
	WebElement creditCardNumber;
	
	@FindBy(how=How.ID,using="creditCardMonth") 
	WebElement creditCardMonth;
	
	@FindBy(how=How.ID,using="creditCardYear") 
	WebElement creditCardYear;
	
	@FindBy(how=How.ID,using="nameOnCard") 
	WebElement nameOnCard;
	
	
	@FindBy(how=How.XPATH,using="//input[(@value='Purchase Flight')]") 
	WebElement purchasebtn; 
	
	public PassengerPurchaseDetailPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String validatePassengerDetailPageTitle() {
		return driver.getTitle();
	}
	
    public void fillName(String pName)
	
	{
		name.sendKeys(pName);
		
	}
	
      public void fillAddressDetails(String pAddress,String pCity,String pState,String pZipcode)
	
	{
		address.sendKeys(pAddress);
		city.sendKeys(pCity);
		state.sendKeys(pState);
		zipcode.sendKeys(pZipcode);
		
	}
	
      public void fillCreditCardDetails(String cardNumber,String month,String year,String cardHolderName)
      {
    	creditCardNumber.sendKeys(cardNumber);
    	creditCardMonth.sendKeys(month);
    	creditCardYear.sendKeys(year);
    	nameOnCard.sendKeys(cardHolderName);
    	  
      }
      
      public BookingConfirmationPage purchaseFlight()
      {
    	
    	  purchasebtn.click();
    	  return new BookingConfirmationPage();
    	  
      }
      

}
