package com.qa.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;

public class LeavePageTest extends BaseTest{
	
	
	@BeforeClass
	public void leavePageSetUp() {
		hp = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		lep = hp.navigateToLeavePage();
		
	}
	
	@Test
	public void scenario4test() {
		lep.clickApply();
		Assert.assertTrue(lep.headerValidation());
		lep.enterLeaveDetails();
		lep.cancelMyLeave("Testing sick leave");
		String verifycancelLeavestatus = lep.verifycancelLeavestatus("Testing sick leave");
		Assert.assertEquals(verifycancelLeavestatus, "Cancelled (1.00)");
		lp.logout();
	}

}
