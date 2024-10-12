package com.qa.bps.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.checkerframework.checker.units.qual.Length;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;

public class MapProcess {
	Navigation navigateTo;
	ProductOverview po;

//---------------------------------------------X-path Area Starts Here------------------------------------------------
	private By createProcessmanBtn = By.xpath("//a[contains(text(),'Create Process Map')]");
	private By bodheeLogoBodhee = By.xpath("//img[contains(@src,'bodhee_logo')]");

	private By plantName = By.xpath("(//div[@role='gridcell'])[4]");
	private By nodeEditBtn = By.xpath("//fa-icon[@ng-reflect-title='Edit']");
	private By processNiodeTypeSearchBox = By.xpath("(//input[@id='searchBar'])[1]");
	private By Equipment = By.xpath("//button[.=' Equipment ']");
	private By templateBtn = By.xpath("//button[.=' Template ']");
	private By dragSpace = By.xpath("//div[@class='inner-node']");
	private By NodeNameTextBox = By.xpath("(//input[@id='nodeNameOverlay'])[1]");
	private By saveBtn = By.xpath("(//button[contains(text(),'Save')])[2]");
	private By createToasterSuccess = By.xpath("//div[@role='alertdialog']");
	private By nodeDeleteOptn = By.xpath("//span[.='Delete']");
	private By nodeCloneOption = By.xpath("//span[contains(text(),' Clone')]");
	private By nodeMoveOption = By.xpath("//span[contains(text(),' Move')]");
	private By cloneNodeInputBox = By.xpath("(//input[@id='nodeNameOverlay'])[last()]");

	private By nodeNametextbox = By.xpath("(//input[@id='nodeNameOverlay'])[2]");
	private By cloneBtn = By.xpath("//button[contains(text(),'Clone')]");
	private By restoreOption = By.xpath("//span[.='Restore']");
	private By configureProcessOptn = By.xpath("//span[contains(text(),' Configure Process')]");
	private By MPETab = By.xpath("//a[@title='Multiple Equipments']");
	private By addMPE = By.xpath("(//h3[@class='fa fa-plus'])[1]");
	private By AltEquipmentInput = By.xpath("(//div[@role='gridcell'])[8]");
	private By altEquipSaveBtn = By.xpath("(//button[contains(text(),'Save')])[3]");
	private By popupCoseBtn = By.xpath("//div[@class='row']/a");
	private By clonePopUpCloseBtn = By.xpath("(//button[@id='closeBtn'])[3]");
	private By altEqSelect = By.xpath("(//div[@class='tabulator-edit-select-list']/div)[1]");
	private By selectFourthEq = By.xpath("(//div[@class='tabulator-edit-select-list-item'])[3]");
	private By selectFifthEq = By.xpath("(//div[@class='tabulator-edit-select-list-item'])[4]");
	private By skillTab = By.xpath("//div[@title='Task Skills']");
	private By skillInput = By.xpath("(//ng-select[@id='id2' or @id='id5'])[last()]/div/div");
	private By skillName = By.xpath("(//div[@role='option'])[1]");
	private By saveBtnPopup = By.xpath("(//button[contains(text(),'Save')])[2]");
	private By skillsName = By.xpath("(//span[.='×']/following-sibling::span/parent::div)[last()]");
	private By addedSkil = By.xpath("(//div[@class='tabulator-cell'])[last()-1]");
	private By delThreedot = By.xpath("(//button[@data-toggle='dropdown'])[last()]");
	private By delOptn = By.xpath("//div[@class='tabulator-menu-item']");
	private By taskNode = By.xpath("(//button[contains(text(),' Task ')])[2]");
	private By selectNodeTypeMovenode = By.xpath("(//span[@class='dropdown-btn'])[1]");
	private By selectNodeMovenode = By.xpath("(//span[@class='dropdown-btn'])[2]");
	private By moveNodeLocation = By.xpath("(//div[contains(text(),'Location')])[1]");
	private By moveBtn = By.xpath("//button[contains(text(),'Move')]");
	private By deleteAltertnateEq = By.xpath("(//div[@role='gridcell'])[14]");
	private By deletedAltEq = By.xpath("(//div[@role='gridcell'])[8]");
	private By homeBtn = By.xpath("(//li[@class='breadcrumb-item'])[1]");
	private By uploadBtn = By.xpath("//div[@id='uploadBtn']");
	private By nodeName = By.xpath("(//input[@id='nodeNameOverlay'])[1]");
	private By descriptionField = By.xpath("//input[@id='info']");
	private By nodeTypeTab = By.xpath("//img[@alt='nodeTypeImage']");
	private By newNodeTypeButton = By.xpath("//h6[.='New Node Type']");
	private By nodeTypeTextBox = By.xpath("(//div[@class='row row-margin']/div/input)[1]");
	private By nodeDescriptionTextBox = By.xpath("(//div[@class='row row-margin']/div/input)[2]");
	private By nodeIconDD = By.xpath("//i[@class='fa fa-sort-desc icon fa-2x']");
	private By nodeIconOption = By.xpath("//label[.='Plant']");
	private By updatedNodeIconOp = By.xpath("//label[.='Line']");
	private By nodeSearchBox = By.xpath("//input[@id='searchNodeType']");
	private By createdNode = By.xpath("(//div[@class='card tileCard'])[2]");
	private By selectFeatureEle = By.xpath("//input[@ng-reflect-model='true']/parent::label");
	private By listedFeatureEle = By.xpath("(//nav[@class='nav flex-column nav-pills'])[2]/a");
	private By processBuilderTab = By.xpath("//img[@alt='mapProcessImage']");
	private By createNodeEle = By.xpath("//button[@class='btn my-2 my-sm-0 nodeBtnClass']");
	private By delayCodeGroupEle = By.xpath("//button[.=' Delay Code group ']");
	private By delayCode = By.xpath("//button[.=' Delay Code ']");
	private By processNodeSearchBox = By.xpath("//input[@placeholder='Process Nodes']");
	private By deleteBtn = By.xpath("(//button[.='Delete'])[1]");
	private By deleteConfrInputBox = By.xpath("(//div[@class='col-sm-12']/input)[2]");
	private By confrmDeleteBtn = By.xpath("(//button[.='Delete'])[last()]");
	private By propertyFeatureCheckBox = By.xpath("(//label[@class='custom-check-box'])[1]");
	private By propertyTab = By.xpath("//a[@id='v-pills-properties-tab']");
	private By addFeatureButton = By.xpath("(//fa-icon[@ng-reflect-icon='fas,plus-circle'])[1]");
	private By propertyName = By.xpath("(//div[contains(@class,'tabulator-cell')])[2]");
	private By propertyNameInputBox = By.xpath("(//div[@tabulator-field='name'])[2]/input");
	private By propertyDesc = By.xpath("(//div[@tabulator-field='description'])[2]");
	private By orderSequence = By.xpath("(//div[@tabulator-field='order_seq'])[2]");
	private By dataTypeDD = By.xpath("(//div[@tabulator-field='dataType'])[2]");
	private By textDataType = By.xpath("//select/option[.='Text' or .='text']");
	private By integerDataType = By.xpath("//select/option[.='Integer']");
	private By floatDataType = By.xpath("//select/option[.='Float']");
	private By addedProperty = By.xpath("//div[@tabindex='0']/div/div");
	private By addedPropertyInNode = By.xpath("//div[@formarrayname='attributeArr']");
	private By propertyThreeDot = By.xpath("//button[@data-toggle='dropdown']");
	private By deleteOption = By.xpath("//div[@class='tabulator-menu-item']");
	private By deleteNodeBtn = By.xpath("//button[.=' Delete ']");
	private By taskNodeEle = By.xpath("//h6[@title='Task']");
	private By avlAtrributeEle = By.xpath("//div[@formarrayname='attributeArr']");
	private By resourceTabgridEle = By.xpath("(//div[@class='gantt_scale_line'])[3]/div");
	private By taskNodeType = By.xpath("//button[.=' Task ']");
	private By taskGroupNodeType = By.xpath("//button[.=' Task Group ']");
	private By selectEquipmentDD = By.xpath("(//div[.='Select Equipment'])[1]");
	private By selectFirstEq = By.xpath("(//div[@role='option'])[1]");
	private By selectSecEq = By.xpath("(//div[@role='option'])[2]");
	private By configuredEq = By.xpath("(//div[@tabulator-field='equipment_name'])[2]");
	private By alterEqSequence = By.xpath("//div[@tabulator-field='equipment_name']");
	private By plantNameEle = By.xpath("(//li[@class='breadcrumb-item'])[4]");
	private By changeAltEqConfirmBtn = By.xpath("(//button[contains(text(),'Confirm')])[last()]");
	private By orderSequenceColumn = By.xpath("(//div[@tabulator-field='order_seq'])[1]");
	private By addedPropertyList = By.xpath("//div[@tabulator-field='name' and @role='gridcell']");
	private By displayedPropList = By.xpath("//div[@formarrayname='attributeArr']/div/div/label");
	private By simplifiedScreenToggle = By.xpath("//div[contains(@class,'mat-slide-toggle-bar mat-slide-toggle')]");
	private By linkagesEle = By.xpath("//*[name()='svg' and @position='absolute']/*[name()='path']");
	private By homeIcon = By.xpath("//fa-icon[@ng-reflect-icon='fas,home']");
	private By linkagesTab = By.xpath("//a[@id='v-pills-node-linkage-tab']");
	private By nodeLinkageAddButton = By.xpath("//label[.='NODE TYPE LINKAGE']/parent::div/fa-icon");
	private By featureName = By.xpath("//input[@id='featureName']");
	private By featureDescription = By.xpath("//input[@id='featureDesc']");
	private By selectNodeTypeDropDown = By.xpath("(//div[.='Select Node Type..'])[last()]/parent::div");
	private By selectLocation = By.xpath("(//div[@role='option'])[1]");
	private By saveLinkageButton = By.xpath("//button[.='Save Linkage']");
	private By addedLinkageEle = By.xpath("//div[@title=\"TestFeature'\"]");
	private By createProcessMap = By.xpath("//a[.='Create Process Map']");
	private By firstProcessType = By.xpath("(//div[@role='option'])[1]");
	private By processTypeInputBox = By.xpath("(//div[@class='ng-input']/input)[1]");
	private By processNameTextBox = By.xpath("//input[@name='process']");
	private By locationDropDown = By.xpath("(//div[@class='ng-input']/input)[2]");
	private By locationValue = By.xpath("//div[@role='option']");
	private By createdButton = By.xpath("//button[.='Create']");
	private By propertyEle = By.xpath("//input[@placeholder='Enter Abbreviation']");
	private By eleToSaveNodeInProcessTab = By.xpath("//fa-icon[@ng-reflect-title='Save']");
	private By elementToNavigateParentNode = By.xpath("(//li[@class='breadcrumb-item'])[last()-1]");
	private By clonedChilderCheckMark = By.xpath("//input[@id='children']/following-sibling::span");
	private By nodeNameEle;
	private By CreatedEqName;
//---------------------------------------------X-path Area Ends Here------------------------------------------------

//------------------------------------------------String Area Starts Here--------------	
	String EqName = "Automation EQ";
	String createToaster;
	String deleteToaster;
	String duplicateToaster;
	String CloneExistingErrortaoster;
	String cloneNodeToaster = "null";
	String altEqToaster;
	String skillAddToaster = "null";
	String deleteSkilToaster = "null";
	String moveNodeToaster;
	String deleteAltEqToaster;
	String altEqName;
	String MPEName;
	String changeEquipmentToaster = "null";
	String nodeTypeName = "Test_node";
	String newNodeType = "Automation";
	String delayCodeGroupValue = "AutomationDCG";
	String delayCodeValue = "AutomationDC";
	String propertyNames = "Automation";
	String processName = "null";
	String taskNodeName = "null";
	String taskGroupNodeName = "null";
	List<WebElement> attributeCount = new ArrayList<WebElement>();

	// ------------------------------------------------String Area Ends
	// Here--------------
	// Constructor
	WebDriver driver;
	public String templateName;

	public MapProcess(WebDriver driver) {
		this.driver = driver;
		po = new ProductOverview(driver);
	}

//-------------------------------------------------Method Area Starts Here---------------------------------------------	
	public boolean NavigateToMapProcess() throws InterruptedException {
		EventProperties.productNameInBodhee = By.xpath("//p[.='" + EventProperties.productName + "']/parent::div");
		EventProperties.TgNameInBodhee = By.xpath("//p[.='" + EventProperties.firstTaskGroupName + "']/parent::div");
		EventProperties.TaskNameInBodhee = By.xpath("//p[.='" + navigateTo.firstTaskNames + "']");
		EventProperties.moveNodeLocation = By.xpath("//div[contains(text(),'" + EventProperties.SiteName + "')]");
		EventProperties.baseLocation = By.xpath("//li[.='" + EventProperties.SiteName + "']");
		System.out.println("Product xpath is :" + EventProperties.productNameInBodhee);
		System.out.println("Task Group xpath is :" + EventProperties.TgNameInBodhee);
		System.out.println("Task Xpath is :" + EventProperties.TaskNameInBodhee);
		System.out.println("Move node location xpath :" + EventProperties.moveNodeLocation);

		navigateTo = new Navigation(driver);

		driver.navigate().refresh();
		Thread.sleep(6000);

		navigateTo.MapProcess();
		Thread.sleep(2000);
		if (driver.findElement(createProcessmanBtn).isDisplayed()) {
			System.out.println("Navigation success");
			return true;

		} else
			return false;
	}

	public boolean CreateProcessMapBtnAvailable() throws InterruptedException {

		Thread.sleep(1000);
		try {
			driver.findElement(createProcessmanBtn).isDisplayed();
			System.out.println("createProcessmanBtn is Displayed");
			return true;
		} catch (Exception e) {
			System.out.println("createProcessmanBtn is not Displayed");
			return false;
		}
	}

	public boolean PlantNameisDisplayed() {
		String siteName = driver.findElement(plantName).getText();

		if (siteName.equals(EventProperties.SiteName)) {
			return true;
		} else
			System.out
					.println("Expected Site name= " + EventProperties.SiteName + " but found site name is " + siteName);
		return false;
	}

	public boolean navigateToSite() throws InterruptedException {
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		if (driver.findElement(EventProperties.APUXpath).isDisplayed()) {
			return true;
		} else
			return false;

	}

	public boolean createAnewNode() throws InterruptedException {
		String randomText = RandomStringUtils.randomAlphabetic(3);
		EqName = EqName + randomText;
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("E");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("q");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(Equipment), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(6000);
		driver.findElement(NodeNameTextBox).clear();
		driver.findElement(NodeNameTextBox).sendKeys(EqName);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		CreatedEqName = By.xpath("//p[contains(text(),'" + EqName + "')]");
		String x = driver.findElement(CreatedEqName).getText();
		try {
			createToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			createToaster = "null";
		}
		if (x.equals(EqName)) {
			return true;
		} else
			return false;

	}

	public boolean toasterPostNodeCreate() {
		if (createToaster.equals(EqName + " created successfully!")) {
			return true;
		} else
			System.out.println("Toaster message is wrong post node creation.... Please check the toaster message!");
		return false;
	}

	public boolean userShouldNotcreateAduplicateNode() throws InterruptedException {
		Thread.sleep(4000);
		Actions action = new Actions(driver);

		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).clear();
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("E");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("q");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(4000);
		action.clickAndHold(driver.findElement(Equipment)).pause(Duration.ofSeconds(3)).moveByOffset(260, 0).release()
				.build().perform();
		Thread.sleep(7000);
		driver.findElement(NodeNameTextBox).clear();
		driver.findElement(NodeNameTextBox).sendKeys(EqName);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		try {
			duplicateToaster = driver.findElement(createToasterSuccess).getText();

		} catch (Exception e) {
			duplicateToaster = "null";
			System.out.println("No Toaster displayed");
		}
		String x = driver.findElement(CreatedEqName).getText();
		List<WebElement> a = driver.findElements(CreatedEqName);
		int siZe = a.size();

		if (siZe > 1) {
			return false;
		} else
			return true;
	}

	public boolean Duplicatetoasterdisplayed() {
		System.out.println("Toaster message while creating duplicated node " + duplicateToaster);
		if (duplicateToaster.equals("Node Already Exist!")) {
			return true;
		} else
			return false;
	}

	public boolean deleteCreatedNode() throws InterruptedException {
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(CreatedEqName)).perform();
		Thread.sleep(2000);
		driver.findElement(nodeDeleteOptn).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		try {
			deleteToaster = driver.findElement(createToasterSuccess).getText();
			action.contextClick(driver.findElement(CreatedEqName)).perform();
			Thread.sleep(2000);
			driver.findElement(restoreOption).isDisplayed();
			return true;
		}

		catch (Exception e) {
			deleteToaster = "null";
			return false;
		}
	}

	public boolean deleteToasterIsDisplayed() {
		if (deleteToaster.equals(EqName + " deleted successfully")) {
			return true;
		} else
			return false;
	}

	public boolean cloneNodewithExistingName() throws InterruptedException {
		CreatedEqName = By.xpath("//p[.='" + EqName + "2']");
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).clear();
		driver.findElement(processNiodeTypeSearchBox).sendKeys("E");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("q");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(4000);
		action.clickAndHold(driver.findElement(Equipment)).pause(Duration.ofSeconds(3)).moveByOffset(700, 0).release()
				.build().perform();
		System.out.println("equipment node is draged ");
		Thread.sleep(4000);
		driver.findElement(NodeNameTextBox).clear();
		System.out.println("node name removed ");
		Thread.sleep(2000);
		driver.findElement(NodeNameTextBox).sendKeys(EqName + "2");
		System.out.println("new node name added ");
		driver.findElement(saveBtn).click();
		System.out.println("save button clicked ");
		Thread.sleep(2000);
		action.contextClick(driver.findElement(CreatedEqName)).perform();
		System.out.println("write clicked on  created node ");
		Thread.sleep(2000);
		driver.findElement(nodeCloneOption).click();
		System.out.println("clicked on clone node option ");
		Thread.sleep(2000);
		driver.findElement(nodeNametextbox).clear();
		System.out.println("existing node name removed ");
		Thread.sleep(1000);
		driver.findElement(nodeNametextbox).sendKeys(EqName + "2");
		System.out.println("same node name added ");
		driver.findElement(cloneBtn).click();
		System.out.println("clone button added ");
		Thread.sleep(2000);
		try {
			CloneExistingErrortaoster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			CloneExistingErrortaoster = "null";
		}

		List<WebElement> a = driver.findElements(CreatedEqName);
		int siZe = a.size();
		System.out.println("Size is " + siZe);
		if (siZe > 1) {
			return false;
		} else {
			return true;
		}

	}

	public boolean DuplicateCloneToaster() {

		try {
			driver.findElement(clonePopUpCloseBtn).click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		if (CloneExistingErrortaoster.equals("Node already exists")) {
			return true;
		}

		else
			return false;
	}

	public boolean CreateNodeWithbegginingSpace() throws InterruptedException {

		Thread.sleep(4000);
		Actions action = new Actions(driver);

		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).clear();
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("E");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("q");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(4000);
		action.clickAndHold(driver.findElement(Equipment)).pause(Duration.ofSeconds(3)).moveByOffset(280, 0).release()
				.build().perform();
		Thread.sleep(5000);
		driver.findElement(NodeNameTextBox).clear();
		driver.findElement(NodeNameTextBox).sendKeys("    Eq");
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		boolean b = true;
		try {
			String nodenameWithSpace = driver.findElement(createToasterSuccess).getText();
			System.out.println(nodenameWithSpace);
			if (nodenameWithSpace.equals("Eq created successfully!")) {
				b = false;
			}

		} catch (Exception e) {

			System.out.println("No Toaster displayed");
			b = true;
		}
		return b;

	}

	public boolean cloneNode() throws InterruptedException {
		try {
			driver.navigate().refresh();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		String randomText = RandomStringUtils.randomAlphabetic(3);
		EqName = EqName + randomText;
		Actions action = new Actions(driver);
		CreatedEqName = By.xpath("//p[contains(text(),'" + EqName + "')]");

		driver.findElement(processNiodeTypeSearchBox).clear();

		Thread.sleep(4000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("E");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("q");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(Equipment), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(3000);
		driver.findElement(NodeNameTextBox).clear();
		driver.findElement(NodeNameTextBox).sendKeys(EqName);
		driver.findElement(saveBtn).click();
		Thread.sleep(4000);
		action.contextClick(driver.findElement(CreatedEqName)).perform();
		driver.findElement(nodeCloneOption).click();
		Thread.sleep(2000);

		driver.findElement(cloneBtn).click();
		Thread.sleep(2000);
		cloneNodeToaster = driver.findElement(createToasterSuccess).getText();
		By clonedNodeName = By.xpath("//p[contains(text(),'" + EqName + "_copy" + "')]");
		try {
			driver.findElement(clonedNodeName).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean cloneNodeToaster() {
		if (cloneNodeToaster.equals("Clonned Successfully")) {
			return true;

		} else
			System.out.println(cloneNodeToaster);
		return false;
	}

	public boolean configAlterEq() throws InterruptedException {
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.ProcessflowNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.productNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.TgNameInBodhee)).perform();
		Thread.sleep(3000);
		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(MPETab).click();
		Thread.sleep(2000);
		driver.findElement(addMPE).click();
		Thread.sleep(1000);

//		driver.findElement(AltEquipmentInput).sendKeys("EQ");
		driver.findElement(AltEquipmentInput).click();
		Thread.sleep(2000);
		altEqName = driver.findElement(altEqSelect).getText();
		driver.findElement(altEqSelect).click();
		Thread.sleep(2000);
		driver.findElement(altEquipSaveBtn).click();
		Thread.sleep(2000);
		try {
			altEqToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			altEqToaster = "null";
		}
		driver.findElement(popupCoseBtn).click();
		Thread.sleep(2000);

		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(MPETab).click();
		Thread.sleep(2000);
		MPEName = "null";
		try {
			MPEName = driver.findElement(AltEquipmentInput).getText();
		} catch (Exception e) {

		}

		if (MPEName.equals(altEqName)) {
			return true;
		} else
			return false;

	}

	public boolean alternateEqToaster() {
		System.out.println(altEqToaster);
		if (altEqToaster.equals("Configuration Mapped Successfully")) {
			return true;
		} else
			return false;

	}

	// ------------------------integration check in IMP for Alternate
	// Equipment----------
	public boolean alternateEquipmentavailableinproductOvrView() throws InterruptedException, IOException {

		Actions action = new Actions(driver);
		Thread.sleep(2000);
		driver.findElement(popupCoseBtn).click();
		Thread.sleep(2000);
		driver.findElement(homeBtn).click();
		Thread.sleep(2000);
		navigateTo = new Navigation(driver);
		po = new ProductOverview(driver);

		System.out.println("Navigated to product overview");
		Thread.sleep(4000);
		navigateTo.LattestPublishedPlan();
		String productName = navigateTo.GetProductDetailsFromPlanner();
		po.getProductDetails(productName);
		navigateTo.productOverview();
		po.preReq();
		System.out.println("Pre Req pass");
		Thread.sleep(4000);
		driver.findElement(po.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		driver.findElement(po.startDD).click();
		Thread.sleep(1000);
		driver.findElement(po.changeAllocatedEqOp).click();
		Thread.sleep(2000);
		System.out.println("Change allocated equipment clicked in start option");

		driver.findElement(changeAltEqConfirmBtn).click();
		Thread.sleep(2000);

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(po.chooseAltEq));
//		driver.findElement(po.chooseAltEq).click();
//		Thread.sleep(4000);

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(po.chooseAltEq)).click().perform();

		Thread.sleep(4000);
		System.out.println("alternate equipment selected ");
		String AltEqName = "null";
		try {
			AltEqName = driver.findElement(po.alternateEqList).getText();
		} catch (Exception e) {

		}
		Thread.sleep(2000);
		System.out.println(AltEqName + " Is the AlterEq");
		Thread.sleep(2000);
		System.out.println(MPEName + " Is the MPE");
		if (MPEName.equals(AltEqName)) {
			return true;
		} else
			return false;

	}

	public boolean changeAlternateEq() throws InterruptedException {
		driver.findElement(po.alternateEqList).click();
		Thread.sleep(1000);
		driver.findElement(po.changeEquipment).click();
		Thread.sleep(2000);
		try {
			changeEquipmentToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {

		}
		System.out.println(changeEquipmentToaster);
		Thread.sleep(4000);
		String equip = driver.findElement(po.equipmentNameOnFirstTask).getText();
		String[] a = equip.split("-");
		String b = a[a.length - 1];
		System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3]);
		System.out.println(b);
		String eqNameInpov = "Eq" + " " + b;
		System.out.println(eqNameInpov);
		Thread.sleep(2000);
		if (MPEName.equals(eqNameInpov)) {
			return true;
		}

		else
			return false;

	}

	public boolean toasterOnChangeEquipment() {
		if (changeEquipmentToaster.equals("Assigned asset updated Successfully")) {
			return true;
		} else
			return false;
	}

	public boolean startTaskWithAlternateEquipment() throws InterruptedException {
		driver.findElement(po.startDD).click();
		Thread.sleep(1000);
		driver.findElement(po.startOp).click();
		Thread.sleep(1000);
		driver.findElement(po.startButton).click();
		Thread.sleep(7000);
		String status = driver.findElement(po.taskStatusInPov).getText();
		System.out.println(status);
		Thread.sleep(2000);
		if (status.equals("In-progress")) {
			return true;
		} else
			return false;
	}

	// ***********************************************************

	public boolean deleteAlternateEqFromTask() throws InterruptedException {

		navigateTo.MapProcess();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(2000);
		action.doubleClick(driver.findElement(EventProperties.ProcessflowNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.productNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.TgNameInBodhee)).perform();
		Thread.sleep(3000);
		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(MPETab).click();
		Thread.sleep(2000);

		driver.findElement(popupCoseBtn).click();
		Thread.sleep(3000);

		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(MPETab).click();
		Thread.sleep(2000);
		driver.findElement(deleteAltertnateEq).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		deleteAltEqToaster = driver.findElement(createToasterSuccess).getText();
		driver.findElement(altEquipSaveBtn).click();
		Thread.sleep(2000);
		driver.findElement(popupCoseBtn).click();
		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(MPETab).click();
		Thread.sleep(2000);
		// Data Deleted Successfully
		boolean b = false;
		try {
			driver.findElement(deletedAltEq).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;

		}
		return b;

	}

	public boolean AlternateEquipmentDelteToaster() {
		if (deleteAltEqToaster.equals("Data Deleted Successfully")) {
			return true;
		} else
			return false;
	}

	public boolean AddSkillInTaskLevel() throws InterruptedException {
		Actions action = new Actions(driver);

		driver.findElement(popupCoseBtn).click();
		Thread.sleep(2000);
		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(skillTab).click();
		Thread.sleep(8000);
		driver.findElement(skillInput).click();
		Thread.sleep(2000);
		driver.findElement(skillName).click();
		Thread.sleep(2000);
		driver.findElement(saveBtnPopup).click();
		Thread.sleep(1500);
		try {
			skillAddToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			skillAddToaster = "null";
		}
		Thread.sleep(4000);

		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(skillTab).click();
		Thread.sleep(2000);

		String addedSkillEle = driver.findElement(skillsName).getText().replace("×", "");
		System.out.println("added equipment " + addedSkillEle);
		String displayedSkill = driver.findElement(addedSkil).getText();
		System.out.println("displayed skill is " + displayedSkill);

		if (addedSkillEle.equalsIgnoreCase(displayedSkill)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyToasterMsgOfAddSkillTest() {
		if (skillAddToaster.equals("Skill added successfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteSkillFromTask() throws InterruptedException {
		driver.findElement(delThreedot).click();
		Thread.sleep(1000);
		driver.findElement(delOptn).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnPopup).click();
		Thread.sleep(2000);
		try {
			deleteSkilToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			deleteSkilToaster = "null";
		}
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(skillTab).click();
		Thread.sleep(1000);
		boolean b = false;
		try {
			driver.findElement(addedSkil).isDisplayed();
			b = false;
		} catch (Exception e) {
			b = true;
		}
		return b;

	}

	public boolean toasteronDeleteSkill() {
		if (deleteSkilToaster.equals("Skill Deleted Successfully")) {
			return true;
		} else
			return false;
	}

	public boolean moveNode() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(7000);
		try {
			driver.findElement(popupCoseBtn).click();
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		driver.findElement(processNiodeTypeSearchBox).sendKeys("t");
		Thread.sleep(1000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("a");
		Thread.sleep(1000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("s");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(4000);

		String random = RandomStringUtils.randomAlphabetic(2);
		random = "TestTask" + random;
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(taskNode), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(NodeNameTextBox).clear();
		driver.findElement(NodeNameTextBox).sendKeys(random);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		action.contextClick(driver.findElement(By.xpath("//div[@title='" + random + "']"))).perform();
		Thread.sleep(2000);
		driver.findElement(nodeMoveOption).click();
		Thread.sleep(2000);
		driver.findElement(selectNodeTypeMovenode).click();
		Thread.sleep(2000);
		driver.findElement(moveNodeLocation).click();
		Thread.sleep(3000);
		driver.findElement(selectNodeMovenode).click();
		Thread.sleep(3000);
		driver.findElement(EventProperties.moveNodeLocation).click();
		Thread.sleep(3000);
		driver.findElement(moveBtn).click();
		Thread.sleep(2000);
		moveNodeToaster = driver.findElement(createToasterSuccess).getText();
		Thread.sleep(5000);
		driver.findElement(EventProperties.baseLocation).click();
		Thread.sleep(5000);
		boolean b = true;
		try {
			driver.findElement(By.xpath("//div[@title='" + random + "']")).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}

		return b;

	}

	public boolean moveNodeToaster() throws InterruptedException {
		Thread.sleep(7000);
		System.out.println("Moved Node Toaster message " + moveNodeToaster);
		if (moveNodeToaster.equals(" The node is moved successfully! ")) {
			return true;
		} else
			return false;
	}

	public boolean verifyDoubleClickFunTest() throws InterruptedException {

		try {
			driver.findElement(bodheeLogoBodhee).click();
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		Thread.sleep(5000);
		navigateTo.MapProcess();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(5000);
		try {
			driver.findElement(uploadBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanCreateTemplateNodeTest() throws InterruptedException {
		Thread.sleep(3000);
		String rdTxt = RandomStringUtils.randomAlphabetic(3);
		templateName = "Template" + rdTxt;
		System.out.println("Template name is " + templateName);

		try {
			driver.findElement(bodheeLogoBodhee).click();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(9000);
		navigateTo.MapProcess();
		Thread.sleep(7000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("template");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(templateBtn), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(nodeName).clear();
		Thread.sleep(1000);
		driver.findElement(nodeName).sendKeys(templateName);
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase(templateName + "createdsuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanEditTemplateNodeTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		actions.contextClick(driver.findElement(By.xpath("//p[.='" + templateName + "']"))).perform();
		Thread.sleep(3000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(descriptionField).sendKeys("update");
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase(templateName + "createdsuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteTemplateNodeTest() throws InterruptedException {
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.contextClick(driver.findElement(By.xpath("//p[.='" + templateName + "']"))).perform();
		Thread.sleep(2000);
		driver.findElement(nodeDeleteOptn).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase("Nodestatusupdatedsuccessfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanNavigateToNodeTypeTabTest() throws InterruptedException {
		Thread.sleep(3000);
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(9000);
		try {
			driver.findElement(bodheeLogoBodhee).click();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(9000);
		navigateTo.MapProcess();
		Thread.sleep(3000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(1000);
		try {
			driver.findElement(newNodeTypeButton).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanCreateNewNodeTypeTest() throws InterruptedException {
		nodeTypeName = nodeTypeName + RandomStringUtils.randomAlphabetic(4);
		System.out.println("Created Node name " + nodeTypeName);
		driver.findElement(newNodeTypeButton).click();
		Thread.sleep(500);
		driver.findElement(nodeTypeTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeDescriptionTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeIconDD).click();
		driver.findElement(nodeIconOption).click();
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals(nodeTypeName + " added Successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanEditNodeNameTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		nodeTypeName = nodeTypeName + "update";
		System.out.println("updated node name" + nodeTypeName);
		driver.findElement(createdNode).click();
		driver.findElement(nodeTypeTextBox).clear();
		driver.findElement(nodeTypeTextBox).sendKeys(nodeTypeName);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals(nodeTypeName + " updated Successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanEditNodeDescriptionTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		driver.findElement(nodeDescriptionTextBox).clear();
		driver.findElement(nodeDescriptionTextBox).sendKeys(nodeTypeName + "update");
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals(nodeTypeName + " updated Successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanChangeTheNodeIconTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		Thread.sleep(4000);
		driver.findElement(nodeIconDD).click();
		Thread.sleep(2000);
		driver.findElement(updatedNodeIconOp).click();
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals(nodeTypeName + " updated Successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifySelectedFeatureAndListedFeatureCountTest() throws InterruptedException {
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		Thread.sleep(3000);
		List<WebElement> selectedFeature = driver.findElements(selectFeatureEle);
		System.out.println("selected feature " + selectedFeature.size());
		List<WebElement> listedFeature = driver.findElements(listedFeatureEle);
		System.out.println("listed feature " + listedFeature.size());
		if (selectedFeature.size() == listedFeature.size()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAvlOfCreatedNodeTypeInProcessBuilderTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		try {
			driver.findElement(createNodeEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanCreateANodeOfCreatedNodeTypeTest() throws InterruptedException {
		newNodeType = newNodeType + RandomStringUtils.randomAlphabetic(4);
		driver.findElement(processNiodeTypeSearchBox).clear();
		Thread.sleep(1000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(createNodeEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(nodeName).clear();
		Thread.sleep(1000);
		driver.findElement(nodeName).sendKeys(newNodeType);
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase(newNodeType + "createdsuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanEditANodeOfCreatedNodeTypeTest() throws InterruptedException {
		nodeNameEle = By.xpath("//button[.=' " + newNodeType + " ']");
		Thread.sleep(2000);
		driver.findElement(processNodeSearchBox).sendKeys(newNodeType);
		driver.findElement(processNodeSearchBox).click();
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(nodeNameEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(nodeName).clear();
		Thread.sleep(1000);
		newNodeType = newNodeType + "update";
		driver.findElement(nodeName).sendKeys(newNodeType);
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase(newNodeType + "createdsuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteANodeOfCreatedNodeTypeTest() throws InterruptedException {
		Thread.sleep(4000);
		nodeNameEle = By.xpath("//button[.=' " + newNodeType + " ']");
		Thread.sleep(2000);
		driver.findElement(processNodeSearchBox).clear();
		driver.findElement(processNodeSearchBox).sendKeys(newNodeType);
		driver.findElement(processNodeSearchBox).click();
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(nodeNameEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(6000);
		driver.findElement(deleteBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(deleteConfrInputBox).click();
		System.out.println("clicked on input box ");
		driver.findElement(deleteConfrInputBox).sendKeys(newNodeType);
		Thread.sleep(1000);
		driver.findElement(confrmDeleteBtn).click();
		Thread.sleep(1500);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase(newNodeType + "deletedsuccessfully")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanRemoveAllSelectedFeatureTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		Thread.sleep(3000);
		List<WebElement> selectedFeature = driver.findElements(selectFeatureEle);
		System.out.println("selected feature " + selectedFeature.size());
		for (WebElement deselect : selectedFeature) {
			deselect.click();
			Thread.sleep(500);
		}
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		String tstrMsg;
		Thread.sleep(1500);
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase(newNodeType + "updatedSuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyListedFeatureCountAfterRemovingAllFeatureTest() throws InterruptedException {
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		Thread.sleep(3000);
		List<WebElement> listedFeature = driver.findElements(listedFeatureEle);
		System.out.println("listed feature " + listedFeature.size());
		if (0 == listedFeature.size() - 3) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyFeatureLisInNodeOfNewNodeTypeTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		ac.dragAndDrop(driver.findElement(createNodeEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		List<WebElement> hidenEle = driver.findElements(listedFeatureEle);
		int i = 0;
		int j = 0;
		for (WebElement featureTab : hidenEle) {
			try {
				featureTab.click();
				j++;
			} catch (Exception e) {
				i++;
			}
		}
		System.out.println("element not clickable " + i);
		System.out.println("element clickable " + j);
		if (j - 1 == 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanAddThePropertiesFeatureInNodeTypeTest() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(7000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(propertyFeatureCheckBox).click();
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		try {
			driver.findElement(propertyTab).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanAddThePropertyToCreatedNodeTypeTest() throws InterruptedException {
		propertyNames = propertyNames + RandomStringUtils.randomAlphabetic(4);
		driver.navigate().refresh();
		Thread.sleep(7000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		Thread.sleep(3000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		driver.findElement(addFeatureButton).click();
		driver.findElement(propertyName).sendKeys(propertyNames);
		driver.findElement(propertyDesc).sendKeys(propertyNames);
		driver.findElement(dataTypeDD).click();
		driver.findElement(dataTypeDD).click();
		Thread.sleep(2000);
		driver.findElement(textDataType).click();
		Thread.sleep(1000);

		driver.findElement(orderSequence).sendKeys("01");
		driver.findElement(saveBtn).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		driver.findElement(propertyTab).click();
		try {
			driver.findElement(addedProperty).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAddedPropertyAvlInCreatedNodeTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		ac.dragAndDrop(driver.findElement(createNodeEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		try {
			driver.findElement(addedPropertyInNode).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanEditTheAddedPropertyTest() throws InterruptedException {
		propertyNames = propertyNames + "Update";
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(7000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		Thread.sleep(4000);
		driver.findElement(propertyTab).click();
		Thread.sleep(3000);

		driver.findElement(propertyName).click();
		Thread.sleep(2000);
		driver.findElement(propertyNameInputBox).clear();
		Thread.sleep(1000);
		driver.findElement(propertyName).click();
		Thread.sleep(1000);
		driver.findElement(propertyNameInputBox).sendKeys(propertyNames);
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(4000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		driver.findElement(propertyTab).click();
		Thread.sleep(2000);
		String editedPropertyName = "null";
		try {
			editedPropertyName = driver.findElement(propertyName).getText();
		} catch (Exception e) {

		}
		if (editedPropertyName.equals(propertyNames)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanDeleteTheAddedPropertyTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		Thread.sleep(4000);
		driver.findElement(propertyTab).click();
		Thread.sleep(3000);
		driver.findElement(propertyThreeDot).click();
		Thread.sleep(1000);
		driver.findElement(deleteOption).click();
		driver.findElement(saveBtn).click();
		Thread.sleep(4000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		driver.findElement(propertyTab).click();
		Thread.sleep(2000);
		try {
			driver.findElement(propertyName).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyTheAvlOfDeletedPropertyInNodeTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		ac.dragAndDrop(driver.findElement(createNodeEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		try {
			driver.findElement(addedPropertyInNode).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyUserCanDeleteTheCreatedNodeTypeTest() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(9000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		driver.findElement(createdNode).click();
		Thread.sleep(4000);
		driver.findElement(deleteNodeBtn).click();
		Thread.sleep(1000);
		driver.findElement(deleteBtn).click();
		Thread.sleep(1000);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase(nodeTypeName + "DeletedSuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAvlOfDeletedNodeInNodeTypeTabTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(1000);
		try {
			driver.findElement(createdNode).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyAvlOfDeleteNodeTypeInProcessBuilderTest() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(4000);
		try {
			driver.findElement(createNodeEle).click();
			System.out.println("is available ");
			return false;
		} catch (Exception e) {
			System.out.println("is not available");
			return true;
		}

	}

	public boolean verifyUserIsAbleToAddNewPropertiesToTaskNodeTest() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(8000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(5000);
		driver.findElement(nodeSearchBox).clear();
		Thread.sleep(2000);
		driver.findElement(nodeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(taskNodeEle).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		driver.findElement(addFeatureButton).click();
		Thread.sleep(2000);
		driver.findElement(propertyName).sendKeys(propertyNames);
		driver.findElement(propertyDesc).sendKeys(propertyNames);
		driver.findElement(dataTypeDD).click();
		driver.findElement(dataTypeDD).click();
		Thread.sleep(2000);
		driver.findElement(textDataType).click();
		Thread.sleep(1000);
		driver.findElement(orderSequence).click();
		Thread.sleep(1000);
		driver.findElement(orderSequence).sendKeys("05");
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(taskNodeEle).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("(//div[@title='" + propertyNames + "'])[1]")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyAddedPropertyAvlInTaskNodesTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);

		action.doubleClick(driver.findElement(EventProperties.ProcessflowNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.productNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.TgNameInBodhee)).perform();
		Thread.sleep(3000);
		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//label[@title='" + propertyNames + "']")).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanEditTheTaskNodePropertyTest() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(7000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(taskNodeEle).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@title='" + propertyNames + "'])[1]")).click();
		driver.findElement(By.xpath("(//div[@title='" + propertyNames + "'])[1]/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("((//div[@title='" + propertyNames + "'])/parent::div/div)[2]")).click();
		propertyNames = propertyNames + "edit";

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@tabulator-field='name'])/input")).sendKeys(propertyNames);
		driver.findElement(saveBtn).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(taskNodeEle).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(4000);
		try {
			driver.findElement(By.xpath("(//div[@title='" + propertyNames + "'])[1]")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean editFeatureAvlInTaskNodeTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);

		action.doubleClick(driver.findElement(EventProperties.ProcessflowNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.productNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.TgNameInBodhee)).perform();
		Thread.sleep(3000);
		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//label[@title='" + propertyNames + "']")).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserCanDeleteTheaddedFeatureFromTaskNodeTest() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(7000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(taskNodeEle).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@title='" + propertyNames + "']/following-sibling::div/button")).click();
		Thread.sleep(2000);
		driver.findElement(deleteOption).click();
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(taskNodeEle).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(4000);
		try {
			driver.findElement(By.xpath("(//div[@title='" + propertyNames + "'])[1]")).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyAvlOfDeletedTaskFeatureInTaskNodesTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);

		action.doubleClick(driver.findElement(EventProperties.ProcessflowNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.productNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.TgNameInBodhee)).perform();
		Thread.sleep(3000);
		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//label[@title='" + propertyNames + "']")).isDisplayed();
			return false;

		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyAvlFeatureseAfterAddingPropertyWithCommaTest() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(7000);
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		attributeCount = driver.findElements(addedPropertyInNode);
		int attributeSizeBeforeAddingProperty = attributeCount.size();
		System.out.println("Property size before adding the property " + attributeSizeBeforeAddingProperty);

		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}

		Thread.sleep(7000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(taskNodeEle).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		driver.findElement(addFeatureButton).click();
		driver.findElement(propertyName).sendKeys(propertyNames + "'");
		driver.findElement(propertyDesc).sendKeys(propertyNames + "'");
		driver.findElement(dataTypeDD).click();
		driver.findElement(dataTypeDD).click();
		Thread.sleep(2000);
		driver.findElement(textDataType).click();
		Thread.sleep(1000);

		driver.findElement(orderSequence).sendKeys("01");
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(3000);

		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);

		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);

		action.doubleClick(driver.findElement(EventProperties.ProcessflowNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.productNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.TgNameInBodhee)).perform();
		Thread.sleep(3000);
		action.contextClick(driver.findElement(EventProperties.TaskNameInBodhee)).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);

		attributeCount = driver.findElements(addedPropertyInNode);
		int attributeSizeAfterAddingProperty = attributeCount.size();
		System.out.println("Property size after adding the property " + attributeSizeAfterAddingProperty);

		if (attributeSizeBeforeAddingProperty + 1 == attributeSizeAfterAddingProperty) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteTheAddedAttributeTest() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(7000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(taskNodeEle).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@title=\"" + propertyNames + "'\"]/following-sibling::div/button")).click();
		Thread.sleep(2000);
		driver.findElement(deleteOption).click();
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(taskNodeEle).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(4000);
		try {
			driver.findElement(By.xpath("(//div[@title=\"" + propertyNames + "'\"])[1]")).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyUserCanAddPrimaryEquipmentTest() throws InterruptedException {
		String randomStr = RandomStringUtils.randomAlphabetic(4);
		newNodeType = newNodeType + "Task" + randomStr;
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		navigateTo.MapProcess();
		Thread.sleep(4000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(taskNodeType), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(nodeName).clear();
		Thread.sleep(1000);
		System.out.println("value for node " + newNodeType);
		driver.findElement(nodeName).sendKeys(newNodeType);
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(3000);
		action.contextClick(driver.findElement(By.xpath("//p[.='" + newNodeType + "']"))).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(MPETab).click();
		Thread.sleep(3000);
		driver.findElement(selectEquipmentDD).click();
		Thread.sleep(1000);
		driver.findElement(selectFirstEq).click();
		Thread.sleep(2000);
		driver.findElement(selectEquipmentDD).click();
		Thread.sleep(1000);
		driver.findElement(selectSecEq).click();
		Thread.sleep(2000);
		driver.findElement(altEquipSaveBtn).click();
		Thread.sleep(2000);
		driver.findElement(popupCoseBtn).click();
		Thread.sleep(2000);
		action.contextClick(driver.findElement(By.xpath("//p[.='" + newNodeType + "']"))).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(MPETab).click();
		Thread.sleep(2000);
		try {
			driver.findElement(configuredEq).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanAlternativeEquipmentTest() throws InterruptedException {
		List<String> altEqUipmentValue = new ArrayList<String>();
		List<String> altEqValueAfterConfig = new ArrayList<String>();
		try {
			driver.findElement(popupCoseBtn).click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//p[.='" + newNodeType + "']"))).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(MPETab).click();
		Thread.sleep(2000);
		driver.findElement(addMPE).click();
		Thread.sleep(1000);

		driver.findElement(AltEquipmentInput).sendKeys("EQ");
		Thread.sleep(2000);
		driver.findElement(selectFourthEq).click();
		Thread.sleep(2000);

		driver.findElement(addMPE).click();
		Thread.sleep(1000);

		driver.findElement(AltEquipmentInput).sendKeys("EQ");
		Thread.sleep(2000);
		driver.findElement(selectFifthEq).click();
		Thread.sleep(2000);
		driver.findElement(altEquipSaveBtn).click();
		List<WebElement> altEqSeqWhileConfif = driver.findElements(alterEqSequence);
		altEqSeqWhileConfif.remove(altEqSeqWhileConfif.size() - 1);

		for (WebElement webElement : altEqSeqWhileConfif) {
			altEqUipmentValue.add(webElement.getText());
		}
		Thread.sleep(2000);
		driver.findElement(popupCoseBtn).click();
		Thread.sleep(2000);
		action.contextClick(driver.findElement(By.xpath("//p[.='" + newNodeType + "']"))).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(MPETab).click();
		Thread.sleep(2000);
		List<WebElement> altEqSeqAfterConfif = driver.findElements(alterEqSequence);
		altEqSeqAfterConfif.remove(altEqSeqAfterConfif.size() - 1);
		for (WebElement webElement : altEqSeqAfterConfif) {
			altEqValueAfterConfig.add(webElement.getText());
		}
		System.out.println("alternate equipment while configuration " + altEqUipmentValue);
		System.out.println("alternate equipment after configuration " + altEqValueAfterConfig);
		boolean b = altEqUipmentValue.containsAll(altEqValueAfterConfig);
		if (b == true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteTheTaskNodeTest() throws InterruptedException {
		try {
			driver.findElement(popupCoseBtn).click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//p[.='" + newNodeType + "']"))).perform();
		Thread.sleep(4000);
		driver.findElement(nodeDeleteOptn).click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase("Nodestatusupdatedsuccessfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanCreateDelayCodeGroupTest() throws InterruptedException {
		delayCodeGroupValue = delayCodeGroupValue + RandomStringUtils.randomAlphabetic(4);
		Thread.sleep(5000);
		try {
			driver.findElement(bodheeLogoBodhee).click();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(9000);
		navigateTo.MapProcess();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys("Delay Code group");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(delayCodeGroupEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(nodeName).clear();
		Thread.sleep(1000);
		driver.findElement(nodeName).sendKeys(delayCodeGroupValue);
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase(delayCodeGroupValue + "createdsuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToCreateDelayCodeInDCGTest() throws InterruptedException {
		delayCodeValue = delayCodeValue + RandomStringUtils.randomAlphabetic(4);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//p[.='" + delayCodeGroupValue + "']"))).perform();
		Thread.sleep(4000);

		driver.findElement(processNiodeTypeSearchBox).sendKeys("Delay Code");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(delayCode), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(nodeName).clear();
		Thread.sleep(1000);
		driver.findElement(nodeName).sendKeys(delayCodeValue);
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase(delayCodeValue + "createdsuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvlOfDelayCodeInSelectReasonDDTest() throws InterruptedException, IOException {
		Thread.sleep(5000);
		try {
			driver.findElement(bodheeLogoBodhee).click();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		navigateTo.LattestPublishedPlan();
		Thread.sleep(2000);
		String productName = navigateTo.GetProductDetailsFromPlanner();
		Thread.sleep(2000);
		po.getProductDetails(productName);
		Thread.sleep(2000);
		navigateTo.productOverview();
		po.preReq();
		Thread.sleep(2000);
		driver.findElement(po.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		try {
			driver.findElement(po.startDD).click();
			Thread.sleep(2000);
			driver.findElement(po.resetButton).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(13000);
		} catch (Exception e) {
			driver.findElement(po.taskGrpProdctOvrVw).click();
		}
		Thread.sleep(2000);
		driver.findElement(po.startDD).click();
		Thread.sleep(2000);
		Thread.sleep(1000);
		driver.findElement(po.startOp).click();
		Thread.sleep(2000);
		new EventProperties();
		driver.findElement(po.startdatePicker).sendKeys(EventProperties.delayTime);
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		driver.findElement(po.startButton).click();
		Thread.sleep(2000);
		driver.findElement(po.chooseReasonDD).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[.='" + delayCodeGroupValue + "'])[1]/preceding-sibling::button")).click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("(//span[.='" + delayCodeValue + "'])[1]")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanDeletDelayCodeTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		navigateTo.MapProcess();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(By.xpath("//p[.='" + delayCodeGroupValue + "']"))).perform();
		Thread.sleep(4000);
		action.contextClick(driver.findElement(By.xpath("//p[.='" + delayCodeValue + "']"))).perform();
		Thread.sleep(4000);
		driver.findElement(nodeDeleteOptn).click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase("Nodestatusupdatedsuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanDeleteTheDelayCodeGroupTest() throws InterruptedException {
		driver.findElement(plantNameEle).click();
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//p[.='" + delayCodeGroupValue + "']"))).perform();
		Thread.sleep(4000);
		driver.findElement(nodeDeleteOptn).click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase("Nodestatusupdatedsuccessfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvlOfDelayCodeInSelectReasonDDPostDeleteTest() throws InterruptedException, IOException {
		Thread.sleep(5000);
		try {
			driver.findElement(bodheeLogoBodhee).click();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		navigateTo.LattestPublishedPlan();
		Thread.sleep(2000);
		String productName = navigateTo.GetProductDetailsFromPlanner();
		Thread.sleep(2000);
		po.getProductDetails(productName);
		Thread.sleep(2000);
		navigateTo.productOverview();
		po.preReq();
		Thread.sleep(2000);
		driver.findElement(po.taskGrpProdctOvrVw).click();
		Thread.sleep(2000);
		try {
			driver.findElement(po.startDD).click();
			Thread.sleep(2000);
			driver.findElement(po.resetButton).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(13000);
		} catch (Exception e) {
			driver.findElement(po.taskGrpProdctOvrVw).click();
		}
		Thread.sleep(2000);
		driver.findElement(po.startDD).click();
		Thread.sleep(2000);
		Thread.sleep(1000);
		driver.findElement(po.startOp).click();
		Thread.sleep(2000);
		new EventProperties();
		driver.findElement(po.startdatePicker).sendKeys(EventProperties.delayTime);
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).build().perform();

		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		driver.findElement(po.startButton).click();
		Thread.sleep(2000);
		driver.findElement(po.chooseReasonDD).click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("(//span[.='" + delayCodeGroupValue + "'])[1]/preceding-sibling::button"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[.='" + delayCodeValue + "'])[1]")).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyAvlOfOrderSequenceColumnInPropertyTabTest() throws InterruptedException {
		Thread.sleep(4000);
		try {
			driver.findElement(bodheeLogoBodhee).click();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(6000);
		navigateTo.MapProcess();
		Thread.sleep(2000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(2000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(taskNodeEle).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		try {
			driver.findElement(orderSequenceColumn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanCreateNodeTypeByAddingOrderSequenceTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		nodeTypeName = nodeTypeName + RandomStringUtils.randomAlphabetic(4);
		propertyNames = propertyNames + RandomStringUtils.randomAlphabetic(4);
		System.out.println("Created Node name " + nodeTypeName);
		driver.findElement(newNodeTypeButton).click();
		Thread.sleep(500);
		driver.findElement(nodeTypeTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeDescriptionTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeIconDD).click();
		driver.findElement(nodeIconOption).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		driver.findElement(addFeatureButton).click();
		driver.findElement(propertyName).sendKeys(propertyNames + "'");
		driver.findElement(propertyDesc).sendKeys(propertyNames + "'");
		driver.findElement(dataTypeDD).click();
		driver.findElement(dataTypeDD).click();
		Thread.sleep(2000);
		driver.findElement(textDataType).click();
		Thread.sleep(1000);
		driver.findElement(orderSequence).sendKeys("1");
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals(nodeTypeName + " added Successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTheAvlOfPropertyaddedWithOrderSequenceTest() throws InterruptedException {
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(createdNode).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("(//div[@title='" + propertyNames + "'])[1]")).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyTheOrderSequenceOfPropertyTest() throws InterruptedException {
		Actions action = new Actions(driver);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(createdNode).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);

		driver.findElement(addFeatureButton).click();
		driver.findElement(propertyName).sendKeys(propertyNames + "2");
		driver.findElement(propertyDesc).sendKeys(propertyNames + "2");
		driver.findElement(dataTypeDD).click();
		driver.findElement(dataTypeDD).click();
		Thread.sleep(2000);
		driver.findElement(textDataType).click();
		Thread.sleep(1000);
		driver.findElement(orderSequence).sendKeys("2");
		Thread.sleep(1000);

		driver.findElement(addFeatureButton).click();
		driver.findElement(propertyName).sendKeys(propertyNames + "3");
		driver.findElement(propertyDesc).sendKeys(propertyNames + "3");
		driver.findElement(dataTypeDD).click();
		driver.findElement(dataTypeDD).click();
		Thread.sleep(2000);
		driver.findElement(textDataType).click();
		Thread.sleep(1000);
		driver.findElement(orderSequence).sendKeys("3");
		Thread.sleep(1000);

		driver.findElement(addFeatureButton).click();
		driver.findElement(propertyName).sendKeys(propertyNames + "4");
		driver.findElement(propertyDesc).sendKeys(propertyNames + "4");
		driver.findElement(dataTypeDD).click();
		driver.findElement(dataTypeDD).click();
		Thread.sleep(2000);
		driver.findElement(textDataType).click();
		Thread.sleep(1000);
		driver.findElement(orderSequence).sendKeys("4");
		Thread.sleep(1000);

		driver.findElement(saveBtn).click();
		Thread.sleep(1000);

		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(createdNode).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);

		List<WebElement> addedPropValueList = new ArrayList<WebElement>();
		List<String> addedValues = new ArrayList<String>();

		addedPropValueList = driver.findElements(addedPropertyList);

		for (WebElement list : addedPropValueList) {
			addedValues.add(list.getText());
		}
		System.out.println("Added Value lists is " + addedValues);
		driver.navigate().refresh();
		Thread.sleep(4000);

		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);

		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);

		action.dragAndDrop(driver.findElement(createNodeEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);

		List<WebElement> displayedValueEle = new ArrayList<WebElement>();

		List<String> displayValue = new ArrayList<String>();

		displayedValueEle = driver.findElements(displayedPropList);

		for (WebElement list : displayedValueEle) {
			displayValue.add(list.getText());
		}
		System.out.println(displayValue);

		if (addedValues.equals(displayValue)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyWhetherIntegerTypePropertyAcceptingNegatiValueTest() throws InterruptedException {

		propertyNames = propertyNames + "Integer";
		By intTextBox = By.xpath("//input[@placeholder='Enter " + propertyNames + "']");
		Actions action = new Actions(driver);
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(5000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(2000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(createdNode).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		driver.findElement(addFeatureButton).click();
		driver.findElement(propertyName).sendKeys(propertyNames);
		driver.findElement(propertyDesc).sendKeys(propertyNames);
		driver.findElement(dataTypeDD).click();
		driver.findElement(dataTypeDD).click();
		Thread.sleep(2000);
		driver.findElement(integerDataType).click();
		Thread.sleep(1000);
		driver.findElement(orderSequence).sendKeys("5");
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);

		try {
			driver.navigate().refresh();
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(8000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);

		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);

		action.dragAndDrop(driver.findElement(createNodeEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(intTextBox).sendKeys("-1");

		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		nodeTypeName = nodeTypeName.replace(" ", "");

		System.out.println("Node type name while adding integer type " + nodeTypeName);
		if (tstrMsg.equalsIgnoreCase(nodeTypeName + "createdsuccessfully!")) {
			return false;
		} else {
			return true;
		}

	}

	public boolean verifyWhetherFloatTypePropertyAcceptingNegativeValueTest() throws InterruptedException {

		propertyNames = propertyNames + "Float";
		By intTextBox = By.xpath("//input[@placeholder='Enter " + propertyNames + "']");
		Actions action = new Actions(driver);
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(9000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(2000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(createdNode).click();
		Thread.sleep(2000);
		driver.findElement(propertyTab).click();
		Thread.sleep(1000);
		driver.findElement(addFeatureButton).click();
		driver.findElement(propertyName).sendKeys(propertyNames);
		driver.findElement(propertyDesc).sendKeys(propertyNames);
		driver.findElement(dataTypeDD).click();
		driver.findElement(dataTypeDD).click();
		Thread.sleep(2000);
		driver.findElement(floatDataType).click();
		Thread.sleep(1000);
		driver.findElement(orderSequence).sendKeys("6");
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);

		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(8000);

		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);

		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);

		action.dragAndDrop(driver.findElement(createNodeEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(intTextBox).sendKeys("-1");

		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String tstrMsg;
		try {
			tstrMsg = driver.findElement(createToasterSuccess).getText().replace(" ", "");
		} catch (Exception e) {
			tstrMsg = "null";
		}
		System.out.println("*" + tstrMsg + "*");
		if (tstrMsg.equalsIgnoreCase(nodeTypeName + "createdsuccessfully!")) {
			return false;
		} else {
			return true;
		}

	}

	public boolean verifyUserIsAbleToCreateANodeByAddingApportstopeTest() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(6000);
		try {
			driver.findElement(bodheeLogoBodhee).click();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		Thread.sleep(9000);
		navigateTo.MapProcess();
		Thread.sleep(2000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(1000);

		nodeTypeName = nodeTypeName + RandomStringUtils.randomAlphabetic(4);
		nodeTypeName = nodeTypeName + "'";
		System.out.println("Created Node name " + nodeTypeName);
		driver.findElement(newNodeTypeButton).click();
		Thread.sleep(500);
		driver.findElement(nodeTypeTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeDescriptionTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeIconDD).click();
		driver.findElement(nodeIconOption).click();
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals(nodeTypeName + " added Successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserIsAbleToCreateANodeByAddingApportstopeInDescriptionTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		nodeTypeName = "Test" + RandomStringUtils.randomAlphabetic(7);
		driver.findElement(newNodeTypeButton).click();
		Thread.sleep(500);
		driver.findElement(nodeTypeTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeDescriptionTextBox).sendKeys(nodeTypeName + "'");
		driver.findElement(nodeIconDD).click();
		driver.findElement(nodeIconOption).click();
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals(nodeTypeName + " added Successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserIsAbleToCreateNewNodeByAddingApportstapeSymbolTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		nodeTypeName = "Test" + RandomStringUtils.randomAlphabetic(7);
		driver.findElement(newNodeTypeButton).click();
		Thread.sleep(500);
		driver.findElement(nodeTypeTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeDescriptionTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeIconDD).click();
		driver.findElement(nodeIconOption).click();
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(3000);

		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);

		newNodeType = "Test" + RandomStringUtils.randomAlphabetic(4);
		newNodeType = newNodeType + "'";
		driver.findElement(processNiodeTypeSearchBox).clear();
		Thread.sleep(1000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(createNodeEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(nodeName).clear();
		Thread.sleep(1000);
		driver.findElement(nodeName).sendKeys(newNodeType);
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);

		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("Actual Toaster message is *" + successToaster + "*");
		System.out.println("Expected Toaster message is *" + nodeTypeName + " created successfully!");
		if (successToaster.equals(newNodeType + " created successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToCreateNewNodeByAddingApportstopeSymboleInDescriptionTest()
			throws InterruptedException {
		Actions action = new Actions(driver);
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(7000);

		newNodeType = "TestDesc" + RandomStringUtils.randomAlphabetic(4);
		newNodeType = newNodeType + "'";
		driver.findElement(processNiodeTypeSearchBox).clear();
		Thread.sleep(1000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(createNodeEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(nodeName).clear();
		Thread.sleep(1000);
		driver.findElement(nodeName).sendKeys(newNodeType);
		Thread.sleep(1000);

		driver.findElement(descriptionField).clear();

		driver.findElement(descriptionField).sendKeys(newNodeType);

		driver.findElement(saveBtn).click();
		Thread.sleep(1000);

		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("Actual Toaster message is *" + successToaster + "*");
		System.out.println("Expected Toaster message is *" + nodeTypeName + " created successfully!");
		if (successToaster.equals(newNodeType + " created successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvlOfCreatedNewNodeByAddingApportstopeSymboleInDescriptionTest()
			throws InterruptedException {
		Actions action = new Actions(driver);
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(7000);

		action.contextClick(driver.findElement(By.xpath("//p[contains(text(),'" + newNodeType + ")]"))).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		String descriptionValue = driver.findElement(descriptionField).getAttribute("ng-reflect-model");
		System.out.println("Description value is *" + descriptionValue);
		System.out.println("Expected values is *" + newNodeType);
		if (descriptionValue.equals(newNodeType)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserIsAbleToCloneANodeByAddingApportstopeSymboleTest() throws InterruptedException {

		Actions action = new Actions(driver);
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(7000);
		action.contextClick(driver.findElement(By.xpath("//p[contains(text(),'" + newNodeType + ")]"))).perform();
		Thread.sleep(2000);
		newNodeType = "TestClone" + RandomStringUtils.randomAlphabetic(4);
		newNodeType = newNodeType + "'";
		Thread.sleep(2000);
		driver.findElement(nodeCloneOption).click();
		Thread.sleep(2000);
		driver.findElement(cloneNodeInputBox).clear();
		Thread.sleep(2000);
		driver.findElement(cloneNodeInputBox).sendKeys(newNodeType);

		driver.findElement(cloneBtn).click();
		Thread.sleep(2000);
		cloneNodeToaster = driver.findElement(createToasterSuccess).getText();
		By clonedNodeName = By.xpath("//p[contains(text(),'" + newNodeType + ")]");
		Thread.sleep(3000);
		try {
			driver.findElement(clonedNodeName).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyCloneNodeToasterAfterAddingApportStopeSymboTest() {
		if (cloneNodeToaster.equals("Clone Success")) {
			return true;

		} else {
			System.out.println(cloneNodeToaster);
			return false;
		}

	}

	public boolean verifyUserIsAbleToCreateNewNodeByAddingLessThanSymboleTest() throws InterruptedException {

		Actions action = new Actions(driver);
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(8000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		nodeTypeName = "TestLessThanSymbole" + RandomStringUtils.randomAlphabetic(4);

		System.out.println("Created Node name " + nodeTypeName);
		driver.findElement(newNodeTypeButton).click();
		Thread.sleep(1000);
		driver.findElement(nodeTypeTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeDescriptionTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeIconDD).click();
		driver.findElement(nodeIconOption).click();
		driver.findElement(saveBtn).click();

		driver.navigate().refresh();
		Thread.sleep(6000);

		newNodeType = "TestLessThan" + RandomStringUtils.randomAlphabetic(4);
		newNodeType = newNodeType + "<";

		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(3000);

		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);

		driver.findElement(processNiodeTypeSearchBox).clear();
		Thread.sleep(1000);
		driver.findElement(processNiodeTypeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(createNodeEle), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(4000);
		driver.findElement(nodeName).clear();
		Thread.sleep(1000);
		driver.findElement(nodeName).sendKeys(newNodeType);
		Thread.sleep(1000);

		driver.findElement(descriptionField).clear();

		driver.findElement(descriptionField).sendKeys(newNodeType);

		driver.findElement(saveBtn).click();
		Thread.sleep(1000);

		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("Actual Toaster message is *" + successToaster + "*");
		System.out.println("Expected Toaster message is *" + newNodeType + " created successfully!");
		if (successToaster.equals(newNodeType + " created successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTheAvlOfCreatedNodeWithLessThanSymboleTest() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}

		Thread.sleep(7000);

		By lessThanNode = By.xpath("//p[contains(text(),'" + newNodeType + "')]");
		try {
			driver.findElement(lessThanNode).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyAvlOfLinkagePostNavigattingBackFromSimplifiedScreenTest() throws InterruptedException {
		Actions action = new Actions(driver);
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(7000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(1000);
		driver.findElement(plantName).click();
		Thread.sleep(2000);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.ProcessflowNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.productNameInBodhee)).perform();
		Thread.sleep(3000);
		action.doubleClick(driver.findElement(EventProperties.TgNameInBodhee)).perform();
		Thread.sleep(3000);

		driver.findElement(simplifiedScreenToggle).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(simplifiedScreenToggle).click();
		Thread.sleep(3000);

		try {
			driver.findElement(linkagesEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserIsAbleToAddNodeLinkageWithApportstopeTest() throws InterruptedException {

		try {
			driver.findElement(homeIcon).click();
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		navigateTo.MapProcess();
		Thread.sleep(3000);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		nodeTypeName = "nodeLinkageApportstope" + RandomStringUtils.randomAlphabetic(4);

		System.out.println("Created Node name " + nodeTypeName);
		driver.findElement(newNodeTypeButton).click();
		Thread.sleep(1000);
		driver.findElement(nodeTypeTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeDescriptionTextBox).sendKeys(nodeTypeName);
		driver.findElement(nodeIconDD).click();
		driver.findElement(nodeIconOption).click();
		driver.findElement(saveBtn).click();
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(createdNode).click();
		Thread.sleep(2000);

		driver.findElement(linkagesTab).click();
		Thread.sleep(2000);
		driver.findElement(nodeLinkageAddButton).click();
		Thread.sleep(2000);
		driver.findElement(featureName).sendKeys("TestFeature'");
		driver.findElement(featureDescription).sendKeys("TestFeature'");
		Thread.sleep(4000);
		driver.findElement(selectNodeTypeDropDown).click();
		Thread.sleep(2000);

		driver.findElement(selectLocation).click();
		Thread.sleep(2000);

		driver.findElement(saveLinkageButton).click();

		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals(nodeTypeName + " updated Successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyAddedFeatureIsAvailableOrNotTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(nodeSearchBox).clear();
		driver.findElement(nodeSearchBox).sendKeys(nodeTypeName);
		Thread.sleep(2000);
		driver.findElement(createdNode).click();
		Thread.sleep(2000);

		driver.findElement(linkagesTab).click();
		Thread.sleep(2000);

		try {
			driver.findElement(addedLinkageEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserIsAbleToCreateNewProcessWithApportstopeTest() throws InterruptedException {
		processName = "Test" + RandomStringUtils.randomAlphabetic(4);
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(createProcessMap).click();
		Thread.sleep(2000);
		driver.findElement(processTypeInputBox).sendKeys("Task");
		Thread.sleep(500);
		driver.findElement(firstProcessType).click();
		Thread.sleep(500);
		driver.findElement(processNameTextBox).sendKeys(processName);
		Thread.sleep(500);
		driver.findElement(locationDropDown).click();
		Thread.sleep(500);
		driver.findElement(locationValue).click();
		Thread.sleep(500);
		driver.findElement(createdButton).click();
		Thread.sleep(2000);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals("Process Created successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvlOfCreatedProcessTest() throws InterruptedException {
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//li[.='" + processName + "']")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	public boolean verifyUserCanCreateTheTaskNodeByAddingPropertyTest() throws InterruptedException {
		taskNodeName = "TestTaskNode" + RandomStringUtils.randomAlphabetic(5);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);

		driver.findElement(processNiodeTypeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(taskNodeType), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(6000);
		driver.findElement(NodeNameTextBox).clear();
		driver.findElement(NodeNameTextBox).sendKeys(taskNodeName);

		driver.findElement(propertyEle).sendKeys("TestProperty");

		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals(taskNodeName + " created successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvailabilityOfAddedPropertyToTaskNodeTest() throws InterruptedException {
		Actions action = new Actions(driver);
		driver.findElement(eleToSaveNodeInProcessTab).click();
		Thread.sleep(3000);
		action.contextClick(driver.findElement(By.xpath("//p[contains(text(),'" + taskNodeName + "')]"))).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		String addedPropetyValue = driver.findElement(propertyEle).getAttribute("value");
		System.out.println("Added Property value is " + addedPropetyValue);

		if (addedPropetyValue.equals("TestProperty")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanRemoveTheAddedPropertyTest() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(8000);
		Actions action = new Actions(driver);
		driver.findElement(eleToSaveNodeInProcessTab).click();
		Thread.sleep(3000);
		action.contextClick(driver.findElement(By.xpath("//p[contains(text(),'" + taskNodeName + "')]"))).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		driver.findElement(propertyEle).clear();
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals(taskNodeName + " created successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvailabilityOfRemovedPropertyTest() throws InterruptedException {
		Actions action = new Actions(driver);
		driver.findElement(eleToSaveNodeInProcessTab).click();
		Thread.sleep(3000);
		action.contextClick(driver.findElement(By.xpath("//p[contains(text(),'" + taskNodeName + "')]"))).perform();
		Thread.sleep(2000);
		driver.findElement(configureProcessOptn).click();
		Thread.sleep(3000);
		String addedPropetyValue = driver.findElement(propertyEle).getAttribute("value");
		System.out.println("Added Property value is " + addedPropetyValue);

		if (addedPropetyValue.equals("TestProperty")) {
			return false;
		} else {
			return true;
		}
	}

	public boolean verifyUserCanCreateTheTaskGroupNodeTest() throws InterruptedException {

		try {
			driver.navigate().refresh();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(6000);
		taskGroupNodeName = "TestTaskGroup" + RandomStringUtils.randomAlphabetic(5);
		driver.findElement(nodeTypeTab).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(processBuilderTab).click();
		Thread.sleep(4000);
		driver.findElement(plantName).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(EventProperties.APUXpath)).perform();
		Thread.sleep(3000);

		driver.findElement(processNiodeTypeSearchBox).sendKeys("Task Group");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(taskGroupNodeType), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(6000);
		driver.findElement(NodeNameTextBox).clear();
		driver.findElement(NodeNameTextBox).sendKeys(taskGroupNodeName);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("*" + successToaster + "*");
		if (successToaster.equals(taskGroupNodeName + " created successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTaskNodeCreationInTaskGroupTest() throws InterruptedException {
		taskNodeName = "TestTaskNode1" + RandomStringUtils.randomAlphabetic(5);

		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//p[contains(text(),'" + taskGroupNodeName + "')]"))).perform();
		Thread.sleep(3000);

		driver.findElement(processNiodeTypeSearchBox).sendKeys("Task");
		Thread.sleep(2000);
		driver.findElement(processNiodeTypeSearchBox).click();
		Thread.sleep(2000);
		action.dragAndDrop(driver.findElement(taskNodeType), driver.findElement(dragSpace)).build().perform();
		Thread.sleep(6000);
		driver.findElement(NodeNameTextBox).clear();
		driver.findElement(NodeNameTextBox).sendKeys(taskNodeName);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("Toaster message while creating child task node *" + successToaster + "*");
		if (successToaster.equals(taskNodeName + " created successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyParentNodeCloneWithChildNodeTest() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		driver.findElement(elementToNavigateParentNode).click();
		Thread.sleep(2000);
		action.contextClick(driver.findElement(By.xpath("//p[contains(text(),'" + taskGroupNodeName + "')]")))
				.perform();
		System.out.println("write clicked on  created node ");
		Thread.sleep(2000);
		driver.findElement(nodeCloneOption).click();
		System.out.println("clicked on clone node option ");
		Thread.sleep(2000);
		driver.findElement(clonedChilderCheckMark).click();
		Thread.sleep(2000);
		driver.findElement(cloneBtn).click();
		System.out.println("clone button added ");
		Thread.sleep(1500);
		String successToaster;
		try {
			successToaster = driver.findElement(createToasterSuccess).getText();
		} catch (Exception e) {
			successToaster = "null";
		}
		System.out.println("Toaster message while creating child task node *" + successToaster + "*");
		if (successToaster.equals("Clone Success")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyClonedNodeAvailabilityTest() throws InterruptedException {
		Thread.sleep(2000);

		try {
			driver.findElement(By.xpath("//p[contains(text(),'" + taskGroupNodeName + "_copy')]")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyChildNodeNameInClonedParentTest() throws InterruptedException {

		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//p[contains(text(),'" + taskGroupNodeName + "_copy')]")))
				.perform();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//p[contains(text(),'" + taskNodeName + "_copy')]")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

//-------------------------------------------------Method Area Ends Here---------------------------------------------	

}
