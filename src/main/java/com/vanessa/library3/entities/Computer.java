package com.vanessa.library3.entities;

import java.util.Scanner;

import com.vanessa.library3.dao.ComputerDAO;

public class Computer implements Management {
	Scanner t = new Scanner(System.in);

	private int id;
	private String brandName;
	private String processor;
	private String ram;
	private String operationalSystem;

	public Computer idIs(int id) {
		this.id = id;
		return this;
	}

	public Computer brands(String brandName) {
		this.brandName = brandName;
		return this;
	}

	public Computer processorIs(String processor) {
		this.processor = processor;
		return this;
	}

	public Computer ramCapacity(String ram) {
		this.ram = ram;
		return this;
	}

	public Computer oS(String operationalSystem) {
		this.operationalSystem = operationalSystem;
		return this;
	}

	public void shop() {
		System.out.println("Digite a marca do computador: ");
		String brand = t.next();

		System.out.println("Digite o processador: ");
		String processor = t.next();

		System.out.println("Digite a capacidade da memória RAM: ");
		String ram = t.next();

		System.out.println("Digite o sistema operacional: ");
		String os = t.next();

		ComputerDAO.computers.add(new Computer().idIs(ComputerDAO.computers.size() + 1).brands(brand)
				.processorIs(processor).ramCapacity(ram).oS(os));

		System.out.println("Computador comprado com sucesso!");

	}

	public void maintenance() {
		boolean exists = false;
		
		while(!exists) {
			System.out.println("Digite o número de identificação do computador: ");
			int id = t.nextInt();
			
			for(Computer computer : ComputerDAO.computers) {
				if (computer.getId() == id ) {
					exists = true;
				} 
			}
		}
		
		if(exists) 
			ComputerDAO.computers.remove(id);
			System.out.println("Computador foi reconhecido e retirado para manutenção.");
		
	}

	public int getId() {
		return id;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getProcessor() {
		return processor;
	}

	public String getRam() {
		return ram;
	}

	public String getOperationalSystem() {
		return operationalSystem;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", marca=" + brandName + ", processador=" + processor + ", ram=" + ram + ", SO="
				+ operationalSystem + "]";
	}

}
