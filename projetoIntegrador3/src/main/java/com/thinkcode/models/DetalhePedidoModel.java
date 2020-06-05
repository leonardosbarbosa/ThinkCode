/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.models;

/**
 *
 * @author Leonardo Moreno
 */
public class DetalhePedidoModel {
      
    private int iddetalhepedido;
    private int idpedido;
    private int idproduto;
    private String nomeProduto;
    private int qtde;
    private double valor;
    private String dataInclusao;
    private int userInlcusao;
    private String dataExclusao;
    private int userExclusao;

    public DetalhePedidoModel() {
    }

    public DetalhePedidoModel( int idpedido, int idproduto,String nomeProduto, int qtde, double valor, String dataInclusao, int userInlcusao) {
        this.idpedido = idpedido;
        this.idproduto = idproduto;
        this.nomeProduto = nomeProduto;
        this.qtde = qtde;
        this.valor = valor;
        this.dataInclusao = dataInclusao;
        this.userInlcusao = userInlcusao;
    }
     public int getIdDetalhePedido() {
        return iddetalhepedido;
    }

    public void setIdDetalhePedido(int iddetalhepedido) {
        this.iddetalhepedido = iddetalhepedido;
    }
    public int getIdPedido() {
        return idpedido;
    }

    public void setIdPedido(int idpedido) {
        this.idpedido = idpedido;
    }
     public int getIdProduto() {
        return idproduto;
    }

    public void setIdProduto(int idproduto) {
        this.idproduto = idproduto;
    }
    
      public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

     public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public int getUserInclusao() {
        return userInlcusao;
    }

    public void setUserInclusao(int userInlcusao) {
        this.userInlcusao = userInlcusao;
    }

    public String getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(String dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public int getUserExclusao() {
        return userExclusao;
    }

    public void setUserExclusao(int userExclusao) {
        this.userExclusao = userExclusao;
    }
}
