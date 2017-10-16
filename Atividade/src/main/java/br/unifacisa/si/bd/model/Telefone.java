package br.unifacisa.si.bd.model;

public class Telefone {
	
	private int id;
	private int idPessoa;
	private int numero;
	
	
	public Telefone(int id, int idPessoa, int numero) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.numero = numero;
	}
	
	public Telefone() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}
