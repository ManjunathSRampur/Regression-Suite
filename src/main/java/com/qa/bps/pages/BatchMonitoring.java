package com.qa.bps.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qa.bps.utils.ElementUtil;

public class BatchMonitoring {

	WebDriver driver;
	int size;
	Navigation navigateTo;
//*****************************************Locators******************************************************************	
	public static By alertForLogDelay = By
			.xpath("//div[@class='d-flex justify-content-between align-items-center alert-root rounded mr-2']");

	private By productionTab = By.xpath("//div[contains(text(),'Production')]");
	private By validationTab = By.xpath("//div[contains(text(),'Validation')]");
	private By resetFilterBtn = By.xpath("//a[contains(text(),'Reset Filters')]");
	private By apudd = By.xpath("(//button[@data-toggle='dropdown'])[1]");
	private By aptDD = By.xpath("(//button[@data-toggle='dropdown'])[2]");
	private By BuildingDD = By.xpath("(//button[@data-toggle='dropdown'])[3]");
	private By productDD = By.xpath("(//button[@data-toggle='dropdown'])[4]");
	private By campaignDD = By.xpath("(//button[@data-toggle='dropdown'])[5]");
	private By SettingBtn = By.xpath("(//button[@data-toggle='dropdown'])[6]");
	private By campaignWiseOption = By.xpath("//a[contains(text(),'Campaign Wise ')]");
	private By apuddValue = By.xpath("//div[@class='dropdown-menu customHeight show']");
	private By getProductName = By.xpath("//div[@class='product-section-individual-container product-name']");
	private By getCampNameFromPO = By.xpath("(//span[@class='text pl-1'])[1]");
	private By batchMonitoringNav = By.xpath("//li[contains(text(),' Batch Overview ')]");
	private By CampaignNameinBM = By.xpath("//div[@class='product-section-individual-container product-name']");
	private By firstCampaign = By.xpath("//div[@class='batch-details-row']");
	private By assignOps = By.xpath("(//div[@class='d-flex flex-wrap'])[1]/div");
	private By assignedopinPO = By
			.xpath("(//div[@class='d-flex justify-content-start align-items-center pt-2 flex-wrap'])[1]/div");
	private By batchMonitorFrmbatchSummary = By.xpath("//li[contains(text(),' Batch Monitoring ')]");
	private By productOverViewBtn = By.xpath("//button[contains(text(),'Product Overview')]");
	private By taskGrpProdctOvrVw = By.xpath("(//div[@class='dhx_shape-container']/div)[1]");
	public static By firstTaskToglleBtn = By.xpath("(//button[@class='btn dropdown-toggle'])[2]");
	public static By markAsCompleteOp = By
			.xpath("//div[@class='dropdown-menu action-dropdown show']/a[.='Mark as Completed']");
	public static By markAsCompleteBtn = By.xpath("(//a[.='Mark As Completed'])[2]");
	private By restartOption = By.xpath("//div[@class='dropdown-menu action-dropdown show']/a[.='Restart']");
	public static By delayCloseDatePicker = By.xpath("//input[@id='showEndDatePicker']");
	public static By delayStartReasonDD = By.xpath("(//span[.=' Select Reason Code'])[1]");
	public static By delayReasonOp = By
			.xpath("(//span[contains(text(), '" + EventProperties.delayReasonCode + "')])[1]");
	public static By logDelayButton = By.xpath("//button[.='Log Delay']");
	private By assetDownOption = By.xpath("//div[@class='dropdown-menu action-dropdown show']/a[.='Asset Status']");
	private By taskStatusEle = By.xpath("(//td[@class='no-border'])[5]");
	private By taskStatusInPOVEle = By.xpath("(//span[@class='text']/a)[1]");
	private By toasterMsg = By.xpath("//div[@role='alertdialog']");
	private By startDD = By.xpath("(//button[@class='btn dropdown-toggle'])[2]");
	public static By resetButton = By.xpath("(//a[.='Reset'])[1]");
	private By startOp = By.xpath("(//div[@class='dropdown-menu show']/a)[1]");
	public static By startTask = By.xpath("//div[@class='dropdown-menu action-dropdown show']/a[.='Start']");
	public static By startButton = By.xpath("//button[.='Start Task']");
	public static By startTaskBtn = By.xpath("//button/a[contains(text(),'Start Task')]");
	private By ProductNameDrop = By.xpath("//select[@id='select']");
	private By batchDD = By.xpath("(//select)[2]");
	private By selectFirstBatch = By.xpath("((//select)[2]/option)[1]");
	private By closeTaskInfoWindo = By.xpath("//div[@class='close-button']");
	private By taskGroupActionBtn = By.xpath("((//div[@class='btn-group'])/button)[1]");
	private By avlBtnsUnderTaskGroupTogleBtn = By.xpath("//div[@class='dropdown-menu action-dropdown show']/a");
	private By chooseStatusDD = By.xpath("(//div[@class='btn-group root'])[1]");
	private By notStartedFilter = By.xpath("//a[.=' Not Started ']");
	private By inProgressFilter = By.xpath("//a[.=' In-progress ']");
	private By allFilter = By.xpath("(//a[.=' All '])[1]");
	private By taskGroupStatus = By.xpath("//a[.='Not Started' or .='In-progress' or .='CLOSED']");
	private By deletAssetDown = By.xpath("((//a[.='Asset Down']/following-sibling::div)[1]/*)[2]");
	private By selectEqButon = By.xpath("(//div[.=' Select Assets '])[1]");
	private By selectEqOpt = By.xpath("(//div/a[.=' " + EventProperties.equipmentName + " '])[1]"); // need to change
																									// the equipment
																									// name
	private By selectReasonButton = By.xpath("(//div[.=' Select Type '])[1]");
	private By selectReasonOp = By.xpath("(//div[@class='row font-16 pl-1']/app-dropdown/div/div/a)[1]");
	private By selectTime = By.xpath("(//input[@name='selectedDate'])[1]");
	private By logAssetButton = By.xpath("(//button[.='Log Asset Down'])[1]");
	private By eqCloseBtn = By.xpath("//div[@class='close-button']");
	private By eqAlertMessage = By.xpath("(//a[.='Asset Down']/parent::div)[1]");
	private String expectedEqAlertMessage = "Asset Down - " + EventProperties.equipmentName + " : "
			+ EventProperties.assetDownReason + "";
	private By eqAlertMsgInPov = By.xpath("(//div[.='Asset Down  - " + EventProperties.eqNameInPOV + " "
			+ EventProperties.assetDownReason + " '])[4]"); // need
	private String eqpAlertMsgInPov = "Asset Down - " + EventProperties.eqNameInPOV + " "
			+ EventProperties.assetDownReason;

	private By availableProductInBatchMonitoring = By
			.xpath("//div[contains(@class,'product-section-individual-container product-nam')]");
	private By firstBatchInBatchMonitoring = By.xpath("(//div[@class='batch-details-row'])[1]");

//************************************************************************************************************	
	String ProductnameInBM;
	String apn;
	String CampaignName;
	String campNameinBMSTR;
	String taskStatusInBM;
	String taskStatusInPOV;
	String productNameInPlanner;

//**************************************************************************************************************************	
	private ElementUtil eleUtil;

	public BatchMonitoring(WebDriver driver, int size) {
		eleUtil = new ElementUtil(driver);
		this.driver = driver;
		this.size = size;
	}

//************************************Methods*****************************************************************************

	public void preReqTest(String pN) throws InterruptedException {
		delayReasonOp = By.xpath("(//span[contains(text(), '" + EventProperties.delayReasonCode + "')])[1]");

		System.out.println("Equipment x path is " + selectEqOpt);
		navigateTo = new Navigation(driver);
		System.out.println(pN + "Displayed");
		productNameInPlanner = pN;
		Select product = new Select(driver.findElement(ProductNameDrop));
		String Finaltext = "";
		for (WebElement option : product.getOptions()) {
			if (pN.trim().contains(option.getText().trim())) {
				System.out.println("inside if condition ");
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
		Thread.sleep(2000);
		try {
			driver.findElement(startDD).click();
			Thread.sleep(2000);
			driver.findElement(resetButton).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(8000);
		} catch (Exception e) {
			driver.findElement(startDD).click();
			Thread.sleep(2000);
			System.out.println("reset button is disabled ");
		}

		try {
			System.out.println("inside secound try");
			driver.findElement(startDD).click();
			Thread.sleep(2000);
			driver.findElement(startOp).click();
			Thread.sleep(1000);
			driver.findElement(startButton).click();
			Thread.sleep(13000);
		} catch (Exception e) {
			System.out.println("unable to  start the task ");
		}
	}

	public boolean verifyAPUDD() throws InterruptedException {
		selectEqOpt = By.xpath("(//div/a[.=' " + EventProperties.equipmentName + " '])[1]");
		driver.findElement(apudd).isDisplayed();
		driver.findElement(apudd).click();
		Thread.sleep(1000);
		try {
			driver.findElement(apuddValue).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyAPTDD() throws InterruptedException {
		driver.findElement(apuddValue).click();
		driver.findElement(aptDD).click();
		Thread.sleep(1000);
		try {
			driver.findElement(apuddValue).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyBuildingDD() throws InterruptedException {
		driver.findElement(apuddValue).click();
		driver.findElement(BuildingDD).click();
		Thread.sleep(1000);
		try {
			driver.findElement(apuddValue).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean VerifyProductDD() throws InterruptedException {
		driver.findElement(apuddValue).click();
		driver.findElement(BuildingDD).click();
		Thread.sleep(1000);
		try {
			driver.findElement(productDD).click();
			driver.findElement(apuddValue).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyProductName(String pN) {
		ProductnameInBM = driver.findElement(getProductName).getText();
		apn = " " + ProductnameInBM + " ";
		System.out.println("Product name from planner is " + pN);
		System.out.println("Product name is Batch monitoring is " + apn);

		if (pN.contains(apn)) {
			return true;
		} else
			return false;
	}

	public boolean verifyCampaignWiseFilter() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		CampaignName = driver.findElement(getCampNameFromPO).getText();
		driver.findElement(batchMonitoringNav).click();
		Thread.sleep(2000);
		driver.findElement(SettingBtn).click();
		Thread.sleep(1000);
		driver.findElement(campaignWiseOption).click();
		Thread.sleep(2000);
		campNameinBMSTR = driver.findElement(CampaignNameinBM).getText();
		if (campNameinBMSTR.equals(CampaignName)) {
			return true;
		} else
			return false;

	}

	public boolean OpStatusTaskWIP() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(5000);

		Thread.sleep(2000);

		System.out.println("Product Name in planner " + productNameInPlanner);

		List<WebElement> lists = driver.findElements(availableProductInBatchMonitoring);
		for (WebElement ls : lists) {
			if (productNameInPlanner.trim().contains(ls.getText().trim())) {
				productNameInPlanner = ls.getText();
				break;
			}
		}
		System.out.println("Product Name is " + productNameInPlanner);
		firstBatchInBatchMonitoring = By.xpath("(//div[.='" + productNameInPlanner + "'])[1]");

		System.out.println("xpath : " + firstBatchInBatchMonitoring);

//		driver.findElement(firstBatchInBatchMonitoring).click();
		firstCampaign = firstBatchInBatchMonitoring;
		driver.findElement(firstCampaign).click();

		Thread.sleep(2000);
		List<WebElement> a = driver.findElements(assignOps);
		ArrayList<String> opN = new ArrayList<String>();
		ArrayList<String> opNinPOv = new ArrayList<String>();

		for (WebElement e : a) {
			e.getText();
			opN.add(e.getText());
		}
		System.out.println(opN);

		taskStatusInBM = driver.findElement(taskStatusEle).getText();
		System.out.println("Task Status in inprogress state is in BM :" + taskStatusInBM);
		driver.findElement(batchMonitorFrmbatchSummary).click();
		Thread.sleep(2000);
		driver.findElement(productOverViewBtn).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);

		List<WebElement> b = driver.findElements(assignedopinPO);
		for (WebElement f : b) {
			opNinPOv.add(f.getText());

		}
		System.out.println(opNinPOv);
		taskStatusInPOV = driver.findElement(taskStatusInPOVEle).getText();
		System.out.println("Task status in product overview is " + taskStatusInPOV);

		if (opN.equals(opNinPOv)) {
			System.out.println("Assigned Operators in batch Summary and product overview is same");
			return true;
		} else
			return false;

	}

	// 2
	public boolean VerifyuserCanCloseTheTaskTest() throws InterruptedException {
		driver.findElement(batchMonitoringNav).click();
		Thread.sleep(2000);
		driver.findElement(firstCampaign).click();
		Thread.sleep(2000);
		driver.findElement(firstTaskToglleBtn).click();
		driver.findElement(markAsCompleteOp).click();
		Thread.sleep(1000);
		driver.findElement(markAsCompleteBtn).click();
		Thread.sleep(500);
		String toasterMsgInBM = driver.findElement(toasterMsg).getText().replace(" ", "");
		Thread.sleep(10000);
		if (toasterMsgInBM.equals("Taskstatusupdatedsuccessfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean operatorAvlPostCloseTest() throws InterruptedException {
		taskStatusInBM = driver.findElement(taskStatusEle).getText();
		System.out.println("Task Status in close state is in BM :" + taskStatusInBM);

		List<WebElement> a = driver.findElements(assignOps);
		ArrayList<String> opN = new ArrayList<String>();
		ArrayList<String> opNinPOv = new ArrayList<String>();

		for (WebElement e : a) {
			e.getText();
			opN.add(e.getText());

		}
		System.out.println(opN);
		driver.findElement(batchMonitorFrmbatchSummary).click();
		Thread.sleep(1000);
		driver.findElement(productOverViewBtn).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);

		List<WebElement> b = driver.findElements(assignedopinPO);
		for (WebElement f : b) {
			opNinPOv.add(f.getText());

		}
		System.out.println(opNinPOv);
		taskStatusInPOV = driver.findElement(taskStatusInPOVEle).getText();
		System.out.println("Task status in product overview is " + taskStatusInPOV);

		if (opN.equals(opNinPOv)) {
			System.out.println("Assigned Operators in batch Summary and product overview is same");
			return true;
		} else
			return false;
	}

	public boolean verifyUserCanRestartTask() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(batchMonitoringNav).click();
		Thread.sleep(2000);
		driver.findElement(firstCampaign).click();
		Thread.sleep(2000);
		driver.findElement(firstTaskToglleBtn).click();
		driver.findElement(restartOption).click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		String toasterMsgInBM = "null";
		try {
			toasterMsgInBM = driver.findElement(toasterMsg).getText().replace(" ", "");
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		if (toasterMsgInBM.equals("Taskstatusupdatedsuccessfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyOpAvlPostRestartTest() throws InterruptedException {
		taskStatusInBM = driver.findElement(taskStatusEle).getText();
		System.out.println("Task Status in close state is in BM :" + taskStatusInBM);

		List<WebElement> a = driver.findElements(assignOps);
		ArrayList<String> opN = new ArrayList<String>();
		ArrayList<String> opNinPOv = new ArrayList<String>();

		for (WebElement e : a) {
			e.getText();
			opN.add(e.getText());

		}
		System.out.println(opN);
		driver.findElement(batchMonitorFrmbatchSummary).click();
		Thread.sleep(2000);
		driver.findElement(productOverViewBtn).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);

		List<WebElement> b = driver.findElements(assignedopinPO);
		for (WebElement f : b) {
			opNinPOv.add(f.getText());

		}
		System.out.println(opNinPOv);
		taskStatusInPOV = driver.findElement(taskStatusInPOVEle).getText();
		System.out.println("Task status in product overview is " + taskStatusInPOV);

		if (opN.equals(opNinPOv)) {
			System.out.println("Assigned Operators in batch Summary and product overview is same");
			return true;
		} else
			return false;
	}

	public boolean verifyUserCanCloseTaskWithDelayTest() throws InterruptedException {
		driver.findElement(batchMonitoringNav).click();
		Thread.sleep(2000);
		driver.findElement(firstCampaign).click();
		Thread.sleep(2000);
		driver.findElement(firstTaskToglleBtn).click();
		driver.findElement(markAsCompleteOp).click();
		Thread.sleep(1000);
		driver.findElement(delayCloseDatePicker).sendKeys(EventProperties.delayCloseTime);

		Thread.sleep(1000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);

		driver.findElement(markAsCompleteBtn).click();
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(logDelayButton).click();
		Thread.sleep(500);
		String toasterMsgInBM;
		try {
			toasterMsgInBM = driver.findElement(toasterMsg).getText().replace(" ", "");
		} catch (Exception e) {
			return false;
		}
		Thread.sleep(10000);
		if (toasterMsgInBM.equals("Taskstatusupdatedsuccessfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTaskStatusInBMAndPOVInWIPStateTest() {
		if (taskStatusInBM.equals(taskStatusInPOV)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyOperatorStatusAfterDelayCloseTest() throws InterruptedException {

		try {
			driver.findElement(closeTaskInfoWindo).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Task info window is not displayed ");
		}

		taskStatusInBM = driver.findElement(taskStatusEle).getText();
		System.out.println("Task Status in close state is in BM :" + taskStatusInBM);

		List<WebElement> a = driver.findElements(assignOps);
		ArrayList<String> opN = new ArrayList<String>();
		ArrayList<String> opNinPOv = new ArrayList<String>();

		for (WebElement e : a) {
			e.getText();
			opN.add(e.getText());

		}
		System.out.println(opN);
		driver.findElement(batchMonitorFrmbatchSummary).click();
		Thread.sleep(2000);
		driver.findElement(productOverViewBtn).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);

		List<WebElement> b = driver.findElements(assignedopinPO);
		for (WebElement f : b) {
			opNinPOv.add(f.getText());

		}
		System.out.println(opNinPOv);

		taskStatusInPOV = driver.findElement(taskStatusInPOVEle).getText();
		System.out.println("Task status in product overview is " + taskStatusInPOV);

		if (opN.equals(opNinPOv)) {
			System.out.println("Assigned Operators in batch Summary and product overview is same");
			return true;
		} else
			return false;

	}

	public boolean verifyTaskStatusInBMAndPOVinCloseStateTest() {
		if (taskStatusInBM.equals(taskStatusInPOV)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTaskStatusInBMAndPOVinPostRestartStateTest() {
		if (taskStatusInBM.equals(taskStatusInPOV)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTaskStatusInBMAndPOVinPostDelayFinishStateTest() {
		if (taskStatusInBM.equals(taskStatusInPOV)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean taskGroupActionBtnTest() throws InterruptedException {
		driver.findElement(batchMonitoringNav).click();
		Thread.sleep(2000);
		driver.findElement(firstCampaign).click();
		Thread.sleep(2000);
		driver.findElement(taskGroupActionBtn).click();
		boolean b = false;
		Thread.sleep(1000);
		List<WebElement> taskGroupActionBtn = driver.findElements(avlBtnsUnderTaskGroupTogleBtn);
		for (WebElement actionBtn : taskGroupActionBtn) {
			String actionBtnValue = actionBtn.getText();
			System.out.println(actionBtnValue);
			if (actionBtnValue.equals("Start") || actionBtnValue.equals("Mark as Completed")
					|| actionBtnValue.equals("Reopen") || actionBtnValue.equals("Reset")) {
				System.out.println("Task group toggle Button containse Start/Mark as Completed/Reopen/Reset");
				b = false;
			} else {
				b = true;
			}
		}
		return b;

	}

	public boolean verifyFuncOfChooseFilterInNotStartedStateTest() throws InterruptedException {
		boolean b = false;
		driver.findElement(chooseStatusDD).click();
		Thread.sleep(1000);
		driver.findElement(notStartedFilter).click();
		Thread.sleep(1000);
		List<WebElement> tGStatus = new ArrayList<WebElement>();
		tGStatus = driver.findElements(taskGroupStatus);
		for (WebElement tgS : tGStatus) {
			String status = tgS.getText();
			if (status.equals("In-progress") || status.equals("CLOSED")) {
				System.out.println("choose status filter is not working for not started option ");
				b = false;
			} else {
				b = true;
			}
		}
		return b;

	}

	public boolean verifyFuncOfChooseFilterInWIPdStateTest() throws InterruptedException {
		boolean b = false;
		driver.findElement(chooseStatusDD).click();
		Thread.sleep(1000);
		driver.findElement(inProgressFilter).click();
		Thread.sleep(1000);
		List<WebElement> tGStatus = new ArrayList<WebElement>();
		tGStatus = driver.findElements(taskGroupStatus);
		for (WebElement tgS : tGStatus) {
			String status = tgS.getText();
			if (status.equals("Not Started") || status.equals("CLOSED")) {
				System.out.println("choose status filter is not working for in-progress option ");
				b = false;
			} else {
				b = true;
			}
		}
		return b;

	}

	public boolean verifyFuncOfChooseFilterInAlldStateTest() throws InterruptedException {
		boolean b = false;
		driver.findElement(chooseStatusDD).click();
		Thread.sleep(1000);
		driver.findElement(allFilter).click();
		Thread.sleep(1000);
		List<WebElement> tGStatus = new ArrayList<WebElement>();
		tGStatus = driver.findElements(taskGroupStatus);
		for (WebElement tgS : tGStatus) {
			String status = tgS.getText();
			if (status.equals("Not Started") || status.equals("CLOSED") || status.equals("In-progress")) {

				b = true;
			} else {
				System.out.println("choose status filter is not working for All option ");
				b = false;
			}
		}
		return b;
	}

	public boolean verifyUserCanCloseTheTasEarlyTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(firstCampaign).click();
		Thread.sleep(2000);
		try {
			driver.findElement(firstTaskToglleBtn).click();
			Thread.sleep(1000);
			driver.findElement(restartOption).click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Thread.sleep(10000);

		} catch (Exception e) {

		}

		driver.findElement(firstTaskToglleBtn).click();
		Thread.sleep(1000);
		driver.findElement(markAsCompleteOp).click();
		Thread.sleep(1000);
		driver.findElement(delayCloseDatePicker).sendKeys(EventProperties.earlyClose);

		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		driver.findElement(markAsCompleteBtn).click();
		driver.findElement(delayStartReasonDD).click();
		System.out.println("delay reason selected ");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='dropdown-btn'])[1]")).click();
		driver.findElement(delayReasonOp).click();
		Thread.sleep(1000);
		driver.findElement(logDelayButton).click();
		Thread.sleep(500);
		String toasterMsgInBM;
		try {
			toasterMsgInBM = driver.findElement(toasterMsg).getText().replace(" ", "");
		} catch (Exception e) {
			return false;
		}
		Thread.sleep(10000);
		if (toasterMsgInBM.equals("Taskstatusupdatedsuccessfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyOperatorStatusAfterEarlyClose() throws InterruptedException {

		try {
			driver.findElement(closeTaskInfoWindo).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Task info window is not displayed ");
		}

		taskStatusInBM = driver.findElement(taskStatusEle).getText();
		System.out.println("Task Status in close state is in BM :" + taskStatusInBM);

		List<WebElement> a = driver.findElements(assignOps);
		ArrayList<String> opN = new ArrayList<String>();
		ArrayList<String> opNinPOv = new ArrayList<String>();

		for (WebElement e : a) {
			e.getText();
			opN.add(e.getText());

		}
		System.out.println(opN);
		driver.findElement(batchMonitorFrmbatchSummary).click();
		Thread.sleep(2000);
		driver.findElement(productOverViewBtn).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(1000);

		List<WebElement> b = driver.findElements(assignedopinPO);
		for (WebElement f : b) {
			opNinPOv.add(f.getText());

		}
		System.out.println(opNinPOv);

		taskStatusInPOV = driver.findElement(taskStatusInPOVEle).getText();
		System.out.println("Task status in product overview is " + taskStatusInPOV);

		if (opN.equals(opNinPOv)) {
			System.out.println("Assigned Operators in batch Summary and product overview is same");
			return true;
		} else
			return false;

	}

	public boolean verifyTaskStatusInBMAndPOVinPostEarlyFinishStateTest() {
		if (taskStatusInBM.equals(taskStatusInPOV)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanDoAssetDownTest() throws InterruptedException {
		navigateTo.batchMonitoring();
		Thread.sleep(2000);
		driver.findElement(firstCampaign).click();
		Thread.sleep(2000);

		try {
			driver.findElement(deletAssetDown).click();
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("There is no equipment down");
		}
		Thread.sleep(8000);
		driver.findElement(firstTaskToglleBtn).click();
		driver.findElement(assetDownOption).click();
		Thread.sleep(1000);
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
		driver.findElement(selectTime).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();

		System.out.println("data selected ");
		driver.findElement(logAssetButton).click();
		System.out.println("asset added ");
		Thread.sleep(500);
		String tostMsg = "null";
		try {
			driver.findElement(toasterMsg).isDisplayed();
			tostMsg = driver.findElement(toasterMsg).getText();
			System.out.println("Toaster is capture " + tostMsg);
			System.out.println("asset down added ");
		} catch (Exception e) {
			System.out.println("asset alert is not displayed ");
			driver.findElement(eqCloseBtn).click();
			return false;
		}
		if (tostMsg.equals("Asset status updated!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAddedAssetAlertInBMTest() {
		String eqAlertMsgInBM = "null";
		try {
			eqAlertMsgInBM = driver.findElement(eqAlertMessage).getText();
		} catch (Exception e) {
			System.out.println("equipment down alert is not visible ");
			return false;
		}
		System.out.println("Equipment alert message is " + eqAlertMsgInBM);
		if (eqAlertMsgInBM.equals(expectedEqAlertMessage)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAddedAssetInPOVTest() throws InterruptedException {
		driver.findElement(batchMonitorFrmbatchSummary).click();
		Thread.sleep(2000);
		driver.findElement(productOverViewBtn).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		String actualAlert;
		try {
			actualAlert = driver.findElement(eqAlertMsgInPov).getText();
			driver.findElement(eqAlertMsgInPov).isDisplayed();

		} catch (Exception e) {
			System.out.println("alert message is not displayed in product overview ");
			return false;
		}
		System.out.println(actualAlert);
		if (actualAlert.equalsIgnoreCase(eqpAlertMsgInPov)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteAddedAssetDownTest() throws InterruptedException {
		driver.findElement(batchMonitoringNav).click();
		Thread.sleep(2000);
		driver.findElement(firstCampaign).click();
		Thread.sleep(2000);
		try {
			driver.findElement(deletAssetDown).click();
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

//*************************************************************************************************************************	
}
