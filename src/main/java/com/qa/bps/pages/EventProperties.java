package com.qa.bps.pages;

import org.openqa.selenium.By;

public class EventProperties {
	public static String event_Id = "(//div[@aria-label='-Ch: - Preparation_eq201_PQB'])[1]";
	public static String sec_task_eventId = "(//div[@aria-label='-Ch: - Feeding in 201_eq201_PQB'])[1]";
	public static String task_Date = "02/07/2024";
	public static String delayTime = "020720240700A"; // mm/dd/yyyy/time/A
	public static String delayCloseTime = "020720241000A";// mm/dd/yyyy/time/A
	public static String earlyStartTime = "020720240500A";
	public static String earlyClose = "020720240630A";
	public static String equipmentName = "Eq 201_B705";
	public static String assetDownReason = "Maintenance";
	public static String baselineDate="08010020240600A";
	public static String eqUnAvlDate = "02/06/202419:00";
	public static String eqUnAvlToDate = "020720240700A";
	public static String eqNameInPOV = "705-1080-303-201_B705 Maintenance";//
	public static String delayReasonCode = "Trial/Validation/Qualification";
	public static String opUnAvlFromDate = "020620240600A";
	public static String opUnAvlToDate = "022720240600A";
	public static String PlannedStateDate = "020720241100pm";
	public static String addSideTaskTime = "1100Pm";
	public static String  ProcessOrderFlag;
	public static String productNameStartsWith="R";
	public static String lessThanDate="01182025";
	
	
	
	// Below Variables for Bodhee studio
	public static String SiteName = "Ujpest";
	public static By APUXpath = By.xpath("//div[@id='47']");
	public static By ProcessflowNameInBodhee = By.xpath("//div[@id='938']");
	public static By productNameInBodhee = By.xpath("//div[@id='1840']");
	public static By TgNameInBodhee = By.xpath("//div[@id='1843']");
	public static By TaskNameInBodhee = By.xpath("//div[@id='2319']");
	public static By moveNodeLocation = By.xpath("//div[contains(text(),'Ujpest')]");
	public static By baseLocation = By.xpath("//li[@id='46']");

}
