package com.qa.bps.test;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class DailyOperatorManagementTest extends BaseTest {

	String batchNumberValue;

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		ctpage = homepage.navigateToControlTower();
		mgr = ctpage.navigateToManager();
		mgr.navigateToProducView();
		System.out.println("--------ProductOverView Delay Management Test-------------");

	}

//------------------------------Updated Test Script Start From Here --------------------------------------------------

	@Test(groups = { "SmokeTest" }, priority = 0)
	public void getProductDetailsTest() throws InterruptedException, SQLException {
		jdbc.configureDelayCodeGrp();
		navigateTo.LattestPublishedPlan();
		String ActPN = navigateTo.GetProductDetailsFromPlanner();
		String firstTaskName = navigateTo.findFirstTaskFromPlanner();
		String batchName = navigateTo.getFirstBatchName();
		navigateTo.addValueToEventProp();
		navigateTo.productOverview();
		productview.getTaskTimeFromPO(ActPN, firstTaskName, batchName);
		jdbc.getEquipmentNameFromDB();

	}

	// Verify user is able to login to the application as Shift Lead
	@Test(groups = { "SmokeTest" }, priority = 1)
	public void loginAsSLTest() throws InterruptedException {
		Assert.assertTrue(productview.loginAsSL(batchNumberValue), "Welcome message not exist ");
	}

	// verify the task availability in SLV

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyToatalOpFieldAvl() {
		Assert.assertTrue(productview.verifyToatalOpFieldAvlTest(),
				"Toatal Operator and Absent Operator count is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyHeaderBtnAvl() {
		Assert.assertEquals(productview.verifyHeaderBtnAvlTest(), Constants.ShiftLeadHeaderBtn);
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyLogEventBtnIsAvl() {
		Assert.assertTrue(productview.verifyLogEventTest(), "Log Even Btn is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyResfreshSaveRestBtnAvl() {
		Assert.assertEquals(productview.verifyResfreshSaveRestBtnAvlTest(), Constants.shiftLeadSecHeaderBtns);
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyToglleToResticBtnAvl() {
		Assert.assertTrue(productview.verifyToglleToResticBtnAvlTest(),
				"Toggle to restrict movement is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifyTheAvlOfZoomInAndZoomOutBtn() {
		Assert.assertTrue(productview.verifyTheAvlOfZoomInAndZoomOutBtnTest(),
				"Zoom In And Zoom Out Button is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyTheSummaryTableIsAvl() {
		Assert.assertTrue(productview.verifyTheSummaryTableIsAvl(), "Shift summary table is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void taskAvailabilityTest() throws InterruptedException {
		Assert.assertTrue(productview.taskAvailability(), "Task data is not avaialble");
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void verifyTaskTimeInNotStartedState() throws InterruptedException {
		Assert.assertTrue(productview.verifyTaskTimeInNotStartedStateTest(),
				"Task time is not matching in product overview and Shift lead view in idle state");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void startTaskTest() throws InterruptedException {
		productview.taskAvailability();
		Thread.sleep(2000);
		Assert.assertTrue(productview.startTask(), "Task Not started / Task info window is not closed  ");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyTaskStatusPostStartTask() throws InterruptedException {
		productview.taskAvailability();
		Thread.sleep(2000);
		Assert.assertTrue(productview.verifyTaskStatusPostStartTaskTest(),
				"After start task status is not updated to in progress");

	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifyTaskTimePostStartTask() throws InterruptedException {
		Assert.assertTrue(productview.verifyTaskTimePostStartTask(),
				"Task time is not matching in POV and SLV post start task");
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void closeTaskTest() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(productview.methodToFindLastSecTask(), "Task is disapeared after starting the task ");
		Assert.assertTrue(productview.closeTask(), "Task is not closed / Wrong toaster message is displaying ");
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void verifyTaskStatusAfterClose() throws InterruptedException {

		Assert.assertTrue(productview.verifyTaskStatusAfterCloseTest(), "After close task status is not updated ");

	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void verifyTaskTimeAfterClose() throws InterruptedException {
		Assert.assertTrue(productview.verifyTaskTimeAfterCloseTest(),
				"After close task time is not matching with product overview");
	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void restartTask() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(productview.taskAvailability(), "Task is disapaer after close ");
		Assert.assertTrue(productview.restartTaskTest(), "Task is not restarted / wrong toaster message is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyTaskStatusAfterRestart() throws InterruptedException {
		Assert.assertTrue(productview.verifyTaskStatusAfterRestartTest(),
				"After restart task status not updated to in progress");
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifyTaskTimeAfterRestart() throws InterruptedException {
		Assert.assertTrue(productview.verifyTaskTimeAfterRestartTest(),
				"After restart task time is not matching with product overview");
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void resetTask() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(productview.taskAvailability(), "Task is disapaer after Restart ");
		Assert.assertTrue(productview.resetTaskTest(), "Task is not reset / wrong toaster message is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyTaskStatusAfterReset() throws InterruptedException {
		Assert.assertTrue(productview.verifyTaskStatusAfterResetTest(), "Task status is not updated to yet to start ");
	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyTaskTimeAfterReset() throws InterruptedException {
		Assert.assertTrue(productview.verifyTaskTimeAfterResetTest(),
				"After reset task time is not matching with product overview");
	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void startTaskWithDelay() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(productview.taskAvailability(), "Task is disapaer after Reset ");
		Assert.assertTrue(productview.startTaskWithDelayTest(),
				"Task is not Started with log delay / wrong toaster message is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyAlertMsgAfterDelayStart() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(productview.taskAvailability(), "Task is disapaer after Delay Start ");
		Assert.assertTrue(productview.verifyAlertMsgAfterDelayStartTest(),
				"Alert message is not displayed in Shift lead view after delay start");
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifyTaskDurationAfterDelayStartInPOV() throws InterruptedException {
		Assert.assertTrue(productview.verifyTaskDurationAfterDelayStartInPOVTest(),
				"Task time is not matching in product overview after delay start");
	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void closeTaskWithDelay() throws InterruptedException {
		productview.navigateToShiftLeadView();
		Thread.sleep(4000);
		productview.methodToFindLastSecTask();
		Assert.assertTrue(productview.closeTaskWithDelayTest(),
				"Task is not closed with delay / Toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void verifyAlertMsgAfterDelayClose() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(productview.methodToFindLastSecTask(), "Task is disapaer after Delay close ");
		Assert.assertTrue(productview.verifyAlertMsgAfterDelayCloseTest(),
				"Alert message is not displayed in Shift lead view after delay close");

	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void verifyTaskDurationInPOVAfterDelayFinish() throws InterruptedException {
		Assert.assertTrue(productview.verifyTaskDurationInPOVAfterDelayFinishTest(),
				"Task time is not matching in product overview after delay close");
	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void startTaskEarly() throws InterruptedException {
		productview.navigateToShiftLeadView();
		Thread.sleep(4000);
		productview.taskAvailability();
		productview.resetTaskTest();
		productview.taskAvailability();
		Assert.assertTrue(productview.startTaskEarlyTest(),
				"Task is not started with early delay / Toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void verifyAlertMsgAfterEarlyStart() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(productview.taskAvailability(), "Task is disapaer after Early start ");
		Assert.assertTrue(productview.verifyAlertMsgAfterEarlyStartTest(),
				"Alert message is not displayed in Shift lead view after Early start");
	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void verifyTaskDurationInPovAfterEarlyStart() throws InterruptedException {
		Assert.assertTrue(productview.verifyTaskDurationInPovAfterEarlyStartTest(),
				"Task time is not matching in product overview after early start");
	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void closeTaskEarly() throws InterruptedException {
		productview.navigateToShiftLeadView();
		Thread.sleep(4000);
		productview.methodToFindLastSecTask();
		Assert.assertTrue(productview.closeTaskEarlyTest(),
				"Task is not closed with early delay / Toaster message is not displayed ");

	}

	@Test(groups = { "SmokeTest" }, priority = 33)
	public void verifyAlertMsgAfterEarlyClose() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(productview.taskAvailability(), "Task is disapaer after Early close ");
		Assert.assertTrue(productview.verifyAlertMsgAfterEarlyCloseTest(),
				"Alert message is not displayed in Shift lead view after Early close");
	}

	@Test(groups = { "SmokeTest" }, priority = 34)
	public void verifyTaskDurationInPOVAfterEarlyClose() throws InterruptedException {
		Assert.assertTrue(productview.verifyTaskDurationInPOVAfterEarlyCloseTest(),
				"Task time is not matching in product overview after early close");
	}

	@Test(groups = { "SmokeTest" }, priority = 35)
	public void verifyDataValidationPostRefresh() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 36)
	public void verifyUserCanResetTheTaskAfterEarlyClose() throws InterruptedException {
		productview.navigateToShiftLeadView();
		Thread.sleep(4000);
		productview.taskAvailability();
		Assert.assertTrue(productview.resetTaskTest(),
				"Task is not reset after early close / wrong toaster message is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 37)
	public void verifyTheTaskStatusAfterResetTheTaskAfterEarlyClose() throws InterruptedException {
		Assert.assertTrue(productview.verifyTheTaskStatusAfterResetTheTaskAfterEarlyCloseTest(),
				"Task status is not updated to yet to start after reset the task after early close");
	}

	@Test(groups = { "SmokeTest" }, priority = 38)
	public void verifyTheTaskDurationAfterResetTheTaskAfterEarlyClose() throws InterruptedException {
		Assert.assertTrue(productview.verifyTheTaskDurationAfterResetTheTaskAfterEarlyCloseTest(),
				"Task duration is not matching POV after reset the task post early close");
	}

	@Test(groups = { "SmokeTest" }, priority = 39)
	public void assetDown() throws InterruptedException {
		productview.navigateToShiftLeadView();
		Thread.sleep(6000);
		productview.taskAvailability();
		productview.removeExistingAssetDown();
		productview.taskAvailability();
		Assert.assertTrue(productview.assetDownTest(),
				"User is unable to down the asset/ wrong toaster message is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 40)
	public void verifyAvlOfEquipmentDownAlert() throws InterruptedException {
		Assert.assertTrue(productview.verifyAvlOfEquipmentDownAlertTest(),
				"User is unable to see the equipment down alert");
	}

	@Test(groups = { "SmokeTest" }, priority = 41)
	public void verifyTheAvlOfEquipmentDownAlertInPOV() throws InterruptedException {
		Assert.assertTrue(productview.verifyTheAvlOfEquipmentDownAlertInPOVTest(),
				"Equipment down alert is not available in POV screen");
	}

	@Test(groups = { "SmokeTest" }, priority = 42)
	public void verifyDataValidationPostRefresh1() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 43)
	public void verifyUserCanDeleteEquipmentDown() throws InterruptedException {
		productview.navigateToShiftLeadView();
		Thread.sleep(4000);
		Assert.assertTrue(productview.verifyUserCanDeleteEquipmentDownTest(),
				"User is unable to delete equipment down alert");
	}

	@Test(groups = { "SmokeTest" }, priority = 44)
	public void verifyToasterMsgPostEquipmentDownAlertDelete() {
		Assert.assertTrue(productview.verifyToasterMsgPostEquipmentDownAlertTest(),
				"Post equipment down delete alert message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 45)
	public void verifyEquipmentDownAlertInPOVPostEquipmentDownAlertDelete() throws InterruptedException {
		Assert.assertTrue(productview.verifyEquipmentDownAlertInPOVPostEquipmentDownAlertDeleteTest(),
				"User is able to see the equipment down alert after delete");
	}

	@Test(groups = { "SmokeTest" }, priority = 46)
	public void verifyUserCanAddOperator() throws InterruptedException {
		productview.navigateToShiftLeadView();
		Thread.sleep(4000);
		Assert.assertTrue(productview.verifyUserCanAddOperatorTest(),
				"operator alert is not displayed after adding temp operator /unable to add temp op");

	}

	@Test(groups = { "SmokeTest" }, priority = 47)
	public void verifyTemOpAvlInGrid() {
		Assert.assertTrue(productview.verifyTemOpAvlInGridTest(), "Temp operator is not avaialble in grid ");
	}

	@Test(groups = { "SmokeTest" }, priority = 48)
	public void verifyUserCanDeleteTempOp() throws InterruptedException {
		Assert.assertFalse(productview.verifyUserCanDeleteTempOpTest(), "User is unable to delete the temp operator ");
	}

	@Test(groups = { "SmokeTest" }, priority = 49)
	public void verifyFuncOfLogEventBtn() throws InterruptedException {
		Assert.assertTrue(productview.verifyFuncOfLogEventBtnTest(), "User is unable to add log Event ");
	}

	@Test(groups = { "SmokeTest" }, priority = 50)
	public void verifyLogEventIsDisplayed() throws InterruptedException {
		Assert.assertTrue(productview.verifyLogEventIsDisplayedTest(), "Log event is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 51)
	public void verifyUserCanDeleteLogEvent() throws InterruptedException {
		Assert.assertTrue(productview.verifyUserCanDeleteLogEventTest(), "User is unable to delete the log delay");
	}

//	@Test(groups = { "SmokeTest" }, priority = 52)
	public void addSideTask() throws InterruptedException {
		Assert.assertTrue(productview.addSideTaskTest(), "User is unable to add the side task ");
	}

	@Test(groups = { "SmokeTest" }, priority = 53)
	public void verifyUserCanChnageTheAllocatedOpByDrag() throws InterruptedException {
		Assert.assertTrue(productview.verifyUserCanChnageTheAllocatedOpByDragTest(),
				"User is unable to change the operator by drag");
	}

	@Test(groups = { "SmokeTest" }, priority = 54)
	public void verifyShiftLeadCanNavigateToManagerView() throws InterruptedException {
		Assert.assertTrue(productview.verifyShiftLeadCanNavigateToManagerViewTest(),
				"Shift lead is unable to navigate to Manager view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 55)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	// this test case should be called after completing all the test cases
	@Test(groups = { "SmokeTest" }, priority = 57)
	public void deleteConfigureDelayCodeGrp() throws SQLException {
		jdbc.deleteConfigureDelayCode();
	}

}
