package br.unifacisa.si.bd.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unifacisa.si.bd.dao.TelefoneDAO;
import br.unifacisa.si.bd.model.Pessoa;
import br.unifacisa.si.bd.model.Telefone;

public class JDBCTelefoneDAO implements TelefoneDAO{
	
	private Connection con;
	
	

	public JDBCTelefoneDAO(Connection con) {
		super();
		this.con = con;
	}

	public void cadastrar(Telefone telefone) {
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into telefone (id_telefone,id_pessoa,numero) "
			   		+ "values (?,?,?)");
			p.setInt(1, telefone.getId());
			p.setInt(2, telefone.getIdPessoa());
			p.setInt(3, telefone.getNumero());
			   p.executeUpdate();
			   p.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void exluir(Telefone telefone) {
		PreparedStatement p;
		try {
			p = con.prepareStatement("delete from telefone where id_telefone = ?");
			p.setInt(1, telefone.getId());
			   p.executeUpdate();
			   p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Telefone obterTelefonePorNome(String nome) {
		
		JDBCPessoaDAO p = new JDBCPessoaDAO(this.con);
		Pessoa pessoa;
		pessoa = p.obterPessoaPorNome(nome);
		List<Telefone> telefones = new ArrayList<Telefone>();
		telefones = this.todosOsTelefones();
		for (Telefone telefone : telefones) {
			if(telefone.getIdPessoa() == pessoa.getId()) {
				return telefone;
			}
		}
		
		return null;
	}

	public List<Telefone> todosOsTelefones() {
		List<Telefone> telefones = new ArrayList<Telefone>();
		   PreparedStatement p;
		try {
			p = con.prepareStatement("select * from telefone");
			ResultSet rs = p.executeQuery();
			   while(rs.next()){
				   Telefone telefone = new Telefone();
			      telefone.setId(rs.getInt("id_telefone"));
			      telefone.setIdPessoa(rs.getInt("id_pessoa"));
			      telefone.setNumero(rs.getInt("numero"));
			   }
			   rs.close();
			   p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return telefones;
	}

}
