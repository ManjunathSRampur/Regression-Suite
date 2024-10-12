package com.qa.bps.pages;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;

public class ProductOverview extends EventProperties {

	WebDriver driver;
	public Navigation navigateTo;
	String time = null;
	String timehour = null;
	List<WebElement> labeslwb = new ArrayList<WebElement>();
	List<String> labelsstrings = new ArrayList<String>();

	List<String> headerInfo = new ArrayList<String>();
	private By batchOverview = By.xpath("//li[contains(text(),'Batch Overview')]");
	public By slashDD = By.xpath("(//button[@data-toggle='dropdown'])[2]");
	public By startBtn2 = By.xpath("(//a[.='Start'])[2]");
	public By startTaskBtn = By.xpath("//button[.='Start Task']");
	public By logDelayBtn1 = By.xpath("(//a[.='Log Delay'])[1]");
	public By chooseCategoryDD = By.xpath("//span[.=' Select Reason Code']");
	public By subAerrowMark = By.xpath("(//button[.=' chevron_right '])[1]");
	public By chooseCategoryFirstOptn = By
			.xpath("(//a[@class='dropdown-item d-flex justify-content-between ng-star-inserted'])[1]");
	public By selectType1DD = By.xpath("(//div[.=' Type '])[1]");
	public By selectTypeOptn = By.xpath("(//a[.=' N/A '])[1]");
	public By durationHH = By.xpath("//input[@placeholder='HH']");
	public By notificationIcon = By.xpath("//div[@class='notification-icon buttons']");
	public By delayDetails = By.xpath("//a[.='Batch :']/ancestor::div[2]//span[@class='task-name pl-1']");
	public By name = By.xpath("(//span[@class='delay-val pl-1'])[2]");
	public By enrTriggerDuration = By.xpath("//input[@placeholder='In Days']");
	public By enrTrigger = By.xpath("//span[.='Accept The Recommendation & Regenerate Plan']");
	public By prodandbatchName = By.xpath("//select/option");
	public By productName = By.xpath("((//select)[1]/option)[1]");
	public By batchName = By.xpath("((//select)[2]/option)[1]");
	public By taskGroup = By.xpath("(//div[contains(@class,'process-card-heading')])[1]");
	public By task = By.xpath("//div[contains(@class,'row')]//div[contains(@class,'process-card-heading')]");
	public By userName = By.xpath("//p[@id='navbarDropdown']");
	public By triggerSuccMsg = By.xpath("//div[@class='notification']");
	public By homeBtn = By.xpath("//li[.=' Home ']");
	public By microPlanning = By.xpath("//img[@src='./assets/png/microplanning-image.png']");
	public By plannerTab = By.xpath("//img[@src='./assets/png/microplanning-image.png']");
	public By versionIcon = By.xpath("//img[@src='./assets/svg/Union.svg']");
	public By publishLabel = By.xpath("(//div[@class='d-flex justify-content-center w-100 ']/div/label)[3]");
	public By publishArrow = By.xpath("(//i[@class='fa fa-fas fa-arrow-right'])[2]");
	private By publishArrow2 = By.xpath("(//i[@class='fa fa-fas fa-arrow-right'])[3]");
	public By batchCard = By.xpath("(//div[.=' N/A '])[2]");
	public By crossIcon = By.xpath("//img[@src='./assets/svg/Cancel.svg']");
	public By startTimeOfTask = By.xpath("(//div[contains(@class,'step-card')]//div[@title='Predicted'])[1]/span");
	public By delayMsg = By.xpath("(//label[@class='form-check-label'])[2]");
	public By managerBackBtn = By.xpath("//li[.=' Manager ']");
	public By controlTowerTab = By.xpath("//img[@src='./assets/png/monitoring.png']");
	public By managerTab = By.xpath("//img[@src='./assets/png/manager.png']");
	private By delayAlertInNotificationIcon = By.xpath("//div/span[.='Delay Time Added']/parent::div");
	private By opUnAvlAlertInNotificationIcon = By.xpath("//a[.='Operator Unavailable']/parent::span/parent::div");
	private By assetDownAlertInNotificationIcon = By.xpath("//span[.='Asset Down']/parent::div");
	public int size;

	public String assetStatusMsg;

	List<WebElement> taskGrpElemements = new ArrayList<WebElement>();
	List<WebElement> batchDDElemements = new ArrayList<WebElement>();
	List<String> bacthDDvalues = new ArrayList<String>();
	List<WebElement> campaignListElements = new ArrayList<WebElement>();
	List<String> delayFields = new ArrayList<String>();
	List<WebElement> delayFieldsEXP = new ArrayList<WebElement>();
	List<String> delayFieldsInManagerPageAlert = new ArrayList<String>();
	public List<String> delayFieldsNames = new ArrayList<String>();
	public List<String> delayFieldsInTask = new ArrayList<String>();
	private ElementUtil eleUtil;
	String reasonEqAsset;
	String eqAsset;
	private By nextTaskStartTimeBeforEnr = By.xpath("(//div[@class='label p-0 m-0 ng-star-inserted'])[3]");
	private By nextTaskEndTimeBeforEnr = By.xpath("(//div[@class='label p-0 m-0 ng-star-inserted'])[4]");

//-----------------------------------------------------------------------------------------------------------------
	private By ProductNameDrop = By.xpath("//select[@id='select']");
	private By BatchNameDrop = By.xpath("(//select[contains(@class,'form-select')])[2]");
	public static By taskGrpProdctOvrVw = By.xpath("(//div[@class='dhx_shape-container']/div)[1]");
	private By firstOp = By.xpath("(//span[@class='allowBtn'])[1]");
	private By menuIcon = By.xpath("//div[@class='dropdown dropdown-large buttons']");
	private By BodheeIcon = By.xpath("//p[.='Bodhee Studio']");
	private By teamMangMtIcon = By.xpath("//a[@href='/qa/qa5/configui/team-management/user']");
	private By opSearchBox = By.xpath("(//input[@placeholder='Search'])[2]");
	private By team = By.xpath("(//div[@tabulator-field='team_name'])[2]");
	private By role = By.xpath("//div[@title='Shift Leader']");
	public String foundOp = null;
	private By tgStartDate = By.xpath("(//div[@class='text'])[1]");
	private By tgEndDate = By.xpath("(//div[@class='text'])[2]");
	private By taskStartDate = By.xpath("(//span[@class='text'])[1]");
	private By taskEndDateF = By.xpath("(//span[@class='text'])[2]");
	private By taskEndDate = By.xpath("(//span[@class='text'])[last()-1]");
	public static By startDD = By.xpath("(//button[@class='btn dropdown-toggle'])[2]");

	public static By startOp = By.xpath("(//div[@class='dropdown-menu show']/a)[1]");
	public static By startButton = By.xpath("//button[.='Start Task']");
	public By changeAllocatedEqOp = By.xpath("(//a[contains(text(),'Change Allocated Equipment')])[2]");
	public By chooseAltEq = By.xpath("(//button[@class='btn dropdown-toggle filter-background'])[1]");
	public By changeEquipment = By.xpath("(//p[contains(text(),'Change Equipment')])[2]");
	public By equipmentNameOnFirstTask = By.xpath("(//span[@class='text '])[1]");

	public By alternateEqList = By.xpath("//div[@x-placement='bottom-start']/a");
	private By nonWorkingHrsTstrClose = By.xpath("//div[@aria-label='Can not close task in non working hours!']");
	public static By closeOp = By.xpath("//div[@class='dropdown-menu show']/a[.='Mark as Completed']");
	public static By closeButton = By.xpath("(//button[.='Mark As Completed'])");
	public static By resetButton = By.xpath("(//a[.='Reset'])[1]");
	public static By startdatePicker = By.xpath("//input[@id='showStartDatePicker']");
	public static By chooseReasonDD = By.xpath("(//span[.=' Select Reason Code'])[1]");
	public static By selectReason = By.xpath("(//span[@class='tree-child tree-last-child font-16'])[1]");
	public static By logDelayButton = By.xpath("//p[.='Log Delay']");
	public static By endDatePicker = By.xpath("//input[@id='showEndDatePicker']");
	private By operatorStatus = By.xpath("//div[@class='dropdown-menu show']/a[.='Operator Status']");
	private By chooseOperatorDD = By.xpath("//div[.=' Choose Operator ']");
	private By selectFOp = By.xpath("(//div[@x-placement='top-start']/a)[1]");
	private By selectLeaveTypeDD = By.xpath("//div[.=' Select Type ']");
	private By selectLeave = By.xpath("//a[.=' Leave - Planned ']");
	private By leaveFromDate = By.xpath("//input[@id='startDate']");
	private By leaveEndDate = By.xpath("//input[@id='endDate']");
	private By submitOpStatus = By.xpath("//a[.='Submit Status']");
	private By restartOption = By.xpath("(//a[.='Restart'])[1]");
	private By deleteAssetDownBtn = By.xpath("(//a[.='Asset Down ']/parent::*/following-sibling::div/*)[2]");
	private By assetAlertMsg = By.xpath("//a[.='Asset Down ']");
	private By operUnAvlDeleteIcon = By.xpath("(//a[.=' Operator Unavailable']/parent::div/following-sibling::*/*)[2]");
	private By operatorUnAvlAlertEle = By.xpath("//a[.=' Operator Unavailable']");
	private By editLogDelayIcon = By.xpath("//div[@class='d-flex']/*");
	private By cleareFormBtn = By.xpath("//button[.='Clear Form']");
	private By additionalCmtBtn = By
			.xpath("(//div[@class='row p-1 pr-2 md-form font-16 align-items-start'])[1]/textarea");
	private By updateDelayBtn = By.xpath("//p[.='Update Delay']");
	public static By commentsInput = By.xpath("(//textarea[@placeholder='Additional Comment'])[1]");
	// -----------------------------------------------------------------------------------------------------
	private By shiftLeader = By.xpath("//div[.='Shift Leader']/preceding::div[6]");
	private By threeDot = By.xpath("//img[@src='./assets/png/3-dot-menu.svg']");
	private By changePwd = By.xpath("(//img[@src='./assets/png/rolesvg.svg'])[2]");
	private By entPwd = By.xpath("(//input[@placeholder='Enter Password'])[2]");
	private By confPwd = By.xpath("(//input[@placeholder='Enter Password'])[3]");
	private By resetPwd = By.xpath("//button[.='Reset Password']");
	private By userDropDown = By.xpath("//div[@id='navbarDropdown']");
	private By logOut = By.xpath("//a[.='Logout']");
	String sLEmail;
	String pwd = "Spider@4";
	public By taskStatusInPov = By.xpath("(//span[@class='text']/a)[1]");
	private By userEmail = By.xpath("//input[@id='username']");
	private By userPwd = By.xpath("//input[@id='txtPassword']");
	private By signInButton = By.xpath("//button[.='SIGN IN']");
	private By controlTower = By.xpath("//img[@src='./assets/png/monitoring.png']");
	private By shifTLead = By.xpath("//img[@src='./assets/png/shift-leader.png']");
	private By dailyOpMgmt = By.xpath("//img[@src='./assets/png/shift-leader.png']");
	private By selectDate = By.xpath("(//input[@id='selectedDate'])[1]");
	private By taskInSLV = By.xpath("//div[@event_id='19-132']");
	private By taskStatusInSLV = By.xpath("(//div[@class='font-16 black-font bold'])[3]");
	private By userDDInSL = By.xpath("//p[@id='navbarDropdown']");
	private By languageDD = By.xpath("(//a[@class='dropdown-item'])[3]");
	private By englishLang = By.xpath("(//a[.='English (en)'])");
	private By closePopUpButton = By.xpath("//img[@src='./assets/svg/Cancel.svg']");
	private By resetBatch = By.xpath("//img[@src='./assets/png/reset.png']");
	private By taskStatus = By.xpath("(//div[@class='step-card p-2 w-100 filter-oee-icon'])[1]/div/div/span/a");
	private By toasterMSGEle = By.xpath("//div[@role='alertdialog']");
	private By statusOfTaskGrp = By.xpath("(//div[@class='col-4 process-state']/a)[2]");
	private By delayDurationInTG = By.xpath("(//div[@class='text'])[3]");
	private By earlyStartAlert = By.xpath("//div[contains(text(),'- Early Start ;')]");
	private By earlyCloseAlert = By.xpath("//div[contains(text(),'Early Finish ;')]");
	private By allocatedEqpInPov = By.xpath("(//div[@class='d-flex w-100 flex-wrap'])[1]/div/span");
	private By firstTaskInPlanner = By.xpath("(//div[@class='gantt_cell gantt_cell_tree'])[4]/div[6]");
	private By resourceTab = By.xpath("(//div[.='Resources '])[2]");
	private By allocatedEqInPlanner = By.xpath("//div[@class='left-side-eq each-row each-eq']/span");

	// ------------------------------------------------------------------------------------------------------
	private By firsttask = By.xpath(event_Id);
	private By batchNo = By.xpath("(//div[@class='block font-16 black-font bold']/a)[4]");
	public static By CloseButton = By.cssSelector("div[class*='close']");
	private By batchDD = By.xpath("(//select)[2]");
	private By selectFirstBatch = By.xpath("((//select)[2]/option)[1]");
	private By batchOption = By.xpath("(//select)[2]/option");
	String batchNumber;
	String productNameVSB;
	private By batchList = By.xpath("//div[@class='dhx_diagram_flow_item ']");
	List<WebElement> taskGroups = new ArrayList<WebElement>();
	private By taskList = By.xpath("(//div[@class='btn-group'])/button");
	List<WebElement> tasksTogleButton = new ArrayList<WebElement>();
	List<WebElement> batchDropDown = new ArrayList<WebElement>();
	private By campaingNameInPOV = By.xpath("(//div[@class='label ml-4'])[1]");
	private By campaignNameInValidation = By.xpath("(//div[@class='smallText mt-0 pt-0'])[1]");
	private By batchOverviewTab = By.xpath("//li[.= ' Batch Overview ']");
	private By validationTab = By.xpath("(//div[.='Validation '])[1]");

	String taskStartDateBeforeEnR = null;
	String taskEndDateBeforeEnR = null;
	public static By assetStatusOp = By.xpath("//div[@class='dropdown-menu show']/a[.='Asset Status']");
	public static By selectAssetDD = By.xpath("(//div[.=' Select Assets '])[1]");
	private By selectEq = By.xpath("(//a[.=' " + equipmentName + " '])[1]");
	private By selectReasonDD = By.xpath("(//div[.=' Select Type '])[1]");
	private By selectReasonForEqUnAvl = By.xpath("(//a[.=' Maintenance '])[1]");
	private By selectTimeForEqUnAvl = By.xpath("(//input[@id='startDate'])[1]");
	private By logAssetDownButton = By.xpath("(//button[.='Log Asset Down'])[1]");
	private By secTaskNameInPov = By.xpath("(//div[@class='process-card-heading ml-0 pl-0'])[2]");
	private By managerTabs = By.xpath("//li[.=' Manager ']");
	private By managerViewTab = By.xpath("(//img[@class='card-image ng-star-inserted'])[1]");
	private By dayViewButton = By.xpath("//a[.='Day View']");
	private By taskDate = By.xpath("(//span[@class='text'])[4]");
	private By managerViewDateBox = By.xpath("//input[@id='selectedDate']");
	String dateWhereDataAvl = null;
	String secTaskName;
	private By taskEventIdMV = By.xpath("(//div[.='DEN-23U002Heating-mixing-cooling I._eq21_DEN'])[1]");
	private By taskGroupColurCode = By.xpath("//div[@class='rounded-pill mt-2 alert-area']");
	private By nonWorkingHrsTstr = By.xpath("//div[@aria-label='Can not start task in non working hours!']");
	private By operatorUnAvlAlertEditIcon = By
			.xpath("(//a[.=' Operator Unavailable']/parent::div/following-sibling::div/*)[1]");
//	---------------------------------------------------------------------------------------------
	List<String> equipmentNameInPOV = new ArrayList<String>();
	List<String> equipmentNameInPlanner = new ArrayList<String>();
	private String nonWorkingHrsTstrMsg = "null";

//-------------------------------------------------------------------------------------------------
	public ProductOverview(WebDriver driver) {
		eleUtil = new ElementUtil(driver);
		this.driver = driver;
	}

	public void xpathReinitialization() {
		System.out.println("Inside Xpath reinialisation ");
		startDD = By.xpath("(//button[@data-toggle='dropdown'])[1]");
		startOp = By.xpath("(//a[contains(text(),'Start')])[4]");
		startButton = By.xpath("(//a[contains(text(),'Start')])[9]");
		startdatePicker = By.xpath("//input[@name='selectedDate']");
		closeOp = By.xpath("//a[contains(text(),'Mark as Completed')]");

	}

	// ----------------------------------------------Error Toaster Validate
	// --------------------

	public boolean tosterValidate() {
		try {
			driver.findElement(By.xpath("//div[@id='toast-container']"));
			System.out.println("Error toaster is displaying hence test case failed ");
			return false;
		} catch (Exception e) {
			System.out.println("Navigate to the page without any error message hence test case is passed");
			return true;
		}
	}

	// --------------------------------------------------------------------------------

	public BatchMonitoring navigateToProductDelayAfterTaskCompletion() {
		driver.findElement(batchOverview).click();
		return new BatchMonitoring(driver, size);

	}

	public String getProductDetails(String productName2) throws InterruptedException, IOException {
		System.out.println("inside product details test case ");
		productNameVSB = productName2;
		System.out.println(productNameVSB);
		try {
			driver.findElement(CloseButton).click();
		} catch (Exception e) {

		}

		return batchNumber;
	}

	public void preReq() throws InterruptedException {

		selectReason = By.xpath("//span[contains(text(),'" + EventProperties.delayReasonCode + "')]");

		navigateTo = new Navigation(driver);
		Select product = new Select(driver.findElement(ProductNameDrop));
		String Finaltext = "null";
		for (WebElement option : product.getOptions()) {
			System.out.println(productNameVSB.trim());
			System.out.println(option.getText().trim());
			if (productNameVSB.trim().contains(option.getText().trim())) {
				System.out.println("inside if condition");
				Finaltext = option.getText();
				product.selectByVisibleText(Finaltext);
				break;
			}
		}
		EventProperties.productName = Finaltext;
		System.out.println("Product Name in Event Properties :" + EventProperties.productName);

		selectFirstBatch = By.xpath("//option[.='" + EventProperties.firstBatchNumber + " ']");
		System.out.println("Xpath to select first batch " + selectFirstBatch);

		System.out.println("productDisplayed " + Finaltext);
		Thread.sleep(1000); // reduce 4 sec
		driver.findElement(batchDD).click();

		selectFirstBatch = By.xpath("//option[.='" + EventProperties.firstBatchNumber + " ']");
		System.out.println("Xpath to select first batch " + selectFirstBatch);

		driver.findElement(selectFirstBatch).click();
		System.out.println("Batch is selected");
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		try {
			driver.findElement(startDD).click();
			driver.findElement(resetButton).click();
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("reset button is disabled ");
			driver.findElement(startDD).click();
		}
		Thread.sleep(8000);
	}

	// ----------------------------------------------------------------------------------------

	public void shiftLeadNavigation() throws InterruptedException {
		driver.findElement(menuIcon).click();
		System.out.println("menu icon clicked ");
		driver.findElement(BodheeIcon).click();
		System.out.println("navigate to bodhee ");
		Thread.sleep(5000);
		driver.findElement(teamMangMtIcon).click();
		System.out.println("navigate to team management ");
		Thread.sleep(2000);
		driver.findElement(opSearchBox).sendKeys(foundOp);
		System.out.println("search operator ");
		String teamName = driver.findElement(team).getText();
		System.out.println(teamName);
		driver.findElement(opSearchBox).clear();
		System.out.println("search operator team");
		Thread.sleep(3000);
		driver.findElement(opSearchBox).sendKeys(teamName);
		System.out.println("find shift lead ");
		Thread.sleep(3000);
		String sLName = driver.findElement(shiftLeader).getText();
		sLEmail = sLName;
		driver.findElement(opSearchBox).clear();
		driver.findElement(opSearchBox).sendKeys(sLName);
		System.out.println(sLName);
		Thread.sleep(5000);
		driver.findElement(threeDot).click();
		System.out.println("click on three dots ");
		driver.findElement(changePwd).click();
		System.out.println("click on change pwd");
		driver.findElement(entPwd).sendKeys(pwd);
		System.out.println("send new pwd");
		driver.findElement(confPwd).sendKeys(pwd);
		System.out.println("send confirm pwd");
		driver.findElement(resetPwd).click();
		System.out.println("click on reset pwd");
		Thread.sleep(2000);
		driver.findElement(userDropDown).click();
		System.out.println("click on user drop down ");
		driver.findElement(logOut).click();
		System.out.println("user loged out");
		Thread.sleep(4000);
		driver.findElement(userEmail).sendKeys(sLEmail);
		driver.findElement(userPwd).sendKeys(pwd);
		driver.findElement(signInButton).click();
		Thread.sleep(4000);
		driver.findElement(userDDInSL).click();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(languageDD)).perform();
		Thread.sleep(4000);
		driver.findElement(englishLang).click();
		Thread.sleep(5000);
		driver.findElement(controlTower).click();
		Thread.sleep(2000);
		driver.findElement(shifTLead).click();
		Thread.sleep(2000);
		driver.findElement(dailyOpMgmt).click();
		Thread.sleep(4000);
		driver.findElement(selectDate).sendKeys("11152023");
		Thread.sleep(7000);
	}

	// ------------------------------------------------------------------------------------------

	public boolean taskAndTGSyncInNotstartedState() throws InterruptedException {
		selectEq = By.xpath("(//a[.=' " + equipmentName + " '])[1]");
		System.out.println("select equipment x path " + selectEq);
		System.out.println("test case 1 started ");
		String tGstDate = driver.findElement(tgStartDate).getText().replace(" ", "");
		System.out.println("TG start Date : " + tGstDate);
		String tGendDate = driver.findElement(tgEndDate).getText().replace(" ", "");
		System.out.println("TG end Date : " + tGendDate);
		String taskStDate = driver.findElement(taskStartDate).getText().replace(" ", "");
		System.out.println("task started : " + taskStDate);
		String taskEnDate = driver.findElement(taskEndDate).getText().replace(" ", "");
		System.out.println("task end Date : " + taskEnDate);
		if (tGstDate.equalsIgnoreCase(taskStDate) && tGendDate.equalsIgnoreCase(taskEnDate)) {
			System.out.println("task group start and end date is equals to task start and end date");
			return true;
		} else {
			System.out.println("task group start and end date is not equal to task start and end date");
			return false;
		}

	}

	public boolean taskAndTGSyncInInprogressState() throws InterruptedException {
		System.out.println("test case 2 started ");
		System.out.println("Verify task start and end date for in progress state");
		driver.findElement(startDD).click();

		Thread.sleep(10000);
		driver.findElement(startOp).click();
		Thread.sleep(1000);
		driver.findElement(startButton).click();
		Thread.sleep(8000);

		try {
			driver.findElement(CloseButton).isDisplayed();
			return false;

		} catch (Exception e) {
			System.out.println("Task info window is disapeared after start");
		}

		String tGstDate = driver.findElement(tgStartDate).getText().replace(" ", "");
		System.out.println("TG start Date : " + tGstDate);
		String tGendDate = driver.findElement(tgEndDate).getText().replace(" ", "");
		System.out.println("TG end Date : " + tGendDate);
		String taskStDate = driver.findElement(taskStartDate).getText().replace(" ", "");
		System.out.println("task started : " + taskStDate);
		String taskEnDate = driver.findElement(taskEndDate).getText().replace(" ", "");
		System.out.println("task end Date : " + taskEnDate);
		if (tGstDate.equalsIgnoreCase(taskStDate) && tGendDate.equalsIgnoreCase(taskEnDate)) {
			System.out.println("task group start and end date is equals to task start and end date");
			return true;
		} else {
			System.out.println("task group start and end date is not equal to task start and end date");
			return false;
		}

	}

	public boolean taskAndTGsynInCloseState() throws InterruptedException {
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}
		System.out.println("test case 3 started ");
		driver.findElement(startDD).click();
		Thread.sleep(2000);
		driver.findElement(closeOp).click();
		driver.findElement(closeButton).click();
		Thread.sleep(13000);
		String tGstDate = driver.findElement(tgStartDate).getText().replace(" ", "");
		System.out.println("TG start Date : " + tGstDate);
		String tGendDate = driver.findElement(tgEndDate).getText().replace(" ", "");
		System.out.println("TG end Date : " + tGendDate);
		String taskStDate = driver.findElement(taskStartDate).getText().replace(" ", "");
		System.out.println("task started : " + taskStDate);
		String taskEnDate = driver.findElement(taskEndDate).getText().replace(" ", "");
		System.out.println("task end Date : " + taskEnDate);
		try {
			driver.findElement(CloseButton).isDisplayed();
			return false;

		} catch (Exception e) {
			System.out.println("Task Info window is disapeared after close");
		}

		driver.findElement(startDD).click();
		Thread.sleep(2000);
		driver.findElement(resetButton).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(13000);

		if (tGstDate.equalsIgnoreCase(taskStDate) && tGendDate.equalsIgnoreCase(taskEnDate)) {
			System.out.println("task group start and end date is equals to task start and end date");
			return true;
		} else {
			System.out.println("task group start and end date is not equal to task start and end date");
			return false;
		}

	}

	public boolean taskAndTGsynInDelayStartState() throws InterruptedException {
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}

		try {
			driver.findElement(startDD).click();
			Thread.sleep(2000);
			driver.findElement(resetButton).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(13000);
		} catch (Exception e) {
			driver.findElement(taskGrpProdctOvrVw).click();
		}
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		System.out.println("test case 4 started ");
		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(startOp).click();
		Thread.sleep(2000);
		new EventProperties();
		driver.findElement(startdatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(startButton).click();
		driver.findElement(chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();

		Thread.sleep(6000);

		try {
			driver.findElement(CloseButton).isDisplayed();
			return false;

		} catch (Exception e) {
			System.out.println("Task infor window is disapeared after delay start ");
		}

		String tGstDate = driver.findElement(tgStartDate).getText().replace(" ", "");
		System.out.println("TG start Date : " + tGstDate);
		String tGendDate = driver.findElement(tgEndDate).getText().replace(" ", "");
		System.out.println("TG end Date : " + tGendDate);
		String taskStDate = driver.findElement(taskStartDate).getText().replace(" ", "");
		System.out.println("task started : " + taskStDate);
		String taskEnDate = driver.findElement(taskEndDate).getText().replace(" ", "");
		System.out.println("task end Date : " + taskEnDate);
		if (tGstDate.equalsIgnoreCase(taskStDate) && tGendDate.equalsIgnoreCase(taskEnDate)) {
			System.out.println("task group start and end date is equals to task start and end date");
			return true;
		} else {
			System.out.println("task group start and end date is not equal to task start and end date");
			return false;
		}

	}

	public boolean taskAndTGsynInDelayCloseState() throws InterruptedException {
		System.out.println("test case 5 started ");

		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}

		try {
			driver.findElement(startDD).click();
			Thread.sleep(1000);
			driver.findElement(startOp).click();
			Thread.sleep(1000);
			driver.findElement(startButton).click();
			Thread.sleep(13000);
		} catch (Exception e) {
			driver.findElement(taskGrpProdctOvrVw).click();
		}
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1500);
		driver.findElement(startDD).click();
		Thread.sleep(2000);
		driver.findElement(closeOp).click();
		Thread.sleep(3000);
		driver.findElement(endDatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);

		System.out.println("date added ");

		driver.findElement(closeButton).click();
		driver.findElement(chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();
		Thread.sleep(7000);

		try {
			driver.findElement(CloseButton).isDisplayed();
			return false;

		} catch (Exception e) {
			System.out.println("Task infor window is disapeared after delay close ");
		}

		String tGstDate = driver.findElement(tgStartDate).getText().replace(" ", "");
		System.out.println("TG start Date : " + tGstDate);
		String tGendDate = driver.findElement(tgEndDate).getText().replace(" ", "");
		System.out.println("TG end Date : " + tGendDate);
		String taskStDate = driver.findElement(taskStartDate).getText().replace(" ", "");
		System.out.println("task started : " + taskStDate);
		String taskEnDate = driver.findElement(taskEndDate).getText().replace(" ", "");
		System.out.println("task end Date : " + taskEnDate);

		driver.findElement(startDD).click();
		Thread.sleep(2000);
		driver.findElement(resetButton).click();
		driver.switchTo().alert().accept();
		Thread.sleep(13000);
		if (tGstDate.equalsIgnoreCase(taskStDate) && tGendDate.equalsIgnoreCase(taskEnDate)) {
			System.out.println("task group start and end date is equals to task start and end date");
			return true;
		} else {
			System.out.println("task group start and end date is not equal to task start and end date");
			return false;
		}

	}

	public boolean taskReset() throws InterruptedException {

		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}

		System.out.println("Test case 6 started ");
		String taskStartTimeBeforeReset = driver.findElement(taskStartDate).getText();
		String taskEndTimeBeforeReset = driver.findElement(taskEndDateF).getText();
		System.out.println("Task start Time befor reset " + taskStartTimeBeforeReset);
		System.out.println("Task end Time befor reset " + taskEndTimeBeforeReset);
		driver.findElement(startDD).click();
		System.out.println("startDD clicked ");
		Thread.sleep(1000);
		driver.findElement(startOp).click();
		System.out.println("startOp is clicked ");
		Thread.sleep(2000);
		driver.findElement(startdatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);

		System.out.println("data is added ");
		driver.findElement(startButton).click();
		System.out.println("start button is clicked ");
		driver.findElement(chooseReasonDD).click();
		System.out.println("chooseReasonDD is clicked ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		System.out.println("selectReason is added ");
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();
		System.out.println("log delay button is clicked ");
		Thread.sleep(13000);

		try {
			driver.findElement(CloseButton).isDisplayed();
			return false;

		} catch (Exception e) {
			System.out.println("Delay window is disapeared after delay start ");
		}

		driver.findElement(startDD).click();
		System.out.println("startDD clicked ");
		Thread.sleep(2000);
		driver.findElement(closeOp).click();
		System.out.println("close op is clicked ");
		driver.findElement(endDatePicker).sendKeys(EventProperties.task_Date);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);

		System.out.println("date added ");

		System.out.println("end date is added ");
		driver.findElement(closeButton).click();
		System.out.println("close button is clicked ");
		driver.findElement(chooseReasonDD).click();
		System.out.println("chooseReasonDD is clicked ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		System.out.println("selectReason is added ");
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();
		System.out.println("logDelayButton is clicked ");
		Thread.sleep(10000);

		try {
			driver.findElement(CloseButton).isDisplayed();
			return false;

		} catch (Exception e) {
			System.out.println("Log delay button is not disapeared after delay close ");
		}
		driver.findElement(startDD).click();
		System.out.println("startDD is clicked ");
		Thread.sleep(2000);
		driver.findElement(resetButton).click();
		System.out.println("resetButton is clicked ");
		driver.switchTo().alert().accept();
		System.out.println("alert is clicked ");
		Thread.sleep(13000);

		String taskStartTimeAfterReset = driver.findElement(taskStartDate).getText();
		String taskEndTimeAfterReset = driver.findElement(taskEndDateF).getText();
		System.out.println("Task start Time After reset " + taskStartTimeAfterReset);
		System.out.println("Task end Time After reset " + taskEndTimeAfterReset);

		if (taskStartTimeBeforeReset.equalsIgnoreCase(taskStartTimeAfterReset)
				&& taskEndTimeBeforeReset.equalsIgnoreCase(taskEndTimeAfterReset)) {
			System.out.println("Task time is reset successfully ");
			return true;
		} else {
			System.out.println("Task time is not reset successfully ");
			return false;
		}
	}

	public boolean taskStatus() throws InterruptedException {
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}
		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(startOp).click();
		Thread.sleep(1000);
		driver.findElement(startButton).click();
		Thread.sleep(13000);

		try {
			driver.findElement(CloseButton).isDisplayed();

		} catch (Exception e) {
			System.out.println("Task info window is disapeared after start");
		}
		String taskStatusValue = driver.findElement(taskStatusInPov).getText();
		if (taskStatusValue.equals("In-progress")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean resetToasterisDisplayed() throws InterruptedException {
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		driver.findElement(startDD).click();
		driver.findElement(resetButton).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(200);
		String MsgOnReset = "null";
		try {
			MsgOnReset = driver.findElement(toasterMSGEle).getText();
		} catch (Exception e) {

		}
		System.out.println(MsgOnReset);
		Thread.sleep(6000);
		if (MsgOnReset.equals("Task status updated successfully")) {
			System.out.println("Reset toaster validation Pass");
			return true;
		} else
			System.out.println("Reset toaster validation Failed");
		return false;

	}

	public boolean statusValidatePostReset() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		String taskStatusPostReset = driver.findElement(taskStatus).getText().replace(" ", "");
		if (taskStatusPostReset.equals("NotStarted")) {
			System.out.println("Post reset Validation pass");
			return true;
		} else
			System.out.println("Post reset Validation Failed");
		return false;

	}

	public boolean taskGrpStatusValdtnPostReset() throws InterruptedException {
		Thread.sleep(6000);

		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		String statsOfTg = driver.findElement(statusOfTaskGrp).getText().replace(" ", "");
		if (statsOfTg.equals("NotStarted")) {
			System.out.println("Post reset Validation pass");
			return true;
		} else
			System.out.println("Post reset Validation Failed");
		return false;

	}

	public boolean delayValidationinTgAfterStart() throws InterruptedException {
		try {
			driver.findElement(startDD).click();
			driver.findElement(resetButton).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(10000);
		} catch (Exception e) {
			driver.findElement(taskGrpProdctOvrVw).click();
		}
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1500);
		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(startOp).click();
		driver.findElement(startdatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(startButton).click();
		driver.findElement(chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();
		Thread.sleep(6000);

		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}

		String delayHrsrPostStrt = driver.findElement(delayDurationInTG).getText();
		System.out.println(delayHrsrPostStrt);
		if (delayHrsrPostStrt.equals("2hrs")) {
			System.out.println("Delay Hours captured for 2 hour on task group hence passed");
			return true;
		} else {
			System.out.println("Delay duration not updated On task group hence TC failed");
			return false;
		}
	}

	public boolean delayDurationValOnTGpostReset() throws InterruptedException {

		try {
			driver.findElement(startDD).click();
			Thread.sleep(1000);
			driver.findElement(startOp).click();
			driver.findElement(startButton).click();
			Thread.sleep(13000);

		} catch (Exception e) {
			driver.findElement(taskGrpProdctOvrVw).click();
		}

		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1500);
		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(resetButton).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(7000);
		String delayHrsbeforStrt = driver.findElement(delayDurationInTG).getText();
		System.out.println(delayHrsbeforStrt);

		if (delayHrsbeforStrt.equals("0hrs")) {
			System.out.println("Delay Hours captured for 0 hour on task group hence passed");
			return true;
		}

		else {
			System.out.println("Delay duration not updated On task group to '0hrs' hence TC failed");
			return false;
		}

	}

	public boolean delayDurationValOnTGDelayedfinish() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(startOp).click();
		Thread.sleep(1000);
		driver.findElement(startButton).click();
		Thread.sleep(13000);
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {
		}

		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1500);
		driver.findElement(startDD).click();
		Thread.sleep(2000);
		driver.findElement(closeOp).click();
		Thread.sleep(3000);
		driver.findElement(endDatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(closeButton).click();
		Thread.sleep(1000);
		driver.findElement(chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();
		Thread.sleep(8000);
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}
		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(resetButton).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(7000);
		String delayHrsbeforStrt = driver.findElement(delayDurationInTG).getText();
		System.out.println(delayHrsbeforStrt);

		if (delayHrsbeforStrt.equals("0hrs")) {
			System.out.println("Delay Hours captured for 0 hour on task group hence passed");
			return true;
		}

		else
			System.out.println("Delay duration not updated On task group to '0hrs' hence TC failed");
		return false;

	}

	public boolean verifyUserCanStartTaskEarlyTest() throws InterruptedException {

		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);
		try {
			driver.findElement(startDD).click();
			driver.findElement(resetButton).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(10000);
		} catch (Exception e) {
			driver.findElement(taskGrpProdctOvrVw).click();
		}
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1500);
		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(startOp).click();
		Thread.sleep(2000);
		new EventProperties();
		driver.findElement(startdatePicker).sendKeys(EventProperties.task_Date);

		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);

		driver.findElement(startButton).click();
		Thread.sleep(1000);
		try {
			nonWorkingHrsTstrMsg = driver.findElement(nonWorkingHrsTstr).getText();
			return true;
		} catch (Exception e) {

		}

		driver.findElement(chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();
		Thread.sleep(500);
		String MsgOnReset = driver.findElement(toasterMSGEle).getText();
		System.out.println(MsgOnReset);
		Thread.sleep(7000);

		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}

		if (MsgOnReset.equals("Task status updated successfully")) {
			System.out.println("User can start the task early");
			return true;
		} else {
			System.out.println("User can't start the task early");
			return false;
		}

	}

	public boolean verifyLogDelayAlertAfterEarlyStartTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(4000);

		if (nonWorkingHrsTstrMsg.equals("Can not start task in non working hours!")) {
			return true;
		}
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);
		try {
			driver.findElement(earlyStartAlert).isDisplayed();
			System.out.println("Early start alert is displayed ");
			return true;
		} catch (Exception e) {
			System.out.println("Early start alert is not displayed ");
			return false;
		}
	}

	public boolean verifyUserCanResetPostEarlyStartTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		try {
			driver.findElement(taskGrpProdctOvrVw).click();
			driver.findElement(startDD).click();
			Thread.sleep(1000);
			driver.findElement(startOp).click();
			Thread.sleep(2000);
			driver.findElement(startButton).click();
			Thread.sleep(9000);
		} catch (Exception e) {
			driver.findElement(taskGrpProdctOvrVw).click();
		}
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1500);
		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(resetButton).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		String MsgOnReset = driver.findElement(toasterMSGEle).getText();
		System.out.println(MsgOnReset);
		Thread.sleep(9000);
		if (MsgOnReset.equals("Task status updated successfully")) {
			System.out.println("Reset toaster validation Pass");
			return true;
		} else {
			System.out.println("Reset toaster validation Failed");
			return false;
		}
	}

	public boolean verifyUserCanCloseTheTaskEarlyTest() throws InterruptedException {

		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(startOp).click();
		Thread.sleep(1000);
		driver.findElement(startButton).click();
		Thread.sleep(8000);
		driver.findElement(startDD).click();
		Thread.sleep(2000);
		driver.findElement(closeOp).click();
		Thread.sleep(3000);
		driver.findElement(endDatePicker).sendKeys(EventProperties.task_Date);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		driver.findElement(closeButton).click();
		Thread.sleep(1000);
		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {

		}

		try {
			nonWorkingHrsTstrMsg = driver.findElement(nonWorkingHrsTstrClose).getText();
			return true;
		} catch (Exception e) {

		}

		driver.findElement(chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();
		Thread.sleep(500);
		String MsgOnReset = driver.findElement(toasterMSGEle).getText();
		System.out.println(MsgOnReset);
		Thread.sleep(7000);

		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}

		if (MsgOnReset.equals("Task status updated successfully")) {
			System.out.println("Reset toaster validation Pass");
			return true;
		} else {
			System.out.println("Reset toaster validation Failed");
			return false;
		}

	}

	public boolean verifyAlertMsgPostEarlyCloseTest() {

		if (nonWorkingHrsTstrMsg.equals("Can not close task in non working hours!")) {
			return true;
		}

		try {
			driver.findElement(earlyCloseAlert).isDisplayed();
			System.out.println("Early start alert is displayed ");
			return true;
		} catch (Exception e) {
			System.out.println("Early start alert is not displayed ");
			return false;
		}

	}

	public boolean verifyUserCanRestartTheTaskTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);
		String taskStatusValue = driver.findElement(taskStatus).getText().trim();
		if (taskStatusValue.equals("In-progress") || taskStatusValue.equals("CLOSED")) {
			driver.findElement(startDD).click();
			driver.findElement(resetButton).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(3500);
		}
		try {
			driver.findElement(startDD).click();
			Thread.sleep(1000);
			driver.findElement(startOp).click();
			Thread.sleep(1000);
			driver.findElement(startButton).click();
			Thread.sleep(9000);

			driver.findElement(startDD).click();
			Thread.sleep(2000);
			driver.findElement(closeOp).click();
			driver.findElement(closeButton).click();
			Thread.sleep(13000);

		} catch (Exception e) {
			driver.findElement(taskGrpProdctOvrVw).click();
		}
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(restartOption).click();
		Thread.sleep(500);
		String MsgOnReset = driver.findElement(toasterMSGEle).getText();
		System.out.println(MsgOnReset);
		Thread.sleep(10000);
		if (MsgOnReset.equals("Task status updated successfully")) {
			System.out.println("Reset toaster validation Pass");
			return true;
		} else {
			System.out.println("Reset toaster validation Failed");
			return false;
		}
	}

	public boolean verifyUserCanDownTheAssetTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		try {
			driver.findElement(deleteAssetDownBtn).click();
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			System.out.println("There is no asset down");
		}
		Thread.sleep(9000);

		try {
			driver.findElement(startDD).click();
			System.out.println("startDD clicked ");
			Thread.sleep(1000);
			driver.findElement(resetButton).click();
			System.out.println("reset button clicked ");
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(8000);
		} catch (Exception e) {
			System.out.println("Task is already in not started state");
		}
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);
		driver.findElement(startDD).click();
		System.out.println("Start dd clicked again");
		driver.findElement(assetStatusOp).click();
		System.out.println("assetStatusOp cliked ");
		driver.findElement(selectAssetDD).click();
		Thread.sleep(1000);
		System.out.println("selectAssetDD  click");
		driver.findElement(selectEq).click();
		System.out.println("selectEq clicked ");
		driver.findElement(selectReasonDD).click();
		Thread.sleep(1000);
		System.out.println("selectReasonDD clicked ");
		driver.findElement(selectReasonForEqUnAvl).click();
		System.out.println("selectReasonForEqUnAvl selected ");
		driver.findElement(selectTimeForEqUnAvl).sendKeys(EventProperties.task_Date);
		Thread.sleep(1000);
		System.out.println(" selectTimeForEqUnAvl sended ");
		driver.findElement(logAssetDownButton).click();
		System.out.println("logAssetDownButton clicked ");
		Thread.sleep(500);
		String MsgOnReset = driver.findElement(toasterMSGEle).getText();
		System.out.println(MsgOnReset);
		Thread.sleep(7000);
		try {
			driver.findElement(CloseButton).isDisplayed();
			return false;

		} catch (Exception e) {

		}
		if (MsgOnReset.equals("Asset status updated!")) {
			System.out.println("Asset status updated!");
			return true;
		} else {
			System.out.println("Asset status updated! failed");
			return false;
		}

	}

	public boolean verifyAssetAlertAvlPostAssetDownTest() {
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}
		try {
			driver.findElement(assetAlertMsg).isDisplayed();
			System.out.println("Asset alert is displayed ");
			return true;
		} catch (Exception e) {
			System.out.println("Asset down alert is not displayed after asset down");
			return false;
		}

	}

	public boolean verifyEqUnAvlAlertInBellIconTest() {
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}
		driver.findElement(notificationIcon).click();
		try {
			driver.findElement(assetDownAlertInNotificationIcon).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanDeleteAssetDownTest() throws InterruptedException {
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}
		driver.findElement(deleteAssetDownBtn).click();
		driver.switchTo().alert().accept();
		Thread.sleep(8000);
		try {
			driver.findElement(assetAlertMsg).isDisplayed();
			System.out.println("Asset alert is displayed after delete ");
			return false;
		} catch (Exception e) {
			System.out.println("Asset alert is disapeared after delete");
			return true;
		}

	}

	public boolean verifyUserCanDoOpUnAvlTest() throws InterruptedException {
		try {
			driver.findElement(operUnAvlDeleteIcon).click();
			driver.switchTo().alert().accept();
			Thread.sleep(8000);
		} catch (Exception e) {
			System.out.println("No operators are unavailable ");
		}
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);
		driver.findElement(startDD).click();
		System.out.println("startDD is clicked ");
		driver.findElement(operatorStatus).click();
		driver.findElement(chooseOperatorDD).click();
		driver.findElement(selectFOp).click();
		driver.findElement(selectLeaveTypeDD).click();
		driver.findElement(selectLeave).click();
		driver.findElement(leaveFromDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(leaveEndDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(submitOpStatus).click();
		Thread.sleep(1500);
		String MsgOnReset = driver.findElement(toasterMSGEle).getText();
		System.out.println("operator unavailable toaster messages :"+MsgOnReset);
		Thread.sleep(7000);

		try {
			driver.findElement(CloseButton).isDisplayed();
			return false;

		} catch (Exception e) {

		}

		if (MsgOnReset.equals("Unavailability Added Successfully")) {
			System.out.println("Reset toaster validation Pass");
			return true;
		} else {
			System.out.println("Reset toaster validation Failed");
			return false;
		}
	}

	public boolean verifyOpUnAvlAlertAvlTest() {
		try {
			driver.findElement(operatorUnAvlAlertEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean opUnAvlAlertInBellIconTest() {
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}
		driver.findElement(notificationIcon).click();
		try {
			driver.findElement(opUnAvlAlertInNotificationIcon).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanDeleteOpUnAvlTest() throws InterruptedException {
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}
		driver.findElement(operUnAvlDeleteIcon).click();
		driver.switchTo().alert().accept();
		Thread.sleep(8000);
		try {
			driver.findElement(operatorUnAvlAlertEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean enR() throws InterruptedException {

		boolean b = false;
		String actulaEnRStatus = null;
		String nextTaskStartDateBeforEnr = null;
		String nextTaskEndDateBeforEnr = null;
		System.out.println("Test case 7 started ");
		driver.findElement(startDD).click();
		System.out.println("startDD clicked ");
		Thread.sleep(1000);
		driver.findElement(startOp).click();
		System.out.println("startOp clicked ");
		Thread.sleep(2000);
		driver.findElement(startButton).click();
		System.out.println("startButton clicked ");
		Thread.sleep(9000);
		driver.findElement(startDD).click();
		System.out.println("startDD clicked ");
		Thread.sleep(2000);
		driver.findElement(closeOp).click();
		System.out.println("closeOp clicked ");
		Thread.sleep(2000);
		driver.findElement(endDatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(closeButton).click();
		System.out.println("closeButton clicked ");
		driver.findElement(chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();
		Thread.sleep(13000);
		driver.findElement(notificationIcon).click();
		System.out.println("notificationIcon clicked ");
		nextTaskStartDateBeforEnr = driver.findElement(nextTaskStartTimeBeforEnr).getText();
		System.out.println("start date befor triggering EnR " + nextTaskStartDateBeforEnr);
		nextTaskEndDateBeforEnr = driver.findElement(nextTaskEndTimeBeforEnr).getText();
		System.out.println("End date befor triggering EnR " + nextTaskEndDateBeforEnr);
		try {
			driver.findElement(enrTrigger).click();
			System.out.println("enrTrigger clicked ");
		} catch (Exception e) {
			System.out.println("unable to triger the EnR");
			Thread.sleep(2000);
			driver.findElement(homeBtn).click();
			driver.findElement(microPlanning).click();
			Thread.sleep(2000);
			driver.findElement(plannerTab).click();
			driver.findElement(versionIcon).click();
			Thread.sleep(2000);
			return false;
		}

		Thread.sleep(2000);
		driver.findElement(homeBtn).click();
		driver.findElement(microPlanning).click();
		Thread.sleep(2000);
		driver.findElement(plannerTab).click();
		Thread.sleep(270000);
		driver.findElement(versionIcon).click();
		Thread.sleep(2000);
		try {
			driver.findElement(publishLabel).isDisplayed();
			actulaEnRStatus = driver.findElement(publishLabel).getText();
			if (actulaEnRStatus.equalsIgnoreCase("Published")) {
				System.out.println("EnR is Triggered " + actulaEnRStatus);
				b = true;
			}
		} catch (Exception e) {
			System.out.println("EnR is failed " + actulaEnRStatus);
			b = false;
		}
		return b;
	}

	public boolean scheduleBatcheAfterEnR() throws InterruptedException {
		System.out.println("Test Case 8 started ");
		Thread.sleep(2000);
		try {
			driver.findElement(publishArrow2).isEnabled();
		} catch (Exception e) {
			System.out.println("EnR version is not displayed hence tesct case is failes ");
			return false;
		}
		try {
			driver.findElement(publishArrow).click();
			System.out.println("publish arrow is clicked ");
			driver.findElement(batchCard).isDisplayed();
			System.out.println("batches are not scheduled ");
			return false;
		} catch (Exception e) {
			System.out.println("Batches are scheduled hence test case is passed ");
			return true;

		}

	}

// Verify user can trigger the EnR with operator unavailability 
	public boolean toOperatorUnavailability() throws InterruptedException {

		// ----------------------------
		System.out.println("test case 9 started step 1 started ");
		driver.findElement(taskGrpProdctOvrVw).click();
		foundOp = driver.findElement(firstOp).getText();
		System.out.println("Operator name befor triggering the EnR " + foundOp);
		Thread.sleep(2000);
		driver.findElement(startDD).click();
		System.out.println("startDD is clicked ");
		Thread.sleep(2000);
		driver.findElement(resetButton).click();
		System.out.println("resetButton is clicked ");
		driver.switchTo().alert().accept();
		System.out.println("alert is clicked ");
		Thread.sleep(9000);
		try {
			driver.findElement(startDD).click();
			System.out.println("startDD is clicked ");
			driver.findElement(operatorStatus).click();
			driver.findElement(chooseOperatorDD).click();
			driver.findElement(selectFOp).click();
			driver.findElement(selectLeaveTypeDD).click();
			driver.findElement(selectLeave).click();
			driver.findElement(leaveFromDate).sendKeys("01012024");
			Thread.sleep(2000);
			driver.findElement(leaveEndDate).sendKeys("01032024");
			Thread.sleep(2000);
			driver.findElement(submitOpStatus).click();
			Thread.sleep(8000);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean toTrigerEnr(String delayTime) throws InterruptedException {
		System.out.println("Test Case 9 step 2 started ");
		boolean b = false;
		String actulaEnRStatus = null;
		String nextTaskStartDateBeforEnr = null;
		String nextTaskEndDateBeforEnr = null;
		driver.findElement(startDD).click();
		System.out.println("startDD clicked ");
		Thread.sleep(2000);
		driver.findElement(startOp).click();
		System.out.println("startOp clicked ");
		Thread.sleep(2000);
		driver.findElement(startButton).click();
		System.out.println("startButton clicked ");
		Thread.sleep(9000);
		driver.findElement(startDD).click();
		System.out.println("startDD clicked ");
		Thread.sleep(2000);
		driver.findElement(closeOp).click();
		System.out.println("closeOp clicked ");
		Thread.sleep(2000);
		driver.findElement(endDatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(closeButton).click();
		System.out.println("closeButton clicked ");
		driver.findElement(chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();
		Thread.sleep(13000);
		driver.findElement(notificationIcon).click();
		System.out.println("notificationIcon clicked ");
		nextTaskStartDateBeforEnr = driver.findElement(nextTaskStartTimeBeforEnr).getText();
		System.out.println("start date befor triggering EnR " + nextTaskStartDateBeforEnr);
		nextTaskEndDateBeforEnr = driver.findElement(nextTaskEndTimeBeforEnr).getText();
		System.out.println("End date befor triggering EnR " + nextTaskEndDateBeforEnr);
		try {
			driver.findElement(enrTrigger).click();
			System.out.println("enrTrigger clicked ");
		} catch (Exception e) {
			System.out.println("unable to triger the EnR");
			Thread.sleep(2000);
			driver.findElement(homeBtn).click();
			driver.findElement(microPlanning).click();
			Thread.sleep(2000);
			driver.findElement(plannerTab).click();
			driver.findElement(versionIcon).click();
			Thread.sleep(2000);
			return false;
		}

		Thread.sleep(2000);
		driver.findElement(homeBtn).click();
		driver.findElement(microPlanning).click();
		Thread.sleep(2000);
		driver.findElement(plannerTab).click();
		Thread.sleep(270000);
		driver.findElement(versionIcon).click();
		Thread.sleep(2000);
		try {
			driver.findElement(publishLabel).isDisplayed();
			actulaEnRStatus = driver.findElement(publishLabel).getText();
			if (actulaEnRStatus.equalsIgnoreCase("Published")) {
				System.out.println("EnR is Triggered " + actulaEnRStatus);
				b = true;
			}
		} catch (Exception e) {
			System.out.println("EnR is failed " + actulaEnRStatus);
			b = false;
		}
		return b;

	}

	public boolean toCheckScheduleBatch() throws InterruptedException {
		System.out.println("test case 9 step 3 started ");
		Thread.sleep(2000);
		try {
			driver.findElement(publishArrow2).isDisplayed();
		} catch (Exception e) {
			System.out.println("EnR version is not displayed hence tesct case is failes ");
			return false;
		}
		try {
			driver.findElement(publishArrow).click();
			System.out.println("publish arrow is clicked ");
			driver.findElement(batchCard).isDisplayed();
			System.out.println("batches are not scheduled ");
			return false;
		} catch (Exception e) {
			System.out.println("Batches are scheduled hence test case is passed ");
			return true;
		}
	}

	public boolean toCheckScheduleOperator() throws InterruptedException {

		// -------------------------------------------
		System.out.println("test case 9  step 4 started ");

		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(3000);
		String allocatedOp = driver.findElement(firstOp).getText();
		System.out.println("Operator name befor triggering the EnR ");
		System.out.println("allocated operator is " + allocatedOp);
		if (foundOp.equalsIgnoreCase(allocatedOp)) {
			System.out.println("Allocated operator and unavilable operator are same " + foundOp + "=" + allocatedOp);
			return false;
		} else {
			System.out
					.println("Allocated operator and unavilable operator are not same " + foundOp + "!=" + allocatedOp);
			return true;
		}

	}

	public boolean enRTrigerWithEqUnAvl() throws InterruptedException {
		System.out.println("test case 13 starte / Verify user can triger the EnR with Equipment unavailability ");
		boolean b = false;
		String actulaEnRStatus = null;
		try {
			driver.findElement(logAssetDownButton).click();
			System.out.println("");
			driver.switchTo().alert().accept();
			Thread.sleep(8000);
		} catch (Exception e) {
		}
		driver.findElement(startDD).click();
		System.out.println("startDD cicked ");
		driver.findElement(resetButton).click();
		System.out.println("resetButton clicked  ");
		driver.switchTo().alert().accept();
		System.out.println("alert accepted");
		Thread.sleep(8000);
		taskStartDateBeforeEnR = driver.findElement(taskStartDate).getText();
		System.out.println("task start date before EnR " + taskStartDateBeforeEnR);
		taskEndDateBeforeEnR = driver.findElement(taskEndDateF).getText();
		System.out.println("task end date before EnR " + taskEndDateBeforeEnR);

		driver.findElement(startDD).click();
		Thread.sleep(1000);
		System.err.println("startDD click");
		try {
			driver.findElement(assetStatusOp).click();
			System.out.println("assetStatusOp cliked ");
			driver.findElement(selectAssetDD).click();
			Thread.sleep(1000);
			System.out.println("selectAssetDD  click");
			driver.findElement(selectEq).click();
			System.out.println("selectEq clicked ");
			driver.findElement(selectReasonDD).click();
			Thread.sleep(1000);
			System.out.println("selectReasonDD clicked ");
			driver.findElement(selectReasonForEqUnAvl).click();
			System.out.println("selectReasonForEqUnAvl selected ");
			driver.findElement(selectTimeForEqUnAvl).sendKeys(EventProperties.eqUnAvlDate);
			Thread.sleep(1000);
			System.out.println(" selectTimeForEqUnAvl sended ");
			driver.findElement(logAssetDownButton).click();
			System.out.println("logAssetDownButton clicked ");
			Thread.sleep(9000);

			driver.findElement(notificationIcon).click();
			System.out.println("notificationIcon clicked ");
			driver.findElement(enrTrigger).click();
			System.out.println("enrTrigger clicked ");
		} catch (Exception e) {
			System.out.println("unable to triger the EnR");
			Thread.sleep(2000);
			driver.findElement(homeBtn).click();
			driver.findElement(microPlanning).click();
			Thread.sleep(2000);
			driver.findElement(plannerTab).click();
			Thread.sleep(3000);
			driver.findElement(versionIcon).click();
			Thread.sleep(2000);
			return false;
		}

		Thread.sleep(2000);
		driver.findElement(homeBtn).click();
		driver.findElement(microPlanning).click();
		Thread.sleep(2000);
		driver.findElement(plannerTab).click();
		Thread.sleep(270000);
		driver.findElement(versionIcon).click();
		Thread.sleep(2000);

		try {
			driver.findElement(publishLabel).isDisplayed();
			actulaEnRStatus = driver.findElement(publishLabel).getText();
			if (actulaEnRStatus.equalsIgnoreCase("Published")) {
				System.out.println("EnR is Triggered " + actulaEnRStatus);
				b = true;
			}
		} catch (Exception e) {
			System.out.println("EnR is failed " + actulaEnRStatus);
			b = false;
		}
		return b;
	}

	public boolean taskTimeAfterEnR() throws InterruptedException {

		// --------------------------------------------
		driver.findElement(taskGroup).click();
		String actualStartDateAfterEnR = driver.findElement(taskStartDate).getText();
		System.out.println("task start date After EnR " + actualStartDateAfterEnR);
		String actualEndDateAfterEnR = driver.findElement(taskEndDateF).getText();
		System.out.println("task end date After EnR " + actualEndDateAfterEnR);
		if (actualStartDateAfterEnR.equalsIgnoreCase(taskStartDateBeforeEnR)
				&& actualEndDateAfterEnR.equalsIgnoreCase(taskEndDateBeforeEnR)) {
			return false;
		} else {
			return true;
		}

	}

	public void taskSyncInManagerViewInNotStartedState() throws InterruptedException {
		driver.findElement(startDD).click();
		System.out.println("startDD clicked ");
		Thread.sleep(1000);
		driver.findElement(startOp).click();
		System.out.println("startOp clicked ");
		driver.findElement(startButton).click();
		System.out.println("startButton clicked ");
		Thread.sleep(8000);
		driver.findElement(startDD).click();
		System.out.println("startDD clicked ");
		Thread.sleep(2000);
		driver.findElement(closeOp).click();
		System.out.println("closeOp clicked ");
		driver.findElement(closeButton).click();
		System.out.println("closeButton clicked ");
		Thread.sleep(8000);
		secTaskName = driver.findElement(secTaskNameInPov).getText().replace("\n", "");
		String a[] = driver.findElement(taskDate).getText().split(" ");
		System.out.println(a[0]);
		String b[] = a[0].split("-");
		String convertDate = b[1] + "" + b[2] + "" + b[0];
		dateWhereDataAvl = convertDate;
		System.out.println("date where data avl " + dateWhereDataAvl);
		System.out.println("Secound task Name :" + secTaskName);
		driver.findElement(managerTabs).click();
		System.out.println("Navigated to Manager Tab ");
		driver.findElement(managerViewTab).click();
		System.out.println("Navigated to Manager view ");
		Thread.sleep(2000);
		driver.findElement(dayViewButton).click();
		System.out.println("dayViewButton clicked ");
		Thread.sleep(2000);
		driver.findElement(managerViewDateBox).sendKeys(dateWhereDataAvl);
		System.out.println("managerViewDateBox clicked ");
		Thread.sleep(3000);

	}

	// -------------------------------------------------
	public boolean completeBatch() throws InterruptedException {
		driver.findElement(closePopUpButton).click();
		System.out.println("inside batch complete");
		driver.findElement(batchDD).click();
		Thread.sleep(3000);
		batchDropDown = driver.findElements(batchOption);
		int batchSize = batchDropDown.size();
		System.out.println("batch size is :" + batchSize);
		System.out.println("inside batch complete");
		for (int j = batchSize; j > 0; j--) {
			driver.findElement(batchDD).click();
			driver.findElement(By.xpath("((//select)[2]/option)[" + j + "]")).click();
			Thread.sleep(2000);
			taskGroups = driver.findElements(batchList);
			for (WebElement taskGroupElt : taskGroups) {
				taskGroupElt.click();
				tasksTogleButton = driver.findElements(taskList);
				int sizeOfTogleButton = tasksTogleButton.size();
				System.out.println(sizeOfTogleButton);
				for (int i = 2; i <= sizeOfTogleButton; i++) {
					driver.findElement(By.xpath("(//button[@class='btn dropdown-toggle'])" + "[" + i + "]")).click();
					Thread.sleep(1000);
					driver.findElement(startOp).click();
					Thread.sleep(1000);
					driver.findElement(startButton).click();
					Thread.sleep(8000);
					driver.findElement(By.xpath("(//button[@class='btn dropdown-toggle'])" + "[" + i + "]")).click();
					driver.findElement(closeOp).click();
					driver.findElement(closeButton).click();
					Thread.sleep(8000);
				}
				driver.findElement(closePopUpButton).click();
				Thread.sleep(2000);
			}
		}

		String campaignValueInPOV = driver.findElement(campaingNameInPOV).getText().replace(" ", "");
		System.out.println("product Overview " + campaignValueInPOV);
		driver.findElement(batchOverviewTab).click();
		Thread.sleep(2000);
		driver.findElement(validationTab).click();
		Thread.sleep(3000);
		String campaignValueInValidation = driver.findElement(campaignNameInValidation).getText().replace(" ", "");
		System.out.println("Validation tab" + campaignValueInValidation);
		if (campaignValueInPOV.equalsIgnoreCase(campaignValueInValidation)) {
			System.out.println("batch closed successfully and data is showing in validation tab");
			return true;
		} else {
			System.out.println(
					"batch closed successfully but data is not showing / wrong data is showing in validation tab");
			return false;
		}
	}

	public boolean taskSyncOfNotStartedInSLV() throws InterruptedException {
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		String actualStatusInPOV = driver.findElement(taskStatusInPov).getText();
		System.out.println("get task status ");
		System.out.println(actualStatusInPOV);
//		foundOp = driver.findElement(firstOp).getText();
		System.out.println("get operator name ");
		shiftLeadNavigation();
		driver.findElement(taskInSLV).click();
		Thread.sleep(3000);
		String actualStatusInSLV = driver.findElement(taskStatusInSLV).getText();
		Thread.sleep(3000);
		if (actualStatusInPOV.equalsIgnoreCase("Not Started")
				&& actualStatusInSLV.equalsIgnoreCase("Status : Yet To Start")) {
			System.out.println("Task status in POV and SLV is Same");
			return true;
		} else {
			System.out.println("Task Status in POV and SLV is not same ");
			return false;
		}
	}

	public boolean verifyTaskEqAlocInPlannerTabTest() throws InterruptedException {
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		List<WebElement> eqNameInPOVEles = driver.findElements(allocatedEqpInPov);
		for (WebElement eqNameInPOVEle : eqNameInPOVEles) {
			equipmentNameInPOV.add(eqNameInPOVEle.getText().replace(" ", ""));
		}
		Collections.sort(equipmentNameInPOV);
		System.out.println("Equipments Name in POV are " + equipmentNameInPOV);
		navigateTo.LattestPublishedPlan();
		navigateTo.GetProductDetailsFromPlanner();
		navigateTo.findFirstTaskFromPlanner();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.doubleClick(driver.findElement(firstTaskInPlanner)).perform();
		Thread.sleep(2000);
		driver.findElement(resourceTab).click();
		Thread.sleep(1000);
		List<WebElement> eqNameInPlannerEles = driver.findElements(allocatedEqInPlanner);
		for (WebElement eqNameInPlannerEle : eqNameInPlannerEles) {
			equipmentNameInPlanner.add(eqNameInPlannerEle.getText().replace(" ", ""));
		}
		Collections.sort(equipmentNameInPlanner);
		System.out.println("Equipment Name in planner " + equipmentNameInPlanner);

		boolean b = equipmentNameInPOV.equals(equipmentNameInPlanner);
		if (b == true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean editLogDelayTest() throws InterruptedException {
		navigateTo.productOverview();
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(startOp).click();
		Thread.sleep(2000);
		driver.findElement(startdatePicker).sendKeys(EventProperties.delayTime);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(startButton).click();
		driver.findElement(chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();
		Thread.sleep(8000);
		driver.findElement(editLogDelayIcon).click();
		Thread.sleep(1000);
		driver.findElement(cleareFormBtn).click();
		driver.findElement(additionalCmtBtn).clear();
		driver.findElement(additionalCmtBtn).sendKeys("Test");
		Thread.sleep(1000);
		driver.findElement(updateDelayBtn).click();
		Thread.sleep(8000);
		driver.findElement(editLogDelayIcon).click();
		Thread.sleep(1000);
		String addedCmt = driver.findElement(additionalCmtBtn).getAttribute("value");
		System.out.println("added comment is " + addedCmt);

		if (addedCmt.equals("Test")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyLogDelayAlertInBellIconTest() {
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}
		driver.findElement(notificationIcon).click();
		try {
			driver.findElement(delayAlertInNotificationIcon).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyTGColourIndicationAfterEarlyStartTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(15000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		try {
			driver.findElement(startDD).click();
			Thread.sleep(1000);
			driver.findElement(resetButton).click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Thread.sleep(9000);
		} catch (Exception e) {
			System.out.println("reset button is disabled ");
			driver.findElement(startDD).click();
		}

		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1500);
		driver.findElement(startDD).click();
		Thread.sleep(1000);
		driver.findElement(startOp).click();
		Thread.sleep(2000);
		new EventProperties();
		driver.findElement(startdatePicker).sendKeys(EventProperties.task_Date);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		Thread.sleep(2000);

		driver.findElement(startButton).click();

		try {
			nonWorkingHrsTstrMsg = driver.findElement(nonWorkingHrsTstr).getText();
			return true;
		} catch (Exception e) {

		}

		driver.findElement(chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(selectReason).click();
		Thread.sleep(1000);
		driver.findElement(commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(logDelayButton).click();
		Thread.sleep(9000);
		String actualColourCode = driver.findElement(taskGroupColurCode).getAttribute("style");
		System.out.println("Actual colour code " + actualColourCode);
		if (actualColourCode
				.equalsIgnoreCase("background: linear-gradient(to right, rgb(0, 128, 0) 0%, rgb(128, 191, 128) 0%);")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyToasterMSGWhileEditingOperatorUnAvlAlertTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);
		try {
			driver.findElement(operUnAvlDeleteIcon).click();
			driver.switchTo().alert().accept();
			Thread.sleep(8000);
		} catch (Exception e) {
			System.out.println("No operators are unavailable ");
		}
		driver.findElement(startDD).click();
		System.out.println("startDD is clicked ");
		driver.findElement(operatorStatus).click();
		driver.findElement(chooseOperatorDD).click();
		driver.findElement(selectFOp).click();
		driver.findElement(selectLeaveTypeDD).click();
		driver.findElement(selectLeave).click();
		driver.findElement(leaveFromDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(leaveEndDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(submitOpStatus).click();
		Thread.sleep(5000);
		try {
			driver.findElement(CloseButton).click();

		} catch (Exception e) {

		}

		driver.findElement(operatorUnAvlAlertEditIcon).click();
		Thread.sleep(2000);
		driver.findElement(additionalCmtBtn).sendKeys("Test Comment for operator Unavailable");
		Thread.sleep(1000);
		driver.findElement(submitOpStatus).click();
		String toasterMSG = "null";
		try {
			toasterMSG = driver.findElement(toasterMSGEle).getText();
			System.out.println(toasterMSG);
		} catch (Exception e) {
			toasterMSG = "null";
		}

		if (toasterMSG.equals("Unavailability Updated Successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvalabilityOfAddedCommentTest() throws InterruptedException {
		driver.findElement(editLogDelayIcon).click();
		Thread.sleep(1500);
		String addedCmt = driver.findElement(additionalCmtBtn).getAttribute("value");
		System.out.println("added comment is " + addedCmt);

		if (addedCmt.equals("Test")) {
			return true;
		} else {
			return false;
		}
	}

}
