package com.varalakshmi.stationary.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.varalakshmi.stationary.model.User;

public class UserDAOImpl implements UserDAO {
	

	public void register(User user) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://101.53.133.59:3306/revature_training_db";
			String username = "rev_user";
			String password = "rev_user";
			connection = DriverManager.getConnection(url, username, password);

			String sql = "INSERT INTO varalakshmi_stationaryapp_users(NAME,email,PASSWORD,contact) VALUES(?,?,?,?)";

			statement = connection.prepareStatement(sql);

			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getContact());

			int rows = statement.executeUpdate();
		  System.out.println("No of rows inserted:" + rows);
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




