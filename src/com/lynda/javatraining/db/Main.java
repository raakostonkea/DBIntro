package com.lynda.javatraining.db;

import com.sun.jndi.ldap.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String CONN_STRING =
			"jdbc:mysql://localhost/explorecalifornia";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// før java 6 eller syv.
		//Class.forName("com.mysql.jdbc.Driver");

		// add libery.
		com.mysql.jdbc.Connection conn = null;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery("SELECT  * FROM  states");


			rs.last();
			System.out.println("number of rows : " + rs.getRow());

//			System.out.println("connected !");

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (rs != null ) {
				rs.close();
			}

			if (stmt != null ) {
				stmt.close();
			}

			if (conn != null ) {
				conn.close();
			}


			// næste fase er at få workbenchen til at fungere.


		}


	}

}
