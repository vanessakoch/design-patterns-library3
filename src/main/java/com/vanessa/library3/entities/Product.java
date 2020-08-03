package com.vanessa.library3.entities;

import com.vanessa.library3.util.CartProperties;

public abstract class Product {
	private double price;

	public Product(double price) {
		super();
		this.price = price;
	}

	public void insertProperty(ShopCart cart) {
		cart.insertProperty(CartProperties.PRICE, price);
	}

	
}
