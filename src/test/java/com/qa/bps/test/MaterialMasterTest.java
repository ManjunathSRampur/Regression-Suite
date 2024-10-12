package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MaterialMasterTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------Material Master Page-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		navigateTo.materialMaster();
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifAddInfoBtnAvlInFrountOfFields() throws InterruptedException {
		Assert.assertTrue(mm.verifAddInfoBtnAvlInFrountOfFieldsTest(),
				"Info button is not available for text fieldes ");
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyDDListAvailabilityForCampaignRunType() {
		Assert.assertTrue(mm.verifyDDListAvailabilityForCampaignRunTypeTest(),
				"No drop down option is available for campaign run type Drop down");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyAptFieldAvlUnderNewMaterialMaster() {
		Assert.assertTrue(mm.verifyAptFieldAvlUnderNewMaterialMasterTest(),
				"Apt field is not avaialable under new material master pop-up");
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyUserCanCreateMaterialMaster() throws InterruptedException {
		Assert.assertTrue(mm.verifyUserCanCreateMaterialMasterTest(),
				"User is unable to create material master / toaster message is not displayed s");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyUserCanEditCreatedMaterialMaster() throws InterruptedException {
		Assert.assertTrue(mm.verifyUserCanEditCreatedMaterialMasterTest(),
				"User is unable to edit the material master / Toaster message is not displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyUserCanDeleteMaterialMaster() throws InterruptedException {
		Assert.assertTrue(mm.verifyUserCanDeleteMaterialMasterTest(),
				"User is unable to delete the material master / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifyTheAvlOfGramUOMInUOMDD() throws InterruptedException {
		Assert.assertTrue(mm.verifyTheAvlOfGramUOMInUOMDDTest(), "Gram UOM is missing under UOM Drop Down");
	}
	
	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyUserCanCreateMaterialMasterWithApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(mm.verifyUserCanCreateMaterialMasterWithApportstopeSymbolTest(), "Toaster message is not displaying");
	}
	@Test(groups = { "SmokeTest" }, priority = 9)
	public void verifyAvailabilityOftMaterialMasterWithApportstopeSymbol1() throws InterruptedException {
		Assert.assertTrue(mm.verifyAvailabilityOftMaterialMasterWithApportstopeSymbolTest(), "created material but not displayed");
	}
	@Test(groups = { "SmokeTest" }, priority = 10)
	public void verifyUserCanEditMaterialMasterTestWithApportsopeSymbol() throws InterruptedException {
		Assert.assertTrue(mm.verifyUserCanEditMaterialMasterTestWithApportsopeSymbolTest(), " editted material but not displayed ");
	}
	@Test(groups = { "SmokeTest" }, priority = 11)
	public void validateEdittedMasterMaterialTestWithApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(mm.validateEdittedMasterMaterialTestWithApportstopeSymbolTest(),"editted material is not  displayed");
	}
	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyUserCanDeleteMaterialMasterTestWithApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(mm.verifyUserCanDeleteMaterialMasterTestWithApportstopeSymbolTest(), "after deleting material, material is still existing");
	}
	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifyUserAbleToNavigateConfigureProperty() throws InterruptedException {
		Assert.assertTrue(mm.verifyUserAbleToNavigateConfigureProperty(), " user is unable to navigate ");
	}
	
}
