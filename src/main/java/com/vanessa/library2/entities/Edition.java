package com.vanessa.library2.entities;

public class Edition {
	private int number;
	
	public Edition numbered(int number) {
		this.number = number;
		return this;
	}
	
	@Override
	public String toString() {
		return "" + number + "]";
	}
}
