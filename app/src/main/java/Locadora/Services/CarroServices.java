package Locadora.services;

import Locadora.Model.Carro;
import Locadora.Model.Modelo;
import Locadora.Repository.CarroRepository;
import Locadora.Services.FabricanteServices;
import Locadora.Services.LeituraServices;
import Locadora.Services.ModeloServices;

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
}