package com.qa.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;

public class LoginPageTest extends BaseTest {
	
	
	@Test
	public void scenario1test() {
		lp.doLogin("Admin", "admin123");
		
		Assert.assertTrue(lp.checkMenuElementAvailability("Admin"));
		Assert.assertTrue(lp.checkMenuElementAvailability("PIM"));
		Assert.assertTrue(lp.checkMenuElementAvailability("Leave"));
		Assert.assertTrue(lp.checkMenuElementAvailability("Time"));
		Assert.assertTrue(lp.checkMenuElementAvailability("Recruitment"));
		Assert.assertTrue(lp.checkMenuElementAvailability("My Info"));
		
		Assert.assertTrue(lp.checkWidgetElementAvailability("Time at Work"));
		Assert.assertTrue(lp.checkWidgetElementAvailability("My Actions"));
		Assert.assertTrue(lp.checkWidgetElementAvailability("Quick Launch"));
		Assert.assertTrue(lp.checkWidgetElementAvailability("Buzz Latest Posts"));
		Assert.assertTrue(lp.checkWidgetElementAvailability("Employees on Leave Today"));
		Assert.assertTrue(lp.checkWidgetElementAvailability("Employee Distribution by Sub Unit"));
		
		lp.logout();
		
	}
	
	
	@Test
	public void scenario2test() {
		lp.doLogin("Admin", "admin123");
		lp.navigateToAdminPage();
		
	}
	

}
