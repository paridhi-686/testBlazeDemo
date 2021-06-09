package com.blazedemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.blazedemo.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\AutomationExpert\\eclipse-workspace\\seleniumTest\\src\\main\\java\\com\\blazedemo\\config\\config.properties");
			prop.load(ip);
			
		} catch(FileNotFoundException e) {
		  	e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



    public static void initialization() {
    	
    	String browserName = prop.getProperty("browser");
    	if(browserName.equals("chrome")){
 	         System.setProperty("webdriver.chrome.driver", "C:\\Users\\AutomationExpert\\Desktop\\driver\\chromedriver.exe");  
 		     driver=new ChromeDriver();
 	  }
    	else if(browserName.equals("FF")) {
 		     System.setProperty("webdriver.gecko.driver", "C:\\Users\\AutomationExpert\\Desktop\\driver\\geckodriver.exe");  
  		     driver=new FirefoxDriver();
 		  
 	  }
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
 	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
     
    }
}