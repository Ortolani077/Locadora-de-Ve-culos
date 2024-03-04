package Locadora.Repository;

import Locadora.Classe.ConexaoBanco;
import Locadora.Model.Carro;
import Locadora.Model.Fabricante;
import Locadora.Model.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ModeloRepository {

    public List<Modelo> consultarTodos(Long idFabricante) {
        try {
           Connection conexao = ConexaoBanco.obterConexao();
String sql = "SELECT * FROM modelo WHERE fabricante_id = ?";
PreparedStatement statement = conexao.prepareStatement(sql);
statement.setLong(1, idFabricante);
ResultSet result = statement.executeQuery();


            List<Modelo> listaModelo = new ArrayList<>();

            while (result.next()) {
                listaModelo.add(new Modelo(
                        result.getLong("id"),
                        result.getString("nome"),
                        result.getLong("fabricante_id")
                ));
            }

            // Fechar recursos
            result.close();
            statement.close();
            conexao.close();

            return listaModelo;

        } catch (SQLException ex) {
            System.out.println("Algo deu errado: " + ex.getMessage());
            return null;
        }
    }

   public void salvar( Carro pCarro) {
    String insertCarro = "INSERT INTO carro (fabricante_id, modelo_id, placa, cor, disponivel, ano, valorlocacao) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(insertCarro)) {
        statement.setLong(1, pCarro.getIdFabricante());
        statement.setLong(2, pCarro.getIdModelo());
        statement.setString(3, pCarro.getPlaca());
        statement.setString(4, pCarro.getCor());
        if (pCarro.getDisponivel() != null) { // Verifica se o valor de disponível é nulo
            statement.setBoolean(5, pCarro.getDisponivel());
        } else {
            statement.setNull(5, Types.BOOLEAN); // Se for nulo, define como NULL no banco de dados
        }
        statement.setInt(6, pCarro.getAno());
        statement.setDouble(7, pCarro.getValorLocacao());

        statement.executeUpdate();
        System.out.println("Carro salvo com sucesso!");
    } catch (SQLException ex) {
        System.out.println("Erro ao salvar o carro: " + ex.getMessage());
    }
}

public List<Modelo> consultarTodosmodelos() {
    try {
        Connection conexao = ConexaoBanco.obterConexao();
        Statement statement = conexao.createStatement();

        String sql = "SELECT * FROM modelo";

        ResultSet result = statement.executeQuery(sql);

        List<Modelo> listaModelo = new ArrayList<>();

        while (result.next()) {
            long id = result.getLong("id");
            String nome = result.getString("nome");
            long fabricanteId = result.getLong("fabricante_id");
            Modelo modelo = new Modelo(id, nome, fabricanteId); // Instancia o modelo com os dados do banco
            listaModelo.add(modelo);
        }

        // Fechar recursos
        result.close();
        statement.close();
        conexao.close();

        return listaModelo;

    } catch (SQLException ex) {
        System.out.println("Algo deu errado: " + ex.getMessage());
        return null;
    }
}

public void salvarModelo(Modelo modelo) {
    String insertModelo = "INSERT INTO modelo (nome, fabricante_id) VALUES (?, ?)";

    try (Connection connection = ConexaoBanco.obterConexao();
         PreparedStatement statement = connection.prepareStatement(insertModelo)) {
        statement.setString(1, modelo.getNome());
        statement.setLong(2, modelo.getFabricanteId());

        statement.executeUpdate();
        System.out.println("Modelo salvo com sucesso!");
    } catch (SQLException ex) {
        System.out.println("Erro ao salvar o modelo: " + ex.getMessage());
    }
}
}
