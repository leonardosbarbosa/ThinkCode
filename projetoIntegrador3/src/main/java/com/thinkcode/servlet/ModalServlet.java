/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.servlet;

import com.thinkcode.DAO.UsuarioDAO;
import com.thinkcode.db.ConnectionDB;
import com.thinkcode.models.RelatorioModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Nascimento
 */
@WebServlet(name = "ModalServlet", urlPatterns = {"/ModalServlet"})
public class ModalServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String tarefa = request.getParameter("tarefa");
        String id = request.getParameter("id");
        Connection con;
        List<RelatorioModel> relatorios = new ArrayList<RelatorioModel>();

        try {
            String sqlState = "SELECT po.nome, iv.quantidade, iv.valor, po.id_produto FROM item_venda iv \n"
                    + "	INNER JOIN venda ve ON iv.id_venda = ve.id_venda\n"
                    + "	INNER JOIN produto po on iv.id_produto = po.id_produto\n"
                    + "	where iv.id_venda =  " + id;
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
                relatorio.setNomeProduto((rs.getString("po.nome")));
                relatorio.setQuantidadeProduto(Integer.parseInt(rs.getString("iv.quantidade")));
                relatorio.setValorProduto(Double.parseDouble(rs.getString("iv.valor")));
                relatorio.setIdProduto(Integer.parseInt(rs.getString("po.id_produto")));

                relatorios.add(relatorio);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tarefa.equals("modal")) {

            String modal = "<div id=\"my-modal\" class=\"modal fade\" tabindex=\"-1\">\n"
                    + "									<div class=\"modal-dialog\">\n"
                    + "										<div class=\"modal-content\">\n"
                    + "											<div class=\"modal-header\">\n"
                    + "												<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n"
                    + "												<h3 class=\"smaller lighter blue no-margin\">Produtos</h3>\n"
                    + "											</div>\n"
                    + "\n"
                    + "											<div class=\"modal-body\">\n"
                    + "												<table id=\"tabelaprodutos\" class=\"table  table-bordered table-hover\">\n"
                    + "                                    <thead>\n"
                    + "                                        <tr>\n"
                    + "                                            <th id=\"id\"> Nr.Produto </th>\n"
                    + "                                            <th id=\"id\"> Produto </th>\n"
                    + "                                            <th> Quantidade</th>\n"
                    + "                                            <th> Valor </th>\n"
                    + "                                        </tr>\n"
                    + "                                    </thead>\n"
                    + "\n"
                    + "                                    <tbody>\n";
            for (RelatorioModel relatorio : relatorios) {
                modal += "<tr><th>" + relatorio.getIdProduto() + "</th><th>" + relatorio.getNomeProduto() + "</th><th>" + relatorio.getQuantidadeProduto() + "</th><th>" + relatorio.getValorProduto() + "</th></tr>";
            }
            modal += "                                    </tbody>\n"
                    + "                                </table>"
                    + "											</div>\n"
                    + "\n"
                    + "											<div class=\"modal-footer\">\n"
                    + "												<button class=\"btn btn-sm btn-danger pull-right\" data-dismiss=\"modal\">\n"
                    + "													<i class=\"ace-icon fa fa-times\"></i>\n"
                    + "													Fechar\n"
                    + "												</button>\n"
                    + "											</div>\n"
                    + "										</div><!-- /.modal-content -->\n"
                    + "									</div><!-- /.modal-dialog -->\n"
                    + "								</div>";
            //response.getWriter().write(modal);
            //request.setAttribute("result", modal);
            PrintWriter out = response.getWriter();
            out.print(modal);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
