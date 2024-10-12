package com.qa.bps.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;

public class PasswordPolicyConfig {
	WebDriver driver;
	Navigation navigateTo;

	public PasswordPolicyConfig(WebDriver driver) {

		this.driver = driver;
		navigateTo = new Navigation(driver);
	}

//X-Path Area
	private By passwordPolicyTab = By.xpath("//div/a[@routerlink='pass-config']");
	private By headerText = By.xpath("//label[.='Password Configuration']");
	private By aCapitalCheckBox = By.xpath("(//input[@type='checkbox'])[1]");
	private By aLowerCheckBox = By.xpath("(//input[@type='checkbox'])[2]");
	private By aNumberCheckBox = By.xpath("(//input[@type='checkbox'])[3]");
	private By maxLengthInput = By.xpath("(//div/input[@type='number'])[1]");
	private By minLengthInput = By.xpath("(//div/input[@type='number'])[2]");
	private By specialCharInput = By.xpath("(//div/input[@type='text'])[2]");
	private By saveBtn = By.xpath("//button[.='Save']");
	private By toaster = By.xpath("//div[@role='alertdialog']");
	private By homeNav = By.xpath("//label/a[@class='breadCrumbHome']");
	private By iamBtn = By.xpath("//h6[.='IAM']/parent::div/div/div/a/button");
	private By passwordPromptWindow = By.xpath("//ngb-tooltip-window[@role='tooltip']");
	private By teamManagementBtn = By.xpath("//h6[.='Team Management']/parent::div/div/div/a/button");
	private By newPasswordInputTM = By.xpath("(//input[@placeholder='Enter Password'])[2]");
//	

	String ToasterMsg;

	public boolean navigateToPasswordPolicyCongifuration() throws InterruptedException {
		navigateTo.adminConsole();
		Thread.sleep(2500);
		driver.findElement(passwordPolicyTab).click();
		Thread.sleep(2000);
		boolean b;
		try {
			driver.findElement(headerText).isDisplayed();
			b = true;
		} catch (Exception e) {
			System.out.println("Navigation failed");
			b = false;
		}
		return b;
	}

	public boolean availableFiledsUnderPasswordPolicyConfigTab() {
		boolean b;
		try {
			driver.findElement(aCapitalCheckBox).isDisplayed();
			driver.findElement(aLowerCheckBox).isDisplayed();
			driver.findElement(aNumberCheckBox).isDisplayed();
			driver.findElement(maxLengthInput).isDisplayed();
			driver.findElement(minLengthInput).isDisplayed();
			driver.findElement(specialCharInput).isDisplayed();
			driver.findElement(saveBtn).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean userCanCheckTheAvailableCheckBoxes() throws InterruptedException {
		boolean b = false;
		try {
			Thread.sleep(2000);
			String a = driver.findElement(aCapitalCheckBox).getAttribute("ng-reflect-model");
			if (a.equalsIgnoreCase("true")) {
				driver.findElement(aCapitalCheckBox).click();
			}
		} catch (Exception e) {
			System.out.println("A Capital (Upper Case) Letter is not selected");
		}

		try {
			Thread.sleep(2000);
			String a = driver.findElement(aLowerCheckBox).getAttribute("ng-reflect-model");
			if (a.equalsIgnoreCase("true")) {
				driver.findElement(aLowerCheckBox).click();
			}
		} catch (Exception e) {
			System.out.println("A Lower Case Letter is not selected");
		}

		try {
			Thread.sleep(2000);
			String a = driver.findElement(aLowerCheckBox).getAttribute("ng-reflect-model");
			if (a.equalsIgnoreCase("true")) {
				driver.findElement(aLowerCheckBox).click();
			}
		} catch (Exception e) {
			System.out.println("A Capital (Upper Case) Letter is not selected");
		}

		try {
			Thread.sleep(2000);
			String a = driver.findElement(aNumberCheckBox).getAttribute("ng-reflect-model");
			if (a.equalsIgnoreCase("true")) {
				driver.findElement(aNumberCheckBox).click();
			}
		} catch (Exception e) {
			System.out.println("A Capital (Upper Case) Letter is not selected");
		}

		driver.findElement(aCapitalCheckBox).click();
		Thread.sleep(2000);
		driver.findElement(aLowerCheckBox).click();
		Thread.sleep(2000);
		driver.findElement(aNumberCheckBox).click();
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(1200);

		try {
			String a = driver.findElement(aCapitalCheckBox).getAttribute("ng-reflect-model");
			String c = driver.findElement(aLowerCheckBox).getAttribute("ng-reflect-model");
			String d = driver.findElement(aNumberCheckBox).getAttribute("ng-reflect-model");
			if (a.equalsIgnoreCase("true") && c.equalsIgnoreCase("true") && d.equalsIgnoreCase("true")) {
				b = true;
			}
		} catch (Exception e) {
			b = false;
		}

		return b;

	}

	public boolean userCanConfigPasswordPolicyAndCheckToaster() throws InterruptedException {
		driver.findElement(maxLengthInput).clear();
		Thread.sleep(1200);
		driver.findElement(minLengthInput).clear();
		Thread.sleep(1200);
		driver.findElement(specialCharInput).clear();
		Thread.sleep(1200);
		driver.findElement(maxLengthInput).sendKeys("22");
		Thread.sleep(1200);
		driver.findElement(minLengthInput).sendKeys("7");
		Thread.sleep(1200);
		driver.findElement(specialCharInput).sendKeys("@#$&");
		Thread.sleep(1200);
		driver.findElement(saveBtn).click();
		Thread.sleep(1500);
		System.out.println("Save btn clicked");
		ToasterMsg = driver.findElement(toaster).getText();
		boolean b;
		try {
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean toasterValOnConfiguration() {

		ToasterMsg = ToasterMsg.replace(" ", "");
		boolean b;
		if (ToasterMsg.equals("Passwordpolicyupdatedsuccessfully.")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean changePasswordPolicyConfig() throws InterruptedException {

		driver.findElement(maxLengthInput).clear();
		Thread.sleep(1200);
		driver.findElement(minLengthInput).clear();
		Thread.sleep(1200);
		driver.findElement(specialCharInput).clear();
		Thread.sleep(1200);
		driver.findElement(maxLengthInput).sendKeys("24");
		Thread.sleep(1200);
		driver.findElement(minLengthInput).sendKeys("5");
		Thread.sleep(1200);
		driver.findElement(specialCharInput).sendKeys("@#");
		Thread.sleep(1200);
		driver.findElement(saveBtn).click();
		Thread.sleep(1200);
		ToasterMsg = driver.findElement(toaster).getText();
		boolean b;
		try {
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean toasterValOnchangePasswordPolicy() {
		ToasterMsg = ToasterMsg.replace(" ", "");
		boolean b;
		if (ToasterMsg.equals("Passwordpolicyupdatedsuccessfully.")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public boolean refreshAndVerifypasswordPlocyUpdated() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		String x = driver.findElement(maxLengthInput).getAttribute("ng-reflect-model");
		Thread.sleep(800);
		String y = driver.findElement(minLengthInput).getAttribute("ng-reflect-model");
		Thread.sleep(800);
		String z = driver.findElement(specialCharInput).getAttribute("ng-reflect-model");

		boolean b;
		if (x.equals("24") && y.equals("5") && z.equals("@#")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean limitOfMaxLength() throws InterruptedException {
		driver.findElement(maxLengthInput).clear();
		Thread.sleep(1500);
		driver.findElement(maxLengthInput).sendKeys("25");
		Thread.sleep(1200);
		driver.findElement(saveBtn).click();
		Thread.sleep(1200);
		ToasterMsg = driver.findElement(toaster).getText();
		System.out.println(ToasterMsg);
		boolean b;
		if (ToasterMsg.equals("Maximum Length cannot be greater then 24.")) {
			b = true;
		}

		else {
			b = false;
		}
		return b;
	}

	public boolean maxValueNotUpdatedToMorethan24() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		String x = driver.findElement(maxLengthInput).getAttribute("ng-reflect-model");
		int num = Integer.parseInt(x);
		boolean b;
		if (num > 24) {
			b = false;
		} else {
			b = true;
		}
		return b;
	}

	public boolean minValueLimitValidation() throws InterruptedException {
		driver.findElement(minLengthInput).clear();
		Thread.sleep(1500);
		driver.findElement(minLengthInput).sendKeys("2");
		Thread.sleep(1200);
		driver.findElement(saveBtn).click();
		Thread.sleep(1200);
		ToasterMsg = driver.findElement(toaster).getText();
		System.out.println(ToasterMsg);
		boolean b;
		if (ToasterMsg.equals("Min and Max Value should be greater than or equal to 4")) {
			b = true;
		}

		else {
			b = false;
		}
		return b;
	}

	public boolean minValueNotUpdatedToLessThan4() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		String x = driver.findElement(maxLengthInput).getAttribute("ng-reflect-model");
		int num = Integer.parseInt(x);
		boolean b;
		if (num > 24) {
			b = false;
		} else {
			b = true;
		}
		return b;
	}

	public boolean maxValueIsNotLessThanMin() throws InterruptedException {
		Random random = new Random();
		int num1 = 5 + random.nextInt(18);
		System.out.println(num1);
		int num2 = num1 + 1;
		System.out.println(num2);
		String a = String.valueOf(num1);
		String b = String.valueOf(num2);
		driver.findElement(maxLengthInput).clear();
		Thread.sleep(1200);
		driver.findElement(maxLengthInput).sendKeys(a);
		Thread.sleep(1200);
		driver.findElement(minLengthInput).clear();
		Thread.sleep(1200);
		driver.findElement(minLengthInput).sendKeys(b);
		Thread.sleep(1200);
		boolean d;
		driver.findElement(saveBtn).click();
		Thread.sleep(1200);

		ToasterMsg = driver.findElement(toaster).getText();
		System.out.println(ToasterMsg);

		if (ToasterMsg.equals("Maximum Length cannot be less then Minimum Length")) {
			d = true;
		}

		else {
			d = false;
		}
		return d;

	}

	public boolean refreshAndVerifypasswordPlocyNotUpdatedToWrongvalue() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		String x = driver.findElement(maxLengthInput).getAttribute("ng-reflect-model");
		Thread.sleep(800);
		String y = driver.findElement(minLengthInput).getAttribute("ng-reflect-model");
		Thread.sleep(800);
		String z = driver.findElement(specialCharInput).getAttribute("ng-reflect-model");

		boolean b;
		if (x.equals("24") && y.equals("5") && z.equals("@#")) {
			b = true;
		} else {
			b = false;
		}
		return b;

	}

	public boolean verifyThePasswordPolicyPromptUserWhileCreatingNewUserInIAM() throws InterruptedException {
		changePasswordPolicyConfig();
		Thread.sleep(4000);
		driver.findElement(homeNav).click();
		Thread.sleep(4000);
		driver.findElement(iamBtn).click();
		Thread.sleep(3200);
		driver.findElement(IAM.createUserBtn).click();
		Thread.sleep(2000);
		driver.findElement(IAM.password).click();
		Thread.sleep(2500);
		String a = driver.findElement(passwordPromptWindow).getText();

		System.out.println(a);
		a = a.replace("\r", "");
		a = a.replace("\n", "");
		a = a.replace(" ", "");
		System.out.println("a is:" + a);
		String s = "Passwordmustinclude:Alowercaseletter.Acapital(uppercase)letter.Anumber.Minimum5characters.Maximum24characters.Specialcharacter(@#).";
		System.out.println("s is:" + s);
		boolean b;
		if (a.equals(s)) {
			b = true;
		}

		else {
			b = false;
		}
		return b;
	}

	public boolean verifyThePasswordPolicyPromptUserWhileeditingpasswordInIAM() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2800);
		driver.findElement(IAM.userThreeDot).click();
		Thread.sleep(1800);
		driver.findElement(IAM.resetPwd).click();
		Thread.sleep(2000);
		driver.findElement(IAM.newPassword).click();

		String a = driver.findElement(passwordPromptWindow).getText();

		System.out.println(a);
		a = a.replace("\r", "");
		a = a.replace("\n", "");
		a = a.replace(" ", "");
		System.out.println("a is:" + a);
		String s = "Passwordmustinclude:Alowercaseletter.Acapital(uppercase)letter.Anumber.Minimum5characters.Maximum24characters.Specialcharacter(@#).";
		System.out.println("s is:" + s);
		boolean b;
		if (a.equals(s)) {
			b = true;
		}

		else {
			b = false;
		}
		return b;

	}

	public boolean verifyPasswordPolicyInTeamManagementCreateOperator() throws InterruptedException {
		Thread.sleep(2500);
		navigateTo.TeamManagement();
		Thread.sleep(3800);
		driver.findElement(TeamManagement.OperatorThreeDot).click();
		Thread.sleep(2000);
		driver.findElement(TeamManagement.manageOperatorOption).click();
		Thread.sleep(1500);
		driver.findElement(newPasswordInputTM).click();

		String a = driver.findElement(passwordPromptWindow).getText();

		System.out.println(a);
		a = a.replace("\r", "");
		a = a.replace("\n", "");
		a = a.replace(" ", "");
		System.out.println("a is:" + a);
		String s = "Passwordmustinclude:Alowercaseletter.Acapital(uppercase)letter.Anumber.Minimum5characters.Maximum24characters.Specialcharacter(@#).";
		System.out.println("s is:" + s);
		boolean b;
		if (a.equals(s)) {
			b = true;
		}

		else {
			b = false;
		}
		return b;

	}

	public boolean verifyPasswordPolicyInCreateOPeratorTM() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(TeamManagement.createNewOperatorBtn).click();
		Thread.sleep(2200);
		driver.findElement(TeamManagement.paswordInput).click();

		String a = driver.findElement(passwordPromptWindow).getText();

		System.out.println(a);
		a = a.replace("\r", "");
		a = a.replace("\n", "");
		a = a.replace(" ", "");
		System.out.println("a is:" + a);
		String s = "Passwordmustinclude:Alowercaseletter.Acapital(uppercase)letter.Anumber.Minimum5characters.Maximum24characters.Specialcharacter(@#).";
		System.out.println("s is:" + s);
		boolean b;
		if (a.equals(s)) {
			b = true;
		}

		else {
			b = false;
		}
		return b;

	}

	public boolean configPasswordPolicyWithAphostropheSymbol() throws InterruptedException {
		navigateTo.adminConsole();
		Thread.sleep(2500);
		driver.findElement(maxLengthInput).clear();
		Thread.sleep(1200);
		driver.findElement(minLengthInput).clear();
		Thread.sleep(1200);
		driver.findElement(specialCharInput).clear();
		Thread.sleep(1200);
		driver.findElement(maxLengthInput).sendKeys("24");
		Thread.sleep(1200);
		driver.findElement(minLengthInput).sendKeys("5");
		Thread.sleep(1200);
		driver.findElement(specialCharInput).sendKeys("@#'");
		Thread.sleep(1200);
		driver.findElement(saveBtn).click();
		Thread.sleep(1200);
		ToasterMsg = driver.findElement(toaster).getText();
		boolean b;
		try {
			driver.findElement(toaster).isDisplayed();
			b = true;
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public boolean toasterValOnConfigurationPasswordPolicyWithAphostropheSymbol() {

		ToasterMsg = ToasterMsg.replace(" ", "");
		boolean b;
		if (ToasterMsg.equals("Passwordpolicyupdatedsuccessfully.")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

}