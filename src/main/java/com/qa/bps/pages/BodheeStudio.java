package com.qa.bps.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BodheeStudio {

	WebDriver driver;
	List<WebElement> menuList = new ArrayList<WebElement>();
	List<String> menuNamesList = new ArrayList<String>();
	private By iam = By.xpath("//a[contains(@href,'iam')]");
	private By shiftPattern = By.xpath("//a[contains(@href,'shift-pattern')]");
	private By adminConsole = By.xpath("//a[contains(@href,'user-preference')]");
	private By dataManagement = By.xpath("//a[contains(@href,'dataManagement')]");
	private By teamManagement = By.xpath("//a[contains(@href,'team-management')]");

	private By menuNames = By.xpath("//h6[contains(@class,'card-title')]");

	public BodheeStudio(WebDriver driver) {

		this.driver = driver;

	}

	public List<String> bodheeStudioMenus() throws InterruptedException {

		Thread.sleep(10000);
		menuList = driver.findElements(menuNames);
		System.out.println(menuList.size());
		for (WebElement e : menuList)

		{

			System.out.println(e.getText());
			menuNamesList.add(e.getText());

		}

		return menuNamesList;
	}

	public IAM navigateToIAM() throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(iam).click();
		Thread.sleep(3000);
		return new IAM(driver);
	}

	public ShiftPattern navigateToShiftPatrn() {
		driver.findElement(shiftPattern).click();
		return new ShiftPattern(driver);
	}

	public AdminConsole navigateToAdminConsole() {
		driver.findElement(adminConsole).click();
		return new AdminConsole(driver);
	}

	public DataManagement navigatetoDataManagement() {
		driver.findElement(dataManagement).click();
		return new DataManagement(driver);
	}

	public TeamManagement navigatetoToTeamManagement() {
		driver.findElement(teamManagement).click();
		;
		return new TeamManagement(driver);
	}

}
