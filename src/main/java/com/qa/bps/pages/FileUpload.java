package com.qa.bps.pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;
import com.qa.bps.utils.ExcelUtil;

public class FileUpload {

	private By fileuploadbtn = By.xpath("//button/a[contains(text(),'Upload New File')]");
	private By browseBtn = By.xpath("//input[@id='file']");
	private By upload = By.xpath("//*[normalize-space(text()) = 'Choose File']");
	private By uploadfileTypes = By
			.xpath("(//div[contains(@class, 'dropdown-menu customHeight ng-star-inserted show')])//a");
	private By uploadfileCampaign = By.xpath("(//div[contains(@class, 'dropdown-menu customHeight')])//a)[1]");
	private By filetypeInventory = By.xpath("(//div[contains(@class,'dropdown-menu customHeight')]/a[4])[2]");
	private By filetypeCampaign = By.xpath("(//div[contains(@class,'dropdown-menu customHeight')]/a[1])[2]");
	private By uploadbtn = By.xpath("//button[@class='btn btn-warning mt-2 next-btn']");
	private By uploadfilename = By.xpath("//span[@class='text-ellipsis']");
	private By uploadafterfilename = By.xpath("//input[@formcontrolname='fileName']");
	private By searchFile = By.xpath("//input[@class='search-input form-control']");
	private By uploadedOn = By.xpath("//div[@class='inside-text'][1]");
	private By uploadedBy = By.xpath("//div[@class='inside-text'][2]");
	private By uploadStatus = By.xpath("//div[@class='inside-text'][3]");
	private By viewicon = By.xpath("//i[@class='fa fa-eye']");
	private By userloggedIn = By.xpath("//p[@id='navbarDropdown']");
	private By uploadDetails = By.xpath("//div[@class='inside-text']");
	private By sNo = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]");
	private By pName = By.xpath("//table[@class='table table-bordered']//td[2]");
	private By date = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[3]");
	private By closingInv = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[4]");
	private By lastClosedBt = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[5]");
	private By totalInvRow = By.xpath("//table[@class='table table-bordered']/tbody/tr");
	private By viewIconInventory = By.xpath("(//i[@class='fa fa-eye'])[2]");
	private By viewIconCampaign = By.xpath("(//i[@class='fa fa-eye'])[1]");
	private By crossMarkBtn = By.xpath("//div[@class='modal-content ']//button[contains(@class,'close')]");
	private By row1 = By.xpath("//div[@class='table-data']//tr[2]/td[2]");
	private By row2 = By.xpath("//div[@class='table-data']//tr[3]/td[2]");
	private By inventoryFileuploadDetails = By.xpath("(//i[@class='fa fa-eye'])[11]");
	private By Rows = By.xpath("//div[@class='table-data']//tr");
	private By inventoryeyeIcon = By.xpath("(//i[@class='fa fa-eye'])[2]");
	private By inventoryTable = By.xpath("//tbody/tr");
	private By uploadFailedFile = By.xpath("(//div[contains(text(),'Upload failed')])[1]");
	private By fileUpload = By.xpath("(//div[contains(@class,'dropdown-menu customHeight')])[1]/a");
	private By allFilesDropDown = By.xpath("(//div[@class='btn-text grey-text'])[1]");
	private By downloadTemplate = By.xpath("//a[contains(text(),'Download Template')]");
	private By chooseFile = By.xpath("//div[contains(text(), 'Choose File')]");
	private By uploadCampaign = By.xpath("(//a[contains(text(),'Campaign Data')])[2]");
	private By closeBtn = By.xpath("(//span[contains(text(),'×')])[2]");
	private By closeBtnInvView = By.xpath("(//span[contains(text(),'×')])[3]");
	private By cancelBtn = By.xpath("//a[contains(text(),'Cancel')]");
	private By downloadBtn = By.xpath("(//img[@title='Download Report'])[1]");

	List<String> prodnamelist = new ArrayList<String>();
	List<WebElement> prodnamewe = new ArrayList<WebElement>();
	List<String> prodnameListCampaign = new ArrayList<String>();
	List<WebElement> prodnameweListCampaign = new ArrayList<WebElement>();
	List<String> stringnameList = new ArrayList<String>();
	List<WebElement> nameslist = new ArrayList<WebElement>();
	List<String> campaign_ID = new ArrayList<String>();
	List<Object> campaign_ID_From_Excel = new ArrayList<Object>();
	List<Object> inventory_ID_From_Excel = new ArrayList<Object>();
	List<WebElement> allFilesName = new ArrayList<WebElement>();
	List<String> stringnamesList = new ArrayList<String>();
	String before_xpath = "//div[@class='table-data']//tr[";
	String after_xpath = "]/td[2]";
	String filename;
	String uploadSucessMsg = "Uploaded successfully";
	String uploadAlertTxt;
	WebDriverWait wt;
	WebDriver driver;
	Navigation navigateTo;
	ExcelUtil eu;
	private ElementUtil eleUtil;

//	------------------------------------------------------------------------------------

	private By dataCatalogTab = By.xpath("//a[@id='v-pills-catalog']");
	private By createDataCatalog = By.xpath("//a[.='Create Data Catalog']");
	private By dataCatalogName = By.xpath("//input[@id='overlayCatalogName']");
	private By selectDataSourceName = By.xpath("(//div[.='Select Data Source Type...'])[2]");
	private By selectDataSourceType = By.xpath("(//div/span[@class='ng-option-label'])[1]");
	private By enterTableName = By.xpath("//input[@id='tableNameCatalog']");
	private By selectDataCatalogType = By.xpath("(//div[.='Select data catalog type..'])[2]");
	private By selectDataCatalogTypeValue = By.xpath("//span[.='process flow']");
	private By createColumnButton = By.xpath("//div[@class='col-sm-6  col-md-6 col-lg-6']/button");
	private By firstColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-even'])[last()]/div)[3]");
	private By secoundColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-even'])[last()]/div)[5]");
	private By thirdColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-even'])[last()]/div)[6]");
	private By selectDataTypeColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-even'])[last()]/div)[last()-4]");
	private By numberOfBatch = By.xpath("(//div[@tabulator-field='datatype_display'])[9]");

	private By oddrowFirstColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-odd'])[last()]/div)[3]");
	private By oddrowSecoundColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-odd'])[last()]/div)[5]");
	private By oddrowThirdColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-odd'])[last()]/div)[6]");
	private By oddrowFourthColumn = By
			.xpath("((//div[@class='tabulator-row tabulator-selectable tabulator-row-odd'])[last()]/div)[7]");
	private By campaignStartDate = By.xpath("(//div[@tabulator-field='datatype_display'])[10]");
	private By saveDataCatalogBtn = By.xpath("//button[.='Save']");
	private By toasterMessage = By.xpath("//div/div[@class='toast-message ng-star-inserted']");
	private By closeIcon = By.xpath("//div[@class='row']/a");
	private By searchBox = By.xpath("//input[@placeholder='Search..']");
	private By createdDataCatalogue = By
			.xpath("//div[@class='tabulator-row tabulator-selectable tabulator-row-even tabulator-tree-level-1']");
	private By fileUploadTab = By.xpath("//a[@id='v-pills-file-uploads']");
	public By createNewFolder = By.xpath("//button[.='Create New Folder']");
	private By folderName = By.xpath("//input[@placeholder='Create new directory']");
	private By createFolderBtn = By.xpath("//button[@id='button2']");
	public By createNewConfigration = By.xpath("//button[.='Create New Configuration']");
	private By selectDirectory = By.xpath("//select[@formcontrolname='ParentDirectory']");
	private By selectCreatedFolder = By.xpath("(//select[@formcontrolname='ParentDirectory']/option)[last()]");
	private By enterColumnName = By.xpath("//input[@placeholder='Enter column name']");
	private By selectDataType = By.xpath("//select[@formcontrolname='DataType']");
	private By addColumn = By.xpath("//i[@class='fa fa-plus']");
	private By fileStructureName = By.xpath("//input[@formcontrolname='FileStructureName']");
	private By nextBtnUnderFileConfig = By.xpath("(//button[.=' Next '])[2]");
	private By saveBtn = By.xpath("(//button[.=' Save '])[3]");
	private By addNewConstraint = By.xpath("//button[.=' Add New Constraint ']");
	private By selectColumn = By.xpath("//select[@formcontrolname='FieldName']");
	private By selectColumn2op = By.xpath("(//select[@formcontrolname='FieldName'])[2]");
	private By selectColumn3op = By.xpath("(//select[@formcontrolname='FieldName'])[3]");
	private By selectColumn4op = By.xpath("(//select[@formcontrolname='FieldName'])[4]");
	private By selectColumn5op = By.xpath("(//select[@formcontrolname='FieldName'])[5]");
	private By selectColumn1 = By.xpath("(//select[@formcontrolname='FieldName']/option)[2]");
	private By selectColumn2 = By.xpath("((//select[@formcontrolname='FieldName'])[2]/option)[3]");
	private By selectColumn3 = By.xpath("((//select[@formcontrolname='FieldName'])[3]/option)[4]");
	private By selectColumn4 = By.xpath("((//select[@formcontrolname='FieldName'])[4]/option)[5]");
	private By selectColumn5 = By.xpath("((//select[@formcontrolname='FieldName'])[5]/option)[6]");
	private By selectConstraint = By.xpath("//select[@formcontrolname='ConstraintType']");
	private By selectConstraintOp2 = By.xpath("(//select[@formcontrolname='ConstraintType'])[2]");
	private By selectConstraintOp3 = By.xpath("(//select[@formcontrolname='ConstraintType'])[3]");
	private By selectConstraintOp4 = By.xpath("(//select[@formcontrolname='ConstraintType'])[4]");
	private By selectConstraintOp5 = By.xpath("(//select[@formcontrolname='ConstraintType'])[5]");
	private By isMandatoryConstraint = By.xpath("(//select[@formcontrolname='ConstraintType']/option)[2]");
	private By isMandatoryConstraint2 = By.xpath("((//select[@formcontrolname='ConstraintType'])[2]/option)[2]");
	private By isMandatoryConstraint3 = By.xpath("((//select[@formcontrolname='ConstraintType'])[3]/option)[2]");
	private By isMandatoryConstraint4 = By.xpath("((//select[@formcontrolname='ConstraintType'])[4]/option)[2]");
	private By isMandatoryConstraint5 = By.xpath("((//select[@formcontrolname='ConstraintType'])[5]/option)[2]");
	private By selectDataCatalog = By.xpath("//select[@formcontrolname='DataCatalog']");
	private By dataCatalogColumn1DD = By.xpath("(//select[@formcontrolname='DataCatalogColumn'])[1]");
	private By dataCatalogColumn1Op = By
			.xpath("(//select[@formcontrolname='DataCatalogColumn'])[1]/option[.=' Product']");
	private By dataCatalogColumn2DD = By.xpath("(//select[@formcontrolname='DataCatalogColumn'])[2]");
	private By dataCatalogColumn2Op = By
			.xpath("(//select[@formcontrolname='DataCatalogColumn'])[2]/option[.=' campaign_id']");
	private By dataCatalogColumn3DD = By.xpath("(//select[@formcontrolname='DataCatalogColumn'])[3]");
	private By dataCatalogColumn3Op = By
			.xpath("(//select[@formcontrolname='DataCatalogColumn'])[3]/option[.=' Number_Of_Batches']");
	private By dataCatalogColumn4DD = By.xpath("(//select[@formcontrolname='DataCatalogColumn'])[4]");
	private By dataCatalogColumn4Op = By
			.xpath("(//select[@formcontrolname='DataCatalogColumn'])[4]/option[.=' campaign_start_date']");
	private By dataCatalogColumn5DD = By.xpath("(//select[@formcontrolname='DataCatalogColumn'])[5]");
	private By dataCatalogColumn5Op = By
			.xpath("(//select[@formcontrolname='DataCatalogColumn'])[5]/option[.=' campaign_end_date']");
	private By closeButton = By.xpath("(//a[@class='close'])[3]");
	String dataCatalogNameValue;
	private By selectDataCatalogValue = By.xpath("(//select[@formcontrolname='DataCatalog']/option)[2]");
	String folderValue;
	private By createdFolder = By.xpath("//strong[.='" + folderValue + "']");
	String fileStructureNameValue;
	private By createdFileStructure = By.xpath("//strong[.='" + fileStructureNameValue + "']");
	public By uploadNewFileBtn = By.xpath("//button[.='Upload New File']");
	private By uploadFileArea = By.xpath("//input[@id='fileDropRef']");
	private By nextButtonToUploadFile = By.xpath("(//button[.=' Next '])[1]");
	private By uploadFileBtn = By.xpath("//button[.='Upload File']");
	private By homeBtn = By.xpath("//span[.='Home']");
	private By homeIcon = By.xpath("//li[@class='breadcrumb-item']");
	private By uploadedFile = By.xpath("(//tr/td)[1]");
	private By eyeIcon = By.xpath("(//i[@class='fa fa-eye'])[1]");
	private By dataUnderEyeIcon = By.xpath("(//table[@class='table table-bordered']/tbody/tr)[2]");
	private By dataAvlUnderEyeIcon = By.xpath("//table[@class='table table-bordered']/tbody/tr/td");
	private By closeWindowBtn = By.xpath("(//a[@class='close'])[2]");
	private By downloadUploadedFile = By.xpath("(//div[@class='col']/img)[1]");
	private By closeWindoOfView = By.xpath("(//button[@class='close'])[last()]");
	private By clickDataTypeColumn = By.xpath("//div/select");
	private By selectIntegerDataType = By.xpath("//div/select/option[.='Integer']");
	private By selectDateDataType = By.xpath("//div/select/option[.='Date']");
	private By textDataType = By.xpath("//div/select/option[.='Text']");
	private By campaignFolder = By.xpath("//strong[.='Ujpest' or .='Campaign']");
	private By campaigFile = By.xpath("//strong[.='Campaign Data' or .='Campaign File']");
	private By latestUploadedFile = By.xpath("(//td/strong)[1]");
	private By allUploadedFiles = By.xpath("(//td/strong)");

	private By bodheeLogo = By.xpath("//img[@src='./assets/png/bodhee_logo_new.png']");
	private By microPlanningTab = By.xpath("//div[.=' Microplanning ']");
	private By plannerTab = By.xpath("//div[.=' Planner ']");
	private By allUploadedFileEle = By.xpath("(//td/strong)");
	private By createPlan = By.xpath("//label[@title='Create New Plan']");
	private By planTitle = By.xpath("//input[@id='planTitle']");
	private By planDesc = By.xpath("//input[@id='planDescription']");
	private By planningcycle = By.xpath("//div[contains(text(),'Planning Cycle')]");
	private By planningcycleval = By.xpath("(//a[contains(text(),'Mid Term Plan')])[2]");
	private By baseLineDate = By.xpath("(//input[@id='baseLineDate'])");
	private By scenarioDD = By.xpath("//div[contains(text(),'Choose Scenario')]");
	private By scenarioDDval = By.xpath("//a[.=' Custom ']");
	String pageTitle;
	private By nextBtn = By.xpath("//button[.='Next']");
	private By doneBtn = By.xpath("//button[contains(text(),'Done')]");
	private By campaigntgt = By.xpath("(//span[@class='checkmark'])[20]");
	private By schedulingGrain = By.xpath("//input[@placeholder='in Mins']");
	private By employeeConstraint = By.xpath("(//span[@class='checkmark'])[3]");
	private By latestCampaignFile = By.xpath("(//input[@type='checkbox'])[2]");
	private By latestCampaignFileInPlanner = By.xpath("(//app-dropdown/div/button/div[@class='btn-text'])[2]");
	private By closeIconOfCreatPlanWindow = By.xpath("(//button[@class='close'])[3]");
	private By allUploadedFilesInPlannerEle = By
			.xpath("//div[@class='dropdown-menu customHeight ng-star-inserted show']/a");
	private By chooseCampaignDD = By.xpath("//div[.=' Choose Campaign ']");
	private By microPlanningList = By.xpath("//li[.=' Microplanning ']");
	private By fileUploadCard = By.xpath("//div[.=' File Upload ']");
	private By dataCard = By.xpath("//div[@class='card']");
	private By galaryViewBtn = By.xpath("//fa-icon[@title='Gallery View']");
	private By listViewBtn = By.xpath("//fa-icon[@title='List View']");
	private By dataCardInListView = By.xpath("//td[@class='ellipsis']");
	private By threeDots = By.xpath("//button[@class='dropbtn']");
	private By editIcon = By.xpath("//span[.='Edit']");
	private By deleteIcon = By.xpath("//span[.='Delete']");
	private By createdFolderEle = By.xpath("//td[@class='ellipsis']");

	List<String> allUploadedFileValue = new ArrayList<String>();

	List<String> allUploadedFileValueInPlanner = new ArrayList<String>();
	String planMsg;
	String latestUploadedFileName;
	String baseLineDates;
	int availableFileSize;

	List<WebElement> viewData = new ArrayList<WebElement>();
	List<String> storeDisplayedData = new ArrayList<String>();

	public FileUpload(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

// ----------------------------------updated test case start from here ---------------------------------------

	public boolean createDataCatalog() throws InterruptedException, AWTException {
		Actions actions = new Actions(driver);
		String randomText = RandomStringUtils.randomAlphabetic(3);
		dataCatalogNameValue = "debugBatch" + randomText;
		driver.findElement(dataCatalogTab).click();
		Thread.sleep(3000);
		driver.findElement(createDataCatalog).click();
		driver.findElement(dataCatalogName).sendKeys(dataCatalogNameValue);
		driver.findElement(selectDataSourceName).click();
		Thread.sleep(1000);
		driver.findElement(selectDataSourceType).click();
		driver.findElement(enterTableName).sendKeys(dataCatalogNameValue);
		driver.findElement(selectDataCatalogType).click();
		Thread.sleep(1000);
		driver.findElement(selectDataCatalogTypeValue).click();
		Thread.sleep(1000);
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

		driver.findElement(createColumnButton).click();
		driver.findElement(oddrowFirstColumn).sendKeys("campaign_id");
		driver.findElement(oddrowSecoundColumn).click();
		driver.findElement(oddrowSecoundColumn).sendKeys("campaign_id");
		driver.findElement(oddrowThirdColumn).click();
		driver.findElement(oddrowThirdColumn).sendKeys("campaign_id");

		driver.findElement(oddrowFourthColumn).click();
		driver.findElement(oddrowFourthColumn).click();
		Thread.sleep(2000);
		driver.findElement(clickDataTypeColumn).click();
		Thread.sleep(2000);
		driver.findElement(textDataType).click();
		Thread.sleep(2000);
		driver.findElement(createColumnButton).click();
		driver.findElement(firstColumn).sendKeys("Number_Of_Batches");
		driver.findElement(secoundColumn).click();
		driver.findElement(secoundColumn).sendKeys("Number_Of_Batches");
		driver.findElement(thirdColumn).click();
		driver.findElement(thirdColumn).sendKeys("Number_Of_Batches");
		driver.findElement(numberOfBatch).click();
		driver.findElement(numberOfBatch).click();

		Thread.sleep(2000);
		driver.findElement(clickDataTypeColumn).click();
		Thread.sleep(2000);
		driver.findElement(selectIntegerDataType).click();
		Thread.sleep(5000);

		driver.findElement(createColumnButton).click();
		driver.findElement(oddrowFirstColumn).sendKeys("campaign_start_date");
		driver.findElement(oddrowSecoundColumn).click();
		driver.findElement(oddrowSecoundColumn).sendKeys("campaign_start_date");
		driver.findElement(oddrowThirdColumn).click();
		driver.findElement(oddrowThirdColumn).sendKeys("campaign_start_date");
		Thread.sleep(2000);
		driver.findElement(campaignStartDate).click();
		driver.findElement(campaignStartDate).click();
		driver.findElement(clickDataTypeColumn).click();
		driver.findElement(selectDateDataType).click();

		Thread.sleep(2000);

		driver.findElement(createColumnButton).click();

		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		driver.findElement(firstColumn).sendKeys("campaign_end_date");
		Thread.sleep(1000);
		driver.findElement(secoundColumn).click();
		driver.findElement(secoundColumn).sendKeys("campaign_end_date");
		Thread.sleep(1000);
		driver.findElement(thirdColumn).click();
		driver.findElement(thirdColumn).sendKeys("campaign_end_date");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//div[@tabulator-field='datatype_display'])[11]")).click();
		driver.findElement(By.xpath("(//div[@tabulator-field='datatype_display'])[11]")).click();

		driver.findElement(clickDataTypeColumn).click();
		Thread.sleep(2000);
		driver.findElement(selectDateDataType).click();

		Thread.sleep(2000);

		try {
			driver.findElement(saveDataCatalogBtn).click();
			Thread.sleep(2000);
			String tostMsg = driver.findElement(toasterMessage).getText();
			System.out.println(tostMsg);
			if (tostMsg.equalsIgnoreCase("Data Catalog created successfully.")) {
				return true;
			} else {
				System.out.println("Unable to create the new data catalog ");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Unable to create the new data catalog ");
			driver.findElement(closeIcon).click();
			return false;

		}
	}

	public boolean checkDataCatalogAfterCreation() {
		driver.findElement(searchBox).sendKeys(dataCatalogNameValue);
		try {

			driver.findElement(createdDataCatalogue).isDisplayed();
			return true;
		} catch (Exception e) {
			System.out.println("Created data catalogue is not displayed ");
			return false;
		}
	}

	public boolean createNewFolder() throws InterruptedException {
		String randomText = RandomStringUtils.randomAlphabetic(3);
		folderValue = "automation_folder" + randomText;

		createdFolder = By.xpath("//strong[.='" + folderValue + "']");

		driver.findElement(fileUploadTab).click();
		Thread.sleep(2000);
		driver.findElement(createNewFolder).click();
		driver.findElement(folderName).sendKeys(folderValue);
		try {
			driver.findElement(createFolderBtn).click();
			Thread.sleep(1000);
			String tostMsg = driver.findElement(toasterMessage).getText();
			Thread.sleep(2000);
			try {
				driver.findElement(closeWindowBtn).click();
				System.out.println("Window is not disapear ");
				return false;
			} catch (Exception e) {

			}

			if (tostMsg.equalsIgnoreCase("New Folder created successfully")) {
				System.out.println("Folder created successfully ");
				return true;
			} else {
				System.out.println("Folder Not created ");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Folder Not created ");
			return false;
		}
	}

	public boolean createNewConfigurationStep1() throws InterruptedException {
		String randomText = RandomStringUtils.randomAlphabetic(3);
		driver.findElement(createNewConfigration).click();
		driver.findElement(selectDirectory).click();
		Thread.sleep(1000);
		driver.findElement(selectCreatedFolder).click();
		try {
			driver.findElement(enterColumnName).sendKeys("Product");
			Select select = new Select(driver.findElement(selectDataType));
			select.selectByVisibleText(" TEXT");
			driver.findElement(addColumn).click();
			Thread.sleep(2000);

			driver.findElement(enterColumnName).sendKeys("Campaign ID");
			select.selectByVisibleText(" TEXT");
			driver.findElement(addColumn).click();
			Thread.sleep(2000);

			driver.findElement(enterColumnName).sendKeys("Number of Batches");
			select.selectByVisibleText(" INTEGER");
			driver.findElement(addColumn).click();
			Thread.sleep(2000);

			driver.findElement(enterColumnName).sendKeys("Campaign Start Date");
			select.selectByVisibleText(" DATE");
			driver.findElement(addColumn).click();
			Thread.sleep(2000);

			driver.findElement(enterColumnName).sendKeys("Campaign End Date");
			select.selectByVisibleText(" DATE");
			driver.findElement(addColumn).click();
			Thread.sleep(5000);

			fileStructureNameValue = "automation_ConfigFile" + randomText;
			// ------------------------------------------------------------
			createdFileStructure = By.xpath("//strong[.='" + fileStructureNameValue + "']");
			// -------------------------------------------------------------
			driver.findElement(fileStructureName).sendKeys(fileStructureNameValue);
			driver.findElement(nextBtnUnderFileConfig).click();
			Thread.sleep(2000);
			System.out.println("Create new configuration step1 is completed ");
			return true;

		} catch (Exception e) {
			System.out.println("Unable to create a new configuration ");
			return false;
		}
	}

	public boolean createNewConfigurationStep2() throws InterruptedException {

		try {
			driver.findElement(addNewConstraint).click();
			driver.findElement(selectColumn).click();
			driver.findElement(selectColumn1).click();
			driver.findElement(selectConstraint).click();
			driver.findElement(isMandatoryConstraint).click();

			Thread.sleep(2000);

			driver.findElement(addNewConstraint).click();
			driver.findElement(selectColumn2op).click();
			driver.findElement(selectColumn2).click();
			driver.findElement(selectConstraintOp2).click();
			driver.findElement(isMandatoryConstraint2).click();

			Thread.sleep(2000);

			driver.findElement(addNewConstraint).click();
			driver.findElement(selectColumn3op).click();
			driver.findElement(selectColumn3).click();
			driver.findElement(selectConstraintOp3).click();
			driver.findElement(isMandatoryConstraint3).click();

			Thread.sleep(2000);

			driver.findElement(addNewConstraint).click();
			driver.findElement(selectColumn4op).click();
			driver.findElement(selectColumn4).click();
			driver.findElement(selectConstraintOp4).click();
			driver.findElement(isMandatoryConstraint4).click();

			Thread.sleep(2000);

			driver.findElement(addNewConstraint).click();
			driver.findElement(selectColumn5op).click();
			driver.findElement(selectColumn5).click();
			driver.findElement(selectConstraintOp5).click();
			driver.findElement(isMandatoryConstraint5).click();

			Thread.sleep(2000);
			driver.findElement(nextBtnUnderFileConfig).click();
			System.out.println("create new configuration step 2 completed ");
			Thread.sleep(4000);
			return true;
		} catch (Exception e) {
			System.out.println("Create new configuration step 2 failed ");
			return false;
		}
	}

	public boolean createNewConfigurationStep3() throws InterruptedException {
//		try {
		driver.findElement(selectDataCatalog).click();
		Thread.sleep(2000);
		driver.findElement(selectDataCatalogValue).click();
		Thread.sleep(7000);
		driver.findElement(nextBtnUnderFileConfig).click();
		System.out.println("create new configuration step 3 completed ");
		Thread.sleep(4000);
		return true;
//		} catch (Exception e) {
//			System.out.println("create new configuration step 3 failed ");
//			return false;
//		}
	}

	public boolean createNewConfigurationStep4() throws InterruptedException {
		try {
			driver.findElement(dataCatalogColumn1DD).click();
			Thread.sleep(1000);
			driver.findElement(dataCatalogColumn1Op).click();
			Thread.sleep(2000);
			driver.findElement(dataCatalogColumn2DD).click();
			Thread.sleep(1000);
			driver.findElement(dataCatalogColumn2Op).click();
			Thread.sleep(2000);
			driver.findElement(dataCatalogColumn3DD).click();
			Thread.sleep(1000);
			driver.findElement(dataCatalogColumn3Op).click();
			Thread.sleep(2000);
			driver.findElement(dataCatalogColumn4DD).click();
			Thread.sleep(1000);
			driver.findElement(dataCatalogColumn4Op).click();
			Thread.sleep(2000);
			driver.findElement(dataCatalogColumn5DD).click();
			Thread.sleep(1000);
			driver.findElement(dataCatalogColumn5Op).click();
			Thread.sleep(2000);
			driver.findElement(saveBtn).click();
			Thread.sleep(2000);
			System.out.println("create new configuration step 4 completed ");
			String tostMsg = driver.findElement(toasterMessage).getText();
			driver.findElement(closeButton).click();
			Thread.sleep(4000);
			if (tostMsg.equals("File Structure created successfully")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Create New configuration Step 4 is failed ");
			return false;
		}

	}

	public boolean uploadNewFile(String filePath) throws InterruptedException {
		File file = new File(filePath);
		driver.findElement(createdFolder).click();
		Thread.sleep(3000);
		driver.findElement(createdFileStructure).click();
		Thread.sleep(3000);
		driver.findElement(uploadNewFileBtn).click();
		Thread.sleep(2000);
		driver.findElement(uploadFileArea).sendKeys(file.getAbsolutePath());
		Thread.sleep(3000);
		driver.findElement(nextButtonToUploadFile).click();
		Thread.sleep(3000);
		driver.findElement(nextButtonToUploadFile).click();
		Thread.sleep(3000);
		driver.findElement(uploadFileBtn).click();
		Thread.sleep(1500);
		String tstrMsg = driver.findElement(toasterMessage).getText().replace(" ", "");
		Thread.sleep(1000);
		System.out.println("Toaster message is " + tstrMsg);
		if (tstrMsg.equalsIgnoreCase("FileUploadedsuccessfully")) {
			System.out.println("File Uploaded successfully");
			return true;
		} else {
			System.out.println("File Upload Failed ");
			return false;
		}
	}

	public boolean avlOfuploadedFile() throws InterruptedException {

		driver.findElement(homeBtn).click();
		Thread.sleep(3000);
		driver.findElement(createdFolder).click();
		Thread.sleep(3000);
		driver.findElement(createdFileStructure).click();
		Thread.sleep(3000);
		try {
			driver.findElement(uploadedFile).isDisplayed();
			System.out.println("File is Uploaded ");
			return true;
		} catch (Exception e) {
			System.out.println("File is not uploaded ");
			return false;
		}
	}

	public boolean functionalityOfViewButton() throws InterruptedException {
		driver.findElement(eyeIcon).click();
		Thread.sleep(4000);
		try {
			driver.findElement(dataUnderEyeIcon).isDisplayed();
			System.out.println("data is avaialable under view icon");
			return true;
		} catch (Exception e) {
			System.out.println("Data is not avaialable under view icon ");
			return false;
		}
	}

	public boolean funcionalityOfDownloadBtn() throws InterruptedException {
		String downloadPath = "C://Users//testuser//Downloads";
		driver.findElement(closeWindoOfView).click();
		Thread.sleep(3000);
		driver.findElement(downloadUploadedFile).click();
		Thread.sleep(4000);
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals("fileUploadTest.xlsx")) {

				return true;
			}
		}
		return false;
	}

	public boolean compareExcel() throws IOException {
		ArrayList excell1 = new ArrayList();
		ArrayList excell2 = new ArrayList();
		FileInputStream file = new FileInputStream("C://Users//testuser//Downloads//fileUploadTest.xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("campaign_data");
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.iterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				DataFormatter dataFormatter = new DataFormatter();
				String cellValue = dataFormatter.formatCellValue(cell);
				excell1.add(cellValue);
			}
		}

		workbook.close();
		file.close();

		System.out.println("---------------------------------------------------------------------------------------");

		FileInputStream file1 = new FileInputStream(Constants.campaignFileNew);
		Workbook workbook1 = new XSSFWorkbook(file1);
		Sheet sheet1 = workbook1.getSheet("campaign_data");
		Iterator<Row> rowIterator1 = sheet1.iterator();
		while (rowIterator1.hasNext()) {
			Row row = rowIterator1.next();
			Iterator<Cell> cellIterator = row.iterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				DataFormatter dataFormatter = new DataFormatter();
				String cellValue = dataFormatter.formatCellValue(cell);
				System.out.println(cellValue);
				excell2.add(cellValue);
			}
		}
		workbook1.close();
		file1.close();
		System.out.println("Downloaded Excel data ");
		System.out.println(excell1);
		System.out.println("Uploaded Excel data ");
		System.out.println(excell2);
		boolean b = excell1.equals(excell2);
		if (b == true) {
			System.out.println("Downloaded excel and uploaded excel data is matched ");
			return true;
		} else {
			System.out.println("Downloaded excel and uploaded excel data not matched ");
			return false;
		}
	}

	public boolean uploadedExcelWithViewBtn() throws InterruptedException, IOException {
		ArrayList excell2 = new ArrayList();

		driver.findElement(homeBtn).click();
		Thread.sleep(1000);
		driver.findElement(createdFolder).click();
		Thread.sleep(3000);
		driver.findElement(createdFileStructure).click();
		Thread.sleep(3000);
		driver.findElement(eyeIcon).click();
		Thread.sleep(4000);
		viewData = driver.findElements(dataAvlUnderEyeIcon);
		for (WebElement viewDatas : viewData) {
			storeDisplayedData.add(viewDatas.getText());
		}

		System.out.println("***********************Displayed data ***********************");
		System.out.println(storeDisplayedData);

		driver.findElement(closeWindoOfView).click();
		Thread.sleep(1000);
		driver.findElement(homeBtn).click();
		Thread.sleep(1000);

		FileInputStream file1 = new FileInputStream(Constants.campaignFileNew);
		Workbook workbook1 = new XSSFWorkbook(file1);
		Sheet sheet1 = workbook1.getSheet("campaign_data");
		Iterator<Row> rowIterator1 = sheet1.iterator();
		while (rowIterator1.hasNext()) {
			Row row = rowIterator1.next();
			Iterator<Cell> cellIterator = row.iterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				DataFormatter dataFormatter = new DataFormatter();
				String cellValue = dataFormatter.formatCellValue(cell);
				System.out.println(cellValue);
				excell2.add(cellValue);
			}
		}
		System.out.println("***************Uploaded Excel data******************");
		System.out.println(excell2);
		workbook1.close();
		file1.close();

		boolean b = storeDisplayedData.equals(excell2);
		System.out.println("compared value = " + b);
		if (b == true) {
			System.out.println("Displayed data and uploaded file data is matched ");
			return true;
		} else {
			System.out.println("Displayed data and uploaded file data is not matched ");
			return false;
		}
	}

	public void getFileDetailsFromFileUpload() throws InterruptedException {

		driver.findElement(campaignFolder).click();
		Thread.sleep(1000);
		driver.findElement(campaigFile).click();
		Thread.sleep(4000);
		List<WebElement> allUploadedFileEle = new ArrayList<WebElement>();
		allUploadedFileEle = driver.findElements(By.xpath("(//td/strong)"));

		Thread.sleep(4000);
		latestUploadedFileName = driver.findElement(latestUploadedFile).getText().replace(" ", "");
		System.out.println("Latest uploaded file is:");
		latestUploadedFileName = latestUploadedFileName + ".xlsx";
		System.out.println(latestUploadedFileName);
		System.out.println("All uploaded Files are :");
		for (int i = 1; i <= allUploadedFileEle.size(); i++) {
			allUploadedFileValue.add(driver.findElement(By.xpath("(//td/strong)[" + i + "]")).getText() + ".xlsx");
		}
		Thread.sleep(2000);
		Collections.sort(allUploadedFileValue);
		System.out.println(allUploadedFileValue);
		driver.findElement(homeBtn).click();
		Thread.sleep(1000);
		driver.findElement(homeIcon).click();
	}

	public boolean verifyLatestUploadedFileInPlannerTest() throws InterruptedException {
		String randomText = RandomStringUtils.randomAlphabetic(3);
		driver.findElement(createPlan).click();
		String planName = "Automation_Test_" + randomText;
		driver.findElement(planTitle).sendKeys(planName);
		driver.findElement(planDesc).sendKeys(planName);
		driver.findElement(planningcycle).click();
		driver.findElement(planningcycleval).click();
		Thread.sleep(2000);
		driver.findElement(baseLineDate).sendKeys("0101002024");
		Thread.sleep(2000);
		driver.findElement(scenarioDD).click();
		Thread.sleep(3000);
		driver.findElement(scenarioDDval).click();
		Thread.sleep(4000);
		driver.findElement(nextBtn).click();
		Thread.sleep(2000);
		driver.findElement(schedulingGrain).clear();
		driver.findElement(schedulingGrain).sendKeys("15");
		driver.findElement(employeeConstraint).click();
		driver.findElement(nextBtn).click();
		Thread.sleep(1000);
		driver.findElement(latestCampaignFile).click();
		Thread.sleep(4000);
		String latestcampaignName;
		try {
			latestcampaignName = driver.findElement(latestCampaignFileInPlanner).getText();
			latestcampaignName = latestcampaignName.replace(" ", "");

			System.out.println("Latest campaign file is displaying ");
		} catch (Exception e) {
			System.out.println("Latest campaign file is not displaying ");
			return false;
		}

		if (latestcampaignName.equals(latestUploadedFileName)) {
			System.out.println("Latest Uploaded file is displayed ");
			return true;
		} else {
			System.out.println("Latest Uploaded File is not displayed ");
			return false;
		}
	}

	public boolean verifyAllUploadedFilesInPlanner() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(closeIconOfCreatPlanWindow).click();
		Thread.sleep(1000);
		String randomText = RandomStringUtils.randomAlphabetic(3);
		driver.findElement(createPlan).click();
		String planName = "Automation_Test_" + randomText;
		Thread.sleep(3000);
		driver.findElement(planTitle).sendKeys(planName);
		driver.findElement(planDesc).sendKeys(planName);
		driver.findElement(planningcycle).click();
		driver.findElement(planningcycleval).click();
		Thread.sleep(2000);
		driver.findElement(baseLineDate).sendKeys("0101002024");
		Thread.sleep(2000);
		driver.findElement(scenarioDD).click();
		Thread.sleep(4000);
		driver.findElement(scenarioDDval).click();
		Thread.sleep(4000);
		driver.findElement(nextBtn).click();
		Thread.sleep(2000);
		driver.findElement(schedulingGrain).clear();
		driver.findElement(schedulingGrain).sendKeys("15");
		driver.findElement(employeeConstraint).click();
		driver.findElement(nextBtn).click();
		Thread.sleep(1000);
		try {
			driver.findElement(chooseCampaignDD).click();
			Thread.sleep(1000);
			List<WebElement> allUploadedFilePlannerEles = new ArrayList<WebElement>();
			allUploadedFilePlannerEles = driver.findElements(allUploadedFilesInPlannerEle);
			for (WebElement uploadedFileList : allUploadedFilePlannerEles) {
				allUploadedFileValueInPlanner.add(uploadedFileList.getText());
			}
			System.out.println("Available files in planner are ");
			System.out.println(allUploadedFileValueInPlanner);

		} catch (Exception e) {
			System.out.println("choose campaign drop down is disabled ");
			return false;
		}

		Collections.sort(allUploadedFileValueInPlanner);
		boolean b = allUploadedFileValue.equals(allUploadedFileValueInPlanner);
		if (b == true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanNavigateToGallaryViewTest() throws InterruptedException {
		navigateTo = new Navigation(driver);
		driver.navigate().refresh();
		Thread.sleep(4000);
		navigateTo.navigateToPlanner();
		driver.findElement(microPlanningList).click();
		Thread.sleep(2000);
		driver.findElement(fileUploadCard).click();
		Thread.sleep(5000);
		driver.findElement(galaryViewBtn).click();
		Thread.sleep(2000);
		try {
			driver.findElement(dataCard).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyDataAvlUnderListViewTest() throws InterruptedException {
		driver.findElement(listViewBtn).click();
		Thread.sleep(3000);
		try {
			driver.findElement(dataCardInListView).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserIsAbleToEditTheCreatedFolderTest() throws InterruptedException {
		String randomText = RandomStringUtils.randomAlphabetic(5);
		folderValue = "automation_folder" + randomText;
		driver.findElement(fileUploadTab).click();
		Thread.sleep(1500);

		driver.findElement(createNewFolder).click();
		Thread.sleep(2000);
		driver.findElement(folderName).sendKeys(folderValue);
		Thread.sleep(2000);
		driver.findElement(createFolderBtn).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);

		driver.findElement(searchBox).sendKeys(folderValue);

		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(threeDots)).build().perform();

		driver.findElement(editIcon).click();

		driver.findElement(folderName).clear();

		driver.findElement(folderName).sendKeys(folderValue + "update");

		Thread.sleep(1500);
		driver.findElement(createFolderBtn).click();
		String tstrMsg = "null";

		try {
			tstrMsg = driver.findElement(toasterMessage).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster messages while updating folder *" + tstrMsg);
		if (tstrMsg.equals("Folder updated successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToDeleteCreatedFolderTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(searchBox).sendKeys(folderValue + "update");
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(threeDots)).build().perform();
		Thread.sleep(2000);
		driver.findElement(deleteIcon).click();
		Thread.sleep(1500);
		String tstrMsg = "null";

		try {
			tstrMsg = driver.findElement(toasterMessage).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster messages while updating folder *" + tstrMsg);
		if (tstrMsg.equals("Folder deleted successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvailabilityOfCreatedFolderTest() throws InterruptedException {
		driver.findElement(searchBox).clear();
		Thread.sleep(500);
		driver.findElement(searchBox).sendKeys(folderValue + "update");
		Thread.sleep(2000);
		try {
			driver.findElement(createdFolderEle).isDisplayed();
			return false;

		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyUserCanUploadTheCampaignFileTest() throws InterruptedException {
		String path = "./src/test/resources/testdata/DummyData.xlsx";
		File file = new File(path);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(campaignFolder).click();
		Thread.sleep(1000);
		driver.findElement(campaigFile).click();
		Thread.sleep(4000);

		List<WebElement> allUploadedFileEle = new ArrayList<WebElement>();
		allUploadedFileEle = driver.findElements(By.xpath("(//td/strong)"));
		availableFileSize = allUploadedFileEle.size();
		System.out.println("Avaialble files before uploading new campaign " + availableFileSize);
		driver.findElement(uploadNewFileBtn).click();
		Thread.sleep(2000);
		driver.findElement(uploadFileArea).sendKeys(file.getAbsolutePath());
		Thread.sleep(3000);
		driver.findElement(nextButtonToUploadFile).click();
		Thread.sleep(3000);
		driver.findElement(nextButtonToUploadFile).click();
		Thread.sleep(3000);
		driver.findElement(uploadFileBtn).click();
		Thread.sleep(1500);
		String tstrMsg = driver.findElement(toasterMessage).getText().replace(" ", "");
		Thread.sleep(1000);
		System.out.println("Toaster message is " + tstrMsg);
		if (tstrMsg.equalsIgnoreCase("FileUploadedsuccessfully")) {
			System.out.println("File Uploaded successfully");
			return true;
		} else {
			System.out.println("File Upload Failed ");
			return false;
		}

	}

	public boolean verifyTheAvailabilityOfUploadedCampaignFileTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(campaignFolder).click();
		Thread.sleep(1000);
		driver.findElement(campaigFile).click();
		Thread.sleep(4000);
		List<WebElement> allUploadedFileEle = new ArrayList<WebElement>();
		allUploadedFileEle = driver.findElements(By.xpath("(//td/strong)"));
		int avaialableFileAfterUpload = allUploadedFileEle.size();
		System.out.println("Available files after uploading the campagin file " + avaialableFileAfterUpload);
		if (avaialableFileAfterUpload > availableFileSize) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanUploadTheCampaignFileByAddingApportstopeInFileTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);

		String path = "./src/test/resources/testdata/DummyDataWithComma.xlsx";
		File file = new File(path);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(campaignFolder).click();
		Thread.sleep(1000);
		driver.findElement(campaigFile).click();
		Thread.sleep(4000);

		List<WebElement> allUploadedFileEle = new ArrayList<WebElement>();
		allUploadedFileEle = driver.findElements(By.xpath("(//td/strong)"));
		availableFileSize = allUploadedFileEle.size();
		System.out.println("Avaialble files before uploading new campaign with comma " + availableFileSize);
		driver.findElement(uploadNewFileBtn).click();
		Thread.sleep(2000);
		driver.findElement(uploadFileArea).sendKeys(file.getAbsolutePath());
		Thread.sleep(3000);
		driver.findElement(nextButtonToUploadFile).click();
		Thread.sleep(3000);
		driver.findElement(nextButtonToUploadFile).click();
		Thread.sleep(3000);
		driver.findElement(uploadFileBtn).click();
		Thread.sleep(1500);
		String tstrMsg = driver.findElement(toasterMessage).getText().replace(" ", "");
		Thread.sleep(1000);
		System.out.println("Toaster message is " + tstrMsg);
		if (tstrMsg.equalsIgnoreCase("FileUploadedsuccessfully")) {
			System.out.println("File Uploaded successfully");
			return true;
		} else {
			System.out.println("File Upload Failed ");
			return false;
		}

	}

	public boolean verifyAvailabilityOfUploadTheCampaignFileByAddingApportstopeInFileTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(campaignFolder).click();
		Thread.sleep(1000);
		driver.findElement(campaigFile).click();
		Thread.sleep(4000);
		List<WebElement> allUploadedFileEle = new ArrayList<WebElement>();
		allUploadedFileEle = driver.findElements(By.xpath("(//td/strong)"));
		int avaialableFileAfterUpload = allUploadedFileEle.size();
		System.out.println("Available files after uploading the campagin file " + avaialableFileAfterUpload);
		if (avaialableFileAfterUpload > availableFileSize) {
			return true;
		} else {
			return false;
		}
	}

}
