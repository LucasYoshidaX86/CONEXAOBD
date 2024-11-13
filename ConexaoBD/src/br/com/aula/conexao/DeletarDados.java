package br.com.aula.conexao;

//Importando bibliotecas.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//Criando classe para deletar dados do banco de dados.
public class DeletarDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoBD.conectar(); //Chamando método para conectar com o banco de dados.
		
		Scanner entrada = new Scanner(System.in); //Criando objeto scanner para ler a entrada do usuário.
		
//Verifica a conexão com o banco de dados para continuar com a execução.
		if (conexao != null) {
			String sql = "DELETE FROM alunos WHERE nome = ?"; //Definindo comando para deletar dados.
			try {
				System.out.println("Digite o nome do aluno que deseja excluir da tabela: ");
					String nome = entrada.nextLine(); //Recebe a entrada e armazena.
					
//Deletando os dados escolhido pelo usuário.
					PreparedStatement stmt = conexao.prepareStatement(sql);
					stmt.setString(1, nome);
					stmt.executeUpdate();
					
//Exibe mensagem de sucesso caso o delete tenha sido concluído.
					System.out.println("Dados excluídos com sucesso.");
			} catch (SQLException e) { //Criando exceção para erro, quando ocorra erro ao excluir um dado.
				System.err.println("Erro ao excluir dados: " + e.getMessage());
			} finally {
				try {
//Finalizando a conexão com o banco de dados.
					if (conexao != null) conexao.close();
				} catch (SQLException e) {
					System.err.println("Erro ao fechar conexão: " + e.getMessage());
				}
			}
		}

	}

}
