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
public class AcompanheModel {
    private int idAcompanhe;
    private String descricao;
    private String dataInclusao;
    private int userInlcusao;
    private String dataExclusao;
    private int userExclusao;

    public AcompanheModel() {
    }

    public AcompanheModel( String descricao, String dataInclusao, int userInlcusao) {
        this.descricao = descricao;
        this.dataInclusao = dataInclusao;
        this.userInlcusao = userInlcusao;
    }

    public int getIdAcompanhe() {
        return idAcompanhe;
    }

    public void setIdAcompanhe(int id) {
        this.idAcompanhe = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
