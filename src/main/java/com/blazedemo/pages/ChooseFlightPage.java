package com.blazedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.TestBase;

public class ChooseFlightPage extends TestBase {
	
	//Page Factory
	@FindBy(how=How.XPATH,using="//form[@name='VA43']//following::input[1]") 
	WebElement chooseFlightBtn;
	
	@FindBy(how=How.XPATH,using="//tbody") 
	WebElement table;
	
	public ChooseFlightPage(){
		PageFactory.initElements(driver, this);
	}

	public String validateChooseFlightTitle() {
		return driver.getTitle();
	}
    
	public boolean checkTablePresent() {
		return table.isDisplayed();
	}
	
    public PassengerPurchaseDetailPage chooseflight()
	
	{
		chooseFlightBtn.click();
		return new PassengerPurchaseDetailPage();
		
	}
	


}
