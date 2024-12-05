package com.qa.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;

public class JobPageTest extends BaseTest{

	
	@BeforeClass
	public void jobPageSetUp() {
		lp.doLogin("Admin", "admin123");
		ap = lp.navigateToAdminPage();
		jp = ap.navigateToJobTitle();
	}
	
	@Test
	public void scenario3test() {
		Assert.assertTrue(jp.headervalidation());
		jp.fillJobDetails();
		Assert.assertTrue(jp.validateJobTitleAvailabiliy("Test Engineer"));
		jp.editJobtitle();
		Assert.assertTrue(jp.validateJobTitleAvailabiliy("SDET Test Engineer"));
		jp.deleteTitle();
		lp.logout();
	}
}
