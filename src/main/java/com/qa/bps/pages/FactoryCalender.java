package com.qa.bps.pages;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.bps.utils.Constants;

public class FactoryCalender {

	WebDriver driver;
	Navigation navigateTo;

	public By newCalendar = By.xpath("//h6[contains(text(),'New Calendar')]");
	private By factoryCalNameInput = By.xpath("//input[@id='calenderName1']");
	private By factoryCalDescInput = By.xpath("//input[@id='calenderDesc1']");
	private By factoryCalstartYear = By.xpath("//input[@id='startYear']");
	private By factoryCalendYear = By.xpath("//input[@id='endYear']");
	private By activeStatusDD = By.xpath("//input[@role='combobox']");
	private By calendarStsfalse = By.xpath("(//div[@role='option'])[2]");
	private By calendarStsTrue = By.xpath("(//div[@role='option'])[1]");
	private By checkBox = By.xpath("//input[@id='listCheck']");
	private By allDaysCheckBox = By.xpath("//input[@id='All']");
	private By saveBtn = By.xpath("(//button[contains(text(),'Save')])[2]");
	private By successToaster = By.xpath("//div[@role='alertdialog']");
	private By allPlantCheckBox = By.xpath("(//input[@type='checkbox'])[9]");
	private By addShiftBtn = By.xpath("//button[@class='button-primary']");
	private By blankDShiftname = By.xpath("(//div[@role='gridcell'])[last()-6]");
	private By popUpCloseBtn = By.xpath("(//fa-icon)[5]");
	private By addShiftNameInput = By.xpath("(//input[@type='text'])[last()-1]");
	public By shiftStartTime = By.xpath("(//div[@role='gridcell'])[last()-3]");
	public By shiftEndTime = By.xpath("(//div[@role='gridcell'])[last()-2]");
	private By effectiveStDate = By.xpath("(//div[@role='gridcell'])[last()-1]");
	private By effectiveEndDate = By.xpath("(//div[@role='gridcell'])[last()]");
	private By inputTime = By.xpath("//input[@type='time']");
	private By inputDate = By.xpath("//input[@type='date']");
	private By deleteShiftOption = By.xpath("(//div[@role='gridcell'])[last()-5]");
	private By deleteShiftBtn = By.xpath("//div[contains(text(),'Delete Shift')]");
	private By inactiveCalendar = By.xpath("(//span[contains(text(),'Inactive')])[1]");
	private By deleteFCbtn = By.xpath("(//button[contains(text(),'Delete')])[1]");
	private By deleteFCbtn2 = By.xpath("(//button[contains(text(),'Delete')])[2]");
	private By deletePopupCloseBtn = By.xpath("(//button[@id='closeBtn'])[3]");
	private By deleteConfirmInput = By.xpath("//input[@id='dpToDelete']");
	private By selectUsageFact = By.xpath("(//div[@class='form-check'])[last()]");

	String fcName;
	String ReName;
	public String ToasterMessage;

	public FactoryCalender(WebDriver driver) {
		this.driver = driver;
	}

	public boolean UsercanNavigateToFactoryCalendar() throws InterruptedException {
		navigateTo = new Navigation(driver);
		navigateTo.FactoryCalendar();
		try {
			driver.findElement(newCalendar).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	public boolean userCanCreateAnewfactoryCalendar() throws InterruptedException {
		fcName = RandomStringUtils.randomAlphabetic(4);
		fcName = "FactoryCalendar" + fcName;
		driver.findElement(newCalendar).click();
		Thread.sleep(2000);
		driver.findElement(factoryCalNameInput).sendKeys(fcName);
		System.out.println("factory calendar name " + fcName);
		Thread.sleep(1000);
		driver.findElement(factoryCalDescInput)
				.sendKeys("calendar created By Automation test USer for testing purpose");
		Thread.sleep(1000);
		driver.findElement(factoryCalstartYear).sendKeys("2001");
		Thread.sleep(1000);
		driver.findElement(factoryCalendYear).sendKeys("2002");
		Thread.sleep(1000);
		driver.findElement(activeStatusDD).click();
		Thread.sleep(2000);
		driver.findElement(calendarStsfalse).click();
		Thread.sleep(2000);
		driver.findElement(allDaysCheckBox).click();
		Thread.sleep(2000);

		try {
			driver.findElement(selectUsageFact).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		ToasterMessage = driver.findElement(successToaster).getText();
		try {
			driver.findElement(By.xpath("//div[contains(text(),'" + fcName + " 2001-2002')]")).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean toasterPostfactoryCalendarCreated() {
		if (ToasterMessage.equals("Factory Calendar created Successfully!")) {
			return true;
		} else
			return false;
	}

	public boolean userCancreateAduplicateFactoryCalendar() throws InterruptedException {

		driver.findElement(newCalendar).click();
		Thread.sleep(2000);
		driver.findElement(factoryCalNameInput).sendKeys(fcName);
		Thread.sleep(1000);
		driver.findElement(factoryCalDescInput)
				.sendKeys("calendar created by Automation test uSer for testing purpose");
		Thread.sleep(1000);
		driver.findElement(factoryCalstartYear).sendKeys("2001");
		Thread.sleep(1000);
		driver.findElement(factoryCalendYear).sendKeys("2002");
		Thread.sleep(1000);
		driver.findElement(activeStatusDD).click();
		Thread.sleep(2000);
		driver.findElement(calendarStsfalse).click();
		Thread.sleep(2000);
		driver.findElement(allDaysCheckBox).click();
		Thread.sleep(2000);

		try {
			driver.findElement(selectUsageFact).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		ToasterMessage = driver.findElement(successToaster).getText();

		Thread.sleep(2000);
		List<WebElement> duplicateFc = driver
				.findElements(By.xpath("//div[contains(text(),'" + fcName + " 2001-2002')]"));
		int a = duplicateFc.size();
		if (a == 1) {
			return true;

		}

		else
			return false;
	}

	public boolean duplicateFactoryCalendarToaster() {
		if (ToasterMessage.equals("Calendar Name Already Exist!")) {
			return true;
		} else
			return false;
	}

	public boolean UserCanEditFactoryCalendar() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[contains(text(),'" + fcName + " 2001-2002')]")).click();
		Thread.sleep(2000);
		// String fcReName = RandomStringUtils.randomAlphabetic(4);
		ReName = fcName + "Auto";
		driver.findElement(factoryCalNameInput).clear();
		Thread.sleep(2000);
		driver.findElement(factoryCalNameInput).sendKeys(ReName);
		Thread.sleep(2000);
		try {
			driver.findElement(allPlantCheckBox).isSelected();

		} catch (Exception e) {
			driver.findElement(allPlantCheckBox).click();
		}
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		ToasterMessage = driver.findElement(successToaster).getText();
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		String Attribute = driver.findElement(factoryCalNameInput).getAttribute("ng-reflect-model");
		System.out.println(Attribute);
		System.out.println(ReName);
		System.out.println(ToasterMessage);

		if (Attribute.equals(ReName)) {
			return true;

		} else
			return false;

	}

	public boolean editFactoryCalendarToaster() {
		if (ToasterMessage.equals("Changes saved successfully!")) {
			return true;
		} else
			return false;
	}

	public boolean addNewShiftWithoutFillingShiftDetailsToaster() throws InterruptedException {
		boolean b = true;
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(2000);
		driver.findElement(addShiftBtn).click();
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		try {
			String x = driver.findElement(successToaster).getText();
			String errorToaster = "Please fill all the required field carefully!";
			if (x.equals(errorToaster)) {
				b = true;
			}

		} catch (Exception e) {
			b = false;

		}
		return b;

	}

	public boolean UserCanAddAnewShift() throws InterruptedException {
		String ShiftName = RandomStringUtils.randomAlphabetic(4);
		String shiftName2 = "Shift " + ShiftName;
		Thread.sleep(1500);
		driver.findElement(blankDShiftname).click();
		Thread.sleep(1500);
		driver.findElement(addShiftNameInput).sendKeys(shiftName2);
		Thread.sleep(1500);
		driver.findElement(shiftStartTime).click();
		Thread.sleep(1500);
		driver.findElement(inputTime).sendKeys("0800A");
		Thread.sleep(1000);
		driver.findElement(shiftEndTime).click();
		Thread.sleep(1500);
		driver.findElement(inputTime).sendKeys("0600P");
		Thread.sleep(1000);
		driver.findElement(effectiveStDate).click();
		Thread.sleep(1000);
		driver.findElement(inputDate).sendKeys("01012001");
		Thread.sleep(1500);
		driver.findElement(effectiveEndDate).click();
		Thread.sleep(1000);
		driver.findElement(inputDate).sendKeys("01012002");
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(7000);
		String createdShiftname = driver.findElement(blankDShiftname).getAttribute("title");
		System.out.println(shiftName2);
		System.out.println(createdShiftname);
		if (shiftName2.equals(createdShiftname)) {
			return true;
		} else
			return false;
	}

	public boolean userCanCreateAshiftWithoutFillingShiftname() throws InterruptedException {
		boolean b = true;
		Thread.sleep(2000);
		driver.findElement(addShiftBtn).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(2000);
		driver.findElement(addShiftBtn).click();
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		String x = driver.findElement(blankDShiftname).getText();
		System.out.println(x);
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(4000);
		String y = driver.findElement(blankDShiftname).getText();
		System.out.println(y);
		if (y.equals(null)) {
			b = false;
		} else {
			b = true;
		}
		return b;

	}

	public boolean userCanEditTheShiftDetils() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		System.out.println("Popup closed");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(2000);
		driver.findElement(shiftStartTime).click();
		Thread.sleep(1500);
		driver.findElement(inputTime).sendKeys("1000A");
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		System.out.println("updsate Saved");
		Thread.sleep(2000);
		ToasterMessage = driver.findElement(successToaster).getText();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		System.out.println("Calendar clicked to validate");
		Thread.sleep(4000);
		String updatedStartTime = driver.findElement(shiftStartTime).getAttribute("title");
		String ExpectedStartTime = "10:00:00";

		if (updatedStartTime.equals(ExpectedStartTime)) {
			return true;
		} else
			return false;
	}

	public boolean editShiftToaster() {
		if (ToasterMessage.equals("Changes saved successfully!")) {
			return true;
		} else
			return false;

	}

	public boolean UserCanDeleteTheShift() throws InterruptedException {
		boolean b = true;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(2000);
		driver.findElement(deleteShiftOption).click();
		Thread.sleep(1500);
		driver.findElement(deleteShiftBtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		ToasterMessage = driver.findElement(successToaster).getText();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(3000);
		try {

			String updatedStartTime = driver.findElement(shiftStartTime).getAttribute("title");
			String ExpectedStartTime = "10:00:00";
			if (updatedStartTime.equals(ExpectedStartTime)) {
				b = false;
			}

		} catch (Exception e) {
			b = true;
		}
		return b;

	}

	public boolean deleteShiftToaster() {
		if (ToasterMessage.equals("Changes saved successfully!")) {
			return true;
		} else
			return false;

	}

	// **************************************
	public boolean deleteConfirmationMessageDisplayed() throws InterruptedException {
		boolean b = true;
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(2000);
		driver.findElement(activeStatusDD).click();
		Thread.sleep(2000);
		driver.findElement(calendarStsTrue).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(3500);
		ToasterMessage = driver.findElement(successToaster).getText();
		String FcStatus = driver.findElement(By
				.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]/parent::div/following-sibling::footer/span"))
				.getText();
		System.out.println(FcStatus);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(2000);
		driver.findElement(deleteFCbtn).click();
		Thread.sleep(2000);
		try {
			driver.findElement(deleteConfirmInput).isDisplayed();
			Thread.sleep(2000);
			driver.findElement(deletePopupCloseBtn).click();
			Thread.sleep(1500);
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean deleteFactoryCalendarByProvidingWrongdeleteConfirmMessage() throws InterruptedException {

		boolean b = true;
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(2000);
		driver.findElement(activeStatusDD).click();
		Thread.sleep(2000);
		driver.findElement(calendarStsTrue).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(3500);
		ToasterMessage = driver.findElement(successToaster).getText();
		String FcStatus = driver.findElement(By
				.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]/parent::div/following-sibling::footer/span"))
				.getText();
		System.out.println(FcStatus);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(2000);
		driver.findElement(deleteFCbtn).click();
		Thread.sleep(2000);
		driver.findElement(deleteConfirmInput).sendKeys("ReName");
		Thread.sleep(1500);
		driver.findElement(deleteFCbtn2).click();
		Thread.sleep(1500);
		ToasterMessage = driver.findElement(successToaster).getText();
		Thread.sleep(2000);
		if (FcStatus.equalsIgnoreCase("Active")) {
			b = true;

		} else {
			b = false;
		}
		return b;

	}

	public boolean toasterMessageOfDeleteFCByWrongFCName() {
		if (ToasterMessage.equals("Incorrect Factory Calendar name!")) {
			return true;
		} else
			return false;
	}

	public boolean userCanDeletefactoryFaceldar() throws InterruptedException {
		driver.navigate().refresh();
		boolean b = true;
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(2000);
		driver.findElement(activeStatusDD).click();
		Thread.sleep(2000);
		driver.findElement(calendarStsTrue).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(3500);
		ToasterMessage = driver.findElement(successToaster).getText();
		String FcStatus = driver.findElement(By
				.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]/parent::div/following-sibling::footer/span"))
				.getText();
		System.out.println(FcStatus);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ReName + " 2001-2002')]")).click();
		Thread.sleep(5000);
		driver.findElement(deleteFCbtn).click();
		Thread.sleep(4000);
		System.out.println("Updated value of factory calendar " + ReName);
		driver.findElement(deleteConfirmInput).click();
		driver.findElement(deleteConfirmInput).sendKeys(ReName);
		Thread.sleep(1500);
		driver.findElement(deleteFCbtn2).click();
		Thread.sleep(1500);
		ToasterMessage = driver.findElement(successToaster).getText();
		Thread.sleep(2000);
		if (FcStatus.equalsIgnoreCase("Inactive")) {
			b = true;

		} else {
			b = false;
		}
		return b;

	}

	public boolean deleteFCtoaster() {

		if (ToasterMessage.equals("Deleted successfully!")) {
			return true;
		} else
			return false;
	}

}
