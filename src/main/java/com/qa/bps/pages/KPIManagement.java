package com.qa.bps.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KPIManagement {

	private WebDriver driver;

	private By screenNames = By.xpath("//div[@class='heading']");
	private By CycleTimeAnalysis = By.xpath("//div[contains(text(), 'Cycle Time Distribution Analysis')]");
	private By delayAnalysis = By.xpath("//div[contains(text(), ' Delay Analysis ')]");
	private By scheduleAdheranceReport = By.xpath("//div[contains(text(), ' Schedule Adherence Report ')]");
	private By equipmentRelaunchTimeAnalysis = By
			.xpath("//div[contains(text(),'Equipment Relaunch Time Distribution Analysis')]");
	List<String> stringnameList = new ArrayList<String>();
	List<WebElement> nameslist = new ArrayList<WebElement>();

	public KPIManagement(WebDriver driver) {

		this.driver = driver;
	}

	// verify all the screen are available under kpi management

	public List<String> checkKPIManagementScreenNames()

	{
		nameslist = driver.findElements(screenNames);
		for (WebElement e : nameslist) {
			stringnameList.add(e.getText());

		}
		System.out.println(stringnameList);

		return stringnameList;
	}

	public CycleTimeAnalysis navigateToCycleTimeAnalysis() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(CycleTimeAnalysis).click();
		return new CycleTimeAnalysis(driver);

	}

	public DelayAnalysis navigateToDelayAnalysis() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(delayAnalysis).click();
		return new DelayAnalysis(driver);

	}

	public ScheduleAdheranceReport navigateToScheduleAdheranceReport() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(scheduleAdheranceReport).click();
		return new ScheduleAdheranceReport(driver);

	}

	public EquipmentRelaunchTime navigateToEquipmentRelaunchTime() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(equipmentRelaunchTimeAnalysis).click();
		return new EquipmentRelaunchTime(driver);
	}

}
