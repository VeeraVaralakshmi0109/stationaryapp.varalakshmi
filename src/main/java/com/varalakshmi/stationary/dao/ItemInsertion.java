package com.varalakshmi.stationary.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.varalakshmi.stationary.util.ConnectionUtil;

public class ItemInsertion {

	public static void itemInsertion(int id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement statement = null;
		Date date = Date.valueOf(LocalDate.now());
		String query = "insert into varalaksmi_statinary_transaction(User_id,product_id,Purchased_on)values(?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setInt(1, 1);
		statement.setInt(2, id);
		statement.setDate(3, date);
		int rows = statement.executeUpdate();
	}

}
