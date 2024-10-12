package com.qa.bps.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.qa.bps.factory.DriverFactory;
import com.qa.bps.factory.JdbcFactory;
import com.qa.bps.pages.LoginPage;
import com.qa.bps.pages.Navigation;
import com.qa.bps.pages.PlanGenerationSC01;
import com.qa.bps.pages.PlanGenerationSC02;
import com.qa.bps.pages.PlanGenerationSC03;
import com.qa.bps.pages.PlanGenerationSC04;
import com.qa.bps.pages.PlanGenerationSC05;
import com.qa.bps.pages.PlanGenerationSC06;
import com.qa.bps.pages.PlanGenerationSC00;
import com.qa.bps.utils.ElementUtil;
import com.qa.bps.utils.JDBCUtil;

public class BaseTest {

	DriverFactory df;
	JdbcFactory jf;
	public WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	Navigation navigateTo;
	PlanGenerationSC00 pl0;
	PlanGenerationSC01 pl1;
	PlanGenerationSC02 pl2;
	PlanGenerationSC03 pl3;
	PlanGenerationSC04 pl4;
	PlanGenerationSC05 pl5;
	PlanGenerationSC06 pl6;
	int size = 0;

	@Parameters({ "baseUrl", "browser", "managerName", "domain", "password", "DBURL", "DBUser", "DBPassword" })
	@BeforeClass(alwaysRun = true)
	public void setUp(String url, String browser, String managerName, String domain, String password, String DBURL,
			String DBUser, String DBPassword) throws IOException, SQLException {
		df = new DriverFactory();
		prop = df.initProperties();

		System.out.println("inside Setup");

		prop.setProperty("browser", browser);
		prop.setProperty("url", url);
		prop.setProperty("manager_username", managerName);
		prop.setProperty("manager_password", password);
		prop.setProperty("manager_domian", domain);

		driver = df.initDriver(prop);
		loginpage = new LoginPage(driver);
		navigateTo = new Navigation(driver);
		pl0=new PlanGenerationSC00(driver);
		pl1=new PlanGenerationSC01(driver);
		pl2=new PlanGenerationSC02(driver);
		pl3=new PlanGenerationSC03(driver);
		pl4=new PlanGenerationSC04(driver);
		pl5=new PlanGenerationSC05(driver);
		pl6=new PlanGenerationSC06(driver);

		new ElementUtil(driver);

	}

	@AfterClass(alwaysRun = true)

	public void tearDown() {

		driver.quit();
	}
}