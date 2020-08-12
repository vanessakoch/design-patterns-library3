package com.vanessa.library3.facade;

public class Library {
	private double yield;
	private Management computer;
	private Management book;

	public Library(Double yield) {
		this.yield = yield;
		
		computer = new Computer();
		book = new Book();
	}

	public void shopComputer() {
		if(getYield() >= 2000.0) {
			setYield(getYield() - 2000.0);
			computer.shop();
		} else {
			System.out.println("Dinheiro insuficiente!");
		}
	}

	public void shopBook() {
		if(getYield() >= 150.0) {
			setYield(getYield() - 150.0);
			book.shop();
		} else {
			System.out.println("Dinheiro insuficiente!");
		}
	}

	public void maintenanceComputer() {
		if(getYield() >= 200.0) {
			setYield(getYield() - 200.0);
			computer.maintenance();
		} else {
			System.out.println("Dinheiro insuficiente!");
		}
	}

	public void maintenanceBook() {
		if(getYield() >= 80.0) {
			setYield(getYield() - 80.0);
			book.maintenance();
		} else {
			System.out.println("Dinheiro insuficiente!");
		}
	}

	public double getYield() {
		return yield;
	}

	public void setYield(double yield) {
		this.yield = yield;
	}
	
}
