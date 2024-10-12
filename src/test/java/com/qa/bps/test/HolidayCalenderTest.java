package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class HolidayCalenderTest extends BaseTest {
	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------Holiday Calendar-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifyUserCannavigateTOHolidayCalendar() throws InterruptedException {
		Assert.assertTrue(hc.navigateTOHolidayCalendar());
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyUserCanCreateANewHolidayCalendarWithoutFillingTheMandetoryFields() throws InterruptedException {
		Assert.assertTrue(hc.UserCanCreateANewHolidayCalendarWithoutFillingTheMandetoryFields());
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifytoasterMessageAfterCreatingACalendarWithoutfillingMandetoryFields() throws InterruptedException {
		Assert.assertTrue(hc.toasterMessageAfterCreatingACalendarWithoutfillingMandetoryFields());
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyuserCanCreateAnewHolidayCalendar() throws InterruptedException {
		Assert.assertTrue(hc.userCanCreateAnewHolidayCalendar());
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyHolidayCalendarToaster() throws InterruptedException {
		Assert.assertTrue(hc.HolidayCalendarToaster());
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyuserCanEditTheHolidayCalendar() throws InterruptedException {
		Assert.assertTrue(hc.userCanEditTheHolidayCalendar());
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifytoasterMessageOfEditCalendar() throws InterruptedException {
		Assert.assertTrue(hc.toasterMessageOfEditCalendar());
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyUserCanDeleteHolidayCalendar() throws InterruptedException {
		Assert.assertTrue(hc.deleteHolidayCalendar());
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void verifydeleteHolidayCalendarToaster() throws InterruptedException {
		Assert.assertTrue(hc.deleteHolidayCalendarToaster());
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

}
