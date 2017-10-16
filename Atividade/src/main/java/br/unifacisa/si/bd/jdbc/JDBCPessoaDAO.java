package br.unifacisa.si.bd.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unifacisa.si.bd.dao.PessoaDAO;
import br.unifacisa.si.bd.model.Pessoa;

public class JDBCPessoaDAO implements PessoaDAO{
	
	private Connection con;
	

	public JDBCPessoaDAO(Connection con) {
		this.con = con;
	}
	
	

	public void cadastrar(Pessoa pessoa) {
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into pessoa (id_pessoa,nome, cpf,dataNacimento) "
			   		+ "values (?,?,?,?)");
			 p.setInt(1, pessoa.getId());
			 p.setString(2, pessoa.getNome());
			 p.setString(3, pessoa.getCpf());
			 p.setString(4, pessoa.getDataNacimento());
			   p.executeUpdate();
			   p.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				  
		
	}

	public void exluir(Pessoa pessoa) {
		PreparedStatement p;
		try {
			p = con.prepareStatement("delete from pessoa where id_pessoa = ?");
			p.setInt(1, pessoa.getId());
			   p.executeUpdate();
			   p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		
	}

	public Pessoa obterPessoaPorNome(String nome) {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas = this.todasAsPessoas();
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getNome().equals(nome)) {
				return pessoa;
			}
		}	
		return null;
	}

	public List<Pessoa> todasAsPessoas() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		   PreparedStatement p;
		try {
			p = con.prepareStatement("select * from pessoa");
			ResultSet rs = p.executeQuery();
			   while(rs.next()){
			      Pessoa pessoa = new Pessoa();
			      pessoa.setId(rs.getInt("id_pessoa"));
			      pessoa.setNome(rs.getString("nome"));
			      pessoa.setCpf(rs.getString("cpf"));
			      pessoa.setDataNacimento(rs.getString("dataNacimento"));
			      pessoas.add(pessoa);
			   }
			   rs.close();
			   p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return pessoas;
	}

}
