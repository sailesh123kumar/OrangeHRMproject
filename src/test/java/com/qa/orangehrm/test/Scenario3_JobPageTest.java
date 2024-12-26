package com.qa.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;
import com.qa.orangehrm.constants.AppConstants;

public class Scenario3_JobPageTest extends BaseTest{

	
	@BeforeMethod
	public void jobPageSetUp() {
		hp = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		ap = hp.navigateToAdminPage();
		jp = ap.navigateToJobTitle();
	}
	
	
	@Test
	public void adminUserManagementValidation_Scenario3Test() {
		Assert.assertTrue(ap.checkUserManagementElementAvailability());
		
	}
	
	@Test
	public void jobTitleHeaderValidation_Scenario3Test() {
		Assert.assertTrue(jp.headervalidation());
	}
	
	@Test
	public void addEditAndDeleteJobTitle_Scenario3Test() {
		jp.fillJobDetails("Test Engineer","SDET Engineer",AppConstants.JOBUPLOAD_FILE_PATH,"Testing");
		Assert.assertTrue(jp.validateJobTitleAvailability("Test Engineer"));
		jp.editJobtitle("Test Engineer");
		Assert.assertTrue(jp.validateJobTitleAvailability("SDET Test Engineer"));
		jp.deleteTitle("SDET Test Engineer");
		
	}
	
	@AfterMethod
	public void logout() {
		lp.logout();
	}
	
}
