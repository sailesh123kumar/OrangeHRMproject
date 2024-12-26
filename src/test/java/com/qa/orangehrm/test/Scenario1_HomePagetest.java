package com.qa.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;
import com.qa.orangehrm.pages.HomePage;

public class Scenario1_HomePagetest extends BaseTest{
	
	
	@BeforeMethod    //This method will execute before each test
	public void homePageSetUp() {
		hp = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test
	public void menuItemAvaiability_Scenario1Test() {
		Assert.assertTrue(hp.checkMenuElementAvailability("Admin"));
		Assert.assertTrue(hp.checkMenuElementAvailability("PIM"));
		Assert.assertTrue(hp.checkMenuElementAvailability("Leave"));
		Assert.assertTrue(hp.checkMenuElementAvailability("Time"));
		Assert.assertTrue(hp.checkMenuElementAvailability("Recruitment"));
		Assert.assertTrue(hp.checkMenuElementAvailability("My Info"));
	}
	
	@Test
	public void widgetItemAvaiability_Scenario1Test() {
				
		Assert.assertTrue(hp.checkWidgetElementAvailability("Time at Work"));
		Assert.assertTrue(hp.checkWidgetElementAvailability("My Actions"));
		Assert.assertTrue(hp.checkWidgetElementAvailability("Quick Launch"));
		Assert.assertTrue(hp.checkWidgetElementAvailability("Buzz Latest Posts"));
		Assert.assertTrue(hp.checkWidgetElementAvailability("Employees on Leave Today"));
		Assert.assertTrue(hp.checkWidgetElementAvailability("Employee Distribution by Sub Unit"));
	}
	
	@AfterMethod
	public void logout() {
		lp.logout();
	}
	
}
