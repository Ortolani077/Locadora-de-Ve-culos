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

 

    public Long obterIdFabricantePeloNome(String nome) throws SQLException {
        Long id = null;
          String query = "SELECT id FROM fabricante WHERE nome = ?";
        try (PreparedStatement statement = ConexaoBanco.obterConexao().prepareStatement(query)) {
            statement.setString(1, nome);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    id = resultSet.getLong("id");
                }
            }
        }
        return id;
}
    
    
    
      public void editarFabricante(Fabricante fabricante) {
String updateFabricante = "UPDATE fabricante SET nome = ? WHERE nome = ?";

    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(updateFabricante)) {
        
        statement.setString(1, fabricante.getNome());
        

        statement.executeUpdate();
        System.out.println("Fabricante editado com sucesso!");
    } catch (SQLException ex) {
        System.out.println("Erro ao editar o fabricante: " + ex.getMessage());
    }
}
      

public boolean verificarModelosAssociados(long idFabricante) {
    String query = "SELECT COUNT(*) FROM modelo WHERE fabricante_id = ?";
    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(query)) {
        
        statement.setLong(1, idFabricante);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0; // Retorna true se houver modelos associados, false se não houver
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao verificar modelos associados: " + ex.getMessage());
    }
    return true; // Retorna true em caso de erro para evitar exclusão acidental
}


      
public String obterNomeFabricantePorId(long idFabricante) {
    // Cria uma instância de FabricanteRepository
    FabricanteRepository fabricanteRepository = new FabricanteRepository();
    
    // Consulta o repositório para obter a lista de fabricantes
    List<Fabricante> fabricantes = fabricanteRepository.consultar();
    
    // Itera sobre a lista de fabricantes
    for (Fabricante fabricante : fabricantes) {
        // Verifica se o ID do fabricante corresponde ao ID procurado
        if (fabricante.getId() == idFabricante) {
            // Retorna o nome do fabricante encontrado
            return fabricante.getNome();
        }
    }
    // Retorna uma string vazia se o fabricante não for encontrado
    return "";
}






public void excluirModelosDoFabricante(long idFabricante) {
    String deleteModelos = "DELETE FROM modelo WHERE fabricante_id = ?";
    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(deleteModelos)) {
        
        statement.setLong(1, idFabricante);
        statement.executeUpdate();
        
        System.out.println("Modelos associados ao fabricante foram excluídos com sucesso!");
        
    } catch (SQLException ex) {
        System.out.println("Erro ao excluir modelos associados: " + ex.getMessage());
    }
}

public void deletarFabricante(Fabricante fabricante) {
    // Verifica se há modelos associados ao fabricante
    if (verificarModelosAssociados(fabricante.getId())) {
        // Se houver, exclua esses modelos primeiro
        excluirModelosDoFabricante(fabricante.getId());
    }

    // Exclui os carros associados aos modelos do fabricante
    excluirCarrosDosModelosDoFabricante(fabricante.getId());

    // Agora podemos excluir o fabricante
    String deleteFabricante = "DELETE FROM fabricante WHERE id = ?";
  
    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(deleteFabricante)) {
        
        statement.setLong(1, fabricante.getId());
        
        int linhasAfetadas = statement.executeUpdate();
        
        if (linhasAfetadas > 0) {
            System.out.println("Fabricante deletado com sucesso!");
        } else {
            System.out.println("Nenhum fabricante foi deletado.");
        }
        
    } catch (SQLException ex) {
        System.out.println("Erro ao deletar o fabricante: " + ex.getMessage());
    }
}

// Método para excluir os carros associados aos modelos do fabricante
public void excluirCarrosDosModelosDoFabricante(long idFabricante) {
    String deleteCarros = "DELETE FROM carro WHERE modelo_id IN (SELECT id FROM modelo WHERE fabricante_id = ?)";
    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(deleteCarros)) {
        
        statement.setLong(1, idFabricante);
        statement.executeUpdate();
        
        System.out.println("Carros associados aos modelos do fabricante foram excluídos com sucesso!");
        
    } catch (SQLException ex) {
        System.out.println("Erro ao excluir carros associados aos modelos: " + ex.getMessage());
    }
}






}