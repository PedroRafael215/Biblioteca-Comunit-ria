/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author pedro
 * Classe referente a tabela em banco de dados. Armazenando informaçoes de emprestimos da Biblioteca
 */
public class Emprestimos {
    
    private int id;
    private String id_usuario;
    private String id_livro;
    private String data_pedido;
    private String data_devolucao;

    /**
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
     * @return the id_usuario
     */
    public String getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_livro
     */
    public String getId_livro() {
        return id_livro;
    }

    /**
     * @param id_livro the id_livro to set
     */
    public void setId_livro(String id_livro) {
        this.id_livro = id_livro;
    }

    /**
     * @return the data_pedido
     */
    public String getData_pedido() {
        return data_pedido;
    }

    /**
     * @param data_pedido the data_pedido to set
     */
    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
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
