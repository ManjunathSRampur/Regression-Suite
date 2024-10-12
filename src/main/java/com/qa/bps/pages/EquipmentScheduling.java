package com.qa.bps.pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.bps.utils.ElementUtil;

//import io.netty.handler.timeout.TimeoutException;

public class EquipmentScheduling {

	WebDriver driver;
	String formattedDate;
	List<WebElement> eqlist = new ArrayList<WebElement>();

	private By equipmentList = By.xpath("//div[@class='gantt_tree_content']//div[@class='equipment-header']");
	private By sideTaskBtn = By.xpath("//button[contains(text(), 'Side Task')]");
	private By taskName = By.xpath("(//*[@class='task-name'])[1]");
	private By selEquipment = By.xpath(
			"(//div[@class='modal-content fix-height']//div[@class='selected-list']//span[@class='ng-star-inserted'])[1]");
	private By datePicker = By.xpath("//input[@id='startDate']");
	private By selEquipmentFromDropDown = By.xpath("(//label[contains(text(), 'Eq 21_B722')])[2]");
	private By addBtn = By.xpath("//button[contains(text(), 'Add')]");
	private By toast = By.xpath("//*[@id='toast-container']");
	private By filterBtn = By.xpath("(//button[contains(text(),'Filters')])");
	private By equipment = By.xpath("(//span[contains(text(),'Equipment')])[1]");
	private By searchChkBox = By.xpath("(//label[contains(text(),'Eq 21_B722')])[1]");
	private By breakTaskDisplay = By.xpath("(//div[contains(text(), 'Break (NA)')])[2]");
	private By searchBoxClick = By.xpath("(//ul[@class='lazyContainer'])[6]");
	private By closeIcon = By.xpath(
			"//div[@class='close-button pointer']//*[name()='svg']//*[name()='path' and contains(@clip-rule,'evenodd')]");
	private By allChkBox = By.xpath("//label[contains(@id,'scale')]/input");
	List<WebElement> allChkBoxes = new ArrayList<WebElement>();
	List<WebElement> operatorField=new ArrayList<WebElement>();
	private By chkBoxStrings=By.xpath("(//label[contains(@id,'scale')]//input)");
	private By chkBoxRequiredOperator=By.xpath("(//label[contains(@id,'scale')]//input)[4]");
	private By chkBoxAvailableOperator=By.xpath("(//label[contains(@id,'scale')]//input)[5]");
	private By chkBoxShortageOperator=By.xpath("(//label[contains(@id,'scale')]//input)[6]");
	private By operatorSection=By.xpath("(//div[@class='gantt_grid_data'])[2]//div[@class='gantt_tree_content' and contains(text(),'Operator') or contains(text(),'Shortage')]");
	List<WebElement> chkboxStringList=new ArrayList<WebElement>();

	//private By firstOptnEquipment=By.xpath("(//ul[@class='lazyContainer'])[6]/li[1]//input");
	private By equipmentHeader=By.xpath("(//div[@class='equipment-header'])[2]");
	private By firstOptnEquipment=By.xpath("(//ul[@class='lazyContainer'])[6]/li[1]/label");
	private By viewDropDown=By.xpath("//span[.='View']");
	private By viewOptions=By.xpath("//div[@class='list-area single-select-mode']//li");
	List<String> viewOptn = new ArrayList<String>();
	private By sideTaskDD=By.xpath("(//mat-expansion-panel)[1]");
	private By equipDD=By.xpath("//button[@data-toggle='dropdown']");
	private By eqFirstOptn=By.xpath("(//div[@class='dropdown-menu customHeight ng-star-inserted show']/a)[1]");
	private By dateFilter=By.xpath("//input[@placeholder='Date']");
	private ElementUtil eleUtil;

	public EquipmentScheduling(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public boolean getEquipmentList() throws InterruptedException, NoSuchElementException

	{
		try {

			// eleUtil.waitTillElementVisible(sideTaskBtn, Duration.ofSeconds(1000));
			Thread.sleep(10000);
			// eqlist = eleUtil.getElements(equipmentList);
			// System.out.println(eqlist);
			// boolean b = eqlist.isEmpty();// checking the list is empty
			boolean b = driver.findElement(sideTaskBtn).isDisplayed();
			return b;
		} catch (Exception e) {
			System.out.println("EquipmentScheduling not Loaded");
			return true;
		}
	}

	public String testSideTaskBtnWorkflow() throws InterruptedException {
		Thread.sleep(3000);
		eleUtil.getElement(sideTaskBtn).click();
		eleUtil.getElement(sideTaskDD).click();
		String TaskName = eleUtil.getElement(taskName).getText();
		eleUtil.getElement(taskName).click();
		eleUtil.getElement(equipDD).click();
		String EquipmentName = driver.findElement(eqFirstOptn).getText();
		Thread.sleep(2000);
		eleUtil.getElement(eqFirstOptn).click();
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 formattedDate = currentDate.format(formatter).toString();
		System.out.println(formattedDate);
		eleUtil.getElement(datePicker).sendKeys(formattedDate);
		eleUtil.getElement(datePicker).sendKeys(Keys.TAB);
		eleUtil.getElement(datePicker).sendKeys("0245PM");
		eleUtil.getElement(addBtn).click();
		Thread.sleep(2000);
		String msg = driver.findElement(toast).getText();
		driver.findElement(closeIcon).click();
		return msg;

	}

	// TC verify user is able to view the added side task
	public boolean viewSideTaskAdded() throws InterruptedException

	{
		Thread.sleep(2000);
		eleUtil.getElement(dateFilter).sendKeys(formattedDate);
		System.out.println("1 in");
		Thread.sleep(2000);
		eleUtil.getElement(filterBtn).click();
		eleUtil.getElement(equipment).click();
		eleUtil.getElement(searchChkBox).click();
		System.out.println("2 in");
		// driver.findElement(searchBoxClick).click();
		eleUtil.getElement(breakTaskDisplay).isDisplayed();
		System.out.println("3 in");
		return true;
	}

	public boolean allChkBoxSelected() {
		allChkBoxes = driver.findElements(allChkBox);
		int listSize = allChkBoxes.size();
		int count = 0;
		for (WebElement e : allChkBoxes) {

			e.isSelected();
			count++;

		}

		if (listSize == count) {

			return true;
		}

		else {

			return false;
		}
	}

	public boolean operatorSectiondisplayed() throws InterruptedException{
		Thread.sleep(20000);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(chkBoxAvailableOperator));
		driver.findElement(chkBoxAvailableOperator).click();
		driver.findElement(chkBoxRequiredOperator).click();
		driver.findElement(chkBoxShortageOperator).click();
		if(driver.findElements(operatorSection).size()==0)
		{
			
		return true;
		}
		else
		{
			
			return false;
		}
		}
	

	public String equipmentValidation() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(20000));
	
	
		Thread.sleep(20000);
		driver.findElement(filterBtn).click();
		Thread.sleep(2000);
		driver.findElement(equipment).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(firstOptnEquipment)));
		driver.findElement(firstOptnEquipment).click();
		Thread.sleep(8000);
		String text=driver.findElement(equipmentHeader).getText();
		Thread.sleep(2000);
		System.out.println(text);
		return text;
		
	}
	public List<String> viewDropDown()throws InterruptedException
	{
		//Thread.sleep(20000);
		//driver.findElement(filterBtn).click();
		Thread.sleep(2000);
		driver.findElement(viewDropDown).click();
		Thread.sleep(2000);
		List<WebElement> optn=driver.findElements(viewOptions);
		for (WebElement e : optn) 
		{
			 viewOptn.add(e.getText());
		}
	
	return viewOptn;
	}
}