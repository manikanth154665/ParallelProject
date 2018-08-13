package com.cg.pwa.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	public static Connection getconnection(){
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/test";
		String uname="root";
		String pwd="mani.1996";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con=DriverManager.getConnection(url, uname, pwd);
			System.out.println("Database connected");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println("Error:"+e.getMessage());
		}
		
		return con;
		
	}

	public static void main(String[] args) {

		getconnection();
		
		
		
		
	}

}
