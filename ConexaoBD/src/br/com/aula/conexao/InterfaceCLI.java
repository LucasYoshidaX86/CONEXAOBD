package br.com.aula.conexao;

//Importando bibliotecas.
import java.sql.Connection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.InputMismatchException;

//Criando classe para elaboração de interface Command-Line.
public class InterfaceCLI {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in); //Criando objeto scanner para ler entrada do usuário.
		
//Criando loop infinito para exibição de execuções do sistema, onde o usuário escolhe uma opção. 
		while (true) {
			
			try {
				System.out.println("=== Menu Principal ===");
				System.out.println("1. Inserir Aluno");
				System.out.println("2. Atualizar Aluno");
				System.out.println("3. Deletar Aluno");
				System.out.println("4. Ler Registros de Alunos");
				System.out.println("0. Sair");
				System.out.println("Escolha uma opção: ");
				
				int opcao = entrada.nextInt(); //Recebe a entrada e armazena.
				entrada.nextLine(); //Limpando o buffer.
				
//Criação dos casos de acordo a entrada digitada pelo usuário.
				switch (opcao) {
					case 1: 
						InserirDados.main(null); //Caso 1 chama o método main da classe InserirDados.
						break;
					case 2:
						AtualizarDados.main(null); //Caso 2 chama o método main da classe AtualizarDados.
						break;
					case 3:
						DeletarDados.main(null); //Caso 3 chama o método main da classe DeletarDados.
						break;
					case 4: 
						LerDados.main(null); //Caso 4 chama o método main da classe LerDados.
						break;
					case 0: 
						System.out.println("Saindo..."); //Caso a entrada seja igual a 0, o programa encerra.
						entrada.close();
						return;
					default:
						System.out.println("Opção inválida. Tente novamente."); //Exibe esta mensagem caso seja uma opção inválida.
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Por favor, digite um número."); //Cria uma exceção caso a entrada digitada pelo usuário não seja um número.
				entrada.nextLine(); //Limpa buffer. 
			}
			
			
		}
		
	}

}
