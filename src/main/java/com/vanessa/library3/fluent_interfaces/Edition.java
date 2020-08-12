package com.vanessa.library3.fluent_interfaces;

public class Edition {
	private int number;

	public Edition numbered(int number) {
		this.number = number;
		return this;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "" + number;
	}
}
