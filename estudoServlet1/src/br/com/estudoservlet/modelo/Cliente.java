package br.com.estudoservlet.modelo;

import java.util.Calendar;

public class Cliente {

	private String nomeCompleto;

	private String cpf;

	private Calendar dataNasc;

	private Integer cod_Cliente;

	private Endereço endereco;

	private String email;
	

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Integer getCod_Cliente() {
		return cod_Cliente;
	}

	public void setCod_Cliente(Integer cod_Cliente) {
		this.cod_Cliente = cod_Cliente;
	}

	public Endereço getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereço endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
