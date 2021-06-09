package com.blazedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.blazedemo.base.TestBase;

public class FindFlightPage extends TestBase {
	
	//Page Factory
	@FindBy(name="fromPort") 
	WebElement journeyFrom;
	
	@FindBy(name="toPort") 
	WebElement journeyTo;
	
	@FindBy(how=How.XPATH,using="//input[(@value='Find Flights')]") 
	WebElement findFlightBtn; 
	
	@FindBy(how=How.LINK_TEXT,using="home") 
	WebElement home_link;
	
	@FindBy(how=How.LINK_TEXT,using="destination of the week! The Beach!") 
	WebElement beach_link;
	
	public FindFlightPage() {
		
		PageFactory.initElements(driver, this);

	}
	
	//Actions
	
	public String validateBlazeDemoTitle() {
		return driver.getTitle();
	}
	
	public LoginPage moveToHomeLink() {
		home_link.click();
		return new LoginPage();
	}
	
	
    public ChooseFlightPage findflights(String flightFrom,String flightTo)
	
	{
		Select fromCountry = new Select(journeyFrom);
		fromCountry.selectByVisibleText(flightFrom);
		Select toCountry = new Select(journeyTo);
		toCountry.selectByVisibleText(flightTo);
		findFlightBtn.click();
		return new ChooseFlightPage();
		
	}
	
	
}
