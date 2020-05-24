/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.PerfilModel;
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
 * @author Devakian
 */
public class PerfilDAO {

    public static boolean cadastrarPerfil(PerfilModel perfil) {
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
            ps.setInt(5, perfil.getUsrInclusao());
            ps.setString(6, perfil.getDataExclusao());
            ps.setString(7, perfil.getUsrExclusao());

            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static PerfilModel consultarPerfil(PerfilModel perfil) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select * from perfil where id_perfil = " + perfil.getIdPerfil());
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                perfil.setIdPerfil(rs.getInt("id_perfil"));
                perfil.setTipo(rs.getString("tipo"));
                perfil.setDescricao(rs.getString("descricao"));
                perfil.setDataInclusao(rs.getString("data_inclusao"));
                perfil.setUsrInclusao(Integer.parseInt(rs.getString("usr_inclusao")));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perfil;
    }

    public static boolean excluirPerfil(int idPerfil, int userExclusao) {
        Connection con;
        Date date = new Date();
        String data = date.toInstant().toString().substring(0, 10);
        
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("update perfil set data_exclusao = '" + data + "', usr_exclusao = " + userExclusao + " where id_perfil = " + idPerfil);
            
            ps.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean Delete(int idPerfil) {
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

    public static List<PerfilModel> PerfisCadastrados(String filtroDescricao, String filtroTipo) {
        Connection con;
        List<PerfilModel> perfis = new ArrayList<>();

        try {
            String sqlState = "select * from perfil WHERE data_exclusao is null";
            if (filtroDescricao != null && !filtroDescricao.equals("") && filtroTipo != null && !filtroTipo.equals("")) {
                sqlState += " and id_filial = " + filtroDescricao + " and tipo = '" + filtroTipo + "'";
            }

            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement(sqlState);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PerfilModel perfil = new PerfilModel();
                perfil.setIdPerfil(rs.getInt("id_perfil"));
                perfil.setTipo(rs.getString("tipo"));
                perfil.setDescricao(rs.getString("descricao"));
                perfis.add(perfil);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perfis;
    }

    public static boolean atualizarPerfil(PerfilModel perfil) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "update perfil set tipo = ?, descricao = ? where id_perfil = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, perfil.getTipo());
            ps.setString(2, perfil.getDescricao());
            ps.setInt(3, perfil.getIdPerfil());
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
}
