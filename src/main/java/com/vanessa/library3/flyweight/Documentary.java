package com.vanessa.library3.flyweight;

public class Documentary implements Document {
	private String docTitle;
	private String theme;
	
	public Documentary(String docTitle, String theme) {
		super();
		this.docTitle = docTitle;
		this.theme = theme;
	}

	public void getDocument() {
		System.out.println("Documentário - Título: " + docTitle + " - Tema: " + theme);
	}
	
}


