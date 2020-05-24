/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.DAO;

import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.RelatorioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo Nascimento
 */
public class RelatorioDAO {

    public static List<RelatorioModel> VendasEfetuadas(RelatorioModel _filtro) {
        Connection con;
        List<RelatorioModel> relatorios = new ArrayList<RelatorioModel>();

        try {
            String sqlState = "SELECT venda.id_venda, filial.nome, usuario.nome , venda.cpf_cnpj,venda.pagamento,venda.parcelas,venda.total,venda.data  "
                    + " FROM venda "
                    + " INNER JOIN usuario ON venda.id_usuario = usuario.id_usuario "
                    + " INNER JOIN filial ON venda.id_filial = filial.id_filial;";
//            if (filtroFilial != null && !filtroFilial.equals("")) {
//                sqlState += " and us.id_filial = " + filtroFilial;
//            }
//            if (filtroPerfil != null && !filtroPerfil.equals("")) {
//                if (filtroFilial != null && !filtroFilial.equals("")) {
//                    sqlState += " and us.id_perfil = " + filtroPerfil;
//                } else {
//                    sqlState += " and us.id_perfil = " + filtroPerfil;
//                }
//
//            }
            con = ConnectionDB.obterConexao();
            PreparedStatement ps = con.prepareStatement(sqlState);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RelatorioModel relatorio = new RelatorioModel();
                relatorio.setIdVenda(Integer.parseInt(rs.getString("id_venda")));
                relatorio.setfilialNome(rs.getString("filial.nome"));
                relatorio.setusuarioNome(rs.getString("usuario.nome"));
                relatorio.setcpfCnpj(rs.getString("venda.cpf_cnpj"));
                relatorio.setpagamento(Integer.parseInt(rs.getString("venda.pagamento")));
                relatorio.setparcelas(Integer.parseInt(rs.getString("venda.parcelas")));
                relatorio.settotal(Double.parseDouble(rs.getString("venda.total")));
                relatorio.setdata(rs.getString("venda.data").toString());
                        
                relatorios.add(relatorio);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relatorios;
    }
}
