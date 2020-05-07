/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.Venda;
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
public class VendaDAO {
    public static boolean cadastraraVenda(Venda produto) throws SQLException {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "insert into venda (id_venda, id_status, id_endereco, id_usuario, id_filial, cpf_cnpj, pagamento, parcelas, total, data_exclusao, usr_exclusao, codigo_rastreio)"
                    + " values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, produto.getIdVenda());
            ps.setInt(2, produto.getIdStatus());
            ps.setInt(3, produto.getIdEndereco());
            ps.setInt(4, produto.getIdUsuario());
            ps.setInt(5, produto.getIdFilial());
            ps.setString(6, produto.getCpfCnpj());
            ps.setInt(7, produto.getPagamento());
            ps.setDouble(8, produto.getParcelas());
            ps.setDouble(9, produto.getTotal());
            ps.setString(10, produto.getData());
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
        
        public static boolean consultarVenda(String idVenda) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select nome from venda where id_venda like '%" + idVenda + "%'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("id_usuario"));
            }
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
            
        public static boolean excluirVenda(String idVenda) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("delete nome from venda where id_venda like '%" + idVenda + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
