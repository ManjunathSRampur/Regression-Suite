package com.qa.bps.pages;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;
import com.qa.bps.utils.ExcelUtil;

public class ManagerView {

	WebDriver driver;
	JDBC jdbc;
	ShiftSummaryHandover sshandover;
	Navigation navigateTo;
	private By notReqFile = By.xpath("//div[.='Day' or .= 'Week' or.= 'Month' or .= 'Timeline']");
	private By weekDatePicker = By.xpath("//input[@id='selectedWeek']");
	private By refreshBtn = By.xpath("//a[.='Refresh']");
	private By saveBtn = By.xpath("//a[.='Save']");
	private By dayViewBtn = By.xpath("//a[.='Day View']");
	private By alertBtn = By.xpath("//button[.='Alerts']");
	private By selectDate = By.xpath("//input[@id='selectedDate']");
	private By shiftTypeDD = By.xpath("(//button[@data-toggle='dropdown'])[1]");
	private By shiftTypeList = By.xpath("(//div[contains(@class,'dropdown-menu customHeight')])[1]/a");
	private By selectTeamDD = By.xpath("//div[@class='selected-list']");
	private By teamList = By.xpath("//ul[@class='lazyContainer']/li");
	private By availableTaskList = By.xpath("//div[@class='d-flex h-100 w-100']");
	private By taskTollTip = By.xpath("(//div[@role='tooltip']/div)[1]");
	private By downloadConstraintBtn = By.xpath("//img[@title='Download Constraints']");
	private By weekView = By.xpath("//a[.='Week View']");
	private By sideTaskButton = By.xpath("//button[.=' Side Task ']");
	private By zoomInbtn = By.xpath("//a[@title='Zoom In']");
	private By zoomOutbtn = By.xpath("//a[@title='Zoom Out']");
	private By fullScreenBtn = By.xpath("//img[contains(@src,'fullscreen.png')]");
	private By defineShiftInFc = By.xpath("//div[@tabulator-field='shift_name']");
	private By shiftNameInFc = By.xpath("(//div[@tabulator-field='shift_name'])[2]");
	private By shiftStartTimeInFc = By
			.xpath("(//div[@tabulator-field='shift_name'])[2]/following-sibling::div[@tabulator-field='start_time']");
	private By shiftEndTimeInFc = By
			.xpath("(//div[@tabulator-field='shift_name'])[2]/following-sibling::div[@tabulator-field='end_time']");
	private By shiftStartTimeInMv = By.xpath("(//div[@data-col-id='0'])[1]");
	private By shiftEndTimeInMv = By.xpath("(//div[@class='dhx_scale_bar '])[last()]");
	private By teamNameListInGrid = By.xpath("//div[@class='section_name']");
	private By addOperatorBtn = By.xpath("//a[.='Add Operator']");
	private By selectTeamDDInOperatorStatus = By.xpath("(//button[@data-toggle='dropdown'])[2]");
	private By selectFirstTeam = By.xpath("(//div[@x-placement='bottom-start']/a)[1]");
	private By selecteOperatorDD = By.xpath("(//button[@id='dropdownMenuButton'])[1]");
	private By selectOperatorTeamDD = By.xpath("(//ul[@aria-labelledby='dropdownMenuButton']/li)[1]");
	private By selectUser = By.xpath("(//ul[@aria-labelledby='dropdownMenuButton']/li/ul/li)[1]");
	private By submitStatusBtn = By.xpath("//button[.='Submit Status']");
	private By toasterMessage = By.xpath("(//div[@role='alertdialog'])[last()]");
	private By tempOperatorAvl = By.xpath("//span[@class='temp']");
	private By operatorStatusViewBtn = By.xpath("(//div[.='View '])[1]");
	private By operatorStatusDeleteBtn = By.xpath("(//div[@class='d-flex']/*)[2]");
	private By getFirstOperator = By.xpath("(//div[@data-row-index='0']/div/div/div)[1]");
	private By logEvent = By.xpath("(//div[@class='font-medium']/*)[1]");
	private By chooseCategoryDD = By.xpath("//div[.=' Choose Category ']");
	private By employeeUnAvailableEle = By.xpath("//a[.=' Employee Unavailable ']");
	private By selectResourceDD = By.xpath("//div[.=' Select Resource ']");
	private By selectResourceSearchBox = By.xpath("(//input[@placeholder='Search'])[3]");
	private By selectFirstResource = By.xpath("(//div[@x-placement='bottom-start']/a)[1]");
	private By selecteTypeDD = By.xpath("//div[.=' Select Type ']");
	private By plannedLeaveEle = By.xpath("//a[.=' Leave - Planned ']");
	private By operatorUnAvlFromDate = By.xpath("(//input[@id='startDate'])[2]");
	private By operatorUnAvlEndDate = By.xpath("//input[@id='endDate']");
	private By addButtonInLogEvent = By.xpath("(//button[.='Add'])[2]");
	private By deleteIconInGridView = By.xpath("//img[@class='delete_img']");
	private By logEventSummmaryTab = By.xpath("(//div[.='Summary '])[1]");
	private By operatorUnAvlAlertEle = By.xpath("//div[contains(text(),'Employee Unavailable:')]");
	private By closeWindow = By.xpath("//div[@class='close-button']");
	private By equipmentUnAvlOp = By.xpath("//a[.=' Equipment Unavailable ']");
	private By equipmentDownReason = By.xpath("//a[.=' Maintenance ']");
	private By equipmentDownAlert = By.xpath("//div[contains(text(),'Equipment Unavailable:')]");
	private By buildingGroupDD = By.xpath("//div[.=' Building Group Filter ']");
	private By buildingGroupOption = By.xpath("(//div[@x-placement='bottom-start']/a)[1]");
	private By alertFromDateEle = By.xpath("(//div[@class='date-picker']/input)[1]");
	private By alertToDateEle = By.xpath("(//div[@class='date-picker']/input)[2]");
	private By alertMessage = By.xpath("(//textarea)[1]");
	private By alertSubmitButton = By.xpath("//button[.='Submit']");
	private By viewBtnInAlertTab = By.xpath("(//div[.='View '])[1]");
	private By alertMsgEle = By.xpath("//a[.='Alert Message']");
	private By alertWindowCloseBtn = By.xpath("//div[@class='modal-header header-tab']/button/span");
	private By alertDeleteIcon = By.xpath("(//div[@class='d-flex']/*)[2]");
	private By addedCommentEle = By.xpath("//a[.='Alert Message']/parent::div");
	private By sideTaskDD = By.xpath("(//span[@class='mat-content'])[1]");
	private By firstSideTask = By.xpath("(//div[@class='card'])[1]");
	private By sideTaskName = By.xpath("((//div[@class='card'])[1]/div/div/p/span)[2]");
	private By selectEquipment = By.xpath("//div[.=' Select Equipment ']");
	private By sideTaskSearch = By.xpath("(//input[@placeholder='Search'])[2]");
	private By selectEquipmentOp = By.xpath("//div[@x-placement='bottom-start']/a");
	private By selectOperatorDD = By.xpath("//button[@id='dropdownMenuButton']");
	private By selectTeamToSideTask = By.xpath("(//ul[@aria-labelledby='dropdownMenuButton']/li)[1]");
	private By selectUserForSideTask = By.xpath("(//li[@class='ng-star-inserted']/a)[2]");
	private By dateForSideTask = By.xpath("//input[@id='startDate']");
	private By addSideTaskButton = By.xpath("//button[.='Add']");
	private By getFirstTaskTime = By.xpath("(//div[@class='dhx_scale_bar '])[1]");
	private By taskDurationButton = By.xpath("(//div[.=' Task Duration '])[2]");
	private By shiftHours = By.xpath("//div[@class='dhx_scale_bar ']");
	private By sideTaskBannerInSho = By.xpath("//span[@class='sideTask']");
	private By taskDurationStartDatePicker = By.xpath("(//div[@class='modal-body']/input)[2]");
	private By taskDurationEndDatePicker = By.xpath("(//div[@class='modal-body']/input)[3]");
	private By closeIconForTaskDuration = By.xpath("(//button[@class='close']/span)[2]");
	private By sideTaskStartTimeInSho = By
			.xpath("(//span[@class='sideTask']/parent::div/parent::div/following-sibling::table/tbody/tr/td/span)[1]");
	private By sideTaskEndTimeInSho = By
			.xpath("(//span[@class='sideTask']/parent::div/parent::div/following-sibling::table/tbody/tr/td/span)[2]");
	private By deleteSideTask = By.xpath("//div[.=' Delete ']");
	private By divideTaskButton = By.xpath("//div[.=' Divide Task ']");
	private By allocatedOperatorInMv = By.xpath("//button[@id='dropdownMenuButton']/div[@class='btn-text']");
	private By allocatedOperatorInPov = By
			.xpath("((//div[contains(@class,'col-10 pr-0')])[1]/div/div)[4]/div/*/div/span");
	private By taskDurationBtnTest = By.xpath("//div[.=' Task Duration ']");
	private By firstTaskStartTimeInPov = By.xpath("(//span[@class='text'])[1]");
	private By firstTaskEndTimeInPov = By.xpath("(//span[@class='text'])[2]");
	private By updateTaskDurationBtn = By.xpath("(//button[.='Update'])[1]");
	private By sideTaskEle;
	private By sideTaskInVSB;

	String alertInManagerView;
	String alertInDB;
	String sideTaskStartTimeBeforDrag;
	String sideTaskEndTimeBeforeDrag;
	String sideTaskStartTimeAfterDrag;

	String firstTaskStartTimeInMv;
	String firstTaskEndTimeInMV;
	String firstTaskStartTimeInMvAfterDrag;
	String firstTaskEndTimeInMvAfterDrag;

	private By firstTaskEle;
	private By TeamName;
	private By shiftName;
	// **********************************************************
	String firstTaskNameInMV = "MV";
	String sideTaskNameValue;
	String firstTaskNameInPlanner = "Planner";
	String sideTaskEndTimeAfterDrag;
	List<WebElement> definedShift = new ArrayList<WebElement>();
	List<WebElement> displayedShift = new ArrayList<WebElement>();

	private ElementUtil eleUtil;
	public String PlPovStartDate;
	public String PlPovEndDate;

	public ManagerView(WebDriver driver) {
		this.driver = driver;
		navigateTo = new Navigation(driver);
		eleUtil = new ElementUtil(driver);
		jdbc = new JDBC();
		sshandover = new ShiftSummaryHandover(driver);
	}

	public void findFirstTask() throws InterruptedException {

		Actions action = new Actions(driver);
		navigateTo.ManagerView();
		Thread.sleep(2000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		firstTaskNameInPlanner = navigateTo.firstTaskNames;
		System.out.println("first task name in planner : " + firstTaskNameInPlanner);
		driver.findElement(shiftTypeDD).click();
		List<WebElement> shiftTypes = driver.findElements(shiftTypeList);
		driver.findElement(shiftTypeDD).click();
		for (int i = 1; i <= shiftTypes.size(); i++) {
			driver.findElement(shiftTypeDD).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//div[contains(@class,'dropdown-menu customHeight')])[1]/a)[" + i + "]"))
					.click();
			driver.findElement(selectTeamDD).click();
			Thread.sleep(1000);
			List<WebElement> teamLists = driver.findElements(teamList);
			driver.findElement(selectTeamDD).click();
			Thread.sleep(1000);
			for (int j = 1; j <= teamLists.size(); j++) {
				driver.findElement(selectTeamDD).click();
				Thread.sleep(1000);
				TeamName = By.xpath("(//ul[@class='lazyContainer']/li)[" + j + "]");
				driver.findElement(By.xpath("(//ul[@class='lazyContainer']/li)[" + j + "]")).click();
				Thread.sleep(1000);

				List<WebElement> taskList = driver.findElements(availableTaskList);
				for (int k = 1; k <= taskList.size(); k++) {
					driver.findElement(refreshBtn).click();
					Thread.sleep(1000);
					action.moveToElement(driver
							.findElement(By.xpath("((//div[@class='d-flex h-100 w-100'])/parent::div )[" + k + "]")))
							.build().perform();
					Thread.sleep(2000);
					firstTaskNameInMV = driver.findElement(taskTollTip).getText();
					System.out.println("first task name in manager view " + firstTaskNameInMV);
					if (firstTaskNameInMV.equals(firstTaskNameInPlanner)) {
						System.out.println("inside if condition ");
						firstTaskEle = By.xpath("((//div[@class='d-flex h-100 w-100'])/parent::div )[" + k + "]");
						System.out.println("First Task Xpath is :" + firstTaskEle);

						shiftName = By
								.xpath("((//div[contains(@class,'dropdown-menu customHeight')])[1]/a)[" + i + "]");

						System.out.println("Team Name where task is available " + TeamName);
						System.out.println("shift name where task is available " + shiftName);
						break;
					}
				}
				if (!firstTaskNameInMV.equals(firstTaskNameInPlanner)) {
					driver.findElement(By.xpath("(//ul[@class='lazyContainer']/li)[" + j + "]")).click();
					driver.findElement(selectTeamDD).click();
					Thread.sleep(1000);
				}

				if (firstTaskNameInMV.equals(firstTaskNameInPlanner)) {
					break;
				}
			}
			Thread.sleep(4000);
			if (firstTaskNameInMV.equals(firstTaskNameInPlanner)) {
				break;
			}
		}
	}

	public boolean verifyUserCanNavigateToManagerViewTest() throws InterruptedException {
		boolean b = navigateTo.ManagerView();
		return b;
	}

	public boolean verifyNotReqFielAvlTest() {
		try {
			driver.findElement(notReqFile).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifySelectTeamFilterAvlTest() {
		try {
			driver.findElement(selectTeamDD).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyTheAvlOfDatePickerInWeekViewTest() {
		try {
			driver.findElement(weekDatePicker).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfRefreshBtnTest() {
		try {
			driver.findElement(refreshBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfSaveBtnTest() {
		try {
			driver.findElement(saveBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfDayBtnTest() {
		try {
			driver.findElement(dayViewBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfAlertBtnTest() {
		try {
			driver.findElement(alertBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanNavigateToDayViewTest() throws InterruptedException {
		driver.findElement(dayViewBtn).click();
		Thread.sleep(2000);
		try {
			driver.findElement(selectDate).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyDataAvlInManagerViewTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(2000);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(2000);
		driver.findElement(TeamName).click();
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(firstTaskEle)).build().perform();
		Thread.sleep(2000);
		firstTaskNameInMV = driver.findElement(taskTollTip).getText();
		if (firstTaskNameInMV.equals(firstTaskNameInPlanner)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAvlOfShiftTypeDDinDayViewTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(2000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		try {
			driver.findElement(shiftTypeDD).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfDownloadConstraintBtnTest() {
		try {
			driver.findElement(downloadConstraintBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfRefreshBtnInDayViewTest() {
		try {
			driver.findElement(refreshBtn).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfSaveButtonTest() {
		try {
			driver.findElement(saveBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfWeekViewBtnInDayViewTest() {
		try {
			driver.findElement(weekView).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfAlertButtonInDayViewTest() {
		try {
			driver.findElement(alertBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfSideTaskButtonInDayViewTest() throws InterruptedException {
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(2000);
		try {
			driver.findElement(sideTaskButton).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfZoomInTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		try {
			driver.findElement(zoomInbtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlZoomOutBtnTest() {
		try {
			driver.findElement(zoomOutbtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAvlOfFullScreenBtnTest() {
		try {
			driver.findElement(fullScreenBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyShiftTypeInMVAndFcTest() throws InterruptedException {
		navigateTo.factoryCalendar();
		Thread.sleep(2000);
		definedShift = driver.findElements(defineShiftInFc);
		List<String> definedShiftValue = new ArrayList<String>();
		for (int i = 1; i < definedShift.size(); i++) {
			definedShiftValue.add(definedShift.get(i).getText());
		}

		navigateTo.ManagerView();
		Thread.sleep(2000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(2000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(4000);
		displayedShift = driver.findElements(shiftTypeList);
		List<String> displayShiftValue = new ArrayList<String>();
		for (int j = 0; j < displayedShift.size(); j++) {
			displayShiftValue.add(displayedShift.get(j).getText());
		}

		Collections.sort(definedShiftValue);
		Collections.sort(displayShiftValue);
		System.out.println("Defined shift value is " + definedShiftValue);
		System.out.println("Displayed shift Values are " + displayShiftValue);
		if (definedShiftValue.equals(displayShiftValue)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanSelectTheShiftTest() throws InterruptedException {
		navigateTo.factoryCalendar();
		Thread.sleep(2000);
		String shiftNameValue = driver.findElement(shiftNameInFc).getText();
		System.out.println("Shift Name Value is " + shiftNameValue);
		String shiftStartTimeValuearr[] = driver.findElement(shiftStartTimeInFc).getText().split(":");
		String shiftStartTimeValue = shiftStartTimeValuearr[0];
		System.out.println("Shift start time : " + shiftStartTimeValue);
		String shiftEndTimeValueArr[] = driver.findElement(shiftEndTimeInFc).getText().split(":");
		String shiftEndTimeValue = shiftEndTimeValueArr[0];
		int a = Integer.parseInt(shiftEndTimeValue);
		a = a - 1;
		shiftEndTimeValue = String.valueOf(a);
		if (a < 10) {
			shiftEndTimeValue = "0" + shiftEndTimeValue;
		}
		System.out.println("Shift end time : " + shiftEndTimeValue);
		navigateTo.ManagerView();
		Thread.sleep(2000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(2000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[.=' " + shiftNameValue + " ']")).click();
		Thread.sleep(2000);
		String[] shiftStartTimeValueInMvArray = driver.findElement(shiftStartTimeInMv).getText().split(":");
		String shiftStartTimeValueInMv = shiftStartTimeValueInMvArray[0];
		System.out.println("Shift satrt time value in manager view " + shiftStartTimeValueInMv);
		String[] shiftEndTimeValueInMvArray = driver.findElement(shiftEndTimeInMv).getText().split(":");
		String shiftEndTimeValueInMv = shiftEndTimeValueInMvArray[0];
		System.out.println("Shift end time value in manager view " + shiftEndTimeValueInMv);
		if (shiftStartTimeValue.equals(shiftStartTimeValueInMv) && shiftEndTimeValue.equals(shiftEndTimeValueInMv)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToSelectTheTeamTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(2000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(1000);
		driver.findElement(selectTeamDD).click();
		String selectedTeamName = driver.findElement(TeamName).getText().replace(" ", "");
		System.out.println("Selected team is " + selectedTeamName);
		driver.findElement(TeamName).click();
		Thread.sleep(2000);
		boolean b = true;

		List<WebElement> teamListEle = driver.findElements(teamNameListInGrid);
		int size = teamListEle.size();
		String teamListarr[] = new String[size];

		for (int i = 0; i < teamListEle.size(); i++) {
			teamListarr[i] = teamListEle.get(i).getText().replace("[", "");
			teamListarr[i] = teamListarr[i].replace("]", "");
		}
		String h;
		String a[] = new String[size];
		for (int i = 0; i < teamListEle.size(); i++) {
			System.out.println(teamListarr[i]);
			h = teamListarr[i];
//			
			a = h.split("User");
			String TeamName = a[0].replace(" ", "");
			System.out.println("Team Name after convert " + TeamName);
			if (TeamName.contains(selectedTeamName)) {
				b = true;
			} else {
				System.out.println("Other teams user are avaialble in grid " + TeamName);
				b = false;
				break;
			}
		}
		return b;
	}

	public boolean verifyUserCanAddTempOperatorTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1500);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(2000);
		driver.findElement(addOperatorBtn).click();
		Thread.sleep(1000);
		driver.findElement(selectTeamDDInOperatorStatus).click();
		Thread.sleep(2000);
		driver.findElement(selectFirstTeam).click();
		Thread.sleep(1000);
		driver.findElement(selecteOperatorDD).click();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(selectOperatorTeamDD)).build().perform();
		Thread.sleep(2000);
		driver.findElement(selectUser).click();
		Thread.sleep(1000);
		driver.findElement(submitStatusBtn).click();
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		if (tstrMsg.equals("Temp Operator added successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAvlOfAddedTempOperatorInGridTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1500);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(2000);
		try {
			driver.findElement(tempOperatorAvl).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanDeleteTempOperatorTest() throws InterruptedException {
		driver.findElement(addOperatorBtn).click();
		Thread.sleep(1000);
		driver.findElement(operatorStatusViewBtn).click();
		Thread.sleep(1000);
		driver.findElement(operatorStatusDeleteBtn).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		if (tstrMsg.equals("Temp Operator deleted successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvlOfTempOperatorInGridPostDeleteTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1500);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(2000);
		try {
			driver.findElement(tempOperatorAvl).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyUserIsAbleToDoOperatorUnAvailableFromLogEventTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		driver.navigate().refresh();
		Thread.sleep(7000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1500);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		String firstOperator = driver.findElement(getFirstOperator).getText().trim();
		System.out.println("First operator in grid is :" + firstOperator + ":");
		driver.findElement(logEvent).click();
		Thread.sleep(1000);
		driver.findElement(chooseCategoryDD).click();
		Thread.sleep(1000);
		driver.findElement(employeeUnAvailableEle).click();
		Thread.sleep(1000);
		driver.findElement(selectResourceDD).click();
		Thread.sleep(1000);
		driver.findElement(selectResourceSearchBox).sendKeys(firstOperator);
		Thread.sleep(1000);
		driver.findElement(selectFirstResource).click();
		Thread.sleep(1000);
		driver.findElement(selecteTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(plannedLeaveEle).click();
		Thread.sleep(1000);
		driver.findElement(operatorUnAvlFromDate).sendKeys(EventProperties.task_Date);
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
		driver.findElement(operatorUnAvlEndDate).sendKeys(EventProperties.task_Date);
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
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(500);
		driver.findElement(addButtonInLogEvent).click();
		Thread.sleep(500);
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		if (tstrMsg.equals("Unavailability Updated Successfully!!!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyOperatorUnAvlAlertInGridViewTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1500);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		try {
			driver.findElement(deleteIconInGridView).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyOperatorUnAvlAlertInLogEventWindowTest() throws InterruptedException {
		driver.findElement(logEvent).click();
		Thread.sleep(1000);
		driver.findElement(logEventSummmaryTab).click();
		Thread.sleep(1000);
		try {
			driver.findElement(operatorUnAvlAlertEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserIsAbleToDeleteOpUnAvlFromGridTest() throws InterruptedException {
		try {
			driver.findElement(closeWindow).click();
			System.out.println("window is not closed");
			Thread.sleep(2000);

		} catch (Exception e) {
			System.out.println("Window is closed ");
		}
		driver.findElement(deleteIconInGridView).click();
		driver.switchTo().alert().accept();
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		if (tstrMsg.equals("Operator Unavailability deleted Successfully!!!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteOpUnAvlFromLogEventWindowTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1500);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		String firstOperator = driver.findElement(getFirstOperator).getText().trim();
		System.out.println("First operator in grid is :" + firstOperator + ":");
		driver.findElement(logEvent).click();
		Thread.sleep(1000);
		driver.findElement(chooseCategoryDD).click();
		Thread.sleep(1000);
		driver.findElement(employeeUnAvailableEle).click();
		Thread.sleep(1000);
		driver.findElement(selectResourceDD).click();
		Thread.sleep(1000);
		driver.findElement(selectResourceSearchBox).sendKeys(firstOperator);
		Thread.sleep(1000);
		driver.findElement(selectFirstResource).click();
		Thread.sleep(1000);
		driver.findElement(selecteTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(plannedLeaveEle).click();
		Thread.sleep(1000);
		driver.findElement(operatorUnAvlFromDate).sendKeys(EventProperties.task_Date);
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
		driver.findElement(operatorUnAvlEndDate).sendKeys(EventProperties.task_Date);
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
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(500);
		driver.findElement(addButtonInLogEvent).click();
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1500);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(logEvent).click();
		Thread.sleep(1000);
		driver.findElement(logEventSummmaryTab).click();
		Thread.sleep(3000);
		driver.findElement(operatorStatusDeleteBtn).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		if (tstrMsg.equals("Operator Unavailability deleted Successfully!!!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyOpUnAvlAlertInLogEventPostDeleteTest() throws InterruptedException {
		try {
			driver.findElement(closeWindow).click();
			Thread.sleep(2000);

		} catch (Exception e) {
			System.out.println("Window is  closed ");
		}
		driver.findElement(logEvent).click();
		Thread.sleep(1000);
		driver.findElement(logEventSummmaryTab).click();
		Thread.sleep(2000);
		try {
			driver.findElement(operatorUnAvlAlertEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyUserCanAddEquipmentUnAvlFromLogEventTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1500);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(logEvent).click();
		Thread.sleep(1000);
		driver.findElement(chooseCategoryDD).click();
		Thread.sleep(1000);
		driver.findElement(equipmentUnAvlOp).click();
		Thread.sleep(1000);
		driver.findElement(selectResourceDD).click();
		Thread.sleep(1000);
		driver.findElement(selectResourceSearchBox).sendKeys(EventProperties.equipmentName);
		Thread.sleep(1000);
		driver.findElement(selectFirstResource).click();
		driver.findElement(selecteTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(equipmentDownReason).click();
		Thread.sleep(1000);
		driver.findElement(operatorUnAvlFromDate).sendKeys(EventProperties.task_Date);
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
		driver.findElement(operatorUnAvlEndDate).sendKeys(EventProperties.task_Date);
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
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(500);
		driver.findElement(addButtonInLogEvent).click();
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		if (tstrMsg.equals("Asset status updated!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvlOfEquipmentDowAlertInLogEventTest() throws InterruptedException {
		try {
			driver.findElement(closeWindow).click();
			System.out.println("Window is not closed");
			Thread.sleep(2000);

		} catch (Exception e) {
			System.out.println("Window is closed ");
		}

		driver.findElement(logEvent).click();
		Thread.sleep(1000);
		driver.findElement(logEventSummmaryTab).click();
		Thread.sleep(1000);

		try {

			driver.findElement(equipmentDownAlert).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanDeleteEquipmentDownAlertTest() throws InterruptedException {
		driver.findElement(operatorStatusDeleteBtn).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		if (tstrMsg.equals("Asset status Deleted Successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvlOfEquipmentDownAlertInLogEventPostDeleteTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(2000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(logEvent).click();
		Thread.sleep(3000);
		driver.findElement(logEventSummmaryTab).click();
		Thread.sleep(1000);
		try {

			driver.findElement(equipmentDownAlert).isDisplayed();
			return false;

		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyUserIsAbleToAddAlertTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1500);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		driver.findElement(alertBtn).click();
		Thread.sleep(2000);
		driver.findElement(buildingGroupDD).click();
		Thread.sleep(1000);
		driver.findElement(buildingGroupOption).click();
		driver.findElement(alertFromDateEle).sendKeys(EventProperties.task_Date);
		actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
		Thread.sleep(500);
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
		driver.findElement(alertToDateEle).sendKeys(EventProperties.task_Date);
		actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
		Thread.sleep(500);
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
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(500);
		driver.findElement(alertMessage).sendKeys("Comment for testing purpose");
		driver.findElement(alertSubmitButton).click();
		Thread.sleep(1000);
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		if (tstrMsg.equals("Alert message added successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvlOfAddedAlertTest() throws InterruptedException {
		try {
			driver.findElement(alertWindowCloseBtn).click();
		} catch (Exception e) {
			System.out.println("Alert window is not available ");
		}
		Thread.sleep(4000);
		driver.findElement(alertBtn).click();
		Thread.sleep(2000);
		driver.findElement(viewBtnInAlertTab).click();
		Thread.sleep(1000);
		alertInManagerView = driver.findElement(addedCommentEle).getText();
		String arr[] = alertInManagerView.split("-");
		alertInManagerView = arr[3];
		System.out.println("Added comment is " + alertInManagerView);
		try {
			driver.findElement(alertMsgEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyTheAvlOfAddedAlertInWeekViewAlertTabTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(alertBtn).click();
		Thread.sleep(2000);
		driver.findElement(viewBtnInAlertTab).click();
		Thread.sleep(1000);
		try {
			driver.findElement(alertMsgEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanDeleteAddedAlertTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(2000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(3000);
		driver.findElement(alertBtn).click();
		Thread.sleep(2000);

		driver.findElement(viewBtnInAlertTab).click();
		Thread.sleep(1000);

		driver.findElement(alertDeleteIcon).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		if (tstrMsg.equals("Alert message deleted!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvlOfAlertPostDeleteTest() throws InterruptedException {
		try {
			driver.findElement(alertWindowCloseBtn).click();
		} catch (Exception e) {
			System.out.println("Alert window is not available ");
		}
		Thread.sleep(4000);
		driver.findElement(alertBtn).click();
		Thread.sleep(2000);
		driver.findElement(viewBtnInAlertTab).click();
		Thread.sleep(1000);
		try {
			driver.findElement(alertMsgEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyAvlOfDeletedAlertInWeekViewTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(alertBtn).click();
		Thread.sleep(2000);
		driver.findElement(viewBtnInAlertTab).click();
		Thread.sleep(1000);
		try {
			driver.findElement(alertMsgEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyAlertMsgAvlInDataBaseTest() throws SQLException {
		jdbc.getAlertMsgFromDB();
		alertInManagerView = alertInManagerView.replace(" ", "");
		System.out.println("Added comment in Manager view " + alertInManagerView);
		alertInDB = jdbc.alertMsg.replace(" ", "");
		System.out.println("Alert in DB is " + alertInDB);
		if (alertInManagerView.equals(alertInDB)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanAddSideTaskTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(1000);

		String taskTime = driver.findElement(getFirstTaskTime).getText();
		System.out.println("Task Time " + taskTime);
		driver.findElement(sideTaskButton).click();
		Thread.sleep(1000);
		driver.findElement(sideTaskDD).click();
		Thread.sleep(1000);
		sideTaskNameValue = driver.findElement(sideTaskName).getText();
		driver.findElement(firstSideTask).click();
		Thread.sleep(1000);
		driver.findElement(selectEquipment).click();
		driver.findElement(sideTaskSearch).sendKeys(EventProperties.equipmentName);
		driver.findElement(selectEquipmentOp).click();
		driver.findElement(selectOperatorDD).click();
		actions.moveToElement(driver.findElement(selectTeamToSideTask)).build().perform();
		Thread.sleep(1000);
		driver.findElement(selectUserForSideTask).click();
		Thread.sleep(1000);
		driver.findElement(dateForSideTask).sendKeys(EventProperties.task_Date);
		actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
		Thread.sleep(500);
		driver.findElement(dateForSideTask).sendKeys(taskTime);
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(500);
		driver.findElement(addSideTaskButton).click();
		Thread.sleep(1000);
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		if (tstrMsg.equals("Side Task Added Successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvlOfAddedSideTaskTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(1000);
		sideTaskEle = By.xpath("(//div[.='" + sideTaskNameValue + "'])/parent::div[@class='dhx_cal_event_line ']");
		try {
			driver.findElement(sideTaskEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyTheAvlOfSideTaskButtonWithoutSelectingShiftTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		try {
			driver.findElement(sideTaskButton).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyTheAvlOfAddOperatorButtonWithoutSelectingShiftTest() {
		try {
			driver.findElement(addOperatorBtn).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyShiftTimeAfterChangingSideTaskDurationTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(1000);
		List<WebElement> listC = driver.findElements(shiftHours);
		int shiftCountBeforSave = listC.size();
		System.out.println("Shift count before save " + shiftCountBeforSave);
		Actions act = new Actions(driver);
		act.clickAndHold(driver.findElement(sideTaskEle)).pause(Duration.ofSeconds(3)).moveByOffset(140, 0).release()
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(4000);
		List<WebElement> listCAS = driver.findElements(shiftHours);
		int shiftCountAfterSave = listCAS.size();
		System.out.println("Shift count after save " + shiftCountAfterSave);
		if (shiftCountBeforSave == shiftCountAfterSave) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAvlOfSideTaskInVSBTest() throws InterruptedException {
		sideTaskInVSB = By.xpath("//div[@aria-label='" + sideTaskNameValue + "']");
		navigateTo.VSB();
		Thread.sleep(2000);
		driver.findElement(VSBpage.DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		try {
			driver.findElement(sideTaskInVSB).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifySideTaskTimeAfterDragInMVTest() throws InterruptedException {
		navigateTo.ManagerView();
		Thread.sleep(2000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(2000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(5000);
		driver.findElement(shiftName).click();
		Thread.sleep(2000);
		driver.findElement(sideTaskEle).click();
		Thread.sleep(2000);
		driver.findElement(taskDurationButton).click();
		Thread.sleep(2000);
		sideTaskStartTimeBeforDrag = driver.findElement(taskDurationStartDatePicker).getAttribute("value");
		sideTaskStartTimeBeforDrag = sideTaskStartTimeBeforDrag.replace("T", "-");
		String arr[] = sideTaskStartTimeBeforDrag.split("-");
		sideTaskStartTimeBeforDrag = arr[0] + arr[1] + arr[2] + arr[3];
		sideTaskEndTimeBeforeDrag = driver.findElement(taskDurationEndDatePicker).getAttribute("value");
		sideTaskEndTimeBeforeDrag = sideTaskEndTimeBeforeDrag.replace("T", "-");
		String arr1[] = sideTaskEndTimeBeforeDrag.split("-");
		sideTaskEndTimeBeforeDrag = arr1[0] + arr1[1] + arr1[2] + arr1[3];
		System.out.println("Side task Start time before drag " + sideTaskStartTimeBeforDrag);
		System.out.println("Side task end time before " + sideTaskEndTimeBeforeDrag);
		driver.findElement(closeIconForTaskDuration).click();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.clickAndHold(driver.findElement(sideTaskEle)).pause(Duration.ofSeconds(3)).moveByOffset(140, 0).release()
				.build().perform();
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		driver.findElement(sideTaskEle).click();
		Thread.sleep(2000);
		driver.findElement(taskDurationButton).click();
		Thread.sleep(2000);
		sideTaskStartTimeAfterDrag = driver.findElement(taskDurationStartDatePicker).getAttribute("value");
		sideTaskStartTimeAfterDrag = sideTaskStartTimeAfterDrag.replace("T", "-");
		String arr3[] = sideTaskStartTimeAfterDrag.split("-");
		sideTaskStartTimeAfterDrag = arr3[0] + arr3[1] + arr3[2] + arr3[3];
		sideTaskEndTimeAfterDrag = driver.findElement(taskDurationEndDatePicker).getAttribute("value");
		sideTaskEndTimeAfterDrag = sideTaskEndTimeAfterDrag.replace("T", "-");
		String arr4[] = sideTaskEndTimeAfterDrag.split("-");
		sideTaskEndTimeAfterDrag = arr4[0] + arr4[1] + arr4[2] + arr4[3];
		System.out.println("Side task Start time after drag " + sideTaskStartTimeAfterDrag);
		System.out.println("Side task end time after " + sideTaskEndTimeAfterDrag);
		if ((sideTaskStartTimeAfterDrag.equals(sideTaskStartTimeBeforDrag)
				&& sideTaskEndTimeAfterDrag.equals(sideTaskEndTimeBeforeDrag))) {
			return false;
		} else {
			return true;
		}
	}

	public boolean verifySideTaskTimeAfterDragInVSBTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		navigateTo.VSB();
		Thread.sleep(2000);
		driver.findElement(VSBpage.DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		actions.moveToElement(driver.findElement(sideTaskInVSB)).build().perform();
		Thread.sleep(3000);
		String task = driver.findElement(VSBpage.taskTollTip).getText();
		System.out.println(task);
		Thread.sleep(1000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		vsbStart_date = vsbStart_date.replace("-", "");
		System.out.println("side task start date in vsb " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		vsbEndDate = vsbEndDate.replace("-", "");
		System.out.println("side task end date in vsb " + vsbEndDate);
		if (vsbStart_date.equals(sideTaskStartTimeAfterDrag) && vsbEndDate.equals(sideTaskEndTimeAfterDrag)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanDeleteSideTaskTest() throws InterruptedException {
		navigateTo.VSB();
		Thread.sleep(2000);
		driver.findElement(VSBpage.DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(sideTaskInVSB).click();
		Thread.sleep(1000);
		driver.findElement(deleteSideTask).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		Thread.sleep(4000);
		if (tstrMsg.equals("Side Task Deleted Successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheOperatorAllocationInProductOverviewTest() throws InterruptedException {
		navigateTo.ManagerView();
		Thread.sleep(1000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1500);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(2000);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(1000);
		driver.findElement(TeamName).click();
		Thread.sleep(3000);
		driver.findElement(firstTaskEle).click();
		Thread.sleep(2000);
		driver.findElement(divideTaskButton).click();
		Thread.sleep(2000);
		List<WebElement> allocatedOpList = driver.findElements(allocatedOperatorInMv);
		List<String> allocatedOpName = new ArrayList<String>();
		for (WebElement list : allocatedOpList) {
			allocatedOpName.add(list.getText());
		}
		Collections.sort(allocatedOpName);
		System.out.println("Allocated Operators Name in Manager view " + allocatedOpName);
		navigateTo.productOverview();
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		List<WebElement> allocatedOpLstInPov = driver.findElements(allocatedOperatorInPov);
		List<String> allocatedOpNameInPov = new ArrayList<String>();
		for (WebElement list1 : allocatedOpLstInPov) {
			allocatedOpNameInPov.add(list1.getText());
		}

		Collections.sort(allocatedOpNameInPov);
		System.out.println("Aloocated operator in Product overview " + allocatedOpNameInPov);

		if (allocatedOpName.equals(allocatedOpNameInPov)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanChangeTheTaskDurationTest() throws InterruptedException {
		navigateTo.ManagerView();
		Thread.sleep(1000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(2000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(1000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(1000);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(1000);
		driver.findElement(TeamName).click();
		Thread.sleep(1500);
		driver.findElement(firstTaskEle).click();
		Thread.sleep(1000);
		driver.findElement(taskDurationBtnTest).click();
		Thread.sleep(2000);
		firstTaskStartTimeInMv = driver.findElement(taskDurationStartDatePicker).getAttribute("value");
		firstTaskStartTimeInMv = firstTaskStartTimeInMv.replace("T", "-");
		String arr[] = firstTaskStartTimeInMv.split("-");
		firstTaskStartTimeInMv = arr[0] + arr[1] + arr[2] + arr[3];
		firstTaskEndTimeInMV = driver.findElement(taskDurationEndDatePicker).getAttribute("value");
		firstTaskEndTimeInMV = firstTaskEndTimeInMV.replace("T", "-");
		String arr1[] = firstTaskEndTimeInMV.split("-");
		firstTaskEndTimeInMV = arr1[0] + arr1[1] + arr1[2] + arr1[3];
		System.out.println("first task Start time before drag " + firstTaskStartTimeInMv);
		System.out.println("first task end time before drag" + firstTaskEndTimeInMV);
		driver.findElement(closeIconForTaskDuration).click();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.clickAndHold(driver.findElement(firstTaskEle)).pause(Duration.ofSeconds(3)).moveByOffset(140, 0).release()
				.build().perform();
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		Thread.sleep(4000);
		if (tstrMsg.equals("Task Details Updated Successfully.")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTaskDurationInManagerViewPostDragTest() throws InterruptedException {
		driver.findElement(firstTaskEle).click();
		Thread.sleep(1000);
		driver.findElement(taskDurationBtnTest).click();
		Thread.sleep(2000);
		firstTaskStartTimeInMvAfterDrag = driver.findElement(taskDurationStartDatePicker).getAttribute("value");
		firstTaskStartTimeInMvAfterDrag = firstTaskStartTimeInMvAfterDrag.replace("T", "-");
		String arr[] = firstTaskStartTimeInMvAfterDrag.split("-");
		firstTaskStartTimeInMvAfterDrag = arr[0] + arr[1] + arr[2] + arr[3];
		firstTaskEndTimeInMvAfterDrag = driver.findElement(taskDurationEndDatePicker).getAttribute("value");
		firstTaskEndTimeInMvAfterDrag = firstTaskEndTimeInMvAfterDrag.replace("T", "-");
		String arr1[] = firstTaskEndTimeInMvAfterDrag.split("-");
		firstTaskEndTimeInMvAfterDrag = arr1[0] + arr1[1] + arr1[2] + arr1[3];
		System.out.println("first task Start time after drag " + firstTaskStartTimeInMvAfterDrag);
		System.out.println("first task end time after drag " + firstTaskEndTimeInMvAfterDrag);

		Thread.sleep(1000);

		if (firstTaskStartTimeInMv.equals(firstTaskStartTimeInMvAfterDrag)
				&& firstTaskEndTimeInMV.equals(firstTaskEndTimeInMvAfterDrag)) {
			return false;
		} else {
			return true;
		}

	}

	public boolean verifyTaskDurationInProductOverviewAfterDragTest() throws InterruptedException {
		navigateTo.productOverview();
		Thread.sleep(1000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(1000);
		String startTimeInPov = driver.findElement(firstTaskStartTimeInPov).getText().replace("-", "");
		startTimeInPov = startTimeInPov.replace(" ", "");
		System.out.println("First Task Start time in Product Overview after drag " + startTimeInPov);
		String endTimeInPov = driver.findElement(firstTaskEndTimeInPov).getText().replace("-", "");
		endTimeInPov = endTimeInPov.replace(" ", "");
		System.out.println("First task end time in product overview after drag " + endTimeInPov);

		if (firstTaskStartTimeInMvAfterDrag.equals(startTimeInPov)
				&& firstTaskEndTimeInMvAfterDrag.equals(endTimeInPov)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheTaskDurationInVSBAfterDragTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		navigateTo.VSB();
		Thread.sleep(2000);
		driver.findElement(VSBpage.DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		actions.moveToElement(driver.findElement(VSBpage.firsttask)).build().perform();
		Thread.sleep(3000);
		String task = driver.findElement(VSBpage.taskTollTip).getText();
		System.out.println(task);
		Thread.sleep(1000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		vsbStart_date = vsbStart_date.replace("-", "");
		System.out.println("first task start date in vsb " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		vsbEndDate = vsbEndDate.replace("-", "");
		System.out.println("first task end date in vsb " + vsbEndDate);
		if (firstTaskStartTimeInMvAfterDrag.equals(vsbStart_date) && firstTaskEndTimeInMvAfterDrag.equals(vsbEndDate)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanChangeTheTaskDurationFromDatePickerTest() throws InterruptedException {
		navigateTo.ManagerView();
		Thread.sleep(1000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(2000);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		Thread.sleep(1000);
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(1000);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(1000);
		driver.findElement(TeamName).click();
		Thread.sleep(1500);
		driver.findElement(firstTaskEle).click();
		Thread.sleep(1000);
		driver.findElement(taskDurationBtnTest).click();
		Thread.sleep(2000);
		firstTaskStartTimeInMv = driver.findElement(taskDurationStartDatePicker).getAttribute("value");
		firstTaskStartTimeInMv = firstTaskStartTimeInMv.replace("T", "-");
		String arr[] = firstTaskStartTimeInMv.split("-");
		firstTaskStartTimeInMv = arr[0] + arr[1] + arr[2] + arr[3];
		firstTaskEndTimeInMV = driver.findElement(taskDurationEndDatePicker).getAttribute("value");
		firstTaskEndTimeInMV = firstTaskEndTimeInMV.replace("T", "-");
		String arr1[] = firstTaskEndTimeInMV.split("-");
		firstTaskEndTimeInMV = arr1[0] + arr1[1] + arr1[2] + arr1[3];
		System.out.println("first task Start time before drag " + firstTaskStartTimeInMv);
		System.out.println("first task end time before drag " + firstTaskEndTimeInMV);
		driver.findElement(taskDurationStartDatePicker).sendKeys(EventProperties.task_Date);
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		driver.findElement(taskDurationEndDatePicker).sendKeys(EventProperties.task_Date);
		actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		driver.findElement(updateTaskDurationBtn).click();
		Thread.sleep(1000);

		String tstrMsg = "null";
		try {
			tstrMsg = driver.findElement(toasterMessage).getText();

		} catch (Exception e) {
			tstrMsg = "null";
		}
		Thread.sleep(4000);
		if (tstrMsg.equals("Task Details Updated Successfully.")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTaskDurationInManagerViewAfterDurationChangeTest() throws InterruptedException {
		driver.findElement(firstTaskEle).click();
		Thread.sleep(1000);
		driver.findElement(taskDurationBtnTest).click();
		Thread.sleep(2000);
		firstTaskStartTimeInMvAfterDrag = driver.findElement(taskDurationStartDatePicker).getAttribute("value");
		firstTaskStartTimeInMvAfterDrag = firstTaskStartTimeInMvAfterDrag.replace("T", "-");
		String arr[] = firstTaskStartTimeInMvAfterDrag.split("-");
		firstTaskStartTimeInMvAfterDrag = arr[0] + arr[1] + arr[2] + arr[3];
		firstTaskEndTimeInMvAfterDrag = driver.findElement(taskDurationEndDatePicker).getAttribute("value");
		firstTaskEndTimeInMvAfterDrag = firstTaskEndTimeInMvAfterDrag.replace("T", "-");
		String arr1[] = firstTaskEndTimeInMvAfterDrag.split("-");
		firstTaskEndTimeInMvAfterDrag = arr1[0] + arr1[1] + arr1[2] + arr1[3];
		System.out.println("first task Start time after drag " + firstTaskStartTimeInMvAfterDrag);
		System.out.println("first task end time after drag " + firstTaskEndTimeInMvAfterDrag);

		Thread.sleep(1000);

		if (firstTaskStartTimeInMv.equals(firstTaskStartTimeInMvAfterDrag)
				&& firstTaskEndTimeInMV.equals(firstTaskEndTimeInMvAfterDrag)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean verifyTaskDurationInPOVAfterDurationChangeByDatePickerTest() throws InterruptedException {
		navigateTo.productOverview();
		Thread.sleep(1000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(1000);
		String startTimeInPov = driver.findElement(firstTaskStartTimeInPov).getText().replace("-", "");
		startTimeInPov = startTimeInPov.replace(" ", "");
		System.out.println("First Task Start time in Product Overview after drag " + startTimeInPov);
		String endTimeInPov = driver.findElement(firstTaskEndTimeInPov).getText().replace("-", "");
		endTimeInPov = endTimeInPov.replace(" ", "");
		System.out.println("First task end time in product overview after drag " + endTimeInPov);

		if (firstTaskStartTimeInMvAfterDrag.equals(startTimeInPov)
				&& firstTaskEndTimeInMvAfterDrag.equals(endTimeInPov)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTaskDurationInVSBAfterDurationChangeByDatePickerTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		navigateTo.VSB();
		Thread.sleep(2000);
		driver.findElement(VSBpage.DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		actions.moveToElement(driver.findElement(VSBpage.firsttask)).build().perform();
		Thread.sleep(3000);
		String task = driver.findElement(VSBpage.taskTollTip).getText();
		System.out.println(task);
		Thread.sleep(1000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		vsbStart_date = vsbStart_date.replace("-", "");
		System.out.println("first task start date in vsb " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		vsbEndDate = vsbEndDate.replace("-", "");
		System.out.println("first task end date in vsb " + vsbEndDate);
		if (firstTaskStartTimeInMvAfterDrag.equals(vsbStart_date) && firstTaskEndTimeInMvAfterDrag.equals(vsbEndDate)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyUserCanRefreshThePageInDayViewTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		navigateTo.ManagerView();
		Thread.sleep(1000);
		driver.findElement(dayViewBtn).click();
		Thread.sleep(1500);
		driver.findElement(selectDate).sendKeys(EventProperties.task_Date);
		System.out.println("inside task date");
		driver.findElement(shiftTypeDD).click();
		Thread.sleep(1000);
		driver.findElement(shiftName).click();
		Thread.sleep(1000);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(2000);
		driver.findElement(TeamName).click();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.clickAndHold(driver.findElement(firstTaskEle)).pause(Duration.ofSeconds(3)).moveByOffset(140, 0).release()
				.build().perform();
		Thread.sleep(2000);

		driver.findElement(refreshBtn).click();
		Thread.sleep(2000);

		try {
			driver.findElement(firstTaskEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyTheTaskDurationInVSBPostStartPostDurationChnageFromMVTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		navigateTo.VSB();
		Thread.sleep(2000);
		driver.findElement(VSBpage.DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(VSBpage.firsttask).click();
		Thread.sleep(2000);
		driver.findElement(VSBpage.starttaskoption).click();
		System.out.println("Start task clicked from popup");
		Thread.sleep(1000);
		driver.findElement(VSBpage.starttaskbutton).click();
		System.out.println("Task started");
		Thread.sleep(9000);
		actions.moveToElement(driver.findElement(VSBpage.firsttask)).build().perform();
		Thread.sleep(3000);
		String task = driver.findElement(VSBpage.taskTollTip).getText();
		System.out.println(task);
		Thread.sleep(1000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		vsbStart_date = vsbStart_date.replace("-", "");
		System.out.println("first task start date in vsb " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		vsbEndDate = vsbEndDate.replace("-", "");
		System.out.println("first task end date in vsb " + vsbEndDate);
		if (firstTaskStartTimeInMvAfterDrag.equals(vsbStart_date) && firstTaskEndTimeInMvAfterDrag.equals(vsbEndDate)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheTaskDurationInVSBPostClosePostDurationChnageFromMVTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		driver.findElement(VSBpage.firsttask).click();
		Thread.sleep(2000);
		System.out.println("Clicked on task and popup displayed");
		Thread.sleep(1000); // reduce 2 sec
		driver.findElement(VSBpage.markAsCompleteoption).click();
		Thread.sleep(1000); // reduce 1 sec
		driver.findElement(VSBpage.markAsCompleteButton).click();
		System.out.println("Task closed");
		Thread.sleep(8000);
		actions.moveToElement(driver.findElement(VSBpage.firsttask)).build().perform();
		Thread.sleep(3000);
		String task = driver.findElement(VSBpage.taskTollTip).getText();
		System.out.println(task);
		Thread.sleep(1000);
		String arr1[] = task.split("Start : ");
		String arr2[] = arr1[1].split("End : ");
		String vsbStart_date = arr2[0].replaceAll("\n", "");
		vsbStart_date = vsbStart_date.replace(" ", "");
		vsbStart_date = vsbStart_date.replace("-", "");
		System.out.println("first task start date in vsb " + vsbStart_date);
		String vsbEndDate = arr2[1].replace(" ", "");
		vsbEndDate = vsbEndDate.replace("-", "");
		System.out.println("first task end date in vsb " + vsbEndDate);
		if (firstTaskStartTimeInMvAfterDrag.equals(vsbStart_date) && firstTaskEndTimeInMvAfterDrag.equals(vsbEndDate)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanStartTheTaskWithLogDelayPostDurationChnageFromMVTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(VSBpage.DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(VSBpage.firsttask).click();
		System.out.println("Task info popup is displayed");
		Thread.sleep(1000); // reduce 2 sec
		driver.findElement(VSBpage.ReSettask).click();
		System.out.println("Reset button clicked");
		Thread.sleep(1000); // reduce 2 sec
		driver.findElement(VSBpage.ReSetButton).click();
		System.out.println("Reset alert accetped");
		Thread.sleep(8000);
		Actions actions = new Actions(driver);
		boolean flag = true;
		System.out.println("Test case 30 started ");
		Thread.sleep(6000);
		driver.findElement(VSBpage.firsttask).click();
		System.out.println("first task is clicked ");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(VSBpage.starttaskoption).click();
		System.out.println("start option clicked ");
		Thread.sleep(1000);
		driver.findElement(VSBpage.delayStartDatePicker).sendKeys(EventProperties.delayTime);
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		System.out.println("date added ");
		Thread.sleep(2000);
		driver.findElement(VSBpage.starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(3000);
		driver.findElement(VSBpage.delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(VSBpage.delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(VSBpage.additonalCmt).sendKeys("Test");
		Thread.sleep(1000);
		driver.findElement(VSBpage.logDelayButton).click();
		Thread.sleep(2000);
		try {
			String tosterMessage = driver.findElement(VSBpage.logDelayToaster).getText();
			driver.findElement(VSBpage.logDelayToaster).isDisplayed();
			System.out.println("Toaster is capture " + tosterMessage);
		} catch (Exception e) {
			System.out.println("Toaster message is not displayed ");
			flag = false;
		}
		Thread.sleep(8000);
		return flag;
	}

}