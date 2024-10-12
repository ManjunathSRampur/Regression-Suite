package com.qa.bps.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qa.bps.utils.ElementUtil;

public class AdminConsole {
	WebDriver driver;
	String time = null;
	String timehour = null;
	Navigation navigateTo;
	public static String firstTaskName;

	public AdminConsole(WebDriver driver) {
		this.driver = driver;
		navigateTo = new Navigation(driver);
	}

	private By firstBatchInBatchMonitoring = By.xpath("(//div[@class='batch-details-row'])[1]");
	private By availableProductInBatchMonitoring = By
			.xpath("//div[contains(@class,'product-section-individual-container product-nam')]");
	private By DelayToleranceTab = By.xpath("//a[@routerlink='delay-tolerance']");
	private By delayToleranceText = By.xpath("//h3[contains(text(),'Delay Tolerance & Threshold Policy')]");
	private By DelayToleranceDurationInput = By.xpath("(//input[@inputmode='numeric'])[1]");
	private By DelayThresholdDurationInput = By.xpath("(//input[@inputmode='numeric'])[2]");
	private By UOMHrsBtn1 = By.xpath("(//input[@value='hrs'])[1]");
	private By UOMHrsBtn2 = By.xpath("(//input[@value='hrs'])[2]");
	private By reasonCodeDD = By.xpath("//button[@class='dropdown-head font-16']");
	private By saveBtn = By.xpath("(//button[contains(text(),'Save')])[2]");
	private By delayReasonOp = By.xpath("(//button[@class='dropdown-btn'])[1]");
	private By delayReasonOp1 = By.xpath("(//span[contains(text(), '" + EventProperties.delayReasonCode + "')])[1]");
	private By homeNav = By.xpath("//a[contains(text(),'Home')]");
	private By toasterMsg = By.xpath("//div[@role='alertdialog']");
	private By firsttask = By.xpath(EventProperties.event_Id);
	private By LogDelayPopup = By.xpath("//div[@class='root ng-star-inserted']");
	private By logdelayAlert = By.xpath("//div[@class='w-100 root ng-star-inserted']");
	public String ToasterMessage = "null";
	private By delayAlertInSH = By.xpath("//a[.=' Duration']/parent::div");
	public String DelayReason;
	private By nonWorkingHrsTstr = By.xpath("//div[@aria-label='Can not start task in non working hours!']");
	private By nonWorkingHrsTstrClose = By.xpath("//div[@aria-label='Can not close task in non working hours!']");
	String nonWorkingHrsTstrMsg = "null";

	public void resetTask() throws InterruptedException {
		try {
			driver.findElement(VSBpage.CloseButton).click();
			firsttask = By.xpath(EventProperties.event_Id);
			driver.findElement(firsttask).click();
			Thread.sleep(1000);
			driver.findElement(VSBpage.ReSettask).click();
			Thread.sleep(1000);
			driver.findElement(VSBpage.ReSetButton).click();
			Thread.sleep(8000);

		} catch (Exception e) {

			firsttask = By.xpath(EventProperties.event_Id);
			driver.findElement(firsttask).click();
			Thread.sleep(1000);
			driver.findElement(VSBpage.ReSettask).click();
			Thread.sleep(1000);
			driver.findElement(VSBpage.ReSetButton).click();
			Thread.sleep(8000);
		}
	}

	public boolean navigateToDelayToleranceTab() throws InterruptedException {
		VSBpage.delayReasonOp = By.xpath("(//span[contains(text(), '" + EventProperties.delayReasonCode + "')])[1]");
		delayReasonOp1 = By.xpath("(//span[contains(text(), '" + EventProperties.delayReasonCode + "')])[1]");
		ProductOverview.selectReason = By.xpath("//span[contains(text(),'" + EventProperties.delayReasonCode + "')]");
		BatchMonitoring.delayReasonOp = By
				.xpath("(//span[contains(text(), '" + EventProperties.delayReasonCode + "')])[1]");
		boolean b = true;
		driver.findElement(DelayToleranceTab).click();
		Thread.sleep(1000);
		if (driver.findElement(delayToleranceText).isDisplayed()) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean availabilityOfInputFields() {
		boolean b = true;
		try {
			driver.findElement(DelayToleranceDurationInput).isDisplayed();
			driver.findElement(DelayThresholdDurationInput).isDisplayed();
			b = true;
		} catch (Exception e) {
			System.out.println("Delay Tolerance input box not displayed");
			b = false;
		}
		return b;
	}

	public boolean availabilityOfUOMRadioBtn() {
		boolean b = true;
		try {
			driver.findElement(UOMHrsBtn1).isDisplayed();
			driver.findElement(UOMHrsBtn2).isDisplayed();
			b = true;
		} catch (Exception e) {
			System.out.println("UOM Radio button not vailable ");
			b = false;
		}
		return b;
	}

	public boolean availabilityOfReasonCodeDD() {
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = true;
		} catch (Exception e) {
			System.out.println("reason code dropdown is not available ");
			b = false;

		}
		return b;
	}

	public boolean availabilityOfSaveBtn() {
		boolean b = true;

		try {
			driver.findElement(saveBtn).isDisplayed();
			b = true;
		} catch (Exception e) {
			System.out.println("Save Button not available");
			b = false;

		}
		return b;
	}

	public boolean userCanConfigureDelaytolAndThreshold() throws InterruptedException {

		driver.findElement(DelayToleranceDurationInput).clear();
		Thread.sleep(1000);
		driver.findElement(DelayToleranceDurationInput).sendKeys("2");
		Thread.sleep(1000);
		driver.findElement(DelayThresholdDurationInput).clear();
		driver.findElement(DelayThresholdDurationInput).sendKeys("4");
		driver.findElement(reasonCodeDD).click();
		Thread.sleep(1500);
//		driver.findElement(delayReasonOp).click();
		driver.findElement(delayReasonOp1).click();
		Thread.sleep(1400);
		driver.findElement(UOMHrsBtn1).click();
		Thread.sleep(1000);
		driver.findElement(UOMHrsBtn2).click();
		driver.findElement(saveBtn).click();
		Thread.sleep(1200);

		try {
			ToasterMessage = driver.findElement(toasterMsg).getText();

		} catch (Exception e) {
			System.out.println("No Toaster Displayed");
		}
		System.out.println(ToasterMessage);

		String toleranceValue = driver.findElement(DelayToleranceDurationInput).getAttribute("ng-reflect-model");
		String ThresoldValue = driver.findElement(DelayThresholdDurationInput).getAttribute("ng-reflect-model");
		DelayReason = EventProperties.delayReasonCode;
		System.out.println(toleranceValue);
		System.out.println(ThresoldValue);

		boolean b = true;
		if (toleranceValue.equals("2") && ThresoldValue.equals("4")) {
			b = true;
		} else {
			System.out.println("Thresold or Tolerance value not configured after clicking save button");
			b = false;
		}
		return b;
	}

	public boolean toasterMessageAfterClickingSaveBtn() {
		boolean b = true;

		if (ToasterMessage.equals("Changes saved successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean VerifyConfiguredTolerancePostRefresh() throws InterruptedException {

		driver.findElement(homeNav).click();
		Thread.sleep(2000);
		driver.findElement(Navigation.adminConsole).click();
		Thread.sleep(2000);
		driver.findElement(DelayToleranceTab).click();
		Thread.sleep(1500);
		String toleranceValue = driver.findElement(DelayToleranceDurationInput).getAttribute("ng-reflect-model");
		String ThresoldValue = driver.findElement(DelayThresholdDurationInput).getAttribute("ng-reflect-model");
		System.out.println(toleranceValue);
		System.out.println(ThresoldValue);

		boolean b = true;
		if (toleranceValue.equals("2") && ThresoldValue.equals("4")
				&& EventProperties.delayReasonCode.equals(DelayReason)) {
			b = true;
		} else {
			System.out.println("Thresold or Tolerance value not configured after clicking save button");
			b = false;
		}
		return b;

	}

	public boolean verifyDelayedStartBelowtoleranceFromVsb() throws InterruptedException {
		firsttask = By.xpath(EventProperties.event_Id);
		Actions actions = new Actions(driver);
		navigateTo.VSB();
		driver.findElement(VSBpage.DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		driver.findElement(VSBpage.starttaskoption).click();
		Thread.sleep(1000);
		driver.findElement(VSBpage.delayStartDatePicker).sendKeys(EventProperties.delayTime);
		Thread.sleep(1000);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);

		Thread.sleep(1000);

		System.out.println("date added ");
		Thread.sleep(2000);
		driver.findElement(VSBpage.starttaskbutton).click();

		Thread.sleep(1500);
		boolean b = true;
		try {
			driver.findElement(LogDelayPopup).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		Thread.sleep(8000);
		return b;
	}

	public boolean verifyLogDelayAlertPostDelayedStartBelowTolerance() throws InterruptedException {
		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		boolean b = true;
		try {
			driver.findElement(logdelayAlert).isDisplayed();
			driver.findElement(VSBpage.CloseButton).click();
			b = false;
		} catch (Exception e) {
			driver.findElement(VSBpage.CloseButton).click();
			b = true;
		}
		return b;
	}

	public boolean delayedFinishBelowTolerance() throws InterruptedException {
		resetTask();
		Actions actions = new Actions(driver);

		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		driver.findElement(VSBpage.starttaskoption).click();
		Thread.sleep(1000);
		driver.findElement(VSBpage.starttaskbutton).click();
		Thread.sleep(8000);
		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		driver.findElement(VSBpage.markAsCompleteoption).click();
		Thread.sleep(1200);
		driver.findElement(VSBpage.delayCloseDatePicker).sendKeys(EventProperties.delayTime);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		driver.findElement(VSBpage.markAsCompleteButton).click();
		boolean b = true;
		try {
			driver.findElement(LogDelayPopup).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		Thread.sleep(8000);
		return b;

	}

	public boolean verifyLogDelayAlertPostDelayedfinishBelowTolerance() throws InterruptedException {
		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		boolean b = true;
		try {
			driver.findElement(logdelayAlert).isDisplayed();
			driver.findElement(VSBpage.CloseButton).click();
			b = false;
		} catch (Exception e) {
			driver.findElement(VSBpage.CloseButton).click();
			b = true;
		}
		return b;
	}

	public boolean delayedStartBetweenToleranceAndThreshold() throws InterruptedException {
		resetTask();
		Actions actions = new Actions(driver);
		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		driver.findElement(VSBpage.starttaskoption).click();
		Thread.sleep(1000);
		driver.findElement(VSBpage.starttaskbutton).click();
		Thread.sleep(8000);
		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		driver.findElement(VSBpage.markAsCompleteoption).click();
		Thread.sleep(1200);
		driver.findElement(VSBpage.delayCloseDatePicker).sendKeys(EventProperties.delayTime);
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		driver.findElement(VSBpage.markAsCompleteButton).click();
		boolean b = true;
		try {
			driver.findElement(LogDelayPopup).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		Thread.sleep(8000);
		return b;
	}

	public boolean AlertDisplayedBetweentolAndThrsh() throws InterruptedException {
		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInVsb).isDisplayed();
			driver.findElement(VSBpage.CloseButton).click();
			b = true;
		} catch (Exception e) {
			driver.findElement(VSBpage.CloseButton).click();
			b = false;
		}
		return b;

	}

	public boolean delayReasonValidationPostdelayedSartBetweentoleranceAndthreshold() throws InterruptedException {
		firsttask = By.xpath(EventProperties.event_Id);
		boolean b = true;
		driver.findElement(firsttask).click();
		Thread.sleep(1200);

		try {
			String fullAlertMsg = driver.findElement(VSBpage.delayAlertInVsb).getText();
			System.out.println(fullAlertMsg);
			String trim1 = fullAlertMsg.replace("N/A - ", "");
			String delayreasonCode = trim1.replace(" ; Duration: 3 hrs", "");

			if (DelayReason.equals(delayreasonCode)) {
				b = true;
			} else {
				b = false;

			}
		} catch (Exception e) {
			System.out.println("No alerts available");
			b = false;
		}

		return b;
	}

	public boolean delayedFinishBetweenToleranceAndThreshold() throws InterruptedException {

		resetTask();
		Actions actions = new Actions(driver);

		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		driver.findElement(VSBpage.starttaskoption).click();
		Thread.sleep(1000);
		driver.findElement(VSBpage.starttaskbutton).click();
		Thread.sleep(8000);
		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		driver.findElement(VSBpage.markAsCompleteoption).click();
		Thread.sleep(1200);
		driver.findElement(VSBpage.delayCloseDatePicker).sendKeys(EventProperties.delayTime);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		driver.findElement(VSBpage.markAsCompleteButton).click();
		boolean b = true;
		try {
			driver.findElement(LogDelayPopup).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		Thread.sleep(8000);
		return b;

	}

	// ------------------
	public boolean AlertDisplayedBetweentolAndThrshWithDelayedFinish() throws InterruptedException {
		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInVsb).isDisplayed();
			driver.findElement(VSBpage.CloseButton).click();
			b = true;
		} catch (Exception e) {
			driver.findElement(VSBpage.CloseButton).click();
			b = false;
		}
		return b;

	}

	public boolean delayReasonValidationBetweentoleranceAndthresholdWithDelayedFinish() throws InterruptedException {
		firsttask = By.xpath(EventProperties.event_Id);
		boolean b = true;
		driver.findElement(firsttask).click();
		Thread.sleep(1200);

		try {
			String fullAlertMsg = driver.findElement(VSBpage.delayAlertInVsb).getText();
			System.out.println(fullAlertMsg);
			String trim1 = fullAlertMsg.replace("N/A - ", "");
			String delayreasonCode = trim1.replace(" ; Duration: 3 hrs", "");

			if (DelayReason.equals(delayreasonCode)) {
				b = true;
			} else {
				b = false;

			}
		} catch (Exception e) {
			System.out.println("No alerts available");
			b = false;
		}

		return b;
	}

	public boolean delyedStartAboveThreshold() throws InterruptedException {
		firsttask = By.xpath(EventProperties.event_Id);

		resetTask();
		Thread.sleep(4000);
		boolean b = true;
		Actions actions = new Actions(driver);
		boolean flag = true;

		Thread.sleep(6000);
		driver.findElement(firsttask).click();

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
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		Thread.sleep(2000);
		driver.findElement(VSBpage.starttaskbutton).click();
		System.out.println("start button is clicked ");
		try {
			driver.findElement(LogDelayPopup).isDisplayed();
			b = true;
		} catch (Exception e) {

		}
		Thread.sleep(3000);
		driver.findElement(VSBpage.delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		VSBpage.reason = driver.findElement(VSBpage.delayReasonOp).getText();
		System.out.println("delay reason is " + VSBpage.reason);
		Thread.sleep(3000);
		driver.findElement(VSBpage.delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(VSBpage.additonalCmt).sendKeys("Test");
		Thread.sleep(1000);

		driver.findElement(VSBpage.logDelayButton).click();
		Thread.sleep(2000);
		return b;

	}

	// ----

	public boolean AlertDisplayedAboveThresholdWithDelayedStart() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(VSBpage.DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(5000);
		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInVsb).isDisplayed();
			driver.findElement(VSBpage.CloseButton).click();
			b = true;
		} catch (Exception e) {
			driver.findElement(VSBpage.CloseButton).click();
			b = false;
		}
		return b;

	}

	public boolean delayReasonValidationAbovethresholdWithDelayedStart() throws InterruptedException {
		firsttask = By.xpath(EventProperties.event_Id);
		boolean b = true;

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(VSBpage.DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(5000);

		driver.findElement(firsttask).click();
		Thread.sleep(1200);

		try {
			String fullAlertMsg = driver.findElement(VSBpage.delayAlertInVsb).getText();
			System.out.println(fullAlertMsg);
			String trim1 = fullAlertMsg.replace("N/A - ", "");
			String delayreasonCode = trim1.replace(" ; Duration: 5 hrs", "");

			if (DelayReason.equals(delayreasonCode)) {
				b = true;
			} else {
				b = false;

			}
		} catch (Exception e) {
			System.out.println("No alerts available");
			b = false;
		}

		return b;
	}

	// -----------

	public boolean delayedFinishAboveThreshold() throws InterruptedException {

		firsttask = By.xpath(EventProperties.event_Id);

		resetTask();
		boolean b = true;
		driver.findElement(firsttask).click();
		Thread.sleep(1000);
		driver.findElement(VSBpage.starttaskoption).click();
		System.out.println("start opton is clicked");
		Thread.sleep(2000);
		driver.findElement(VSBpage.starttaskbutton).click();
		System.out.println("start button is clicked ");
		Thread.sleep(8000);

		driver.findElement(firsttask).click();
		System.out.println("first task is clicked ");
		driver.findElement(VSBpage.markAsCompleteoption).click();
		System.out.println("mark as acomplete option is clicked ");
		Thread.sleep(2000);

		driver.findElement(VSBpage.delayCloseDatePicker).sendKeys(EventProperties.delayCloseTime);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		System.out.println("date added ");
		driver.findElement(VSBpage.markAsCompleteButton).click();
		System.out.println("mark as complete button clicked ");
		try {
			driver.findElement(LogDelayPopup).isDisplayed();
			b = true;
		} catch (Exception e) {

		}

		Thread.sleep(2000);
		driver.findElement(VSBpage.delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(VSBpage.delayReasonOp).click();
		Thread.sleep(2000);
		driver.findElement(VSBpage.additonalCmt).sendKeys("Test");
		driver.findElement(VSBpage.logDelayButton).click();
		Thread.sleep(8000);

		return b;

	}

	public boolean AlertDisplayedAboveThresholdWithDelayedFinish() throws InterruptedException {
		driver.findElement(firsttask).click();
		Thread.sleep(1200);
		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInVsb).isDisplayed();
			driver.findElement(VSBpage.CloseButton).click();
			b = true;
		} catch (Exception e) {
			driver.findElement(VSBpage.CloseButton).click();
			b = false;
		}
		return b;

	}

	public boolean delayReasonValidationAbovethresholdWithDelayedFinish() throws InterruptedException {
		firsttask = By.xpath(EventProperties.event_Id);
		boolean b = true;
		driver.findElement(firsttask).click();
		Thread.sleep(1200);

		try {
			String fullAlertMsg = driver.findElement(VSBpage.delayAlertInVsb).getText();
			System.out.println(fullAlertMsg);
			String trim1 = fullAlertMsg.replace("N/A - ", "");
			String delayreasonCode = trim1.replace(" ; Duration: 5 hrs", "");

			if (DelayReason.equals(delayreasonCode)) {
				b = true;
			} else {
				b = false;

			}
		} catch (Exception e) {
			System.out.println("No alerts available");
			b = false;
		}

		return b;
	}

	public void setUpBeforeProductOverView() throws InterruptedException {
		resetTask();
		navigateTo.productOverview();
	}

	// ---------Delay Tolerance Testcases for Product Overview

	public void resetTaskInProductOverview() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		driver.findElement(ProductOverview.startDD).click();
		System.out.println("startDD is clicked ");
		Thread.sleep(2000);
		try {
			driver.findElement(ProductOverview.resetButton).click();
			driver.switchTo().alert().accept();
			System.out.println("resetButton is clicked ");
		} catch (Exception e) {

		}

		System.out.println("alert is clicked ");
		Thread.sleep(8000);

	}

	public boolean DelayedStartBelowToleranceFromProductOverview() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		Select product = new Select(driver.findElement(VSBpage.ProductNameDrop));
		Thread.sleep(1000);
		String Finaltext = "";
		for (WebElement option : product.getOptions()) {
			System.out.println(option.getText().trim());
			System.out.println(VSBpage.productName.trim());

			if (VSBpage.productName.trim().contains(option.getText().trim())) {
				System.out.println("inside if condition ");
				Finaltext = option.getText();
				product.selectByVisibleText(Finaltext);
				break;
			}
		}

		System.out.println("productDisplayed");
		Thread.sleep(1000);
		driver.findElement(VSBpage.batchDD).click();
		driver.findElement(VSBpage.selectFirstBatch).click();
		System.out.println("Batch is selected");

		// --

		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(1000);
		driver.findElement(ProductOverview.startOp).click();
		Thread.sleep(2000);
		new EventProperties();
		driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.delayTime);
		// driver.findElement(ProductOverview.startdatePicker).sendKeys("02072024");

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(ProductOverview.startButton).click();
		boolean b = true;
		try {
			driver.findElement(LogDelayPopup).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		System.out.println("27 Executed Successfully");
		return b;
	}

	public boolean ValidateDelayAlertinProdOvWithDelayedStartBlowTol() {
		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInPov).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		System.out.println("28 Executed Successfully");
		return b;

	}

	public boolean delayedFinishBelowToleranceInProdOverview() throws InterruptedException {

		resetTaskInProductOverview();
		System.out.println("Post Reset delayed finish method execution started");
		Thread.sleep(5000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(2000);
		driver.findElement(ProductOverview.startOp).click();
		Thread.sleep(2000);
		new EventProperties();

		driver.findElement(ProductOverview.startButton).click();
		Thread.sleep(5000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(1500);
		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(2000);
		driver.findElement(ProductOverview.closeOp).click();
		Thread.sleep(3000);
		driver.findElement(ProductOverview.endDatePicker).sendKeys(EventProperties.delayCloseTime);
		// driver.findElement(ProductOverview.endDatePicker).sendKeys("02072024");
		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(ProductOverview.closeButton).click();
		Thread.sleep(5000);
		boolean b = true;
		try {
			driver.findElement(LogDelayPopup).isDisplayed();
			System.out.println("Log delay popup displayed below tolerance");
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;

	}

	public boolean ValidateDelayAlertinProdOvWithDelayedFinishBelowTol() {
		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInPov).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;

	}

	public boolean delayedStartBetwentolAndThresProdOv() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);

		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(1000);
		driver.findElement(ProductOverview.startOp).click();
		Thread.sleep(2000);
		new EventProperties();
		driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.delayTime);
		// driver.findElement(ProductOverview.startdatePicker).sendKeys("02072024");

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(ProductOverview.startButton).click();

		Thread.sleep(4000);
		boolean b = true;
		try {
			driver.findElement(LogDelayPopup).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;

	}

	public boolean alertDisplayedInProdOvBetweenTolAndthreshPostDelayedStart() {
		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInPov).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	// --
	public boolean delayReasonValidationPostdelayedSartBetweentoleranceAndthresholdinProdOv()
			throws InterruptedException {

		boolean b = true;

		Thread.sleep(1200);

		try {
			String fullAlertMsg = driver.findElement(VSBpage.delayAlertInPov).getText();
			System.out.println(fullAlertMsg);

			String trim1 = fullAlertMsg.replace(" ; Duration: 3 hrs", "");
			String delayreasonCode = trim1.replace(" - Delayed Started", "");

			System.out.println("Expected : " + DelayReason);
			System.out.println("Actual : " + delayreasonCode);

			if (DelayReason.equals(delayreasonCode)) {
				b = true;
			} else {
				b = false;

			}
		} catch (Exception e) {
			System.out.println("No alerts available");
			b = false;
		}

		return b;
	}

	public boolean delayedFinishBetweenTolAndThresInProdOv() throws InterruptedException {

		resetTaskInProductOverview();
		System.out.println("Post Reset delayed start method execution started");
		Thread.sleep(5000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(2000);
		driver.findElement(ProductOverview.startOp).click();
		Thread.sleep(2000);
		new EventProperties();

		driver.findElement(ProductOverview.startButton).click();
		Thread.sleep(5000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(1500);
		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(2000);
		driver.findElement(ProductOverview.closeOp).click();
		Thread.sleep(3000);
		driver.findElement(ProductOverview.endDatePicker).sendKeys(EventProperties.delayCloseTime);
		// driver.findElement(ProductOverview.endDatePicker).sendKeys("02072024");
		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(ProductOverview.closeButton).click();
		Thread.sleep(5000);
		boolean b = true;
		try {
			driver.findElement(LogDelayPopup).isDisplayed();
			System.out.println("Log delay popup displayed below tolerance");
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;

	}
	// --

	public boolean alertDisplayedInProdOvBetweenTolAndthreshPostDelayedFinish() {
		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInPov).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	// --
	public boolean delayReasonValidationPostdelayedFinishBetweentoleranceAndthresholdinProdOv()
			throws InterruptedException {

		boolean b = true;

		Thread.sleep(1200);

		try {
			String fullAlertMsg = driver.findElement(VSBpage.delayAlertInPov).getText();
			System.out.println(fullAlertMsg);

			String trim1 = fullAlertMsg.replace(" ; Duration: 3 hrs", "");
			String delayreasonCode = trim1.replace(" - Delayed Finish", "");

			System.out.println("Expected : " + DelayReason);
			System.out.println("Actual : " + delayreasonCode);

			if (DelayReason.equals(delayreasonCode)) {
				b = true;
			} else {
				b = false;

			}
		} catch (Exception e) {
			System.out.println("No alerts available");
			b = false;
		}

		return b;

	}

	// -- delayed start above threshold in product Overview

	public boolean delayedStartAboveThresholdProdOv() throws InterruptedException {
		boolean b = true;
		driver.navigate().refresh();
		Thread.sleep(4000);

		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(1000);
		driver.findElement(ProductOverview.startOp).click();
		Thread.sleep(2000);
		new EventProperties();
		driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.delayTime);
		// driver.findElement(ProductOverview.startdatePicker).sendKeys("02072024");

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(ProductOverview.startButton).click();
		Thread.sleep(4000);
		try {
			driver.findElement(ProductOverview.chooseReasonDD).isDisplayed();
			b = true;
		} catch (Exception e) {
			System.out.println("Above threhold choose delay reason dropdown is not displayed");
			b = false;
		}

		driver.findElement(ProductOverview.chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(ProductOverview.selectReason).click();
		Thread.sleep(1000);
		driver.findElement(ProductOverview.commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(ProductOverview.logDelayButton).click();

		Thread.sleep(6000);

		return b;

	}

	public boolean alertDisplayedInProdOvAboveThresholdPostDelayedStart() {
		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInPov).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	// --
	public boolean delayReasonValidationPostdelayedSartAboveThresholdinProdOv() throws InterruptedException {

		boolean b = true;

		Thread.sleep(1200);

		try {
			String fullAlertMsg = driver.findElement(VSBpage.delayAlertInPov).getText();
			System.out.println(fullAlertMsg);

			String trim1 = fullAlertMsg.replace(" ; Duration: 5 hrs", "");
			String delayreasonCode = trim1.replace(" - Delayed Started", "");

			System.out.println("Expected : " + DelayReason);
			System.out.println("Actual : " + delayreasonCode);

			if (DelayReason.equals(delayreasonCode)) {
				b = true;
			} else {
				b = false;

			}
		} catch (Exception e) {
			System.out.println("No alerts available");
			b = false;
		}

		return b;
	}

	// ----------Delayed finish above threshold

	public boolean delayedFinishAboveThresInProdOv() throws InterruptedException {
		boolean b = true;

		System.out.println("Post Reset delayed start method execution started");
		Thread.sleep(5000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(2000);
		driver.findElement(ProductOverview.startOp).click();
		Thread.sleep(2000);
		new EventProperties();

		driver.findElement(ProductOverview.startButton).click();
		Thread.sleep(5000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(1500);
		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(2000);
		driver.findElement(ProductOverview.closeOp).click();
		Thread.sleep(3000);
		driver.findElement(ProductOverview.endDatePicker).sendKeys(EventProperties.delayCloseTime);
//		driver.findElement(ProductOverview.endDatePicker).sendKeys("02072024");
		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(ProductOverview.closeButton).click();
		Thread.sleep(5000);

		try {
			driver.findElement(ProductOverview.chooseReasonDD).isDisplayed();
			b = true;
		} catch (Exception e) {
			System.out.println("Above threhold choose delay reason dropdown is not displayed");
			b = false;
		}

		driver.findElement(ProductOverview.chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(ProductOverview.selectReason).click();
		Thread.sleep(1000);
		driver.findElement(ProductOverview.commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(ProductOverview.logDelayButton).click();

		Thread.sleep(6000);

		return b;

	}
	// --

	public boolean alertDisplayedInProdOvAboveThreshPostDelayedFinish() {
		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInPov).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	// --
	public boolean delayReasonValidationPostdelayedFinishAboveThresholdinProdOv() throws InterruptedException {

		boolean b = true;

		Thread.sleep(1200);

		try {
			String fullAlertMsg = driver.findElement(VSBpage.delayAlertInPov).getText();
			System.out.println(fullAlertMsg);

			String trim1 = fullAlertMsg.replace(" ; Duration: 5 hrs", "");
			String delayreasonCode = trim1.replace(" - Delayed Finish", "");

			System.out.println("Expected : " + DelayReason);
			System.out.println("Actual : " + delayreasonCode);

			if (DelayReason.equals(delayreasonCode)) {
				b = true;
			} else {
				b = false;

			}
		} catch (Exception e) {
			System.out.println("No alerts available");
			b = false;
		}

		return b;

	}

	public boolean earlyStartFromProdOvBelowTol() throws InterruptedException {
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(1000);
		driver.findElement(ProductOverview.startOp).click();
		Thread.sleep(2000);
		new EventProperties();
		driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.delayTime);
		// driver.findElement(ProductOverview.startdatePicker).sendKeys("02072024");

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(ProductOverview.startButton).click();
		Thread.sleep(6000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;
	}

	public boolean ValidateAlertinProdOvWithEarlyStartBlowTol() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInPov).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		System.out.println("28 Executed Successfully");
		return b;

	}

	public boolean earlyFinishBelowToleranceInProdOv() throws InterruptedException {

		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(2000);
		driver.findElement(ProductOverview.startOp).click();
		Thread.sleep(2000);
		new EventProperties();

		driver.findElement(ProductOverview.startButton).click();
		Thread.sleep(5000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(1500);
		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(2000);
		driver.findElement(ProductOverview.closeOp).click();
		Thread.sleep(3000);
		driver.findElement(ProductOverview.endDatePicker).sendKeys(EventProperties.delayCloseTime);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		Thread.sleep(2000);
		driver.findElement(ProductOverview.closeButton).click();

		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {

		}

		Thread.sleep(6000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}

		return b;

	}

	public boolean ValidateAlertinProdOvWithEarlyFinishBelowTol() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInPov).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;
	}

	public boolean earlyStartBetweenTolAndThreshInProdOv() throws InterruptedException {
		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(1000);
		driver.findElement(ProductOverview.startOp).click();
		Thread.sleep(2000);
		new EventProperties();
		driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.delayTime);
		// driver.findElement(ProductOverview.startdatePicker).sendKeys("02072024");

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(ProductOverview.startButton).click();
		Thread.sleep(1000);

		try {
			nonWorkingHrsTstrMsg = driver.findElement(nonWorkingHrsTstr).getText();
			return true;
		} catch (Exception e) {

		}
		Thread.sleep(6000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;
	}

	public boolean alertDisplayedInProdOvBetweenTolAndthreshPostEaryStart() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(4000);

		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInPov).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		if (nonWorkingHrsTstrMsg.equals("Can not start task in non working hours!")) {
			return true;
		}

		return b;
	}

	public boolean delayReasonValidationPostEarlySartBetweentoleranceAndthresholdinProdOv()
			throws InterruptedException {

		boolean b = true;

		Thread.sleep(1200);

		try {
			String fullAlertMsg = driver.findElement(VSBpage.delayAlertInPov).getText();
			System.out.println(fullAlertMsg);

			String trim1 = fullAlertMsg.replace(" ; Duration: -3 hrs", "");
			String delayreasonCode = trim1.replace(" - Early Start", "");

			System.out.println("Expected : " + DelayReason);
			System.out.println("Actual : " + delayreasonCode);

			if (DelayReason.equals(delayreasonCode)) {
				b = true;
			} else {
				b = false;

			}
		} catch (Exception e) {
			System.out.println("No alerts available");
			b = false;
		}

		if (nonWorkingHrsTstrMsg.equals("Can not start task in non working hours!")) {
			return true;
		}

		return b;
	}

	public boolean earlyStartAboveThresholdFromProdOv() throws InterruptedException {

		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(1000);
		driver.findElement(ProductOverview.startOp).click();
		Thread.sleep(2000);
		new EventProperties();
		// driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.delayTime);
		driver.findElement(ProductOverview.startdatePicker).sendKeys("02072024");

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		boolean b = true;
		driver.findElement(ProductOverview.startButton).click();
		Thread.sleep(4000);

		try {
			nonWorkingHrsTstrMsg = driver.findElement(nonWorkingHrsTstr).getText();
			return true;
		} catch (Exception e) {

		}

		try {
			driver.findElement(ProductOverview.chooseReasonDD).isDisplayed();
			b = true;
		} catch (Exception e) {
			System.out.println("Above threhold choose delay reason dropdown is not displayed");
			b = false;
		}

		driver.findElement(ProductOverview.chooseReasonDD).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(ProductOverview.selectReason).click();
		Thread.sleep(1000);
		driver.findElement(ProductOverview.commentsInput).sendKeys("Comment added For Testing Purpose");
		driver.findElement(ProductOverview.logDelayButton).click();

		Thread.sleep(6000);

		return b;
	}

	public boolean alertDisplayedInProdOvAbovethreshPostEaryStart() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(5000);

		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		boolean b = true;
		try {
			driver.findElement(VSBpage.delayAlertInPov).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		if (nonWorkingHrsTstrMsg.equals("Can not start task in non working hours!")) {
			return true;
		}
		return b;
	}

	public boolean delayReasonValidationPostEarlySartAboveThresholdinProdOv() throws InterruptedException {

		boolean b = true;

		Thread.sleep(1200);

		try {
			String fullAlertMsg = driver.findElement(VSBpage.delayAlertInPov).getText();
			System.out.println(fullAlertMsg);

			String trim1 = fullAlertMsg.replace(" ; Duration: -5 hrs", "");
			String delayreasonCode = trim1.replace(" - Early Start", "");

			System.out.println("Expected : " + DelayReason);
			System.out.println("Actual : " + delayreasonCode);

			if (DelayReason.equals(delayreasonCode)) {
				b = true;
			} else {
				b = false;

			}
		} catch (Exception e) {
			System.out.println("No alerts available");
			b = false;
		}

		if (nonWorkingHrsTstrMsg.equals("Can not start task in non working hours!")) {
			return true;
		}

		return b;
	}

	// -----------Sumit Testcase ends here,and Manjunath's Started

	// ---------------------Delay Tolerance TC For Shift Handover--------------

	public void resetTaskInProductOverviewForSH() throws InterruptedException {

//		navigateTo.productOverview();                                                  
//		driver.findElement(By.xpath("//div[@class='ml-3']/select")).click();
//		Thread.sleep(1500);
//		driver.findElement(By.xpath("//option[contains(text(),'PQB-24U001 ')]")).click();
//		Thread.sleep(1200);

		driver.findElement(ProductOverview.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);

		driver.findElement(ProductOverview.startDD).click();
		Thread.sleep(1000);

		try {
			driver.findElement(ProductOverview.startOp).isEnabled();
			System.out.println("Task is already reset");

		} catch (Exception e) {

			Thread.sleep(2000);
			driver.findElement(ProductOverview.resetButton).click();
			System.out.println("resetButton is clicked ");
			driver.switchTo().alert().accept();
			System.out.println("alert is clicked ");
			Thread.sleep(13000);

		}

	}

	public void setUpBeforeShiftHandoverView() throws InterruptedException {
		Thread.sleep(2000);
		// resetTaskInProductOverviewForSH();
		Thread.sleep(4000);
		navigateTo.Shifthandover();
		System.out.println("inside shift handover page ");
	}

	


	public boolean taskStatusAfterStart() throws InterruptedException {
		Thread.sleep(2000);
		String Status = driver.findElement(By.xpath("(//td/a[.='Not Started' or .='In-progress' or .='CLOSED'])[1]"))
				.getText();
		if (Status.equalsIgnoreCase("In-progress")) {

			return true;
		} else {

			return false;
		}

	}

	

	
	



	

	
	
	// --tol and thresh value 0

	public void ChangeThresholdAndTolToZero() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		navigateTo.adminConsole();
		Thread.sleep(4000);
		driver.findElement(DelayToleranceTab).click();
		Thread.sleep(1000);
		driver.findElement(DelayToleranceDurationInput).clear();
		Thread.sleep(1000);
		driver.findElement(DelayToleranceDurationInput).sendKeys("0");
		Thread.sleep(1000);
		driver.findElement(DelayThresholdDurationInput).clear();
		Thread.sleep(1400);
		driver.findElement(DelayThresholdDurationInput).sendKeys("0");
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
	}



	


	


	

	


	



	

	
	



	


	



	

	// -----------Batch Monitoring Starts here

	public void setupBeforeBatchMonitoring() throws InterruptedException {
		navigateTo.batchMonitoring();
		Thread.sleep(2000);

		System.out.println("Product Name in planner " + VSBpage.productName);

		List<WebElement> lists = driver.findElements(availableProductInBatchMonitoring);
		for (WebElement ls : lists) {
			if (VSBpage.productName.trim().contains(ls.getText().trim())) {
				VSBpage.productName = ls.getText();
				break;
			}
		}
		System.out.println("Product Name is " + VSBpage.productName);
		firstBatchInBatchMonitoring = By.xpath("(//div[.='" + VSBpage.productName + "'])[1]");
		driver.findElement(firstBatchInBatchMonitoring).click();

	}

	public void resetTaskInBM() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
		try {
			driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
			Thread.sleep(2000);
			driver.findElement(BatchMonitoring.resetButton).click();
			Thread.sleep(1500);
			driver.switchTo().alert().accept();
			Thread.sleep(10000);
		} catch (Exception e) {

		}
	}

	// -----------------------------------------------

	public boolean DelayedstartBelowToleranceInBatchMonitoring() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTask).click();
		Thread.sleep(2000);
		driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.task_Date);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(BatchMonitoring.startTaskBtn).click();
		Thread.sleep(6000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;
	}

	public boolean verifyAlertWithDelayedstartBelowToleranceinBM() throws InterruptedException {

		Thread.sleep(4000);

		boolean b = true;
		try {
			driver.findElement(BatchMonitoring.alertForLogDelay).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;
	}

	public boolean delayedFinishBelowTolBM() throws InterruptedException {
		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTask).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTaskBtn).click();
		Thread.sleep(6000);

		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		driver.findElement(BatchMonitoring.markAsCompleteOp).click();
		Thread.sleep(1000);
		// driver.findElement(BatchMonitoring.delayCloseDatePicker).sendKeys(EventProperties.delayCloseTime);
		driver.findElement(BatchMonitoring.delayCloseDatePicker).sendKeys(EventProperties.task_Date);

		Thread.sleep(1000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		driver.findElement(BatchMonitoring.markAsCompleteBtn).click();
		Thread.sleep(8000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;

	}

	public boolean verifyAlertWithDelayedFinishBelowToleranceinBM() {
		boolean b = true;
		try {
			driver.findElement(BatchMonitoring.alertForLogDelay).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;
	}

	public boolean delayedStartBetweenTolAndThreshBM() throws InterruptedException {

		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTask).click();
		Thread.sleep(2000);
		// driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.delayTime);
		driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(BatchMonitoring.startTaskBtn).click();
		Thread.sleep(6000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;

	}

	public boolean DelayedStartalertDisplayedBetweenTolAndThreshBM() {
		boolean b = true;
		try {
			driver.findElement(BatchMonitoring.alertForLogDelay).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean validateDelayReasonBetweenTolAndThreshWithDelayedStartBM() {
		String delaycode = driver.findElement(BatchMonitoring.alertForLogDelay).getText();
		String[] a = delaycode.split("-");
		String ActDelayReason = a[0].replace(" ", "");
		System.out.println(ActDelayReason);
		System.out.println("Expected delay reason " + DelayReason);
		System.out.println("Actual delay reason " + ActDelayReason);
		if (DelayReason.replace(" ", "").equals(ActDelayReason)) {
			return true;
		} else
			return false;

	}

	public boolean delayedFinishBetweenTolAndThreshBM() throws InterruptedException {
		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTask).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTaskBtn).click();
		Thread.sleep(6000);

		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		driver.findElement(BatchMonitoring.markAsCompleteOp).click();
		Thread.sleep(1000);
		// driver.findElement(BatchMonitoring.delayCloseDatePicker).sendKeys(EventProperties.delayCloseTime);
		driver.findElement(BatchMonitoring.delayCloseDatePicker).sendKeys(EventProperties.task_Date);

		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		driver.findElement(BatchMonitoring.markAsCompleteBtn).click();
		Thread.sleep(8000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;

	}

	public boolean DelayedFinishalertDisplayedBetweenTolAndThreshBM() {
		boolean b = true;
		try {
			driver.findElement(BatchMonitoring.alertForLogDelay).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean validateDelayReasonBetweenTolAndThreshWithDelayedFinishBM() {
		String delaycode = driver.findElement(BatchMonitoring.alertForLogDelay).getText();
		String[] a = delaycode.split("-");
		String ActDelayReason = a[0].replace(" ", "");
		System.out.println(ActDelayReason);
		System.out.println("Expected delay reason " + DelayReason);
		System.out.println("Actual delay reason " + ActDelayReason);
		if (DelayReason.replace(" ", "").equals(ActDelayReason)) {
			return true;
		} else
			return false;

	}

	public boolean delayedStartAboveThreshInBM() throws InterruptedException {

		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTask).click();
		Thread.sleep(2000);
		// driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.delayTime);
		driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(BatchMonitoring.startTaskBtn).click();
		Thread.sleep(6000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}

		driver.findElement(BatchMonitoring.delayStartReasonDD).click();

		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.delayReasonOp).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
		driver.findElement(BatchMonitoring.logDelayButton).click();
		System.out.println("Log delay button clicked");
		Thread.sleep(15000);

		return b;

	}

	public boolean DelayedStartAlertDisplayedaboveThreshBM() {
		boolean b = true;
		try {
			driver.findElement(BatchMonitoring.alertForLogDelay).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean validateDelayReasonAboveThresholdDelayedStartBM() {
		String delaycode = driver.findElement(BatchMonitoring.alertForLogDelay).getText();
		String[] a = delaycode.split("-");
		String ActDelayReason = a[0].replace(" ", "");
		System.out.println(ActDelayReason);
		System.out.println("Expected delay reason " + DelayReason);
		System.out.println("Actual delay reason " + ActDelayReason);
		if (DelayReason.replace(" ", "").equals(ActDelayReason)) {
			return true;
		} else
			return false;
	}

	public boolean delayedFinishAboveThresholdBM() throws InterruptedException {

		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTask).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTaskBtn).click();
		Thread.sleep(6000);

		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		driver.findElement(BatchMonitoring.markAsCompleteOp).click();
		Thread.sleep(1000);
		// driver.findElement(BatchMonitoring.delayCloseDatePicker).sendKeys(EventProperties.delayCloseTime);
		driver.findElement(BatchMonitoring.delayCloseDatePicker).sendKeys(EventProperties.task_Date);

		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1500);
		driver.findElement(BatchMonitoring.markAsCompleteBtn).click();
		Thread.sleep(2000);

		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}

		driver.findElement(BatchMonitoring.delayStartReasonDD).click();

		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.delayReasonOp).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
		driver.findElement(BatchMonitoring.logDelayButton).click();
		System.out.println("Log delay button clicked");
		Thread.sleep(15000);

		return b;

	}

	public boolean DelayedFinishAlertDisplayedaboveThreshBM() {
		boolean b = true;
		try {
			driver.findElement(BatchMonitoring.alertForLogDelay).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean validateDelayReasonAboveThresholdDelayedFinishBM() {
		String delaycode = driver.findElement(BatchMonitoring.alertForLogDelay).getText();
		String[] a = delaycode.split("-");
		String ActDelayReason = a[0].replace(" ", "");
		System.out.println(ActDelayReason);
		System.out.println("Expected delay reason " + DelayReason);
		System.out.println("Actual delay reason " + ActDelayReason);
		if (DelayReason.replace(" ", "").equals(ActDelayReason)) {
			return true;
		} else
			return false;
	}

	public boolean earlyStartBelowToleranceBM() throws InterruptedException {
		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTask).click();
		Thread.sleep(2000);
		// driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.delayTime);
		driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(BatchMonitoring.startTaskBtn).click();
		Thread.sleep(6000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;
	}

	public boolean earlyStartAlertDisplayedBelowToleranceBM() {
		boolean b = true;
		try {
			driver.findElement(BatchMonitoring.alertForLogDelay).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;
	}

	public boolean earlyFinishBelowToleranceBM() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTask).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTaskBtn).click();
		Thread.sleep(6000);

		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		driver.findElement(BatchMonitoring.markAsCompleteOp).click();
		Thread.sleep(1000);

		driver.findElement(BatchMonitoring.delayCloseDatePicker).sendKeys(EventProperties.task_Date);

		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1500);

		driver.findElement(BatchMonitoring.markAsCompleteBtn).click();

		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {

		}

		Thread.sleep(8000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;

	}

	public boolean earlyFinishAlertDisplayedBelowToleranceBM() {
		boolean b = true;
		try {
			driver.findElement(BatchMonitoring.alertForLogDelay).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;
	}

	public boolean earlyStartBetweenToleranceAndThresholdBM() throws InterruptedException {
		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTask).click();
		Thread.sleep(2000);
		// driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.delayTime);
		driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(BatchMonitoring.startTaskBtn).click();
		Thread.sleep(1000);
		try {
			nonWorkingHrsTstrMsg = driver.findElement(nonWorkingHrsTstr).getText();
			return true;
		} catch (Exception e) {

		}
		Thread.sleep(6000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}

		return b;
	}

	public boolean earlyStartalertDisplayedBetweenTolAndThreshBM() {
		boolean b = true;
		try {
			driver.findElement(BatchMonitoring.alertForLogDelay).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}

		if (nonWorkingHrsTstrMsg.equals("Can not start task in non working hours!")) {
			return true;
		}

		return b;
	}

	public boolean validateDelayReasonBetweenTolAndThreshWithEarlyStartBM() {
		if (nonWorkingHrsTstrMsg.equals("Can not start task in non working hours!")) {
			return true;
		}

		String delaycode = driver.findElement(BatchMonitoring.alertForLogDelay).getText();
		String[] a = delaycode.split("-");
		String ActDelayReason = a[0].replace(" ", "");
		System.out.println(ActDelayReason);
		System.out.println("Expected delay reason " + DelayReason);
		System.out.println("Actual delay reason " + ActDelayReason);
		if (DelayReason.replace(" ", "").equals(ActDelayReason)
				|| nonWorkingHrsTstrMsg.equals("Can not start task in non working hours!")) {
			return true;
		} else
			return false;
	}

	public boolean EarlyStartAboveThreshInBM() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(7000);

		driver.findElement(BatchMonitoring.firstTaskToglleBtn).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.startTask).click();
		Thread.sleep(2000);
		// driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.delayTime);
		driver.findElement(ProductOverview.startdatePicker).sendKeys(EventProperties.task_Date);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);

		System.out.println("date added ");

		driver.findElement(BatchMonitoring.startTaskBtn).click();
		Thread.sleep(6000);
		boolean b = true;
		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}

		driver.findElement(BatchMonitoring.delayStartReasonDD).click();

		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(BatchMonitoring.delayReasonOp).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
		driver.findElement(BatchMonitoring.logDelayButton).click();
		System.out.println("Log delay button clicked");
		Thread.sleep(15000);

		try {
			driver.findElement(reasonCodeDD).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}

		return b;

	}

	public boolean earlyStartalertDisplayedAboveThresholdBM() {
		boolean b = true;
		try {
			driver.findElement(BatchMonitoring.alertForLogDelay).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}

		if (nonWorkingHrsTstrMsg.equals("Can not start task in non working hours!")) {
			return true;
		}

		return b;
	}

	public boolean validateDelayReasonAboveThresholdWithEarlyStartBM() {

		if (nonWorkingHrsTstrMsg.equals("Can not start task in non working hours!")) {
			return true;
		}

		String delaycode = driver.findElement(BatchMonitoring.alertForLogDelay).getText();
		String[] a = delaycode.split("-");
		String ActDelayReason = a[0].replace(" ", "");
		System.out.println(ActDelayReason);
		System.out.println("Expected delay reason " + DelayReason);
		System.out.println("Actual delay reason " + ActDelayReason);
		if (DelayReason.equals(ActDelayReason)
				|| nonWorkingHrsTstrMsg.equals("Can not start task in non working hours!")) {
			return true;
		} else
			return false;

	}

}
