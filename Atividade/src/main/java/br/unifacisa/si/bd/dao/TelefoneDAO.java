package br.unifacisa.si.bd.dao;

import java.util.List;


import br.unifacisa.si.bd.model.Telefone;

public interface TelefoneDAO {
	
	public void cadastrar(Telefone telefone);
	public void exluir(Telefone telefone);
	public Telefone obterTelefonePorNome(String nome);
	public List<Telefone> todosOsTelefones();

}
