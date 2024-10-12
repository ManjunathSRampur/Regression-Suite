package com.qa.bps.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;
	public static Properties prop;
	private static String path;
	DesiredCapabilities caps = null;
	String browsername;

	Properties properties = new Properties();

	public WebDriver initDriver(Properties prop) {

		browsername = prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().clearDriverCache().setup();
			WebDriverManager.chromedriver().clearResolutionCache().setup();
			WebDriverManager.chromedriver().setup();
			ChromeOptions handlingSSL = new ChromeOptions();
			handlingSSL.addArguments("headless");
			handlingSSL.addArguments("--remote-allow-origins=*");
			handlingSSL.addArguments("window-size=960,520");
			handlingSSL.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(handlingSSL);

		} else if (browsername.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		}

		else if (browsername.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setAcceptInsecureCerts(true);
			driver = new EdgeDriver(edgeOptions);

		}

		else {

			System.out.println("Please pass the right browser name is :" + browsername);

		}

		driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;

	}

	public Properties initProperties() {

		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");

			prop = new Properties();
			prop.load(ip);
			ip.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

	public static String getScreenshot() throws IOException {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path1 = "./report_screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path1);
		try {
			FileUtil.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] arrOfStr = path1.split("t", 4);
		String path2 = arrOfStr[arrOfStr.length - 1];
		String path = "." + path2;
		return path;
	}

	private static WebDriver getDriver() {

		return driver;
	}

}
