package com.qa.bps.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	static WebDriver driver;
	WebElement we;
	private By locator;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement findElement(By path) {

		we = driver.findElement(path);

		return we;

	}

	public void doZoomOut() throws AWTException {
		// For ZOOMING OUT TO 80%
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
	}

	public WebElement getElement(By locator) throws NoSuchElementException, ElementNotInteractableException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("element could not be found");
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			System.out.println("element could not be found");
		}
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElements(locator);
	}

	public void doSendkeys(By locator, String value) {
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}

	public void doClick(By locator) throws ElementClickInterceptedException {
		try {
			getElement(locator).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element is not able to be clicked");
		}
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public boolean isDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean isTextDisplayed(String locator) {
		return driver.getPageSource().contains(locator);
	}

	public String isGettext(By locator) {
		return driver.findElement(locator).getText();
	}

	public boolean isEnabled(By locator) {
		return getElement(locator).isEnabled();
	}

	public WebElement waitTillElementVisible(By locator, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public Alert waitForAlert(Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(Duration timeout) {
		waitForAlert(timeout).accept();
	}

	public void dismissAlert(Duration timeout) {
		waitForAlert(timeout).dismiss();
	}

	public boolean waitForUrlContaines(String urlFraction, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	public void selectDate(String expMonthYear, String day) {
		String actMonthYear = driver.findElement(By.xpath("(//span)[2]")).getText();
		while (!actMonthYear.equals(expMonthYear)) {
			driver.findElement(By.xpath("(//button[@class='calendar__nav-btn'])[1]")).click();
			actMonthYear = driver.findElement(By.xpath("(//span)[2]")).getText();
		}
		driver.findElement(By.xpath("(//span[normalize-space(text())='" + day + "'])[1]")).click();
	}

	public static String getScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File snappath = new File(Constants.SNAPSHOT_PATH);

		String path = snappath.getAbsolutePath() + System.currentTimeMillis() + ".png";
		// String path="./reports/Screenshot/"+System.currentTimeMillis()+".png";

		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		InputStream is = new FileInputStream(path); 
//		byte[] ssBytes=IOUtils.toByteArray(is);
//		String base64= Base64.getEncoder().encodeToString(ssBytes)

		return path;
	}

	public void zoomIn(By locator) throws ElementClickInterceptedException {
		try {
			getElement(locator).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Unable to click the element");
		}
	}

	public void zoomOut(By locator) throws ElementClickInterceptedException {
		try {
			getElement(locator).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Unable to click the element");
		}
	}

	public void fullScreen(By locator) throws ElementClickInterceptedException {
		try {
			getElement(locator).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Unable to click the element");
		}
	}

	public boolean fileDownload(By locator, String fileName) throws ElementClickInterceptedException, IOException {
		try {
			boolean b;
			getElement(locator).click();
			

			File dir = new File("C:\\Users\\testuser\\Downloads");
			File[] dirContents = dir.listFiles();

			for (int i = 0; i < dirContents.length; i++) {
				if (dirContents[i].getName().contains(fileName)) {

					dirContents[i].exists();
					b = dirContents[i].delete();
					dirContents[i].getName();

					System.out.println("file name is " + dirContents[i].getName());
					// FileUtils.cleanDirectory(new File(fileName));
					// FileUtils.cleanDirectory(dir);
					return b;
				}
			}
			return true;
		} catch (ElementClickInterceptedException e) {
			System.out.println("Unable to click the download button");
			return false;
		}
	}

	public boolean simpleDropDown(By headerlocator, By Optionlocator, By validationLocator)
			throws ElementClickInterceptedException, IOException {
		getElement(headerlocator).click();
		getElement(Optionlocator).click();
		return getElement(validationLocator).isDisplayed();

	}
	
	
	
	public String getToolTip(By locator,String attribute)
	{
		
		String	toolTip=driver.findElement(locator).getAttribute(attribute);
		return toolTip;
	}
	
	
	public boolean tosterMsgAndSearchValidation(String actualTosterMsg, String expectedTosterMsg, String actualDisplay,String searchingValue)
	{
		
		  if(actualTosterMsg.equalsIgnoreCase(expectedTosterMsg)&&actualDisplay.equalsIgnoreCase(searchingValue))
			{
				return true;
			}
			else {
				return false;
			}
	}
	public boolean tosterMsgValidation(String tosterMsg, String expectedTosterMsg)
	{
		  if(tosterMsg.equals(expectedTosterMsg)) 
		  {
	        	return true;
	      }
	      else
          {
	        	return false;
	      }
	}

	
}
