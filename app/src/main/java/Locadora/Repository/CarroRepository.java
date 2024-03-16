package Locadora.Repository;
import Locadora.Classe.ConexaoBanco;
import Locadora.Model.Carro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CarroRepository {

    // Outros métodos da classe CarroRepository...

    /**
     * Busca o nome do fabricante pelo ID.
     * @param idFabricante O ID do fabricante.
     * @return O nome do fabricante ou null se não for encontrado.
     */
    public String buscarNomeFabricantePorId(Long idFabricante) {
        String nomeFabricante = null;
        String query = "SELECT nome FROM fabricante WHERE id = ?";
        try (Connection connection = ConexaoBanco.obterConexao();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, idFabricante);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    nomeFabricante = resultSet.getString("nome");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar o nome do fabricante: " + ex.getMessage());
        }
        return nomeFabricante;
    }

    /**
     * Busca o nome do modelo pelo ID.
     * @param idModelo O ID do modelo.
     * @return O nome do modelo ou null se não for encontrado.
     */
    public String buscarNomeModeloPorId(Long idModelo) {
        String nomeModelo = null;
        String query = "SELECT nome FROM modelo WHERE id = ?";
        try (Connection connection = ConexaoBanco.obterConexao();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, idModelo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    nomeModelo = resultSet.getString("nome");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar o nome do modelo: " + ex.getMessage());
        }
        return nomeModelo;
    }
    
    
    
      public List<Carro> listarTodos() throws SQLException {
        List<Carro> carros = new ArrayList<>();
        String query = "SELECT * FROM carro";

        try (Connection connection = ConexaoBanco.obterConexao();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Carro carro = new Carro();
                carro.setId(resultSet.getLong("id"));
                carro.setFabricanteId(resultSet.getLong("fabricante_id"));
                carro.setModeloId(resultSet.getLong("modelo_id"));
                carro.setPlaca(resultSet.getString("placa"));
                carro.setCor(resultSet.getString("cor"));
                carro.setDisponivel(resultSet.getBoolean("disponivel"));
                carro.setAno(resultSet.getInt("ano"));
                carro.setValorLocacao(resultSet.getDouble("valorlocacao"));
                // Adicione outros atributos do carro, se necessário

                carros.add(carro);
            }
        }

        return carros;
    }
      
       public Long obterIdFabricantePeloNome(String nomeFabricante) {
        Long idFabricante = null;
        String query = "SELECT id FROM fabricante WHERE nome = ?";
        try (Connection connection = ConexaoBanco.obterConexao();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nomeFabricante);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    idFabricante = resultSet.getLong("id");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar o ID do fabricante pelo nome: " + ex.getMessage());
        }
        return idFabricante;
    }
       
       
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
        
        public void editarCarro(Carro carro) {
    String updateCarro = "UPDATE carro SET fabricante_id = ?, modelo_id = ?, placa = ?, cor = ?, disponivel = ?, ano = ?, valorlocacao = ? WHERE id = ?";

    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(updateCarro)) {
        statement.setLong(1, carro.getFabricanteId());
        statement.setLong(2, carro.getModeloId());
        statement.setString(3, carro.getPlaca());
        statement.setString(4, carro.getCor());
        statement.setBoolean(5, carro.getDisponivel());
        statement.setInt(6, carro.getAno());
        statement.setDouble(7, carro.getValorLocacao());
        statement.setLong(8, carro.getId());

        statement.executeUpdate();
        System.out.println("Carro editado com sucesso!");
    } catch (SQLException ex) {
        System.out.println("Erro ao editar o carro: " + ex.getMessage());
    }
}
public Long obterIdModeloPeloNome(String nomeModelo) {
    Long idModelo = null;
    String query = "SELECT id FROM modelo WHERE nome = ?";
    
    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, nomeModelo);
        
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                idModelo = resultSet.getLong("id");
            }
        }
    } catch (SQLException ex) {
        // Tratamento de exceção mais específico
        System.err.println("Erro ao buscar o ID do modelo pelo nome: " + ex.getMessage());
    }
    
    return idModelo;
}

    public List<Carro> listarPorFabricante(long idFabricante) {
    List<Carro> carros = new ArrayList<>();
    String query = "SELECT * FROM carro WHERE fabricante_id = ?";
    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setLong(1, idFabricante);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Carro carro = new Carro();
                carro.setId(resultSet.getLong("id"));
                // Defina outros atributos do carro, se necessário
                carros.add(carro);
            }
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao listar carros por fabricante: " + ex.getMessage());
    }
    return carros;
}

public void excluirCarro(Long id) {
    String query = "DELETE FROM carro WHERE id = ?";
    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setLong(1, id);
        int linhasAfetadas = statement.executeUpdate();
        if (linhasAfetadas > 0) {
            System.out.println("Carro excluído com sucesso!");
        } else {
            System.out.println("Nenhum carro foi excluído.");
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao excluir o carro: " + ex.getMessage());
    }
}

}
