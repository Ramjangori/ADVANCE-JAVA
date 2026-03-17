package com.adjavajsbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecordFromDataBase {
	static String DBURL = "jdbc:mysql://localhost:3306/JDBCJAVAA3";
	static String USER = "root";
	static String PASS = "Ramjan123";
	static String  SelectQuery ="select * from Students";
	
	
	
	
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection(DBURL, USER,PASS );
	Statement smt = con.createStatement();
	ResultSet result = smt.executeQuery(SelectQuery );
	
	while(result.next()) {
		
		System.out.print("Id: " + result.getInt(1));
		System.out.print(" Name : " + result.getString(2));
		System.out.println(" City : " + result.getString(3));
		
	}
	
}
}
