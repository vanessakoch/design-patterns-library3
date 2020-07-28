package com.vanessa.library2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vanessa.library2.controller.BorrowCommand;
import com.vanessa.library2.controller.DevolutionCommand;
import com.vanessa.library2.controller.Invoker;
import com.vanessa.library2.controller.ReserveCommand;
import com.vanessa.library2.dao.BookDAO;
import com.vanessa.library2.dao.StudentDAO;
import com.vanessa.library2.entities.Book;
import com.vanessa.library2.entities.Student;
import com.vanessa.library2.exceptions.LivroException;

public class Main {
	static Scanner t = new Scanner(System.in);
	static List<String> questionList;

	public static void main(String[] args) throws LivroException {

		StudentDAO.insertStudents();
		BookDAO.insertBooks();

		String register = "";
		Invoker invoker = new Invoker();

		while (true) {

			menu();
			int choice = t.nextInt();

			switch (choice) {

			case 1:
				StudentDAO.getStudents();
				break;

			case 2:
				if (getStudentnBook() != null) {
					register = invoker.execute(new BorrowCommand(register, StudentDAO.getStudent(questionList.get(0)),
							BookDAO.getBook(questionList.get(1))));

					if (getConfirmation() == 2) {
						register = invoker.undo();
					}
					System.out.println("Histórico:" + register);

				} else {
					System.out.println("Estudante ou livro inexistente");
				}

				break;

			case 3:
				if (getStudentnBook() != null) {
					Student student = StudentDAO.getStudent(questionList.get(0));
					Book book = BookDAO.getBook(questionList.get(1));
					boolean isRented = false;

					for (Book books : student.getBorrowedBooks()) {
						if (book.getName().equalsIgnoreCase(books.getName())) {
							isRented = true;
						}
					}

					if (isRented) {
						register = invoker.execute(new DevolutionCommand(register, student, book));

						if (getConfirmation() == 2) {
							register = invoker.undo();
						}
						System.out.println("Histórico:" + register);
					}
				} else {
					System.out.println("Estudante ou livro inexistente");
				}
				break;

			case 4:
				if (getStudentnBook() != null) {
					register = invoker.execute(new ReserveCommand(register, StudentDAO.getStudent(questionList.get(0)),
							BookDAO.getBook(questionList.get(1))));

					if (getConfirmation() == 2) {
						register = invoker.undo();
					}
					System.out.println("Histórico:" + register);
				} else {
					System.out.println("Estudante ou livro inexistente");
				}
				break;

			case 5:
				String studentName = getStudentName();
				boolean studentExists = false;

				for (Student student : StudentDAO.getStudentsList()) {
					if (studentName.equalsIgnoreCase(student.getName())) {
						student.printBorrowedBooks();
						studentExists = true;
					}
				}

				if (!studentExists) {
					System.out.println("Aluno não existe!");
				}
				break;

			case 6:
				String name = getStudentName();
				boolean exist = false;

				for (Student student : StudentDAO.getStudentsList()) {
					if (name.equalsIgnoreCase(student.getName())) {
						student.printReservedBooks();
						exist = true;
					}
				}

				if (!exist)
					System.out.println("Aluno não existe!");

				break;
			}

		}

	}

	public static void menu() {
		System.out.println("\n[1] - Listar cadastros");
		System.out.println("[2] - Emprestar livro");
		System.out.println("[3] - Devolver livro");
		System.out.println("[4] - Reservar livro");
		System.out.println("[5] - Pesquisar empréstimos");
		System.out.println("[6] - Pesquisar reservas\n");
	}

	public static List<String> getStudentnBook() {
		questionList = new ArrayList<String>();

		System.out.println("Digite o nome do aluno: ");
		questionList.add(t.next());

		System.out.println("Digite o nome do livro: ");
		questionList.add(t.next());

		if (StudentDAO.getStudent(questionList.get(0)) != null && BookDAO.getBook(questionList.get(1)) != null) {
			return questionList;
		}
		return null;
	}

	public static int getConfirmation() {
		System.out.println("1 - Confirmar | 2 - Desfazer");
		return t.nextInt();
	}

	public static String getStudentName() {
		System.out.println("Digite o nome do aluno: ");
		return t.next();
	}
}