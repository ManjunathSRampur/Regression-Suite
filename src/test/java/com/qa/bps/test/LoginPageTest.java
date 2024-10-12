package com.qa.bps.test;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class LoginPageTest extends BaseTest {
	@Test(groups = { "SmokeTest" }, priority = 1)
	public void loginTest() throws InterruptedException {
		 loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		

	}

}
