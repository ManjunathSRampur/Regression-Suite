package com.qa.bps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bps.utils.ElementUtil;

public class DelayAnalysis {

	private WebDriver driver;
	private By submitBtn = By.xpath("//button[contains(text(),'Submit')]");
	private ElementUtil eleUtil;

	public DelayAnalysis(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Verify full screen under Cycle Time Analysis screen
	public boolean submitBtnExists() throws Exception {
		eleUtil.getElement(submitBtn).click();
		boolean fe = eleUtil.getElement(submitBtn).isDisplayed();
		return fe;
	}

}
