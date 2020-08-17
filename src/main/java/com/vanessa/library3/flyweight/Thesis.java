package com.vanessa.library3.flyweight;

public class Thesis implements Document {
	private String docTitle;
	
	public Thesis(String docTitle) {
		super();
		this.docTitle = docTitle;
	}

	public void getDocument() {
		System.out.println("Tese - Título: " + docTitle );
	}
	
}
