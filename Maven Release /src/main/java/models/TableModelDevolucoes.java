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
 * Essa Classe define a estrutura da tabela que visualiza todas as devoluções realizadas
 */
public class TableModelDevolucoes extends AbstractTableModel {
    
    private String[] colunas = {"Id", "Membro", "Livro", "Data Devolução"};
    
     @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return Conexao.devolucoes.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return Conexao.devolucoes.get(linha).getId();
            case 1:
                return Conexao.devolucoes.get(linha).getMembro();
            case 2:
                return Conexao.devolucoes.get(linha).getLivro();
            case 3:
                return Conexao.devolucoes.get(linha).getData_devolucao();
            
            
            
        }
        return null;
    }
    
      public  void atualizarTable(){
        
        
        this.fireTableDataChanged();
    }
    
    
    
    
    
}
