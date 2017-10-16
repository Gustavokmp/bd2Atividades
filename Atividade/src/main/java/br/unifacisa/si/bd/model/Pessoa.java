package br.unifacisa.si.bd.model;

public class Pessoa {
	
	private int id;
	private String nome;
	private String cpf;
	private String dataNacimento;
	
	
	public Pessoa(int id, String nome, String cpf, String dataNacimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNacimento = dataNacimento;
	}
	
	public Pessoa() {
		super();
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNacimento() {
		return dataNacimento;
	}
	public void setDataNacimento(String dataNacimento) {
		this.dataNacimento = dataNacimento;
	}
	
	
	

}
