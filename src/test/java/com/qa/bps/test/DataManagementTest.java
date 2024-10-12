package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class DataManagementTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------Data Management-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void VerifyuserCanNavigateToDataManagement() throws InterruptedException {
		Assert.assertTrue(dm.userCanNavigateToDataManagement());
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void VerifyavailableFields() throws InterruptedException {
		Assert.assertTrue(dm.availableFields());
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void VerifyuserCanSearchdataUsingTheSearchBox() throws InterruptedException {
		Assert.assertTrue(dm.userCanSearchDataUsingTheSearchBox());
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void VerifySearchBoxfunctionalityByRemovingChar() throws InterruptedException {
		Assert.assertTrue(dm.VerifySearchBoxfunctionalityByRemovingChar(),
				"data not cleared after user remove character");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void VerifyusercanSeedataInGridView() throws InterruptedException {
		Assert.assertTrue(dm.usercanSeedataInGridView(), "No data displayed In grid view");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void VerifyusercanSeedataInListView() throws InterruptedException {
		Assert.assertTrue(dm.usercanSeedataInListView(), "No data displayed In List view");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void VerifydataAvailableUnaderMasterdata() throws InterruptedException {
		Assert.assertTrue(dm.dataAvailableUnaderMasterdata(), "Data missing from Master data  ");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void VerifydataAvailableUnderFileUploadTab() throws InterruptedException {
		Assert.assertTrue(dm.dataAvailableUnderFileUploadTab(), "Data missing from Master data  ");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void VerifyUserCanCreateNewMasterTable() throws InterruptedException {
		Assert.assertTrue(dm.UserCanCreateNewMasterTable(), "Created Master Table Not found");
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void VerifyToasterPostnewMasterTableCreation() throws InterruptedException {
		Assert.assertTrue(dm.ToasterPostnewMasterTableCreation(),
				"Wrong toaster message displayed after creating the new master table");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void VerifyuserCanCreateAmasterTableWithDuplicateName() throws InterruptedException {
		Assert.assertTrue(dm.userCanCreateAMasterTableWithDuplicateName(),
				"User can create a master table with duplicate name");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyDataValidationPostRefresh() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void VerifyduplicateMasterTableToaster() throws InterruptedException {
		Assert.assertTrue(dm.duplicateMasterTableToaster(), "Toaster displayed " + dm.SuccessToaster);
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void VerifyuserCanDeleteTheMasterTable() throws InterruptedException {
		Assert.assertTrue(dm.userCanDeleteTheMasterTable(), "unable to delete the master table");
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void VerifytoastermessagePostMasterTableDeletion() throws InterruptedException {
		Assert.assertTrue(dm.toastermessagePostMasterTableDeletion(), "Toaster displayed " + dm.SuccessToaster);
	}

//	------------------------------------------Functional Area test cases -------------
	@Test(groups = { "SmokeTest" }, priority = 16)
	public void verifyUserCanNavigateToFUnctionalArea() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserCanNavigateToFUnctionalAreaTest(), "User is unable to navigate functional area");
	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void verifyDeleteBtnIsDisableBfrCrtFuncArea() {
		Assert.assertTrue(dm.verifyDeleteBtnIsDisableBfrCrtFuncAreaTest(),
				"Delete Button is enabled before creating functional area");
	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyUserCanCreateANewFunctionalArea() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserCanCreateANewFunctionalAreaTest(),
				"User is unable to create functional area/ toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifyFunctOfSearchBox() throws InterruptedException {
		Assert.assertTrue(dm.verifyFunctOfSearchBoxTest(), "Search value is not populatting ");
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void verifyUserCanEditFuncArea() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserCanEditFuncAreaTest(),
				"User is unable to edit functional area / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyUserCanDeleteFuncArea() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserCanDeleteFuncAreaTest(),
				"User is unable to delte functional area / Toaster message is not displayed ");
	}

//	------------------------------------------Department test cases -------------
	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyUserCanNavigateDepartmentScreen() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserCanNavigateDepartmentScreenTest(),
				"User is unable to navigate department screen ");
	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void verifyUserCanCreateNewDepartment() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserCanCreateNewDepartmentTest(), "User is unable to created the department");
	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyTheFunctOfDepartmentSearchBox() {
		Assert.assertTrue(dm.verifyTheFunctOfDepartmentSearchBoxTest(), "User is unable to search the department ");
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifyUserCanEditTheDepartment() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserCanEditTheDepartmentTest(),
				"User is unable to edit the department / toaster message is not displayed /wrong ");
	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void verifyUserCanChangeActiveStatu() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserCanChangeActiveStatuTest(), "User is unable to change the active status");
	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void verifyUserCanDeleteTheDepartment() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserCanDeleteTheDepartmentTest(),
				"User is unable to delete the department/ wrong toaster message is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void verifyDataValidationPostRefresh1() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void verifyUserCanCreateDataCatalogWithSpecialCharactor() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserCanCreateDataCatalogWithSpecialCharactorTest(),
				"User is unable to created data catalog with special symbole");
	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void verifyTheAvlOfSpecialSymboleDataCatalog() throws InterruptedException {
		Assert.assertTrue(dm.verifyTheAvlOfSpecialSymboleDataCatalogTest(),
				"Data catalog created with specail symbole is not visible");
	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void verifyUserIsAbleToEditTheDataCatalog() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserIsAbleToEditTheDataCatalogTest(), "User is unable to edit the data catalog");
	}

	@Test(groups = { "SmokeTest" }, priority = 33)
	public void verifyUserIsAbleToAddTheNewColumnToDataCatalog() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserIsAbleToAddTheNewColumnToDataCatalogTest(),
				"User is unable to add the new column to data catalog / Wrong toaster message is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 34)
	public void verifyAvlOfAddedColumnInDataCatalog() throws InterruptedException {
		Assert.assertTrue(dm.verifyAvlOfAddedColumnInDataCatalogTest(),
				"Added column is not available under data catalog");
	}

	@Test(groups = { "SmokeTest" }, priority = 35)
	public void verifyUserIsAbleToChangeTheDataTypeOfAddedColumn() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserIsAbleToChangeTheDataTypeOfAddedColumnTest(), "Data type is not chnaged ");
	}

	@Test(groups = { "SmokeTest" }, priority = 36)
	public void verifyUserIsAbleToDeleteAddedColumn() throws InterruptedException {
		Assert.assertTrue(dm.verifyUserIsAbleToDeleteAddedColumnTest(), "Deleted column is still exist");
	}

}
