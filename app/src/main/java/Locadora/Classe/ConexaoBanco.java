package Locadora.Classe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static String url = "jdbc:postgresql://localhost:5434/Locadora?autoReconnect=true";
    private static String user = "postgres";
    private static String senha = "admin";

    // Usaremos o padrão Singleton para garantir apenas uma instância da conexão
    private static Connection connection = null;

    // Método privado para criar uma conexão
    private static void criarConexao() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, senha);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver PostgreSQL não encontrado.");
        }
    }

    // Método público para obter a conexão
    public static Connection obterConexao() throws SQLException {
        if (connection == null || connection.isClosed()) {
            criarConexao();
        }
        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection conexao = obterConexao();
            System.out.println("Conexão com o banco de dados estabelecida.");
            // Faça operações no banco de dados aqui

            // Não se esqueça de fechar a conexão quando terminar
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao conectar ao banco de dados.");
        }
    }
}
