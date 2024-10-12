package com.qa.bps.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ElementUtil;

public class SkillMatrix {

	WebDriver driver;
	String RL;
	String TM;
	String email;
	String fn;
	String ln;

	private By skillDetails = By.xpath("//div[@class='fm-row' and @role='row']");
	private By taskFilter = By.xpath("//div[@class='fm-cell fm-header fm-filter-header fm-draggable' and @data-h='2']");
	private By taskSelect = By.xpath("//div[@class='fm-ui-element fm-ui fm-filters-table-content']//ul/li[1]");
	private By selectAll = By.xpath("//div[@class='fm-ui-element fm-ui fm-select-all-wrapper fm-ui-col']");
	private By applyBtn = By.xpath("//button[contains(text(),'Apply')]");
	private By uploadbtn = By.xpath("//img[@title='Upload SKill Matrix Excel']");
	private By msgToaster = By.xpath("//div[@class='toast-bottom-right toast-container']");
	private By downloadBtn = By.xpath("//img[@title='Download SKill Matrix Excel']");
	private By clickCell = By.xpath("(//div[@class='fm-cell fm-level-0'])[2]");
	private By clickDetailsCell = By.xpath("//div[@class='fm-cell' and @data-n='odd']");
	private By clickEmptyRow = By.xpath("(//div[@class='fm-cell fm-empty' and @data-n='odd'])[1]");
	private By clickClose = By.xpath("(//button[@role='button'])[5]");
	private By createRoleIcon=By.xpath("//a[@routerlink='userRoles']");
	private By createRoleBtn1=By.xpath("(//button[.='Create new role'])[1]");
	private By roleNameTextField=By.xpath("(//input[@placeholder='Enter role name'])[1]");
	private By descTxtField=By.xpath("//input[@placeholder='Enter description']");
	private By createRoleBtn2=By.xpath("//button[.='Save']");
	private By roleToster=By.xpath("//div[@id='toast-container']");
	private By searchBox=By.xpath("(//input[@placeholder='Search'])[2]"); 
	private By firstRow= By.xpath("(//div[@tabulator-field='name'])[2]");
	private By threeDot=By.xpath("(//img[@src='./assets/png/3-dot-menu.svg'])[1]");
	private By deleteIcon=By.xpath("(//img[@src='./assets/png/deletesvg.svg'])");
	private By deleteRoleName=By.xpath("(//input[@placeholder='Enter role name'])[2]");
	private By deleteBtn=By.xpath("//button[.='Delete']");
	private By deleteToster=By.xpath("//div[@id='toast-container']");
	private By operatorTeamTab=By.xpath("//a[@id='v-pills-userGroup-tab']");
	private By createNewTeamBtn=By.xpath("(//button[.='Create new team'])[1]");
	private By teamTittleTxtField=By.xpath("//input[@placeholder='Enter team title']");
	private By teamDescTxtField=By.xpath("//input[@placeholder='Enter description']");
	private By firstOption=By.xpath("(//div[@role='option'])[1]");
	private By selectOperatorDroDown=By.xpath("(//div[.='Select operators'])[2]");
	private By selectOrgTypeDD=By.xpath("(//div[.='Select Organization Type'])[1]");
	private By optionOrgDD=By.xpath("(//div[@role='option'])[3]");
	private By chooseShiftDD=By.xpath("(//div[.='Select Shift'])[2]");
	private By firstOptnShift=By.xpath("(//div[@role='option'])[1]");
	private By createNewTeam=By.xpath("(//button[.='Save'])[1]");
	private By orgNodeDD=By.xpath("(//div[.='Select Organization Node'])[1]");
	private By optnOrgNodeDD=By.xpath("//div[@role='option']");
	private By crossMark=By.xpath("(//div[@class='tabulator-row tabulator-selectable tabulator-row-odd']//div)[19]");
	private By checkBox=By.xpath("//div[@class='tabulator-cell tabulator-editing']/input");
	private By toaster=By.xpath("//div[@id='toast-container']");
	private By searchBx=By.xpath("(//input[@placeholder='Search'])[2]");
	private By firstCell=By.xpath("(//div[@tabulator-field='name'])[2]");
	private By deleteTeamName=By.xpath("//input[@placeholder='Enter team name']");
	private By operatorTab=By.xpath("//a[@id='v-pills-user-tab']");
	private By newOpratotBtn=By.xpath("//button[.='Create new operator']");
	private By firstName=By.xpath("//input[@placeholder='Enter First name']");
	private By firstNameEdit=By.xpath("(//input[@placeholder='Enter First name'])[2]");
	private By lastName=By.xpath("//input[@placeholder='Enter Last name']");
	private By emailId=By.xpath("(//input[@placeholder='Enter Email address'])[1]");
	private By emailId2=By.xpath("(//input[@placeholder='Enter Email address'])[2]");
	private By phNum=By.xpath("//input[@placeholder='Enter Mobile number']");
	private By password=By.xpath("(//input[@placeholder='Enter Password'])[1]");
	private By selectTeamDD=By.xpath("(//input[@role='combobox'])[1]"); 
	private By selectTeamDDFirstOptn=By.xpath("(//div[@role='option'])[1]"); 
	private By selectRoleDD=By.xpath("(//div[.='Select Role'])[2]");
	private By selectRoleDDFirstOptn=By.xpath("(//div[@role='option'])[1]");
	private By statusScrool=By.xpath("//span[@class='slider round']");
	private By addNewOPBtn=By.xpath("(//button[.='Save'])[1]");
	private By opNameFirstCell=By.xpath("(//div[@tabulator-field='display_name'])[2]");
	private By editBtn=By.xpath("//img[@src='./assets/png/editsvg.svg']");
	private By saveRole=By.xpath("//button[.='Save']");
	private By saveTeamBtn=By.xpath("(//button[.='Save'])[1]");
	private By saveOperatorBtn=By.xpath("(//button[.='Save'])[2]");
	private By showPassWord = By.xpath("(//label[@class='custom-control-label'])[1]");

	private ElementUtil eleUtil;

	public SkillMatrix(WebDriver driver) {
		eleUtil = new ElementUtil(driver);
		this.driver = driver;
	}

	public boolean isSkillDetailsDisplayed() throws InterruptedException {

		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@id='v-pills-skillMetrix-tab']")).click();
		Thread.sleep(5000);

		boolean b = driver.findElement(skillDetails).isDisplayed();
		return b;
	}

	public boolean isTaskSkillDetailsDisplayed() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(taskFilter).click();
		driver.findElement(selectAll).click();
		driver.findElement(taskSelect).click();
		driver.findElement(applyBtn).click();
		boolean b = isSkillDetailsDisplayed();
		return b;

	}

	// 30692 Verify user is able to upload the skill matrix template without
	// downloading the latest file.
	public String verifyUploadSkillMatrix() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(uploadbtn).click();
		Thread.sleep(2000);
		driver.findElement(msgToaster).isDisplayed();
		String msgDisplayed = driver.findElement(msgToaster).getText();
		Thread.sleep(2000);
		System.out.println(msgDisplayed);
		return msgDisplayed;
	}

	// 30693 Verify no toaster message is displayed when user is clicks on the
	// upload button after downloading the latest skill matrix excel.
	public boolean verifyMsgDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(uploadbtn).click();
		//Thread.sleep(2000);
		//driver.findElement(downloadBtn).click();
		Thread.sleep(8000);
		//driver.findElement(uploadbtn).click();
		boolean fe = driver.findElement(msgToaster).isDisplayed();
		System.out.println(fe);
		return fe;
	}
	
	public boolean verifyDownloadSkillMatrix() throws InterruptedException, ElementClickInterceptedException, IOException {
		boolean b=eleUtil.fileDownload(downloadBtn, Constants.DOWNLOAD_FILENAME_IN_SKILLMATRIX);
		return b;
	}
	
	public boolean createRole(String roleName,String Description) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(createRoleIcon).click();
		Thread.sleep(3000);
		driver.findElement(createRoleBtn1).click();
		Thread.sleep(3000);
		String randomText=RandomStringUtils.randomAlphabetic(3);
		 RL=randomText+"-"+roleName;
		String DISC=randomText+"-"+Description;
		Thread.sleep(3000);
		driver.findElement(roleNameTextField).sendKeys(RL);
		Thread.sleep(3000);
		driver.findElement(descTxtField).sendKeys(DISC);
		Thread.sleep(3000);
		driver.findElement(createRoleBtn2).click();
		Thread.sleep(2000);
		String succMsg=driver.findElement(roleToster).getText();
		System.out.println(succMsg);
		String c =Constants.succExpected;
		Thread.sleep(3000);
		driver.findElement(searchBox).sendKeys(RL);
		Thread.sleep(3000);
	String	name=driver.findElement(firstRow).getText();
	
	return eleUtil.tosterMsgAndSearchValidation(succMsg, c, name, RL);
		
	}
	public boolean deleteRole() throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.findElement(createRoleIcon).click();
		Thread.sleep(3000);
		driver.findElement(searchBox).clear();
		Thread.sleep(3000);
		driver.findElement(searchBox).sendKeys(RL);
		Thread.sleep(3000);
		driver.findElement(threeDot).click();
		Thread.sleep(3000);
		driver.findElement(deleteIcon).click();
		Thread.sleep(3000);
//		driver.findElement(deleteRoleName).sendKeys(RL+" "+"updated");
//		Thread.sleep(3000);
		driver.findElement(deleteBtn).click();
		Thread.sleep(3000);
		String delete_suss=driver.findElement(deleteToster).getText();
		System.out.println(delete_suss);
		String deleteMSG=Constants.DELETE_SUCCESS;
		return eleUtil.tosterMsgValidation(delete_suss, deleteMSG);
		
	}
	public boolean createTeam(String tittle, String desc) throws InterruptedException, AWTException 
	{  
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(operatorTeamTab).click();
		driver.findElement(createNewTeamBtn).click();
		String randomText=RandomStringUtils.randomAlphabetic(3);
	     TM=randomText+"-"+tittle;
		String DISC=randomText+"-"+desc;
		driver.findElement(teamTittleTxtField).sendKeys(TM);
		driver.findElement(teamDescTxtField).sendKeys(DISC);
		Thread.sleep(2000);
//		driver.findElement(selectOperatorDroDown).click();
//		Thread.sleep(2000);
//		driver.findElement(firstOption).click();
		Thread.sleep(2000);
		driver.findElement(selectOrgTypeDD).click();
		Thread.sleep(2000);
		driver.findElement(optionOrgDD).click();
		Thread.sleep(2000);
		driver.findElement(orgNodeDD).click();
		Thread.sleep(2000);
		
		driver.findElement(optnOrgNodeDD).click();
		Thread.sleep(2000);
//		driver.findElement(crossMark).click();
//		Thread.sleep(5000);
//		driver.findElement(checkBox).click();
		
//		eleUtil.doZoomOut();
//		Thread.sleep(3000);
		
		//driver.findElement(chooseShiftDD).click();
		//Thread.sleep(2000);
		//driver.findElement(firstOptnShift).click();
		
		//driver.findElement(By.xpath("//*[@id=\"teamhistory\"]/div[2]/div/div/div[5]")).click();
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div[.='-- select date --'])[1]")).sendKeys("09032024");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[.='-- select date --']")).sendKeys("09042024");
		driver.findElement(createNewTeam).click();
		String EXP=Constants.TEAM_SUCCESS;
		Thread.sleep(2000);
		String toasterMSG=driver.findElement(toaster).getText();	
		System.out.println(toasterMSG);
		Thread.sleep(2000);
		driver.findElement(searchBx).sendKeys(TM);
		Thread.sleep(2000);
		String cellValue=driver.findElement(firstCell).getText();
		
		return eleUtil.tosterMsgAndSearchValidation(toasterMSG, EXP, cellValue, TM);
		
	}
	public boolean deleteTeam() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(searchBox).clear();
		driver.findElement(operatorTeamTab).click();
		driver.findElement(searchBox).sendKeys(TM);
		Thread.sleep(2000);
		driver.findElement(threeDot).click();
		Thread.sleep(2000);
		driver.findElement(deleteIcon).click();
//		Thread.sleep(3000);
//		driver.findElement(deleteTeamName).sendKeys(TM+" "+"updated");
		Thread.sleep(2000);
		driver.findElement(deleteBtn).click();
		Thread.sleep(2000);
		String delete_suss=driver.findElement(deleteToster).getText();
		System.out.println(delete_suss);
		String deleteMSG=Constants.DELETE_SUCCESS;
		return eleUtil.tosterMsgValidation(delete_suss, deleteMSG);
		
	}
	public boolean createOperators(String FN,String LN, String Email ,String pwd) throws InterruptedException
	{

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(operatorTab).click();
		driver.findElement(newOpratotBtn).click();
		
		String randomText=RandomStringUtils.randomAlphabetic(3);
	      fn=randomText+"-"+FN;
	      ln=randomText+"-"+LN;
		 email=randomText+"-"+Email;
		
		Thread.sleep(2000);
		driver.findElement(firstName).sendKeys(fn);
		Thread.sleep(2000);
		driver.findElement(lastName).sendKeys(ln);
		Thread.sleep(2000);
		driver.findElement(emailId).sendKeys(email);
		Thread.sleep(2000);
		//driver.findElement(phNum).sendKeys(phNo);
		driver.findElement(password).sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(showPassWord).click();
		Thread.sleep(8000);
		WebElement ele=driver.findElement(statusScrool);
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollIntoView();",ele );
		Thread.sleep(4000);
		driver.findElement(selectTeamDD).click();
		Thread.sleep(2000);
		driver.findElement(selectTeamDDFirstOptn).click();
		Thread.sleep(2000);
		driver.findElement(selectRoleDD).click();
		Thread.sleep(2000);
		driver.findElement(selectRoleDDFirstOptn).click();
		Thread.sleep(2000);
		driver.findElement(statusScrool).click();
		Thread.sleep(2000);
		driver.findElement(addNewOPBtn).click();
		System.out.println("clicked");
		Thread.sleep(2000);
		String succ_Toaster=driver.findElement(toaster).getText();
		System.out.println(succ_Toaster);
		String EXP=Constants.TEAM_SUCCESS;
		driver.findElement(searchBox).sendKeys(fn+" "+ln);
		Thread.sleep(2000);
     String	cellValue=driver.findElement(opNameFirstCell).getText();
     System.out.println(cellValue);
     System.out.println(fn+" "+ln);
     
 	return eleUtil.tosterMsgAndSearchValidation(succ_Toaster, EXP, cellValue, fn+" "+ln);
		}
	
	public boolean deleteOperator() throws InterruptedException
	{
		driver.findElement(operatorTab).click();
		driver.findElement(threeDot).click();
		Thread.sleep(2000);
		driver.findElement(deleteIcon).click();
		Thread.sleep(2000);
//		driver.findElement(emailId2).sendKeys(email);
//		Thread.sleep(2000);
		driver.findElement(deleteBtn).click();
		Thread.sleep(2000);
		String delete_suss=driver.findElement(deleteToster).getText();
		System.out.println(delete_suss);
		String deleteMSG=Constants.DELETE_SUCCESS;
		
		return eleUtil.tosterMsgValidation(delete_suss, deleteMSG);
		
		
	}
	public boolean editRole() throws InterruptedException
	{
		
		Thread.sleep(2000);
		driver.findElement(createRoleIcon).click();	
		Thread.sleep(3000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(RL);
		Thread.sleep(2000);
		driver.findElement(threeDot).click();
		Thread.sleep(2000);
		driver.findElement(editBtn).click();
		Thread.sleep(3000);
		driver.findElement(roleNameTextField).clear();
		Thread.sleep(2000);
		driver.findElement(roleNameTextField).sendKeys(RL+" "+"updated");
		Thread.sleep(2000);
		driver.findElement(saveRole).click();
		Thread.sleep(2000);
		String toaster_MSG=driver.findElement(toaster).getText();
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(RL+" "+"updated");
		Thread.sleep(2000);
		String firstrow=driver.findElement(firstRow).getText();
		
		String c =Constants.succExpected;
		Thread.sleep(3000);
	
	return eleUtil.tosterMsgAndSearchValidation(toaster_MSG, c, firstrow, RL+" "+"updated");
		
	}
	public boolean editTeam() throws InterruptedException
	{
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(operatorTeamTab).click();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(TM);
		Thread.sleep(2000);
		driver.findElement(threeDot).click();
		Thread.sleep(2000);
		driver.findElement(editBtn).click();
		Thread.sleep(2000);
		driver.findElement(teamTittleTxtField).clear();
		Thread.sleep(2000);
		driver.findElement(teamTittleTxtField).sendKeys(TM+" "+"updated");
		Thread.sleep(2000);
		driver.findElement(saveTeamBtn).click();
		Thread.sleep(2000);
	    String	save_succ=driver.findElement(toaster).getText();
	    Thread.sleep(2000);
	    driver.findElement(searchBox).clear();
	    Thread.sleep(2000);
	    driver.findElement(searchBox).sendKeys(TM+" "+"updated");
	    Thread.sleep(2000);
        String cellValue=driver.findElement(firstCell).getText();
        String EXP=Constants.TEAM_SUCCESS;
		
		return eleUtil.tosterMsgAndSearchValidation(save_succ, EXP, cellValue, TM+" "+"updated");
	    
		
		
	}
	public boolean editOperator() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(searchBox).clear();
		Thread.sleep(2000);
		driver.findElement(operatorTab).click();
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(fn+" "+ln);
		Thread.sleep(2000);
		driver.findElement(threeDot).click();
		Thread.sleep(2000);
		driver.findElement(editBtn).click();
		Thread.sleep(2000);
		driver.findElement(firstNameEdit).clear();
		Thread.sleep(2000);
		driver.findElement(firstNameEdit).sendKeys(fn);
		Thread.sleep(2000);
		driver.findElement(saveOperatorBtn).click();
		Thread.sleep(2000);
		String succ_Toaster=driver.findElement(toaster).getText();
		System.out.println(succ_Toaster);
		String EXP=Constants.TEAM_SUCCESS;
		Thread.sleep(3000);
		 driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys(fn+" "+ln);
		Thread.sleep(3000);
     String	cellValue=driver.findElement(opNameFirstCell).getText();
     System.out.println(cellValue);
     System.out.println(fn+" "+ln);
     
 	return eleUtil.tosterMsgAndSearchValidation(succ_Toaster, EXP, cellValue, fn+" "+ln);
		}
		
		
	}
	


