package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("Qtde de linhas exclu�das: " + linhasModificadas);
		
		con.close();

	}

}
