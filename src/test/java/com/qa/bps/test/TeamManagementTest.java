package com.qa.bps.test;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class TeamManagementTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------TeamManagement Page-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifUserCanNavigateToTeamManagement() throws InterruptedException {
		tm.navigateToTeamManagement();
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifavailableTabsInTM() throws InterruptedException {
		Assert.assertTrue(tm.availableTabsInTM(), "any of the tab not displayed in Team management");

	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifytabHeaderInTeamManagement() throws InterruptedException {
		Assert.assertTrue(tm.tabHeaderInTeamManagement(), "Tab Header is not displayed or displayed wrong");

	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyavailableFieldsUnderOperatorTeamTab() throws InterruptedException {
		Assert.assertTrue(tm.availableFieldsUnderOperatorTeamTab(),
				"please check some of the fields are missing from Operator team tab");

	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifycreaNewTeamAndCheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.creaNewTeamAndCheckToaster(),
				"please check some of the fields are missing from Operator team tab");

	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifytoasterMsgValidation() throws InterruptedException {
		Assert.assertTrue(tm.toasterMsgValidation(),
				"Toaster displayed after creating a new operator team " + tm.ToasterMsg);

	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifycreatedTeamExistsInteamList() throws InterruptedException {
		Assert.assertTrue(tm.createdTeamExistsInteamList(),
				"New Operator team not created or team name not foundin the list");

	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyfunctionalityOfSearchBoxINCreateTeam() throws InterruptedException {
		Assert.assertTrue(tm.functionalityOfSearchBoxINCreateTeam(), "Search box functionality is not working");

	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void createNewTeamWithDuplicateName() throws InterruptedException {
		Assert.assertTrue(tm.createNewTeamWithDuplicateName(), "duplicate Team Created or error toaster not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void duplicateTeamAddedInTeamList() throws InterruptedException {
		Assert.assertTrue(tm.duplicateTeamAddedInTeamList(), "Duplicate Team Created ");

	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void toasterValidationOnDuplicateTeamCreation() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnDuplicateTeamCreation(), "Wrong Toaster displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyeditOpTeamAndToaster() throws InterruptedException {
		Assert.assertTrue(tm.editOpTeamAndToaster(),
				"No toaster displayed after editing the operator team or team tatus not updated");

	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifytoasterValidationonEditingTeamName() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidation(),
				"No toaster displayed after editing the operator team or wrong toaster displayed " + tm.ToasterMsg);

	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void editTeamDescandVerifyToaster() throws InterruptedException {
		Assert.assertTrue(tm.editTeamDescandVerifyToaster(),
				"No toaster displayed after editing the operator team or wrong toaster displayed " + tm.ToasterMsg);

	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void toasterValOnEditTeamDesc() throws InterruptedException {
		Assert.assertTrue(tm.toasterValOnEditTeamDesc(),
				"No toaster displayed after editing the operator team or wrong toaster displayed " + tm.ToasterMsg);

	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void verifyOperationTeamDescUpdated() throws InterruptedException {
		Assert.assertTrue(tm.verifyOperationTeamDescUpdated(), "Team Description not updated");

	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void deleteOpTeamAndcheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.deleteOpTeamAndcheckToaster(), "Wrong Toaster");

	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyavaialabilityOfDeletedTeam() throws InterruptedException {
		Assert.assertTrue(tm.avaialabilityOfDeletedTeam(), "Team Not deleted");

	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void deleteTeamToasterValidation() throws InterruptedException {
		Assert.assertTrue(tm.deleteTeamToasterValidation(), "Wrong toaster displayed after deleting the Operator team");

	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void verifytabHeaderInOperatorTab() throws InterruptedException {
		Assert.assertTrue(tm.tabHeaderInOperatorTab(), "Tab Header is missing from operator tab");

	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyavailableFieldsUnderOperatorTab() throws InterruptedException {
		Assert.assertTrue(tm.availableFieldsUnderOperatorTab(), "some fields are missing in operator tab");

	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifycreateNewOperatorAndCheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.createNewOperatorAndCheckToaster(), "No Toaster Message fter creating operator");

	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void toasterValidationOnCreateOperator() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnCreateOperator(),
				"No Toaster Message fter creating operator or Wrong Toaster displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyavailabilityOfCreatedOp() throws InterruptedException {
		Assert.assertTrue(tm.availabilityOfCreatedOp(), "Created Operator not available in the operator list");

	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void functionalityOfSearchboxInOperatorTab() throws InterruptedException {
		Assert.assertTrue(tm.functionalityOfSearchboxInOperatorTab(),
				"Searchbox functionality is not working in Operator Tab");

	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void editOperatorAndToasterDisplayed() throws InterruptedException {
		Assert.assertTrue(tm.editOperatorAndToasterDisplayed(), "Edit operator toaster not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void toasterValidationOnEditOperator() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnEditOperator(),
				"Edit operator toaster not displayed or wrong toaster displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void verifyavailabilityOfEditedOperator() throws InterruptedException {
		Assert.assertTrue(tm.availabilityOfEditedOperator(), "Edited Operator not available in operator list");

	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void editOperatorTeamandCheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.editOperatorTeamandCheckToaster(),
				"Operator team not edited or toaster message not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void toasterValidationOnEditOperatorTeam() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnEditOperatorTeam(),
				"Operator team not edited or wrong toaster message  displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void verifyOperatorIsAddedToNewteam() throws InterruptedException {
		Assert.assertTrue(tm.verifyOperatorIsAddedToNewteam(), "Operator team not edited");

	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void editOperatorGroupAndCheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.editOperatorGroupAndCheckToaster(), "Operator group not edited or toaster not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 33)
	public void toasterValidationOnEditOperatorGrp() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnEditOperatorGrp(),
				"Operator group not edited or toaster not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 34)
	public void verifyOperatorIsAddedToNewGrp() throws InterruptedException {
		Assert.assertTrue(tm.verifyOperatorIsAddedToNewGrp(), "Operator group not edited");

	}

	@Test(groups = { "SmokeTest" }, priority = 35)
	public void deleteOperatorAndCheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.deleteOperatorAndCheckToaster(), "Delete Operator toaster not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 36)
	public void checkOperatorStatusPostDelete() throws InterruptedException {
		Assert.assertTrue(tm.checkOperatorStatusPostDelete(), "Operator group not edited");

	}

	@Test(groups = { "SmokeTest" }, priority = 37)
	public void toasterValidationOndeleteOperator() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOndeleteOperator(), "wrong toaster diaplyed after deleting operator");

	}

	@Test(groups = { "SmokeTest" }, priority = 38)
	public void verifyreActiveTheDeletedUserAndCheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.reActiveTheDeletedUserAndCheckToaster(),
				"Operator status not reactivated or toaster not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 39)
	public void checkOperatorStatusPostReActive() throws InterruptedException {
		Assert.assertTrue(tm.checkOperatorStatusPostReActive(), "Operator status not changed to activ");

	}

	@Test(groups = { "SmokeTest" }, priority = 40)
	public void toasterValidationOnreActiveOperator() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnreActiveOperator(),
				"Wrong toaster message displayed after re-active the operator");

	}

	@Test(groups = { "SmokeTest" }, priority = 41)
	public void changeOperatorRoleAndCheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.changeOperatorRoleAndCheckToaster(),
				"Operator role not changed or toaster message not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 42)
	public void toasterValidationOnChangingOperatorRole() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnChangingOperatorRole(),
				"Wrong toaster message displayed on changing operator role");

	}

	@Test(groups = { "SmokeTest" }, priority = 43)
	public void verifyOperatorRoleIsUpdatedInOpList() throws InterruptedException {
		Assert.assertTrue(tm.verifyOperatorRoleIsUpdatedInOpList(), "Operator Role Not updated in Operator list");

	}

	@Test(groups = { "SmokeTest" }, priority = 44)
	public void createUserWithSameName() throws InterruptedException {
		Assert.assertTrue(tm.createUserWithSameName(), "Operator not created with same name");

	}

	@Test(groups = { "SmokeTest" }, priority = 45)
	public void toasterValidationOnCreateOperatorWithSameName() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnCreateOperatorWithSameName(), "Toaster Not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 46)
	public void availabilityOfCreatedOpWithSameName() throws InterruptedException {
		Assert.assertTrue(tm.availabilityOfCreatedOpWithSameName(),
				"created opearator with same name not displayed in opeator list");

	}

	@Test(groups = { "SmokeTest" }, priority = 47)
	public void createOperatorWithDuplicateEmailIDAndToasterDisplayed() throws InterruptedException {
		Assert.assertTrue(tm.createOperatorWithDuplicateEmailIDAndToasterDisplayed(),
				"operator Created with duplicate name or wrong toaster displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 48)
	public void availabilityOfCreatedOpWithSameEmail() throws InterruptedException {
		Assert.assertTrue(tm.availabilityOfCreatedOpWithSameEmail(), "User created with Duplicated Email");

	}

	@Test(groups = { "SmokeTest" }, priority = 49)
	public void toasterValidationOnCreateUserDuplicateEmail() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnCreateUserDuplicateEmail(), "User created with Duplicated Email");

	}

	@Test(groups = { "SmokeTest" }, priority = 50)
	public void createUserWithoutEmpIDAndCheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.createUserWithoutEmpIDAndCheckToaster(),
				"Unable to create an operator without employee ID");

	}

	@Test(groups = { "SmokeTest" }, priority = 51)
	public void toasterValidationOnCreateOperatorWithoutEmpID() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnCreateOperatorWithoutEmpID(),
				"Wrong toaster message displayed after creating a operator without employee id");

	}

	@Test(groups = { "SmokeTest" }, priority = 52)
	public void verifyAvailabilityOfTheCreatedOpInOperatorList() throws InterruptedException {
		Assert.assertTrue(tm.verifyAvailabilityOfTheCreatedOpInOperatorList(),
				"The Operator Created without EMployee ID is not present in the operator list");

	}

	@Test(groups = { "SmokeTest" }, priority = 53)
	public void headerValidationForOperatorRoleTab() throws InterruptedException {
		Assert.assertTrue(tm.headerValidationForOperatorRoleTab(), "Operator Role Header nor diaplyed");

	}

	@Test(groups = { "SmokeTest" }, priority = 54)
	public void verifyavailableFieldsUnderOperatorRoleTab() throws InterruptedException {
		Assert.assertTrue(tm.availableFieldsUnderOperatorRoleTab(), "Some missing fields in Operator role tab");

	}

	@Test(groups = { "SmokeTest" }, priority = 55)
	public void createNewRoleAndChecktoaster() throws InterruptedException {
		Assert.assertTrue(tm.createNewRoleAndChecktoaster(),
				"Operator role not created or Toaster message not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 56)
	public void toasterMsgValidationOnCreateRole() throws InterruptedException {
		Assert.assertTrue(tm.toasterMsgValidationOnCreateRole(),
				"Wrong Toaster displayed after creating new Operator role");

	}

	@Test(groups = { "SmokeTest" }, priority = 57)
	public void createdRoleDisplayedInOpRoleList() throws InterruptedException {
		Assert.assertTrue(tm.createdRoleDisplayedInOpRoleList(), "Operator role not displayed in the created list");

	}

	@Test(groups = { "SmokeTest" }, priority = 58)
	public void searchBoxFunctionalityInoperatorRoleTab() throws InterruptedException {
		Assert.assertTrue(tm.searchBoxFunctionalityInoperatorRoleTab(),
				"Search box functionality is not working in operator role tab");

	}

	@Test(groups = { "SmokeTest" }, priority = 59)
	public void createdRoleAvailableUnderCreateNewOperator() throws InterruptedException {
		Assert.assertTrue(tm.createdRoleAvailableUnderCreateNewOperator(), "created role not found ");

	}

	@Test(groups = { "SmokeTest" }, priority = 60)
	public void editOpRoleAndChecktoaster() throws InterruptedException {
		Assert.assertTrue(tm.editOpRoleAndChecktoaster(), "Operator Role Not edited or toaster not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 61)
	public void toasterValidationOnEditOpRole() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnEditOpRole(), "Wrong toaster displayed on edit operator");

	}

	@Test(groups = { "SmokeTest" }, priority = 62)
	public void editedRoleIsUpdatedINroleList() throws InterruptedException {
		Assert.assertTrue(tm.editedRoleIsUpdatedINroleList(), "Edited Operator role not present in the list");

	}

	@Test(groups = { "SmokeTest" }, priority = 63)
	public void deleteOperatorRoleAndCheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.deleteOperatorRoleAndCheckToaster(),
				"Operator Role not deleted or Toaster message not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 64)
	public void toasterValidationOnDeleteOpRole() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnDeleteOpRole(),
				"Wrong Taster message displayed on delete operator role");

	}

	@Test(groups = { "SmokeTest" }, priority = 65)
	public void deletedRoleNotPresentInroleList() throws InterruptedException {
		Assert.assertTrue(tm.deletedRoleNotPresentInroleList(),
				"operator role displayed in Operator role list after delete");

	}

	@Test(groups = { "SmokeTest" }, priority = 66)
	public void createRoleWithDuplicateNameAndCheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.createRoleWithDuplicateNameAndCheckToaster(),
				"User is able to create duplicate Roles or Toaster not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 67)
	public void toasterValidationOnCreateDuplicateOperatorRole() throws InterruptedException {
		Assert.assertTrue(tm.toasterValidationOnCreateDuplicateOperatorRole(),
				"User is able to create duplicate Roles or Toaster not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 68)
	public void deleteDuplicateRole() throws InterruptedException {
		Assert.assertTrue(tm.deleteOperatorRoleAndCheckToaster(), "User is unable to create the duplicate user role");
		driver.findElement(tm.searchBox);
	}

	@Test(groups = { "SmokeTest" }, priority = 69)
	public void createRoleWithApostropheSymbolAndValidateToaster() throws InterruptedException {
		Assert.assertTrue(tm.createRoleWithApostropheSymbolAndValidateToaster(),
				"User is unable to create a role with Apostrophe Symbol");

	}

	@Test(groups = { "SmokeTest" }, priority = 70)
	public void verifyNoRolesDeletedAfterCreatingRolesWithApostropheSymbol() throws InterruptedException {
		Assert.assertTrue(tm.verifyNoRolesDeletedAfterCreatingRolesWithApostropheSymbol(),
				"Roles Deleted After creating team With ApostropheSymbol");

	}

	@Test(groups = { "SmokeTest" }, priority = 71)
	public void toasterMsgValidationOnCreateRoleWithApostropheSymbol() throws InterruptedException {
		Assert.assertTrue(tm.toasterMsgValidationOnCreateRoleWithApostropheSymbol(),
				"No toaster displayed or Wrong toaster message displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 72)
	public void createNewTeamWithWithApostropheSymbol() throws InterruptedException {
		Assert.assertTrue(tm.createNewTeamWithWithApostropheSymbol(), "Unable to create team With ApostropheSymbol");

	}

	@Test(groups = { "SmokeTest" }, priority = 73)
	public void toasterMsgValidationOnCreateTeamWithApostropheSymbol() throws InterruptedException {
		Assert.assertTrue(tm.toasterMsgValidationOnCreateTeamWithApostropheSymbol(),
				"Unable to create team With ApostropheSymbol - Wrong or blank toaster displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 74)
	public void verifyNoOperatorTeamsDeletedAfterCreatingRolesWithApostropheSymbol() throws InterruptedException {
		Assert.assertTrue(tm.verifyNoOperatorTeamsDeletedAfterCreatingRolesWithApostropheSymbol(),
				"Teams deleted after creating new team With ApostropheSymbol");

	}

	@Test(groups = { "SmokeTest" }, priority = 75)
	public void createoperatorWithDuplicateRFID() throws InterruptedException {
		Assert.assertTrue(tm.createoperatorWithDuplicateRFID(), "User can create operator with duplicte RFID UID");

	}

	@Test(groups = { "SmokeTest" }, priority = 76)
	public void toasterMsgValidationOnCreateOperatorWithDuplicateRFID() throws InterruptedException {
		Assert.assertTrue(tm.toasterMsgValidationOnCreateOperatorWithDuplicateRFID(),
				"User can create operator with duplicte RFID UID - wrong or no toaster displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 77)
	public void createoperatorWithDuplicateEmpID() throws InterruptedException {
		Assert.assertTrue(tm.createoperatorWithDuplicateEmpID(), "User can create operator with duplicte  Employee ID");

	}

	@Test(groups = { "SmokeTest" }, priority = 78)
	public void toasterMsgValidationOnCreateOperatorWithDuplicateEmpID() throws InterruptedException {
		Assert.assertTrue(tm.toasterMsgValidationOnCreateOperatorWithDuplicateEmpID(),
				"User can create operator with duplicte Employee ID - wrong or no toaster displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 79)
	public void manageTeamAndCheckToaster() throws InterruptedException {
		Assert.assertTrue(tm.manageTeamAndCheckToaster(), "Manage Team is not working or no toaster displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 80)
	public void manageTeamToasterValidation() throws InterruptedException {
		Assert.assertTrue(tm.manageTeamToasterValidation(), "Manage Team is not working or no toaster displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 81)
	public void operatorTeamIsUpdatedBymanageTeamFunctionality() throws InterruptedException {
		Assert.assertTrue(tm.operatorTeamIsUpdatedBymanageTeamFunctionality(), "Operator Team Not updated");

	}

	@Test(groups = { "SmokeTest" }, priority = 82)
	public void skillMatrixHeaderVal() throws InterruptedException {
		Assert.assertTrue(tm.skillMatrixHeaderVal(), "Skill Matrix header not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 83)
	public void availableFieldsUnderSkillMatrix() throws InterruptedException {
		Assert.assertTrue(tm.availableFieldsUnderSkillMatrix(), "Missing Value in Skill matrix in the header section");

	}

	@Test(groups = { "SmokeTest" }, priority = 84)
	public void uploadAndDownloadBtnAvailable() throws InterruptedException {
		Assert.assertTrue(tm.uploadAndDownloadBtnAvailable(),
				"Upload skill matrix or download skill matrix button not available ");

	}

}
