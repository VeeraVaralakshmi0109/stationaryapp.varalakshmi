package com.varalakshmi.stationary;

public class Stationary {

		private int id;
		private String name;
		private String brandName;
		private int price;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBrandName() {
			return brandName;
		}

		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "id=" + id + ", name=" + name + ", brandName=" + brandName + ", price=" + price;
		}

	}


