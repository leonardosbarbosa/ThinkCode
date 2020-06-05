/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.AcompanheModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AcompanheDAO {
      public static boolean cadastrarAcompanhe(AcompanheModel acompanhe) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "insert into tb_acompanhe (descricao, data_inclusao, usr_inclusao)"
                    + " values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, acompanhe.getDescricao());
            ps.setString(2, acompanhe.getDataInclusao());
            ps.setInt(3, acompanhe.getUserInclusao());

            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AcompanheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
     public static List<AcompanheModel> consultarTodosAcompanhe() {
        Connection con;
        List<AcompanheModel> acompanhes = new ArrayList<AcompanheModel>();

        try {
           con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select * from tb_acompanhe");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AcompanheModel acompanhe = new AcompanheModel();
                acompanhe.setDescricao(rs.getString("descricao"));
                acompanhes.add(acompanhe);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AcompanheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acompanhes;
    }

    public static boolean consultarAcompanhe(int id_acompanhe) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select * from tb_acompanhe where id_acompanhe like '%" + id_acompanhe + "%'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id_acompanhe"));
            }
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AcompanheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean excluirAcompanhe(int id_acompanhe, int userExclusao) {
        Connection con;
        Date date = new Date();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("UPDATE tb_acompanhe SET data_exclusao =" + date + " usr_exclusao = " + userExclusao +" WHERE tb_acompanhe.id_acompanhe = " + id_acompanhe);
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AcompanheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean DeleteAcompanhe(int id_acompanhe) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("DELETE FROM tb_acompanhe WHERE tb_acompanhe.id_acompanhe = "+id_acompanhe);
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AcompanheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
