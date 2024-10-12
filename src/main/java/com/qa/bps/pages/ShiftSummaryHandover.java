package com.qa.bps.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;

public class ShiftSummaryHandover extends EventProperties {

	WebDriver driver;
	Navigation navigateTo;
	VSBpage vsb;
	private By ProductNameDrop = By.xpath("//select[@id='select']");

	public static By batchDD = By.xpath("(//select)[2]");
	private By shiftDetailsFieled = By.xpath("//div[contains(@class,'shift-details-container')]");
	private By selectDate = By.xpath("//input[@id='selectedDate']");
	private By shiftTypeDD = By.xpath("(//button[@class='btn dropdown-toggle filter-background'])[1]");
	private By teamFilterDD = By.xpath("(//button[@class='btn dropdown-toggle filter-background'])[2]");
	private By relaventFilter = By.xpath("(//button[@class='btn dropdown-toggle filter-background'])[3]");
	private By shiftListEle = By.xpath("//div[@x-placement='bottom-start']/a");
	private By teamListEle = By.xpath("//div[@x-placement='bottom-start']/a");
	private By firstTaskNameEle = By.xpath("(//div[@class='ellipsis-container'])[1]");
	public static By taskGrpProdctOvrVw = By.xpath("(//div[@class='dhx_shape-container']/div)[1]");
	public static By startDD = By.xpath("(//button[@class='btn dropdown-toggle'])[2]");
	public static By resetButton = By.xpath("(//a[.='Reset'])[1]");
	private By searchBoxEle = By.xpath("//input[@placeholder='Search...']");
	private By searchBtnEle = By.xpath("//button[.=' Search ']");
	private By dwdReportIconEle = By.xpath("//a[@title='Download Report']");
	private By equipmentDDEle = By.xpath("//span[.='Equipment']");
	private By actionDropDown = By.xpath("(//button[@class='btn dropdown-toggle'])[2]");
	private By actionDropDownTG = By.xpath("(//button[@class='btn dropdown-toggle'])[1]");

	private By startOption = By.xpath("//div[@x-placement='bottom-start']/a[.='Start']");
	private By startTaskButton = By.xpath("//button[.='Start Task']");
	private By markAsCompleteOption = By.xpath("(//a[contains(text(),'Mark as Completed')])[2]");
	private By markAscompleteBtn = By.xpath("//button[contains(text(),'Mark as Completed')]");

	// ------------------------------------------------------------------
	private By taskGrpStatusSH = By.xpath("(//div[@class='large-font']/a)[2]");
	private By TGActualOrPlannedStartProdOv = By.xpath("(//div[@class='text'])[1]");
	private By TGActualOrPlannedEndProdOv = By.xpath("(//div[@class='text'])[2]");
	private By TGdelayHrsProdOv = By.xpath("(//div[@class='text'])[3]");
	private By TGActualOrPlannedStartSH = By
			.xpath("(//div[@class='d-flex align-items-center process-details-text ng-star-inserted'])[1]");
	private By TGActualOrPlannedEndSH = By
			.xpath("(//div[@class='d-flex align-items-center process-details-text ng-star-inserted'])[2]");
	private By TGdelayHrsSH = By.xpath("//div[@class='d-flex align-items-center process-details-text col-5 pl-0']");
	private By taskStatusSH = By.xpath("(//td[@class='no-border']/a)[1]");
	private By firstTaskPLStartTime = By.xpath("(//span[@title='Planned Start Date'])[1]");
	private By firstTaskActualStartTime = By.xpath("(//span[@title='Actual Start Date'])[1]");
	private By firstTaskPlEndTime = By.xpath("(//span[@title='Planned End Date'])[1]");
	private By firstTaskActualEndTimeSH = By.xpath("(//span[@title='Actual End Date'])[1]");
	private By toasterMessage = By.xpath("(//div[@role='alertdialog'])[1]");
	private By FirstTaskStartTimeProdOV = By.xpath("(//span[@class='text'])[1]");
	private By FirstTaskEndTimeProdOV = By.xpath("(//span[@class='text'])[2]");
	private By FirstTaskStatusProdOv = By.xpath("(//span[@class='text'])[3]");
	private By restartOptionSH = By.xpath("//a[contains(text(),'Restart')]");
	private By resetTaskOption = By.xpath("//div[@x-placement='bottom-start']/a[contains(text(),'Reset')]");
	private By startDatePicker = By.xpath("//input[@id='showStartDatePicker']");
	private By endDatePicker = By.xpath("//input[@id='showEndDatePicker']");
	public static By delayReasonOp = By.xpath("(//span[contains(text(), '" + delayReasonCode + "')])[1]"); // need to
	private By delayReasonAlert = By
			.xpath("//div[@class='d-flex justify-content-between align-items-center alert-root rounded mr-2']");
	private By delayReasonCodeProdOv = By
			.xpath("//div[@class='d-flex justify-content-between align-items-center alert-root rounded']");
	public static By delayStartReasonDD = By.xpath("(//div[@class='md-form font-16'])[1]");
	public static By additonalCmt = By.xpath("(//textarea[@placeholder='Additional Comment'])[1]");
	public static By logDelayButton = By.xpath("//button[.='Log Delay']");
	private By handOffMsg = By.xpath("//textarea[@placeholder='Handoff Message']");
	private By shiftHandOverCheckBox1 = By.xpath("//input[@id='taskUpdatedCheck']");
	private By shiftHandOverCheckBox2 = By.xpath("//input[@id='statusDelayCheck']");
	private By handoverToNxtShiftBtn = By.xpath("//a[.=' Handover to Next Shift']");
	private By ShiftHandoverConfirmationBtn = By.xpath("//button[contains(text(),'Handover')]");
	private By userName = By.xpath("//p[@id='navbarDropdown']");
	private By SLname = By.xpath("(//span[@class='value-lead'])[1]");
	private By handedOvBy = By.xpath("(//span[@class='value-lead'])[2]");
	private By sidetaskSH = By.xpath("(//div[@class='card custom-card']//following-sibling::table/tbody/tr/th)[1]");
	private By sideTaskVSB = By.xpath("((//div[@class='row'])[1]/div/p/span)[2]");
	private By sideTaskBtn = By.xpath("//button[contains(text(),'Side Task')]");
	private By sideTaskActionBtn = By.xpath("//div[.='SIDE TASK']/parent::div/table/tbody/tr/td/div/button");
	private By deleteSideTaskBtn = By.xpath("//a[.='Delete']");
	private By tasksInVSB = By.xpath("//div[@class='dhx_event_resize dhx_event_resize_start']");
	private By findSideTaskName = By.xpath("(//div[@class='font-16 black-font bold'])[1]");
	// ---------------------------------------------------------------------

//String Product overview	
	String tgStatusSH;
	String TGPlannedStartProdOv;
	String TGPlannedEndProdOv;
	String TaskGroupdelayHrsProdOv;
	String FirstTaskStartTimeinProdOV;
	String FirstTaskEndTimeinProdOV;
	String FirstTaskStatusinProdOv;

//String SH	
	String TGPlannedStartSH;
	String TGPlannedEndSH;
	String TaskGroupdelayHrsSH;
	String FirstTaskPlannedStartTimeSH;
	String FirstTaskActualStartTimeSH;
	String FirstTaskPlEndTimeSH;
	String ActualendDateSH;
	String taskStatus;
	String DelayreasonCode;
	String ToasterMessage = null;
	public static String reason = null;
	String ActualUsername;
	String ShiftLeadName;
	String HandOverByUSer;

//String VSB
	String sideTaskName;

	boolean toasterDisplayed;

	// -----------------------------
	public static By selectFirstBatch;
	public static String firstTaskName;
	String firstTaskNameInSHO = "null";

	public ShiftSummaryHandover(WebDriver driver) {

		this.driver = driver;
		vsb = new VSBpage(this.driver);
	}

	public void xpathReinitializtion() {
		if (EventProperties.actionLevel.equalsIgnoreCase("Task Group")) {
			System.out.println("Action will be on Task group level");
			actionDropDown = By.xpath("(//button[@class='btn dropdown-toggle'])[1]");
			startTaskButton = By.xpath("//button[.='Start']");
			startDatePicker = By.xpath("//input[@id='showEndDatePicker']");
			markAsCompleteOption = By.xpath("(//a[contains(text(),'Mark as Completed')])");
			markAscompleteBtn = By.xpath("//button/a[contains(text(),'Mark As Completed')]");

		} else {
			System.out.println("Action will be on task level");
		}
	}

	public void getTaskTimeFromPO(String APN, String firstTaskName2) throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		navigateTo = new Navigation(driver);
		firstTaskName = firstTaskName2.replace(" ", "");
		System.out.println(APN + "Displayed");
		Select product = new Select(driver.findElement(ProductNameDrop));
		String Finaltext = "";
		for (WebElement option : product.getOptions()) {
			System.out.println(APN.trim());
			System.out.println(option.getText().trim());
			if (APN.trim().contains(option.getText().trim())) {
				System.out.println("inside if condition");
				Finaltext = option.getText();
				product.selectByVisibleText(Finaltext);
				break;
			}
		}
		selectFirstBatch = By.xpath("//option[.='" + EventProperties.firstBatchNumber + " ']");
		System.out.println("Xpath to select first batch " + selectFirstBatch);
		driver.findElement(batchDD).click();
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
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		TGPlannedStartProdOv = driver.findElement(TGActualOrPlannedStartProdOv).getText();
		TGPlannedEndProdOv = driver.findElement(TGActualOrPlannedEndProdOv).getText();
		TGPlannedStartProdOv = TGPlannedStartProdOv.replaceAll(" ", "");
		TGPlannedEndProdOv = TGPlannedEndProdOv.replaceAll(" ", "");

		TaskGroupdelayHrsProdOv = driver.findElement(TGdelayHrsProdOv).getText();
		TaskGroupdelayHrsProdOv = TaskGroupdelayHrsProdOv.replace("hrs", "");
		System.out.println("---- Product overview Task group details print block start ---------");
		System.out.println(TGPlannedStartProdOv);
		System.out.println(TGPlannedEndProdOv);
		System.out.println(TaskGroupdelayHrsProdOv);
		System.out.println("---- Product overview Task group details print block Ends ---------");
		System.out.println(5000);
	}

	public void addSideTaskinVSB() throws InterruptedException {

		navigateTo.VSB();
		Thread.sleep(2000);

		driver.navigate().refresh();
		Thread.sleep(8000);
		driver.findElement(vsb.DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(9000);
		boolean b = false;
		System.out.println("tes case 27 started ");

		driver.findElement(sideTaskBtn).click();
		System.out.println("side task button is clicked ");
		Thread.sleep(3000);
		driver.findElement(vsb.sideTaskDropDown).click();
		System.out.println("side task drop down is clicked ");
		Thread.sleep(2000);
		driver.findElement(vsb.sideTaskType).click();
		System.out.println("side task type is selected ");
		Thread.sleep(1000);
		driver.findElement(vsb.addSideTask).click();
		Thread.sleep(2000);

		sideTaskName = driver.findElement(sideTaskVSB).getText();
		sideTaskName = sideTaskName.replaceAll(" ", "");
		System.out.println("VSB Side task Name " + sideTaskName);

	}

	public boolean verifyTheAvlOfShiftDetailsFiledTest() {
		try {
			driver.findElement(shiftDetailsFieled).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfDateBoxFiledTest() {
		try {
			driver.findElement(selectDate).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// ----------------------
	public void getTaskGroupDetailsSH() {
		//
		String txt1 = driver.findElement(TGActualOrPlannedStartSH).getText();
		String txt2 = txt1.replaceAll("\n", "");

		txt2 = txt2.replaceAll(" ", "");
		TGPlannedStartSH = txt2.replace("Pl.Start*:", "");
		TGPlannedStartSH = TGPlannedStartSH.replace("\n", "");

		String txt3 = driver.findElement(TGActualOrPlannedEndSH).getText();
		String txt4 = txt3.replaceAll("\n", "");
		txt4 = txt3.replaceAll(" ", "");
		TGPlannedEndSH = txt4.replace("Pl.End*:", "");
		TGPlannedEndSH = TGPlannedEndSH.replace("\n", "");
		TaskGroupdelayHrsSH = driver.findElement(TGdelayHrsSH).getText();
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replace("\n", "");
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replace("Hrs", "");
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replaceAll(" ", "");
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replace("Delay:", "");

		System.out.println("---- Shift Handover Task group details print block start ---------");
		System.out.println(TGPlannedStartSH);
		System.out.println(TGPlannedEndSH);
		System.out.println(TaskGroupdelayHrsSH);

		System.out.println("---- Shift Handover Task group details print block Ends ---------");

	}

	// -----------------------

	public boolean verifyAvlOfShiftTypeDDTest() {
		try {
			driver.findElement(shiftTypeDD).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfTeamFilterDropDownTest() {
		try {
			driver.findElement(teamFilterDD).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfRelaventFilterDDTest() {
		try {
			driver.findElement(relaventFilter).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfTaskTest() throws InterruptedException {
		boolean b = false;
		String firstTaskName = navigateTo.firstTaskNames.replace(" ", "");
		System.out.println("First task Name from Planner " + firstTaskName);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(5000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(2000);
		List<WebElement> shiftList = new ArrayList<WebElement>();
		shiftList = driver.findElements(shiftListEle);
		System.out.println(shiftList);
		driver.findElement(teamFilterDD).click();
		Thread.sleep(2000);
		for (int i = 1; i <= shiftList.size(); i++) {
			driver.findElement(shiftTypeDD).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@x-placement='bottom-start']/a)[" + i + "]")).click();
			Thread.sleep(2000);
			System.out.println("selected shift " + i);
			driver.findElement(teamFilterDD).click();
			List<WebElement> teamList = driver.findElements(teamListEle);
			driver.findElement(shiftTypeDD).click();
			for (int j = 1; j <= teamList.size(); j++) {
				Thread.sleep(2000);
				driver.findElement(teamFilterDD).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[@x-placement='bottom-start']/a)[" + j + "]")).click();
				System.out.println("selected team " + j);

				try {
					firstTaskNameInSHO = driver.findElement(firstTaskNameEle).getText().replace(" ", "");
					firstTaskNameInSHO = firstTaskNameInSHO.replace("\n", "");
				} catch (Exception e) {

				}

				System.out.println("First Task Name in Shift handover " + firstTaskNameInSHO);
				if (firstTaskNameInSHO.equalsIgnoreCase(firstTaskName)) {
					b = true;
					System.out.println("Inside if condition to break");
					break;
				}
//				---------------------------------------
				Thread.sleep(3000);
				if (!b) {
					driver.findElement(shiftTypeDD).click();
				} else {
					break;
				}
			}
//			------------------------
			Thread.sleep(3000);
			if (!b) {
				driver.findElement(shiftTypeDD).click();
			} else {
				break;
			}
		}

		return b;

	}

	public boolean addedSideTaskDisplayedInSH() {

		String sideTaskSH = driver.findElement(sidetaskSH).getText();
		sideTaskSH = sideTaskSH.replaceAll(" ", "");
		sideTaskSH = sideTaskSH.replace("\n", "");
		System.out.println("Sidetask name in VSB: " + sideTaskName);
		System.out.println("Sidetask name in SH:  " + sideTaskSH);
		boolean b = true;
		if (sideTaskName.equals(sideTaskSH)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean deleteSideTaskAndVerifyInVSB() throws InterruptedException {
		driver.findElement(sideTaskActionBtn).click();
		Thread.sleep(2000);
		driver.findElement(deleteSideTaskBtn).click();
		Thread.sleep(5000);
		System.out.println("Side task deleted from Shift handover");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		try {
			driver.findElement(sidetaskSH).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyTheAvlOfSearchBoxTest() {
		try {
			driver.findElement(searchBoxEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyAvlOfSearchBtnTest() {
		try {
			driver.findElement(searchBtnEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyAvlOfDwdReportIconTest() {
		try {
			driver.findElement(dwdReportIconEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyAvlOfEquipmentDropDownTest() {
		try {
			driver.findElement(equipmentDDEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean taskGroupStatusWhenNoTaskStarted() {
		tgStatusSH = driver.findElement(taskGrpStatusSH).getText();
		boolean b;
		if (tgStatusSH.equalsIgnoreCase("Not Started")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean TGPlannedStartTimeValidationWithProdOvWhenNoTaskStarted() {
		boolean b;

		System.out.println(TGPlannedStartSH);
		System.out.println(TGPlannedStartProdOv);
		if (TGPlannedStartSH.equalsIgnoreCase(TGPlannedStartProdOv)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean TGPlannedEndTimeValidationWithProdOvWhenNoTaskStarted() {
		boolean b;

		System.out.println(TGPlannedEndSH);
		System.out.println(TGPlannedEndProdOv);
		if (TGPlannedEndSH.equalsIgnoreCase(TGPlannedEndProdOv)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean TGDelayHrsValidationWithProdOvWhenNoTaskStarted() {
		boolean b;
		if (TaskGroupdelayHrsSH.equalsIgnoreCase(TaskGroupdelayHrsProdOv)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

//-------------------------------------------------------------------------------------------
	public boolean taskStatusWhenNotStarted() {
		String TaskStatus = driver.findElement(taskStatusSH).getText();
		boolean b;
		if (TaskStatus.equals("Not Started")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean taskAndTaskGrouptimeSynchInNotStarted() {
		String taskPlannedStartTimeSH = driver.findElement(firstTaskPLStartTime).getText();
		taskPlannedStartTimeSH = taskPlannedStartTimeSH.replaceAll(" ", "");
		this.FirstTaskPlannedStartTimeSH = taskPlannedStartTimeSH;
		boolean b;
		if (taskPlannedStartTimeSH.equalsIgnoreCase(TGPlannedStartSH)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean verifyUserCanStartTheTaskTest() throws InterruptedException {
		driver.findElement(actionDropDown).click();
		Thread.sleep(10000);
		driver.findElement(startOption).click();
		Thread.sleep(1000);
		driver.findElement(startTaskButton).click();
		Thread.sleep(1500);
		try {
			ToasterMessage = driver.findElement(toasterMessage).getText();
			toasterDisplayed = driver.findElement(toasterMessage).isDisplayed();
			ToasterMessage = ToasterMessage.replaceAll(" ", "");
			System.out.println(ToasterMessage);
		} catch (Exception e) {
			System.out.println("Toaster not displayed");
		}

		Thread.sleep(2800);
		boolean b;
		String taskStatus = driver.findElement(taskStatusSH).getText();
		if (taskStatus.equalsIgnoreCase("In-progress")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean toasterValidationAftertaskStarted() {
		boolean b;
		if (ToasterMessage.equalsIgnoreCase("taskstatusupdatedsuccessfully")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean taskGroupStatusWhenFirstTaskStarted() {
		boolean b;
		tgStatusSH = driver.findElement(taskGrpStatusSH).getText();
		if (tgStatusSH.equalsIgnoreCase("in-progress")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean taskAdnTaskGroupTimeSynchWhenInProgress() {
		boolean b;

		FirstTaskActualStartTimeSH = driver.findElement(firstTaskActualStartTime).getText();
		FirstTaskActualStartTimeSH = FirstTaskActualStartTimeSH.replaceAll(" ", "");
		FirstTaskPlEndTimeSH = driver.findElement(firstTaskPlEndTime).getText();
		FirstTaskPlEndTimeSH = FirstTaskPlEndTimeSH.replaceAll(" ", "");
		if (FirstTaskActualStartTimeSH.equalsIgnoreCase(TGPlannedStartSH)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean startTimeSynchValidationWhenInProgress() throws InterruptedException {
		navigateTo.productOverview();
		Thread.sleep(2000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		FirstTaskStartTimeinProdOV = driver.findElement(FirstTaskStartTimeProdOV).getText();
		FirstTaskStartTimeinProdOV = FirstTaskStartTimeinProdOV.replaceAll(" ", "");
		FirstTaskStartTimeinProdOV = FirstTaskStartTimeinProdOV.replaceAll("&nbsp;", "");

		System.out.println(FirstTaskActualStartTimeSH);
		System.out.println(FirstTaskStartTimeinProdOV);
		boolean b;
		if (FirstTaskActualStartTimeSH.equalsIgnoreCase(FirstTaskStartTimeinProdOV)) {
			b = true;
		}

		else {
			b = false;
		}
		return b;

	}

	public boolean taskStatusInprodOvWhenTaskInProgress() {

		boolean b;
		FirstTaskStatusinProdOv = driver.findElement(FirstTaskStatusProdOv).getText();
		System.out.println(FirstTaskStatusinProdOv);

		if (FirstTaskStatusinProdOv.equalsIgnoreCase("In-progress")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean EndTimeSynchValidationWhenInProgress() {
		FirstTaskEndTimeinProdOV = driver.findElement(FirstTaskEndTimeProdOV).getText();
		FirstTaskEndTimeinProdOV = FirstTaskEndTimeinProdOV.replaceAll(" ", "");
		boolean b;
		if (FirstTaskPlEndTimeSH.equalsIgnoreCase(FirstTaskEndTimeinProdOV)) {
			b = true;
		}

		else {
			b = false;
		}

		return b;
	}

	public void resetTaskProdOvAndNavigateBacktoSH() throws InterruptedException {
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

		navigateTo.Shifthandover();
		Thread.sleep(2000);
		verifyAvlOfTaskTest();

	}

	public boolean completeTaskSH() throws InterruptedException {
		driver.findElement(actionDropDown).click();
		Thread.sleep(1000);
		driver.findElement(startOption).click();
		Thread.sleep(1000);
		driver.findElement(startTaskButton).click();
		Thread.sleep(7000);
		driver.findElement(actionDropDown).click();
		Thread.sleep(1200);
		driver.findElement(markAsCompleteOption).click();
		Thread.sleep(1200);
		driver.findElement(markAscompleteBtn).click();
		Thread.sleep(1800);

		try {
			toasterDisplayed = driver.findElement(toasterMessage).isDisplayed();
			ToasterMessage = driver.findElement(toasterMessage).getText();
			ToasterMessage = ToasterMessage.replace(" ", "");
			System.out.println("is toaster displayed after completing the task? " + toasterDisplayed);
			System.out.println("toaster msg: " + ToasterMessage);
		} catch (Exception e) {
			System.out.println("Mark as complete toaster not displayed");
		}
		Thread.sleep(3200);

		String taskStatusPostclose = driver.findElement(taskStatusSH).getText();
		boolean b;
		if (taskStatusPostclose.equalsIgnoreCase("CLOSED")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean ToasterValidationOnCompleteTask() {
		boolean b;
		if (toasterDisplayed == true && ToasterMessage.equalsIgnoreCase("taskstatusupdatedsuccessfully")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean ActualEndTimeUpdatedPostTaskComplete() {
		ActualendDateSH = driver.findElement(firstTaskActualEndTimeSH).getText();
		ActualendDateSH = ActualendDateSH.replaceAll(" ", "");
		ActualendDateSH = ActualendDateSH.replace("&nbsp;", "");
		boolean b;
		if (FirstTaskPlEndTimeSH.equalsIgnoreCase(ActualendDateSH)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean taskStatusValidateInProdOvInAfterComplete() throws InterruptedException {
		navigateTo.productOverview();
		Thread.sleep(2000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2500);
		FirstTaskEndTimeinProdOV = driver.findElement(FirstTaskEndTimeProdOV).getText();
		FirstTaskEndTimeinProdOV = FirstTaskEndTimeinProdOV.replaceAll(" ", "");
		FirstTaskEndTimeinProdOV = FirstTaskEndTimeinProdOV.replace("&nbsp;", "");
		boolean b;
		FirstTaskStatusinProdOv = driver.findElement(FirstTaskStatusProdOv).getText();
		if (FirstTaskStatusinProdOv.equalsIgnoreCase("CLOSED")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean TaskStartTimeSynchInProdOVPostComplete() {
		boolean b;
		if (FirstTaskStartTimeinProdOV.equalsIgnoreCase(FirstTaskActualStartTimeSH)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean TaskEndTimeSynchInProdOVPostComplete() {
		boolean b;
		if (ActualendDateSH.equalsIgnoreCase(FirstTaskEndTimeinProdOV)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

//---------------------------7th Aug-----------------------------------------------
	public boolean restartTaskSH() throws InterruptedException {
		navigateTo.Shifthandover();
		Thread.sleep(2000);
		verifyAvlOfTaskTest();
		Thread.sleep(2000);
		driver.findElement(startDD).click();
		Thread.sleep(1500);
		driver.findElement(restartOptionSH).click();
		System.out.println("Restart option clicked");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(1800);
		System.out.println("Restart alert accepted");
		try {
			toasterDisplayed = driver.findElement(toasterMessage).isDisplayed();
			ToasterMessage = driver.findElement(toasterMessage).getText();
			ToasterMessage = ToasterMessage.replaceAll(" ", "");
			System.out.println("Restart toaster " + ToasterMessage);
		} catch (Exception e) {
			System.out.println("Toaster message not displayed after restart task");
		}
		Thread.sleep(6000);
		boolean b = true;
		System.out.println("tg status expected " + tgStatusSH);
		taskStatus = driver.findElement(taskStatusSH).getText();
		System.out.println("task status expected " + taskStatus);
		if (tgStatusSH.equalsIgnoreCase("in-progress") && taskStatus.equalsIgnoreCase("in-progress")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean toasterDiaplyedAfterRestart() {
		boolean b;
		if (toasterDisplayed = true && ToasterMessage.equalsIgnoreCase("Taskstatusupdatedsuccessfully")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean VerifyTaskEndDateFieldUpdatedToNAPostRestart() {
		ActualendDateSH = driver.findElement(firstTaskActualEndTimeSH).getText();
		ActualendDateSH = ActualendDateSH.replace(" ", "");
		ActualendDateSH = ActualendDateSH.replace("&nbsp;", "");
		boolean b;
		if (ActualendDateSH.equalsIgnoreCase("N/A")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean TasStatusSynchInProdOvPostRestart() throws InterruptedException {
		navigateTo.productOverview();
		Thread.sleep(2000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		FirstTaskStatusinProdOv = driver.findElement(FirstTaskStatusProdOv).getText();
		FirstTaskStatusinProdOv = FirstTaskStatusinProdOv.replaceAll(" ", "");
		boolean b;
		if (FirstTaskStatusinProdOv.equalsIgnoreCase("In-progress")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean taskTimeSynchTestInProdOVPostRestart() {
		System.out.println(FirstTaskStartTimeinProdOV);
		System.out.println(FirstTaskActualStartTimeSH);
		boolean b;
		if (FirstTaskStartTimeinProdOV.equals(FirstTaskActualStartTimeSH)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean taskEndSynchTestInProdOVPostRestart() {
		System.out.println(FirstTaskEndTimeinProdOV);
		System.out.println(FirstTaskPlEndTimeSH);
		boolean b;
		if (FirstTaskEndTimeinProdOV.equalsIgnoreCase(FirstTaskPlEndTimeSH)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean resetTaskFromSH() throws InterruptedException {
		navigateTo.Shifthandover();
		verifyAvlOfTaskTest();
		Thread.sleep(2000);
		driver.findElement(startDD).click();
		Thread.sleep(1500);
		driver.findElement(resetTaskOption).click();
		Thread.sleep(1500);
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		try {
			toasterDisplayed = driver.findElement(toasterMessage).isDisplayed();
			ToasterMessage = driver.findElement(toasterMessage).getText();
			ToasterMessage = ToasterMessage.replace(" ", "");
		} catch (Exception e) {
			System.out.println("toaster message not displayed after reset task");
		}

		Thread.sleep(6000);
		boolean b = true;
		tgStatusSH = driver.findElement(taskGrpStatusSH).getText();
		System.out.println("tg status expected " + tgStatusSH);
		taskStatus = driver.findElement(taskStatusSH).getText();
		System.out.println("task status expected " + taskStatus);
		if (tgStatusSH.equalsIgnoreCase("Not Started") && taskStatus.equalsIgnoreCase("Not Started")) {
			b = true;
		} else {
			b = false;
		}

		return b;

	}

	public boolean resetTaskToaster() {
		boolean b;
		if (toasterDisplayed = true && ToasterMessage.equalsIgnoreCase("Taskstatusupdatedsuccessfully")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean plannedStartTimeValidationPostReset() {
		String plStarttime = driver.findElement(firstTaskPLStartTime).getText();
		plStarttime = plStarttime.replaceAll(" ", "");
		FirstTaskPlannedStartTimeSH = plStarttime;
		System.out.println("--------plannedStartTimeValidationPostReset---------");
		System.out.println(FirstTaskPlannedStartTimeSH);
		System.out.println(plStarttime);
		boolean b;
		if (FirstTaskPlannedStartTimeSH.equalsIgnoreCase(plStarttime)) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean plannedEndTimeValidationPostReset() {
		String plannedEndTime = driver.findElement(firstTaskPlEndTime).getText();
		plannedEndTime = plannedEndTime.replace(" ", "");
		FirstTaskPlEndTimeSH = plannedEndTime;
		System.out.println("-----plannedEndTimeValidationPostReset------");
		System.out.println(FirstTaskPlEndTimeSH);
		System.out.println(plannedEndTime);
		boolean b;
		if (FirstTaskPlEndTimeSH.equalsIgnoreCase(plannedEndTime)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean plannedStartTimeSynchINProdOVPostReset() throws InterruptedException {
		navigateTo.productOverview();
		Thread.sleep(2000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		FirstTaskStartTimeinProdOV = driver.findElement(FirstTaskStartTimeProdOV).getText();
		FirstTaskStartTimeinProdOV = FirstTaskStartTimeinProdOV.replaceAll(" ", "");
		System.out.println(FirstTaskPlannedStartTimeSH);
		System.out.println(FirstTaskStartTimeinProdOV);
		boolean b;
		if (FirstTaskPlannedStartTimeSH.equalsIgnoreCase(FirstTaskStartTimeinProdOV)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean plannedEndTimeSynchINProdOVPostReset() {
		FirstTaskEndTimeinProdOV = driver.findElement(FirstTaskEndTimeProdOV).getText();
		FirstTaskEndTimeinProdOV = FirstTaskEndTimeinProdOV.replace(" ", "");
		System.out.println(FirstTaskPlEndTimeSH);
		System.out.println(FirstTaskEndTimeinProdOV);
		boolean b;
		if (FirstTaskPlEndTimeSH.equalsIgnoreCase(FirstTaskEndTimeinProdOV)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean DelayedStartSH() throws InterruptedException {
		navigateTo.Shifthandover();
		verifyAvlOfTaskTest();
		Thread.sleep(2000);
		driver.findElement(actionDropDown).click();
		Thread.sleep(2000);
		driver.findElement(startOption).click();
		Thread.sleep(1200);
		driver.findElement(startDatePicker).sendKeys(EventProperties.task_Date);
		Actions action = new Actions(driver);
		Thread.sleep(1500);
		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		driver.findElement(startTaskButton).click();
		Thread.sleep(1500);
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
		Thread.sleep(1500);
		try {
			toasterDisplayed = driver.findElement(toasterMessage).isDisplayed();
			ToasterMessage = driver.findElement(toasterMessage).getText();
			ToasterMessage = ToasterMessage.replaceAll(" ", "");
		} catch (Exception e) {
			System.out.println("No toaster displayed in Delayed Start");
		}
		Thread.sleep(5000);
		tgStatusSH = driver.findElement(taskGrpStatusSH).getText();
		boolean b = true;
		System.out.println("tg status expected " + tgStatusSH);
		taskStatus = driver.findElement(taskStatusSH).getText();
		System.out.println("task status expected " + taskStatus);
		if (tgStatusSH.equalsIgnoreCase("in-progress") && taskStatus.equalsIgnoreCase("in-progress")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean toasterValidationPostDelayedStart() {
		boolean b;
		if (toasterDisplayed = true && ToasterMessage.equalsIgnoreCase("DelayUpdatedSuccessfully!!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean delayReasonCodeAlertPoStDelayedStart() {
		boolean b = true;
		try {
			String DelayreasonCode = driver.findElement(delayReasonAlert).getText();
			this.DelayreasonCode = DelayreasonCode;
			System.out.println(DelayreasonCode);
			if (DelayreasonCode.contains("Automation_Delay_Code")) {
				b = true;
			} else {
				b = false;
			}
		} catch (Exception e) {
			System.out.println("Delay reason code not displayed");
			b = false;
		}

		return b;

	}

	public boolean taskAndTaskGroupStartTimeSynchPostDelayedStart() {
		FirstTaskActualStartTimeSH = driver.findElement(firstTaskActualStartTime).getText();
		FirstTaskActualStartTimeSH = FirstTaskActualStartTimeSH.replaceAll(" ", "");

		getTaskGroupDetailsSH();
		TGPlannedStartSH = TGPlannedStartSH.replace("Start:", "");
		System.out.println(FirstTaskActualStartTimeSH);
		System.out.println(TGPlannedStartSH);
		boolean b;
		if (FirstTaskActualStartTimeSH.equalsIgnoreCase(TGPlannedStartSH)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean delayHrsValOnTaskGroupOnDelayedStartSH() {
		TaskGroupdelayHrsSH = driver.findElement(TGdelayHrsSH).getText();
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replace("\n", "");
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replace("Hrs", "");
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replaceAll(" ", "");
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replace("Delay:", "");

		boolean b;
		if (TaskGroupdelayHrsSH.equalsIgnoreCase("2")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean TasktimeSynchInProdOvOnDelayedStart() throws InterruptedException {
		FirstTaskPlEndTimeSH = driver.findElement(firstTaskPlEndTime).getText();
		FirstTaskPlEndTimeSH = FirstTaskPlEndTimeSH.replace(" ", "");
		System.out.println("------Shift handover task and task group details--------");
		System.out.println("First task actual start time in SH: " + FirstTaskActualStartTimeSH);
		System.out.println("First task planned End time in SH: " + FirstTaskPlEndTimeSH);

		// doubt on print statement( May be declairing wrong value)

		System.out.println("Task group Actual Start SH: " + TGPlannedEndSH);
		System.out.println("Task group planned in SH: " + TGPlannedEndSH);

		navigateTo.productOverview();
		Thread.sleep(2000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		FirstTaskStartTimeinProdOV = driver.findElement(FirstTaskStartTimeProdOV).getText();
		FirstTaskStartTimeinProdOV = FirstTaskStartTimeinProdOV.replaceAll(" ", "");
		FirstTaskStartTimeinProdOV = FirstTaskStartTimeinProdOV.replace("&nbsp;", "");

		FirstTaskEndTimeinProdOV = driver.findElement(FirstTaskEndTimeProdOV).getText();
		FirstTaskEndTimeinProdOV = FirstTaskEndTimeinProdOV.replaceAll(" ", "");
		FirstTaskEndTimeinProdOV = FirstTaskEndTimeinProdOV.replace("&nbsp;", "");

		TGPlannedStartProdOv = driver.findElement(TGActualOrPlannedStartProdOv).getText();
		TGPlannedStartProdOv = TGPlannedStartProdOv.replaceAll(" ", "");
		TGPlannedEndProdOv = driver.findElement(TGActualOrPlannedEndProdOv).getText();
		TGPlannedEndProdOv = TGPlannedEndProdOv.replaceAll(" ", "");

		System.out.println("--------Product Overview task and task group details----------");
		System.out.println(FirstTaskStartTimeinProdOV);
		System.out.println(FirstTaskEndTimeinProdOV);
		TaskGroupdelayHrsProdOv = driver.findElement(TGdelayHrsProdOv).getText();
		TaskGroupdelayHrsProdOv = TaskGroupdelayHrsProdOv.replace("hrs", "");
		System.out.println(TaskGroupdelayHrsProdOv);
		System.out.println(TGPlannedStartProdOv);
		System.out.println(TGPlannedEndProdOv);
		boolean b;
		if (FirstTaskActualStartTimeSH.equalsIgnoreCase(FirstTaskStartTimeinProdOV)
				&& FirstTaskPlEndTimeSH.equalsIgnoreCase(FirstTaskEndTimeinProdOV)) {
			b = true;
		} else {
			b = false;
		}

		return b;

	}

	public boolean TGDelayHrsvalidationOnDelayedStartProdOv() {
		boolean b;
		if (TaskGroupdelayHrsProdOv.equalsIgnoreCase("2")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean TgTimeSynchwithProdOvOnDelayedStart() {
		boolean b;

		if (TGPlannedStartSH.equalsIgnoreCase(TGPlannedStartSH)
				&& TGPlannedEndSH.equalsIgnoreCase(TGPlannedEndProdOv)) {
			b = true;

		} else {
			b = false;
		}
		return b;
	}

	public boolean delayReasonCodeSynchTestInProdOvOnDelayedStart() {
		boolean b = true;
		try {
			String DelayreasonCode = driver.findElement(delayReasonCodeProdOv).getText();
			this.DelayreasonCode = DelayreasonCode;
			System.out.println(DelayreasonCode);
			if (DelayreasonCode.contains("Automation_Delay_Code")) {
				b = true;
			} else {
				b = false;
			}
		} catch (Exception e) {
			System.out.println("Delay reason code not displayed");
			b = false;
		}

		return b;
	}

	// ---------------------------------------------
	public boolean ResetTaskPostDelayedStart() throws InterruptedException {
		navigateTo.Shifthandover();
		verifyAvlOfTaskTest();
		FirstTaskPlannedStartTimeSH = driver.findElement(firstTaskPLStartTime).getText();
		FirstTaskPlannedStartTimeSH = FirstTaskPlannedStartTimeSH.replaceAll(" ", "");

		Thread.sleep(2000);
		driver.findElement(startDD).click();
		Thread.sleep(1500);
		driver.findElement(resetTaskOption).click();
		Thread.sleep(1500);
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		try {
			toasterDisplayed = driver.findElement(toasterMessage).isDisplayed();
			ToasterMessage = driver.findElement(toasterMessage).getText();
			ToasterMessage = ToasterMessage.replace(" ", "");
		} catch (Exception e) {
			System.out.println("toaster message not displayed after reset task");
		}

		Thread.sleep(6000);
		boolean b = true;
		tgStatusSH = driver.findElement(taskGrpStatusSH).getText();
		System.out.println("tg status expected " + tgStatusSH);
		taskStatus = driver.findElement(taskStatusSH).getText();
		System.out.println("task status expected " + taskStatus);
		if (tgStatusSH.equalsIgnoreCase("Not Started") && taskStatus.equalsIgnoreCase("Not Started")) {
			b = true;
		} else {
			b = false;
		}

		return b;

	}

	public boolean resetTaskToasterPostDelayedStartValidation() {

		boolean b;
		if (toasterDisplayed = true && ToasterMessage.equalsIgnoreCase("Taskstatusupdatedsuccessfully")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean taskGroupPlStartTimeValidationOnDelayedStartReset() {
		driver.findElement(TGActualOrPlannedStartSH).getText();
		String txt1 = driver.findElement(TGActualOrPlannedStartSH).getText();
		String txt2 = txt1.replaceAll("\n", "");

		txt2 = txt2.replaceAll(" ", "");
		TGPlannedStartSH = txt2.replace("Pl.Start*:", "");
		TGPlannedStartSH = TGPlannedStartSH.replace("\n", "");
		boolean b;
		if (FirstTaskPlannedStartTimeSH.equalsIgnoreCase(TGPlannedStartSH)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean delayedFinishSH() throws InterruptedException {

		verifyUserCanStartTheTaskTest();
		Thread.sleep(5000);

		driver.findElement(actionDropDown).click();
		Thread.sleep(1200);
		driver.findElement(markAsCompleteOption).click();
		Thread.sleep(1500);
		driver.findElement(endDatePicker).sendKeys(task_Date);
		Actions action = new Actions(driver);
		Thread.sleep(1500);
		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		driver.findElement(markAscompleteBtn).click();

		Thread.sleep(1500);
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
		Thread.sleep(1500);
		try {
			toasterDisplayed = driver.findElement(toasterMessage).isDisplayed();
			ToasterMessage = driver.findElement(toasterMessage).getText();
			ToasterMessage = ToasterMessage.replaceAll(" ", "");
		} catch (Exception e) {
			System.out.println("No toaster displayed in Delayed Start");
		}
		Thread.sleep(5000);
		tgStatusSH = driver.findElement(taskGrpStatusSH).getText();
		boolean b = true;
		System.out.println("tg status expected " + tgStatusSH);
		taskStatus = driver.findElement(taskStatusSH).getText();
		System.out.println("task status expected " + taskStatus);
		if (tgStatusSH.equalsIgnoreCase("in-progress") && taskStatus.equalsIgnoreCase("CLOSED")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean ToasterValidationAfterDelayedFinish() {
		boolean b;
		if (ToasterMessage.equalsIgnoreCase("DelayUpdatedSuccessfully!!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean delayAlertvalidationOnDelayedStartSH() {
		boolean b = true;
		try {
			String DelayreasonCode = driver.findElement(delayReasonAlert).getText();
			this.DelayreasonCode = DelayreasonCode;
			System.out.println(DelayreasonCode);
			if (DelayreasonCode.contains("Automation_Delay_Code")) {
				b = true;
			} else {
				b = false;
			}
		} catch (Exception e) {
			System.out.println("Delay reason code not displayed");
			b = false;
		}

		return b;

	}

	public boolean delayHrSValidationOnTGonDelayedFinish() {
		TaskGroupdelayHrsSH = driver.findElement(TGdelayHrsSH).getText();
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replace("\n", "");
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replace("Hrs", "");
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replaceAll(" ", "");
		TaskGroupdelayHrsSH = TaskGroupdelayHrsSH.replace("Delay:", "");
		boolean b;
		System.out.println("Delay hrs on tg post delayed finish " + TaskGroupdelayHrsSH);
		if (TaskGroupdelayHrsSH.equalsIgnoreCase("2")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public void getPreHandoverDetails() {
		ActualUsername = driver.findElement(userName).getText();
		ShiftLeadName = driver.findElement(SLname).getText();
		HandOverByUSer = driver.findElement(handedOvBy).getText();
		System.out.println("-----getPreHandoverDetails----");

		System.out.println(ActualUsername);
		System.out.println(ShiftLeadName);
		System.out.println(HandOverByUSer);

	}

	public boolean ShifthandoverAction() throws InterruptedException {
		Thread.sleep(2500);
		driver.findElement(handOffMsg).sendKeys("TestHandOffMSG");
		Thread.sleep(2500);
		driver.findElement(shiftHandOverCheckBox1).click();
		Thread.sleep(2500);
		driver.findElement(shiftHandOverCheckBox2).click();
		Thread.sleep(2500);

		Actions a = new Actions(driver);
		// scroll down a page
		a.sendKeys(Keys.PAGE_DOWN).build().perform();

		Thread.sleep(2500);

		driver.findElement(handoverToNxtShiftBtn).click();
		Thread.sleep(1500);
		driver.findElement(ShiftHandoverConfirmationBtn).click();
		Thread.sleep(1500);
		try {
			ToasterMessage = driver.findElement(toasterMessage).getText();
			ToasterMessage = ToasterMessage.replaceAll(" ", "");
			System.out.println("Shift handover toaster is " + ToasterMessage);
			// Handoverdonesuccessfully
		} catch (Exception e) {
			System.out.println("Toaster Message not displayed after shift handover");
		}
		Thread.sleep(4000);
		boolean b;

		if (driver.findElement(handoverToNxtShiftBtn).isEnabled() && !HandOverByUSer.equals("N/A")) {
			b = false;
		} else {
			b = true;

		}

		return b;

	}

	public boolean shiftHandoverToaster() {
		boolean b;
		if (ToasterMessage.equalsIgnoreCase("Handoverdonesuccessfully")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean postSshiftHandoverVal() throws InterruptedException {
		boolean b;
		Thread.sleep(4000);
		System.out.println("postVal User Details");
		getPreHandoverDetails();
		System.out.println("----Post shift handover-----");
		System.out.println("SL Name " + ShiftLeadName);
		System.out.println("User name " + ActualUsername);
		System.out.println("handover by " + HandOverByUSer);
		if (ShiftLeadName.equals(ShiftLeadName) && ActualUsername.equals(HandOverByUSer)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean disableActionPosthandover() {
		boolean b;
		try {
			driver.findElement(actionDropDown).click();
			Thread.sleep(2000);
			driver.findElement(startOption).isDisplayed();
			Thread.sleep(1000);
			b = false;
		} catch (Exception e) {
			System.out.println("After shift handover Action buttons are disabled which is expected");
			b = true;
		}
		return b;

	}

}