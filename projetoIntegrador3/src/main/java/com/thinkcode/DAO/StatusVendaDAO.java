/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.Status_Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Devakian
 */
public class StatusVendaDAO {

    public static boolean cadastrarStatusVenda(Status_Venda statusVenda) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "insert into status_venda (id_status, status, descricao, data_inclusao, usr_inclusao,data_exclusao,usr_exclusao)"
                    + " values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, statusVenda.getId_status());
            ps.setString(2, statusVenda.getStatus());
            ps.setString(3, statusVenda.getDescricao());
            ps.setString(4, statusVenda.getDataInclusao());
            ps.setInt(5, statusVenda.getUsrInclusao());
            ps.setString(6, statusVenda.getDataExclusao());
            ps.setInt(7, statusVenda.getUsrExclusao());

            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StatusVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static boolean consultarStatusVenda(int idStatus) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select id_status from status_venda where id_status like '%" + idStatus + "%'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id_status"));
            }
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StatusVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean excluirEndereco(int idStatus) {
        Connection con;
        Date date = new Date();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("update from status_venda  set dt_exclusao = " + date + "where id_status like '%" + idStatus + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StatusVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean Delete(int idStatus) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("delete id_status from status_venda where id_status like '%" + idStatus + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StatusVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
