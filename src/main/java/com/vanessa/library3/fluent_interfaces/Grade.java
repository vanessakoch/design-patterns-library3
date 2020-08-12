package com.vanessa.library3.fluent_interfaces;

public class Grade {
	private String stage;
	
	public Grade educationalStage(String stage) {
		this.stage = stage;
		return this;
	}

	@Override
	public String toString() {
		return "" + stage + "]";
	}
	
}
