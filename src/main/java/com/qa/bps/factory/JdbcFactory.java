package com.qa.bps.factory;

import java.sql.ResultSet;

import com.qa.bps.utils.JDBCUtil;

public class JdbcFactory {
	
	
	public int runDBQuery() throws Exception {
		int result = 0;
		String query = "SELECT count(*) FROM bodhee.file_upload_history";
		JDBCUtil jdbcu = new JDBCUtil();
		jdbcu.ConnectDB();
		ResultSet res = jdbcu.executeQuery(query);
		while (res.next()) {
			System.out.println("count is " + res.getInt(1));
			result = res.getInt(1);
		}
		jdbcu.DisconnectDB();
		return result;

	}

}
