/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo Silva
 */
public class ProdutoDAO {

    public static boolean cadastrarProduto(ProdutoModel produto) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "insert into tb_produto (id_usuario, id_filial, tipo, nome, qtde, descricao, valor)"
                    + " values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, produto.getIdUsuario());
            ps.setInt(2, produto.getIdFilial());
            ps.setString(3, produto.getTipo());
            ps.setString(4, produto.getNome());
            ps.setInt(5, produto.getQuantidade());
            ps.setString(6, produto.getDescricao());
            ps.setDouble(7, produto.getValor());
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static ProdutoModel consultarProduto(ProdutoModel produto) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select * from tb_produto where id_produto = " + produto.getIdProduto(),
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                produto.setDescricao(rs.getString("descricao"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(Integer.parseInt(rs.getString("qtde")));
                produto.setTipo(rs.getString("tipo"));
                produto.setValor(Double.parseDouble(rs.getString("valor")));
                produto.setIdProduto(rs.getInt("id_produto"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    public static boolean atualizarProduto(ProdutoModel produto) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "update tb_produto set id_usuario = ?, id_filial = ?, tipo = ?, nome = ?, qtde = ?, descricao = ?, valor = ? where id_produto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, produto.getIdUsuario());
            ps.setInt(2, produto.getIdFilial());
            ps.setString(3, produto.getTipo());
            ps.setString(4, produto.getNome());
            ps.setInt(5, produto.getQuantidade());
            ps.setString(6, produto.getDescricao());
            ps.setDouble(7, produto.getValor());
            ps.setDouble(8, produto.getIdProduto());
            ps.executeUpdate();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static boolean excluirProduto(int idProduto, int userExclusao) {
        Connection con;
        Date date = new Date();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("update tb_produto set data_exclusao = '" + date.toInstant().toString().substring(0, 10) + "',"
                    + "usr_exclusao = " + userExclusao + " where id_produto = " + idProduto);
            ps.execute();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean Delete(String idProduto) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("delete nome from tb_produto where id_produto like '%" + idProduto + "%'",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<ProdutoModel> produtosCadastrados(String filtroFilial, String filtroTipo, String filtroNome) {
        Connection con;
        List<ProdutoModel> produtos = new ArrayList<>();

        try {
            String sqlState = "select * from tb_produto where data_exclusao is null";
            if (filtroFilial != null && !filtroFilial.equals("")) {
                sqlState += "and id_filial = " + filtroFilial;
            }
            if (filtroTipo != null && !filtroTipo.equals("")) {
                sqlState += " and tipo = '" + filtroTipo + "'";
            }
            if (filtroNome != null && !filtroNome.equals("")) {
                sqlState += "and nome like '%" + filtroNome + "%' and qtde > 0";
            }
            sqlState += " order by nome";
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement(sqlState,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProdutoModel produto = new ProdutoModel();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setIdUsuario(rs.getInt("id_usuario"));
                produto.setIdFilial(rs.getInt("id_filial"));
                produto.setTipo(rs.getString("tipo"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("qtde"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getDouble("valor"));
                produtos.add(produto);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

    public static boolean atualizarQtdeProduto(int id, int qtde) {
        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sql = "update tb_produto  set qtde = qtde-(?)  where id_produto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, qtde);
            ps.setInt(2, id);
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
}
