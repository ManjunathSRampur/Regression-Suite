package com.qa.bps.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public static final List<String> EXPECTED_LOGIN_FIELD_NAMES_ = Arrays.asList("Login to your Bodhee account",
			"Privacy Policy", "Terms of Usage");
	public static final List<String> EXPECTED_HOME_SCREEN_NAMES_ = Arrays.asList("Microplanning", "Control Tower",
			"KPI Management", "VSB");
	public static final List<String> EXPECTED_CT_MANAGER_SCREEN_NAMES_ = Arrays.asList("Manager View",
			"Alerts & Notifications", "Shift Summary & Handover", "Plant View", "Product View and Delay Management",
			"Summary Dashboard");

	public static final List<String> EXPECTED_CT_MAIN_SCREEN_NAMES_ = Arrays.asList("Operator", "Shift Leader",
			"Manager");

	public static final List<String> EXPECTED_KPI_SUMMARY_LIST = Arrays.asList("Total Operators (Shift)",
			"Total Shift Leaders", "Total Operators Present", "Total Operators with Allocated Work",
			"Total Operators Absent:", "Average Operator Allocation (%)");
	public static final List<String> EXPECTED_FILETYPES_ = Arrays.asList("All", "Campaign Data", "Yield Data",
			"Demand Data", "Inventory Data");

	public static final List<String> EXPECTED_SSHANDOVER_HEADERS = Arrays.asList("Shift Lead", "Handed Over By",
			"Handover Time");
	public static final List<String> EXPECTED_PRODUCTVIEW_BATCH_LABELS = Arrays.asList("Start Date", "Pl. End Date*",
			"Delay", "Forecasted Delay");
	public static final List<String> EXPECTED_PRODUCTOVERVIEW_HEADER_LABELS = Arrays.asList("Campaign", "Pl. Start*",
			"Pl. End*", "Delay");
	public static final List<String> EXPECTED_MICROPLANNING_SCREEN_NAMES = Arrays.asList("File Upload", "Planner",
			"Alerts & Notifications", "Skill Matrix");
	public static final String inventoryFilepath = ".\\src\\test\\resources\\testdata\\Inventory_file.xlsx";
	public static final String campaignFilepath = ".\\src\\test\\resources\\testdata\\Campaign_file.xlsx";
	public static final String INVFILENAME = "Inventory_file.xlsx";
	public static final String CAMPAIGNFILENAME = "Campaign_file.xlsx";

	public static final String fileuploadsuccessmsg = "File Uploaded Successfully!";
	public static final int batchCount = 19;
	public static final String startlabel = "Start";// from product overview header section after closing all the batch
	public static final String endLabel = "End";// from product overview header section after closing all the batch

	public static final String sideTaskAddMsg = "Side Task details added Successfully.";
	public static final String SideTaskAddMsg = "Side Task details added Successfully.";
	public static final String color1 = "#FB8402";
	public static final String skillMatrixUploadToaster = "Please download the latest skill file before attempting to upload!";
	public static final String shiftSummaryHandoverUploadToaster = "Please fill all the required fields.";
	public static final List<String> EXPECTED_KPI_Management_SCREEN_NAMES_ = Arrays.asList(
			"Cycle Time Distribution Analysis", "Delay Analysis", "Schedule Adherence Report",
			"Equipment Relaunch Time Distribution Analysis", "eOEE Dashboard");
	public static final String TaskAddMsg = "Task Added Successfully!";
	public static final List<String> EXPECTED_Shifts = Arrays.asList("General 1 (Ujpest)", "General 2 (Ujpest)",
			"Day (Ujpest)", "Night (Ujpest)");
	public static final String SNAPSHOT_PATH = "\\src\\test\\resources\\screenshot";
	public static final String LOG_MSG = "tasks status updated successfully and triggered recommendations engine";
	public static final String DOWNLOAD_FILENAME_IN_MANAGER = "Manager View Constraint Violation  Week";
	public static final String DOWNLOAD_FILENAME_IN_SKILLMATRIX = "QuestionSheet";
	public static final String DOWNLOAD_FILENAME_IN_SHIFTHANDOVER = "shift_handover_report";
	public static final String DOWNLOAD_FILENAME_IN_FILEUPLOAD = "Campaign_file";
	public static final String DOWNLOAD_FILENAME_IN_FILEUPLOADTEMP = "Campaign_file";
	public static final String DOWNLOAD_FILENAME_IN_SUMMARYDASHBOARDinREPORT = "myExcelFile_export";
	public static final String DOWNLOAD_FILENAME_IN_SUMMARYDASHBOARDinPROD = "gantt";
	public static final List<String> EXPECTED_BODHEEESTUDIO_SCREEN_NAMES_ = Arrays.asList("Map Process", "KPI Manager",
			"IAM", "Data Management", "Team Management", "Admin Console", "Shift Pattern", "Plan Validation");
	public static final List<String> EXPECTED_VSB_FIELDS_NAMES = Arrays.asList("Equipment Unavailable", "As Planned",
			"Major Delay", "Planned", "Slight Delay");
	public static final List<String> EXPECTED_DAY_DROPDOWN_NAMES = Arrays.asList(" Day ", " 3 Days ", " Week ");

	public static final String UPLOAD_TOASTER_MSG_SHIFT_PATTERN = "Please download the latest shift pattern file to upload!";
	public static final String POLICY_TOASTER_MSG = "Password policy updated successfully.";
	public static final String POLICY_ERROR_TOASTER_MSG = "Please fill all the required field!";
	public static final String DElAY_TOLERANCE_PAGE_TITLE = "Delay Tolerance & Threshold Policy";
	public static final String USER_ROLE_SAVED_SUCCESSFULLY = "User Role Saved Successfully!";
	public static final String USER_SUCCESS_MSG = "User Details Updated Successfully!";
	public static final List<String> EXPECTED_SHIFT_DROPDOWN_LIST = Arrays.asList(" Day ", " Night ", " General 1 ",
			" General 2 ");
	public static final String USER_GROUP_SAVED_SUCCESSFULLY = "User Details Updated Successfully!";
	public static final String DAYSTARTTIME = "06:00";
	public static final String DAYENDTIME = "17:00";
	public static final String SHIFTPATTERN_UPLOAD_TOOLTIP = "Upload Shift Pattern Excel";
	public static final String SHIFTPATTERN_DOWNLOAD_TOOLTIP = "Download Shift Pattern Excel";
	public static final String DOWNLOAD_OPERATOR_GAP_ANALYSIS_TOOLTIP = "Download Operator Gap Analysis";
	public static final String FAILED_CONSRAINTS_TOOLTIP = "Failed Constraints";
	public static final String LOG_EVENTS_TOOLTIP = "Log Events";
	public static final String FULL_SCREEN_VIEW = "Full screen view";
	public static final String EQUIPMENT_VALIDATION = "Eq 123_B616";
	// public static final String DelayTolerance_SAVE_SUCESSFULLY="Changes saved
	// successfully!";
	public static final List<String> EQUIPMENT_VIEW_DROPDOWN_OPTIONS_ = Arrays.asList("Shift", "Day", "Week", "Month");

	public static final List<String> DELAY_FIELDS = Arrays.asList("JÓDMESAC-JÓDMESAC-23U001", "JM 2.1",
			"Prep_tasks_batch_eq25.00_IM", "manju r");

	public static final List<String> EXPECTED_MASTERDATA_SCREEN_NAMES_ = Arrays.asList("Material Master",
			"Functional Area", "Holiday Calendar", "Factory Calendar", "Department", "Breakdown Type", "Process BOM",
			"Material Stock Product Inventory", "Process Order", "Planned Order");
	public static final String FUNCTIONAL_SUCCESS_MSG = "Functional area saved Successfully!";
	public static final String expectedMsg = "Functional area saved Successfully!";
	public static String succExpected = "Saved Successfully!";
	public static final String SAVE_CHANGES = "Changes saved successfully!";
	public static final String SAVE_CHANGES_DEALAYTOLERANCE = "Changes saved successfully.";
	// public static final String SAVE_CHANGES_DEALAYTOLERANCE2="Error in
	// configuring the values.";
	public static final String CREATE_MATERIAL_MASTER = "Changes are saved successfully!";
	public static final String DELETE_USER_TOASTER = "User Deleted Successfully!";
	public static final String DELETE_GROUP_TOASTER = "User Group Deleted Successfully!";
	public static final String DELETE_ROLE_TOASTER = "User Role Deleted Successfully!";
	public static final String EDIT_USER_TOASTER = "User Details Updated Successfully!";
	public static final String EDIT_GRP_TOASTER = "User Details Updated Successfully!";
	public static final String EDIT_ROLE_TOASTER = "User Role Updated Successfully!";
	public static final String EDIT_MATERIAL_TOASTER = "Changes are saved successfully!";
	public static final String DELETE_MATERIAL_TOASTER = "Deleted Successfully!";
	public static final String DELETE_SUCCESS = "Deleted Successfully!";
	public static final String TEAM_SUCCESS = "Saved Successfully!";
	public static final String OP_SUCC = "Saved Successfully!";
	public static final String PLANNEDENSD_TEXT = "Planned End*";
	public static final String PLANNEDSTART_TEXT = "Planned Start*";
	public static final String BATCH_STATUS = "In-progress";
	public static final String ENR_SUCC_MSG = "tasks status updated successfully and triggered recommendations engine";
	public static final String PUBLISH_MSG = "Published";
	public static final String DElAY_TOLERANCE_PAGE_TITLE1 = "Delay Tolerance & Threshold Policy";
	public static final String SAVE_CHANGES_DEALAYTOLERANCE2 = "Error in configuring the values.";
	public static final String PRODUCT_OVERVIEW_PAGE_TITLE = " Product Overview ";
	public static final String SAVE_CHANGES_PRODUCTOVERVIEW = "";
	public static final String PLANNESTART_TEXT = "Tasks status updated successfully";
	public static final String SAVE_CHNAGE_TOASTER_TEAMSHIFT = "Shift Data Inserted Successfully!";
	public static final String SAVE_Shift_TOASTER_FECTORYCAL = "Changes saved successfully!";
	public static final List<String> operatorUtilizationFields = Arrays.asList("Operator Name", "% Utilization",
			"Utilization (Hrs)", "Planned Utilization (Hrs)");
	public static final List<String> shiftHandoverFooterBtnsList = Arrays.asList("Further Comments", "Cancel",
			"Handover to Next Shift", "Download Report");

	public static final String campaignFileNew = ".\\src\\test\\resources\\testdata\\fileUploadTest.xlsx";
	public static final String ADD_OP = "User 251 allocated to Team 2, Duration - 1/1/24, 6:00 AM -";
	public static final String LOG_EVENT_SUCC_TOASTER = "Unavailability Updated Successfully!!!";
	public static final String LOG_EVENT_ALERT = "Employee Unavailable: hcy-sennass hcy-john, Duration: 2024-01-01 06:00 - 2024-01-01 14:00";
	public static final String ALERT_SUCC = "Alert message added successfully!";
	public static final String ALERT_NOTIFICATION = "Start Time - 01/01/2024 06:00, End Time - 02/01/2024 08:00, Alert Message - Test Alert Message";
	public static final String SIDE_TASK_SUCC = "Side Task Added Successfully";

	public static final List<String> ShiftLeadHeaderBtn = Arrays.asList("Add Operator", "Side Task");
	public static final List<String> shiftLeadSecHeaderBtns = Arrays.asList("Refresh", "Deallocate Task To Shift Lead",
			"Reset", "Save");

}
