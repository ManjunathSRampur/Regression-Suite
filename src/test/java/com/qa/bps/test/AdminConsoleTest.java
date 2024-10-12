package com.qa.bps.test;

import java.awt.AWTException;
import java.sql.SQLException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class AdminConsoleTest extends BaseTest {
	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException, ParseException {
		System.out.println("-----------AdminConsole Test Page-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		navigateTo.addValueToEventProp();
		navigateTo.LattestPublishedPlan();
		String productName = navigateTo.GetProductDetailsFromPlanner();
		String firstTaskName = navigateTo.findFirstTaskFromPlanner();
		navigateTo.addValueToEventProp();
		navigateTo.VSB();
		vsbpage.productDetails(productName, firstTaskName);
		ac.resetTask();
		vsbpage.mousehoverontask();
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void navigateToAdminConsole() throws InterruptedException, SQLException {
		jdbc.configureDelayCodeGrp();
		Thread.sleep(2000);
		navigateTo.adminConsole();
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyUserCannavigateToDelayToleranceTab() throws InterruptedException {
		Assert.assertTrue(ac.navigateToDelayToleranceTab(),
				"Admin Console page not displayed or incorrect text displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyavailabilityOfInputFields() throws InterruptedException {
		Assert.assertTrue(ac.availabilityOfInputFields(), "UOM input fields not found in Threshold Tolerance tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyavailabilityOfUOMRadioBtn() throws InterruptedException {
		Assert.assertTrue(ac.availabilityOfUOMRadioBtn(), "UOM Radio buttons not found in Threshold Tolerance tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyavailabilityOfReasonCodeDD() throws InterruptedException {
		Assert.assertTrue(ac.availabilityOfReasonCodeDD(), "reason code dropdown is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyavailabilityOfSaveBtn() throws InterruptedException {
		Assert.assertTrue(ac.availabilityOfSaveBtn(), "Save Button not available");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifyuserCanConfigureDelaytolAndThreshold() throws InterruptedException {
		Assert.assertTrue(ac.userCanConfigureDelaytolAndThreshold(),
				"Thresold or Tolerance value not configured after clicking save button");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifytoasterMessageAfterClickingSaveBtn() throws InterruptedException {
		Assert.assertTrue(ac.toasterMessageAfterClickingSaveBtn(),
				"Displayed Toaster Message is: " + ac.ToasterMessage);
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void VerifyConfiguredTolerancePostRefresh() throws InterruptedException {
		Assert.assertTrue(ac.VerifyConfiguredTolerancePostRefresh(),
				"Tolerance value not changed post refresh or navigate back from another page");
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void verifyStartingTaskBelowtoleranceFromVsb() throws InterruptedException {
		Assert.assertTrue(ac.verifyDelayedStartBelowtoleranceFromVsb(),
				"log delay popup displayed , when user start the task below tolerance");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void verifyLogDelayAlertPostDelayedStartBelowTolerance() throws InterruptedException {
		Assert.assertTrue(ac.verifyLogDelayAlertPostDelayedStartBelowTolerance(),
				"log delay alert under task info window displayed , when user start the task below tolerance");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifydelayedFinishBelowTolerance() throws InterruptedException {
		Assert.assertTrue(ac.delayedFinishBelowTolerance(),
				"log delay popup displayed , when user close the task below tolerance");
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifyLogDelayAlertPostDelayedfinishBelowTolerance() throws InterruptedException {
		Assert.assertTrue(ac.verifyLogDelayAlertPostDelayedfinishBelowTolerance(),
				"log delay alert displayed , when user close the task below tolerance");
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void verifydelayedStartBetweenToleranceAndThreshold() throws InterruptedException {
		Assert.assertTrue(ac.delayedStartBetweenToleranceAndThreshold(),
				"log delay popup  displayed , when user start the task below tolerance");
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void verifyAlertDisplayedBetweentolAndThrsh() throws InterruptedException {
		Assert.assertTrue(ac.AlertDisplayedBetweentolAndThrsh(),
				"log delay alert not displayed , when user start the task below tolerance");

	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void delayReasonValidationPostdelayedSartBetweentoleranceAndthreshold() throws InterruptedException {
		Assert.assertTrue(ac.delayReasonValidationPostdelayedSartBetweentoleranceAndthreshold(),
				"log delay alert not displayed , when user start the task below tolerance");

	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void verifydelayedFinishBetweenToleranceAndThreshold() throws InterruptedException {
		Assert.assertTrue(ac.delayedFinishBetweenToleranceAndThreshold(), "");

	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyAlertDisplayedBetweentolAndThrshWithDelayedFinish() throws InterruptedException {
		Assert.assertTrue(ac.AlertDisplayedBetweentolAndThrshWithDelayedFinish(), "");

	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void delayReasonValidationBetweentoleranceAndthresholdWithDelayedFinish() throws InterruptedException {
		Assert.assertTrue(ac.delayReasonValidationBetweentoleranceAndthresholdWithDelayedFinish(), "");

	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void verifydelyedStartAboveThreshold() throws InterruptedException {
		Assert.assertTrue(ac.delyedStartAboveThreshold(), "");

	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyAlertDisplayedAboveThresholdWithDelayedStart() throws InterruptedException {
		Assert.assertTrue(ac.AlertDisplayedAboveThresholdWithDelayedStart(), "");

	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifdelayReasonValidationAbovethresholdWithDelayedStart() throws InterruptedException {
		Assert.assertTrue(ac.delayReasonValidationAbovethresholdWithDelayedStart(), "");

	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void verifdelayedFinishAboveThreshold() throws InterruptedException {
		Assert.assertTrue(ac.delayedFinishAboveThreshold(), "");

	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyAlertDisplayedAboveThresholdWithDelayedFinish() throws InterruptedException {
		Assert.assertTrue(ac.AlertDisplayedAboveThresholdWithDelayedFinish(), "");

	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifydelayReasonValidationAbovethresholdWithDelayedFinish() throws InterruptedException {
		Assert.assertTrue(ac.delayReasonValidationAbovethresholdWithDelayedFinish(), "");

	}

	// product Overview TC Starts------

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void setUpBeforeProductOverView() throws InterruptedException {
		ac.setUpBeforeProductOverView();

	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void DelayedStartBelowToleranceFromProductOverview() throws InterruptedException {
		Assert.assertTrue(ac.DelayedStartBelowToleranceFromProductOverview(), "");

	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void ValidateDelayAlertinProdOvWithDelayedStartBlowTol() throws InterruptedException {
		Assert.assertTrue(ac.ValidateDelayAlertinProdOvWithDelayedStartBlowTol(), "");

	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void delayedFinishBelowToleranceInProdOverview() throws InterruptedException {
		Assert.assertTrue(ac.delayedFinishBelowToleranceInProdOverview());
	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void ValidateDelayAlertinProdOvWithDelayedFinishBelowTol() throws InterruptedException {
		Assert.assertTrue(ac.ValidateDelayAlertinProdOvWithDelayedFinishBelowTol());

	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void resetTask() throws InterruptedException {
		ac.resetTaskInProductOverview();
	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void delayedStartBetwentolAndThresProdOv() throws InterruptedException {
		Assert.assertTrue(ac.delayedStartBetwentolAndThresProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 33)
	public void verifyAlertDisplayedInProdOvBetweenTolAndthreshPostDelayedStart() throws InterruptedException {
		Assert.assertTrue(ac.alertDisplayedInProdOvBetweenTolAndthreshPostDelayedStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 34)
	public void delayReasonValidationPostdelayedSartBetweentoleranceAndthresholdinProdOv() throws InterruptedException {
		Assert.assertTrue(ac.delayReasonValidationPostdelayedSartBetweentoleranceAndthresholdinProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 35)
	public void delayedFinishBetweenTolAndThresInProdOv() throws InterruptedException {
		Assert.assertTrue(ac.delayedFinishBetweenTolAndThresInProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 36)
	public void verifyalertDisplayedInProdOvBetweenTolAndthreshPostDelayedFinish() throws InterruptedException {
		Assert.assertTrue(ac.alertDisplayedInProdOvBetweenTolAndthreshPostDelayedFinish());
	}

	@Test(groups = { "SmokeTest" }, priority = 37)
	public void VerifydelayReasonValidationPostdelayedFinishBetweentoleranceAndthresholdinProdOv()
			throws InterruptedException {
		Assert.assertTrue(ac.delayReasonValidationPostdelayedFinishBetweentoleranceAndthresholdinProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 38)
	public void resetTaskInProdOv() throws InterruptedException {
		ac.resetTaskInProductOverview();
	}

	@Test(groups = { "SmokeTest" }, priority = 39)
	public void refreshAndVerifyData1() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 40)
	public void verifydelayedStartAboveThresholdProdOv() throws InterruptedException {
		Assert.assertTrue(ac.delayedStartAboveThresholdProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 41)
	public void verifyalertDisplayedInProdOvAboveThresholdPostDelayedStart() throws InterruptedException {
		Assert.assertTrue(ac.alertDisplayedInProdOvAboveThresholdPostDelayedStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 42)
	public void verifydelayReasonValidationPostdelayedSartAboveThresholdinProdOv() throws InterruptedException {
		Assert.assertTrue(ac.delayReasonValidationPostdelayedSartAboveThresholdinProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 43)
	public void PostDelayedStartAboveThreshResetTaskInProdOv() throws InterruptedException {
		ac.resetTaskInProductOverview();
	}

	@Test(groups = { "SmokeTest" }, priority = 44)
	public void VerifydelayedFinishAboveThresInProdOv() throws InterruptedException {
		Assert.assertTrue(ac.delayedFinishAboveThresInProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 45)
	public void verifyalertDisplayedInProdOvAboveThreshPostDelayedFinish() throws InterruptedException {
		Assert.assertTrue(ac.alertDisplayedInProdOvAboveThreshPostDelayedFinish());
	}

	@Test(groups = { "SmokeTest" }, priority = 46)
	public void verifydelayReasonValidationPostdelayedFinishAboveThresholdinProdOv() throws InterruptedException {
		Assert.assertTrue(ac.delayReasonValidationPostdelayedFinishAboveThresholdinProdOv());

	}

	@Test(groups = { "SmokeTest" }, priority = 47)
	public void PostDelayedFinishAboveThreshResetTaskInProdOv() throws InterruptedException {
		ac.resetTaskInProductOverview();
	}

//	 PO Early Start TC Starts

	@Test(groups = { "SmokeTest" }, priority = 48)
	public void earlyStartFromProdOvBelowTol() throws InterruptedException {

		Assert.assertTrue(ac.earlyStartFromProdOvBelowTol());
	}

	@Test(groups = { "SmokeTest" }, priority = 49)
	public void ValidateAlertinProdOvWithEarlyStartBlowTol() throws InterruptedException {

		Assert.assertTrue(ac.ValidateAlertinProdOvWithEarlyStartBlowTol());
	}

	@Test(groups = { "SmokeTest" }, priority = 50)
	public void resetAfterEarlyStart() throws InterruptedException {
		ac.resetTaskInProductOverview();
	}

	@Test(groups = { "SmokeTest" }, priority = 51)
	public void earlyFinishFromProdOvBelowTol() throws InterruptedException {

		Assert.assertTrue(ac.earlyFinishBelowToleranceInProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 52)
	public void ValidateAlertinProdOvWithEarlyFinishBelowTol() throws InterruptedException {

		Assert.assertTrue(ac.ValidateAlertinProdOvWithEarlyFinishBelowTol());
	}

	@Test(groups = { "SmokeTest" }, priority = 53)
	public void resetAfterEarlyFinishBelowTol() throws InterruptedException {
		ac.resetTaskInProductOverview();
	}

	// Test class-5
	@Test(groups = { "SmokeTest" }, priority = 54)
	public void earlyStartBetweenTolAndThreshInProdOv() throws InterruptedException {

		Assert.assertTrue(ac.earlyStartBetweenTolAndThreshInProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 55)
	public void alertDisplayedInProdOvBetweenTolAndthreshPostEaryStart() throws InterruptedException {

		Assert.assertTrue(ac.alertDisplayedInProdOvBetweenTolAndthreshPostEaryStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 56)
	public void delayReasonValidationPostEarlySartBetweentoleranceAndthresholdinProdOv() throws InterruptedException {

		Assert.assertTrue(ac.delayReasonValidationPostEarlySartBetweentoleranceAndthresholdinProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 57)
	public void resetAfterEarlyStartBtwnTol() throws InterruptedException {
		ac.resetTaskInProductOverview();
	}

	@Test(groups = { "SmokeTest" }, priority = 58)
	public void earlyStartAboveThresholdFromProdOv() throws InterruptedException {

		Assert.assertTrue(ac.earlyStartAboveThresholdFromProdOv());
	}

	@Test(groups = { "SmokeTest" }, priority = 59)
	public void alertDisplayedInProdOvAbovethreshPostEaryStart() throws InterruptedException {

		Assert.assertTrue(ac.alertDisplayedInProdOvAbovethreshPostEaryStart());
	}

	@Test(groups = { "SmokeTest" }, priority = 60)
	public void delayReasonValidationPostEarlySartAboveThresholdinProdOv() throws InterruptedException {

		Assert.assertTrue(ac.delayReasonValidationPostEarlySartAboveThresholdinProdOv());
	}

//	-----------Batch Monitoring Starts here	

	@Test(groups = { "SmokeTest" }, priority = 102)
	public void setupBeforeBatchMonitoring() throws InterruptedException {
		ac.setupBeforeBatchMonitoring();
	}

	@Test(groups = { "SmokeTest" }, priority = 103)
	public void refreshAndVerifyData() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 104)
	public void DelayedstartBelowToleranceInBatchMonitoring() throws InterruptedException {
		Assert.assertTrue(ac.DelayedstartBelowToleranceInBatchMonitoring());
	}

	@Test(groups = { "SmokeTest" }, priority = 105)
	public void verifyAlertWithDelayedstartBelowToleranceinBM() throws InterruptedException {
		Assert.assertTrue(ac.verifyAlertWithDelayedstartBelowToleranceinBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 106)
	public void ResetTaskInBM1() throws InterruptedException {
		ac.resetTaskInBM();
	}

	@Test(groups = { "SmokeTest" }, priority = 107)
	public void delayedFinishBelowTolBM() throws InterruptedException {
		Assert.assertTrue(ac.delayedFinishBelowTolBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 108)
	public void verifyAlertWithDelayedFinishBelowToleranceinBM() throws InterruptedException {
		Assert.assertTrue(ac.verifyAlertWithDelayedFinishBelowToleranceinBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 109)
	public void ResetTaskInBM() throws InterruptedException {
		ac.resetTaskInBM();
	}

	@Test(groups = { "SmokeTest" }, priority = 110)
	public void delayedStartBetweenTolAndThreshBM() throws InterruptedException {
		Assert.assertTrue(ac.delayedStartBetweenTolAndThreshBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 111)
	public void DelayedStartalertDisplayedBetweenTolAndThreshBM() throws InterruptedException {
		Assert.assertTrue(ac.DelayedStartalertDisplayedBetweenTolAndThreshBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 112)
	public void validateDelayReasonBetweenTolAndThreshWithDelayedStartBM() throws InterruptedException {
		Assert.assertTrue(ac.validateDelayReasonBetweenTolAndThreshWithDelayedStartBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 113)
	public void ResetTaskInBM2() throws InterruptedException {
		ac.resetTaskInBM();
	}

	@Test(groups = { "SmokeTest" }, priority = 114)
	public void delayedFinishBetweenTolAndThreshBM() throws InterruptedException {
		Assert.assertTrue(ac.delayedFinishBetweenTolAndThreshBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 115)
	public void DelayedFinishalertDisplayedBetweenTolAndThreshBM() throws InterruptedException {
		Assert.assertTrue(ac.DelayedFinishalertDisplayedBetweenTolAndThreshBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 116)
	public void validateDelayReasonBetweenTolAndThreshWithDelayedFinishBM() throws InterruptedException {
		Assert.assertTrue(ac.validateDelayReasonBetweenTolAndThreshWithDelayedFinishBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 117)
	public void ResetTaskInBM3() throws InterruptedException {
		ac.resetTaskInBM();
	}

	@Test(groups = { "SmokeTest" }, priority = 118)
	public void delayedStartAboveThreshInBM() throws InterruptedException {
		Assert.assertTrue(ac.delayedStartAboveThreshInBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 119)
	public void DelayedStartAlertDisplayedaboveThreshBM() throws InterruptedException {
		Assert.assertTrue(ac.DelayedStartAlertDisplayedaboveThreshBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 120)
	public void validateDelayReasonAboveThresholdDelayedStartBM() throws InterruptedException {
		Assert.assertTrue(ac.validateDelayReasonAboveThresholdDelayedStartBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 121)
	public void reset4() throws InterruptedException {
		ac.resetTaskInBM();
	}

	@Test(groups = { "SmokeTest" }, priority = 122)
	public void delayedFinishAboveThresholdBM() throws InterruptedException {
		Assert.assertTrue(ac.delayedFinishAboveThresholdBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 123)
	public void DelayedFinishAlertDisplayedaboveThreshBM() throws InterruptedException {
		Assert.assertTrue(ac.DelayedFinishAlertDisplayedaboveThreshBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 124)
	public void validateDelayReasonAboveThresholdDelayedFinishBM() throws InterruptedException {
		Assert.assertTrue(ac.validateDelayReasonAboveThresholdDelayedFinishBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 125)
	public void reset5() throws InterruptedException {
		ac.resetTaskInBM();
	}

	@Test(groups = { "SmokeTest" }, priority = 126)
	public void earlyStartBelowToleranceBM() throws InterruptedException {
		Assert.assertTrue(ac.earlyStartBelowToleranceBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 127)
	public void earlyStartAlertDisplayedBelowToleranceBM() throws InterruptedException {
		Assert.assertTrue(ac.earlyStartAlertDisplayedBelowToleranceBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 128)
	public void reset6() throws InterruptedException {
		ac.resetTaskInBM();
	}

	@Test(groups = { "SmokeTest" }, priority = 129)
	public void earlyFinishBelowToleranceBM() throws InterruptedException {
		Assert.assertTrue(ac.earlyFinishBelowToleranceBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 130)
	public void earlyFinishAlertDisplayedBelowToleranceBM() throws InterruptedException {
		Assert.assertTrue(ac.earlyFinishAlertDisplayedBelowToleranceBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 131)
	public void reset7() throws InterruptedException {
		ac.resetTaskInBM();
	}

	@Test(groups = { "SmokeTest" }, priority = 132)
	public void earlyStartBetweenToleranceAndThresholdBM() throws InterruptedException {
		Assert.assertTrue(ac.earlyStartBetweenToleranceAndThresholdBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 133)
	public void earlyStartalertDisplayedBetweenTolAndThreshBM() throws InterruptedException {
		Assert.assertTrue(ac.earlyStartalertDisplayedBetweenTolAndThreshBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 134)
	public void validateDelayReasonBetweenTolAndThreshWithEarlyStartBM() throws InterruptedException {
		Assert.assertTrue(ac.validateDelayReasonBetweenTolAndThreshWithEarlyStartBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 135)
	public void EarlyStartAboveThreshInBM() throws InterruptedException {
		Assert.assertTrue(ac.EarlyStartAboveThreshInBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 136)
	public void earlyStartalertDisplayedAboveThresholdBM() throws InterruptedException {
		Assert.assertTrue(ac.earlyStartalertDisplayedAboveThresholdBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 137)
	public void validateDelayReasonAboveThresholdWithEarlyStartBM() throws InterruptedException {
		Assert.assertTrue(ac.validateDelayReasonAboveThresholdWithEarlyStartBM());
	}

	@Test(groups = { "SmokeTest" }, priority = 138)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}
	
	
	
	

	@Test(groups = { "SmokeTest" }, priority = 139)
	public void ChangeThresholdAndTolToZero() throws InterruptedException {
		ac.ChangeThresholdAndTolToZero();
	}

	// this test case should be called after completing all the test cases
	@Test(groups = { "SmokeTest" }, priority = 140)
	public void deleteConfigureDelayCodeGrp() throws SQLException {
		jdbc.deleteConfigureDelayCode();
	}

}
