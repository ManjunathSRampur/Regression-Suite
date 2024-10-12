package com.qa.bps.test;

import java.awt.AWTException;
import java.sql.SQLException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.pages.LoginPage;
import com.qa.bps.pages.Navigation;
import com.qa.bps.pages.PlanGenerationSC01;
import com.qa.bps.pages.SeleniumDatabaseTesting;
import com.qa.bps.utils.Constants;

public class PlannerTestSc00 extends BaseTest {
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException, SQLException {
		SeleniumDatabaseTesting.getConnection();
		new LoginPage(driver);
		loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		System.out.println("loged in");
		Thread.sleep(3000);
		System.out.println("--------- Planner Test------------------------");
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void navigateToplanner() throws InterruptedException {
		navigateTo.LattestPublishedPlan();
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void createAnewPlan() throws InterruptedException {
		System.out.println(
				"--------------------------------Create_New_Plan_Test_Started(Sc-0)-------------------------------------------------");
		Assert.assertTrue(pl0.createAnewPlanScenario0(), "Plan Failed Or not generated");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void algoAuditorSc0_DB_Validation() throws InterruptedException, SQLException {
		System.out.println(
				"--------------------------------New_Plan_Algo_Auditor_Validation_Test_Started(Sc-0)---------------------------------");
		Assert.assertTrue(SeleniumDatabaseTesting.algoAuditorSc0(),
				"DB Algo Validation Checks Failed for new plan with SC-0");

	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyUserCanAutoSchedule() throws InterruptedException {
		System.out.println(
				"--------------------------------Normal_Autoschedule_Test_Started(Sc-0)-----------------------------------------");
		Assert.assertTrue(pl0.TriggerAutoschedule(), "Plan Failed Or not generated");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void algoAuditorSc0_DB_Validation_ForAutoSchedule() throws InterruptedException, SQLException {
		System.out.println(
				"--------------------------------Normal_Autoschedule_Plan_Algo_Auditor_Validation_Test_Started(Sc-0)---------------------------------");
		Assert.assertTrue(pl0.algoAuditorSc0_DB_Validation_ForAutoSchedule(),
				"DB Algo Validation Checks Failed For Normal Autoschedule with SC-0");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyUserCanAutoscheduleaftermovebatch() throws InterruptedException, ParseException {
		System.out.println(
				"--------------------------------Batch_Move_Autoschedule_Test_Started(Sc-0)-----------------------------------");
		Assert.assertTrue(pl0.batchmove(), "Auto schedule plan failed/date is less than drag date");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void algoAuditorSc0_DB_Validation_ForMoveBatchAutoSchedule() throws InterruptedException, SQLException {
		System.out.println(
				"--------------------------------Batch_Move_Autoschedule_Plan_Algo_Auditor_Validation_Test_Started(Sc-0)---------------------------------");
		Assert.assertTrue(pl0.algoAuditorSc0_DB_Validation_ForMoveBatchAutoSchedule(),
				"DB Algo Validation Checks Failed For Move Batch Autoschedule with SC-0");
	}

}
