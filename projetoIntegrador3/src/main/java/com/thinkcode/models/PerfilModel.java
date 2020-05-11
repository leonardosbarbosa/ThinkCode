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
public class PerfilModel {

    private int idPerfil;
    private String tipo;
    private String descricao;
    private String dataInclusao;
    private String usrInclusao;
    private String dataExclusao;
    private String usrExclusao;

    public PerfilModel() {
    }

    public PerfilModel(int idPerfil, String tipo, String descricao) {
        this.idPerfil = idPerfil;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getUsrInclusao() {
        return usrInclusao;
    }

    public void setUsrInclusao(String usrInclusao) {
        this.usrInclusao = usrInclusao;
    }

    public String getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(String dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public String getUsrExclusao() {
        return usrExclusao;
    }

    public void setUsrExclusao(String usrExclusao) {
        this.usrExclusao = usrExclusao;
    }

}
