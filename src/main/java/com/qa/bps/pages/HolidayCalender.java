package com.qa.bps.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.bps.utils.Constants;

public class HolidayCalender {
	WebDriver driver;
	Navigation navigateTo;
	private By excitCalender = By.xpath("(//div[@class='card tileCard'])[2]");
	private By saveBtn = By.xpath("(//button[contains(text(),'Save')])[2]");
	private By addNewCalendarBtn = By.xpath("(//div[@class='card tileCard'])[1]");
	private By calendarNameInput = By.xpath("//input[@id='calenderName']");
	private By calendarDesc = By.xpath("//input[@id='calenderDesc']");
	private By successToaster = By.xpath("//div[@role='alertdialog']");
	private By popUpCloseBtn = By.xpath("(//fa-icon)[5]");
	private By addHolidayBtn = By.xpath("//p[contains(text(),'Add Holiday')]");
	private By startDateInput = By.xpath("//input[@type='date']");
	public By holidayname = By.xpath("(//div[@role='gridcell'])[last()]");
	private By holiDayInput = By.xpath("//input[@type='text']");
	private By deleteBtn = By.xpath("(//button[contains(text(),'Delete')])[1]");
	private By selectUsageFact = By.xpath("(//div[@class='form-check'])[last()]");

	public HolidayCalender(WebDriver driver) {
		this.driver = driver;
	}

	String toasterMsg;
	String CalendarName;

	public boolean navigateTOHolidayCalendar() throws InterruptedException {
		navigateTo = new Navigation(driver);
		navigateTo.holidayCalendar();
		if (driver.findElement(addNewCalendarBtn).isDisplayed()) {
			return true;
		} else
			return false;

	}

	public boolean UserCanCreateANewHolidayCalendarWithoutFillingTheMandetoryFields() throws InterruptedException {
		CalendarName = RandomStringUtils.randomAlphabetic(4);
		CalendarName = "TestCal" + CalendarName;

		driver.findElement(addNewCalendarBtn).click();
		Thread.sleep(2000);
		driver.findElement(calendarNameInput).sendKeys(CalendarName);
		Thread.sleep(1000);
		driver.findElement(calendarDesc).sendKeys("CalendarCreated for testing purpose");

		Thread.sleep(2000);
		try {
			driver.findElement(selectUsageFact).click();
		} catch (Exception e) {

		}

		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		toasterMsg = driver.findElement(successToaster).getText();
		System.out.println(toasterMsg);
		driver.navigate().refresh();
		Thread.sleep(4000);
		boolean b = true;
		try {
			WebElement a = driver.findElement(By.xpath("//div[contains(text(),'" + CalendarName + "')]"));
			a.isDisplayed();
			b = false;

		} catch (Exception e) {
			b = true;
		}
		return b;

	}

	public boolean toasterMessageAfterCreatingACalendarWithoutfillingMandetoryFields() {
		if (toasterMsg.equals("Please Fill All The Mandetory Fields")) {
			return true;
		} else
			return false;
	}

	public boolean userCanCreateAnewHolidayCalendar() throws InterruptedException {
		FactoryCalender fc = new FactoryCalender(driver);
		CalendarName = RandomStringUtils.randomAlphabetic(4);
		CalendarName = "TestCal" + CalendarName;

		driver.findElement(addNewCalendarBtn).click();
		Thread.sleep(2000);
		driver.findElement(calendarNameInput).sendKeys(CalendarName);
		Thread.sleep(1000);
		driver.findElement(calendarDesc).sendKeys("CalendarCreated for testing purpose");
		Thread.sleep(2000);
		driver.findElement(addHolidayBtn).click();
		Thread.sleep(1500);
		driver.findElement(fc.shiftStartTime).click();
		Thread.sleep(2000);
		driver.findElement(startDateInput).sendKeys("01012024");
		Thread.sleep(1000);
		driver.findElement(fc.shiftEndTime).click();
		Thread.sleep(1000);
		driver.findElement(startDateInput).sendKeys("01012024");
		driver.findElement(holidayname).click();
		driver.findElement(By.xpath("(//input[@type='text'])[last()-2]")).sendKeys("Test Holiday");

		try {
			driver.findElement(selectUsageFact).click();
		} catch (Exception e) {

		}

		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		toasterMsg = driver.findElement(successToaster).getText();
		System.out.println(toasterMsg);
		Thread.sleep(2000);
		boolean b;
		try {
			WebElement a = driver.findElement(By.xpath("//div[contains(text(),'" + CalendarName + "')]"));
			a.isDisplayed();
			b = true;

		} catch (Exception e) {
			b = false;

		}
		return b;
	}

	public boolean HolidayCalendarToaster() {
		if (toasterMsg.equals("Calendar Created Successfully!")) {
			return true;
		} else
			return false;
	}

	public boolean userCanEditTheHolidayCalendar() throws InterruptedException {

		driver.findElement(By.xpath("//div[contains(text(),'" + CalendarName + "')]")).click();
		Thread.sleep(2000);
		driver.findElement(holidayname).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//input[@type='text'])[last()-2]")).sendKeys("Test Holiday changed");
		Thread.sleep(1200);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'" + CalendarName + "')]")).click();
		Thread.sleep(1500);
		toasterMsg = driver.findElement(successToaster).getText();
		return true;

	}

	public boolean toasterMessageOfEditCalendar() {
		if (toasterMsg.equals("Changes saved successfully!")) {
			return true;
		} else
			return false;
	}

	public boolean deleteHolidayCalendar() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'" + CalendarName + "')]")).click();
		Thread.sleep(2000);
		driver.findElement(deleteBtn).click();
		Thread.sleep(2000);
		toasterMsg = driver.findElement(successToaster).getText();
		WebElement a = driver.findElement(
				By.xpath("//div[contains(text(),'" + CalendarName + " ')]/parent::div/following-sibling::footer/span"));
		String status = a.getText();
		System.out.println(status);
		if (status.equals("Inactive")) {
			return true;
		} else
			return false;
	}

	public boolean deleteHolidayCalendarToaster() {
		if (toasterMsg.equals("Holiday Calendar Deleted Successfully!")) {
			return true;
		} else
			return false;
	}

}
