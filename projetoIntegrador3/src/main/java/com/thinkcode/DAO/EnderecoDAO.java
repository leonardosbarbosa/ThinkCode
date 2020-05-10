/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.Endereco;
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
public class EnderecoDAO {

    public static boolean cadastrarEndereco(Endereco endereco) {
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

    public static boolean consultarEndrecoIdUsuario(int idUuario) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select id_Usuario from endereco where id_Usuario like '%" + idUuario + "%'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("id_Uuario"));
            }
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
            public static boolean excluirEndereco(int idEndereco) {
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
}
