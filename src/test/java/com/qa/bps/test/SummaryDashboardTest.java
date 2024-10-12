package com.qa.bps.test;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SummaryDashboardTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		System.out.println("---------Summary Dashboard Page----------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		ctpage = homepage.navigateToControlTower();
		mgr = ctpage.navigateToManager();
		summarydash = mgr.navigateToSummaryDashboard();

	}

//	******************************Updated test cases start from here ****************************
	@Test(groups = { "SmokeTest" }, priority = 1)
	public void dataAvlUnderSummaryTabTest() throws InterruptedException {
		Assert.assertTrue(summarydash.dataAvlUnderSummaryTab(), "Data is not avaialable under summary tab ");
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void dataAvlUnderProductionTabTest() throws InterruptedException {
		Assert.assertTrue(summarydash.dataAvlUnderProductionTab(), "Data is not avaialable under production tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void dataAvlUnderEqpTabTest() throws InterruptedException {
		Assert.assertTrue(summarydash.dataAvlUnderEqpTab(), "Data is not avaialable under equipment tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void dataAvlUnderWIPInvTabTest() throws InterruptedException {
		Assert.assertTrue(summarydash.dataAvlUnderWIPInvTab(), "Data is not avaialable under WIP Inv tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void dataAvlUnderStockTabTest() throws InterruptedException {
		Assert.assertTrue(summarydash.dataAvlUnderStockTab(), "Data is not avaialable under Stock tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void dataAvlUnderOpTabTest() throws InterruptedException {
		Assert.assertTrue(summarydash.dataAvlUnderOpTab(), "Data is not avaialable under Operator tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void dataAvlUnderProductionLineTabTest() throws InterruptedException {
		Assert.assertTrue(summarydash.dataAvlUnderProductionLineTab(),
				"Data is not avaialable under Production Line tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void dataAvlUnderOpUtiliInHrsTabTest() throws InterruptedException {
		Assert.assertTrue(summarydash.dataAvlUnderOpUtiliIHrsTab(),
				"Data is not avaialable under operator utilization in HRS tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void dataAvlUnderOpUtilizationInMinsTabTest() throws InterruptedException {
		Assert.assertTrue(summarydash.dataAvlUnderOpUtilizationInMinsTab(),
				"Data is not avaialable under operator utilization in Mins tab");
	}

}
