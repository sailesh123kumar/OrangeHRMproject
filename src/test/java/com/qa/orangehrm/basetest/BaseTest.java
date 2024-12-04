package com.qa.orangehrm.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.orangehrm.driverfactory.BrowserFactory;
import com.qa.orangehrm.pages.LoginPage;

public class BaseTest {
	
	WebDriver driver;
	BrowserFactory bf;
	Properties prop;
	protected LoginPage lp;
	
	@BeforeTest
	public void setup() {
		
		bf = new BrowserFactory();
		prop  = bf.initProperties();
		
		driver = bf.initBrowser(prop);
		lp = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
