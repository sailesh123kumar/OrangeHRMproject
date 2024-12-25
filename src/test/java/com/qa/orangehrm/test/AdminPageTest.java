package com.qa.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;
import com.qa.orangehrm.constants.AppConstants;
import com.qa.orangehrm.pages.AdminPage;

public class AdminPageTest extends BaseTest {

	@BeforeClass
	public void adminSetUp() {
		hp = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		ap = hp.navigateToAdminPage();
	}

	@Test
	public void adminUserManagementValidation_scenario2test() {
		Assert.assertTrue(ap.checkUserManagementElementAvailability());
	}

	@Test
	public void scenario2test() {
		ap.adduserdetails("TestUserCreation" , "testing123" , "Ranga Akunuri");
		ap.searchUser("TestUserCreation");
		Assert.assertEquals(ap.checkUserPresence("TestUserCreation"), "TestUserCreation");
		ap.deleteUser();
		lp.logout();
	}

}
