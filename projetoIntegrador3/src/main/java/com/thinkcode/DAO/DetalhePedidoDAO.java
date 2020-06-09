/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.DetalhePedidoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DetalhePedidoDAO {
       public static boolean cadastrarDetalhePedido(DetalhePedidoModel detalhe) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "insert into tb_detalhe_pedido (id_pedido, id_produto, qtde,Valor,data_inclusao,usr_inclusao)"
                    + " values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, detalhe.getIdPedido());
            ps.setInt(2, detalhe.getIdProduto());
            ps.setInt(3, detalhe.getQtde());
            ps.setDouble(4, detalhe.getValor());
            ps.setString(5, detalhe.getDataInclusao());
            ps.setInt(6, detalhe.getUserInclusao());

            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DetalhePedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
     public static List<DetalhePedidoModel> consultarTodosDetalhePedido(int idpedido) {
        Connection con;
        List<DetalhePedidoModel> detalhes = new ArrayList<DetalhePedidoModel>();

        try {
           con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select "
                    + "tb_detalhe_pedido.id_detalhepedido ,"
                    + " tb_produto.nome ,"
                    + " tb_detalhe_pedido.qtde ,"
                    + " tb_detalhe_pedido.valor "
                    + " from tb_detalhe_pedido "
                    + " inner join tb_produto on tb_detalhe_pedido.id_produto = tb_produto.id_produto "
                    + " where id_pedido ="+idpedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetalhePedidoModel detalhe = new DetalhePedidoModel();
                detalhe.setIdDetalhePedido(rs.getInt("id_detalhepedido"));
                detalhe.setNomeProduto(rs.getString("tb_produto.nome"));
                detalhe.setQtde(rs.getInt("qtde"));
                detalhe.setValor(rs.getDouble("valor"));
                detalhes.add(detalhe);
               
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DetalhePedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detalhes;
    }

    public static boolean consultarDetalhePedido(int id_detalhepedido) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select * from tb_detalhe_pedido where id_detalhepedido like '%" + id_detalhepedido + "%'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id_detalhepedido"));
            }
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AcompanheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean excluirDetalhePedido(int id_detalhe, int userExclusao) {
        Connection con;
        Date date = new Date();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("UPDATE tb_detalhe_pedido SET data_exclusao =" + date + " usr_exclusao = " + userExclusao +" WHERE tb_detalhe_pedido.id_detalhepedido = " + id_detalhe);
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DetalhePedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean DeleteDetalhePedido(int id_detalhepedido) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("DELETE FROM tb_detalhe_pedido WHERE tb_detalhe_pedido.id_detalhepedido = "+id_detalhepedido);
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DetalhePedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
