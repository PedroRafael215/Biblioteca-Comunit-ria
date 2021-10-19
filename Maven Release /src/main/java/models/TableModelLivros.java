/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pedro
 * Essa Classe define a estrutura da tabela que visualiza os livros disponiveis na Biblioteca
 */
public class TableModelLivros extends AbstractTableModel{

    //private List <Livros> dados = new ArrayList<Livros>(); Usando -> Conexao.livros
    private String[] colunas = {"Id", "Titulo", "Autor", "Ano"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    
    
    
    @Override
    public int getRowCount() {
        return Conexao.livros.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return Conexao.livros.get(linha).getId();
            case 1:
                return Conexao.livros.get(linha).getTitulo();
            case 2:
                return Conexao.livros.get(linha).getAutor();
            case 3:
                return Conexao.livros.get(linha).getAno();
            
            
        }
        return null;
        
    }
   
    public static  void atualizarT(){
       
    }
    public  void atualizarTable(){
        
        
        this.fireTableDataChanged();
    }
    
    
}