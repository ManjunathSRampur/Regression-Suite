package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class ManagerTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		System.out.println("-------------------Manager Test----------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"),
				prop.getProperty("manager_password"));
		ctpage = homepage.navigateToControlTower();
		mgr = ctpage.navigateToManager();

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void controlTowerSubScreenNamesTest() {
		// System.out.println("Manager Page");

		Assert.assertEquals(mgr.getManagerScreenNames(), Constants.EXPECTED_CT_MANAGER_SCREEN_NAMES_,"Manager screen names are not matching/displayed");

	}

}
