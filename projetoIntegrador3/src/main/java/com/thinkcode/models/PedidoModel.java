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
    private String nomeFilial;
    private int idacompanhe;
    private String descricaoAcompanhe;
    private double valor;
    private String dataInclusao;
    private int userInlcusao;
    private String dataExclusao;
    private int userExclusao;
    private String nomeSolicitante;
    private String nomeProduto;
    private int qtd;
    private String observacao;

    public PedidoModel() {
    }

    public PedidoModel(int idfilial, String nomeFilial, int idacompanhe, String descricaoAcompanhe, double valor, String dataInclusao, int userInlcusao) {
        this.idfilial = idfilial;
        this.nomeFilial = nomeFilial;
        this.idacompanhe = idacompanhe;
        this.descricaoAcompanhe = descricaoAcompanhe;
        this.valor = valor;
        this.dataInclusao = dataInclusao;
        this.userInlcusao = userInlcusao;
    }

    public int getIdPedido() {
        return idpedido;
    }

    public void setIdPedido(int id) {
        this.idpedido = id;
    }

    public int getIdFilial() {
        return idfilial;
    }

    public void setIdFilial(int idfilial) {
        this.idfilial = idfilial;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public int getIdAcompanhe() {
        return idacompanhe;
    }

    public void setIdAcompanhe(int idacompanhe) {
        this.idacompanhe = idacompanhe;
    }

    public String getDescricaoAcompanhe() {
        return descricaoAcompanhe;
    }

    public void setDescricaoAcompanhe(String descricaoAcompanhe) {
        this.descricaoAcompanhe = descricaoAcompanhe;
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
    
    public String getnomeSolicitante() {
        return nomeSolicitante;
    }

    public void setnomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }
     public String getnomeProduto() {
        return nomeProduto;
    }

    public void setnomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
    public String getobservacao() {
        return observacao;
    }

    public void setobservacao (String observacao) {
        this.observacao = observacao;
    }
       
    public int getqtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
