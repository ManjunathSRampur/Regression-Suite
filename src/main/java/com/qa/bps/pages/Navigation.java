package com.qa.bps.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.aspectj.weaver.patterns.ExactAnnotationFieldTypePattern;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Navigation {
	DataManagement DataManagement;
	FactoryCalender factCalendar;
	WebDriver driver;

	private By bodheLogoIMP = By.xpath("//img[contains(@src,'bodhee_logo')]");
	private By bodheeLogoBodhee = By.xpath("//img[contains(@src,'bodhee_logo')]");
	private By userDropDown = By.xpath("//p[@id='navbarDropdown']");
	private By bodheeStudioLabel = By.xpath("//a[contains(text(),'Bodhee Studio')]");
	private By dataManagement = By.xpath("//a[contains(@href,'dataManagement')]");
	private By masterDataIcon = By.xpath("//a[@id='v-pills-master']");
	private By factoryCal = By.xpath("//div[@title='Factory Calendar']");
	private By holidayCal = By.xpath("//div[@title='Holiday Calendar']");
	private By addNewCalendarBtn = By.xpath("(//div[@class='card tileCard'])[1]");
	private By factorycalCard = By.xpath("(//div[@class='card tileCard'])[last()]");
	private By InsideFC = By.xpath("//input[@name='calenderName1']");
	private By controlTower = By.xpath("//div[contains(text(),'Control Tower')]");
	private By manager = By.xpath("//div[contains(text(),'Manager')]");
	private By productview = By.xpath("//div[contains(text(),'Product View and Delay Management')]");
	private By productOverviewBtn = By.xpath("//button[contains(text(),'Product Overview')]");
	private By taskGrpProdctOvrVw = By.xpath("(//div[@class='dhx_shape-container']/div)[1]");
	private By teamManagement = By.xpath("//a[contains(@href,'team-management')]");
	private By createopBtn = By.xpath("//button[contains(text(),'Create new operator')]");
	private By vsb = By.xpath("//div[contains(text(),'VSB')]");
	private By moveBatchbtn = By.xpath("//button[contains(text(),'Move Batch ')]");
	private By labelIAM = By.xpath("(//a[@class='dropdown-item'])[1]");
	private By createNewUserbtn = By.xpath("//button[contains(text(),' Create User ')]");
	private By managerview = By.xpath("//div[contains(text(),'Manager View')]");
	private By alertBtn = By.xpath("//button[contains(text(),'Alerts')]");
	private By navigatePlan = By.xpath("//button[@class='btn btn-warning planButton']");
	private By microplanning = By.xpath("//div[contains(text(),'Microplanning')]");
	private By planner = By.xpath("//div[contains(text(),'Planner')]");
	private By shiftLeader = By.xpath("//div[contains(text(),' Shift Leader ')]");
	private By ShiftLeadView = By.xpath("//div[contains(text(),' Daily Operator Management ')]");
	private By dailuOpmnagement = By.xpath("//li[contains(text(),' Daily Operator Management ')]");
	private By shiftPattern = By.xpath("//a[contains(@href,'shift-pattern')]");
	private By selectTeamDD = By.xpath("//span[contains(text(),'Select Teams')]");
	private By mapprocess = By.xpath("//a[contains(@href,'builder')]");
	private By processBuilderText = By.xpath("//li[contains(text(),'Process Builder')]");
	private By productname = By.xpath("(//div[@class='gantt_tree_content'])[1]");
	private By clickProductName = By.xpath("(//div[@class='gantt_tree_icon gantt_open'])[1]");
	private By productionTab = By.xpath("(//div[.='PRODUCTION '])[2]");
	private By shiftHandover = By.xpath("//div[contains(text(),' Shift Summary & Handover ')]");
	private By shiftHOText = By.xpath("//div[contains(@class,'shift-details-container')]");
	private By ExpandAll = By.xpath("//a[contains(text(),'Expand All ')]");
	private By firstTaskName = By.xpath("(//div[@class='gantt_cell gantt_cell_tree'])[4]/div[6]");
	public static By adminConsole = By.xpath("//a[contains(@href,'user-preference')]");
	private By secoundTaskNameEle = By.xpath("(//div[@class='gantt_cell gantt_cell_tree'])[5]/div[6]");

	private By firstBatchNameEle = By.xpath("(//div[@class='gantt_cell gantt_cell_tree'])[2]");
	public By masterData = By.xpath("//a[@id='v-pills-master']");
	private By datamanagement = By.xpath("//a[@ng-reflect-router-link='/dataManagement']");
	public By dataCatalogBtn = By.xpath("//a[contains(text(),'Create Data Catalog')]");
	private By materialMasterTab = By.xpath("(//div[.='Material Master'])[5]");
	private By newMaterialMasterBtn = By.xpath("//a[.='New Material']");
	private By planValidationPage = By.xpath("//a[contains(@href,'planValidation')]");
	private By validateBtn = By.xpath("//button[.='Validate']");
	public By vsb7days = By.xpath("//div[contains(text(),' VSB (7 Days) ')]");
	private By getFirstTaskTime = By.xpath("(//div[@data-column-name='start_date'])[4]");
	private By recipeManagementTab = By.xpath("//div[@title='Recipe Management']");
	private By recipeBtn = By.xpath("//a[.='Recipe']");
	private By firstBatchEle = By.xpath("(//div[@class='gantt_tree_content'])[9]");

	String PN;
	String finalPN;
	String firstTaskDate = "null";
	// -----xpath for task group level----

	private By firstTaskGroupName = By.xpath("(//div[@data-column-name='task']/div[@class='gantt_tree_content'])[3]");
	private By collapseAllBtn = By.xpath("//a[.='Collapse All ']");
	private By secoundTaskGroupNameEle = By.xpath("((//div[@class='gantt_cell gantt_cell_tree'])[4]/div)[5]");

	public static String firstTaskNames = "test";
	public static String secoundTaskName;

	public Navigation(WebDriver driver) {
		this.driver = driver;
	}

	public void holidayCalendar() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(3000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(3000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(4000);
		driver.findElement(dataManagement).click();
		Thread.sleep(2000);
		driver.findElement(masterDataIcon).click();
		Thread.sleep(2000);
		driver.findElement(holidayCal).click();
		Thread.sleep(4000);

		if (driver.findElement(addNewCalendarBtn).isDisplayed()) {
			System.out.println("Navigated to Holiday Calendar");
		}
	}

	public void factoryCalendar() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(3000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(3000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(3000);
		driver.findElement(dataManagement).click();
		Thread.sleep(2000);
		driver.findElement(masterDataIcon).click();
		Thread.sleep(2000);
		driver.findElement(factoryCal).click();
		Thread.sleep(2000);
		driver.findElement(factorycalCard).click();
		if (driver.findElement(InsideFC).isDisplayed()) {
			System.out.println("Navigated to factory Calendar");
		}
	}

	public void productOverview() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(7000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(7000);
		}

		driver.findElement(controlTower).click();
		Thread.sleep(2000);
		driver.findElement(manager).click();
		Thread.sleep(2500);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		driver.findElement(productview).click();
		Thread.sleep(1000);
		driver.findElement(productOverviewBtn).click();
		Thread.sleep(1000);
		if (driver.findElement(taskGrpProdctOvrVw).isDisplayed()) {
			System.out.println("navigated to Product Overview");
		}

	}

	public void TeamManagement() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(4000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(2000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(4000);
		driver.findElement(teamManagement).click();
		Thread.sleep(2000);
		if (driver.findElement(createopBtn).isDisplayed()) {
			System.out.println("Navigated to Team Management");
		}

	}

	public void VSB() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(6000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(6000);
		}

		driver.findElement(vsb).click();
		Thread.sleep(5000);

	}

	public void IAM() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(5000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(6000);
		}

		driver.findElement(userDropDown).click();
		driver.findElement(labelIAM).click();
		Thread.sleep(5000);
		if (driver.findElement(createNewUserbtn).isDisplayed()) {
			System.out.println("Navigated to IAM");
		}

	}

	public boolean ManagerView() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(7000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.findElement(controlTower).click();
		Thread.sleep(2000);
		driver.findElement(manager).click();
		Thread.sleep(2000);
		driver.findElement(managerview).click();
		Thread.sleep(2000);
		if (driver.findElement(alertBtn).isDisplayed()) {
			System.out.println("Navigated to ManagerView");
			return true;
		} else {
			return false;
		}
	}

	public void navigateToPlanner() throws InterruptedException {
		Thread.sleep(3000);
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(3000);
		}

		catch (Exception e) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(bodheeLogoBodhee));
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.findElement(microplanning).click();
		Thread.sleep(1000);
		driver.findElement(planner).click();
		Thread.sleep(1000);
	}

	public void LattestPublishedPlan() throws InterruptedException {
		Thread.sleep(3000);
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(5000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.findElement(microplanning).click();
		Thread.sleep(1500);
		driver.findElement(planner).click();
		Thread.sleep(1500);
		driver.findElement(navigatePlan).click();
		Thread.sleep(1500);
	}

	public void ShiftLeadView() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(3000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.findElement(controlTower).click();
		Thread.sleep(1000);
		driver.findElement(shiftLeader).click();
		Thread.sleep(1000);
		driver.findElement(ShiftLeadView).click();
		Thread.sleep(1000);

		if (driver.findElement(dailuOpmnagement).isDisplayed()) {
			System.out.println("navigated to ShiftLead Vew");
		}

	}

	public void ShiftPattern() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(3000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.navigate().refresh();
		Thread.sleep(6000);

		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(3000);
		driver.findElement(shiftPattern).click();
		Thread.sleep(1000);
		if (driver.findElement(selectTeamDD).isDisplayed()) {
			System.out.println("Navigated to Shift Pattern");
		}
	}

	public void MapProcess() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(9000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(9000);
		}

		driver.navigate().refresh();
		Thread.sleep(9000);
		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(10000);
		driver.findElement(mapprocess).click();
		Thread.sleep(3000);
		if (driver.findElement(processBuilderText).isDisplayed()) {
			System.out.println("Navigated to Map Process");
		}

	}

	public String GetProductDetailsFromPlanner() throws InterruptedException {
		driver.findElement(productionTab).click();
		Thread.sleep(15000);

		if (EventProperties.actionLevel.equals("Task Group")) {
			PN = driver.findElement(productname).getText();
			String arr[] = PN.split("-");
			PN = arr[0];
			System.out.println("product name in planner " + PN);
			finalPN = " " + PN + " ";
			System.out.println("product name after comvert " + finalPN);
			return finalPN;
		}

		else {

			PN = driver.findElement(productname).getText();
			System.out.println("product name in planner " + PN);
			finalPN = " " + PN + " ";
			System.out.println("product name after comvert " + finalPN);
			return finalPN;
		}

	}

	public boolean Shifthandover() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(7000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(7000);
		}

		driver.findElement(controlTower).click();
		Thread.sleep(1000);
		driver.findElement(manager).click();
		Thread.sleep(1000);
		driver.findElement(shiftHandover).click();
		Thread.sleep(3000);

		if (driver.findElement(shiftHOText).isDisplayed()) {
			System.out.println("navigated to Shift Handover");
			return true;
		}
		return false;

	}

	public String findFirstTaskFromPlanner() {
		driver.findElement(ExpandAll).click();
		String firstTaskNames = driver.findElement(firstTaskName).getText();
		firstTaskNames = firstTaskNames;
		System.out.println(firstTaskNames);
		return firstTaskNames;
	}

	public String getFirstBatchName() {
		String batchName = driver.findElement(firstBatchNameEle).getAttribute("aria-label");
		System.out.println("Attribute value of batch name " + batchName);
		return batchName;
	}

	public void batchMonitoring() throws InterruptedException {
		Thread.sleep(3000);
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(5000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.findElement(controlTower).click();
		Thread.sleep(1000);
		driver.findElement(manager).click();
		Thread.sleep(1000);
		driver.findElement(productview).click();
		Thread.sleep(1000);

		Thread.sleep(1000);
		if (driver.findElement(productOverviewBtn).isDisplayed()) {
			System.out.println("navigated to Batch Monitoring");
		}

	}

	public void DataManagement() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(9000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(9000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(6000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(3000);
		driver.findElement(datamanagement).click();
		Thread.sleep(4000);
		if (driver.findElement(dataCatalogBtn).isDisplayed()) {
			System.out.println("Navigated to data management");
		}

	}

	public void FactoryCalendar() throws InterruptedException {
		DataManagement = new DataManagement(driver);
		factCalendar = new FactoryCalender(driver);
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(5000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(18000);
		driver.findElement(datamanagement).click();
		Thread.sleep(4000);
		driver.findElement(DataManagement.masterData).click();
		Thread.sleep(2000);
		driver.findElement(DataManagement.factorycalendar).click();
		Thread.sleep(2000);
		if (driver.findElement(factCalendar.newCalendar).isDisplayed()) {
			System.out.println("Navigated to data management");
		}

	}

	public void vsb3Days() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(3000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}
		driver.findElement(vsb7days).click();
		Thread.sleep(4000);
	}

	public boolean materialMaster() throws InterruptedException {
		DataManagement = new DataManagement(driver);
		factCalendar = new FactoryCalender(driver);
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(7000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(7000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(7000);
		driver.findElement(datamanagement).click();
		Thread.sleep(4000);
		driver.findElement(DataManagement.masterData).click();
		Thread.sleep(3000);
		driver.findElement(materialMasterTab).click();
		Thread.sleep(1000);
		try {
			driver.findElement(newMaterialMasterBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean planValidation() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(7000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(7000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(7000);

		driver.findElement(planValidationPage).click();
		Thread.sleep(2000);
		try {
			driver.findElement(validateBtn).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean navigateRecipeManagement() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(7000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(7000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(7000);
		driver.findElement(datamanagement).click();
		Thread.sleep(4000);
		driver.findElement(masterData).click();
		Thread.sleep(3000);
		driver.findElement(recipeManagementTab).click();
		Thread.sleep(2000);
		try {
			driver.findElement(recipeBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void addValueToEventProp() throws InterruptedException {
		Thread.sleep(3000);
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(5000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.findElement(microplanning).click();
		Thread.sleep(1500);
		driver.findElement(planner).click();
		Thread.sleep(1500);
		driver.findElement(navigatePlan).click();
		Thread.sleep(1500);

		driver.findElement(productionTab).click();
		Thread.sleep(15000);
		String PN = driver.findElement(productname).getText();
		System.out.println(PN);
		finalPN = " " + PN + " ";
		System.out.println("Final product Name is :" + finalPN);
		driver.findElement(ExpandAll).click();

		if (EventProperties.actionLevel.equals("Task Group")) {
			System.out.println("inside task group");

			firstTaskNames = driver.findElement(firstTaskGroupName).getText();

			Thread.sleep(1000);

			String firstTaskGroupNameInPlanner = firstTaskNames = driver.findElement(firstTaskGroupName).getText();

			driver.findElement(collapseAllBtn).click();

			Thread.sleep(500);

			driver.findElement(clickProductName).click();

			Thread.sleep(500);

			driver.findElement(clickProductName).click();

			Thread.sleep(500);

			secoundTaskName = driver.findElement(secoundTaskGroupNameEle).getText();

			System.out.println("First task group Name in planner " + firstTaskNames);

			System.out.println("Secound task group Name in planner " + secoundTaskName);

			String firstTaskTime = driver.findElement(getFirstTaskTime).getText();

			this.firstTaskDate = firstTaskTime.replace(" ", "-");

			System.out.println("First task time is " + firstTaskTime);

			String firstTaskDate = firstTaskTime.replaceAll("\\s.*", "");

			System.out.println("First task date is " + firstTaskDate);

			String arr[] = firstTaskDate.split("-");
			firstTaskDate = arr[1] + arr[2] + arr[0];

			System.out.println("First task date after convert is " + firstTaskDate);

			EventProperties.task_Date = firstTaskDate;

			EventProperties.delayTime = firstTaskDate;

			EventProperties.delayCloseTime = firstTaskDate;

			EventProperties.earlyStartTime = firstTaskDate;

			EventProperties.earlyClose = firstTaskDate;

			EventProperties.eqUnAvlDate = firstTaskDate;

			System.out.println("First task date in event prop " + EventProperties.task_Date);

			driver.findElement(collapseAllBtn).click();

			driver.findElement(clickProductName).click();

			Thread.sleep(500);

			String firstBatchNo = driver.findElement(firstBatchEle).getText();

			System.out.println("First Batc Number in planner " + firstBatchNo);

			EventProperties.firstBatchNumber = firstBatchNo;

			EventProperties.firstTaskGroupName = firstTaskGroupNameInPlanner;
			System.out.println("First Task froup Name in Planner :" + firstTaskGroupNameInPlanner);

		}

		else {

			String firstTaskGroupNameInPlanner = firstTaskNames = driver.findElement(firstTaskGroupName).getText();

			firstTaskNames = driver.findElement(firstTaskName).getText();

			secoundTaskName = driver.findElement(secoundTaskNameEle).getText();

			System.out.println("First task Name in planner " + firstTaskNames);

			System.out.println("secound task Name in planner " + secoundTaskName);

			String firstTaskTime = driver.findElement(getFirstTaskTime).getText();

			this.firstTaskDate = firstTaskTime.replace(" ", "-");

			System.out.println("First task time is " + firstTaskTime);

			String firstTaskDate = firstTaskTime.replaceAll("\\s.*", "");

			System.out.println("First task date is " + firstTaskDate);

			String arr[] = firstTaskDate.split("-");
			firstTaskDate = arr[1] + arr[2] + arr[0];

			System.out.println("First task date after convert is " + firstTaskDate);

			EventProperties.task_Date = firstTaskDate;

			EventProperties.delayTime = firstTaskDate;

			EventProperties.delayCloseTime = firstTaskDate;

			EventProperties.earlyStartTime = firstTaskDate;

			EventProperties.earlyClose = firstTaskDate;

			EventProperties.eqUnAvlDate = firstTaskDate;

			System.out.println("First task date in event prop " + EventProperties.task_Date);

			driver.findElement(collapseAllBtn).click();

			driver.findElement(clickProductName).click();

			Thread.sleep(500);

			String firstBatchNo = driver.findElement(firstBatchEle).getText();

			System.out.println("First Batc Number in planner " + firstBatchNo);

			EventProperties.firstBatchNumber = firstBatchNo;

			EventProperties.firstTaskGroupName = firstTaskGroupNameInPlanner;
			System.out.println("First Task froup Name in Planner :" + firstTaskGroupNameInPlanner);
		}

	}

	public void adminConsole() throws InterruptedException {

		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(7000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(7000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(7000);
		driver.findElement(adminConsole).click();
		Thread.sleep(2500);

	}

}
