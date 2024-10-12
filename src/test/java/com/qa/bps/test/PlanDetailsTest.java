package com.qa.bps.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class PlanDetailsTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("-----------Plan Details Test-------------");
		 loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		
	}

	
}
