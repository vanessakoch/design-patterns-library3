package com.vanessa.library2.entities;

public class Student {

	private String name;
	private String birthDate;
	private Grade grade;
	
	public Student named(String name) {
		this.name = name;
		return this;
	}

	public Student bornIn(String birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public Student enrolledIn(Grade grade) {
		this.grade = grade;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public Grade getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", birthDate=" + birthDate + ", grade=" + grade + "]";
	}
	
}
