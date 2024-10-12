package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionalAreaTest extends BaseTest {
	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------Functional Area Page-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void verifyUserCanNavigateFunctionalArea() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCanNavigateFunctionalAreaTest());
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void verifyAvailabilityOfSearchBox() throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfSearchBox());
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void verifyAvailabilityOfNewFunctionalArea() throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfNewFunctionalArea());
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void verifyAvailabilityOfFieldsToCreateFunctionalArea() throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfFieldsToCreateFunctionalArea());
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void verifyUserCanCreateNewFunctionalArea() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCanCreateNewFunctionalArea());
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void verifyAvailabilityOfCreatedFunctionalArea() throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfCreatedFunctionalArea());
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void verifyUserCanEditCreatedFunctionalArea() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCanEditCreatedFunctionalArea());
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void verifyUserCreatedFunctionalAreaEditedOrNot() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCreatedFunctionalAreaEditedOrNot());
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void verifyuserCanDeleteFunctionalArea() throws InterruptedException {
		Assert.assertTrue(fa.verifyuserCanDeleteFunctionalArea());
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void verifyAvailabilityOfDeletedFunctionalArea() throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfDeletedFunctionalArea());
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void verifyUserCanCreateFunctionalAreaByAddinghApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCanCreateFunctionalAreaByAddinghApportstopeSymbol());
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyAvailabilityOfCreatedFunctionalAreaByAddinghApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfCreatedFunctionalAreaByAddinghApportstopeSymbol());
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifyUserCanEditCreatedFunctionalAreaByAddinghApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCanEditCreatedFunctionalAreaByAddinghApportstopeSymbol());
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void verifyUserEditedFunctionalAreaByAddinghApportstopeSymbolIsEdittedOrNot() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserEditedFunctionalAreaByAddinghApportstopeSymbolIsEdittedOrNot());
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void verifyUserCanDeleteFunctionalAreaCreatedByAddinghApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCanDeleteFunctionalAreaCreatedByAddinghApportstopeSymbol());
	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void verifyAvailabilityOfDeletedFunctionalAreaCreatedByAddingApportstopeSymbol()
			throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfDeletedFunctionalAreaCreatedByAddingApportstopeSymbol());
	}
	@Test(groups = { "SmokeTest" }, priority = 17)
	public void verifyUserCanCreateDupilcateFunctionalArea() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCanCreateDupilcateFunctionalArea());
	}
	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyAvailabilityOfDupilcateFunctionalArea() throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfDupilcateFunctionalArea());
	}
	
	//Department test cases 
	
	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifyUserCanNaviagteDepartment() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCanNaviagteDepartment());
	}
	@Test(groups = { "SmokeTest" }, priority = 20)
	public void verifyAvailabilityOfSearchBoxOFDepartment() throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfSearchBoxOFDepartment());
	}
	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyAvailabilityOfNewDepartmentTab() throws InterruptedException {
		Assert.assertTrue(fa. verifyAvailabilityOfNewDepartmentTab());
	}
	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyAvailabilityOfFieldsToCreateNewDepartment() throws InterruptedException {
		Assert.assertTrue(fa. verifyAvailabilityOfFieldsToCreateNewDepartment());
	}
	@Test(groups = { "SmokeTest" }, priority = 23)
	public void verifyUserCanCreateNewDepartment() throws InterruptedException {
		Assert.assertTrue(fa. verifyUserCanCreateNewDepartment());
	}
	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyAvailabilityOfCreatedDepartment() throws InterruptedException {
		Assert.assertTrue(fa. verifyAvailabilityOfCreatedDepartment());
	}
	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifyUsercanEditCreatedDepartment() throws InterruptedException {
		Assert.assertTrue(fa. verifyUsercanEditCreatedDepartment());
	}
	@Test(groups = { "SmokeTest" }, priority = 26)
	public void verifyUserEditedDepartmentEdittedOrNot() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserEditedDepartmentEdittedOrNot());
	}
	@Test(groups = { "SmokeTest" }, priority = 27)
	public void verifyUserCanDeleteCreatedDepartment() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCanDeleteCreatedDepartment());
	}
	@Test(groups = { "SmokeTest" }, priority = 28)
	public void verifyAvailabilityOfDeletedDepartemtName() throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfDeletedDepartemtName());
	}
	@Test(groups = { "SmokeTest" }, priority = 29)
	public void verifyUserCanCreateNewDepartmentByAddingApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCanCreateNewDepartmentByAddingApportstopeSymbol(),"User is unable to create department by adding ApportstopeSymbol");
	}
	@Test(groups = { "SmokeTest" }, priority = 30)
	public void verifyAvailabilityOfUserCreateNewDepartmentByAddingApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfUserCreateNewDepartmentByAddingApportstopeSymbol());
	}
	@Test(groups = { "SmokeTest" }, priority = 31)
	public void verifyUsercanEditCreatedDepartmentByAddingApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(fa.verifyUsercanEditCreatedDepartmentByAddingApportstopeSymbol());
	}
	@Test(groups = { "SmokeTest" }, priority = 32)
	public void verifyUserEditedDepartmentEdittedOrNotByAddingApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserEditedDepartmentEdittedOrNotByAddingApportstopeSymbol());
	}
	@Test(groups = { "SmokeTest" }, priority = 33)
	public void verifyUserCanDeleteCreatedDepartmentByAddingApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(fa.verifyUserCanDeleteCreatedDepartmentByAddingApportstopeSymbol());
	}
	@Test(groups = { "SmokeTest" }, priority = 34)
	public void verifyAvailabilityOfDeletedDepartemtNameByAddingApportstopeSymbol() throws InterruptedException {
		Assert.assertTrue(fa.verifyAvailabilityOfDeletedDepartemtNameByAddingApportstopeSymbol());
	}
}