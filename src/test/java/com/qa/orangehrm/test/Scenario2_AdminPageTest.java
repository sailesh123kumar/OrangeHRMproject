package com.qa.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;
import com.qa.orangehrm.constants.AppConstants;
import com.qa.orangehrm.pages.AdminPage;

public class Scenario2_AdminPageTest extends BaseTest {

	@BeforeMethod
	public void adminSetUp() {
		hp = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		ap = hp.navigateToAdminPage();
	}

	@Test
	public void adminUserManagementValidation_Scenario2Test() {
		Assert.assertTrue(ap.checkUserManagementElementAvailability());
	}

	@Test
	public void addAndDeleteUser_Scenario2Test() {
		ap.adduserdetails("TestUserCreation" , "testing123" , "Ranga Akunuri");
		ap.searchUser("TestUserCreation");
		Assert.assertEquals(ap.checkUserPresence("TestUserCreation"), "TestUserCreation");
		ap.deleteUser();
		
	}
	
	public void logout() {
		lp.logout();
	}

}
