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
 * Essa Classe define a estrutura da tabela que visualiza os membros cadastrados no sistema
 */
public class TableModelMembros extends AbstractTableModel{
private String[] colunas = {"Id", "Nome", "Rua", "Bairro", "Cidade", "CPF", "RG", "Email"};



@Override
 public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return Conexao.membros.size();
    }

      @Override
    public int getColumnCount() {
        return colunas.length;
    }

     @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return Conexao.membros.get(linha).getId();
            case 1:
                return Conexao.membros.get(linha).getNome();
            case 2:
                return Conexao.membros.get(linha).getRua();
            case 3:
                return Conexao.membros.get(linha).getBairro();
            case 4:
                return Conexao.membros.get(linha).getCidade();
            case 5:
                return Conexao.membros.get(linha).getCpf();
            case 6:
                return Conexao.membros.get(linha).getRg();
            case 7:
                return Conexao.membros.get(linha).getEmail();
        }
        return null;
        
    }
    
}
