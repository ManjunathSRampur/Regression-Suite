package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlanValidationTest extends BaseTest {
	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifyUserCanNavigateToPlanValidation() throws InterruptedException {
		Assert.assertTrue(navigateTo.planValidation(), "User is unable to navigate plan validation screen ");
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyUserCanNaviagateToProductGraphView() throws InterruptedException {
		Assert.assertTrue(planValidation.verifyUserCanNaviagateToProductGraphViewTest(),
				"Graph is not generating after cliking on generate button");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyavailableTabsUnderPlanValidation() {
		Assert.assertTrue(planValidation.availableTabsUnderPlanValidation(),
				"Graph view or data validation view missing");
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyvalidateBtnDisplayedUnderDataValidation() throws InterruptedException {
		Assert.assertTrue(planValidation.validateBtnDisplayedUnderDataValidation(),
				"Validate Button is not available under Data Validation View tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyDataAfterClickingValidationBtn() throws InterruptedException {
		Assert.assertTrue(planValidation.DataAfterClickingValidationBtn(), "No data after clicking validation button");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifydataAvailableUnbderMandetoryChecks() throws InterruptedException {
		Assert.assertTrue(planValidation.dataAvailableUnbderMandetoryChecks(),
				"No data available under Mandetory checks");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifydataAvailableUnderConfigTab() throws InterruptedException {
		Assert.assertTrue(planValidation.dataAvailableUnderConfigTab(), "No data found under Config Tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifydataAvailableUnderControltowerTab() throws InterruptedException {
		Assert.assertTrue(planValidation.dataAvailableUnderControltowerTab(),
				"No data available under Control tower tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void verifydataAvailableUnderProductGraphViewTab() throws InterruptedException {
		Assert.assertTrue(planValidation.dataAvailableUnderProductGraphViewTab(),
				"No data Available under Product graph view tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void verifytooltipForProductSearchBox() throws InterruptedException {
		Assert.assertTrue(planValidation.tooltipForProductSearchBox(), "Wrong tooltip displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void productNameTest() throws InterruptedException {
		Assert.assertTrue(planValidation.productNameValidation(), "Wrong product name displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void productNameTestTG() throws InterruptedException {
		Assert.assertTrue(planValidation.productNameValidationTG(), "Wrong product name displayed");
	}

}
