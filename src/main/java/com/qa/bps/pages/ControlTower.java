package com.qa.bps.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.bps.utils.ElementUtil;

public class ControlTower {

	private By manager = By.xpath("//div[contains(text(),'Manager')]");

	private By operator = By.xpath("//div[contains(text(),'Operator')]");
	private By shiftLeader = By.xpath("//div[contains(text(),'Shift Leader')]");
	private By mainScreenNames = By.xpath("//div[@class='heading']");
	List<WebElement> nameslistCT = new ArrayList<WebElement>();
	List<String> nameslist = new ArrayList<String>();
	WebDriver driver;

	private ElementUtil eleUtil;

	public ControlTower(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public List<String> getControlTowerMainScreenNames()

	{

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		nameslistCT = eleUtil.getElements(mainScreenNames);
		for (WebElement e : nameslistCT) {
			nameslist.add(e.getText());
		}
		System.out.println(nameslist);

		return nameslist;

	}
	public Manager navigateToManager() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		eleUtil.getElement(manager).click();
		return new Manager(driver);
	}
	public OperatorView navigateToOperator() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		eleUtil.getElement(operator).click();
		return new OperatorView(driver);

	}
}
