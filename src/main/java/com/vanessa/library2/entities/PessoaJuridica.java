package com.vanessa.library2.entities;

public class PessoaJuridica extends Pessoa {
	protected String razaoSocial;

	public PessoaJuridica(int registro, String razaoSocial) {
		super(registro);
		this.razaoSocial = razaoSocial;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
	public String toString() {
		return "PessoaJuridica - Razão Social: " + razaoSocial;
	}

}
