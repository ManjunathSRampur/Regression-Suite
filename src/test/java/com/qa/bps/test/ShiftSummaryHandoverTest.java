package com.qa.bps.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.pages.EventProperties;
import com.qa.bps.pages.Navigation;
import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ExcelUtil;

public class ShiftSummaryHandoverTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
//		if (EventProperties.actionLevel == "Task Group") {
//
//			sshandover.xpathReinitializtion();
//
//		}
	}

	@Test(groups = { "SmokeTest" }, priority = 0)
	public void preReq() throws InterruptedException, SQLException, AWTException {
		jdbc.configureDelayCodeGrp();
		navigateTo.LattestPublishedPlan();

		String ActPN = navigateTo.GetProductDetailsFromPlanner();
		String firstTaskName = navigateTo.findFirstTaskFromPlanner();
		navigateTo.addValueToEventProp();
		navigateTo.productOverview();
		sshandover.getTaskTimeFromPO(ActPN, firstTaskName);

	}

//	@Test(groups = { "SmokeTest" }, priority = 1)
	public void addSideTaskinVSB() throws InterruptedException {
		sshandover.addSideTaskinVSB();
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyUserCanNavigateToSho() throws InterruptedException {
		Assert.assertTrue(navigateTo.Shifthandover());
		sshandover.xpathReinitializtion();
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyTheAvlOfShiftDetailsFiled() {
		Assert.assertTrue(sshandover.verifyTheAvlOfShiftDetailsFiledTest(), "Shift details fieled not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyAvlOfDateBoxFiled() {
		Assert.assertTrue(sshandover.verifyAvlOfDateBoxFiledTest(), "Date box is not available");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyAvlOfShiftTypeDD() {
		Assert.assertTrue(sshandover.verifyAvlOfShiftTypeDDTest(), "Shift Type Drop Down is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyAvlOfTeamFilterDropDown() {
		Assert.assertTrue(sshandover.verifyAvlOfTeamFilterDropDownTest(), "Team Filter Drop down is not available");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifyAvlOfRelaventFilterDD() {
		Assert.assertTrue(sshandover.verifyAvlOfRelaventFilterDDTest(), "Relavent Filter is not available");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyAvlOfTask() throws InterruptedException {
		Assert.assertTrue(sshandover.verifyAvlOfTaskTest(), "First task is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void verifyTheAvlOfSearchBox() {
		Assert.assertTrue(sshandover.verifyTheAvlOfSearchBoxTest(), "Search Box is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void verifyAvlOfSearchBtn() {
		Assert.assertTrue(sshandover.verifyAvlOfSearchBtnTest(), "Search Button is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void verifyAvlOfDwdReportIcon() {
		Assert.assertTrue(sshandover.verifyAvlOfDwdReportIconTest(), "Download report icon is not available");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyAvlOfEquipmentDropDown() {
		Assert.assertTrue(sshandover.verifyAvlOfEquipmentDropDownTest(), "Equipment Drop down is not avaialble ");
	}

//	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifyaddedSideTaskDisplayedInSH() {
		Assert.assertTrue(sshandover.addedSideTaskDisplayedInSH(),
				"Added Side task from VSB is not displayed in Shift Handover");
	}

//	@Test(groups = { "SmokeTest" }, priority = 14)
	public void verifydeleteSideTaskAndVerifyInVSB() throws InterruptedException {
		Assert.assertTrue(sshandover.deleteSideTaskAndVerifyInVSB(), "Side task is still exist post delete");
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void getTaskGroupDetailsSH() {
		sshandover.getTaskGroupDetailsSH();
	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void VerifytaskGroupStatusWhenNoTaskStarted() {
		Assert.assertTrue(sshandover.taskGroupStatusWhenNoTaskStarted());
	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void VerifyTGPlannedStartTimeValidationWithProdOvWhenNoTaskStarted() {
		Assert.assertTrue(sshandover.TGPlannedStartTimeValidationWithProdOvWhenNoTaskStarted());
	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void VerifyTGPlannedEndTimeValidationWithProdOvWhenNoTaskStarted() {
		Assert.assertTrue(sshandover.TGPlannedEndTimeValidationWithProdOvWhenNoTaskStarted());
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void VerifyTGDelayHrsValidationWithProdOvWhenNoTaskStarted() {
		Assert.assertTrue(sshandover.TGDelayHrsValidationWithProdOvWhenNoTaskStarted());
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void VerifytaskStatusWhenNotStarted() {
		Assert.assertTrue(sshandover.taskStatusWhenNotStarted());
	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void VerifytaskAndTaskGrouptimeSynchInNotStarted() {
		Assert.assertTrue(sshandover.taskAndTaskGrouptimeSynchInNotStarted());
	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyUserCanStartTheTask() throws InterruptedException {
		Assert.assertTrue(sshandover.verifyUserCanStartTheTaskTest());
	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void toasterValidationAftertaskStarted() throws InterruptedException {
		Assert.assertTrue(sshandover.toasterValidationAftertaskStarted());

	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifytaskGroupStatusWhenFirstTaskStarted() throws InterruptedException {
		Assert.assertTrue(sshandover.taskGroupStatusWhenFirstTaskStarted());
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifytaskAdnTaskGroupTimeSynchWhenInProgress() throws InterruptedException {
		Assert.assertTrue(sshandover.taskAdnTaskGroupTimeSynchWhenInProgress());
	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void VerifystartTimeSynchValidationWhenInProgress() throws InterruptedException {
		Assert.assertTrue(sshandover.startTimeSynchValidationWhenInProgress());
	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void VerifytaskStatusInprodOvWhenTaskInProgress() throws InterruptedException {
		Assert.assertTrue(sshandover.taskStatusInprodOvWhenTaskInProgress());
	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void VerifyEndTimeSynchValidationWhenInProgress() throws InterruptedException {
		Assert.assertTrue(sshandover.EndTimeSynchValidationWhenInProgress());
	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void VerifyresetTaskProdOvAndNavigateBacktoSH() throws InterruptedException {
		sshandover.resetTaskProdOvAndNavigateBacktoSH();
	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void VerifycompleteTaskSH() throws InterruptedException {
		Assert.assertTrue(sshandover.completeTaskSH());
	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void VerifyToasterValidationOnCompleteTask() throws InterruptedException {
		Assert.assertTrue(sshandover.ToasterValidationOnCompleteTask());
	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void VerifyActualEndTimeUpdatedPostTaskComplete() throws InterruptedException {
		Assert.assertTrue(sshandover.ActualEndTimeUpdatedPostTaskComplete());
	}

	@Test(groups = { "SmokeTest" }, priority = 33)
	public void VerifytaskStatusValidateInProdOvInAfterComplete() throws InterruptedException {
		Assert.assertTrue(sshandover.taskStatusValidateInProdOvInAfterComplete());
	}

	@Test(groups = { "SmokeTest" }, priority = 34)
	public void VerifyTaskStartTimeSynchInProdOVPostComplete() throws InterruptedException {
		Assert.assertTrue(sshandover.TaskStartTimeSynchInProdOVPostComplete());
	}

	@Test(groups = { "SmokeTest" }, priority = 35)
	public void VerifyTaskEndTimeSynchInProdOVPostComplete() throws InterruptedException {
		Assert.assertTrue(sshandover.TaskEndTimeSynchInProdOVPostComplete());
	}

	@Test(groups = { "SmokeTest" }, priority = 36)
	public void VerifyrestartTaskSH() throws InterruptedException {
		Assert.assertTrue(sshandover.restartTaskSH());
	}

	@Test(groups = { "SmokeTest" }, priority = 37)
	public void VerifytoasterDiaplyedAfterRestart() throws InterruptedException {
		Assert.assertTrue(sshandover.toasterDiaplyedAfterRestart());
	}

	@Test(groups = { "SmokeTest" }, priority = 38)
	public void VerifyTaskEndDateFieldUpdatedToNAPostRestart() throws InterruptedException {
		Assert.assertTrue(sshandover.VerifyTaskEndDateFieldUpdatedToNAPostRestart());
	}

	@Test(groups = { "SmokeTest" }, priority = 39)
	public void VerifyTasStatusSynchInProdOvPostRestart() throws InterruptedException {
		Assert.assertTrue(sshandover.TasStatusSynchInProdOvPostRestart());
	}

	@Test(groups = { "SmokeTest" }, priority = 40)
	public void VerifytaskTimeSynchTestInProdOVPostRestart() throws InterruptedException {
		Assert.assertTrue(sshandover.taskTimeSynchTestInProdOVPostRestart());
	}

	@Test(groups = { "SmokeTest" }, priority = 41)
	public void VerifytaskEndSynchTestInProdOVPostRestart() throws InterruptedException {
		Assert.assertTrue(sshandover.taskEndSynchTestInProdOVPostRestart());
	}

	@Test(groups = { "SmokeTest" }, priority = 42)
	public void VerifyresetTaskFromSH() throws InterruptedException {
		Assert.assertTrue(sshandover.resetTaskFromSH());
	}

	@Test(groups = { "SmokeTest" }, priority = 43)
	public void VerifyresetTaskToaster() throws InterruptedException {
		Assert.assertTrue(sshandover.resetTaskToaster());
	}

	@Test(groups = { "SmokeTest" }, priority = 44)
	public void VerifyplannedStartTimeValidationPostReset() throws InterruptedException {
		Assert.assertTrue(sshandover.plannedStartTimeValidationPostReset());
	}

	@Test(groups = { "SmokeTest" }, priority = 45)
	public void VerifyplannedEndTimeValidationPostReset() throws InterruptedException {
		Assert.assertTrue(sshandover.plannedEndTimeValidationPostReset());
	}

	@Test(groups = { "SmokeTest" }, priority = 46)
	public void VerifyplannedStartTimeSynchINProdOVPostReset() throws InterruptedException {
		Assert.assertTrue(sshandover.plannedStartTimeSynchINProdOVPostReset());
	}

	@Test(groups = { "SmokeTest" }, priority = 47)
	public void VerifyplannedEndTimeSynchINProdOVPostReset() throws InterruptedException {
		Assert.assertTrue(sshandover.plannedEndTimeSynchINProdOVPostReset());
	}

	@Test(groups = { "SmokeTest" }, priority = 48)
	public void VerifyDelayedStartSH() throws InterruptedException {
		Assert.assertTrue(sshandover.DelayedStartSH());
	}

	@Test(groups = { "SmokeTest" }, priority = 49)
	public void VerifytoasterValidationPostDelayedStart() throws InterruptedException {
		Assert.assertTrue(sshandover.toasterValidationPostDelayedStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 50)
	public void VerifydelayReasonCodeAlertPoStDelayedStart() throws InterruptedException {
		Assert.assertTrue(sshandover.toasterValidationPostDelayedStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 51)
	public void VerifytaskAndTaskGroupStartTimeSynchPostDelayedStart() throws InterruptedException {
		Assert.assertTrue(sshandover.taskAndTaskGroupStartTimeSynchPostDelayedStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 52)
	public void VerifydelayHrsValOnTaskGroupPostDelayedStart() throws InterruptedException {
		Assert.assertTrue(sshandover.delayHrsValOnTaskGroupOnDelayedStartSH());
	}

	@Test(groups = { "SmokeTest" }, priority = 53)
	public void VerifyTasktimeSynchInProdOvOnDelayedStart() throws InterruptedException {
		Assert.assertTrue(sshandover.TasktimeSynchInProdOvOnDelayedStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 54)
	public void VerifyTGDelayHrsvalidationOnDelayedStartProdOv() throws InterruptedException {
		Assert.assertTrue(sshandover.TGDelayHrsvalidationOnDelayedStartProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 55)
	public void VerifyTgTimeSynchwithProdOvOnDelayedStart() throws InterruptedException {
		Assert.assertTrue(sshandover.TgTimeSynchwithProdOvOnDelayedStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 56)
	public void VerifydelayReasonCodeSynchTestInProdOvOnDelayedStart() throws InterruptedException {
		Assert.assertTrue(sshandover.delayReasonCodeSynchTestInProdOvOnDelayedStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 57)
	public void verifyResetTaskPostDelayedStart() throws InterruptedException {
		Assert.assertTrue(sshandover.ResetTaskPostDelayedStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 58)
	public void VerifyresetTaskToasterPostDelayedStartValidation() throws InterruptedException {
		Assert.assertTrue(sshandover.resetTaskToasterPostDelayedStartValidation());
	}

	@Test(groups = { "SmokeTest" }, priority = 59)
	public void verifytaskGroupPlStartTimeValidationOnDelayedStartReset() throws InterruptedException {
		Assert.assertTrue(sshandover.taskGroupPlStartTimeValidationOnDelayedStartReset());
	}

	@Test(groups = { "SmokeTest" }, priority = 60)
	public void verifydelayedFinishSH() throws InterruptedException {
		Assert.assertTrue(sshandover.delayedFinishSH());
	}

	@Test(groups = { "SmokeTest" }, priority = 61)
	public void verifyToasterValidationAfterDelayedFinish() throws InterruptedException {
		Assert.assertTrue(sshandover.ToasterValidationAfterDelayedFinish());
	}

	@Test(groups = { "SmokeTest" }, priority = 62)
	public void verifydelayAlertvalidationOnDelayedStartSH() throws InterruptedException {
		Assert.assertTrue(sshandover.delayAlertvalidationOnDelayedStartSH());
	}

	@Test(groups = { "SmokeTest" }, priority = 63)
	public void verifydelayHrSValidationOnTGonDelayedFinish() throws InterruptedException {
		Assert.assertTrue(sshandover.delayHrSValidationOnTGonDelayedFinish());
	}

	@Test(groups = { "SmokeTest" }, priority = 64)

	public void getPreHandoverDetails() {
		sshandover.getPreHandoverDetails();
	}

	@Test(groups = { "SmokeTest" }, priority = 65)
	public void verifyUserCanPerformShifthandoverAction() throws InterruptedException {
		Assert.assertTrue(sshandover.ShifthandoverAction());
	}

	@Test(groups = { "SmokeTest" }, priority = 66)
	public void verifyshiftHandoverToaster() throws InterruptedException {
		Assert.assertTrue(sshandover.shiftHandoverToaster());
	}

	@Test(groups = { "SmokeTest" }, priority = 67)

	public void verifypostSshiftHandoverVal() throws InterruptedException {
		Assert.assertTrue(sshandover.postSshiftHandoverVal());
	}

	@Test(groups = { "SmokeTest" }, priority = 68)
	public void verifydisableActionPosthandover() throws InterruptedException {
		Assert.assertTrue(sshandover.disableActionPosthandover());
	}

	// this test case should be called after completing all the test cases
	@Test(groups = { "SmokeTest" }, priority = 69)
	public void deleteConfigureDelayCodeGrp() throws SQLException {
		jdbc.deleteConfigureDelayCode();
	}

}