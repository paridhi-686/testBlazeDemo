package com.blazedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.TestBase;

public class LoginPage extends TestBase {
	
	
	//Page Factory
		@FindBy(how=How.XPATH,using="//button[contains(text(),'Login')]") 
		WebElement LoginBtn;
		
		@FindBy(how=How.ID,using="email") 
		WebElement email; 
		
		@FindBy(how=How.ID,using="password") 
		WebElement password; 
		 
		@FindBy(how=How.LINK_TEXT,using="Register") 
		WebElement register;
		
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}

		public String getLoginPageTitle() {
			return driver.getTitle();
		}
	    
		   public void fillLoginDetails(String useremail,String userpassword)
			
			{
			   email.sendKeys(useremail);
			   password.sendKeys(userpassword);
			   LoginBtn.click();	
			}
		   
		   public RegistrationPage selectRegistration()
			
			{
			   register.click();
				return new RegistrationPage();
				
			}

}
