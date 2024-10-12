package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CycleTimeAnalysisTest extends BaseTest {
	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		System.out.println("--------------CycleTimeAnalysis Test-----------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), 
				prop.getProperty("manager_password"));
		kpipage = homepage.navigateToKPI_Management();
		kpipage.navigateToCycleTimeAnalysis();

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void testSubmitBtnExists() throws Exception {

		Assert.assertTrue(cta.submitBtnExists(),"Submit button doesnt exists");

	}

}
