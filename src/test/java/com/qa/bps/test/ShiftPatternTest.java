package com.qa.bps.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.pages.ShiftPattern;

import com.qa.bps.utils.Constants;

public class ShiftPatternTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------ShiftPatternTest Page-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		bs = homepage.navigateToBodheeStudio();
		shptn = bs.navigateToShiftPatrn();
	}

	// Verify the shiftPattern download template tool tip displayed on mouse over
	@Test(groups = { "SmokeTest" }, priority = 1)
	public void shiftPttnDownloadToolTip() throws InterruptedException {

		Assert.assertEquals(shptn.shiftPtnDownloadToolTip(), Constants.SHIFTPATTERN_DOWNLOAD_TOOLTIP,
				"Tooltip is not displayed/matching");
	}

	// Verify the teamShiftPattern download template tool tip displayed on mouse
	// over
	@Test(groups = { "SmokeTest" }, priority = 2)
	public void teamShiftPttniconToolTip() throws InterruptedException {

		Assert.assertEquals(shptn.teamshiftPtniconToolTip(), Constants.SHIFTPATTERN_DOWNLOAD_TOOLTIP,
				"Tooltip is not displayed/matching");
	}

	// Verify the available fields of operator Team shift pattern
	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyAllavailablefieldsOperatorShift() throws InterruptedException {
		Assert.assertTrue(shptn.fieldsOfOperatorShiftPattern(), "fields doesnt exists");

	}

	// Verify the toggle button should not displayed of operator shift pattern
	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifytoggleButtonOfOvertimeShiftTeamshiftTab() throws InterruptedException {
		Assert.assertTrue(shptn.toggleBtnOfovertimeShift(), "field is exists");

	}

	// Verify the search box functionality of operator shift pattern with one Team
	// in team shift screen
	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifysearchFunctionalityofOperatorShift1TeamShiftScreen() throws InterruptedException {
		Assert.assertFalse(shptn.searchFunctionOptShift1Team(), "fields doesnt exists");

	}

	// Verify the search box functionality of operator shift pattern with two Team
	// in Team shift pattern Tab
	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifysearchFunctionalityofOperatorShift2Team() throws InterruptedException {
		Assert.assertFalse(shptn.searchFunctionOptShift2Team(), "fields doesnt exists");

	}

	// Verify user can move to previous month in team shift pattern
	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifyMoveToPreviousMonth() throws InterruptedException {
		Assert.assertTrue(shptn.verifyMovedToPrevioustMonth(), "Sheet not moved to next month");

	}

	// Verify user can move to next month in team shift pattern
	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyMoveToNextMonth() throws InterruptedException {
		Assert.assertTrue(shptn.verifyMovedToNextMonth(), "Sheet not moved to next month");

	}

	// Verify user can create shift in factory calendar for Team shift pattern
	// screen
	@Test(groups = { "SmokeTest" }, priority = 9)
	public void createShiftinFectoryCal() throws InterruptedException {
		Assert.assertTrue(shptn.newShiftConfig(), "Team is not created");

	}

	// Verify newly created shift is visible in Team shift pattern screen
	@Test(groups = { "SmokeTest" }, priority = 10)
	public void intigrationOfShiftFromFectoryCal() throws InterruptedException {
		Assert.assertTrue(shptn.verifyShiftConfig(), "Team is not present");

	}

	// Verify user can delete shift from factory calender for Team shift pattern
	@Test(groups = { "SmokeTest" }, priority = 11)
	public void deleteShiftFromFectoryCal() throws InterruptedException {
		Assert.assertTrue(shptn.ShiftDeleteFromFactoryCal(), "Team is not Deleted");

	}

	// Verify Deleted shift from factory calendar is not visible in Team shift
	// pattern screen
	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyShiftDeletedFromShiftPattern() throws InterruptedException {
		Assert.assertTrue(shptn.verifyShiftDeleted(), "Team is not Deleted");

	}

	// Verify user can click on check Box and save the changes in Team shift pattern

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void selectChkBox() throws InterruptedException {
		Assert.assertTrue(shptn.selectChkBox(), "field is not selected");

	}

	// Verify user can deselect check Box and save the changes in Team shift Pattern
	@Test(groups = { "SmokeTest" }, priority = 14)
	public void DeselectChkBox() throws InterruptedException {
		Assert.assertFalse(shptn.DeselectChkBox(), "field is selected");

	}

	// Verify user can remove the old shift pattern in team shift pattern screen
	@Test(groups = { "SmokeTest" }, priority = 15)
	public void uncheckAllTheChekbox() throws InterruptedException {
		Assert.assertTrue(shptn.unchekCheckBox(), "can not uncheck all option");

	}

	// Verify user can configure new Team shift pattern in team shift pattern screen
	@Test(groups = { "SmokeTest" }, priority = 16)
	public void cofigureNewShiftPattern() throws InterruptedException {
		Assert.assertTrue(shptn.configShifPattern(), "new shift pattern in not configured");

	}

	// Verify user can download excel of team shift pattern
	@Test(groups = { "SmokeTest" }, priority = 17)
	public void downloadShiftPattern() throws InterruptedException {
		Assert.assertTrue(shptn.downloadShiftPattern(), "sheet is not downloaded");

	}

	// Operator Shift pattern
	// Screen.................................................................................................
	// Verify user can move to operator shift pattern screen
	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyOperatorShiftTabNavigation() throws InterruptedException {
		Assert.assertTrue(shptn.verifyOperatorShiftPattern(), "can not moved to operator shift tab ");
	}

	// Verify available fields of operator shift pattern screen
	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifyFiledOfOperatorShiftPattern() throws InterruptedException {
		Assert.assertTrue(shptn.fildsOfOperatorShift(), "all fields are not available");
	}

	// Verify holiday Button functionality in operator shift pattern
	@Test(groups = { "SmokeTest" }, priority = 20)
	public void verifyHolidayBtnFuntion() throws InterruptedException {
		Assert.assertTrue(shptn.verifyHolidayFun(), "holidays are not visible ");

	}

	// Verify working hours Button functionality in operator shift pattern
	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyWorkingHoursBtnFuntion() throws InterruptedException {
		Assert.assertTrue(shptn.verifyWorkingHoursFun(), "working hours are not visible ");

	}

	// Verify the duplicate Date should not displayed of operator shift pattern
	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyDuplicateDatesInOperatorShiftScreen() throws InterruptedException {
		Assert.assertFalse(shptn.DuplicateDateInOperatorShift(), "field is exists");
	}

	// Verify user can select Team and select operator drop down functionality in
	// operator shift pattern
	@Test(groups = { "SmokeTest" }, priority = 23)
	public void selectTeamAndOperatorFunctionality() throws InterruptedException {
		Assert.assertTrue(shptn.verifyTeamOperatorDropdown(), "can not select team and operator ");

	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyUserCanMarkTheOperatorUnavailable() throws InterruptedException, IOException {
		Assert.assertTrue(shptn.verifyUserCanMarkTheOperatorUnavailableTest(),
				"Unable to mark the operator unavailable / wrong toaster message is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifyWorkingHrsAfterMarkingOperatorUnAvailable() throws InterruptedException {
		Assert.assertTrue(shptn.verifyWorkingHrsAfterMarkingOperatorUnAvailableTest(),
				"After marking operator unavailable working hours not changes to zero(0)");
	}

}