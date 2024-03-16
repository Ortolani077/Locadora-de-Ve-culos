/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Locadora.View;

import Locadora.Model.Carro;
import Locadora.Model.Fabricante;
import Locadora.Model.Modelo;
import Locadora.Repository.CarroRepository;
import Locadora.Services.ChartFrame;
import Locadora.Services.FabricanteServices;
import Locadora.Services.ModeloServices;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Rodrigo Ortolani
 */
public class Menu extends javax.swing.JFrame {

  private List<String> nomesModelos;
    private List<String> nomesFabricantes;

   public Menu() {
       initComponents();
       setBackgroundImage(); // Configura a imagem de fundo
       createMenuBar();
           setLocationRelativeTo(null); // Define a posição da janela para o centro da tela
        setResizable(false);
      ;
    }


   


    // Menu de Operações
    JMenu menuOperacoes = new JMenu("Operações");

    private void createMenuBar() {
    JMenuBar menuBar = new JMenuBar();

    // Cria o menu "Cadastro"
    JMenu menuCadastro = new JMenu("Cadastro");

    JMenuItem itemCadastroFabricantes = new JMenuItem("Cadastrar Fabricantes");
    JMenuItem itemCadastroModelos = new JMenuItem("Cadastrar Modelos");
    JMenuItem itemCadastrarVeiculos = new JMenuItem("Cadastrar Veículos");

    // Adiciona os itens de menu ao menu "Cadastro"
    menuCadastro.add(itemCadastroFabricantes);
    menuCadastro.add(itemCadastroModelos);
    menuCadastro.add(itemCadastrarVeiculos);

    // Cria o menu "Operações"
    JMenu menuOperacoes = new JMenu("Operações");

    JMenuItem itemEditarVeiculos = new JMenuItem("Editar Veículos");
    JMenuItem itemEditarFabricantes = new JMenuItem("Editar Fabricantes");
    JMenuItem itemDeletarFabricantes = new JMenuItem("Deletar Fabricantes"); // Novo item para deletar fabricantes
    JMenuItem itemGerarGrafico = new JMenuItem("Gerar Gráfico");

    // Adiciona os itens de menu ao menu "Operações"
    menuOperacoes.add(itemEditarVeiculos);
    menuOperacoes.add(itemEditarFabricantes);
    menuOperacoes.add(itemDeletarFabricantes); // Adiciona o item do menu para deletar fabricantes
    menuOperacoes.add(itemGerarGrafico);

    // Adicionando menus à barra de menus
    menuBar.add(menuCadastro);
    menuBar.add(menuOperacoes);

    // Configurando a barra de menus
    setJMenuBar(menuBar);
    
    // Adicionando ouvintes de eventos aos itens do menu
    itemCadastroFabricantes.addActionListener(evt -> abrirTelaCadastroFabricantes());
    itemCadastroModelos.addActionListener(evt -> abrirTelaCadastroModelos());
    itemCadastrarVeiculos.addActionListener(evt -> abrirTelaCadastrarVeiculos());
    itemEditarVeiculos.addActionListener(evt -> {
        try {
            abrirTelaEditarVeiculos();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    itemEditarFabricantes.addActionListener(evt -> abrirTelaEditarFabricantes());
    itemDeletarFabricantes.addActionListener(evt -> abrirTelaDeletarFabricantes()); // Novo listener para deletar fabricantes
    itemGerarGrafico.addActionListener(evt -> gerarGrafico()); // Ouvinte para o item Gerar Gráfico
}
    
    private void abrirTelaDeletarFabricantes() {
    DeletarFabricante telaDeletarFabricantes = new DeletarFabricante();
    telaDeletarFabricantes.setVisible(true);
}

    
private void abrirTelaEditarFabricantes() {
    // Implemente aqui a lógica para abrir a tela de edição de fabricantes
    EditarFabricante editarFabricante = new EditarFabricante();
    editarFabricante.setVisible(true);
    this.dispose(); // Fecha a janela atual
}


// Método para gerar o gráfico
private void gerarGrafico() {
    try {
        CarroRepository carroRepository = new CarroRepository();
        List<Carro> carros = carroRepository.listarTodos();
        DefaultPieDataset dataset = ChartFrame.criarDataset(carros); // Criar o conjunto de dados para o gráfico
        ChartFrame frame = new ChartFrame(dataset); // Criar a janela do gráfico
        frame.setVisible(true); // Exibir a janela do gráfico
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

// Métodos para abrir as telas correspondentes aos itens do menu
private void abrirTelaCadastroFabricantes() {
    CadastroFabricantes fabricantes = new CadastroFabricantes(nomesFabricantes);
    fabricantes.setVisible(true);
    
    this.dispose();
    // Exemplo: CadastroFabricantes telaCadastroFabricantes = new CadastroFabricantes();
    // telaCadastroFabricantes.setVisible(true);
}

private void abrirTelaCadastroModelos() {
    CadastroModelos modelos = new CadastroModelos(nomesFabricantes);
    modelos.setVisible(true);
    
    this.dispose();
}

private void abrirTelaCadastrarVeiculos() {
    CadastroVeiculos veiculos = new CadastroVeiculos();
    veiculos.setVisible(true);
    
    this.dispose();
}

private void abrirTelaEditarVeiculos() throws SQLException {
    EditarCarro editar = new EditarCarro();
    editar.setVisible(true);
    this.dispose();
    
}

      /** This method is called from within the constructor to
       * initialize the form.
       * WARNING: Do NOT modify this code. The content of this method is
       * always regenerated by the Form Editor.
       */
      /** This method is called from within the constructor to
       * initialize the form.
       * WARNING: Do NOT modify this code. The content of this method is
       * always regenerated by the Form Editor.
       */        
    


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    
    
    
    
    
   
    
    
    
  private void setBackgroundImage() {
    // Caminho absoluto para a imagem
    String imagePath = "C:\\Users\\Rodrigo Ortolani\\Documents\\NetBeansProjects\\Locadora-de-Ve-culos-main\\app\\src\\main\\java\\Locadora\\View\\Imagens\\locadora.png";
    
    // Cria um objeto ImageIcon com a imagem
    ImageIcon icon = new ImageIcon(imagePath);
    
    // Cria um JLabel para exibir a imagem
    JLabel label = new JLabel(icon);
    
    // Define o tamanho do JLabel como o tamanho do JFrame
    label.setBounds(0, 0, getWidth(), getHeight());
    
    // Adiciona o JLabel ao JFrame
    add(label);
}


    public static void main(String[] args) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
        Menu menu = new Menu();
        
        // Define a posição da janela para o centro da tela
        menu.setLocationRelativeTo(null);
        
        // Impede o redimensionamento da janela
        menu.setResizable(false);
        
        menu.setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables

    
    
    
    
    
    
    
}
