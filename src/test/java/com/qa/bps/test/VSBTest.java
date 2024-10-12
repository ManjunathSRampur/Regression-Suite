package com.qa.bps.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.sql.SQLException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.qa.bps.pages.EventProperties;
import com.qa.bps.pages.JDBC;
import com.qa.bps.utils.Constants;

public class VSBTest extends BaseTest {
	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("----------VSB test page-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		Thread.sleep(2000);
		System.out.println("task group level " + EventProperties.actionLevel);
		if (EventProperties.actionLevel.equalsIgnoreCase("Task Group")) {
			System.out.println("inside task group xpath reinitilization");
			vsbpage.xpathReinitilization();
		}
	}

//	@Test(groups = { "SmokeTest" }, priority = -1)
	public void tosterValidateTest() {
		Assert.assertTrue(vsbpage.tosterValidate());
	}

	@Test(groups = { "SmokeTest" }, priority = 0)
	public void productDetailsTest() throws InterruptedException, SQLException {
		jdbc.configureDelayCodeGrp();
		navigateTo.LattestPublishedPlan();

		String productName = navigateTo.GetProductDetailsFromPlanner();

		String firstTaskName = navigateTo.findFirstTaskFromPlanner();

		navigateTo.addValueToEventProp();

		navigateTo.VSB();

		vsbpage.productDetails(productName, firstTaskName);

		jdbc.getEquipmentNameFromDB();
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void mousehoverontaskTest() throws InterruptedException, ParseException {
		Assert.assertTrue(vsbpage.mousehoverontask());

	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void fieldsNamesTest() throws InterruptedException {
		homepage.navigateToVSB();
		Assert.assertEquals(vsbpage.checkVSBFieldsNames(), Constants.EXPECTED_VSB_FIELDS_NAMES,
				"VSB fields names are not matching/available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void testSideButtonExist() {

		Assert.assertTrue(vsbpage.sidetaskButton(), "sidetask button doesnt exists");

	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void testFilterButtonExist() {

		Assert.assertTrue(vsbpage.filterButton(), "Filter button doesnt exists");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void testmovebatchButtonExist() {

		Assert.assertTrue(vsbpage.moveBatchButton(), "Move Batch  button doesnt exists");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void testDayViewDDExist() {
		Assert.assertTrue(vsbpage.DayviewDD(), "Day view drop down doesnt exists");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void selectDate() throws InterruptedException {

		Assert.assertTrue(vsbpage.SelectPlanDate(), "No data avaialable on this Date");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void starttask() throws InterruptedException {

		Assert.assertTrue(vsbpage.clickonstartTask(), "Task started successfully");

	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void startTaskStatusInProductOverview() throws InterruptedException {

		Assert.assertTrue(vsbpage.taskStartedInProductOverview());

	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void navigateHp1() throws InterruptedException {
		homepage.navigateToVSB();
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void completeTsk() throws InterruptedException {
		Assert.assertTrue(vsbpage.completeTsk());
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void navigateHp2() throws InterruptedException {
		homepage.navigateToVSB();
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void ValidateTaskClosure() throws InterruptedException {
		Assert.assertTrue(vsbpage.ValidateTaskClosure());

	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void restartTask() throws InterruptedException {
		Assert.assertTrue(vsbpage.restartTask());

	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void navigateHp3() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		navigateTo.VSB();
	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void resetTaskTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.resettask());
	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void testtaskStatusInProductOVPostReset() throws InterruptedException {
		Assert.assertTrue(vsbpage.taskStatusInProductOVPostReset());

	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void navigateHp4() throws InterruptedException {
		homepage.navigateToVSB();
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void notStartedStateTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.notStartedState());
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void inProgresStateTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.inProgresState());
	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void completeStateTest() throws InterruptedException {
		vsbpage.completeState();
	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void postRestartStatusTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.postRestartStatus());
	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void postResetStatusTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.postResetStatus());
	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void assetDownTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.assetDown(), "unable to do the asset status down ");
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void assetAlertInVsbTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.assetAlertInVsb(), "Asset down alert message is not displayed in VSB ");
	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void assetAlertInPovTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.assetAlertInPov(), "Asset down alert message is not displayed in Product Overview ");
	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void deleteAddedEq() throws InterruptedException {
		homepage.navigateToVSB();
		Thread.sleep(8000);
		System.out.println("navigated to vsb for test case 27");
		Assert.assertTrue(vsbpage.deleteAddedEqTest());
	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void delayStartTest() throws InterruptedException {

		Assert.assertTrue(vsbpage.delayStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void delayStartValInVsbTest() {
		Assert.assertTrue(vsbpage.delayStartValInVsb());
	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void delayStartValInPovTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.delayStartValInPov());
	}

////	@Test(groups = { "SmokeTest" }, priority = 33)
	public void filterFunctionalityTest() throws InterruptedException {
		Thread.sleep(2000);
		homepage.navigateToVSB();
		Thread.sleep(8000);
		System.out.println("Navigated to VSB");
		Assert.assertTrue(vsbpage.filterFunctionality());

	}

////	@Test(groups = { "SmokeTest" }, priority = 34)
	public void resetFilterTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.resetFilter());
	}

	@Test(groups = { "SmokeTest" }, priority = 35)
	public void taskStartAndEnddateSyncOnInProgressStateTest() throws InterruptedException, ParseException {
		Thread.sleep(2000);
		homepage.navigateToVSB();
		Assert.assertTrue(vsbpage.taskStartAndEnddateSyncOnInProgressState());
	}

	@Test(groups = { "SmokeTest" }, priority = 36)
	public void taskStartAndEnddateSyncOnCloseStateTest() throws InterruptedException, ParseException {
		homepage.navigateToVSB();
		Thread.sleep(8000);
		System.out.println("Navigated to VSB");
		Assert.assertTrue(vsbpage.taskStartAndEnddateSyncOnCloseState());
	}

	@Test(groups = { "SmokeTest" }, priority = 37)
	public void taskStartAndEnddateSyncOnDelayStartStateTest() throws InterruptedException, ParseException {
		homepage.navigateToVSB();
		Thread.sleep(10000);
		System.out.println("Navigated to VSB");
		Assert.assertTrue(vsbpage.taskStartAndEnddateSyncOnDelayStartState());
	}

	@Test(groups = { "SmokeTest" }, priority = 38)
	public void taskStartAndEnddateSyncOnDelayCloseStateTest() throws InterruptedException, ParseException {
		homepage.navigateToVSB();
		Thread.sleep(10000);
		System.out.println("Navigated to VSB");
		Assert.assertTrue(vsbpage.taskStartAndEnddateSyncOnDelayCloseState());
		homepage.navigateToVSB();
		Thread.sleep(10000);
	}

	@Test(groups = { "SmokeTest" }, priority = 39)
	public void taskResetFuncInNormalStartTest() throws InterruptedException {

		Assert.assertTrue(vsbpage.taskResetFuncInNormalStart(),
				"expected task details are not matched with actual task details hence reset functionality is failed in normal start  ");

	}

	@Test(groups = { "SmokeTest" }, priority = 40)
	public void taskResetFuncInNormalCloseTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.taskResetFuncInNormalClose(),
				"expected task details are not matched with actual task details hence reset functionality is failed in normal close ");

	}

	@Test(groups = { "SmokeTest" }, priority = 41)
	public void taskResetFuncInDelayStartTest() throws InterruptedException {

		Assert.assertTrue(vsbpage.taskResetFuncInDelayStart(),
				"expected task details are not matched with actual task details hence reset functionality is failed in delay start  ");

	}

	@Test(groups = { "SmokeTest" }, priority = 42)
	public void taskResetFuncInDelayCloseTest() throws InterruptedException {

		Assert.assertTrue(vsbpage.taskResetFuncInDelayClose(),
				"expected task details are not matched with actual task details hence reset functionality is failed in delay close  ");

	}

	@Test(groups = { "SmokeTest" }, priority = 43)

	public void restartFuncInNormalStartTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.restartFuncInNormalStart(),
				"Expected task details are not matched with actual task details hence Restart functionality with normal start and normal close is failed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 44)
	public void restartFuncInDelayStartTest() throws InterruptedException {

		Assert.assertTrue(vsbpage.restartFuncInDelayStart(),
				"Expected task details are not matched with actual task details hence Restart functionality with Delay start and normal close is failed ");

	}

	@Test(groups = { "SmokeTest" }, priority = 45)
	public void restartFuncInDelayCloseTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.restartFuncInDelayClose(),
				"Expected task details are not matched with actual task details hence Restart functionality with normal start and Delay close is failed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 46)
	public void nextTaskTimeUpdWithDelayStartTest() throws InterruptedException {

		Assert.assertTrue(vsbpage.nextTaskTimeUpdWithDelayStart(),
				"Next Task is not moving foraward After Delay Start");
	}

	@Test(groups = { "SmokeTest" }, priority = 47)
	public void nextTaskTimeUpdAfterResetForDelayStartTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.nextTaskTimeUpdAfterReset(),
				"Task is not moving backward after reset in delay start");
	}

	@Test(groups = { "SmokeTest" }, priority = 48)
	public void nextTaskTimeUpdWithDelayCloseTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.nextTaskTimeUpdWithDelayClose(),
				"Next Task is not moving foraward after delay close ");
	}

	@Test(groups = { "SmokeTest" }, priority = 49)
	public void nextTaskTimeUpdAfterResetForDelayCloseTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.nextTaskTimeUpdAfterReset(),
				"Task is not moving backward after reset in delay close");
	}

	@Test(groups = { "SmokeTest" }, priority = 50)
	public void nextTaskTimeUpdWithEarlyStartTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.nextTaskTimeUpdWithEarlyStart(),
				"Next Task is not moving backward After early start");
	}

	@Test(groups = { "SmokeTest" }, priority = 51)
	public void nextTaskTimeUpdAfterResetForEarlyStartTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.nextTaskTimeUpdAfterReset(), "Task is not moving forward after reset in early start");
	}

	@Test(groups = { "SmokeTest" }, priority = 52)
	public void nextTaskTimeUpdWithEarlyCloseTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.nextTaskTimeUpdWithEarlyClose(),
				"Next Task is not moving backward After early close");
	}

	@Test(groups = { "SmokeTest" }, priority = 53)
	public void nextTaskTimeUpdAfterResetForEarlyCloseTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.nextTaskTimeUpdAfterReset(), "Task is not moving forward after reset in early close");
	}

	@Test(groups = { "SmokeTest" }, priority = 54)
	public void dragTaskForwardTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.dragTaskForward(), "Unable to drag the task forward ");
	}

	@Test(groups = { "SmokeTest" }, priority = 55)
	public void addSideTaskTestT() throws InterruptedException {
		Thread.sleep(8000);
		System.out.println("navigated to vsb for test case 27");
		Assert.assertTrue(vsbpage.addSideTask(), "User is unable to add side task");
	}

	@Test(groups = { "SmokeTest" }, priority = 56)
	public void sideTaskAvlTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.sideTaskAvl(), "Side Task is not avaialble ");
	}

	@Test(groups = { "SmokeTest" }, priority = 57)
	public void verifyUserCanAddCmtInSideTask() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanAddCmtInSideTaskTest(),
				"User is unable to add the comment in side task");
	}

	@Test(groups = { "SmokeTest" }, priority = 58)
	public void deleteSideTaskTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.deleteSideTask(), "User is unable to delete the side task ");
	}

	@Test(groups = { "SmokeTest" }, priority = 60)
	public void verifyFuncOfShowMOCBtn() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyFuncOfShowMOCBtnTest(), "After clicking on show moc data is not displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 61)
	public void verifyFirstTaskNameInENGLang() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyFirstTaskNameInENGLangTest(), "first task name is in native language");
	}

	@Test(groups = { "SmokeTest" }, priority = 62)
	public void verifyTheFuncOfZoomIn() throws InterruptedException {

		Assert.assertTrue(vsbpage.verifyTheFuncOfZoomInTest(), "User is unable to zoom in ");
	}

	@Test(groups = { "SmokeTest" }, priority = 63)
	public void verifyTheFuncOfZoomOut() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyTheFuncOfZoomOutTest(), "User is unable to zoom out");
	}

	@Test(groups = { "SmokeTest" }, priority = 64)
	public void verifyAlertNotificationInIdleState() {
		Assert.assertTrue(vsbpage.verifyAlertNotificationInIdleStateTest(),
				"Alert notification is displayed in idle state hence test case is failed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 65)
	public void verifyResetFuncAfterDelayStartAndNormalClose() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyResetFuncAfterDelayStartAndNormalCloseTest(),
				"User is unable to reset the task after delay start and normal close/Time is not reseted ");
	}

	@Test(groups = { "SmokeTest" }, priority = 66)
	public void verifyUserCanStartTheTaskAfterDrag() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanStartTheTaskAfterDragTest(),
				"User is unable to start the task after drag/wrong toaster message is displaying ");
	}

	@Test(groups = { "SmokeTest" }, priority = 67)
	public void verifyUserCanCloseTheTaskAfterDrag() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanCloseTheTaskAfterDragTest(),
				"User is unable to close the task after drag/wrong toaster message is displaying ");
	}

	@Test(groups = { "SmokeTest" }, priority = 68)
	public void verifyRestartFunctionalityAfterDrag() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyRestartFunctionalityAfterDragTest(),
				"User is unable to restart the task / task time is not matched ");
	}

	@Test(groups = { "SmokeTest" }, priority = 69)
	public void verifyResetFunctionalityAfterDrag() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyResetFunctionalityAfterDragTest(),
				"User is unable to reset the task/ task time is not reseted ");
	}

	@Test(groups = { "SmokeTest" }, priority = 70)
	public void verifyResetFunctionalityWithNormalStartAndDelayFinish() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyResetFunctionalityWithNormalStartAndDelayFinishTest(),
				"User is unable to reset the task with normal start and delay close / task time is not updated ");
	}

	@Test(groups = { "SmokeTest" }, priority = 71)
	public void verifyUserCanCloseTheTaskByDrag() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanCloseTheTaskByDragTest(),
				"User is unable to close the task By drag /toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 72)
	public void verifyRestartFuncAfterDelayCloseByDrag() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyRestartFuncAfterDelayCloseByDragTest(),
				"User is unable to restart the task after delay close by drag / time is not reseted ");
	}

	@Test(groups = { "SmokeTest" }, priority = 73)
	public void verifyResetFuncAfterDelayCloseByDrag() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyResetFuncAfterDelayCloseByDragTest(),
				"User is unable to reset the task after delay close by drag / time is not reseted ");
	}

	@Test(groups = { "SmokeTest" }, priority = 74)
	public void verifyUserCanCloseTaskEarly() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanCloseTaskEarlyTest(),
				"User is unable to close the task early / Toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 75)
	public void verifyRestartFuncAfterEarlyClose() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyRestartFuncAfterEarlyCloseTest(),
				"User is unable to restart the task after early close / Expected task and actual task time is not matched ");
	}

	@Test(groups = { "SmokeTest" }, priority = 76)
	public void verifyResetFuncAfterEarlyClose() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyResetFuncAfterEarlyCloseTest(),
				"User is unable to reset the task / task time is not reseted ");
	}

	@Test(groups = { "SmokeTest" }, priority = 77)
	public void verifyUserCanExtendTheTaskDuration() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanExtendTheTaskDurationTest(),
				"User is unable to extend the task duration / Toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 78)
	public void verifyAlertMessagPostDurationChnage() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyAlertMessagPostDurationChnageTest(),
				"Post duration change alert message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 79)
	public void verifyUserCanStartTheTaskPostDurationChnage() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanStartTheTaskPostDurationChnageTest(),
				"User is unable to start the task / Toaster message is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 80)
	public void verifyUserCanCloseTheTaskPostDurationChnage() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanCloseTheTaskPostDurationChnageTest(),
				"User is unable to close the task / Toaster message is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 81)
	public void verifyUserCanRestartTheTaskPostDurationChnage() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanRestartTheTaskPostDurationChnageTest(),
				"User is unable to restart the task / Toaster message is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 82)
	public void verifyUserCanResetTheTaskPostDurationChnage() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanResetTheTaskPostDurationChnageTest(),
				"User is unable to reset the task / Toaster message is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 83)
	public void verifyUserCanStartTheTaskWithDelayPostDurationChange() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanStartTheTaskWithDelayPostDurationChangeTest(),
				"User is unable to start the task with delay / Toaster message is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 84)
	public void verifyUserCanCloseTheTaskWithDelayPostDurationChange() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanCloseTheTaskWithDelayPostDurationChangeTest(),
				"User is unable to close the task with delay / Toaster message is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 85)
	public void verifyUserCanResetTheTaskPostDelayStartAndDelayClose() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanResetTheTaskPostDelayStartAndDelayCloseTest(),
				"User is unable to reset the task / Toaster message is not displayed post delay start and delay close");
	}

	@Test(groups = { "SmokeTest" }, priority = 86)
	public void verifyUserCanStartTheTaskEarlyPostDurationChange() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanStartTheTaskEarlyPostDurationChangeTest(),
				"User is unable to start the task early / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 87)
	public void verifyUserCanCloseTheTaskEarlyPostDurationChange() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanCloseTheTaskEarlyPostDurationChangeTest(),
				"User is unable to close the task early / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 88)
	public void verifyUserCanResetTheTaskPostEarlyStartAndClose() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanResetTheTaskPostEarlyStartAndCloseTest(),
				"User is unable to reset the task  / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 89)
	public void verifyDragFrwdAndBacaward() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyDragFrwdAndBacawardTest(),
				"user is unable to do drag farwad and backward / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 90)
	public void verifyUserCanStartPostDragBackward() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanStartPostDragBackwardTest(),
				"User is unable to start the task/ Toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 91)
	public void verifyUserCanEditLogDelay() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanEditLogDelayTest(), "User is unable to add the comment ");
	}

	@Test(groups = { "SmokeTest" }, priority = 92)
	public void verifyUserCanSeePlanedTaskAfterClickingOnBasePlanTrue() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanSeePlanedTaskAfterClickingOnBasePlanTest(),
				"Planed task details are not displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 93)
	public void verifyUserCanSeePlannedTaskAfterClickingOnBasePlanFalse() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanSeePlannedTaskAfterClickingOnBasePlanFalseTest(),
				"Planned task displaying after unchecking the base plan input ");
	}

	@Test(groups = { "SmokeTest" }, priority = 94)
	public void logEventFuncForEqDown() throws InterruptedException {
		Assert.assertTrue(vsbpage.logEventFuncForEqDownTest(),
				"user is unable to do eqUnAvl from log event / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 95)
	public void verifyUserCanDeleteEqDownFromLogEvent() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanDeleteEqDownFromLogEventTest(),
				"user is unable to delete eq UnAvl / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 96)
	public void verifyUserCanEditTheAssetDownLogByAddingEndDate() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanEditTheAssetDownLogByAddingEndDateTest(),
				"User is unable to edit the equnavl by adding to date");
	}

	@Test(groups = { "SmokeTest" }, priority = 97)
	public void deleteEqDownFromAlert() throws InterruptedException {
		vsbpage.deleteEqDownFromAlertTest();
	}

	@Test(groups = { "SmokeTest" }, priority = 98)
	public void verifyAvlailabilityOfDelayAlertPostDragAndDropAndDelayStart() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyAvlailabilityOfDelayAlertPostDragAndDropAndDelayStartTest(),
				"After adding the delay by Drag And Drop , if user start the task with delay , log delay alert has disappeared");
	}

// this test case should be called after completing all the test cases 
	@Test(groups = { "SmokeTest" }, priority = 99)
	public void deleteConfigureDelayCodeGrp() throws SQLException {
		jdbc.deleteConfigureDelayCode();
	}

//	@Test(groups = { "SmokeTest" }, priority = 98)
	public void verifyUserCanTakeActionOnSideTaskPostClose() throws InterruptedException {
		Assert.assertTrue(vsbpage.verifyUserCanTakeActionOnSideTaskPostCloseTest(),
				"User can able to take action on side task after close");
	}

	// --- @Test(groups = { "SmokeTest" }, priority = 94)
	public void verifyUserCanDoEquipmentDownByAddingFromAndToDate() throws InterruptedException {
		vsbpage.verifyUserCanDoEquipmentDownByAddingFromAndToDateTest();
	}

//--------------------------------In-Progress--------------------------

//	@Test(groups = { "SmokeTest" }, priority = 55)
	public void triggerEnRAfterDragTest() throws InterruptedException {
		Assert.assertTrue(vsbpage.triggerEnRAfterDrag(), "Unable to trigger the EnR/batches are not scheduled ");
	}

//	@Test(groups = { "SmokeTest" }, priority = 56)
	public void checkTaskTimingAfterEnRTest() throws InterruptedException {
		driver.findElement(vsbpage.homepage).click();
		homepage.navigateToVSB();
		Assert.assertTrue(vsbpage.checkTaskTimingAfterEnR(),
				"After Drag Start time and End timem is not matched with after EnR trigger start time and end time");
	}

}
