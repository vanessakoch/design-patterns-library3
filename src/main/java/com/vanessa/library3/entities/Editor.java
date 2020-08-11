package com.vanessa.library3.entities;

public class Editor {
	private String name;
	private String specialty;
	
	public Editor named(String name) {
		this.name = name;
		return this;
	}
	
	public Editor specialty(String specialty) {
		this.specialty = specialty;
		return this;
	}

	@Override
	public String toString() {
		return "Editor [name=" + name + ", specialty=" + specialty + "]";
	}

	public String getName() {
		return name;
	}

	public String getSpecialty() {
		return specialty;
	}
	
}
