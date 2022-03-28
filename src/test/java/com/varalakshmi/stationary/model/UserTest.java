package com.varalakshmi.stationary.model;

import java.util.Scanner;

public class UserTest {
	public static void main(String[] args) {

		System.out.println("name");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("email");
		String email = sc.next();
		System.out.println("password");
		String password = sc.next();
		System.out.println("contact");
		String contact = sc.next();

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setContact(contact);
		System.out.println(user);
		// log.debug(user)

	}

}
