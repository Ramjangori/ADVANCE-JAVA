package com.userRegestrationAndLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Regester {

	static boolean reg(String user, String email, String city, String pass) {

		return true;

	}
}

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

		if (status == 1) {

			System.out.println("Enter UserName");
			String userName = sc.next();
			System.out.println("Enter Email");
			String EmailId = sc.next();
			System.out.println("Enter City ");
			String City = sc.next();
			System.out.println("Enter Password");
			String pass = sc.next();
			String select = "select email from user";
			Statement smt = con.createStatement();

			ResultSet st = smt.executeQuery(select);
			int sucess = 1;
			while (st.next()) {
				if (st.getString("email").equals(EmailId)) {
					System.out.println("Email Already Exists... please login");
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

		}

	}

}
