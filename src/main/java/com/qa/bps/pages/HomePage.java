package com.qa.bps.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends EventProperties {

	// locators
	WebDriver driver;
	// private By favbtn = By.xpath("//fa-icon[@title='Favorites']");
	private By favbtn = By.xpath("//div/fa-icon");
	private By nofavaddedPopup = By.xpath("//div/li/b[contains(text(),'No Favorites Added')]");
	private By favAddedToaster = By.xpath("//div[contains(text(),'Favorites Added Successfully')]");
	private By favDelToaster = By.xpath("//div[contains(text(),'Favorites Removed')]");
	private By favListHomeScreen = By.xpath("//div[@class='fav-card ']/div");
	private By favManageBtn = By.xpath("//*[@data-icon='list']");
	private By favRemoveAll = By.xpath("//div[@class='remove']/fa-icon");
	private By favPages = By.xpath("//p[contains(text(),'Control Tower')]");
	private By favBtnClose = By.xpath("(//div[@class='remove']/fa-icon)[5]");
	private By homeBtn = By.xpath("//img[@src='./assets/png/home.png']");
	private By homeBtn2 = By.xpath("//li[contains(text(),' Home')]");
	private By homeScreenNames = By.xpath("//div[@class='heading center-align mt-0 mb-1']");
	private By controlTower = By.xpath("//div[contains(text(),'Control Tower')]");
	private By microplanning = By.xpath("//div[contains(text(),'Microplanning')]");
	private By kpiManagement = By.xpath("//div[contains(text(),' KPI Management ')]");
	private By managerView = By.xpath("//div[.=' Manager View ']");
	private By manager = By.xpath("//div[.=' Manager ']");
	private By shiftLeader = By.xpath("//div[contains(text(),' Shift Leader')]");
	private By summaryDashBoard = By.xpath("//div[contains(text(),' Summary Dashboard ')]");
	private By config = By.xpath("//div[@class='nav-item dropdown ml-1']");
	private By eng = By.xpath("//a[@class='dropdown-item'][normalize-space()='English (en)']");
	private By userDropDown = By.xpath("//p[@id='navbarDropdown']");
	private By lebelFav = By.xpath("(//a[.='Favorite'])[1]");
	private By bodheeStudioLabel = By.xpath("//a[contains(text(),'Bodhee Studio')]");
	private By userNameinStudio = By.xpath("//div[@class='nav-link dropdown-toggle']");
	private By labelIAM = By.xpath("(//a[@class='dropdown-item'])[1]");
	private By displayedNameInStudio = By.xpath("(//div[@tabulator-field='user_name'])[2]");
	private By returnHomePageFromStudio = By.xpath("//img[@alt='Bodhee Logo']");
	private By bodheeLogo = By.xpath("//a[@class='bodhee_logo']");
	private By controlTWR = By.xpath("(//div[.=' Control Tower '])[last()]");
	private By vsbtab = By.xpath("//div[contains(text(),'VSB')]");
	private By DateBox = By.xpath("//input[@placeholder='Date']");

	WebDriverWait wait;

	List<WebElement> homeScreenNameList = new ArrayList<WebElement>();
	List<WebElement> favRemoveAllwe = new ArrayList<WebElement>();
	List<String> nameList = new ArrayList<String>();
	// private By welcomeMsg = By.xpath("//a[normalize-space()='Welcome']");
	private By welcomeMsg = By.xpath("//div/a[normalize-space()='Welcome']");
	boolean msgExist;

	// constructor
	public HomePage(WebDriver driver) {

		this.driver = driver;
		System.out.println("Inside Home Page" + driver);
	}

	// methods
	public boolean weclomeMsgExist() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		msgExist = driver.findElement(welcomeMsg).isDisplayed();

		return msgExist;
	}

	public List<String> HomeScreenNamesExist() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		homeScreenNameList = driver.findElements(homeScreenNames);
		for (WebElement e : homeScreenNameList) {

			nameList.add(e.getText());
		}
		System.out.println(nameList);
		return nameList;

	}

	public ControlTower navigateToControlTower()

	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(controlTower).click();
		return new ControlTower(driver);
	}

	public MicroPlanning navigateToMicroplanning()

	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(microplanning).click();
		return new MicroPlanning(driver);
	}

	public KPIManagement navigateToKPI_Management()

	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(kpiManagement).click();
		return new KPIManagement(driver);
	}

	public boolean validateIamUser() throws InterruptedException

	{
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(userDropDown).click();
		Thread.sleep(4000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(6000);
		driver.findElement(userNameinStudio).click();
		Thread.sleep(4000);
		driver.findElement(labelIAM).click();
		Thread.sleep(4000);
		boolean b = driver.findElement(displayedNameInStudio).isDisplayed();

		driver.findElement(returnHomePageFromStudio).click();
		return b;
	}

	public boolean checkBodheeLogo() {

		return driver.findElement(bodheeLogo).isDisplayed();

	}

	public BodheeStudio navigateToBodheeStudio() throws InterruptedException {

		Thread.sleep(10000);
		driver.findElement(userDropDown).click();
		Thread.sleep(10000);
		driver.findElement(bodheeStudioLabel).click();
		Thread.sleep(18000);

		return new BodheeStudio(driver);

	}

	public boolean favBtnAvailable() throws InterruptedException {

		Thread.sleep(15000);
		return driver.findElement(favbtn).isDisplayed();
	}

	public boolean noFavAdded() throws InterruptedException {
		driver.findElement(favbtn).click();
		Thread.sleep(9000);
		return driver.findElement(nofavaddedPopup).isDisplayed();
	}

	public boolean addFavorties() throws InterruptedException {
		driver.findElement(controlTower).click();
		Thread.sleep(7000);
		driver.findElement(userDropDown).click();
		Thread.sleep(2000);
		driver.findElement(lebelFav).click();
		Thread.sleep(4000);
		boolean b = driver.findElement(favAddedToaster).isDisplayed();
		return b;

	}

	public boolean checkFavHomePage() throws InterruptedException {
		driver.findElement(homeBtn).click();
		driver.navigate().refresh();
		Thread.sleep(7000);
		return driver.findElement(favListHomeScreen).isDisplayed();

	}

	public boolean checkFavAdded() throws InterruptedException {
		driver.findElement(favbtn).click();
		Thread.sleep(6000);
		String a = driver.findElement(favPages).getText();
		String b = driver.findElement(favListHomeScreen).getText();
		if (a.equalsIgnoreCase(b)) {
			System.out.println("homes screen" + a);
			System.out.println("fav screen" + b);
			return true;
		} else {
			return false;
		}

	}

	public boolean checkFavoriteNavigationFromHeader() throws InterruptedException {
		driver.findElement(favPages).click();
		Thread.sleep(5000);
		boolean b = driver.findElement(controlTower).isDisplayed();
		driver.findElement(homeBtn).click();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(4000);

		return b;

	}

	public boolean checkFavoriteNavigationFromFavSection() throws InterruptedException {

		driver.findElement(favListHomeScreen).click();
		Thread.sleep(5000);
		return driver.findElement(controlTower).isDisplayed();
	}

	public boolean deleteFavList() throws InterruptedException {
		Thread.sleep(5000);
//		driver.findElement(homeBtn).click();
//		Thread.sleep(5000);
		driver.findElement(favManageBtn).click();
		Thread.sleep(4000);
		driver.findElement(favBtnClose).click();
		Thread.sleep(5000);
		return driver.findElement(favDelToaster).isDisplayed();

	}

	public boolean maxFavLimit() throws InterruptedException {
//		Thread.sleep(7000);
		System.out.println("test case 11 started ");
		driver.findElement(homeBtn).click();
		Thread.sleep(2000);
		driver.findElement(microplanning).click();
		Thread.sleep(4000);
		driver.findElement(userDropDown).click();
		Thread.sleep(2000);
		driver.findElement(lebelFav).click();
		Thread.sleep(2000);
		driver.findElement(homeBtn).click();
		driver.navigate().refresh();
		Thread.sleep(4000); // 1 page added (microplanning)
		driver.findElement(kpiManagement).click();
		Thread.sleep(4000);
		driver.findElement(userDropDown).click();
		Thread.sleep(2000);
		driver.findElement(lebelFav).click();
		Thread.sleep(2000);
		driver.findElement(homeBtn).click();
		driver.navigate().refresh();
		Thread.sleep(4000); // 3 pages added (KPI management)

		driver.findElement(controlTWR).click();
		Thread.sleep(2000);
		driver.findElement(manager).click();
		Thread.sleep(4000);
		driver.findElement(userDropDown).click();
		Thread.sleep(4000);
		driver.findElement(lebelFav).click();
		Thread.sleep(4000);
		driver.findElement(homeBtn2).click();
		driver.navigate().refresh();
		Thread.sleep(4000); // 4 pages added(manager )

		driver.findElement(controlTWR).click();
		Thread.sleep(4000);
		driver.findElement(manager).click();
		Thread.sleep(4000);
		driver.findElement(managerView).click();
		Thread.sleep(8000);
		driver.findElement(userDropDown).click();
		Thread.sleep(4000);
		driver.findElement(lebelFav).click();
		Thread.sleep(4000);
		driver.findElement(homeBtn2).click();
		driver.navigate().refresh();
		Thread.sleep(4000); // 5 pages added(manager )

		driver.findElement(controlTWR).click();
		Thread.sleep(5000);
		driver.findElement(shiftLeader).click();
		Thread.sleep(4000);
		driver.findElement(userDropDown).click();
		Thread.sleep(4000);
		driver.findElement(lebelFav).click();
		Thread.sleep(4000);

		boolean b = driver.findElement(By.xpath("//div[contains(text(),'Can add only 5 Favorites')]")).isDisplayed();

		driver.findElement(homeBtn2).click();
		return b;

	}

	public boolean deleteAllFavList() throws InterruptedException {
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		driver.findElement(favManageBtn).click();
		Thread.sleep(5000);
		favRemoveAllwe = driver.findElements(favRemoveAll);
		System.out.println(favRemoveAllwe.size());
		for (int i = 1; i <= favRemoveAllwe.size(); i++) {
			driver.findElement(By.xpath("(//div[@class='remove']/fa-icon)[last()]")).click();
			Thread.sleep(2000);
		}

		Thread.sleep(6000);
		int size = driver.findElements(favManageBtn).size();
		if (size == 0) {

			return true;
		}

		else
			return false;

	}

	public VSBpage navigateToVSB() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(vsbtab).click();
		Thread.sleep(7000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(4000);
		return new VSBpage(driver);

	}

}
