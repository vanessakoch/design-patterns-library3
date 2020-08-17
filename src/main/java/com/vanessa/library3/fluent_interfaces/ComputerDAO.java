package com.vanessa.library3.fluent_interfaces;

import java.util.ArrayList;
import java.util.List;

import com.vanessa.library3.facade.Computer;

public class ComputerDAO {
	public static List<Computer> computers = new ArrayList<Computer>();

	public static void insertComputers() {
		computers.add(new Computer().idIs(1).brands("Samsung").processorIs("I5").ramCapacity("8gb").oS("Windows"));
		computers.add(new Computer().idIs(2).brands("Acer").processorIs("I7").ramCapacity("16gb").oS("Windows"));
		computers.add(new Computer().idIs(3).brands("Lenovo").processorIs("I3").ramCapacity("4gb").oS("Windows"));
		computers.add(new Computer().idIs(4).brands("Samsung").processorIs("I7").ramCapacity("16gb").oS("Windows"));
		computers.add(new Computer().idIs(5).brands("Samsung").processorIs("I5").ramCapacity("8gb").oS("Windows"));
		computers.add(new Computer().idIs(6).brands("Acer").processorIs("I7").ramCapacity("16gb").oS("Linux"));
		computers.add(new Computer().idIs(7).brands("Lenovo").processorIs("I3").ramCapacity("4gb").oS("Linux"));
		computers.add(new Computer().idIs(8).brands("Samsung").processorIs("I7").ramCapacity("16gb").oS("Linux"));	
	}

	public static Computer getComputer(int id) {
		for (Computer computer : computers) {
			if (id == computer.getId())
				return computer;
		}
		return null;
	}
	
	public static void printComputers() {
		for(Computer computer : computers) {
			System.out.println(computer);
		}
	}

	public static List<Computer> getComputersList() {
		return computers;
	}
	
	
	
}