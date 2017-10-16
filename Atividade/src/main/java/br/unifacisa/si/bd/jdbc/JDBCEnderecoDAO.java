package br.unifacisa.si.bd.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unifacisa.si.bd.dao.EnderecoDAO;
import br.unifacisa.si.bd.model.Endereco;
import br.unifacisa.si.bd.model.Pessoa;

public class JDBCEnderecoDAO implements EnderecoDAO{
	
	private Connection con;
	
	

	public JDBCEnderecoDAO(Connection con) {
		super();
		this.con = con;
	}

	public void cadastrar(Endereco endereco) {
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into endereco (id_endereco,id_pessoa,estado,cidade,rua,numero) "
			   		+ "values (?,?,?,?,?,?)");
			 p.setInt(1, endereco.getId());
			 p.setInt(2, endereco.getIdPessoa());
			 p.setString(3, endereco.getEstado());
			 p.setString(4, endereco.getCidade());
			 p.setString(5, endereco.getRua());
			 p.setInt(6, endereco.getNumero());
			   p.executeUpdate();
			   p.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void exluir(Endereco endereco) {
		PreparedStatement p;
		try {
			p = con.prepareStatement("delete from endereco where id_endereco = ?");
			p.setInt(1, endereco.getId());
			   p.executeUpdate();
			   p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Endereco obterEnderecoPorNome(String nome) {
		JDBCPessoaDAO p = new JDBCPessoaDAO(this.con);
		Pessoa pessoa;
		pessoa = p.obterPessoaPorNome(nome);
		List<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos = this.todosOsEnderecos();
		for (Endereco endereco : enderecos) {
			if(endereco.getIdPessoa() == pessoa.getId()) {
				return endereco;
			}
		}
		return null;
	}

	public List<Endereco> todosOsEnderecos() {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		   PreparedStatement p;
		try {
			p = con.prepareStatement("select * from endereco");
			ResultSet rs = p.executeQuery();
			   while(rs.next()){
				   Endereco endereco = new Endereco();
			      endereco.setId(rs.getInt("id_endereco"));
			      endereco.setIdPessoa(rs.getInt("id_pessoa"));
			      endereco.setEstado(rs.getString("estado"));
			      endereco.setCidade(rs.getString("cidade"));
			      endereco.setRua(rs.getString("rua"));
			      endereco.setNumero(rs.getInt("numero"));
			      enderecos.add(endereco);
			   }
			   rs.close();
			   p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return enderecos;
	}

}
