package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class MicroPlanningTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("----------Microplanning Page----------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		homepage.navigateToMicroplanning();

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void screenNamesTest() {

		Assert.assertEquals(microplan.checkMicroplanningScreenNames(), Constants.EXPECTED_MICROPLANNING_SCREEN_NAMES,
				"Microplanning screen names are not matching/available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void dateTimeTextTest() {

		Assert.assertTrue(microplan.dateTimeEnabled(), "In microplanning Data and time are disabled");
	}

}
