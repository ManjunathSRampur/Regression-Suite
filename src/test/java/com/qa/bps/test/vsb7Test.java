package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class vsb7Test extends BaseTest {

	@Test(groups = { "SmokeTest" }, priority = 0)
	public void navigateToVSB3days() throws InterruptedException {
		System.out.println("----------VSB7 test page-------------------------");

		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		Thread.sleep(2000);
		navigateTo.vsb3Days();
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifyAvailableFields() throws InterruptedException {
		Assert.assertTrue(vsb7.verifyAvailableFields(), "All fields are not available");
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyoptionsAvailableUnderFilterButton() throws InterruptedException {
		Assert.assertTrue(vsb7.optionsAvailableUnderFilterButton(),
				"Fields not displayed after clicking filter button");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyslightDelayEventColor() {
		Assert.assertTrue(vsb7.slightDelayEventColor());

	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void VerifyEquipmentUnavailableEventColors() {

		Assert.assertTrue(vsb7.EquipmentUnavailableEventColors());
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void VerifyAsPlannedEventColors() {

		Assert.assertTrue(vsb7.AsPlannedEventColors());
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void VerifyMajorDelayColors() {

		Assert.assertTrue(vsb7.MajorDelayColors());
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void VerifyPlannedColors() {

		Assert.assertTrue(vsb7.PlannedColors());
	}

}
