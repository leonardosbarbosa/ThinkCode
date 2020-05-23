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
public class PedidoModel {
    private int idpedido;
    private int idfilial;
    private int idacompanhe;
     private double valor;
    private String dataInclusao;
    private int userInlcusao;
    private String dataExclusao;
    private int userExclusao;

    public PedidoModel() {
    }

    public PedidoModel( int idfilial, int idacompanhe, double valor, String dataInclusao, int userInlcusao) {
        this.idfilial = idfilial;
        this.idacompanhe = idacompanhe;
        this.valor = valor;
        this.dataInclusao = dataInclusao;
        this.userInlcusao = userInlcusao;
    }
    public int getIdPedido() {
        return idpedido;
    }

    public void setIdPedido(int id) {
        this.idpedido = idpedido;
    }
    public int getIdFilial() {
        return idfilial;
    }

    public void setIdFilial(int idfilial) {
        this.idfilial = idfilial;
    }
    public int getIdAcompanhe() {
        return idacompanhe;
    }

    public void setIdAcompanhe(int idacompanhe) {
        this.idacompanhe = idacompanhe;
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
