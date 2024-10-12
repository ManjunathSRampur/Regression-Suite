package com.qa.bps.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecipeManagement {

	WebDriver driver;
	Navigation navigateTo;
	private By recipeNameColumn = By.xpath("(//div[@tabulator-field='recipe_name'])[1]");
	private By descriptionColumn = By.xpath("(//div[@tabulator-field='description'])[1]");
	private By materialNumberColumn = By.xpath("(//div[@tabulator-field='material_number'])[1]");
	private By productNameColumn = By.xpath("(//div[@tabulator-field='product_name'])[1]");
	private By createdByColumn = By.xpath("(//div[@tabulator-field='created_by'])[1]");
	private By createdDateColumn = By.xpath("(//div[@tabulator-field='creation_date'])[1]");
	private By statusColumn = By.xpath("(//div[@tabulator-field='status'])[1]");
	private By actionsColumn = By.xpath("(//div[@tabulator-field='IsSelected'])[1]");
	private By recipeBtn = By.xpath("//a[.='Recipe']");
	private By searchBox = By.xpath("(//input[@placeholder='Search..'])[1]");
	private By recipeManagementPopup = By.xpath("//h3[contains(text(),'Recipe Management')]");
	private By defineEventTab = By.xpath("(//a[@aria-controls='v-pills-info'])[1]");
	private By definePreProductionEventtab = By.xpath("(//a[@aria-controls='v-pills-info'])[2]");
	private By saveBtn = By.xpath("(//button[.=' Save '])[2]");
	private By toasterElement = By.xpath("//div[@role='alertdialog']");
	private By avlInputFileds = By.xpath("//div[@class='col-sm-4 col-md-4 col-lg-4']/label");
	private By closePopUpIcon = By.xpath("//div[@class='row']/a");
	private By addNewProductionPtBtn = By.xpath("(//div[@data-toggle='tooltip'])[1]");
	private By newProdPtRowEle = By.xpath("(//div[@class='row inner-card ng-star-inserted'])[2]");
	private By removeRowBtn = By.xpath("(//span[@data-toggle='tooltip'])[1]");
	private By addnewConsumptionPtBtn = By.xpath("(//div[@data-toggle='tooltip'])[2]");
	private By addNewTimebasedConstraintBtn = By.xpath("(//div[@data-toggle='tooltip'])[3]");
	private By addNewTransferTaskBtn = By.xpath("(//div[@data-toggle='tooltip'])[4]");
	private By preProductionEventLabel = By.xpath("//div[@for='info']");
	private By preProcessingTabFiled = By.xpath("(//div[@class='tabulator-header'])[2]/div/div");
	private By recipeNameTextFiled = By.xpath("(//input[@id='recipeName'])[last()]");
	private By recipeIdTextFiled = By.xpath("//input[@id='recipeId']");
	private By recipeDescription = By.xpath("//input[@id='description']");
	private By selectMaterialDD = By.xpath("(//div[.='Select Material'])[last()]/following-sibling::div/input");
	private By firstMaterialEle = By.xpath("(//div[@role='option'])[1]/span");
	private By selectProductDD = By.xpath("//div[.='Select Product']/following-sibling::div/input");
	private By validateStartDate = By.xpath("//input[@id='validityStart']");
	private By validateEndDate = By.xpath("//input[@id='validityEnd']");
	private By statusToglleBtn = By.xpath("(//span[@class='slider round'])[1]");
	private By taskDD = By.xpath("(//input[@role='combobox'])[3]");
	private By firstTask = By.xpath("(//div[@role='option'])[1]");
	private By materialNoDD = By.xpath("(//input[@role='combobox'])[4]");
	private By firstMaterial = By.xpath("(//div[@role='option'])[1]");
	private By quantity = By.xpath("(//input[@id='item.production_quantity'])[last()]");
	private By UomDD = By.xpath("(//input[@role='combobox'])[5]");
	private By UOMUnit = By.xpath("(//span[.='Meter'])[last()]");
	private By toasterMsg = By.xpath("//div[@role='alertdialog']");
	private By threeDot = By.xpath("(//div[@tabulator-field='IsSelected'])[2]");
	private By editButton = By.xpath("(//div[@class='tabulator-menu-item'])[2]");
	private By avlCreatedRecipe = By.xpath("(//div[@role='gridcell'])[1]");
	private By deleteRecipeBtn = By.xpath("(//div[@class='tabulator-menu-item'])[3]");
	private By consumptionPointTaskDD = By.xpath("(//input[@role='combobox'])[6]");
	private By consumptionPointMaterialNumberDD = By.xpath("(//input[@role='combobox'])[7]");
	private By consumptionPointQty = By.xpath("//input[@id='item.consumption_quantity']");
	private By consumptionPointUOM = By.xpath("(//input[@role='combobox'])[8]");
	private By constraintName = By.xpath("//input[@id='constraintName']");
	private By initatingTaskDD = By.xpath("(//input[@role='combobox'])[6]");
	private By initiatingReference = By.xpath("(//input[@role='combobox'])[7]");
	private By recipeForTargetTask = By.xpath("(//input[@role='combobox'])[8]");
	private By concludingTask = By.xpath("(//input[@role='combobox'])[9]");
	private By conclusionReference = By.xpath("(//input[@role='combobox'])[10]");
	private By comparisonOperatorDD = By.xpath("(//input[@role='combobox'])[11]");
	private By timeConstraintItemQty = By.xpath("//input[@id='item.consumption_quantity']");
	private By originatingTransferTask = By.xpath("(//input[@role='combobox'])[6]");
	private By destinationRecipe = By.xpath("(//input[@role='combobox'])[7]");
	private By destinationTask = By.xpath("(//input[@role='combobox'])[8]");
	private By preProductionRecipeDD = By.xpath("(//input[@role='combobox'])[1]");
	private By preProductionRecipeOp = By.xpath("//div[@role='option']");
	private By productionTaskDD = By.xpath("(//div[@tabulator-field='source_task'])[2]");
	private By DDOptions = By.xpath("(//div[@class='tabulator-edit-select-list-item'])[1]");
	private By preProductionTaskDD = By.xpath("(//div[@tabulator-field='target_task'])[2]");
	private By linkageDepenDencyDD = By.xpath("(//div[@tabulator-field='dependency_code'])[2]");
	private By postProductionRecipeDD = By.xpath("(//input[@role='combobox'])[2]");
	private By postProductionRecipeOp = By.xpath("//div[@role='option']");
	private By ProductionTaskDD1 = By.xpath("(//div[@tabulator-field='source_task'])[3]");
	private By postProductionTask = By.xpath("(//div[@tabulator-field='target_task'])[3]");
	private By postProductionLinkgaeDD = By.xpath("(//div[@tabulator-field='dependency_code'])[3]");
	private By pleaseSelectPreProductionRecipeDD = By.xpath("//input[@role='combobox']");
	private By selectPreProcessingRecipe = By.xpath("//div[@role='option']/span");
	private By sourceTaskDD = By.xpath("(//div[@tabulator-field='source_task'])[2]");
	private By sourceTaskInputBox = By.xpath("(//div[@tabulator-field='source_task'])[2]/input");
	private By avaialbleTask = By.xpath("//div[@class='tabulator-edit-select-list']/div");
	private By createdRecipeEle = By.xpath("(//div[@role='row'])[1]");

//	----------------------------
	String recipeNameValue = "RecipeMgmtTest";
	String recipeId = "";
	String validateStartDateValue = "01012024";
	String validateEndDateValue = "01022024";
	List<WebElement> inputFileds = new ArrayList<WebElement>();
	List<String> avlFiledsValue = new ArrayList<String>();
	List<WebElement> preProcessingTabColumnEle = new ArrayList<WebElement>();
	List<String> preProcessingTabColumnValue = new ArrayList<String>();
	String recipeNameValueConsumption;
	String recipeNameValueConsumptionTest;

	public RecipeManagement(WebDriver driver) {
		this.driver = driver;
		navigateTo = new Navigation(driver);
	}

	public boolean verifyUserCanNavigateRecipeManagementTest() throws InterruptedException {
		boolean b = navigateTo.navigateRecipeManagement();
		return b;
	}

	public boolean verifyTheAvlOfRecipeNameColumn() {
		try {
			driver.findElement(recipeNameColumn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyTheAvleOfDescriptionColumn() {
		try {
			driver.findElement(descriptionColumn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfMaterialNumberColumnTest() {
		try {
			driver.findElement(materialNumberColumn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfProductNameColumnTest() {
		try {
			driver.findElement(productNameColumn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfCreatedByColumnTest() {
		try {
			driver.findElement(createdByColumn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyCreatedDateColumnTest() {
		try {
			driver.findElement(createdDateColumn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyStatusColumnTest() {
		try {
			driver.findElement(statusColumn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfActionsColumnTest() {
		try {
			driver.findElement(actionsColumn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfSearchBoxTest() {
		try {
			driver.findElement(searchBox).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfRecipeBtnTest() {
		try {
			driver.findElement(recipeBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanClikOnRecipeBtnTest() throws InterruptedException {
		driver.findElement(recipeBtn).click();
		Thread.sleep(2000);
		try {
			driver.findElement(recipeManagementPopup).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyAvlOfDefineEventTabTest() {
		try {
			driver.findElement(defineEventTab).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfDefinePreProductionEventTabTest() {
		try {
			driver.findElement(definePreProductionEventtab).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserIsAbleToSaveTheRecipeMangementWithoutFilingFieledTest() throws InterruptedException {
		driver.findElement(saveBtn).click();
		Thread.sleep(500);
		String tstMsg = "null";
		try {
			tstMsg = driver.findElement(toasterElement).getText();
		} catch (Exception e) {
			tstMsg = "null";
		}
		if (tstMsg.equals("Please fill All Mandatory fields")) {
			return true;
		} else {
			return false;
		}
	}

	public List<String> verifyAvlInputFieledInRecipeManagementPopUpTest() {
		inputFileds = driver.findElements(avlInputFileds);
		for (WebElement filed : inputFileds) {
			avlFiledsValue.add(filed.getText());
		}
		System.out.println(avlFiledsValue);
		return avlFiledsValue;
	}

	public boolean verifyUserCanAddNewProductionPointRowTest() throws InterruptedException {
		try {
			driver.findElement(closePopUpIcon).click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		driver.findElement(recipeBtn).click();
		Thread.sleep(2000);
		driver.findElement(addNewProductionPtBtn).click();
		Thread.sleep(2000);
		try {
			driver.findElement(newProdPtRowEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanRemoveNewProductionPointRowTest() throws InterruptedException {
		driver.findElement(removeRowBtn).click();
		Thread.sleep(3000);
		try {
			driver.findElement(newProdPtRowEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyUserCanAddNewConsumtionPointRowTest() throws InterruptedException {
		driver.findElement(addnewConsumptionPtBtn).click();
		Thread.sleep(2000);
		try {
			driver.findElement(newProdPtRowEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanDeleteTheNewConsumptionPtRowTest() throws InterruptedException {
		driver.findElement(removeRowBtn).click();
		Thread.sleep(3000);
		try {
			driver.findElement(newProdPtRowEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyUserCanAddTimeBasedConstraintRowTest() throws InterruptedException {
		driver.findElement(addNewTimebasedConstraintBtn).click();
		Thread.sleep(2000);
		try {
			driver.findElement(newProdPtRowEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanRemoveTimeBasedConstraintRowTest() throws InterruptedException {
		driver.findElement(removeRowBtn).click();
		Thread.sleep(3000);
		try {
			driver.findElement(newProdPtRowEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyUserCanAddTransferTaskRowTest() throws InterruptedException {
		driver.findElement(addNewTransferTaskBtn).click();
		Thread.sleep(2000);
		try {
			driver.findElement(newProdPtRowEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanRemoveTheTransferTaskRowTest() throws InterruptedException {
		driver.findElement(removeRowBtn).click();
		Thread.sleep(3000);
		try {
			driver.findElement(newProdPtRowEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyUserCanNavigateDefineProductionEventTabTest() {
		driver.findElement(definePreProductionEventtab).click();
		try {
			driver.findElement(preProductionEventLabel).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlFiledsInDefineProductionEventTabTest() {
		preProcessingTabColumnEle = driver.findElements(preProcessingTabFiled);
		for (WebElement preProcessingColumn : preProcessingTabColumnEle) {
			preProcessingTabColumnValue.add(preProcessingColumn.getAttribute("title"));
		}
		System.out.println(preProcessingTabColumnValue);
		return true;
	}

	public boolean verifyUserIsAbleCreateRecipeMgmtTest() throws InterruptedException {
		recipeNameValue = recipeNameValue + RandomStringUtils.randomAlphabetic(2);
		recipeId = RandomStringUtils.randomNumeric(4);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(recipeBtn).click();
		Thread.sleep(2000);
		driver.findElement(recipeNameTextFiled).sendKeys(recipeNameValue);
		System.out.println("Recipe Name :" + recipeNameValue);
		driver.findElement(recipeIdTextFiled).sendKeys(recipeId);
		driver.findElement(recipeDescription).sendKeys(recipeNameValue);
		Thread.sleep(1000);
		driver.findElement(selectMaterialDD).click();
		Thread.sleep(1000);
		String firstMasterial = driver.findElement(firstMaterialEle).getText();
		driver.findElement(firstMaterialEle).click();
		Thread.sleep(1000);
		System.out.println("first masterial name " + firstMasterial);
		driver.findElement(selectProductDD).sendKeys(firstMasterial);
		driver.findElement(By.xpath("(//div[@role='option']//span[contains(text(),'" + firstMasterial + "')])[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(validateStartDate).sendKeys(validateStartDateValue);
		Thread.sleep(1000);
		driver.findElement(validateEndDate).sendKeys(validateEndDateValue);
		Thread.sleep(2000);
		driver.findElement(statusToglleBtn).click();
		driver.findElement(taskDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		driver.findElement(materialNoDD).click();
		driver.findElement(firstMaterial).click();
		driver.findElement(quantity).sendKeys("4");
		driver.findElement(UomDD).click();
		driver.findElement(UOMUnit).click();
		Thread.sleep(3000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Recipe Details insert successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAvlOfCreatedRecipeTest() throws InterruptedException {
		driver.findElement(searchBox).sendKeys(recipeNameValue);
		Thread.sleep(1000);
		try {
			driver.findElement(avlCreatedRecipe).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserIsAbleToeditRecipeMgmtTest() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(recipeNameValue);
		Thread.sleep(1000);
		driver.findElement(threeDot).click();
		driver.findElement(editButton).click();
		Thread.sleep(2000);
		driver.findElement(validateEndDate).sendKeys("01032024");
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message while editing recipe " + toasterMessage);
		if (toasterMessage.equals("Recipe Details update successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToDeleteRecipeMgmtTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(recipeNameValue);
		Thread.sleep(500);
		driver.findElement(threeDot).click();
		driver.findElement(deleteRecipeBtn).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Data Deleted Successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvlOfRecipePostDeleteTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(recipeNameValue);
		Thread.sleep(1000);
		try {
			driver.findElement(avlCreatedRecipe).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyUserIsAbleToCreateRecpieByAddingConsumptionPointTest() throws InterruptedException {
		recipeNameValueConsumption = recipeNameValue + RandomStringUtils.randomAlphabetic(2);
		recipeNameValueConsumptionTest=recipeNameValueConsumption;
		recipeId = RandomStringUtils.randomNumeric(4);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(recipeBtn).click();
		Thread.sleep(2000);
		driver.findElement(recipeNameTextFiled).sendKeys(recipeNameValueConsumption);
		System.out.println("Recipe Name :" + recipeNameValueConsumption);
		driver.findElement(recipeIdTextFiled).sendKeys(recipeId);
		driver.findElement(recipeDescription).sendKeys(recipeNameValueConsumption);
		Thread.sleep(1000);
		driver.findElement(selectMaterialDD).click();
		Thread.sleep(1000);
		String firstMasterial = driver.findElement(firstMaterialEle).getText();
		driver.findElement(firstMaterialEle).click();
		Thread.sleep(1000);
		System.out.println("first masterial name " + firstMasterial);
		driver.findElement(selectProductDD).sendKeys(firstMasterial);
		driver.findElement(By.xpath("(//div[@role='option']//span[contains(text(),'" + firstMasterial + "')])[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(validateStartDate).sendKeys(validateStartDateValue);
		Thread.sleep(1000);
		driver.findElement(validateEndDate).sendKeys(validateEndDateValue);
		Thread.sleep(2000);
		driver.findElement(statusToglleBtn).click();
		driver.findElement(taskDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		driver.findElement(materialNoDD).click();
		driver.findElement(firstMaterial).click();
		driver.findElement(quantity).sendKeys("4");
		driver.findElement(UomDD).click();
		driver.findElement(UOMUnit).click();
		Thread.sleep(3000);
		driver.findElement(addnewConsumptionPtBtn).click();
		Thread.sleep(1000);
		driver.findElement(consumptionPointTaskDD).click();
		driver.findElement(firstTask).click();
		driver.findElement(consumptionPointMaterialNumberDD).click();
		driver.findElement(firstMaterial).click();
		driver.findElement(consumptionPointQty).sendKeys("4");
		Thread.sleep(1000);
		driver.findElement(consumptionPointUOM).click();
		driver.findElement(UOMUnit).click();
		Thread.sleep(3000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Recipe Details insert successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserIsAbleCreateRecipeByAddingTimeBasedConstraintTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		recipeNameValue = recipeNameValue + RandomStringUtils.randomAlphabetic(2);
		recipeId = RandomStringUtils.randomNumeric(4);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(recipeBtn).click();
		Thread.sleep(2000);
		driver.findElement(recipeNameTextFiled).sendKeys(recipeNameValue);
		System.out.println("Recipe Name :" + recipeNameValue);
		driver.findElement(recipeIdTextFiled).sendKeys(recipeId);
		driver.findElement(recipeDescription).sendKeys(recipeNameValue);
		Thread.sleep(1000);
		driver.findElement(selectMaterialDD).click();
		Thread.sleep(1000);
		String firstMasterial = driver.findElement(firstMaterialEle).getText();
		driver.findElement(firstMaterialEle).click();
		Thread.sleep(1000);
		System.out.println("first masterial name " + firstMasterial);
		driver.findElement(selectProductDD).sendKeys(firstMasterial);
		driver.findElement(By.xpath("(//div[@role='option']//span[contains(text(),'" + firstMasterial + "')])[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(validateStartDate).sendKeys(validateStartDateValue);
		Thread.sleep(1000);
		driver.findElement(validateEndDate).sendKeys(validateEndDateValue);
		Thread.sleep(2000);
		driver.findElement(statusToglleBtn).click();
		driver.findElement(taskDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		driver.findElement(materialNoDD).click();
		driver.findElement(firstMaterial).click();
		driver.findElement(quantity).sendKeys("4");
		driver.findElement(UomDD).click();
		driver.findElement(UOMUnit).click();
		Thread.sleep(2000);

		driver.findElement(addNewTimebasedConstraintBtn).click();
		Thread.sleep(1000);
		driver.findElement(constraintName).sendKeys("Test");
		System.out.println("constraint name added");
		Thread.sleep(1000);
		driver.findElement(initatingTaskDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		System.out.println("initatingTaskDD name added");
		driver.findElement(initiatingReference).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(recipeForTargetTask).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(concludingTask).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(conclusionReference).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(comparisonOperatorDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(timeConstraintItemQty).sendKeys("4");
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Recipe Details insert successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToDeleteTheRecipeOfTimeBasedConstraintTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(searchBox).sendKeys(recipeNameValue);
		Thread.sleep(500);
		driver.findElement(threeDot).click();
		driver.findElement(deleteRecipeBtn).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Data Deleted Successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToCreateRecipeByAddingWithTransferTaskTest() throws InterruptedException {
		recipeNameValue = recipeNameValue + RandomStringUtils.randomAlphabetic(2);
		recipeId = RandomStringUtils.randomNumeric(4);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(recipeBtn).click();
		Thread.sleep(2000);
		driver.findElement(recipeNameTextFiled).sendKeys(recipeNameValue);
		System.out.println("Recipe Name :" + recipeNameValue);
		driver.findElement(recipeIdTextFiled).sendKeys(recipeId);
		driver.findElement(recipeDescription).sendKeys(recipeNameValue);
		Thread.sleep(1000);
		driver.findElement(selectMaterialDD).click();
		Thread.sleep(1000);
		String firstMasterial = driver.findElement(firstMaterialEle).getText();
		driver.findElement(firstMaterialEle).click();
		Thread.sleep(1000);
		System.out.println("first masterial name " + firstMasterial);
		driver.findElement(selectProductDD).sendKeys(firstMasterial);
		driver.findElement(By.xpath("(//div[@role='option']//span[contains(text(),'" + firstMasterial + "')])[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(validateStartDate).sendKeys(validateStartDateValue);
		Thread.sleep(1000);
		driver.findElement(validateEndDate).sendKeys(validateEndDateValue);
		Thread.sleep(2000);
		driver.findElement(statusToglleBtn).click();
		driver.findElement(taskDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		driver.findElement(materialNoDD).click();
		driver.findElement(firstMaterial).click();
		driver.findElement(quantity).sendKeys("4");
		driver.findElement(UomDD).click();
		driver.findElement(UOMUnit).click();
		Thread.sleep(2000);

		driver.findElement(addNewTransferTaskBtn).click();
		Thread.sleep(1000);

		driver.findElement(originatingTransferTask).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(destinationRecipe).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(destinationTask).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Recipe Details insert successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToDeleteRecipeOfTransferTaskTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(searchBox).sendKeys(recipeNameValue);
		Thread.sleep(500);
		String toasterMessage = "null";
		try {
			driver.findElement(threeDot).click();
			driver.findElement(deleteRecipeBtn).click();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Data Deleted Successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleTocreateRecipeByDefiningPreProductionTest() throws InterruptedException {

		recipeNameValue = recipeNameValue + RandomStringUtils.randomAlphabetic(2);
		recipeId = RandomStringUtils.randomNumeric(4);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(recipeBtn).click();
		Thread.sleep(2000);
		driver.findElement(recipeNameTextFiled).sendKeys(recipeNameValue);
		System.out.println("Recipe Name :" + recipeNameValue);
		driver.findElement(recipeIdTextFiled).sendKeys(recipeId);
		driver.findElement(recipeDescription).sendKeys(recipeNameValue);
		Thread.sleep(1000);
		driver.findElement(selectMaterialDD).click();
		Thread.sleep(1000);
		String firstMasterial = driver.findElement(firstMaterialEle).getText();
		driver.findElement(firstMaterialEle).click();
		Thread.sleep(1000);
		System.out.println("first masterial name " + firstMasterial);
		driver.findElement(selectProductDD).sendKeys(firstMasterial);
		driver.findElement(By.xpath("(//div[@role='option']//span[contains(text(),'" + firstMasterial + "')])[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(validateStartDate).sendKeys(validateStartDateValue);
		Thread.sleep(1000);
		driver.findElement(validateEndDate).sendKeys(validateEndDateValue);
		Thread.sleep(2000);
		driver.findElement(statusToglleBtn).click();
		driver.findElement(taskDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		driver.findElement(materialNoDD).click();
		driver.findElement(firstMaterial).click();
		driver.findElement(quantity).sendKeys("4");
		driver.findElement(UomDD).click();
		driver.findElement(UOMUnit).click();
		Thread.sleep(2000);

		driver.findElement(definePreProductionEventtab).click();
		Thread.sleep(1000);
		driver.findElement(preProductionRecipeDD).click();
		Thread.sleep(500);
		driver.findElement(preProductionRecipeOp).click();
		driver.findElement(productionTaskDD).click();
		Thread.sleep(500);
		driver.findElement(DDOptions).click();
		driver.findElement(preProductionTaskDD).click();
		Thread.sleep(500);
		driver.findElement(DDOptions).click();
		driver.findElement(linkageDepenDencyDD).click();
		Thread.sleep(500);
		driver.findElement(DDOptions).click();
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Recipe Details insert successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToDeleteRecipeOfPreProcessingTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(searchBox).sendKeys(recipeNameValue);
		Thread.sleep(500);
		String toasterMessage = "null";
		try {
			driver.findElement(threeDot).click();
			driver.findElement(deleteRecipeBtn).click();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Data Deleted Successfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserIsAbleTocreateRecipeByDefiningPostProductionTest() throws InterruptedException {
		recipeNameValue = recipeNameValue + RandomStringUtils.randomAlphabetic(2);
		recipeId = RandomStringUtils.randomNumeric(4);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(recipeBtn).click();
		Thread.sleep(2000);
		driver.findElement(recipeNameTextFiled).sendKeys(recipeNameValue);
		System.out.println("Recipe Name :" + recipeNameValue);
		driver.findElement(recipeIdTextFiled).sendKeys(recipeId);
		driver.findElement(recipeDescription).sendKeys(recipeNameValue);
		Thread.sleep(1000);
		driver.findElement(selectMaterialDD).click();
		Thread.sleep(1000);
		String firstMasterial = driver.findElement(firstMaterialEle).getText();
		driver.findElement(firstMaterialEle).click();
		Thread.sleep(1000);
		System.out.println("first masterial name " + firstMasterial);
		driver.findElement(selectProductDD).sendKeys(firstMasterial);
		driver.findElement(By.xpath("(//div[@role='option']//span[contains(text(),'" + firstMasterial + "')])[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(validateStartDate).sendKeys(validateStartDateValue);
		Thread.sleep(1000);
		driver.findElement(validateEndDate).sendKeys(validateEndDateValue);
		Thread.sleep(2000);
		driver.findElement(statusToglleBtn).click();
		driver.findElement(taskDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		driver.findElement(materialNoDD).click();
		driver.findElement(firstMaterial).click();
		driver.findElement(quantity).sendKeys("4");
		driver.findElement(UomDD).click();
		driver.findElement(UOMUnit).click();
		Thread.sleep(2000);

		driver.findElement(definePreProductionEventtab).click();
		Thread.sleep(1000);

		driver.findElement(postProductionRecipeDD).click();
		Thread.sleep(1000);
		driver.findElement(postProductionRecipeOp).click();
		Thread.sleep(500);
		driver.findElement(ProductionTaskDD1).click();
		driver.findElement(DDOptions).click();
		Thread.sleep(500);
		driver.findElement(postProductionTask).click();
		Thread.sleep(500);
		driver.findElement(DDOptions).click();
		driver.findElement(postProductionLinkgaeDD).click();
		Thread.sleep(500);
		driver.findElement(DDOptions).click();
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Recipe Details insert successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteRecipeOfProductionTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(searchBox).sendKeys(recipeNameValue);
		Thread.sleep(500);
		String toasterMessage = "null";
		try {
			driver.findElement(threeDot).click();
			driver.findElement(deleteRecipeBtn).click();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Data Deleted Successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToDeletRecipeOfConsumptionPointTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(searchBox).sendKeys(recipeNameValueConsumptionTest);
		Thread.sleep(500);
		String toasterMessage = "null";
		try {
			driver.findElement(threeDot).click();
			driver.findElement(deleteRecipeBtn).click();
			driver.switchTo().alert().accept();
			Thread.sleep(1500);
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Data Deleted Successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheDuplicateTaskAvlUnderProductionTaskDDTest() throws InterruptedException {
		recipeNameValue = recipeNameValue + RandomStringUtils.randomAlphabetic(2);
		recipeId = RandomStringUtils.randomNumeric(4);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(recipeBtn).click();
		Thread.sleep(2000);
		driver.findElement(recipeNameTextFiled).sendKeys(recipeNameValue);
		System.out.println("Recipe Name :" + recipeNameValue);
		driver.findElement(recipeIdTextFiled).sendKeys(recipeId);
		driver.findElement(recipeDescription).sendKeys(recipeNameValue);
		Thread.sleep(1000);
		driver.findElement(selectMaterialDD).click();
		Thread.sleep(1000);
		String firstMasterial = driver.findElement(firstMaterialEle).getText();
		driver.findElement(firstMaterialEle).click();
		Thread.sleep(1000);
		System.out.println("first masterial name " + firstMasterial);
		driver.findElement(selectProductDD).sendKeys(firstMasterial);
		driver.findElement(By.xpath("(//div[@role='option']//span[contains(text(),'" + firstMasterial + "')])[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(validateStartDate).sendKeys(validateStartDateValue);
		Thread.sleep(1000);
		driver.findElement(validateEndDate).sendKeys(validateEndDateValue);
		Thread.sleep(2000);
		driver.findElement(statusToglleBtn).click();
		driver.findElement(taskDD).click();
		Thread.sleep(1000);

		String taskName = driver.findElement(firstTask).getText();

		driver.findElement(firstTask).click();

		driver.findElement(materialNoDD).click();
		driver.findElement(materialNoDD).sendKeys(firstMasterial);
		driver.findElement(firstMaterial).click();
		driver.findElement(quantity).sendKeys("4");
		driver.findElement(UomDD).click();
		driver.findElement(UOMUnit).click();
		Thread.sleep(3000);

		driver.findElement(definePreProductionEventtab).click();
		Thread.sleep(2000);

		driver.findElement(pleaseSelectPreProductionRecipeDD).click();
		Thread.sleep(2000);
		driver.findElement(selectPreProcessingRecipe).click();
		Thread.sleep(2000);
		driver.findElement(sourceTaskDD).click();
		Thread.sleep(3000);
		System.out.println("Task Name is " + taskName);
		driver.findElement(sourceTaskInputBox).sendKeys(taskName);
		Thread.sleep(3000);
		List<WebElement> ls = driver.findElements(avaialbleTask);
		int size = ls.size();

		if (size > 1) {
			return false;
		} else {
			return true;
		}

	}

	public boolean verifyUserIsAbleToCreateRecipeByAddingConsumptionPointTest() throws InterruptedException {
		recipeNameValueConsumption = "Test";
		recipeNameValueConsumption = recipeNameValue + RandomStringUtils.randomAlphabetic(2);
		recipeId = RandomStringUtils.randomNumeric(4);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(recipeBtn).click();
		Thread.sleep(2000);
		driver.findElement(recipeNameTextFiled).sendKeys(recipeNameValueConsumption);
		System.out.println("Recipe Name :" + recipeNameValueConsumption);
		driver.findElement(recipeIdTextFiled).sendKeys(recipeId);
		driver.findElement(recipeDescription).sendKeys(recipeNameValueConsumption);
		Thread.sleep(1000);
		driver.findElement(selectMaterialDD).click();
		Thread.sleep(1000);
		String firstMasterial = driver.findElement(firstMaterialEle).getText();
		driver.findElement(firstMaterialEle).click();
		Thread.sleep(1000);
		System.out.println("first masterial name " + firstMasterial);
		driver.findElement(selectProductDD).sendKeys(firstMasterial);
		driver.findElement(By.xpath("(//div[@role='option']//span[contains(text(),'" + firstMasterial + "')])[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(validateStartDate).sendKeys(validateStartDateValue);
		Thread.sleep(1000);
		driver.findElement(validateEndDate).sendKeys(validateEndDateValue);
		Thread.sleep(2000);
		driver.findElement(statusToglleBtn).click();
		driver.findElement(taskDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		driver.findElement(materialNoDD).click();
		driver.findElement(firstMaterial).click();
		driver.findElement(quantity).sendKeys("4");
		driver.findElement(UomDD).click();
		driver.findElement(UOMUnit).click();
		Thread.sleep(3000);
		driver.findElement(addnewConsumptionPtBtn).click();
		Thread.sleep(1000);
		driver.findElement(consumptionPointTaskDD).click();
		driver.findElement(firstTask).click();
		driver.findElement(consumptionPointMaterialNumberDD).click();
		driver.findElement(firstMaterial).click();
		driver.findElement(consumptionPointQty).sendKeys("4");
		Thread.sleep(1000);
		driver.findElement(consumptionPointUOM).click();
		driver.findElement(UOMUnit).click();
		Thread.sleep(3000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Recipe Details insert successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAvlOfCreatedRecipeByAddingConsumptionPointTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(recipeNameValueConsumption);

		try {
			driver.findElement(createdRecipeEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserIsAbleToDeleteCreatedRecipeByAddingConsumptionPointTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(recipeNameValueConsumption);
		String toasterMessage = "null";
		try {
			driver.findElement(threeDot).click();
			driver.findElement(deleteRecipeBtn).click();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Data Deleted Successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvlOfCreatedRecipeByAddingConsumptionPointPostDeleteTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(recipeNameValueConsumption);

		try {
			driver.findElement(createdRecipeEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyUserIsAbleCreateRecipeByAddingTimeBasedConstraintWithSpecialSymbolTest()
			throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		recipeNameValue = recipeNameValue + RandomStringUtils.randomAlphabetic(2);
		recipeId = RandomStringUtils.randomNumeric(4);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(recipeBtn).click();
		Thread.sleep(2000);
		driver.findElement(recipeNameTextFiled).sendKeys(recipeNameValue);
		System.out.println("Recipe Name :" + recipeNameValue);
		driver.findElement(recipeIdTextFiled).sendKeys(recipeId);
		driver.findElement(recipeDescription).sendKeys(recipeNameValue);
		Thread.sleep(1000);
		driver.findElement(selectMaterialDD).click();
		Thread.sleep(1000);
		String firstMasterial = driver.findElement(firstMaterialEle).getText();
		driver.findElement(firstMaterialEle).click();
		Thread.sleep(1000);
		System.out.println("first masterial name " + firstMasterial);
		driver.findElement(selectProductDD).sendKeys(firstMasterial);
		driver.findElement(By.xpath("(//div[@role='option']//span[contains(text(),'" + firstMasterial + "')])[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(validateStartDate).sendKeys(validateStartDateValue);
		Thread.sleep(1000);
		driver.findElement(validateEndDate).sendKeys(validateEndDateValue);
		Thread.sleep(2000);
		driver.findElement(statusToglleBtn).click();
		driver.findElement(taskDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		driver.findElement(materialNoDD).click();
		driver.findElement(firstMaterial).click();
		driver.findElement(quantity).sendKeys("4");
		driver.findElement(UomDD).click();
		driver.findElement(UOMUnit).click();
		Thread.sleep(2000);

		driver.findElement(addNewTimebasedConstraintBtn).click();
		Thread.sleep(1000);
		driver.findElement(constraintName).sendKeys("Test'");
		System.out.println("constraint name added");
		Thread.sleep(1000);
		driver.findElement(initatingTaskDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		System.out.println("initatingTaskDD name added");
		driver.findElement(initiatingReference).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(recipeForTargetTask).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(concludingTask).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(conclusionReference).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(comparisonOperatorDD).click();
		Thread.sleep(1000);
		driver.findElement(firstTask).click();
		Thread.sleep(1000);
		driver.findElement(timeConstraintItemQty).sendKeys("4");
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(toasterMsg).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is " + toasterMessage);
		if (toasterMessage.equals("Recipe Details insert successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifySpecialSymbolAddedOrNotInCreateRecipeByAddingTimeBasedConstrainTest()
			throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(recipeNameValue);
		Thread.sleep(1000);
		driver.findElement(threeDot).click();
		driver.findElement(editButton).click();
		Thread.sleep(2000);
		String displayedContrainName = driver.findElement(constraintName).getAttribute("ng-reflect-model");

		System.out.println("Displayed constraint Name is " + displayedContrainName);
		if (displayedContrainName.equals("Test'")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteRecipeWithTimeConstraintAndSpecialSymbolsTest()
			throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(searchBox).sendKeys(recipeNameValue);
		Thread.sleep(500);

		driver.findElement(threeDot).click();
		driver.findElement(deleteRecipeBtn).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		driver.findElement(searchBox).sendKeys(recipeNameValue);
		Thread.sleep(500);
		try {
			driver.findElement(createdRecipeEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
		

	}

}
