package com.varalakshmi.stationary;

import java.sql.Connection;
import java.sql.ResultSet;

import com.varalakshmi.stationary.util.ConnectionUtil;
import com.varalakshmi.stationary.validator.AdminAl;

public class AdminLogin {
	
	public static int login(String email, String password, String contact) throws Exception {

		Connection connection = null;

		connection = ConnectionUtil.getConnection();
		String query = "select email,password,contact from varalakshmi_stationaryapp_admin where Email='" + email + "'";

		java.sql.Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		String adminemail = null;
		String adminpassword = null;
		Long admincontact = null;
		while (result.next()) {
			adminemail = result.getString("Email");
			adminpassword = result.getString("PASSWORD");
			admincontact = result.getLong("contact");
			
		}

		int n = 0;
		try {
			if (adminpassword.equals(password)) {
				n = 1;
				System.out.println("Admin-Login Successfull");
				AdminAl.alter();
			} else {
				System.out.println("invalid credentials");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return n;


	}
}

	



