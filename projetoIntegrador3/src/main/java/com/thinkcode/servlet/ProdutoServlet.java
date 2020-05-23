package com.thinkcode.servlet;

import Controller.FilialController;
import Controller.ProdutoController;
import Controller.UsuarioController;
import com.thinkcode.models.FilialModel;
import com.thinkcode.models.ProdutoModel;
import com.thinkcode.models.UsuarioModel;
import java.io.IOException;
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
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

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
        String tarefa = request.getParameter("tarefa");
        String id = request.getParameter("id");

        ProdutoModel produto = new ProdutoModel();
        ProdutoController produtoController = new ProdutoController();

        Cookie cook = null;
        List<Cookie> cookies = new ArrayList<Cookie>();
        cookies = Arrays.asList(request.getCookies());
        String url = "/login.jsp";
        boolean logado = false;
        //Fim instância       

        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName() != null && ck.getName().equals("Id_Usuario")) {
                    cook = ck;
                    logado = true;
                }
            }
        }
        if (logado) {
            if (tarefa != null) {
                if (tarefa.equals("Editando")) {

                    produto.setIdProduto(Integer.parseInt(id));
                    produto = produtoController.produtoPropriedades(produto);
                    url = "/cadastroUsuario.jsp";
                    request.setAttribute("ID_PRODUTO", produto.getIdProduto());
                    request.setAttribute("nomeProduto", produto.getNome());
                    request.setAttribute("tipoProduto", produto.getTipo());
                    request.setAttribute("quantidadeProduto", produto.getQuantidade());
                    request.setAttribute("descricaoProduto", produto.getDescricao());
                    request.setAttribute("valorProduto", produto.getValor());
                    request.setAttribute("idFilial", produto.getIdFilial());
                    request.setAttribute("tarefa", "Editar");
                }

            }
            //Pegando parâmetros e atribuindo a model

            //Fim atribuição
            String filtroIDFilial = "";
            String filtroNome = "";
            if (request.getParameter("filtroFiliais") != null || request.getParameter("filtroPerfil") != null) {
                filtroIDFilial = request.getParameter("filtroFiliais");
                filtroNome = request.getParameter("filtroNome");
            }
            List<ProdutoModel> produtos = produtoController.ProdutosCadastrados(filtroIDFilial, filtroNome);
            request.setAttribute("produtos", produtos);
            FilialController FilialController = new FilialController();
            List<FilialModel> filiais = FilialController.FiliaisCadastradas("", "");
            request.setAttribute("filiais", filiais);
            url = "/gerenciarProdutos.jsp";
            if (tarefa != null) {
                if (tarefa.equals("Editando")) {

                    url = "/cadastroProduto.jsp";
                }
                if (tarefa.equals("Cadastrando")) {
                    url = "/cadastroProduto.jsp";
                }
            }
            if (request.getParameter("nomeProduto") != null && request.getParameter("quantidadeProduto") != null) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setId(Integer.parseInt(cook.getValue()));
                UsuarioController usuarioController = new UsuarioController();
                usuario = usuarioController.UsuarioPropriedades(usuario);
               if (request.getParameter("ID_PRODUTO") != null) {
                    produto.setIdProduto(Integer.parseInt(request.getParameter("ID_PRODUTO")));
                }
                produto.setNome(request.getParameter("nomeProduto"));
                produto.setQuantidade(Integer.parseInt(request.getParameter("quantidadeProduto")));
                produto.setTipo(request.getParameter("tipoProduto"));
                produto.setValor(Double.parseDouble(request.getParameter("valorProduto")));
                produto.setDescricao(request.getParameter("descricaoProduto"));
                produto.setIdUsuario(usuario.getIdUsuario());
                produto.setIdFilial(Integer.parseInt(request.getParameter("filialProduto")));

                if (tarefa.equals("cadastro")) {
                    //Salvando produto
                    boolean ok = produtoController.save(produto);
                    //Fim
                    if (ok) {
                        url = "/gerenciarProdutos.jsp";
                    }
                } 
                 if (tarefa.equals("Editar")) { //Atualizando produto     
                    boolean ok = produtoController.update(produto);
                    if (ok) {
                        url = "/gerenciarProdutos.jsp";
                    }

                }
            }
        }
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            String error = e.toString();
        }

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
