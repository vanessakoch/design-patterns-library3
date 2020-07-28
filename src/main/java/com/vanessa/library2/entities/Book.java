package com.vanessa.library2.entities;

public class Book {
	private String name;
	private int year;
	private Edition edition;
	private Editor editor;
	private int total;
	
	public Book named(String name) {
		this.name = name;
		return this;
	}
	
	public Book published(int year) {
		this.year = year;
		return this;
	}
	
	public Book editionNumber(Edition edition) {
		this.edition = edition;
		return this;
	}
	
	public Book edited(Editor editor) {
		this.editor = editor;
		return this;
	}
	
	public Book copies(int total) {
		this.total = total;
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
	
	public int getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", year=" + year + ", edition=" + edition + ", editor=" + editor + ", copies=" + total + "]";
	}
	
	
}
