/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.models;

/**
 *
 * @author Devakian
 */
public class ItensVenda {
    
    private int idItem;
    private int idProduto;
    private int idUsuario;
    private int idVenda;
    private int Qntd;
    private double valor;

    
    public ItensVenda(){
        
    }
    
    public ItensVenda(int idItem, int idProduto, int idUsuario, int idVenda, int idQntd, double valor) {
        this.idItem = idItem;
        this.idProduto = idProduto;
        this.idUsuario = idUsuario;
        this.idVenda = idVenda;
        this.Qntd = idQntd;
        this.valor = valor;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
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

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getQntd() {
        return Qntd;
    }

    public void setQntd(int idQntd) {
        this.Qntd = idQntd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
