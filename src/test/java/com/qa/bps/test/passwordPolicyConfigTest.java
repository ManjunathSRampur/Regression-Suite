package com.qa.bps.test;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class passwordPolicyConfigTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------TeamManagement Page-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifynavigateToPasswordPolicyCongifuration() throws InterruptedException {
		Assert.assertTrue(ppc.navigateToPasswordPolicyCongifuration(),
				"Unable to navigate to password policy configuration page");

	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyavailableFiledsUnderPasswordPolicyConfigTab() throws InterruptedException {
		Assert.assertTrue(ppc.availableFiledsUnderPasswordPolicyConfigTab(),
				"Any of the field missing from password policy configuration page");

	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyuserCanCheckTheAvailableCheckBoxes() throws InterruptedException {
		Assert.assertTrue(ppc.userCanCheckTheAvailableCheckBoxes(),
				"user is not able to check the configuration check boxes");

	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void userCanConfigPasswordPolicyAndCheckToaster() throws InterruptedException {
		Assert.assertTrue(ppc.userCanConfigPasswordPolicyAndCheckToaster(), "Pasword policy not configured");

	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifytoasterValOnConfiguration() throws InterruptedException {
		Assert.assertTrue(ppc.toasterValOnConfiguration(),
				"No Toaster displayed or wrong toaster displayed after configuring password policy");

	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void VerifyUserCanchangePasswordPolicyConfig() throws InterruptedException {
		Assert.assertTrue(ppc.changePasswordPolicyConfig(), "Unable to change the password policy configuration");

	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void toasterValOnchangePasswordPolicy() throws InterruptedException {
		Assert.assertTrue(ppc.toasterValOnchangePasswordPolicy(),
				"No Toaster displayed or wrong toaster displayed after configuring password policy");

	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void refreshAndVerifypasswordPlocyUpdated() throws InterruptedException {
		Assert.assertTrue(ppc.refreshAndVerifypasswordPlocyUpdated(),
				"After refreshing the page password policy not updated to the configured value");

	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void verifylimitOfMaxLength() throws InterruptedException {
		Assert.assertTrue(ppc.limitOfMaxLength(), "Error toaster not displayed when user enter max value more than 24");

	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void VerifymaxValueNotUpdatedToMorethan24() throws InterruptedException {
		Assert.assertTrue(ppc.maxValueNotUpdatedToMorethan24(), "Max value field accepting more than 24");

	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void verifyLimitOfMinValue() throws InterruptedException {
		Assert.assertTrue(ppc.minValueLimitValidation(),
				"Minimum value accepting less than 4 or toaster message not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void VerifyminValueNotUpdatedToLessThan4() throws InterruptedException {
		Assert.assertTrue(ppc.minValueNotUpdatedToLessThan4(), "Min value field accepting less than 4");

	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifymaxValueIsNotLessThanMin() throws InterruptedException {
		Assert.assertTrue(ppc.maxValueIsNotLessThanMin(), "Max Value is accepting less than minimum");

	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void refreshAndVerifypasswordPlocyNotUpdatedToWrongvalue() throws InterruptedException {
		Assert.assertTrue(ppc.refreshAndVerifypasswordPlocyNotUpdatedToWrongvalue(),
				"Min field is accepting value more than max");

	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void verifyThePasswordPolicyPromptUserWhileCreatingNewUserInIAM() throws InterruptedException {
		Assert.assertTrue(ppc.verifyThePasswordPolicyPromptUserWhileCreatingNewUserInIAM(),
				"The password policy configured is not same with the prompt value in IAM");

	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void verifyThePasswordPolicyPromptUserWhileeditingpasswordInIAM() throws InterruptedException {
		Assert.assertTrue(ppc.verifyThePasswordPolicyPromptUserWhileeditingpasswordInIAM(),
				"The password policy configured is not same with the prompt value in IAM edit password");

	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void verifyPasswordPolicyInTeamManagementCreateOperator() throws InterruptedException {
		Assert.assertTrue(ppc.verifyPasswordPolicyInTeamManagementCreateOperator(),
				"The password policy configured is not same with the prompt value in Team Management edit password");

	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyPasswordPolicyInCreateOPeratorTM() throws InterruptedException {
		Assert.assertTrue(ppc.verifyPasswordPolicyInCreateOPeratorTM(),
				"The password policy configured is not same with the prompt value in Team Management Create Operator");

	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifyUserCanconfigPasswordPolicyWithAphostropheSymbol() throws InterruptedException {
		Assert.assertTrue(ppc.configPasswordPolicyWithAphostropheSymbol(),
				"User is unable to configure password policy with Aphostrophe symbol");

	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void toasterValOnConfigurationPasswordPolicyWithAphostropheSymbol() throws InterruptedException {
		Assert.assertTrue(ppc.toasterValOnConfigurationPasswordPolicyWithAphostropheSymbol(),
				"No Toaster displayed or wrong toaster displayed after configuring password policy with Aphostrophe symbol");

	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void refreshAndVerifydataAvaiable() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
	}

}