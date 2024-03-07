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
    
    
    public List<Carro> consultarTodos() throws SQLException {
    List<Carro> carros = new ArrayList<>();
    Connection conexao = ConexaoBanco.obterConexao();
    String sql = "SELECT * FROM carro"; // Consulta para selecionar todos os carros
    PreparedStatement statement = conexao.prepareStatement(sql);
    ResultSet result = statement.executeQuery();

    while (result.next()) {
        // Obter os valores de cada coluna do resultado
        long id = result.getLong("id");
        long fabricanteId = result.getLong("fabricante_id");
        long modeloId = result.getLong("modelo_id");
        String placa = result.getString("placa");
        String cor = result.getString("cor");
        boolean disponivel = result.getBoolean("disponivel");
        int ano = result.getInt("ano");
        double valorLocacao = result.getDouble("valorlocacao");

        // Criar um objeto Carro com os valores obtidos e adicioná-lo à lista
        Carro carro = new Carro(id, fabricanteId, modeloId, placa, cor, disponivel, ano, valorLocacao);
        carros.add(carro);
    }

    // Fechar recursos
    result.close();
    statement.close();
    conexao.close();

    return carros;
}
      
      
      
      
      
      
      public void editar(Carro carro) {
        try {
            Connection conexao = ConexaoBanco.obterConexao();
            String sql = "UPDATE carro SET fabricante_id = ?, modelo_id = ?, placa = ?, cor = ?, disponivel = ?, ano = ?, valorlocacao = ? WHERE id = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setLong(1, carro.getFabricanteId());
            statement.setLong(2, carro.getModeloId());
            statement.setString(3, carro.getPlaca());
            statement.setString(4, carro.getCor());
            statement.setBoolean(5, carro.getDisponivel());
            statement.setInt(6, carro.getAno());
            statement.setDouble(7, carro.getValorLocacao());
            statement.setLong(8, carro.getId());
            statement.executeUpdate();

            statement.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao editar carro: " + e.getMessage());
        }
    }
      
      
      public Long obterIdFabricantePeloNome(String nomeFabricante) {
    String query = "SELECT id FROM fabricante WHERE nome = ?";
    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, nomeFabricante);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getLong("id");
            }
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao obter ID do fabricante: " + ex.getMessage());
    }
    return null;
}

      
      
      
      
      public Long obterIdModeloPeloNome(String nomeModelo) {
    String query = "SELECT id FROM modelo WHERE modelo  ?";
    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, nomeModelo);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getLong("id");
            }
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao obter ID do modelo: " + ex.getMessage());
    }
    return null;
}
      
      public Long obterIdModeloPeloId(Long idModelo) {
    String query = "SELECT id FROM modelo WHERE id = ?";
    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setLong(1, idModelo);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getLong("id");
            }
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao obter ID do modelo: " + ex.getMessage());
    }
    return null;
}


}