package com.qa.bps.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.ss.usermodel.*;
import com.qa.bps.pages.SeleniumDatabaseTesting;

import com.qa.bps.utils.ElementUtil;

public class PlanGenerationSC00 {

	WebDriver driver;
	Navigation navigateTo;

	String planMsg;

	String randomStr;
	String planname;
	String pstatus;

	boolean manageScenarioPopupAvailable;

	boolean updateButtonAvailable;

	private ElementUtil eleUtil;
	private By createNewPLanBtn = By.xpath("//label[@title='Create New Plan']");
	private By createNewPlanInput = By.xpath("//input[@id='planTitle']");
	private By planDescInput = By.xpath("//input[@id='planDescription']");
	private By planningCycleBtn = By.xpath("(//button[@data-toggle='dropdown'])[3]");
	private By monthlyPlanOption = By.xpath("(//a[contains(text(),' Monthly Plan ')])[2]");
	private By chooseScDD = By.xpath("//div[contains(text(),' Choose Scenario ')]");
	private By scenario01Option = By.xpath("//a[contains(text(),' Sc-0 ')]");
	private By baselineDt = By.xpath("//input[@id='baseLineDate']");
	private By nextBtn = By.xpath("//button[contains(text(),'Next')]");
	private By processOrderOption = By.xpath("(//input[@name='selectingSource'])[2]");
	private By campaignOption = By.xpath("(//input[@name='selectingSource'])[1]");
	private By loadLattestCampaignCheckBox = By.xpath("(//input[@type='checkbox'])[2]");
	private By triggerPlanbtn = By.xpath("//button[contains(text(),'Trigger Plan')]");
	private By doneBtn = By.xpath("//button[contains(text(),'Done')]");
	private By savedVersion = By.xpath("(//a[contains(text(),'Saved Version')])[1]");
	private By draft = By.xpath("(//label[contains(text(),'DRAFT')])[1]");
	private By failed = By.xpath("(//label[contains(text(),'Failed')])[1]");
	private By planStatus = By.xpath("(//div[@class='align-items-center'])[3]/label");
	private By abortBtn = By.xpath("(//fa[@name='fas fa-ban'])[1]");
	private By abortConfirmation = By.xpath("//button[contains(text(),'Abort')]");
	private By selectAll = By.xpath("//input[@title='Select All']");
	private By filterBtn = By.xpath("(//p[@id='navbarDropdown'])[2]");
	private By startsWithOptn = By.xpath("(//a[contains(text(),'Start with')])[1]");
	private By applyBtn = By.xpath("(//button[contains(text(),'Apply')])[1]");
	private By checkBoxes = By.xpath("//input[@type='checkbox']");
	private By startdateoptn = By.xpath("(//p[@id='navbarDropdown'])[6]");
	private By lessThan = By.xpath("(//a[contains(text(),'Less Than')])[1]");
	private By lessthanInput = By.xpath("(//input[@type='date'])[1]");
	private By lessTahnApply = By.xpath("(//button[contains(text(),'Apply')])[5]");
	private By navigateToGaneratedPlan = By.xpath("(//fa/i)[4]");
	private By batchesCount = By.xpath("(//div[@class='bodhee-kpi-card-value'])[1]");
	private By CampaignCount = By.xpath("(//div[@class='bodhee-kpi-card-value'])[2]");
	private By startsWithInput = By.xpath("(//div[@class='container ng-star-inserted']/input)[1]");
	private By searchPlanVersionDD = By.xpath("//div[@class='c-btn']");
	private By lattestPlanVersionID = By.xpath("(//label)[1]");
	private By submitBtn = By.xpath("//button[contains(text(),'Submit')]");
	private By validationMsg = By.xpath("//div[@class='text-holder']");
	// trigerring autoschedule
	private By autoschedule = By.xpath("(//div[.='Auto Schedule'])[2]");
	private By trigger = By.xpath("//button[.='Approve']");
	private By version = By.xpath("//img[@class='pointer']");
	private By versionhistoryEle = By.xpath("//div[@id='myNav']/div/div[2]/div[1]/div/div[3]/label");

	// batch moving
	private By startDateEle = By.xpath("(//div[@data-column-name='start_date'])[2]");
	private By Updtstartdate = By.xpath("(//div[@data-column-name='start_date'])[2]");
	private By productiontab = By.xpath("(//div[.='PRODUCTION '])[2]");
	private By expandAllBtn = By.xpath("//a[.='Expand All ']");
	private By firstBatch = By.xpath("(//div[@class='gantt_task_content'])[2]");
	private By cmtBox = By.xpath("//label[.='Comments*']/following-sibling::input");
	private By saveBtn = By.xpath("//button[.='Save']");
	private By toaterMsg = By.xpath("//div[@role='alertdialog']");
	private By saveas = By.xpath("(//div[.='Save as'])[2]");
	private By savecmt = By.xpath("(//input[@placeholder='Enter save comment'])[3]");
	private By savechng = By.xpath("//a[.='Save change']");
	private By latestarrow = By.xpath("(//fa[@name='fas fa-arrow-right'])[1]");
	private By closeicon = By.xpath("//fa[@name='fas fa-times']");

	// After autoschedule plan
	private By lattestPlanVersionID1 = By.xpath("(//label)[1]");
	// -----------------------Update Xpath ----------------------------------

	String baseLineDates;
	String Scenario;
	String startDateAfterDrag;
	String startDateAfterautoschedule;
	public static String plID;

//-------------------------------------------------------------------------------------------
	public PlanGenerationSC00(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		navigateTo = new Navigation(driver);
	}

//*********************************************************************************	
//Plan generation with sc0 starts here
	public boolean createAnewPlanScenario0() throws InterruptedException {
		String planName = RandomStringUtils.randomAlphanumeric(2);
		String Pn = "Automation " + planName;
		driver.findElement(createNewPLanBtn).click();
		Thread.sleep(1000);
		driver.findElement(createNewPlanInput).sendKeys(Pn);
		driver.findElement(planDescInput).sendKeys("Plan Generation Test with scenario 0");
		driver.findElement(planningCycleBtn).click();
		driver.findElement(monthlyPlanOption).click();
		driver.findElement(baselineDt).sendKeys(EventProperties.baselineDate);
		driver.findElement(chooseScDD).click();
		Scenario = driver.findElement(scenario01Option).getText();
		driver.findElement(scenario01Option).click();
		Thread.sleep(1500);
		driver.findElement(nextBtn).click();
		Thread.sleep(500);
		driver.findElement(nextBtn).click();
		Thread.sleep(500);

		if (EventProperties.ProcessOrderFlag.equalsIgnoreCase("True")) {

			driver.findElement(processOrderOption).click();
			Thread.sleep(500);
			driver.findElement(nextBtn).click();
			Thread.sleep(1000);
			driver.findElement(selectAll).click();
			Thread.sleep(1000);
			driver.findElement(filterBtn).click();
			Thread.sleep(1000);
			driver.findElement(startsWithOptn).click();
			Thread.sleep(1500);

			driver.findElement(startsWithInput).sendKeys(EventProperties.productNameStartsWith);
			System.out.println("Input value added");

			Thread.sleep(1500);
			driver.findElement(applyBtn).click();
			System.out.println("Input value added");

			Thread.sleep(500);
			driver.findElement(selectAll).click();
			Thread.sleep(1000);
			driver.findElement(selectAll).click();
			Thread.sleep(1000);
			driver.findElement(startdateoptn).click();
			Thread.sleep(1500);
			driver.findElement(lessThan).click();
			Thread.sleep(1500);
			driver.findElement(lessthanInput).sendKeys(EventProperties.lessThanDate);
			Thread.sleep(1000);
			driver.findElement(lessTahnApply).click();
			Thread.sleep(1000);
			driver.findElement(selectAll).click();
			Thread.sleep(500);
			driver.findElement(triggerPlanbtn).click();
			Thread.sleep(500);
			driver.findElement(doneBtn).click();
			Thread.sleep(500);
		} else {
			driver.findElement(loadLattestCampaignCheckBox).click();
			Thread.sleep(500);
			driver.findElement(nextBtn).click();
			Thread.sleep(1500);
			driver.findElement(triggerPlanbtn).click();
			Thread.sleep(1000);
			driver.findElement(doneBtn).click();
			Thread.sleep(1500);

		}

		ArrayList<String> st = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(1500);
		driver.navigate().to("https://dev.bodhee.com/qa/qa2/algovalidation");
		Thread.sleep(4000);
		driver.findElement(searchPlanVersionDD).click();
		Thread.sleep(1500);
		plID = driver.findElement(lattestPlanVersionID).getText();
		System.out.println("Generated plan Version ID: " + plID);
		driver.findElement(lattestPlanVersionID).click();
		Thread.sleep(1400);
		driver.findElement(submitBtn).click();
		Thread.sleep(4000);
		String ValMsg = driver.findElement(validationMsg).getText();
		System.out.println(ValMsg);
		Thread.sleep(1500);
		driver.close();
		driver.switchTo().window(st.get(0));
		Thread.sleep(2500);

		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(savedVersion).click();
		Thread.sleep(1000);

		boolean b = false;
		String status = "null";
		for (int i = 1; i < 400; i++) {
			driver.findElement(savedVersion).click();
			Thread.sleep(1500); // 10 min
			status = driver.findElement(planStatus).getText();
			if (status.equalsIgnoreCase("Plan generating")) {
				System.out.println("Plan is generating with  " + Scenario + " ," + "Please wait!");
				continue;
			}

			else if (status.equalsIgnoreCase("Failed")) {
				System.out.println("Plan failed with : " + Scenario);
				System.out.println("Failed Plan name is: " + Pn);
				b = false;
				break;
			}

			else if (status.equalsIgnoreCase("DRAFT")) {
				System.out.println("Plan Generated Successfully with " + Scenario);
				System.out.println(
						"Total Time Taken for plan generation with " + Scenario + "=" + (i * 1.5) / 60 + "min");

				b = true;
				break;
			} else {
				b = false;
			}

		}

		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(savedVersion).click();
		Thread.sleep(1500);
		status = driver.findElement(planStatus).getText();
		if (status.equalsIgnoreCase("Plan generating"))

		{
			driver.findElement(abortBtn).click();
			System.out.println("Plan Aborted ");
			Thread.sleep(1500);
			driver.findElement(abortConfirmation).click();
			System.out.println("Confirmation clicked ");

			return false;
		}

		else if (status.equalsIgnoreCase("DRAFT")) {
			driver.navigate().refresh();
			Thread.sleep(4000);
			driver.findElement(savedVersion).click();
			Thread.sleep(1500);
			driver.findElement(navigateToGaneratedPlan).click();
			Thread.sleep(3000);
			String Url = driver.getCurrentUrl();
			String[] a = Url.split("&");

			System.out.println(a[1]);
			System.out.println("Generated Plan Name: " + Pn);
			String Batches = driver.findElement(batchesCount).getText();
			String Campaign = driver.findElement(CampaignCount).getText();
			System.out.println("Number of Campaign Scheduled :" + Campaign);
			System.out.println("Number of Batches Scheduled :" + Batches);
			b = true;
		}
		return b;
	}

//Triggering auto schedule 	
	public boolean TriggerAutoschedule() throws InterruptedException {
		boolean f = false;
		Thread.sleep(2000);
		driver.findElement(autoschedule).click();
		Thread.sleep(7000);
		driver.findElement(trigger).click();
		Thread.sleep(5000);

		for (int i = 1; i <= 300; i++) {
			driver.findElement(version).click();
			Thread.sleep(4000);
			String versionhistory = driver.findElement(versionhistoryEle).getText();
			// System.out.println(versionhistory);
			Thread.sleep(2000);
			if (versionhistory.equals("DRAFT")) {
				System.out.println("Autoschedule Plan Pass without any changes");

				f = true;
				break;

			} else if (versionhistory.equals("Failed")) {
				System.out.println("Autoschedule Plan failed without any changes");
				f = false;
				break;
			}
		}
		return f;
	}

	// Moving batch
	public boolean batchmove() throws InterruptedException, ParseException {
		boolean f = false;
		Thread.sleep(2000);
		driver.findElement(closeicon).click();
		Thread.sleep(2000);
		driver.findElement(productiontab).click();
		Thread.sleep(15000);
		driver.findElement(expandAllBtn).click();
		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.clickAndHold(driver.findElement(firstBatch)).pause(Duration.ofSeconds(3)).moveByOffset(130, 0).release()
				.build().perform();
		Thread.sleep(10000);
		driver.findElement(cmtBox).sendKeys("TestDragAndDrop");
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(15000);
		driver.findElement(expandAllBtn).click();
		Thread.sleep(3000);
		startDateAfterDrag = driver.findElement(startDateEle).getText().replaceAll("\\s.*", "");
		System.out.println("Start Date after Changes " + startDateAfterDrag);
		driver.findElement(saveas).click();
		Thread.sleep(2000);
		driver.findElement(savecmt).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(savechng).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(15000);
		ArrayList<String> st = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);
		driver.navigate().to("https://dev.bodhee.com/qa/qa2/algovalidation");
		Thread.sleep(4000);
		driver.findElement(searchPlanVersionDD).click();
		Thread.sleep(1500);
		driver.close();
		driver.switchTo().window(st.get(0));
		Thread.sleep(7000);
		driver.findElement(version).click();
		Thread.sleep(2000);
		driver.findElement(latestarrow).click();
		Thread.sleep(2000);
		driver.findElement(autoschedule).click();
		Thread.sleep(7000);
		driver.findElement(trigger).click();
		Thread.sleep(5000);

		for (int i = 1; i <= 300; i++) {
			driver.findElement(version).click();
			Thread.sleep(4000);
			String versionhistory = driver.findElement(versionhistoryEle).getText();
//			System.out.println(versionhistory);
			Thread.sleep(2000);
			if (versionhistory.equals("DRAFT")) {

				driver.findElement(latestarrow).click();
				Thread.sleep(3000);
				driver.findElement(productiontab).click();
				Thread.sleep(3000);
				driver.findElement(expandAllBtn).click();
				Thread.sleep(3000);
				startDateAfterautoschedule = driver.findElement(Updtstartdate).getText().replaceAll("\\s.*", "");
				System.out.println("startDateAfterautoschedule " + startDateAfterautoschedule);
				Thread.sleep(2000);
				System.out.println("startDateAfterDrag " + startDateAfterDrag + " & " + "startDateAfterautoschedule "
						+ startDateAfterautoschedule);

				SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

				Date date1 = dateFormat.parse(startDateAfterDrag);
				Date date2 = dateFormat.parse(startDateAfterautoschedule);

//				System.out.println(date1.toString());
//				System.out.println(date2.toString());

				System.out.println(
						"Duration gap between after drag and autoschedule drag is " + date2.compareTo(date1) + " days");

				if (date2.compareTo(date1) >= 0) {
					f = true;
				} else {
					f = false;
				}
				break;
			} else if (versionhistory.equals("Failed")) {
				System.out.println("Autoscheduled failed after move batch");
				f = false;
				break;
			}

		}
		return f;
	}

//Algo Validation for sc0 after Normal Autoschedule
	public boolean algoAuditorSc0_DB_Validation_ForAutoSchedule() throws InterruptedException, SQLException {
		String plID1;
		boolean f = false;

		String category1 = "SCENARIO 0";
		Thread.sleep(3000);
		ArrayList<String> st = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(1500);
		driver.navigate().to("https://dev.bodhee.com/qa/qa2/algovalidation");
		Thread.sleep(4000);
		driver.findElement(searchPlanVersionDD).click();
		Thread.sleep(1500);
		plID1 = driver.findElement(lattestPlanVersionID1).getText();
		int plan = Integer.parseInt(plID1);
		System.out.println("Generated plan Version ID: " + plID1);
		driver.findElement(lattestPlanVersionID1).click();
		Thread.sleep(1400);
		driver.findElement(submitBtn).click();
		Thread.sleep(4000);
		String ValMsg = driver.findElement(validationMsg).getText();
		System.out.println(ValMsg);
		Thread.sleep(1500);
		driver.close();
		driver.switchTo().window(st.get(0));
		Thread.sleep(3000);

		SeleniumDatabaseTesting sd = new SeleniumDatabaseTesting();
		boolean s = sd.genericDBValidation(category1, plan);
		f = s;
		return f;

	}

	// Algo Validation for sc0 after Moving Batch Autoschedule
	public boolean algoAuditorSc0_DB_Validation_ForMoveBatchAutoSchedule() throws InterruptedException, SQLException {
		String plID1;
		boolean f = false;
		System.out.println("algoAuditorSc0_DB_Validation_ForMoveBatchAutoSchedule started");
		String category1 = "SCENARIO 0";
		Thread.sleep(3000);
		ArrayList<String> st = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(1500);
		driver.navigate().to("https://dev.bodhee.com/qa/qa2/algovalidation");
		Thread.sleep(4000);
		driver.findElement(searchPlanVersionDD).click();
		Thread.sleep(1500);
		plID1 = driver.findElement(lattestPlanVersionID1).getText();
		int plan = Integer.parseInt(plID1);
		System.out.println("Generated plan Version ID: " + plID1);
		driver.findElement(lattestPlanVersionID1).click();
		Thread.sleep(1400);
		driver.findElement(submitBtn).click();
		Thread.sleep(4000);
		String ValMsg = driver.findElement(validationMsg).getText();
		System.out.println(ValMsg);
		Thread.sleep(1500);
		driver.close();
		driver.switchTo().window(st.get(0));
		Thread.sleep(3000);

		SeleniumDatabaseTesting sd = new SeleniumDatabaseTesting();
		boolean s = sd.genericDBValidation(category1, plan);
		f = s;
		return f;

	}

}
