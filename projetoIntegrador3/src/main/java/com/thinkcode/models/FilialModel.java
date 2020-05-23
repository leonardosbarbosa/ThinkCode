/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.models;

import java.util.Date;

/**
 *
 * @author Leonardo Silva
 */
public class FilialModel {

    private int idFilial;
    private String nome;
    private long telefone;

    private String descricao;
    private Long cnpj;
    private int cep;
    private String rua;
    private String bairro;
    private String numero;
    private String complemento;
    private String dataInclusao;
    private int userInclusao;
    private String dataExclusao;
    private int userExclusao;

    public FilialModel() {
    }

    public FilialModel(int idFilial,String nome,int telefone, String descricao, Long cnpj, int cep, String rua, String bairro, String numero, String complemento, String dataInclusao, int userInclusao) {

        this.idFilial = idFilial;
        this.nome = nome;
        this.telefone = telefone;
        this.descricao = descricao;
        this.cnpj = cnpj;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.dataInclusao = dataInclusao;
        this.userInclusao = userInclusao;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
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

    public int getUserInclusao() {
        return userInclusao;
    }

    public void setUserInclusao(int userInclusao) {
        this.userInclusao = userInclusao;
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
