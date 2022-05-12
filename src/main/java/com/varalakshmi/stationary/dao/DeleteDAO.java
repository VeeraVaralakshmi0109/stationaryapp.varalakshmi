package com.varalakshmi.stationary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.varalakshmi.stationary.util.ConnectionUtil;

public class DeleteDAO {
	public void delete() throws Exception {

		Connection connection = null;
		PreparedStatement statement = null;

		System.out.println("Enter the id to be deleted");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();

		try {

			connection = ConnectionUtil.getConnection();



			String sql = "DELETE from varalakshmi_stationaryapp_Items WHERE id=?";

			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			int rows = statement.executeUpdate();

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
