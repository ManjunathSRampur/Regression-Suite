package com.qa.ExtentReportListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.qa.bps.factory.DriverFactory;

public class ExtentReportListener implements ITestListener {

	private static final String OUTPUT_FOLDER = "./report_screenshot/";
	private static final String FILE_NAME = "BPS_Regression_Automation_TestExecutionReport.html";

	private static ExtentReports extent = init();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	private static ExtentReports extentReports;
	static DriverFactory df1;
	static Properties prop;

	private static ExtentReports init() {

		Path path = Paths.get(OUTPUT_FOLDER);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}

		extentReports = new ExtentReports();

		ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
		reporter.config().setReportName("BPS Regression Automation Test Results");
		reporter.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.AUTHOR,
				ViewName.DEVICE, ViewName.EXCEPTION, ViewName.LOG });
		extentReports.attachReporter(reporter);
		df1 = new DriverFactory();
		prop = df1.initProperties();

		extentReports.setSystemInfo("Release Date", prop.getProperty("Release_Date"));
		extentReports.setSystemInfo("Jenkins Build", prop.getProperty("jenkins_Id"));
		extentReports.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReports.setSystemInfo("Scheduling_Engine", prop.getProperty("Scheduling_Engine"));
		extentReports.setSystemInfo("Pre-Processing", prop.getProperty("Pre-Processing"));
		extentReports.setSystemInfo("Algo_DB_version", prop.getProperty("Algo_DB_version"));
		extentReports.setSystemInfo("IMP UI", prop.getProperty("IMP_UI"));
		extentReports.setSystemInfo("IMP Backend", prop.getProperty("IMP_Backend"));
		extentReports.setSystemInfo("Config UI", prop.getProperty("Bodhee_Studio_Config_UI"));
		extentReports.setSystemInfo("Config Backend", prop.getProperty("Bodhee_Studio_Config_Backend"));
		extentReports.setSystemInfo("Bodhee Security", prop.getProperty("Bodhee_Security"));
		extentReports.setSystemInfo("Bodhee Studio File Upload", prop.getProperty("Bodhee_Studio_File_Upload"));
		extentReports.setSystemInfo("Bodhee Controller", prop.getProperty("Bodhee_Controller"));
		
		extentReports.setSystemInfo("harbur_matrix", prop.getProperty("Harbur_Matrix"));
		extentReports.setSystemInfo("BPS Optimizer ", prop.getProperty("BPS_Optimizer"));
		extentReports.setSystemInfo("API Gateway", prop.getProperty("API_Gateway"));
		extentReports.setSystemInfo("Notifier", prop.getProperty("Notifier"));
		extentReports.setSystemInfo("Browser Name", prop.getProperty("browser_name"));
		extentReports.setSystemInfo("Browser Version", prop.getProperty("brower_version"));
		extentReports.setSystemInfo("Run by", prop.getProperty("test_run_by"));
		extentReports.setSystemInfo("Customer Name", prop.getProperty("customer_name"));

		extentReports.setSystemInfo("GitHub Details", prop.getProperty("gitHub_Details"));

		extentReports.setSystemInfo("IMP UI", prop.getProperty("impUI"));
		extentReports.setSystemInfo("IMP Backend", prop.getProperty("impBE"));
		extentReports.setSystemInfo("Config UI", prop.getProperty("configFE"));
		extentReports.setSystemInfo("Config Backend", prop.getProperty("configBE"));
		extentReports.setSystemInfo("IAM", prop.getProperty("iam"));
		extentReports.setSystemInfo("File Upload", prop.getProperty("fileUpload"));
		extentReports.setSystemInfo("Bodhee Controller", prop.getProperty("bodheeController"));

		return extentReports;
	}

	@Override
	public synchronized void onStart(ITestContext context) {
		System.out.println("Test Suite started!");

	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println(("Test Suite is ending!"));
		String sourceFolder = "./report_screenshot";
		String outputZipFile = "./report_screenshot.zip";
		extent.flush();
		test.remove();

		try {
			FileOutputStream fos = new FileOutputStream(outputZipFile);
			ZipOutputStream zipOut = new ZipOutputStream(fos);
			File fileToZip = new File(sourceFolder);

			zipFile(fileToZip, fileToZip.getName(), zipOut);
			zipOut.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
		if (fileToZip.isHidden()) {
			return;
		}
		if (fileToZip.isDirectory()) {
			File[] children = fileToZip.listFiles();
			for (File childFile : children) {
				zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
			}
			return;
		}
		FileInputStream fis = new FileInputStream(fileToZip);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zipOut.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zipOut.write(bytes, 0, length);
		}
		fis.close();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String qualifiedName = result.getMethod().getQualifiedName();
		int last = qualifiedName.lastIndexOf(".");
		int mid = qualifiedName.substring(0, last).lastIndexOf(".");
		String className = qualifiedName.substring(mid + 1, last);

		System.out.println(methodName + " started!");
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());

		extentTest.assignCategory(result.getTestContext().getSuite().getName());
		/*
		 * methodName = StringUtils.capitalize(StringUtils.join(StringUtils.
		 * splitByCharacterTypeCamelCase(methodName), StringUtils.SPACE));
		 */
		extentTest.assignCategory(className);
		test.set(extentTest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));
	}

	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		test.get().pass("Test passed");
		// test.get().pass(result.getThrowable(),
		// MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot()).build());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		String methodName = result.getMethod().getMethodName();

		try {
			test.get().fail(result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		String methodName = result.getMethod().getMethodName();
		try {
			test.get().skip(result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPerce 	ntage for " + result.getMethod().getMethodName()));
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}
