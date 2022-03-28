package com.varalakshmi.stationary.model;

public class StationaryList {
	private int id;
	private String items;
	private String brand;
	private float price;

	public int getId() {
		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	// @Override

	@Override
	public String toString() {
		return "StationaryList [id=" + id + ", items=" + items + ", brand=" + brand + ", price=" + price + "]";
	}

}

