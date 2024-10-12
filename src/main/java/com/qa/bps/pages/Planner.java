package com.qa.bps.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.ss.usermodel.*;

import com.qa.bps.utils.ElementUtil;

public class Planner {

	WebDriver driver;
	Navigation navigateTo;

	private By createPlan = By.xpath("//label[@title='Create New Plan']");
	private By planTitle = By.xpath("//input[@id='planTitle']");
	private By planDesc = By.xpath("//input[@id='planDescription']");
	private By planningcycle = By.xpath("//div[contains(text(),'Planning Cycle')]");
	private By planningcycleval = By.xpath("(//a[contains(text(),'Mid Term Plan')])[2]");
	private By baseLineDate = By.xpath("(//input[@id='baseLineDate'])");
	private By title = By.xpath("//p[contains(text(),'Plan Details')]");
	private By scenarioDD = By.xpath("//div[contains(text(),'Choose Scenario')]");
	private By scenarioDDval = By.xpath("//a[contains(text(),' Custom ')]");
	String pageTitle;
	private By nextBtn = By.xpath("//button[.='Next']");
	private By doneBtn = By.xpath("//button[contains(text(),'Done')]");
	private By campaigntgt = By.xpath("(//span[@class='checkmark'])[20]");
	private By schedulingGrain = By.xpath("//input[@placeholder='in Mins']");
	private By employeeConstraint = By.xpath("(//span[@class='checkmark'])[3]");
	private By latestCampaignFile = By.xpath("(//input[@type='checkbox'])[2]");
	private By campaignTargetCheckBox = By.xpath("(//span[@class='checkmark'])[last()]");
	String planMsg;

	private By pMsg = By.xpath("//label[@class='label-default']");
	private By fixed = By.xpath("//app-dropdown[@class='dropdownForAll']");
	private By valueSelection = By
			.xpath("//app-dropdown[@class='dropdownForAll']//a[contains(text(),' Fixed number of batches ')]");
	String randomStr;
	String planname;
	String pstatus;
	private By searchPlan = By.xpath("//input[@id='search']");
	private By grain = By.xpath("(//input[contains(@class,'form-control inputBox')])[2]");
	private By planStatus = By.xpath("//div[contains(@class,'plansArchive-card')]//label[text()='DRAFT']");
	private By savedVersioBtn = By.xpath("//button[@class='btn planArchive-btn']/a[text()='Saved Version']");
	private By draftPlanArrowBtn = By.xpath("(//fa[@name='fas fa-arrow-right'])[2]");
	private By arrowIcon = By.xpath("//button[@class='btn btn-warning planButton']");
	private By planArchiveSection = By.xpath("//div[@class='plansArchive-card']");
	private By savedVersionBtn = By.xpath("(//a[contains(text(),'Saved Version')])[1]");

	private By manageScenario = By.xpath("//div[@class=\'whiteContainer allowBtn\'][2]");
	private By manageScenarioPopup = By.xpath("//h5[@id=\'exampleModalLongTitle\']");
	private By versionlabel = By.xpath("(//label[@for='version'])");
	private By checkBoxMaxOperatorSkill = By.xpath("(//span[@class='checkmark'])[17]");
	private By checkBoxEmpConstraint = By.xpath("(//span[@class='checkmark'])[3]");
	private By checkBoxruleset = By.xpath("(//span[@class='checkmark'])[18]");
	private By checkBoxProductPriority = By.xpath("(//span[@class='checkmark'])[19]");

	boolean manageScenarioPopupAvailable;

	private By campaignTargetData = By.xpath("//table[@class='table align-center']");

	boolean updateButtonAvailable;

	private ElementUtil eleUtil;

//-----------------------Update Xpath ----------------------------------
	private By fileUploadTab = By.xpath("//a[@id='v-pills-file-uploads']");
	private By newFileUploadButton = By.xpath("//button[.='Upload New File']");
	private By choseDirectoryDD = By.xpath("//select[@formcontrolname='Directory']");
	private By choseFileStructureDD = By.xpath("//select[@formcontrolname='FileStructure']");
	private By selectFilePath = By.xpath("//input[@id='fileDropRef']");
	private By menuIcon = By.xpath("//div[@class='dropdown dropdown-large buttons']");
	private By navigateBodhee = By.xpath("//img[@src='./assets/png/DeveloperStudio.png']");
	private By dataManagementTab = By.xpath("(//button[.='Configure'])[3]");
	private By nextButton = By.xpath("(//button[.=' Next '])[1]");
	private By uploadFile = By.xpath("//button[.='Upload File']");
	private By toasterMessage = By.xpath("//div[@role='alertdialog']");
	private By navigateInDir = By.xpath("//span[.='Ujpest']");
	private By navigateInFS = By.xpath("(//span[.='Campaign Data'])[1]");
	private By navigateUploadFile = By.xpath("(//div[@class='col pt-1'])[1]");
	private By campagnDate = By.xpath("(//td[@class='ng-star-inserted'])[9]");
	String baseLineDates;
	private By closeButton = By.xpath("(//button[@class='close'])[5]");
	private By bodheeLogo = By.xpath("(//img[@src='./assets/png/bodhee_logo_new.png'])[2]");
	private By trigerPlan = By.xpath("//button[.='Trigger Plan']");
	private By searchNewPlan = By.xpath("//input[@id='search']");
	private By savedVersionBtns = By.xpath("//a[.='Saved Version']");
	private By newPlanStatus = By.xpath("(//label[.='DRAFT'])[1]");
	private By navigatePlan = By.xpath("//button[@class='btn btn-warning planButton']");
	private By publishPlanBtn = By.xpath("//a[.='Publish']");
	private By summaryCard = By.xpath("(//div[@class='bodhee-kpi-card-success'])[3]");
	private By campaignCard = By.xpath("//div[@class='header']");
	private By campaignTab = By.xpath("//div[contains(text(),'CAMPAIGN ')]");
	private By constraintCard = By.xpath("(//div[@class='download-card-main'])[1]");
	private By constraintTab = By.xpath("(//div[.='CONSTRAINT '])[1]");
	private By productionTab = By.xpath("(//div[.='PRODUCTION '])[2]");
	private By productionCard = By.xpath("//div[@class='gantt_cell gantt_cell_tree']");
	private By equipmentTab = By.xpath("(//div[.='Equipment '])[2]");
	private By equipmentCard = By.xpath("//div[@class='dhx_timeline_label_column']");
	private By WipInvCard = By.xpath("//div[@class='fm-ui-element fm-filters fm-rows-filter']");
	private By WipInvTab = By.xpath("(//div[.='WIP INV '])[2]");
	private By stockTab = By.xpath("(//div[.='STOCK '])[2]");
	private By stockCard = By.xpath("//div[@class='fm-ui-element fm-filters fm-rows-filter']");
	private By operatorTab = By.xpath("(//div[.='OPERATOR '])[2]");
	private By operatorCard = By.xpath("(//div[.='Operator'])[1]");
	private By productionLineTab = By.xpath("(//div[.='Production line '])[2]");
	private By productionLineCard = By.xpath("(//div[.='Equipment'])[2]");
	private By comparisonTab = By.xpath("(//div[.='COMPARISON '])[2]");
	private By comparisonCard = By.xpath("//div[@class='title-row']");
	private By comparisonCardInNativeLang = By.xpath("//div[@class='value-row']");
	private By processOrderTab = By.xpath("//div[contains(text(),'PROCESS-ORDERS ')]");
	private By processOrderData = By.xpath("//div[@class='tabulator']");
	private By failedConstraintsIcon = By.xpath("//a[@title='Failed Constraints']");
	private By logEventsIcon = By.xpath("//a[@title='Log Events']/*");
	private By selectEquipmentDD = By.xpath("(//div[@class='selected-list'])[6]");
	private By fullScreenIcon = By.xpath("//a[@title='Full screen view']");
	private By chooseCategoryDD = By.xpath("//div[.=' Choose Category ']");
	private By empUnavilable = By.xpath("//a[.=' Employee Unavailable ']");
	private By selectResourceDD = By.xpath("//div[.=' Select Resource ']");
	private By employee = By
			.xpath("(//a[contains(@class,'dropdown-item d-flex justify-content-between ng-star-inserted')])[5]");
	private By startDate = By.xpath("//input[@id='startDate']");
	private By endDate = By.xpath("//input[@id='endDate']");
	private By userDD = By.xpath("//p[@id='navbarDropdown']");
	private By languageDD = By.xpath("(//a[@class='dropdown-item'])[5]");
	private By nativeLanguage = By.xpath("(//div[@id='custom-lang']/ul/li)[2]");
	private By engLang = By.xpath("//a[.='English (en)']");
	private By expandAllBtn = By.xpath("//a[.='Expand All ']");
	private By firstBatch = By.xpath("(//div[@class='gantt_task_content'])[2]");
	private By cmtBox = By.xpath("//label[.='Comments*']/following-sibling::input");
	private By saveBtn = By.xpath("//button[.='Save']");
	private By toaterMsg = By.xpath("//div[@role='alertdialog']");
	private By saveAsBtn = By.xpath("(//div[.='Save as'])[2]");
	private By saveCmtBox = By.xpath("//div[@class='align input-group']/input");
	private By saveChangesBtn = By.xpath("//a[.='Save change']");
	private By versionIcon = By.xpath("//div[@class='label-small']/label");
	private By newDraftedPlan = By.xpath("(//div[@class='align-items-center pointer'])[1]/fa");
	private By batchDelaySummary = By.xpath("(//div[.='Batch Delay Summary '])[2]");
	private By batchDelaySummaryTab = By.xpath("//span[.='Delay Time Added']/parent::div/parent::div");
	private By closeBtnForWindow = By.xpath("//div[@class='close-button']");
	private By overviewTabEleInNative = By.xpath("(//div[@class='d-flex marginclass'])[1]");
	private By languageDotEle = By.xpath("//*[contains(text(),'language.')]");
	private By kpiValues = By.xpath("//div[@class='left-side-content']/div/div/div/div");
	private By latestVersion = By.xpath("(//div[@class='align-items-center'])[2]/label");
	private By closeVersionHistoryWindow = By.xpath("//fa[@name='fas fa-times']");
	private By displayedVersion = By.xpath("(//label[@class='label-small'])[1]");
	private By summaryTab = By.xpath("(//div[.='Summary '])[2]");
	private By updateBtn = By.xpath("//button[.='Update']");
	private By productname = By.xpath("(//div[@class='gantt_tree_content'])[1]");
	private By batchName = By.xpath("(//div[@class='gantt_tree_content'])[9]");
	private By taskGroup = By.xpath("(//div[@class='gantt_tree_content'])[17]");
	private By firstTaskName = By.xpath("(//div[@class='gantt_cell gantt_cell_tree'])[4]/div[6]");
	private By firstTaskFte = By.xpath("(//div[@data-column-name='fte'])[4]/div");
	private By completionHrs = By.xpath("(//div[@data-column-index='6'])[5]");
	private By productNameInTaskInfoEle = By.xpath("//p[.='Campaign No.']/following-sibling::span");
	private By batchNameInTaskInfoEle = By.xpath("//p[.='Batch No.']/following-sibling::span");
	private By taskGroupNameInTaskInfoEle = By.xpath("//p[.='Task Group']/following-sibling::span");
	private By taskNameInTaskInfoEle = By.xpath("//p[.='Task']/following-sibling::span");
	private By completionHrsInTaskInfoEle = By.xpath("(//p[.='Completion Hrs']/following-sibling::span)[1]");
	private By FteInTaskInfoEle = By.xpath("//span[.='FTE']/following-sibling::span");
	private By popUpClose = By.xpath("(//div[contains(@class,'popup')]/div/div/div)[2]");
	private By lastRowTaskInEqTab = By.xpath("(//div[contains(@class,'dhx_cal_event_line')])[last()]");
	private By equipmentTollTip = By.xpath("//div[@role='tooltip']");
	private By addBtn = By.xpath("(//div[.='Add '])[1]");
	private By addEvent = By.xpath("//button[.='Add']");
	private By chooseCatg = By.xpath("//div[.=' Choose Category ']");
	private By eqUnAvl = By.xpath("//a[.=' Equipment Unavailable ']");
	private By selectResource = By.xpath("//div[.=' Select Resource ']");
	private By eqSearchBox = By.xpath("(//input[@placeholder='Search'])[last()]");
	private By eqUnAvlAlert = By.xpath("//div[contains(text(),' Equipment Unavailable:')]");
	private By equipmentDDSearchBox = By.xpath("(//input[@placeholder='Search'])[7]");
	private By eqUnAvlSection = By.xpath("//div[@aria-label='Equipment Unavailability']");
	private By eqUnAvlTollTip = By.xpath("//div[@role='tooltip']");
	private By deleteIconForEqUnAvl = By
			.xpath("(//div[contains(text(),' Equipment Unavailable:')]/following-sibling::div/*)[2]");
	private By processOrderDwdBtn = By.xpath("//img[@class='screen-toggle-icon download']");
	private By gantScaleLineAfterZoom = By.xpath("(//div[@class='gantt_scale_line'])[3]/div");
	private By dependienciesTab = By.xpath("(//div[.='Dependencies '])[1]");
	private By zoomInBtn = By.xpath("(//a[.='Zoom In '])[last()]");
	private By zoomOutBtn = By.xpath("(//a[.='Zoom Out '])[last()]");
	private By filterBtn = By.xpath("//button[.='Filters ']");
	private By applyFilterBtn = By.xpath("//button[.='Apply Filter']");
	private By selectTaskDropDown = By.xpath("//ng-select[@placeholder='Select Task']");
	private By firstTaskStartTime = By.xpath("(//div[@data-column-name='start_date']/div)[4]");
	private By firstTaskEndTime = By.xpath("(//div[@data-column-name='end_date']/div)[4]");
	private By selectFirstBatch = By.xpath("(//div[@role='option'])[1]");
	private By selectTaskInputBox = By.xpath("//div[@class='ng-input']/input");
	private By buildingDropDown = By.xpath("//span[.='Select Building']");
	private By selectAllCheckBox = By.xpath("//label[@for='kptjgc2tiw']");
	private By availableEquipmentList = By.xpath("//div[@class='dhx_timeline_label_column']");
	private By reschedulingComparisonTab = By.xpath("//a[.='Rescheduling Comparision']");
	private By enRComparisonCheckBox = By.xpath("//a[.='ENR Comparison']");
	private By selectPlanDropDownButton = By.xpath("//button[@data-toggle='dropdown']");
	private By comparinsgVersionEle = By.xpath("(//div[@x-placement='bottom-start']/a)[2]");
	private By publishedPlanNameEle = By.xpath("//li[contains(@class,'bold')]");
	private By publishedPlanVersionEle = By.xpath("//label[@for='version']");
	private By displayedPublishPlan = By.xpath("(//div[@class='tabulator-col-title'])[6]");
	private By displayedCompringPlan = By.xpath("(//div[@class='tabulator-col-title'])[10]");

	public String tstmsg;

//-------------------------------------------------------------------------------------------
	public Planner(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		navigateTo = new Navigation(driver);
	}

	public String fillPlanDetails() throws InterruptedException, AWTException {

		driver.findElement(createPlan).click();
		randomStr = RandomStringUtils.randomNumeric(5);
		planname = "Automation_Test_" + randomStr;
		System.out.println("New plan name is " + planname);
		driver.findElement(planTitle).sendKeys(planname);
		driver.findElement(planDesc).sendKeys("Sample desc");
		Thread.sleep(2000);
		driver.findElement(planningcycle).click();
		Thread.sleep(2000);
		driver.findElement(planningcycleval).click();

		driver.findElement(baseLineDate).sendKeys("03/07/2023");
		// pageTitle = driver.findElement(title).getText();
		driver.findElement(scenarioDD).click();
		driver.findElement(scenarioDDval).click();
		driver.findElement(nextBtn).click();
		driver.findElement(checkBoxEmpConstraint).click();
		driver.findElement(By.xpath("//div[@class='slider-data']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector(\"div[class$='constraint-div']\").scrollTop=1200");
		Thread.sleep(2000);
		// driver.findElement(grain).click();
		// driver.findElement(grain).sendKeys("15");
		// driver.findElement(grain).sendKeys(Keys.TAB);
		System.out.println("entered data in grain");
		driver.findElement(checkBoxMaxOperatorSkill).click();
		driver.findElement(checkBoxMaxOperatorSkill).click();
		driver.findElement(checkBoxProductPriority).click();
		driver.findElement(checkBoxProductPriority).click();
		driver.findElement(checkBoxruleset).click();
		driver.findElement(checkBoxruleset).click();
		driver.findElement(campaigntgt).click();
		driver.findElement(nextBtn).click();
		Thread.sleep(4000);
		eleUtil.doZoomOut();
		eleUtil.doZoomOut();
		eleUtil.doZoomOut();
		Thread.sleep(4000);
		driver.findElement(fixed).click();
		driver.findElement(valueSelection).click();
		driver.findElement(nextBtn).click();
		planMsg = driver.findElement(pMsg).getText();
		driver.findElement(doneBtn).click();
		return planMsg;
	}

	public boolean checkPlanStaus() throws InterruptedException

	{

		Thread.sleep(120000);

		WebElement search = driver.findElement(searchPlan);
		search.sendKeys(planname);
		driver.findElement(savedVersioBtn).click();
		Thread.sleep(2000);
		pstatus = driver.findElement(planStatus).getText();
		if (pstatus.equalsIgnoreCase("DRAFT")) {

			return true;
		} else
			return false;

	}

	public PlanDetails navigateToPlanDetails()

	{

		driver.findElement(arrowIcon).click();
		return new PlanDetails(driver);
	}

	public boolean isplanArchiveDisplayed() {

		boolean b = driver.findElement(planArchiveSection).isDisplayed();
		return b;
	}

	public PlanDetails navigateToDraftPlan() {

		driver.findElement(savedVersionBtn).click();
		driver.findElement(draftPlanArrowBtn).click();
		return new PlanDetails(driver);
	}

//----------------------------------------New Test Case Start From Here ------------------------------------------------

	public boolean fileUpload(String filePath) throws InterruptedException {
		File file = new File(filePath);
//		driver.findElement(selectFile).sendKeys(file.getAbsolutePath());
		driver.findElement(menuIcon).click();
		driver.findElement(navigateBodhee).click();
		Thread.sleep(4000);
		driver.findElement(dataManagementTab).click();
		Thread.sleep(2000);
		driver.findElement(fileUploadTab).click();
		System.out.println("navigate to file upload ");
		Thread.sleep(2000);
		driver.findElement(newFileUploadButton).click();
		Thread.sleep(4000);
		System.out.println("clicked on file upload button ");
		Select select = new Select(driver.findElement(choseDirectoryDD));
		select.selectByVisibleText("Ujpest");
		System.out.println("director selected ");
		Select select1 = new Select(driver.findElement(choseFileStructureDD));
		select1.selectByVisibleText("Campaign Data");
		System.out.println("Campaign Data selected ");
		driver.findElement(selectFilePath).sendKeys(file.getAbsolutePath());
		Thread.sleep(3000);
		driver.findElement(nextButton).click();
		Thread.sleep(2000);
		driver.findElement(nextButton).click();
		Thread.sleep(2000);
		driver.findElement(uploadFile).click();
		Thread.sleep(3000);
		boolean b = driver.findElement(toasterMessage).isDisplayed();
		System.out.println(driver.findElement(toasterMessage).getText());
		driver.findElement(navigateInDir).click();
		driver.findElement(navigateInFS).click();
		driver.findElement(navigateUploadFile).click();
		Thread.sleep(2000);
		String demoDate = driver.findElement(campagnDate).getText().replace("-", " ");
		System.out.println("converted date is : " + demoDate);
		String arr1[] = demoDate.split(" ");
		int a = Integer.parseInt(arr1[0]);
		a = a - 1;
		baseLineDates = arr1[1] + a + "" + arr1[2];
		System.out.println("Base line date : " + baseLineDates);
		driver.findElement(closeButton).click();
		System.out.println("pop-up is closed");
		driver.findElement(bodheeLogo).click();
		Thread.sleep(3000);
		return b;
	}

	public boolean createPlan() throws InterruptedException {
		String randomText = RandomStringUtils.randomAlphabetic(3);
		driver.findElement(createPlan).click();
		String planName = "Automation_Test_" + randomText;
		driver.findElement(planTitle).sendKeys(planName);
		driver.findElement(planDesc).sendKeys(planName);
		driver.findElement(planningcycle).click();
		driver.findElement(planningcycleval).click();
		Thread.sleep(2000);
		driver.findElement(baseLineDate).sendKeys(baseLineDates);
		Thread.sleep(2000);
		driver.findElement(scenarioDD).click();
		driver.findElement(scenarioDDval).click();
		driver.findElement(nextBtn).click();
		Thread.sleep(2000);
		driver.findElement(schedulingGrain).clear();
		driver.findElement(schedulingGrain).sendKeys("15");
		driver.findElement(employeeConstraint).click();
		driver.findElement(nextBtn).click();
		Thread.sleep(1000);
		driver.findElement(latestCampaignFile).click();
		driver.findElement(nextBtn).click();
		Thread.sleep(1000);
		driver.findElement(trigerPlan).click();
		Thread.sleep(1000);
		driver.findElement(doneBtn).click();
		Thread.sleep(2000);
		driver.findElement(searchNewPlan).sendKeys(planName);
		Thread.sleep(300000);
		driver.findElement(savedVersionBtns).click();
		Thread.sleep(2000);
		String versionStatus = driver.findElement(newPlanStatus).getText();
		System.out.println(versionStatus);
		if (versionStatus.equalsIgnoreCase("DRAFT")) {
			return true;
		} else {
			return false;
		}

	}

	public void publishPlan() throws InterruptedException {
		driver.findElement(navigatePlan).click();
		Thread.sleep(2000);
		driver.findElement(publishPlanBtn).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}

	public boolean dataAvlUnderOverviewTab() throws InterruptedException {
		navigateTo = new Navigation(driver);
		System.out.println("test case 3 started ");
//		driver.findElement(savedVersionBtns).click();
//		Thread.sleep(2000);
		driver.findElement(navigatePlan).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {

			driver.findElement(summaryCard).isDisplayed();
			System.out.println("data is displayed under summary tab");
			return true;

		} catch (Exception e) {
			System.out.println("data is not avaialable under summary tab");
			return false;

		}

	}

	public boolean dataAvlUnderCampaignTab() throws InterruptedException {
		boolean b = true;
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		try {
			driver.findElement(campaignTab).isDisplayed();
			driver.findElement(campaignTab).click();
			driver.findElement(campaignCard).isDisplayed();
			System.out.println("Campaign Tab displayed");
			b = true;
		}

		catch (Exception e) {
			driver.findElement(processOrderTab).isDisplayed();
			driver.findElement(processOrderTab).click();
			driver.findElement(processOrderData).isDisplayed();
			System.out.println("Process order is displayed");
			b = true;

		}
		return b;

	}

	public boolean dataAvlUnderConstraintTab() throws InterruptedException {

		driver.findElement(constraintTab).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			driver.findElement(constraintCard).isDisplayed();
			System.out.println("data is avaialble under constraint tab");
			return true;
		} catch (Exception e) {
			System.out.println("data is not avaialable under constraint tab");
			return false;
		}

	}

	public boolean dataAvlUnderProductionTab() throws InterruptedException {
		driver.findElement(productionTab).click();
		// Thread.sleep(5000);
		Thread.sleep(1000);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		try {
			driver.findElement(productionCard).isDisplayed();
			System.out.println("data is avaialble under production tab");
			return true;
		} catch (Exception e) {
			System.out.println("data is not avaialble under production tab");
			return false;
		}

	}

	public boolean dataAvlUnderEquipmentTab() throws InterruptedException {

		driver.findElement(equipmentTab).click();
		Thread.sleep(17000);

		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(equipmentCard).isDisplayed();
			System.out.println("Data is avaialble under equipment tab");
			return true;

		} catch (Exception e) {
			System.out.println("data is not available under equipment tab");
			return false;
		}

	}

	public boolean dataAvlUnderWIPINVTab() throws InterruptedException {
		driver.findElement(WipInvTab).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			driver.findElement(WipInvCard).isDisplayed();
			System.out.println("Data is avaialble under WIPINV tab");
			return true;
		} catch (Exception e) {
			System.out.println("Data is not avaialble under WIPINV tab");
			return false;
		}
	}

	public boolean dataAvlUnderStockTab() throws InterruptedException {

		driver.findElement(stockTab).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			driver.findElement(stockCard).isDisplayed();
			System.out.println("data is available under stock tab");
			return true;
		} catch (Exception e) {

			System.out.println("data is not avaialble under stock tab");
			return false;

		}

	}

	public boolean dataAvlUnderOperatorTab() throws InterruptedException {

		driver.findElement(operatorTab).click();
		Thread.sleep(6000);
		try {
			driver.findElement(operatorCard).isDisplayed();
			System.out.println("Data is avaialablu under operator tab ");
			return true;
		} catch (Exception e) {
			System.out.println("data is not avaialable under operator tab");
			return false;
		}

	}

	public boolean dataAvlUnderProductionLineTab() throws InterruptedException {

		driver.findElement(productionLineTab).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {

			driver.findElement(productionLineCard).isDisplayed();
			System.out.println("Data is avaialable under production line tab ");
			return true;

		} catch (Exception e) {
			System.out.println("Data is not avaialble under production line tab ");
			return false;
		}

	}

	public boolean dataAvlUnderComparisonTab() throws InterruptedException {

		driver.findElement(comparisonTab).click();
		Thread.sleep(7000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			driver.findElement(comparisonCard).isDisplayed();
			System.out.println("data is avaialable under comparison tab ");
			return true;
		} catch (Exception e) {
			System.out.println("data is not avaialable under comparison tab");
			return false;
		}

	}

	public String failedConstraintsIconToolTip() {

		return eleUtil.getToolTip(failedConstraintsIcon, "title");
	}

	public boolean logEventsIconToolTip() {

		try {
			driver.findElement(logEventsIcon).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String fullScreenIconToolTip() {
		return eleUtil.getToolTip(fullScreenIcon, "title");
	}

	public boolean verifyDataAvlUnderVersionCopmTabAfterLanguageChangeTest() throws InterruptedException {
		driver.findElement(userDD).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(languageDD)).perform();
		Thread.sleep(4000);
		driver.findElement(nativeLanguage).click();
		Thread.sleep(7000);
		try {
			driver.findElement(comparisonCardInNativeLang).isDisplayed();
			System.out.println("data is avaialable under comparison tab ");
			return true;
		} catch (Exception e) {
			System.out.println("data is not avaialable under comparison tab");
			return false;
		}

	}

	public boolean languageDotIssueInNativeLanguage() throws InterruptedException {
		driver.findElement(overviewTabEleInNative).click();
		Thread.sleep(4000);
		try {
			driver.findElement(languageDotEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyFunctOfDragAndDropInProdTabTest() throws InterruptedException {
		driver.findElement(userDD).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(languageDD)).perform();
		Thread.sleep(4000);
		driver.findElement(engLang).click();
		Thread.sleep(7000);
		driver.findElement(productionTab).click();
		Thread.sleep(7000);
		driver.findElement(expandAllBtn).click();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.clickAndHold(driver.findElement(firstBatch)).pause(Duration.ofSeconds(3)).moveByOffset(130, 0).release()
				.build().perform();
		Thread.sleep(3000);
		driver.findElement(cmtBox).sendKeys("TestDragAndDrop");
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(5000);
		String toasterMsgvalue = "null";
		try {
			toasterMsgvalue = driver.findElement(toaterMsg).getText();
			System.out.println(toasterMsgvalue);
		} catch (Exception e) {
			return false;
		}
		Thread.sleep(5000);
		if (toasterMsgvalue.equals("Validation Completed")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyFuncOfSaveAsBtnTest() throws InterruptedException {
		driver.findElement(saveAsBtn).click();
		driver.findElement(saveCmtBox).sendKeys("Test Save As Btn");
		driver.findElement(saveChangesBtn).click();
		Thread.sleep(8000);
		driver.findElement(versionIcon).click();
		Thread.sleep(1000);
		driver.findElement(newDraftedPlan).click();
		Thread.sleep(5000);
		driver.findElement(logEventsIcon).click();
		Thread.sleep(1000);

		try {
			driver.findElement(batchDelaySummary).click();
			Thread.sleep(1000);
			driver.findElement(batchDelaySummaryTab).isDisplayed();
			System.out.println("Data is available ");
			driver.findElement(closeBtnForWindow).click();
			return false;
		} catch (Exception e) {
			driver.findElement(closeBtnForWindow).click();
			return true;
		}

	}

	public boolean verifyKpiValuesPostSaveAsTest() throws InterruptedException {
		navigateTo.LattestPublishedPlan();
		Thread.sleep(4000);
		List<WebElement> kpiValuesInBasePlan = driver.findElements(kpiValues);
		List<String> kpiValuesBP = new ArrayList<String>();
		System.out.println("Size of the kpi values " + kpiValuesInBasePlan.size());
		for (WebElement kpiValuesInBasePlanEle : kpiValuesInBasePlan) {
			kpiValuesBP.add(kpiValuesInBasePlanEle.getText());
		}
		System.out.println("Kpi Values in Base Plane are " + kpiValuesBP);
		driver.findElement(versionIcon).click();
		Thread.sleep(1000);
		driver.findElement(newDraftedPlan).click();
		Thread.sleep(5000);
		List<WebElement> kpiValuesInDraftPlan = driver.findElements(kpiValues);
		List<String> kpiValuesDP = new ArrayList<String>();
		System.out.println("Size of the kpi values " + kpiValuesInDraftPlan.size());
		for (WebElement kpiValuesInBasePlanEle : kpiValuesInDraftPlan) {
			kpiValuesDP.add(kpiValuesInBasePlanEle.getText());
		}
		System.out.println("KPI values in Drafted plann are " + kpiValuesDP);
		if (kpiValuesBP.equals(kpiValuesDP)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUiRedirectionAfterSaveAsTest() throws InterruptedException {
		navigateTo.LattestPublishedPlan();
		driver.findElement(saveAsBtn).click();
		driver.findElement(saveCmtBox).sendKeys("Test Save As Btn");
		driver.findElement(saveChangesBtn).click();
		Thread.sleep(20000);
		driver.findElement(versionIcon).click();
		Thread.sleep(5000);
		String latestVersionvalue = driver.findElement(latestVersion).getText().replace(" ", "");
		driver.findElement(closeVersionHistoryWindow).click();
		String displayedVersionValue = driver.findElement(displayedVersion).getAttribute("title").replace(" ", "");
		System.out.println("Latest version value" + latestVersionvalue);
		System.out.println("Latest displayed version value" + displayedVersionValue);
		if (latestVersionvalue.equals(displayedVersionValue)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyDataAvlUnderProductOrCampaignPriorityTabTest() throws InterruptedException {
		navigateTo.navigateToPlanner();
		String randomText = RandomStringUtils.randomAlphabetic(3);
		driver.findElement(createPlan).click();
		String planName = "Automation_Test_" + randomText;
		driver.findElement(planTitle).sendKeys(planName);
		driver.findElement(planDesc).sendKeys(planName);
		driver.findElement(planningcycle).click();
		driver.findElement(planningcycleval).click();
		Thread.sleep(2000);
		driver.findElement(baseLineDate).sendKeys("04230020240335P");
		Thread.sleep(2000);
		driver.findElement(scenarioDD).click();
		driver.findElement(scenarioDDval).click();
		driver.findElement(nextBtn).click();
		Thread.sleep(2000);
		driver.findElement(schedulingGrain).clear();
		driver.findElement(schedulingGrain).sendKeys("15");
		driver.findElement(employeeConstraint).click();
		Thread.sleep(1000);
		driver.findElement(campaignTargetCheckBox).click();
		Thread.sleep(3000);
		driver.findElement(nextBtn).click();
		Thread.sleep(1000);
		try {
			driver.findElement(campaignTargetData).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUpdateBtnAvlUnderLogEventBtnTest() throws InterruptedException {
		navigateTo.LattestPublishedPlan();
		Thread.sleep(2000);
		driver.findElement(logEventsIcon).click();
		Thread.sleep(1000);
		driver.findElement(summaryTab).click();
		Thread.sleep(1000);
		try {
			driver.findElement(updateBtn).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyTaskDetailsInTaskInfoWindowTest() throws InterruptedException {
		navigateTo.LattestPublishedPlan();
		navigateTo.GetProductDetailsFromPlanner();
		navigateTo.findFirstTaskFromPlanner();
		Thread.sleep(3000);
		String productNameInPlanner = driver.findElement(productname).getText();
		System.out.println("Product Name in production tab " + productNameInPlanner);
		String BatchNameInPlanner = driver.findElement(batchName).getText();
		System.out.println("Batch name in production tab " + BatchNameInPlanner);
		String taskGroupNameInPlanner = driver.findElement(taskGroup).getText();
		System.out.println("Task group name in production tab " + taskGroupNameInPlanner);
		String firstTaskNameInPlanner = driver.findElement(firstTaskName).getText();
		System.out.println("first task name in planner " + firstTaskNameInPlanner);
		String firstTaskFteInPlanner = driver.findElement(firstTaskFte).getText();
		System.out.println("First Task Fte in planner " + firstTaskFteInPlanner);
		String completionHrsInPlanner = driver.findElement(completionHrs).getText();
		System.out.println("Task completion hrs  in planner " + completionHrsInPlanner);
		Actions actions = new Actions(driver);
		actions.doubleClick(driver.findElement(firstTaskName)).perform();
		Thread.sleep(4000);
		String productNameInTaskInfoTab = driver.findElement(productNameInTaskInfoEle).getText();
		System.out.println("product name in task info tab " + productNameInTaskInfoTab);
		String batchnameInTaskInfoTab = driver.findElement(batchNameInTaskInfoEle).getText();
		System.out.println("Batch Name in task info tab is " + batchnameInTaskInfoTab);
		String taskGroupNameInTaskInfoTab = driver.findElement(taskGroupNameInTaskInfoEle).getText();
		System.out.println("Task group name in task info tab is " + taskGroupNameInTaskInfoTab);
		String taskNameInTaskInfoTab = driver.findElement(taskNameInTaskInfoEle).getText();
		System.out.println("Task Name in task info tab " + taskNameInTaskInfoTab);
		String completionHrsInTaskInfoTab = driver.findElement(completionHrsInTaskInfoEle).getText();
		System.out.println("completion Hrs In Task Info Tab " + completionHrsInTaskInfoTab);
		String FteInTaskInfoTab = driver.findElement(FteInTaskInfoEle).getText();
		System.out.println("Fte In Task Info tab " + FteInTaskInfoTab);
		if (productNameInPlanner.equals(productNameInTaskInfoTab) && BatchNameInPlanner.equals(batchnameInTaskInfoTab)
				&& taskGroupNameInPlanner.equals(taskGroupNameInTaskInfoTab)
				&& firstTaskNameInPlanner.equals(taskNameInTaskInfoTab)
				&& firstTaskFteInPlanner.equals(FteInTaskInfoTab)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyEquipmentTollTipInEquipmentTabTest() throws InterruptedException {
		try {
			driver.findElement(popUpClose).click();
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		driver.findElement(equipmentTab).click();
		Thread.sleep(17000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(lastRowTaskInEqTab)).build().perform();
		Thread.sleep(2000);
		try {
			driver.findElement(equipmentTollTip).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserAddEqUnAvlAlertTest() throws InterruptedException {
		Actions action = new Actions(driver);
		driver.findElement(logEventsIcon).click();
		Thread.sleep(2000);
		driver.findElement(addBtn).click();
		driver.findElement(chooseCatg).click();
		Thread.sleep(1000);
		driver.findElement(eqUnAvl).click();
		Thread.sleep(1000);
		driver.findElement(selectResource).click();
		Thread.sleep(1000);
		driver.findElement(eqSearchBox).sendKeys(EventProperties.equipmentName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.=' " + EventProperties.equipmentName + " ']")).click();
		Thread.sleep(1000);
		driver.findElement(startDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_RIGHT).sendKeys("06:00A").build().perform();
		Thread.sleep(1000);
		driver.findElement(endDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_RIGHT).sendKeys("18:00P").build().perform();
		Thread.sleep(1000);
		driver.findElement(addEvent).click();
		try {
			driver.findElement(toasterMessage).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanSeeEqUnAvlAlertTest() throws InterruptedException {
		driver.findElement(summaryTab).click();
		Thread.sleep(2000);
		try {
			driver.findElement(eqUnAvlAlert).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;

		}

	}

	public boolean verifyUserCanSeeTheEqUnAvlTollTipInEquipmentTabTest() throws InterruptedException {
		try {
			driver.findElement(closeBtnForWindow).click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		driver.navigate().refresh();
		Thread.sleep(9000);
		driver.findElement(equipmentTab).click();
		Thread.sleep(15000);
		driver.findElement(filterBtn).click();
		Thread.sleep(1000);
		driver.findElement(selectEquipmentDD).click();
		Thread.sleep(1000);
		driver.findElement(equipmentDDSearchBox).sendKeys(EventProperties.equipmentName);
		driver.findElement(By.xpath("//label[.='" + EventProperties.equipmentName + "']")).click();
		Thread.sleep(2000);
		driver.findElement(applyFilterBtn).click();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(eqUnAvlSection)).build().perform();
		try {
			driver.findElement(eqUnAvlTollTip).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanDeleteEqUnAvlTest() throws InterruptedException {
		boolean b = false;
		driver.findElement(logEventsIcon).click();
		Thread.sleep(2000);
		driver.findElement(summaryTab).click();
		Thread.sleep(2000);
		driver.findElement(deleteIconForEqUnAvl).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		tstmsg = driver.findElement(toasterMessage).getText();
		try {
			driver.findElement(toasterMessage).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		if (tstmsg.equals("Event deleted successfully")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean verifyEqUnAvlAlertIsDisapearedPostDeleteTest() throws InterruptedException {
		driver.findElement(summaryTab).click();
		Thread.sleep(2000);
		try {
			driver.findElement(eqUnAvlAlert).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;

		}
	}

	public boolean verifyTheEqUnAvlTollTipInEquipmentTabPostDeleteTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(equipmentTab).click();
		Thread.sleep(17000);
		driver.findElement(filterBtn).click();
		Thread.sleep(1000);
		driver.findElement(selectEquipmentDD).click();
		Thread.sleep(1000);
		driver.findElement(equipmentDDSearchBox).sendKeys(EventProperties.equipmentName);
		driver.findElement(By.xpath("//label[.='" + EventProperties.equipmentName + "']")).click();
		Thread.sleep(1000);
		driver.findElement(applyFilterBtn).click();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		try {
			actions.moveToElement(driver.findElement(eqUnAvlSection)).build().perform();
			driver.findElement(eqUnAvlTollTip).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyAvlOfProcessOrderDwdBtnTest() throws InterruptedException {
		navigateTo.LattestPublishedPlan();
		Thread.sleep(1000);
		try {
			driver.findElement(processOrderTab).click();
			driver.findElement(processOrderDwdBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyFuncOfZoomInAndZoomButtonInResourceTabTest() throws InterruptedException {
		Thread.sleep(3000);
		navigateTo.LattestPublishedPlan();
		Thread.sleep(2000);
		navigateTo.GetProductDetailsFromPlanner();
		Thread.sleep(2000);
		navigateTo.findFirstTaskFromPlanner();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(firstTaskName)).perform();
		Thread.sleep(4000);
		driver.findElement(dependienciesTab).click();
		Thread.sleep(3000);
		driver.findElement(zoomInBtn).click();
		Thread.sleep(2000);
		driver.findElement(zoomInBtn).click();
		try {
			driver.findElement(gantScaleLineAfterZoom).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyFuncOfZoomOutBtnInResourceTabTest() throws InterruptedException {
		driver.findElement(zoomOutBtn).click();
		Thread.sleep(2000);
		driver.findElement(zoomOutBtn).click();
		try {
			driver.findElement(gantScaleLineAfterZoom).isDisplayed();
			return false;

		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyTheAvailabilityOfTaskDropDownTest() throws InterruptedException {
		Thread.sleep(3000);
		navigateTo.LattestPublishedPlan();
		Thread.sleep(2000);
		driver.findElement(equipmentTab).click();
		Thread.sleep(4000);
		try {
			driver.findElement(selectTaskDropDown).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyTheTaskTimeIntegrationInProductionTabAndEquipmentTab() throws InterruptedException {
		navigateTo.GetProductDetailsFromPlanner();
		Thread.sleep(2000);
		String firstTaskName = navigateTo.findFirstTaskFromPlanner();
		Thread.sleep(2000);
		String taskStrtTime = driver.findElement(firstTaskStartTime).getText().replace(" ", "");
		String taskEndTime = driver.findElement(firstTaskEndTime).getText().replace(" ", "");

		System.out.println("First Task Start Time in production tab is " + taskStrtTime);
		System.out.println("First task End time in production tab is " + taskEndTime);

		driver.findElement(equipmentTab).click();
		Thread.sleep(4000);

		driver.findElement(zoomInBtn).click();
		driver.findElement(zoomInBtn).click();
		Thread.sleep(2000);

		driver.findElement(selectTaskDropDown).click();
		Thread.sleep(3000);
		driver.findElement(selectTaskInputBox).sendKeys(firstTaskName);
		Thread.sleep(2000);
		driver.findElement(selectFirstBatch).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[contains(text(),'" + firstTaskName + "')])[1]"))).build()
				.perform();
		Thread.sleep(3000);
		String task = driver.findElement(equipmentTollTip).getText();
		System.out.println(task);
		Thread.sleep(1000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String EqStart_date = arr2[0].replaceAll("\n", "");
		EqStart_date = EqStart_date.replace(" ", "");
		System.out.println("start date " + EqStart_date);
		String EqEndDate = arr2[1].replace(" ", "");
		System.out.println("end date " + EqEndDate);

		if (taskStrtTime.equals(EqStart_date) && taskEndTime.equals(EqEndDate)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheFunctionalityOfBuildingDropDownInEqTabTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(filterBtn).click();
		Thread.sleep(2000);
		driver.findElement(buildingDropDown).click();
		Thread.sleep(500);
		driver.findElement(selectAllCheckBox).click();
		Thread.sleep(500);
		driver.findElement(applyFilterBtn).click();
		Thread.sleep(2000);
		try {
			driver.findElement(availableEquipmentList).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyProperErrorToasterMsgUnderReschedulingCompTabIfEnROpIsNotSelectedTest()
			throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(comparisonTab).click();
		Thread.sleep(4000);
		driver.findElement(reschedulingComparisonTab).click();
		Thread.sleep(4000);
		String toasterMsgValue = "null";
		try {
			toasterMsgValue = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			toasterMsgValue = "null";
		}

		if (toasterMsgValue.equals("There is no comparable data available for the specified version.")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTheAvailabilityOfEnRComparisonTabUnderReschedulingCompTabTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(comparisonTab).click();
		Thread.sleep(4000);
		driver.findElement(reschedulingComparisonTab).click();
		Thread.sleep(4000);

		try {
			driver.findElement(enRComparisonCheckBox).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanSelectAnyVersionOfThePlanToCompareUnderReschedulinComparisonTabTest()
			throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		String publishedPlanNameValue = driver.findElement(publishedPlanNameEle).getText();
		System.out.println("Published Plan Name is " + publishedPlanNameValue);
		String publishPlanVersionValue = driver.findElement(publishedPlanVersionEle).getAttribute("title").replace("v", "");
		publishedPlanNameValue = publishedPlanNameValue + "-" + publishPlanVersionValue;
		System.out.println("Publis Plan version value is " + publishPlanVersionValue);
		System.out.println("Published Plan Name is " + publishedPlanNameValue);
		driver.findElement(selectPlanDropDownButton).click();
		Thread.sleep(2000);
		String comparingPlanVersionValue = driver.findElement(comparinsgVersionEle).getText();
		System.out.println("Comparing plan versions value " + comparingPlanVersionValue);
		driver.findElement(comparinsgVersionEle).click();
		Thread.sleep(7000);
		String displayedPublishPlanValue = driver.findElement(displayedPublishPlan).getText();
		System.out.println("Displayed publish plan value " + displayedPublishPlanValue);
		String displayedComparingPlanValue = driver.findElement(displayedCompringPlan).getText();
		System.out.println("Displayed comparison plan value " + displayedComparingPlanValue);
		if (publishedPlanNameValue.equals(displayedPublishPlanValue)
				&& comparingPlanVersionValue.equals(displayedComparingPlanValue)) {
			return true;
		} else {
			return false;
		}
	}

}
