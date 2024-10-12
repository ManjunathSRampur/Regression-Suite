package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MasterDataTest extends BaseTest {
	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------Master Data Page-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifyUserCanNavigateToMasterData() throws InterruptedException {
		Assert.assertTrue(md.verifyUserCanNavigateToMasterDataTest(), "User is unable to navigate to master data ");
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyTheAvailabelFiledsToCreateMasterData() throws InterruptedException {
		Assert.assertTrue(md.verifyTheAvailabelFiledsToCreateMasterDataTest(), "Some fileds are missing");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyUserCanCreateMasterData() throws InterruptedException {
		Assert.assertTrue(md.verifyUserCanCreateMasterDataTest(),
				"User is unable to create master data / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyTheAvlOfCreatedMasterData() {
		Assert.assertTrue(md.verifyTheAvlOfCreatedMasterDataTest(), "Created master data is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyUserCanEditTheMasterData() throws InterruptedException {
		Assert.assertTrue(md.verifyUserCanEditTheMasterDataTest(),
				"User is unable to edit the master data / wrong toaster message is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyTheAvlOfEditedMasterData() {
		Assert.assertTrue(md.verifyTheAvlOfEditedMasterDataTest(), "Edited master data is not available in ui");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifyUserCanDeleteMasterData() throws InterruptedException {
		Assert.assertTrue(md.verifyUserCanDeleteMasterDataTest(),
				"User is unable to delete master data / wrong toaster messages is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyTheAvlOfDeleteMasterData() {
		Assert.assertTrue(md.verifyTheAvlOfDeleteMasterDataTest(), "Deleted master table exist in ui");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void verifyUserCanCreateMasterDataByAddingApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(md.verifyUserCanCreateMasterDataByAddingApportstopeSymbolTest(),
				"User is unable to create master data by adding special symbols / wrong toaster messages is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void verifyTheAvlOfCreatedMasterDataWithApportsope() {
		Assert.assertTrue(md.verifyTheAvlOfCreatedMasterDataWithApportsopeTest(),
				"Created master data with special symbole is not available in UI");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void verifyUserCanEditMasterDataWithApportStop() throws InterruptedException {
		Assert.assertTrue(md.verifyUserCanEditMasterDataWithApportStopTest(),
				"User is unable to edit the master data with aportsope symbole / wrong toaster messages is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyAvailabilityOfEditedMasterDataWithApportStop() {
		Assert.assertTrue(md.verifyAvailabilityOfEditedMasterDataWithApportStopTest(),
				"Edited master with special symbol is not available in ui");

	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifyUserCanDeleteMasterDataWithApportStop() throws InterruptedException {
		Assert.assertTrue(md.verifyUserCanDeleteMasterDataWithApportStopTest(),
				"User is unable to delete the master data with special symbole / wrong toaster message is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void verifyAvailabilityOfCreatedMasterDataWithApportStopAfterDelete() {
		Assert.assertTrue(md.verifyAvailabilityOfCreatedMasterDataWithApportStopAfterDeleteTest(),
				"Deleted master data stil exist in ui");
	}

}