package br.com.mirante.orcamento.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemRepositoryJDBC implements ItemRepository {

	private static final String URL = System.getenv().get("ORCAMENTO_URL");
	private static final String USER = System.getenv().get("ORCAMENTO_USER");
	private static final String SENHA = System.getenv().get("ORCAMENTO_SENHA");
	
	@Override
	public void excluir(Integer codigoItem) {
		String comando = "DELETE FROM ITEM_ORCAMENTO WHERE ID = ?";

		try (Connection conexao = DriverManager.getConnection(URL, USER, SENHA);
				PreparedStatement statement = conexao.prepareStatement(comando)) {
			statement.setInt(1, codigoItem);
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Erro ao conectar ao servidor");
			exception.printStackTrace();
		}
	}
}
