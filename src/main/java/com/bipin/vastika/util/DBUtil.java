package com.bipin.vastika.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URl = "jdbc:mysql://localhost:3306/bipin";
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "bipin128";


	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER_NAME);
		return DriverManager.getConnection(URl, USER_NAME, PASSWORD);
	}
}
