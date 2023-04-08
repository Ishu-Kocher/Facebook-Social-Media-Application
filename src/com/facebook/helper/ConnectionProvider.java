package com.facebook.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	//Connection
	private static Connection con;

	public static Connection getConnection() {

		try {

			if (con == null) {
				// load driver class
				Class.forName("com.mysql.cj.jdbc.Driver");

				// create connection
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook", "root", "ishu");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
