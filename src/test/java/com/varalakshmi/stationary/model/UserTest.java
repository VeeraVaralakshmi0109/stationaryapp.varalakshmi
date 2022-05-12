package com.varalakshmi.stationary.model;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserTest {
	private static Logger log = LogManager.getLogger(UserTest.class);

	public static void main(String[] args) {


		log.info("name");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		log.info("email");
		String email = sc.next();
		log.info("password");
		String password = sc.next();
		log.info("contact");
		String contact = sc.next();

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setContact(contact);
		// System.out.println(user);
		log.info(user);

	}

}
