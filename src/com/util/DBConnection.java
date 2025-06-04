package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private final static String driverClassName = "com.mysql.jdbc.Driver";// jAR
	private final static String userName = "root";
	private final static String password = "root";
	private final static String connectionURL = "jdbc:mysql://localhost:3306/club3_2";

	public static Connection getDBConnection() {
		Connection conn = null;
		try {
			Class.forName(driverClassName); // 1st step..

			// getting connection with database..

			conn = DriverManager.getConnection(connectionURL, userName, password);
			if (conn != null) {
				System.out.println("database connected successfully...");
			}

			else {
				System.out.println("not connected...");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String[] args) {

		getDBConnection();
	}
}
