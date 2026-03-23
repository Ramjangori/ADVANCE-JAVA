package com.userRegestrationAndLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Main {
	private static final String DBURL = "jdbc:mysql://localhost:3306/JDBCJAVAA3";
	private static final String DBUSERNAME = "root";
	private static final String DBPASSWORD = "Ramjan123";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1. For Registeration..");
		System.out.println("Enter 2. For Login..");
		int status = sc.nextInt();
		sc.nextLine();

		if (status == 1) {

			System.out.println("Enter UserName");
			String userName = sc.nextLine();
			System.out.println("Enter Email");
			String EmailId = sc.nextLine();
			System.out.println("Enter City ");
			String City = sc.nextLine();
			System.out.println("Enter Password");
			String pass = sc.next();
			String select = "select email from user";
			Statement smt = con.createStatement();

			ResultSet st = smt.executeQuery(select);
			int sucess = 1; // for checking duplicate email
			while (st.next()) {
				if (st.getString("email").equals(EmailId)) {
					System.err.println("Email Already Exists... please login");
					System.out.println("Please Login");
					sucess = 0;
					break;
				}

			}

			if (sucess == 1) {
				String insert = "insert into user values(?,?,?,?)";
				PreparedStatement pmt = con.prepareStatement(insert);
				pmt.setString(1, userName);
				pmt.setString(2, EmailId);
				pmt.setString(3, City);
				pmt.setString(4, pass);

				int affceted = pmt.executeUpdate();
				if (affceted > 0) {
					System.out.println("Registration Sucessfully");
				} else {
					System.out.println("Some error occure Try AGAIN..");
				}
			}
			
		}

		if (status == 2) {

		
			System.out.println("Enter Email Id");
			String emailId = sc.next();
			System.out.println("Enter Password");
			String pass = sc.next();

			String LoginQuery = "Select email , password from user";

			Statement smt = con.createStatement();
			ResultSet result = smt.executeQuery(LoginQuery);
			while (result.next()) {

				String dbemail = result.getString("email");
				String dbpass = result.getString("password");
				if (dbemail.equals(emailId) && dbpass.equals(pass)) {
					System.out.println("Login sucessfully..");
				} else {
					System.err.println("Please Enter Correct Email and Password..");
					break;
				}
			}

			con.close();
		}

	}

}
