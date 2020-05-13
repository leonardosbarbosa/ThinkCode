/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.FilialModel;
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
public class FilialDAO {
    
      public static boolean cadastrarFilial(FilialModel filial) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            
            String sql = "insert into filial (Nome, Descricao, cnpj, cep, rua, bairro, numero,"
                    + " complemento, data_inclusao,usr_inclusao)"
                    + " values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, filial.getNome());
            ps.setString(2, filial.getDescricao());
            ps.setLong(3, filial.getCnpj());
            ps.setInt(4, filial.getCep());
            ps.setString(5, filial.getRua());
            ps.setString(6, filial.getBairro());
            ps.setString(7, filial.getNumero());
            ps.setString(8, filial.getComplemento());
            ps.setString(9, filial.getDataInclusao());
            ps.setInt(10, filial.getUserInclusao());                         
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
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
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
