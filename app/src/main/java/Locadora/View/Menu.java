/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Locadora.View;

import Locadora.Model.Fabricante;
import Locadora.Model.Modelo;
import Locadora.Services.FabricanteServices;
import Locadora.Services.ModeloServices;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo Ortolani
 */
public class Menu extends javax.swing.JFrame {

  private List<String> nomesModelos;
    private List<String> nomesFabricantes;

    public Menu() {
        initComponents();
        this.nomesFabricantes = new FabricanteServices().obterNomesFabricantes();
        this.nomesModelos = new ModeloServices().obterNomesModelos();
    }

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
        BtnCadastroFabricantes = new javax.swing.JButton();
        BTNCadastroModelos = new javax.swing.JButton();
        BTNPAGECADASTARCARROS = new javax.swing.JButton();
        jButtonEDITAR = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnCadastroFabricantes.setText("Cadastro de Fabricantes");
        BtnCadastroFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastroFabricantesActionPerformed(evt);
            }
        });

        BTNCadastroModelos.setText("Cadastro de Modelos");
        BTNCadastroModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCadastroModelosActionPerformed(evt);
            }
        });

        BTNPAGECADASTARCARROS.setText("Cadastrar Veículos");
        BTNPAGECADASTARCARROS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNPAGECADASTARCARROSActionPerformed(evt);
            }
        });

        jButtonEDITAR.setText("Editar Veículos");
        jButtonEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEDITARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnCadastroFabricantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNCadastroModelos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNPAGECADASTARCARROS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEDITAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(BtnCadastroFabricantes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNCadastroModelos)
                .addGap(18, 18, 18)
                .addComponent(BTNPAGECADASTARCARROS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEDITAR)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCadastroFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastroFabricantesActionPerformed
        
         FabricanteServices fabricanteServices = new FabricanteServices();
    
    // Obter os nomes dos fabricantes
    List<String> nomesFabricantes = fabricanteServices.obterNomesFabricantes();
    
    // Verificar se a lista de nomes de fabricantes não está vazia
    if (!nomesFabricantes.isEmpty()) {
        // Criar uma nova instância da tela de cadastro de fabricantes
        CadastroFabricantes cadastroFabricantes = new CadastroFabricantes(nomesFabricantes);
        
        // Tornar a nova janela CadastroFabricantes visível
        cadastroFabricantes.setVisible(true);
        
        // Fechar a janela atual (Menu)
        this.dispose();
    } else {
        // Se a lista de nomes de fabricantes estiver vazia, exibir uma mensagem
        JOptionPane.showMessageDialog(this, "Não há fabricantes disponíveis para cadastro.");
    }

        
        
        
    }//GEN-LAST:event_BtnCadastroFabricantesActionPerformed

    private void BTNCadastroModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCadastroModelosActionPerformed
        
        
        
                                                        
    // Obtém a lista de nomes de modelos
    List<String> nomesModelos = new ModeloServices().obterNomesModelos();

    // Cria uma nova instância da tela CadastroModelos
    CadastroModelos cadastroModelos = new CadastroModelos(nomesModelos);
    
    // Torna a nova janela CadastroModelos visível
    cadastroModelos.setVisible(true);
    
    // Fecha a janela atual (Menu)
    this.dispose();


        
        
        
        
    }//GEN-LAST:event_BTNCadastroModelosActionPerformed

    private void BTNPAGECADASTARCARROSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNPAGECADASTARCARROSActionPerformed
 CadastroVeiculos cadastro = new CadastroVeiculos();
 cadastro.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_BTNPAGECADASTARCARROSActionPerformed

    private void jButtonEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEDITARActionPerformed
      Editar editar = new Editar();
      editar.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButtonEDITARActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNCadastroModelos;
    private javax.swing.JButton BTNPAGECADASTARCARROS;
    private javax.swing.JButton BtnCadastroFabricantes;
    private javax.swing.JButton jButtonEDITAR;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables
public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}
