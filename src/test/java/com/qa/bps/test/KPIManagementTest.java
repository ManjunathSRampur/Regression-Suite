package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class KPIManagementTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		System.out.println("-----------------Kpi Management Test---------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"),
				prop.getProperty("manager_password"));

		kpipage = homepage.navigateToKPI_Management();
	}

	// verify all the screen are available under kpi management
	@Test(groups = { "SmokeTest" }, priority = 1)
	public void screenNamesTest() {

		//System.out.println("KPI_Management");
		Assert.assertEquals(kpipage.checkKPIManagementScreenNames(), Constants.EXPECTED_KPI_Management_SCREEN_NAMES_,"KPI management screen names are not matching");
	}

}
