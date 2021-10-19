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
 * Essa Classe define a estrutura da tabela que visualiza os emprestimos em atraso.
 * Estar visivel nessa tabela não significa estar visivel tambem na tabela de devedores.
 * Apenas se dia atraso for maior ou igual a 5.
 */
public class TableModelEmprestimos2  extends AbstractTableModel{
 private String[] colunas = {"Id", "Membro", "Livro", "Data Pedido", "Data Devolução", " Dias em atraso"};
    
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return Conexao.emprestimosAtrasados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return Conexao.emprestimosAtrasados.get(linha).getId();
            case 1:
                return Conexao.emprestimosAtrasados.get(linha).getId_usuario();           
            case 2: 
                return Conexao.emprestimosAtrasados.get(linha).getId_livro();  
            case 3:
                return Conexao.emprestimosAtrasados.get(linha).getData_pedido();
            case 4:
                return Conexao.emprestimosAtrasados.get(linha).getData_devolucao();
            case 5:
                return Conexao.emprestimosAtrasados.get(linha).getDias_atraso();
            
        }
        return null;
    }
    
      public  void atualizarTable(){
        
        
        this.fireTableDataChanged();
    }
    
}
