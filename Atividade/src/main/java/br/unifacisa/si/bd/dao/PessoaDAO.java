package br.unifacisa.si.bd.dao;

import java.util.List;

import br.unifacisa.si.bd.model.Pessoa;

public interface PessoaDAO {
	
	public void cadastrar(Pessoa pessoa);
	public void exluir(Pessoa pessoa);
	public Pessoa obterPessoaPorNome(String nome);
	public List<Pessoa> todasAsPessoas();

}
