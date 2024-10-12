package com.qa.bps.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.bps.pages.IAM;
import org.testng.annotations.DataProvider;

public class IAMTest extends BaseTest {
	Logger log = Logger.getLogger(IAM.class);

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------IAM Page-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
//		 -------------
//		navigateTo.addValueToEventProp();

//		navigateTo.LattestPublishedPlan();

//		String productName = navigateTo.GetProductDetailsFromPlanner();

//		String firstTaskName = navigateTo.findFirstTaskFromPlanner();

//		navigateTo.addValueToEventProp();

//		navigateTo.VSB();

//		vsbpage.productDetails(productName, firstTaskName);
//-------

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void PreReq() throws InterruptedException {
		iam.preReq();
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void ConfigPasswordPolicy() throws InterruptedException {
		iam.configurePasswordPolicy();
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void navigateToIAM() throws InterruptedException {
		iam.navigateToIAM();
	}

//	 Verify user is able to create group and success message is displayed
	@Test(groups = { "SmokeTest" }, priority = 4)
	public void VerifyUserCanCreateAnUser() throws InterruptedException {
		Assert.assertTrue(iam.CreateUser(), "User Not Created Or Created User Not available in IAM");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void userCreationToaster() {
		Assert.assertTrue(iam.verifyToasterMessageAfterCreatingNewUser(),
				"Toaster Message not displayed or Wrong toaster message displayed After creating new user");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void editUserTest() throws InterruptedException {
		Assert.assertTrue(iam.editUser(),
				"Unable to edit the user/successful toaster message is not matching/displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void editUserToaster() {
		Assert.assertTrue(iam.verifyToasterMessageAfterEditUserDetails(),
				"Toaster Message not displayed or Wrong toaster message displayed After editing user details");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void deleteUserTest() throws InterruptedException {
		Assert.assertTrue(iam.deleteUser(),
				"Unable to delete the user/successful toaster message is not matching/displayed ");

	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void deleteUserToaster() {
		Assert.assertTrue(iam.verifyToasterMessageAfterDeletingUser(),
				"Toaster Message not displayed or Wrong toaster message displayed After deleting user ");
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void CreateUserGroups() throws InterruptedException {
		Assert.assertTrue(iam.CreateUserGroups(), "Unable to create user group");

	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void createUserGroupToaster() {
		Assert.assertTrue(iam.verifyToasterMessageAfterCreatingUserGroup(),
				"Toaster Message not displayed or Wrong toaster message displayed After deleting user " + "i.e: "
						+ iam.ToasterMsg);
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void editGrpTest() throws InterruptedException {

		Assert.assertTrue(iam.editUserGroup(), "Unable to edit user group/Updated toaster message is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void editUserGroupToaster() {
		Assert.assertTrue(iam.verifyToasterMessageAfterEditUserGroup(),
				"Toaster Message not displayed or Wrong toaster message displayed After deleting user " + "i.e: "
						+ iam.ToasterMsg);
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void deleteGrouptest() throws InterruptedException {

		Assert.assertTrue(iam.deleteUserGroup(), "Unable to delete user group/Delete toaster message is not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void deleteUserGroupToaster() {
		Assert.assertTrue(iam.verifyToasterMessageAfterDeleteUserGroup(),
				"Toaster Message not displayed or Wrong toaster message displayed After deleting user " + "i.e: "
						+ iam.ToasterMsg);
	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void IAMRoletest() throws InterruptedException {

		Assert.assertTrue(iam.CreateRole(),
				"Unable to create new role/successful toaster message is not matching/displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void createRoleToaster() {
		Assert.assertTrue(iam.verifyToasterMessageAftercreatingNewRole(),
				"Toaster Message not displayed or Wrong toaster message displayed After deleting user " + "i.e: "
						+ iam.ToasterMsg);
	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void editRoleTest() throws InterruptedException {
		Assert.assertTrue(iam.editUserRole(),
				"Unable to edit the existing role/Successful toaster message is not matching/displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void EditRoleToaster() {
		Assert.assertTrue(iam.verifyToasterMessageAfterEditUserRole(),
				"Toaster Message not displayed or Wrong toaster message displayed After deleting user " + "i.e: "
						+ iam.ToasterMsg);
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void deleteRoletest() throws InterruptedException {

		Assert.assertTrue(iam.deleteUserRole(), "User Role not deleted");

	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void DeleteRoleToaster() {
		Assert.assertTrue(iam.deleteRoleToaster(),
				"Toaster Message not displayed or Wrong toaster message displayed After deleting user " + "i.e: "
						+ iam.ToasterMsg);
	}

//	@Test(groups = { "SmokeTest" }, priority = 12)

	public void verifyFunctOfAcessModifierFalse() throws InterruptedException {
		Assert.assertTrue(iam.verifyFunctOfAcessModifierTest(),
				"After converting feature flag to false , action buttons are displaying");
	}

//	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifyFunctOfAcessModifierTrue() throws InterruptedException {
		Assert.assertTrue(iam.verifyFunctOfAcessModifierTrueTest(),
				"After converting feature flag to true , action buttons are not displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyUserCanCreateWithEmployeeId() throws InterruptedException {
		Assert.assertTrue(iam.verifyUserCanCreateWithEmployeeIdTest(),
				"User is unable to create with employee id/wrong toaster message is displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void verifyCreatedOperatorIsDisplayed() throws InterruptedException {
		Assert.assertTrue(iam.verifyCreatedOperatorIsDisplayed(), "Created operator is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyUserCanEditEmpId() throws InterruptedException {
		Assert.assertTrue(iam.verifyUserCanEditEmpIdTest(), "User is unable to edit the employee id");
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifyEmpLoyeeIdChangedToNullAfterManageGroup() throws InterruptedException {
		Assert.assertTrue(iam.verifyEmpLoyeeIdChangedToNullAfterManageTeamTest(),
				"After Managing the group employee id chnaged to null");
	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void verifyEmployeeIdChnageToNullAfterResetPwd() throws InterruptedException {
		Assert.assertTrue(iam.verifyEmployeeIdChnageToNullAfterResetPwdTest(),
				"After reset the passward the employee id chnaged to null");
	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void verifyUserCanCreateTheOperatorWithExistingEmpId() throws InterruptedException {
		Assert.assertTrue(iam.verifyUserCanCreateTheOperatorWithExistingEmpIdTest(),
				"User is able create the operator with existing employee id");
	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void verifyTheToasterMsgAfterCreatingUserWithSameEmpId() {
		Assert.assertTrue(iam.verifyTheToasterMsgAfterCreatingUserWithSameEmpIdTest(),
				"Wrong toaster message is displaying while creating user with existing employee id");
	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void verifyUserCanCreateTheOperatorByEnteringSpaceInEmpField() throws InterruptedException {
		Assert.assertTrue(iam.verifyUserCanCreateTheOperatorByEnteringSpaceInEmpFieldTest(),
				"User is able create the operator by entering spaces in employee id");
	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void verifyUserIsAbleToCreateAUserWithSpecialCharacterInFirstName() throws InterruptedException {
		Assert.assertTrue(iam.verifyUserIsAbleToCreateAUserWithSpecialCharacterTest(),
				"Able to created new user by adding special symbole in first name and last name");
	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void verifyUserIsAbleToCreateNewUserByAddingApportstopeInPassword() throws InterruptedException {
		Assert.assertTrue(iam.verifyUserIsAbleToCreateNewUseByAddingApportstopeInPasswordTest(),
				"Unable to create user by adding apportstope symbole in password");
	}

	@Test(groups = { "SmokeTest" }, priority = 33)
	public void verifyUserIsAbleToCreateAUserWithSameEmailId() throws InterruptedException {
		Assert.assertTrue(iam.verifyUserIsAbleToCreateAUserWithSameEmailIdTest(),
				"User is able to created new with existing email id");
	}

	@Test(groups = { "SmokeTest" }, priority = 34)
	public void verifyUserIsAbleToCreateUserWithRfid() throws InterruptedException {
		Assert.assertTrue(iam.verifyUserIsAbleToCreateUserWithRfidTest(),
				"Unable to Create new user with by rfid / Wrong toaster message is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 35)
	public void verifyTheAvlOfUserCreatedWithRfid() throws InterruptedException {
		Assert.assertTrue(iam.verifyTheAvlOfUserCreatedWithRfidTest(),
				"User created with Rfid is not displaying in user list");
	}

	@Test(groups = { "SmokeTest" }, priority = 36)
	public void verifyUserIsAbleToCreateUserWithSameRfid() throws InterruptedException {
		Assert.assertTrue(iam.verifyUserIsAbleToCreateUserWithSameRfidTest(),
				"User is able to created employee with same RFID");
	}

	@Test(groups = { "SmokeTest" }, priority = 37)
	public void verifyTheAvlOfCreatedUserWithExistingRFID() throws InterruptedException {
		Assert.assertTrue(iam.verifyTheAvlOfCreatedUserWithExistingRFIDTest(),
				"User created with Existing RFID is displaying in user list");
	}

	@Test(groups = { "SmokeTest" }, priority = 38)
	public void verifyPasswordResetWithExistingPassword() throws InterruptedException {
		Assert.assertTrue(iam.verifyPasswordResetWithExistingPasswordTest(),
				"User is able to reset the password with old password");
	}

}
