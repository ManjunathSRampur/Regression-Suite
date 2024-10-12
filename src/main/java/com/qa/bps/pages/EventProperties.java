package com.qa.bps.pages;

import org.openqa.selenium.By;

public class EventProperties {
	public static String event_Id = "";
	public static String sec_task_eventId = "";
	public static String task_Date = "";
	public static String delayTime = "";
	public static String delayCloseTime = "";
	public static String earlyStartTime = "";
	public static String earlyClose = "";
	public static String equipmentName = "Eq 201_B705";
	public static String assetDownReason = "Maintenance";// no need to remove common in all env

	public static String eqUnAvlDate = "02/06/202419:00";
	public static String eqUnAvlToDate = "020720240100A";

	public static String eqNameInPOV = "N 370-G-R.0.212 (PMA)-PMA305_M&B (6000L)";//

	public static String delayReasonCode = "Automation_Delay_Code";
	public static String opUnAvlFromDate = "020620240600A";
	public static String opUnAvlToDate = "022720240600A";
	public static String PlannedStateDate = "020720241100pm";
	public static String addSideTaskTime = "0600am";
	public static String firstBatchNumber = "null";

	public static String actionLevel;
	public static String ProcessOrderFlag;

	// Below Variables for Bodhee studio

	public static String productName = "";
	public static String firstTaskGroupName = "";

	public static String SiteName = "Marburg";
	public static By APUXpath = By.xpath("//p[.='MMP']/parent::div");
	public static By ProcessflowNameInBodhee = By.xpath("//p[.='PF_rP 287-953']/parent::div");
	public static By productNameInBodhee = By.xpath("//div[@id='498']");
	public static By TgNameInBodhee = By.xpath("//div[@id='499']");
	public static By TaskNameInBodhee = By.xpath("//div[@id='500']");
	public static By moveNodeLocation = By.xpath("//div[contains(text(),'Marburg')]");
	public static By baseLocation = By.xpath("//li[.='Marburg']");

}
