package com.varalakshmi.stationary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.varalakshmi.stationary.model.StationaryList;
import com.varalakshmi.stationary.util.ConnectionUtil;

public class StationaryItemsDAOImpl implements StationaryItemsDAO {

	public List<StationaryList> findAll() throws SQLException, ClassNotFoundException {

		List<StationaryList> stationaryList = new ArrayList<StationaryList>();
		Connection connection = null;
		PreparedStatement statement = null;

		ResultSet rs = null;
		connection = ConnectionUtil.getConnection();
		String sql = "select id,Items_Name,Items_brandname,Price from varalakshmi_stationaryapp_Items";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		while (rs.next()) {
			Integer id = rs.getInt("id");
			String Items = rs.getString("Items_Name");
			String Brand = rs.getString("Items_brandname");
			Float Price = rs.getFloat("Price");
			StationaryList slObj = new StationaryList();
			slObj.setId(id);
			slObj.setItems(Items);
			slObj.setBrand(Brand);
			slObj.setPrice(Price);
			stationaryList.add(slObj);
		}
		return stationaryList;


	}

	public StationaryList findById(int id) throws SQLException, ClassNotFoundException {
		StationaryList slObj = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		connection = ConnectionUtil.getConnection();
		String sql = "select * from varalakshmi_stationaryapp_Items where id=?";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		while (rs.next()) {
			Integer itemId = rs.getInt("id");
			slObj = new StationaryList();
			slObj.setId(itemId);

		}
		return slObj;

	}

	public StationaryList findByBrandName(String brandname) throws Exception {
		StationaryList slObj = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		connection = ConnectionUtil.getConnection();
		String sql = "select * from varalakshmi_stationaryapp_Items from Item_brandname=?";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		if (rs.next()) {

			String Brand = rs.getString("Item_brandname");

			slObj = new StationaryList();

			slObj.setBrand(Brand);

		}
		return slObj;


	}

}


