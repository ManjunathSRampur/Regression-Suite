package com.qa.bps.pages;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;

public class MaterialMaster {

	WebDriver driver;
	private By propertiesBtn = By.xpath("//fa-icon[@title='Configure Properties']");
	private By createPropertiesBtn = By.xpath("//div[@class='tab-content']//fa-icon");
	private By propertiesName = By.xpath("((//div[@id='propertiesTable'])//div[@role='gridcell'])[2])");
	private By createMaterialBtn = By.xpath("//button[@class='button-primary']");
	private By parentField = By.xpath("(//input[@role='combobox'])[4]");
	private By firstDropDown = By.xpath("(//div[@role='option'])[1]");
	private By shortTextField = By.xpath("//input[@id='shortText']");
	private By materialTypeField = By.xpath("(//input[@role='combobox'])[1]");
	private By uomField = By.xpath("(//input[@role='combobox'])[2]");
	private By locationField = By.xpath("(//input[@role='combobox'])[3]");
	private By toasterMsg = By.xpath("//div[@class='toast-bottom-right toast-container']");
	private By searchField = By.xpath("//input[@placeholder='Search..']");
	private By threeDot = By.xpath("(//div[@role='gridcell'])[3]");
	private By editMaterial = By.xpath("(//div[@class='tabulator-menu-item'])[1]");
	private By deleteMaterialbtn = By.xpath("(//button[contains(text(),'Delete')])[2]");
	private By deleteMaterial = By.xpath("(//div[@class='tabulator-menu-item'])[2]");
	private By infoIconForTextField = By.xpath("//i[@class='fa fa-info-circle info-icon1']");
	private By newMaterialMasterBtn = By.xpath("//a[.='New Material']");
	private By camapignRunTypeDD = By.xpath("//ng-select[@ng-reflect-items='Fixed number of batches,Fixed ']");
	private By dropDownOption = By.xpath("//div[@role='option']");
	private By aptField = By.xpath("//label[@for='APT']");
	private By materialCode = By.xpath("(//input[@id='description'])[last()]");
	private By materialDesc = By.xpath("(//input[@id='displayName'])[last()]");
	private By shortText = By.xpath("(//input[@id='shortText'])[last()]");
	private By materialTypeDD = By.xpath("//ng-select[@id='materialType']/div");
	private By materialValue = By.xpath("(//div[@class='ng-option'])[1]");
	private By UomDD = By.xpath("//ng-select[@ng-reflect-bind-label='name']/div");
	private By UomValue = By.xpath("(//span[@class='ng-option-label'])[1]");
	private By planOrLocationDD = By.xpath(
			"//span[.='Parent Plant / Location for the Material']/parent::label/following-sibling::ng-select/div");
	private By DDValue = By.xpath("(//div[@role='option'])[1]");
	private By processFlowProductDD = By
			.xpath("//span[contains(text(),'Process Flow')]/parent::label/following-sibling::ng-select/div");
	private By AptDD = By.xpath("//span[contains(text(),'Automatic')]/parent::label/following-sibling::ng-select/div");
	private By saveBtn = By.xpath("(//button[.=' Save '])[last()]");
	private By successToaster = By.xpath("//div[@role='alertdialog']");
	private By gramsUOM = By.xpath("//span[.='Grams']");
	private By materialcode = By.xpath("((//div[@role='row'])[1]/div)[4]");
	private By shortextbox = By.xpath("//input[@id='shortText']");
	private By configicon = By.xpath("//fa-icon[@title='Configure Properties']");
	private By propertyicon = By.xpath("//div[@class='col-sm-3 col-md-3 col-lg-3 text-muted text-left']");

	private String testMaterialName;
	private ElementUtil eleUtil;

	String materialCodeValue;

	public MaterialMaster(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public boolean verifAddInfoBtnAvlInFrountOfFieldsTest() throws InterruptedException {
		driver.findElement(newMaterialMasterBtn).click();
		Thread.sleep(1000);
		try {
			driver.findElement(infoIconForTextField).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyDDListAvailabilityForCampaignRunTypeTest() {
		driver.findElement(camapignRunTypeDD).click();
		try {
			driver.findElement(dropDownOption).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAptFieldAvlUnderNewMaterialMasterTest() {
		try {
			driver.findElement(aptField).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanCreateMaterialMasterTest() throws InterruptedException {
		String randomText = RandomStringUtils.randomAlphabetic(3);
		materialCodeValue = "materialMaster" + randomText;
		String randoNumber = RandomStringUtils.randomNumeric(3);
		driver.findElement(materialCode).sendKeys(randoNumber);
		driver.findElement(materialDesc).sendKeys(materialCodeValue);
		driver.findElement(shortText).sendKeys(materialCodeValue);
		driver.findElement(materialTypeDD).click();
		Thread.sleep(500);
		driver.findElement(materialValue).click();
		driver.findElement(UomDD).click();
		Thread.sleep(500);
		driver.findElement(UomValue).click();
		Thread.sleep(500);
		driver.findElement(planOrLocationDD).click();
		Thread.sleep(500);
		driver.findElement(DDValue).click();
		driver.findElement(processFlowProductDD).click();
		Thread.sleep(500);
		driver.findElement(DDValue).click();
		driver.findElement(AptDD).click();
		Thread.sleep(500);
		driver.findElement(DDValue).click();
		driver.findElement(camapignRunTypeDD).click();
		Thread.sleep(500);
		driver.findElement(DDValue).click();
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String toasterMsg = "null";
		try {
			toasterMsg = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toasterMsg + "*");
		if (toasterMsg.equals("Changes are saved successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public void verifyUserCanEditMaterialMasterTest() {

	}

	public boolean verifyUserCanEditCreatedMaterialMasterTest() throws InterruptedException {
		driver.findElement(searchField).sendKeys(materialCodeValue);
		Thread.sleep(2000);
		driver.findElement(threeDot).click();
		Thread.sleep(1000);
		driver.findElement(editMaterial).click();
		Thread.sleep(1000);
		driver.findElement(materialDesc).clear();
		driver.findElement(materialDesc).sendKeys("Update");
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String toasterMsg = "null";
		try {
			toasterMsg = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toasterMsg + "*");
		if (toasterMsg.equals("Changes are saved successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteMaterialMasterTest() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(searchField).clear();
		Thread.sleep(1000);
		driver.findElement(searchField).sendKeys(materialCodeValue);
		Thread.sleep(1000);
		driver.findElement(threeDot).click();
		Thread.sleep(1000);
		driver.findElement(deleteMaterial).click();
		Thread.sleep(1000);
		driver.findElement(deleteMaterialbtn).click();
		Thread.sleep(1500);
		String toasterMsg = "null";
		try {
			toasterMsg = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toasterMsg + "*");
		if (toasterMsg.equals("Deleted Successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTheAvlOfGramUOMInUOMDDTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(newMaterialMasterBtn).click();
		Thread.sleep(1000);
		driver.findElement(UomDD).click();
		Thread.sleep(500);
		try {
			driver.findElement(gramsUOM).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanCreateMaterialMasterWithApportstopeSymbolTest() throws InterruptedException {

		String randomText = RandomStringUtils.randomAlphabetic(3);
		materialCodeValue = "materialMaster" + randomText;
		String randomNumber = RandomStringUtils.randomNumeric(3);
		driver.findElement(materialCode).sendKeys(randomNumber);
		driver.findElement(materialDesc).sendKeys(materialCodeValue + "'");
		driver.findElement(shortText).sendKeys(materialCodeValue + "'");
		driver.findElement(materialTypeDD).click();
		Thread.sleep(500);
		driver.findElement(materialValue).click();
		driver.findElement(UomDD).click();
		Thread.sleep(500);
		driver.findElement(UomValue).click();
		Thread.sleep(500);
		driver.findElement(planOrLocationDD).click();
		Thread.sleep(500);
		driver.findElement(DDValue).click();
		driver.findElement(processFlowProductDD).click();
		Thread.sleep(500);
		driver.findElement(DDValue).click();
		driver.findElement(AptDD).click();
		Thread.sleep(500);
		driver.findElement(DDValue).click();
		driver.findElement(camapignRunTypeDD).click();
		Thread.sleep(500);
		driver.findElement(DDValue).click();
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String toasterMsg = "null";
		try {
			toasterMsg = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toasterMsg + "*");
		if (toasterMsg.equals("Changes are saved successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAvailabilityOftMaterialMasterWithApportstopeSymbolTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(searchField).sendKeys(materialCodeValue + "'");
		try {

			driver.findElement(materialcode).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanEditMaterialMasterTestWithApportsopeSymbolTest() throws InterruptedException {
		driver.findElement(searchField).clear();
		Thread.sleep(2000);
		driver.findElement(searchField).sendKeys(materialCodeValue);
		Thread.sleep(3000);
		driver.findElement(threeDot).click();
		Thread.sleep(2000);
		driver.findElement(editMaterial).click();
		Thread.sleep(2000);
		driver.findElement(shortText).clear();
		driver.findElement(shortText).sendKeys("TestUpdate'");
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		String toasterMsg = "null";
		try {
			toasterMsg = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toasterMsg + "*");
		if (toasterMsg.equals("Changes are saved successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validateEdittedMasterMaterialTestWithApportstopeSymbolTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(searchField).clear();
		Thread.sleep(2000);
		driver.findElement(searchField).sendKeys("TestUpdate'");
		Thread.sleep(3000);
		driver.findElement(threeDot).click();
		Thread.sleep(2000);
		driver.findElement(editMaterial).click();
		Thread.sleep(3000);
		String updatedMaterialShortText = "NULL";
		try {
			updatedMaterialShortText = driver.findElement(shortText).getAttribute("ng-reflect-model");
		} catch (Exception e) {

		}

		if (updatedMaterialShortText.equals("TestUpdate'")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteMaterialMasterTestWithApportstopeSymbolTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(searchField).clear();
		Thread.sleep(1000);
		driver.findElement(searchField).sendKeys("TestUpdate'");
		Thread.sleep(1000);
		driver.findElement(threeDot).click();
		Thread.sleep(1000);
		driver.findElement(deleteMaterial).click();
		Thread.sleep(3000);
		driver.findElement(deleteMaterialbtn).click();
		Thread.sleep(3000);
		String toasterMsg = "null";
		try {
			toasterMsg = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + toasterMsg + "*");
		if (toasterMsg.equals("Deleted Successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validateDelettedMasterMaterialTestWithApportstopeSymbolTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(searchField).sendKeys("TestUpdate'");
		try {

			driver.findElement(materialcode).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyUserAbleToNavigateConfigureProperty() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(configicon).click();
		try {

			driver.findElement(propertyicon).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
