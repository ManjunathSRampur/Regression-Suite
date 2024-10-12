package com.qa.bps.test;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

//import io.netty.handler.timeout.TimeoutException;
// this feature is implimanted in other screen
public class EquipmentSchedulingTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		System.out.println("--------Equipment Scheduling Page--------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"),
				prop.getProperty("manager_password"));
		ctpage = homepage.navigateToControlTower();
		mgr = ctpage.navigateToManager();
		mgr.navigateToEquipmentScheduling();
	}

  @Test(groups = { "SmokeTest" }, priority = 1)
	public void testEquipmentSchDisplay() throws InterruptedException, NoSuchElementException {

		Assert.assertTrue(es.getEquipmentList());

	}

	@Test(groups = { "SmokeTest" }, dependsOnMethods = { "testEquipmentSchDisplay" }, priority = 2)
	public void checkTestSideTaskBtn() throws InterruptedException {

		Assert.assertEquals(es.testSideTaskBtnWorkflow(), Constants.TaskAddMsg,"Unable to add side task/Task Added toaster message is not displayed");

	}

	@Test(groups = { "SmokeTest" }, dependsOnMethods = { "testEquipmentSchDisplay" }, priority = 3)
	public void checkViewSideTask() throws InterruptedException {

		Assert.assertTrue(es.viewSideTaskAdded(),"Task is not added/displayed");

	}
	// Verify the right equipment is displayed when the check box is checked in equipment drop down. 
	//@Test(groups = { "SmokeTest" }, priority = 4)
	public void equipmentDDValidate() throws InterruptedException {

		Assert.assertEquals(es.equipmentValidation(), Constants.EQUIPMENT_VALIDATION,"Selected equipment is not displayed/matching");

	}
	// Verify the View drop down options are displayed
	@Test(groups = { "SmokeTest" }, priority = 5)
	public void viewOptn() throws InterruptedException {

		Assert.assertEquals(es.viewDropDown(), Constants.EQUIPMENT_VIEW_DROPDOWN_OPTIONS_,"View dropdown options are not matching/displayed");

	}

    //Verify all the task and operator checkbox is selected
	@Test(groups = { "SmokeTest" }, priority = 6)
	public void allChkBoxesSelected() throws InterruptedException {

		Assert.assertTrue(es.allChkBoxSelected(),"All checkbox's are not selected");

	}
    //Verify all the operator section is disabled when deselecting the operator checkbox
	@Test(groups = { "SmokeTest" }, priority = 7)
	public void chkBoxDeselect() throws InterruptedException {

		Assert.assertTrue(es.operatorSectiondisplayed(),"Operator section is displayed");

	}

	
}
