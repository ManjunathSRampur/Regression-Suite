package com.qa.bps.test;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class FileUploadTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException {
		System.out.println("---------File Upload Test------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
		microplan = homepage.navigateToMicroplanning();
		fileup = microplan.navigateToFileUpload();

	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void createDataCatalogTes() throws InterruptedException, AWTException {
		Assert.assertTrue(fileup.createDataCatalog(), " Unable to create a new Data Catalog");
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void checkDataCatalogAfterCreationTest() {
		Assert.assertTrue(fileup.checkDataCatalogAfterCreation(), "created data catalog is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void createNewFolderTest() throws InterruptedException {
		Assert.assertTrue(fileup.createNewFolder(),
				"Unable to create new folder / after clicking on next button window is not disapearing ");
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void createNewConfigurationTest() throws InterruptedException {
		Assert.assertTrue(fileup.createNewConfigurationStep1(), "Create New configuration Step1 is failed ");
		Assert.assertTrue(fileup.createNewConfigurationStep2(), "Create New configuration Step2 is failed ");
		Assert.assertTrue(fileup.createNewConfigurationStep3(), " Create New configuration Step3 is failed ");
		Assert.assertTrue(fileup.createNewConfigurationStep4(),
				"Unable to Create New Configuration / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void uploadNewFileTest() throws InterruptedException {
		Assert.assertTrue(fileup.uploadNewFile(Constants.campaignFileNew),
				"File Upload failed / toaster message not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void avlOfuploadedFileTest() throws InterruptedException {
		Assert.assertTrue(fileup.avlOfuploadedFile(), "Uploaded file is not avaialable ");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void functionalityOfViewButtonTest() throws InterruptedException {
		Assert.assertTrue(fileup.functionalityOfViewButton(), "Data is not available under view buttton ");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void funcionalityOfDownloadBtnTest() throws InterruptedException {
		Assert.assertTrue(fileup.funcionalityOfDownloadBtn(), "File is not downloaded ");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void compareDwdSheetTest() throws IOException {
		Assert.assertTrue(fileup.compareExcel(), "Downloaded excell and uploaded excell data is not matched ");
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void uploadedExcelWithViewBtnTest() throws InterruptedException, IOException {
		Assert.assertTrue(fileup.uploadedExcelWithViewBtn(), "Displayed data and uploaded file data is not matched ");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void verifyLatestUploadedFileInPlanner() throws InterruptedException {
		fileup.getFileDetailsFromFileUpload();
		navigateTo.navigateToPlanner();
		Assert.assertTrue(fileup.verifyLatestUploadedFileInPlannerTest(), "Latest Uploaded File is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void verifyAllUploadedFilesInPlanner() throws InterruptedException {
		Assert.assertTrue(fileup.verifyAllUploadedFilesInPlanner());
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void verifyUserCanNavigateToGallaryView() throws InterruptedException {
		Assert.assertTrue(fileup.verifyUserCanNavigateToGallaryViewTest(),
				"Data card is not avaialble under gallary view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void verifyDataAvlUnderListView() throws InterruptedException {
		Assert.assertTrue(fileup.verifyDataAvlUnderListViewTest(), "Data card is not avaialble under list view ");
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void verifyUserIsAbleToEditTheCreatedFolder() throws InterruptedException {
		Assert.assertTrue(fileup.verifyUserIsAbleToEditTheCreatedFolderTest(),
				"User is unable to edit the created folder");
	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void verifyUserIsAbleToDeleteCreatedFolder() throws InterruptedException {
		Assert.assertTrue(fileup.verifyUserIsAbleToDeleteCreatedFolderTest(),
				"User is unable to delete the created folder");
	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void verifyTheAvailabilityOfCreatedFolder() throws InterruptedException {
		Assert.assertTrue(fileup.verifyTheAvailabilityOfCreatedFolderTest(),
				"Created Folder is avaialble post deleting the folder");
	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void verifyUserCanUploadTheCampaignFile() throws InterruptedException {
		Assert.assertTrue(fileup.verifyUserCanUploadTheCampaignFileTest(),
				"User is unable to upload the campaign file ");
	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void verifyTheAvailabilityOfUploadedCampaignFile() throws InterruptedException {
		Assert.assertTrue(fileup.verifyTheAvailabilityOfUploadedCampaignFileTest(),
				"Uploaded file is not available in ui");
	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void verifyUserCanUploadTheCampaignFileByAddingApportstopeInFile() throws InterruptedException {
		Assert.assertTrue(fileup.verifyUserCanUploadTheCampaignFileByAddingApportstopeInFileTest(),
				"User is unable to upload the campaign file containing comma");
	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void verifyAvailabilityOfUploadTheCampaignFileByAddingApportstopeInFile() throws InterruptedException {
		Assert.assertTrue(fileup.verifyAvailabilityOfUploadTheCampaignFileByAddingApportstopeInFileTest(),
				"Uploaded campaign file with comma is not available in ui");
	}

}