package com.varalakshmi.stationary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.varalakshmi.stationary.util.ConnectionUtil;

public class ItemPriceFinder {

	public static int priceFinder(int id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet res = null;
		String query = "select price from varalakshmi_stationaryapp_Items where id=?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		res = statement.executeQuery();
		int price = 0;
		while (res.next()) {
			price = res.getInt("Price");
		}
		return price;

	}

}
