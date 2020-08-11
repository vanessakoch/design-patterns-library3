package com.vanessa.library3;

import java.util.Scanner;

import com.vanessa.library3.controller.BorrowCommand;
import com.vanessa.library3.controller.DevolutionCommand;
import com.vanessa.library3.controller.Invoker;
import com.vanessa.library3.controller.ReserveCommand;
import com.vanessa.library3.dao.BookDAO;
import com.vanessa.library3.dao.ComputerDAO;
import com.vanessa.library3.dao.StudentDAO;
import com.vanessa.library3.entities.Agenda;
import com.vanessa.library3.entities.Book;
import com.vanessa.library3.entities.DigitalMeet;
import com.vanessa.library3.entities.Library;
import com.vanessa.library3.entities.RoomMeet;
import com.vanessa.library3.entities.Student;

public class Main {
	static Scanner t = new Scanner(System.in);
	static String answers[];

	public static void main(String[] args) {

		Library library = new Library(5000.0);

		StudentDAO.insertStudents();
		BookDAO.insertBooks();
		ComputerDAO.insertComputers();
		
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
						if (action == 1) {
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
				Agenda agenda = new Agenda();

				int reserve = 1;

				while (reserve != 0) {
					System.out.println("\n[1] - Nova ocupação de computadores");
;					System.out.println("[2] - Nova ocupação de salas");
					System.out.println("[0] - Fechar agenda");
					reserve = t.nextInt();

					if (reserve == 1) {
						System.out.println("Digite o número de alunos: ");
						int n_students = t.nextInt();
						System.out.println("Digite o tempo de duração (minutos): ");
						int time = t.nextInt();
						System.out.println("Digite o número de computadores: ");
						int n_cpu = t.nextInt();
						if(n_cpu <= ComputerDAO.computers.size()) {
							DigitalMeet digital = new DigitalMeet(time, n_students, n_cpu);
							agenda.insertMeet(digital);
							System.out.println("Reservado.");
						} else {
							System.out.println("Computadores insuficientes.");
						}
						
					}

					if (reserve == 2) {
						System.out.println("Digite o número de alunos: ");
						int n_students = t.nextInt();
						System.out.println("Digite o tempo de duração (minutos): ");
						int time = t.nextInt();
						System.out.println("Digite o número de salas: ");
						int n_rooms = t.nextInt();
						System.out.println("Digite o número de professores: ");
						int n_teachers = t.nextInt();
						RoomMeet room = new RoomMeet(time, n_students, n_teachers, n_rooms);
						agenda.insertMeet(room);
						System.out.println("Reservado.");
					}
				}

				if (reserve == 0)
					System.out.println(agenda.getTotal());

				break;

			case 7:
				System.out.println("[1] - Comprar livro | [2] - Comprar computador | "
						+ "[3] - Manutenção de livro | [4] - Manutenção de computador");
				int shop = t.nextInt();

				switch (shop) {
				case 1:
					library.shopBook();
					break;
				case 2:
					library.shopComputer();
					break;
				case 3:
					library.maintenanceBook();
					break;
				case 4:
					library.maintenanceComputer();
					break;
				}
				System.out.println("Saldo atual: " + library.getYield());

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
		System.out.println("[6] - Agendar reunião");
		System.out.println("[7] - Gerenciar biblioteca\n");
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