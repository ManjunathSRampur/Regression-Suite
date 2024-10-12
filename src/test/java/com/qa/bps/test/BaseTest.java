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
import com.qa.bps.pages.AdminConsole;
import com.qa.bps.pages.BodheeStudio;
import com.qa.bps.pages.ControlTower;
import com.qa.bps.pages.CycleTimeAnalysis;
import com.qa.bps.pages.DataManagement;
import com.qa.bps.pages.DelayAnalysis;
import com.qa.bps.pages.EquipmentRelaunchTime;
import com.qa.bps.pages.EquipmentScheduling;
import com.qa.bps.pages.FactoryCalender;
import com.qa.bps.pages.FileUpload;

import com.qa.bps.pages.FunctionalArea;

import com.qa.bps.pages.HolidayCalender;

import com.qa.bps.pages.HomePage;
import com.qa.bps.pages.IAM;
import com.qa.bps.pages.JDBC;
import com.qa.bps.pages.KPIManagement;
import com.qa.bps.pages.LoginPage;
import com.qa.bps.pages.Manager;
import com.qa.bps.pages.ManagerView;
import com.qa.bps.pages.MapProcess;
import com.qa.bps.pages.MasterData;
import com.qa.bps.pages.MaterialMaster;
import com.qa.bps.pages.MicroPlanning;
import com.qa.bps.pages.Navigation;
import com.qa.bps.pages.OperatorView;
import com.qa.bps.pages.PasswordPolicyConfig;
import com.qa.bps.pages.PlanDetails;
import com.qa.bps.pages.PlanValidation;
import com.qa.bps.pages.Planner;
import com.qa.bps.pages.PlantView;
import com.qa.bps.pages.ProductOverview;
import com.qa.bps.pages.RecipeManagement;
import com.qa.bps.pages.DailyOperatorManagement;

import com.qa.bps.pages.BatchMonitoring;

import com.qa.bps.pages.ScheduleAdheranceReport;
import com.qa.bps.pages.ShiftPattern;
import com.qa.bps.pages.ShiftSummaryHandover;
import com.qa.bps.pages.SkillMatrix;
import com.qa.bps.pages.SummaryDashboard;
import com.qa.bps.pages.TeamManagement;
import com.qa.bps.pages.VSB7;
import com.qa.bps.pages.VSBpage;
import com.qa.bps.utils.ElementUtil;
import com.qa.bps.utils.JDBCUtil;

public class BaseTest {

	DriverFactory df;
	
	JdbcFactory jf;
	public static WebDriver driver;
	Properties prop;
	LoginPage loginpage;

	Navigation navigateTo;

	HomePage homepage;
	ControlTower ctpage;
	KPIManagement kpipage;
	CycleTimeAnalysis cta;
	DelayAnalysis da;
	ScheduleAdheranceReport sar;
	EquipmentRelaunchTime ert;
	Manager mgr;
	ManagerView mgview;
	ShiftSummaryHandover sshandover;
	PlantView pview;
	DailyOperatorManagement productview;
	ProductOverview pdtoverview;
	SummaryDashboard summarydash;
	MicroPlanning microplan;
	FileUpload fileup;
	ElementUtil eu;
	Planner pl;
	PlanDetails pd;
	SkillMatrix sm;
	EquipmentScheduling es;
	OperatorView opview;
	BatchMonitoring ptclose;
	BodheeStudio bs;
	IAM iam;
	ShiftPattern shptn;
	AdminConsole ac;
	DataManagement dm;
	TeamManagement tm;
	MapProcess mp;
	FunctionalArea fa;
	PasswordPolicyConfig ppc;
	MasterData md;
	MaterialMaster mm;
	HolidayCalender hc;
	FactoryCalender fc;
	VSBpage vsbpage;

	PlanValidation planValidation;

	VSB7 vsb7;
	RecipeManagement recipeMangement;
	JDBC jdbc;

	int size = 0;

	@Parameters({ "baseUrl", "browser", "managerName", "domain", "password", "DBURL", "DBUser", "DBPassword" })
	@BeforeClass(alwaysRun = true)
	public void setUp(String url, String browser, String managerName, String domain, String password, String DBURL,
			String DBUser, String DBPassword) throws IOException, SQLException {
		df = new DriverFactory();
		prop = df.initProperties();

		System.out.println("inside Setup");

		prop.setProperty("DBURL", DBURL);
		prop.setProperty("DBUser", DBUser);
		prop.setProperty("DBPassword", DBPassword);

		prop.setProperty("browser", browser);
		prop.setProperty("url", url);
		prop.setProperty("manager_username", managerName);
		prop.setProperty("manager_password", password);
		prop.setProperty("manager_domian", domain);
		driver = df.initDriver(prop);
		loginpage = new LoginPage(driver);
		navigateTo = new Navigation(driver);
		homepage = new HomePage(driver);
		ctpage = new ControlTower(driver);
		mgr = new Manager(driver);
		mgview = new ManagerView(driver);
		sshandover = new ShiftSummaryHandover(driver);
		pview = new PlantView(driver);
		productview = new DailyOperatorManagement(driver);
		pdtoverview = new ProductOverview(driver);
		summarydash = new SummaryDashboard(driver);
		microplan = new MicroPlanning(driver);
		fileup = new FileUpload(driver);
		eu = new ElementUtil(driver);
		pl = new Planner(driver);
		pd = new PlanDetails(driver);
		sm = new SkillMatrix(driver);
		es = new EquipmentScheduling(driver);
		opview = new OperatorView(driver);
		cta = new CycleTimeAnalysis(driver);
		da = new DelayAnalysis(driver);
		sar = new ScheduleAdheranceReport(driver);
		ert = new EquipmentRelaunchTime(driver);
		ptclose = new BatchMonitoring(driver, size);
		bs = new BodheeStudio(driver);
		iam = new IAM(driver);
		shptn = new ShiftPattern(driver);
		ac = new AdminConsole(driver);
		dm = new DataManagement(driver);
		tm = new TeamManagement(driver);
		md = new MasterData(driver);
		vsbpage = new VSBpage(driver);
		fa = new FunctionalArea(driver);
		mp = new MapProcess(driver);
		mm = new MaterialMaster(driver);
		hc = new HolidayCalender(driver);
		fc = new FactoryCalender(driver);
		planValidation = new PlanValidation(driver);
		ppc=new PasswordPolicyConfig(driver);
		vsb7 = new VSB7(driver);
		recipeMangement = new RecipeManagement(driver);
		JDBC.getDBConnection(prop.getProperty("DBURL"), prop.getProperty("DBUser"), prop.getProperty("DBPassword"));
		JDBC.getConnection();
		jdbc = new JDBC();
	}

	@AfterClass(alwaysRun = true)

	public void tearDown() {

		driver.quit();
	}
}