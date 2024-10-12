package com.qa.bps.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MasterData {
	WebDriver driver;
	Navigation navigateTo;
	public By masterData = By.xpath("//a[@id='v-pills-master']");
	private By newMasterDataButton = By.xpath("//a[.='New Master Table']");
	private By masterDataNameEle = By.xpath("(//input[@id='description'])[2]");
	private By masterDataDescriptionEle = By.xpath("//input[@id='displayName']");
	private By selectDataCatalogDDEle = By.xpath("(//input[@role='combobox'])[1]");
	private By selectFileTypeDDEle = By.xpath("(//input[@role='combobox'])[2]");
	private By addButtonTagEle = By.xpath("(//input[@id='shortText'])[1]");
	private By editButtonTagEle = By.xpath("(//input[@id='shortText'])[2]");
	private By searchButtonTagEle = By.xpath("(//input[@id='shortText'])[3]");
	private By deleteButtonTagEle = By.xpath("(//input[@id='shortText'])[4]");
	private By activaStatusCheckBoxEle = By.xpath("//input[@id='status']");
	private By optionToSelectEle = By.xpath("//div[@role='option']");
	private By saveButtonEle = By.xpath("(//button[.=' Save '])[2]");
	private By successToaster = By.xpath("//div[@role='alertdialog']");
	private By masterDataDeleteIcon = By.xpath("//button[.=' Delete ']");
	private By createdMasterDataEle;
	private By masterDataEditIcon;

	String masterTableName = "null";

	public MasterData(WebDriver driver) {
		this.driver = driver;
		navigateTo = new Navigation(driver);

	}

	public boolean verifyUserCanNavigateToMasterDataTest() throws InterruptedException {
		navigateTo.DataManagement();
		driver.findElement(masterData).click();
		Thread.sleep(2000);
		try {
			driver.findElement(newMasterDataButton).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyTheAvailabelFiledsToCreateMasterDataTest() throws InterruptedException {
		driver.findElement(masterData).click();
		Thread.sleep(2000);
		try {
			driver.findElement(masterDataNameEle).isDisplayed();
			driver.findElement(masterDataDescriptionEle).isDisplayed();
			driver.findElement(selectDataCatalogDDEle).isDisplayed();
			driver.findElement(selectFileTypeDDEle).isDisplayed();
			driver.findElement(addButtonTagEle).isDisplayed();
			driver.findElement(editButtonTagEle).isDisplayed();
			driver.findElement(searchButtonTagEle).isDisplayed();
			driver.findElement(deleteButtonTagEle).isDisplayed();
			driver.findElement(activaStatusCheckBoxEle).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;

		}
	}

	public boolean verifyUserCanCreateMasterDataTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		masterTableName = "TestMasterData" + RandomStringUtils.randomAlphabetic(5);
		String addButtonValue = "TestAdd" + RandomStringUtils.randomAlphabetic(5);
		String editButtonValue = "TestEdit" + RandomStringUtils.randomAlphabetic(5);
		String searchButtonValue = "TestSearch" + RandomStringUtils.randomAlphabetic(5);
		String deleteButtonValue = "TestDelete" + RandomStringUtils.randomAlphabetic(5);
		driver.findElement(newMasterDataButton).click();
		Thread.sleep(1000);
		driver.findElement(masterDataNameEle).sendKeys(masterTableName);
		Thread.sleep(500);
		driver.findElement(masterDataDescriptionEle).sendKeys(masterTableName);
		Thread.sleep(500);
		driver.findElement(selectDataCatalogDDEle).click();
		Thread.sleep(500);
		driver.findElement(optionToSelectEle).click();
		Thread.sleep(500);
		driver.findElement(addButtonTagEle).sendKeys(addButtonValue);
		Thread.sleep(500);
		driver.findElement(editButtonTagEle).sendKeys(editButtonValue);
		Thread.sleep(500);
		driver.findElement(searchButtonTagEle).sendKeys(searchButtonValue);
		Thread.sleep(500);
		driver.findElement(deleteButtonTagEle).sendKeys(deleteButtonValue);
		Thread.sleep(500);
		driver.findElement(activaStatusCheckBoxEle).click();
		driver.findElement(saveButtonEle).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}

		System.out.println("Toaster message while creating master data " + toasterMessage);
		if (toasterMessage.equals("Master Data details stored successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTheAvlOfCreatedMasterDataTest() {
		createdMasterDataEle = By.xpath("//div[@title='" + masterTableName + "']");
		masterDataEditIcon = By.xpath("//div[@title='" + masterTableName
				+ "']/parent::div/parent::div/parent::div/preceding-sibling::div/fa-icon");
		try {
			driver.findElement(createdMasterDataEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanEditTheMasterDataTest() throws InterruptedException {
		masterTableName = masterTableName + "update";
		driver.findElement(masterDataEditIcon).click();
		Thread.sleep(2000);
		driver.findElement(masterDataNameEle).clear();
		driver.findElement(masterDataNameEle).sendKeys(masterTableName);
		Thread.sleep(1000);
		driver.findElement(saveButtonEle).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}

		System.out.println("Toaster message while editing master data " + toasterMessage);
		if (toasterMessage.equals("Master Data details stored successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvlOfEditedMasterDataTest() {
		createdMasterDataEle = By.xpath("//div[@title='" + masterTableName + "']");
		masterDataEditIcon = By.xpath("//div[@title='" + masterTableName
				+ "']/parent::div/parent::div/parent::div/preceding-sibling::div/fa-icon");

		try {
			driver.findElement(createdMasterDataEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanDeleteMasterDataTest() throws InterruptedException {
		driver.findElement(masterDataEditIcon).click();
		Thread.sleep(2000);
		driver.findElement(masterDataDeleteIcon).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}

		System.out.println("Toaster message while deleting master data " + toasterMessage);
		if (toasterMessage.equals("Master Data deleted successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvlOfDeleteMasterDataTest() {
		try {
			driver.findElement(createdMasterDataEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyUserCanCreateMasterDataByAddingApportstopeSymbolTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		masterTableName = "TestMasterData" + RandomStringUtils.randomAlphabetic(5) + "'";
		String addButtonValue = "TestAdd" + RandomStringUtils.randomAlphabetic(5) + "'";
		String editButtonValue = "TestEdit" + RandomStringUtils.randomAlphabetic(5) + "'";
		String searchButtonValue = "TestSearch" + RandomStringUtils.randomAlphabetic(5) + "'";
		String deleteButtonValue = "TestDelete" + RandomStringUtils.randomAlphabetic(5) + "'";
		driver.findElement(newMasterDataButton).click();
		Thread.sleep(1000);
		driver.findElement(masterDataNameEle).sendKeys(masterTableName);
		Thread.sleep(500);
		driver.findElement(masterDataDescriptionEle).sendKeys(masterTableName);
		Thread.sleep(500);
		driver.findElement(selectDataCatalogDDEle).click();
		Thread.sleep(500);
		driver.findElement(optionToSelectEle).click();
		Thread.sleep(500);
		driver.findElement(addButtonTagEle).sendKeys(addButtonValue);
		Thread.sleep(500);
		driver.findElement(editButtonTagEle).sendKeys(editButtonValue);
		Thread.sleep(500);
		driver.findElement(searchButtonTagEle).sendKeys(searchButtonValue);
		Thread.sleep(500);
		driver.findElement(deleteButtonTagEle).sendKeys(deleteButtonValue);
		Thread.sleep(500);
		driver.findElement(activaStatusCheckBoxEle).click();
		driver.findElement(saveButtonEle).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}

		System.out.println("Toaster message while creating master data " + toasterMessage);
		if (toasterMessage.equals("Master Data details stored successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTheAvlOfCreatedMasterDataWithApportsopeTest() {
		createdMasterDataEle = By.xpath("//div[contains(@title,'" + masterTableName + ")]");
		System.out.println("xpath ed " + createdMasterDataEle);
		masterDataEditIcon = By.xpath("//div[contains(@title,'" + masterTableName
				+ ")]/parent::div/parent::div/parent::div/preceding-sibling::div/fa-icon");

		System.out.println("xpath ed2 " + masterDataEditIcon);
		try {
			driver.findElement(createdMasterDataEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanEditMasterDataWithApportStopTest() throws InterruptedException {
		masterTableName = "TestMasterDataUpdate" + RandomStringUtils.randomAlphabetic(5) + "'";
		driver.findElement(masterDataEditIcon).click();
		Thread.sleep(2000);
		driver.findElement(masterDataNameEle).clear();
		driver.findElement(masterDataNameEle).sendKeys(masterTableName);
		Thread.sleep(1000);
		driver.findElement(saveButtonEle).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}

		System.out.println("Toaster message while editing master data " + toasterMessage);
		if (toasterMessage.equals("Master Data details stored successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvailabilityOfEditedMasterDataWithApportStopTest() {
		createdMasterDataEle = By.xpath("//div[contains(@title,'" + masterTableName + ")]");
		masterDataEditIcon = By.xpath("//div[contains(@title,'" + masterTableName
				+ ")]/parent::div/parent::div/parent::div/preceding-sibling::div/fa-icon");
		try {
			driver.findElement(createdMasterDataEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanDeleteMasterDataWithApportStopTest() throws InterruptedException {
		driver.findElement(masterDataEditIcon).click();
		Thread.sleep(2000);
		driver.findElement(masterDataDeleteIcon).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}

		System.out.println("Toaster message while deleting master data " + toasterMessage);
		if (toasterMessage.equals("Master Data deleted successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvailabilityOfCreatedMasterDataWithApportStopAfterDeleteTest() {
		try {
			driver.findElement(createdMasterDataEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

}
