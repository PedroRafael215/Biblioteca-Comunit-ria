/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pedro
 * Essa Classe define a estrutura da tabela que visualiza os emrpestimos em curso
 */
public class TableModelEmprestimos1 extends AbstractTableModel {

    
    private String[] colunas = {"Id", "Membro", "Livro", "Data Pedido", "Data Devolução"};
    
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return Conexao.emprestimos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return Conexao.emprestimos.get(linha).getId();
            case 1:
                return Conexao.emprestimos.get(linha).getId_usuario();
            case 2:
                return Conexao.emprestimos.get(linha).getId_livro();
            case 3:
                return Conexao.emprestimos.get(linha).getData_pedido();
            case 4:
                return Conexao.emprestimos.get(linha).getData_devolucao();
            
            
        }
        return null;
    }
    
      public  void atualizarTable(){
        
        
        this.fireTableDataChanged();
    }
    
}
