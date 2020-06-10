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

public class PedidoDAO extends ConnectionDB {

    public static boolean cadastrarPedido(PedidoModel pedido) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "INSERT INTO tb_pedido (id_filial, id_acompanhe, Valor, data_inclusao,usr_inclusao,descricao, usr_acompanhamento) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdFilial());
            ps.setInt(2, pedido.getIdAcompanhe());
            ps.setDouble(3, pedido.getValor());
            ps.setString(4, pedido.getDataInclusao());
            ps.setInt(5, pedido.getUserInclusao());
            ps.setString(6, pedido.getobservacao());
            ps.setInt(7, pedido.getUserAcompanhamento());

            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static List<PedidoModel> consultarTodosPedido(String _filtroFilial, String _filtroSolicitante, String _filtroStatus) {
        Connection con;
        List<PedidoModel> pedidos = new ArrayList<PedidoModel>();

        try {
            con = ConnectionDB.obterConexao();
            String sql = "select \n"
                    + "	tb_pedido.id_pedido ,\n"
                    + "	fi.nome as nomeFilial,\n"
                    + "	us.nome as nomeSolicitante,\n"
                    + "	us2.nome as nomeAcompanhamento,\n"
                    + "	ac.descricao,\n"
                    + "	tb_pedido.data_inclusao,\n"
                    + "	tb_pedido.descricao\n"
                    + "from tb_pedido \n"
                    + "INNER JOIN tb_filial as fi ON tb_pedido.id_filial = fi.id_filial \n"
                    + "INNER JOIN tb_acompanhe as ac ON tb_pedido.id_acompanhe = ac.id_acompanhe\n"
                    + "INNER JOIN tb_usuario as us on tb_pedido.usr_inclusao = us.id_usuario\n"
                    + "LEFT JOIN tb_usuario as us2 on tb_pedido.usr_acompanhamento = us2.id_usuario\n";
                    
            if (_filtroStatus == null || _filtroStatus.equals("")) {
                sql += "where ac.descricao not like '%Cancelado%'";
            } else {
                sql += "where tb_pedido.id_acompanhe = " + _filtroStatus;
            }
            if (_filtroFilial != null && !_filtroFilial.equals("")) {
                sql += "and tb_pedido.id_filial = " + _filtroFilial;
            }
            if (_filtroSolicitante != null && !_filtroSolicitante.equals("")) {
                sql += "and tb_pedido.usr_inclusao = " + _filtroSolicitante;
            }
            PreparedStatement ps = con.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoModel pedido = new PedidoModel();
                pedido.setIdPedido(rs.getInt("tb_pedido.id_pedido"));
                pedido.setNomeFilial(rs.getString("nomeFilial"));
                pedido.setnomeSolicitante(rs.getString("nomeSolicitante"));
                pedido.setAcompanhamento(rs.getString("ac.descricao"));
                pedido.setDataInclusao(rs.getString("data_inclusao"));
                pedido.setobservacao(rs.getString("tb_pedido.descricao"));
                pedido.setNomeAcompanhamento(rs.getString("nomeAcompanhamento"));
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
            PreparedStatement ps = con.prepareStatement("UPDATE tb_pedido SET data_exclusao =" + date + " usr_exclusao = " + userExclusao + " WHERE tb_pedido.id_pedido = " + id_pedido);
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
            PreparedStatement ps = con.prepareStatement("DELETE FROM tb_pedido WHERE tb_pedido.id_pedido = " + id_pedido);
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static int consultarUltimoPedido(int id_vendedor) {
        int id_pedido = 0;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select id_pedido from tb_pedido where usr_inclusao = " + id_vendedor + "  order by id_pedido desc limit 1;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                id_pedido = rs.getInt("id_pedido");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_pedido;
    }

    public static PedidoModel consultaPedido(int id) {
        Connection con;
        PedidoModel pedido = new PedidoModel();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select \n"
                    + "	tb_pedido.id_pedido ,\n"
                    + "	tb_pedido.id_filial ,\n"
                    + "	tb_pedido.id_acompanhe ,\n"
                    + "	tb_pedido.usr_inclusao ,\n"
                    + "	tb_pedido.Valor,\n"
                    + "	fi.nome as nomeFilial,\n"
                    + "	us.nome as nomeSolicitante,\n"
                    + "	ac.descricao,\n"
                    + "	tb_pedido.data_inclusao,\n"
                    + "	tb_pedido.descricao\n"
                    + "from tb_pedido \n"
                    + "INNER JOIN tb_filial as fi ON tb_pedido.id_filial = fi.id_filial \n"
                    + "INNER JOIN tb_acompanhe as ac ON tb_pedido.id_acompanhe = ac.id_acompanhe\n"
                    + "INNER JOIN tb_usuario as us on tb_pedido.usr_inclusao = us.id_usuario where tb_pedido.id_pedido = " + id,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pedido.setIdPedido(rs.getInt("tb_pedido.id_pedido"));
                pedido.setNomeFilial(rs.getString("nomeFilial"));
                pedido.setnomeSolicitante(rs.getString("nomeSolicitante"));
                pedido.setAcompanhamento(rs.getString("ac.descricao"));
                pedido.setDataInclusao(rs.getString("data_inclusao"));
                pedido.setobservacao(rs.getString("tb_pedido.descricao"));
                pedido.setIdFilial(rs.getInt("tb_pedido.id_filial"));
                pedido.setIdAcompanhe(rs.getInt("tb_pedido.id_acompanhe"));
                pedido.setUserInclusao(rs.getInt("tb_pedido.usr_inclusao"));
                pedido.setValor(rs.getDouble("tb_pedido.Valor"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido;

    }

    public static boolean AtualizarPedido(PedidoModel _pedido) {
        boolean alter = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();

            String sql = "update tb_pedido set  id_filial = " + _pedido.getIdFilial() + ", id_acompanhe = " + _pedido.getIdAcompanhe() + ", Valor = " + Double.toString(_pedido.getValor()) + " , data_inclusao =  '" + _pedido.getDataInclusao() + "',  descricao =  '" + _pedido.getobservacao() + "', usr_acompanhamento = " + _pedido.getUserAcompanhamento() + " "
                    + "  where id_pedido = " + _pedido.getIdPedido();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.execute();
            alter = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            String guts = ex.toString();
            System.out.println(ex);
        }

        return alter;
    }
}
