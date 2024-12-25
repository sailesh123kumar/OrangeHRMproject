package com.qa.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;

public class LoginPageTest extends BaseTest {
	
	
	@Test
	public void scenario1test() {
		lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		lp.logout();
		
	}
	
	
}
