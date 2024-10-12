package com.qa.bps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlantView  {
	WebDriver driver;
	private By delay = By.xpath("//div[contains(text(),'Total Delay(Hrs):')]");
	private By menu = By.xpath("//div[@class='menu']");
	private By summaryEquipments = By.xpath("//div[@class='equipment-no equipment-no-summary']");
	private By clusterEquipments = By.xpath("//div[@class='equipment-no equipment-no-cluster']");
	private By clustertab = By.xpath("//div[contains(text(),'Cluster')]");
	boolean delayb;

	public PlantView(WebDriver driver) {

		this.driver = driver;
	}

	public boolean checkTotalDelayExist() throws InterruptedException {
		Thread.sleep(3000);

		delayb = driver.findElement(delay).isDisplayed();
		return delayb;
	}

	public boolean checkMenusExist() throws InterruptedException {
		Thread.sleep(2000);
		boolean b = driver.findElement(menu).isDisplayed();
		return b;

	}

	public boolean getSummaryEquipmentDetails() throws InterruptedException

	{
		Thread.sleep(2000);
		boolean b = driver.findElements(summaryEquipments).isEmpty();
		return b;

	}

	public boolean getClusterEquipmentDetails()

	{

		driver.findElement(clustertab).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean b = driver.findElements(clusterEquipments).isEmpty();
		return b;

	}
}
