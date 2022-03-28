package com.varalakshmi.stationary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.varalakshmi.stationary.Stationary;
import com.varalakshmi.stationary.util.ConnectionUtil;


public class StationaryDao {
	public static List<Stationary> allProducts() throws ClassNotFoundException, SQLException {
		List<Stationary> list = new ArrayList<Stationary>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet res = null;
		String query = "select * from varalakshmi_stationaryapp_Items";
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

}


