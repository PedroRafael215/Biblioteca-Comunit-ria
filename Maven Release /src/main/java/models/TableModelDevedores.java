/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.table.AbstractTableModel;
import static models.Conexao.listaDevedores;

/**
 *
 * @author pedro
 * Essa Classe define a estrutura da tabela que visualiza os devedores. 
 * Membros com mais de 4 dias de atraso. Que quando nessa tabela se encontram bloqueados de pegar um emprestimo
 * 
 */
public class TableModelDevedores extends AbstractTableModel {
    
    private String[] colunas = {"Id", "Membro", "Livro", "Data Pedido", "Data Devolução", " Dias em atraso"};
    

@Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    
  @Override
    public int getRowCount() {
        return Conexao.listaDevedores.size();
    }  
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return Conexao.listaDevedores.get(linha).getId();
            case 1:
                return Conexao.listaDevedores.get(linha).getId_usuario();           
            case 2: 
                return Conexao.listaDevedores.get(linha).getId_livro();  
            case 3:
                return Conexao.listaDevedores.get(linha).getData_pedido();
            case 4:
                return Conexao.listaDevedores.get(linha).getData_devolucao();
            case 5:
                return Conexao.listaDevedores.get(linha).getDias_atraso();
            
        }
        return null;
    }
    
    public  void atualizarTable(){
        
        
        this.fireTableDataChanged();
    }
    
}