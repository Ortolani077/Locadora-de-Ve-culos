package Locadora.Services;

import Locadora.Classe.ConexaoBanco;
import Locadora.Model.Modelo;
import Locadora.Model.Fabricante;
import Locadora.Repository.FabricanteRepository;
import Locadora.Services.LeituraServices;
import Locadora.Repository.ModeloRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ModeloServices {

    private final Scanner scanner;

    public ModeloServices() {
        scanner = new Scanner(System.in);
    }

  public List<Modelo> consultar(Long idFabricante) {
    ModeloRepository modeloRepository = new ModeloRepository();
    
    if (idFabricante == null) {
        System.out.println("ID do fabricante é nulo.");
        return new ArrayList<>(); // Retorna uma lista vazia se o ID do fabricante for nulo
    }
    
    List<Modelo> listaModelo = modeloRepository.consultarTodos(idFabricante);
    
    if (listaModelo == null || listaModelo.isEmpty()) {
        System.out.println("Nenhum modelo encontrado para o fabricante com o ID: " + idFabricante);
    } else {
        System.out.println("Lista de Modelos:");
        System.out.println("________________________________");
        for (Modelo modelo : listaModelo) {
            System.out.println(modelo.toString());
        }
        System.out.println("________________________________");
    }
    
    return listaModelo;
}



    
    
    
    
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

    
      public List<String> obterNomesModelos() {
        List<Modelo> listaModelos = consultar(Long.MAX_VALUE);
        List<String> nomesModelos = new ArrayList<>();
        List<Long> fabModelos = new ArrayList<>();

        for (Modelo modelos : listaModelos) {
            nomesModelos.add(modelos.getNome());
        fabModelos.add(modelos.getFabricanteId());
        }
        return nomesModelos;
        
        
      }

    private Connection connection;
    
    
    
    
   public List<Modelo> obterModelos() {
    return consultar(null); // Passa null para indicar que deseja buscar todos os modelos
}


    
 
      
public void cadastrarModelo() {
    ModeloRepository modeloRepo = new ModeloRepository();
    LeituraServices leituraServices = new LeituraServices(); // Inicializa o objeto leituraServices

    System.out.println("Digite o nome do modelo:");
    String nomeModelo = leituraServices.ler(); // Obtém o nome do modelo do usuário
    
    FabricanteServices fabricanteServices = new FabricanteServices();
    Long idFabricante = fabricanteServices.selecionar(); // Chama o método para selecionar o fabricante
    
    if (idFabricante == -1L) {
        System.out.println("Erro ao selecionar o fabricante. Tente novamente.");
        return; // Retorna se houve um erro ao selecionar o fabricante
    }
    
    // Cria uma instância de Modelo com o nome e o ID do fabricante
    Modelo modelo = new Modelo();
    modelo.setNome(nomeModelo);
    modelo.setFabricanteId(idFabricante);
    
  modeloRepo.salvarModelo(modelo);
    
    System.out.println("Modelo cadastrado com sucesso!");
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
            
            // Consulta ao banco de dados para obter o nome do fabricante
            String nomeFabricante = obterNomeFabricante(fabricanteId);

            Modelo modelo = new Modelo(id, nome, fabricanteId);
            
            // Atribuir o nome do fabricante ao objeto Modelo
            modelo.setNomeFabricante(nomeFabricante);

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








private String obterNomeFabricante(long fabricanteId) {
    try {
        Connection conexao = ConexaoBanco.obterConexao();
        String sql = "SELECT nome FROM fabricante WHERE id = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setLong(1, fabricanteId);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            return result.getString("nome");
        } else {
            return "Fabricante não encontrado";
        }
    } catch (SQLException ex) {
        System.out.println("Algo deu errado ao obter o nome do fabricante: " + ex.getMessage());
        return null;
    }
}








  public List<Fabricante> consultarTodos() {
        try {
            Connection conexao = ConexaoBanco.obterConexao();
            Statement statement = conexao.createStatement();

            String sql = "SELECT * FROM fabricante";

            ResultSet result = statement.executeQuery(sql);

            List<Fabricante> listaFabricantes = new ArrayList<>();

            while (result.next()) {
                long id = result.getLong("id");
                String nome = result.getString("nome");
                Fabricante fabricante = new Fabricante(nome); // Instancia o fabricante com os dados do banco
                listaFabricantes.add(fabricante);
            }

            return listaFabricantes;

        } catch (SQLException ex) {
            System.out.println("Algo deu errado: " + ex.getMessage());
            return null;
        }

  }
  
  
  
  public static void exibirListaModelos(List<Modelo> modelos) {
    StringBuilder mensagem = new StringBuilder();
    mensagem.append("Lista de Modelos:\n");
    mensagem.append("________________________________\n");
    
    for (Modelo modelo : modelos) {
        mensagem.append("ID: ").append(modelo.getId()).append(", ");
        mensagem.append("Nome: ").append(modelo.getNome()).append(", ");
        
        // Obtém o nome do fabricante correspondente ao fabricanteId
        String nomeFabricante = obterNomeFabricante(modelo.getFabricanteId());
        mensagem.append("Fabricante: ").append(nomeFabricante).append("\n");
    }
    
    mensagem.append("________________________________");

    JOptionPane.showMessageDialog(null, mensagem.toString(), "Lista de Modelos", JOptionPane.INFORMATION_MESSAGE);
}

// Método para obter o nome do fabricante a partir do ID
private static String obterNomeFabricante(Long fabricanteId) {
    FabricanteServices fabricanteServices = new FabricanteServices();
    List<Fabricante> fabricantes = fabricanteServices.consultar();
    
    for (Fabricante fabricante : fabricantes) {
        if (fabricante.getId().equals(fabricanteId)) {
            return fabricante.getNome();
        }
    }
    
    return "Fabricante não encontrado";
}



public List<Modelo> consultarTodosNomesFabricantes(Long idFabricante) {
    try {
        Connection conexao = ConexaoBanco.obterConexao();
        String sql = "SELECT m.id, m.nome, m.fabricante_id, f.nome AS nome_fabricante FROM modelo m " +
                     "INNER JOIN fabricante f ON m.fabricante_id = f.id " +
                     "WHERE m.fabricante_id = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setLong(1, idFabricante);
        ResultSet result = statement.executeQuery();

        List<Modelo> listaModelo = new ArrayList<>();

        while (result.next()) {
            Modelo modelo = new Modelo(
                    result.getLong("id"),
                    result.getString("nome"),
                    result.getLong("fabricante_id")
            );
            modelo.setNomeFabricante(result.getString("nome_fabricante")); // Define o nome do fabricante
            listaModelo.add(modelo);
        }

       
        result.close();
        statement.close();
        conexao.close();

        return listaModelo;

    } catch (SQLException ex) {
        System.out.println("Algo deu errado: " + ex.getMessage());
        return null;
    }
}



}
