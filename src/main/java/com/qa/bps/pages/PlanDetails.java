package com.qa.bps.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;
import com.qa.bps.utils.ExcelUtil;

import io.reactivex.rxjava3.functions.Action;

public class PlanDetails {

	WebDriver driver;
	String statusString;
	String versionString;
	String publishmsg;

	private By status = By.xpath("//div[@class='label-small ellipsis-custom']");
	private By version = By.xpath("//div[text()=' v0 ']");
	private By publishBtn = By.xpath("//button/a[contains(text(),'Publish')]");
	private By publishedMsg = By.xpath("//label[text()='Published']");

	private By failedConstraintsButton = By.xpath("//a[@class=\'screen-toggle-icon\']");
	private By operatorSchedule = By.xpath("//button[contains(text(),'Operator Schedule')]");
	private By logeventButton = By.cssSelector("svg.screen-toggle-icon");
	private By logeventPopup = By.xpath("//div[@class=\'root\']");
	boolean logeventpopAvailable;
	private By checKBox1 = By.xpath("(//input[@type='checkbox'])[17]");
	private By checKBox2 = By.xpath("(//input[@type='checkbox'])[18]");
	private By checKBox3 = By.xpath("(//input[@type='checkbox'])[19]");
	private By checKBox4 = By.xpath("(//input[@type='checkbox'])[20]");
	private By campaingCount = By.xpath("(//div[@class='bodhee-kpi-card-value'])[1]");
	// private By arrowbutton = By.xpath("(//div[@class='text-ellipsis'])[7]");
	private By batchesCount = By.xpath("(//div[@class='bodhee-kpi-card-value'])[2]");
	private By campaignTab = By.xpath("//div[text()='CAMPAIGN ']");
	private By productionTab = By.xpath("//div[text()='PRODUCTION ']");
	private By taskList = By.xpath("//div[@data-column-name='task']//div[@class='gantt_tree_content']");
	private By productList = By.xpath("//div[@class='inside-text' and  @fxflex='10']");
	private By versionlabel = By.xpath("(//div[@class='label-small'])[5]");
	private By versionNumberLabel = By.xpath("(//label[@class='planArchive-label-small'])[2]");
	private By closeBtninVersionPage = By.xpath("//i[contains(@class,'fa fa-fas fa-times')]");
	private By downloadOperatorGapAnalysisIcon = By.xpath("(//img[@src='./assets/png/download_report.png' and @title='Download Operator Gap Analysis'])");
	private By failedConstraintsIcon = By.xpath("//a[@title='Failed Constraints']");
	private By logEventsIcon = By.xpath("//a[@title='Log Events']");
	private By fullScreenIcon = By.xpath("//a[@title='Full screen view']");
	private By arrowIcon=By.xpath("//button[@class='btn btn-warning planButton']");
	List<String> campaign_ID = new ArrayList<String>();
	List<Object> campaign_ID_From_Excel = new ArrayList<Object>();
	List<String> products_ID = new ArrayList<String>();
	List<Object> products_ID_From_Excel = new ArrayList<Object>();
	List<String> campaign_IDs = new ArrayList<String>();
	List<Object> campaign_IDs_From_Excel = new ArrayList<Object>();
	String before_xpath = "(//div[@class='inside-text' and  @fxflex='10'])[";
	String after_xpath = "]";

	String before_Xpath = "(//div[@data-column-name='task']//div[@class='gantt_tree_content'])[";
	String after_Xpath = "]";

	private By campaignData = By.xpath(before_xpath);
	private ElementUtil eleUtil;

	// private By arrowbutton = By.xpath("(//div[@class='text-ellipsis'])[7]");

	public PlanDetails(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	/*
	 * public String checkStatus()
	 * 
	 * {
	 * 
	 * statusString = driver.findElement(status).getText();
	 * System.out.println(statusString); return statusString;
	 * 
	 * }
	 */

	public String checkVersion()

	{
		versionString = driver.findElement(version).getText();
		// System.out.println("Plan Current Verion is " + versionString);
		driver.findElement(closeBtninVersionPage).click();
		return versionString;

	}

	public String publishPlan() throws InterruptedException

	{
		Thread.sleep(3000);
		driver.findElement(publishBtn).click();
		Thread.sleep(10000);
		driver.findElement(version).click();
		driver.findElement(publishedMsg).click();
		publishmsg = driver.findElement(publishedMsg).getText();
		Thread.sleep(4000);
		System.out.println("print msg" + publishmsg);

		driver.findElement(closeBtninVersionPage).click();
		return publishmsg;
	}

	// 27330 Verify the Number of campaign displayed under the plan matches with the
	// campaign uploaded data

	public boolean checkCampaignCount() throws IOException {

		String count = driver.findElement(campaingCount).getText();
		int i = Integer.parseInt(count);
		// System.out.println("value of integer"+i);
		ExcelUtil eu = new ExcelUtil();
		campaign_ID_From_Excel = eu.readExcelData(1, Constants.campaignFilepath, "str");
		// System.out.println("Campaign ID from excel" + campaign_ID_From_Excel);
		int sizeofCampaignId = campaign_ID_From_Excel.size();
		// System.out.println("Total Campaign count from excel" + sizeofCampaignId);
		if (i == sizeofCampaignId) {
			return true;
		} else {
			return false;
		}
	}

	// 27332 Verify the Number of batches displayed under the plan matches with the
	// campaign uploaded data
	// we have hardcoded bacth number in if-else loop please verify while running
	// it.
	public boolean checkbatchesCount() throws IOException {

		String count = driver.findElement(batchesCount).getText();
		int counts = Integer.parseInt(count);
		System.out.println("batch count from appn" + counts);
		ExcelUtil eu = new ExcelUtil();
		campaign_ID_From_Excel = eu.readExcelData(2, Constants.campaignFilepath, "numeric");
		System.out.println("Batch count from excel " + campaign_ID_From_Excel);
		int sums = 0;
		int size = campaign_ID_From_Excel.size();
		for (int i = 0; i < size; i++) {
			int sum = (int) campaign_ID_From_Excel.get(i);
			System.out.println("before add" + sum);
			sums = sums + sum;
			System.out.println("after add" + sum);
		}

		System.out.println("Batch count" + sums);

		if (counts == sums) {
			return true;
		} else
			return false;

	}

	// 30627 Verify user is able to see the campaign details under Campaign tab
	// based on the campaign data uploaded
	public boolean checkCampaignDetails() throws IOException, InterruptedException {
		driver.findElement(campaignTab).click();

		List<WebElement> products = driver.findElements(productList);
		int productsSize = products.size();
		System.out.println("total products in appn " + productsSize);
		// Reading from Excel File
		ExcelUtil eu = new ExcelUtil();

		products_ID_From_Excel = eu.readExcelData(0, Constants.campaignFilepath, "str");
		// System.out.println("list from excel" + campaign_ID_From_Excel);
		products_ID_From_Excel.sort(null);
		// System.out.println("After sort:" + campaign_ID_From_Excel);

		for (int i = 1; i <= productsSize; i++) {

			Thread.sleep(2000);
			products_ID.add(driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText().toString());
			System.out.println("prd list from appn" + products_ID);
		}
		// System.out.println(campaign_ID);
		Collections.sort(products_ID);
		for (String str : products_ID)
			System.out.print("product " + str);

		if (products_ID_From_Excel.equals(products_ID)) {
			return true;
		} else {
			return false;
		}

	}

	// verify the gnatt chart
	public boolean checkgnattChart() throws IOException, InterruptedException {

		driver.findElement(productionTab).click();
		List<WebElement> task = driver.findElements(taskList);
		int taskSize = task.size();
		// System.out.println(taskSize);
		// Reading from Excel File
		ExcelUtil eu = new ExcelUtil();
		Thread.sleep(4000);
		campaign_IDs_From_Excel = eu.readExcelData(1, Constants.campaignFilepath, "str");
		// System.out.println("list from excel" + campaign_IDs_From_Excel);
		campaign_IDs_From_Excel.sort(null);

		System.out.println("After sort:" + campaign_IDs_From_Excel);

		for (int i = 1; i <= taskSize; i++) {

			campaign_IDs.add(driver.findElement(By.xpath(before_Xpath + i + after_Xpath)).getText().toString());
		}
		// System.out.println(campaign_ID);
		Collections.sort(campaign_IDs);
		for (String str : campaign_IDs)
			System.out.print(" " + str);

		if (campaign_IDs_From_Excel.equals(campaign_IDs)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean getVersionDetails() {
		String verLabel = eleUtil.getElement(versionlabel).getText();
		eleUtil.waitTillElementVisible(versionlabel, Duration.ofSeconds(30));
		System.out.println("versionLabel:" + verLabel);
		eleUtil.getElement(versionlabel).click();
		String verNum = driver.findElement(versionNumberLabel).getText();
		eleUtil.waitTillElementVisible(versionlabel, Duration.ofSeconds(30));
		eleUtil.getElement(versionNumberLabel).click();
		System.out.println("versionNumber:" + verNum);
		if (verLabel.equalsIgnoreCase(verNum)) {
			return true;
		} else {
			return false;
		}
	}
   
	public String downloadOperatorGapAnalysisIconToolTip() throws InterruptedException
	{
//	driver.findElement(arrowIcon).click();
	Actions act= new Actions(driver);
	Thread.sleep(8000);
	WebElement downloadOptGaIcon=driver.findElement(downloadOperatorGapAnalysisIcon);
	act.moveToElement(downloadOptGaIcon).perform();
	System.out.println("performed");
	
	return	eleUtil.getToolTip(downloadOperatorGapAnalysisIcon, "title");
	
	}
	
	public String failedConstraintsIconToolTip()
	{
	//driver.findElement(arrowIcon).click();
	return	eleUtil.getToolTip(failedConstraintsIcon, "title");
	}
	
	public String logEventsIconToolTip()
	{
	//driver.findElement(arrowIcon).click();
	return	eleUtil.getToolTip(logEventsIcon, "title");
	}
	
	public String fullScreenIconToolTip()
	{
	//driver.findElement(arrowIcon).click();
	return	eleUtil.getToolTip(fullScreenIcon, "title");
	}
	
	
	
	
	

}
