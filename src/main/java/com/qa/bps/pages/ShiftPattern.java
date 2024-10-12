package com.qa.bps.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;

public class ShiftPattern {
	private static final By SAVE_CHNAGE_TOASTER_TEAMSHIFT = null;
	WebDriver driver;
	Navigation navigateTo;
	ProductOverview po;

	private By downLoadFileBtn = By.xpath("//div[@class='topRow']//img[2]");
	private By teamShiftPatternBtn = By.xpath("(//div[@class='sideNavBar']//a)[2]");
	private By toaster = By.xpath("//div[@id='toast-container']");
	private By shiftPtnDownloadImg = By.xpath("//img[@title='Download Shift Pattern Excel']");
	private By teamShiftPatternIcon = By.xpath("//a[@routerlink='team-shift-pattern']");
	private By selectTeam = By.xpath("//span[@class='ng-star-inserted']");
	private By closeSearchButton = By.xpath("//span[@class='c-remove clear-all ng-star-inserted']");
	private By datePicker = By.xpath("//input[@id='start']");
	private By saveButton = By.xpath("//button[text()='Save']");
	private By saveButton2 = By.xpath("(//button[text()='Save'])[2]");
	private By clearbtn = By.xpath("(//*[name()='svg' and @class='ng-star-inserted'])[2]");
	private By toggleBtn = By.xpath("//div/label[@class='switch']");
	private By firstTeamOption = By.xpath("(//li[@ng-reflect-ng-class='[object Object]'])[1]");
	private By SecondTeamOption = By.xpath("(//li[@ng-reflect-ng-class='[object Object]'])[2]");
	private By firstTeamOnscrn = By.xpath("(//th[@scope='row'])[1]");
	private By secondTeamOnscrn = By
			.xpath("(//th[contains(@style,'position: sticky; z-index: 0; left: 0; text-align: center;')])[last()]");
	private By selectChkBox = By.xpath("(//input[@type='checkbox'])[21]");
	private By saveChageToaster = By.xpath(" //div[@id='toast-container']");
	private By allDates = By.xpath("//tr[1]/th[@class='ng-star-inserted']");
	private By allDates2 = By.xpath("//tr[1]/th");
	private By hometextLink = By.xpath("//a[contains(text(), 'Home') ]");
	private By homeicon = By.xpath("//fa-icon[@ng-reflect-icon='fas,home']");
	private By masterDataTab = By.xpath("//a[@id='v-pills-master']");
	private By dataManagmentTab = By.xpath("//a[contains(@href,'dataManagement')]");
	private By fectoryCalanderTab = By.xpath("//div[@title='Factory Calendar']");
	private By activeCalander = By.xpath("//span[text()='Active']");
	private By addShiftButton = By.xpath("//p[text()='Add Shift']");
	private By shiftNameColumn = By.xpath("(//div[@tabulator-field='shift_name'])[last()]");
	private By shiftStartTime = By.xpath("(//div[@tabulator-field='start_time'])[last()]");
	private By shiftEndTime = By.xpath("(//div[@tabulator-field='end_time'])[last()]");
	private By shiftStartdate = By.xpath("(//div[@tabulator-field='effective_start_date'])[last()]");
	private By shiftEndtdate = By.xpath("(//div[@tabulator-field='effective_end_date'])[last()]");
	private By saveNewShiftButton = By.xpath("(//button[text()=' Save '])[2]");
	private By saveShiftToaster = By.xpath("//div[@id='toast-container']");
	private By shiftPatternTab = By.xpath("//a[contains(@href,'shift-pattern')]");
	private By buttonForShiftDelete = By.xpath("//div[contains(text(),'Delete Shift')]");
	private By shiftDeleteOption = By.xpath("(//div[@title='Shift Testing']/following-sibling::*)[1]");
	private By shiftToFind = By.xpath("(//th[contains(text(),'Shift Testing-23:00-06:00')])[1]");
	private By curuntmounth = By.xpath("//input[@id='start']");
	private By previousButton = By.xpath("//fa-icon[@ng-reflect-title='Previous Month']");
	private By nextButton = By.xpath("//fa-icon[@ng-reflect-title='Next Month']");
	private By operatorShiftIcon = By.xpath("//a[@routerlink='operator-shift-pattern']");
	private By operatorShiftPageTitle = By.xpath("//p[contains(text(),'Operator Shift Pattern')]");
	private By downloadButton = By.xpath("//img[@title='Download Shift Pattern Excel']");
	private By selectedCheckBox = By.xpath("//input[@ng-reflect-model='true']");
	private By CB = By.xpath("//input[@type='checkbox']");
	private By selectTeamOption = By.xpath("(//div[@class='c-btn'])[1]");
	private By selectOperatorOption = By.xpath("//span[text()='Select Operators']");
	private By searchOperator = By.xpath("//input[@placeholder='Search Operator']");
	private By operatorUnIcon = By.xpath("//img[@title='Operator Unavailability']");
	private By holidayButton = By.xpath("(//input[@type='checkbox'])[last()-1]");
	private By holidayOptionSheet = By.xpath("(//tr/th[text()=' Holiday'])[1]");
	private By workingHoursButton = By.xpath("(//input[@type='checkbox'])[last()]");
	private By workingHoursOptionSheet = By.xpath("(//tr/th[text()=' Working Hours'])[1]");
	private By selectfirstTeamOption = By.xpath("(//ul[@class='lazyContainer'])[1]/li[1]");
	private By selectfirstTeamName = By.xpath("(//ul[@class='lazyContainer'])[1]/li[1]/label");
	private By selectOperatorDropdown = By.xpath("//span[text()='Select Operators']");
	private By selectfirstOperatorOption = By.xpath("(//ul[@class='lazyContainer'])[2]/li[1]");
	private By selectfirstOperatorName = By.xpath("(//ul[@class='lazyContainer'])[2]/li[1]/label");
	private By firstTeamNameofSheet = By.xpath("(//tr)[4]/td[1]");
	private By firstuserNameofSheet = By.xpath("(//tr)[4]/th[1]");
	private By bodheelogo = By.xpath("//img[@alt='Bodhee Logo']");
	private By controlTowerTab = By.xpath("//div[.=' Control Tower ']");
	private By managerViewTab = By.xpath("(//img[@class='card-image'])[3]");
	private By productOverviewTab = By.xpath("(//img[@class='card-image'])[4]");
	private By productOverviewButton = By.xpath("//button[text()='Product Overview']");
	private By firstTaskOfPO = By.xpath("(//div[@class='dhx_diagram_flow_item '])[1]");
	private By firstOperatorOfPO = By.xpath(
			"(//div[contains(@class,'justify-content-between align-items-center operator-root p-1 m-1 allowBtn')])[1]");
	private By userDropDown = By.xpath("//p[@id='navbarDropdown']");
	private By bodheeStudioLabel = By.xpath("//a[contains(text(),'Bodhee Studio')]");
	private By shiftPattern = By.xpath("//a[contains(@href,'shift-pattern')]");
	private By searchBoxTeamshift = By.xpath("//span[text()='Select Teams']");
	private By searchBoxForOperatorshift = By.xpath("//input[@placeholder='Search Operator']");

	private By holidaysDay = By.xpath("(//select[@class='custom-select ng-pristine ng-valid ng-touched'])[1]");
	private By teamManagementTab = By.xpath("//a[contains(@href,'team-management')]");
	private By searchBoxTeamManagement = By.xpath("(//input[@placeholder='Search'])[2]");
	private By teamName = By.xpath("(//div[@tabulator-field='team_name'])[2]");
	private By operatorUnavailabilityIcon = By.xpath("//img[@title='Operator Unavailability']");
	private By selectTeamOfOp = By.xpath("(//input[@role='combobox'])[1]");
	private By NewShiftName = By.xpath("//div[@title='Shift Testing']");
	private By newShiftStartTime = By.xpath("//div[@title='23:00:00']");
	private By newShiftEndTime = By.xpath("(//div[@title='06:00:00'])[last()]");
	private By selectMonth = By.xpath("//input[@id='start']");
	private By selectNameOfOp = By.xpath("(//input[@role='combobox'])[2]");
	private By selectsuggestion = By.xpath("//div[@role='option']");
	private By startLeaveDate = By.xpath("(//input[@type='date'])[1]");
	private By endLeaveDate = By.xpath("(//input[@type='date'])[2]");
	private By selectShift = By.xpath("(//input[@role='combobox'])[3]");
	private By selectShiftType = By.xpath("//span[text()='Full day']");
	private By selectAbsenceType = By.xpath("(//input[@role='combobox'])[4]");
	private By selectAbsenceTypeOption = By.xpath("//span[text()='Leave - Planned']");
	private By saveButtonOfOp = By.xpath("//button[@class='m-1 btn custom-btn custom-btn-primary']");
	private By Planleave = By.xpath("//option[text()='Leave - Planned']");
	private By holidayStatusAftrLeave = By.xpath("//td/div[text()=' Leave - Planned ']");
	// private By holidayBox = By.xpath("//div[@class='cell-content
	// ng-star-inserted']");
	private By holidayBox = By.xpath("(//tr[@class='ng-star-inserted'])[2]/td");
	private By teamCheckBox = By.xpath("//label");
	private By holidayReson = By.xpath("//select[@ng-reflect-model='Leave - Planned']");
	private By nullvalueforleave = By.xpath("//select/option[1]");
	private By commentArea = By.xpath("//textarea[text()='Enter Comments']");
	private By menuIcon = By.cssSelector("div[class*='dropdown d']");
	private By firstOp = By.xpath("(//span[@class='allowBtn'])[1]");
	private By BodheeIcon = By.xpath("//p[.='Bodhee Studio']");
	private By teamMangMtIcon = By.xpath("(//h6[.='Team Management']/following-sibling::div)[2]/div");
	private By opSearchBox = By.xpath("(//input[@placeholder='Search'])[2]");
	private By team = By.xpath("(//div[@tabulator-field='team_name'])[2]");
	private By operatorTeamDropDown = By.xpath("(//div[@class='c-token ng-star-inserted']/span)[1]");
	private By selectAllTeamCheck = By.xpath("(//span[.='Select All'])[1]");
	private By deSelectAllTeamCheck = By.xpath("(//span[.='Select All'])[2]");
	private By operatorTeamSearchBox = By.xpath("(//input[@placeholder='Search'])[2]");
	private By operatorTeamCheckBox = By.xpath("//input[@aria-labelledby='option']/parent::li");
	private By selectOperatorDropDown = By.xpath("//span[@class='ng-star-inserted']");
	private By selectTeamSearchBox = By.xpath("(//input[@placeholder='Search'])[3]");
	private By markHolidayBtn = By.xpath("(//td[@title='Click to mark holiday.'])[3]");
	private By leavePlannedEle = By.xpath("(//select/option)[2]");
	private By successToaster = By.xpath("//div[@role='alertdialog']");
	private By dateBoxEle = By.xpath("//input[@id='start']");
	private By workingHrs = By.xpath(" ((//tr[@class='ng-star-inserted'])[3]/td)[3]/div/input");

	String OperatorNameOnLeave;
	String neShiftNameInFC;
	String newshiftSP;
	String saveToaster;
	String foundOp;
	String[] firstTaskDate;
	String monthToFindeOperatorShift;
	String yearToFindOperatorShift;
	String dateToFindFirstOperatorShift;
	String teamNames;

	boolean srchBox, datePker, saveBtn, togglebtn, chkBoxStatus, selTeam, selOperator, serchOp, dwnldBtn, OptUnBtn;

	public ShiftPattern(WebDriver driver) {

		this.driver = driver;
		navigateTo = new Navigation(driver);

	}

	public String shiftPtnDownloadToolTip() throws InterruptedException {
		Thread.sleep(2000);
		String tooltip = driver.findElement(shiftPtnDownloadImg).getAttribute("title");
		System.out.println(tooltip);
		return tooltip;

	}

	public String teamshiftPtniconToolTip() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(teamShiftPatternIcon).click();
		String tooltip = driver.findElement(shiftPtnDownloadImg).getAttribute("title");
		System.out.println(tooltip);
		return tooltip;
	}

	public boolean fieldsOfOperatorShiftPattern() throws InterruptedException {
		try {
			Thread.sleep(1000);
			srchBox = driver.findElement(searchBoxTeamshift).isDisplayed();
			Thread.sleep(1000);
			datePker = driver.findElement(datePicker).isDisplayed();
			Thread.sleep(1000);
			saveBtn = driver.findElement(saveButton).isDisplayed();
			Thread.sleep(1000);
			dwnldBtn = driver.findElement(downloadButton).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean toggleBtnOfovertimeShift() throws InterruptedException {
		Thread.sleep(3000);
		try {
			driver.findElement(toggleBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			System.out.println("inside catch block ");
			return false;
		}

	}

	public boolean searchFunctionOptShift1Team() throws InterruptedException {
		driver.findElement(selectTeam).click();
		driver.findElement(firstTeamOption).click();
		Thread.sleep(2000);
		String FirstteamName = driver.findElement(firstTeamOption).getText();
		Thread.sleep(2000);
		driver.findElement(firstTeamOnscrn).click();
		String FirstteamNameOnsheet = driver.findElement(firstTeamOnscrn).getText();
		Thread.sleep(2000);

		if (FirstteamName == FirstteamNameOnsheet) {
			return true;
		}

		else {
			return false;
		}
	}

	public boolean searchFunctionOptShift2Team() throws InterruptedException {

		driver.findElement(closeSearchButton).click();
		driver.findElement(selectTeam).click();
		driver.findElement(firstTeamOption).click();
		driver.findElement(SecondTeamOption).click();
		Thread.sleep(2000);
		String FirstteamName = driver.findElement(firstTeamOption).getText();
		String SecondteamName = driver.findElement(SecondTeamOption).getText();
		Thread.sleep(2000);
		driver.findElement(firstTeamOnscrn).click();
		String FirstteamNameOnsheet = driver.findElement(firstTeamOnscrn).getText();
		String SecondteamNameOnsheet = driver.findElement(secondTeamOnscrn).getText();

		Thread.sleep(2000);
		if (FirstteamName == FirstteamNameOnsheet && SecondteamName == SecondteamNameOnsheet) {
			return true;
		} else {
			return false;
		}
	}

	public boolean selectChkBox() throws InterruptedException {
		Thread.sleep(4000);
		boolean b = true;
		if (driver.findElement(selectChkBox).isSelected()) {
			System.out.println("Checkbox is already selected");
			driver.findElement(selectChkBox).click();
			Thread.sleep(4000);
			driver.findElement(saveButton).click();
			System.out.println("Checkbox deselected");
			Thread.sleep(4000);

			driver.findElement(selectChkBox).click();
			Thread.sleep(4000);
			driver.findElement(saveButton).click();
			System.out.println("Checkbox selected again and saved");
			Thread.sleep(4000);
			b = driver.findElement(selectChkBox).isSelected();
		}

		else {
			Thread.sleep(4000);
			System.out.println("Checkbox not selected so check and save directly");
			driver.findElement(selectChkBox).click();
			Thread.sleep(4000);
			driver.findElement(saveButton).click();
			System.out.println("Checkbox selected again and saved");
			Thread.sleep(4000);
			b = driver.findElement(selectChkBox).isSelected();

		}

		return b;

	}

	public boolean DeselectChkBox() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(selectChkBox).click();
		System.out.println("Checkbox is deselected");
		driver.findElement(saveButton).click();
		System.out.println("save button is clicked");
		Thread.sleep(4000);
		driver.findElement(selectChkBox).click();
		System.out.println("Checkbox is selected");
		Thread.sleep(4000);
		driver.findElement(saveButton).click();
		Thread.sleep(4000);
		System.out.println("Save button clicked");
		boolean b = driver.findElement(selectChkBox).isSelected();
		if (b == true) {
			return false;
		} else
			return true;
	}

	public boolean DuplicateDateInOperatorShift() {
		List<WebElement> alldates = driver.findElements(allDates);
		String arr[] = new String[alldates.size()];
		for (WebElement date : alldates) {

			String number = date.getText();
			System.out.println(number);
		}

		int[] ar = new int[] { 1, 2, 3, 4, 7, 8 };
		System.out.println("Duplicate elements in given array: ");
		// Searches for duplicate element
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] == arr[j])

					return false;

			}
		}
		return true;
	}

	public boolean newShiftConfig() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(hometextLink).click();
		Thread.sleep(2000);
		driver.findElement(dataManagmentTab).click();
		Thread.sleep(2000);
		driver.findElement(masterDataTab).click();
		Thread.sleep(2000);
		driver.findElement(fectoryCalanderTab).click();
		Thread.sleep(2000);
		driver.findElement(activeCalander).click();
		Thread.sleep(2000);
		driver.findElement(addShiftButton).click();
		Thread.sleep(2000);
		driver.findElement(shiftNameColumn).sendKeys("Shift Testing");
		Thread.sleep(2000);
		driver.findElement(shiftStartTime).sendKeys("1100PM");
		Thread.sleep(2000);
		driver.findElement(shiftEndTime).sendKeys("0600AM");
		Thread.sleep(2000);
		driver.findElement(shiftStartdate).sendKeys("01012023");
		Thread.sleep(2000);
		driver.findElement(shiftEndtdate).sendKeys("12302024");
		Thread.sleep(2000);
		driver.findElement(saveNewShiftButton).click();
		Thread.sleep(2000);

		String saveShiftToasterMassage = driver.findElement(saveShiftToaster).getText();
		Thread.sleep(3000);

		driver.findElement(activeCalander).click();
		Thread.sleep(2000);

		String x = driver.findElement(NewShiftName).getText();
		String y = driver.findElement(newShiftStartTime).getText();
		String z = driver.findElement(newShiftEndTime).getText();
		neShiftNameInFC = x + "-" + y + "-" + z;
		System.out.println(neShiftNameInFC);

		System.out.println("SHift added");
		System.out.println("message is" + saveShiftToasterMassage);
		if (saveShiftToasterMassage.equalsIgnoreCase(Constants.SAVE_Shift_TOASTER_FECTORYCAL)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyShiftConfig() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(homeicon).click();
		Thread.sleep(2000);
		driver.findElement(shiftPatternTab).click();
		Thread.sleep(5000);
		newshiftSP = driver.findElement(shiftToFind).getText();
		System.out.println(newshiftSP);
		try {
			if (neShiftNameInFC.equals(newshiftSP)) {
				System.out.println("new shift displayed");
			}

			return true;
		} catch (Exception e) {
			System.out.println("new shift not displayed");
			return false;
		}
	}

	public boolean ShiftDeleteFromFactoryCal() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(hometextLink).click();
		Thread.sleep(2000);
		driver.findElement(dataManagmentTab).click();
		Thread.sleep(2000);
		driver.findElement(masterDataTab).click();
		Thread.sleep(2000);
		driver.findElement(fectoryCalanderTab).click();
		Thread.sleep(2000);
		driver.findElement(activeCalander).click();
		Thread.sleep(2000);
		driver.findElement(shiftDeleteOption).click();
		Thread.sleep(2000);
		driver.findElement(buttonForShiftDelete).click();
		Thread.sleep(2000);

		driver.findElement(saveNewShiftButton).click();
		Thread.sleep(2000);
		String saveShiftToasterMassage = driver.findElement(saveShiftToaster).getText();
		Thread.sleep(1000);
		System.out.println("message is" + saveShiftToasterMassage);
		if (saveShiftToasterMassage.equalsIgnoreCase(Constants.SAVE_Shift_TOASTER_FECTORYCAL)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyShiftDeleted() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(homeicon).click();
		Thread.sleep(2000);
		driver.findElement(shiftPatternTab).click();
		Thread.sleep(2000);
		try {
			driver.findElement(shiftToFind).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyMovedToPrevioustMonth() throws InterruptedException {
		Thread.sleep(3000);
		String curruntMonth = driver.findElement(curuntmounth).getAttribute("ng-reflect-model");
		System.out.println("curunt month before moving back is " + curruntMonth);
		driver.findElement(previousButton).click();
		Thread.sleep(1000);
		String previousMonth = driver.findElement(curuntmounth).getAttribute("ng-reflect-model");
		System.out.println("previous month is " + previousMonth);
		if (curruntMonth != previousMonth) {
			return true;
		}

		return false;
	}

	public boolean verifyMovedToNextMonth() throws InterruptedException {

		String curruntMonth = driver.findElement(curuntmounth).getAttribute("ng-reflect-model");
		System.out.println("curunt month after moving back is " + curruntMonth);
		driver.findElement(nextButton).click();
		Thread.sleep(1000);
		String nextmonth = driver.findElement(curuntmounth).getAttribute("ng-reflect-model");
		System.out.println("Next month is " + nextmonth);

		if (curruntMonth != nextmonth) {
			return true;
		}

		return false;
	}

	public boolean verifyOperatorShiftPattern() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(operatorShiftIcon).click();
		Thread.sleep(2000);
		if (driver.findElement(operatorShiftPageTitle).isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean downloadShiftPattern() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(downloadButton).click();
		Thread.sleep(2000);
		String confirmationMassage = driver.findElement(saveShiftToaster).getText();
		File dir = new File("C:/Users/Admin/Downloads");
		File[] dirContents = dir.listFiles();

		if (dirContents != null) {
			for (File file : dirContents) {

				String filename = file.getName();
				System.out.println(filename);

				if (file.getName().matches("Team_shift_pattern_March_2024.xlsx")) {
					return true;
				} else
					return false;
			}
		}

		return false;
	}

	public boolean unchekCheckBox() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> cbs = driver.findElements(selectedCheckBox);
		for (int i = 1; i <= cbs.size(); i++) {
			driver.findElement(selectedCheckBox).click();
		}
		Thread.sleep(5000);
		driver.findElement(saveButton).click();
		Thread.sleep(2000);
		String saveShiftToasterMassage = driver.findElement(saveShiftToaster).getText();
		if (saveShiftToasterMassage.equals(Constants.SAVE_CHNAGE_TOASTER_TEAMSHIFT)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean configShifPattern() throws InterruptedException {
		Thread.sleep(4000);
		List<WebElement> cbs = driver.findElements(CB);
		for (int i = 17; i <= 300; i++) {

			if (i % 5 == 0) {
				driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).click();
			}
		}
		Thread.sleep(3000);
		driver.findElement(saveButton).click();
		Thread.sleep(3000);
		String saveShiftToasterMassage = driver.findElement(saveShiftToaster).getText();
		if (saveShiftToasterMassage.equalsIgnoreCase(Constants.SAVE_CHNAGE_TOASTER_TEAMSHIFT)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean fildsOfOperatorShift() throws InterruptedException {
		Thread.sleep(4000);
		try {
			selTeam = driver.findElement(selectTeamOption).isDisplayed();
			selOperator = driver.findElement(selectOperatorOption).isDisplayed();
			serchOp = driver.findElement(searchOperator).isDisplayed();
			saveBtn = driver.findElement(saveButton).isDisplayed();
			dwnldBtn = driver.findElement(downloadButton).isDisplayed();
			OptUnBtn = driver.findElement(operatorUnIcon).isDisplayed();
			datePker = driver.findElement(datePicker).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHolidayFun() throws InterruptedException {

		driver.findElement(holidayButton).click();
		Thread.sleep(2000);
		boolean chkBoxStatus = driver.findElement(holidayButton).isSelected();
		if (!chkBoxStatus) {
			driver.findElement(holidayButton).click();
		}
		try {
			driver.findElement(holidayOptionSheet).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyWorkingHoursFun() throws InterruptedException {

		driver.findElement(workingHoursButton).click();
		Thread.sleep(2000);
		boolean chkBoxStatus = driver.findElement(workingHoursButton).isSelected();
		if (!chkBoxStatus) {
			driver.findElement(workingHoursButton).click();
			Thread.sleep(2000);
		}
		try {
			driver.findElement(workingHoursOptionSheet).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyTeamOperatorDropdown() throws InterruptedException {
		driver.findElement(clearbtn).click();
		Thread.sleep(4000);
		driver.findElement(selectTeamOption).click();
		Thread.sleep(4000);
		driver.findElement(selectfirstTeamOption).click();
		Thread.sleep(2000);
		String firstTeamName = driver.findElement(selectfirstTeamName).getText();
		System.out.println("first team name in dropdown " + firstTeamName);
		driver.findElement(selectOperatorDropdown).click();
		Thread.sleep(4000);
		driver.findElement(selectfirstOperatorOption).click();
		Thread.sleep(2000);
		String firstOperatorName = driver.findElement(selectfirstOperatorName).getText();
		System.out.println("first operator name in dropdown " + firstOperatorName);
		Thread.sleep(2000);
		String firstTeamNameInSheet = driver.findElement(firstTeamNameofSheet).getText();
		System.out.println("first team name in sheet " + firstTeamNameInSheet);
		String firstOperatorNameInSheet = driver.findElement(firstuserNameofSheet).getText();
		System.out.println("first operator name in sheet " + firstOperatorNameInSheet);
		Thread.sleep(2000);
		if (firstTeamName.matches(firstTeamNameInSheet) && firstOperatorName.matches(firstOperatorNameInSheet)) {
			return true;
		} else {

			return false;
		}
	}

	public boolean verifyUserCanMarkTheOperatorUnavailableTest() throws InterruptedException, IOException {
		po = new ProductOverview(driver);
		navigateTo.addValueToEventProp();
		System.out.println("Navigated to product overview");
		Thread.sleep(4000);
		navigateTo.LattestPublishedPlan();
		String productName = navigateTo.GetProductDetailsFromPlanner();
		po.getProductDetails(productName);
		navigateTo.productOverview();
		po.preReq();
		System.out.println("Pre Req pass");
		Thread.sleep(4000);
		driver.findElement(po.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		foundOp = driver.findElement(firstOp).getText();

		System.out.println("Operator name is " + firstOp);

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
		teamNames = driver.findElement(team).getText();
		System.out.println("Team Name is " + teamNames);

		Actions action = new Actions(driver);

		System.out.println("First Task Date in planner " + navigateTo.firstTaskDate);

		firstTaskDate = navigateTo.firstTaskDate.split("-");

		monthToFindeOperatorShift = firstTaskDate[1];

		System.out.println("shift month " + monthToFindeOperatorShift);
		yearToFindOperatorShift = firstTaskDate[0];
		System.out.println("year to find shift " + yearToFindOperatorShift);
		dateToFindFirstOperatorShift = firstTaskDate[2];
		System.out.println("Date to find first operator " + dateToFindFirstOperatorShift);

		navigateTo.ShiftPattern();
		Thread.sleep(6000);
		driver.findElement(operatorShiftIcon).click();
		Thread.sleep(5000);

		driver.findElement(dateBoxEle).sendKeys(monthToFindeOperatorShift + yearToFindOperatorShift);

		Thread.sleep(7000);

		driver.findElement(operatorTeamDropDown).click();
		Thread.sleep(3000);
		System.out.println("Operator Team drop down clicked ");
		driver.findElement(selectAllTeamCheck).click();
		Thread.sleep(3000);
		System.out.println("Selected all team");
		driver.findElement(deSelectAllTeamCheck).click();
		Thread.sleep(1000);
		System.out.println("deselected all team");
		driver.findElement(operatorTeamSearchBox).sendKeys(teamNames);
		Thread.sleep(1000);

		driver.findElement(operatorTeamCheckBox).click();
		Thread.sleep(3000);

		driver.findElement(selectOperatorDropDown).click();
		Thread.sleep(6000);
		driver.findElement(selectTeamSearchBox).sendKeys(foundOp);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[.='" + foundOp + "']")).click();
		Thread.sleep(4000);

		action.doubleClick(driver.findElement(markHolidayBtn)).perform();

		driver.findElement(leavePlannedEle).click();
		Thread.sleep(2000);

		driver.findElement(saveButton2).click();

		Thread.sleep(1500);

		String tstrMsg;
		try {
			tstrMsg = driver.findElement(successToaster).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("Toaster message is*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase("shift updated successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyWorkingHrsAfterMarkingOperatorUnAvailableTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
		driver.findElement(dateBoxEle).sendKeys(monthToFindeOperatorShift + yearToFindOperatorShift);

		Thread.sleep(5000);

		driver.findElement(operatorTeamDropDown).click();
		Thread.sleep(1000);
		driver.findElement(selectAllTeamCheck).click();
		Thread.sleep(3000);
		driver.findElement(deSelectAllTeamCheck).click();
		Thread.sleep(2000);
		driver.findElement(operatorTeamSearchBox).sendKeys(teamNames);
		Thread.sleep(1000);
		driver.findElement(operatorTeamCheckBox).click();
		Thread.sleep(3000);

		driver.findElement(selectOperatorDropDown).click();
		Thread.sleep(7000);
		driver.findElement(selectTeamSearchBox).sendKeys(foundOp);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[.='" + foundOp + "']")).click();
		Thread.sleep(5000);

		String wrokingHours = "12";

		try {
			wrokingHours = driver.findElement(workingHrs).getAttribute("ng-reflect-model");
		} catch (Exception e) {

		}

		if (wrokingHours.equals("0")) {
			return true;
		} else {
			return false;
		}

	}

}