package com.qa.bps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bps.utils.ElementUtil;

public class EquipmentRelaunchTime {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public EquipmentRelaunchTime(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	private By submitBtn = By.xpath("//button[contains(text(),'Submit')]");
	
	//Verify full screen under Cycle Time Analysis screen
	public boolean submitBtnExists() throws Exception {
		eleUtil.getElement(submitBtn).click();
				boolean fe=driver.findElement(submitBtn).isDisplayed();
				return fe;
	}

}
