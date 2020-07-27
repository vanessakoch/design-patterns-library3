package com.vanessa.library2.entities;

public class PessoaFisica extends Pessoa {
	protected String nome;

	public PessoaFisica(int registro, String nome) {
		super(registro);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa física - Nome: " + nome;
	}

}
