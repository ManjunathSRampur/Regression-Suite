package com.qa.bps.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.aspectj.weaver.patterns.ExactAnnotationFieldTypePattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Navigation {

	WebDriver driver;

	private By bodheLogoIMP = By.xpath("//img[@src='./assets/png/bodhee_logo.png']");
	private By bodheeLogoBodhee = By.cssSelector("img[src='./assets/png/bodhee_logo_new.png']");
	private By userDropDown = By.xpath("//p[@id='navbarDropdown']");
	private By bodheeStudioLabel = By.xpath("//a[contains(text(),'Bodhee Studio')]");
	private By dataManagement = By.xpath("//a[contains(@href,'dataManagement')]");
	private By masterDataIcon = By.xpath("//a[@id='v-pills-master']");
	private By factoryCal = By.xpath("//div[@title='Factory Calendar']");
	private By holidayCal = By.xpath("//div[@title='Holiday Calendar']");
	private By addNewCalendarBtn = By.xpath("(//div[@class='card tileCard'])[1]");
	private By factorycalCard = By.xpath("(//div[@class='card tileCard'])[2]");
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
	private By productionTab = By.xpath("(//div[.='PRODUCTION '])[2]");
	private By shiftHandover = By.xpath("//div[contains(text(),' Shift Summary & Handover ')]");
	private By shiftHOText = By.xpath("//a[contains(text(),'Published On ')]");
	private By ExpandAll = By.xpath("//a[contains(text(),'Expand All ')]");
	private By firstTaskName = By.xpath("(//div[@class='gantt_cell gantt_cell_tree'])[4]/div[6]");
	private By firstBatchNameEle = By.xpath("(//div[@class='gantt_cell gantt_cell_tree'])[2]");

	private By datamanagement = By.xpath("//a[@ng-reflect-router-link='/dataManagement']");
	public By dataCatalogBtn = By.xpath("//a[contains(text(),'Create Data Catalog')]");
	private By materialMasterTab = By.xpath("(//div[.='Material Master'])[5]");
	private By newMaterialMasterBtn = By.xpath("//a[.='New Material']");
	private By planValidationPage = By.xpath("//a[contains(@href,'planValidation')]");
	private By validateBtn = By.xpath("//button[.='Validate']");

	public By vsb7days = By.xpath("//div[contains(text(),' VSB (7 Days) ')]");

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
			Thread.sleep(3000);
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
			Thread.sleep(4000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(6000);
		}

		driver.findElement(vsb).click();
		Thread.sleep(3000);

	}

	public void IAM() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(3000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(6000);
		}

		driver.findElement(userDropDown).click();
		driver.findElement(labelIAM).click();
		Thread.sleep(3000);
		if (driver.findElement(createNewUserbtn).isDisplayed()) {
			System.out.println("Navigated to IAM");
		}

	}

	public void ManagerView() throws InterruptedException {
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
		driver.findElement(manager).click();
		Thread.sleep(1000);
		driver.findElement(managerview).click();
		Thread.sleep(2000);
		if (driver.findElement(alertBtn).isDisplayed()) {
			System.out.println("Navigated to ManagerView");
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
		Thread.sleep(8000);
         System.out.println("Inside Home page");
		driver.findElement(microplanning).click();
		Thread.sleep(1500);
		System.out.println("MIcro planning clicked");
		driver.findElement(planner).click();
		System.out.println("Planner clicked");
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
			Thread.sleep(3000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(3000);
		driver.findElement(mapprocess).click();
		Thread.sleep(1000);
		if (driver.findElement(processBuilderText).isDisplayed()) {
			System.out.println("Navigated to Map Process");
		}

	}

	public String GetProductDetailsFromPlanner() throws InterruptedException {
		driver.findElement(productionTab).click();
		Thread.sleep(4000);
		String PN = driver.findElement(productname).getText();
		System.out.println(PN);
		String finalPN = " " + PN + " ";
		System.out.println(finalPN);
		return finalPN;

	}

	public void Shifthandover() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(3000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(3000);
		}

		driver.findElement(controlTower).click();
		Thread.sleep(1000);
		driver.findElement(manager).click();
		Thread.sleep(1000);
		driver.findElement(shiftHandover).click();
		Thread.sleep(3000);

		if (driver.findElement(shiftHOText).isDisplayed()) {
			System.out.println("navigated to Shift Handover");
		}

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
			Thread.sleep(3000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(3000);
		driver.findElement(datamanagement).click();
		Thread.sleep(4000);
		if (driver.findElement(dataCatalogBtn).isDisplayed()) {
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

	public boolean planValidation() throws InterruptedException {
		try {
			driver.findElement(bodheLogoIMP).click();
			Thread.sleep(3000);
		}

		catch (Exception e) {
			driver.findElement(bodheeLogoBodhee).click();
			Thread.sleep(5000);
		}

		driver.findElement(userDropDown).click();
		Thread.sleep(1000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(3000);

		driver.findElement(planValidationPage).click();
		Thread.sleep(2000);
		try {
			driver.findElement(validateBtn).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

}
