package com.varalakshmi.stationary.validator;


import com.varalakshmi.stationary.model.User;

public class UserValidator {



	public static void validatorUserDetails(User user) throws Exception {

		if (user.getName() == null) {
			throw new Exception("Invalid Name");
		} else if (user.getEmail() == null) {
			throw new Exception("Invalid Email");
		} else if (user.getPassword() == null) {
			throw new Exception("Invalid Password");
		} else if (user.getPassword().length() < 8) {
			throw new Exception("Password must have minimum 8 characters");
		}

		else if (user.getContact() == null) {
			throw new Exception("Invalid Contact");
		}
		System.out.println("Validation passed");

	}

}
