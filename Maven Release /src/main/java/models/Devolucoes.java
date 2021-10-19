/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author pedro
 * Classe referente a tabela em banco de dados. Armazenando informaçoes de devoluções da Biblioteca 
 */
public class Devolucoes {
    
    private int id;
    private String membro;
    private String livro;
    private String data_devolucao;

    /** id de Devolucoes
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the membro
     */
    public String getMembro() {
        return membro;
    }

    /**
     * @param membro the membro to set
     */
    public void setMembro(String membro) {
        this.membro = membro;
    }

    /**
     * @return the livro
     */
    public String getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(String livro) {
        this.livro = livro;
    }

    /**
     * @return the data_devolucao
     */
    public String getData_devolucao() {
        return data_devolucao;
    }

    /**
     * @param data_devolucao the data_devolucao to set
     */
    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
    
    
}
