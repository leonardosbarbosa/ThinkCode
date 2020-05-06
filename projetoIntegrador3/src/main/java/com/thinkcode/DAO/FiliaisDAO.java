/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.Filial;
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
public class FiliaisDAO {
      public static boolean cadastrarFilial(Filial filial) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "insert into filial (id_filial, nome, descricao, cnpj, cep, rua, bairro, numero,"
                    + "complemento, data_inclusao,user_inclusao)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, filial.getId());
            ps.setString(2, filial.getNome());
            ps.setString(3, filial.getDescricao());
            ps.setString(4, filial.getCnpj());
            ps.setString(5, filial.getCep());
            ps.setString(6, filial.getRua());
            ps.setString(7, filial.getBairro());
            ps.setString(8, filial.getNumero());
            ps.setString(9, filial.getComplemento());
            ps.setString(10, filial.getDataInclusao());
            ps.setString(11, filial.getUserInlcusao());
                          
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static boolean consultarFilial(int idFilial) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select id_filial from filial where id_filial like '%" + idFilial + "%'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("id_filial"));
            }
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
            public static boolean excluirFilial(int idFilial) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("delete id_filial from filial where id_filial like '%" + idFilial + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
