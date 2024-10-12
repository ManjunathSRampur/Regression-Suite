package com.qa.bps.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qa.bps.utils.ElementUtil;

public class OperatorView {

	WebDriver driver;
//***************************************************************Locators AREA Starts ***********************************************************

	private By ProductNameDrop = By.xpath("//select[@id='select']");
	private By batchDD = By.xpath("(//select)[2]");
	private By selectFirstBatch = By.xpath("((//select)[2]/option)[1]");
	private By taskGrpProdctOvrVw = By.xpath("(//div[@class='dhx_shape-container']/div)[1]");
	private By GetfirstopName = By.xpath("(//span[@class='allowBtn'])[1]");
	private By GetSecondopName = By.xpath("(//span[@class='allowBtn'])[2]");

	private By IamSearchBx = By.xpath("//input[@placeholder='Search..']");
	private By tmSearchBx = By.xpath("(//input[@placeholder='Search'])[2]");
	private By userThreeDot = By.xpath("(//div[@role='gridcell'])[7]");
	private By ResetPassword = By.xpath("(//div[@class='tabulator-menu-item'])[3]");
	private By newPassword = By.xpath("(//input[@type='password'])[4]");
	private By confirmPassword = By.xpath("(//input[@type='password'])[5]");
	private By saveBtn = By.xpath("(//button[contains(text(),'Save')])[3]");
	private By getEmai = By.xpath("(//div[@tabulator-field='email'])[2]");
	private By userDDBodhee = By.xpath("//div[@id='navbarDropdown']");
	private By userDDIMP = By.xpath("//p[@id='navbarDropdown']");
	private By logoutOption = By.xpath("//a[contains(text(),'Logout')]");
	private By usernamePlacHolder = By.xpath("//input[@placeholder='Email']");
	private By PaswordPlacHldr = By.xpath("//input[@id='txtPassword']");
	private By signInBtn = By.xpath("//button[@type='submit']");
	private By datePicker = By.xpath("(//input[@id='selectedDate'])[1]");
	private By controlTower = By.xpath("//div[contains(text(),'Control Tower')]");
	private By operator = By.xpath("//div[.=' Operator ']");

	private By sideTaskBtn = By.xpath("//button[contains(text(),'Side Task')]");
	private By operatorNameInOpView = By.xpath("//div[@class='bold']/span//div[1]//button/div[1]");
	private By operatorTeamInOpView = By.xpath("(//span[@class='bold'])[1]");
	private By getSLNamefrmOpView = By.xpath("(//span[@class='bold'])[2]");
	private By opShiftTimeEle = By.xpath("(//span[@class='bold'])[3]");
	private By selectTeamDD = By.xpath("//span[.='Select Teams']");
	private By teamSearchBox = By.xpath("(//input[@placeholder='Search'])[last()]");
	private By selectTeam = By.xpath("//li[@class='pure-checkbox ng-star-inserted']");
	private By dateBox = By.xpath("(//input[@id='selectedDate'])[1]");
	private By OpTeaminTM = By.xpath("(//div[@tabulator-field='team_name'])[2]");
	private By operatorViewDate = By.xpath("(//div[@class='label-medium date mt-2'])[1]");

	private By sl = By.xpath("(//div[@title='Shift Leader']/preceding-sibling::div)[9]");

	private By taskStatus = By.xpath("(//div/span/a)[2]");
	public By startDD = By.xpath("(//button[@class='btn dropdown-toggle'])[2]");
	private By resetButton = By.xpath("(//a[.='Reset'])[1]");
	private By taskStartDate = By.xpath("(//span[@class='text'])[1]");
	private By taskEndDateF = By.xpath("(//span[@class='text'])[2]");
	private By taskName = By.xpath("(//div[@class='process-card-heading ml-0 pl-0'])[1]");
	private By taskNameOP = By.xpath("//span[@class='buttons']//following-sibling::p/span[1]");
	private By firstTask = By.xpath("(//span[@class='buttons']//following-sibling::p/span[1])[1]");
	private By taskTollTip = By.xpath("//div[@role='tooltip']");
	private By notFirstSection = By.xpath("//p[.='*This is not the first section of this task.']");
	private By closeBtn = By.xpath("//div[@class='close-button pointer']");
	private By searchOP = By.xpath("//div[@class='dropdown-menu customHeight show']//input");
	private By selectOP = By.xpath("//div[@class='dropdown-menu customHeight show']//a");
	private By startTask = By.xpath("//div[.=' Start Task ']");
	private By startBtn = By.xpath("//button[.='Start Task']");
	private By succToaster = By.xpath("//div[@id='toast-container']");
	private By statusInProgress = By.xpath("(//span[@class='Grid'])[1]//span[2]/b/a[1]");
	private By markAsCompleteBtn = By.xpath("//div[.=' Mark as Completed ']");
	private By markAsCompleteBtn2 = By.xpath("//button[.=' Mark As Completed']");
	private By completedStatus = By.xpath("(//span[@class='Grid'])[1]//span[2]/a[1]");
	// private By firsttask = By.xpath(event_Id);

	String OpNameInOpView; // Operator name from operator view stored globally
	String OpTeamInOpView; // Operator team from operator view stored globally
	String SLNameinOpVw; // Shiftlead name in Op view
	String OPTeaminTM;
	String randomText = RandomStringUtils.randomAlphabetic(5);
	String NewPassword = "";
	String OpEmail;
	String ProductName;
	String OpName;
	String OpName2;
	String opShiftTime;
	String month;
	String date;
	Integer datee;
	String taskStDate;
	String taskEnDate;
	String TaskName;
	private By opShiftTimeInShiftPatter = By.xpath("//tr[.='" + opShiftTime + "']/td");
//***************************************************************Locators AREA Ends***********************************************************

	private ElementUtil eleUtil;

	public OperatorView(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
//******************************************************Methods Area Starts**************************************************************************

	public boolean preReqPage(String PN) throws InterruptedException {

		try {
			Select product = new Select(driver.findElement(ProductNameDrop));
			String Finaltext = "";
			for (WebElement option : product.getOptions()) {
				if (PN.trim().contains(option.getText().trim())) {
					Finaltext = option.getText();
					product.selectByVisibleText(Finaltext);
					break;
				}
			}

			System.out.println("product Selected");
			driver.findElement(batchDD).click();

			selectFirstBatch = By.xpath("//option[.='" + EventProperties.firstBatchNumber + " ']");
			System.out.println("Xpath to select first batch " + selectFirstBatch);

			driver.findElement(selectFirstBatch).click();
			System.out.println("Batch is selected");
			Thread.sleep(2000);
			driver.findElement(taskGrpProdctOvrVw).click();
			Thread.sleep(2000);

			String status = driver.findElement(taskStatus).getText();
			Thread.sleep(2000);
			if (status.equalsIgnoreCase("In-progress")) {
				Thread.sleep(2000);
				driver.findElement(startDD).click();
				Thread.sleep(2000);
				driver.findElement(resetButton).click();
				Thread.sleep(2000);
				System.out.println("resetButton is clicked ");
				driver.switchTo().alert().accept();
				System.out.println("alert is clicked ");
				Thread.sleep(13000);
				OpName = driver.findElement(GetfirstopName).getText();
				Thread.sleep(2000);
				System.out.println(OpName);
				OpName2 = driver.findElement(GetSecondopName).getText();
				Thread.sleep(2000);
				System.out.println(OpName2);
				taskStDate = driver.findElement(taskStartDate).getText().replace(" ", "");
				Thread.sleep(2000);
				System.out.println("task started : " + taskStDate);
				taskEnDate = driver.findElement(taskEndDateF).getText().replace(" ", "");
				Thread.sleep(2000);
				System.out.println("task end Date : " + taskEnDate);
				TaskName = driver.findElement(taskName).getText();
				System.out.println(TaskName);

			}

			else if (status.equalsIgnoreCase("CLOSED")) {
				Thread.sleep(2000);
				driver.findElement(startDD).click();
				Thread.sleep(2000);
				driver.findElement(resetButton).click();
				Thread.sleep(2000);

				System.out.println("resetButton is clicked ");
				driver.switchTo().alert().accept();
				System.out.println("alert is clicked ");
				Thread.sleep(13000);

				OpName = driver.findElement(GetfirstopName).getText();
				Thread.sleep(2000);
				System.out.println(OpName);
				OpName2 = driver.findElement(GetSecondopName).getText();
				Thread.sleep(2000);
				System.out.println(OpName2);
				taskStDate = driver.findElement(taskStartDate).getText().replace(" ", "");
				Thread.sleep(2000);
				System.out.println("task started : " + taskStDate);
				taskEnDate = driver.findElement(taskEndDateF).getText().replace(" ", "");
				Thread.sleep(2000);
				System.out.println("task end Date : " + taskEnDate);
				TaskName = driver.findElement(taskName).getText();
				System.out.println(TaskName);

			} else {
				Thread.sleep(2000);
				OpName = driver.findElement(GetfirstopName).getText();
				Thread.sleep(2000);
				System.out.println(OpName);
				Thread.sleep(2000);
				OpName2 = driver.findElement(GetSecondopName).getText();
				Thread.sleep(2000);
				System.out.println(OpName2);
				taskStDate = driver.findElement(taskStartDate).getText().replace(" ", "");
				System.out.println("task started : " + taskStDate);
				Thread.sleep(2000);
				taskEnDate = driver.findElement(taskEndDateF).getText().replace(" ", "");
				System.out.println("task end Date : " + taskEnDate);
				TaskName = driver.findElement(taskName).getText();
				System.out.println(TaskName);

			}

			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean preReq2ResetPassword() throws InterruptedException {
		try {
			NewPassword = randomText + "@1Ay";
			System.out.println("New random Password is " + NewPassword);
			driver.findElement(IamSearchBx).sendKeys(OpName);
			Thread.sleep(2000);
			driver.findElement(userThreeDot).click();
			Thread.sleep(1000);
			driver.findElement(ResetPassword).click();
			Thread.sleep(2000);
			driver.findElement(newPassword).sendKeys(NewPassword);
			Thread.sleep(2000);
			driver.findElement(confirmPassword).sendKeys(NewPassword);
			Thread.sleep(2000);
			driver.findElement(saveBtn).click();
			System.out.println("Password Saved Successfully");
			Thread.sleep(6000);
			driver.findElement(IamSearchBx).clear();
			Thread.sleep(2000);
			driver.findElement(IamSearchBx).sendKeys(OpName);
			Thread.sleep(2000);
			OpEmail = driver.findElement(getEmai).getText();
			Thread.sleep(1000);
			System.out.println("OpEmail is " + OpEmail);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	public boolean loginAsOp() throws InterruptedException {
		driver.findElement(userDDBodhee).click();
		Thread.sleep(1000);
		driver.findElement(logoutOption).click();
		Thread.sleep(5000);
		driver.findElement(usernamePlacHolder).sendKeys(OpEmail);
		driver.findElement(PaswordPlacHldr).sendKeys(NewPassword);
		driver.findElement(signInBtn).click();
		Thread.sleep(8000);
		try {
			Thread.sleep(2000);
			driver.findElement(datePicker).isDisplayed();
			return true;
		}

		catch (Exception e) {
			Thread.sleep(2000);
			driver.findElement(controlTower).click();
			Thread.sleep(6000);
			driver.findElement(operator).click();
			Thread.sleep(5000);
			driver.findElement(datePicker).isDisplayed();
			return true;

		}

	}

	public boolean verifyAvalblField() throws InterruptedException {

		driver.findElement(dateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);

		String x = driver.findElement(operatorNameInOpView).getText();
		System.out.println("OP name in OPView " + x);

		boolean b = driver.findElement(sideTaskBtn).isDisplayed();

		if (x.equals(OpName) && b == true) {
			return true;
		} else {
			return false;
		}
	}

	public void getTeamandOpDetails() throws InterruptedException {
		SLNameinOpVw = driver.findElement(getSLNamefrmOpView).getText();
		System.out.println("Shiftlead name in Op view is " + SLNameinOpVw);
		OpNameInOpView = driver.findElement(operatorNameInOpView).getText();
		System.out.println(OpNameInOpView);
		OpTeamInOpView = driver.findElement(operatorTeamInOpView).getText();
		opShiftTime = driver.findElement(opShiftTimeEle).getText().replaceAll(" Hours", "");
		System.out.println("Shift Timing is " + opShiftTime);
		System.out.println("data availablity date " + driver.findElement(operatorViewDate).getText());
		String arr[] = driver.findElement(operatorViewDate).getText().split("-");
		month = arr[1];
		System.out.println("MOnth is " + month);
		date = arr[2];
		datee = Integer.parseInt(date);
		System.out.println("date is " + date);
		System.out.println("operator Team in Operator view:- " + OpTeamInOpView);
		driver.findElement(userDDIMP).click();
		Thread.sleep(1000);
		driver.findElement(logoutOption).click();

	}

	public boolean VerifyOpTeaminTM() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(tmSearchBx).sendKeys(OpNameInOpView);
		Thread.sleep(2000);
		OPTeaminTM = driver.findElement(OpTeaminTM).getText();
		System.out.println("Operator Team in Team Management :- " + OPTeaminTM);
		if (OpTeamInOpView.equals(OPTeaminTM)) {
			System.out.println("OPerator team in OP view and Team Management  is same");
			return true;
		}

		else
			return false;
	}

	public boolean VerifyOpShiftleadInTM() throws InterruptedException {
		driver.findElement(tmSearchBx).clear();
		Thread.sleep(2000);
		driver.findElement(tmSearchBx).sendKeys(OpTeamInOpView);
		OPTeaminTM = driver.findElement(sl).getText();
		System.out.println("ShiftLead name is " + OPTeaminTM);
		if (OPTeaminTM.equals(SLNameinOpVw)) {
			System.out.println("SL name in Team Management and Operator view is same");
			return true;
		} else
			return false;

	}

	public boolean verifyShiftAllocation() throws InterruptedException {
		Thread.sleep(4000);
		boolean b = false;
		opShiftTimeInShiftPatter = By.xpath("//tr[.='" + opShiftTime + "']/td");
		driver.findElement(dateBox).sendKeys(month);
		Thread.sleep(4000);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(2000);
		driver.findElement(teamSearchBox).sendKeys(OpTeamInOpView);
		Thread.sleep(1000);
		driver.findElement(selectTeam).click();
		Thread.sleep(1000);
		driver.findElement(dateBox).click();
		List<WebElement> dateCheckBox = driver.findElements(opShiftTimeInShiftPatter);
		Thread.sleep(5000);
		System.out.println("shift pattern shift is " + driver.findElement(opShiftTimeInShiftPatter).getText());
		for (int i = 0; i <= dateCheckBox.size(); i++) {
			if (i == datee) {
				b = dateCheckBox.get(i).isEnabled();
			}
		}
		System.out.println("is selected " + b);
		if (b == true) {
			return true;
		} else {
			return false;
		}
	}

//******************************************************Methods Area Ends**************************************************************************
	public boolean datepickerValidation() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(datePicker).sendKeys(EventProperties.task_Date);
		Thread.sleep(3000);
		return true;
	}

	public boolean taskValidation() throws InterruptedException {

//	   Thread.sleep(2000);
//	   driver.findElement(datePicker).sendKeys(EventProperties.task_Date);
		Thread.sleep(3000);
		String OPTaskName = driver.findElement(taskNameOP).getText();
		System.out.println("ProductOverViewTask " + TaskName);
		System.out.println("OperatorViewTask " + OPTaskName);
		Thread.sleep(2000);
		if (OPTaskName.equalsIgnoreCase(TaskName)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean dateAndTimeValidationWithProductOverview() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//span[@class='buttons']//following-sibling::p/span[1])[1]")))
				.build().perform();
		Thread.sleep(3000);
		String task = driver.findElement(By.xpath("//div[@role='tooltip']//div")).getText();
		System.out.println(task);
		Thread.sleep(1000);

		String arr1[] = task.split("Start:");
		String arr2[] = arr1[1].split("End:");

		String OPStart_date = arr2[0].replaceAll("\n", "");
		OPStart_date = OPStart_date.replace(" ", "");
		System.out.println("start date " + OPStart_date);
		System.out.println("start date " + taskStDate);
		String OPEndDate = arr2[1].replace(" ", "");
		System.out.println("end date " + OPEndDate);
		System.out.println("end date " + taskEnDate);

		if (OPStart_date.equalsIgnoreCase(taskStDate) || OPEndDate.equalsIgnoreCase(taskEnDate)) {
			return true;

		} else {
			return false;
		}

	}

	public String startTaskValidation() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(4000);

		driver.findElement(datePicker).sendKeys(EventProperties.task_Date);
		Thread.sleep(2000);
		driver.findElement(firstTask).click();
		Thread.sleep(3000);
		try {

			driver.findElement(startTask).isDisplayed();
			Thread.sleep(2000);
			driver.findElement(startTask).click();
			Thread.sleep(2000);
			driver.findElement(startBtn).click();
			Thread.sleep(1000);
			String succToast = driver.findElement(succToaster).getText();
			String s = succToast.replaceAll("\n", "");
			String t = s.replace("×", "");
			System.out.println("start task toaster " + t);
			return t;
		}

		catch (Exception e) {
//			driver.findElement(notFirstSection).isDisplayed();
			Thread.sleep(2000);
			driver.findElement(closeBtn).click();
			Thread.sleep(2000);
			driver.findElement(operatorNameInOpView).click();
			Thread.sleep(2000);
			driver.findElement(searchOP).sendKeys(OpName2);
			Thread.sleep(2000);
			driver.findElement(selectOP).click();
			Thread.sleep(2000);
			driver.findElement(firstTask).click();
			Thread.sleep(2000);
			driver.findElement(startTask).click();
			Thread.sleep(2000);
			driver.findElement(startBtn).click();
			Thread.sleep(2000);
			String succToast = driver.findElement(succToaster).getText();
			String s = succToast.replaceAll("\n", "");
			String t = s.replace("×", "");

			System.out.println("start task toaster " + t);
			return t;
		}

	}

	public boolean statusCheckAfterStartTask() throws InterruptedException {
		Thread.sleep(4000);
		String Status = driver.findElement(statusInProgress).getText();
		Thread.sleep(2000);
		if (Status.equalsIgnoreCase("In Progress")) {
			return true;
		} else {
			return false;
		}

	}

	public String markAsComplete() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(firstTask).click();
		try {
			Thread.sleep(1000);
			driver.findElement(markAsCompleteBtn).isDisplayed();
			Thread.sleep(1000);
			driver.findElement(markAsCompleteBtn).click();
			Thread.sleep(1000);
			driver.findElement(markAsCompleteBtn2).click();
			Thread.sleep(1000);
			String succToast = driver.findElement(succToaster).getText();
			String s = succToast.replaceAll("\n", "");
			String t = s.replace("×", "");
			System.out.println("start task toaster " + t);
			return t;

		} catch (Exception e) {

			Thread.sleep(2000);
			driver.findElement(closeBtn).click();
			Thread.sleep(2000);
			driver.findElement(operatorNameInOpView).click();
			Thread.sleep(2000);
			driver.findElement(searchOP).clear();
			Thread.sleep(1000);
			driver.findElement(searchOP).sendKeys(OpName);
			Thread.sleep(1000);
			driver.findElement(selectOP).click();
			Thread.sleep(2000);
			driver.findElement(firstTask).click();
			Thread.sleep(2000);
			driver.findElement(markAsCompleteBtn).click();
			Thread.sleep(1000);
			driver.findElement(markAsCompleteBtn2).click();
			Thread.sleep(1000);
			String succToast = driver.findElement(succToaster).getText();
			String s = succToast.replaceAll("\n", "");
			String t = s.replace("×", "");
			System.out.println("start task toaster " + t);
			return t;

		}

	}

	public boolean statusCheckAfterCompleteTask() throws InterruptedException {
		Thread.sleep(4000);
		String Status = driver.findElement(completedStatus).getText();
		Thread.sleep(2000);
		if (Status.equalsIgnoreCase("Task-Completed")) {
			return true;
		} else {
			return false;
		}

	}

}
