package com.varalakshmi.stationary.logic;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.varalakshmi.stationary.Stationary;
import com.varalakshmi.stationary.dao.ItemInsertion;
import com.varalakshmi.stationary.dao.ItemPriceFinder;
import com.varalakshmi.stationary.dao.StationaryListDao;


public class BuyItems {

	private static Logger log = LogManager.getLogger(BuyItems.class);
	static List<Integer> chocId;

	static Scanner sc=new Scanner(System.in);
	public static void findItems() throws ClassNotFoundException, SQLException
	{
		List<Stationary> list = StationaryListDao.allProducts();
	for(Stationary stationary:list)
	{
	System.out.println(stationary.getId()+"  "+stationary.getName()+"  "+stationary.getBrandName()+"  "+stationary.getPrice());

	}
	chocId=new ArrayList<Integer>();
	buyItems();

	}
	public static void buyItems() throws ClassNotFoundException, SQLException
	{
	System.out.println("Select the product you want");
	int id=sc.nextInt();
	int total=0;
	chocId.add(id);
	for(Integer i:chocId)
	{
	int price=ItemPriceFinder.priceFinder(i);
	total=total+price;
	}
	log.info("Your total price is " + total);
	log.info("1) Buy more items");
	log.info("2) continue to payment");
	int option=sc.nextInt();
	if(option==1)
	{
	buyItems();
	}
	else if(option==2)
	{
	int verified=payment(total);
	if(verified==1)
	{
	for(Integer k:chocId)
	{
	   ItemInsertion.itemInsertion(k);
	}
	System.out.println("order placed successfully");
	}

	}


	}
	public static int payment(int total)
	{
		log.info("Enter your upi id");
	String upi=sc.next();
		log.info("Your total price is : " + total);
		log.info("Enter amount to pay");
	int price=sc.nextInt();
	if(price ==total)
	{
	return 1;
	}
	else if(price!=total)
	{
	System.out.println("Please pay : "+total);
	payment(total);
	}
	return 1;
	}

	}




