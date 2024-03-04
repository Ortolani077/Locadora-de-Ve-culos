package Locadora.Repository;

import Locadora.Model.Carro;
import Locadora.Classe.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CarroRepository {

    public void salvar(Carro pCarro) {
        String insertCarro = "INSERT INTO carro (fabricante_id, modelo_id, placa, cor, disponivel, ano, valorlocacao) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConexaoBanco.obterConexao();
             PreparedStatement statement = connection.prepareStatement(insertCarro)) {
            statement.setLong(1, pCarro.getFabricanteId());
            statement.setLong(2, pCarro.getModeloId());
            statement.setString(3, pCarro.getPlaca());
            statement.setString(4, pCarro.getCor());

            if (pCarro.getDisponivel() != null) {
                statement.setBoolean(5, pCarro.getDisponivel());
            } else {
                statement.setNull(5, Types.BOOLEAN);
            }

            statement.setInt(6, pCarro.getAno());

            // Verifica se o valor de valorLocacao não é nulo antes de definir no statement
            if (pCarro.getValorLocacao() != null) {
                statement.setDouble(7, pCarro.getValorLocacao());
            } else {
                statement.setNull(7, Types.DOUBLE);
            }

            statement.executeUpdate();
            System.out.println("Carro salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar o carro: " + ex.getMessage());
        }
    }

    public List<Carro> consultarPorFabricante(Long idFabricante) throws SQLException {
        List<Carro> carrosDoFabricante = new ArrayList<>();

        String query = "SELECT * FROM carro WHERE fabricante_id = ?";

        try (Connection connection = ConexaoBanco.obterConexao();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, idFabricante);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String anoAsString = Integer.toString(resultSet.getInt("ano"));

            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar carros por fabricante: " + ex.getMessage());
        }

        return carrosDoFabricante;
    }
    }
}
