package com.varalakshmi.home;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.varalakshmi.stationary.AdminLogin;
import com.varalakshmi.stationary.login.LoginDetails;
import com.varalakshmi.stationary.validator.UserValidatorTest;

public class StationaryHomeTest {
	private static Logger log = LogManager.getLogger(StationaryHomeTest.class);

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		log.info("1.signUp");
		log.info("2.signin");
		log.info("3.AdminLogin");
		log.info("Choose the preferences");

		int num = sc.nextInt();
		if (num == 1) {
			UserValidatorTest.userRegister();
		} else if (num == 2) {
			String email=sc.next();
			String password=sc.next();

			LoginDetails.login(email, password);
		}
		else if (num == 3) {
			String email = sc.next();
			String password = sc.next();
			String contact = sc.next();
			AdminLogin.login(email, password, contact);
		}



	}


}
