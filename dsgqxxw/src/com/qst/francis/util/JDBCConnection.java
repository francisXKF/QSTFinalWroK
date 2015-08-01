package com.qst.francis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {
	private Connection connection = null;
	private static final String jdbcpath = "jdbc:mysql://localhost:3306/qst";
	private static final String jdbcuser = "root";
	private static final String jdbcpassword = "francis";

	//jdbc connection
	public Connection getConnection(){
		return this.connection;
	}
	public Connection createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcpath, jdbcuser, jdbcpassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("failed connection");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("failed connection");
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement){
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(preparedStatement != null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("close connection failed");
			e.printStackTrace();
		}
	}
}
