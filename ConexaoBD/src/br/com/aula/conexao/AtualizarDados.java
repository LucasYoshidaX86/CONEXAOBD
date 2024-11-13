package br.com.aula.conexao;

//Importando bibliotecas.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException; 
import java.util.Scanner;
import java.util.InputMismatchException;

//Criando classe para atualizar dados do banco de dados.
public class AtualizarDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoBD.conectar(); //Chamando método para conectar ao banco de dados.
		
		Scanner entrada = new Scanner(System.in); //Criando objeto scanner para ler entrada do usuário.
		
		int escolha = -1; //Inicia a variável com valor fora do parâmetro para entrar no loop.
		
//Loop While para verificar se a entrada digitada pelo usuário está dentro do parâmetro pedido.
		     while (true) {
		            try {
//Exibindo opções para alterar dados.
		                System.out.println("Alterar Dados: ");
		                System.out.println("Digite 1 para alterar nome e idade.");
		                System.out.println("Digite 2 para alterar apenas o nome.");
		                System.out.println("Digite 3 para alterar apenas a idade.");
		                System.out.print("Escolha uma opção: ");
		                escolha = entrada.nextInt(); //Recebe entrada do usuário.
		                entrada.nextLine(); // Limpando o buffer.

		                //Se a entrada estiver dentro do parâmetro, finaliza o loop.
		                if (escolha >= 1 && escolha <= 3) {
		                    break;
		                } else { //Exibe mensagem de erro caso a entrada não seja uma das opções.
		                    System.out.println("Erro: Opção inválida. Por favor, escolha entre as opções 1, 2 ou 3.");
		                }
		            } catch (InputMismatchException e) { //Exibe mensagem caso a entrada não seja válida, como por exemplo uma letra.
		                System.out.println("Erro: Entrada inválida. Por favor, insira um número inteiro para a opção.");
		                entrada.nextLine(); // Limpando o buffer.
		            }
		        }
			
//Verifica conexão para continuar com a execução.
		if (conexao != null) {
			
			try {
				if (escolha == 1) { //Comando para alterar nome e idade do aluno, caso a entrada escolhida do usuário seja 1.
					System.out.println("Digite o novo nome do aluno: ");
						String nome1 = entrada.nextLine(); //Recebe a entrada e armazena.
						
						
					System.out.println("Digite a nova idade: ");
						int idade1 = entrada.nextInt(); //Recebe a entrada e armazena.
						
						entrada.nextLine(); //Limpando o buffer.
						
					System.out.println("Digite o nome do aluno que deseja alterar os dados: ");
						String nome2 = entrada.nextLine(); //Recebe a entrada e armazena.
						
					String sql1 = "UPDATE alunos SET nome = ?, idade = ? WHERE nome = ?"; //Define o comando para alterar os dados na tabela.
					PreparedStatement stmt = conexao.prepareStatement(sql1);
				
					//Atualizando a idade e nome.
					stmt.setString(1, nome1);
					stmt.setInt(2, idade1);
					stmt.setString(3, nome2);
					stmt.executeUpdate();
				} 
					else if (escolha == 2) { //Comando para alterar apenas o nome do aluno, caso a entrada escolhida do usuário seja 2.
					System.out.println("Digite o novo nome do aluno: ");
						String nome3 = entrada.nextLine(); //Recebe a entrada e armazena.
						

						
					System.out.println("Digite o nome do aluno que deseja alterar os dados: ");
						String nome4 = entrada.nextLine(); //Recebe a entrada e armazena.
						
					String sql2 = "UPDATE alunos SET nome = ? WHERE nome = ?"; //Define o comando para alterar os dados na tabela.
					PreparedStatement stmt = conexao.prepareStatement(sql2);
					
					//Atualizando o nome na tabela alunos.
					stmt.setString(1, nome3);
					stmt.setString(2, nome4);
					stmt.executeUpdate();				
				}
					else if (escolha == 3) { //Comando para alterar apenas a idade do aluno, caso a entrada escolhida do usuário seja 3.
					System.out.println("Digite a nova idade: ");
						int idade2 = entrada.nextInt(); //Recebe a entrada e armazena.
						
						entrada.nextLine(); //Limpando o buffer.
						
					System.out.println("Digite o nome do aluno que deseja alterar os dados: ");
						String nome5 = entrada.nextLine(); //Recebe a entrada e armazena.
						
					String sql3 = "UPDATE alunos SET idade = ? WHERE nome = ?"; //Define o comando para alterar os dados na tabela.
					PreparedStatement stmt = conexao.prepareStatement(sql3);
					
					//Atualizando a idade na tabela alunos.
					stmt.setInt(1, idade2);
					stmt.setString(2, nome5);
					stmt.executeUpdate();
				}
//Exibindo mensagem de sucesso para alteração de dados na tabela.
				System.out.println("Dados atualizados com sucesso");
			} catch (SQLException e) { //Cria exceção para erro, caso a alteração de algum erro.
				System.err.println("Erro ao atualizar dados: " + e.getMessage());
			} finally { 
				try {
//Finaliza a execução com o Banco de Dados.
					if (conexao != null) conexao.close();
				} catch (SQLException e) {
					System.err.println("Erro ao fechar conexão: " + e.getMessage());
				}
			}
		}
	}
}
