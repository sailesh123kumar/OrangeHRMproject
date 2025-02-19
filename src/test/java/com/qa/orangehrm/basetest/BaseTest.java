package com.qa.orangehrm.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.orangehrm.driverfactory.BrowserFactory;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.JobPage;
import com.qa.orangehrm.pages.LeavePage;
import com.qa.orangehrm.pages.LoginPage;

public class BaseTest {
	
	WebDriver driver;
	BrowserFactory bf;
	protected Properties prop;
	protected LoginPage lp;
	protected HomePage hp;
	protected AdminPage ap;
	protected JobPage jp;
	protected LeavePage lep;
	
	@BeforeTest
	public void setup() {
		
		bf = new BrowserFactory();
		prop  = bf.initProperties();
		
		driver = bf.initBrowser(prop);
		lp = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
