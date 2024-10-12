package com.qa.bps.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.bps.utils.ElementUtil;

public class MicroPlanning {

	WebDriver driver;

	private By fileupload = By.xpath("//div[contains(text(),'File Upload')]");
	private By planner = By.xpath("//div[contains(text(),'Planner')]");
	private By skillMatrix = By.xpath("//div[contains(text(),'Skill Matrix')]");
	private By screenNames = By.xpath("//div[@class='heading']");
	private By dateTime = By.xpath("//div[@class='mr-4']");
	List<String> stringnameList = new ArrayList<String>();
	List<WebElement> nameslist = new ArrayList<WebElement>();

	private ElementUtil eleUtil;

	public MicroPlanning(WebDriver driver) {
		eleUtil = new ElementUtil(driver);
		this.driver = driver;

	}

	public List<String> checkMicroplanningScreenNames()

	{
		nameslist = eleUtil.getElements(screenNames);
		for (WebElement e : nameslist) {
			stringnameList.add(e.getText());

		}

		return stringnameList;
	}

	public boolean dateTimeEnabled() {

		String date = eleUtil.getElement(dateTime).getText();
		if (!(date.isEmpty())) {
			return true;

		} else
			return false;

	}

	public FileUpload navigateToFileUpload() throws InterruptedException

	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		eleUtil.getElement(fileupload).click();
		Thread.sleep(5000);
		return new FileUpload(driver);
	}

	public Planner navigateToPlanner()

	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		eleUtil.getElement(planner).click();
		return new Planner(driver);
	}

	public SkillMatrix navigateToSkillMatrix() {

		eleUtil.getElement(skillMatrix).click();
		return new SkillMatrix(driver);
	}

}
