package com.qa.bps.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VSB7 {
	WebDriver driver;

	public VSB7(WebDriver driver) {
		this.driver = driver;
	}

	private By BuildingHead = By.xpath("//div[contains(text(),'Building')]");
	private By EquipmentHead = By.xpath("//div[contains(text(),'Equipment')]");
	private By filterButton = By.xpath("//button[contains(text(),'Filter')]");
	private By AptDD = By.xpath("//span[contains(text(),'APT')]");
	private By BuildingDD = By.xpath("//span[contains(text(),'Building')]");
	private By productDD = By.xpath("//span[contains(text(),'Product')]");
	private By EquipmentDD = By.xpath("(//span[contains(text(),'Equipment')])[2]");
	private By showTransferLinkCheckBox = By.xpath("//input[@type='checkbox']");
	private By MajorDelayColor = By.xpath("(//span[contains(text(),'Major Delay')]/parent::p/span)[1]");
	private By PlannedColor = By.xpath("((//span[contains(text(),'Planned')]/parent::p/span))[3]");

	private By slightDelayclr=By.xpath("(//span[contains(text(),'Slight Delay')]/parent::p/span)[1]");
	private By EqUnavailableClr=By.xpath("(//span[contains(text(),'Equipment Unavailable')]/parent::p/span)[1]");
	private By AsPlannedClr=By.xpath("(//span[contains(text(),'As Planned')]/parent::p/span)[1]");






	
	
	public boolean verifyAvailableFields() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		boolean b;
		try {
			
			
			
			driver.findElement(BuildingHead).isDisplayed();
			driver.findElement(EquipmentHead).isDisplayed();
			driver.findElement(filterButton).isDisplayed();
			driver.findElement(showTransferLinkCheckBox).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;

		}
		return b;

	}

	public boolean optionsAvailableUnderFilterButton() throws InterruptedException {
		driver.findElement(filterButton).click();
		Thread.sleep(2000);
		boolean b;
		try {
			driver.findElement(AptDD).isDisplayed();
			driver.findElement(BuildingDD).isDisplayed();
			driver.findElement(productDD).isDisplayed();
			driver.findElement(EquipmentDD).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean slightDelayEventColor() {
		
		String a =driver.findElement(slightDelayclr).getAttribute("style");
		
		
		
		
		String SlightDelay = "background: rgb(251, 211, 0);";

		 
		System.out.println(a);
		if (a.equals(SlightDelay)) {
			return true;
		} else
			return false;

	}

	public boolean EquipmentUnavailableEventColors() {
		String EquipmentUnavailable = "background: rgba(67, 58, 58, 0.54);";

		String a = driver.findElement(EqUnavailableClr).getAttribute("style");
		System.out.println(a);
		if (a.equals(EquipmentUnavailable)) {
			return true;
		} else
			return false;
	}
	
	public boolean AsPlannedEventColors() {
		String asPlanned = "background: rgb(0, 128, 0);";

		String a = driver.findElement(AsPlannedClr).getAttribute("style");
		System.out.println(a);
		if (a.equals(asPlanned)) {
			return true;
		} else
			return false;
	}
	
	
	
	public boolean MajorDelayColors() {
		String MajorDelay = "background: rgb(255, 0, 0);";

		String a = driver.findElement(MajorDelayColor).getAttribute("style");
		System.out.println(a);
		if (a.equals(MajorDelay)) {
			return true;
		} else
			return false;
	}
	
	public boolean PlannedColors() {
		String planned = "background: rgb(128, 128, 128);";

		String a = driver.findElement(PlannedColor).getAttribute("style");
		System.out.println(a);
		if (a.equals(planned)) {
			return true;
		} else
			return false;
	}
	
	public void EquipmentAvailabilityUnderVsb7(){
		
	}
	
	

}
