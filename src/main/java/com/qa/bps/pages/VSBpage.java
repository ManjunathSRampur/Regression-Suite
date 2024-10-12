package com.qa.bps.pages;

import java.security.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;

public class VSBpage extends EventProperties {

	WebDriver driver;
	Navigation navigateTo;
	private By fieldsNames = By.xpath("//span[@class='legend-title']");

	private By optionname = By.xpath("//div[@x-placement=\"bottom-start\"]//a");

	List<WebElement> Fieldlist = new ArrayList<WebElement>();
	List<WebElement> optionlistname = new ArrayList<WebElement>();

	List<String> stringfield = new ArrayList<String>();
	private By sidetaskbutton = By.xpath("//button[contains(text(),' Side Task ')]");
	private By filterbutton = By.xpath("//button[contains(text(),' Filters ')]");
	public static By DateBox = By.xpath("//input[@placeholder='Date']");
	public static By DataTable = By.xpath("//input[@id='selectedDate2']");
	public static By firsttask = By.xpath(event_Id);
	private By secTask = By.xpath(sec_task_eventId);
	public static By starttaskoption = By.xpath("//div[contains(text(),' Start Task ')]");
	private By MoveBatchbutton = By.xpath("//button[text()=\"Move Batch \"]");
	public static By starttaskbutton = By.xpath("//button[contains(text() , 'Start Task')]");
	public static By markAsCompleteoption = By.xpath("//div[.=' Mark as Completed ']");
	public static By markAsCompleteButton = By.xpath("//button[text()=' Mark As Completed']");
	private By Restarttask = By.xpath("//div[.=' Restart ']");
	public static By ReSettask = By.xpath("//div[contains(text(),' Reset ')]");
	public static By ReSetButton = By.xpath("(//button[contains(text(),'Reset')])[2]");
	private By errorMsg = By.xpath("//div[.=' Exception: null ']");
	private By refreshbutton = By.xpath("(//fa-icon[@class='fa-icon ng-fa-icon'])[3]");
	public static By CloseButton = By.xpath("(//div[contains(@class,'close-button')])[last()]");
	private By closeBtnStartBtn = By.xpath("(//div[@class='close-button pointer'])[last()]");
	public By homepage = By.xpath("//li[text()=' Home ']");
	private By Manager = By.xpath("//div[contains(text(),'Manager')]");
	private By controlTower = By.xpath("//div[contains(text(),'Control Tower')]");
	private By ProductviewScreen = By.xpath("//div[contains(text(),'Product View and Delay Management')]");
	private By productoverview = By.xpath("//button[contains(text(),'Product Overview')]");
	private By VsbTaskStatus = By.xpath("(//div[@class='block font-16 black-font bold'])[1]");
	public static By ProductNameDrop = By.xpath("//select[@id='select']");
	private By BatchNameDrop = By.xpath("(//select[contains(@class,'form-select')])[2]");
	private By lastBatch = By.xpath("(//div/select)[2]/option[last()]");
	private By firsttaskgroup = By.xpath("(//div[contains(@class,'process-card-heading limit-text')])[1]");
	private By Txt1 = By.xpath("//div[@id='toast-container']");
	private By dayviewdd = By.xpath("(//button[@data-toggle='dropdown'])[1]");
	private By TaskstatusPO = By.xpath("(//span/a)[2]");
	private By taskGrpProdctOvrVw = By.xpath("(//div[@class='dhx_shape-container']/div)[1]");
	private By columnToDragTheTask = By.xpath("(//div[@data-col-id='5'])[2]");
	private By vsbtab = By.xpath("//div[contains(text(),'VSB')]");
	public By notificationIcon = By.xpath("//div[@class='notification-icon buttons']");
	public By microPlanning = By.xpath("//img[@src='./assets/png/microplanning-image.png']");
	public By plannerTab = By.xpath("//img[@src='./assets/png/microplanning-image.png']");
	public By versionIcon = By.xpath("//img[@src='./assets/svg/Union.svg']");
	public By publishLabel = By.xpath("(//div[@class='d-flex justify-content-center w-100 ']/div/label)[3]");
	private By publishArrow2 = By.xpath("(//i[@class='fa fa-fas fa-arrow-right'])[3]");
	public By publishArrow = By.xpath("(//i[@class='fa fa-fas fa-arrow-right'])[2]");
	public By batchCard = By.xpath("(//div[.=' N/A '])[2]");
	private By yesBtn = By.xpath("(//button[.='Yes'])[last()]");
	private By yesBtnToEditExistingDelay = By.xpath("(//button[.='Yes'])[1]");
	public By enrTrigger = By.xpath("//span[.='Accept The Recommendation & Regenerate Plan']");
	private By eqCloseBtn = By.xpath("//div[@class='close-button']");
	private By startTaskWindow = By.xpath("//a[.='Start Task']");
	private By userDD = By.xpath("//p[@id='navbarDropdown']");
	private By languageDD = By.xpath("(//a[@class='dropdown-item'])[5]");
	private By nativeLanguage = By.xpath("(//div[@id='custom-lang']/ul/li)[2]");
	private By engLang = By.xpath("//a[.='English (en)']");
	private By showMOCCheckBox = By.xpath("//label[.=' Show MOC ']");
	private By opAllocationCount = By.xpath("//div[@class='w-100 smallText d-flex justify-content-around']/p");
	private By firstTaskNameInVsb = By.xpath("//span[.='Task ']/parent::a/parent::div");
	private By gridSize = By.xpath("(//div[@class='dhx_scale_bar '])[2]");
	private By zoomIn = By.xpath("//a[.='Zoom In ']");
	private By zoomOut = By.xpath("//a[.='Zoom Out ']");
	private By deleteEqUnAvlEle = By.xpath("(//a[.='Asset Down']/parent::div/following-sibling::div/*)[2]");
	private By baseLineCheckBox = By.xpath("//label[@class='containerbody']/span");
	private By featureBtn = By.xpath(
			"//div[.=' Start Task ' or .=' Mark as Completed ' or .=' Log Asset Status ' or .=' Change Allocated Equipment ' or .=' Reset ']");
	private By logEventIcon = By.xpath("//li[@title='Log Events']");
	private By chooseCategoryDD = By.xpath("//div[.=' Choose Category ']");
	private By eqUnAvlOp = By.xpath("//a[.=' Equipment Unavailable ']");
	private By selectResourceDD = By.xpath("//div[.=' Select Resource ']");
	private By searchBox = By.xpath("(//input[@placeholder='Search'])[7]");
	private By selectEqDownResonDD = By.xpath("//div[.=' Select Type ']");
	private By earlyStartToasterMsgEle = By.xpath("//div[@aria-label='Can not start task in non working hours!']");
	private By earlyCloseToasterMsgEle = By.xpath("//div[@aria-label='Can not close task in non working hours!']");
	public By firstSideTask=By.xpath("((//div[@class='card'])[1]/div/div/p/span)[2]");
	private ElementUtil eleUtil;
	boolean sidetaskbtn;
	boolean filterbtn;
	boolean dayviewdrop;
	boolean datatable;
	boolean movebatchbtn;
	String taskStartTimeAfterDrag = null;
	String taskEndTimeAfterDrag = null;
	String earlyStartTstrMsgValue = "null";
	String earlyCloseTstrMsgValue = "null";

	// ----------------------------------------------Error Toaster Validate
	// --------------------

	public void xpathReinitialization() {
		sidetaskbutton = By.xpath("abc");
	}

	public boolean tosterValidate() {
		try {
			driver.findElement(By.xpath("//div[@id='toast-container']")).isDisplayed();
			System.out.println("Error toaster is displaying hence test case is failed ");
			return false;
		} catch (Exception e) {
			System.out.println("Navigate to the page without any error message hence test case passed ");
			return true;
		}
	}

	// --------------------------------------------------------------------------------
	private By notStartedStatus = By.xpath("(//div[@class='block font-16 black-font bold'])[1]/a");
	private By inProgresToaster = By.xpath("//div[.=' Task status updated successfully ']");
	private By inprogressStatus = By.xpath("(//div[@class='block font-16 black-font bold']/a)[1]");
	private By actionToaster = By.xpath("(//div[@role='alertdialog'])[last()]");
	private By completeStatus = By.xpath("(//div[@class='block font-16 black-font bold']/a)[1]");
	private By restartToaster = By.xpath("//div[.=' Task status updated successfully ']");
	private By restartStatus = By.xpath("(//div[@class='block font-16 black-font bold']/a)[1]");
	private By resetToaster = By.xpath("//div[.=' Task status updated successfully ']");
	private By resetStatus = By.xpath("(//div[@class='block font-16 black-font bold']/a)[1]");
	private By assetStatusOption = By.xpath("//div[.=' Log Asset Status ']");
	private By selectEqButon = By.xpath("(//div[.=' Select Assets '])[1]");
	private By selectEqOpt = By.xpath("(//div/a[.=' " + equipmentName + " '])[1]"); // need to change the equipment name
	private By selectReasonButton = By.xpath("(//div[.=' Select Type '])[1]");
	private By selectReasonOp = By.xpath("(//div[@class='row font-16 pl-1']/app-dropdown/div/div/a)[1]");
	private By selectTime = By.xpath("(//input[@name='selectedDate'])[1]");
	private By eqUnAvlToDateEle = By.xpath("(//input[@name='selectedDate'])[2]");
	private By eqUnAvlEndDateAlert = By.xpath("//input[@id='endDate']");
	private By logAssetButton = By.xpath("(//button[.='Log Asset Down'])[1]");
	private By upldateLogEvent = By.xpath("(//button[.='Update'])[1]");
	private By assetToasterMessage = By.xpath("//div[.=' Asset status updated! ']");
	private By eqAlertMessage = By
			.xpath("(//div[.='Asset Down - " + equipmentName + " : " + assetDownReason + " '])[6]");// need to change eq
																									// name and reason
	private String expectedEqAlertMessage = "Asset Down - " + equipmentName + " : " + assetDownReason + ""; // need to
																											// change
																											// equipment
																											// name and
																											// reason
	private By eqAlertMsgInPov = By.xpath("(//div[.='Asset Down  - " + eqNameInPOV + " " + assetDownReason + " '])[1]"); // need
																															// to
																															// change
																															// equipment
																															// name
																															// and
																															// reason
																															// as
																															// display
																															// in
																															// vsb
	private String eqpAlertMsgInVsb = "Asset Down - " + eqNameInPOV + " " + assetDownReason; // need to change equipment
																								// name and reason as
																								// display in vsb
	public By sideTaskButton = By.xpath("//li[@class='gantt-menu-item  gantt-menu-item-right mr-2']");
	public By sideTaskDropDown = By.xpath("(//span[@class='mat-content'])[1]");
	public By sideTaskType = By.xpath("(//div[@class='card'])[1]");
	public By addSideTask = By.xpath("(//div[@class='dhx_matrix_cell dhx_timeline_data_cell '])[2]");
	public By sideTaskToaster = By.xpath("//div[@class='toast-message ng-star-inserted']");
	private By sideTask = By.xpath("//div[contains(@class,'sideTask-top')]");
	private By sideTaskDeleteButton = By.xpath("//div[.=' Delete ']");
	private By sideTaskToasterMsg = By.xpath("//div[@class='toast-message ng-star-inserted']");
	public static By delayStartDatePicker = By.xpath("//input[@id='showStartDatePicker']");
	public static By delayCloseDatePicker = By.xpath("//input[@id='showEndDatePicker']");
	public static By delayStartReasonDD = By.xpath("(//div[@class='md-form font-16'])[1]");
	public static By delayReasonOp = By.xpath("(//span[contains(text(), '" + delayReasonCode + "')])[1]"); // need to
																											// change
	private By cmtBtn = By.xpath("//div[.=' Comments ']");// delay reason
	private By cmtSec = By.xpath("//textarea");
	private By saveCmtBtn = By.xpath("//button[.='Save']");
	private By commentField = By.xpath("//a[.='Comments']/parent::div");
	public static By logDelayButton = By.xpath("//button[.='Log Delay']");
	public static By logDelayToaster = By.xpath("//div[.=' Task status updated successfully ']");

	public static By delayAlertInPov = By
			.xpath("//div[@class='d-flex justify-content-between align-items-center alert-root rounded']");

	public static By delayAlertInVsb = By.xpath("//a[.=' Duration']/parent::div");
	public static String reason = null;
	private By filterButton = By.xpath("//button[.=' Filters ']");
	private By buildingDD = By.xpath("(//div[@class='cuppa-dropdown'])[1]");
	private By cellDD = By.xpath("(//div[@class='cuppa-dropdown'])[2]");
	private By productFamilyDD = By.xpath("(//div[@class='cuppa-dropdown'])[3]");
	private By productDD = By.xpath("(//div[@class='cuppa-dropdown'])[4]");
	private By equipmentDD = By.xpath("(//div[@class='cuppa-dropdown'])[5]");
	private By firstEq = By.xpath("((//div[@class='ng-star-inserted']/ul)[5]/li)[1]");
	private By displayedEq = By.xpath("//div[@class='dhx_matrix_scell']/div");
	private By resetFilterIcon = By.xpath("//button[.='Reset filter']");
	private By postResetAvlTask = By.xpath("(//div[@class='dhx_matrix_scell']/div)[2]");
	private By povStartDate = By.xpath("(//span[@class='text'])[1]");
	private By povEndDate = By.xpath("(//span[@class='text'])[2]");
	private By batchNo = By.xpath("(//div[@class='block font-16 black-font bold']/a)[4]");
	public static By batchDD = By.xpath("(//select)[2]");
	public static By selectFirstBatch = By.xpath("//option[.='112243584 ']");
	private By elementToDrag = By.xpath("(" + event_Id + "/div)[2]");
	private By logDelayEditIcon = By.xpath("(//a[.=' Duration']/parent::div/following-sibling::div/*)[1]");
	public static By additonalCmt = By.xpath("(//textarea[@placeholder='Additional Comment'])[1]");
	private By updateDelay = By.xpath("//p[.='Update Delay']");

	String batchNumber;
	public static String productName;
	String firstTaskName;
	static By taskTollTip = By.xpath("//div[@role='tooltip']");
	int i = 0;
	private By togleButton = By.xpath("(//button[@class='btn dropdown-toggle'])[2]");
	private By povResetButton = By.xpath("(//a[.='Reset'])[1]");

	private String expTaskDetails = null;
	private String expTaskDetailsAfterRestart = null;
	private By threeDayView = By.xpath("//a[.=' 3 Days ']");
	private By dayView = By.xpath("//a[.=' Day ']");
	private By sideTaskActionBtns = By.xpath("//div[.=' Mark as Completed ' or .='Change Duration' or .=' Delete ']");
	private By addLogEventBtn = By.xpath("(//button[.='Add'])[1]");
	private By summaryTab = By.xpath("(//div[.='Summary '])[2]");
	private By deleteEqUnAvl = By
			.xpath("(//div[contains(text(),' Equipment Unavailable')]/following-sibling::div/*)[2]");
	private By editEqUnAvl = By.xpath("(//div[@class='d-flex']/*)[1]");
	private By elementToFindFirstTask = By.xpath("(//div[@class='bar-details w-100 h-100']/parent::div)");
	private By eleForFirstTaskNameInVSB = By.xpath("//span[.='Task ']/parent::a/parent::div");
	private By elementForBatchNumber = By.xpath("//span[.='Batch :']/parent::a");
	private By plantName = By.xpath("(//div[@role='gridcell'])[4]");

	String firstTaskNameFromPlanner;
	String secoundTaskNameFromPlanner;
	String firstTaskNameInVSB;
	String taskArialLabelValueForTask1;
	String taskArialLabelValueForTask2;
	String secoundTaskNameInVSB;
	String firstBatchNameInVSB;
//_____________________________________________________________________________________________________________________________________

	public VSBpage(WebDriver driver) {
		eleUtil = new ElementUtil(driver);
		this.driver = driver;
		navigateTo = new Navigation(driver);

	}

	public void xpathReinitilization() {
		TaskstatusPO = By.xpath("//a[.='State']/following-sibling::a");
		povStartDate = By.xpath("(//div[@class='text'])[1]");
		povEndDate = By.xpath("(//div[@class='text'])[2]");
		togleButton = By.xpath("(//button[@class='btn dropdown-toggle'])[1]");
	}

	public void productDetails(String productName2, String firstTaskName1) throws InterruptedException {

		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(8000);
		firstTaskNameFromPlanner = Navigation.firstTaskNames;
		secoundTaskNameFromPlanner = Navigation.secoundTaskName;

		System.out.println("first task name from planner is:" + firstTaskNameFromPlanner);
		System.out.println("secound task name from planner is:" + secoundTaskNameFromPlanner);

		List<WebElement> taskEle = driver.findElements(elementToFindFirstTask);

		System.out.println("count of available task in vsb screen " + taskEle.size());

		for (int i = 1; i <= taskEle.size(); i++) {
			driver.findElement(refreshbutton).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='bar-details w-100 h-100']/parent::div)[" + i + "]")).click();
			Thread.sleep(2000);
			firstTaskNameInVSB = driver.findElement(eleForFirstTaskNameInVSB).getText().replace("Task ", "");
			firstBatchNameInVSB = driver.findElement(elementForBatchNumber).getText().replace("Batch :", "");
			firstBatchNameInVSB = firstBatchNameInVSB.trim();
			System.out.println("Task Name is:" + firstTaskNameInVSB);
			System.out.println("First Batch Name is " + firstBatchNameInVSB);
			System.out.println("First Batch Number is " + EventProperties.firstBatchNumber);
			if (firstTaskNameInVSB.equals(firstTaskNameFromPlanner)
					&& EventProperties.firstBatchNumber.equals(firstBatchNameInVSB)) {
				driver.findElement(CloseButton).click();
				Thread.sleep(2000);
				System.out.println("inside if condition");
				driver.findElement(refreshbutton).click();
				Thread.sleep(1000);
				driver.findElement(refreshbutton).click();
				Thread.sleep(7000);
				taskArialLabelValueForTask1 = driver
						.findElement(By.xpath("(//div[@class='bar-details w-100 h-100']/parent::div)[" + i + "]"))
						.getAttribute("aria-label");
				System.out.println("Arial label value of first task is " + taskArialLabelValueForTask1);
				break;
			} else {
				driver.findElement(CloseButton).click();
			}

		}
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		List<WebElement> taskEle1 = driver.findElements(elementToFindFirstTask);
		for (int j = 1; j <= taskEle1.size(); j++) {
			driver.findElement(refreshbutton).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='bar-details w-100 h-100']/parent::div)[" + j + "]")).click();
			Thread.sleep(2000);
			secoundTaskNameInVSB = driver.findElement(eleForFirstTaskNameInVSB).getText().replace("Task ", "");
			firstBatchNameInVSB = driver.findElement(elementForBatchNumber).getText().replace("Batch :", "");
			firstBatchNameInVSB = firstBatchNameInVSB.trim();
			Thread.sleep(2000);
			System.out.println("First Batch Name is " + firstBatchNameInVSB);
			System.out.println("First Batch Number is " + EventProperties.firstBatchNumber);
			if (secoundTaskNameInVSB.equals(secoundTaskNameFromPlanner)
					&& EventProperties.firstBatchNumber.equals(firstBatchNameInVSB)) {
				driver.findElement(CloseButton).click();
				Thread.sleep(1000);
				System.out.println("inside if condition");
				driver.findElement(refreshbutton).click();
				Thread.sleep(1000);
				driver.findElement(refreshbutton).click();
				Thread.sleep(7000);
				taskArialLabelValueForTask2 = driver
						.findElement(By.xpath("(//div[@class='bar-details w-100 h-100']/parent::div)[" + j + "]"))
						.getAttribute("aria-label");
				System.out.println("xpath to find secound task " + taskArialLabelValueForTask2);
				System.out.println("Arial label value of secound task is " + taskArialLabelValueForTask2);
				break;
			} else {
				driver.findElement(CloseButton).click();
			}

		}

		EventProperties.event_Id = "(//div[@aria-label='" + taskArialLabelValueForTask1 + "'])[1]";
		EventProperties.sec_task_eventId = "(//div[@aria-label='" + taskArialLabelValueForTask2 + "'])[1]";
		firsttask = By.xpath(event_Id);

		elementToDrag = By.xpath("(" + event_Id + "/div)[2]");
		System.out.println("first task xpath :" + firsttask);
		secTask = By.xpath(sec_task_eventId);
		System.out.println("secound task xpath :" + secTask);

		driver.findElement(firsttask).click();
		Thread.sleep(2000);
		productName = productName2;
		firstTaskName = firstTaskName1.replace(" ", "");
//		firstTaskName = firstTaskName1;
		System.out.println("product name is :" + productName);
		driver.findElement(CloseButton).click();
	}

	public boolean mousehoverontask() throws ParseException, InterruptedException {
		Thread.sleep(4000);
		selectEqOpt = By.xpath("(//div/a[.=' " + equipmentName + " '])[1]");
		System.out.println("Select equipment x path :" + selectEqOpt);
		System.out.println("Test case mouse hover started ");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(3000);
		String task = driver.findElement(taskTollTip).getText();
		System.out.println(task);
		Thread.sleep(1000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		System.out.println("start date " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		System.out.println("end date " + vsbEndDate);
		driver.findElement(homepage).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(controlTower).click();
		Thread.sleep(1000);
		driver.findElement(Manager).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(ProductviewScreen).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(productoverview).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println("Navigated to product overview");
		Thread.sleep(1000); // reduce 1 sec

		if (i == 0) {
			Select product = new Select(driver.findElement(ProductNameDrop));
			String Finaltext = "";

			for (WebElement option : product.getOptions()) {
				System.out.println(option.getText().trim());
				System.out.println(productName.trim());

				if (productName.trim().contains(option.getText().trim())) {
					System.out.println("inside if condition ");
					Finaltext = option.getText();
					product.selectByVisibleText(Finaltext);
					break;
				}
			}

			Thread.sleep(1000);

			selectFirstBatch = By.xpath("//option[.='" + EventProperties.firstBatchNumber + " ']");
			System.out.println("Xpath to select first batch " + selectFirstBatch);
			driver.findElement(batchDD).click();
			driver.findElement(selectFirstBatch).click();
			System.out.println("Batch is selected");

			i = 1;
		}

		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(3000); // reduce 3 sec
		String povStartDates = driver.findElement(povStartDate).getText().replace(" ", "");
		String povEndDates = driver.findElement(povEndDate).getText().replace(" ", "");

		System.out.println("pov start and end date : " + povStartDates + " " + povEndDates);

		// ----

		driver.findElement(homepage).click();
		Thread.sleep(2000);

		if (vsbStart_date.equalsIgnoreCase(povStartDates) && vsbEndDate.equalsIgnoreCase(povEndDates)) {
			System.out.println("VSB start and end date is matched with pov start and end date ");
			return true;
		} else {
			System.out.println("VSB start and end date is not matched with pov start and end date ");
			return false;
		}
	}

	public List<String> checkVSBFieldsNames()

	{
		System.out.println("test case 2 started ");
		Fieldlist = driver.findElements(fieldsNames);
		for (WebElement e : Fieldlist) {
			stringfield.add(e.getText());

		}

		return stringfield;
	}

	public boolean sidetaskButton() {
		System.out.println("test case 3 started");
		sidetaskbtn = driver.findElement(sidetaskbutton).isDisplayed();
		return sidetaskbtn;
	}

	public boolean filterButton() {
		System.out.println("test case 4 started");
		filterbtn = driver.findElement(filterbutton).isDisplayed();
		return filterbtn;
	}

	public boolean DayviewDD() {
		try {
			driver.findElement(dayviewdd).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean moveBatchButton() {
		System.out.println("test case 5 started ");
		movebatchbtn = driver.findElement(MoveBatchbutton).isDisplayed();
		return movebatchbtn;
	}

	public boolean SelectPlanDate() throws InterruptedException {

		try {
			driver.findElement(DataTable).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickonstartTask() throws InterruptedException {

		try {

			driver.findElement(firsttask).click();
			System.out.println("Task info popup is displayed");
			Thread.sleep(1000);
			driver.findElement(ReSettask).click();
			System.out.println("Reset button clicked");
			Thread.sleep(1000);
			driver.findElement(ReSetButton).click();
			System.out.println("Reset alert accetped");
			Thread.sleep(9000);

		} catch (Exception e) {
			driver.findElement(closeBtnStartBtn).click();
			System.out.println("closeBtnStartBtn is clicked ");
			Thread.sleep(5000);
		}

		Thread.sleep(2000);

		try {
			driver.findElement(firsttask).click();
			Thread.sleep(2000);
			driver.findElement(deleteEqUnAvlEle).click();
			driver.switchTo().alert().accept();
			Thread.sleep(8000);

		} catch (Exception e) {
			driver.findElement(CloseButton).click();

		}

		try {
			driver.findElement(logEventIcon).click();
			Thread.sleep(2000);
			driver.findElement(summaryTab).click();
			Thread.sleep(1000);
			driver.findElement(deleteEqUnAvl).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			driver.findElement(eqCloseBtn).click();
			Thread.sleep(1000);
		}

		Thread.sleep(2000);
		System.out.println("test case 8 started ");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(firsttask));
		driver.findElement(firsttask).click();

		System.out.println("firstTaskClicked");

		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		System.out.println("Start task clicked from popup");

		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("Task started");
		Thread.sleep(8000);
		try {

			driver.findElement(startTaskWindow).isDisplayed();
			System.out.println("task info window is not disapeared ");
			System.out.println("startTaskWindow is displayed ");
			driver.findElement(closeBtnStartBtn).click();
			System.out.println("closeBtnStartBtn is clicked ");
			Thread.sleep(1000);
			return false;

		} catch (Exception e) {

		}
		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		System.out.println("first task clicked post task started");

		try {
			driver.findElement(starttaskoption).isDisplayed();

		}

		catch (Exception e) {
			Reporter.log("Start is not displayed");
			System.out.println("Start button not displayed , hence TC passed");

		}
		Thread.sleep(1000); // reduced 7 sec
//		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.findElement(CloseButton).click();
		Thread.sleep(1000); // reduced 3 sec
//		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		return true;
	}

	public boolean taskStartedInProductOverview() throws InterruptedException {
		System.out.println("test case 9 started ");
		driver.findElement(homepage).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(controlTower).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(Manager).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(ProductviewScreen).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(productoverview).click();
		Thread.sleep(1000);
		driver.navigate().refresh();

		Thread.sleep(4000);

		System.out.println("Navigated to product overview");
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000); // reduce 3 sec
		String taskStatusActual = driver.findElement(TaskstatusPO).getText();
		Thread.sleep(1000); // reduce 1 sec
		System.out.println(taskStatusActual);

		if (taskStatusActual.equalsIgnoreCase("In-progress")) {
			System.out.println("Exp=Act");
			Thread.sleep(1000); // reduce 1 sec
			driver.findElement(homepage).click();
			Thread.sleep(2000); // reduce 1 sec
			return true;
		}

		else {
			return false;
		}

	}

	public boolean completeTsk() throws InterruptedException {
		System.out.println("test case 11 started ");
		Thread.sleep(2000);
		driver.findElement(firsttask).click();
		Thread.sleep(1000); // reduce 1 sec
		System.out.println("Clicked on task and popup displayed");
//		Thread.sleep(1000); // reduce 2 sec
		driver.findElement(markAsCompleteoption).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(markAsCompleteButton).click();
		System.out.println("Task closed");
		Thread.sleep(8000);

		// navigating to product overview to check the closed status
		driver.findElement(homepage).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(controlTower).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(Manager).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(ProductviewScreen).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(productoverview).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println("Navigated to product overview");
		System.out.println("productDisplayed");
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000); // reduce 3 sec
		String taskStatusActual = driver.findElement(TaskstatusPO).getText();
		Thread.sleep(1000); // reduce 1 sec
		System.out.println(taskStatusActual);

		if (taskStatusActual.equalsIgnoreCase("CLOSED")) {
			System.out.println("Exp=Act");
			Thread.sleep(1000); // reduce 1 sec
			driver.findElement(homepage).click();
			Thread.sleep(2000); // reduce 1 sec
			return true;
		}

		else {
			return false;
		}

	}

	public boolean ValidateTaskClosure() throws InterruptedException {
		System.out.println("test case 13 started ");
		Thread.sleep(2000);
		driver.findElement(firsttask).click();
		Thread.sleep(1000); // reduce 1 sec
		System.out.println("Clicked  task  and popup displayed");
		Thread.sleep(1000); // reduce 2 sec

		try {
			driver.findElement(markAsCompleteoption).isDisplayed();

		}

		catch (Exception e) {
			Reporter.log("Mark as complete is not displayed");
			System.out.println("Mark as complete button not displayed , hence TC passed");
			Thread.sleep(1000); // reduce 2 sec
			driver.findElement(CloseButton).click();
		}
		Thread.sleep(1000); // reduce 3 sec
		return true;
	}

	public boolean restartTask() throws InterruptedException {
		boolean b = true;
		System.out.println("test case 14 started ");
		driver.findElement(firsttask).click();
		Thread.sleep(1000); // reduce 4 sec
		driver.findElement(Restarttask).click();
		Thread.sleep(8000);

		try {
			driver.findElement(errorMsg).isDisplayed();
			System.out.println("After restart error message is displayed hence test case is failed "
					+ driver.findElement(errorMsg).getText());
			b = false;

		} catch (Exception e) {
			System.out.println("No error message ");
		}

		driver.findElement(homepage).click();
		Thread.sleep(1000);
		driver.findElement(controlTower).click();
		Thread.sleep(1000);
		driver.findElement(Manager).click();
		Thread.sleep(1000);
		driver.findElement(ProductviewScreen).click();
		Thread.sleep(1000);
		driver.findElement(productoverview).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println("Navigated to product overview");
		System.out.println("productDisplayed");
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);
		String taskStatusActual = driver.findElement(TaskstatusPO).getText();

		Thread.sleep(1000);
		System.out.println(taskStatusActual);

		if (taskStatusActual.equalsIgnoreCase("In-progress") && b == true) {
			System.out.println("Exp=Act");
			Thread.sleep(1000);
			driver.findElement(homepage).click();
			Thread.sleep(2000);
			return true;
		} else {
			driver.findElement(homepage).click();
			Thread.sleep(2000);
			return false;
		}

	}

	public boolean resettask() throws InterruptedException {
		boolean b = true;
		System.out.println("test case 16 started ");
		Thread.sleep(2000);

		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		driver.findElement(firsttask).click();
		System.out.println("Task info popup is displayed");
		Thread.sleep(1000); // reduce 2 sec
		driver.findElement(ReSettask).click();
		System.out.println("Reset button clicked");
		Thread.sleep(1000); // reduce 2 sec
		driver.findElement(ReSetButton).click();
		System.out.println("Reset alert accetped");
		Thread.sleep(8000);
		try {
			driver.findElement(errorMsg).isDisplayed();
			System.out.println("error message is displayed hence test case is failed " + errorMsg);
			b = false;
		} catch (Exception e) {
			driver.findElement(firsttask).click();
			Thread.sleep(1000);
			driver.findElement(starttaskoption).isDisplayed();
			Thread.sleep(1000);
			driver.findElement(CloseButton).click();
			Thread.sleep(2000);
			b = true;
		}

		driver.findElement(homepage).click();
		Thread.sleep(2000);
		if (b == true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean taskStatusInProductOVPostReset() throws InterruptedException {
		System.out.println("test case 17 started ");

		driver.findElement(controlTower).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(Manager).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(ProductviewScreen).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(productoverview).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println("Navigated to product overview");
		System.out.println("productDisplayed");
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000); // reduce 1 sec
		String taskStatusActual = driver.findElement(TaskstatusPO).getText();

		Thread.sleep(1000); // reduce 1 sec
		System.out.println(taskStatusActual);

		if (taskStatusActual.equalsIgnoreCase("Not Started")) {
			System.out.println("Exp=Act");
			Thread.sleep(1000); // reduce 1 sec
			driver.findElement(homepage).click();
			Thread.sleep(2000); // reduce 1 sec
			return true;
		} else

			return false;

	}

	// ---------------------------------------------------------------------------------------------------------------------------------
	// verify the task status from the task info pop-up when task is in "Not-Started
	// " state
	public boolean notStartedState() throws InterruptedException {

		System.out.println("Test case 19 started");
		Thread.sleep(2000);
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened ");
		Thread.sleep(2000); // reduce 1 sec
		String actualStatus = driver.findElement(notStartedStatus).getText();
		System.out.println("Actual status " + actualStatus);
		driver.findElement(CloseButton).click();
		if (actualStatus.equalsIgnoreCase("Status : Yet To Start")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean inProgresState() throws InterruptedException {
		System.out.println("test case 20 started ");
		Thread.sleep(2000);
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for testcase 20 ");
		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("Task started ");
		driver.findElement(inProgresToaster).isDisplayed();
		String toasterMessage = driver.findElement(inProgresToaster).getText();
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(9000);
		try {
			System.out.println("task info window is not disapeared ");
			driver.findElement(startTaskWindow).isDisplayed();
			System.out.println("startTaskWindow is displayed ");
			driver.findElement(closeBtnStartBtn).click();
			System.out.println("closeBtnStartBtn is clicked ");
			Thread.sleep(1000);
			return false;

		} catch (Exception e) {

		}

		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for secound time ");
		String actualStatus = driver.findElement(inprogressStatus).getText();
		System.out.println("Actausl " + actualStatus);
		driver.findElement(CloseButton).click();
		if (actualStatus.equalsIgnoreCase("Status : In Progress")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean completeState() throws InterruptedException {

		System.out.println("test case 21 started ");
		Thread.sleep(2000);
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for testcase 21 ");
		Thread.sleep(1000);
		driver.findElement(markAsCompleteoption).click();
		Thread.sleep(1000);
		driver.findElement(markAsCompleteButton).click();
		System.out.println("Task closed");
		driver.findElement(actionToaster).isDisplayed();
		String toasterMessage = driver.findElement(actionToaster).getText();
		System.out.println("Toaster is captured " + toasterMessage);
		Thread.sleep(9000);
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for secound time ");
		Thread.sleep(1000);
		String actualStatus = driver.findElement(completeStatus).getText();
		driver.findElement(CloseButton).click();
		if (actualStatus.equalsIgnoreCase("Status : Completed")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean postRestartStatus() throws InterruptedException {

		System.out.println("test case 22 started ");
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for testcase 22 ");
		Thread.sleep(2000); // reduce 3 sec
		driver.findElement(Restarttask).click();
		String toasterMessage = "null";
		try {
			driver.findElement(restartToaster).isDisplayed();
			toasterMessage = driver.findElement(restartToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured " + toasterMessage);
		Thread.sleep(8000);
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for secound time ");
		Thread.sleep(1000); // reduce 1 sec
		String actualStatus = driver.findElement(restartStatus).getText();
		driver.findElement(CloseButton).click();
		if (actualStatus.equalsIgnoreCase("Status : In Progress")
				&& toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean postResetStatus() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(5000);
		System.out.println("test case 23 started ");
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for testcase 23 ");
		Thread.sleep(1000); // reduce 3 sec
		driver.findElement(ReSettask).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(ReSetButton).click();
		System.out.println("Reset alert accetped");
		driver.findElement(resetToaster).isDisplayed();
		String toasterMessage = driver.findElement(resetToaster).getText();
		System.out.println("toaster message is captured " + toasterMessage);
		Thread.sleep(8000);
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for secound time ");
		Thread.sleep(1000); // reduce 1 sec
		String actuStatus = driver.findElement(resetStatus).getText();
		driver.findElement(CloseButton).click();
		if (actuStatus.equalsIgnoreCase("Status : Yet To Start")) {
			return true;
		} else {
			return false;
		}

	}

	// Verify user can add the asset status down
	public boolean assetDown() throws InterruptedException {

		boolean b = false;
		System.out.println("test case 24 started ");
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for testcase 24 ");
		Thread.sleep(1000);
		driver.findElement(assetStatusOption).click();
		System.out.println("asse status option is clicked");
		Thread.sleep(500);
		driver.findElement(selectEqButon).click();
		System.out.println("equipment button is clicked ");
		Thread.sleep(1000);
		driver.findElement(selectEqOpt).click();
		Thread.sleep(1000);
		System.out.println("equipment is selected ");
		driver.findElement(selectReasonButton).click();
		System.out.println("reason button is clicked ");
		String reson = driver.findElement(selectReasonOp).getText();
		driver.findElement(selectReasonOp).click();
		System.out.println(reson);
		System.out.println("reason is selected ");
		driver.findElement(selectTime).sendKeys(eqUnAvlDate);
		Thread.sleep(2000);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		System.out.println("data selected ");
		driver.findElement(logAssetButton).click();
		System.out.println("asset added ");
		Thread.sleep(500);
		try {
			driver.findElement(assetToasterMessage).isDisplayed();
			String tostMsg = driver.findElement(assetToasterMessage).getText();
			System.out.println("Toaster is capture " + tostMsg);
			System.out.println("asset down added ");
			b = true;
		} catch (Exception e) {
			System.out.println("asset alert is not displayed ");
			driver.findElement(eqCloseBtn).click();
			return false;
		}
		return b;
	}

	public boolean assetAlertInVsb() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		System.out.println("test case 25 started ");
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for testcase 25 ");
		Thread.sleep(2000);
		try {
			driver.findElement(eqAlertMessage).isDisplayed();
			String actualAlertMessage = driver.findElement(eqAlertMessage).getText();
			System.out.println("Alert message " + actualAlertMessage);
			driver.findElement(CloseButton).click();
			if (actualAlertMessage.equalsIgnoreCase(expectedEqAlertMessage)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("alert message is not avaialble ");
			driver.findElement(CloseButton).click();
			return false;
		}

	}

	public boolean assetAlertInPov() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		System.out.println("test case 26 started ");
		driver.findElement(homepage).click();
		Thread.sleep(3000); // reduce 1 sec
		driver.findElement(controlTower).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(Manager).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(ProductviewScreen).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(productoverview).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println("Navigated to product overview");
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000); // reduce 3 sec

		try {
			String actualAlert = driver.findElement(eqAlertMsgInPov).getText();
			driver.findElement(eqAlertMsgInPov).isDisplayed();
			System.out.println(actualAlert);
			driver.findElement(homepage).click();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			if (actualAlert.equalsIgnoreCase(expectedEqAlertMessage)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			driver.findElement(homepage).click();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			System.out.println("alert message is not displayed in product overview ");
			return false;
		}

	}

	public boolean deleteAddedEqTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(firsttask).click();
		Thread.sleep(2000);
		try {
			driver.findElement(deleteEqUnAvlEle).click();
			driver.switchTo().alert().accept();
			Thread.sleep(8000);
			return true;
		} catch (Exception e) {
			System.out.println("unable to delete the asset down");
			return false;
		}
	}

	public boolean addSideTask() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(8000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(9000);
		boolean b = false;
		System.out.println("tes case 27 started ");
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(firsttask));
		driver.findElement(firsttask).click();
		driver.findElement(CloseButton).click();
		System.out.println("test case 27 started ");
		Thread.sleep(3000);
		driver.findElement(sideTaskButton).click();
		System.out.println("side task button is clicked ");
		Thread.sleep(3000);
		driver.findElement(sideTaskDropDown).click();
		System.out.println("side task drop down is clicked ");
		Thread.sleep(2000);
		driver.findElement(sideTaskType).click();
		System.out.println("side task type is selected ");
		Thread.sleep(1000);
		driver.findElement(addSideTask).click();
		Thread.sleep(2000);
		try {
			driver.findElement(sideTaskToaster).isDisplayed();
			String toasterMessage = driver.findElement(sideTaskToaster).getText();
			System.out.println("Toaster is captured " + toasterMessage);
			Thread.sleep(5000);
			driver.findElement(sideTaskButton).click();
			b = true;
		} catch (Exception e) {
			driver.findElement(sideTaskButton).click();
			System.out.println("toaster message is not displayed");
			b = false;
		}

		return b;
	}

	public boolean sideTaskAvl() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		System.out.println("");
		boolean flag = true;
		System.out.println("test case 28 is started ");
		try {
			driver.findElement(sideTask).isDisplayed();
			System.out.println("side task is displayed ");
		} catch (Exception e) {
			System.out.println("side task is not added ");
			flag = false;
		}
		return flag;
	}

	public boolean deleteSideTask() throws InterruptedException {
		boolean flag = true;
		System.out.println("test case 29 started ");
		driver.findElement(CloseButton).click();
		Thread.sleep(1000);
		driver.findElement(sideTask).click();
		System.out.println("side task info pop-up is opened ");
		Thread.sleep(4000);
		driver.findElement(sideTaskDeleteButton).click();
		System.out.println("side task delete button is clicked ");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		try {
			driver.findElement(sideTaskToasterMsg).isDisplayed();
			String toasterMessage = driver.findElement(sideTaskToasterMsg).getText();
			System.out.println("delete toaster message is captured :" + toasterMessage);
		} catch (Exception e) {
			System.out.println("delete toaster message is not displayed");
			flag = false;
		}
		Thread.sleep(9000);
		return flag;

	}

	public boolean delayStart() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		Actions actions = new Actions(driver);
		boolean flag = true;
		System.out.println("Test case 30 started ");
		Thread.sleep(6000);
		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(starttaskoption).click();
		System.out.println("start option clicked ");
		Thread.sleep(1000);
		driver.findElement(delayStartDatePicker).sendKeys(delayTime);
		Thread.sleep(1000);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);

		System.out.println("date added ");
		Thread.sleep(2000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(3000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		reason = driver.findElement(delayReasonOp).getText();
		System.out.println("delay reason is " + reason);
		Thread.sleep(3000);
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		Thread.sleep(1000);

		driver.findElement(logDelayButton).click();
		Thread.sleep(2000);

		try {
			String tosterMessage = driver.findElement(logDelayToaster).getText();
			driver.findElement(logDelayToaster).isDisplayed();
			System.out.println("Toaster is capture " + tosterMessage);
		} catch (Exception e) {
			System.out.println("Toaster message is not displayed ");
			flag = false;
		}
		Thread.sleep(8000);
		return flag;
	}

	public boolean delayStartValInVsb() {
		System.out.println("test case 31 started ");
		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		try {
			String actualAlert = driver.findElement(delayAlertInVsb).getText();
			System.out.println("actual alert is " + actualAlert);
			String exAlert = "N/A - " + reason + " ; Duration: 2 hrs";
			System.out.println("expected alert is :" + exAlert);
			driver.findElement(CloseButton).click();
			if (actualAlert.equalsIgnoreCase(exAlert)) {
				return true;
			} else {
				System.out.println("reason is not matched / alert message is not displayed ");
				return false;
			}
		} catch (Exception e) {
			System.out.println("reason is not matched / alert message is not displayed ");
			driver.findElement(CloseButton).click();
			return false;
		}
	}

	public boolean delayStartValInPov() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		System.out.println("Test case 32 started ");
		driver.findElement(homepage).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(controlTower).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(Manager).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(ProductviewScreen).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(productoverview).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println("Navigated to product overview");
		Thread.sleep(3000); // reduce 1 sec
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000); // reduce 3 sec
		try {
			String actualAlert = driver.findElement(delayAlertInPov).getText();
			String expAlert = this.reason + " - " + "Delayed Started ; Duration: 2 hrs";
			System.out.println("expected alert :" + expAlert);
			System.out.println(actualAlert);
			driver.findElement(togleButton).click();
			Thread.sleep(2000);
			driver.findElement(povResetButton).click();
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			driver.findElement(homepage).click();
			if (actualAlert.equalsIgnoreCase(expAlert)) {
				return true;
			} else {
				System.out.println("selected reason or duration is not matched ");
				return false;
			}
		} catch (Exception e) {
			driver.findElement(togleButton).click();
			Thread.sleep(2000);
			driver.findElement(povResetButton).click();
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			driver.findElement(homepage).click();
			return false;
		}
	}

	public boolean filterFunctionality() throws InterruptedException {
		System.out.println("Test case 33 started ");
		driver.findElement(filterButton).click();
		driver.findElement(buildingDD).click();
		driver.findElement(cellDD).click();
		driver.findElement(productFamilyDD).click();
		driver.findElement(productDD).click();
		driver.findElement(equipmentDD).click();
		Thread.sleep(1000);
		String selectedEq = driver.findElement(firstEq).getText();
		driver.findElement(firstEq).click();
		String disEq = driver.findElement(displayedEq).getText();
		if (selectedEq.equalsIgnoreCase(disEq)) {
			System.out.println("selected equipment = displayed equipment :" + selectedEq + " = " + disEq);
			return true;
		} else {
			System.out.println(
					"selected equipment and displayed equipment is not matched / unable to select the equipment");
			return false;
		}

	}

	public boolean resetFilter() throws InterruptedException {
		System.out.println("test case 34 started ");
		boolean flag = false;
		driver.findElement(resetFilterIcon).click();
		try {
			driver.findElement(postResetAvlTask).isDisplayed();
			System.out.println("Filter reset is successful");

			flag = true;
		} catch (Exception e) {
			System.out.println("Filter is not reseted");
			flag = false;
		}
		driver.findElement(filterButton).click();
		Thread.sleep(4000);
		return flag;
	}

	public boolean taskStartAndEnddateSyncOnInProgressState() throws InterruptedException, ParseException {
		System.out.println("test case 35 started ");
		System.out.println("Verify the task start and end date in POV after staring the task");
		driver.findElement(firsttask).click();
		driver.findElement(starttaskoption).click();
		driver.findElement(starttaskbutton).click();
		Thread.sleep(9000);
		try {
			System.out.println("task info window is not disapeared ");
			driver.findElement(startTaskWindow).isDisplayed();
			System.out.println("startTaskWindow is displayed ");
			driver.findElement(closeBtnStartBtn).click();
			System.out.println("closeBtnStartBtn is clicked ");
			Thread.sleep(1000);
//			return false;

		} catch (Exception e) {

		}

		boolean flag = mousehoverontask();
		return flag;
	}

	public boolean taskStartAndEnddateSyncOnCloseState() throws InterruptedException, ParseException {
		System.out.println("test case 36 started ");
		System.out.println("Verify the task start and end date in POV after closing the task");
		driver.findElement(firsttask).click();
		driver.findElement(markAsCompleteoption).click();
		driver.findElement(markAsCompleteButton).click();
		Thread.sleep(9000);
		boolean flag = mousehoverontask();
		return flag;
	}

	public boolean taskStartAndEnddateSyncOnDelayStartState() throws InterruptedException, ParseException {
		System.out.println("test case 37 started ");
		System.out.println("verify task start and end date POV after delay start ");
		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(9000);
		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(1000);
		driver.findElement(delayStartDatePicker).sendKeys(delayTime);
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		System.out.println("date added ");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(1000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);

//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		reason = driver.findElement(delayReasonOp).getText();
		System.out.println("delay reason is " + reason);
		Thread.sleep(1000);
		driver.findElement(delayReasonOp).click();

		driver.findElement(additonalCmt).sendKeys("Test");

		Thread.sleep(1000);

		driver.findElement(logDelayButton).click();
		Thread.sleep(9000);
		boolean flag = mousehoverontask();
		return flag;
	}

	public boolean taskStartAndEnddateSyncOnDelayCloseState() throws InterruptedException, ParseException {
		System.out.println("test case 38 started ");
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for testcase 38 ");
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(markAsCompleteoption).click();
		Thread.sleep(1000);
		driver.findElement(delayCloseDatePicker).sendKeys(delayCloseTime);

		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		driver.findElement(markAsCompleteButton).click();
		Thread.sleep(1000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();

		driver.findElement(additonalCmt).sendKeys("Test");

		Thread.sleep(1000);

		driver.findElement(logDelayButton).click();
		Thread.sleep(9000);
		boolean flag = mousehoverontask();
		return flag;
	}

	public boolean taskResetFuncInNormalStart() throws InterruptedException {
		System.out.println("Test case 39 started ");

		try {
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
			Thread.sleep(4000);
			driver.findElement(firsttask).click();
			driver.findElement(ReSettask).click();
			Thread.sleep(1000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(8000);
		} catch (Exception e) {

		}

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		System.out.println("expected details capturing started ");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		expTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);
		System.out.println("expected task details are " + expTaskDetails);

		driver.findElement(firsttask).click();
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(9000);

		try {
			System.out.println("task info window is not disapeared ");
			driver.findElement(startTaskWindow).isDisplayed();
			System.out.println("startTaskWindow is displayed ");
			driver.findElement(closeBtnStartBtn).click();
			System.out.println("closeBtnStartBtn is clicked ");
			Thread.sleep(1000);

		} catch (Exception e) {

		}

		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(9000);

		System.out.println("Actual details capturing started ");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		String actulTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);
		System.out.println("Actual task details are " + actulTaskDetails);

		if (expTaskDetails.equalsIgnoreCase(actulTaskDetails)) {
			System.out.println("expected task details matched with actual task details ");
			return true;
		} else {
			System.out.println("expected task details are not matched with actual task details ");
			return false;
		}

	}

	public boolean taskResetFuncInNormalClose() throws InterruptedException {
		System.out.println("test case 40 started ");

		try {
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
			Thread.sleep(4000);
			driver.findElement(firsttask).click();
			driver.findElement(ReSettask).click();
			Thread.sleep(1000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(8000);
		} catch (Exception e) {

		}

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		System.out.println("expected details capturing started ");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		expTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);
		System.out.println("expected task details are " + expTaskDetails);

		driver.findElement(firsttask).click();
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(9000);
		driver.findElement(firsttask).click();
		driver.findElement(markAsCompleteoption).click();
		Thread.sleep(1000);
		driver.findElement(markAsCompleteButton).click();
		Thread.sleep(8000);
		System.out.println("Expected task details are " + expTaskDetails);
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(9000);

		System.out.println("Actual details capturing started ");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		String actulTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);
		System.out.println("Actual task details are " + actulTaskDetails);

		if (expTaskDetails.equalsIgnoreCase(actulTaskDetails)) {
			System.out.println("expected task details matched with actual task details ");
			return true;
		} else {
			System.out.println("expected task details are not matched with actual task details ");
			return false;
		}

	}

	public boolean taskResetFuncInDelayStart() throws InterruptedException {
		System.out.println("Test case 41 started ");

		try {
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
			Thread.sleep(4000);
			driver.findElement(firsttask).click();
			driver.findElement(ReSettask).click();
			Thread.sleep(1000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(8000);
		} catch (Exception e) {

		}

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		System.out.println("expected details capturing started ");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		expTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);
		System.out.println("expected task details are " + expTaskDetails);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(1000);
		driver.findElement(delayStartDatePicker).sendKeys(delayTime);
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		System.out.println("date added ");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(1000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
		driver.findElement(delayReasonOp).click();

		driver.findElement(additonalCmt).sendKeys("Test");

		Thread.sleep(1000);

		driver.findElement(logDelayButton).click();
		Thread.sleep(8000);

		driver.findElement(firsttask).click();
		driver.findElement(markAsCompleteoption).click();
		Thread.sleep(1000);
		driver.findElement(markAsCompleteButton).click();
		Thread.sleep(8000);
		System.out.println("Expected task details are " + expTaskDetails);
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(8000);

		System.out.println("Actual details capturing started ");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(3000);
		String actulTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);
		System.out.println("Actual task details are " + actulTaskDetails);

		if (expTaskDetails.equalsIgnoreCase(actulTaskDetails)) {
			System.out.println("expected task details matched with actual task details ");
			return true;
		} else {
			System.out.println("expected task details are not matched with actual task details ");
			return false;
		}

	}

	public boolean taskResetFuncInDelayClose() throws InterruptedException {
		System.out.println("Test case 42 started ");

		try {
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
			Thread.sleep(4000);
			driver.findElement(firsttask).click();
			driver.findElement(ReSettask).click();
			Thread.sleep(1000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(8000);
		} catch (Exception e) {

		}

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		System.out.println("expected details capturing started ");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		expTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);
		System.out.println("expected task details are " + expTaskDetails);

		driver.findElement(firsttask).click();
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(9000);
		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(markAsCompleteoption).click();
		System.out.println("mark as acomplete option is clicked ");
		Thread.sleep(1000);

		driver.findElement(delayCloseDatePicker).sendKeys(delayCloseTime);

		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		System.out.println("date added ");
		driver.findElement(markAsCompleteButton).click();
		System.out.println("mark as complete button clicked ");
		Thread.sleep(1000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		driver.findElement(additonalCmt).sendKeys("Test");
		Thread.sleep(1000);
		driver.findElement(logDelayButton).click();
		Thread.sleep(9000);

		System.out.println("Expected task details are " + expTaskDetails);
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(9000);

		System.out.println("Actual details capturing started ");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		String actulTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);
		System.out.println("Actual task details are " + actulTaskDetails);

		if (expTaskDetails.equalsIgnoreCase(actulTaskDetails)) {
			System.out.println("expected task details matched with actual task details ");
			return true;
		} else {
			System.out.println("expected task details are not matched with actual task details ");
			return false;
		}

	}

	public boolean restartFuncInNormalStart() throws InterruptedException {

		try {
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
			Thread.sleep(4000);
			driver.findElement(firsttask).click();
			driver.findElement(ReSettask).click();
			Thread.sleep(1000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(8000);
		} catch (Exception e) {

		}

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		System.out.println("Test case 43 started ");
		Actions act = new Actions(driver);
		System.out.println("Expected task details capturing started ");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		expTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		Thread.sleep(3000);
		System.out.println("Expected Task Details After restart " + expTaskDetailsAfterRestart);
		driver.findElement(firsttask).click();
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(9000);

		try {
			System.out.println("task info window is not disapeared ");
			driver.findElement(startTaskWindow).isDisplayed();
			System.out.println("startTaskWindow is displayed ");
			driver.findElement(closeBtnStartBtn).click();
			System.out.println("closeBtnStartBtn is clicked ");
			Thread.sleep(1000);
//			return false;

		} catch (Exception e) {

		}

		driver.findElement(firsttask).click();
		driver.findElement(markAsCompleteoption).click();
		Thread.sleep(2000);
		driver.findElement(markAsCompleteButton).click();
		Thread.sleep(8000);
		System.out.println("Expected task details are " + expTaskDetailsAfterRestart);
		driver.findElement(firsttask).click();
		driver.findElement(Restarttask).click();
		Thread.sleep(8000);

		System.out.println("Actual task details capturing started after restart");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		String actualTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		if (expTaskDetailsAfterRestart.equalsIgnoreCase(actualTaskDetailsAfterRestart)) {
			System.out.println(
					"Expected task details are matched with actual task details hence Restart functionality is working as expected with normal start and normal close");
			return true;
		} else {
			System.out.println(
					"Expected task details are not matched with actual task details hence Restart functionality with normal start and normal close is failed ");

			return false;
		}

	}

	public boolean restartFuncInDelayStart() throws InterruptedException {

		try {
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
			Thread.sleep(4000);
			driver.findElement(firsttask).click();
			driver.findElement(ReSettask).click();
			Thread.sleep(1000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(8000);
		} catch (Exception e) {

		}

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		System.out.println("Test case 44 strated ");
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(2000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(10000);
		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(2000);
		driver.findElement(delayStartDatePicker).sendKeys(delayTime);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		System.out.println("date added ");
		Thread.sleep(3000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(3000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
		driver.findElement(delayReasonOp).click();
		Thread.sleep(3000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(8000);

//		new lines added here ------------------------
		Actions act = new Actions(driver);
		System.out.println("Expected task details capturing started ");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		expTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		Thread.sleep(3000);
//		new lines ends her-----------------------------

		driver.findElement(firsttask).click();
		driver.findElement(markAsCompleteoption).click();
		Thread.sleep(2000);
		driver.findElement(markAsCompleteButton).click();
		Thread.sleep(8000);
		System.out.println("Expected task details are " + expTaskDetailsAfterRestart);

		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		driver.findElement(Restarttask).click();
		Thread.sleep(8000);
//		Actions act = new Actions(driver);
		System.out.println("Actual task details capturing started after restart");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		String actualTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		if (expTaskDetailsAfterRestart.equalsIgnoreCase(actualTaskDetailsAfterRestart)) {
			System.out.println(
					"Expected task details are matched with actual task details hence Restart functionality is working as expected with Dealy start and normal close");
			return true;
		} else {
			System.out.println(
					"Expected task details are not matched with actual task details hence Restart functionality with Delay start and normal close is failed ");

			return false;
		}
	}

	public boolean restartFuncInDelayClose() throws InterruptedException {

		try {
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
			Thread.sleep(4000);
			driver.findElement(firsttask).click();
			driver.findElement(ReSettask).click();
			Thread.sleep(1000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(8000);
		} catch (Exception e) {

		}

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		System.out.println("test case 45 started ");
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(2000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(10000);

		driver.findElement(firsttask).click();
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(2000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(10000);

//		new lines added here ------------------------
		Actions act = new Actions(driver);
		System.out.println("Expected task details capturing started ");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		expTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		Thread.sleep(3000);
//		new lines ends her-----------------------------

		try {
			System.out.println("task info window is not disapeared ");
			driver.findElement(startTaskWindow).isDisplayed();
			System.out.println("startTaskWindow is displayed ");
			driver.findElement(closeBtnStartBtn).click();
			System.out.println("closeBtnStartBtn is clicked ");
			Thread.sleep(1000);
//			return false;

		} catch (Exception e) {

		}

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(markAsCompleteoption).click();
		System.out.println("mark as acomplete option is clicked ");
		Thread.sleep(2000);

		driver.findElement(delayCloseDatePicker).sendKeys(delayCloseTime);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		System.out.println("date added ");
		driver.findElement(markAsCompleteButton).click();
		System.out.println("mark as complete button clicked ");
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(10000);
		System.out.println("Expected task details are " + expTaskDetailsAfterRestart);

		driver.findElement(firsttask).click();
		driver.findElement(Restarttask).click();
		Thread.sleep(8000);

		System.out.println("Actual task details capturing started after restart");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		String actualTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		if (expTaskDetailsAfterRestart.equalsIgnoreCase(actualTaskDetailsAfterRestart)) {
			System.out.println(
					"Expected task details are matched with actual task details hence Restart functionality is working as expected with normal start and Delay close");
			return true;
		} else {
			System.out.println(
					"Expected task details are not matched with actual task details hence Restart functionality with normal start and Delay close is failed ");

			return false;
		}

	}

	public boolean nextTaskTimeUpdWithDelayStart() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(5000);

		System.out.println("test case 46 started ");
		driver.findElement(dayviewdd).click();
		Thread.sleep(1000);
		driver.findElement(threeDayView).click();
		Thread.sleep(6000);
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(2000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(10000);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(2000);
		driver.findElement(delayStartDatePicker).sendKeys(delayTime);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		System.out.println("date added ");
		Thread.sleep(3000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(3000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();// need to check with sumit sir
		driver.findElement(delayReasonOp).click();
		Thread.sleep(3000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(8000);

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(5000);
		String task = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		System.out.println("first task start date " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		System.out.println("first task end date " + vsbEndDate);

		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		driver.findElement(CloseButton).click();

		driver.findElement(refreshbutton).click();
		Thread.sleep(4000);

		act.moveToElement(driver.findElement(secTask)).build().perform();
		Thread.sleep(2000);
		String sectask = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String secTaskarr1[] = sectask.split("Start : ");
		String secTaskarr2[] = secTaskarr1[1].split("End : ");
		String secTaskStart_date = secTaskarr2[0].replaceAll("\n", "");
		secTaskStart_date = secTaskStart_date.replace(" ", "");
		System.out.println("next task start date " + secTaskStart_date);
		String secTaskEndDate = secTaskarr2[1].replace(" ", "");
		System.out.println("next task end date " + secTaskEndDate);

		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		driver.findElement(CloseButton).click();
		Thread.sleep(4000);

		if (vsbEndDate.equalsIgnoreCase(secTaskStart_date)) {
			System.out.println("Linked Task is moving forward ");
			return true;
		} else {
			System.out.println("linked task is not moving forward ");
			return false;
		}

	}

	public boolean nextTaskTimeUpdAfterReset() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(refreshbutton).click();
		Thread.sleep(3000);
		System.out.println("test case reset for next task started ");
		driver.findElement(firsttask).click();
		Thread.sleep(4000);
		driver.findElement(ReSettask).click();
		Thread.sleep(2000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(8000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(2000);
		String task = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		System.out.println("first task start date " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		System.out.println("first task end date " + vsbEndDate);

		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		driver.findElement(CloseButton).click();
		Thread.sleep(2000);
		driver.findElement(refreshbutton).click();
		Thread.sleep(4000);

		act.moveToElement(driver.findElement(secTask)).build().perform();
		Thread.sleep(2000);
		String sectask = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String secTaskarr1[] = sectask.split("Start : ");
		String secTaskarr2[] = secTaskarr1[1].split("End : ");
		String secTaskStart_date = secTaskarr2[0].replaceAll("\n", "");
		secTaskStart_date = secTaskStart_date.replace(" ", "");
		System.out.println("next task start date " + secTaskStart_date);
		String secTaskEndDate = secTaskarr2[1].replace(" ", "");
		System.out.println("next task end date " + secTaskEndDate);

		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		driver.findElement(CloseButton).click();
		driver.findElement(refreshbutton).click();
		Thread.sleep(4000);

		if (vsbEndDate.equalsIgnoreCase(secTaskStart_date)) {
			System.out.println("Linked Task is moving backward ");
			return true;
		} else {
			System.out.println("linked task is not moving backward ");
			return false;
		}

	}

	public boolean nextTaskTimeUpdWithDelayClose() throws InterruptedException {
		System.out.println("test case 48 started ");
		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(2000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(8000);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(markAsCompleteoption).click();
		System.out.println("mark as acomplete option is clicked ");
		Thread.sleep(2000);

		driver.findElement(delayCloseDatePicker).sendKeys(delayCloseTime);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		System.out.println("date added ");
		driver.findElement(markAsCompleteButton).click();
		System.out.println("mark as complete button clicked ");
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(8000);

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(2000);
		String task = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		System.out.println("first task start date " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		System.out.println("first task end date " + vsbEndDate);

		driver.findElement(firsttask).click();
		driver.findElement(CloseButton).click();
		Thread.sleep(2000);
		driver.findElement(refreshbutton).click();
		Thread.sleep(4000);

		act.moveToElement(driver.findElement(secTask)).build().perform();
		Thread.sleep(2000);
		String sectask = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String secTaskarr1[] = sectask.split("Start : ");
		String secTaskarr2[] = secTaskarr1[1].split("End : ");
		String secTaskStart_date = secTaskarr2[0].replaceAll("\n", "");
		secTaskStart_date = secTaskStart_date.replace(" ", "");
		System.out.println("next task start date " + secTaskStart_date);
		String secTaskEndDate = secTaskarr2[1].replace(" ", "");
		System.out.println("next task end date " + secTaskEndDate);

		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		driver.findElement(CloseButton).click();
		Thread.sleep(4000);

		if (vsbEndDate.equalsIgnoreCase(secTaskStart_date)) {
			System.out.println("Linked Task is moving forward ");
			return true;
		} else {
			System.out.println("linked task is not moving forward ");
			return false;
		}
	}

	public boolean nextTaskTimeUpdWithEarlyStart() throws InterruptedException {
		System.out.println("test case 50 started ");

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(2000);
		try {
			driver.findElement(delayStartDatePicker).sendKeys(earlyStartTime);

			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(2000);
			System.out.println("date added ");
			Thread.sleep(3000);
			driver.findElement(starttaskbutton).click();
			Thread.sleep(1000);
			try {
				earlyStartTstrMsgValue = driver.findElement(earlyStartToasterMsgEle).getText();
				return true;
			} catch (Exception e) {

			}

			System.out.println("start button is clicked ");
			Thread.sleep(7000);
			driver.findElement(delayStartReasonDD).click();
			System.out.println("delay reason selected ");
			Thread.sleep(3000);
//			driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
			driver.findElement(delayReasonOp).click();
			Thread.sleep(3000);
			driver.findElement(additonalCmt).sendKeys("Test");
			driver.findElement(logDelayButton).click();
			Thread.sleep(8000);
		} catch (Exception e) {
			driver.findElement(CloseButton).click();
			driver.findElement(CloseButton).click();
		}

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(2000);
		String task = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		System.out.println("first task start date " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		System.out.println("first task end date " + vsbEndDate);

		driver.findElement(firsttask).click();
		driver.findElement(CloseButton).click();
		Thread.sleep(2000);
		driver.findElement(refreshbutton).click();
		Thread.sleep(4000);

		act.moveToElement(driver.findElement(secTask)).build().perform();
		Thread.sleep(5000);
		String sectask = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String secTaskarr1[] = sectask.split("Start : ");
		String secTaskarr2[] = secTaskarr1[1].split("End : ");
		String secTaskStart_date = secTaskarr2[0].replaceAll("\n", "");
		secTaskStart_date = secTaskStart_date.replace(" ", "");
		System.out.println("next task start date " + secTaskStart_date);
		String secTaskEndDate = secTaskarr2[1].replace(" ", "");
		System.out.println("next task end date " + secTaskEndDate);

		driver.findElement(firsttask).click();
		driver.findElement(CloseButton).click();
		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		driver.findElement(CloseButton).click();
		Thread.sleep(4000);

		if (vsbEndDate.equalsIgnoreCase(secTaskStart_date)) {
			System.out.println("Linked Task is moving backaward ");
			return true;
		} else {
			System.out.println("Linked task is not moving backaward ");
			return false;
		}

	}

	public boolean nextTaskTimeUpdWithEarlyClose() throws InterruptedException {
		System.out.println("test case 52 started ");
		driver.findElement(firsttask).click();
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(2000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(10000);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(markAsCompleteoption).click();
		System.out.println("mark as acomplete option is clicked ");
		Thread.sleep(2000);

		driver.findElement(delayCloseDatePicker).sendKeys(earlyClose);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		System.out.println("date added ");
		driver.findElement(markAsCompleteButton).click();
		System.out.println("mark as complete button clicked ");
		Thread.sleep(2000);

		try {
			earlyCloseTstrMsgValue = driver.findElement(earlyCloseToasterMsgEle).getText();
			return true;
		} catch (Exception e) {

		}

		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {

		}

		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(10000);

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(2000);
		String task = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		System.out.println("first task start date " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		System.out.println("first task end date " + vsbEndDate);

		driver.findElement(firsttask).click();
		driver.findElement(CloseButton).click();
		Thread.sleep(2000);
		driver.findElement(refreshbutton).click();
		Thread.sleep(4000);

		act.moveToElement(driver.findElement(secTask)).build().perform();
		Thread.sleep(5000);
		String sectask = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String secTaskarr1[] = sectask.split("Start : ");
		String secTaskarr2[] = secTaskarr1[1].split("End : ");
		String secTaskStart_date = secTaskarr2[0].replaceAll("\n", "");
		secTaskStart_date = secTaskStart_date.replace(" ", "");
		System.out.println("next task start date " + secTaskStart_date);
		String secTaskEndDate = secTaskarr2[1].replace(" ", "");
		System.out.println("next task end date " + secTaskEndDate);

		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		driver.findElement(CloseButton).click();
		Thread.sleep(4000);

		if (vsbEndDate.equalsIgnoreCase(secTaskStart_date)) {
			System.out.println("Linked Task is moving forward ");
			return true;
		} else {
			System.out.println("linked task is not moving forward ");
			return false;
		}
	}

	public boolean dragTaskForward() throws InterruptedException {

		try {
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
			Thread.sleep(6000);
			driver.findElement(refreshbutton).click();
			Thread.sleep(3000);
			System.out.println("test case reset for next task started ");
			driver.findElement(firsttask).click();
			Thread.sleep(4000);
			driver.findElement(ReSettask).click();
			Thread.sleep(2000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(8000);
		} catch (Exception e) {

		}
		driver.findElement(dayviewdd).click();
		Thread.sleep(1000);
		driver.findElement(dayView).click();
		Thread.sleep(5000);
		System.out.println("day view selected ");
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(5000);
		String task = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		System.out.println("first task start date " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		System.out.println("first task end date " + vsbEndDate);

		System.out.println("task drag started ");

		action.clickAndHold(driver.findElement(firsttask)).pause(Duration.ofSeconds(3)).moveByOffset(200, 0).release()
				.build().perform();
		Thread.sleep(3000);

		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(15000);

		action.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(3000);
		String afterDragtask = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String afterDragArr1[] = afterDragtask.split("Start : ");
		String afterDragArr2[] = afterDragArr1[1].split("End : ");
		String afterDragVsbStart_date = afterDragArr2[0].replaceAll("\n", "");
		afterDragVsbStart_date = afterDragVsbStart_date.replace(" ", "");
		taskStartTimeAfterDrag = afterDragVsbStart_date;
		System.out.println("first task start date " + afterDragVsbStart_date);
		String afterDragVsbEndDate = afterDragArr2[1].replace(" ", "");
		taskEndTimeAfterDrag = afterDragVsbEndDate;
		System.out.println("first task end date " + afterDragVsbEndDate);

		if (vsbStart_date.equalsIgnoreCase(afterDragVsbStart_date)
				&& vsbEndDate.equalsIgnoreCase(afterDragVsbEndDate)) {
			System.out.println("Task is not draged forward ");
			return false;
		} else {
			System.out.println("Task is draged forward ");
			return true;
		}

	}

	public boolean triggerEnRAfterDrag() throws InterruptedException {
		System.out.println("test case 55 started ");
		boolean b = false;
		String actulaEnRStatus = null;

		driver.findElement(notificationIcon).click();
		System.out.println("notificationIcon clicked ");
		try {
			driver.findElement(enrTrigger).click();
			System.out.println("enrTrigger clicked ");
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("unable to triger the EnR");
			Thread.sleep(2000);
			driver.findElement(homepage).click();
			driver.findElement(microPlanning).click();
			Thread.sleep(2000);
			driver.findElement(plannerTab).click();
			driver.findElement(versionIcon).click();
			Thread.sleep(2000);
			return false;
		}

		Thread.sleep(2000);
		driver.findElement(homepage).click();
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
			return false;
		}

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
			b = true;
		}
		return b;
	}

	public boolean checkTaskTimingAfterEnR() throws InterruptedException {
		System.out.println("Task start time after dragging the task " + taskStartTimeAfterDrag);
		System.out.println("Task End time after dragging the task " + taskEndTimeAfterDrag);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(5000);
		String task = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_dateAfterEnR = arr2[0].replaceAll("\n", "");
		vsbStart_dateAfterEnR = vsbStart_dateAfterEnR.replace(" ", "");
		System.out.println("first task start time after EnR " + vsbStart_dateAfterEnR);
		String vsbEndDateAfterEnR = arr2[1].replace(" ", "");
		System.out.println("first task end time after EnR " + vsbEndDateAfterEnR);
		if (taskStartTimeAfterDrag.equals(vsbStart_dateAfterEnR)
				&& taskEndTimeAfterDrag.equalsIgnoreCase(vsbEndDateAfterEnR)) {

			System.out.println(
					"After Drag Start time and End timem is matched with after EnR trigger start time and end time");
			return true;
		} else {
			System.out.println(
					"After Drag Start time and End timem is not matched with after EnR trigger start time and end time");
			return false;

		}

	}

	public boolean verifyUserCanAddCmtInSideTaskTest() throws InterruptedException {
		driver.findElement(sideTask).click();
		Thread.sleep(1000);
		driver.findElement(cmtBtn).click();
		Thread.sleep(1000);
		driver.findElement(cmtSec).sendKeys("Test");
		driver.findElement(saveCmtBtn).click();
		Thread.sleep(9000);
		driver.findElement(sideTask).click();
		Thread.sleep(1000);
		String addedCmt;
		try {
			addedCmt = driver.findElement(commentField).getText();
		} catch (Exception e) {
			return false;
		}
		System.out.println("added comment is " + addedCmt);
		if ((addedCmt).equals("Comments : Test")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanTakeActionOnSideTaskPostCloseTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(sideTaskButton).click();
		System.out.println("side task button is clicked ");
		Thread.sleep(3000);
		driver.findElement(sideTaskDropDown).click();
		System.out.println("side task drop down is clicked ");
		Thread.sleep(2000);
		driver.findElement(sideTaskType).click();
		System.out.println("side task type is selected ");
		Thread.sleep(3000);
		driver.findElement(addSideTask).click();
		Thread.sleep(2000);
		driver.findElement(sideTaskButton).click();
		Thread.sleep(2000);

		driver.findElement(sideTask).click();
		System.out.println("side task info pop-up is opened ");
		Thread.sleep(4000);
		driver.findElement(markAsCompleteoption).click();
		Thread.sleep(9000);
		driver.findElement(sideTask).click();
		Thread.sleep(2000);
		try {
			driver.findElement(sideTaskActionBtns).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyFuncOfShowMOCBtnTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		try {
			driver.findElement(CloseButton).click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		Thread.sleep(1000);
		driver.findElement(showMOCCheckBox).click();
		Thread.sleep(1000);
		boolean b = false;
		List<WebElement> opAlocCountEle = driver.findElements(opAllocationCount);
		for (WebElement opAlocEls : opAlocCountEle) {
			System.out.println(opAlocEls.getText());
			b = opAlocEls.isDisplayed();
		}
		return b;
	}

	public boolean verifyFirstTaskNameInENGLangTest() throws InterruptedException {
		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		String firstTaskNameInVsbV = driver.findElement(firstTaskNameInVsb).getText().replace(" ", "");
		driver.findElement(CloseButton).click();
		Thread.sleep(2000);
		if (firstTaskNameInVsbV.equals("Task" + firstTaskName)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheFuncOfZoomInTest() throws InterruptedException {
		navigateTo.VSB();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		String gridSizeBeforeZoomIn = driver.findElement(gridSize).getText();
		System.out.println("grid size before zoom out " + gridSizeBeforeZoomIn);
		driver.findElement(zoomIn).click();
		Thread.sleep(5000);
		String gridSizeAfterZoomIn = driver.findElement(gridSize).getText();
		System.out.println("grid size after zoom in " + gridSizeAfterZoomIn);
		if (gridSizeBeforeZoomIn != gridSizeAfterZoomIn) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTheFuncOfZoomOutTest() throws InterruptedException {
		String gridSizeBeforeZoomOut = driver.findElement(gridSize).getText();
		System.out.println("grid size before zoom out " + gridSizeBeforeZoomOut);
		driver.findElement(zoomOut).click();
		Thread.sleep(5000);
		String gridSizeAfterZoomOut = driver.findElement(gridSize).getText();
		if (gridSizeBeforeZoomOut != gridSizeAfterZoomOut) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAlertNotificationInIdleStateTest() {
		try {
			driver.findElement(firsttask).click();
			driver.findElement(ReSettask).click();
			Thread.sleep(2000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(10000);
		} catch (Exception e) {
			driver.findElement(CloseButton).click();
		}
		driver.findElement(firsttask).click();
		try {
			driver.findElement(delayAlertInVsb).isDisplayed();
			driver.findElement(CloseButton).click();
			return false;
		} catch (Exception e) {
			driver.findElement(CloseButton).click();
			return true;
		}
	}

	public boolean verifyResetFuncAfterDelayStartAndNormalCloseTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(task_Date);
		Thread.sleep(5000);
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(2000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(8000);

		System.out.println("expected details capturing started ");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(2000);
		expTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);
		System.out.println("expected task details are " + expTaskDetails);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(1000);
		driver.findElement(delayStartDatePicker).sendKeys(delayTime);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		System.out.println("date added ");
		Thread.sleep(2000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();// need to check with sumit sir
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(9000);

		driver.findElement(firsttask).click();
		driver.findElement(markAsCompleteoption).click();
		driver.findElement(markAsCompleteButton).click();
		Thread.sleep(8000);

		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(2000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(8000);

		System.out.println("Actual details capturing started ");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(2000);
		String actulTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(2000);
		System.out.println("Actual task details are " + actulTaskDetails);

		if (expTaskDetails.equalsIgnoreCase(actulTaskDetails)) {
			System.out.println("expected task details matched with actual task details ");
			return true;
		} else {
			System.out.println("expected task details are not matched with actual task details ");
			return false;
		}

	}

	public boolean verifyUserCanStartTheTaskAfterDragTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(zoomIn).click();
		Thread.sleep(2000);
		driver.findElement(secTask).click();
		Thread.sleep(1000);
		driver.findElement(CloseButton).click();
		Thread.sleep(1000);

		try {
			driver.findElement(firsttask).click();
			driver.findElement(ReSettask).click();
			Thread.sleep(2000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(8000);

		} catch (Exception e) {

		}

		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(firsttask)).pause(Duration.ofSeconds(3)).moveByOffset(200, 0).release()
				.build().perform();

		Thread.sleep(6000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(10000);
		driver.findElement(firsttask).click();
		System.out.println("firstTaskClicked");
		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		System.out.println("Start task clicked from popup");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("Task started");
		Thread.sleep(500);
		driver.findElement(inProgresToaster).isDisplayed();
		String toasterMessage = driver.findElement(inProgresToaster).getText();
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(10000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanCloseTheTaskAfterDragTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);

		driver.findElement(firsttask).click();
		System.out.println("firstTaskClicked");
		Thread.sleep(1000);
		driver.findElement(markAsCompleteoption).click();
		driver.findElement(markAsCompleteButton).click();
		String toasterMessage = "null";
		try {
			driver.findElement(actionToaster).isDisplayed();
			toasterMessage = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(8000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyRestartFunctionalityAfterDragTest() throws InterruptedException {
		Actions act = new Actions(driver);
		System.out.println("Expected task details capturing started ");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		expTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);

		driver.findElement(firsttask).click();
		driver.findElement(Restarttask).click();
		Thread.sleep(8000);
		System.out.println("Actual task details capturing started after restart");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		String actualTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		if (expTaskDetailsAfterRestart.equalsIgnoreCase(actualTaskDetailsAfterRestart)) {
			System.out.println(
					"Expected task details are matched with actual task details hence Restart functionality is working as expected with normal start and normal close");
			return true;
		} else {
			System.out.println(
					"Expected task details are not matched with actual task details hence Restart functionality with normal start and normal close is failed ");

			return false;
		}
	}

	public boolean verifyResetFunctionalityAfterDragTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(2000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(9000);
		System.out.println("expected details capturing started ");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(2000);
		expTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);
		System.out.println("expected task details are " + expTaskDetails);

		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);

		driver.findElement(secTask).click();
		Thread.sleep(1000);
		driver.findElement(CloseButton).click();
		Thread.sleep(1000);
		act.clickAndHold(driver.findElement(firsttask)).pause(Duration.ofSeconds(3)).moveByOffset(200, 0).release()
				.build().perform();

		Thread.sleep(3000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(9000);
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(2000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(8000);

		System.out.println("Actual details capturing started ");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		String actulTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);
		System.out.println("Actual task details are " + actulTaskDetails);

		if (expTaskDetails.equalsIgnoreCase(actulTaskDetails)) {
			System.out.println("expected task details matched with actual task details ");
			return true;
		} else {
			System.out.println("expected task details are not matched with actual task details ");
			return false;
		}
	}

	public boolean verifyResetFunctionalityWithNormalStartAndDelayFinishTest() throws InterruptedException {

		driver.findElement(firsttask).click();
		System.out.println("firstTaskClicked");
		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		System.out.println("Start task clicked from popup");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("Task started");

		Thread.sleep(6000);

		Actions act = new Actions(driver);
		System.out.println("Expected task details capturing started ");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		expTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();
		Thread.sleep(3000);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(markAsCompleteoption).click();
		System.out.println("mark as acomplete option is clicked ");
		Thread.sleep(2000);

		driver.findElement(delayCloseDatePicker).sendKeys(delayCloseTime);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		System.out.println("date added ");
		driver.findElement(markAsCompleteButton).click();
		System.out.println("mark as complete button clicked ");
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(10000);
		System.out.println("Expected task details are " + expTaskDetails);

		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(2000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(8000);

		System.out.println("Actual task details capturing started after restart");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		String actualTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		if (expTaskDetailsAfterRestart.equalsIgnoreCase(actualTaskDetailsAfterRestart)) {
			System.out.println(
					"Expected task details are matched with actual task details hence Restart functionality is working as expected with normal start and Delay close");
			return true;
		} else {
			System.out.println(
					"Expected task details are not matched with actual task details hence Restart functionality with normal start and Delay close is failed ");

			return false;
		}

	}

	public boolean verifyUserCanCloseTheTaskByDragTest() throws InterruptedException {
		System.out.println("Test case 71 started ");
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		try {

			driver.findElement(firsttask).click();
			System.out.println("Task info popup is displayed");
			Thread.sleep(1000);
			driver.findElement(ReSettask).click();
			System.out.println("Reset button clicked");
			Thread.sleep(1000);
			driver.findElement(ReSetButton).click();
			System.out.println("Reset alert accetped");
			Thread.sleep(9000);

		} catch (Exception e) {
			driver.findElement(closeBtnStartBtn).click();
			System.out.println("closeBtnStartBtn is clicked ");
			Thread.sleep(5000);
		}

		driver.findElement(firsttask).click();
		System.out.println("firstTaskClicked");
		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		System.out.println("Start task clicked from popup");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("Task started");
		Thread.sleep(6000);

		Actions actions = new Actions(driver);
		actions.clickAndHold(driver.findElement(elementToDrag)).pause(Duration.ofSeconds(3)).moveByOffset(200, 0)
				.release().build().perform();
		Thread.sleep(5000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		driver.findElement(actionToaster).isDisplayed();
		String toasterMessage = driver.findElement(actionToaster).getText();
		Thread.sleep(8000);
		System.out.println("Toaster is captured  " + toasterMessage);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyRestartFuncAfterDelayCloseByDragTest() throws InterruptedException {
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(2000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(9000);
		driver.findElement(firsttask).click();
		System.out.println("firstTaskClicked");
		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		System.out.println("Start task clicked from popup");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("Task started");
		Thread.sleep(9000);
		System.out.println("expected details capturing started ");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(3000);
		expTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(4000);
		System.out.println("expected task details are " + expTaskDetails);

		act.moveToElement(driver.findElement(refreshbutton)).build().perform();
		Thread.sleep(2000);
		driver.findElement(refreshbutton).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(secTask).click();
		Thread.sleep(1000);
		driver.findElement(CloseButton).click();
		Thread.sleep(3000);
		act.clickAndHold(driver.findElement(elementToDrag)).pause(Duration.ofSeconds(3)).moveByOffset(130, 0).release()
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(9000);

		driver.findElement(firsttask).click();
		driver.findElement(Restarttask).click();
		Thread.sleep(8000);
		System.out.println("Actual task details capturing started after restart");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		String actualTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		if (expTaskDetailsAfterRestart.equalsIgnoreCase(actualTaskDetailsAfterRestart)) {
			System.out.println(
					"Expected task details are matched with actual task details hence Restart functionality is working as expected with normal start and delay close By drag ");
			return true;
		} else {
			System.out.println(
					"Expected task details are not matched with actual task details hence Restart functionality with normal start and delay  close By drag is failed ");
			return false;
		}

	}

	public boolean verifyResetFuncAfterDelayCloseByDragTest() throws InterruptedException {
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(8000);

		System.out.println("expected details capturing started ");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(2000);
		expTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(1000);
		System.out.println("expected task details are " + expTaskDetails);

		driver.findElement(firsttask).click();
		System.out.println("firstTaskClicked");
		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		System.out.println("Start task clicked from popup");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("Task started");
		Thread.sleep(6000);

		act.clickAndHold(driver.findElement(elementToDrag)).pause(Duration.ofSeconds(3)).moveByOffset(130, 0).release()
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(8000);

		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);

		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(8000);

		System.out.println("Actual task details capturing started after restart");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(2000);
		String actualTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		if (expTaskDetailsAfterRestart.equalsIgnoreCase(actualTaskDetailsAfterRestart)) {
			System.out.println(
					"Expected task details are matched with actual task details hence Restart functionality is working as expected with normal start and delay close By drag ");
			return true;
		} else {
			System.out.println(
					"Expected task details are not matched with actual task details hence Restart functionality with normal start and delay  close By drag is failed ");
			return false;
		}
	}

	public boolean verifyUserCanCloseTaskEarlyTest() throws InterruptedException {
		driver.findElement(firsttask).click();
		System.out.println("firstTaskClicked");
		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		System.out.println("Start task clicked from popup");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("Task started");
		Thread.sleep(6000);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(markAsCompleteoption).click();
		System.out.println("mark as acomplete option is clicked ");
		Thread.sleep(2000);

		driver.findElement(delayCloseDatePicker).sendKeys(earlyClose);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		System.out.println("date added ");
		driver.findElement(markAsCompleteButton).click();
		System.out.println("mark as complete button clicked ");
		Thread.sleep(2000);

		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {

		}

		try {
			earlyCloseTstrMsgValue = driver.findElement(earlyCloseToasterMsgEle).getText();
			return true;
		} catch (Exception e) {

		}

		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(1000);
		driver.findElement(actionToaster).isDisplayed();
		String toasterMessage = driver.findElement(actionToaster).getText();
		Thread.sleep(8000);
		System.out.println("Toaster is captured  " + toasterMessage);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyRestartFuncAfterEarlyCloseTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		if (earlyCloseTstrMsgValue.equals("Can not close task in non working hours!")) {
			return true;
		}

		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);

		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(9000);

		driver.findElement(firsttask).click();
		System.out.println("firstTaskClicked");
		Thread.sleep(2000);
		driver.findElement(starttaskoption).click();
		System.out.println("Start task clicked from popup");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("Task started");
		Thread.sleep(9000);

		System.out.println("expected details capturing started ");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(2000);
		expTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(1000);
		System.out.println("expected task details are " + expTaskDetails);

		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		System.out.println("first task is clicked ");
		driver.findElement(markAsCompleteoption).click();
		System.out.println("mark as acomplete option is clicked ");
		Thread.sleep(2000);

		driver.findElement(delayCloseDatePicker).sendKeys(earlyClose);

		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		System.out.println("date added ");
		driver.findElement(markAsCompleteButton).click();

		System.out.println("mark as complete button clicked ");
		Thread.sleep(2000);

		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {

		}

		try {
			earlyCloseTstrMsgValue = driver.findElement(earlyCloseToasterMsgEle).getText();
			return true;
		} catch (Exception e) {

		}

		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(7000);
		driver.findElement(firsttask).click();
		driver.findElement(Restarttask).click();
		Thread.sleep(9000);
		System.out.println("Actual task details capturing started after restart");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(4000);
		String actualTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		if (expTaskDetailsAfterRestart.equalsIgnoreCase(actualTaskDetailsAfterRestart)) {
			System.out.println(
					"Expected task details are matched with actual task details hence Restart functionality is working as expected with normal start and delay close By drag ");
			return true;
		} else {
			System.out.println(
					"Expected task details are not matched with actual task details hence Restart functionality with normal start and delay  close By drag is failed ");
			return false;
		}

	}

	public boolean verifyResetFuncAfterEarlyCloseTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(5000);
		driver.findElement(zoomIn).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(5000);
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(9000);

		System.out.println("expected details capturing started ");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(2000);
		expTaskDetails = driver.findElement(taskTollTip).getText();
		Thread.sleep(1000);
		System.out.println("expected task details are " + expTaskDetails);

		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(5000);
		driver.findElement(firsttask).click();

		System.out.println("firstTaskClicked");
		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		System.out.println("Start task clicked from popup");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("Task started");
		Thread.sleep(8000);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(markAsCompleteoption).click();
		System.out.println("mark as acomplete option is clicked ");
		Thread.sleep(2000);

		driver.findElement(delayCloseDatePicker).sendKeys(earlyClose);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		System.out.println("date added ");
		driver.findElement(markAsCompleteButton).click();
		System.out.println("mark as complete button clicked ");
		Thread.sleep(2000);

		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {

		}

		try {
			earlyCloseTstrMsgValue = driver.findElement(earlyCloseToasterMsgEle).getText();
			return true;
		} catch (Exception e) {

		}

		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();

		Thread.sleep(7000);

		driver.findElement(elementToDrag).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(9000);

		System.out.println("Actual task details capturing started after restart");
		act.moveToElement(driver.findElement(firsttask)).build().perform();
		Thread.sleep(3000);
		String actualTaskDetailsAfterRestart = driver.findElement(taskTollTip).getText();

		if (expTaskDetails.equalsIgnoreCase(actualTaskDetailsAfterRestart)) {
			System.out.println(
					"Expected task details are matched with actual task details hence Restart functionality is working as expected with normal start and delay close By drag ");
			return true;
		} else {
			System.out.println(
					"Expected task details are not matched with actual task details hence Restart functionality with normal start and delay  close By drag is failed ");
			return false;
		}

	}

	public boolean verifyUserCanExtendTheTaskDurationTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(secTask).click();
		driver.findElement(CloseButton).click();
		Actions act = new Actions(driver);
		act.clickAndHold(driver.findElement(elementToDrag)).pause(Duration.ofSeconds(3)).moveByOffset(130, 0).release()
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();

		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(actionToaster).getText();
			System.out.println("Toaster is captured  " + toasterMessage);
		} catch (Exception e) {

		}
		Thread.sleep(8000);
		if (toasterMessage.equals("Log delay updated successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAlertMessagPostDurationChnageTest() throws InterruptedException {
		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		try {
			driver.findElement(delayAlertInVsb).isDisplayed();
			driver.findElement(CloseButton).click();
			return true;
		} catch (Exception e) {
			driver.findElement(CloseButton).click();
			return false;
		}
	}

	public boolean verifyUserCanStartTheTaskPostDurationChnageTest() throws InterruptedException {

		try {
			driver.findElement(firsttask).click();
			System.out.println("firstTaskClicked");
			driver.findElement(ReSettask).click();
			Thread.sleep(1000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(9000);
		} catch (Exception e) {

		}

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);

		driver.findElement(firsttask).click();
		System.out.println("firstTaskClicked");
		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		System.out.println("Start task clicked from popup");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		Thread.sleep(1000);
		System.out.println("Task started");
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(actionToaster).getText();

			System.out.println("Toaster is captured  " + toasterMessage);
		} catch (Exception e) {

		}
		Thread.sleep(8000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanCloseTheTaskPostDurationChnageTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);

		driver.findElement(firsttask).click();
		System.out.println("firstTaskClicked");
		Thread.sleep(1000);
		driver.findElement(markAsCompleteoption).click();
		driver.findElement(markAsCompleteButton).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			driver.findElement(actionToaster).isDisplayed();
			toasterMessage = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(8000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanRestartTheTaskPostDurationChnageTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(task_Date);
		Thread.sleep(5000);

		driver.findElement(firsttask).click();
		driver.findElement(Restarttask).click();
		String toasterMessage = "null";
		Thread.sleep(1000);
		try {
			driver.findElement(actionToaster).isDisplayed();
			toasterMessage = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(8000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanResetTheTaskPostDurationChnageTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(5000);

		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			toasterMessage = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(8000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanStartTheTaskWithDelayPostDurationChangeTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(task_Date);
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.clickAndHold(driver.findElement(elementToDrag)).pause(Duration.ofSeconds(3)).moveByOffset(130, 0).release()
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(8000);
		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(2000);
		driver.findElement(delayStartDatePicker).sendKeys(delayTime);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		System.out.println("date added ");
		Thread.sleep(3000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(3000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();// need to check with sumit sir
		driver.findElement(delayReasonOp).click();
		Thread.sleep(3000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			driver.findElement(actionToaster).isDisplayed();
			toasterMessage = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(8000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanCloseTheTaskWithDelayPostDurationChangeTest() throws InterruptedException {
		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(markAsCompleteoption).click();
		System.out.println("mark as acomplete option is clicked ");
		Thread.sleep(2000);

		driver.findElement(delayCloseDatePicker).sendKeys(delayCloseTime);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		System.out.println("date added ");
		driver.findElement(markAsCompleteButton).click();
		System.out.println("mark as complete button clicked ");
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();

		String toasterMessage = "null";
		Thread.sleep(1000);
		try {
			driver.findElement(actionToaster).isDisplayed();
			toasterMessage = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(8000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanResetTheTaskPostDelayStartAndDelayCloseTest() throws InterruptedException {
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		String toasterMessage = "null";
		Thread.sleep(1000);
		try {
			driver.findElement(actionToaster).isDisplayed();
			toasterMessage = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(8000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanStartTheTaskEarlyPostDurationChangeTest() throws InterruptedException {
		Actions act = new Actions(driver);
		act.clickAndHold(driver.findElement(elementToDrag)).pause(Duration.ofSeconds(3)).moveByOffset(130, 0).release()
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(8000);
		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(2000);
		driver.findElement(delayStartDatePicker).sendKeys(earlyStartTime);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		System.out.println("date added ");
		Thread.sleep(3000);
		driver.findElement(starttaskbutton).click();

		try {
			earlyStartTstrMsgValue = driver.findElement(earlyStartToasterMsgEle).getText();
			return true;
		} catch (Exception e) {

		}

		System.out.println("start button is clicked ");
		Thread.sleep(3000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();// need to check with sumit sir
		driver.findElement(delayReasonOp).click();
		Thread.sleep(3000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			driver.findElement(actionToaster).isDisplayed();
			toasterMessage = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(8000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanCloseTheTaskEarlyPostDurationChangeTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(task_Date);
		Thread.sleep(4000);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(markAsCompleteoption).click();
		System.out.println("mark as acomplete option is clicked ");
		Thread.sleep(2000);

		driver.findElement(delayCloseDatePicker).sendKeys(delayCloseTime);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		System.out.println("date added ");
		driver.findElement(markAsCompleteButton).click();
		System.out.println("mark as complete button clicked ");
		Thread.sleep(1000);

		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {

		}

		try {
			earlyCloseTstrMsgValue = driver.findElement(earlyCloseToasterMsgEle).getText();
			return true;
		} catch (Exception e) {

		}

		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(1000);
		String toasterMessage = "null";
		try {
			driver.findElement(actionToaster).isDisplayed();
			toasterMessage = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(8000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanResetTheTaskPostEarlyStartAndCloseTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(task_Date);
		Thread.sleep(4000);
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		System.out.println("reset task is done ");
		String toasterMessage = "null";
		Thread.sleep(1000);
		try {
			driver.findElement(actionToaster).isDisplayed();
			toasterMessage = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(8000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyDragFrwdAndBacawardTest() throws InterruptedException {

		try {
			driver.navigate().refresh();
			Thread.sleep(4000);
			driver.findElement(DateBox).sendKeys(task_Date);
			Thread.sleep(4000);
			driver.findElement(firsttask).click();
			driver.findElement(ReSettask).click();
			Thread.sleep(1000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			Thread.sleep(9000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(5000);

		Actions act = new Actions(driver);
		act.clickAndHold(driver.findElement(firsttask)).pause(Duration.ofSeconds(3)).moveByOffset(130, 0).release()
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(9000);

		act.clickAndHold(driver.findElement(firsttask)).pause(Duration.ofSeconds(3)).moveByOffset(-130, 0).release()
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(yesBtn).click();
		String toasterMessage = "null";
		Thread.sleep(1000);
		try {
			driver.findElement(actionToaster).isDisplayed();
			toasterMessage = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(9000);
		if (toasterMessage.equals("Log delay successfully edited!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanStartPostDragBackwardTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(firsttask).click();
		System.out.println("firstTaskClicked");
		Thread.sleep(1000);
		driver.findElement(starttaskoption).click();
		System.out.println("Start task clicked from popup");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		System.out.println("Task started");
		Thread.sleep(500);
		driver.findElement(inProgresToaster).isDisplayed();
		String toasterMessage = driver.findElement(inProgresToaster).getText();
		System.out.println("Toaster is captured  " + toasterMessage);
		Thread.sleep(10000);
		if (toasterMessage.equals("Task status updated successfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanEditLogDelayTest() throws InterruptedException {
		driver.findElement(firsttask).click();
		driver.findElement(ReSettask).click();
		Thread.sleep(1000);
		System.out.println("reset is clicked ");
		driver.findElement(ReSetButton).click();
		Thread.sleep(8000);
		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(2000);
		driver.findElement(delayStartDatePicker).sendKeys(delayTime);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		System.out.println("date added ");
		Thread.sleep(3000);
		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(3000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();// need to check with sumit sir
		driver.findElement(delayReasonOp).click();
		Thread.sleep(3000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(8000);
		driver.findElement(firsttask).click();
		Thread.sleep(2000);
		driver.findElement(logDelayEditIcon).click();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).clear();
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(updateDelay).click();
		Thread.sleep(4000);
		driver.findElement(firsttask).click();
		Thread.sleep(2000);
		driver.findElement(logDelayEditIcon).click();
		Thread.sleep(1000);
		String addedCmt = driver.findElement(additonalCmt).getAttribute("value");
		System.out.println("Added cmt is " + addedCmt);
		if (addedCmt.equals("Test")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanSeePlanedTaskAfterClickingOnBasePlanTest() throws InterruptedException {
		try {
			driver.findElement(CloseButton).click();
		} catch (Exception e) {

		}
		Thread.sleep(3000);
		navigateTo.LattestPublishedPlan();
		Thread.sleep(2000);
		driver.findElement(baseLineCheckBox).click();
		Thread.sleep(2000);
		navigateTo.VSB();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(firsttask).click();
		Thread.sleep(4000);
		try {
			driver.findElement(featureBtn).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyUserCanSeePlannedTaskAfterClickingOnBasePlanFalseTest() throws InterruptedException {
		try {
			driver.findElement(CloseButton).click();
		} catch (Exception e) {

		}
		Thread.sleep(3000);
		navigateTo.LattestPublishedPlan();
		Thread.sleep(2000);
		driver.findElement(baseLineCheckBox).click();
		Thread.sleep(2000);
		navigateTo.VSB();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(firsttask).click();
		Thread.sleep(4000);
		try {
			driver.findElement(featureBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanDoEquipmentDownByAddingFromAndToDateTest() throws InterruptedException {
		try {
			driver.findElement(CloseButton).click();
		} catch (Exception e) {

		}
		driver.findElement(firsttask).click();
		System.out.println("Task info window is opened for testcase 24 ");
		Thread.sleep(1000);
		driver.findElement(assetStatusOption).click();
		System.out.println("asse status option is clicked");
		Thread.sleep(500);
		driver.findElement(selectEqButon).click();
		System.out.println("equipment button is clicked ");
		Thread.sleep(1000);
		driver.findElement(selectEqOpt).click();
		Thread.sleep(1000);
		System.out.println("equipment is selected ");
		driver.findElement(selectReasonButton).click();
		System.out.println("reason button is clicked ");
		String reson = driver.findElement(selectReasonOp).getText();
		driver.findElement(selectReasonOp).click();
		System.out.println(reson);
		System.out.println("reason is selected ");
		driver.findElement(selectTime).sendKeys(eqUnAvlDate);
		Thread.sleep(1000);
		driver.findElement(eqUnAvlToDateEle).sendKeys(eqUnAvlToDate);
		System.out.println("data selected ");
		driver.findElement(logAssetButton).click();
		System.out.println("asset added ");
		try {
			driver.findElement(assetToasterMessage).isDisplayed();
			String tostMsg = driver.findElement(assetToasterMessage).getText();
			System.out.println("Toaster is capture " + tostMsg);
			System.out.println("asset down added ");
			return true;
		} catch (Exception e) {
			System.out.println("asset alert is not displayed ");
			driver.findElement(eqCloseBtn).click();
			return false;
		}
	}

	public boolean logEventFuncForEqDownTest() throws InterruptedException {
		navigateTo.VSB();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(logEventIcon).click();
		Thread.sleep(2000);
		driver.findElement(chooseCategoryDD).click();
		Thread.sleep(1000);
		driver.findElement(eqUnAvlOp).click();
		Thread.sleep(1000);
		driver.findElement(selectResourceDD).click();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(EventProperties.equipmentName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[.=' " + EventProperties.equipmentName + " '])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(selectEqDownResonDD).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.=' " + EventProperties.assetDownReason + " ']")).click();
		Thread.sleep(1000);
		driver.findElement(selectTime).sendKeys(eqUnAvlDate);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		System.out.println("date added ");
		actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		driver.findElement(addLogEventBtn).click();
		String tstrMsg = "null";
		Thread.sleep(500);
		try {
			tstrMsg = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("alert message is *" + tstrMsg + "*");
		if (tstrMsg.equals("Asset status updated!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanDeleteEqDownFromLogEventTest() throws InterruptedException {
		navigateTo.VSB();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(logEventIcon).click();
		Thread.sleep(2000);
		driver.findElement(summaryTab).click();
		Thread.sleep(1000);
		driver.findElement(deleteEqUnAvl).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		String tstrMsg = "null";
		Thread.sleep(2000);
		try {
			tstrMsg = driver.findElement(actionToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("alert message is *" + tstrMsg + "*");
		if (tstrMsg.equals("Equipment Unavailability deleted successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanEditTheAssetDownLogByAddingEndDateTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		navigateTo.VSB();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(logEventIcon).click();
		Thread.sleep(2000);
		driver.findElement(chooseCategoryDD).click();
		Thread.sleep(1000);
		driver.findElement(eqUnAvlOp).click();
		Thread.sleep(1000);
		driver.findElement(selectResourceDD).click();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(EventProperties.equipmentName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[.=' " + EventProperties.equipmentName + " '])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(selectEqDownResonDD).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.=' " + EventProperties.assetDownReason + " ']")).click();
		Thread.sleep(1000);
		driver.findElement(selectTime).sendKeys(EventProperties.task_Date);

		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
		actions.sendKeys(Keys.ARROW_UP).build().perform();

//		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
//		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
//		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
//		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
//		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		driver.findElement(addLogEventBtn).click();
		Thread.sleep(6000);
		driver.findElement(logEventIcon).click();
		Thread.sleep(2000);
		driver.findElement(summaryTab).click();
		Thread.sleep(1000);
		driver.findElement(editEqUnAvl).click();
		Thread.sleep(1000);

		try {
			driver.findElement(eqUnAvlEndDateAlert).sendKeys(EventProperties.task_Date);
			Thread.sleep(2000);

			actions.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(500);
			actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
			Thread.sleep(500);
			actions.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(500);
			actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
			Thread.sleep(500);
			actions.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(500);

			actions.sendKeys(Keys.ARROW_LEFT).build().perform();
			actions.sendKeys(Keys.ARROW_LEFT).build().perform();
			actions.sendKeys(Keys.ARROW_LEFT).build().perform();
			actions.sendKeys(Keys.ARROW_LEFT).build().perform();
			actions.sendKeys(Keys.ARROW_UP).build().perform();
			actions.sendKeys(Keys.ARROW_UP).build().perform();

			System.out.println("data selected ");
			driver.findElement(upldateLogEvent).click();
			System.out.println("asset added ");
			driver.findElement(assetToasterMessage).isDisplayed();
			String tostMsg = driver.findElement(assetToasterMessage).getText();
			System.out.println("Toaster is capture " + tostMsg);
			System.out.println("asset down added ");
			return true;
		} catch (Exception e) {
			System.out.println("asset alert is not displayed ");
			return false;
		}

	}

	public void deleteEqDownFromAlertTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		try {
			navigateTo.VSB();
			Thread.sleep(4000);
			driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
			Thread.sleep(6000);
			driver.findElement(logEventIcon).click();
			Thread.sleep(2000);
			driver.findElement(summaryTab).click();
			Thread.sleep(1000);
			driver.findElement(deleteEqUnAvl).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
	}

	public boolean verifyAvlailabilityOfDelayAlertPostDragAndDropAndDelayStartTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(refreshbutton).click();
		Thread.sleep(3000);
		System.out.println("test case reset for next task started ");
		driver.findElement(firsttask).click();
		Thread.sleep(4000);
		try {
			driver.findElement(ReSettask).click();
			Thread.sleep(2000);
			System.out.println("reset is clicked ");
			driver.findElement(ReSetButton).click();
			System.out.println("reset task is done ");
			Thread.sleep(8000);
		} catch (Exception e) {

		}
		System.out.println("task drag started ");

		actions.clickAndHold(driver.findElement(firsttask)).pause(Duration.ofSeconds(3)).moveByOffset(200, 0).release()
				.build().perform();
		Thread.sleep(3000);

		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(logDelayButton).click();
		Thread.sleep(8000);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(starttaskoption).click();
		System.out.println("start option clicked ");
		Thread.sleep(1000);
		driver.findElement(delayStartDatePicker).sendKeys(delayTime);
		Thread.sleep(1000);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);

		driver.findElement(starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(3000);

		driver.findElement(yesBtnToEditExistingDelay).click();
		Thread.sleep(3000);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");

		try {
			driver.findElement(delayAlertInVsb).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
