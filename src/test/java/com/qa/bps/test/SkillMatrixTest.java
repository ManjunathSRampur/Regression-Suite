package com.qa.bps.test;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.bps.pages.SkillMatrix;
import com.qa.bps.utils.Constants;

public class SkillMatrixTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		microplan = homepage.navigateToMicroplanning();
		sm = microplan.navigateToSkillMatrix();
		System.out.println("------------Skilmatrix Page---------------");
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void getSkillMatrixDetailsTest() throws InterruptedException {

		Assert.assertTrue(sm.isSkillDetailsDisplayed());
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void getTaskSkillMatrixDetailsTest() throws InterruptedException {
		Assert.assertTrue(sm.isTaskSkillDetailsDisplayed());
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void testverifyUploadSkillMatrix() throws InterruptedException {
		Assert.assertEquals(sm.verifyUploadSkillMatrix(), Constants.skillMatrixUploadToaster);

	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void getverifyMsgDisplayed() throws InterruptedException {
		Assert.assertFalse(sm.verifyMsgDisplayed());
	}

	// NOT TO BE ENABLED
	// @Test(groups = {"SmokeTest"}, priority=5)
	public void checkDownloadFunctionality()
			throws ElementClickInterceptedException, InterruptedException, IOException {
		Assert.assertTrue(sm.verifyDownloadSkillMatrix());
	}

	// NOT TO BE ENABLED

//	@Test(groups = { "SmokeTest" },priority = 6)
//	public void getverifyUpdationofSkill() throws InterruptedException {
//		Assert.assertTrue(sm.verifyUpdationofSkill());
//	}

	@DataProvider(name = "createRole")
	public Object[][] getData() {
		return new Object[][] { { "Mentor", "leader" } };
	}

	// Verify user can create role
	@Test(dataProvider = "createRole", groups = { "SmokeTest" }, priority = 7)
	public void createRole(String roleName, String Description)
			throws ElementClickInterceptedException, InterruptedException, IOException {
		Assert.assertTrue(sm.createRole(roleName, Description));
	}

	// Verify user can edit existing role
	@Test(groups = { "SmokeTest" }, priority = 8)
	public void editRole() throws InterruptedException {
		Assert.assertTrue(sm.editRole());
	}

	// Verify user can delete existing role
	@Test(groups = { "SmokeTest" }, priority = 9)
	public void deleteRole() throws ElementClickInterceptedException, InterruptedException, IOException {
		Assert.assertTrue(sm.deleteRole());
	}

	@DataProvider(name = "createTeam")
	public Object[][] getTeamData() {
		return new Object[][] { { "Team1", "Test" } };
	}
	// Verify user can create operator team

	@Test(dataProvider = "createTeam", groups = { "SmokeTest" }, priority = 10)
	public void createTeam(String teamTittle, String Description)
			throws ElementClickInterceptedException, InterruptedException, IOException, AWTException {
		Assert.assertTrue(sm.createTeam(teamTittle, Description));
	}

	// Verify user can edit existing team
	@Test(groups = { "SmokeTest" }, priority = 11)
	public void editTeam() throws InterruptedException {
		Assert.assertTrue(sm.editTeam());
	}

	// Verify user can delete existing team
	@Test(groups = { "SmokeTest" }, priority = 12)
	public void deleteTeam() throws ElementClickInterceptedException, InterruptedException, IOException {
		Assert.assertTrue(sm.deleteTeam());

	}

	@DataProvider(name = "createOperator")
	public Object[][] getOperatorData() {
		return new Object[][] { { "john", "sennass", "john@neewee.ai", "Tanout@414" } };
	}

	// Verify user can create new operator
	@Test(dataProvider = "createOperator", groups = { "SmokeTest" }, priority = 13)
	public void createOperator(String fN, String lN, String email, String PWD)
			throws ElementClickInterceptedException, InterruptedException, IOException {
		Assert.assertTrue(sm.createOperators(fN, lN, email, PWD));

	}

	// Verify user can edit existing operator
	@Test(groups = { "SmokeTest" }, priority = 14)
	public void editOperator() throws InterruptedException {
		Assert.assertTrue(sm.editOperator());
	}

	// Verify user can delete existing operator
	@Test(groups = { "SmokeTest" }, priority = 15)
	public void deleteOperator() throws ElementClickInterceptedException, InterruptedException, IOException {
		Assert.assertTrue(sm.deleteOperator());
	}
}