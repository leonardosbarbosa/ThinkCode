/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 *
 * @author Leonardo Silva
 */
public class UsuarioDAO {

    public static boolean cadastrarUsuario(UsuarioModel usuario) {

        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();

            String sql = "insert into usuario (id_perfil, id_filial, cpf_cnpj, rg, nome, email, senha, telefone, sexo, empresa, data_nascimento, data_inclusao, usr_inclusao)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, 1);
            ps.setString(3, usuario.getCpfCnpj());
            ps.setString(4, usuario.getRg());
            ps.setString(5, usuario.getNome());
            ps.setString(6, usuario.getEmail());
            ps.setString(7, usuario.getSenha());
            ps.setLong(8, usuario.getTelefone());
            ps.setString(9, usuario.getSexo());
            ps.setInt(10, 1);

            ps.setString(11, converteData(usuario.getDataNasc()));
            String datinha = usuario.getDataNasc();
            ps.setString(12, usuario.getDataInclusao());
            ps.setInt(13, usuario.getUserInclusao());
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            String guts = ex.toString();
            System.out.println(ex);
        }
        return ok;
    }

    public static String converteData(String data) {

        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = sdf1.parse(data);
            data = dataNascimento.toInstant().toString().substring(0, 10);
            return data;
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public static boolean consultarUsuarioCadastrado(UsuarioModel usuario) {
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

    public static UsuarioModel consultarUsuario(UsuarioModel usuario) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select * from usuario where cpf_cnpj = '" + usuario.getCpfCnpj() + "' or email = '" + usuario.getEmail() + "' and senha = '" + usuario.getSenha() + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                usuario.setCpfCnpj(rs.getString("cpf_cnpj"));
                usuario.setDataExclusao(rs.getString("data_exclusao"));
                usuario.setDataInclusao(rs.getString("data_inclusao"));
                usuario.setDataNasc(rs.getDate("data_nascimento").toString());
                usuario.setEmail(rs.getString("email"));
                usuario.setEmpresa(rs.getInt("empresa"));
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setIdFilial(rs.getInt("id_filial"));
                usuario.setIdPerfil(rs.getInt("id_perfil"));
                usuario.setNome(rs.getString("nome"));
                usuario.setRg(rs.getString("rg"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setTelefone(rs.getInt("telefone"));
                usuario.setUserExclusao(rs.getInt("usr_exclusao"));
                usuario.setUserInclusao(rs.getInt("usr_inclusao"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public static boolean excluirUsuario(int idUsuario) {
        Connection con;
        Date date = new Date();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("update from usuario set dt_exclusao = " + date + " where id_usuario like '%" + idUsuario + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean Delete(int idUsuario) {
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

    public static List<UsuarioModel> UsuariosCadastrados() {
        Connection con;
        List<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
        
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select * from usuario");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setCpfCnpj(rs.getString("cpf_cnpj"));
                usuario.setDataExclusao(rs.getString("data_exclusao"));
                usuario.setDataInclusao(rs.getString("data_inclusao"));
                usuario.setDataNasc(rs.getDate("data_nascimento").toString());
                usuario.setEmail(rs.getString("email"));
                usuario.setEmpresa(rs.getInt("empresa"));
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setIdFilial(rs.getInt("id_filial"));
                usuario.setIdPerfil(rs.getInt("id_perfil"));
                usuario.setNome(rs.getString("nome"));
                usuario.setRg(rs.getString("rg"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setTelefone(rs.getLong("telefone"));
                usuario.setUserExclusao(rs.getInt("usr_exclusao"));
                usuario.setUserInclusao(rs.getInt("usr_inclusao"));
                usuarios.add(usuario);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

}
