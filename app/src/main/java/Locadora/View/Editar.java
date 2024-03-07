/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Locadora.View;

import Locadora.Classe.ConexaoBanco;
import Locadora.Model.Carro;
import Locadora.Model.Fabricante;
import Locadora.Model.Modelo;
import Locadora.Repository.CarroRepository;
import Locadora.Repository.FabricanteRepository;
import Locadora.Repository.ModeloRepository;
import Locadora.Services.ModeloServices;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;



public class Editar extends javax.swing.JFrame {
 private JTable tabelaCarros;
    private CarroRepository carroRepository;
    
        
        
        
        public Editar() {
      initComponents();
    
        carroRepository = new CarroRepository();
        this.tabelaCarros = jTABELA; // Corrigindo para usar jTABELA em minúsculas
        carregarCarros();
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTABELA = new javax.swing.JTable();
        btnCadastrar = new javax.swing.JButton();
        TXTIDCARROPARAEDITAR = new javax.swing.JTextField();
        TXTFABRICANTEIDEDITAR = new javax.swing.JTextField();
        TXTMODELOIDEDITAR = new javax.swing.JTextField();
        TXTANOIDEDITAR = new javax.swing.JTextField();
        TXTCOREDITAR = new javax.swing.JTextField();
        TXTPLACAEDITAR = new javax.swing.JTextField();
        jCheckBoxDisponivel = new javax.swing.JCheckBox();
        jCheckBoxIndisponivel = new javax.swing.JCheckBox();
        TXTVALORLOCACAOEDITAR = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonIDsFabricanteseModelos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTABELA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTABELA);

        btnCadastrar.setText("Editar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        TXTIDCARROPARAEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTIDCARROPARAEDITARActionPerformed(evt);
            }
        });

        jCheckBoxDisponivel.setText("Disponível");

        jCheckBoxIndisponivel.setText("Indisponível");

        jLabel1.setText("ID Carro");

        jLabel2.setText("ID Fabricante");

        jLabel3.setText("ID Modelo");

        jLabel4.setText("Ano");

        jLabel5.setText("Cor");

        jLabel6.setText("Placa");

        jLabel7.setText("Valor");

        jButtonIDsFabricanteseModelos.setText("Lista de ID");
        jButtonIDsFabricanteseModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIDsFabricanteseModelosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TXTIDCARROPARAEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXTFABRICANTEIDEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXTMODELOIDEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonIDsFabricanteseModelos)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TXTANOIDEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TXTCOREDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TXTPLACAEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TXTVALORLOCACAOEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBoxDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBoxIndisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCadastrar)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel5)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(53, 53, 53))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTCOREDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTPLACAEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTANOIDEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTMODELOIDEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTFABRICANTEIDEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTIDCARROPARAEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTVALORLOCACAOEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCadastrar)
                            .addComponent(jButtonIDsFabricanteseModelos)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBoxDisponivel)
                            .addComponent(jCheckBoxIndisponivel))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
                                             
   // Obtenha o índice da linha selecionada na tabela
int selectedRow = tabelaCarros.getSelectedRow();

// Verifique se alguma linha foi selecionada
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Selecione um carro para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
    return;
}

// Obtenha o ID do carro da primeira coluna da linha selecionada
Long carroId = (Long) tabelaCarros.getValueAt(selectedRow, 0);

// Obtenha o novo ID do fabricante diretamente do campo de texto
String fabricanteIdInput = TXTFABRICANTEIDEDITAR.getText();

// Verifique se o campo do ID do fabricante está vazio
if (fabricanteIdInput == null || fabricanteIdInput.trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "ID do fabricante não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
    return;
}

// Converta o ID do fabricante para Long
Long fabricanteId;
try {
    fabricanteId = Long.parseLong(fabricanteIdInput);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "ID do fabricante deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
    return;
}

// Obtenha o novo ID do modelo diretamente do campo de texto
String modeloIdInput = TXTMODELOIDEDITAR.getText();

// Verifique se o campo do ID do modelo está vazio
if (modeloIdInput == null || modeloIdInput.trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "ID do modelo não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
    return;
}

// Converta o ID do modelo para Long
Long modeloId;
try {
    modeloId = Long.parseLong(modeloIdInput);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "ID do modelo deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
    return;
}

// Obtenha os outros dados do carro diretamente dos campos de texto
String placa = TXTPLACAEDITAR.getText();
String cor = TXTCOREDITAR.getText();
Integer ano = Integer.parseInt(TXTANOIDEDITAR.getText());
Double valorLocacao = Double.parseDouble(TXTVALORLOCACAOEDITAR.getText());
Boolean disponivel = jCheckBoxDisponivel.isSelected();

// Crie um objeto Carro com os novos valores
Carro carroEditado = new Carro(carroId, fabricanteId, modeloId, placa, cor, disponivel, ano, valorLocacao);

// Execute a operação de edição
carroRepository.editar(carroEditado);
JOptionPane.showMessageDialog(this, "Carro editado com sucesso!");
carregarCarros();



    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void TXTIDCARROPARAEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTIDCARROPARAEDITARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTIDCARROPARAEDITARActionPerformed

    private void jButtonIDsFabricanteseModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIDsFabricanteseModelosActionPerformed
    String fabricantes = "Lista de Fabricantes:\n";
String modelos = "\nLista de Modelos:\n";

// Consulta para obter os fabricantes
FabricanteRepository fabricanteRepository = new FabricanteRepository();
List<Fabricante> listaFabricantes = fabricanteRepository.consultar();  // Método para consultar todos os fabricantes

// Consulta para obter os modelos
ModeloRepository modeloRepository = new ModeloRepository();
List<Modelo> listaModelos = modeloRepository.consultarTodosmodelos(); // Método para consultar todos os modelos

// Crie um JPanel para organizar os componentes
JPanel panel = new JPanel(new GridLayout(1, 2));

// Crie duas JTextAreas para exibir a lista de fabricantes e modelos
JTextArea fabricantesArea = new JTextArea(10, 20);
fabricantesArea.setEditable(false);
JTextArea modelosArea = new JTextArea(10, 20);
modelosArea.setEditable(false);

// Preencha a JTextArea com os dados dos fabricantes
fabricantesArea.append(fabricantes);
for (Fabricante fabricante : listaFabricantes) {
    fabricantesArea.append(fabricante.getId() + " - " + fabricante.getNome() + "\n");
}

// Preencha a JTextArea com os dados dos modelos
modelosArea.append(modelos);
for (Modelo modelo : listaModelos) {
    modelosArea.append(modelo.getId() + " - " + modelo.getNome() + "\n");
}

// Adicione as JTextAreas em um JScrollPane para permitir a rolagem
JScrollPane fabricantesScrollPane = new JScrollPane(fabricantesArea);
JScrollPane modelosScrollPane = new JScrollPane(modelosArea);

// Adicione os JScrollPanes ao JPanel
panel.add(fabricantesScrollPane);
panel.add(modelosScrollPane);

// Exiba a caixa de diálogo JOptionPane
JOptionPane.showMessageDialog(this, panel, "Lista de Fabricantes e Modelos", JOptionPane.INFORMATION_MESSAGE);

        
        
    }//GEN-LAST:event_jButtonIDsFabricanteseModelosActionPerformed
  private void carregarCarros() {
        DefaultTableModel model = (DefaultTableModel) tabelaCarros.getModel();
        model.setRowCount(0);
        String[] colunas = {"Id do Carro", "Fabricante", "Modelo", "Ano", "Cor", "Placa", "Valor", "Disponível"};
        model.setColumnIdentifiers(colunas);

        try {
            List<Carro> carros = carroRepository.consultarTodos();

            for (Carro carro : carros) {
                String nomeFabricante = obterNomeFabricante(carro.getFabricanteId());
                String nomeModelo = obterNomeModelo(carro.getModeloId());
                Object[] rowData = {
                    carro.getId(),
                    nomeFabricante,
                    nomeModelo,
                    carro.getAno(),
                    carro.getCor(),
                    carro.getPlaca(),
                    carro.getValorLocacao(),
                    carro.getDisponivel() ? "Sim" : "Não"
                };
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar carros: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

private String obterNomeFabricante(Long fabricanteId) throws SQLException {
    String nomeFabricante = null;
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        conexao = ConexaoBanco.obterConexao(); // Obtém a conexão com o banco de dados
        String sql = "SELECT nome FROM fabricante WHERE id = ?";
        stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, fabricanteId);
        rs = stmt.executeQuery();

        if (rs.next()) {
            nomeFabricante = rs.getString("nome");
        }
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conexao != null) {
            conexao.close();
        }
    }

    return nomeFabricante;
}

private String obterNomeModelo(Long modeloId) throws SQLException {
    String nomeModelo = null;
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        conexao = ConexaoBanco.obterConexao(); // Obtém a conexão com o banco de dados
        String sql = "SELECT nome FROM modelo WHERE id = ?";
        stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, modeloId);
        rs = stmt.executeQuery();

        if (rs.next()) {
            nomeModelo = rs.getString("nome");
        }
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conexao != null) {
            conexao.close();
        }
    }

    return nomeModelo;
}



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editar().setVisible(true);
            }
        });
            }
        



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TXTANOIDEDITAR;
    private javax.swing.JTextField TXTCOREDITAR;
    private javax.swing.JTextField TXTFABRICANTEIDEDITAR;
    private javax.swing.JTextField TXTIDCARROPARAEDITAR;
    private javax.swing.JTextField TXTMODELOIDEDITAR;
    private javax.swing.JTextField TXTPLACAEDITAR;
    private javax.swing.JTextField TXTVALORLOCACAOEDITAR;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton jButtonIDsFabricanteseModelos;
    private javax.swing.JCheckBox jCheckBoxDisponivel;
    private javax.swing.JCheckBox jCheckBoxIndisponivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTABELA;
    // End of variables declaration//GEN-END:variables
}
