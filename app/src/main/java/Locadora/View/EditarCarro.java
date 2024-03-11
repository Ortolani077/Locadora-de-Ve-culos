/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Locadora.View;

import Locadora.Model.Carro;
import Locadora.Repository.CarroRepository;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;





public class EditarCarro extends javax.swing.JFrame {

   
     private CarroRepository carroRepository;

   public EditarCarro() throws SQLException {
        initComponents();
        carroRepository = new CarroRepository();
        atualizarListaCarros();
         
        setLocationRelativeTo(null); // Define a posição da janela para o centro da tela
        setResizable(false);
    
        setBackgroundImage(); 

        // Chame o método de personalização das JLabels
        personalizeJLabels();
    }

  String[] colunas = {"ID Carro", "Fabricante ID", "Fabricante", "Modelo ID", "Modelo", "Ano", "Cor", "Placa", "Valor", "Disponível"};

// Atualize a lista de carros para incluir as novas informações
  
  
  
  

public class JLabelCustomizer {
    public static void customize(JLabel label) {
        // Cor de fundo e borda arredondada
        label.setOpaque(true);
        label.setBackground(new Color(70, 130, 180)); // Cor azul claro
        label.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(1, 1, 1), 1), // Borda escura
            BorderFactory.createEmptyBorder(1, 1, 1, 1) // Preenchimento interno
        ));
        // Cor do texto e estilo da fonte
        label.setForeground(Color.WHITE); // Texto branco
        label.setFont(new Font("Arial", Font.BOLD, 12)); // Fonte Arial, negrito, tamanho 12
    }
}

  private void personalizeJLabels() {
        JLabel[] labels = {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7};

        for (JLabel label : labels) {
            JLabelCustomizer.customize(label);
        }
    }
  
  
  
private void atualizarListaCarros() {
    try {
        List<Carro> carros = carroRepository.listarTodos();
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

      for (Carro carro : carros) {
    Long idFabricante = carro.getFabricanteId();
    String nomeFabricante = carroRepository.buscarNomeFabricantePorId(idFabricante);

    Long idModelo = carro.getModeloId();
    String nomeModelo = carroRepository.buscarNomeModeloPorId(idModelo);

    // Converter o valor booleano para "Disponível" ou "Indisponível"
    String disponibilidade = carro.getDisponivel() ? "Disponível" : "Indisponível";

    Object[] linha = {
        carro.getId(), 
        idFabricante, 
        nomeFabricante, 
        idModelo, 
        nomeModelo, 
        carro.getAno(), 
        carro.getCor(), 
        carro.getPlaca(), 
        carro.getValorLocacao(), 
        disponibilidade // Aqui definimos a disponibilidade como "Disponível" ou "Indisponível"
    };
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
        jTextFieldIDASEREDITADO = new javax.swing.JTextField();
        NOVOFABRICANTEID = new javax.swing.JTextField();
        jTextField3NOVOMODELOID = new javax.swing.JTextField();
        jTextField4NOVOANO = new javax.swing.JTextField();
        jTextField5NOVACOR = new javax.swing.JTextField();
        jTextField6NOVAPLACA = new javax.swing.JTextField();
        jTextField7NOVOVALOR = new javax.swing.JTextField();
        checkbox1DISPONIVEL = new java.awt.Checkbox();
        checkbox2INDISPONIVEL = new java.awt.Checkbox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        jTextFieldIDASEREDITADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDASEREDITADOActionPerformed(evt);
            }
        });

        NOVOFABRICANTEID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOVOFABRICANTEIDActionPerformed(evt);
            }
        });

        jTextField5NOVACOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5NOVACORActionPerformed(evt);
            }
        });

        checkbox1DISPONIVEL.setLabel("Disponível");

        checkbox2INDISPONIVEL.setLabel("Indisponível");

        jLabel1.setText("ID p/editar");

        jLabel2.setText("Novo Fab.ID");

        jLabel3.setText("Novo mod.ID");

        jLabel4.setText("Ano");

        jLabel5.setText("Cor");

        jLabel6.setText("Placa");

        jLabel7.setText("Valor");

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkbox1DISPONIVEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(checkbox2INDISPONIVEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIDASEREDITADO, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(NOVOFABRICANTEID, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField3NOVOMODELOID)
                        .addComponent(BTNEDITAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4NOVOANO, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5NOVACOR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6NOVAPLACA, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7NOVOVALOR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(114, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIDASEREDITADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NOVOFABRICANTEID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3NOVOMODELOID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5NOVACOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6NOVAPLACA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7NOVOVALOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4NOVOANO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkbox1DISPONIVEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkbox2INDISPONIVEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BTNEDITAR)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    private void setBackgroundImage() {
    // Caminho absoluto para a imagem
    String imagePath = "C:\\Users\\Rodrigo Ortolani\\Documents\\NetBeansProjects\\Locadora-de-Ve-culos-main\\app\\src\\main\\java\\Locadora\\View\\Imagens\\editar.jpg";


    try {
        // Carrega a imagem
        Image image = new ImageIcon(imagePath).getImage();

        // Verifica se a imagem foi carregada corretamente
        if (image != null) {
            // Redimensiona a imagem para caber no JFrame
            int contentWidth = getContentPane().getWidth();
            int contentHeight = getContentPane().getHeight();
            Image scaledImage = image.getScaledInstance(contentWidth, contentHeight, Image.SCALE_SMOOTH);

            // Cria um ImageIcon com a imagem redimensionada
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Cria um JLabel para exibir a imagem
            JLabel backgroundLabel = new JLabel(scaledIcon);
            backgroundLabel.setBounds(0, 0, contentWidth, contentHeight);

            // Adiciona o JLabel ao content pane do JFrame
            getContentPane().add(backgroundLabel);

            // Revalida e redesenha o content pane do JFrame para garantir que as mudanças sejam aplicadas
            revalidate();
            repaint();
        } else {
            System.err.println("Erro ao carregar a imagem: " + imagePath);
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Erro ao carregar a imagem: " + imagePath);
    }
}
    
    
    
    
    
    
    
    private void BTNEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEDITARActionPerformed
      Carro carro = new Carro();
  int selectedRow = tabelaCarros.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um carro para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obter os valores dos campos de texto e das caixas de seleção
    Long carroId = Long.parseLong(jTextFieldIDASEREDITADO.getText());
    Long fabricanteId = Long.parseLong(NOVOFABRICANTEID.getText());
    Long modeloId = Long.parseLong(jTextField3NOVOMODELOID.getText());
    Integer ano = Integer.parseInt(jTextField4NOVOANO.getText());
String cor = jTextField5NOVACOR.getText();
if (cor.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Por favor, preencha o campo 'Cor'.", "Erro", JOptionPane.ERROR_MESSAGE);
    return; // Retorna sem tentar editar o carro se o campo estiver vazio
}

    String placa = jTextField6NOVAPLACA.getText();
    Double valorLocacao = Double.parseDouble(jTextField7NOVOVALOR.getText());
    boolean disponibilidade = checkbox1DISPONIVEL.getState();

// Criando um novo objeto Carro com os dados atualizados
Carro carroEditado = new Carro();
carroEditado.setId(carroId);
carroEditado.setFabricanteId(fabricanteId);
carroEditado.setModeloId(modeloId);
carroEditado.setPlaca(placa);
carroEditado.setAno(ano);
carroEditado.setDisponivel(disponibilidade);
carroEditado.setValorLocacao(valorLocacao);
carroEditado.setCor(cor); // Definindo a cor do carro

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

    private void jTextFieldIDASEREDITADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDASEREDITADOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDASEREDITADOActionPerformed

    private void NOVOFABRICANTEIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOVOFABRICANTEIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NOVOFABRICANTEIDActionPerformed

    private void jTextField5NOVACORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5NOVACORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5NOVACORActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
   
    /**
     * @param args the command line arguments
     */
    
    
    
   

    
    
       

        /* Create and display the form */
      
        
                
                
                

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNEDITAR;
    private javax.swing.JTextField NOVOFABRICANTEID;
    private java.awt.Checkbox checkbox1DISPONIVEL;
    private java.awt.Checkbox checkbox2INDISPONIVEL;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3NOVOMODELOID;
    private javax.swing.JTextField jTextField4NOVOANO;
    private javax.swing.JTextField jTextField5NOVACOR;
    private javax.swing.JTextField jTextField6NOVAPLACA;
    private javax.swing.JTextField jTextField7NOVOVALOR;
    private javax.swing.JTextField jTextFieldIDASEREDITADO;
    private javax.swing.JTable tabelaCarros;
    // End of variables declaration//GEN-END:variables
}
