package br.unifacisa.si.bd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	
	private String driver = "org.postgresql.Driver";
	private String user = "postgres";
	private String senha = "root";
	private String url = "jdbc:postgresql://localhost:5432/atividadeBD2";
	private Connection con;
	
	
	public Connection abriConexao() {
		try {
            Class.forName(driver);
            this.con = null;
            con = (Connection) DriverManager.getConnection(url, user, senha);
            System.out.println( "Conexão realizada com Sucesso!");
        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
		return this.con;
	}
	

}
