package com.vanessa.library2.entities;

public class Book {
	private String name;
	private int year;
	private Edition edition;
	private Editor editor;
	
	public Book named(String name) {
		this.name = name;
		return this;
	}
	
	public Book publicationYear(int year) {
		this.year = year;
		return this;
	}
	
	public Book editionNumber(Edition edition) {
		this.edition = edition;
		return this;
	}
	
	public Book editedBy(Editor editor) {
		this.editor = editor;
		return this;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public Edition getEdition() {
		return edition;
	}

	public Editor getEditor() {
		return editor;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", year=" + year + ", edition=" + edition + ", editor=" + editor + "]";
	}
	
	
}
