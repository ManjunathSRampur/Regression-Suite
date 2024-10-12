package com.qa.bps.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataManagement {
	Navigation navigateTo;
	FileUpload FileUpload;
	WebDriver driver;
	private By masterDataIcon = By.xpath("//a[@id='v-pills-master']");
	private By icons = By.xpath("//div[@class='navigation-area']//img");
	private By processflowNav = By.xpath("//div[@title='process flow']");
	private By configurationNav = By.xpath("//div[@title='Configurations']");
	private By demandNav = By.xpath("//div[@title='demand']");
	private By processDataNav = By.xpath("//div[@title='process data']");
	private By SAPMIINav = By.xpath("//div[@title='SAP-MII']");
	private By planReasonsNav = By.xpath("//div[@title='Plan Reasons']");
	private By constaintsNav = By.xpath("//div[@title='constraints']");
	private By GeneralNav = By.xpath("//div[@title='General']");
	private By searchBox = By.xpath("//input[@placeholder='Search..']");
	private By listView = By.xpath("//fa-icon[@id='listIcon']");
	private By gridView = By.xpath("//fa-icon[@id='gridIcon']");
	public By masterData = By.xpath("//a[@id='v-pills-master']");
	private By dataCatalog = By.xpath("//a[@id='v-pills-catalog']");
	private By fileUpload = By.xpath("//a[@id='v-pills-file-uploads']");
	private By plannedReasonGridView = By.xpath("(//label[contains(text(),'Planned Order')])[1]");
	private By MaterialMaster = By.xpath("//div[@title='Material Master']");
	private By functionalArea = By.xpath("//div[@title='Functional Area']");
	private By Holidaycalendar = By.xpath("//div[@title='Holiday Calendar']");
	public By factorycalendar = By.xpath("//div[@title='Factory Calendar']");
	private By department = By.xpath("//div[@title='Department']");
	private By breakDownType = By.xpath("//div[@title='Breakdown Type']");
	private By ProcessBom = By.xpath("//div[@title='Process BOM']");
	private By RecipeManagement = By.xpath("//div[@title='Recipe Management']");
	private By batchNameConfigBtn = By.xpath("//a[contains(text(),'Batch Name Configuration')]");
	private By newMasterTableBtn = By.xpath("//a[contains(text(),'New Master Table')]");
	private By masterDataNameInput = By.xpath("(//input[@name='description'])[2]");
	private By masterDataDescInput = By.xpath("//input[@id='displayName']");
	private By dataCatlogValue = By.xpath("(//div[@role='option'])[1]");
	private By selectDataCatlogDD = By.xpath("(//span[@class='ng-arrow-wrapper'])[1]");
	private By selectFileType = By.xpath("(//span[@class='ng-arrow-wrapper'])[2]");
	private By addBtnTagInput = By.xpath("(//input[@id='shortText'])[1]");
	private By EditBtntag = By.xpath("(//input[@id='shortText'])[2]");
	private By searchBtnTag = By.xpath("(//input[@id='shortText'])[3]");
	private By deleteBtnTag = By.xpath("(//input[@id='shortText'])[4]");
	private By saveBtn = By.xpath("(//button[contains(text(),' Save ')])[2]");
	private By ActiveCheckBox = By.xpath("//input[@name='status']");
	private By successToaster = By.xpath("//div[@role='alertdialog']");
	private By popupCloseBtn = By.xpath("(//fa-icon[@size='lg'])[6]");
	private By masterTableDeleteBtn = By.xpath("//button[contains(text(),'Delete')]");
	private By functionalAreaTab = By.xpath("(//div[.='Functional Area'])[last()]");
	private By newFunctionalAreaBtn = By.xpath("//a[.='New Functional Area']");
	private By deleteBtn = By.xpath("//button[.='Delete']");
	private By funcAreaName = By.xpath("//label[.='Functional Area']/following-sibling::input");
	private By description = By.xpath("//label[.='Description']/following-sibling::input");
	private By searchValue = By.xpath("//div[@class='tabulator-table']");
	private By threeDot = By.xpath("//div[@class='tabulator-table']/div/div/i");
	private By editButton = By.xpath("(//div[@class='tabulator-menu-item'])[1]");
	private By deleteFunctArea = By.xpath("(//div[@class='tabulator-menu-item'])[2]");
	private By departmentScreen = By.xpath("//div[@title='Department']");
	private By newDepartmentBtn = By.xpath("//a[.='New Department']");
	private By departmentName = By.xpath("//label[.='Department']/following-sibling::input");
	private By planLocationDD = By.xpath("//input[@role='combobox']");
	private By location = By.xpath("(//div[@role='option'])[1]");
	private By activeFlag = By.xpath("(//div[@tabulator-field='active_flag'])[2]");
	private By dataCatalogTab = By.xpath("//a[@id='v-pills-catalog']");
	private By createDataCatalog = By.xpath("//a[.='Create Data Catalog']");
	private By dataCatalogName = By.xpath("//input[@id='overlayCatalogName']");
	private By selectDataSourceName = By.xpath("(//div[.='Select Data Source Type...'])[2]");
	private By selectDataSourceType = By.xpath("(//div/span[@class='ng-option-label'])[1]");
	private By enterTableName = By.xpath("//input[@id='tableNameCatalog']");
	private By selectDataCatalogType = By.xpath("(//div[.='Select data catalog type..'])[2]");
	private By selectDataCatalogTypeValue = By.xpath("//span[.='process flow']");
	private By saveDataCatalogBtn = By.xpath("//button[.='Save']");
	private By createdDataCatalogEle = By.xpath("(//div[@role='row'])[2]");
	private By createdDataCatlogNameEle = By.xpath("(//div[@tabulator-field='name'])[3]");
	private By dataCatalogDescriptionTextBox = By.xpath("//input[@id='descriptionCatalog']");

	private By createColumnButton = By.xpath("//div[@class='col-sm-6  col-md-6 col-lg-6']/button");
	private By firstColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-even'])[last()]/div)[3]");
	private By secoundColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-even'])[last()]/div)[5]");
	private By thirdColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-even'])[last()]/div)[6]");
	private By selectDataTypeColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-even'])[last()]/div)[last()-4]");
	private By clickDataTypeColumn = By.xpath("//div/select");
	private By textDataType = By.xpath("//div/select/option[.='Text']");
	private By selectIntegerDataType = By.xpath("//div/select/option[.='Integer']");
	private By selectDataTypeColumnEle = By
			.xpath("(//div[.='Product' and @class='tabulator-cell']/following-sibling::div)[4]");
	private By threeDotsToDeleteDataCatalogColumn=By.xpath("(//div[.='Product']/following-sibling::div)[1]");
	private By deleteColumnEle=By.xpath("//div[@class='tabulator-menu-item']");

	public String SuccessToaster;
	String masterDataName;
	String funcAreaValue;
	String departmentNameValue;
	String dataCatalogNameValue;
	List<WebElement> allIcons = new ArrayList<WebElement>();

	public DataManagement(WebDriver driver) {
		this.driver = driver;
	}

	public boolean userCanNavigateToDataManagement() throws InterruptedException {
		navigateTo = new Navigation(driver);
		navigateTo.DataManagement();
		return true;
	}

	public boolean availableFields() {
		driver.findElement(processflowNav).isDisplayed();
		driver.findElement(configurationNav).isDisplayed();
		driver.findElement(demandNav).isDisplayed();
		driver.findElement(processDataNav).isDisplayed();
		driver.findElement(SAPMIINav).isDisplayed();
		driver.findElement(planReasonsNav).isDisplayed();
		driver.findElement(constaintsNav).isDisplayed();
		driver.findElement(GeneralNav).isDisplayed();
		driver.findElement(searchBox).isDisplayed();
		driver.findElement(listView).isDisplayed();
		driver.findElement(gridView).isDisplayed();
		driver.findElement(masterData).isDisplayed();
		driver.findElement(dataCatalog).isDisplayed();
		driver.findElement(fileUpload).isDisplayed();
		return true;

	}

	public boolean userCanSearchDataUsingTheSearchBox() throws InterruptedException {
		driver.findElement(searchBox).sendKeys("process");
		Thread.sleep(2000);
		driver.findElement(processflowNav).isDisplayed();
		return true;

	}

	public boolean VerifySearchBoxfunctionalityByRemovingChar() throws InterruptedException {

		try {
			driver.findElement(searchBox).clear();
			Thread.sleep(2000);
			driver.findElement(processflowNav).isDisplayed();
			driver.findElement(configurationNav).isDisplayed();
			driver.findElement(demandNav).isDisplayed();
			driver.findElement(processDataNav).isDisplayed();
			driver.findElement(SAPMIINav).isDisplayed();
			driver.findElement(planReasonsNav).isDisplayed();
			driver.findElement(constaintsNav).isDisplayed();
			driver.findElement(GeneralNav).isDisplayed();
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

	public boolean usercanSeedataInGridView() throws InterruptedException {
		try {
			driver.findElement(gridView).click();
			Thread.sleep(2000);
			driver.findElement(plannedReasonGridView).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean usercanSeedataInListView() throws InterruptedException {
		try {
			driver.findElement(listView).click();
			Thread.sleep(2000);
			driver.findElement(processDataNav).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean dataAvailableUnaderMasterdata() throws InterruptedException {
		driver.findElement(masterDataIcon).click();
		Thread.sleep(2000);
		try {
			driver.findElement(MaterialMaster).isDisplayed();
			driver.findElement(functionalArea).isDisplayed();
			driver.findElement(Holidaycalendar).isDisplayed();
			driver.findElement(factorycalendar).isDisplayed();
			driver.findElement(department).isDisplayed();
			driver.findElement(breakDownType).isDisplayed();
			driver.findElement(ProcessBom).isDisplayed();
			driver.findElement(RecipeManagement).isDisplayed();
			driver.findElement(batchNameConfigBtn).isDisplayed();
			driver.findElement(newMasterTableBtn).isDisplayed();

			return true;

		} catch (Exception e) {
			return false;

		}
	}

	public boolean dataAvailableUnderFileUploadTab() throws InterruptedException {

		try {
			driver.findElement(fileUpload).click();
			Thread.sleep(2000);
			driver.findElement(listView).isDisplayed();
			driver.findElement(gridView).isDisplayed();
			driver.findElement(listView).isDisplayed();
			FileUpload = new FileUpload(driver);
			driver.findElement(FileUpload.createNewConfigration).isDisplayed();
			driver.findElement(FileUpload.createNewFolder).isDisplayed();
			driver.findElement(FileUpload.uploadNewFileBtn).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean UserCanCreateNewMasterTable() throws InterruptedException {
		masterDataName = RandomStringUtils.randomAlphabetic(4);
		masterDataName = "Automation" + masterDataName;
		driver.findElement(masterDataIcon).click();
		Thread.sleep(2000);
		driver.findElement(newMasterTableBtn).click();
		Thread.sleep(2000);
		driver.findElement(masterDataNameInput).sendKeys(masterDataName);
		Thread.sleep(1000);
		driver.findElement(masterDataDescInput).sendKeys("test description");
		Thread.sleep(1000);
		driver.findElement(selectDataCatlogDD).click();
		Thread.sleep(1000);
		driver.findElement(dataCatlogValue).click();
		driver.findElement(addBtnTagInput).sendKeys("test add Btn Tag");
		Thread.sleep(1000);
		driver.findElement(EditBtntag).sendKeys("test edit Btn Tag");
		Thread.sleep(1000);
		driver.findElement(searchBtnTag).sendKeys(" search Btn Tag");
		Thread.sleep(1000);
		driver.findElement(deleteBtnTag).sendKeys("delete Btn Tag");
		Thread.sleep(1000);
		driver.findElement(ActiveCheckBox).click();
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		SuccessToaster = driver.findElement(successToaster).getText();
		Thread.sleep(3000);

		try {
			driver.findElement(By.xpath("//div[@title='" + masterDataName + "']")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean ToasterPostnewMasterTableCreation() {

		if (SuccessToaster.equals("New Master Table Created Successfully!")) {
			return true;
		}

		else
			return false;
	}

	public boolean userCanCreateAMasterTableWithDuplicateName() throws InterruptedException {
		driver.findElement(masterDataIcon).click();
		Thread.sleep(2000);
		driver.findElement(newMasterTableBtn).click();
		Thread.sleep(2000);
		driver.findElement(masterDataNameInput).sendKeys(masterDataName);
		Thread.sleep(1000);
		driver.findElement(masterDataDescInput).sendKeys("test description");
		Thread.sleep(1000);
		driver.findElement(selectDataCatlogDD).click();
		Thread.sleep(1000);
		driver.findElement(dataCatlogValue).click();
		driver.findElement(addBtnTagInput).sendKeys("test add Btn Tag");
		Thread.sleep(1000);
		driver.findElement(EditBtntag).sendKeys("test edit Btn Tag");
		Thread.sleep(1000);
		driver.findElement(searchBtnTag).sendKeys(" search Btn Tag");
		Thread.sleep(1000);
		driver.findElement(deleteBtnTag).sendKeys("delete Btn Tag");
		Thread.sleep(1000);
		driver.findElement(ActiveCheckBox).click();
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);

		SuccessToaster = driver.findElement(successToaster).getText();
		Thread.sleep(2000);
		driver.findElement(popupCloseBtn).click();
		Thread.sleep(2000);
		List<WebElement> duplicateTable = driver.findElements(By.xpath("//div[@title='" + masterDataName + "']"));
		int x = duplicateTable.size();
		if (x == 1) {
			return true;

		}

		else
			return false;

	}

	public boolean duplicateMasterTableToaster() {
		if (SuccessToaster.equals("Master Table name Already Exist!")) {
			return true;
		} else
			return false;
	}

	public boolean userCanDeleteTheMasterTable() throws InterruptedException {

		driver.findElement(By.xpath(
				"(//div[@title='" + masterDataName + "']/parent::div/parent::div/parent::div/parent::div/*/*)[1]"))
				.click();
		System.out.println("master table Edit button clicked");
		Thread.sleep(2000);
		driver.findElement(masterTableDeleteBtn).click();
		Thread.sleep(2000);
		SuccessToaster = driver.findElement(successToaster).getText();
		try {
			driver.findElement(By.xpath("//div[@title='" + masterDataName + "']")).isDisplayed();
			return false;

		} catch (Exception e) {
			return true;
		}

	}

	public boolean toastermessagePostMasterTableDeletion() throws InterruptedException {
		Thread.sleep(5000);
		String deletetoaster = SuccessToaster.replace(" ", "");
		if (deletetoaster.equals("MasterDatadeletedsuccessfully!")) {
			return true;
		} else
			return false;
	}

	public boolean verifyUserCanNavigateToFUnctionalAreaTest() throws InterruptedException {
		driver.findElement(functionalAreaTab).click();
		Thread.sleep(1000);
		try {
			driver.findElement(newFunctionalAreaBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;

		}

	}

	public boolean verifyDeleteBtnIsDisableBfrCrtFuncAreaTest() {
		driver.findElement(newFunctionalAreaBtn).click();
		boolean b = driver.findElement(deleteBtn).isEnabled();
		System.out.println(b);
		if (b == true) {
			return false;
		} else {
			return true;
		}
	}

	public boolean verifyUserCanCreateANewFunctionalAreaTest() throws InterruptedException {
		funcAreaValue = RandomStringUtils.randomAlphabetic(4);
		funcAreaValue = "automation" + funcAreaValue;
		driver.findElement(funcAreaName).sendKeys(funcAreaValue);
		Thread.sleep(1000);
		System.out.println("new created functional area " + funcAreaValue);
		driver.findElement(description).sendKeys(funcAreaValue);
		Thread.sleep(500);
		driver.findElement(saveBtn).click();
		Thread.sleep(500);
		String tstMsg = "null";
		try {
			tstMsg = driver.findElement(successToaster).getText().replace(" ", "");
			System.out.println("Toaster message is*" + tstMsg + "*");
		} catch (Exception e) {
			tstMsg = "null";
		}
		if (tstMsg.equals("FunctionalareasavedSuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyFunctOfSearchBoxTest() throws InterruptedException {
		driver.findElement(searchBox).sendKeys(funcAreaValue);
		Thread.sleep(5000);
		try {
			driver.findElement(searchValue).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanEditFuncAreaTest() throws InterruptedException {
		driver.findElement(threeDot).click();
		Thread.sleep(2000);
		driver.findElement(editButton).click();
		Thread.sleep(1000);
		driver.findElement(description).clear();

		driver.findElement(description).sendKeys(funcAreaValue + "Update");
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(500);
		String tstMsg = "null";
		try {
			tstMsg = driver.findElement(successToaster).getText().replace(" ", "");
		} catch (Exception e) {
			tstMsg = "null";
		}
		Thread.sleep(5000);
		System.out.println("Toaster message is  " + tstMsg);
		if (tstMsg.equals("FunctionalareaupdatedSuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteFuncAreaTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(8000);
		driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys(funcAreaValue);
		Thread.sleep(1000);
		driver.findElement(threeDot).click();
		Thread.sleep(2000);
		driver.findElement(deleteFunctArea).click();
		Thread.sleep(1000);
		driver.findElement(deleteBtn).click();
		Thread.sleep(500);
		String tstMsg = "null";
		try {
			tstMsg = driver.findElement(successToaster).getText().replace(" ", "");
		} catch (Exception e) {
			tstMsg = "null";
		}
		System.out.println("Toaster message is  " + tstMsg);
		if (tstMsg.equals("FunctionalareadeletedSuccessfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanNavigateDepartmentScreenTest() throws InterruptedException {
		navigateTo.DataManagement();
		Thread.sleep(1000);
		driver.findElement(masterDataIcon).click();
		Thread.sleep(2000);
		driver.findElement(departmentScreen).click();
		Thread.sleep(1000);
		try {
			driver.findElement(newDepartmentBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanCreateNewDepartmentTest() throws InterruptedException {
		departmentNameValue = RandomStringUtils.randomAlphabetic(4);
		departmentNameValue = "automation" + departmentNameValue;
		System.out.println("Department name is " + departmentNameValue);
		driver.findElement(newDepartmentBtn).click();
		Thread.sleep(2000);
		driver.findElement(departmentName).sendKeys(departmentNameValue);
		Thread.sleep(1000);
		driver.findElement(description).sendKeys(departmentNameValue);
		Thread.sleep(1000);
		driver.findElement(planLocationDD).click();
		Thread.sleep(1000);
		driver.findElement(location).click();
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(500);
		String tstMsg = "null";
		try {
			tstMsg = driver.findElement(successToaster).getText().replace(" ", "");
		} catch (Exception e) {
			tstMsg = "null";
		}
		System.out.println("Toaster message is  " + tstMsg);
		if (tstMsg.equals("DepartmentsavedSuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheFunctOfDepartmentSearchBoxTest() {
		driver.findElement(searchBox).sendKeys(departmentNameValue);
		try {
			driver.findElement(searchValue).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanEditTheDepartmentTest() throws InterruptedException {
		driver.findElement(threeDot).click();
		Thread.sleep(2000);
		driver.findElement(editButton).click();
		Thread.sleep(1000);
		driver.findElement(description).clear();

		driver.findElement(description).sendKeys(departmentNameValue + "Update");
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(500);
		String tstMsg = "null";
		try {
			tstMsg = driver.findElement(successToaster).getText().replace(" ", "");
		} catch (Exception e) {
			tstMsg = "null";
		}
		System.out.println("Toaster message is  " + tstMsg);
		if (tstMsg.equals("DepartmentupdatedSuccessfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanChangeActiveStatuTest() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(departmentNameValue);
		String activeFlagValueBeforeClick = driver.findElement(activeFlag).getAttribute("aria-checked");
		System.out.println(activeFlagValueBeforeClick);
		driver.findElement(activeFlag).click();
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(departmentNameValue);
		String activeFlagValueAfterClick = driver.findElement(activeFlag).getAttribute("aria-checked");
		System.out.println(activeFlagValueAfterClick);
		if (!activeFlagValueBeforeClick.equals(activeFlagValueAfterClick)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteTheDepartmentTest() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(departmentNameValue);
		Thread.sleep(1000);
		driver.findElement(threeDot).click();
		Thread.sleep(2000);
		driver.findElement(deleteFunctArea).click();
		Thread.sleep(1000);
		driver.findElement(deleteBtn).click();
		Thread.sleep(500);
		String tstMsg = "null";
		try {
			tstMsg = driver.findElement(successToaster).getText().replace(" ", "");
		} catch (Exception e) {
			tstMsg = "null";
		}
		System.out.println("Toaster message is " + tstMsg);
		if (tstMsg.equals("DepartmentdeletedSuccessfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanCreateDataCatalogWithSpecialCharactorTest() throws InterruptedException {
		navigateTo.DataManagement();
		Thread.sleep(2000);
		String randomText = RandomStringUtils.randomAlphabetic(3);
		dataCatalogNameValue = "TestDataCatalog" + randomText;
		dataCatalogNameValue = dataCatalogNameValue + "'";
		driver.findElement(dataCatalogTab).click();
		Thread.sleep(3000);
		driver.findElement(createDataCatalog).click();
		driver.findElement(dataCatalogName).sendKeys(dataCatalogNameValue);
		driver.findElement(selectDataSourceName).click();
		Thread.sleep(1000);
		driver.findElement(selectDataSourceType).click();

		dataCatalogNameValue = dataCatalogNameValue.replace("'", "");

		driver.findElement(enterTableName).sendKeys(dataCatalogNameValue);
		driver.findElement(selectDataCatalogType).click();
		Thread.sleep(1000);
		driver.findElement(selectDataCatalogTypeValue).click();
		Thread.sleep(1000);
		driver.findElement(saveDataCatalogBtn).click();
		Thread.sleep(1000);
		String toasterMsg = "null";
		try {
			toasterMsg = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}
		if (toasterMsg.equals("Data Catalog created successfully.")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvlOfSpecialSymboleDataCatalogTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(dataCatalogNameValue + "'");
		Thread.sleep(2000);

		try {
			driver.findElement(createdDataCatalogEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserIsAbleToEditTheDataCatalogTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(dataCatalogNameValue + "'");
		Thread.sleep(2000);
		driver.findElement(createdDataCatlogNameEle).click();
		Thread.sleep(2000);
		driver.findElement(dataCatalogDescriptionTextBox).sendKeys("Update Data Catalog");
		driver.findElement(saveDataCatalogBtn).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(dataCatalogNameValue + "'");
		Thread.sleep(2000);
		driver.findElement(createdDataCatlogNameEle).click();
		Thread.sleep(2000);
		String descriptiongUpdatedValue = driver.findElement(dataCatalogDescriptionTextBox)
				.getAttribute("ng-reflect-model");
		System.out.println("Description is " + descriptiongUpdatedValue);
		if (descriptiongUpdatedValue.equals(" Update Data Catalog")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToAddTheNewColumnToDataCatalogTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(dataCatalogNameValue + "'");
		Thread.sleep(2000);
		driver.findElement(createdDataCatlogNameEle).click();
		Thread.sleep(2000);

		driver.findElement(createColumnButton).click();
		driver.findElement(firstColumn).sendKeys("Product");
		driver.findElement(secoundColumn).click();
		driver.findElement(secoundColumn).sendKeys("Product");
		driver.findElement(thirdColumn).click();
		driver.findElement(thirdColumn).sendKeys("Product");
		driver.findElement(selectDataTypeColumn).click();
		driver.findElement(selectDataTypeColumn).click();
		Thread.sleep(2000);
		driver.findElement(clickDataTypeColumn).click();
		Thread.sleep(2000);
		driver.findElement(textDataType).click();
		Thread.sleep(2000);

		driver.findElement(saveDataCatalogBtn).click();
		Thread.sleep(1000);
		String toasterMsg = "null";
		try {
			toasterMsg = driver.findElement(successToaster).getText();
		} catch (Exception e) {

		}
		if (toasterMsg.equals("Data Catalog changes saved successfully.")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvlOfAddedColumnInDataCatalogTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(dataCatalogNameValue + "'");
		Thread.sleep(2000);
		driver.findElement(createdDataCatlogNameEle).click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//div[.='Product']")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserIsAbleToChangeTheDataTypeOfAddedColumnTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(dataCatalogNameValue + "'");
		Thread.sleep(2000);
		driver.findElement(createdDataCatlogNameEle).click();
		Thread.sleep(2000);
		driver.findElement(selectDataTypeColumnEle).click();
		driver.findElement(selectDataTypeColumnEle).click();
		Thread.sleep(2000);
		driver.findElement(clickDataTypeColumn).click();
		Thread.sleep(2000);
		driver.findElement(selectIntegerDataType).click();
		Thread.sleep(2000);
		driver.findElement(saveDataCatalogBtn).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(dataCatalogNameValue + "'");
		Thread.sleep(2000);
		driver.findElement(createdDataCatlogNameEle).click();
		Thread.sleep(2000);
		String chnagedDataType = driver.findElement(selectDataTypeColumnEle).getText();
		System.out.println("Chnaged data type is " + chnagedDataType);
		if (chnagedDataType.equals("Integer")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToDeleteAddedColumnTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(dataCatalogNameValue + "'");
		Thread.sleep(2000);
		driver.findElement(createdDataCatlogNameEle).click();
		Thread.sleep(2000);
		driver.findElement(threeDotsToDeleteDataCatalogColumn).click();
		Thread.sleep(1000);
		driver.findElement(deleteColumnEle).click();
		Thread.sleep(2000);
		driver.findElement(saveDataCatalogBtn).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(dataCatalogNameValue + "'");
		Thread.sleep(2000);
		driver.findElement(createdDataCatlogNameEle).click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//div[.='Product']")).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
		
	}
}
