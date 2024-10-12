package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class ControlTowerTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		System.out.println("--------------ControlTower Test-----------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"),
				prop.getProperty("manager_password"));
		ctpage = homepage.navigateToControlTower();
	}

	@Test(groups = { "SmokeTest"}, priority = 1)
	public void ControlTowerMainScreenNamesTest() {

		Assert.assertEquals(ctpage.getControlTowerMainScreenNames(), Constants.EXPECTED_CT_MAIN_SCREEN_NAMES_,"Control tower screen names are not matching/available");

	}
	
	@Test(groups = { "SmokeTest" }, priority = 2)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

}
