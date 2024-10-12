package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EquipmentRelaunchTimeTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		System.out.println("----------------EquipmentRelaunchTimeTest------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"),
				prop.getProperty("manager_password"));
		kpipage = homepage.navigateToKPI_Management();
		kpipage.navigateToEquipmentRelaunchTime();

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void testSubmitBtn() throws Exception {

		Assert.assertTrue(ert.submitBtnExists(),"Submit button doesnt exists");

	}

}
