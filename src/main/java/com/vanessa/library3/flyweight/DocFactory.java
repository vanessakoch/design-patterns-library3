package com.vanessa.library3.flyweight;

import java.util.HashMap;
import java.util.Map;

import com.vanessa.library3.fluent_interfaces.StudentDAO;

public class DocFactory {

	public enum Type {
		DOCUMENTARY, THESIS, FINALEXAM
	}

	private static final Map<String, Document> documents = new HashMap<String, Document>();

	public Document getDocument(Type type, String title) {

		if (!documents.containsKey(title)) {
			switch (type) {
			case DOCUMENTARY:
				documents.put("Dicas de Estudo", new Documentary("Dicas de Estudo", "Geral"));
				documents.put("Vestibular e Enem", new Documentary("Vestibular e Enem", "Enem"));
				documents.put("Redação Enem", new Documentary("Redação Enem", "Enem"));
				break;
			case FINALEXAM:
				documents.put("TCC de Calculo", new FinalExam("TCC de Cálculo", StudentDAO.getStudent("Maria")));
				documents.put("TCC de Programação", new FinalExam("TCC de Programação", StudentDAO.getStudent("Marcos")));
				documents.put("TCC de Ciencias", new FinalExam("TCC de Ciências", StudentDAO.getStudent("Jamile")));
				break;
			case THESIS:
				documents.put("Tese sobre racismo", new Thesis("Tese sobre racismo"));
				documents.put("Tese sobre coronavirus", new Thesis("Tese sobre coronavirus"));
				documents.put("Tese sobre automedicação", new Thesis("Tese sobre automedicação"));
				break;
			default:
				break;
			}
		}

		return documents.get(title);
	}
}