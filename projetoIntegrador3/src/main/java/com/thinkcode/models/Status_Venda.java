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
public class Status_Venda {
    private int id_status;
    private String status;
    private String descricao;
    private String dataInclusao;
    private int usrInclusao;
    private String dataExclusao;
    private int usrExclusao;

    public Status_Venda(int id_status, String status, String descricao) {
        this.id_status = id_status;
        this.status = status;
        this.descricao = descricao;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getUsrInclusao() {
        return usrInclusao;
    }

    public void setUsrInclusao(int usrInclusao) {
        this.usrInclusao = usrInclusao;
    }

    public String getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(String dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public int getUsrExclusao() {
        return usrExclusao;
    }

    public void setUsrExclusao(int usrExclusao) {
        this.usrExclusao = usrExclusao;
    }
    
    
}
