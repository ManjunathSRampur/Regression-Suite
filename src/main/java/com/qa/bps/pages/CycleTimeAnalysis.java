package com.qa.bps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bps.utils.ElementUtil;

public class CycleTimeAnalysis {

	private By fullScreen = By.xpath("//img[@src='assets/png/fullscreen1.png']");
	private By minimiseScreen = By.xpath("//img[@src='assets/png/exitFullscreen.png']");
	private By submitBtn = By.xpath("//button[contains(text(),'Submit')]");
	private WebDriver driver;
	private ElementUtil eleUtil;

	public CycleTimeAnalysis(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Verify full screen under Cycle Time Analysis screen
	public boolean submitBtnExists() throws Exception {
		Thread.sleep(7000);
		eleUtil.getElement(submitBtn).click();
		Thread.sleep(7000);
		boolean fe = eleUtil.getElement(submitBtn).isDisplayed();
		return fe;
	}

}
