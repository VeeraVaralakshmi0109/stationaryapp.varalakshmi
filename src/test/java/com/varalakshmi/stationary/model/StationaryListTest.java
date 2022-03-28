package com.varalakshmi.stationary.model;

import java.sql.SQLException;
import java.util.List;

import com.varalakshmi.stationary.dao.StationaryItemsDAOImpl;


public class StationaryListTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StationaryList sl = new StationaryList();
		// sl.setId(1);
		// sl.setItems("pen");
		// sl.setBrand("apsara");
		// sl.setPrice(13);
		// System.out.println(sl);
		StationaryItemsDAOImpl stationaryItemDAO = new StationaryItemsDAOImpl();


		List<StationaryList> stationaryItem = stationaryItemDAO.findAll();
		for (StationaryList stationaryItems : stationaryItem) {
			System.out.println(stationaryItems);
		}

	}

}
