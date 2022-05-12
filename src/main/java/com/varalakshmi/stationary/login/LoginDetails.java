package com.varalakshmi.stationary.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import com.varalakshmi.stationary.Stationary;
import com.varalakshmi.stationary.dao.ItemPriceFinder;
import com.varalakshmi.stationary.dao.StationaryListDao;
import com.varalakshmi.stationary.util.ConnectionUtil;

public class LoginDetails {

	public static int login(String email, String password) throws Exception {
		Scanner sc = new Scanner(System.in);

		Connection connection = ConnectionUtil.getConnection();
		String query = "select Email,PASSWORD from varalakshmi_stationaryapp_users where Email='" + email + "'";

		java.sql.Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		String useremail = null;
		String userpassword = null;
		while (result.next()) {
			useremail = result.getString("Email");
			userpassword = result.getString("PASSWORD");
		}
		int n = 0;
		try {
			if (userpassword.equals(password)) {
				System.out.println("Login Successfull");
				
				System.out.println("Enter FullList to display List");
				System.out.println("Enter id to display particular stationary");
				System.out.println("Enter brandname to display all the list in the same brand");
				System.out.println("Enter pricerange to display List between that range");
				// Scanner sc = new Scanner(System.in);
				String input = sc.next();
				if (input.equalsIgnoreCase("FullList")) {
					List<Stationary> list = StationaryListDao.allProducts();
					for (Stationary lists : list) {
						System.out.println(lists);
					}
	
				}
				else if(input.equalsIgnoreCase("id")) {
					System.out.println("Enter the id");
					// Scanner sc = new Scanner(System.in);
					int id = sc.nextInt();
					ItemPriceFinder.priceFinder(id);
				}
				else if(input.equalsIgnoreCase("brandname")) {
					
				}
				else if(input.equalsIgnoreCase("pricerange")) {
					List<Stationary> ls = StationaryListDao.minMax();
					for (Stationary lists : ls) {
						System.out.println(lists);
					
				}
				
				//BuyItems.findItems();
			}
		}
			else {
				System.out.println("invalid credentials");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return n;
		
	}
}
	