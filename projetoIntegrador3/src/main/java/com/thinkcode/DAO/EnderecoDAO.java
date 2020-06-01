/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.EnderecoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo Silva
 */
public class EnderecoDAO {

    public static boolean cadastrarEndereco(EnderecoModel endereco) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "insert into endereco (id_usuario, cep, rua, bairro, numero, complemento)"
                    + " values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, endereco.getIdUsuario());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getRua());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getNumero());
            ps.setString(6, endereco.getComplemento());
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static EnderecoModel consultarEndrecoIdUsuario(int idUuario) {
        Connection con;
        EnderecoModel endereco = new EnderecoModel();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select * from endereco where id_usuario = " + idUuario,
                            ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                endereco.setIdUsuario(Integer.parseInt(rs.getString("id_usuario")));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCep(rs.getString("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setId(Integer.parseInt(rs.getString("id_endereco")));

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }

    public static boolean excluirEndereco(int idEndereco) {
        Connection con;
        Date date = new Date();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("update endereco set dt_exclusao = " + date + " where id_endereco like '%" + idEndereco + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean Delete(int idEndereco) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("delete id_endereco from endereco where id_endereco like '%" + idEndereco + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean atualizarEndereco(EnderecoModel endereco) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "update endereco set id_usuario = ?, cep = ?, rua = ?, bairro = ?, numero = ?, complemento= ? where id_endereco = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, endereco.getIdUsuario());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getRua());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getNumero());
            ps.setString(6, endereco.getComplemento());
            ps.setInt(7, endereco.getId());
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
}
