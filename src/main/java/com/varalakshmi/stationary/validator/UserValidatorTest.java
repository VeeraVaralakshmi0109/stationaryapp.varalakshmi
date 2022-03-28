package com.varalakshmi.stationary.validator;

import java.util.Scanner;

import com.varalakshmi.stationary.dao.UserDAO;
import com.varalakshmi.stationary.dao.UserDAOImpl;
import com.varalakshmi.stationary.model.User;

public class UserValidatorTest {


	public static void userRegister() throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("name");
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



		UserValidator.validatorUserDetails(user);
		UserDAO userdao = new UserDAOImpl();
		userdao.register(user);

	}
}
