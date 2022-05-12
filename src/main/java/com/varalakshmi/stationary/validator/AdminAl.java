package com.varalakshmi.stationary.validator;

import java.util.Scanner;

import com.varalakshmi.stationary.dao.DeleteDAO;
import com.varalakshmi.stationary.dao.UpdateDAO;

public class AdminAl {
	public static void alter() throws Exception {

		String update = null;
		String delete = null;
		UpdateDAO updateDAO = new UpdateDAO();

		System.out.println("Enter update to update Items Name");
		System.out.println("Enter priceupdate to update price");
		System.out.println("Enter delete to delete Items");

		Scanner sc = new Scanner(System.in);

		String input = sc.next();

		if (input.equalsIgnoreCase("update")) {
			System.out.println("update item page");
		
			
			updateDAO.brandUpdate();
			System.out.println("successfully updated brandname");

		}
		else if(input.equalsIgnoreCase("priceupdate")) {
			
			System.out.println("price update page");
			updateDAO.priceUpdate();
			System.out.println("Successfully updated price");
			
			
		}
			
		else if (input.equalsIgnoreCase("delete")) {

			System.out.println("delete item page");
			DeleteDAO deletedao = new DeleteDAO();
			deletedao.delete();
			System.out.println("Successfully deleted");

		}

	}
}


