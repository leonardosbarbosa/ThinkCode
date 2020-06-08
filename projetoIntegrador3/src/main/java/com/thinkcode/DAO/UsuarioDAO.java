/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 *
 * @author Leonardo Silva
 */
public class UsuarioDAO extends ConnectionDB {

    public static boolean cadastrarUsuario(UsuarioModel usuario) {

        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();

            String sql = "insert into tb_usuario (id_perfil, id_filial, cpf_cnpj, rg, nome, email, senha, telefone, sexo, empresa, data_nascimento, data_inclusao, usr_inclusao)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getIdPerfil());
            ps.setInt(2, usuario.getIdFilial());
            ps.setString(3, usuario.getCpfCnpj());
            ps.setString(4, usuario.getRg());
            ps.setString(5, usuario.getNome());
            ps.setString(6, usuario.getEmail());
            if (usuario.getIdPerfil() == 3) {
                ps.setString(7, "0");
            } else {
                ps.setString(7, usuario.getSenha());
            }
            ps.setLong(8, usuario.getTelefone());
            ps.setString(9, usuario.getSexo());
            ps.setInt(10, 1);

            ps.setString(11, converteData(usuario.getDataNasc()));
            String datinha = usuario.getDataNasc();
            ps.setString(12, usuario.getDataInclusao());
            ps.setInt(13, usuario.getUserInclusao());
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            String guts = ex.toString();
            System.out.println(ex);
        }
        return ok;
    }

    public static boolean atualizarUsuario(UsuarioModel usuario) {

        boolean ok = false;
        Connection con;
        try {
            con = ConnectionDB.obterConexao();

            String sql = "update tb_usuario set id_perfil = ?, id_filial = ?, cpf_cnpj = ?, rg = ?, nome = ?, email = ?, senha = ?, telefone = ?, sexo = ?, empresa = ?, data_nascimento = ?, data_inclusao = ?, usr_inclusao= ? "
                    + "  where id_usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getIdPerfil());
            ps.setInt(2, usuario.getIdFilial());
            ps.setString(3, usuario.getCpfCnpj());
            ps.setString(4, usuario.getRg());
            ps.setString(5, usuario.getNome());
            ps.setString(6, usuario.getEmail());
            ps.setString(7, usuario.getSenha());
            ps.setLong(8, usuario.getTelefone());
            ps.setString(9, usuario.getSexo());
            ps.setInt(10, 1);

            ps.setString(11, converteData(usuario.getDataNasc()));
            String datinha = usuario.getDataNasc();
            ps.setString(12, usuario.getDataInclusao());
            ps.setInt(13, usuario.getUserInclusao());
            ps.setInt(14, usuario.getIdUsuario());
            ps.execute();
            ok = true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            String guts = ex.toString();
            System.out.println(ex);
        }
        return ok;
    }

    public static String converteData(String data) {

        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = sdf1.parse(data);
            data = dataNascimento.toInstant().toString().substring(0, 10);
            return data;
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public static boolean consultarUsuarioCadastrado(UsuarioModel usuario) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("select email from tb_usuario where email = '" + usuario.getEmail() + "' and senha = '" + usuario.getSenha() + "'",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static UsuarioModel consultarUsuario(UsuarioModel usuario) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            String sqlState = "select * from tb_usuario";
            if (usuario.getIdPerfil() != 0 && usuario.getIdPerfil() == 3) {
                if (usuario.getEmail() != null && usuario.getSenha() != null) {
                    sqlState += " where email = '" + usuario.getEmail() + "'";
                }
            } else {
                    if (usuario.getEmail() != null && usuario.getSenha() != null) {
                    sqlState += " where email = '" + usuario.getEmail() + "' and senha = '" + usuario.getSenha() + "'";
                }
            }

            if (usuario.getCpfCnpj() != null) {
                if (usuario.getEmail() != null && usuario.getSenha() != null) {
                    sqlState += " and cpf_cnpj = '" + usuario.getCpfCnpj() + "' ";
                } else {
                    sqlState += " where cpf_cnpj = '" + usuario.getCpfCnpj() + "' ";
                }
            }
            if (usuario.getIdUsuario() != 0) {
                if (usuario.getEmail() != null && usuario.getSenha() != null) {
                    sqlState += " and id_usuario = '" + usuario.getIdUsuario() + "' ";
                } else {
                    sqlState += " where id_usuario = '" + usuario.getIdUsuario() + "' ";
                }

            }
            PreparedStatement ps = con.prepareStatement(sqlState,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                usuario.setCpfCnpj(rs.getString("cpf_cnpj"));
                usuario.setDataExclusao(rs.getString("data_exclusao"));
                usuario.setDataInclusao(rs.getString("data_inclusao"));
                usuario.setDataNasc(rs.getDate("data_nascimento").toString());
                usuario.setEmail(rs.getString("email"));
                usuario.setEmpresa(rs.getInt("empresa"));
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setIdFilial(rs.getInt("id_filial"));
                usuario.setIdPerfil(rs.getInt("id_perfil"));
                usuario.setNome(rs.getString("nome"));
                usuario.setRg(rs.getString("rg"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setTelefone(rs.getLong("telefone"));
                usuario.setUserExclusao(rs.getInt("usr_exclusao"));
                usuario.setUserInclusao(rs.getInt("usr_inclusao"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public static boolean excluirUsuario(int idUsuarioExclusao, int idUsuarioExcluindo) {
        Connection con;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("update  tb_usuario set data_exclusao = ?, usr_exclusao = ? where id_usuario = ?");
            ps.setString(1, dtf.format(now));
            ps.setInt(2, idUsuarioExcluindo);
            ps.setInt(3, idUsuarioExclusao);
            ps.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean Delete(int idUsuario) {
        Connection con;
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("delete id_usuario from tb_usuario where id_usuario like '%" + idUsuario + "%'");
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<UsuarioModel> UsuariosCadastrados(String filtroFilial, String filtroPerfil) {
        Connection con;
        List<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();

        try {
            String sqlState = "select * from tb_usuario as us"
                    + " left join tb_filial as fi on us.id_filial = fi.id_filial"
                    + " left join tb_perfil as pe on us.id_perfil = pe.id_perfil"
                    + " where us.data_exclusao is null";
            if (filtroFilial != null && !filtroFilial.equals("")) {
                sqlState += " and us.id_filial = " + filtroFilial;
            }
            if (filtroPerfil != null && !filtroPerfil.equals("")) {
                if (filtroFilial != null && !filtroFilial.equals("")) {
                    sqlState += " and us.id_perfil = " + filtroPerfil;
                } else {
                    sqlState += " and us.id_perfil = " + filtroPerfil;
                }

            }
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement(sqlState,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setCpfCnpj(rs.getString("cpf_cnpj"));
                usuario.setDataExclusao(rs.getString("data_exclusao"));
                usuario.setDataInclusao(rs.getString("data_inclusao"));
                usuario.setDataNasc(rs.getDate("data_nascimento").toString());
                usuario.setEmail(rs.getString("email"));
                usuario.setEmpresa(rs.getInt("empresa"));
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setIdFilial(rs.getInt("id_filial"));
                usuario.setIdPerfil(rs.getInt("id_perfil"));
                usuario.setNome(rs.getString("nome"));
                usuario.setRg(rs.getString("rg"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setTelefone(rs.getLong("telefone"));
                usuario.setUserExclusao(rs.getInt("usr_exclusao"));
                usuario.setUserInclusao(rs.getInt("usr_inclusao"));
                usuario.setNomeFilial(rs.getString("fi.Nome"));
                usuario.setNomePerfil(rs.getString("pe.tipo"));
                usuarios.add(usuario);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public static UsuarioModel UsuariosPorCPFPERFIL(String CPF, String PERFIL) {
        Connection con;
        UsuarioModel usuarioDB = new UsuarioModel();
        try {
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement("SELECT * from tb_usuario where id_perfil = 3 and cpf_cnpj = '" + CPF + "' ",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();

            if (rs.first()) {

                usuarioDB.setNome(rs.getString("nome"));
                usuarioDB.setRg(rs.getString("rg"));
                usuarioDB.setDataNasc(rs.getString("data_nascimento"));
                usuarioDB.setTelefone(rs.getLong("telefone"));
                usuarioDB.setEmail(rs.getString("email"));
                usuarioDB.setSexo(rs.getString("sexo"));
                usuarioDB.setId(rs.getInt("id_usuario"));

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarioDB;
    }

}
