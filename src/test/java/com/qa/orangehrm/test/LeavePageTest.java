package com.qa.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;

public class LeavePageTest extends BaseTest{
	
	
	@BeforeClass
	public void adminSetUp() {
		lp.doLogin("Admin", "admin123");
		lep = lp.navigateToLeavePage();
		
	}
	
	@Test
	public void scenario4test() {
		lep.clickApply();
		Assert.assertTrue(lep.headerValidation());
		lep.enterLeaveDetails();
		lep.cancelMyLeave();
		lep.verifycancelLeavestatus();
		lp.logout();
	}

}
