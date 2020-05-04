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
public class Usuario {

    private int id;
    private int idPerfil; // Chave Estrangeira
    private int idFilial; // Chave Estrangeira
    private String cpfCnpj;
    private String rg;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String sexo;
    private String empresa;
    private String dataNasc;
    private String dataInclusao;
    private String userInclusao;
    private String dataExclusao;
    private String userExclusao;

    public Usuario(int id, int idPerfil, int idFilial, String cpfCnpj, String rg,
            String nome, String email, String senha, String telefone, String sexo,
            String empresa, String dataNasc, String dataInclusao, String userInclusao) {

        this.id = id;
        this.idPerfil = idPerfil;
        this.idFilial = idFilial;
        this.cpfCnpj = cpfCnpj;
        this.rg = rg;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.sexo = sexo;
        this.empresa = empresa;
        this.dataNasc = dataNasc;
        this.dataInclusao = dataInclusao;
        this.userInclusao = userInclusao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getUserInclusao() {
        return userInclusao;
    }

    public void setUserInclusao(String userInclusao) {
        this.userInclusao = userInclusao;
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
