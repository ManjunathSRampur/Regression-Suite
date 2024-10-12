package com.qa.bps.test;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class LoginPageTest extends BaseTest {
	@Test(groups = { "SmokeTest" }, priority = 1)
	public void loginTest() throws InterruptedException {
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		Assert.assertTrue(homepage.weclomeMsgExist(), "Welcome message doesnt exists ");
	}

}
