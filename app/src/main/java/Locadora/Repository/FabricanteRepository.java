package Locadora.Repository;

import Locadora.Classe.ConexaoBanco;
import Locadora.Model.Fabricante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FabricanteRepository {
    
   public List<Fabricante> consultar() {
    try (Connection conexao = ConexaoBanco.obterConexao();
         Statement statement = conexao.createStatement()) {

        String sql = "SELECT * FROM fabricante";
        ResultSet result = statement.executeQuery(sql);

        List<Fabricante> listaFabricante = new ArrayList<>();

        while (result.next()) {
            Fabricante fabricante = new Fabricante();
            fabricante.setId(result.getLong("id"));
            fabricante.setNome(result.getString("nome"));
            listaFabricante.add(fabricante);
        }

        return listaFabricante;

    } catch (SQLException ex) {
        System.out.println("Algo deu errado: " + ex.getMessage());
        return new ArrayList<>(); // Retorna uma lista vazia em caso de erro
    }


    }
public Long salvar(String nome) {
        String sql = "INSERT INTO fabricante (nome) VALUES (?)";

        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, nome);

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }

            System.out.println("Fabricante cadastrado com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar fabricante no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }

        return -1L; // Retorna -1 se algo der errado
    }




}
