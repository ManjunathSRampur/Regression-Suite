package com.qa.bps.test;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BatchMonitoringTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
	}

//------------------------------------------------------	
	@Test(groups = { "SmokeTest" }, priority = 0)
	public void preReq() throws InterruptedException, SQLException {
		jdbc.configureDelayCodeGrp();
		Thread.sleep(2000);
		navigateTo.LattestPublishedPlan();
		Thread.sleep(2000);
		String PN = navigateTo.GetProductDetailsFromPlanner();
		navigateTo.addValueToEventProp();
		navigateTo.productOverview();
		driver.navigate().refresh();
		Thread.sleep(5000);
		ptclose.preReqTest(PN);
		jdbc.getEquipmentNameFromDB();
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void VerifyAPUDropdown() throws Exception {
		navigateTo.batchMonitoring();
		Assert.assertTrue(ptclose.verifyAPUDD());

	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyAPTDropdown() throws Exception {

		Assert.assertTrue(ptclose.verifyAPTDD());

	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyBuildingDropdown() throws Exception {

		Assert.assertTrue(ptclose.verifyBuildingDD());

	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void VerifyProductDropdown() throws Exception {

		Assert.assertTrue(ptclose.VerifyProductDD());

	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyProductName() throws Exception {
		navigateTo.LattestPublishedPlan();
		Thread.sleep(2000);
		String PN = navigateTo.GetProductDetailsFromPlanner();
		navigateTo.batchMonitoring();
		Assert.assertTrue(ptclose.verifyProductName(PN));

	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyProductCampaignwiseFilter() throws InterruptedException {
		navigateTo.productOverview();
		Thread.sleep(3000);
		Assert.assertTrue(ptclose.verifyCampaignWiseFilter());

	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void closefirstOpStatusTaskWIP() throws Exception {
		Thread.sleep(3000);
		Assert.assertTrue(ptclose.OpStatusTaskWIP());

	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyTaskStatusInBMAndPOVInWIPState() {
		Assert.assertTrue(ptclose.verifyTaskStatusInBMAndPOVInWIPStateTest(),
				"Task status in POV And BM is not same in WIP State");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void VerifyUserCanCloseTheTask() throws Exception {

		Assert.assertTrue(ptclose.VerifyuserCanCloseTheTaskTest(), "Toaster message is not displayed ");

	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void operatorAvlPostClose() throws InterruptedException {
		Assert.assertTrue(ptclose.operatorAvlPostCloseTest(), "Operator are not same in BM and POV After close ");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void verifyTaskStatusInBMAndPOVinCloseState() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(ptclose.verifyTaskStatusInBMAndPOVinCloseStateTest(),
				"Task status in POV And BM is not same in close State");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyUserCanRestartTask() throws Exception {
		Thread.sleep(2000);
		Assert.assertTrue(ptclose.verifyUserCanRestartTask(),
				"User is unable to restart the task / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifyOpAvlPostRestart() throws InterruptedException {
		Assert.assertTrue(ptclose.verifyOpAvlPostRestartTest(), "Operator are not same in BM and POV After Restart ");
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void verifyTaskStatusInBMAndPOVinPostRestartState() throws InterruptedException {

		Assert.assertTrue(ptclose.verifyTaskStatusInBMAndPOVinPostRestartStateTest(),
				"Task status in POV And BM is not same in post restart State");
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void verifyUserCanCloseTaskWithDelay() throws Exception {

		Assert.assertTrue(ptclose.verifyUserCanCloseTaskWithDelayTest(),
				"User is unable close the task with delay / toaster message is not displayed ");

	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void verifyOperatorStatusAfterDelayClose() throws InterruptedException {
		Assert.assertTrue(ptclose.verifyOperatorStatusAfterDelayCloseTest(),
				"Operator are not same in BM and POV After delay close ");
	}

	@Test(groups = { "SmokeTest" }, priority = 17)

	public void verifyTaskStatusInBMAndPOVinPostDelayFinishState() {
		Assert.assertTrue(ptclose.verifyTaskStatusInBMAndPOVinPostDelayFinishStateTest(),
				"Task status in POV And BM is not same in post delay close State");
	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void taskGroupActionBtn() throws InterruptedException {
		Assert.assertTrue(ptclose.taskGroupActionBtnTest(),
				"Task group toggle Button containse Start/Mark as Completed/Reopen/Reset action buttons");
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifyFuncOfChooseFilterInNotStartedState() throws InterruptedException {
		Assert.assertTrue(ptclose.verifyFuncOfChooseFilterInNotStartedStateTest(),
				"choose status filter is not working for not started option ");
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void verifyFuncOfChooseFilterInWIPdState() throws InterruptedException {
		Assert.assertTrue(ptclose.verifyFuncOfChooseFilterInWIPdStateTest(),
				"Task Type filter is not working for In-progress option");
	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyFuncOfChooseFilterInAllState() throws InterruptedException {
		Assert.assertTrue(ptclose.verifyFuncOfChooseFilterInAlldStateTest(),
				"choose status filter is not working for All option ");
	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyUserCanCloseTheTasEarly() throws InterruptedException {
		Assert.assertTrue(ptclose.verifyUserCanCloseTheTasEarlyTest(), "User is unable to close the task Early");
	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void verifyOperatorStatusAfterEarlyClose() throws InterruptedException {
		Assert.assertTrue(ptclose.verifyOperatorStatusAfterEarlyClose(),
				"After early close BM operator POV operator are not same");
	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyTaskStatusInBMAndPOVinPostEarlyFinishState() {
		Assert.assertTrue(ptclose.verifyTaskStatusInBMAndPOVinPostEarlyFinishStateTest(),
				"Task status in POV And BM is not same in post early close State");
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifyUserCanDoAssetDown() throws InterruptedException {
		Assert.assertTrue(ptclose.verifyUserCanDoAssetDownTest(),
				"User is unable to do asset down / toaster message is not displayed ");
		Thread.sleep(5000);
	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void verifyAddedAssetAlertInBM() {
		Assert.assertTrue(ptclose.verifyAddedAssetAlertInBMTest(),
				"Asset down alert is not displayed / wrong asset down alert is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void verifyAddedAssetInPOV() throws InterruptedException {
		Assert.assertTrue(ptclose.verifyAddedAssetInPOVTest(),
				"Asset down alert is not displayed / wrong asset down alert is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void verifyUserCanDeleteAddedAssetDown() throws InterruptedException {
		Assert.assertTrue(ptclose.verifyUserCanDeleteAddedAssetDownTest(), "User is unable to delete the alert ");
	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	// this test case should be called after completing all the test cases
	@Test(groups = { "SmokeTest" }, priority = 30)
	public void deleteConfigureDelayCodeGrp() throws SQLException {
		jdbc.deleteConfigureDelayCode();
	}

}
