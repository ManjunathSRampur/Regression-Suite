package com.qa.bps.pages;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;
import com.qa.bps.utils.ExcelUtil;

public class DailyOperatorManagement extends EventProperties {
	WebDriver driver;
	Navigation navigateTo;
	private By fields = By.xpath("//div[@class='product-section-individual-container card-body white-font']");
	private By productoverview = By.xpath("//button[contains(text(),'Product Overview')]");
	private By validation = By.xpath("//div[contains(text(),'Validation')]");
	private By startDate = By.xpath("//a[normalize-space()='Start Date']");
	private By endDate = By.xpath("//a[normalize-space()='End Date']");
	private By productionData = By.xpath("//div[@class='product-section-individual-container batch-details']");
	List<Object> campaign_ID_From_Excel = new ArrayList<Object>();
	boolean b;
	private By validationCheckBox = By.xpath("//input[@name='element_name']");
	private By checkBox = By.xpath("//div//input[@type='checkbox']");
	private By firstOperator = By.xpath("(//span[@class='allowBtn'])[1]");
	private By firstTG = By.xpath("(//div[@class='dhx_diagram_flow_shape dhx_item_shape '])[1]");

	ProductOverview pov;
	List<WebElement> chkboxList = new ArrayList<WebElement>();
	List<WebElement> cardList = new ArrayList<WebElement>();
	List<WebElement> labelList = new ArrayList<WebElement>();
	List<WebElement> LabelList = new ArrayList<WebElement>();
	List<WebElement> chkboxListAfterSelection = new ArrayList<WebElement>();
	List<WebElement> editIconList = new ArrayList<WebElement>();
	private By chklistValidation = By.xpath("//a[contains(text(),'Validated On')]");
	private By labelValidation = By.xpath("//div[contains(@class,'label-group smallText')]");
	private By editIcon = By.xpath("//a[contains(@title,'Edit')]");
	private By validatedTime = By.xpath("//input[contains(@placeholder,'From')]");
	private By checkMark = By.xpath("//i[contains(@class,'fa fa-check')]");
	private By divider = By.xpath("//div[@class='divider']");
	private By cardProduct = By.xpath("//div[@class='card-notransform']");
	private By menuIcon = By.cssSelector("div[class*='dropdown d']");
	private By IAM = By.xpath("(//img[@class='card-img-top'])[1]");
	private By iamSearchBox = By.xpath("//input[@placeholder='Search..']");
	private By userEditOption = By.xpath("(//div[@role='gridcell'])[7]");
	private By resetPassword = By.xpath("(//div[@class='tabulator-menu-item'])[3]");
	private By newPassword = By.id("newPassword");
	private By confirmPassword = By.id("confirmNewPassword");
	private By opEmail = By.xpath("(//div[@class='tabulator-cell'])[7]");
	private By saveBtn = By.xpath("(//button[contains(text(),'Save')])[3]");
	private By userNameinStudio = By.xpath("//div[@class='nav-link dropdown-toggle']");
	private By logout = By.xpath("//a[contains(text(),'Logout')]");

	private By byemailid = By.id("username");
	private By bypassword = By.id("txtPassword");
	private By byloginbtn = By.xpath("//button[.='SIGN IN']");
	private By datePickerinOperator = By.xpath("(//input[@placeholder='Date'])");
	private By ProductNameDrop = By.xpath("//select[@id='select']");
	private By batchDD = By.xpath("(//select)[2]");
	private By selectFirstBatch = By.xpath("((//select)[2]/option)[1]");
	private By startDD = By.xpath("(//button[@class='btn dropdown-toggle'])[2]");
	private By resetButton = By.xpath("(//a[.='Reset'])[1]");
	private By taskNameEle = By.xpath("(//div[@class='font-16 black-font bold'])[1]");
	private By msg = By.xpath("(//p[contains(@class,'msg')])[last()]");
	String msgUnderInfo;
	String op;
	String OpEmail;
	String firstTaskName;

	int bacthSizeExcel;

	private By validationDetails = By.xpath("//div[@class='product-section-individual-container batch-detailsval']");
	private ElementUtil eleUtil;
//----------------------------------Updated script Xpaths -------------------------------------------------------------

	private By BodheeIcon = By.xpath("//p[.='Bodhee Studio']");
	private By teamMangMtIcon = By.xpath("(//h6[.='Team Management']/following-sibling::div)[2]/div");
	private By opSearchBox = By.xpath("(//input[@placeholder='Search'])[2]");
	String foundOp;
	private By team = By.xpath("(//div[@tabulator-field='team_name'])[2]");
	private By shiftLeader = By.xpath("//div[.='Shift Leader']/preceding::div[9]");
	String sLEmail;
	private By threeDot = By.xpath("//img[@src='./assets/png/3-dot-menu.svg']");
	private By changePwd = By.xpath("(//img[@src='./assets/png/rolesvg.svg'])[2]");
	private By entPwd = By.xpath("(//input[@placeholder='Enter Password'])[2]");
	String pwd;
	private By confPwd = By.xpath("(//input[@placeholder='Enter Password'])[3]");
	private By resetPwd = By.xpath("//button[.='Reset Password']");
	private By userDropDown = By.xpath("//div[@id='navbarDropdown']");
	private By logOut = By.xpath("//a[.='Logout']");
	private By userEmail = By.xpath("//input[@id='username']");
	private By userPwd = By.xpath("//input[@id='txtPassword']");
	private By signInButton = By.xpath("//button[.='SIGN IN']");
	private By userDDInSL = By.xpath("//p[@id='navbarDropdown']");
	private By languageDD = By.xpath("//a[.='  English (en) ' or .='  Magyar (hu) ']");
	private By englishLang = By.xpath("(//a[.='English (en)'])");

	private By controlTower = By.xpath("//div[.=' Control Tower ']");
	private By shifTLead = By.xpath("//div[.=' Shift Leader ']");
	private By dailyOpMgmt = By.xpath("//div[.=' Daily Operator Management ']");
	private By selectDate = By.xpath("(//input[@id='selectedDate'])[1]");

	private By welcomeMsg = By.xpath("//div[@class='heading w-100 center-align']/a");

	private By closePopUpButton = By.xpath("//img[@src='./assets/svg/Cancel.svg']");
	private By taskGrpProdctOvrVw = By.xpath("(//div[@class='dhx_shape-container']/div)[1]");
	private By taskStatusInPov = By.xpath("(//span[@class='text']/a)[1]");
	private By firstOp = By.xpath("(//span[@class='allowBtn'])[1]");
	static String taskName;

	private By firsttask = By.xpath("(//div[.='" + taskName + "'])[1]");
	private By getTaskName = By.xpath("(//div[@class='process-card-heading ml-0 pl-0'])[1]");
	private By starttaskoption = By.xpath("//div[contains(text(),' Start Task ')]");
	private By starttaskbutton = By.xpath("//button[contains(text() , 'Start Task')]");
	private By CloseButton = By.xpath("(//div[@class='row']/div)[2]");
	private By logDelayCloseBtn = By.xpath("(//div[contains(@class, 'close-button')])[3]");
	private By markAsCompleteoption = By.xpath("//div[.=' Mark as Completed ']");
	private By markAsCompleteButton = By.xpath("//button[text()=' Mark As Completed']");
	private By closeTask = By.xpath("(//div[@class='dhx_cal_event_line ']/div/span)[2]");
	private By totalOpFieldEle = By.xpath("//div[@class='d-flex']");
	private By headerBtnFieldsEle = By.xpath("//div[@class='d-flex']/following-sibling::div/button");
	private By logEvenBtnEle = By.xpath("(//div[@class='d-flex']/following-sibling::div/*)[1]");
	private By secoundHeaderBtnsEle = By.xpath("//div[@class='reset-save-div']/button");
	private By toglleBtnToResticMovementEle = By.xpath("//span[@class='slider round']");
	private By zoomInBtnEle = By.xpath("//a[@title='Zoom In']");
	private By zoomOutBtnEle = By.xpath("//a[@title='Zoom Out']");
	private By shiftSummaryTableEle = By.xpath("//div[@class='summary-table']");
	private By taskListELe = By.xpath("//div[@class='d-flex h-100 w-100']");
	private By sLVtaskNameEle = By.xpath("(//a[.='Task']/parent::*)[1]");
	private By closeIcon = By.xpath("//div[@class='close-button pointer']");
	private By toasterMsgEle = By.xpath("//div[@role='alertdialog']");
	private By Restarttask = By.xpath("//div[.=' Restart ']");
	private By ReSettask = By.xpath("//div[contains(text(),' Reset ')]");
	private By ReSetButton = By.xpath("(//button[contains(text(),'Reset')])[last()]");
	private By delayStartDatePicker = By.xpath("//input[@id='showStartDatePicker']");
	private By delayStartReasonDD = By.xpath("(//div[@class='md-form font-16'])[1]");
	private By delayReasonOp = By.xpath("(//span[contains(text(), '" + delayReasonCode + "')])[1]");
	private By logDelayButton = By.xpath("//button[.='Log Delay']");
	private By delayCloseDatePicker = By.xpath("//input[@id='showEndDatePicker']");
	private By logDelayAlertEle = By.xpath("(//a[.=' Duration']/parent::*)[last()]");
	private By deleteAssetDown = By.xpath("((//a[.='Asset Down']/parent::*)[2]/following-sibling::div/*)[2]");
	private By assetStatusOption = By.xpath("//div[.=' Log Asset Status ']");
	private By selectEqButon = By.xpath("(//div[.=' Select Assets '])[1]");
	private By selectEqOpt = By.xpath("(//div/a[.=' " + equipmentName + " '])[1]"); // need to change the equipment name
	private By selectReasonButton = By.xpath("(//div[.=' Select Type '])[1]");
	private By selectReasonOp = By.xpath("(//div[@class='row font-16 pl-1']/app-dropdown/div/div/a)[1]");
	private By selectTime = By.xpath("(//input[@name='selectedDate'])[2]");
	private By logAssetButton = By.xpath("(//button[.='Log Asset Down'])[1]");
	private By addOperator = By.xpath("//button[.='Add Operator']");
	private By selectTeamDD = By.xpath("//div[.=' Select Team ']");
	private By selectFirstTeam = By.xpath("(//button[@data-toggle='dropdown']/following-sibling::div)[1]/a");
	private By selectOpDD = By.xpath("//div[.=' Select Operator ']");
	private By firstTeamEle = By.xpath("(//ul[@aria-labelledby='dropdownMenuButton']/li)[1]");
	private By firstOpEle = By.xpath("(//ul[@aria-labelledby='dropdownMenuButton']/li/a/following-sibling::ul/li)[1]");
	private By additonalCmt = By.xpath("//textarea[@placeholder='Additional Comment']");
	private By submitStatusBtn = By.xpath("//button[.='Submit Status']");
	private By opStatusCloseIcon = By.xpath("(//div[@class='close-button'])[2]");
	private By operatorAlert = By.xpath("//div[@class='operatorList']/div");
	private By tempOp = By.xpath("(//span[@class='temp'])[1]");
	private By deleteOpIcon = By.xpath("((//div[@class='d-flex'])[2]/*)[2]");
	private By chooseCategoryDD = By.xpath("//div[.=' Choose Category ']");
	private By selectResourceDD = By.xpath("//div[.=' Select Resource ']");
	private By employUnAvlEle = By.xpath("//a[.=' Employee Unavailable ']");
	private By selectFirstOp = By.xpath("(//div[@x-placement='bottom-start']/a)[1]");
	private By selectTypeDD = By.xpath("//div[.=' Select Type ']");
	private By selectFirstType = By.xpath("(//div[@x-placement='bottom-start']/a)[1]");
	private By logEventFromDate = By.xpath("(//input[@id='startDate'])[1]");
	private By logEventEndDate = By.xpath("(//input[@id='endDate'])[1]");
	private By addBtn = By.xpath("(//button[.='Add'])[1]");
	private By summaryTabOfLogEvent = By.xpath("(//div[.='Summary '])[2]");
	private By sideTaskBtn = By.xpath("//button[.='Side Task']");
	private By sideTaskFirstOp = By.xpath("(//div[@class='main-list']/mat-accordion)[1]");
	private By firstSideTaskEle = By.xpath("(//div[@class='card'])[1]");
	private By selectEqDD = By.xpath("//div[.=' Select Equipment ']");
	private By selectFirstEq = By.xpath("(//div[@x-placement='bottom-start']/a)[1]");
	private By logEvent = By.xpath("(//div[@class='ng-star-inserted']/div/div)[1]");
	private By secTaskName = By.xpath("(//div[@class='process-card-heading ml-0 pl-0'])[2]");
	private By firstTaskStartTimeEle = By.xpath("(((//div[contains(@class,'step-card')])[1]/div)[3]/div/span)[1]");
	private By firstTaskEndTimeEle = By.xpath("(((//div[contains(@class,'step-card')])[1]/div)[3]/div/span)[2]");
	private By firstTaskEle = By.xpath("(//div[@class='d-flex h-100 w-100'])[1]/parent::div");
	private By firstTaskStartTimeInSLV = By.xpath("((//table/tbody/tr)[2]/td)[last()-1]");
	private By firstTaskEndTimeInSLV = By.xpath("((//table/tbody/tr)[last()]/td)[last()]");
	private By eleToDrop = By.xpath("(//div[@data-col-id='2'])[5]");
	private By saveChangesBtn = By.xpath("//a[.='Save']");
	private By taskStatusInSLV = By.xpath("//a[.='Status']/parent::div");
	private By equipmentDownDeleteIcon = By.xpath("(//a[.='Asset Down']/parent::div/following-sibling::div/*)[4]");
	private By equipmentDownAlertInPov = By.xpath("(//a[.='Asset Down '])[1]");
//
	String secTaskNameInPov;
	String batchNames;
	String toasterMsg;
	String firstTaskstartTime;
	String firstTaskEndTime;
	String startTimeInSLV;
	String endTimeInSLV;
	String toasterMsgs;
	private String reason = null;
	int i;
	String APN1;
	private LoginPage loginpage;

//----------------------------------------------------------------------------------------------------------------------

	public DailyOperatorManagement(WebDriver driver) {

		this.driver = driver;
		navigateTo = new Navigation(driver);
		eleUtil = new ElementUtil(driver);
		loginpage = new LoginPage(driver);

	}

	public ProductOverview navigateToProducOverView() {
		driver.findElement(productoverview).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ProductOverview(driver);

	}

	public void getValidationDetails() {
		driver.findElement(productoverview).click();

	}

//******************************************************************************************************************************	******************************************

//--------------Changes not required in This method-----------------------------------------------------------

	public boolean shiftLeadNavigation() throws InterruptedException {
		String randomText = RandomStringUtils.randomAlphabetic(2);
		pwd = "Spid@1" + randomText;
		System.out.println("Randome pwd is " + pwd);
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
		boolean b = driver.findElement(welcomeMsg).isDisplayed();
		System.out.println("Login successfully and message is displayed " + driver.findElement(welcomeMsg).getText());
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
		driver.findElement(selectDate).sendKeys(task_Date);
		Thread.sleep(7000);
		return b;
	}

	public void getTaskDetailsFromPOV() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(userDDInSL).click();
		Thread.sleep(1000);
		driver.findElement(logOut).click();
		Thread.sleep(3000);
		driver.findElement(userEmail).sendKeys("mahboobsab.nandigatti@neewee.ai");
		driver.findElement(userPwd).sendKeys("Spider@00");
		driver.findElement(signInButton).click();
		Thread.sleep(4000);
		navigateTo.productOverview();
		Thread.sleep(2000);

		Select product = new Select(driver.findElement(ProductNameDrop));
		String Finaltext = "";
		for (WebElement option : product.getOptions()) {
			if (option.getText().contains(APN1)) {
				Finaltext = option.getText();
				product.selectByVisibleText(Finaltext);
				break;
			}
		}

		System.out.println("product Selected");
		driver.findElement(batchDD).click();
		Thread.sleep(1000);
		driver.findElement(selectFirstBatch).click();
		System.out.println("Batch is selected");
		Thread.sleep(4000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		String actualStatusInPOV = driver.findElement(taskStatusInPov).getText();
		System.out.println("get task status ");
		System.out.println(actualStatusInPOV);
		foundOp = driver.findElement(firstOp).getText();
		taskName = driver.findElement(getTaskName).getText().replace("\n", "");
		secTaskNameInPov = driver.findElement(secTaskName).getText();
		System.out.println("Secound task name is " + secTaskNameInPov);
		firstTaskstartTime = driver.findElement(firstTaskStartTimeEle).getText();
		System.out.println("first Task start time in product overview " + firstTaskstartTime);
		firstTaskEndTime = driver.findElement(firstTaskEndTimeEle).getText();
		System.out.println("first task end time in product overview " + firstTaskEndTime);
		Thread.sleep(14000);
	}

	public void navigateToShiftLeadView() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(userDDInSL).click();

		System.out.println("click on user drop down ");
		Thread.sleep(3000);
		driver.findElement(logOut).click();
		System.out.println("user loged out");
		Thread.sleep(4000);
		driver.findElement(userEmail).sendKeys(sLEmail);
		driver.findElement(userPwd).sendKeys(pwd);
		driver.findElement(signInButton).click();
		Thread.sleep(4000);
		boolean b = driver.findElement(welcomeMsg).isDisplayed();
		System.out.println("Login successfully and message is displayed " + driver.findElement(welcomeMsg).getText());
		driver.findElement(userDDInSL).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(languageDD)).perform();
		Thread.sleep(2000);
		driver.findElement(englishLang).click();
		Thread.sleep(5000);
		driver.findElement(controlTower).click();
		Thread.sleep(2000);
		driver.findElement(shifTLead).click();
		Thread.sleep(2000);
		driver.findElement(dailyOpMgmt).click();
		Thread.sleep(4000);
		driver.findElement(selectDate).sendKeys(task_Date);
		Thread.sleep(7000);

	}

//------------------------------Updated Test Script Start From Here --------------------------------------------------

	public boolean loginAsSL(String batchNumberValue) throws InterruptedException {
		delayReasonOp = By.xpath("(//span[contains(text(), '" + delayReasonCode + "')])[1]");
		selectEqOpt = By.xpath("(//div/a[.=' " + equipmentName + " '])[1]");
		System.out.println("Equipment down xpath " + selectEqOpt);
		driver.findElement(closePopUpButton).click();
		Thread.sleep(3000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		String actualStatusInPOV = driver.findElement(taskStatusInPov).getText();
		System.out.println("get task status ");
		System.out.println(actualStatusInPOV);
		foundOp = driver.findElement(firstOp).getText();
		taskName = driver.findElement(getTaskName).getText().replace("\n", "");
		secTaskNameInPov = driver.findElement(secTaskName).getText();
		System.out.println("Secound task name is " + secTaskNameInPov);
		batchNumberValue = batchNames;
		firstTaskstartTime = driver.findElement(firstTaskStartTimeEle).getText();
		System.out.println("first Task start time in product overview " + firstTaskstartTime);
		firstTaskEndTime = driver.findElement(firstTaskEndTimeEle).getText();
		System.out.println("first task end time in product overview " + firstTaskEndTime);
		taskName = batchNumberValue + taskName;
		System.out.println("Task Name after converting " + taskName);
		System.out.println("Task Name is " + taskName);
		System.out.println("get operator name ");
		boolean b = shiftLeadNavigation();
		return b;
	}

	public boolean taskAvailability() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		boolean b = false;
		List<WebElement> taskEle = driver.findElements(taskListELe);

		for (i = 1; i <= taskEle.size(); i++) {
			driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]")).click();
			Thread.sleep(1500);
			String sLVTaskName = driver.findElement(sLVtaskNameEle).getText().replace("Task : ", "");
			sLVTaskName = sLVTaskName.replace(" ", "");
			System.out.println("Task Name in Shift lead view " + sLVTaskName);
			try {
				msgUnderInfo = driver.findElement(msg).getText();
				System.out.println("inside to get msg =" + msgUnderInfo);
			} catch (Exception e) {
				msgUnderInfo = "null";
				System.out.println("msg is null =" + msgUnderInfo);
			}
			if (sLVTaskName.equals(firstTaskName) && (msgUnderInfo.equals("*This is not the last section of this task.")
					|| msgUnderInfo.equals("null"))) {
				System.out.println("inside if condition ");
				b = true;
				Thread.sleep(2000);
				break;
			}
			if (!b) {
				System.out.println("this is not the task we are closing ");
				driver.findElement(closeIcon).click();
				Thread.sleep(1000);
			}
		}

		return b;
	}

	public boolean methodToFindLastSecTask() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		boolean b = false;
		List<WebElement> taskEle = driver.findElements(taskListELe);

		for (int i = 1; i <= taskEle.size(); i++) {
			driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]")).click();
			Thread.sleep(1000);
			String sLVTaskName = driver.findElement(sLVtaskNameEle).getText().replace("Task : ", "");
			sLVTaskName = sLVTaskName.replace(" ", "");
			System.out.println("Task Name in Shift lead view " + sLVTaskName);
			try {
				msgUnderInfo = driver.findElement(msg).getText();
				System.out.println("inside to get msg =" + msgUnderInfo);
			} catch (Exception e) {
				msgUnderInfo = "null";
				System.out.println("msg is null =" + msgUnderInfo);
			}
			if (sLVTaskName.equals(firstTaskName)
					&& (msgUnderInfo.equals("*This is not the first section of this task.")
							|| msgUnderInfo.equals("null"))) {
				System.out.println("inside if condition ");
				b = true;
				Thread.sleep(2000);
				break; // Break out of the loop
			}
			if (!b) {
				System.out.println("this is not the task we are closing ");
				driver.findElement(closeIcon).click();
				Thread.sleep(1000);
			}
		}

		return b;
	}

	public boolean verifyToatalOpFieldAvlTest() {
		try {
			driver.findElement(totalOpFieldEle).isDisplayed();
			System.out.println("Toatal Operator and Absent Operator count is available ");
			return true;
		} catch (Exception e) {
			System.out.println("Toatal Operator and Absent Operator count is not available ");
			return false;
		}
	}

	public List<String> verifyHeaderBtnAvlTest() {
		List<WebElement> headerBtns = driver.findElements(headerBtnFieldsEle);
		List<String> headerBtnValue = new ArrayList<String>();
		for (WebElement headerBtn : headerBtns) {
			headerBtnValue.add(headerBtn.getText());
		}
		return headerBtnValue;
	}

	public boolean verifyLogEventTest() {
		try {
			driver.findElement(logEvenBtnEle).isDisplayed();
			System.out.println("Log Even Btn is available ");
			return true;

		} catch (Exception e) {
			System.out.println("Log Even Btn is not available ");
			return false;
		}
	}

	public List<String> verifyResfreshSaveRestBtnAvlTest() {
		List<WebElement> secHeaderBtns = driver.findElements(secoundHeaderBtnsEle);
		List<String> secHeaderBtnValue = new ArrayList<String>();
		for (WebElement secHeaderBtn : secHeaderBtns) {
			secHeaderBtnValue.add(secHeaderBtn.getText());
		}
		return secHeaderBtnValue;
	}

	public boolean verifyToglleToResticBtnAvlTest() {
		try {
			driver.findElement(toglleBtnToResticMovementEle).isDisplayed();
			System.out.println("Toggle to restrict movement is available ");
			return true;
		} catch (Exception e) {
			System.out.println("Toggle to restrict movement is not available ");
			return false;
		}
	}

	public boolean verifyTheAvlOfZoomInAndZoomOutBtnTest() {
		try {
			driver.findElement(zoomInBtnEle).isDisplayed();
			driver.findElement(zoomOutBtnEle).isDisplayed();
			System.out.println("Zoom In And Zoom Out Button is available ");
			return true;
		} catch (Exception e) {
			System.out.println("Zoom In And Zoom Out Button is not available ");
			return false;
		}

	}

	public boolean verifyTheSummaryTableIsAvl() {
		try {
			driver.findElement(shiftSummaryTableEle).isDisplayed();
			System.out.println("Shift summary table is available ");
			return true;
		} catch (Exception e) {
			System.out.println("Shift summary table is not available ");
			return false;
		}
	}

	public boolean startTask() throws InterruptedException {

		driver.findElement(starttaskoption).click();
		System.out.println("starttaskoption is clicked ");
		Thread.sleep(1000);
		driver.findElement(starttaskbutton).click();
		Thread.sleep(1000);
		System.out.println("starttaskbutton is clicked ");
		toasterMsg = driver.findElement(toasterMsgEle).getText().replace(" ", "");
		Thread.sleep(2000);
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("Taskstatusupdatedsuccessfully")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}

	}

	public boolean closeTask() throws InterruptedException {
		driver.findElement(markAsCompleteoption).click();
		Thread.sleep(1000);
		driver.findElement(markAsCompleteButton).click();
		System.out.println("Task closed");
		toasterMsg = driver.findElement(toasterMsgEle).getAttribute("aria-label");
		toasterMsg = toasterMsg.replace(" ", "");
		Thread.sleep(2000);
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("Taskstatusupdatedsuccessfully")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}
	}

	public boolean restartTaskTest() throws InterruptedException {
		System.out.println("inside restart task test case ");
		driver.findElement(Restarttask).click();
		System.out.println("task restarted ");
		Thread.sleep(1000);
		toasterMsg = driver.findElement(toasterMsgEle).getText().replace(" ", "");
		Thread.sleep(3000);
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("Taskstatusupdatedsuccessfully")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}

	}

	public boolean resetTaskTest() throws InterruptedException {

		driver.findElement(ReSettask).click();
		System.out.println("Reset button clicked");
		Thread.sleep(1000);
		driver.findElement(ReSetButton).click();
		System.out.println("Reset alert accetped");
		toasterMsg = driver.findElement(toasterMsgEle).getAttribute("aria-label");
		toasterMsg = toasterMsg.replace(" ", "");
		Thread.sleep(2000);
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("Taskstatusupdatedsuccessfully")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}
	}

	public boolean startTaskWithDelayTest() throws InterruptedException {
		driver.findElement(starttaskoption).click();
		System.out.println("starttaskoption is clicked ");
		Thread.sleep(1000);
		driver.findElement(delayStartDatePicker).sendKeys(delayTime);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

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
		Thread.sleep(2000);
		driver.findElement(logDelayButton).click();
		Thread.sleep(1000);
		toasterMsg = driver.findElement(toasterMsgEle).getText().replace(" ", "");
		Thread.sleep(2000);
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("Taskstatusupdatedsuccessfully")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}

	}

	public boolean verifyAlertMsgAfterDelayStartTest() throws InterruptedException {
		try {
			driver.findElement(logDelayAlertEle).isDisplayed();
			System.out.println("Log delay alert is available ");
			driver.findElement(closeIcon).click();
			return true;

		} catch (Exception e) {
			System.out.println("Log delay alert is not displayed ");
			driver.findElement(closeIcon).click();
			return false;
		}

	}

	public boolean closeTaskWithDelayTest() throws InterruptedException {
		driver.findElement(markAsCompleteoption).click();
		Thread.sleep(1000);
		driver.findElement(delayCloseDatePicker).sendKeys(delayCloseTime);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		driver.findElement(markAsCompleteButton).click();
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(logDelayButton).click();
		toasterMsg = driver.findElement(toasterMsgEle).getAttribute("aria-label");
		toasterMsg = toasterMsg.replace(" ", "");
		Thread.sleep(2000);
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("Taskstatusupdatedsuccessfully")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}

	}

	public boolean verifyAlertMsgAfterDelayCloseTest() throws InterruptedException {
		try {
			driver.findElement(logDelayAlertEle).isDisplayed();
			System.out.println("Log delay alert is available ");
			driver.findElement(closeIcon).click();
			return true;

		} catch (Exception e) {
			System.out.println("Log delay alert is not displayed ");
			driver.findElement(closeIcon).click();
			return false;
		}
	}

	public boolean startTaskEarlyTest() throws InterruptedException {
		driver.findElement(starttaskoption).click();
		System.out.println("starttaskoption is clicked ");
		Thread.sleep(1000);
		driver.findElement(delayStartDatePicker).sendKeys(earlyStartTime);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

//		Thread.sleep(2000);
//		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
//		Thread.sleep(2000);

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
		Thread.sleep(2000);
		driver.findElement(logDelayButton).click();
		Thread.sleep(1000);
		toasterMsg = driver.findElement(toasterMsgEle).getText().replace(" ", "");
		Thread.sleep(2000);
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("Taskstatusupdatedsuccessfully")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}

	}

	public boolean verifyAlertMsgAfterEarlyStartTest() throws InterruptedException {
		try {
			driver.findElement(logDelayAlertEle).isDisplayed();
			System.out.println("Log delay alert is available ");
			driver.findElement(closeIcon).click();
			return true;

		} catch (Exception e) {
			System.out.println("Log delay alert is not displayed ");
			driver.findElement(closeIcon).click();
			return false;
		}
	}

	public boolean closeTaskEarlyTest() throws InterruptedException {
		driver.findElement(markAsCompleteoption).click();
		Thread.sleep(1000);
		driver.findElement(delayCloseDatePicker).sendKeys(earlyClose);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

//		Thread.sleep(2000);
//		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);

		driver.findElement(markAsCompleteButton).click();
		Thread.sleep(2000);
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(logDelayButton).click();
		toasterMsg = driver.findElement(toasterMsgEle).getAttribute("aria-label");
		toasterMsg = toasterMsg.replace(" ", "");
		Thread.sleep(2000);
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("Taskstatusupdatedsuccessfully")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}

	}

	public boolean verifyAlertMsgAfterEarlyCloseTest() throws InterruptedException {
		try {
			driver.findElement(logDelayAlertEle).isDisplayed();
			System.out.println("Log delay alert is available ");
			driver.findElement(closeIcon).click();
			return true;
		} catch (Exception e) {
			System.out.println("Log delay alert is not displayed ");
			driver.findElement(closeIcon).click();
			return false;
		}
	}

	public void removeExistingAssetDown() throws InterruptedException {
		try {
			driver.findElement(deleteAssetDown).click();
			driver.switchTo().alert().accept();
			System.out.println("asset is available ");
		} catch (Exception e) {
			driver.findElement(closeIcon).click();
			Thread.sleep(1000);
			System.out.println("Asset down is not available ");
		}
		Thread.sleep(3000);
	}

	public boolean assetDownTest() throws InterruptedException {
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
		Thread.sleep(4000);
		System.out.println("data selected ");
		driver.findElement(logAssetButton).click();
		System.out.println("asset added ");
		toasterMsg = driver.findElement(toasterMsgEle).getText().replace(" ", "");
		Thread.sleep(3000);
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("Assetstatusupdated!")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}

	}

	public void getTaskTimeFromPO(String APN, String firstTaskName2, String batchName) throws InterruptedException {
		batchNames = batchName;
		firstTaskName = firstTaskName2.replace(" ", "");
		System.out.println("first task name in planner " + firstTaskName);
		System.out.println(APN + "Displayed");
		APN1 = APN;

		Select product = new Select(driver.findElement(ProductNameDrop));
		String Finaltext = "";
		for (WebElement option : product.getOptions()) {
			if (APN.trim().contains(option.getText().trim())) {
				Finaltext = option.getText();
				product.selectByVisibleText(Finaltext);
				break;
			}
		}

		System.out.println("product Selected");
		driver.findElement(batchDD).click();
		Thread.sleep(1000);
		selectFirstBatch = By.xpath("//option[.='" + EventProperties.firstBatchNumber + " ']");
		System.out.println("Xpath to select first batch " + selectFirstBatch);
		driver.findElement(selectFirstBatch).click();
		System.out.println("Batch is selected");
		Thread.sleep(1000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);
		try {
			driver.findElement(startDD).click();
			driver.findElement(resetButton).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(8000);
		} catch (Exception e) {
			System.out.println("reset button is disabled ");

		}
	}

	public boolean verifyUserCanAddOperatorTest() throws InterruptedException {
		driver.findElement(addOperator).click();
		Thread.sleep(1000);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(2000);
		driver.findElement(selectFirstTeam).click();
		Thread.sleep(1000);
		driver.findElement(selectOpDD).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(firstTeamEle)).build().perform();
		Thread.sleep(3000);
		driver.findElement(firstOpEle).click();
		driver.findElement(additonalCmt).sendKeys("test");
		driver.findElement(submitStatusBtn).click();
		try {
			driver.findElement(operatorAlert).isDisplayed();
			driver.findElement(opStatusCloseIcon).click();
			Thread.sleep(3000);
			return true;

		} catch (Exception e) {
			driver.findElement(opStatusCloseIcon).click();
			System.out.println("operator alert is not displayed ");
			Thread.sleep(3000);
			return false;
		}

	}

	public boolean verifyTemOpAvlInGridTest() {
		try {
			driver.findElement(tempOp).isDisplayed();
			return true;

		} catch (Exception e) {
			System.out.println("Temp operator is not avaialble in grid ");
			return false;
		}
	}

	public boolean verifyUserCanDeleteTempOpTest() throws InterruptedException {
		driver.findElement(addOperator).click();
		Thread.sleep(1000);
		driver.findElement(deleteOpIcon).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(opStatusCloseIcon).click();
		Thread.sleep(3000);
		try {
			driver.findElement(tempOp).isDisplayed();
			return true;

		} catch (Exception e) {
			System.out.println("Temp operator is not avaialble in grid ");
			return false;
		}
	}

	public boolean verifyFuncOfLogEventBtnTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(selectDate).sendKeys(task_Date);
		Thread.sleep(5000);
		driver.findElement(logEvenBtnEle).click();
		Thread.sleep(1000);
		driver.findElement(chooseCategoryDD).click();
		Thread.sleep(1000);
		driver.findElement(employUnAvlEle).click();
		Thread.sleep(1000);
		driver.findElement(selectResourceDD).click();
		Thread.sleep(1000);
		driver.findElement(selectFirstOp).click();
		Thread.sleep(1000);
		driver.findElement(selectTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(selectFirstType).click();
		Thread.sleep(1000);
		driver.findElement(logEventFromDate).sendKeys(opUnAvlFromDate);
		driver.findElement(logEventEndDate).sendKeys(opUnAvlToDate);
		Thread.sleep(1000);
		driver.findElement(additonalCmt).sendKeys("Test");
		driver.findElement(addBtn).click();
		toasterMsg = driver.findElement(toasterMsgEle).getAttribute("aria-label");
		toasterMsg = toasterMsg.replace(" ", "");
		Thread.sleep(4000);
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("UnavailabilityUpdatedSuccessfully!!!")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}
	}

	public boolean verifyLogEventIsDisplayedTest() throws InterruptedException {
		driver.findElement(logEvenBtnEle).click();
		Thread.sleep(1000);
		driver.findElement(summaryTabOfLogEvent).click();
		Thread.sleep(1000);
		try {
			driver.findElement(logEvent).isDisplayed();
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	public boolean verifyUserCanDeleteLogEventTest() throws InterruptedException {
		driver.findElement(opStatusCloseIcon).click();
		Thread.sleep(1000);
		driver.findElement(logEvenBtnEle).click();
		Thread.sleep(1000);
		driver.findElement(summaryTabOfLogEvent).click();
		Thread.sleep(1000);
		driver.findElement(deleteOpIcon).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		try {
			driver.findElement(opStatusCloseIcon).click();
		} catch (Exception e) {
			System.out.println("Log Event button is not visible ");
		}
		Thread.sleep(1000);
		toasterMsg = driver.findElement(toasterMsgEle).getAttribute("aria-label");
		toasterMsg = toasterMsg.replace(" ", "");
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("DelayDeletedSuccessfully!")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}

	}

	public boolean addSideTaskTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(selectDate).sendKeys(task_Date);
		Thread.sleep(4000);
		driver.findElement(sideTaskBtn).click();
		Thread.sleep(2000);
		driver.findElement(sideTaskFirstOp).click();
		Thread.sleep(2000);
		driver.findElement(firstSideTaskEle).click();
		Thread.sleep(1000);
		driver.findElement(selectEqDD).click();
		Thread.sleep(1000);
		driver.findElement(selectFirstEq).click();
		driver.findElement(logEventFromDate).sendKeys(addSideTaskTime);
		Thread.sleep(1000);
		driver.findElement(addBtn).click();
		Thread.sleep(500);
		try {
			toasterMsg = driver.findElement(toasterMsgEle).getAttribute("aria-label");
		} catch (Exception e) {
			toasterMsg = "null";
		}
		toasterMsg = toasterMsg.replace(" ", "");
		Thread.sleep(2000);
		System.out.println("Actual Toaster message is " + toasterMsg);
		if (toasterMsg.equals("SideTaskAddedSuccessfully")) {
			System.out.println("Toaster message is displayed " + toasterMsg);
			return true;
		} else {
			System.out.println("wrong toaster message is displayed " + toasterMsg);
			return false;
		}

	}

	public boolean verifyUserCanChnageTheAllocatedOpByDragTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(selectDate).sendKeys(task_Date);
		Thread.sleep(4000);
		String eventIdBeforeDrag = driver.findElement(firstTaskEle).getAttribute("event_id");
		System.out.println("Event Id before drag " + eventIdBeforeDrag);
		Actions actions = new Actions(driver);
		actions.dragAndDrop(driver.findElement(firstTaskEle), driver.findElement(eleToDrop)).build().perform();
		Thread.sleep(5000);
		driver.findElement(saveChangesBtn).click();
		Thread.sleep(5000);
		String eventIdAfterDrag = driver.findElement(firstTaskEle).getAttribute("event_id");
		System.out.println("Event Id after drag " + eventIdAfterDrag);
		if (!eventIdBeforeDrag.equals(eventIdAfterDrag)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyShiftLeadCanNavigateToManagerViewTest() throws InterruptedException {
		boolean b = navigateTo.ManagerView();
		return b;
	}

	public boolean verifyTaskTimeInNotStartedStateTest() throws InterruptedException {
		driver.findElement(closeIcon).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]"))).build()
				.perform();
		Thread.sleep(3000);
		startTimeInSLV = driver.findElement(firstTaskStartTimeInSLV).getText();
		startTimeInSLV = startTimeInSLV.substring(0, startTimeInSLV.length() - 3);
		System.out.println("First task start time in shift lead view " + startTimeInSLV);
		endTimeInSLV = driver.findElement(firstTaskEndTimeInSLV).getText();
		endTimeInSLV = endTimeInSLV.substring(0, endTimeInSLV.length() - 3);
		System.out.println("first task end time in shift lead view " + endTimeInSLV);
		if (firstTaskstartTime.equals(startTimeInSLV) && firstTaskEndTime.equals(endTimeInSLV)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTaskStatusPostStartTaskTest() {
		String status = driver.findElement(taskStatusInSLV).getText();
		System.out.println("Task status post start is *" + status);
		if (status.equals("Status : In Progress")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTaskTimePostStartTask() throws InterruptedException {
		driver.findElement(closeIcon).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]"))).build()
				.perform();
		Thread.sleep(3000);
		startTimeInSLV = driver.findElement(firstTaskStartTimeInSLV).getText();
		startTimeInSLV = startTimeInSLV.substring(0, startTimeInSLV.length() - 3);
		System.out.println("First task start time in shift lead view " + startTimeInSLV);
		endTimeInSLV = driver.findElement(firstTaskEndTimeInSLV).getText();
		endTimeInSLV = endTimeInSLV.substring(0, endTimeInSLV.length() - 3);
		System.out.println("first task end time in shift lead view " + endTimeInSLV);
		if (firstTaskstartTime.equals(startTimeInSLV) && firstTaskEndTime.equals(endTimeInSLV)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTaskStatusAfterCloseTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]")).click();
		Thread.sleep(2000);
		String status = driver.findElement(taskStatusInSLV).getText();
		System.out.println("Task status post start is *" + status);
		if (status.equals("Status : Completed")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTaskTimeAfterCloseTest() throws InterruptedException {
		driver.findElement(closeIcon).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]"))).build()
				.perform();
		Thread.sleep(3000);
		startTimeInSLV = driver.findElement(firstTaskStartTimeInSLV).getText();
		startTimeInSLV = startTimeInSLV.substring(0, startTimeInSLV.length() - 3);
		System.out.println("First task start time in shift lead view " + startTimeInSLV);
		endTimeInSLV = driver.findElement(firstTaskEndTimeInSLV).getText();
		endTimeInSLV = endTimeInSLV.substring(0, endTimeInSLV.length() - 3);
		System.out.println("first task end time in shift lead view " + endTimeInSLV);
		if (firstTaskstartTime.equals(startTimeInSLV) && firstTaskEndTime.equals(endTimeInSLV)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTaskStatusAfterRestartTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]")).click();
		Thread.sleep(2000);
		String status = driver.findElement(taskStatusInSLV).getText();
		System.out.println("Task status post start is *" + status);
		if (status.equals("Status : In Progress")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTaskTimeAfterRestartTest() throws InterruptedException {
		driver.findElement(closeIcon).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]"))).build()
				.perform();
		Thread.sleep(3000);
		startTimeInSLV = driver.findElement(firstTaskStartTimeInSLV).getText();
		startTimeInSLV = startTimeInSLV.substring(0, startTimeInSLV.length() - 3);
		System.out.println("First task start time in shift lead view " + startTimeInSLV);
		endTimeInSLV = driver.findElement(firstTaskEndTimeInSLV).getText();
		endTimeInSLV = endTimeInSLV.substring(0, endTimeInSLV.length() - 3);
		System.out.println("first task end time in shift lead view " + endTimeInSLV);
		if (firstTaskstartTime.equals(startTimeInSLV) && firstTaskEndTime.equals(endTimeInSLV)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTaskStatusAfterResetTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]")).click();
		Thread.sleep(2000);
		String status = driver.findElement(taskStatusInSLV).getText();
		System.out.println("Task status post start is *" + status);
		if (status.equals("Status : Yet To Start")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTaskTimeAfterResetTest() throws InterruptedException {
		driver.findElement(closeIcon).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]"))).build()
				.perform();
		Thread.sleep(3000);
		startTimeInSLV = driver.findElement(firstTaskStartTimeInSLV).getText();
		startTimeInSLV = startTimeInSLV.substring(0, startTimeInSLV.length() - 3);
		System.out.println("First task start time in shift lead view " + startTimeInSLV);
		endTimeInSLV = driver.findElement(firstTaskEndTimeInSLV).getText();
		endTimeInSLV = endTimeInSLV.substring(0, endTimeInSLV.length() - 3);
		System.out.println("first task end time in shift lead view " + endTimeInSLV);
		if (firstTaskstartTime.equals(startTimeInSLV) && firstTaskEndTime.equals(endTimeInSLV)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTaskDurationAfterDelayStartInPOVTest() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]"))).build()
				.perform();
		Thread.sleep(3000);
		startTimeInSLV = driver.findElement(firstTaskStartTimeInSLV).getText();
		startTimeInSLV = startTimeInSLV.substring(0, startTimeInSLV.length() - 3);
		startTimeInSLV = startTimeInSLV.replace(" ", "");
		System.out.println("First task start time in shift lead view after delay start " + startTimeInSLV);
		endTimeInSLV = driver.findElement(firstTaskEndTimeInSLV).getText();
		endTimeInSLV = endTimeInSLV.substring(0, endTimeInSLV.length() - 3);
		endTimeInSLV = endTimeInSLV.replace(" ", "");
		System.out.println("first task end time in shift lead view after delay start " + endTimeInSLV);
		getTaskDetailsFromPOV();
		firstTaskstartTime = firstTaskstartTime.replace(" ", "");
		System.out.println("first task start time in pov after delay start " + firstTaskstartTime);
		firstTaskEndTime = firstTaskEndTime.replace(" ", "");
		System.out.println("first task end time in pov after delay start " + firstTaskEndTime);

		if (firstTaskstartTime.equals(startTimeInSLV) && firstTaskEndTime.equals(endTimeInSLV)) {
			return true;
		} else {
			System.out.println(
					"POV start time not equal to SLV start time =" + firstTaskstartTime + " != " + startTimeInSLV);
			System.out.println("POV end time not equal to SLV end time " + firstTaskEndTime + " != " + endTimeInSLV);
			return false;
		}

	}

	public boolean verifyTaskDurationInPOVAfterDelayFinishTest() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]"))).build()
				.perform();
		Thread.sleep(3000);
		startTimeInSLV = driver.findElement(firstTaskStartTimeInSLV).getText();
		startTimeInSLV = startTimeInSLV.substring(0, startTimeInSLV.length() - 3);
		startTimeInSLV = startTimeInSLV.replace(" ", "");
		System.out.println("First task start time in shift lead view after delay Close " + startTimeInSLV);
		endTimeInSLV = driver.findElement(firstTaskEndTimeInSLV).getText();
		endTimeInSLV = endTimeInSLV.substring(0, endTimeInSLV.length() - 3);
		endTimeInSLV = endTimeInSLV.replace(" ", "");
		System.out.println("first task end time in shift lead view after delay close " + endTimeInSLV);
		getTaskDetailsFromPOV();
		firstTaskstartTime = firstTaskstartTime.replace(" ", "");
		System.out.println("first task start time in pov after delay close " + firstTaskstartTime);
		firstTaskEndTime = firstTaskEndTime.replace(" ", "");
		System.out.println("first task end time in pov after delay close " + firstTaskEndTime);

		if (firstTaskstartTime.equals(startTimeInSLV) && firstTaskEndTime.equals(endTimeInSLV)) {
			return true;
		} else {
			System.out.println(
					"POV start time not equal to SLV start time =" + firstTaskstartTime + " != " + startTimeInSLV);
			System.out.println("POV end time not equal to SLV end time " + firstTaskEndTime + " != " + endTimeInSLV);
			return false;
		}
	}

	public boolean verifyTaskDurationInPovAfterEarlyStartTest() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]"))).build()
				.perform();
		Thread.sleep(3000);
		startTimeInSLV = driver.findElement(firstTaskStartTimeInSLV).getText();
		startTimeInSLV = startTimeInSLV.substring(0, startTimeInSLV.length() - 3);
		startTimeInSLV = startTimeInSLV.replace(" ", "");
		System.out.println("First task start time in shift lead view after early start " + startTimeInSLV);
		endTimeInSLV = driver.findElement(firstTaskEndTimeInSLV).getText();
		endTimeInSLV = endTimeInSLV.substring(0, endTimeInSLV.length() - 3);
		endTimeInSLV = endTimeInSLV.replace(" ", "");
		System.out.println("first task end time in shift lead view after early start " + endTimeInSLV);
		getTaskDetailsFromPOV();
		firstTaskstartTime = firstTaskstartTime.replace(" ", "");
		System.out.println("first task start time in pov after early start " + firstTaskstartTime);
		firstTaskEndTime = firstTaskEndTime.replace(" ", "");
		System.out.println("first task end time in pov after early start " + firstTaskEndTime);

		if (firstTaskstartTime.equals(startTimeInSLV) && firstTaskEndTime.equals(endTimeInSLV)) {
			return true;
		} else {
			System.out.println(
					"POV start time not equal to SLV start time =" + firstTaskstartTime + " != " + startTimeInSLV);
			System.out.println("POV end time not equal to SLV end time " + firstTaskEndTime + " != " + endTimeInSLV);
			return false;
		}
	}

	public boolean verifyTaskDurationInPOVAfterEarlyCloseTest() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]"))).build()
				.perform();
		Thread.sleep(3000);
		startTimeInSLV = driver.findElement(firstTaskStartTimeInSLV).getText();
		startTimeInSLV = startTimeInSLV.substring(0, startTimeInSLV.length() - 3);
		startTimeInSLV = startTimeInSLV.replace(" ", "");
		System.out.println("First task start time in shift lead view after early close " + startTimeInSLV);
		endTimeInSLV = driver.findElement(firstTaskEndTimeInSLV).getText();
		endTimeInSLV = endTimeInSLV.substring(0, endTimeInSLV.length() - 3);
		endTimeInSLV = endTimeInSLV.replace(" ", "");
		System.out.println("first task end time in shift lead view after early close " + endTimeInSLV);
		getTaskDetailsFromPOV();
		firstTaskstartTime = firstTaskstartTime.replace(" ", "");
		System.out.println("first task start time in pov after early close " + firstTaskstartTime);
		firstTaskEndTime = firstTaskEndTime.replace(" ", "");
		System.out.println("first task end time in pov after early close " + firstTaskEndTime);

		if (firstTaskstartTime.equals(startTimeInSLV) && firstTaskEndTime.equals(endTimeInSLV)) {
			return true;
		} else {
			System.out.println(
					"POV start time not equal to SLV start time =" + firstTaskstartTime + " != " + startTimeInSLV);
			System.out.println("POV end time not equal to SLV end time " + firstTaskEndTime + " != " + endTimeInSLV);
			return false;
		}
	}

	public boolean verifyTheTaskStatusAfterResetTheTaskAfterEarlyCloseTest() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]")).click();
		Thread.sleep(2000);
		String status = driver.findElement(taskStatusInSLV).getText();
		System.out.println("Task status post start is *" + status);
		if (status.equals("Status : Yet To Start")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTheTaskDurationAfterResetTheTaskAfterEarlyCloseTest() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]"))).build()
				.perform();
		Thread.sleep(3000);
		startTimeInSLV = driver.findElement(firstTaskStartTimeInSLV).getText();
		startTimeInSLV = startTimeInSLV.substring(0, startTimeInSLV.length() - 3);
		startTimeInSLV = startTimeInSLV.replace(" ", "");
		System.out.println("First task start time in shift lead view after early close " + startTimeInSLV);
		endTimeInSLV = driver.findElement(firstTaskEndTimeInSLV).getText();
		endTimeInSLV = endTimeInSLV.substring(0, endTimeInSLV.length() - 3);
		endTimeInSLV = endTimeInSLV.replace(" ", "");
		System.out.println("first task end time in shift lead view after early close " + endTimeInSLV);
		getTaskDetailsFromPOV();
		firstTaskstartTime = firstTaskstartTime.replace(" ", "");
		System.out.println("first task start time in pov after early close " + firstTaskstartTime);
		firstTaskEndTime = firstTaskEndTime.replace(" ", "");
		System.out.println("first task end time in pov after early close " + firstTaskEndTime);

		if (firstTaskstartTime.equals(startTimeInSLV) && firstTaskEndTime.equals(endTimeInSLV)) {
			return true;
		} else {
			System.out.println(
					"POV start time not equal to SLV start time =" + firstTaskstartTime + " != " + startTimeInSLV);
			System.out.println("POV end time not equal to SLV end time " + firstTaskEndTime + " != " + endTimeInSLV);
			return false;
		}
	}

	public boolean verifyAvlOfEquipmentDownAlertTest() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]")).click();
		Thread.sleep(2000);
		try {
			driver.findElement(equipmentDownDeleteIcon).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyTheAvlOfEquipmentDownAlertInPOVTest() throws InterruptedException {
		getTaskDetailsFromPOV();
		try {
			driver.findElement(equipmentDownAlertInPov).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanDeleteEquipmentDownTest() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='d-flex h-100 w-100'])[" + i + "]")).click();
		Thread.sleep(2000);
		try {
			driver.findElement(equipmentDownDeleteIcon).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(1500);
			toasterMsg = driver.findElement(toasterMsgEle).getText();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyToasterMsgPostEquipmentDownAlertTest() {
		System.out.println("equipment down toaster message is " + toasterMsg);
		if (toasterMsg.equals("Asset Status deleted successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyEquipmentDownAlertInPOVPostEquipmentDownAlertDeleteTest() throws InterruptedException {
		getTaskDetailsFromPOV();
		try {
			driver.findElement(equipmentDownAlertInPov).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

}
