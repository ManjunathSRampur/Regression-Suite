package com.qa.bps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bps.utils.ElementUtil;

public class ScheduleAdheranceReport {

	private WebDriver driver;
	private By submitBtn = By.xpath("//button[contains(text(),'Submit')]");
	private ElementUtil eleUtil;
	public ScheduleAdheranceReport(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	

	
	//Verify full screen under Cycle Time Analysis screen
	public boolean submitBtn() throws Exception {
				driver.findElement(submitBtn).click();
				boolean fe=driver.findElement(submitBtn).isDisplayed();
				return fe;
	}
	

}
