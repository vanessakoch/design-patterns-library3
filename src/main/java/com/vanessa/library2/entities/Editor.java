package com.vanessa.library2.entities;

public class Editor {
	private String name;
	private String specialty;
	
	public Editor named(String name) {
		this.name = name;
		return this;
	}
	
	public Editor specialtyOf(String specialty) {
		this.specialty = specialty;
		return this;
	}

	@Override
	public String toString() {
		return "Editor [name=" + name + ", specialty=" + specialty + "]";
	}
	
}
