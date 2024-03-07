package Locadora.services;

import Locadora.Classe.ConexaoBanco;
import Locadora.Model.Carro;
import Locadora.Model.Modelo;
import Locadora.Repository.CarroRepository;
import Locadora.Services.FabricanteServices;
import Locadora.Services.LeituraServices;
import Locadora.Services.ModeloServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;

public class CarroServices {

    private Carro pCarro;

    public void salvar(Carro pCarro) {
        new CarroRepository().salvar(pCarro);
    }

 
    private Long idFabricanteSelecionado;
    private Long idModeloSelecionado;

 public void cadastrarCarro(String ano, String cor, String placa, String valor, boolean disponivel) {
    // Verifica se o fabricante e o modelo foram selecionados
    if (idFabricanteSelecionado == null || idModeloSelecionado == null) {
        JOptionPane.showMessageDialog(null, "Por favor, selecione um fabricante e um modelo.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Cria o novo objeto Carro com os dados informados
    Carro novoCarro = new Carro(null, idFabricanteSelecionado, idModeloSelecionado, placa, cor, disponivel, Integer.parseInt(ano), Double.parseDouble(valor));

    // Salva o novo carro no banco de dados
    salvar(novoCarro);

    // Exibe uma mensagem de sucesso
    JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
}
 
 
 public void editarrCarro(String ano, String cor, String placa, String valor, boolean disponivel) {
    // Verifica se o fabricante e o modelo foram selecionados
    if (idFabricanteSelecionado == null || idModeloSelecionado == null) {
        JOptionPane.showMessageDialog(null, "Por favor, selecione um fabricante e um modelo.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Cria o novo objeto Carro com os dados informados
    Carro novoCarro = new Carro(null, idFabricanteSelecionado, idModeloSelecionado, placa, cor, disponivel, Integer.parseInt(ano), Double.parseDouble(valor));

    // Salva o novo carro no banco de dados
    salvar(novoCarro);

    // Exibe uma mensagem de sucesso
    JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
}
 public List<Carro> consultarTodos() throws SQLException {
        List<Carro> todosCarros = new ArrayList<>();

        String query = "SELECT * FROM carro";

        try (Connection connection = ConexaoBanco.obterConexao();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Carro carro = new Carro();

                // Preencha o objeto Carro com os dados do ResultSet
                carro.setId(resultSet.getLong("id"));
                carro.setFabricanteId(resultSet.getLong("fabricante_id"));
                carro.setModeloId(resultSet.getLong("modelo_id"));
                carro.setPlaca(resultSet.getString("placa"));
                carro.setCor(resultSet.getString("cor"));
                carro.setDisponivel(resultSet.getBoolean("disponivel"));
                carro.setAno(resultSet.getInt("ano"));
                carro.setValorLocacao(resultSet.getDouble("valorlocacao"));

                // Adicione o carro à lista
                todosCarros.add(carro);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar todos os carros: " + ex.getMessage());
            throw ex; // Lança a exceção para ser tratada posteriormente
        }

        return todosCarros;
    }
}