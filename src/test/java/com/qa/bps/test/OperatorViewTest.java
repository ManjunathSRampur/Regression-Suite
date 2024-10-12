package com.qa.bps.test;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class OperatorViewTest extends BaseTest {
	String PN;

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifyTheProductOverviewNavigation() throws InterruptedException {
		navigateTo.LattestPublishedPlan();
		String PN = navigateTo.GetProductDetailsFromPlanner();
		navigateTo.addValueToEventProp();
		navigateTo.productOverview();
		Assert.assertTrue(opview.preReqPage(PN));
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyTheResetPWDforOperator() throws InterruptedException {
		navigateTo.IAM();
		Thread.sleep(4000);
		Assert.assertTrue(opview.preReq2ResetPassword());
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyTheLoginWithOperator() throws InterruptedException {

		Assert.assertTrue(opview.loginAsOp());

	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void VerifyAvailableFields() throws InterruptedException {
		Assert.assertTrue(opview.verifyAvalblField());

	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void getOpTeamandShiftLeadName() throws InterruptedException, AWTException {
		opview.getTeamandOpDetails();
		Thread.sleep(7000);
		loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));

		Thread.sleep(4000);
		navigateTo.TeamManagement();
		Thread.sleep(4000);

	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void VerifyOperatorTeamName_inTeamManagement() throws InterruptedException {
		Assert.assertTrue(opview.VerifyOpTeaminTM());
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void VerifyShiftLeadName_inTeamManagement() throws InterruptedException {

		Assert.assertTrue(opview.VerifyOpShiftleadInTM());
	}

//	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyShiftAllocation() throws InterruptedException {
		navigateTo.ShiftPattern();
		Thread.sleep(5000);
		Assert.assertTrue(opview.verifyShiftAllocation(), "shift is not allocated to operator ");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void VerifyTheDateFilterFunction() throws InterruptedException {

		Assert.assertTrue(opview.loginAsOp());
		Assert.assertTrue(opview.datepickerValidation());

	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void VerifyTheAvailabilityOfTask() throws InterruptedException {

		Assert.assertTrue(opview.taskValidation());

	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void VerifyTaskTimingsWithProductOverviewWhenNotStarted() throws InterruptedException {

		Assert.assertTrue(opview.dateAndTimeValidationWithProductOverview());

	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void VerifyTheStartTask() throws InterruptedException {

		Assert.assertEquals(opview.startTaskValidation(), Constants.startTaskOP);

	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void VerifyTheTaskStatusAfterStartTask() throws InterruptedException {

		Assert.assertTrue(opview.statusCheckAfterStartTask());

	}

	// @Test(groups = { "SmokeTest" }, priority = 14)
	public void VerifyTheMarkAsCompleteTask() throws InterruptedException {

		Assert.assertEquals(opview.markAsComplete(), Constants.startTaskOP);

	}

	// @Test(groups = { "SmokeTest" }, priority = 15)
	public void VerifyTheTaskStatusAfterCompleteTask() throws InterruptedException {

		Assert.assertTrue(opview.statusCheckAfterCompleteTask());

	}

}
