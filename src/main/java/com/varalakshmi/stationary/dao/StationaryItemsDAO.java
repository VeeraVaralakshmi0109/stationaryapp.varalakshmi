package com.varalakshmi.stationary.dao;

import java.sql.SQLException;
import java.util.List;

import com.varalakshmi.stationary.model.StationaryList;

interface StationaryItemsDAO {

	List<StationaryList> findAll() throws SQLException, ClassNotFoundException;

	StationaryList findById(int id) throws SQLException, ClassNotFoundException;

	StationaryList findByBrandName(String brandname) throws Exception;

}
