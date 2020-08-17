package com.vanessa.library3;

import java.util.Scanner;

import com.vanessa.library3.command_pattern.BorrowCommand;
import com.vanessa.library3.command_pattern.DevolutionCommand;
import com.vanessa.library3.command_pattern.Invoker;
import com.vanessa.library3.command_pattern.ReserveCommand;
import com.vanessa.library3.double_dispatch.Agenda;
import com.vanessa.library3.double_dispatch.DigitalMeet;
import com.vanessa.library3.double_dispatch.RoomMeet;
import com.vanessa.library3.facade.Book;
import com.vanessa.library3.facade.Library;
import com.vanessa.library3.fluent_interfaces.BookDAO;
import com.vanessa.library3.fluent_interfaces.ComputerDAO;
import com.vanessa.library3.fluent_interfaces.Student;
import com.vanessa.library3.fluent_interfaces.StudentDAO;
import com.vanessa.library3.flyweight.DocFactory;
import com.vanessa.library3.flyweight.DocFactory.Type;
import com.vanessa.library3.flyweight.Document;

public class Main {
	static Scanner t = new Scanner(System.in);
	static Scanner space = new Scanner(System.in);

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
				StudentDAO.printStudents();
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
				System.out.println("Digite o nome do aluno: ");
				String studentName = space.nextLine();
				boolean studentExists = false;

				for (Student student : StudentDAO.getStudentsList()) {
					if (studentName.equalsIgnoreCase(student.getName())) {
						studentExists = true;
						System.out.println("Registros do(a) aluno(a) " + student.getName() + "\n");
						student.printBorrowedBooks();
						student.printReservedBooks();
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
					System.out.println("[2] - Nova ocupação de salas");
					System.out.println("[0] - Fechar agenda");
					reserve = t.nextInt();

					if (reserve == 1) {
						System.out.println("Digite o número de alunos: ");
						int n_students = t.nextInt();
						System.out.println("Digite o tempo de duração (minutos): ");
						int time = t.nextInt();
						System.out.println("Digite o número de computadores: ");
						int n_cpu = t.nextInt();

						if (n_cpu <= ComputerDAO.computers.size()) {
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

			case 8:
				DocFactory factory = new DocFactory();

				System.out.println("[1] - Trabalho de conclusão de curso");
				System.out.println("[2] - Tese/Dissertações");
				System.out.println("[3] - Documentário");
				int select = t.nextInt();
				System.out.println("Digite o título do documento: ");
				String titulo = space.nextLine();

				switch (select) {

				case 1:
					Document finalExam = factory.getDocument(Type.FINALEXAM, titulo);
					if (finalExam != null)
						finalExam.getDocument();
					break;
				case 2:
					Document thesis = factory.getDocument(Type.THESIS, titulo);
					if (thesis != null)
						thesis.getDocument();
					break;
				case 3:
					Document documentary = factory.getDocument(Type.DOCUMENTARY, titulo);
					if (documentary != null)
						documentary.getDocument();
					break;

				default:
					break;
				}

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
		System.out.println("[6] - Agendar espaço para estudo");
		System.out.println("[7] - Gerenciar biblioteca");
		System.out.println("[8] - Buscar documentos\n");
	}

	public static String[] getStudentnBook() {
		answers = new String[2];

		System.out.println("Digite o nome do aluno: ");
		answers[0] = space.nextLine();
		System.out.println("Digite o nome do livro: ");
		answers[1] = space.nextLine();

		if (StudentDAO.getStudent(answers[0]) != null && BookDAO.getBook(answers[1]) != null) {
			return answers;
		}
		return null;
	}

	public static int getConfirmation() {
		System.out.println("[1] - Confirmar | [2] - Desfazer");
		return t.nextInt();
	}

}