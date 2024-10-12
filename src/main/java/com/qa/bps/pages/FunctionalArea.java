package com.qa.bps.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FunctionalArea {
	WebDriver driver;
	Navigation navigateTo;
	private By materDataTab = By.xpath("//img[@alt='masterDataImage']");
	private By functionalAreaTab = By.xpath("//div[@title='Functional Area']");
	private By newfunctionalTab = By.xpath("//a[contains(text(),'New Functional Area')]");
	private By searchBox = By.xpath("//input[@placeholder = 'Search..']");
	private By newfunctinalarea = By.xpath("//button[@class='button-primary']");
	private By functionalareafield = By.xpath("(//input[@id='description'])[2]");
	private By descriptrionfield = By.xpath("//input[@id='displayName']");
	private By parentfunctionalareafield = By.xpath("//input[@role='combobox']");
	private By activecheck = By.xpath("(//div[@class='col-sm-6 col-md-6 col-lg-6'])[6]");

	private By savebtn = By.xpath("(//button[.=' Save '])[2]");
	private By successtoaster = By.xpath("//div[@aria-live='polite']");
	private By functionalareatext = By.xpath("(//div[@class='tabulator-cell'])[3]");
	private By threedot = By.xpath("(//div[@class='tabulator-cell text-center'])[1]/i");
	private By editfunctionalarea = By.xpath("(//div[@class='tabulator-menu-item'])[1]");
	private By deletefunctionalarea = By.xpath("(//div[@class='tabulator-menu-item'])[2]");
	private By deletebtn = By.xpath("(//button[@class='btn btn-sm'])[3]");
	private By toastermsgexist = By.xpath("//div[@role='alertdialog']");
	private By duplicatefunctionaltext = By.xpath("(//div[@role='row'])");
	private By departmentTab = By.xpath("//div[@title='Department']");
	private By newdepartmenttab = By.xpath("//a[contains(text(),'New Department')]");
	private By departmentfield = By.xpath("(//input[@id='description'])[2]");
	private By deptartmentdescriptionfiled = By.xpath("//input[@id='displayName']");
	private By locationdropdown = By.xpath("//input[@role='combobox']");
	private By departmenttextfield = By.xpath("(//input[@id='description'])[2]");
	private By departmentdescriptiontextfield = By.xpath("//input[@name='displayName']");
	private By locationvalue = By.xpath("//div[@role='option']");
	private By successstoaster = By.xpath("//div[@aria-live='polite']");
	private By testdepartmenttext = By.xpath("//input[@placeholder='Search..']");
	private By editdepartment = By.xpath("(//div[@class='tabulator-menu-item'])[1]");
	private By deletedepartment = By.xpath("(//div[@class='tabulator-menu-item'])[2]");

	String functionalAreaValue;
	String departmentname;
	List<WebElement> Fieldlist = new ArrayList<WebElement>();

	public FunctionalArea(WebDriver driver) {
		this.driver = driver;
		navigateTo = new Navigation(driver);

	}

	public boolean verifyUserCanNavigateFunctionalAreaTest() throws InterruptedException {
		navigateTo.DataManagement();
		driver.findElement(materDataTab).click();
		Thread.sleep(3000);
		driver.findElement(functionalAreaTab).click();
		try {
			driver.findElement(newfunctionalTab).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyAvailabilityOfSearchBox() {

		try {
			driver.findElement(searchBox).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvailabilityOfNewFunctionalArea() throws InterruptedException {
		Thread.sleep(3000);
		try {
			driver.findElement(newfunctinalarea).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyAvailabilityOfFieldsToCreateFunctionalArea() {
		driver.findElement(newfunctinalarea).click();
		try {
			driver.findElement(functionalareafield).isDisplayed();
			driver.findElement(descriptrionfield).isDisplayed();
			driver.findElement(parentfunctionalareafield).isDisplayed();
			driver.findElement(activecheck).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanCreateNewFunctionalArea() throws InterruptedException {
		String randOme = RandomStringUtils.randomAlphabetic(5);
		functionalAreaValue = "TestFunctional" + randOme;
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(newfunctinalarea).click();
		Thread.sleep(3000);
		driver.findElement(functionalareafield).sendKeys(functionalAreaValue);
		Thread.sleep(2000);
		driver.findElement(descriptrionfield).sendKeys(functionalAreaValue);
		Thread.sleep(2000);
		driver.findElement(savebtn).click();
		Thread.sleep(1500);
		String toastermsgg = "null";
		try {
			toastermsgg = driver.findElement(successtoaster).getText();

		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toastermsgg + "*");
		if (toastermsgg.equals("Functional area saved Successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvailabilityOfCreatedFunctionalArea() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue);
		try {
			driver.findElement(functionalareatext).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanEditCreatedFunctionalArea() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue);
		Thread.sleep(3000);
		driver.findElement(threedot).click();
		Thread.sleep(2000);
		driver.findElement(editfunctionalarea).click();

		Thread.sleep(3000);
		driver.findElement(functionalareafield).clear();
		driver.findElement(functionalareafield).sendKeys(functionalAreaValue + "update");
		Thread.sleep(4000);
		driver.findElement(savebtn).click();
		Thread.sleep(1000);
		String toastermsgg = "null";
		try {
			toastermsgg = driver.findElement(successtoaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toastermsgg + "*");
		if (toastermsgg.equals("Functional area saved Successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCreatedFunctionalAreaEditedOrNot() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue + "update");
		Thread.sleep(2000);
		String updatedfunctonalarea = "null";
		driver.findElement(functionalareafield).getAttribute("ng-reflect-model");
		if (updatedfunctonalarea.equals(functionalAreaValue + "update")) {
			return false;
		} else {
			return true;
		}
	}

	public boolean verifyuserCanDeleteFunctionalArea() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue);
		Thread.sleep(2000);
		driver.findElement(threedot).click();
		Thread.sleep(2000);
		driver.findElement(deletefunctionalarea).click();
		Thread.sleep(1000);
		driver.findElement(deletebtn).click();
		Thread.sleep(1000);
		String toastermsgg = "null";
		try {
			toastermsgg = driver.findElement(successtoaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toastermsgg + "*");
		if (toastermsgg.equals("Functional area deleted Successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAvailabilityOfDeletedFunctionalArea() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue);
		try {
			driver.findElement(functionalareatext).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyUserCanCreateFunctionalAreaByAddinghApportstopeSymbol() throws InterruptedException {
		String randOme = RandomStringUtils.randomAlphabetic(5);
		functionalAreaValue = "TestFunctional" + randOme;
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(newfunctinalarea).click();
		Thread.sleep(3000);
		driver.findElement(functionalareafield).sendKeys(functionalAreaValue + "'");
		Thread.sleep(2000);
		driver.findElement(descriptrionfield).sendKeys(functionalAreaValue + "'");
		Thread.sleep(2000);
		driver.findElement(savebtn).click();
		Thread.sleep(1500);
		String toastermsgg = "null";
		try {
			toastermsgg = driver.findElement(successtoaster).getText();

		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toastermsgg + "*");
		if (toastermsgg.equals("Functional area saved Successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvailabilityOfCreatedFunctionalAreaByAddinghApportstopeSymbol() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue + "'");
		try {
			driver.findElement(functionalareatext).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanEditCreatedFunctionalAreaByAddinghApportstopeSymbol() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue + "'");
		Thread.sleep(3000);
		driver.findElement(threedot).click();
		Thread.sleep(2000);
		driver.findElement(editfunctionalarea).click();
		Thread.sleep(3000);
		driver.findElement(functionalareafield).clear();
		driver.findElement(functionalareafield).sendKeys(functionalAreaValue + "update'");
		Thread.sleep(4000);
		driver.findElement(savebtn).click();
		Thread.sleep(1000);
		String toastermsgg = "null";
		try {
			toastermsgg = driver.findElement(successtoaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toastermsgg + "*");
		if (toastermsgg.equals("Functional area saved Successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserEditedFunctionalAreaByAddinghApportstopeSymbolIsEdittedOrNot()
			throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue + "update'");
		Thread.sleep(2000);
		String updatedfunctonalarea = "null";
		driver.findElement(functionalareafield).getAttribute("ng-reflect-model");
		if (updatedfunctonalarea.equals(functionalAreaValue + "update'")) {
			return false;
		} else {
			return true;
		}
	}

	public boolean verifyUserCanDeleteFunctionalAreaCreatedByAddinghApportstopeSymbol() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue + "'");
		Thread.sleep(2000);
		driver.findElement(threedot).click();
		Thread.sleep(2000);
		driver.findElement(deletefunctionalarea).click();
		Thread.sleep(1000);
		driver.findElement(deletebtn).click();
		Thread.sleep(1000);
		String toastermsgg = "null";
		try {
			toastermsgg = driver.findElement(successtoaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toastermsgg + "*");
		if (toastermsgg.equals("Functional area deleted Successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvailabilityOfDeletedFunctionalAreaCreatedByAddingApportstopeSymbol()
			throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue +"'");
		try {
			driver.findElement(functionalareatext).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyUserCanCreateDupilcateFunctionalArea() throws InterruptedException {
		String randOme = RandomStringUtils.randomAlphabetic(5);
		functionalAreaValue = "TestFunctional" + randOme;
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(newfunctinalarea).click();
		Thread.sleep(3000);
		driver.findElement(functionalareafield).sendKeys(functionalAreaValue);
		Thread.sleep(2000);
		driver.findElement(descriptrionfield).sendKeys(functionalAreaValue);
		Thread.sleep(2000);
		driver.findElement(savebtn).click();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue);
		Thread.sleep(1500);
		driver.findElement(newfunctinalarea).click();
		Thread.sleep(3000);
		driver.findElement(functionalareafield).sendKeys(functionalAreaValue);
		Thread.sleep(2000);
		driver.findElement(descriptrionfield).sendKeys(functionalAreaValue);
		Thread.sleep(2000);
		driver.findElement(savebtn).click();
		Thread.sleep(4000);
		String toastermsggg = "null";
		try {
			toastermsggg = driver.findElement(toastermsgexist).getText();

		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toastermsggg + "*");
		if (toastermsggg.equals("Functional area " + functionalAreaValue + " already exists")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAvailabilityOfDupilcateFunctionalArea() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(functionalAreaValue);
		List<WebElement> displayfunctionalarea = driver.findElements(duplicatefunctionaltext);

		int countOfDisplayedFunctionalArea = displayfunctionalarea.size();

		System.out.println("count of displayed functional area " + countOfDisplayedFunctionalArea);
		if (countOfDisplayedFunctionalArea > 1) {
			return false;
		} else {
			return true;
		}

	}
	// Department test cases
	
	public boolean verifyUserCanNaviagteDepartment() throws InterruptedException {
		driver.findElement(materDataTab).click();
		Thread.sleep(2000);
		driver.findElement(departmentTab).click();
		try {
			driver.findElement(newdepartmenttab).isDisplayed();
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}
	public boolean verifyAvailabilityOfSearchBoxOFDepartment() {
		try {
			driver.findElement(searchBox).isDisplayed();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public boolean verifyAvailabilityOfNewDepartmentTab() throws InterruptedException {
		Thread.sleep(2000);
		try {
			driver.findElement(newdepartmenttab).isDisplayed();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean verifyAvailabilityOfFieldsToCreateNewDepartment() throws InterruptedException {
		driver.findElement(newdepartmenttab).click();
		try {
			driver.findElement(departmentfield).isDisplayed();
			driver.findElement(deptartmentdescriptionfiled).isDisplayed();
			driver.findElement(locationdropdown).isDisplayed();
			return true;
			
		}catch(Exception e ) {
			return false;
		}
		
		
	}
	public boolean verifyUserCanCreateNewDepartment() throws InterruptedException {
		String randOme = RandomStringUtils.randomAlphabetic(5);
		 departmentname = "TestDepartment"+ randOme;
		 driver.navigate().refresh();
		 Thread.sleep(4000);
		 driver.findElement(newdepartmenttab).click();
		 Thread.sleep(3000);
		 driver.findElement(departmenttextfield).sendKeys(departmentname);
		 Thread.sleep(3000);
		 driver.findElement(departmentdescriptiontextfield).sendKeys(departmentname);
		 Thread.sleep(3000);
		 driver.findElement(locationdropdown).click();
		 Thread.sleep(2000);
		 driver.findElement(locationvalue).click();
		 Thread.sleep(2000);
		 driver.findElement(savebtn).click();
		 Thread.sleep(1500);
		 String toastermsgg = "null";
		 try {
			 toastermsgg = driver.findElement(successstoaster).getText();
		 }
		 catch (Exception e) {

			}
			System.out.println("Toaster message is *" + toastermsgg + "*");
			if (toastermsgg.equals("Department saved Successfully!")) {
				return true;
			} else {
				return false;
			}
		 
	}
	public boolean verifyAvailabilityOfCreatedDepartment() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(searchBox).sendKeys(departmentname);
		try {
			driver.findElement(testdepartmenttext).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean verifyUsercanEditCreatedDepartment() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(departmentname);
		Thread.sleep(3000);
		driver.findElement(threedot).click();
		Thread.sleep(2000);
		driver.findElement(editdepartment).click();
		Thread.sleep(3000);
		driver.findElement(departmenttextfield).clear();
		driver.findElement(departmenttextfield).sendKeys(departmentname + "update");
		Thread.sleep(4000);
		driver.findElement(departmentdescriptiontextfield).clear();
		driver.findElement(departmentdescriptiontextfield).sendKeys(departmentname + "update");
		 Thread.sleep(2000);
		driver.findElement(savebtn).click();
		Thread.sleep(1000);
		String toastermsgg = "null";
		try {
			toastermsgg = driver.findElement(successstoaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toastermsgg + "*");
		if (toastermsgg.equals("Department saved Successfully!")) {
			return true;
		} else {
			return false;
		}

	}
	public boolean verifyUserEditedDepartmentEdittedOrNot() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(departmentname + "update");
		Thread.sleep(2000);
		String updateddepartment = "null";
		driver.findElement(testdepartmenttext).getAttribute("ng-reflect-model");
		if (updateddepartment.equals(departmentname + "update")) {
			return false;
		} else {
			return true;
		}
		
	}
	public boolean verifyUserCanDeleteCreatedDepartment() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(departmentname);
		Thread.sleep(2000);
		driver.findElement(threedot).click();
		Thread.sleep(2000);
		driver.findElement(deletedepartment).click();
		Thread.sleep(1000);
		driver.findElement(deletebtn).click();
		Thread.sleep(1000);
		String toastermsgg = "null";
		try {
			toastermsgg = driver.findElement(successstoaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toastermsgg + "*");
		if (toastermsgg.equals("Department deleted Successfully!")) {
			return true;
		} else {
			return false;
		}
	}
	public boolean verifyAvailabilityOfDeletedDepartemtName() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(departmentname);
		try {
			driver.findElement(testdepartmenttext).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean verifyUserCanCreateNewDepartmentByAddingApportstopeSymbol() throws InterruptedException {
		String randOme = RandomStringUtils.randomAlphabetic(5);
		 departmentname = "TestDepartment"+ randOme;
		 driver.navigate().refresh();
		 Thread.sleep(4000);
		 driver.findElement(newdepartmenttab).click();
		 Thread.sleep(3000);
		 driver.findElement(departmenttextfield).sendKeys(departmentname+"'");
		 Thread.sleep(3000);
		 driver.findElement(departmentdescriptiontextfield).sendKeys(departmentname+"'");
		 Thread.sleep(3000);
		 driver.findElement(locationdropdown).click();
		 Thread.sleep(2000);
		 driver.findElement(locationvalue).click();
		 Thread.sleep(2000);
		 driver.findElement(savebtn).click();
		 Thread.sleep(1500);
		 String toastermsgg = "null";
		 try {
			 toastermsgg = driver.findElement(successstoaster).getText();
		 }
		 catch (Exception e) {

			}
			System.out.println("Toaster message is *" + toastermsgg + "*");
			if (toastermsgg.equals("Department saved Successfully!")) {
				return false;
			} else {
				return true;
			}
		 
	}
	public boolean verifyAvailabilityOfUserCreateNewDepartmentByAddingApportstopeSymbol() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(departmentname+ "'");
		try {
			driver.findElement(testdepartmenttext).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean verifyUsercanEditCreatedDepartmentByAddingApportstopeSymbol() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(departmentname);
		Thread.sleep(3000);
		driver.findElement(threedot).click();
		Thread.sleep(2000);
		driver.findElement(editdepartment).click();
		Thread.sleep(3000);
		driver.findElement(departmenttextfield).clear();
		driver.findElement(departmenttextfield).sendKeys(departmentname + "'");
		Thread.sleep(4000);
		driver.findElement(departmentdescriptiontextfield).clear();
		driver.findElement(departmentdescriptiontextfield).sendKeys(departmentname + "'");
		 Thread.sleep(2000);
		driver.findElement(savebtn).click();
		Thread.sleep(1000);
		String toastermsgg = "null";
		try {
			toastermsgg = driver.findElement(successstoaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toastermsgg + "*");
		if (toastermsgg.equals("Department saved Successfully!")) {
			return true;
		} else {
			return false;
		}
	}
	public boolean verifyUserEditedDepartmentEdittedOrNotByAddingApportstopeSymbol() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(departmentname + "update");
		Thread.sleep(2000);
		String updateddepartment = "null";
		driver.findElement(testdepartmenttext).getAttribute("ng-reflect-model");
		if (updateddepartment.equals(departmentname + "update")) {
			return false;
		} else {
			return true;
		}
		}
	public boolean verifyUserCanDeleteCreatedDepartmentByAddingApportstopeSymbol() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(departmentname);
		Thread.sleep(2000);
		driver.findElement(threedot).click();
		Thread.sleep(2000);
		driver.findElement(deletedepartment).click();
		Thread.sleep(1000);
		driver.findElement(deletebtn).click();
		Thread.sleep(1000);
		String toastermsgg = "null";
		try {
			toastermsgg = driver.findElement(successstoaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toastermsgg + "*");
		if (toastermsgg.equals("Department deleted Successfully!")) {
			return true;
		} else {
			return false;
		}
	}
	public boolean verifyAvailabilityOfDeletedDepartemtNameByAddingApportstopeSymbol() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(departmentname);
		try {
			driver.findElement(testdepartmenttext).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}