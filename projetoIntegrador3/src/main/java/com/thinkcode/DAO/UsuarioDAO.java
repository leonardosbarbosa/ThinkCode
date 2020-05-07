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
            String sql = "insert into usuario (id_usuario, id_perfil, id_filial, cpf_cnpj, rg, nome, email, senha, telefone, sexo , empresa,"
                    + "data_nascimento, data_inclusao, usr_inclusao)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getIdUsuario());
            ps.setInt(2, usuario.getIdPerfil());
            ps.setInt(3, usuario.getIdFilial());
            ps.setString(4, usuario.getCpfCnpj());
            ps.setString(5, usuario.getRg());
            ps.setString(6, usuario.getNome());
            ps.setString(7, usuario.getEmail());
            ps.setString(8, usuario.getSenha());
            ps.setInt(9, usuario.getTelefone());
            ps.setString(10, usuario.getSexo());
            ps.setInt(11, usuario.getEmpresa());
            ps.setString(12, usuario.getDataNasc());
            ps.setString(13, usuario.getDataInclusao());
            ps.setInt(14, usuario.getUserInclusao());
            
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
