package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class BodheeStudioTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------BodheeStudio Test Page-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));

		bs = homepage.navigateToBodheeStudio();
	}

	
	@Test(groups = { "SmokeTest" }, priority = 1)
	public void bodheeStudioMenusTest() throws InterruptedException {

		Assert.assertEquals(bs.bodheeStudioMenus(), Constants.EXPECTED_BODHEEESTUDIO_SCREEN_NAMES_,
				"Bodhee studio manu list is not matching");
		navigateTo.MapProcess();

	}
	@Test(groups = { "SmokeTest" }, priority = 2)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}
}
