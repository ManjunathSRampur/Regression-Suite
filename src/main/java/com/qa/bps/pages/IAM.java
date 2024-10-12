package com.qa.bps.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;

public class IAM {

	WebDriver driver;
	Navigation navigateTo;
	Logger log = Logger.getLogger(IAM.class);
	public static By createUserBtn = By.xpath("//*[contains(text(),'Create User')]");
	private By firstName = By.xpath("//input[@id='firstName']");
	private By lastName = By.xpath("//input[@id='lastName']");
	private By emailId = By.xpath("//input[@id='email']");
	public static By password = By.xpath("//input[@name='password']");
	private By mobileNo = By.xpath("//input[@id='phoneNumber']");
	private By activeCheckbox = By.xpath("//input[@id='active']");
	private By userRoleIcon = By.xpath("//a[@data-target='#v-pills-user-role']");
	private By analystRadioBtn = By.xpath("( //input[@name='role'])[5]");
	private By adminRadioBtn = By.xpath("//label[contains(text(),'Administrator')]");
	private By operatorRole = By.xpath("//label[.=' Operator ']");
	private By userGroupIcon = By.xpath("//a[@aria-controls='v-pills-user-group']");
	private By userGroupsDropdown = By.xpath("//input[@role='combobox']");
	private By dropdownOption = By.xpath("(//div[@role='option'])[1]");
	private By saveBtnEle = By.xpath("(//button[.=' Save '])[2]");
	private By pwdResetBtn = By.xpath("//button[.='Save']");
	private By createUserToaster = By.xpath("//div[@role='alertdialog']");
	private By userGroupBtn = By.xpath("(//a[@data-toggle='pill'])[2]");
	private By createGroupBtn = By.xpath("//button[@data-target='#addUserGroupModal']");
	private By enterGroupName = By.xpath("//input[@placeholder='Enter Group Name...']");
	private By grpNameInput = By.xpath("//input[@id='groupName']");
	private By enterDspFld = By.xpath("//input[@id='groupDescModal']");
	private By createBtn = By.xpath("//button[@class='btn btn-sm' and text()='Create']");
	private By saveBtn = By.xpath("(//button[@Type='button' and contains(text(),'Save')])[2]");
	private By createRoleIcn = By.xpath("//a[@aria-controls='v-pills-userroles']");
	private By createRoleBtn = By.xpath("//button[@class='button-primary btn-sm']");
	private By enterRoleName = By.xpath("//input[@name='roleName']");
	private By enterRoleDesp = By.xpath("//input[@name='roleDesc']");
	private By activeCheckBox = By.xpath("//div[@class='input-group-text ']/input");
	private By searchGrpName = By.xpath("//input[@placeholder='Search..']");
	private By firstGroupName = By.xpath("(//div[@tabulator-field='group_name'] )[2]");
	private By searchRoleName = By.xpath("//input[@placeholder='Search..']");
	private By firstRoleName = By.xpath("(//div[@tabulator-field='group_name'] )[2]");
	private By saveRoleBtn = By.xpath("(//button[contains(text(),' Save ')])[2]");
	private By infoIcon = By.xpath("//*[@data-icon='info-circle']");
	private By searchTextField = By.xpath("//input[@placeholder='Search..']");
	private By usersName = By.xpath("(//div[@tabulator-field='user_name'])[2]");
	private By searchUser = By.xpath("//input[@placeholder='Search..']");
	private By displayedOperatorEle = By.xpath("//div[@role='row']");
	public static By userThreeDot = By.xpath("(//div[@role='gridcell'])[7]");
	private By deleteUser = By.xpath("(//div[@class='tabulator-menu']//div)[4]");
	public static By resetPwd = By.xpath("(//div[@class='tabulator-menu']//div)[3]");

	private By userToDelete = By.xpath("//input[@id='userToDelete']");
	private By delete = By.xpath("(//button[contains(text(),'Delete')])[2]");
	private By deleteUserToast = By.xpath("//div[@id='toast-container']//div");
	private By groupThreeDot = By.xpath("(//div[@role='gridcell'])[4]");
	private By deleteGroup = By.xpath("(//div[@class='tabulator-menu']//div)[2]");
	private By userGroupDelete = By.xpath("//input[@id='userGroupForDelete']");
	private By deleteGroupToast = By.xpath("//div[@id='toast-container']/div");
	private By roleThreeDot = By.xpath("(//div[@role='gridcell'])[6]");
	private By deleteRole = By.xpath("(//div[@class='tabulator-menu']//div)[5]");
	private By userRoleDelete = By.xpath("//input[@id='userRoleForDelete']");
	private By deleteRoleToast = By.xpath("//div[@id='toast-container']");
	private By editUser = By.xpath("(//div[@class='tabulator-menu']//div)[1]");
	private By manageGroup = By.xpath("//div[@class='tabulator-menu-item'][2]");
	private By userGroupDD = By.xpath("//div[@class='ng-input']");
	private By userGroupValue = By.xpath("(//div[@role='option'])[1]");
	private By editUserToaster = By.xpath("//div[@id='toast-container']");
	private By editGroup = By.xpath("(//div[@class='tabulator-menu']//div)[1]");
	private By editGroupToast = By.xpath("//div[@id='toast-container']//div");
	private By editGrpDscpField = By.xpath("//input[@id='groupDesc']");
	private By editRole = By.xpath("(//div[@class='tabulator-menu']//div)[1]");
	private By editRoleToast = By.xpath("//div[@id='toast-container']");
	private By fetatureTab = By.xpath("//a[@id='v-pills-features-tab']");
	private By featureCheckBox = By.xpath("(//div[@tabulator-field='Administrator'])[4]");
	private By DateBox = By.xpath("//input[@placeholder='Date']");
	private By firsttask = By.xpath(EventProperties.event_Id);
	private By featureBtn = By.xpath(
			"//div[.=' Start Task ' or .=' Mark as Completed ' or .=' Log Asset Status ' or .=' Change Allocated Equipment ' or .=' Reset ']");
	private By employeeId = By.xpath("//input[@id='employeeId']");
	private By empolyeIdEle = By.xpath("(//div[@tabulator-field='employee_id'])[2]");
	private By newPasswordEle = By.xpath("//input[@id='newPassword']");
	private By confrmPassword = By.xpath("//input[@id='confirmNewPassword']");
	private By closeCreatePopUp = By.xpath("//div[@class='row']/a/fa-icon");
	private By aNumberCheckBoxAdminConsole = By.xpath("(//input[@type='checkbox'])[1]");
	private By aCapitalLatterCheckBoxAdminConsole = By.xpath("(//input[@type='checkbox'])[2]");
	private By aLowerCaselLatterCheckBoxAdminConsole = By.xpath("(//input[@type='checkbox'])[3]");
	private By minimumLengthInputAdminConsole = By.xpath("(//input[@min='1'])[1]");
	private By maximumLengthInputAdminConsole = By.xpath("(//input[@min='1'])[2]");
	private By specialCharAdminConsole = By.xpath("(//input[@type='text'])[2]");
	private By createdUserEmail = By.xpath("(//div[@role='gridcell'])[8]");
	private By saveBtnAdminConsole = By.xpath("(//button[contains(text(),'Save')])[2]");
	private By DisplayNameInIAM = By.xpath("(//div[@role='gridcell'])[6]");
	private By createdGrpName = By.xpath("(//div[@role='gridcell'])[3]");
	private By UserStatus = By.xpath("(//div[@role='gridcell'])[13]");
	private By groupToDeleteInput = By.xpath("//input[@id='userGroupForDelete']");
	private By availableGrpNames = By.xpath("//div[@tabulator-field='group_name']");
	private By userGrp = By.xpath("(//div[@role='option'])[1]");
	private By getToaster = By.xpath("//div[@role='alertdialog']");
	private By createdRole = By.xpath("(//div[@role='gridcell'])[5]");
	private By AvailableRoleNames = By.xpath("//div[@tabulator-field='role_name']");
	private By rfidEle = By.xpath("//input[@name='rfidNumber']");

	public static By newPassword = By.xpath("//input[@name='newPassword']");
	private String du;
	private String lnUpdate;
	String roleName;
	String grpName;
	String editedgrpname;
	String rfid;

	private String fn;
	private String ln;
	private String email;
	public String ToasterMsg = "null";
	private ElementUtil eleUtil;
	private String actualUserName;
	private String searchString;
	private String eut;
	private String ceu;
	private String emailValue;
	private String employeeNumber;
	String duplicateMailId;
	String emlId;
	String successToasterMsg;
	String firstNameValue;

	public IAM(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		navigateTo = new Navigation(driver);

	}

	public void preReq() throws InterruptedException {
		navigateTo.adminConsole();
	}

	public void configurePasswordPolicy() throws InterruptedException {
		try {
			driver.findElement(aNumberCheckBoxAdminConsole).isSelected();
		} catch (Exception e) {
			driver.findElement(aNumberCheckBoxAdminConsole).click();
		}
		Thread.sleep(1000);
		try {
			driver.findElement(aCapitalLatterCheckBoxAdminConsole).isSelected();
		} catch (Exception e) {
			driver.findElement(aCapitalLatterCheckBoxAdminConsole).click();
		}
		Thread.sleep(1000);
		try {
			driver.findElement(aLowerCaselLatterCheckBoxAdminConsole).isSelected();
		} catch (Exception e) {
			driver.findElement(aLowerCaselLatterCheckBoxAdminConsole).click();
		}
		Thread.sleep(2000);
		driver.findElement(minimumLengthInputAdminConsole).clear();
		Thread.sleep(2500);
		driver.findElement(minimumLengthInputAdminConsole).sendKeys("5");

		Thread.sleep(2500);
		driver.findElement(maximumLengthInputAdminConsole).clear();
		Thread.sleep(2500);
		driver.findElement(maximumLengthInputAdminConsole).sendKeys("22");
		Thread.sleep(2000);
		driver.findElement(specialCharAdminConsole).clear();
		Thread.sleep(2000);
		driver.findElement(specialCharAdminConsole).sendKeys("@");
		Thread.sleep(2000);
		driver.findElement(saveBtnAdminConsole).click();
		Thread.sleep(2000);

	}

	public void navigateToIAM() throws InterruptedException {
		navigateTo.IAM();
	}

	// Verify user is able to create an user and success message displayed as
	// expected
	public boolean CreateUser() throws InterruptedException {

		Thread.sleep(4000);

		driver.findElement(createUserBtn).click();
		String randomText = RandomStringUtils.randomAlphabetic(2);
		String FirstName = "Test" + randomText;
		String LastName = "User" + randomText;
		emlId = FirstName + LastName + "@neewee.ai";
		String pswd = "Spider@45$";
		driver.findElement(firstName).sendKeys(FirstName);
		Thread.sleep(1000);
		driver.findElement(lastName).sendKeys(LastName);
		Thread.sleep(1000);

		driver.findElement(emailId).sendKeys(emlId);
		Thread.sleep(1000);

		driver.findElement(password).sendKeys(pswd);
		Thread.sleep(1000);

		driver.findElement(activeCheckbox).click();
		Thread.sleep(2000);
		driver.findElement(userRoleIcon).click();
		Thread.sleep(1000);

		driver.findElement(adminRadioBtn).click();
		Thread.sleep(1000);

		driver.findElement(userGroupIcon).click();
		Thread.sleep(1200);
		driver.findElement(userGroupsDropdown).click();
		Thread.sleep(1200);
		driver.findElement(userGrp).click();
		Thread.sleep(1500);

		driver.findElement(saveBtnEle).click();
		Thread.sleep(1200);
		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println(ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}

		Thread.sleep(2000);
		driver.findElement(searchTextField).clear();
		driver.findElement(searchTextField).sendKeys(emlId);
		Thread.sleep(2000);
		boolean b = true;
		try {
			String createdUserMail = driver.findElement(createdUserEmail).getAttribute("title");
			emlId.equalsIgnoreCase(createdUserMail);
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean verifyToasterMessageAfterCreatingNewUser() {
		boolean b = true;
		if (ToasterMsg.equals("User Details Updated Successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean editUser() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);

		driver.findElement(userThreeDot).click();
		Thread.sleep(2000);
		driver.findElement(editUser).click();
		Thread.sleep(2000);
		driver.findElement(firstName).clear();
		String randomText = RandomStringUtils.randomAlphabetic(5);
		driver.findElement(firstName).sendKeys(randomText);
		Thread.sleep(2000);
		driver.findElement(saveBtnEle).click();
		Thread.sleep(1000);
		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println(ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}

		driver.findElement(searchTextField).clear();
		driver.findElement(searchTextField).sendKeys(emlId);
		Thread.sleep(2000);

		String editedUserName = driver.findElement(DisplayNameInIAM).getAttribute("title");
		String[] a = editedUserName.split(" ");
		boolean b = true;
		if (a[0].equals(randomText)) {
			System.out.println(a[0]);
			System.out.println(randomText);
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean verifyToasterMessageAfterEditUserDetails() {
		boolean b = true;
		if (ToasterMsg.equals("User Details Updated Successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	// User Deleted Successfully!

	public boolean deleteUser() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		Thread.sleep(2000);
		driver.findElement(searchTextField).clear();
		driver.findElement(searchTextField).sendKeys(emlId);
		Thread.sleep(2000);

		driver.findElement(userThreeDot).click();
		Thread.sleep(5000);
		driver.findElement(deleteUser).click();
		Thread.sleep(4000);
		driver.findElement(userToDelete).sendKeys(emlId);
		Thread.sleep(5000);
		driver.findElement(delete).click();
		Thread.sleep(1000);
		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println(ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}

		Thread.sleep(2000);
		driver.findElement(searchTextField).clear();
		driver.findElement(searchTextField).sendKeys(emlId);
		Thread.sleep(2000);

		String value = driver.findElement(UserStatus).getAttribute("title");
		boolean b = true;
		if (value.equalsIgnoreCase("false")) {
			b = true;
		} else {
			b = false;
		}
		return b;
		// log.info("-------Deleted IAM user successfully-------");

	}

	public boolean verifyToasterMessageAfterDeletingUser() {
		boolean b = true;
		if (ToasterMsg.equals("User Deleted Successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean CreateUserGroups() throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(userGroupBtn).click();
		Thread.sleep(2000);
		driver.findElement(createGroupBtn).click();

		String randomText = RandomStringUtils.randomAlphanumeric(2);
		grpName = "TestUser Group " + randomText;
		Thread.sleep(3000);
		driver.findElement(enterGroupName).sendKeys(grpName);
		Thread.sleep(3000);
		driver.findElement(enterDspFld).sendKeys(grpName);
		Thread.sleep(3000);
		driver.findElement(createBtn).click();
		Thread.sleep(4000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);

		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println(ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}

		driver.findElement(searchTextField).clear();
		Thread.sleep(2000);

		driver.findElement(searchTextField).sendKeys(grpName);
		Thread.sleep(2000);

		String grpname = driver.findElement(createdGrpName).getAttribute("title");
		System.out.println(grpname);
		System.out.println(grpName);
		boolean b = true;
		if (grpName.equals(grpname)) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean verifyToasterMessageAfterCreatingUserGroup() {
		boolean b = true;
		if (ToasterMsg.equals("User Group Created Successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean editUserGroup() throws InterruptedException {
		driver.findElement(searchTextField).clear();
		Thread.sleep(2000);
		String randomText = RandomStringUtils.randomAlphanumeric(2);
		String editedGrpName = grpName + " " + randomText;
		driver.findElement(searchTextField).sendKeys(grpName);
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.findElement(groupThreeDot).click();
		Thread.sleep(3000);
		driver.findElement(editGroup).click();
		driver.findElement(grpNameInput).clear();
		Thread.sleep(1500);
		driver.findElement(grpNameInput).sendKeys(editedGrpName);
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);

		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println(ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}
		driver.findElement(searchTextField).clear();
		Thread.sleep(1200);
		driver.findElement(searchTextField).sendKeys(editedGrpName);
		Thread.sleep(1200);
		editedgrpname = driver.findElement(createdGrpName).getAttribute("title");

		boolean b = true;

		if (editedgrpname.equalsIgnoreCase(editedGrpName)) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean verifyToasterMessageAfterEditUserGroup() {
		boolean b = true;
		if (ToasterMsg.equals("User Group Details Updated Successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean deleteUserGroup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		Thread.sleep(1800);
		driver.findElement(searchTextField).clear();
		Thread.sleep(1200);
		driver.findElement(searchTextField).sendKeys(editedgrpname);
		Thread.sleep(1200);
		driver.findElement(groupThreeDot).click();
		// Thread.sleep(4000);
		driver.findElement(deleteGroup).click();
		Thread.sleep(4000);
		driver.findElement(groupToDeleteInput).sendKeys(editedgrpname);
		Thread.sleep(2000);
		driver.findElement(delete).click();
		Thread.sleep(1000);

		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println(ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}
		Thread.sleep(2000);
		driver.findElement(searchTextField).clear();
		Thread.sleep(1200);
		driver.findElement(searchTextField).sendKeys(editedgrpname);
		List<String> grpNameValue = new ArrayList<String>();
		List<WebElement> groupNames = driver.findElements(availableGrpNames);
		for (WebElement name : groupNames) {

			grpNameValue.add(name.getText());

		}
		System.out.println(grpNameValue);
		boolean b = true;
		if (grpNameValue.contains(editedgrpname)) {
			b = false;
		} else {
			b = true;
		}
		return b;

	}

	public boolean verifyToasterMessageAfterDeleteUserGroup() {
		boolean b = true;
		if (ToasterMsg.equals("User Group Deleted Successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean CreateRole() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(createRoleIcn).click();
		driver.findElement(createRoleBtn).click();
		String randomText = RandomStringUtils.randomAlphanumeric(2);
		roleName = "Test " + randomText;
		driver.findElement(enterRoleName).sendKeys(roleName);
		driver.findElement(enterRoleDesp).sendKeys(roleName);
		Thread.sleep(5000);
		driver.findElement(activeCheckBox).click();
		Thread.sleep(5000);
		driver.findElement(saveRoleBtn).click();
		Thread.sleep(1000);
		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println(ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}
		driver.findElement(searchRoleName).clear();
		Thread.sleep(1000);
		driver.findElement(searchRoleName).sendKeys(roleName);
		Thread.sleep(1000);
		String rn = driver.findElement(createdRole).getAttribute("title");
		boolean b = true;
		if (roleName.equals(rn)) {
			b = true;
		}

		else {
			b = false;
		}
		return b;

	}

	public boolean verifyToasterMessageAftercreatingNewRole() {
		boolean b = true;
		if (ToasterMsg.equals("User Role Created Successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean editUserRole() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(searchRoleName).clear();
		Thread.sleep(1000);
		driver.findElement(searchRoleName).sendKeys(roleName);
		Thread.sleep(1000);

		driver.findElement(roleThreeDot).click();
		Thread.sleep(3000);
		driver.findElement(editRole).click();
		Thread.sleep(3000);
		String rt = RandomStringUtils.randomAlphabetic(2);
		driver.findElement(enterRoleName).clear();
		roleName = rt + "Updated";
		driver.findElement(enterRoleName).sendKeys(roleName);
		driver.findElement(saveRoleBtn).click();
		Thread.sleep(1000);
		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println(ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}

		driver.findElement(searchRoleName).clear();
		Thread.sleep(1000);
		driver.findElement(searchRoleName).sendKeys(roleName);
		Thread.sleep(1000);

		String rn = driver.findElement(createdRole).getAttribute("title");
		System.out.println("Expected " + roleName);
		System.out.println("Actual " + rn);
		boolean b = true;
		if (roleName.equals(rn)) {
			b = true;
		}

		else {
			b = false;
		}
		return b;

	}

	public boolean verifyToasterMessageAfterEditUserRole() {
		boolean b = true;
		if (ToasterMsg.equals("User Role Updated Successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean deleteUserRole() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		driver.findElement(roleThreeDot).click();
		Thread.sleep(2000);
		driver.findElement(deleteRole).click();
		Thread.sleep(2000);
		driver.findElement(userRoleDelete).sendKeys(roleName);
		Thread.sleep(3000);
		driver.findElement(delete).click();
		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println(ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}

		Thread.sleep(1200);

		driver.findElement(searchRoleName).clear();
		Thread.sleep(1000);
		driver.findElement(searchRoleName).sendKeys(roleName);
		Thread.sleep(1000);

		List<String> grpNameValue = new ArrayList<String>();
		List<WebElement> groupNames = driver.findElements(AvailableRoleNames);
		for (WebElement name : groupNames) {

			grpNameValue.add(name.getText());

		}
		System.out.println(grpNameValue);
		boolean b = true;
		if (grpNameValue.contains(roleName)) {
			b = false;
		} else {
			b = true;
		}
		return b;

	}

	public boolean deleteRoleToaster() {

		boolean b = true;
		if (ToasterMsg.equals("User Role Deleted Successfully!")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean verifyFunctOfAcessModifierTest() throws InterruptedException {
		driver.findElement(fetatureTab).click();
		Thread.sleep(3000);
		driver.findElement(searchTextField).sendKeys("equipmentallocation");
		Thread.sleep(2000);
		driver.findElement(featureCheckBox).click();
		Thread.sleep(2000);
		driver.findElement(saveBtnEle).click();

		Thread.sleep(2000);
		navigateTo.VSB();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(firsttask).click();
		Thread.sleep(4000);
		try {
			driver.findElement(featureBtn).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean verifyFunctOfAcessModifierTrueTest() throws InterruptedException {
		navigateTo.IAM();
		Thread.sleep(4000);
		driver.findElement(fetatureTab).click();
		Thread.sleep(3000);
		driver.findElement(searchTextField).sendKeys("equipmentallocation");
		Thread.sleep(2000);
		driver.findElement(featureCheckBox).click();
		Thread.sleep(2000);
		driver.findElement(saveBtnEle).click();
		Thread.sleep(2000);
		navigateTo.VSB();
		Thread.sleep(4000);
		driver.findElement(DateBox).sendKeys(EventProperties.task_Date);
		Thread.sleep(6000);
		driver.findElement(firsttask).click();
		Thread.sleep(4000);
		try {
			driver.findElement(featureBtn).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanCreateWithEmployeeIdTest() throws InterruptedException {
		String randomText = RandomStringUtils.randomAlphabetic(8);
		employeeNumber = RandomStringUtils.randomNumeric(4);
		String firstNameValue = randomText;
		String lastNameValue = randomText;
		emailValue = firstNameValue + "." + lastNameValue + "@neewee.ai";
		String pwd = "Spider@$1";
		navigateTo.IAM();
		Thread.sleep(2000);
		driver.findElement(createUserBtn).click();
		Thread.sleep(1000);
		driver.findElement(firstName).sendKeys(firstNameValue);
		driver.findElement(lastName).sendKeys(lastNameValue);
		driver.findElement(emailId).sendKeys(emailValue);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(employeeId).sendKeys(employeeNumber);
		System.out.println("employee id is " + employeeNumber);
		Thread.sleep(2000);
		driver.findElement(userRoleIcon).click();
		Thread.sleep(2000);
		driver.findElement(operatorRole).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEle).click();
		String successToasterMsg = "null";
		Thread.sleep(1500);
		try {
			successToasterMsg = driver.findElement(createUserToaster).getText();
		} catch (Exception e) {

		}
		System.out.println("Toaster message is *" + successToasterMsg + "*");
		if (successToasterMsg.equals("User Details Updated Successfully!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyCreatedOperatorIsDisplayed() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(searchUser).sendKeys(emailValue);
		Thread.sleep(2000);
		try {
			driver.findElement(displayedOperatorEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserCanEditEmpIdTest() throws InterruptedException {
		driver.findElement(userThreeDot).click();
		driver.findElement(editUser).click();
		Thread.sleep(1000);
		driver.findElement(employeeId).clear();
		Thread.sleep(1500);
		driver.findElement(employeeId).sendKeys(employeeNumber + "1");
		driver.findElement(saveBtnEle).click();
		Thread.sleep(500);
		String successToasterMsg = "null";
		try {
			successToasterMsg = driver.findElement(createUserToaster).getText();
		} catch (Exception e) {

		}
		if (successToasterMsg.equals("User Details Updated Successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyEmpLoyeeIdChangedToNullAfterManageTeamTest() throws InterruptedException {
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(searchUser).clear();
		Thread.sleep(1000);
		driver.findElement(searchUser).sendKeys(emailValue);
		driver.findElement(userThreeDot).click();
		Thread.sleep(1000);
		driver.findElement(manageGroup).click();
		Thread.sleep(1000);
		driver.findElement(userGroupDD).click();
		Thread.sleep(1000);
		driver.findElement(userGroupValue).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEle).click();
		Thread.sleep(1000);
		driver.findElement(searchUser).clear();
		Thread.sleep(1000);
		driver.findElement(searchUser).sendKeys(emailValue);
		Thread.sleep(1000);
		String employeeIdValue = driver.findElement(empolyeIdEle).getText();
		if (!employeeIdValue.equals("null")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyEmployeeIdChnageToNullAfterResetPwdTest() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(searchUser).clear();
		Thread.sleep(1000);
		driver.findElement(searchUser).sendKeys(emailValue);
		driver.findElement(userThreeDot).click();
		driver.findElement(resetPwd).click();
		Thread.sleep(1000);
		driver.findElement(newPasswordEle).sendKeys("Neewee@$1");
		Thread.sleep(1000);
		driver.findElement(confrmPassword).sendKeys("Neewee@$1");
		driver.findElement(pwdResetBtn).click();
		Thread.sleep(500);
		driver.findElement(searchUser).clear();
		Thread.sleep(1000);
		driver.findElement(searchUser).sendKeys(emailValue);
		String employeeIdValue = driver.findElement(empolyeIdEle).getText();
		if (!employeeIdValue.equals("null")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUserCanCreateTheOperatorWithExistingEmpIdTest() throws InterruptedException {

		String randomText = RandomStringUtils.randomAlphabetic(9);
		String firstNameValue = "Test" + randomText;
		String lastNameValue = "Test" + randomText;
		String mailIds = firstNameValue + "." + lastNameValue + "@neewee.ai";

		String pwd = "Spi@" + "1234";
		navigateTo.IAM();
		Thread.sleep(2000);
		driver.findElement(createUserBtn).click();
		Thread.sleep(1000);
		driver.findElement(firstName).sendKeys(firstNameValue);
		driver.findElement(lastName).sendKeys(lastNameValue);
		driver.findElement(emailId).sendKeys(mailIds);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(employeeId).sendKeys(employeeNumber + "1");
		System.out.println("employee id is " + employeeNumber);
		Thread.sleep(2000);
		driver.findElement(userRoleIcon).click();
		Thread.sleep(2000);
		driver.findElement(operatorRole).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEle).click();
		successToasterMsg = "null";
		Thread.sleep(1500);

		try {
			successToasterMsg = driver.findElement(createUserToaster).getText();
			System.out.println(successToasterMsg);

		} catch (Exception e) {
			System.out.println(successToasterMsg);

		}
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(searchUser).clear();
		Thread.sleep(1000);
		driver.findElement(searchUser).sendKeys(mailIds);

		try {
			driver.findElement(displayedOperatorEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyTheToasterMsgAfterCreatingUserWithSameEmpIdTest() {
		System.out.println("Toaster message while creating user with same employee id *" + successToasterMsg);
		if (successToasterMsg.equals("Employee ID already exists!!!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyUserCanCreateTheOperatorByEnteringSpaceInEmpFieldTest() throws InterruptedException {
		try {
			driver.findElement(closeCreatePopUp).click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}

		String randomText = RandomStringUtils.randomAlphabetic(9);
		String firstNameValue = randomText;
		String lastNameValue = randomText;
		String mailIds = firstNameValue + "." + lastNameValue + "@neewee.ai";
		String pwd = "Spi@" + "1234";
		navigateTo.IAM();
		Thread.sleep(2000);
		driver.findElement(createUserBtn).click();
		Thread.sleep(1000);
		driver.findElement(firstName).sendKeys(firstNameValue);
		driver.findElement(lastName).sendKeys(lastNameValue);
		driver.findElement(emailId).sendKeys(mailIds);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(employeeId).sendKeys("   ");
		Thread.sleep(2000);
		driver.findElement(userRoleIcon).click();
		Thread.sleep(2000);
		driver.findElement(operatorRole).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEle).click();
		String successToasterMsg = "null";
		try {
			successToasterMsg = driver.findElement(createUserToaster).getText();
			System.out.println(successToasterMsg);
			return false;
		} catch (Exception e) {
			System.out.println(successToasterMsg);
			return true;
		}

	}

	public boolean verifyUserIsAbleToCreateAUserWithSpecialCharacterTest() throws InterruptedException {
		navigateTo.IAM();
		Thread.sleep(2000);
		String randomText = RandomStringUtils.randomAlphabetic(9);
		String firstNameValue = randomText;
		String lastNameValue = randomText;
		String mailIds = firstNameValue + "." + lastNameValue + "@neewee.ai";
		String pwd = "Spi@" + "1234";
		navigateTo.IAM();
		Thread.sleep(2000);
		driver.findElement(createUserBtn).click();
		Thread.sleep(1000);
		driver.findElement(firstName).sendKeys(firstNameValue + "'");
		driver.findElement(lastName).sendKeys(lastNameValue + "'");
		driver.findElement(emailId).sendKeys(mailIds);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(employeeId).sendKeys("   ");
		System.out.println("employee id is " + employeeNumber);
		Thread.sleep(2000);
		driver.findElement(userRoleIcon).click();
		Thread.sleep(2000);
		driver.findElement(operatorRole).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEle).click();
		Thread.sleep(2000);
		String successToasterMsg = "null";
		try {
			successToasterMsg = driver.findElement(createUserToaster).getText();
			System.out.println(successToasterMsg);
			return false;
		} catch (Exception e) {
			System.out.println(successToasterMsg);
			return true;
		}
	}

	public boolean verifyUserIsAbleToCreateNewUseByAddingApportstopeInPasswordTest() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(4000);

		String randomText = RandomStringUtils.randomAlphabetic(9);
		String firstNameValue = randomText;
		String lastNameValue = randomText;
		String mailIds = firstNameValue + "." + lastNameValue + "@neewee.ai";
		String pwd = "Spi@" + "1234";
		navigateTo.IAM();
		Thread.sleep(2000);
		driver.findElement(createUserBtn).click();
		Thread.sleep(1000);
		driver.findElement(firstName).sendKeys(firstNameValue);
		driver.findElement(lastName).sendKeys(lastNameValue);
		driver.findElement(emailId).sendKeys(mailIds);
		driver.findElement(password).sendKeys(pwd + "'");

		System.out.println("employee id is " + employeeNumber);
		Thread.sleep(2000);
		driver.findElement(userRoleIcon).click();
		Thread.sleep(2000);
		driver.findElement(operatorRole).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEle).click();
		driver.findElement(searchUser).sendKeys(mailIds);
		Thread.sleep(2000);
		try {
			driver.findElement(displayedOperatorEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyUserIsAbleToCreateAUserWithSameEmailIdTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);

		String randomText = RandomStringUtils.randomAlphabetic(9);
		String firstNameValue = randomText;
		String lastNameValue = randomText;
		String mailIds = firstNameValue + "." + lastNameValue + "@neewee.ai";
		String pwd = "Spi@" + "1234";
		navigateTo.IAM();
		Thread.sleep(2000);
		driver.findElement(createUserBtn).click();
		Thread.sleep(1000);
		driver.findElement(firstName).sendKeys(firstNameValue);
		driver.findElement(lastName).sendKeys(lastNameValue);
		driver.findElement(emailId).sendKeys(mailIds);
		driver.findElement(password).sendKeys(pwd + "'");

		Thread.sleep(2000);
		driver.findElement(userRoleIcon).click();
		Thread.sleep(2000);
		driver.findElement(operatorRole).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEle).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(3000);

		driver.findElement(createUserBtn).click();
		Thread.sleep(1000);
		driver.findElement(firstName).sendKeys(firstNameValue + "Copy");
		driver.findElement(lastName).sendKeys(lastNameValue + "copy");
		driver.findElement(emailId).sendKeys(mailIds);
		driver.findElement(password).sendKeys(pwd);

		Thread.sleep(2000);
		driver.findElement(userRoleIcon).click();
		Thread.sleep(2000);
		driver.findElement(operatorRole).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEle).click();
		Thread.sleep(2000);

		driver.findElement(searchUser).sendKeys(firstNameValue + "Copy");
		Thread.sleep(2000);
		try {
			driver.findElement(displayedOperatorEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyUserIsAbleToCreateUserWithRfidTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);

		String randomText = RandomStringUtils.randomAlphabetic(9);
		firstNameValue = randomText;
		String lastNameValue = randomText;
		String mailIds = firstNameValue + "." + lastNameValue + "@neewee.ai";
		rfid = RandomStringUtils.randomNumeric(5);
		String pwd = "Spi@" + "1234";
		driver.findElement(createUserBtn).click();
		Thread.sleep(1000);
		driver.findElement(firstName).sendKeys(firstNameValue);
		driver.findElement(lastName).sendKeys(lastNameValue);
		driver.findElement(emailId).sendKeys(mailIds);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(rfidEle).sendKeys(rfid);

		Thread.sleep(2000);
		driver.findElement(userRoleIcon).click();
		Thread.sleep(2000);
		driver.findElement(operatorRole).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEle).click();

		Thread.sleep(1200);
		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println("Toaster messages while creating user with RFID *" + ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}
		if (ToasterMsg.equals("User Details Updated Successfully!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvlOfUserCreatedWithRfidTest() throws InterruptedException {
		driver.findElement(searchUser).sendKeys(firstNameValue);
		Thread.sleep(2000);
		try {
			driver.findElement(displayedOperatorEle).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUserIsAbleToCreateUserWithSameRfidTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);

		String randomText = RandomStringUtils.randomAlphabetic(9);
		firstNameValue = randomText;
		String lastNameValue = randomText;
		String mailIds = firstNameValue + "." + lastNameValue + "@neewee.ai";
		String pwd = "Spi@" + "1234";
		driver.findElement(createUserBtn).click();
		Thread.sleep(1000);
		driver.findElement(firstName).sendKeys(firstNameValue);
		driver.findElement(lastName).sendKeys(lastNameValue);
		driver.findElement(emailId).sendKeys(mailIds);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(rfidEle).sendKeys(rfid);

		Thread.sleep(2000);
		driver.findElement(userRoleIcon).click();
		Thread.sleep(2000);
		driver.findElement(operatorRole).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEle).click();
		Thread.sleep(1200);
		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println("Toaster messages while creating user with existing RFID *" + ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}
		if (ToasterMsg.equals("RFID UID already exists!!!")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTheAvlOfCreatedUserWithExistingRFIDTest() throws InterruptedException {
		driver.findElement(searchUser).sendKeys(firstNameValue);
		Thread.sleep(2000);
		try {
			driver.findElement(displayedOperatorEle).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyPasswordResetWithExistingPasswordTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);

		String randomText = RandomStringUtils.randomAlphabetic(9);
		firstNameValue = randomText;
		String lastNameValue = randomText;
		String mailIds = firstNameValue + "." + lastNameValue + "@neewee.ai";
		String pwd = "Spi@" + "1234";
		driver.findElement(createUserBtn).click();
		Thread.sleep(1000);
		driver.findElement(firstName).sendKeys(firstNameValue);
		driver.findElement(lastName).sendKeys(lastNameValue);
		driver.findElement(emailId).sendKeys(mailIds);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(userRoleIcon).click();
		Thread.sleep(2000);
		driver.findElement(operatorRole).click();
		Thread.sleep(1000);
		driver.findElement(saveBtnEle).click();
		Thread.sleep(1200);

		driver.findElement(searchUser).sendKeys(firstNameValue);
		Thread.sleep(2000);

		driver.findElement(userThreeDot).click();
		driver.findElement(resetPwd).click();
		Thread.sleep(1000);
		driver.findElement(newPasswordEle).sendKeys(pwd);
		Thread.sleep(1000);
		driver.findElement(confrmPassword).sendKeys(pwd);
		driver.findElement(pwdResetBtn).click();
		Thread.sleep(1200);
		try {
			ToasterMsg = driver.findElement(getToaster).getText();
			System.out.println("Toaster messages while reseting the password with existing password *" + ToasterMsg);
		} catch (Exception e) {
			System.out.println("No Toaster message or blank toaster displayed after creating a new User");
		}
		if (ToasterMsg
				.equals("Your new password must be different from your old password. Please enter a new password.!")) {
			return true;
		} else {
			return false;
		}

	}

}
