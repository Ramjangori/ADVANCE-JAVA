package com.adjavajsbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {
	static String DBURL = "jdbc:mysql://localhost:3306/JDBCJAVAA3";
	static String USER = "root";
	static String PASS = "Ramjan123";
	static String  DeleteQuery ="delete from Students where city='City'";
	
	
	
	
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection(DBURL, USER,PASS );
	Statement smt = con.createStatement();
	int d = smt.executeUpdate(DeleteQuery);
	
if(d>0) {
	System.out.println("Delete Sucessfully");
}
	
}
}
