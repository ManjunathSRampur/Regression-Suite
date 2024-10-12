package com.qa.bps.test;

import java.awt.AWTException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class PlannerTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException, SQLException {

		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		microplan = homepage.navigateToMicroplanning();
		Thread.sleep(3000);
		System.out.println("--------- Planner Test------------------------");
		navigateTo.addValueToEventProp();
		jdbc.getEquipmentNameFromDB();
	}

//	 @Test(groups = { "Workflow" }, priority = 1)
	public void createPlanTest() throws InterruptedException, AWTException {

		Assert.assertEquals(pl.fillPlanDetails(), "Plan Is Being Generated");

	}

//	 @Test(groups = { "Workflow" }, priority = 2)
	public void planStatusTest() throws InterruptedException {

		Assert.assertTrue(pl.checkPlanStaus());

	}

	// ------NOT TO BE ENABLED
	// @Test(groups = { "SmokeTest" }, priority = 3)
	public void planArchiveDetailsTest() throws InterruptedException {

		System.out.println("Planner Page");
		Assert.assertTrue(pl.isplanArchiveDisplayed());

	}

//--------------------------------- New Test Cases Start From Here ------------------------------------------------

//	@Test(groups = { "SmokeTest" }, priority = 1)
	public void fileUploadTest() throws InterruptedException {
		Assert.assertTrue(pl.fileUpload(Constants.campaignFileNew),
				"Toaster message is not displayed / File upoad is failed");
	}

//	@Test(groups = { "SmokeTest" }, priority = 2)

	public void createPlanTests() throws InterruptedException {
		homepage.navigateToMicroplanning();
		microplan.navigateToPlanner();
		Thread.sleep(2000);
		Assert.assertTrue(pl.createPlan(), "plan generation is failed ");
	}

//	@Test(groups = { "SmokeTest" }, priority = 2)
	public void publishPlanTest() throws InterruptedException {
		pl.publishPlan();
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void dataAvlUnderOverviewTabTest() throws InterruptedException {
		navigateTo.navigateToPlanner();
		Assert.assertTrue(pl.dataAvlUnderOverviewTab(), "data is not avaialble under summary tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void dataAvlUnderCampaignTabTest() throws InterruptedException {
		Assert.assertTrue(pl.dataAvlUnderCampaignTab(), "data is not avaialable under campaign tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void dataAvlUnderConstraintTabTest() throws InterruptedException {

		Assert.assertTrue(pl.dataAvlUnderConstraintTab(), "data is not avaialable under constraint tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void dataAvlUnderProductionTabTest() throws InterruptedException {
		Assert.assertTrue(pl.dataAvlUnderProductionTab(), "data is not avaialble under production tab");

	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void dataAvlUnderEquipmentTabTest() throws InterruptedException {

		Assert.assertTrue(pl.dataAvlUnderEquipmentTab(), "data is not avaialble under equipment tab ");

	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void dataAvlUnderWIPINVTabTest() throws InterruptedException {
		Assert.assertTrue(pl.dataAvlUnderWIPINVTab(), "Data is not avaialble under WIPINV tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void dataAvlUnderStockTabTest() throws InterruptedException {

		Assert.assertTrue(pl.dataAvlUnderStockTab(), "data is not available under stock tab");

	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void dataAvlUnderOperatorTabTest() throws InterruptedException {

		Assert.assertTrue(pl.dataAvlUnderOperatorTab(), "Data is not available under operator tab ");

	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void dataAvlUnderProductionLineTabTest() throws InterruptedException {

		Assert.assertTrue(pl.dataAvlUnderProductionLineTab(), "Data is not display under production line tab ");

	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void dataAvlUnderComparisonTabTest() throws InterruptedException {

		Assert.assertTrue(pl.dataAvlUnderComparisonTab(), "Data is not avaialable under comparison tab");

	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void failedConstraintsIconToolTip() {

		Assert.assertEquals(pl.failedConstraintsIconToolTip(), Constants.FAILED_CONSRAINTS_TOOLTIP,
				" failed constraints icon tool tip is not displayed/matching");
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void logEventsIconToolTip() {

		Assert.assertEquals(pl.logEventsIconToolTip(), "Log events icon tool tip is not displayed/matching");
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void fullScreenIconToolTip() throws InterruptedException {

		Assert.assertEquals(pl.fullScreenIconToolTip(), Constants.FULL_SCREEN_VIEW,
				"Full screen icon tool tip is not displayed/matching");
	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void verifyDataAvlUnderVersionCopmTabAfterLanguageChange() throws InterruptedException {
		Assert.assertTrue(pl.verifyDataAvlUnderVersionCopmTabAfterLanguageChangeTest(),
				"Data is not avaialble under version comp tab after changing language");
	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void languageDotIssueInNativeLanguage() throws InterruptedException {
		pl.languageDotIssueInNativeLanguage();
	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyFunctOfDragAndDropInProdTab() throws InterruptedException {
		Assert.assertTrue(pl.verifyFunctOfDragAndDropInProdTabTest(),
				"User is unable to drag and drop / toaster message is not proper");
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifyFuncOfSaveAsBtn() throws InterruptedException {
		Assert.assertTrue(pl.verifyFuncOfSaveAsBtnTest(),
				"After save as no data avaialble under batch delay summary tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void verifyKpiValuesPostSaveAs() throws InterruptedException {
		Assert.assertTrue(pl.verifyKpiValuesPostSaveAsTest(), "KPI Values are not same in planner tab drafted plann");
	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyUiRedirectionAfterSaveAs() throws InterruptedException {

		Assert.assertTrue(pl.verifyUiRedirectionAfterSaveAsTest(),
				"Lates version value and displayed version value are not same ");

	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyDataAvlUnderProductOrCampaignPriorityTab() throws InterruptedException {
		Assert.assertTrue(pl.verifyDataAvlUnderProductOrCampaignPriorityTabTest(),
				"Data is not avaialble under product/campaign priority tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void verifyUpdateBtnAvlUnderLogEventBtn() throws InterruptedException {
		Assert.assertTrue(pl.verifyUpdateBtnAvlUnderLogEventBtnTest(),
				"Update button exist before editing the log alert");
	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyTaskDetailsInTaskInfoWindow() throws InterruptedException {
		Assert.assertTrue(pl.verifyTaskDetailsInTaskInfoWindowTest(), "Task details are wrong in task info tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifyEquipmentTollTipInEquipmentTab() throws InterruptedException {
		Assert.assertTrue(pl.verifyEquipmentTollTipInEquipmentTabTest(), "On hover toll tip is not appear");
	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void verifyUserAddEqUnAvlAlert() throws InterruptedException {
		Assert.assertTrue(pl.verifyUserAddEqUnAvlAlertTest(), "User is unable to add equipment event");
	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void verifyUserCanSeeEqUnAvlAlert() throws InterruptedException {
		Assert.assertTrue(pl.verifyUserCanSeeEqUnAvlAlertTest(), "Eq Unavailability alert is not added in summary tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void verifyUserCanSeeTheEqUnAvlTollTipInEquipmentTab() throws InterruptedException {
		Assert.assertTrue(pl.verifyUserCanSeeTheEqUnAvlTollTipInEquipmentTabTest(),
				"Equipment Unavailabilty tool tip is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void verifyUserCanDeleteEqUnAvl() throws InterruptedException {
		Assert.assertTrue(pl.verifyUserCanDeleteEqUnAvlTest(),
				"User is unable to delete the equipment Unavailability alert /toaster message is not displayed and actual toaster is : "
						+ pl.tstmsg);
	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void verifyEqUnAvlAlertIsDisapearedPostDelete() throws InterruptedException {
		Assert.assertTrue(pl.verifyEqUnAvlAlertIsDisapearedPostDeleteTest(),
				"After deleting the equipment unavailability, equipment unavaialbility alert is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void verifyTheEqUnAvlTollTipInEquipmentTabPostDelete() throws InterruptedException {
		Assert.assertTrue(pl.verifyTheEqUnAvlTollTipInEquipmentTabPostDeleteTest(),
				"After deleting the equipment unavailability, equipment unavaialbility tool tip is displaying under equipment tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void verifyAvlOfProcessOrderDwdBtn() throws InterruptedException {
		Assert.assertTrue(pl.verifyAvlOfProcessOrderDwdBtnTest(),
				"process order is not avialable for this plan /Download icon is not avaialable ");
	}

	@Test(groups = { "SmokeTest" }, priority = 33)
	public void verifyFuncOfZoomInButtonInResourceTab() throws InterruptedException {
		Assert.assertTrue(pl.verifyFuncOfZoomInAndZoomButtonInResourceTabTest(), "User is unable to perform zoom in ");
	}

	@Test(groups = { "SmokeTest" }, priority = 34)
	public void verifyFuncOfZoomOutBtnInResourceTab() throws InterruptedException {
		Assert.assertTrue(pl.verifyFuncOfZoomOutBtnInResourceTabTest(), "User is unable to perform zoom out ");
	}

	@Test(groups = { "SmokeTest" }, priority = 35)
	public void verifyTheAvailabilityOfSelectTaskDropDown() throws InterruptedException {
		Assert.assertTrue(pl.verifyTheAvailabilityOfTaskDropDownTest(),
				"Task Drop Down is missing under equipment tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 36)
	public void verifyTheTaskTimeIntegrationInProductionTabAndEquipmentTab() throws InterruptedException {
		Assert.assertTrue(pl.verifyTheTaskTimeIntegrationInProductionTabAndEquipmentTab(),
				"Task time is production tab and equipment tab not matching ");
	}

	@Test(groups = { "SmokeTest" }, priority = 37)
	public void verifyTheFunctionalityOfBuildingDropDownInEqTab() throws InterruptedException {
		Assert.assertTrue(pl.verifyTheFunctionalityOfBuildingDropDownInEqTabTest(),
				"Building drop down functionality is not working");
	}

	@Test(groups = { "SmokeTest" }, priority = 38)
	public void verifyProperErrorToasterMsgUnderReschedulingCompTabIfEnROpIsNotSelected() throws InterruptedException {
		Assert.assertTrue(pl.verifyProperErrorToasterMsgUnderReschedulingCompTabIfEnROpIsNotSelectedTest(),
				"Wrong toaster message is displaying if enr option is not selected");
	}

	@Test(groups = { "SmokeTest" }, priority = 39)
	public void verifyTheAvailabilityOfEnRComparisonTabUnderReschedulingCompTab() throws InterruptedException {
		Assert.assertTrue(pl.verifyTheAvailabilityOfEnRComparisonTabUnderReschedulingCompTabTest(),
				"EnR comparision check box is not available under Rescheduling comparison tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 40)
	public void verifyUserCanSelectAnyVersionOfThePlanToCompareUnderReschedulinComparisonTab()
			throws InterruptedException {
		Assert.assertTrue(pl.verifyUserCanSelectAnyVersionOfThePlanToCompareUnderReschedulinComparisonTabTest(),
				"User is unable to compare any version of the plan");
	}

}
