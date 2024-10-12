package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScheduleAdheranceReportTest extends BaseTest {
	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), 
				prop.getProperty("manager_password"));
		kpipage = homepage.navigateToKPI_Management();
		kpipage.navigateToScheduleAdheranceReport();
		System.out.println("-------------ScheduleAdheranceReportTest--------------------");
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void testsubmitBtn() throws Exception {
		
	 Assert.assertTrue(sar.submitBtn());

	}

}
