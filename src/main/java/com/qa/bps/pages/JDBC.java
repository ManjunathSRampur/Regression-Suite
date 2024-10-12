package com.qa.bps.pages;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class JDBC {

	public static String processValue;
	public static String configurationMode;
	public String siteNameInDb = "";
	public String processFlowNameInDb = "";
	public String locationNameInDb = "";
	public String eqNameInDB = "";

	public static String DB_URL = "";

	public String path = "/BPS/src/test/resources/DBKeys/";
	public static String DB_USER = "";
	public static String DB_PASSWORD = "";

	public String alertMsg = "";

	public static void getDBConnection(String DBURL, String DBUser, String DBPassword) {
		System.out.println(DBURL + " Url Printed");
		System.out.println(DBUser + " User printed");
		System.out.println(DBPassword + " Password printed");
		DB_URL = DBURL;
		DB_USER = DBUser;
		DB_PASSWORD = DBPassword;

	}

//Script to establish the database connection******************************************************************	

	public static void getConnection() throws SQLException {

		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

		System.out.println("connection established ");

		Statement statement = connection.createStatement();

		// 1. Query to Get Process order
		// flag****************************************************************************************

		ResultSet resultSet = statement.executeQuery(
				"select *from bodhee.iam_global_preferences igp where display_name ilike '%Process_order%'");

		while (resultSet.next()) {
			String columnValue = resultSet.getString("preference_value");
			String columnValue2 = resultSet.getString("preference_key");
			processValue = columnValue;
			System.out.println("Process Order flag = " + processValue);
			System.out.println("Col_val2 " + columnValue2);
		}
		EventProperties.ProcessOrderFlag = processValue;

		// 2. Query to Get Configuration
		// Mode****************************************************************************************
		ResultSet resultSet2 = statement.executeQuery(
				"select *from bodhee.iam_global_preferences igp where display_name ilike '%Configuration_mo%'");

		while (resultSet2.next()) {
			String columnValue = resultSet2.getString("preference_value");
			configurationMode = columnValue;
			System.out.println("Configuration mode = " + configurationMode);
		}
		EventProperties.actionLevel = configurationMode;

		connection.close();
	}

	public void getAlertMsgFromDB() throws SQLException {
		String queryToGetAlertMsg = "select*from imp.imp_handover_alert_messages";
		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		System.out.println("connection established ");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(queryToGetAlertMsg);
		while (resultSet.next()) {
			alertMsg = resultSet.getString("alert_message");
		}
		System.out.println(alertMsg);
		connection.close();
	}

	public void toMapProcessConifgration() throws SQLException {
		String queryToGetSitName = "select node_name from bodhee.node n where node_subtype_id =27;";
		String quertToGetProcessFlow = "select node_name  as process_flow_name from bodhee.node n where n.id in (select parent_node_id  from bodhee.node n where n.node_name = '"
				+ EventProperties.productName + "' and node_subtype_id in (31))";
		String queryForLocation = "select display_name from bodhee.node n where node_subtype_id =3";

		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		System.out.println("connection established ");
		Statement statement = connection.createStatement();
		ResultSet resultSet1 = statement.executeQuery(queryToGetSitName);
		while (resultSet1.next()) {
			siteNameInDb = resultSet1.getString("node_name");
		}

		System.out.println("Site name in Db " + siteNameInDb);

		ResultSet resultSet2 = statement.executeQuery(quertToGetProcessFlow);
		while (resultSet2.next()) {
			processFlowNameInDb = resultSet2.getString("process_flow_name");
		}

		ResultSet resultSet3 = statement.executeQuery(queryForLocation);
		while (resultSet3.next()) {
			locationNameInDb = resultSet3.getString("display_name");
		}

		EventProperties.SiteName = locationNameInDb.trim();
		System.out.println("Site name in Event properties " + EventProperties.SiteName);

		System.out.println("Query to get process flow is " + quertToGetProcessFlow);
		processFlowNameInDb = processFlowNameInDb.trim();
		System.out.println("Process flow name in DB :" + processFlowNameInDb);

		EventProperties.APUXpath = By.xpath("//p[.='" + siteNameInDb + "']/parent::div");

		System.out.println("Apu xpath :" + EventProperties.APUXpath);

		EventProperties.ProcessflowNameInBodhee = By.xpath("//p[contains(text(),'" + processFlowNameInDb + "')]");

		System.out.println("Process Flow xpath " + EventProperties.ProcessflowNameInBodhee);

		connection.close();
	}

	public void configureDelayCodeGrp() throws SQLException {
		String quertToConfigDelayCode = "insert into bodhee.node\r\n"
				+ "	(node_name, active_flag, description, parent_node_id, node_subtype_id, tenant_id, creation_date, created_by, uuid, parent_node_uuid)\r\n"
				+ "values('Automation_Delay_Code', true, 'Automation_Delay_Code',(select id from bodhee.node where node_subtype_id = (select id from bodhee.node_subtype ns where lower(node_type)= 'apu') limit 1),\r\n"
				+ "	(select id from bodhee.node_subtype ns where node_type= 'Delay Code group'), (select id from bodhee.tenant), current_timestamp, (select id from bodhee.iam_security_user where email = 'admin@neewee.ai'),\r\n"
				+ "	gen_random_uuid(), (select uuid from bodhee.node where node_subtype_id = (select id from bodhee.node_subtype ns where lower(node_type)= 'apu') limit 1 ))";

		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		System.out.println("connection established ");
		Statement statement = connection.createStatement();
		int m = statement.executeUpdate(quertToConfigDelayCode);
		if (m == 1) {
			System.out.println("Delay Code Group Inserted successfully");
		} else {
			System.out.println("Insertion failed ");
		}
		connection.close();
	}

	public void deleteConfigureDelayCode() throws SQLException {
		String queryToDeleteDelayCode = "delete from bodhee.node where node_name ='Automation_Delay_Code'";
		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		System.out.println("connection established ");
		PreparedStatement pStatement = connection.prepareStatement(queryToDeleteDelayCode);
		pStatement.execute();
		System.out.println("Created delay code group deleted ");
		connection.close();
	}

	public void getEquipmentNameFromDB() throws SQLException {
		String queryToGetEqName = "select neq.node_name  as equip_name \r\n" + "from imp.imp_assigned_asset impp\r\n"
				+ "join bodhee.node n on n.id = impp.node_id\r\n"
				+ "join bodhee.node neq on neq.id = impp.asset_id \r\n" + "where n.node_name ilike '%"
				+ Navigation.firstTaskNames + "%' limit 1\r\n" + "";
		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		System.out.println("connection established ");
		Statement statement = connection.createStatement();
		ResultSet resultSet1 = statement.executeQuery(queryToGetEqName);
		while (resultSet1.next()) {
			eqNameInDB = resultSet1.getString("equip_name");
		}

		System.out.println("Equipment Name in DB is :" + eqNameInDB);
		EventProperties.equipmentName = eqNameInDB;
		System.out.println("Equipment Name in Event Property " + EventProperties.equipmentName);

	}

}