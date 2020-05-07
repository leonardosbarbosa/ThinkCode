/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Devakian
 */
public class PerfilDAO {
        public static boolean cadastrarPerfil(Perfil perfil) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "insert into perfil (id_perfil, tipo, descricao, data_inclusao,usr_inclusao,data_exclusao,usr_exclusao)"
                    + " values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, perfil.getIdPerfil());
            ps.setString(2, perfil.getTipo());
            ps.setString(3, perfil.getDescricao());
            ps.setString(4, perfil.getDataInclusao());
            ps.setString(5, perfil.getUsrInclusao());
            ps.setString(6, perfil.getDataExclusao());
            ps.setString(7, perfil.getUsrExclusao());
            
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
        public static boolean consultarPerfil(int idPerfil) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select id_perfil from perfil where id_perfil like '%" + idPerfil + "%'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("id_perfil"));
            }
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
        public static boolean excluirPerfil(int idPerfil) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("delete id_perfil from perfil where id_perfil like '%" + idPerfil + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
