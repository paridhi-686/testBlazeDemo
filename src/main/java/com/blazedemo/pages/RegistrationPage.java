package com.blazedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.TestBase;

public class RegistrationPage extends TestBase {
	
	//Page Factory
			@FindBy(how=How.XPATH,using="//button[contains(text(),'Register')]") 
			WebElement registerBtn;
			
			@FindBy(how=How.ID,using="name") 
			WebElement nameOfUser; 
			
			@FindBy(how=How.ID,using="company") 
			WebElement company; 
			 
			@FindBy(how=How.ID,using="email") 
			WebElement emailRegistration; 
			 
			@FindBy(how=How.ID,using="password") 
			WebElement passwordRegistration; 
			
			@FindBy(how=How.ID,using="password-confirm") 
			WebElement passwordConfirm; 
			
			
			public RegistrationPage(){
				PageFactory.initElements(driver, this);
			}
			
			 public void fillRegistrationDetails(String uName,String uCompany,String uEmail,String uPassword,String confirmPassword)
				
				{
				 nameOfUser.sendKeys(uName);
				 company.sendKeys(uCompany);
				 emailRegistration.sendKeys(uEmail);
				 passwordRegistration.sendKeys(uPassword);
				 passwordConfirm.sendKeys(confirmPassword);
				 registerBtn.click();
				 
					
				}


}
