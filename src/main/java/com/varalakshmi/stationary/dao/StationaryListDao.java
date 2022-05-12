package com.varalakshmi.stationary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.varalakshmi.stationary.Stationary;
import com.varalakshmi.stationary.util.ConnectionUtil;


public class StationaryListDao {
	public static List<Stationary> allProducts() throws ClassNotFoundException, SQLException {
		ArrayList<Stationary> list = new ArrayList<Stationary>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet res = null;
		String query = "select id,Items_Name,Items_brandname,Price from varalakshmi_stationaryapp_Items";
		statement = connection.prepareStatement(query);
		res = statement.executeQuery();
		Stationary stationary = null;
		int id = 0;
		String name = null;
		String brand = null;
		int price = 0;
		while (res.next()) {
			stationary = new Stationary();
			id = res.getInt("id");
			name = res.getString("Items_Name");
			brand = res.getString("Items_brandname");
			price = res.getInt("Price");
			stationary.setId(id);
			stationary.setName(name);
			stationary.setBrandName(brand);
			stationary.setPrice(price);
			list.add(stationary);
		}
		return list;


	}

	public static List<Stationary> minMax() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Min value");
		int minprice = sc.nextInt();

		System.out.println("Enter Max value");
		int maxprice = sc.nextInt();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet res = null;
		List<Stationary> list = new ArrayList<Stationary>();

		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select id,Items_Name,Items_brandname,Price from varalakshmi_stationaryapp_Items where price between ? and ?";

			statement = connection.prepareStatement(sql);
			statement.setInt(1, minprice);
			statement.setInt(2, maxprice);


			res = statement.executeQuery();
			while (res.next()) {
				Stationary stationary = new Stationary();
				int id = res.getInt("id");
				String name = res.getString("Items_Name");
				String brand = res.getString("Items_brandname");
				int price = res.getInt("Price");
				stationary.setId(id);
				stationary.setName(name);
				stationary.setBrandName(brand);
				stationary.setPrice(price);

				list.add(stationary);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage(), e);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}
}


