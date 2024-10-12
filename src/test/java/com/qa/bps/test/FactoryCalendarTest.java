package com.qa.bps.test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FactoryCalendarTest extends BaseTest {
	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------Factory Calendar Page------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));

	}

	// Verify user is able to navigate to factory calender
	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifyUsercanNavigateToFactoryCalendar() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(8000);
		Assert.assertTrue(fc.UsercanNavigateToFactoryCalendar(),
				"Navigation issue with Factory calendar or New calendsr Option is not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyUserCanCreateAnewfactoryCalendar() throws InterruptedException {

		Assert.assertTrue(fc.userCanCreateAnewfactoryCalendar(), "Created factory calendar is not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifytoasterPostfactoryCalendarCreated() throws InterruptedException {

		Assert.assertTrue(fc.toasterPostfactoryCalendarCreated(),
				"Wrong toaster message displayed after creating the factory calendar -" + "'" + fc.ToasterMessage
						+ "'");

	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyuserCancreateAduplicateFactoryCalendar() throws InterruptedException {

		Assert.assertTrue(fc.userCancreateAduplicateFactoryCalendar(), "Duplicate factory calendar created");

	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyduplicateFactoryCalendarToaster() throws InterruptedException {

		Assert.assertTrue(fc.duplicateFactoryCalendarToaster(),
				"Wrong toaster message displayed after creating the Duplicate Factory Calendar " + "'"
						+ fc.ToasterMessage + "'");

	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyUserCanEditFactoryCalendar() throws InterruptedException {

		Assert.assertTrue(fc.UserCanEditFactoryCalendar(), "Factory Calendar Not edited");

	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifyeditFactoryCalendarToaster() throws InterruptedException {

		Assert.assertTrue(fc.editFactoryCalendarToaster(),
				"Wrong toaster message displayed after editing the Factory Calendar name " + "'" + fc.ToasterMessage
						+ "'");

	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void VerifyaddNewShiftWithoutFillingShiftDetailsToaster() throws InterruptedException {
		Assert.assertTrue(fc.addNewShiftWithoutFillingShiftDetailsToaster(),
				"No Toaster displayed after clicking on save button");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void verifyUserCanAddAnewShift() throws InterruptedException {
		Assert.assertTrue(fc.UserCanAddAnewShift(), "Shift Not created or Created shift name is not as expected");

	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void VerifyuserCanCreateAshiftWithoutFillingShiftname() throws InterruptedException {
		Assert.assertTrue(fc.userCanCreateAshiftWithoutFillingShiftname(), "Shift created with blank name");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void VerifyUserCanEditTheShiftDetils() throws InterruptedException {
		Assert.assertTrue(fc.userCanEditTheShiftDetils(), "Edit Shift start time is not updated in calendar");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void VerifyeditShiftToaster() throws InterruptedException {
		Assert.assertTrue(fc.editShiftToaster(), "Wrong Toaster message displayed : " + fc.ToasterMessage);
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void VerifyUserCanDeleteTheShift() throws InterruptedException {
		Assert.assertTrue(fc.UserCanDeleteTheShift(), "Shift not deleted");
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void VerifyDeleteShiftToaster() throws InterruptedException {
		Assert.assertTrue(fc.deleteShiftToaster(), "Wrong Toaster message displayed : " + fc.ToasterMessage);
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void verifyDeleteConfirmationMessageDisplayed() throws InterruptedException {
		Assert.assertTrue(fc.deleteConfirmationMessageDisplayed(),
				"After clicking on delete factory calendar, delete confirmation window is not opening");
	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void VerifydeleteFactoryCalendarByProvidingWrongdeleteConfirmMessage() throws InterruptedException {
		Assert.assertTrue(fc.deleteFactoryCalendarByProvidingWrongdeleteConfirmMessage(),
				"User can delete the factory calendar by providing wrong factory calendar name");
	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void verifytoasterMessageOfDeleteFCByWrongFCName() {
		Assert.assertTrue(fc.toasterMessageOfDeleteFCByWrongFCName(),
				"Wrong Toaster message displayed : " + fc.ToasterMessage);
	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyuserCanDeletefactoryFaceldar() throws InterruptedException {
		Assert.assertTrue(fc.userCanDeletefactoryFaceldar(),
				"Factory calendar permanently deleted or status not changed to Inactive");
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifydeleteFCtoaster() {
		Assert.assertTrue(fc.deleteFCtoaster(), "Wrong Toaster message displayed : " + fc.ToasterMessage);
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

}
