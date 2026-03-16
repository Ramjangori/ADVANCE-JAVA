package com.adjavajsbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJdbc {
	private static final String DBURL="jdbc:mysql://localhost:3306/JDBCJAVAA3";
	private static final String DBUSERNAME = "root";
	private static final String DBPASSWORD = "Ramjan123";
	private static final String INSERTSQL = "insert into students values(2,'Nikhil','City')";
	
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// load the driver 
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	 // get the connection 
	 Connection con = DriverManager.getConnection(DBURL,DBUSERNAME ,DBPASSWORD );
	 
	 // create the statement 
	 Statement smt = con.createStatement();
	 // Execute the statement  
	 
	 int affected = smt.executeUpdate(INSERTSQL);
	 System.out.println("Insert Sucessfully  ");
	 System.out.println(affected + "row affected");
	  
}
 
}
