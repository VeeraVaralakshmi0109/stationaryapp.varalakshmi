package com.varalakshmi.stationary.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.varalakshmi.stationary.logic.BuyItems;

public class LoginDetails {

	public static void login() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Email");
		String email = scan.next();
		System.out.println("Password");
		String password = scan.next();

		Connection connection = DriverManager.getConnection("jdbc:mysql://101.53.133.59:3306/revature_training_db",
				"rev_user", "rev_user");
		String query = "select Email,PASSWORD from varalakshmi_stationaryapp_users where Email='" + email + "'";
		java.sql.Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		String useremail = null;
		String userpassword = null;
		while (result.next()) {
			useremail = result.getString("Email");
			userpassword = result.getString("PASSWORD");
		}
		if (useremail == null) {
			System.out.println("No records found - please register");
		} else if (userpassword.equals(password)) {
			System.out.println("HAI WELCOME");

			System.out.println("Have a nice Day");

			System.out.println("Listing Stationary Items");
			BuyItems.findItems();
		} else {
			System.out.println("Invalid email or password");
		}

	}

}
