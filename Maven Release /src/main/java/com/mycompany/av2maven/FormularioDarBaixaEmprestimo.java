/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.av2maven;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import models.Conexao;
import static models.Conexao.Conectar;
import models.Devolucoes;
import models.Emprestimos;
//import models.TableModelDarBaixaEmprestimos;

/**
 *
 * @author pedro
 * Esta é a classe de formulario que abate um emprestimo em curso
 */
public class FormularioDarBaixaEmprestimo extends javax.swing.JFrame {

    
    /**
     * Creates new form FormularioDarBaixaEmprestimo
     */
    public FormularioDarBaixaEmprestimo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxEmprestimosAtivosMembros = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxLivrosdoEmprestimoAtivoS = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(205, 100));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Selecione o emprestimo a ser devolvido:");

        DefaultComboBoxModel g= new DefaultComboBoxModel();
        //TableModelDarBaixaEmprestimos a = new TableModelDarBaixaEmprestimos(jComboBoxEmprestimosAtivosMembros);
        for (int i = 0; i < Conexao.emprestimos.size(); i++) {
            g.addElement(Conexao.emprestimos.get(i).getId_usuario());
        }
        jComboBoxEmprestimosAtivosMembros.setModel(g/*new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" })*/);
        jComboBoxEmprestimosAtivosMembros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEmprestimosAtivosMembrosItemStateChanged(evt);
            }
        });
        jComboBoxEmprestimosAtivosMembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEmprestimosAtivosMembrosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Membro(s) com emprestimo(s) ativo(s):");

        DefaultComboBoxModel h= new DefaultComboBoxModel();
        String membro = (String)jComboBoxEmprestimosAtivosMembros.getSelectedItem();
        for (int i = 0; i < Conexao.emprestimos.size(); i++) {
            if(Conexao.emprestimos.get(i).getId_usuario().contentEquals(membro)){
                h.addElement(Conexao.emprestimos.get(i).getId_livro());
            }
        }
        jComboBoxLivrosdoEmprestimoAtivoS.setModel(h/*new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" })*/);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Livro(s) em emprestimo:");

        jButton1.setText("Confirmar Devolução");
        /*String membroS = (String)jComboBoxEmprestimosAtivosMembros.getSelectedItem();
        String livroS = (String) jComboBoxLivrosdoEmprestimoAtivoS.getSelectedItem();
        Emprestimos a = null;
        for(int i = 0; i < Conexao.emprestimos.size(); i++){

            if((Conexao.emprestimos.get(i).getId_usuario().equals(membroS)) && (Conexao.emprestimos.get(i).getId_livro().equals(livroS))){

                a = Conexao.emprestimos.get(i);
                Conexao.deletarEmprestimo(a);*/

                //tablemodel3.fireTableDataChanged();

                //}

            //}
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxEmprestimosAtivosMembros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxLivrosdoEmprestimoAtivoS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jComboBoxEmprestimosAtivosMembros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxLivrosdoEmprestimoAtivoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
               this.dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxEmprestimosAtivosMembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmprestimosAtivosMembrosActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEmprestimosAtivosMembrosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        String membroS = (String)jComboBoxEmprestimosAtivosMembros.getSelectedItem();
String livroS = (String) jComboBoxLivrosdoEmprestimoAtivoS.getSelectedItem();
Emprestimos a = null;
//Devolucoes b = new Devolucoes();
jComboBoxLivrosdoEmprestimoAtivoS.repaint();
int cont = 0;

for(int i = 0; i < Conexao.emprestimos.size(); i++){
    
    
    
    if((Conexao.emprestimos.get(i).getId_usuario().equals(membroS)) && (Conexao.emprestimos.get(i).getId_livro().equals(livroS)) /*&& !((Conexao.emprestimos.get(i).getData_devolucao()).equals(Conexao.emprestimosAtrasados.get(i).getData_devolucao() ))*/){
        
    a = Conexao.emprestimos.get(i);
    Conexao.deletarEmprestimo(a);
    Conexao.emprestimosAtrasados.clear();
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    int id = a.getId();
    String membro =a.getId_usuario();
    String livro = a.getId_livro();
    String dataDev = sdf.format(new Date());
    
    
     
    
    String INSERIR = "INSERT INTO Devolucoes (membro, livro, data_devolucao) VALUES (?, ?, ?)";
            try{
           Connection conn = Conectar();
            PreparedStatement DevolucoesStatement = conn.prepareStatement(INSERIR);          
            
            DevolucoesStatement.setString(1, membro);
            DevolucoesStatement.setString(2, livro);
            DevolucoesStatement.setString(3, dataDev);
            
                      int res = DevolucoesStatement.executeUpdate();
                      if(res > 0){
                          System.out.println("Devolução cadastrada com Sucesso!");
                          
                            Conexao.membros.clear();
                            Conexao.ImportarMembros();
                           
                          this.dispose();
                          
                      }
            
                DevolucoesStatement.close();
                Conexao.Desconectar(conn);
            }catch(HeadlessException e){
                 JOptionPane.showMessageDialog(null, "Erro ao cadastrar Devolução\nContacte o administrador do Sistema.");
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar Devolução\nContacte o administrador do Sistema.");
        }
    //*********************************************************************************************************
          /*  String UPDATE  = "UPDATE Livros SET situacao_livro = ? WHERE titulo = ?";
            
             try{
             Connection conn = Conectar();
             PreparedStatement upd = conn.prepareStatement(UPDATE);
             upd.setString(1, Conexao.situacao[0]);
             upd.setString(2, Conexao.livros.get(i).getTitulo());
             
             int res = upd.executeUpdate();
             
             upd.close();
             Conexao.Desconectar(conn);
             
             }catch(SQLException e){
                 e.printStackTrace();
             }
             */
         }
            
    
    
    
    Conexao.ImportarDevolucoes();
    //Conexao.devolucoes.add(b);
    this.dispose();
    JOptionPane.showMessageDialog(null, "Devolução Concluida!");
    return;
        
    
    }
    
 


   if(this.isActive()){
for(int i = 0; i < Conexao.emprestimosAtrasados.size(); i++){
    if((Conexao.emprestimosAtrasados.get(i).getId_usuario().equals(Conexao.emprestimosAtrasados.get(i).getId_usuario())) && (Conexao.emprestimos.get(i).getId_livro().equals(Conexao.emprestimosAtrasados.get(i).getId_livro()))){
       
        Conexao.emprestimosAtrasados.clear();
        a = Conexao.emprestimos.get(i);
        Conexao.deletarEmprestimo(a);
    
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int id = a.getId();
   
    String membro =a.getId_usuario();
    String livro = a.getId_livro();
    String dataDev = sdf.format(new Date());
    
    
    String INSERIR = "INSERT INTO Devolucoes (membro, livro, data_devolucao) VALUES (?, ?, ?)";
            try{
           Connection conn = Conectar();
            PreparedStatement DevolucoesStatement = conn.prepareStatement(INSERIR);          
            
            DevolucoesStatement.setString(1, membro);
            DevolucoesStatement.setString(2, livro);
            DevolucoesStatement.setString(3, dataDev);
            
                      int res = DevolucoesStatement.executeUpdate();
                      if(res > 0){
                          System.out.println("Devolução cadastrada com Sucesso!");
                          
                            Conexao.membros.clear();
                            Conexao.ImportarMembros();
                           
                          this.dispose();
                          
                      }
            
                DevolucoesStatement.close();
                Conexao.Desconectar(conn);
            }catch(HeadlessException e){
                 JOptionPane.showMessageDialog(null, "Erro ao cadastrar Devolução\nContacte o administrador do Sistema.");
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar Devolução\nContacte o administrador do Sistema.");
        }
    
     //*********************************************************************************************************
    /*String UPDATE  = "UPDATE Livros SET id_situacao = ? WHERE titulo = ?";
            
             try{
             Connection conn = Conectar();
             PreparedStatement upd = conn.prepareStatement(UPDATE);
             upd.setInt(1, 1);
             upd.setString(2, Conexao.livros.get(i).getTitulo());
             
             int res = upd.executeUpdate();
             
             upd.close();
             Conexao.Desconectar(conn);
             
             }catch(SQLException e){
             }
             
         }*/
            
            
            
    Conexao.ImportarDevolucoes();
    //Conexao.devolucoes.add(b);
        JOptionPane.showMessageDialog(null, "Devolução Concluida!");
    this.dispose();
        return;
    
    
}}
        
               // TODO add your handling code here
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private void jComboBoxEmprestimosAtivosMembrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEmprestimosAtivosMembrosItemStateChanged
             
        //jComboBoxLivrosdoEmprestimoAtivo.setModel();
        /*evt.getSource();*/
        
        DefaultComboBoxModel h= new DefaultComboBoxModel();
        String membro = (String)jComboBoxEmprestimosAtivosMembros.getSelectedItem();
        for (int i = 0; i < Conexao.emprestimos.size(); i++) {
        
            if(Conexao.emprestimos.get(i).getId_usuario().contentEquals(membro)){
                             h.addElement(Conexao.emprestimos.get(i).getId_livro());
            }
        }
        jComboBoxLivrosdoEmprestimoAtivoS.setModel(h);
        
   

// TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEmprestimosAtivosMembrosItemStateChanged

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FormularioDarBaixaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioDarBaixaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioDarBaixaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioDarBaixaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioDarBaixaEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxEmprestimosAtivosMembros;
    private javax.swing.JComboBox<String> jComboBoxLivrosdoEmprestimoAtivoS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
        }
