package br.com.aula.conexao;

//Importando bibliotecas.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class LerDados {

	public static void main(String[] args) {
		Connection conexao = ConexaoBD.conectar(); //Conectando ao banco de dados.
		
//
		if(conexao != null) {
			String sql = "SELECT * FROM alunos";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet resultado = stmt.executeQuery(sql);
				
				while (resultado.next()) {
                    System.out.println("ID: " + resultado.getInt("id"));
                    System.out.println("Nome: " + resultado.getString("nome"));
                    System.out.println("Idade: " + resultado.getInt("idade"));
                    System.out.println("----------");
                    
                    System.out.println("Dados puxados com sucesso.");
                }
			} catch (SQLException e) {
				System.err.println("Erro ao puxar dados: " + e.getMessage());
			} finally {
				try {
					if (conexao != null) conexao.close();
				} catch (SQLException e) {
					System.err.println("Erro ao fechar conexão: " + e.getMessage());
				}
			}
		}

	}

}
