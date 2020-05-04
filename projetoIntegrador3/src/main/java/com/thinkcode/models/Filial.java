/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.models;

/**
 *
 * @author Leonardo Silva
 */
public class Filial {

    private int id;
    private String nome;
    private String descricao;
    private String cnpj;
    private String cep;
    private String rua;
    private String bairro;
    private String numero;
    private String complemento;
    private String dataInclusao;
    private String userInlcusao;
    private String dataExclusao;
    private String userExclusao;

    public Filial(int id, String nome, String descricao, String cnpj, String cep, String rua, String bairro, String numero, String complemento, String dataInclusao, String userInlcusao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cnpj = cnpj;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.dataInclusao = dataInclusao;
        this.userInlcusao = userInlcusao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getUserInlcusao() {
        return userInlcusao;
    }

    public void setUserInlcusao(String userInlcusao) {
        this.userInlcusao = userInlcusao;
    }

    public String getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(String dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public String getUserExclusao() {
        return userExclusao;
    }

    public void setUserExclusao(String userExclusao) {
        this.userExclusao = userExclusao;
    }

}
