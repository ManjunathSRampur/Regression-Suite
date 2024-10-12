package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DelayAnalysisTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		System.out.println("------------------------DelayAnalysisTest-----------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), 
				prop.getProperty("manager_password"));
		kpipage = homepage.navigateToKPI_Management();
		kpipage.navigateToDelayAnalysis();

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void testSubmitBtnExists() throws Exception {

		Assert.assertTrue(da.submitBtnExists(),"Submit button doesnt exists");
	}

}
