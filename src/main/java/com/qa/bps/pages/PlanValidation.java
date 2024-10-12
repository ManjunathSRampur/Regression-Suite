package com.qa.bps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.reactivex.rxjava3.functions.Action;

public class PlanValidation {

	WebDriver driver;
	Navigation navigateTo;
	String selectedOptn;

// --------Xpath start ------------------------------
	private By graphViewTab = By.xpath("(//div[.='Product Graph View'])[2]");
	private By selectProduct = By.xpath("//div[@class='ng-value-container']");
	private By SearchproductTooltip = By.xpath("//ng-select[@placeholder='Select or Search Product']");
	private By firstProduct = By.xpath("(//div[@class='ng-dropdown-panel-items scroll-host']/div/div)[1]/span");
	private By generateBtn = By.xpath("//button[.='Generate']");
	private By selectProductSearchBox = By.xpath("//div[@class='ng-input']/input");
	private By generatedValue = By.xpath("(//*[local-name()='g'])[2]");
	private By dataValidationTab = By.xpath("//div[contains(text(),'Data Validation View')]");
	private By productGraphviewTab = By.xpath("//div[contains(text(),'Product Graph View')]");
	private By validateBtn = By.xpath("//button[contains(text(),'Validate')]");
	private By MandetoryChecksTab = By.xpath("//div[contains(text(),'Mandatory Checks')]");
	private By configTab = By.xpath("//div[contains(text(),'Config')]");
	private By controlTowerTab = By.xpath("//div[contains(text(),'Control Tower')]");
	private By batchOption = By.xpath("//span[contains(text(),'Batch')]");
	private By AssignedAssetOption = By.xpath("//span[contains(text(),'Assigned Asset')]");
	private By StatusSynchOption = By.xpath("//span[contains(text(),'Status Sync')]");
	private By TechnicalStepsOption = By.xpath("//span[contains(text(),'Technical Step')]");
	private By MaterialMasterOption = By.xpath("//span[contains(text(),'Material Master')]");
	private By LinkagesMappingOption = By.xpath("//span[contains(text(),'Linkages and Mappings')]");
	private By campaignOption = By.xpath("//span[contains(text(),'Campaign')]");
	private By processStepOption = By.xpath("//span[contains(text(),'Process step')]");
	private By techStepOption = By.xpath("//span[contains(text(),'Technical step')]");
	private By AssignAssetandtechStepOption = By.xpath("//span[contains(text(),'Assigned Asset on Technical Step')]");
	private By AssignAssetandprocessStepOption = By.xpath("//span[contains(text(),'Assigned Asset on Process Step')]");
	private By AssignedOperatorOption = By.xpath("//span[contains(text(),'Assigned Operator')]");
	private By AssignedOperatorAndTechStepOption = By
			.xpath("//span[contains(text(),'Assigned Operator and Technical Step Sync')]");
	private By AssignedOperatorAndTechStepSynchOption = By
			.xpath("//span[contains(text(),'Assigned Asset and Technical Step Sync')]");
	private By productSearchBox = By.xpath("//input[@role='combobox']");
	private By toggleBtn = By.xpath("//input[@role='switch']");
	private By downloadbtn = By.xpath("//button[contains(text(),'Download')]");
	private By taskPropertiesBtn = By.xpath("//img[@data-toggle='modal']");
	private By verticalView = By.xpath("//img[@title='Vertical']");
	private By productOption1 = By.xpath("((//div[@class='ng-dropdown-panel-items scroll-host'])[1]//div/div)[1]");
	private By productName = By.xpath("//h6[@class='product-name']");
	private By toggle2 = By.xpath("//div[@class='mat-slide-toggle-bar']");

//---------Xpath End---------------------------------

	public PlanValidation(WebDriver driver) {
		this.driver = driver;
		navigateTo = new Navigation(driver);
	}

	public boolean verifyUserCanNaviagateToProductGraphViewTest() throws InterruptedException {
		driver.findElement(graphViewTab).click();
		Thread.sleep(2000);
		driver.findElement(selectProduct).click();
		Thread.sleep(1000);
		String firstProductValue = driver.findElement(firstProduct).getText();
		System.out.println("*" + firstProductValue + "*");
		driver.findElement(selectProductSearchBox).sendKeys(firstProductValue);
		Thread.sleep(1000);
		driver.findElement(firstProduct).click();
		Thread.sleep(1000);
		driver.findElement(generateBtn).click();
		Thread.sleep(3000);
		try {
			driver.findElement(generatedValue).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean availableTabsUnderPlanValidation() {
		boolean b;
		try {
			driver.findElement(dataValidationTab).isDisplayed();
			driver.findElement(graphViewTab).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;

		}
		return b;
	}

	public boolean validateBtnDisplayedUnderDataValidation() throws InterruptedException {
		boolean b;

		try {
			driver.findElement(dataValidationTab).click();
			Thread.sleep(1500);
			driver.findElement(validateBtn).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean DataAfterClickingValidationBtn() throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(validateBtn).click();
		Thread.sleep(1500);
		boolean b;
		try {
			driver.findElement(MandetoryChecksTab).isDisplayed();
			driver.findElement(configTab).isDisplayed();
			driver.findElement(controlTowerTab).isDisplayed();
			b = true;

		} catch (Exception e) {
			b = false;
		}

		return b;

	}

	public boolean dataAvailableUnbderMandetoryChecks() throws InterruptedException {
		driver.findElement(MandetoryChecksTab).click();
		Thread.sleep(1500);
		boolean b;
		try {
			driver.findElement(batchOption).isDisplayed();
			driver.findElement(AssignedAssetOption).isDisplayed();
			driver.findElement(StatusSynchOption).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean dataAvailableUnderConfigTab() throws InterruptedException {
		driver.findElement(configTab).click();
		Thread.sleep(1500);
		boolean b;
		try {
			driver.findElement(TechnicalStepsOption).isDisplayed();
			driver.findElement(MaterialMasterOption).isDisplayed();
			driver.findElement(LinkagesMappingOption).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean dataAvailableUnderControltowerTab() throws InterruptedException {
		driver.findElement(controlTowerTab).click();
		Thread.sleep(1500);
		boolean b;
		try {
			driver.findElement(campaignOption).isDisplayed();
			driver.findElement(batchOption).isDisplayed();
			driver.findElement(processStepOption).isDisplayed();
			driver.findElement(techStepOption).isDisplayed();
			driver.findElement(AssignAssetandtechStepOption).isDisplayed();
			driver.findElement(AssignAssetandprocessStepOption).isDisplayed();
			driver.findElement(AssignedOperatorOption).isDisplayed();
			driver.findElement(AssignedOperatorAndTechStepSynchOption).isDisplayed();
			driver.findElement(AssignedOperatorAndTechStepSynchOption).isDisplayed();
			driver.findElement(AssignedOperatorAndTechStepOption).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean dataAvailableUnderProductGraphViewTab() throws InterruptedException {
		driver.findElement(productGraphviewTab).click();
		Thread.sleep(1500);
		boolean b;
		try {
			driver.findElement(productSearchBox).isDisplayed();
			driver.findElement(toggleBtn).isDisplayed();
			driver.findElement(generateBtn).isDisplayed();
			driver.findElement(downloadbtn).isDisplayed();
			driver.findElement(taskPropertiesBtn).isDisplayed();
			driver.findElement(verticalView).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean tooltipForProductSearchBox() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(9000);
		driver.findElement(productGraphviewTab).click();
		Thread.sleep(1500);
		String tooltip = driver.findElement(SearchproductTooltip).getAttribute("title");
		System.out.println(tooltip);
		if (tooltip.equals("undefined")) {
			return false;
		} else
			return true;

	}

	public boolean productNameValidation() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(selectProductSearchBox).click();
		Thread.sleep(3000);
		selectedOptn = driver.findElement(firstProduct).getText();
		Thread.sleep(3000);
		driver.findElement(firstProduct).click();
		Thread.sleep(2000);
		System.out.println(selectedOptn);
		driver.findElement(generateBtn).click();
		Thread.sleep(3000);
		String actualOptn="null";
		try {
			actualOptn	 = driver.findElement(productName).getText();
			System.out.println("Actual=" + actualOptn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		Thread.sleep(2000);
		if (selectedOptn.equalsIgnoreCase(actualOptn)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean productNameValidationTG() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(toggle2).click();
		Thread.sleep(2000);
		driver.findElement(generateBtn).click();
		Thread.sleep(2000);
		String actualOptnTG = driver.findElement(productName).getText();
		System.out.println("ActualTG=" + actualOptnTG);
		Thread.sleep(2000);
		if (selectedOptn.equalsIgnoreCase(actualOptnTG)) {
			return true;
		} else {
			return false;
		}

	}

}
