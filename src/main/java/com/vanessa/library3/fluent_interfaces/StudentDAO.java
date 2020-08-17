package com.vanessa.library3.fluent_interfaces;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	public static List<Student> students = new ArrayList<Student>();

	public static void insertStudents() {
		Grade first = new Grade().educationalStage("First grade");
		Grade second = new Grade().educationalStage("Second grade");
		Grade third = new Grade().educationalStage("Third grade");
		Grade fourth = new Grade().educationalStage("Fourth grade");
		Grade fifth = new Grade().educationalStage("Fifth grade");
		Grade sixth = new Grade().educationalStage("Sixth grade");
		Grade seventh = new Grade().educationalStage("Seventh grade");
		Grade eighth = new Grade().educationalStage("Eighth grade");
		Grade ninth = new Grade().educationalStage("Ninth grade");

		students.add(new Student().named("Maria").bornIn("20/07/2013").enrolledIn(first));
		students.add(new Student().named("Gustavo").bornIn("25/12/2011").enrolledIn(third));
		students.add(new Student().named("Felipe").bornIn("04/02/2006").enrolledIn(eighth));
		students.add(new Student().named("Pedro").bornIn("15/10/2007").enrolledIn(seventh));
		students.add(new Student().named("Marcia").bornIn("05/05/2009").enrolledIn(fifth));
		students.add(new Student().named("João").bornIn("01/01/2005").enrolledIn(ninth));
		students.add(new Student().named("José").bornIn("09/05/2008").enrolledIn(sixth));
		students.add(new Student().named("Marcos").bornIn("31/06/2005").enrolledIn(ninth));
		students.add(new Student().named("Fernando").bornIn("05/03/2010").enrolledIn(fourth));
		students.add(new Student().named("Jamile").bornIn("11/11/2007").enrolledIn(seventh));
		students.add(new Student().named("Paula").bornIn("10/10/2012").enrolledIn(second));

	}

	public static Student getStudent(String name) {
		for (Student student : students) {
			if (name.equalsIgnoreCase(student.getName()))
				return student;
		}
		return null;
	}
	
	public static void printStudents() {
		for(Student student : students) {
			System.out.println(student);
		}
	}

	public static List<Student> getStudentsList() {
		return students;
	}
	
	
	
}
