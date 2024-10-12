package com.qa.bps.test;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.pages.EventProperties;
import com.qa.bps.pages.VSBpage;
import com.qa.bps.utils.Constants;

public class ProductOverviewTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		driver.navigate().refresh();
		Thread.sleep(4000);
		ctpage = homepage.navigateToControlTower();
		mgr = ctpage.navigateToManager();
		productview = mgr.navigateToProducView();
		System.out.println("--------ProductOverView Test-------------");

		if (EventProperties.actionLevel.equals("Task Group")) {
			pdtoverview.xpathReinitialization();
		}
	}

	@Test(groups = { "SmokeTest" }, priority = -2)
	public void getProductDetailsTest() throws InterruptedException, IOException, SQLException {
		jdbc.configureDelayCodeGrp();
		Thread.sleep(2000);
		driver.findElement(pdtoverview.homeBtn).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		navigateTo.addValueToEventProp();
		navigateTo.LattestPublishedPlan();
		String productName = navigateTo.GetProductDetailsFromPlanner();
		pdtoverview.getProductDetails(productName);
		driver.findElement(pdtoverview.homeBtn).click();
		Thread.sleep(2000);
		homepage.navigateToControlTower();
		ctpage.navigateToManager();
		mgr.navigateToProducView();
		jdbc.getEquipmentNameFromDB();
	}

	@Test(groups = { "SmokeTest" }, priority = -1)
	public void tosterValidateTest() {
		Assert.assertTrue(vsbpage.tosterValidate());
	}

	@Test(groups = { "SmokeTest" }, priority = 0)
	public void preReqTest() throws InterruptedException {
		pdtoverview.preReq();
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void taskAndTGSyncInNotstartedStateTest() throws InterruptedException {
		Assert.assertTrue(pdtoverview.taskAndTGSyncInNotstartedState());
		Thread.sleep(2000);
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void taskAndTGSyncInInprogressStateTest() throws InterruptedException {
		Assert.assertTrue(pdtoverview.taskAndTGSyncInInprogressState());
		Thread.sleep(2000);
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void taskAndTGsynInCloseStateTest() throws InterruptedException {
		Assert.assertTrue(pdtoverview.taskAndTGsynInCloseState());
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void taskAndTGsynInDelayStartStateTest() throws InterruptedException {
		Assert.assertTrue(pdtoverview.taskAndTGsynInDelayStartState());
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void taskAndTGsynInDelayCloseStateTest() throws InterruptedException {
		Assert.assertTrue(pdtoverview.taskAndTGsynInDelayCloseState());
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void taskResetTest() throws InterruptedException {
		Assert.assertTrue(pdtoverview.taskReset(), "Task is not reset/task time is not reseted ");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void getTaskStatus() throws InterruptedException {

		Assert.assertTrue(pdtoverview.taskStatus());

	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void resetToasterisDisplayed() throws InterruptedException {
		Assert.assertTrue(pdtoverview.resetToasterisDisplayed());
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void statusValidatePostReset() throws InterruptedException {
		Assert.assertTrue(pdtoverview.statusValidatePostReset());
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void taskGrpStatusValdtn() throws InterruptedException {
		Assert.assertTrue(pdtoverview.taskGrpStatusValdtnPostReset());
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void delayValidationpostReset() throws InterruptedException {
		Assert.assertTrue(pdtoverview.delayValidationinTgAfterStart());

	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void delayDurationValOnTGpostReset() throws InterruptedException {
		Assert.assertTrue(pdtoverview.delayDurationValOnTGpostReset());
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void delayedfinishDelayValidationonTg() throws InterruptedException {
		Assert.assertTrue(pdtoverview.delayDurationValOnTGDelayedfinish());
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void verifyUserCanStartTaskEarly() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyUserCanStartTaskEarlyTest(),
				"User is unable to start the task early/ wrong toaster message is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void verifyLogDelayAlertAfterEarlyStart() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyLogDelayAlertAfterEarlyStartTest(), "Early start alert is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void verifyUserCanResetPostEarlyStart() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyUserCanResetPostEarlyStartTest(),
				"User is unable to reset the task post early start/ toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void verifyUserCanCloseTheTaskEarly() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyUserCanCloseTheTaskEarlyTest(),
				"User is unable to close the task early / toatser message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyAlertMsgPostEarlyClose() {
		Assert.assertTrue(pdtoverview.verifyAlertMsgPostEarlyCloseTest(), "Early close alert is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifyUserCanRestartTheTask() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(pdtoverview.verifyUserCanRestartTheTaskTest(), "User is unable to restart the task");
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void verifyUserCanDownTheAsset() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyUserCanDownTheAssetTest(),
				"User is unable to down the asset / Wrong alert message is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyAssetAlertAvlPostAssetDown() {
		Assert.assertTrue(pdtoverview.verifyAssetAlertAvlPostAssetDownTest(),
				"Asset down alert is not displayed after asset down");
	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyEqUnAvlAlertInBellIcon() {
		pdtoverview.verifyEqUnAvlAlertInBellIconTest();
	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void verifyUserCanDeleteAssetDown() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyUserCanDeleteAssetDownTest(), "Asset alert is displayed after delete ");
	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyUserCanDoOpUnAvl() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyUserCanDoOpUnAvlTest(), "User is unable to mark operator unavailable ");
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifyOpUnAvlAlertAvl() {
		Assert.assertTrue(pdtoverview.verifyOpUnAvlAlertAvlTest(), "Opertaor unavailability alert is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void opUnAvlAlertInBellIcon() {
		Assert.assertTrue(pdtoverview.opUnAvlAlertInBellIconTest(),
				"Operator unavailable alert is not displayed in notifcation");
	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void verifyUserCanDeleteOpUnAvl() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyUserCanDeleteOpUnAvlTest(),
				"User is unable to delete the operator unavailability");
	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void verifyTaskEquipmentAlocInPlannerTab() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyTaskEqAlocInPlannerTabTest(),
				"Equipment name are not same in planner and POV");
	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void editLogDelay() throws InterruptedException {
		Assert.assertTrue(pdtoverview.editLogDelayTest(), "User is unable to edit the log delay ");
	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void verifyLogDelayAlertInBellIcon() {
		Assert.assertTrue(pdtoverview.verifyLogDelayAlertInBellIconTest(),
				"log delay alert is not displayed in notification icon");
	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void verifyTGColourIndicationAfterEarlyStart() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyTGColourIndicationAfterEarlyStartTest(),
				"After early start colour code is not accepted ");
	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void verifyToasterMSGWhileEditingOperatorUnAvlAlert() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyToasterMSGWhileEditingOperatorUnAvlAlertTest(),
				"User is unabel to edit operator unavaialbility / wrong toaster message is displaying / no toaster is available");
	}

	@Test(groups = { "SmokeTest" }, priority = 33)
	public void verifyAvalabilityOfAddedComment() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyAvalabilityOfAddedCommentTest(),
				"Added Comment is not available under Operator Unavaialbe window");
	}

	@Test(groups = { "SmokeTest" }, priority = 34)
	public void verifyUserCanDeleteOpUnAvlAfterAddingComment() throws InterruptedException {
		Assert.assertTrue(pdtoverview.verifyUserCanDeleteOpUnAvlTest(),
				"User is unable to delete the operator unavailability");
	}
	
	
	
	
	
	
	
	
	

//	 this test case should be called after completing all the test cases
	@Test(groups = { "SmokeTest" }, priority = 65)
	public void deleteConfigureDelayCodeGrp() throws SQLException {
		jdbc.deleteConfigureDelayCode();
	}

//	 write the test case above this line
//	 ---------------------------------------------------------------------

//	@Test(groups = { "SmokeTest" }, priority = 7)
	public void enRTestWithDelay() throws InterruptedException {
		Assert.assertTrue(pdtoverview.enR(), "EnR is failed / unable to trigger the EnR");
		Assert.assertTrue(pdtoverview.scheduleBatcheAfterEnR(), "Batches are not scheduled hence test case is failed ");
	}

//	@Test(groups = { "SmokeTest" }, priority = 8)
	public void enRWIthOperatorUnavailabilityTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		System.out.println("Verify user can triger the eNR with operator unavailability ");
		driver.findElement(pdtoverview.homeBtn).click();
		homepage.navigateToControlTower();
		ctpage.navigateToManager();
		mgr.navigateToProducView();
		Assert.assertTrue(pdtoverview.toOperatorUnavailability(), "User is unable down the operator status ");
	}

//	@Test(groups = { "SmokeTest" }, priority = 9)

	public void trigerEnRTest() throws InterruptedException {
		Assert.assertTrue(pdtoverview.toTrigerEnr("01010020241300"),
				"User is unable to triger EnR with operator unavailability");
		Assert.assertTrue(pdtoverview.toCheckScheduleBatch(),
				"Batches are not schedule After trigger EnR with operator Unavailability ");
	}

//	@Test(groups = { "SmokeTest" }, priority = 10)

	public void toCheckScheduleOpAfterTrigerEnR() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Verify user can triger the eNR with operator unavailability ");
		driver.findElement(pdtoverview.homeBtn).click();
		homepage.navigateToControlTower();
		ctpage.navigateToManager();
		mgr.navigateToProducView();
		Assert.assertTrue(pdtoverview.toCheckScheduleOperator(),
				" Allocated operator and unavilable operator are same hence enR with operator unavailability is failed ");

	}

//	@Test(groups = { "SmokeTest" }, priority = 11)
	public void enRTrigerWithEqUnAvlTest() throws InterruptedException {

		Assert.assertTrue(pdtoverview.enRTrigerWithEqUnAvl(),
				"Unable to triger the EnR with equipment unavailaibility ");
		Assert.assertTrue(pdtoverview.toCheckScheduleBatch(),
				"Batches are not schedule After trigger EnR with Equipment Unavailability ");
	}

//	@Test(groups = { "SmokeTest" }, priority = 12)
	public void checkTaskTimeAfterEnRWithEqUnAvl() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(pdtoverview.homeBtn).click();
		homepage.navigateToControlTower();
		Thread.sleep(2000);
		ctpage.navigateToManager();
		mgr.navigateToProducView();
		Assert.assertTrue(pdtoverview.taskTimeAfterEnR(),
				"Before Task Start date and End Date is matched After EnR Task start date and end date, hence EnR is failed with equipment unavailability ");
	}

// In - Progress	

//	@Test(groups = { "SmokeTest" }, priority = 16)
	public void taskSyncInManagerViewInNotStartedStateTest() throws InterruptedException {
		pdtoverview.taskSyncInManagerViewInNotStartedState();
	}

//	@Test(groups = { "SmokeTest" }, priority = 7)
	public void completeBatchTest() throws InterruptedException {
		Assert.assertTrue(pdtoverview.completeBatch());
	}

//	@Test(groups = { "SmokeTest" }, priority = 6)
	public void taskSyncOfNotStartedInSLVTest() throws InterruptedException {
		pdtoverview.taskSyncOfNotStartedInSLV();
	}

}
