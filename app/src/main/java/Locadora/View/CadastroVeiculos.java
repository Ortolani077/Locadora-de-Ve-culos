/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Locadora.View;

import Locadora.Model.Carro;
import Locadora.Model.Fabricante;
import Locadora.Model.Modelo;
import Locadora.Services.FabricanteServices;
import Locadora.Services.ModeloServices;
import Locadora.services.CarroServices;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * 
 */
public class CadastroVeiculos extends javax.swing.JFrame {
        private List<Modelo> modelos;
   private List<Fabricante> fabricantes;
 
    private Long idModeloSelecionado;
    private Long idFabricanteSelecionado;

      public CadastroVeiculos() {
        initComponents();
        preencherListas();
    }

    private void preencherListas() {
        // Preencher lista de modelos
        ModeloServices modeloServices = new ModeloServices();
        modelos = modeloServices.consultarTodosmodelos();
        DefaultListModel<String> modelosListModel = new DefaultListModel<>();
        for (Modelo modelo : modelos) {
            modelosListModel.addElement(modelo.getNome());
        }
        Listademodelos.setModel(modelosListModel);

        // Preencher lista de fabricantes
        FabricanteServices fabricanteServices = new FabricanteServices();
        fabricantes = fabricanteServices.consultar();
        DefaultListModel<String> fabricantesListModel = new DefaultListModel<>();
        for (Fabricante fabricante : fabricantes) {
            fabricantesListModel.addElement(fabricante.getNome());
        }
        ListadeFabricantes.setModel(fabricantesListModel);

        // Adicionar evento de seleção de fabricante
    ListadeFabricantes.addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedIndex = ListadeFabricantes.getSelectedIndex();
            if (selectedIndex != -1) {
                idFabricanteSelecionado = fabricantes.get(selectedIndex).getId();
                System.out.println("ID do Fabricante Selecionado: " + idFabricanteSelecionado); // Adicionando essa linha para verificar o ID do fabricante selecionado
            }
        }
    }
});


        // Adicionar evento de seleção de modelo
       Listademodelos.addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedIndex = Listademodelos.getSelectedIndex();
            if (selectedIndex != -1) {
                idModeloSelecionado = modelos.get(selectedIndex).getId();
                System.out.println("ID do Modelo Selecionado: " + idModeloSelecionado); // Adicionando essa linha para verificar o ID do modelo selecionado
            }
        }
    }
});    }
        
        
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListadeFabricantes = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Listademodelos = new javax.swing.JList<>();
        jTextAno = new javax.swing.JTextField();
        jTextField2Cor = new javax.swing.JTextField();
        jTextField3Placa = new javax.swing.JTextField();
        jTextField1ValorLocacao = new javax.swing.JTextField();
        checkbox1Disponivel = new java.awt.Checkbox();
        checkbox2NaoDisponivel = new java.awt.Checkbox();
        jButton1CadastrarNoBancodeDados = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ListadeFabricantes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListadeFabricantes);

        Listademodelos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(Listademodelos);

        jTextAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAnoActionPerformed(evt);
            }
        });

        jTextField2Cor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2CorActionPerformed(evt);
            }
        });

        jTextField3Placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3PlacaActionPerformed(evt);
            }
        });

        checkbox1Disponivel.setLabel("Disponível");

        checkbox2NaoDisponivel.setLabel("Indisponível");

        jButton1CadastrarNoBancodeDados.setText("Cadastrar");
        jButton1CadastrarNoBancodeDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1CadastrarNoBancodeDadosActionPerformed(evt);
            }
        });

        jButton1.setText("Menu Principal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ano:");

        jLabel2.setText("Cor:");

        jLabel3.setText("Placa:");

        jLabel4.setText("Valor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkbox1Disponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextAno, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2Cor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3Placa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1ValorLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1CadastrarNoBancodeDados)
                            .addComponent(checkbox2NaoDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2Cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3Placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1ValorLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkbox1Disponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkbox2NaoDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1CadastrarNoBancodeDados)
                        .addContainerGap(37, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// </editor-fold>                        

    // TODO add your handling code here:


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> {
            new CadastroVeiculos().setVisible(true);
        });
       
    
       java.awt.EventQueue.invokeLater(() -> {
            new CadastroVeiculos().setVisible(true);
        });
       
       
       
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroVeiculos().setVisible(true);
            }
        });
}

    private void jTextAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAnoActionPerformed
      
    }//GEN-LAST:event_jTextAnoActionPerformed

    private void jButton1CadastrarNoBancodeDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1CadastrarNoBancodeDadosActionPerformed
     
  int fabricanteIndex = ListadeFabricantes.getSelectedIndex();
    int modeloIndex = Listademodelos.getSelectedIndex();
    
    // Verifica se ambos os índices são válidos
    if (fabricanteIndex == -1 || modeloIndex == -1) {
        JOptionPane.showMessageDialog(null, "Por favor, selecione um fabricante e um modelo.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Obtém os IDs dos fabricantes e modelos selecionados
    idFabricanteSelecionado = fabricantes.get(fabricanteIndex).getId();
    idModeloSelecionado = modelos.get(modeloIndex).getId();
    
    // Obtém os valores dos campos da interface do usuário
    String anoStr = jTextAno.getText();
    String cor = jTextField2Cor.getText();
    String placa = jTextField3Placa.getText();
    String valorStr = jTextField1ValorLocacao.getText();
    boolean disponivel = checkbox1Disponivel.getState();
    
    // Verifica se os campos de ano e valor estão preenchidos
    if (anoStr.isEmpty() || valorStr.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, preencha o ano e o valor de locação.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Converte os valores de ano e valor para os tipos corretos
    int ano;
    double valor;
    try {
        ano = Integer.parseInt(anoStr);
        valor = Double.parseDouble(valorStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos válidos para o ano e o valor de locação.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Cria uma instância de Carro com os valores obtidos
    Carro novoCarro = new Carro();
    novoCarro.setAno(ano);
    novoCarro.setCor(cor);
    novoCarro.setPlaca(placa);
    novoCarro.setValorLocacao(valor);
    novoCarro.setDisponivel(disponivel);
    novoCarro.setFabricanteId(idFabricanteSelecionado);
    novoCarro.setModeloId(idModeloSelecionado);

    // Crie uma instância de CarroServices
    CarroServices carroServices = new CarroServices();
    // Chame o método salvar, passando o novo carro como parâmetro
    carroServices.salvar(novoCarro);

    JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);





    }//GEN-LAST:event_jButton1CadastrarNoBancodeDadosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu menu = new Menu();

        // Tornar a instância do menu visível
        menu.setVisible(true);

        // Fechar a janela atual
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3PlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3PlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3PlacaActionPerformed

    private void jTextField2CorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2CorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2CorActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListadeFabricantes;
    private javax.swing.JList<String> Listademodelos;
    private java.awt.Checkbox checkbox1Disponivel;
    private java.awt.Checkbox checkbox2NaoDisponivel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1CadastrarNoBancodeDados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextAno;
    private javax.swing.JTextField jTextField1ValorLocacao;
    private javax.swing.JTextField jTextField2Cor;
    private javax.swing.JTextField jTextField3Placa;
    // End of variables declaration//GEN-END:variables

    
}
