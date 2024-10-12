package com.qa.bps.pages;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qa.bps.pages.PlanGenerationSC00;
import com.qa.bps.pages.PlanGenerationSC01;
import com.qa.bps.pages.PlanGenerationSC02;
import com.qa.bps.pages.PlanGenerationSC03;
import com.qa.bps.pages.PlanGenerationSC04;
import com.qa.bps.pages.PlanGenerationSC05;

public class SeleniumDatabaseTesting {
	//public static String operatorLastName;
	public static String processValue;
	public static String DB_URL = "jdbc:postgresql://172.20.10.4:5432/qa2?currentSchema=bodhee&ssl=true&sslfactory=org.postgresql.ssl.jdbc4.LibPQFactory&sslmode=require&sslkey=./src/test/resources/DBKeys/postgresql-2.pk8&sslcert=./src/test/resources/DBKeys/client-cert.pem&sslrootcert=./src/test/resources/DBKeys/ca-cert.pem"
			+ "";
	public String path = "/BPS/src/test/resources/DBKeys/";
	// Database Username
	public static String DB_USER = "sumit.nanda@neewee.ai";
	// Database Password
	public static String DB_PASSWORD = "snBT9MsWoRMVMyzB9Pa9jLev";

	@Test

	public static void getConnection() throws SQLException {

		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

		System.out.println("connection established ");

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(
				"select *from bodhee.iam_global_preferences igp where display_name ilike '%Process_order%'");

		while (resultSet.next()) {
			String columnValue = resultSet.getString("preference_value");
			System.out.println("Column Value: " + columnValue);
			processValue = columnValue;
			System.out.println(processValue);
		}
		EventProperties.ProcessOrderFlag = processValue;
		connection.close();
	}

	@Test

	public static boolean algoAuditorSc0() throws SQLException {
		boolean f = false;
		ArrayList<Boolean> List = new ArrayList<>();
		String category = "SCENARIO 0";
		String planVersionIdString = PlanGenerationSC00.plID;

		int planVersionId = Integer.parseInt(planVersionIdString);

		System.out.println("connection established ");

		String sql = "SELECT * FROM auditor.validation_check vc "
				+ "JOIN auditor.plan_version_validation_check_result pvvcr " + "ON vc.id = pvvcr.validation_check_id "
				+ "WHERE vc.category = ? " + "AND pvvcr.plan_version_id = ? " + "AND validation_check_id NOT IN (18);";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			// Set the parameters for the placeholders
			preparedStatement.setString(1, category); // Set the value for vc.category
			preparedStatement.setInt(2, planVersionId); // Set the value for pvvcr.plan_version_id

			// Execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				// Retrieve and process each row
				// Example: Fetching data from the result set
				boolean validationCheckId = resultSet.getBoolean("is_pass");
				// Add more result processing as needed

				System.out.println("Validation Check Status: " + validationCheckId);
				List.add(validationCheckId);
			}
			for (boolean d : List) {
				System.out.println(d);
				if (d == true) {
					System.out.println("pass " + d);
					f = true;
				} else {
					System.out.println("fail  " + d);
					f = false;
					break;
				}
			}

			resultSet.close(); // Close ResultSet
		}

		catch (SQLException e) {
			e.printStackTrace(); // Handle SQL exceptions
		}
		return f;
	}

	@Test

	public static boolean algoAuditorSc1() throws SQLException {
		boolean f = false;
		ArrayList<Boolean> List = new ArrayList<>();
		String category = "SCENARIO 1";
		String planVersionIdString = PlanGenerationSC01.plID;

		int planVersionId = Integer.parseInt(planVersionIdString);

		System.out.println("connection established ");

		String sql = "SELECT * FROM auditor.validation_check vc "
				+ "JOIN auditor.plan_version_validation_check_result pvvcr " + "ON vc.id = pvvcr.validation_check_id "
				+ "WHERE vc.category = ? " + "AND pvvcr.plan_version_id = ? " + "AND validation_check_id NOT IN (18);";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			// Set the parameters for the placeholders
			preparedStatement.setString(1, category); // Set the value for vc.category
			preparedStatement.setInt(2, planVersionId); // Set the value for pvvcr.plan_version_id

			// Execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				// Retrieve and process each row
				// Example: Fetching data from the result set
				boolean validationCheckId = resultSet.getBoolean("is_pass");
				// Add more result processing as needed

				System.out.println("Validation Check Status: " + validationCheckId);
				List.add(validationCheckId);
			}
			for (boolean d : List) {
				System.out.println(d);
				if (d == true) {
					System.out.println("pass " + d);
					f = true;
				} else {
					System.out.println("fail  " + d);
					f = false;
					break;
				}
			}

			resultSet.close(); // Close ResultSet
		}

		catch (SQLException e) {
			e.printStackTrace(); // Handle SQL exceptions
		}
		return f;
	}

	@Test

	public static boolean algoAuditorSc2() throws SQLException {
		boolean f = false;
		ArrayList<Boolean> List = new ArrayList<>();
		String category = "SCENARIO 2";
		String planVersionIdString = PlanGenerationSC02.plID;

		int planVersionId = Integer.parseInt(planVersionIdString);

		System.out.println("connection established ");

		String sql = "SELECT * FROM auditor.validation_check vc "
				+ "JOIN auditor.plan_version_validation_check_result pvvcr " + "ON vc.id = pvvcr.validation_check_id "
				+ "WHERE vc.category = ? " + "AND pvvcr.plan_version_id = ? " + "AND validation_check_id NOT IN (18);";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			// Set the parameters for the placeholders
			preparedStatement.setString(1, category); // Set the value for vc.category
			preparedStatement.setInt(2, planVersionId); // Set the value for pvvcr.plan_version_id

			// Execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				// Retrieve and process each row
				// Example: Fetching data from the result set
				boolean validationCheckId = resultSet.getBoolean("is_pass");
				// Add more result processing as needed

				System.out.println("Validation Check Status: " + validationCheckId);
				List.add(validationCheckId);
			}
			for (boolean d : List) {
				System.out.println(d);
				if (d == true) {
					System.out.println("pass " + d);
					f = true;
				} else {
					System.out.println("fail  " + d);
					f = false;
					break;
				}
			}

			resultSet.close(); // Close ResultSet
		}

		catch (SQLException e) {
			e.printStackTrace(); // Handle SQL exceptions
		}
		return f;
	}

	@Test

	public static boolean algoAuditorSc3() throws SQLException {
		boolean f = false;
		ArrayList<Boolean> List = new ArrayList<>();
		String category = "SCENARIO 3";
		String planVersionIdString = PlanGenerationSC03.plID;

		int planVersionId = Integer.parseInt(planVersionIdString);

		System.out.println("connection established ");

		String sql = "SELECT * FROM auditor.validation_check vc "
				+ "JOIN auditor.plan_version_validation_check_result pvvcr " + "ON vc.id = pvvcr.validation_check_id "
				+ "WHERE vc.category = ? " + "AND pvvcr.plan_version_id = ? " + "AND validation_check_id NOT IN (18);";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			// Set the parameters for the placeholders
			preparedStatement.setString(1, category); // Set the value for vc.category
			preparedStatement.setInt(2, planVersionId); // Set the value for pvvcr.plan_version_id

			// Execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				// Retrieve and process each row
				// Example: Fetching data from the result set
				boolean validationCheckId = resultSet.getBoolean("is_pass");
				// Add more result processing as needed

				System.out.println("Validation Check Status: " + validationCheckId);
				List.add(validationCheckId);
			}
			for (boolean d : List) {
				System.out.println(d);
				if (d == true) {
					System.out.println("pass " + d);
					f = true;
				} else {
					System.out.println("fail  " + d);
					f = false;
					break;
				}
			}

			resultSet.close(); // Close ResultSet
		}

		catch (SQLException e) {
			e.printStackTrace(); // Handle SQL exceptions
		}
		return f;
	}

	@Test

	public static boolean algoAuditorSc4() throws SQLException {
		boolean f = false;
		ArrayList<Boolean> List = new ArrayList<>();
		String category = "SCENARIO 4";
		String planVersionIdString = PlanGenerationSC04.plID;

		int planVersionId = Integer.parseInt(planVersionIdString);

		System.out.println("connection established ");

		String sql = "SELECT * FROM auditor.validation_check vc "
				+ "JOIN auditor.plan_version_validation_check_result pvvcr " + "ON vc.id = pvvcr.validation_check_id "
				+ "WHERE vc.category = ? " + "AND pvvcr.plan_version_id = ? " + "AND validation_check_id NOT IN (18);";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			// Set the parameters for the placeholders
			preparedStatement.setString(1, category); // Set the value for vc.category
			preparedStatement.setInt(2, planVersionId); // Set the value for pvvcr.plan_version_id

			// Execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				// Retrieve and process each row
				// Example: Fetching data from the result set
				boolean validationCheckId = resultSet.getBoolean("is_pass");
				// Add more result processing as needed

				System.out.println("Validation Check Status: " + validationCheckId);
				List.add(validationCheckId);
			}
			for (boolean d : List) {
				System.out.println(d);
				if (d == true) {
					System.out.println("pass " + d);
					f = true;
				} else {
					System.out.println("fail  " + d);
					f = false;
					break;
				}
			}

			resultSet.close(); // Close ResultSet
		}

		catch (SQLException e) {
			e.printStackTrace(); // Handle SQL exceptions
		}
		return f;
	}

	@Test

	public static boolean algoAuditorSc5() throws SQLException {
		boolean f = false;
		ArrayList<Boolean> List = new ArrayList<>();
		String category = "SCENARIO 5";
		String planVersionIdString = PlanGenerationSC05.plID;

		int planVersionId = Integer.parseInt(planVersionIdString);

		System.out.println("connection established ");

		String sql = "SELECT * FROM auditor.validation_check vc "
				+ "JOIN auditor.plan_version_validation_check_result pvvcr " + "ON vc.id = pvvcr.validation_check_id "
				+ "WHERE vc.category = ? " + "AND pvvcr.plan_version_id = ? " + "AND validation_check_id NOT IN (18);";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			// Set the parameters for the placeholders
			preparedStatement.setString(1, category); // Set the value for vc.category
			preparedStatement.setInt(2, planVersionId); // Set the value for pvvcr.plan_version_id

			// Execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				// Retrieve and process each row
				// Example: Fetching data from the result set
				boolean validationCheckId = resultSet.getBoolean("is_pass");
				// Add more result processing as needed

				System.out.println("Validation Check Status: " + validationCheckId);
				List.add(validationCheckId);
			}
			for (boolean d : List) {
				System.out.println(d);
				if (d == true) {
					System.out.println("pass " + d);
					f = true;
				} else {
					System.out.println("fail  " + d);
					f = false;
					break;
				}
			}

			resultSet.close(); // Close ResultSet
		}

		catch (SQLException e) {
			e.printStackTrace(); // Handle SQL exceptions
		}
		return f;
	}

	@Test

	public boolean genericDBValidation(String category, int plID1) throws SQLException {
		boolean f = false;
		ArrayList<Boolean> List = new ArrayList<>();
//		String category = "SCENARIO 5";
		String planVersionIdString = PlanGenerationSC05.plID;

//		int planVersionId = Integer.parseInt(planVersionIdString);

		System.out.println("connection established ");

		String sql = "SELECT * FROM auditor.validation_check vc "
				+ "JOIN auditor.plan_version_validation_check_result pvvcr " + "ON vc.id = pvvcr.validation_check_id "
				+ "WHERE vc.category = ? " + "AND pvvcr.plan_version_id = ? " + "AND validation_check_id NOT IN (18);";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			// Set the parameters for the placeholders
			preparedStatement.setString(1, category); // Set the value for vc.category
			preparedStatement.setInt(2, plID1); // Set the value for pvvcr.plan_version_id

			// Execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				// Retrieve and process each row
				// Example: Fetching data from the result set
				boolean validationCheckId = resultSet.getBoolean("is_pass");
				// Add more result processing as needed

				System.out.println("Validation Check Status : " + validationCheckId);
				List.add(validationCheckId);
			}
			for (boolean d : List) {
				System.out.println(d);
				if (d == true) {
					System.out.println("pass " + d);
					f = true;
				} else {
					System.out.println("fail  " + d);
					f = false;
					break;
				}
			}

			resultSet.close(); // Close ResultSet
		}

		catch (SQLException e) {
			e.printStackTrace(); // Handle SQL exceptions
		}
		return f;
	}
	
	@Test

	public static String genericOperatorUnavailability(String planVersionIdString ) throws SQLException {
		String operatorLastName = null;
		boolean f = false;
		ArrayList<Boolean> List = new ArrayList<>();
		String category = "SCENARIO 3";
//		String planVersionIdString = PlanGenerationSC03.plID1;

		int planVersionId = Integer.parseInt(planVersionIdString);

		System.out.println("connection established ");

		String sql = "SELECT o.id, isu.first_name, isu.last_name, o.security_user_id, " +
                "iop.operator_id, iop.imp_plan_version_id, iop.planned_start_time, " +
                "iop.planned_end_time " +
                "FROM imp.imp_operator_plan iop " +
                "JOIN team.\"operator\" o ON iop.operator_id = o.id " +
                "JOIN bodhee.iam_security_user isu ON o.security_user_id = isu.id " +
                "WHERE iop.imp_plan_version_id = ? " +
                "ORDER BY iop.planned_start_time ASC " +
                "LIMIT 1";
		String updateQuery = "UPDATE imp.imp_operator_plan SET imp_plan_version_id = ? " +
                "WHERE imp_plan_version_id = ?";
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				PreparedStatement updateStatement = connection.prepareStatement(updateQuery)){

			// Set the parameters for the placeholders
			preparedStatement.setInt(1, planVersionId); // Set the value for vc.category
//			preparedStatement.setInt(2, planVersionId); // Set the value for pvvcr.plan_version_id

			// Execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				// Retrieve and process each row
				// Example: Fetching data from the result set
				 operatorLastName = resultSet.getString("last_name");
				// Add more result processing as needed

				System.out.println("Operator ID: " + operatorLastName);
				
				
				}
			resultSet.close();

			}catch (SQLException e) {
				e.printStackTrace(); // Handle SQL exceptions
			}
		
		return operatorLastName;
	}

	
}
