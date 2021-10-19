/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.av2maven;

import java.awt.event.KeyEvent;
import models.Conexao;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.Administradores;
import static models.Conexao.Conectar;
import static models.Conexao.Desconectar;
import static models.Conexao.administradores;
import models.TableModelLivros;

/**
 *
 * @author pedro
 * Tela de inicio
 */
public class TelaInicial extends javax.swing.JFrame {

    
    //String login = "";
   // String senha= "";
    
    
    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1_Login = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        b_entrar = new javax.swing.JButton();
        jPasswordField1_Senha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bem Vindo! - Biblioteca ");
        setLocation(new java.awt.Point(200, 200));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            //String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"};
            public int getSize() { return Conexao.livros.size(); }
            public String getElementAt(int i) { return Conexao.livros.get(i).getTitulo(); }
        });
        jList1.setDoubleBuffered(true);
        jList1.setMinimumSize(null);
        jScrollPane1.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Sistema Biblioteca");
        jLabel1.setToolTipText("");
        jLabel1.setDoubleBuffered(true);
        jLabel1.setMinimumSize(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Livros Cadastrados :");
        jLabel2.setDoubleBuffered(true);
        jLabel2.setMinimumSize(null);

        //login = jTextField1_Login.getText();
        //System.out.println(login);
        jTextField1_Login.setDoubleBuffered(true);
        jTextField1_Login.setMinimumSize(null);
        jTextField1_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_LoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Login : ");
        jLabel3.setDoubleBuffered(true);
        jLabel3.setMinimumSize(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Senha : ");

        b_entrar.setBackground(new java.awt.Color(102, 51, 255));
        b_entrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        b_entrar.setMnemonic(KeyEvent.VK_ENTER);
        b_entrar.setText("Entrar");
        b_entrar.setDoubleBuffered(true);
        b_entrar.setMinimumSize(null);
        b_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_entrarActionPerformed(evt);
            }
        });

        //senha = jPasswordField1_Senha.getSelectedText();
        jPasswordField1_Senha.setDoubleBuffered(true);
        jPasswordField1_Senha.setMinimumSize(null);
        jPasswordField1_Senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1_SenhaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(243, 208, 208));
        jButton1.setText("Sair");
        jButton1.setDoubleBuffered(true);
        jButton1.setMinimumSize(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(426, 426, 426))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jPasswordField1_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(57, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordField1_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(b_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1_SenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1_SenhaActionPerformed
        /*JPasswordField a = (JPasswordField)evt.getSource();
        char[] cSenha = a.getPassword();
        String s = new String(cSenha);*/
        



// TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1_SenhaActionPerformed

    private void b_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_entrarActionPerformed
       String l = "" ;
       String s = ""  ;
       ArrayList<Administradores> a = new ArrayList<Administradores>();
     
       String login = jTextField1_Login.getText();
       
        char[] cSenha = jPasswordField1_Senha.getPassword();
        String senha = new String(cSenha);
        
        String sql = "SELECT login, senha FROM Administradores WHERE login =? AND senha=?";
                 try {
                      Connection conn = Conectar();
                      
                      PreparedStatement AdministradoresStatement = conn.prepareStatement(sql);
                      AdministradoresStatement.setString(1, login);
                      AdministradoresStatement.setString(2, senha);
                      
                      ResultSet res = AdministradoresStatement.executeQuery();
                      
                      while(res.next()){
                          Administradores b = new Administradores();
                          
                          //a.setId(res.getInt(1));
                          b.setLogin(res.getString(1));
                          b.setSenha(res.getString(2));
                          a.add(b);
                          
                      }
                      
                      AdministradoresStatement.close();
                      Desconectar(conn);
                      
                      
                      
                 } catch (SQLException ex) {
                     Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        for (int i = 0; i < a.size(); i++){
        if(a.get(i).getLogin().equals(login) && a.get(i).getSenha().equals(senha)){
            UserAdmTela w = new UserAdmTela();
                w.setVisible(true);
                this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Login  inválido.\nTente novamente");
                
        }
        }
        if(a.isEmpty()){
            JOptionPane.showMessageDialog(null, "Login  inválido.\nTente novamente");
        }
        
        
        
        /*for(int i = 0; i < Conexao.administradores.size(); i++){
            
            if((!login.isEmpty()) && login.equals(Conexao.administradores.get(i).getLogin()  )) {
                
               Conexao.checkLogin(login, senha);
               if(Conexao.checkLogin(login, senha)==true){
                UserAdmTela w = new UserAdmTela();
                w.setVisible(true);
                this.dispose();
                break;
               }else{
                   JOptionPane.showMessageDialog(null, "Senha incorreta!");
                break;
               }
            }else{
                JOptionPane.showMessageDialog(null, "Login  inválido.\nTente novamente");
                break;
            }
            
            
            
        }*/
        
        
        
        
        
        /*for(int i = 0; i < Conexao.administradores.size(); i++){
        if( (Conexao.administradores.get(i).getLogin().equals(login))){
           
           if(Conexao.administradores.get(i).getSenha().equals(senha)  ){
            
            this.dispose();
            UserAdmTela b = new UserAdmTela();
            b.setVisible(true);
            break;
        }else{
            JOptionPane.showMessageDialog(null, "Login ou Senha inválidos.\nTente novamente");
        }
        
        }
    }//GEN-LAST:event_b_entrarActionPerformed
   */ }
    private void jTextField1_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_LoginActionPerformed
        //JTextField ev = (JTextField)evt.getSource(); 
         //    this.login = ev.getText();
            //System.err.println(login);

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_LoginActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String args[]) throws SQLException {
  
        
         //   Conexao.Conectar();
        Conexao.ImportarAdministradores();
        Conexao.ImportarLivros();
        Conexao.ImportarMembros();
        Conexao.importarDiasEmprestimo();
        //if(!Conexao.emprestimos.isEmpty()){
        Conexao.importarEmprestimos();
        Conexao.ImportarDevolucoes();
        Conexao.ImportarDevedores();
        //}else{
         //   Conexao.emprestimos.clear();
        //}
        
        
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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        
        
       /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton b_entrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1_Senha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1_Login;
    // End of variables declaration//GEN-END:variables
}