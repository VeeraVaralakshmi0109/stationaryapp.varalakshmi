package com.varalakshmi.dao;

import java.util.List;

import com.varalakshmi.stationary.Stationary;
import com.varalakshmi.stationary.dao.StationaryListDao;

public class Listtest {

	public static void main(String args[]) throws Exception {
		List<Stationary> ls = StationaryListDao.minMax();
		for (Stationary lists : ls) {
			System.out.println(lists);
		}
	}
}
