package br.com.aula.conexao;


//Importando biblioteca.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//Criando classe para inserir os dados na tabela.
public class InserirDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoBD.conectar(); //Chamando método para conectar ao banco de dados.
		
		Scanner entrada = new Scanner(System.in); //Criando objeto scanner para ler entrada do usuário.
			
// Verifica a conexão com o banco de dados para continuar com a execução.
		if (conexao != null) {
			String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)"; //Define o comando para inserir os dados ao SQL.
			try {
//Recebe dados digitados pelo usuário.
				System.out.println("Digite o nome para inserir ao Banco de Dados: ");
					String nome = entrada.nextLine();
//Recebe dados digitados pelo usuário.		
			    System.out.println("Digite a idade para inserir ao Banco de Dados: ");
					int idade = entrada.nextInt();
//Preparando a execução da inserção dos dados digitados pelo usuário.
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setInt(2, idade);
				stmt.executeUpdate();
				
//Exibe mensagem de sucesso para execução concluída.			
				System.out.println("Dados inseridos com sucesso.");
			} catch (SQLException e) { //Cria exceção para erro, caso tenha algum erro ao inserir os dados.
				System.err.println("Erro ao inserir dados: " + e.getMessage());
			} finally {
				try {
//Finalizando a conexão com o banco de dados.
					if (conexao != null) conexao.close();
				} catch (SQLException e) {
					System.err.println("Erro ao fechar conexão: " + e.getMessage());
				}
			}
		}
		entrada.close();
	}
}
