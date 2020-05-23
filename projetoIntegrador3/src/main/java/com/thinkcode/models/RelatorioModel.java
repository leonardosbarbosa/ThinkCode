/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.models;

/**
 *
 * @author Gustavo Nascimento
 */
public class RelatorioModel {
    
    private int idProduto;
    private int idUsuario; // Chave estrangeira
    private int idFilial; // Chave estrangeira
    private String nomeProduto;
    private String qtdProduto;
    private int Valor;

    public RelatorioModel() {

    }


    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    
}
