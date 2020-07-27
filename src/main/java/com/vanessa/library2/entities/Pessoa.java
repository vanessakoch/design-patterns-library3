package com.vanessa.library2.entities;

public abstract class Pessoa {
	private int registro;

	public Pessoa(int registro) {
		super();
		this.registro = registro;
	}

	public int getCodigo() {
		return registro;
	}

	public void setCodigo(int registro) {
		this.registro = registro;
	}

}
