package com.qa.bps.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.bps.factory.DriverFactory;

public class JDBCUtil {
	static String mainPath = "./src/test/resources/DBKeys/";
	static Connection con = null;
	private static Statement stmt;
	private ResultSet res;
	static DriverFactory df;
	static Properties prop;
	
	public void ConnectDB() throws SQLException {
		try {
			df = new DriverFactory();
			prop = df.initProperties();
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("DB_USER"),
					prop.getProperty("DB_PASSWORD"));
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQuery(String query) {
		try {
			res = stmt.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void DisconnectDB() throws Exception {
		if (con != null) {
			con.close();
		}
	}
}
