package com.api.termomecanica.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

	private static Connection connection = null;

	public static Connection getConnection() throws Exception {

		if (connection != null)
			return connection;
		else {

			// String driver = "com.mysql.cj.jdbc.Driver";
			//String driver = "org.postgresql.Driver";

			// String url = "jdbc:mysql://localhost:3306";
			// String url =
			// "jdbc:mysql://localhost:3306/bancolp?useTimezone=true&serverTimezone=UTC";
			String url = "jdbc:postgresql://localhost/bancolp";

			String user = "postgres";
			String password = "root";

			//Class.forName(driver);

			connection = DriverManager.getConnection(url, user, password);

			connection.setAutoCommit(true);

			return connection;
		}

	}

}
