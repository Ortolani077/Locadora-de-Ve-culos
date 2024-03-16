package Locadora.Services;

import Locadora.Classe.ConexaoBanco;
import Locadora.Model.Carro;
import Locadora.Model.Fabricante;
import Locadora.Repository.CarroRepository;
import Locadora.Repository.FabricanteRepository;
import Locadora.Services.LeituraServices;
import Locadora.View.DeletarFabricante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FabricanteServices {
    private final CarroRepository carroRepository;
    private final FabricanteRepository fabricanteRepo;
    private final FabricanteRepository fabricanteRepository;   

    public FabricanteServices() {
        this.carroRepository = new CarroRepository();
        this.fabricanteRepo = new FabricanteRepository();
        this.fabricanteRepository = new FabricanteRepository();
    }
    
    public List<String> obterNomesFabricantes() {
        List<Fabricante> fabricantes = fabricanteRepo.consultar();
        List<String> nomesFabricantes = new ArrayList<>();

        for (Fabricante fabricante : fabricantes) {
            nomesFabricantes.add(fabricante.getNome());
        }

        return nomesFabricantes;
    }

    private Connection connection;
    private LeituraServices leituraServices;

    public List<Fabricante> consultar() {
        return fabricanteRepo.consultar();
    }

    public Long selecionar() {
        List<Fabricante> listaFabricante = consultar();

        System.out.println("Lista Fabricantes");
        System.out.println("________________________________");

        List<Long> idsFabricantes = new ArrayList<>();

        for (Fabricante fabricante : listaFabricante) {
            System.out.println(fabricante.toString());
            idsFabricantes.add(fabricante.getId());
        }

        System.out.println("________________________________");

        System.out.println("Selecione o fabricante do carro: ");

        Long idFabricante = 0L;

        try {
            idFabricante = Long.parseLong(new LeituraServices().ler());

        } catch (Exception ex) {
            System.out.println("OPCAO INVALIDA");
            return -1L;
        }

        if (!idsFabricantes.contains(idFabricante)) {
            System.out.println("OPCAO INVALIDA");
            return -1L;
        }

        return idFabricante;
    }

    public void cadastrarFabricante(String nomeFabricante) {
        System.out.println("Nome do fabricante: " + nomeFabricante); // Mostra o nome do fabricante digitado
        fabricanteRepo.salvar(nomeFabricante);
        
        System.out.println("Fabricante cadastrado com sucesso!");
    }

    public void mostrarListaFabricantes() {
        List<Fabricante> listaFabricantes = consultar();

        System.out.println("Lista de Fabricantes:");
        System.out.println("________________________________");

        for (Fabricante fabricante : listaFabricantes) {
            System.out.println(fabricante);
        }

        System.out.println("________________________________");
    }

    public List<String> obterNomesFabricantesString() {
        List<Fabricante> fabricantes = fabricanteRepo.consultar();
        List<String> nomesFabricantes = new ArrayList<>();

        for (Fabricante fabricante : fabricantes) {
            nomesFabricantes.add(fabricante.getNome());
        }

        return nomesFabricantes;
    }

    public void editarFabricante(Fabricante fabricante) {
        String updateFabricante = "UPDATE fabricante SET nome = ? WHERE nome = ?";

        try (Connection connection = ConexaoBanco.obterConexao();
             PreparedStatement statement = connection.prepareStatement(updateFabricante)) {
            
            // Define o novo nome do fabricante
            statement.setString(1, fabricante.getNovoNome());
            
            // Define o nome original do fabricante para a cláusula WHERE
            statement.setString(2, fabricante.getNome());

            // Executa a atualização
            statement.executeUpdate();
            System.out.println("Fabricante editado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao editar o fabricante: " + ex.getMessage());
        }
    }

     


    // Método para verificar se há modelos associados ao fabricante
    private boolean verificarModelosAssociados(long idFabricante) {
        return fabricanteRepo.verificarModelosAssociados(idFabricante);
    }

    // Método para excluir os modelos associados ao fabricante
    private void excluirModelosDoFabricante(long idFabricante) {
        fabricanteRepo.excluirModelosDoFabricante(idFabricante);
    }

    // Método para excluir os carros associados aos modelos do fabricante
    private void excluirCarrosDosModelosDoFabricante(long idFabricante) {
        fabricanteRepo.excluirCarrosDosModelosDoFabricante(idFabricante);
    }

    public long obterIdFabricantePorNome(String nomeFabricante) {
        // Consulta o repositório para obter o ID do fabricante pelo nome
        Fabricante fabricante = (Fabricante) fabricanteRepo.consultar();
        // Verifica se o fabricante foi encontrado
        if (fabricante != null) {
            // Retorna o ID do fabricante encontrado
            return fabricante.getId();
        } else {
            // Retorna -1 se o fabricante não foi encontrado
            return -1;
        }
    }

public void deletarFabricante(long idFabricante) {
    // Verifica se há modelos associados ao fabricante
    if (verificarModelosAssociados(idFabricante)) {
        // Se houver, exclua esses modelos primeiro
        excluirModelosDoFabricante(idFabricante);
    }

    // Verifica se há carros associados ao fabricante
    boolean carrosAssociados = verificarCarrosAssociados(idFabricante);
    if (carrosAssociados) {
        System.out.println("Não é possível excluir o fabricante, pois há carros associados.");
        return;
    }

    // Cria um objeto Fabricante com o ID fornecido
    Fabricante fabricante = new Fabricante();
    fabricante.setId(idFabricante);

    // Agora podemos excluir o fabricante
    fabricanteRepository.deletarFabricante(fabricante);
}


// Método para verificar se há carros associados ao fabricante
private boolean verificarCarrosAssociados(long idFabricante) {
    String modelo = carroRepository.buscarNomeModeloPorId(idFabricante);
    return modelo != null && !modelo.isEmpty();
}


private void excluirCarrosDoFabricante(Long idFabricante) throws SQLException {
    
    List<Carro> carros = carroRepository.listarTodos();

    for (Carro carro : carros) {
        if (carro.getFabricanteId().equals(idFabricante)) {
            carroRepository.excluirCarro(carro.getId());
            System.out.println("Carro associado ao fabricante excluído: " + carro.getPlaca());
        }
    }
}

public long obterIdFabricantePorNomedelete(String nomeFabricante) {
    // Consulta o repositório para obter o ID do fabricante pelo nome
    List<Fabricante> fabricantes = fabricanteRepo.consultar();
    
    // Procura pelo fabricante com o nome especificado na lista de fabricantes
    for (Fabricante fabricante : fabricantes) {
        if (fabricante.getNome().equals(nomeFabricante)) {
            // Retorna o ID do fabricante encontrado
            return fabricante.getId();
        }
    }
    
    // Retorna -1 se o fabricante não foi encontrado
    return -1;
}



}

   

