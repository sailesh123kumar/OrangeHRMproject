package com.qa.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;
import com.qa.orangehrm.constants.AppConstants;

public class Scenario4_LeavePageTest extends BaseTest{
	
	
	@BeforeMethod
	public void leavePageSetUp() {
		hp = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		lep = hp.navigateToLeavePage();
		
	}
	
	@Test
	public void applyAndCancelLeave_Scenario4Test() {
		lep.clickApply();
		Assert.assertTrue(lep.headerValidation());
		lep.enterLeaveDetails();
		lep.cancelMyLeave("Testing sick leave");
		String verifycancelLeavestatus = lep.verifycancelLeavestatus("Testing sick leave");
		Assert.assertTrue(verifycancelLeavestatus.contains(AppConstants.LEAVEPAGE_FRACTION_CANCEL) );
	}

	
	@AfterMethod
	public void logout() {
		lp.logout();
	}
}
