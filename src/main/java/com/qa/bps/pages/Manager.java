package com.qa.bps.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.bps.utils.ElementUtil;

public class Manager {

	private WebDriver driver;

	private By subScreenNames = By.xpath("//div[@class='heading']");
	private By managerview = By.xpath("//div[contains(text(),'Manager View')]");
	private By shifthandover = By.xpath("//div[contains(text(),'Shift Summary & Handover')]");
	private By plantview = By.xpath("//div[contains(text(),'Plant View')]");
	private By productview = By.xpath("//div[contains(text(),'Product View and Delay Management')]");
	private By summarydashboard = By.xpath("//div[contains(text(),'Summary Dashboard')]");
	private By vsb = By.xpath("//div[contains(text(),'VSB')]");
	List<WebElement> subnameslistCTs = new ArrayList<WebElement>();
	List<String> nameslists = new ArrayList<String>();
	private By productoverview = By.xpath("//button[contains(text(),'Product Overview')]");

	private ElementUtil eleUtil;

	public Manager(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public List<String> getManagerScreenNames()

	{
		driver.findElement(managerview);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		subnameslistCTs = driver.findElements(subScreenNames);
		for (WebElement e : subnameslistCTs) {
			nameslists.add(e.getText());

		}
		// System.out.println(nameslists);

		return nameslists;

	}

	public ManagerView navigateToManagerView() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		eleUtil.getElement(managerview).click();
		return new ManagerView(driver);

	}

	public ShiftSummaryHandover navigateToShiftHandover() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		eleUtil.getElement(shifthandover).click();
		return new ShiftSummaryHandover(driver);

	}

	public PlantView navigateToPlantView() {
		eleUtil.getElement(plantview).click();
		return new PlantView(driver);

	}

	public DailyOperatorManagement navigateToProducView() {
		eleUtil.getElement(productview).click();
		driver.findElement(productoverview).click();
		return new DailyOperatorManagement(driver);

	}

	public SummaryDashboard navigateToSummaryDashboard() {
		eleUtil.getElement(summarydashboard).click();
		return new SummaryDashboard(driver);

	}

	public EquipmentScheduling navigateToEquipmentScheduling() {
		eleUtil.getElement(vsb).click();
		return new EquipmentScheduling(driver);
	}

}
