package Locadora.Services;

import Locadora.Model.Carro;
import Locadora.Model.Fabricante;
import Locadora.services.CarroServices;
import java.util.List;

/**
 *
 * @author Rodrigo Ortolani
 */
class MenuServices {
    public void menuInicial() {
    Long idFabricante = -1L; // Inicializa com -1 para indicar que nenhum fabricante foi selecionado ainda
    
    System.out.println("---- MENU INICIAL ----");
    System.out.println("1 - Lista de Fabricantes e cadastro");
    System.out.println("2 - Lista de modelo e Cadastro");
    System.out.println("3 - Cadastar carros");
    System.out.println("Selecione a opção desejada: ");
    
    String opcao = new LeituraServices().ler();
    
    switch(opcao) {
        case "1":
             new FabricanteServices().consultar();
          
            
            break;
        case "2":
            new ModeloServices().cadastrarModelo();
            
            break;
        case "3":
           
        default:
            System.out.println("Opcao Inválida");
    }
}
}