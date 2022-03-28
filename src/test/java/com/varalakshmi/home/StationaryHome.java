package com.varalakshmi.home;

import java.util.Scanner;

import com.varalakshmi.stationary.login.LoginDetails;
import com.varalakshmi.stationary.validator.UserValidatorTest;

public class StationaryHome {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("1.signUp");
		System.out.println("2.signin");
		System.out.println("Enter the value for signUp or signIn");
		int num = sc.nextInt();
		if (num == 1) {
			UserValidatorTest.userRegister();
		} else if (num == 2) {

			LoginDetails.login();
		}


	}


}
