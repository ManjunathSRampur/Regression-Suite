package com.qa.bps.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.bps.utils.ElementUtil;

public class LoginPage {

	// private by locators

	static WebDriver driver;
	private ElementUtil eu;
	int j = 0;

	private By byemailid = By.id("username");
	private By bydomain = By.xpath("//div[@class='btn-group root noBorder-background']");
	private By bypassword = By.id("txtPassword");
	private By byloginbtn = By.xpath("//button[.='SIGN IN']");
	private By domainname = By.xpath("//div[@class='btn-group root noBorder-background show']//a");
	private By names = By.xpath("//label[@for='login-info']");
	List<String> stringnameList = new ArrayList<String>();
	List<WebElement> nameslist = new ArrayList<WebElement>();
	private By controlTower = By.xpath("//div[contains(text(),'Control Tower')]");
	private By checkBox = By.xpath("//input[@id='customCheck1']");
	private By dd = By.xpath("//p[@id='navbarDropdown']");
	private By logout = By.xpath("(//a[.='Logout'])[2]");
	List<String> stringdomainnameList = new ArrayList<String>();
	List<WebElement> domainnamelist = new ArrayList<WebElement>();
	boolean b;
	private ElementUtil eleUtil;

	public LoginPage(WebDriver driver) {

		LoginPage.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public HomePage doLogin(String email, String pwd) {

		driver.navigate().refresh();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eleUtil.getElement(byemailid).sendKeys(email);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		eleUtil.getElement(bypassword).sendKeys(pwd);
		eleUtil.getElement(byloginbtn).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		Dimension initial_size = driver.manage().window().getSize();
		
		System.out.println("Dimension is "+initial_size);
		
		return new HomePage(driver);
	}

}