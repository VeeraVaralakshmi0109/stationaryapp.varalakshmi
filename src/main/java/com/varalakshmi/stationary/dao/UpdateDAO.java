package com.varalakshmi.stationary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.varalakshmi.stationary.util.ConnectionUtil;

public class UpdateDAO {
	


	public void brandUpdate() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new brand name");
		String newbrandname = sc.next();

		System.out.println("Enter old brand name");
		String oldbrandname = sc.next();

	Connection connection = null;
	PreparedStatement statement = null;

	try
	{
		connection = ConnectionUtil.getConnection();

		String sql = "UPDATE varalakshmi_stationaryapp_Items set Items_brandname=? where Items_brandname=?";

		statement = connection.prepareStatement(sql);
		statement.setString(1, newbrandname);
		statement.setString(2, oldbrandname);

		int rows = statement.executeUpdate();
		

	}catch(
	SQLException e)
	{
		e.printStackTrace();
		throw new Exception(e.getMessage(), e);

	}catch(
	ClassNotFoundException e)
	{
		e.printStackTrace();
	}finally
	{
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

public void priceUpdate() throws Exception {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Increased price");
	int increasedprice = sc.nextInt();

	System.out.println("Enter the id to update price");
	int id = sc.nextInt();

	Connection connection = null;
	PreparedStatement statement = null;

	try {
		ConnectionUtil.getConnection();

		String sql = "UPDATE varalakshmi_stationaryapp_Items set Price=? where id=?";

		statement = connection.prepareStatement(sql);
		statement.setInt(1, increasedprice);
		statement.setInt(2, id);
		int rows = statement.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage(), e);

	}
}
}



