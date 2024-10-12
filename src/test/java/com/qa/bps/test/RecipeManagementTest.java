package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.pages.EventProperties;
import com.qa.bps.utils.Constants;

public class RecipeManagementTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-------Recipe Management------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		Thread.sleep(2000);

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifyUserCanNavigateRecipeManagement() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanNavigateRecipeManagementTest(),
				"User is unable to navigate to recipe management tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyTheAvlOfRecipeNameColumn() {
		Assert.assertTrue(recipeMangement.verifyTheAvlOfRecipeNameColumn(), "Recipe Name column is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyTheAvleOfDescriptionColumn() {
		Assert.assertTrue(recipeMangement.verifyTheAvleOfDescriptionColumn(), "Description column is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyAvlOfMaterialNumberColumn() {
		Assert.assertTrue(recipeMangement.verifyAvlOfMaterialNumberColumnTest(),
				"Material Number column is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyAvlOfProductNameColumn() {
		Assert.assertTrue(recipeMangement.verifyAvlOfProductNameColumnTest(), "Product Name column is not available ");

	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyAvlOfCreatedByColumn() {
		Assert.assertTrue(recipeMangement.verifyAvlOfCreatedByColumnTest(), "created column is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifyCreatedDateColumn() {
		Assert.assertTrue(recipeMangement.verifyCreatedDateColumnTest(), "created date column is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyAvlStatusColumn() {
		Assert.assertTrue(recipeMangement.verifyStatusColumnTest(), "status column is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void verifyAvlOfActionsColumn() {
		Assert.assertTrue(recipeMangement.verifyAvlOfActionsColumnTest(), "Action column is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void verifyAvlOfSearchBox() {
		Assert.assertTrue(recipeMangement.verifyAvlOfSearchBoxTest(), "search box is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void verifyAvlOfRecipeBtn() {
		Assert.assertTrue(recipeMangement.verifyAvlOfRecipeBtnTest(), "Recipe Button is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyUserCanClikOnRecipeBtn() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanClikOnRecipeBtnTest(),
				"user is unable to click on recipe button");
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifyAvlOfDefineEventTab() {
		Assert.assertTrue(recipeMangement.verifyAvlOfDefineEventTabTest(), "Define Event Tab is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void verifyAvlOfDefinePreProductionEventTab() {
		Assert.assertTrue(recipeMangement.verifyAvlOfDefinePreProductionEventTabTest(),
				"Define Pre Production Event Tab is not available ");

	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void verifyUserIsAbleToSaveTheRecipeMangementWithoutFilingFieled() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleToSaveTheRecipeMangementWithoutFilingFieledTest(),
				"User is able to save the Recipe Management without filling the mandatory fieleds");
	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void verifyAvlInputFieledInRecipeManagementPopUp() {
		Assert.assertEquals(recipeMangement.verifyAvlInputFieledInRecipeManagementPopUpTest(),
				Constants.expectedRecipeMgmtFieled);
	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void verifyUserCanAddNewProductionPointRow() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanAddNewProductionPointRowTest(),
				"User is unable to add the new production point row");
	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyUserCanRemoveNewProductionPointRow() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanRemoveNewProductionPointRowTest(),
				"User is unable to remove the added row");
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifyUserCanAddNewConsumtionPointRow() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanAddNewConsumtionPointRowTest(),
				"User is unable to add the new row for consumption point ");
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void verifyUserCanDeleteTheNewConsumptionPtRow() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanDeleteTheNewConsumptionPtRowTest(),
				"User is unable to delete the new consumption point ");
	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyUserCanAddTimeBasedConstraintRow() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanAddTimeBasedConstraintRowTest(),
				"User is unable to add new row to time based constarint");
	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyUserCanRemoveTimeBasedConstraintRow() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanRemoveTimeBasedConstraintRowTest(),
				"User is unable to remove the time based constraint tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void verifyUserCanAddTransferTaskRow() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanAddTransferTaskRowTest(),
				"User is unable to add the Transfer task row ");
	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyUserCanRemoveTheTransferTaskRow() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanRemoveTheTransferTaskRowTest(),
				"User is unable to remove the task transfer row ");
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifyUserCanNavigateDefineProductionEventTab() {
		Assert.assertTrue(recipeMangement.verifyUserCanNavigateDefineProductionEventTabTest(),
				"User is unable to navigate define pre production event tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void verifyAvlFiledsInDefineProductionEventTab() {
		Assert.assertTrue(recipeMangement.verifyAvlFiledsInDefineProductionEventTabTest());
	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void verifyUserIsAbleCreateRecipeMgmt() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleCreateRecipeMgmtTest(),
				"User is unable to create recipe mgmt / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void verifyAvlOfCreatedRecipe() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyAvlOfCreatedRecipeTest(),
				"Created recipe is not avaialble / search box functionality is not working ");
	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void verifyUserIsAbleToeditRecipeMgmt() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleToeditRecipeMgmtTest(),
				"User is unable to edit the recipe mangement");
	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void verifyUserIsAbleToDeleteRecipeMgmt() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleToDeleteRecipeMgmtTest(),
				"User is unable to delete the recipe / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void verifyAvlOfRecipePostDelete() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyAvlOfRecipePostDeleteTest(),
				"User is unable to delete the recipe/ toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void verifyUserIsAbleToCreateRecpieByAddingConsumptionPoint() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleToCreateRecpieByAddingConsumptionPointTest(),
				"User is unable to create recipe management / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 33)
	public void verifyUserIsAbleCreateRecipeByAddingTimeBasedConstraint() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleCreateRecipeByAddingTimeBasedConstraintTest(),
				"User is unable to create recipe by adding time based constraint / toaster message is not displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 34)
	public void verifyUserIsAbleToDeleteTheRecipeOfTimeBasedConstraint() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleToDeleteTheRecipeOfTimeBasedConstraintTest(),
				"User is unable to delete the recipe or toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 35)
	public void verifyUserIsAbleToCreateRecipeByAddingWithTransferTask() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleToCreateRecipeByAddingWithTransferTaskTest(),
				"User is unable to create the recipe by adding Transfer Task row / wrong toaster message is displayed  ");
	}

	@Test(groups = { "SmokeTest" }, priority = 36)
	public void verifyUserIsAbleToDeleteRecipeOfTransferTask() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleToDeleteRecipeOfTransferTaskTest(),
				"User is unable to delete the recipe of Transfer task");
	}

	@Test(groups = { "SmokeTest" }, priority = 37)
	public void verifyUserIsAbleTocreateRecipeByDefiningPreProduction() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleTocreateRecipeByDefiningPreProductionTest(),
				"User is unable to create recipe management by adding preprocessing");
	}

	@Test(groups = { "SmokeTest" }, priority = 38)
	public void verifyUserIsAbleToDeleteRecipeOfPreProcessing() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleToDeleteRecipeOfPreProcessingTest(),
				"User is unable to delete the recipe of pre processing");
	}

	@Test(groups = { "SmokeTest" }, priority = 39)
	public void verifyUserIsAbleTocreateRecipeByDefiningPostProduction() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleTocreateRecipeByDefiningPostProductionTest(),
				"User is unable to create recipe by adding post production task");
	}

	@Test(groups = { "SmokeTest" }, priority = 40)
	public void verifyUserCanDeleteRecipeOfProduction() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanDeleteRecipeOfProductionTest(),
				"user is unable to delete the the post processing ");
	}

	@Test(groups = { "SmokeTest" }, priority = 42)
	public void verifyTheDuplicateTaskAvlUnderProductionTaskDD() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyTheDuplicateTaskAvlUnderProductionTaskDDTest(),
				"Duplicate values available under recipe Management screen");
	}

	@Test(groups = { "SmokeTest" }, priority = 43)
	public void verifyUserIsAbleToCreateRecipeByAddingConsumptionPoint() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleToCreateRecipeByAddingConsumptionPointTest(),
				"User is unable to created recipe by adding consumption point");
	}

	@Test(groups = { "SmokeTest" }, priority = 44)
	public void verifyAvlOfCreatedRecipeByAddingConsumptionPoint() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyAvlOfCreatedRecipeByAddingConsumptionPointTest(),
				"Created recipe is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 45)
	public void verifyUserIsAbleToDeleteCreatedRecipeByAddingConsumptionPoint() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleToDeleteCreatedRecipeByAddingConsumptionPointTest(),
				"User is unable to delete the recipe / wrong toaster message is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 46)
	public void verifyAvlOfCreatedRecipeByAddingConsumptionPointPostDelete() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyAvlOfCreatedRecipeByAddingConsumptionPointPostDeleteTest(),
				"Deleted Recipe is still exist");
	}

	@Test(groups = { "SmokeTest" }, priority = 47)
	public void verifyUserIsAbleCreateRecipeByAddingTimeBasedConstraintWithSpecialSymbol() throws InterruptedException {
		Assert.assertTrue(
				recipeMangement.verifyUserIsAbleCreateRecipeByAddingTimeBasedConstraintWithSpecialSymbolTest(),
				"User is unable to create recipe by adding special symbole ");
	}

	@Test(groups = { "SmokeTest" }, priority = 48)
	public void verifySpecialSymbolAddedOrNotInCreateRecipeByAddingTimeBasedConstrain() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifySpecialSymbolAddedOrNotInCreateRecipeByAddingTimeBasedConstrainTest(),
				"Special symbole not added in constraint name filed of Time based constraint section");
	}

	@Test(groups = { "SmokeTest" }, priority = 49)
	public void verifyUserCanDeleteRecipeWithTimeConstraintAndSpecialSymbols() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserCanDeleteRecipeWithTimeConstraintAndSpecialSymbolsTest(),
				"Deleted recipe is still exist");
	}

	@Test(groups = { "SmokeTest" }, priority = 50)
	public void verifyUserIsAbleToDeletRecipeOfConsumptionPoint() throws InterruptedException {
		Assert.assertTrue(recipeMangement.verifyUserIsAbleToDeletRecipeOfConsumptionPointTest(),
				"User is unable to delete the recipe of consumption point");
	}

}
