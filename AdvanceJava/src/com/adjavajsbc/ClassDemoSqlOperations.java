package com.adjavajsbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ClassDemoSqlOperations { 

	private static final String DBURL="jdbc:mysql://localhost:3306/JDBCJAVAA3";
	private static final String DBUSERNAME = "root";
	private static final String DBPASSWORD = "Ramjan123";
//	private static final String INSERTSQL = "insert into students values(2,'Nikhil','City')";
	private static final String INSERTSQL = "insert into students Values(?,?,?)";
	
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// load the driver 
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	 // get the connection 
	 Connection con = DriverManager.getConnection(DBURL,DBUSERNAME ,DBPASSWORD );
	 
	 // create the statement 
	 PreparedStatement smt = con.prepareStatement(INSERTSQL);
	 // Taking Input From user
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter Student Id");
	  int id = sc.nextInt();
	  System.out.println("Enter Student Name ");
	  String name = sc.next();
	  System.out.println("Enter City ");
	  String city = sc.next();
	  
	  smt.setInt(1, id);
	  smt.setString(2,name);
	  smt.setString(3,city);
	  
	  int rowaffected = smt.executeUpdate();
	  System.out.println("Data insert Succesfully ");
	  System.out.println(rowaffected + "Row affected");
	 
	
}}