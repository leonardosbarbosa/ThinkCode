package com.thinkcode.servlet;

import Controller.PerfilController;
import com.thinkcode.models.PerfilModel;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gusta
 */
@WebServlet(name = "PerfilServlet", urlPatterns = {"/PerfilServlet"})
public class PerfilServlet extends HttpServlet {

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
        //Instância de objetos
        PerfilModel perfil = new PerfilModel();
        PerfilController perfilController = new PerfilController();
        String url = "/login.jsp";
        boolean logado = false;
        String tarefa = request.getParameter("tarefa");
        String id = request.getParameter("id");

        Cookie cook = null;
        List<Cookie> cookies = new ArrayList<>();
        cookies = Arrays.asList(request.getCookies());
        //Fim instância       

        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName() != null && ck.getName().equals("Id_Usuario")) {
                    cook = ck;
                    logado = true;
                }
            }
        }
        //Fim instância

        if (logado) {
            if (tarefa != null) {

                if (tarefa.equals("Editando")) {

                    perfil.setIdPerfil(Integer.parseInt(id));
                    perfil = perfilController.PerfilPropriedades(perfil);
                    url = "/cadastroPerfil.jsp";
                    request.setAttribute("ID_PERFIL", perfil.getIdPerfil());
                    request.setAttribute("descricaoPerfil", perfil.getDescricao());
                    request.setAttribute("tipoPerfil", perfil.getTipo());
                    request.setAttribute("tarefa", "Editar");
                }
            }

            String filtroIDFilial = "";
            String filtroNome = "";
            if (request.getParameter("filtroFiliais") != null || request.getParameter("filtroPerfil") != null) {
                filtroIDFilial = request.getParameter("filtroFiliais");
                filtroNome = request.getParameter("filtroNome");
            }
            List<PerfilModel> perfis = perfilController.PerfisCadastrados(filtroIDFilial, filtroNome);
            request.setAttribute("perfis", perfis);
            url = "/gerenciarPerfis.jsp";
            if (tarefa != null) {

                if (tarefa.equals("Editando")) {
                    url = "/cadastroPerfil.jsp";
                }
            }

            if (tarefa != null) {

                if (tarefa.equals("editar")) {
                    perfil.setIdPerfil(Integer.parseInt(id));
                    perfil = perfilController.PerfilPropriedades(perfil);
                    url = "/cadastroPerfil.jsp";
                    request.setAttribute("ID_PERFIL", perfil.getIdPerfil());
                    request.setAttribute("tipo", perfil.getTipo());
                    request.setAttribute("descricao", perfil.getDescricao());

                    request.setAttribute("tarefa", "Editar");

                }
                if (request.getParameter("ID_PERFIL") != null) {
                    perfil.setIdPerfil(Integer.parseInt(request.getParameter("ID_PERFIL")));
                }
                perfil.setTipo(request.getParameter("tipoPerfil"));
                perfil.setDescricao(request.getParameter("descricaoPerfil"));
                Date dataIncl = new Date();
                perfil.setDataInclusao(dataIncl.toInstant().toString().substring(0, 10));
                perfil.setUsrInclusao(Integer.parseInt(cook.getValue()));

                if (tarefa.equals("cadastro")) {
                    //Salvando produto
                    boolean ok = perfilController.Save(perfil);
                    //Fim 
                    if (ok) {
                        url = "/gerenciarPerfis.jsp";
                    }
                }

                if (tarefa.equals("Editar")) {
                    //Salvando produto
                    boolean ok = perfilController.Update(perfil);
                    //Fim 
                    if (ok) {
                        url = "/gerenciarPerfis.jsp";
                    }
                }
            }

        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
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
