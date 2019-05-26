package com.api.termomecanica.bean;

import java.io.Serializable;

public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;


	private int id;
	
	private String nome;
	
	private String sobrenome;
	
	private String cpf;
	
	private String rg;
	
	private String cidade;
	
	private String estado;

	private String email;
	

	public ClienteBean() {
	} 
	

	public ClienteBean(String nome, String sobrenome, String cpf, String rg, String cidade, String estado,
			String email) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
	}



	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ClienteBean [nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", rg=" + rg
				+ ", cidade=" + cidade + ", estado=" + estado + ", email=" + email + "]";
	}

}
