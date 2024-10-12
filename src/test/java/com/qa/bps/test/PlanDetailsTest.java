package com.qa.bps.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class PlanDetailsTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------Plan Details Test-------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		microplan = homepage.navigateToMicroplanning();
		pl = microplan.navigateToPlanner();
		pl.navigateToDraftPlan();

	}

	@Test(groups = { "Workflow" }, priority = 1)
	public void publishPlanTest() throws InterruptedException {

		Assert.assertEquals(pd.publishPlan(), "Published", "Published message is not displayed ");

	}

	// checkCampaignCount()

//	  @Test(groups = { "Workflow" }, priority = 2)
	public void checkCampaignCount() throws InterruptedException, IOException {

		Assert.assertTrue(pd.checkCampaignCount(), "Campaign count is not matching with uploaded data");

	}

	// checkBatchescount

//	  @Test(groups = { "Workflow" }, priority = 3)
	public void testcheckbatchesCount() throws InterruptedException, IOException {

		Assert.assertTrue(pd.checkbatchesCount(), "Batches count is not matching with uploaded data");

	}

// @Test(groups = { "Workflow" }, priority = 4)
	public void testcheckCampaignDetails() throws InterruptedException, IOException {

		Assert.assertTrue(pd.checkCampaignDetails(), "Campaign details are not matching with uploaded data");

	}

//  @Test(groups = { "Workflow" }, priority = 5) 
	public void testcheckgnattChart() throws InterruptedException, IOException {

		Assert.assertTrue(pd.checkgnattChart(),
				"In gnatt chart campaign_IDs are not matching with campaign file excel test data");

	}

//	  @Test(groups = { "SmokeTest" }, priority = 4) 
	public void checkVersionDetails() throws InterruptedException {
		Assert.assertTrue(pd.getVersionDetails(), "Version details are not matching");
	}

	// Verify the download Operator GapAnalysis Icon tool tip displayed on mouse
	// over
	@Test(groups = { "SmokeTest" }, priority = 6)
	public void downloadOperatorGapAnalysisIconToolTip() throws InterruptedException {

		Assert.assertEquals(pd.downloadOperatorGapAnalysisIconToolTip(),
				Constants.DOWNLOAD_OPERATOR_GAP_ANALYSIS_TOOLTIP,
				"Download Operator Gap Analysis icon tool tip is not displayed/matching");
	}

	// Verify the failed constraints icon tool tip displayed on mouse over
	@Test(groups = { "SmokeTest" }, priority = 7)
	public void failedConstraintsIconToolTip() {

		Assert.assertEquals(pd.failedConstraintsIconToolTip(), Constants.FAILED_CONSRAINTS_TOOLTIP,
				" failed constraints icon tool tip is not displayed/matching");
	}

	// Verify the log events icon tool tip displayed on mouse over
	@Test(groups = { "SmokeTest" }, priority = 8)
	public void logEventsIconToolTip() {

		Assert.assertEquals(pd.logEventsIconToolTip(), Constants.LOG_EVENTS_TOOLTIP,
				"Log events icon tool tip is not displayed/matching");
	}

	// Verify the full screen Icon tool tip displayed on mouse over
	@Test(groups = { "SmokeTest" }, priority = 9)
	public void fullScreenIconToolTip() {

		Assert.assertEquals(pd.fullScreenIconToolTip(), Constants.FULL_SCREEN_VIEW,
				"Full screen icon tool tip is not displayed/matching");

	}

}
