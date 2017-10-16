package br.unifacisa.si.bd.dao;

import java.util.List;

import br.unifacisa.si.bd.model.Endereco;



public interface EnderecoDAO {
	
	public void cadastrar(Endereco endereco);
	public void exluir(Endereco endereco);
	public Endereco obterEnderecoPorNome(String nome);
	public List<Endereco> todosOsEnderecos();

}
