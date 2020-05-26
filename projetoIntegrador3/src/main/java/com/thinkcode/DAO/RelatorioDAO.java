/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.RelatorioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo Nascimento
 */
public class RelatorioDAO {

    public static List<RelatorioModel> VendasEfetuadas(RelatorioModel _filtro) {
        Connection con;
        List<RelatorioModel> relatorios = new ArrayList<RelatorioModel>();

        try {
            String sqlState = "SELECT \n"
                    + "	venda.id_venda,\n"
                    + "	fi.nome as nomeFilial,\n"
                    + "	us.nome as nomeVendedor, \n"
                    + "	cli.nome as nomeCliente,	\n"
                    + "	venda.cpf_cnpj,\n"
                    + "	venda.pagamento,\n"
                    + "	venda.parcelas,\n"
                    + "	venda.total,\n"
                    + "	venda.data\n"
                    + "FROM venda  \n"
                    + "INNER JOIN usuario as us ON venda.id_usuario = us.id_usuario  \n"
                    + "INNER JOIN usuario as cli ON venda.cpf_cnpj = cli.cpf_cnpj  \n"
                    + "INNER JOIN filial as fi ON venda.id_filial = fi.id_filial";

            if (_filtro != null && _filtro.getIdFilial() != 0) {
                sqlState += " where fi.id_filial = " + _filtro.getIdFilial();
            }
            if (_filtro != null && _filtro.getidVendedor() != 0) {
                if (_filtro.getIdFilial() != 0) {
                    sqlState += " and us.id_usuario = " + _filtro.getidVendedor();
                } else {

                    sqlState += " where us.id_usuario = " + _filtro.getidVendedor();
                }
            }
            if (_filtro != null && _filtro.getCpfCliente() != null) {
                if (_filtro.getIdFilial() != 0 || _filtro.getidVendedor() != 0) {
                    sqlState += " and cli.cpf_cnpj = '" + _filtro.getCpfCliente() + "'";
                } else {

                    sqlState += " where cli.cpf_cnpj = '" + _filtro.getCpfCliente() + "'";
                }

            }
            if (_filtro != null && _filtro.getidPagamento() != 0) {
                if (_filtro.getIdFilial() != 0 || _filtro.getidVendedor() != 0 || _filtro.getCpfCliente() != null) {
                    sqlState += " and venda.pagamento = " + _filtro.getidPagamento();
                } else {

                    sqlState += " where venda.pagamento = " + _filtro.getidPagamento();
                }
            }

            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement(sqlState);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RelatorioModel relatorio = new RelatorioModel();
                relatorio.setIdVenda(Integer.parseInt(rs.getString("venda.id_venda")));
                relatorio.setfilialNome(rs.getString("nomeFilial"));
                relatorio.setusuarioNome(rs.getString("nomeVendedor"));
                relatorio.setnomeCliente(rs.getString("nomeCliente"));
                relatorio.setcpfCnpj(rs.getString("venda.cpf_cnpj"));
                if (Integer.parseInt(rs.getString("venda.pagamento")) == 1) {
                    relatorio.setformaPagamento("Cartão de Crédito");
                } else if (Integer.parseInt(rs.getString("venda.pagamento")) == 1) {
                    relatorio.setformaPagamento("Cartão de Débito");
                } else {
                    relatorio.setformaPagamento("Dinheiro");
                }

                relatorio.setparcelas(Integer.parseInt(rs.getString("venda.parcelas")));
                relatorio.settotal(Double.parseDouble(rs.getString("venda.total")));
                relatorio.setdata(rs.getString("venda.data").toString());

                relatorios.add(relatorio);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relatorios;
    }
}
