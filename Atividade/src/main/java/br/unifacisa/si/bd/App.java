package br.unifacisa.si.bd;

import br.unifacisa.si.bd.conexao.ConexaoBD;
import br.unifacisa.si.bd.jdbc.JDBCEnderecoDAO;
import br.unifacisa.si.bd.jdbc.JDBCPessoaDAO;
import br.unifacisa.si.bd.jdbc.JDBCTelefoneDAO;
import br.unifacisa.si.bd.model.Endereco;
import br.unifacisa.si.bd.model.Pessoa;
import br.unifacisa.si.bd.model.Telefone;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ConexaoBD c = new ConexaoBD();
    	
    	Pessoa p = new Pessoa(1, "Gustavo Pires", "1475", "1993-04-13");
    	JDBCPessoaDAO jdbcP = new JDBCPessoaDAO(c.abriConexao());
    	jdbcP.cadastrar(p);
    	
    	Endereco e = new Endereco(1, p.getId(), "Paraiba", "Campina Grande", "Major Juvino", 81);
    	JDBCEnderecoDAO jdbcE= new JDBCEnderecoDAO(c.abriConexao());
    	jdbcE.cadastrar(e);
    	
    	Telefone t = new Telefone(1, 1, 88888);
    	JDBCTelefoneDAO jdbcT = new JDBCTelefoneDAO(c.abriConexao());
    	jdbcT.cadastrar(t);
    	
    	System.out.println(jdbcP.obterPessoaPorNome("Gustavo Pires").getNome());
    	System.out.println(jdbcE.obterEnderecoPorNome("Gustavo Pires").getCidade());
    	System.out.println(jdbcT.obterTelefonePorNome("Gustavo Pires").getNumero());
    	
    	
    	System.out.println(jdbcP.todasAsPessoas());
    	System.out.println(jdbcE.todosOsEnderecos());
    	System.out.println(jdbcT.todosOsTelefones());
    	
    	jdbcE.exluir(e);
    	jdbcT.exluir(t);
    	jdbcP.exluir(p);
    
    	
    	
    	
    	
    	
    }
}
