package com.qa.bps.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class ManagerViewTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException, IOException {
		System.out.println("------------Manager View Test------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));

		navigateTo.addValueToEventProp();

		navigateTo.LattestPublishedPlan();

		String productName = navigateTo.GetProductDetailsFromPlanner();

		String firstTaskName = navigateTo.findFirstTaskFromPlanner();

		navigateTo.VSB();

		vsbpage.productDetails(productName, firstTaskName);

		pdtoverview.getProductDetails(productName);

		driver.findElement(pdtoverview.homeBtn).click();
		Thread.sleep(2000);
		homepage.navigateToControlTower();
		ctpage.navigateToManager();
		mgr.navigateToProducView();

	}

	@Test(groups = { "SmokeTest" }, priority = 0)
	public void preRequTest() throws InterruptedException, SQLException {
		jdbc.getEquipmentNameFromDB();
		pdtoverview.preReq();
		mgview.findFirstTask();
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifyUserCanNavigateToManagerView() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanNavigateToManagerViewTest(), "User is unable to navigate Manager view ");

	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyNotReqFielAvl() {
		Assert.assertTrue(mgview.verifyNotReqFielAvlTest(), "Not required fieldes are available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifySelectTeamFilterAvlInWeekView() {
		Assert.assertTrue(mgview.verifySelectTeamFilterAvlTest(), "Select Team Drop down is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyTheAvlOfDatePickerInWeekView() {
		Assert.assertTrue(mgview.verifyTheAvlOfDatePickerInWeekViewTest(),
				"week date pciker is not avaialable under week view");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyAvlOfRefreshBtn() {
		Assert.assertTrue(mgview.verifyAvlOfRefreshBtnTest(), "Refresh button is not available under week view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyAvlOfSaveBtn() {
		Assert.assertTrue(mgview.verifyAvlOfSaveBtnTest(), "Save button is not avaialable in manager view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifyAvlOfDayBtn() {
		Assert.assertTrue(mgview.verifyAvlOfDayBtnTest(), "Daya view buttton is not avaialable in manager view");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyAvlOfAlertBtn() {
		Assert.assertTrue(mgview.verifyAvlOfAlertBtnTest(), "Alert button is not available under manager view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void verifyUserCanNavigateToDayView() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanNavigateToDayViewTest(), "user is unable to navigate to day view");
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void verifyDataAvlInManagerView() throws InterruptedException {
		Assert.assertTrue(mgview.verifyDataAvlInManagerViewTest(), "Data is not available in manager view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void verifyAvlOfShiftTypeDDinDayView() throws InterruptedException {
		Assert.assertTrue(mgview.verifyAvlOfShiftTypeDDinDayViewTest(),
				"shift type drop down is not available in day view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyAvlOfDownloadConstraintBtn() {
		Assert.assertTrue(mgview.verifyAvlOfDownloadConstraintBtnTest(),
				"Download constraint button is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifyAvlOfRefreshBtnInDayView() {
		Assert.assertTrue(mgview.verifyAvlOfRefreshBtnInDayViewTest(), "Refresh button is not available in day view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void verifyAvlOfSaveButton() {
		Assert.assertTrue(mgview.verifyAvlOfSaveButtonTest(), "Save button is not available in day view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void verifyAvlOfWeekViewBtnInDayView() {
		Assert.assertTrue(mgview.verifyAvlOfWeekViewBtnInDayViewTest(),
				"Week view button is not available in day view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void verifyAvlOfAlertButtonInDayView() {
		Assert.assertTrue(mgview.verifyAvlOfAlertButtonInDayViewTest(), "Alert button is not available in day view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void verifyAvlOfSideTaskButtonInDayView() throws InterruptedException {
		Assert.assertTrue(mgview.verifyAvlOfSideTaskButtonInDayViewTest(),
				"Side task button is not availaibel in day view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyAvlOfZoomIn() throws InterruptedException {
		Assert.assertTrue(mgview.verifyAvlOfZoomInTest(), "Zoom in button is not available in day view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifyAvlZoomOutBtn() {
		Assert.assertTrue(mgview.verifyAvlZoomOutBtnTest(), "Zoom out button is not available in day view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void verifyAvlOfFullScreenBtn() {
		Assert.assertTrue(mgview.verifyAvlOfFullScreenBtnTest(), "Full Screen button is not available in day view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyShiftTypeInMVAndFc() throws InterruptedException {
		Assert.assertTrue(mgview.verifyShiftTypeInMVAndFcTest(), "Defined shift and displayed shift are wrong ");
	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyUserCanSelectTheShift() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanSelectTheShiftTest(),
				"Shift time in factory calendar and shift time in manager view is not same ");
	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void verifyUserIsAbleToSelectTheTeam() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserIsAbleToSelectTheTeamTest(), "Other team members are displaying ");
	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyUserCanAddTempOperator() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanAddTempOperatorTest(),
				"User is unable to add the temp operator / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifyAvlOfAddedTempOperatorInGrid() throws InterruptedException {
		Assert.assertTrue(mgview.verifyAvlOfAddedTempOperatorInGridTest(),
				"Added Temp Operator is not available in grid");
	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void verifyUserCanDeleteTempOperator() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanDeleteTempOperatorTest(),
				"User is unable to delete the temp operator / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void verifyAvlOfTempOperatorInGridPostDelete() throws InterruptedException {
		Assert.assertTrue(mgview.verifyAvlOfTempOperatorInGridPostDeleteTest(),
				"Temp operator is available in grid post delete");
	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void verifyUserIsAbleToDoOperatorUnAvailableFromLogEvent() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserIsAbleToDoOperatorUnAvailableFromLogEventTest(),
				"User is unable to mark the operator unavailable from log event button");
	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void verifyOperatorUnAvlAlertInGridView() throws InterruptedException {
		Assert.assertTrue(mgview.verifyOperatorUnAvlAlertInGridViewTest(),
				"Unavailability alert is not avaialble in grid");
	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void verifyOperatorUnAvlAlertInLogEventWindow() throws InterruptedException {
		Assert.assertTrue(mgview.verifyOperatorUnAvlAlertInLogEventWindowTest(),
				"Operator Unavailabilty alert is not available in log event window");
	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void verifyUserIsAbleToDeleteOpUnAvlFromGrid() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserIsAbleToDeleteOpUnAvlFromGridTest(),
				"User is unable to delete the operator unavailability from grid / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void verifyUserCanDeleteOpUnAvlFromLogEventWindow() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanDeleteOpUnAvlFromLogEventWindowTest(),
				"User is unable to delete operator unavailaibilty from log event window / Toaster message is not available");
	}

	@Test(groups = { "SmokeTest" }, priority = 33)
	public void verifyOpUnAvlAlertInLogEventPostDelete() throws InterruptedException {
		Assert.assertTrue(mgview.verifyOpUnAvlAlertInLogEventPostDeleteTest(),
				"Operator unavailability alert is not removed post delete in log event window ");
	}

	@Test(groups = { "SmokeTest" }, priority = 34)
	public void verifyUserCanAddEquipmentUnAvlFromLogEvent() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanAddEquipmentUnAvlFromLogEventTest(),
				"User is unable to down the asset / toaster message is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 35)
	public void verifyAvlOfEquipmentDowAlertInLogEvent() throws InterruptedException {
		Assert.assertTrue(mgview.verifyAvlOfEquipmentDowAlertInLogEventTest(),
				"Equipment down alert is not available in log event tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 36)
	public void verifyUserCanDeleteEquipmentDownAlert() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanDeleteEquipmentDownAlertTest(),
				"User is unable to delete the equipment down alerts / wrong toaster message is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 37)
	public void verifyTheAvlOfEquipmentDownAlertInLogEventPostDelete() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTheAvlOfEquipmentDownAlertInLogEventPostDeleteTest(),
				"Equipment down alert is not removed from log event post delete");
	}

	@Test(groups = { "SmokeTest" }, priority = 38)
	public void verifyUserIsAbleToAddAlert() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserIsAbleToAddAlertTest(), "User is unable to add the alert ");
	}

	@Test(groups = { "SmokeTest" }, priority = 39)
	public void verifyAvlOfAddedAlert() throws InterruptedException {
		Assert.assertTrue(mgview.verifyAvlOfAddedAlertTest(), "added Alert is not available in alert tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 40)
	public void verifyTheAvlOfAddedAlertInWeekViewAlertTab() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTheAvlOfAddedAlertInWeekViewAlertTabTest(),
				"added alert is not avaialble in week view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 41)
	public void verifyAlertMsgAvlInDataBase() throws SQLException {
		Assert.assertTrue(mgview.verifyAlertMsgAvlInDataBaseTest(),
				"Added alert in manager view and DB is not matching");
	}

	@Test(groups = { "SmokeTest" }, priority = 42)
	public void verifyUserCanDeleteAddedAlert() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanDeleteAddedAlertTest(), "Unable to delete the alert message");
	}

	@Test(groups = { "SmokeTest" }, priority = 43)
	public void verifyTheAvlOfAlertPostDelete() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTheAvlOfAlertPostDeleteTest(),
				"Alert is not removed from alert tab post delete ");
	}

	@Test(groups = { "SmokeTest" }, priority = 44)
	public void verifyAvlOfDeletedAlertInWeekView() throws InterruptedException {
		Assert.assertTrue(mgview.verifyAvlOfDeletedAlertInWeekViewTest(), "Deleted alert is available in week view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 45)
	public void verifyUserCanAddSideTask() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanAddSideTaskTest(), "User is unable to add the side task");
	}

	@Test(groups = { "SmokeTest" }, priority = 46)
	public void verifyAvlOfAddedSideTask() throws InterruptedException {
		Assert.assertTrue(mgview.verifyAvlOfAddedSideTaskTest(), "Side task is not avaialble in grid");
	}

	@Test(groups = { "SmokeTest" }, priority = 47)
	public void verifyTheAvlOfSideTaskButtonWithoutSelectingShift() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTheAvlOfSideTaskButtonWithoutSelectingShiftTest(),
				"Side task is available without selecting shift");
	}

	@Test(groups = { "SmokeTest" }, priority = 48)
	public void verifyTheAvlOfAddOperatorButtonWithoutSelectingShift() {
		Assert.assertTrue(mgview.verifyTheAvlOfAddOperatorButtonWithoutSelectingShiftTest(),
				"Add operator button is displaying without selecting shift");
	}

	@Test(groups = { "SmokeTest" }, priority = 49)
	public void verifyShiftTimeAfterChangingSideTaskDuration() throws InterruptedException {
		Assert.assertTrue(mgview.verifyShiftTimeAfterChangingSideTaskDurationTest(),
				"After Save Shift time is chnaged ");
	}

	@Test(groups = { "SmokeTest" }, priority = 50)
	public void verifyAvlOfSideTaskInVSB() throws InterruptedException {
		Assert.assertTrue(mgview.verifyAvlOfSideTaskInVSBTest(), "Added side task is not avaialble in VSB ");
	}

	@Test(groups = { "SmokeTest" }, priority = 52)
	public void verifySideTaskTimeAfterDragInMV() throws InterruptedException {
		Assert.assertTrue(mgview.verifySideTaskTimeAfterDragInMVTest(), "User is unable to drag the side task");
	}

	@Test(groups = { "SmokeTest" }, priority = 54)
	public void verifySideTaskTimeAfterDragInVSB() throws InterruptedException {
		Assert.assertTrue(mgview.verifySideTaskTimeAfterDragInVSBTest(), "Side task time in MV and VSB is not same");
	}

	@Test(groups = { "SmokeTest" }, priority = 55)
	public void verifyUserCanDeleteSideTask() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanDeleteSideTaskTest(), "User is unable to delete side task");
	}

	@Test(groups = { "SmokeTest" }, priority = 56)
	public void verifyTheOperatorAllocationInProductOverview() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTheOperatorAllocationInProductOverviewTest(),
				"Allocated operator in manager view and product overview is not matching");
	}

	@Test(groups = { "SmokeTest" }, priority = 57)
	public void verifyUserCanChangeTheTaskDurationByDrag() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanChangeTheTaskDurationTest(), "User is unable to drag the task");
	}

	@Test(groups = { "SmokeTest" }, priority = 58)
	public void verifyTaskDurationInManagerViewPostDrag() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTaskDurationInManagerViewPostDragTest(),
				"Task Duration is same in manager view after drag and before drag");
	}

	@Test(groups = { "SmokeTest" }, priority = 59)
	public void verifyTaskDurationInProductOverviewAfterDrag() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTaskDurationInProductOverviewAfterDragTest(),
				"First task start time and end time of Mv not matched with first task start time and end time of pov post drag the task");
	}

	@Test(groups = { "SmokeTest" }, priority = 60)
	public void verifyTheTaskDurationInVSBAfterDrag() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTheTaskDurationInVSBAfterDragTest(),
				"First task start time and end time of Mv not matched with first task start time and end time of VSb post drag the task");
	}

	@Test(groups = { "SmokeTest" }, priority = 61)
	public void verifyDataValidationPostRefresh() {
		driver.navigate().refresh();
	}

	@Test(groups = { "SmokeTest" }, priority = 63)
	public void verifyUserCanChangeTheTaskDurationFromDatePicker() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanChangeTheTaskDurationFromDatePickerTest(),
				"User is unable to change the task duration by date picker");
	}

	@Test(groups = { "SmokeTest" }, priority = 64)
	public void verifyTaskDurationInManagerViewAfterDurationChangeByDatePicker() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTaskDurationInManagerViewAfterDurationChangeTest(),
				"Task Duration is same in manager view after duration change by date picker is same");
	}

	@Test(groups = { "SmokeTest" }, priority = 65)
	public void verifyDataValidationPostRefresh2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 66)
	public void verifyTaskDurationInPOVAfterDurationChangeByDatePicker() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTaskDurationInPOVAfterDurationChangeByDatePickerTest(),
				"First task start time and end time of Mv not matched with first task start time and end time of pov post duration change of task by date picker");
	}

	@Test(groups = { "SmokeTest" }, priority = 67)
	public void verifyTaskDurationInVSBAfterDurationChangeByDatePicker() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTaskDurationInVSBAfterDurationChangeByDatePickerTest(),
				"First task start time and end time of Mv not matched with first task start time and end time of VSb post duration change of task By date picker");
	}

	@Test(groups = { "SmokeTest" }, priority = 69)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 69)
	public void verifyTheTaskDurationInVSBPostStartPostDurationChnageFromMV() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTheTaskDurationInVSBPostStartPostDurationChnageFromMVTest(),
				"Post Start the task , task duration is changed to planed task duration");
	}

	@Test(groups = { "SmokeTest" }, priority = 70)
	public void verifyTheTaskDurationInVSBPostClosePostDurationChnageFromMV() throws InterruptedException {
		Assert.assertTrue(mgview.verifyTheTaskDurationInVSBPostClosePostDurationChnageFromMVTest(),
				"Post Close the task , task duration is changed to planed task duration");
	}

	@Test(groups = { "SmokeTest" }, priority = 71)
	public void verifyUserCanStartTheTaskWithLogDelayPostDurationChnageFromMV() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanStartTheTaskWithLogDelayPostDurationChnageFromMVTest(),
				"User is unable to reset the task post duration change from Mv/ toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 72)
	public void verifyUserCanRefreshThePageInDayView() throws InterruptedException {
		Assert.assertTrue(mgview.verifyUserCanRefreshThePageInDayViewTest(), "Refresh button is not working ");
	}

}
