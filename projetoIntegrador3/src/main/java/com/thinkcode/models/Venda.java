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
public class Venda {

    private int idVenda;
    private int idStatus; // Chave Estrangeira 
    private int idEndereco; // Chave Estrangeira
    private int idUsuario; // Chave Estrangeira
    private int idFilial; // Chave Estrangeira
    private String cpfCnpj;
    private int pagamento;
    private int parcelas;
    private double total;
    private String data;
    private String dataExclusao;
    private String userExclusao;
    private String codRastreio;

    public Venda(int idVenda, int idStatus, int idEndereco, int idUsuario, int idFilial, String cpfCnpj, int pagamento, int parcelas, double total, String data) {
        this.idVenda = idVenda;
        this.idStatus = idStatus;
        this.idEndereco = idEndereco;
        this.idUsuario = idUsuario;
        this.idFilial = idFilial;
        this.cpfCnpj = cpfCnpj;
        this.pagamento = pagamento;
        this.parcelas = parcelas;
        this.total = total;
        this.data = data;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public String getCodRastreio() {
        return codRastreio;
    }

    public void setCodRastreio(String codRastreio) {
        this.codRastreio = codRastreio;
    }

}
