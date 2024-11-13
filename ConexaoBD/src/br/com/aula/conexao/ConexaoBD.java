package br.com.aula.conexao;

//importando bibliotecas.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

// Definindo parâmetros para a conexão com o Banco de Dados.
    private static final String URL = "jdbc:mysql://localhost:3306/aula_java_db";
    private static final String USUARIO = "root";
    private static final String SENHA = ""; // Coloque a senha do seu MySQL, se houver

//Método para conectar com o banco de dados, onde carrega os drivers.
    public static Connection conectar() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

// Tentando conexão com os parâmetros definidos.
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão realizada com sucesso!");
//Criando exceções para caso a conexão não dê certo. 
        } catch (ClassNotFoundException e) {
            System.err.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
        return conexao;
    }

    public static void main(String[] args) {
//Método utilizado na main para testar a conexão.
        conectar();
    }
}

