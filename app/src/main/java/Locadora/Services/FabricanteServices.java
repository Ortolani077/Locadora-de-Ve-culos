package Locadora.Services;

import Locadora.Model.Fabricante;
import Locadora.Repository.FabricanteRepository;
import Locadora.Services.LeituraServices;
import java.sql.Connection;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FabricanteServices {
    
    private final FabricanteRepository fabricanteRepo;
    
    public FabricanteServices() {
        fabricanteRepo = new FabricanteRepository();
    }
    
    public List<String> obterNomesFabricantes() {
    FabricanteRepository fabricanteRepo = new FabricanteRepository();
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
        return new FabricanteRepository().consultar();
        
        
        
        
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
    FabricanteRepository fabricanteRepo = new FabricanteRepository();
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
        // Consulta o repositório para obter a lista de fabricantes
        List<Fabricante> fabricantes = fabricanteRepo.consultar();

        // Cria uma lista para armazenar os nomes dos fabricantes
        List<String> nomesFabricantes = new ArrayList<>();

        // Itera sobre a lista de fabricantes para extrair os nomes
        for (Fabricante fabricante : fabricantes) {
            nomesFabricantes.add(fabricante.getNome());
        }

        // Retorna a lista de nomes dos fabricantes
        return nomesFabricantes;
    }
}
