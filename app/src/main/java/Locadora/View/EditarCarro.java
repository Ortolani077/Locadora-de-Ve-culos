/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Locadora.View;

import Locadora.Model.Carro;
import Locadora.Repository.CarroRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;





public class EditarCarro extends javax.swing.JFrame {

   
     private CarroRepository carroRepository;

    public EditarCarro() throws SQLException {
        initComponents();
        carroRepository = new CarroRepository();
        atualizarListaCarros();
    }

   private void atualizarListaCarros() {
    try {
        List<Carro> carros = carroRepository.listarTodos();
        String[] colunas = {"Placa", "Fabricante", "Modelo", "Ano", "Disponibilidade", "Valor de Locação"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Carro carro : carros) {
            Long idFabricante = carro.getFabricanteId();
            String nomeFabricante = carroRepository.buscarNomeFabricantePorId(idFabricante);

            Long idModelo = carro.getModeloId();
            String nomeModelo = carroRepository.buscarNomeModeloPorId(idModelo);

            String disponibilidade = carro.getDisponivel() != null && carro.getDisponivel() ? "Disponível" : "Indisponível";
            String valorLocacao = carro.getValorLocacao() != null ? String.valueOf(carro.getValorLocacao()) : "N/A";

            Object[] linha = {carro.getPlaca(), nomeFabricante, nomeModelo, carro.getAno(), disponibilidade, valorLocacao};
            model.addRow(linha);
        }

        tabelaCarros.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao recuperar a lista de carros: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTNEDITAR = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCarros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BTNEDITAR.setText("Editar");
        BTNEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEDITARActionPerformed(evt);
            }
        });

        tabelaCarros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaCarros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(BTNEDITAR))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(BTNEDITAR)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void BTNEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEDITARActionPerformed
      
 int selectedRow = tabelaCarros.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um carro para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

  String carroIdStr = (String) tabelaCarros.getValueAt(selectedRow, 0);
Long carroId = Long.parseLong(carroIdStr);

String nomeFabricante = (String) tabelaCarros.getValueAt(selectedRow, 1);
String nomeModelo = (String) tabelaCarros.getValueAt(selectedRow, 2);
String placa = (String) tabelaCarros.getValueAt(selectedRow, 3);
Integer ano = (Integer) tabelaCarros.getValueAt(selectedRow, 4);
String disponibilidadeStr = (String) tabelaCarros.getValueAt(selectedRow, 5);
boolean disponibilidade = "Disponível".equals(disponibilidadeStr);

String valorLocacaoStr = (String) tabelaCarros.getValueAt(selectedRow, 6);
double valorLocacao;
if ("N/A".equals(valorLocacaoStr)) {
    valorLocacao = 0.0; // Ou outro valor padrão, caso necessário
} else {
    valorLocacao = Double.parseDouble(valorLocacaoStr);
}

    // Mostrar o JOptionPane para edição
    String novoPlaca = JOptionPane.showInputDialog(this, "Placa:", placa);
    String novoNomeFabricante = JOptionPane.showInputDialog(this, "Nome do Fabricante:", nomeFabricante);
    String novoNomeModelo = JOptionPane.showInputDialog(this, "Nome do Modelo:", nomeModelo);
    String novoAnoStr = JOptionPane.showInputDialog(this, "Ano:", ano);
    Integer novoAno = Integer.parseInt(novoAnoStr);
    String novaDisponibilidade = JOptionPane.showInputDialog(this, "Disponibilidade:", disponibilidade);
    String novoValorLocacaoStr = JOptionPane.showInputDialog(this, "Valor de Locação:", valorLocacaoStr);
    Double novoValorLocacao = Double.parseDouble(novoValorLocacaoStr);

    Long fabricanteId = null;
    Long modeloId = null;

    fabricanteId = carroRepository.obterIdFabricantePeloNome(novoNomeFabricante);
    try {
        modeloId = carroRepository.obterIdModeloPeloNome(novoNomeModelo);
    } catch (SQLException ex) {
        Logger.getLogger(EditarCarro.class.getName()).log(Level.SEVERE, null, ex);
    }

    // Criando um novo objeto Carro com os dados atualizados
    Carro carroEditado = new Carro();
    carroEditado.setId(carroId);
    carroEditado.setFabricanteId(fabricanteId);
    carroEditado.setModeloId(modeloId);
    carroEditado.setPlaca(novoPlaca);
    carroEditado.setAno(novoAno);
    carroEditado.setDisponivel("Disponível".equals(novaDisponibilidade));
    carroEditado.setValorLocacao(novoValorLocacao);

    // Salvando as alterações no banco de dados
    carroRepository.editarCarro(carroEditado);

    // Atualizando a lista de carros na tabela
    atualizarListaCarros();

    // Exibindo uma mensagem de sucesso
    JOptionPane.showMessageDialog(this, "Carro editado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

}                               

    public static void main(String args[]) {
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
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(EditarCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(EditarCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(EditarCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(EditarCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                new EditarCarro().setVisible(true);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(EditarCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    });
            
    }//GEN-LAST:event_BTNEDITARActionPerformed
   
    /**
     * @param args the command line arguments
     */
    
    
    
   

    
    
       

        /* Create and display the form */
      
        
                
                
                

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNEDITAR;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaCarros;
    // End of variables declaration//GEN-END:variables
}
