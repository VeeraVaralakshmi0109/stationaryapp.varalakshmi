package com.varalakshmi.stationary.dao;

import com.varalakshmi.stationary.model.User;

public class UserDAOTest {
	public static void main(String[] args) throws Exception {

		User user = new User();
		user.setName("vara");
		user.setEmail("varu@gmail.com");
		user.setPassword("varuvaru");
		user.setContact("1234567890");
		System.out.println(user);

		UserDAO userDAO = new UserDAOImpl();
		userDAO.register(user);

	}

}
