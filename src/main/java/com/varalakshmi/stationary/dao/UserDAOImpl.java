package com.varalakshmi.stationary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.varalakshmi.stationary.model.User;
import com.varalakshmi.stationary.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	

	@Override
	public void register(User user) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = ConnectionUtil.getConnection();

//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://training-db.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com:3306/varalakshmi_db";
//			String username = "varalakshmi";
//			String password = "varalakshmi";
//			connection = DriverManager.getConnection(url, username, password);

			String sql = "INSERT INTO varalakshmi_stationaryapp_users(NAME,email,PASSWORD,contact) VALUES(?,?,?,?)";

			statement = connection.prepareStatement(sql);

			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getContact());

			int rows = statement.executeUpdate();
			// System.out.println("No of rows inserted:" + rows);

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
	}

}




