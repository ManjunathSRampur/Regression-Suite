package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlantViewTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		System.out.println("--------- PlantView Test------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), 
				prop.getProperty("manager_password"));
		ctpage = homepage.navigateToControlTower();
		mgr = ctpage.navigateToManager();
		mgr.navigateToPlantView();

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void delayFieldDisplayedTest() throws InterruptedException {

		Assert.assertTrue(pview.checkTotalDelayExist());

	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void menuDetailsTest() throws InterruptedException {

		Assert.assertTrue(pview.checkMenusExist());

	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void equipmentSummaryDetailsTest() throws InterruptedException {

		Assert.assertFalse(pview.getSummaryEquipmentDetails());

	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void clusterSummaryDetailsTest() {

		Assert.assertFalse(pview.getClusterEquipmentDetails());

	}
}
