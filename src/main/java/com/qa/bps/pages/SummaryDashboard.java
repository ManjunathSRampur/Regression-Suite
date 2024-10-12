package com.qa.bps.pages;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;
import com.qa.bps.utils.ExcelUtil;

public class SummaryDashboard {

	WebDriver driver;
	private By summaryfieldLabel = By.xpath("//div[contains(text(),'SUMMARY')]");
	private By campaignfieldLabel = By.xpath("//div[contains(text(),'Campaigns')]");
	private By batchfieldLabel = By.xpath("//div[contains(text(),'Batch')]");
	private By planTitle = By.xpath("//div[@class=' label-medium']");
	private By planType = By.xpath("//div[contains(text(),'Plan')]");
	private By planVersion = By.xpath("//div[@class='label-small mr-4 pr-4']");
	private By productSelect = By.xpath("//div[@class='selected-list']//span[contains(text(),'Product')]");
	private By searchIcon = By.xpath("//input[@aria-labelledby='searchIcon']");
	private By productDisplay = By
			.xpath("//div[@class='gantt_cell gantt_cell_tree']//div[@class='gantt_tree_content']");
	private By equipTab = By.xpath("//div[contains(text(),'EQUIPMENT')]");
	private By wipInvTab = By.xpath("//div[contains(text(),'WIP INV')]");
	private By plTab = By.xpath("//div[contains(text(),'Production line')]");
	private By reporttab = By.xpath("//div[contains(text(),'REPORT')]");
	private By operatorUtilTab = By.xpath("(//div[contains(text(),'Operator Utilization')])[1]");
	private By equipmentList = By.xpath("//div[@class='gantt_grid_data']//div[@class='equipment-header']");
	private By invList = By.xpath("//div[@data-r='3' and @role='row']//span");
	private By stockList = By.xpath("//div[@data-r='7' and @role='row']");
	private By operatorTeamList = By.xpath("//div[@data-r='7' and @role='row']");
	private By plList = By.xpath("//div[@data-r='7' and @role='row']");
	private By rptTabeField = By.xpath("//td[contains(text(),'Select date range')]");
	private By team = By.xpath("//div[@id='scheduler_here']");
	private By campaignList = By.xpath("//div[@class='gantt_cell gantt_cell_tree']//div[@class='gantt_tree_content']");
	private By firstDay = By.xpath("//input[@type='date'][1]");
	private By lastDay = By.xpath("//input[@type='date'][2]");
	private By Report = By.xpath("(//div[@class='d-flex marginclass'])[8]");

	private By startDate = By.xpath("//input[@id='startDate']");
	private By endDate = By.xpath("//input[@id='endDate']");
	private By typeofReport = By.xpath("(//button[@data-toggle='dropdown'])[1]");
	private By ReportSelected = By.xpath("//a[contains(text(),' Batch Summary Report ')]");
	private By desiredShift = By.xpath("(//button[@data-toggle='dropdown'])[2]");
	private By selectShift = By.xpath("//a[contains(text(),' Day ')]");
	private By download = By.xpath("//a[contains(text(),'Download Report')]");
	private By dropdown = By.xpath("//span[contains(text(),'Product')]");
	private By drop = By.xpath("(//ul[@class='lazyContainer'])[2]");
	private By selected = By.xpath("//div[contains(text(),'ERD')]");
	private By prodFiltersBtnFalse = By.xpath("//button[@aria-expanded='false']");
	private By prodFiltersBtnTrue = By.xpath("//button[@aria-expanded='true']");
	private By newColumnDisplay = By.xpath("//div[@class='d-flex justify-content-between']");
	private By fromdateContainer = By.xpath("(//input[@type='date'])[1]");
	private By todateContainer = By.xpath("(//input[@type='date'])[2]");
	private By resetBtn = By.xpath("//button[contains(text(),'Reset')]");
	private By clearBtn = By.xpath("//a[contains(text(),'Clear Form')]");
	private By dateRangeFrom = By.xpath("//input[@max='null']");
	private By dateRangeTo = By.xpath("//input[@min='null']");
	private By doubleclickProd = By.xpath("(//span[@Title='Trend'])[1]");
	private By highchartsDisplay = By.xpath("(//span[@class='legend-title'])[5]");
	private By closeBtn = By.xpath("//div[@class='cursor-pointer']");
	private By stockTrend = By.xpath("(//span[@Title='Trend'])[1]");
	private By stockchartsDisplay = By.xpath("(//span[@class='legend-title'])[5]");
	private By stockcloseBtn = By.xpath("//div[@class='cursor-pointer']");
	private By productTrend = By.xpath("(//span[@Title='Trend'])[1]");
	private By productchartsDisplay = By.xpath("(//span[@class='legend-title'])[5]");
	private By productcloseBtn = By.xpath("//div[@class='cursor-pointer']");
	private By productDD = By.xpath("//span[contains(text(),'Product')]");
	private By productDDList = By.xpath("(//div[@style='overflow: auto; max-height: 300px;'])//li");
	private By productDDListFromDisplay = By.xpath("(//div[@class='kpi-card-alignment'])[2]/div/div[1]/div");
	private By productDDSelValue = By.xpath("//label[contains(text(),'CMK')]");
	private By noDataAvailable = By.xpath("//div[contains(text(),'No Data available')]");
	private By clearProduct = By.xpath("//span[@class='c-remove clear-all']");
	private By ArrowinFilterBtnExpand = By.xpath("//span[@style='transform: rotate(-180deg);']");
	private By ArrowinFilterBtnCollapse = By.xpath("//span[@style='transform: rotate(0deg);']");
	private By campaignListFromProdTab = By
			.xpath("//div[@class='gantt_cell gantt_cell_tree']//div[@class='gantt_tree_content']");
	private By startDateList = By.xpath("//div[@data-column-name='start_date']/div");
	private By endDateList = By.xpath("//div[@data-column-name='end_date']/div");
	private By managerBreadCrumb = By.xpath("(//li[contains(text(),'Manager')])");
	private By productViewandDelayManagement = By.xpath("(//div[contains(@class,'heading')])[7]");
	private By productoverview = By.xpath("//button[contains(text(),'Product Overview')]");
	private By productoverviewLabels = By.xpath("//div[contains(@class,'label ml-4')]");
	private By campaignValues = By
			.xpath("(//div[@class='kpi-card-alignment'])[3]//div//div[@class='bodhee-kpi-card-value batchtower']");
	private By batchDetails = By
			.xpath("(//div[@class='kpi-card-alignment'])[4]//div//div[@class='bodhee-kpi-card-value batchtower']");
	private By zoomIninProd = By.xpath("(//fa-icon[contains(@class,'fa-icon ng-fa-icon')])[1]");
	private By zoomOUTinProd = By.xpath("(//fa-icon[contains(@class,'fa-icon ng-fa-icon')])[2]");
	private By downloadIconinProd = By.xpath("(//fa-icon[@class='fa-icon ng-fa-icon'])[4]");
	private By dropDownOptions = By.xpath("(//li[@class='pure-checkbox'])[1]//input");
	private By dropDownOptionValidation = By.xpath("(//div[@class='section_name'])[1]");
	private By teamsDropDown = By.xpath("//div[@class='c-btn']");
	List<String> prodnamelist = new ArrayList<String>();
	List<String> batchValuesList = new ArrayList<String>();
	List<String> labelsList = new ArrayList<String>();
	List<WebElement> prodname = new ArrayList<WebElement>();
	List<WebElement> plannedStartDate = new ArrayList<WebElement>();
	List<String> plannedStartDatelist = new ArrayList<String>();

	List<WebElement> plannedEndDate = new ArrayList<WebElement>();
	List<WebElement> campaign_values = new ArrayList<WebElement>();
	List<WebElement> batchDetails_values = new ArrayList<WebElement>();
	List<WebElement> labels = new ArrayList<WebElement>();
	List<String> plannedEndDatelist = new ArrayList<String>();
	boolean campaigndisplay;
	boolean batchdisplay, downloads;
	List<WebElement> checkbox = new ArrayList<WebElement>();
	List<WebElement> productDDvalues = new ArrayList<WebElement>();
	List<String> productList = new ArrayList<String>();
	List<String> productDDListFromDisplayvalues = new ArrayList<String>();
	private ElementUtil eleUtil;
	ExcelUtil eu;

//**********************************************Update Xpath********************************
	private By avlDataInSummaryTab = By.xpath("//div[@class='details']/div/div/div");
	private By productionTab = By.xpath("(//div[.='PRODUCTION '])[1]");
	private By avlDataInProductionTab = By.xpath("//div[@class='gantt_grid_data']/div/div");
	private By equipmentTab = By.xpath("(//div[.='EQUIPMENT '])[1]");
	private By equipmentBuildingData = By.xpath("//div[@class='gantt_tree_content']/div");
	private By equipmentGridData = By.xpath("//div[@class='gantt_task_content']/div");
	private By wIPInVTab = By.xpath("(//div[.='WIP INV '])[2]");
	private By avlDataUnderWIPTab = By.xpath("//div[@class='fm-row']/div/span");
	private By avlDataUnderStockTab = By.xpath("//div[@class='fm-row']/div/span");
	private By avlDataUnderOperatorTab = By.xpath("//div[@class='fm-row']/div/span");
	private By avlDataUnderProductionLineTab = By.xpath("//div[@class='fm-row']/div/span");
	private By operatorTab = By.xpath("(//div[.='OPERATOR '])[2]");
	private By productionLineTab = By.xpath("(//div[.='Production line '])[1]");
	private By stockTab = By.xpath("(//div[.='STOCK '])[2]");
	private By operatorUtilizationInHrsTab = By.xpath("(//div[.='Operator Utilization (In Hours) '])[1]");
	private By weekDataBox = By.xpath("//input[@type='week']");
	private By operatorNames = By.xpath("//div[@class='y_axis_cell']/div");
	private By operatorUtilizationInMinsTab = By.xpath("(//div[.='Operator Utilization (In Mins) '])[2]");

	public SummaryDashboard(WebDriver driver) {
		eleUtil = new ElementUtil(driver);
		this.driver = driver;
	}

//	**********************************Updated Test Case start from here****************************

	public boolean dataAvlUnderSummaryTab() throws InterruptedException {
		List<WebElement> dataAvl = new ArrayList<WebElement>();
		try {
			Thread.sleep(5000);
			dataAvl = driver.findElements(avlDataInSummaryTab);
			int size = dataAvl.size();
			if (size > 0) {
				System.out.println("Data is avaialble ");
				for (WebElement webElement : dataAvl) {
					System.out.println(webElement.getText());
				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Data is not displayed ");
			return false;
		}
	}

	public boolean dataAvlUnderProductionTab() throws InterruptedException {
		List<WebElement> dataAvl = new ArrayList<WebElement>();
		driver.findElement(productionTab).click();
		Thread.sleep(5000);
		try {
			dataAvl = driver.findElements(avlDataInProductionTab);
			int size = dataAvl.size();
			if (size > 0) {
				for (WebElement data : dataAvl) {
					System.out.println(data.getText());
				}
				System.out.println("Data is avaialable ");
				return true;
			} else {
				System.out.println("Data is not avaialable ");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Data is not available ");
			return false;
		}

	}

	public boolean dataAvlUnderEqpTab() throws InterruptedException {
		driver.findElement(equipmentTab).click();
		Thread.sleep(5000);
		List<WebElement> eqBuildingData1 = new ArrayList<WebElement>();
		List<WebElement> equipmentGridData1 = new ArrayList<WebElement>();

		try {
			eqBuildingData1 = driver.findElements(equipmentBuildingData);
			equipmentGridData1 = driver.findElements(equipmentGridData);
			if (eqBuildingData1.size() > 0 && equipmentGridData1.size() > 0) {
				for (WebElement eqpBudData : eqBuildingData1) {
					System.out.println(eqpBudData.getText());
				}
				for (WebElement eqpGridData : equipmentGridData1) {
					System.out.println(eqpGridData.getText());
				}
				System.out.println("Data is avaialable ");
				return true;
			} else {
				System.out.println("Data is not avaialable ");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Data is not available ");
			return false;

		}
	}

	public boolean dataAvlUnderWIPInvTab() throws InterruptedException {
		driver.findElement(wIPInVTab).click();
		Thread.sleep(5000);

		try {
			List<WebElement> dataAvlInWipTab = driver.findElements(avlDataUnderWIPTab);
			int size = dataAvlInWipTab.size();
			if (size > 0) {
				for (WebElement data : dataAvlInWipTab) {
					System.out.println(data.getText());
				}
				System.out.println("Data is avaialable ");
				return true;
			} else {
				System.out.println("Data is not avaialable ");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Data is not avaialable ");
			return false;
		}
	}

	public boolean dataAvlUnderStockTab() throws InterruptedException {
		driver.findElement(stockTab).click();
		Thread.sleep(5000);
		try {
			List<WebElement> dataAvlInStockTab = driver.findElements(avlDataUnderStockTab);
			int size = dataAvlInStockTab.size();
			if (size > 0) {
				for (WebElement data : dataAvlInStockTab) {
					System.out.println(data.getText());
				}
				System.out.println("Data is avaialable ");
				return true;
			} else {
				System.out.println("Data is not avaialable ");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Data is not avaialable ");
			return false;
		}
	}

	public boolean dataAvlUnderOpTab() throws InterruptedException {
		driver.findElement(operatorTab).click();
		Thread.sleep(5000);
		try {
			List<WebElement> dataAvlInOpTab = driver.findElements(avlDataUnderOperatorTab);
			int size = dataAvlInOpTab.size();
			if (size > 0) {
				for (WebElement data : dataAvlInOpTab) {
					System.out.println(data.getText());
				}
				System.out.println("Data is avaialable ");
				return true;
			} else {
				System.out.println("Data is not avaialable ");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Data is not avaialable ");
			return false;
		}

	}

	public boolean dataAvlUnderProductionLineTab() throws InterruptedException {
		driver.findElement(productionLineTab).click();
		Thread.sleep(5000);
		try {
			List<WebElement> dataAvlInproductionLineTab = driver.findElements(avlDataUnderProductionLineTab);
			int size = dataAvlInproductionLineTab.size();
			if (size > 0) {
				for (WebElement data : dataAvlInproductionLineTab) {
					System.out.println(data.getText());
				}
				System.out.println("Data is avaialable ");
				return true;
			} else {
				System.out.println("Data is not avaialable ");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Data is not avaialable ");
			return false;
		}
	}

	public boolean dataAvlUnderOpUtiliIHrsTab() throws InterruptedException {
		driver.findElement(operatorUtilizationInHrsTab).click();
		Thread.sleep(2000);
		driver.findElement(weekDataBox).sendKeys("01002024");
		Thread.sleep(5000);

		try {
			List<WebElement> dataAvlInOperatorUtilizationInhrsTab = driver.findElements(operatorNames);
			int size = dataAvlInOperatorUtilizationInhrsTab.size();
			if (size > 0) {
				for (WebElement data : dataAvlInOperatorUtilizationInhrsTab) {
					System.out.println(data.getText());
				}
				System.out.println("Data is avaialable ");
				return true;
			} else {
				System.out.println("Data is not avaialable ");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Data is not avaialable ");
			return false;
		}

	}

	public boolean dataAvlUnderOpUtilizationInMinsTab() throws InterruptedException {
		driver.findElement(operatorUtilizationInMinsTab).click();

		Thread.sleep(2000);
		driver.findElement(weekDataBox).sendKeys("01002024");
		Thread.sleep(5000);

		try {
			List<WebElement> dataAvlInOperatorUtilizationInhrsTab = driver.findElements(operatorNames);
			int size = dataAvlInOperatorUtilizationInhrsTab.size();
			if (size > 0) {
				for (WebElement data : dataAvlInOperatorUtilizationInhrsTab) {
					System.out.println(data.getText());
				}
				System.out.println("Data is avaialable ");
				return true;
			} else {
				System.out.println("Data is not avaialable ");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Data is not avaialable ");
			return false;
		}
	}

}
