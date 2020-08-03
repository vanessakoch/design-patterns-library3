package com.vanessa.library3.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vanessa.library3.util.CartProperties;

public class ShopCart {
	private List<Product> products;
	private Map<CartProperties, Double> properties;

	public void insertProduct(Product product) {
		getProducts().add(product);
		product.insertProperty(this);
	}

	public void insertProperty(CartProperties type, double cost) {
		getProperties().put(type, getProperties().get(type) + cost);
	}

	public double getTotal() {
		if (products.isEmpty())
			return 0.0;
		
		double total = 0;
		total += getProperties().get(CartProperties.PRICE);
		total += getProperties().get(CartProperties.SHIPPING_COST);

		return total;
	}

	private List<Product> getProducts() {
		if (products == null)
			products = new ArrayList<Product>();
		return products;
	}

	private Map<CartProperties, Double> getProperties() {
		if (properties == null) {
			properties = new HashMap<CartProperties, Double>();
			for (CartProperties type : CartProperties.values())
				properties.put(type, 0.0);
		}
		return properties;
	}

}
