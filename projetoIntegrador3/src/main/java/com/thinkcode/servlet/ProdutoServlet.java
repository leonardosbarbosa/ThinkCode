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
                if (tarefa.equals("editar")) {

                    produto.setIdProduto(Integer.parseInt(id));
                    produto = produtoController.produtoPropriedades(produto);
                    url = "/cadastroUsuario.jsp";
                    produto.setNome(request.getParameter("nomeProduto"));
                    produto.setDescricao(request.getParameter("descricaoProduto"));
                    produto.setTipo(request.getParameter("tipoProduto").replace(".", "").replace("-", "").replace("/", ""));
                    produto.setQuantidade(Integer.parseInt(request.getParameter("quantidadeProduto").replace(".", "").replace("-", "").replace("/", "")));
                    produto.setValor(Double.parseDouble(request.getParameter("valorProduto")));
                    produto.setIdFilial(1);
                    produto.setIdUsuario(1);
                }

            }
            //Pegando parâmetros e atribuindo a model

            //Fim atribuição
            String filtroIDFilial = "";
            String filtroNome = "";
            if (request.getParameter("filtroFiliais") != null || request.getParameter("filtroPerfil") != null) {
                filtroIDFilial = request.getParameter("filtroIDFilial");
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
                UsuarioController  usuarioController = new UsuarioController();
                usuario = usuarioController.UsuarioPropriedades(usuario);
                produto.setNome(request.getParameter("nomeProduto"));
                produto.setQuantidade(Integer.parseInt(request.getParameter("nomeProduto")));
                produto.setTipo(request.getParameter("nomeProduto"));
                produto.setValor(Double.parseDouble(request.getParameter("nomeProduto")));
                produto.setDescricao(request.getParameter("nomeProduto"));
                produto.setIdUsuario(usuario.getIdUsuario());
                produto.setIdFilial(Integer.parseInt(request.getParameter("filialProduto")));

                if (tarefa.equals("cadastro")) {
                    //Salvando produto
                    boolean ok = produtoController.save(produto);
                    //Fim
                    if (ok) {
                        url = "/gerenciarProdutos.jsp";
                    }
                } else if (tarefa.equals("consulta")) {  //Consulta produto ALTERAR

                    boolean ok = produtoController.save(produto);
                    if (ok) {
                        url = "/index.jsp";
                    }
                } else if (tarefa.equals("editar")) { //Atualizando produto     
                    boolean ok = produtoController.update(produto);
                    if (ok) {
                        url = "/index.jsp";
                    }

                } else {  //Excluindo Produto  
                    boolean ok = produtoController.delete(produto);

                    if (ok) {
                        url = "/index.jsp";
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
