package com.vanessa.library3;

import java.util.Scanner;

import com.vanessa.library3.controller.BorrowCommand;
import com.vanessa.library3.controller.DevolutionCommand;
import com.vanessa.library3.controller.Invoker;
import com.vanessa.library3.controller.ReserveCommand;
import com.vanessa.library3.dao.BookDAO;
import com.vanessa.library3.dao.StudentDAO;
import com.vanessa.library3.entities.Agenda;
import com.vanessa.library3.entities.Book;
import com.vanessa.library3.entities.DigitalMeet;
import com.vanessa.library3.entities.Meeting;
import com.vanessa.library3.entities.RoomMeet;
import com.vanessa.library3.entities.Student;

public class Main {
	static Scanner t = new Scanner(System.in);
	static String answers[];

	public static void main(String[] args) {

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
					register = invoker.execute(new BorrowCommand(register, StudentDAO.getStudent(answers[0]),
							BookDAO.getBook(answers[1])));

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
					Student student = StudentDAO.getStudent(answers[0]);
					Book book = BookDAO.getBook(answers[1]);
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
					register = invoker.execute(new ReserveCommand(register, StudentDAO.getStudent(answers[0]),
							BookDAO.getBook(answers[1])));

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

				System.out.println("[1] - Empréstimos | [2] - Reservas");
				int action = t.nextInt();
				
				for (Student student : StudentDAO.getStudentsList()) {
					if (studentName.equalsIgnoreCase(student.getName())) {
						studentExists = true;
						System.out.println(student.getName() + ": \n");
						if(action == 1) {
							student.printBorrowedBooks();
						} else {
							student.printReservedBooks();
						}
					}
				}

				if (!studentExists) {
					System.out.println("Aluno não existe!");
				}
				break;

			case 6:
				Meeting dig = new DigitalMeet(50, 5, 5);
				Meeting room = new RoomMeet(100, 5, 1, 1);
				
				Agenda agenda = new Agenda();
				agenda.insertMeet(dig);
				agenda.insertMeet(room);
				
				System.out.println(agenda.getTotal());
				
				break;
			}

		}

	}

	public static void menu() {
		System.out.println("\n[1] - Listar cadastros");
		System.out.println("[2] - Emprestar livro");
		System.out.println("[3] - Devolver livro");
		System.out.println("[4] - Reservar livro");
		System.out.println("[5] - Pesquisar ações do aluno");
		System.out.println("[6] - Agendar reunião\n");
	}

	public static String[] getStudentnBook() {
		answers = new String[2];

		System.out.println("Digite o nome do aluno: ");
		answers[0] = t.next();
		System.out.println("Digite o nome do livro: ");
		answers[1] = t.next();

		if (StudentDAO.getStudent(answers[0]) != null && BookDAO.getBook(answers[1]) != null) {
			return answers;
		}
		return null;
	}

	public static int getConfirmation() {
		System.out.println("[1] - Confirmar | [2] - Desfazer");
		return t.nextInt();
	}

	public static String getStudentName() {
		System.out.println("Digite o nome do aluno: ");
		return t.next();
	}
}