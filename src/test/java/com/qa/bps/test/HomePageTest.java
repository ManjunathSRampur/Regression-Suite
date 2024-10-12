package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class HomePageTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		System.out.println("-----------Home Page-------------------------");
		loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
	}

	
}
