package com.vanessa.library3.flyweight;

public class Documentary implements Document {
	private String docTitle;
	private String theme;
	
	public Documentary(String docTitle) {
		super();
		this.docTitle = docTitle;
	}

	public void getDocument() {
		System.out.println("Documentário - Título: " + docTitle + " - Tema: " + theme);
	}
	
	public void setTheme(String theme) {
		this.theme = theme;
	}

}


