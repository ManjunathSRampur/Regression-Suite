package com.qa.bps.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;

public class HomePageTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		System.out.println("-----------Home Page-------------------------");
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void checkHomeScreenNamesExist() {
		Assert.assertEquals(homepage.HomeScreenNamesExist(), Constants.EXPECTED_HOME_SCREEN_NAMES_,
				"Expected field names are not matching/available");
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void checkWelcomeMsg() throws InterruptedException {

		Assert.assertTrue(homepage.weclomeMsgExist(), "Welcome message doesnt exists ");

	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void CheckValidationIamUser() throws InterruptedException {

		Assert.assertTrue(homepage.validateIamUser(), "IamUser doesnt exists");

	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void favoBtnAvailable() throws InterruptedException {

		Assert.assertTrue(homepage.favBtnAvailable(), "Favorites icon doesnt exists");

	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void nofavpopupAvailable() throws InterruptedException {

		Assert.assertTrue(homepage.noFavAdded(), "No favorites added popup is not available");

	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void favTosterDisplayed() throws InterruptedException {
		Assert.assertTrue(homepage.addFavorties(), "successful toaster message is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void favListAvailable() throws InterruptedException {

		Assert.assertTrue(homepage.checkFavHomePage(), "Favorite lists are not available");

	}

	@Test(groups = { "SmokeTest" }, priority = 8) // Need to verify
	public void favAdded() throws InterruptedException {

		Assert.assertTrue(homepage.checkFavAdded(), "Favorite is not available");

	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void favNavigationFromHeader() throws InterruptedException {

		Assert.assertTrue(homepage.checkFavoriteNavigationFromHeader(), "Favorite feature page is not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void favNavigationFromSection() throws InterruptedException {

		Assert.assertTrue(homepage.checkFavoriteNavigationFromFavSection(), "Favorite feature page is not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void favDelete() throws InterruptedException {

		Assert.assertTrue(homepage.deleteFavList(), "Favorites Removed toaster message is not displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void maxFavAddTest() throws InterruptedException {

		Assert.assertTrue(homepage.maxFavLimit(), "'Can add only 5 Favorites' toaster message is not diplayed  ");

	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void delAllFavListTest() throws InterruptedException {

		Assert.assertTrue(homepage.deleteAllFavList(), "All favorites are not deleted ");

	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void verifyDataValidationPostRefresh() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void checkBodheeLogo() {

		Assert.assertTrue(homepage.checkBodheeLogo(), "Bodhee Logo is not displayed");
	}

}
