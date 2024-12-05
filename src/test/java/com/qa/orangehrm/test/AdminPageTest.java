package com.qa.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;
import com.qa.orangehrm.pages.AdminPage;

public class AdminPageTest extends BaseTest {
	
	
	
	@BeforeClass
	public void adminSetUp() {
		lp.doLogin("Admin", "admin123");
		ap = lp.navigateToAdminPage();
	}
	
	@Test
	public void scenario2test() {
		ap.checkUserManagementElementAvailability();
		ap.adduserdetails();
		ap.searchUser();
		Assert.assertEquals(ap.checkUserPresence(), "TestUserCreation");
		ap.deleteUser();
		lp.logout();
	}
	
	
	
	

}
