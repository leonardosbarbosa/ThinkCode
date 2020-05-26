/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.VendaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo Silva
 */
public class VendaDAO {

    public static boolean cadastraraVenda(VendaModel venda) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "INSERT INTO venda ( id_status, id_endereco, id_usuario, id_filial, cpf_cnpj, pagamento, parcelas, total, data) VALUES (? ,? ,? ,? ,? , ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, venda.getIdStatus());
            ps.setInt(2, venda.getIdEndereco());
            ps.setInt(3, venda.getIdUsuario());
            ps.setInt(4, venda.getIdFilial());
            ps.setString(5, venda.getCpfCnpj());
            ps.setInt(6, venda.getPagamento());
            ps.setDouble(7, venda.getParcelas());
            ps.setDouble(8, venda.getTotal());
            ps.setString(9, venda.getData());
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static boolean consultarVenda(String idVenda) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select nome from venda where id_venda like '%" + idVenda + "%'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id_usuario"));
            }
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean excluirVenda(String idVenda) {
        Connection con;
        Date date = new Date();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("update venda set dt_exlusao = " + date + " where id_venda like '%" + idVenda + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean Delete(String idVenda) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("delete nome from venda where id_venda like '%" + idVenda + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<VendaModel> consultarVendaCompleta(String idVenda) {
        Connection con;
        List<VendaModel> venda = new ArrayList<VendaModel>();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("SELEC * from venda where id_venda = '" + idVenda + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                VendaModel vendaDB = new VendaModel();
                vendaDB.setIdVenda(Integer.parseInt(idVenda));
                vendaDB.setIdStatus(Integer.parseInt(rs.getString("id_status")));
                vendaDB.setIdEndereco(Integer.parseInt(rs.getString("id_endereco")));
                vendaDB.setIdUsuario(Integer.parseInt(rs.getString("id_usuario")));
                vendaDB.setIdFilial(Integer.parseInt(rs.getString("venda.pagamento")));
                vendaDB.setCpfCnpj(rs.getString("cpf_cnpj"));
                vendaDB.setPagamento(Integer.parseInt(rs.getString("pagamento")));
                vendaDB.setParcelas(Integer.parseInt(rs.getString("parcelas")));
                vendaDB.setTotal(Double.parseDouble(rs.getString("total")));
                vendaDB.setData(rs.getString("data"));
                vendaDB.setDataExclusao(rs.getString("data_exclusao"));
                vendaDB.setUserExclusao(rs.getString("usr_exclusao"));
                vendaDB.setCodRastreio(rs.getString("codigo_rastreio"));
                venda.add(vendaDB);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }

    public static int consultarUltimoIdVenda() {
        Connection con;
        int id = 1;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select id_venda from venda order by id_venda desc limit 1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id_venda");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

}
