package br.com.mirante.teste;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunosTeste {
	
	public static void main(String[] args) throws SQLException {
		try(
				var conexao = DriverManager.getConnection("jdbc:mysql://localhost/orcamento", "root", "Luiz1.devmirante");
				var statement = conexao.createStatement()
			){
			
			var resultado = statement.executeQuery("SELECT ID, NOME FROM ALUNO");
			imprimirResultado(resultado);
			
			statement.executeUpdate("INSERT INTO ALUNO(NOME) VALUES ('Maísa Abreu')");
		}
	}

	static void imprimirResultado(ResultSet resultado) throws SQLException {
		while(resultado.next()) {
			Integer id = resultado.getInt("ID");
			String nome = resultado.getString("NOME");
			System.out.println(id + " " + nome);
		}
	}
}