package com.varalakshmi.stationary;

import java.sql.SQLException;

import com.varalakshmi.stationary.logic.BuyItems;

public class StationaryTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		BuyItems.findItems();
	}

}
