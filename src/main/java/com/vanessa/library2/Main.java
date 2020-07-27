package com.vanessa.library2;

import java.util.Scanner;

import com.vanessa.library2.dao.BookDAO;
import com.vanessa.library2.dao.StudentDAO;
import com.vanessa.library2.exceptions.LivroException;

public class Main {
	static Scanner t = new Scanner(System.in);

	public static void main(String[] args) throws LivroException {

		StudentDAO.insertStudents();
		BookDAO.insertBooks();
		BookDAO.getBooks();
		
		while (true) {
			
			menu();
			int choice = t.nextInt();

		}

	}

	public static void menu() {
		System.out.println("\n[1] - Listar cadastros");
		System.out.println("[2] - Emprestar livro");
		System.out.println("[3] - Devolver livro");
		System.out.println("[4] - Pesquisar empréstimos por nome");
		System.out.println("[5] - Gerenciar livros");
		System.out.println("[6] - Gerenciar biblioteca\n");
	}

}
