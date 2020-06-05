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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

            String sql = "insert into tb_filial (Nome, telefone, Descricao, cnpj, cep, rua, bairro, numero,"
                    + " complemento, data_inclusao,usr_inclusao)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, filial.getNome());
            ps.setLong(2, filial.getTelefone());
            ps.setString(3, filial.getDescricao());
            ps.setLong(4, filial.getCnpj());
            ps.setInt(5, filial.getCep());
            ps.setString(6, filial.getRua());
            ps.setString(7, filial.getBairro());
            ps.setString(8, filial.getNumero());
            ps.setString(9, filial.getComplemento());
            ps.setString(10, filial.getDataInclusao());
            ps.setInt(11, filial.getUserInclusao());
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
            PreparedStatement ps = con.prepareStatement("select id_filial from tb_filial where id_filial like '%" + idFilial + "%'",
                            ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id_filial"));
            }
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    public static boolean excluirFilial(int idFilial, int idUsuario) {
        Connection con;
        Date date = new Date();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("update tb_filial set data_exclusao = '" + date.toInstant().toString().substring(0,10) + "'"
                    + ", usr_exclusao = " + idUsuario + " WHERE id_filial = " + idFilial);
            ps.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean Delete(int idFilial) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("delete id_filial from tb_filial where id_filial like '%" + idFilial + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public static List<FilialModel> FiliaisCadastradas(String filtroFilial, String filtroNome) {
        Connection con;
        List<FilialModel> filiais = new ArrayList<FilialModel>();

        try {
            String sqlState = "select * from tb_filial WHERE data_exclusao is null ";
            if (filtroFilial != null && !filtroFilial.equals("")) {
                sqlState += " and id_filial = " + filtroFilial;
            }
            if (filtroNome != null && !filtroNome.equals("")) {               
                    sqlState += " and rua like '%" + filtroNome + "%'";     
            }
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement(sqlState,
                            ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FilialModel filial = new FilialModel();
                filial.setBairro(rs.getString("bairro"));
                filial.setCep(rs.getInt("cep"));
                filial.setCnpj(rs.getLong("cnpj"));
                filial.setComplemento(rs.getString("complemento"));
                filial.setDataExclusao(rs.getString("data_exclusao"));
                filial.setDataInclusao(rs.getString("data_inclusao"));
                filial.setDescricao(rs.getString("Descricao"));
                filial.setIdFilial(rs.getInt("id_filial"));
                filial.setNome(rs.getString("Nome"));
                filial.setNumero(rs.getString("numero"));
                filial.setRua(rs.getString("rua"));
                filial.setTelefone(rs.getLong("telefone"));
                filial.setUserExclusao(rs.getInt("usr_exclusao"));
                filial.setUserInclusao(rs.getInt("usr_inclusao"));
                filiais.add(filial);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filiais;
    }

        public static boolean atualizarFilial(FilialModel filial) {

        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();

            String sql = "update tb_filial set Nome = ?, telefone = ?, Descricao = ?, cnpj = ?, cep = ?, rua = ?, bairro = ?, numero = ?, complemento = ?, data_inclusao = ?, usr_inclusao= ? "
                    + "  where id_filial = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, filial.getNome());
            ps.setLong(2, filial.getTelefone());
            ps.setString(3, filial.getDescricao());
            ps.setLong(4, filial.getCnpj());
            ps.setInt(5, filial.getCep());
            ps.setString(6, filial.getRua());
            ps.setString(7, filial.getBairro());
            ps.setString(8, filial.getNumero());
            ps.setString(9, filial.getComplemento());
            ps.setString(10, filial.getDataInclusao());
            ps.setInt(11, filial.getUserInclusao());
            ps.setInt(12, filial.getIdFilial());
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            String guts = ex.toString();
            System.out.println(ex);
        }
        return ok;
    }
        
        public static FilialModel consultarFilial(FilialModel filial) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sqlState = "select * from tb_filial";
            
            if (filial.getCnpj() != null ) {
                sqlState += " where cnpj = '" + filial.getCnpj()+ "'";
            }
            if (filial.getNome() != null) {
                if (filial.getCnpj()!= null) {
                    sqlState += " and Nome = '" + filial.getNome()+ "' ";
                } else {
                    sqlState += " where Nome = '" + filial.getNome()+ "' ";
                }
            }
            if (filial.getIdFilial()!= 0) {
                if (filial.getNome() != null && filial.getCnpj()!= null) {
                    sqlState += " and id_filial = '" + filial.getIdFilial()+ "' ";
                } else {
                    sqlState += " where id_filial = '" + filial.getIdFilial()+ "' ";
                }
                
            }
            PreparedStatement ps = con.prepareStatement(sqlState,
                            ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                filial.setIdFilial(rs.getInt("id_filial"));
                filial.setNome(rs.getString("Nome"));
                filial.setTelefone(rs.getLong("telefone"));
                filial.setDescricao(rs.getString("Descricao"));
                filial.setCnpj(rs.getLong("cnpj"));
                filial.setCep(rs.getInt("cep"));
                filial.setRua(rs.getString("rua"));
                filial.setBairro(rs.getString("bairro"));
                filial.setNumero(rs.getString("numero"));
                filial.setComplemento(rs.getString("complemento"));
                filial.setDataInclusao(rs.getString("data_inclusao"));
                filial.setDataExclusao(rs.getString("data_exclusao"));
                filial.setUserExclusao(rs.getInt("usr_exclusao"));
                filial.setUserInclusao(rs.getInt("usr_inclusao"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filial;
    }
    
}
