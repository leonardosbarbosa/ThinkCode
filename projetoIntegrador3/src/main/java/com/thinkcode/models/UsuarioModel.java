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
public class UsuarioModel extends Criptografia {

    private int idUsuario;
    private int idPerfil; // Chave Estrangeira
    private int idFilial; // Chave Estrangeira
    private String cpfCnpj;
    private String rg;
    private String nome;
    private String email;
    private String senha;
    private long telefone;
    private String sexo;
    private int empresa;
    private String dataNasc;
    private String dataInclusao;
    private int userInclusao;
    private String dataExclusao;
    private int userExclusao;
    private String nomeFilial;
    private String nomePerfil;

    public UsuarioModel() {
    
    }
    
    public UsuarioModel (String email, String senha){
    this.email = email;
    this.senha = senha;
    }
    
    public UsuarioModel (int idPerfil, int idFilial, String cpfCnpj, String rg,
            String nome, String email, String senha, long telefone, String sexo,
            int empresa, String dataNasc, String dataInclusao, int userInclusao) {
        
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setId(int id) {
        this.idUsuario = id;
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
        String senhaCrip = CriptografiaMD5(senha);  
        return senhaCrip;        
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
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
    
    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }
     public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }
}
