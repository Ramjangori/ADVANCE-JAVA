package com.adjavajsbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchOperation {
	private static final String DBURL="jdbc:mysql://localhost:3306/JDBCJAVAA3";
	private static final String DBUSERNAME = "root";
	private static final String DBPASSWORD = "Ramjan123";
//	private static final String INSERTSQL = "insert into students values(2,'Nikhil','City')";
	private static final String INSERTSQL = "insert into students Values(?,?,?)";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection(DBURL, DBUSERNAME,DBPASSWORD);
		 
		 PreparedStatement pmt = con.prepareStatement(INSERTSQL);
		 Scanner sc= new Scanner(System.in);
		 System.out.println("Enter First Record ....");
		 System.out.println("Enter Student Id");
		  int id = sc.nextInt();
		  System.out.println("Enter Student Name ");
		  String name = sc.next();
		  System.out.println("Enter City ");
		  String city = sc.next();
		  
		  pmt.setInt(1, id);
		  pmt.setString(2,name);
		  pmt.setString(3,city);
		  pmt.addBatch();
		  
		  
		  // second record 
		  System.out.println("Enter Second Record ....");
			 System.out.println("Enter Student Id");
			  int id1 = sc.nextInt();
			  System.out.println("Enter Student Name ");
			  String name1 = sc.next();
			  System.out.println("Enter City ");
			  String city1 = sc.next();
			  
			  pmt.setInt(1, id1);
			  pmt.setString(2,name1);
			  pmt.setString(3,city1);
			  pmt.addBatch();
			  
			  // third record 
			  System.out.println("Enter third Record ....");
				 System.out.println("Enter Student Id");
				  int id2 = sc.nextInt();
				  System.out.println("Enter Student Name ");
				  String name2 = sc.next();
				  System.out.println("Enter City ");
				  String city2 = sc.next();
				  
				  pmt.setInt(1, id2);
				  pmt.setString(2,name2);
				  pmt.setString(3,city2);
				  pmt.addBatch();
				  
				  // fourth record 
				  System.out.println("Enter fourth Record ....");
					 System.out.println("Enter Student Id");
					  int id3 = sc.nextInt();
					  System.out.println("Enter Student Name ");
					  String name3 = sc.next();
					  System.out.println("Enter City ");
					  String city3 = sc.next();
					  
					  pmt.setInt(1, id3);
					  pmt.setString(2,name3);
					  pmt.setString(3,city3);
					  pmt.addBatch();
					  
					  int[] result = pmt.executeBatch();
					  
					  System.out.println(result.length + " row affexted");
					  pmt.close();
		  
	}
}
