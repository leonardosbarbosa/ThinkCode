/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo Silva
 */
public class UsuarioDAO {

    public static boolean cadastrarUsuario(Usuario usuario) {

        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();

            String sql = "insert into usuario (id_perfil, id_filial, cpf_cnpj, rg, nome, email, senha, telefone, sexo, empresa, data_nascimento, data_inclusao)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getIdPerfil());
            ps.setInt(2, usuario.getIdFilial());
            ps.setString(3, usuario.getCpfCnpj());
            ps.setString(4, usuario.getRg());
            ps.setString(5, usuario.getNome());
            ps.setString(6, usuario.getEmail());
            ps.setString(7, usuario.getSenha());
            ps.setLong(8, usuario.getTelefone());
            ps.setString(9, usuario.getSexo());
            ps.setInt(10, 1);
            ps.setString(11, usuario.getDataNasc());
            ps.setString(12, usuario.getDataInclusao());
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            String guts = ex.toString();
            System.out.println(ex);
        }
        return ok;
    }

    public static boolean consultarUsuario(Usuario usuario) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select email from usuario where email = '" + usuario.getEmail() + "' and senha = '" + usuario.getSenha() + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static int consultarIdUsuario(Usuario usuario) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select id_usuario from usuario where cpf_cnpj = '" + usuario.getCpfCnpj() + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                return rs.getInt("id_usuario");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static boolean excluirUsuario(int idUsuario) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("delete id_usuario from usuario where id_usuario like '%" + idUsuario + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
