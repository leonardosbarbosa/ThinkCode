/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.PedidoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PedidoDAO {
     public static boolean cadastrarPedido(PedidoModel pedido) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "INSERT INTO tb_pedido (id_filial, id_acompanhe, data_inclusao,usr_inclusao) VALUES (?,?,?, ?,)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdFilial());
            ps.setInt(2,pedido.getIdAcompanhe());
            ps.setString(3,pedido.getDataInclusao());
            ps.setInt(4,pedido.getUserInclusao());

            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
     public static List<PedidoModel> consultarTodosPedido() {
        Connection con;
        List<PedidoModel> pedidos = new ArrayList<PedidoModel>();

        try {
           con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select tb_pedido.id_pedido , filial.nome ,tb_acompanhe.descricao , tb_pedido.valor , tb_pedido.data_inclusao \n" +
"from tb_pedido INNER JOIN filial ON tb_pedido.id_filial = filial.id_filial \n" +
"INNER JOIN tb_acompanhe ON tb_pedido.id_acompanhe = tb_acompanhe.id_acompanhe");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoModel pedido = new PedidoModel();
                pedido.setIdPedido(rs.getInt("id_pedido"));
                pedido.setNomeFilial(rs.getString("nome"));
                pedido.setDescricaoAcompanhe(rs.getString("descricao"));
                pedido.setValor(rs.getDouble("valor"));
                pedido.setDataInclusao(rs.getString("data_inclusao"));
                pedidos.add(pedido);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidos;
    }

    public static boolean excluirPedido(int id_pedido, int userExclusao) {
        Connection con;
        Date date = new Date();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("UPDATE tb_pedido SET data_exclusao =" + date + " usr_exclusao = " + userExclusao +" WHERE tb_pedido.id_pedido = " + id_pedido);
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean DeletePedido(int id_pedido) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("DELETE FROM tb_pedido WHERE tb_pedido.id_pedido = "+id_pedido);
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
