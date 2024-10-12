package com.qa.bps.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;

public class TeamManagement {

	WebDriver driver;

//X-path Area starts
	private By operatorTeamTab = By.xpath("//a[@id='v-pills-userGroup-tab']");
	private By operatorTab = By.xpath("//a[@id='v-pills-user-tab']");
	private By operatorRoleTab = By.xpath("//a[@id='v-pills-userRole-tab']");
	private By skillMatrixTab = By.xpath("//a[@id='v-pills-skillMetrix-tab']");
	private By tabHeader = By.xpath("//label[@class='label-header']");
	private By teamNameHeader = By.xpath("(//div[.='Team Name'])[4]");
	private By DescHeader = By.xpath("(//div[.='Description'])[4]");
	private By createdOnHeader = By.xpath("(//div[.='Created On'])[4]");
	private By statusHeader = By.xpath("(//div[.='Status'])[4]");
	public By searchBox = By.xpath("(//input[@placeholder='Search'])[2]");
	private By createNewTeamBtn = By.xpath("//button[.='Create new team']");
	private By firstTeam = By.xpath("(//div[@tabulator-field='name'])[2]");
	private By firstTeamDesc = By.xpath("(//div[@tabulator-field='description'])[2]");
	private By teams = By.xpath("//div[@role='row']");
	private By enterTeamTitleInput = By.xpath("//input[@placeholder='Enter team title']");
	private By teamDescInput = By.xpath("//input[@placeholder='Enter description']");

	private By selectScopeDD = By.xpath("(//input[@role='combobox'])[2]");
	private By scopeValueByLocation = By.xpath("//span[.='Location']");
	private By selectOrgNodeDD = By.xpath("(//input[@role='combobox'])[3]");
	private By orgNodeValue = By.xpath("(//div[@role='option'])[1]");
	private By effectiveStDatebtn = By
			.xpath("((//div[@class='tabulator-tableHolder'])[2]/div/div/div[@role='gridcell'])[5]");
	private By effectiveEndDatebtn = By
			.xpath("((//div[@class='tabulator-tableHolder'])[2]/div/div/div[@role='gridcell'])[6]");

	private By effectiveStdateInput = By.xpath("//input[@type='date']");
	private By saveBtn = By.xpath("(//button[.='Save'])[1]");
	private By saveBtnEditOp = By.xpath("(//button[.='Save'])[2]");
	private By toaster = By.xpath("//div[@role='alertdialog']");
	private By threeDot = By.xpath("(//div[@role='gridcell'])[6]");
	private By threeDotOpRole = By.xpath("(//div[@role='gridcell'])[4]");
	public static By OperatorThreeDot = By.xpath("(//div[@role='gridcell'])[10]");
	private By editTeamOption = By.xpath("(//div[@class='tabulator-menu-item'])[1]");
	public static By manageOperatorOption = By.xpath("(//div[@class='tabulator-menu-item'])[2]");
	private By deleteRoleOption = By.xpath("(//div[@class='tabulator-menu-item'])[2]");

	private By deleteTeamOption = By.xpath("(//div[@class='tabulator-menu-item'])[3]");
	private By deleteConfirmationBtn = By.xpath("//button[.='Delete']");
	private By activeStatus = By.xpath("(//div[@tabulator-field='active_flag'])[2]");

	private By displayNameHeader = By.xpath("(//div[.='Display Name'])[4]");
	private By emailAddressHeader = By.xpath("(//div[.='Email Address'])[4]");
	private By employeeIDHeader = By.xpath("(//div[.='Employee ID'])[4]");
	private By teamHeader = By.xpath("(//div[.='Team'])[4]");
	private By rolesHeader = By.xpath("(//div[.='Roles'])[4]");
	public static By createNewOperatorBtn = By.xpath("//button[.='Create new operator']");
	private By firstOp = By.xpath("(//div[@tabulator-field='display_name'])[2]");
	private By firstNameInput = By.xpath("(//input[@placeholder='Enter First name'])[1]");
	private By firstNameInputEdit = By.xpath("(//input[@placeholder='Enter First name'])[2]");
	private By lastNameInput = By.xpath("(//input[@placeholder='Enter Last name'])[1]");
	private By emailInput = By.xpath("(//input[@placeholder='Enter Email address'])[1]");
	private By mobileNumberInput = By.xpath("(//input[@placeholder='Enter Mobile number'])[1]");
	public static By paswordInput = By.xpath("(//input[@placeholder='Enter Password'])[1]");
	private By showPasswordCheckBox = By.xpath("//input[@id='customCheck3']");
	private By RFIDUIDinput = By.xpath("(//input[@placeholder='Enter RFID Card UID'])[1]");
	private By employeeIDinput = By.xpath("(//input[@placeholder='Enter Employee ID'])[1]");
	private By selectTeamDD = By.xpath("(//input[@role='combobox'])[1]");
	private By selectTeamDDedit = By.xpath("(//input[@role='combobox'])[4]");
	private By selectGroupDD = By.xpath("(//input[@role='combobox'])[2]");
	private By selectGroupDDedit = By.xpath("(//input[@role='combobox'])[5]");

	private By chooseRleDD = By.xpath("(//input[@role='combobox'])[3]");
	private By chooseRoleDDedit = By.xpath("(//input[@role='combobox'])[6]");
	private By activeFlagToggleBtn = By.xpath("(//span[@class='slider round'])[1]");
	private By activeFlagToggleBtnDeactive = By.xpath("(//span[@class='slider round'])[2]");

	private By teamValue = By.xpath("(//div[@role='option'])[1]");
	private By opteamValueEdit = By.xpath("(//div[@role='option'])[2]");
	private By opRole = By.xpath("//span[.='Operator']");
	private By SlRole = By.xpath("//span[.='Shift Leader']");

	private By opTeamName = By.xpath("(//div[@tabulator-field='team_name'])[2]");
	private By getOpGrp = By.xpath("((//input[@role='combobox']/parent::div)[5]//preceding-sibling::div/span)[2]");
	private By editOpPopupCloseBtn = By.xpath("(//fa-icon[@class='ng-fa-icon'])[5]");
	private By createteamPopupCloseBtn = By.xpath("(//fa-icon[@class='ng-fa-icon'])[4]");

	private By editedOpRole = By.xpath("(//div[@role='gridcell'])[14]");
	private By errToaster = By.xpath("//div[@id='toast-container']");

	private By OpRoleTabHeader = By.xpath("//label[@class='label-header']");
	private By createNewRoleBtn = By.xpath("//button[.='Create new role']");
	private By roleNameheader = By.xpath("(//div[.='Role Name'])[4]");
	private By enterRoleInput = By.xpath("//input[@placeholder='Enter role name']");
	private By enterRoleDescInput = By.xpath("//input[@placeholder='Enter description']");
	private By roles = By.xpath("//div[@role='option']/span");

	private By manageTeamDD = By.xpath("(//input[@role='combobox'])[7]");
	private By lastTeamValue = By.xpath("(//div[@role='option'])[last()]");
	private By saveBtnManageTeam = By.xpath("(//button[.='Save'])[3]");
	private By operatorsInTeam = By.xpath("//div[@class='ng-value ng-star-inserted']");
	
	private By operatorSklMtrx=By.xpath("(//div[.='Operator'])[2]");
	private By productSklMtrx=By.xpath("(//div[.='PRODUCT'])[1]");
	private By buildIngSklMtrx=By.xpath("(//div[.='BUILDING'])[1]");
	private By taskSklMtrx=By.xpath("(//div[.='TASK'])[1]");
	private By uploadSkillMatrix=By.xpath("(//img[@title='Upload SKill Matrix Excel'])");
	private By downloadSkillMatrix=By.xpath("(//img[@title='Download SKill Matrix Excel'])");
	
	
//X-Path Area Ends	

	Navigation navigateTo;
//String Area Starts
	String teamName;
	public String ToasterMsg;
	String activeflag;

	String OpfirstName;
	String OpLastName;
	String OpEmail;
	String OpDisplayName;
	String RFID;
	String empID;
	String OpteamBefore;
	String OpteamAfter;

	String OpRole;
	String OpRoleDesc;

	int size;

//String Area Ends	

	public TeamManagement(WebDriver driver) {

		this.driver = driver;
		navigateTo = new Navigation(driver);
	}

	String randomText = RandomStringUtils.randomAlphabetic(4);
	String randomNum = RandomStringUtils.randomNumeric(3);

	public void navigateToTeamManagement() throws InterruptedException {
		navigateTo.TeamManagement();
	}

	public boolean availableTabsInTM() {
		boolean b;
		try {
			driver.findElement(operatorTeamTab).isDisplayed();
			driver.findElement(operatorTab).isDisplayed();
			driver.findElement(operatorRoleTab).isDisplayed();
			driver.findElement(skillMatrixTab).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean tabHeaderInTeamManagement() throws InterruptedException {
		driver.findElement(operatorTeamTab).click();
		Thread.sleep(1500);
		boolean b = false;
		try {
			String TeamHeader = driver.findElement(tabHeader).getText();
			if (TeamHeader.equals("Operator Team")) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println("operator team header not displayed ");
			b = false;
		}
		return b;
	}

	public boolean availableFieldsUnderOperatorTeamTab() {
		boolean b;
		try {
			driver.findElement(teamNameHeader).isDisplayed();
			driver.findElement(DescHeader).isDisplayed();
			driver.findElement(createdOnHeader).isDisplayed();
			driver.findElement(statusHeader).isDisplayed();
			driver.findElement(searchBox).isDisplayed();
			driver.findElement(createNewTeamBtn).isDisplayed();
			driver.findElement(firstTeam).isDisplayed();

			b = true;
		} catch (Exception e) {
			System.out.println("Any of the header section missed from Operator Team tab");
			b = false;
		}
		return b;
	}

	public boolean creaNewTeamAndCheckToaster() throws InterruptedException {
		driver.findElement(createNewTeamBtn).click();
		Thread.sleep(1500);
		teamName = "Test Operator Team " + randomText;

		driver.findElement(enterTeamTitleInput).sendKeys(teamName);
		Thread.sleep(1500);
		driver.findElement(teamDescInput).sendKeys("Desc for New Team ");
		Thread.sleep(1000);
		driver.findElement(selectScopeDD).click();
		Thread.sleep(1000);
		driver.findElement(scopeValueByLocation).click();
		Thread.sleep(1500);
		driver.findElement(selectOrgNodeDD).click();
		Thread.sleep(1500);
		driver.findElement(orgNodeValue).click();
		Thread.sleep(1500);
		driver.findElement(effectiveStDatebtn).click();
		Thread.sleep(1500);
		driver.findElement(effectiveStdateInput).sendKeys("01012020");
		Thread.sleep(1500);
		driver.findElement(effectiveEndDatebtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean toasterMsgValidation() {
		boolean b;
		if (ToasterMsg.equals("Operator Team Created Successfully!")) {
			b = true;
		} else {
			System.out.println("Toaster Msg displayed is : " + ToasterMsg);
			b = false;
		}
		return b;
	}

	public boolean createdTeamExistsInteamList() throws InterruptedException {
		boolean b;
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(1200);
		driver.findElement(searchBox).sendKeys(teamName);
		Thread.sleep(1000);
		String createdTeamName = driver.findElement(firstTeam).getText();
		System.out.println("Displayed  team name " + createdTeamName);
		System.out.println("Expected Team name  " + teamName);
		if (teamName.equals(createdTeamName)) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean functionalityOfSearchBoxINCreateTeam() throws InterruptedException {
		boolean b;
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(1200);
		driver.findElement(searchBox).sendKeys(teamName);
		Thread.sleep(1000);
		String createdTeamName = driver.findElement(firstTeam).getText();
		System.out.println("Displayed  team name " + createdTeamName);
		System.out.println("Expected Team name  " + teamName);
		if (teamName.equals(createdTeamName)) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean createNewTeamWithDuplicateName() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(1200);

		driver.findElement(createNewTeamBtn).click();
		Thread.sleep(1500);
		teamName = "Test Operator Team " + randomText;

		driver.findElement(enterTeamTitleInput).sendKeys(teamName);
		Thread.sleep(1500);
		driver.findElement(teamDescInput).sendKeys("Desc for New Team ");
		Thread.sleep(1000);
		driver.findElement(selectScopeDD).click();
		Thread.sleep(1000);
		driver.findElement(scopeValueByLocation).click();
		Thread.sleep(1500);
		driver.findElement(selectOrgNodeDD).click();
		Thread.sleep(1500);
		driver.findElement(orgNodeValue).click();
		Thread.sleep(1500);
		driver.findElement(effectiveStDatebtn).click();
		Thread.sleep(1500);
		driver.findElement(effectiveStdateInput).sendKeys("01012020");
		Thread.sleep(1500);
		driver.findElement(effectiveEndDatebtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		boolean b;
		try {
			ToasterMsg = driver.findElement(errToaster).getText();
			driver.findElement(errToaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean duplicateTeamAddedInTeamList() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(4000);

		boolean b;
		driver.findElement(searchBox).clear();
		Thread.sleep(1200);
		driver.findElement(searchBox).sendKeys(teamName);
		System.out.println("-----Checking how many Team with the same name-----");
		Thread.sleep(2000);

		List<WebElement> e = driver.findElements(teams);
		int a = e.size();
		System.out.println("Available team with the name " + a);
		try {
			driver.findElement(searchBox).clear();
			Thread.sleep(1000);
			driver.findElement(createteamPopupCloseBtn).click();
		} catch (Exception e2) {

		}
		if (a == 1) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean toasterValidationOnDuplicateTeamCreation() {
		boolean b;
		System.out.println(ToasterMsg);
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.contains("alreadyexists.")) {
			b = true;
		}

		else {
			b = false;
		}
		return b;
	}

	public boolean editOpTeamAndToaster() throws InterruptedException {
		boolean b;

		createdTeamExistsInteamList();
		driver.findElement(threeDot).click();
		Thread.sleep(1200);
		driver.findElement(editTeamOption).click();
		Thread.sleep(1500);
		driver.findElement(enterTeamTitleInput).clear();
		Thread.sleep(800);
		teamName = teamName + randomText;
		driver.findElement(enterTeamTitleInput).sendKeys(teamName);
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);

		try {
			ToasterMsg = driver.findElement(toaster).getText();
			System.out.println("editOpTeamAndToaster " + ToasterMsg);
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean toasterValidation() {
		boolean b;
		if (ToasterMsg.equals("Operator Team Details Updated Successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean editTeamDescandVerifyToaster() throws InterruptedException {
		createdTeamExistsInteamList();
		Thread.sleep(1500);
		driver.findElement(threeDot).click();
		Thread.sleep(1200);
		driver.findElement(editTeamOption).click();
		Thread.sleep(1400);
		driver.findElement(teamDescInput).clear();
		Thread.sleep(1400);
		driver.findElement(teamDescInput).sendKeys(teamName);
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean toasterValOnEditTeamDesc() {
		boolean b;
		if (ToasterMsg.equals("Operator Team Details Updated Successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean verifyOperationTeamDescUpdated() {
		boolean b;
		String updatedDesc = driver.findElement(firstTeamDesc).getText();
		System.out.println("updatedDesc displayed " + updatedDesc);
		System.out.println("Description expected " + teamName);
		if (updatedDesc.equals(teamName)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean deleteOpTeamAndcheckToaster() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(threeDot).click();
		Thread.sleep(1200);
		driver.findElement(deleteTeamOption).click();
		Thread.sleep(1500);
		driver.findElement(deleteConfirmationBtn).click();
		Thread.sleep(1200);
		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean avaialabilityOfDeletedTeam() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(1800);
		driver.findElement(searchBox).sendKeys(teamName);
		boolean b = false;
		try {
			activeflag = driver.findElement(activeStatus).getAttribute("title");
			System.out.println("After deleting team active flag is " + activeflag);
			if (activeflag.equalsIgnoreCase("false")) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println("Active flag is " + activeflag);
			b = false;
		}
		return b;
	}

	public boolean deleteTeamToasterValidation() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("DeletedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean tabHeaderInOperatorTab() throws InterruptedException {
		driver.findElement(operatorTab).click();
		Thread.sleep(2000);
		boolean b = false;
		try {
			String oPtabHeader = driver.findElement(tabHeader).getText();
			if (oPtabHeader.equals("Operator")) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println("Header not displayed in OPearator tab");
			b = false;
		}
		return b;

	}

	public boolean availableFieldsUnderOperatorTab() {
		boolean b;
		try {
			driver.findElement(createNewOperatorBtn).isDisplayed();
			driver.findElement(displayNameHeader).isDisplayed();
			driver.findElement(firstOp).isDisplayed();
			driver.findElement(emailAddressHeader).isDisplayed();
			driver.findElement(employeeIDHeader).isDisplayed();
			driver.findElement(teamHeader).isDisplayed();
			driver.findElement(rolesHeader).isDisplayed();
			driver.findElement(statusHeader).isDisplayed();
			driver.findElement(searchBox).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean createNewOperatorAndCheckToaster() throws InterruptedException {
		randomText = RandomStringUtils.randomAlphabetic(7);
		driver.findElement(createNewOperatorBtn).click();
		Thread.sleep(2000);
		OpfirstName = "test" + randomText;

		OpLastName = "operator" + randomText;
		OpDisplayName = OpfirstName + " " + OpLastName;
		OpEmail = OpfirstName + OpLastName + "@neewee.ai";
		OpEmail = OpEmail.toLowerCase();

		System.out.println("Email id :" + OpEmail);

		driver.findElement(firstNameInput).sendKeys(OpfirstName);
		Thread.sleep(500);
		driver.findElement(lastNameInput).sendKeys(OpLastName);
		Thread.sleep(500);
		driver.findElement(emailInput).sendKeys(OpEmail);
		Thread.sleep(500);
		driver.findElement(paswordInput).sendKeys("Spider@1");
		Thread.sleep(500);
		RFID = "Nw" + randomNum;
		// driver.findElement(RFIDUIDinput).sendKeys(RFID);
		Thread.sleep(500);
		empID = "100" + randomNum;
		// driver.findElement(employeeIDinput).sendKeys(empID);
		Thread.sleep(500);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(1000);
		driver.findElement(selectGroupDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(2500);
		driver.findElement(chooseRleDD).click();
		Thread.sleep(1000);
		driver.findElement(opRole).click();
		driver.findElement(activeFlagToggleBtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		Thread.sleep(4000);
		return b;

	}

	public boolean toasterValidationOnCreateOperator() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean availabilityOfCreatedOp() throws InterruptedException {
		boolean b;
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(1000);
		String displayName = driver.findElement(firstOp).getAttribute("title");
		System.out.println("Op name displayed  " + displayName);
		System.out.println("Op name expected " + OpDisplayName);
		if (displayName.equals(OpDisplayName)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean functionalityOfSearchboxInOperatorTab() throws InterruptedException {
		boolean b;
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(1000);
		String displayName = driver.findElement(firstOp).getAttribute("title");
		System.out.println("Op name displayed  " + displayName);
		System.out.println("Op name expected " + OpDisplayName);
		if (displayName.equals(OpDisplayName)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean editOperatorAndToasterDisplayed() throws InterruptedException {

		Thread.sleep(2500);
		driver.findElement(OperatorThreeDot).click();
		System.out.println("Edit op 3 dot clicked");
		Thread.sleep(2500);
		driver.findElement(editTeamOption).click();
		System.out.println("editTeamOption clicked");

		Thread.sleep(2500);
		driver.findElement(firstNameInputEdit).clear();
		System.out.println("firstNameInput cleared");
		OpfirstName = OpfirstName + randomText;
		Thread.sleep(2500);
		driver.findElement(firstNameInputEdit).sendKeys(OpfirstName);
		System.out.println("firstNameInput sent");
		OpDisplayName = OpfirstName + " " + OpLastName;
		Thread.sleep(1200);
		System.out.println("Updated operator name " + OpDisplayName);
		driver.findElement(saveBtnEditOp).click();
		Thread.sleep(1500);
		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean toasterValidationOnEditOperator() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean availabilityOfEditedOperator() throws InterruptedException {
		boolean b;
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(1000);
		String displayName = driver.findElement(firstOp).getAttribute("title");
		System.out.println("Op name displayed  " + displayName);
		System.out.println("Op name expected " + OpDisplayName);
		if (displayName.equals(OpDisplayName)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean editOperatorTeamandCheckToaster() throws InterruptedException {
		OpteamBefore = driver.findElement(opTeamName).getAttribute("title");

		Thread.sleep(2500);
		driver.findElement(OperatorThreeDot).click();
		System.out.println("Edit op 3 dot clicked");
		Thread.sleep(2500);
		driver.findElement(editTeamOption).click();
		System.out.println("editTeamOption clicked");

		Thread.sleep(2500);
		driver.findElement(selectTeamDDedit).click();
		Thread.sleep(800);
		driver.findElement(opteamValueEdit).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEditOp).click();
		Thread.sleep(1200);

		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean toasterValidationOnEditOperatorTeam() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean verifyOperatorIsAddedToNewteam() throws InterruptedException {
		boolean b;
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(1000);

		OpteamAfter = driver.findElement(opTeamName).getAttribute("title");
		System.out.println("Op team before :" + OpteamBefore);
		System.out.println("Op team After :" + OpteamAfter);
		if (OpteamBefore.equals(OpteamAfter)) {
			b = false;
		}

		else {
			b = true;
		}

		return b;

	}

	public boolean editOperatorGroupAndCheckToaster() throws InterruptedException {
		try {
			driver.findElement(editOpPopupCloseBtn).click();
		} catch (Exception e) {
			System.out.println("Edit op popup not open ");
		}
		Thread.sleep(2000);

		boolean b;
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);

		Thread.sleep(2500);
		driver.findElement(OperatorThreeDot).click();
		System.out.println("Edit op grp 3 dot clicked");
		Thread.sleep(2500);
		driver.findElement(editTeamOption).click();
		System.out.println("editop Option clicked to edit grp");
		Thread.sleep(2000);
		OpteamBefore = driver.findElement(getOpGrp).getText();
		System.out.println("OpTeam before printed " + OpteamBefore);
		Thread.sleep(2500);
		driver.findElement(selectGroupDDedit).click();
		Thread.sleep(2000);
		driver.findElement(opteamValueEdit).click();
		Thread.sleep(2500);
		driver.findElement(saveBtnEditOp).click();
		Thread.sleep(1200);

		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean toasterValidationOnEditOperatorGrp() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean verifyOperatorIsAddedToNewGrp() throws InterruptedException {
		try {
			driver.findElement(editOpPopupCloseBtn).click();
		} catch (Exception e) {
			System.out.println("Edit op popup not open ");
		}

		boolean b;
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(1000);
		Thread.sleep(2500);
		driver.findElement(OperatorThreeDot).click();
		System.out.println("Edit op 3 dot clicked");
		Thread.sleep(2500);
		driver.findElement(editTeamOption).click();
		System.out.println("editTeamOption clicked");
		Thread.sleep(2000);
		OpteamAfter = driver.findElement(getOpGrp).getText();
		System.out.println("Op group before :" + OpteamBefore);
		System.out.println("Op group After :" + OpteamAfter);
		if (OpteamBefore.equals(OpteamAfter)) {
			b = false;
		}

		else {
			b = true;
		}

		return b;

	}

	public boolean deleteOperatorAndCheckToaster() throws InterruptedException {
		try {
			driver.findElement(editOpPopupCloseBtn).click();
		} catch (Exception e) {
			System.out.println("Edit op popup not open ");
		}

		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(1000);
		Thread.sleep(2500);
		driver.findElement(OperatorThreeDot).click();
		System.out.println("Edit op 3 dot clicked");
		Thread.sleep(2500);
		driver.findElement(editTeamOption).click();
		System.out.println("editTeamOption clicked");
		Thread.sleep(1000);
		driver.findElement(activeFlagToggleBtnDeactive).click();
		Thread.sleep(1500);
		driver.findElement(saveBtnEditOp).click();

		Thread.sleep(1200);
		boolean b;

		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean checkOperatorStatusPostDelete() throws InterruptedException {
		try {
			driver.findElement(editOpPopupCloseBtn).click();
		} catch (Exception e) {
			System.out.println("Edit op popup not open ");
		}

		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(2500);

		boolean b = false;
		try {
			activeflag = driver.findElement(activeStatus).getAttribute("title");
			System.out.println("After deleting team active flag is " + activeflag);
			if (activeflag.equalsIgnoreCase("false")) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println("Active flag is " + activeflag);
			b = false;
		}
		return b;

	}

	public boolean toasterValidationOndeleteOperator() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean reActiveTheDeletedUserAndCheckToaster() throws InterruptedException {

		try {
			driver.findElement(editOpPopupCloseBtn).click();
		} catch (Exception e) {
			System.out.println("Edit op popup not open ");
		}
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(1000);
		Thread.sleep(2500);
		driver.findElement(OperatorThreeDot).click();
		System.out.println("Edit op 3 dot clicked");
		Thread.sleep(2500);
		driver.findElement(editTeamOption).click();
		System.out.println("editTeamOption clicked");
		Thread.sleep(3000);
		driver.findElement(activeFlagToggleBtnDeactive).click();
		Thread.sleep(1500);
		driver.findElement(saveBtnEditOp).click();

		Thread.sleep(1200);
		boolean b;

		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean checkOperatorStatusPostReActive() throws InterruptedException {
		try {
			driver.findElement(editOpPopupCloseBtn).click();
		} catch (Exception e) {
			System.out.println("Edit op popup not open ");
		}

		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(2500);

		boolean b = false;
		try {
			activeflag = driver.findElement(activeStatus).getAttribute("title");
			System.out.println("After deleting team active flag is " + activeflag);
			if (activeflag.equalsIgnoreCase("true")) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println("Active flag is " + activeflag);
			b = false;
		}
		return b;

	}

	public boolean toasterValidationOnreActiveOperator() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean changeOperatorRoleAndCheckToaster() throws InterruptedException {
		try {
			driver.findElement(editOpPopupCloseBtn).click();
		} catch (Exception e) {
			System.out.println("Edit op popup not open ");
		}

		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(1000);
		Thread.sleep(2500);
		driver.findElement(OperatorThreeDot).click();
		System.out.println("Edit op 3 dot clicked");
		Thread.sleep(2500);
		driver.findElement(editTeamOption).click();
		System.out.println("editTeamOption clicked");
		Thread.sleep(3000);
		driver.findElement(chooseRoleDDedit).click();
		Thread.sleep(1500);
		driver.findElement(SlRole).click();
		Thread.sleep(2000);
		driver.findElement(saveBtnEditOp).click();

		Thread.sleep(1200);
		boolean b;

		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean toasterValidationOnChangingOperatorRole() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean verifyOperatorRoleIsUpdatedInOpList() throws InterruptedException {
		boolean b;
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(1500);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(1500);
		String updatedOProle = driver.findElement(editedOpRole).getAttribute("title");
		System.out.println("Updated Op role Expected:Shift Leader");
		System.out.println("Updated Op role Actual:" + updatedOProle);

		if (updatedOProle.equals("Shift Leader")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean createUserWithSameName() throws InterruptedException {

		driver.findElement(createNewOperatorBtn).click();
		Thread.sleep(2000);
		OpfirstName = "test" + randomText;

		OpLastName = "operator" + randomText;
		OpDisplayName = OpfirstName + " " + OpLastName;
		OpEmail = OpfirstName + OpLastName + "@neeweetest.ai";
		OpEmail = OpEmail.toLowerCase();

		System.out.println("Email id :" + OpEmail);

		driver.findElement(firstNameInput).sendKeys(OpfirstName);
		Thread.sleep(500);
		driver.findElement(lastNameInput).sendKeys(OpLastName);
		Thread.sleep(500);
		driver.findElement(emailInput).sendKeys(OpEmail);
		Thread.sleep(500);
		driver.findElement(paswordInput).sendKeys("Spider@1");
		Thread.sleep(500);

		Thread.sleep(500);
		empID = "100" + randomNum;
		// driver.findElement(employeeIDinput).sendKeys(empID);
		Thread.sleep(500);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(1000);
		driver.findElement(selectGroupDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(2500);
		driver.findElement(chooseRleDD).click();
		Thread.sleep(1000);
		driver.findElement(opRole).click();
		driver.findElement(activeFlagToggleBtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		Thread.sleep(4000);
		return b;

	}

	public boolean toasterValidationOnCreateOperatorWithSameName() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean availabilityOfCreatedOpWithSameName() throws InterruptedException {
		boolean b;
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(1000);
		String displayName = driver.findElement(firstOp).getAttribute("title");
		System.out.println("Op name displayed  " + displayName);
		System.out.println("Op name expected " + OpDisplayName);
		if (displayName.equals(OpDisplayName)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean createOperatorWithDuplicateEmailIDAndToasterDisplayed() throws InterruptedException {
		driver.findElement(createNewOperatorBtn).click();
		Thread.sleep(2000);
		OpfirstName = "test" + randomText;

		OpLastName = "operator" + randomText;
		OpDisplayName = OpfirstName + " " + OpLastName;
		OpEmail = OpfirstName + OpLastName + "@neeweetest.ai";
		OpEmail = OpEmail.toLowerCase();

		System.out.println("Email id :" + OpEmail);

		driver.findElement(firstNameInput).sendKeys(OpfirstName);
		Thread.sleep(500);
		driver.findElement(lastNameInput).sendKeys(OpLastName);
		Thread.sleep(500);
		driver.findElement(emailInput).sendKeys(OpEmail);
		Thread.sleep(500);
		driver.findElement(paswordInput).sendKeys("Spider@1");
		Thread.sleep(500);

		Thread.sleep(500);
		empID = "100" + randomNum;
		driver.findElement(employeeIDinput).sendKeys(empID);
		Thread.sleep(500);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(1000);
		driver.findElement(selectGroupDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(2500);
		driver.findElement(chooseRleDD).click();
		Thread.sleep(1000);
		driver.findElement(opRole).click();
		driver.findElement(activeFlagToggleBtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean availabilityOfCreatedOpWithSameEmail() throws InterruptedException {
		try {
			driver.findElement(createteamPopupCloseBtn).click();
		} catch (Exception e) {
			System.out.println("Edit op popup not open ");
		}

		driver.navigate().refresh();
		Thread.sleep(5000);
		boolean b;
		driver.findElement(searchBox).clear();
		Thread.sleep(1200);
		driver.findElement(searchBox).sendKeys(OpEmail);
		System.out.println("-----Checking how many Operator with the same name-----");
		Thread.sleep(2000);

		List<WebElement> e = driver.findElements(teams);
		int a = e.size();
		System.out.println("Available team with the name " + a);
		try {
			driver.findElement(searchBox).clear();
			Thread.sleep(1000);
			driver.findElement(createteamPopupCloseBtn).click();
		} catch (Exception e2) {

		}
		if (a == 1) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean toasterValidationOnCreateUserDuplicateEmail() {
		boolean b;
		System.out.println(ToasterMsg);
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		ToasterMsg = ToasterMsg.toLowerCase();
		if (ToasterMsg.contains("alreadyexists")) {
			b = true;
		}

		else {
			b = false;
		}
		return b;
	}

	public boolean createUserWithoutEmpIDAndCheckToaster() throws InterruptedException {
		String random = RandomStringUtils.randomAlphabetic(4);
		random = random.toLowerCase();
		driver.findElement(createNewOperatorBtn).click();
		Thread.sleep(1500);
		driver.findElement(operatorTab).click();

		Thread.sleep(2000);
		OpfirstName = "TestNoEmp" + random;
		OpLastName = random;
		OpEmail = OpfirstName + OpLastName + "@neewee.ai";
		OpEmail = OpEmail.toLowerCase();
		OpDisplayName = OpfirstName + " " + OpLastName;
		driver.findElement(firstNameInput).sendKeys(OpfirstName);
		Thread.sleep(500);
		driver.findElement(lastNameInput).sendKeys(OpLastName);
		Thread.sleep(500);
		driver.findElement(emailInput).sendKeys(OpEmail);
		Thread.sleep(500);
		driver.findElement(paswordInput).sendKeys("Spider@1");

		Thread.sleep(2500);
		driver.findElement(chooseRleDD).click();
		Thread.sleep(1000);
		driver.findElement(opRole).click();
		driver.findElement(activeFlagToggleBtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		Thread.sleep(4000);
		return b;

	}

	public boolean toasterValidationOnCreateOperatorWithoutEmpID() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean verifyAvailabilityOfTheCreatedOpInOperatorList() throws InterruptedException {

		boolean b;
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(1000);
		String displayName = driver.findElement(firstOp).getAttribute("title");
		System.out.println("Op name displayed  " + displayName);
		System.out.println("Op name expected " + OpDisplayName);
		if (displayName.equals(OpDisplayName)) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean headerValidationForOperatorRoleTab() throws InterruptedException {
		boolean b;
		Thread.sleep(2000);
		driver.findElement(operatorRoleTab).click();
		String opHeader = driver.findElement(OpRoleTabHeader).getText();
		System.out.println("operator role header " + opHeader);
		if (opHeader.equals("Operator Roles")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean availableFieldsUnderOperatorRoleTab() throws InterruptedException {
		boolean b;
		Thread.sleep(4000);
		try {
			driver.findElement(roleNameheader).isDisplayed();
			driver.findElement(searchBox).isDisplayed();
			driver.findElement(createNewRoleBtn).isDisplayed();
			driver.findElement(DescHeader).isDisplayed();
			driver.findElement(createdOnHeader).isDisplayed();
			b = true;
		} catch (Exception e) {
			System.out.println("Some missing fields in Operator role tab");
			b = false;
		}
		return b;

	}

	public boolean createNewRoleAndChecktoaster() throws InterruptedException {
		String randomTxt = RandomStringUtils.randomAlphabetic(4);
		OpRole = "Test" + " " + randomTxt;
		OpRoleDesc = "Role Created By Automation User";
		Thread.sleep(2000);
		driver.findElement(createNewRoleBtn).click();
		Thread.sleep(2000);
		driver.findElement(enterRoleInput).sendKeys(OpRole);
		Thread.sleep(1000);
		driver.findElement(enterRoleDescInput).sendKeys(OpRoleDesc);
		Thread.sleep(1200);
		driver.findElement(saveBtn).click();

		Thread.sleep(1200);
		boolean b;

		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean toasterMsgValidationOnCreateRole() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			System.out.println("Toaster Msg displayed is : " + ToasterMsg);
			b = false;
		}
		return b;
	}

	public boolean createdRoleDisplayedInOpRoleList() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpRole);
		Thread.sleep(1500);
		String roleDisplayed = driver.findElement(firstTeam).getAttribute("title");
		if (roleDisplayed.equals(OpRole)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean searchBoxFunctionalityInoperatorRoleTab() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(OpRole);
		Thread.sleep(1500);
		String roleDisplayed = driver.findElement(firstTeam).getAttribute("title");
		if (roleDisplayed.equals(OpRole)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean createdRoleAvailableUnderCreateNewOperator() throws InterruptedException {
		boolean b = false;
		driver.findElement(operatorTab).click();
		Thread.sleep(400);
		driver.findElement(createNewOperatorBtn).click();
		Thread.sleep(2500);
		driver.findElement(chooseRleDD).click();
		Thread.sleep(1500);
		List<WebElement> e = driver.findElements(roles);
		System.out.println(e);
		ArrayList<String> list = new ArrayList<>();

		int a = e.size();
		a = a + 1;
		for (int i = 0; i < a; i++) {

			System.out.println(e.get(i).getText());
			if (e.get(i).getText().equals(OpRole)) {
				System.out.println();
				System.out.println("Created Operator role found " + OpRole);
				b = true;
				break;
			} else {
				System.out.println("created role not found");
				b = false;

			}

		}
		return b;

	}

	public boolean editOpRoleAndChecktoaster() throws InterruptedException {
		Thread.sleep(2000);
		try {
			driver.findElement(createteamPopupCloseBtn).click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		boolean b;
		driver.findElement(operatorRoleTab).click();
		Thread.sleep(3500);
		driver.findElement(searchBox).sendKeys(OpRole);
		Thread.sleep(1500);
		driver.findElement(threeDotOpRole).click();
		Thread.sleep(1500);
		driver.findElement(editTeamOption).click();
		OpRole = OpRole + "randomrole";
		Thread.sleep(2500);
		driver.findElement(enterRoleInput).sendKeys(OpRole);
		driver.findElement(saveBtn).click();
		Thread.sleep(1400);
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		Thread.sleep(4000);
		return b;

	}

	public boolean toasterValidationOnEditOpRole() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean editedRoleIsUpdatedINroleList() throws InterruptedException {
		try {
			Thread.sleep(2000);
			driver.findElement(createteamPopupCloseBtn).click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(OpRole);
		Thread.sleep(2000);

		String Oproledisplayed = driver.findElement(firstTeam).getAttribute("title");
		System.out.println("Op role expected:" + OpRole);
		System.out.println("Op role displayed:" + Oproledisplayed);
		boolean b;
		if (Oproledisplayed.equals(Oproledisplayed)) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean deleteOperatorRoleAndCheckToaster() throws InterruptedException {
		Thread.sleep(1200);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(OpRole);
		Thread.sleep(2000);
		driver.findElement(threeDotOpRole).click();
		Thread.sleep(2000);
		driver.findElement(deleteRoleOption).click();
		Thread.sleep(2000);
		driver.findElement(deleteConfirmationBtn).click();
		boolean b;
		Thread.sleep(1400);
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		Thread.sleep(4000);
		return b;
	}

	public boolean toasterValidationOnDeleteOpRole() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("DeletedSuccessfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean deletedRoleNotPresentInroleList() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(OpRole);
		System.out.println("searching for the operator role");
		Thread.sleep(3500);

		boolean b = false;

		try {
			driver.findElement(firstTeam).isDisplayed();
			b = false;

		} catch (Exception e) {
			b = true;
		}

		return b;

	}

	public boolean createRoleWithDuplicateNameAndCheckToaster() throws InterruptedException {

		String randomTxt = RandomStringUtils.randomAlphabetic(4);
		OpRole = "Test" + " " + randomTxt;
		OpRoleDesc = "Role Created By Automation User";
		Thread.sleep(2000);
		driver.findElement(createNewRoleBtn).click();
		Thread.sleep(2000);
		driver.findElement(enterRoleInput).sendKeys(OpRole);
		Thread.sleep(1000);
		driver.findElement(enterRoleDescInput).sendKeys(OpRoleDesc);
		Thread.sleep(1200);
		driver.findElement(saveBtn).click();

		Thread.sleep(1500);

		driver.findElement(createNewRoleBtn).click();
		Thread.sleep(2000);
		driver.findElement(enterRoleInput).sendKeys(OpRole);
		Thread.sleep(1000);
		driver.findElement(enterRoleDescInput).sendKeys(OpRoleDesc);
		Thread.sleep(1200);
		driver.findElement(saveBtn).click();
		Thread.sleep(1400);

		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean toasterValidationOnCreateDuplicateOperatorRole() {
		boolean b;
		System.out.println(ToasterMsg);
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		ToasterMsg = ToasterMsg.toLowerCase();
		try {
			driver.findElement(createteamPopupCloseBtn).click();
		} catch (Exception e) {
			System.out.println("create role popup not open ----- ignore, there is not impact");
		}
		if (ToasterMsg.contains("alreadyexists")) {
			b = true;
		}

		else {
			b = false;
		}
		return b;
	}

	public boolean createRoleWithApostropheSymbolAndValidateToaster() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		List<WebElement> sizeOfRoles = driver.findElements(teams);
		size = sizeOfRoles.size();
		System.out.println("Number of Roles before creating team with With ApostropheSymbol: " + size);
		String randomTxt = RandomStringUtils.randomAlphabetic(4);
		OpRole = "Test'" + " " + randomTxt;
		OpRoleDesc = "Role Created By Automation User";
		Thread.sleep(2000);
		driver.findElement(createNewRoleBtn).click();
		Thread.sleep(2000);
		driver.findElement(enterRoleInput).sendKeys(OpRole);
		Thread.sleep(1000);
		driver.findElement(enterRoleDescInput).sendKeys(OpRoleDesc);
		Thread.sleep(1200);
		driver.findElement(saveBtn).click();

		Thread.sleep(1500);

		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean verifyNoRolesDeletedAfterCreatingRolesWithApostropheSymbol() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		try {
			driver.findElement(createteamPopupCloseBtn).click();
		} catch (Exception e) {

		}
		List<WebElement> a = driver.findElements(teams);
		int size = a.size();
		System.out.println("After creating new role With ApostropheSymbol team present: " + size);
		boolean b;
		if (this.size == size - 1) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean toasterMsgValidationOnCreateRoleWithApostropheSymbol() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			System.out.println("Toaster Msg displayed is : " + ToasterMsg);
			b = false;
		}
		return b;

	}

	public boolean createNewTeamWithWithApostropheSymbol() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(operatorTeamTab).click();
		Thread.sleep(3200);
		List<WebElement> sizeOfteams = driver.findElements(teams);
		size = sizeOfteams.size();
		System.out.println("Number of Roles before creating team with With ApostropheSymbol :" + size);

		String random = RandomStringUtils.randomAlphabetic(4);
		driver.findElement(operatorTeamTab).click();
		Thread.sleep(2000);

		driver.findElement(createNewTeamBtn).click();
		Thread.sleep(1500);
		teamName = "Test Operator Team' " + random;

		driver.findElement(enterTeamTitleInput).sendKeys(teamName);
		Thread.sleep(1500);
		driver.findElement(teamDescInput).sendKeys("Desc for New Team ");
		Thread.sleep(1000);
		driver.findElement(selectScopeDD).click();
		Thread.sleep(1000);
		driver.findElement(scopeValueByLocation).click();
		Thread.sleep(1500);
		driver.findElement(selectOrgNodeDD).click();
		Thread.sleep(1500);
		driver.findElement(orgNodeValue).click();
		Thread.sleep(1500);
		driver.findElement(effectiveStDatebtn).click();
		Thread.sleep(1500);
		driver.findElement(effectiveStdateInput).sendKeys("01012020");
		Thread.sleep(1500);
		driver.findElement(effectiveEndDatebtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);

		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean toasterMsgValidationOnCreateTeamWithApostropheSymbol() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			System.out.println("Toaster Msg displayed is : " + ToasterMsg);
			b = false;
		}
		return b;

	}

	public boolean verifyNoOperatorTeamsDeletedAfterCreatingRolesWithApostropheSymbol() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		try {
			driver.findElement(createteamPopupCloseBtn).click();
		} catch (Exception e) {

		}
		List<WebElement> a = driver.findElements(teams);
		int size = a.size();
		System.out.println("After creating new team With ApostropheSymbol team present: " + size);
		boolean b;
		if (this.size == size - 1) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean createoperatorWithDuplicateRFID() throws InterruptedException {
		String num = RandomStringUtils.randomNumeric(4);
		driver.findElement(operatorTab).click();
		Thread.sleep(3500);

		randomText = RandomStringUtils.randomAlphabetic(7);
		driver.findElement(createNewOperatorBtn).click();
		Thread.sleep(3200);
		OpfirstName = "test" + randomText;

		OpLastName = "operator" + randomText;
		OpDisplayName = OpfirstName + " " + OpLastName;
		OpEmail = OpfirstName + OpLastName + "@neewee.ai";
		OpEmail = OpEmail.toLowerCase();

		System.out.println("Email id :" + OpEmail);

		driver.findElement(firstNameInput).sendKeys(OpfirstName);
		Thread.sleep(500);
		driver.findElement(lastNameInput).sendKeys(OpLastName);
		Thread.sleep(500);
		driver.findElement(emailInput).sendKeys(OpEmail);
		Thread.sleep(500);
		driver.findElement(paswordInput).sendKeys("Spider@1");
		Thread.sleep(500);
		RFID = "Nw" + num;
		driver.findElement(RFIDUIDinput).sendKeys(RFID);
		Thread.sleep(500);
		empID = "100" + randomNum;
		// driver.findElement(employeeIDinput).sendKeys(empID);
		Thread.sleep(500);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(1000);
		driver.findElement(selectGroupDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(2500);
		driver.findElement(chooseRleDD).click();
		Thread.sleep(1000);
		driver.findElement(opRole).click();
		driver.findElement(activeFlagToggleBtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		System.out.println("RFID first operator created");
//-----------------------------------------------

		// driver.findElement(operatorTab).click();
		Thread.sleep(3500);

		driver.findElement(createNewOperatorBtn).click();
		System.out.println("created New operator Button clicked");
		Thread.sleep(4000);

		driver.findElement(firstNameInput).sendKeys(OpfirstName);
		Thread.sleep(500);
		driver.findElement(lastNameInput).sendKeys(OpLastName);
		Thread.sleep(500);
		driver.findElement(emailInput).sendKeys(OpEmail);
		Thread.sleep(500);
		driver.findElement(paswordInput).sendKeys("Spider@1");
		Thread.sleep(500);

		driver.findElement(RFIDUIDinput).sendKeys(RFID);
		Thread.sleep(500);
		empID = "100" + randomNum;
		// driver.findElement(employeeIDinput).sendKeys(empID);
		Thread.sleep(500);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(1000);
		driver.findElement(selectGroupDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(2500);
		driver.findElement(chooseRleDD).click();
		Thread.sleep(1000);
		driver.findElement(opRole).click();
		driver.findElement(activeFlagToggleBtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);

		// RFID UID already exists!!!

		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		Thread.sleep(4000);

		return b;

	}

	public boolean toasterMsgValidationOnCreateOperatorWithDuplicateRFID() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("RFIDUIDalreadyexists!!!")) {
			b = true;
		} else {
			System.out.println("Toaster Msg displayed is : " + ToasterMsg);
			b = false;
		}
		return b;

	}

	public boolean createoperatorWithDuplicateEmpID() throws InterruptedException {
		String numb = RandomStringUtils.randomNumeric(4);
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(operatorTab).click();
		Thread.sleep(3500);
		try {
			driver.findElement(createteamPopupCloseBtn).click();
			System.out.println("Popup closed");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		randomText = RandomStringUtils.randomAlphabetic(7);
		driver.findElement(createNewOperatorBtn).click();
		Thread.sleep(4000);
		OpfirstName = "test" + randomText;

		OpLastName = "operator" + randomText;
		OpDisplayName = OpfirstName + " " + OpLastName;
		OpEmail = OpfirstName + OpLastName + "@neewee.ai";
		OpEmail = OpEmail.toLowerCase();

		System.out.println("Email id :" + OpEmail);

		driver.findElement(firstNameInput).sendKeys(OpfirstName);
		Thread.sleep(500);
		driver.findElement(lastNameInput).sendKeys(OpLastName);
		Thread.sleep(500);
		driver.findElement(emailInput).sendKeys(OpEmail);
		Thread.sleep(500);
		driver.findElement(paswordInput).sendKeys("Spider@1");
		Thread.sleep(500);
		RFID = "Nw" + randomNum;
		// driver.findElement(RFIDUIDinput).sendKeys(RFID);
		Thread.sleep(500);
		empID = "100" + numb;
		driver.findElement(employeeIDinput).sendKeys(empID);
		Thread.sleep(500);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(1000);
		driver.findElement(selectGroupDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(2500);
		driver.findElement(chooseRleDD).click();
		Thread.sleep(1000);
		driver.findElement(opRole).click();
		driver.findElement(activeFlagToggleBtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		System.out.println("Employee ID First operator created");
//-----------------------------------------------
		OpDisplayName = firstNameInput + " " + OpfirstName;

		Thread.sleep(6000);

		driver.findElement(createNewOperatorBtn).click();
		Thread.sleep(3500);

		driver.findElement(firstNameInput).sendKeys(OpfirstName);
		Thread.sleep(500);
		driver.findElement(lastNameInput).sendKeys(OpLastName);
		Thread.sleep(500);
		driver.findElement(emailInput).sendKeys(OpEmail);
		Thread.sleep(500);
		driver.findElement(paswordInput).sendKeys("Spider@1");
		Thread.sleep(500);
		RFID = "Nw" + randomNum;
		// driver.findElement(RFIDUIDinput).sendKeys(RFID);
		Thread.sleep(500);
//		empID = "100" + randomNum;
		driver.findElement(employeeIDinput).sendKeys(empID);
		Thread.sleep(500);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(1000);
		driver.findElement(selectGroupDD).click();
		Thread.sleep(1000);
		driver.findElement(teamValue).click();
		Thread.sleep(2500);
		driver.findElement(chooseRleDD).click();
		Thread.sleep(1000);
		driver.findElement(opRole).click();
		driver.findElement(activeFlagToggleBtn).click();
		Thread.sleep(1500);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);

		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		Thread.sleep(4000);

		return b;

	}

	public boolean toasterMsgValidationOnCreateOperatorWithDuplicateEmpID() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("EmployeeIDAlreadyExists!")) {
			b = true;
		} else {
			System.out.println("Toaster Msg displayed is : " + ToasterMsg);
			b = false;
		}
		return b;

	}

	public boolean manageTeamAndCheckToaster() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5500);
		Thread.sleep(2000);
		driver.findElement(operatorTab).click();
		Thread.sleep(2000);
		createNewOperatorAndCheckToaster();
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(2000);

		OpteamBefore = driver.findElement(opTeamName).getText();
		System.out.println("Op team Before: " + OpteamBefore);
		Thread.sleep(2000);
		driver.findElement(OperatorThreeDot).click();
		Thread.sleep(1000);
		driver.findElement(manageOperatorOption).click();
		Thread.sleep(2000);
		driver.findElement(manageTeamDD).click();
		Thread.sleep(2000);
		driver.findElement(lastTeamValue).click();
		Thread.sleep(2000);
		driver.findElement(saveBtnManageTeam).click();
		Thread.sleep(1500);

		boolean b;
		try {
			ToasterMsg = driver.findElement(toaster).getText();
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean manageTeamToasterValidation() {
		boolean b;
		ToasterMsg = ToasterMsg.replaceAll(" ", "");
		if (ToasterMsg.equals("SavedSuccessfully!")) {
			b = true;
		} else {
			System.out.println("Toaster Msg displayed is : " + ToasterMsg);
			b = false;
		}
		return b;

	}

	public boolean operatorTeamIsUpdatedBymanageTeamFunctionality() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(OpEmail);
		Thread.sleep(2000);

		OpteamAfter = driver.findElement(opTeamName).getText();
		System.out.println("Op team After: " + OpteamAfter);
		Thread.sleep(2000);
		boolean b;
		if (OpteamAfter.equalsIgnoreCase(OpteamBefore)) {
			b = false;
		} else {
			b = true;
		}
		return b;
	}
	
	
	public boolean skillMatrixHeaderVal() throws InterruptedException {
		boolean b;
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(skillMatrixTab).click();
		Thread.sleep(2500);
		String th=driver.findElement(tabHeader).getText();
		th=th.replaceAll(" ", "");
		System.out.println(th);
		if(th.equals("SkillMatrix")) {
			b=true;
		}
		else {
			b=false;
		}
		return b;
		
	}
	
	public boolean availableFieldsUnderSkillMatrix() {
		boolean b;
		try {
			driver.findElement(operatorSklMtrx).isDisplayed();
			driver.findElement(productSklMtrx).isDisplayed();
			driver.findElement(buildIngSklMtrx).isDisplayed();
			driver.findElement(taskSklMtrx).isDisplayed();
			b=true;
		} catch (Exception e) {
			b=false;
		}
		return b;
	}
	
	public boolean uploadAndDownloadBtnAvailable() {
		boolean b;
		try {
			driver.findElement(uploadSkillMatrix).isDisplayed();
			driver.findElement(downloadSkillMatrix).isDisplayed();
		b=true;
		} catch (Exception e) {
			System.out.println("Upload skill matrix or download skill matrix button not available ");
			b=false;
		}
		return b;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
