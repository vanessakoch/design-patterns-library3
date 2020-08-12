package com.vanessa.library3.fluent_interfaces;

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

	public String getName() {
		return name;
	}

	public String getSpecialty() {
		return specialty;
	}

	@Override
	public String toString() {
		return "Editor [name=" + name + ", specialty=" + specialty + "]";
	}
}
