/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.servlet;

import Controller.AcompanheController;
import Controller.DetalhePedidoController;
import Controller.FilialController;
import Controller.PedidoController;
import Controller.ProdutoController;
import Controller.UsuarioController;
import com.thinkcode.models.AcompanheModel;
import com.thinkcode.models.DetalhePedidoModel;
import com.thinkcode.models.FilialModel;
import com.thinkcode.models.PedidoModel;
import com.thinkcode.models.ProdutoModel;
import com.thinkcode.models.UsuarioModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
 * @author Gustavo Nascimento
 */
@WebServlet(name = "SolicitacaoServlet", urlPatterns = {"/SolicitacaoServlet"})
public class SolicitacaoServlet extends HttpServlet {

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
        String tarefa = request.getParameter("tarefa");
        String id = request.getParameter("id");

        //Instância de objetos
        UsuarioModel usuario = new UsuarioModel();
        UsuarioController usuarioController = new UsuarioController();
        ProdutoModel produto = new ProdutoModel();
        ProdutoController produtoController = new ProdutoController();
        FilialController FilialController = new FilialController();
        PedidoModel pedido = new PedidoModel();
        PedidoController pedidoC = new PedidoController();
        DetalhePedidoModel detalhePedido = new DetalhePedidoModel();
        DetalhePedidoController detalhePedidoC = new DetalhePedidoController();
        AcompanheModel acompanhamento = new AcompanheModel();
        AcompanheController acompanhamentoC = new AcompanheController();
        String _filtroFilial = null;
        String _filtroSolicitante = null;
        String _filtroStatus = null;
        Boolean cadastro = false;
        Date dataIncl = new Date();
        Cookie cook = null;
        List<Cookie> cookies = new ArrayList<Cookie>();
        cookies = Arrays.asList(request.getCookies());
        String url = "/login.jsp";
        boolean logado = false;
        //Fim instância       

        //Varredura de cookie para verificar se usuário está logado
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName() != null && ck.getName().equals("Id_Usuario")) {
                    cook = ck;
                    logado = true;
                }
            }
        }
        //Fim Varredura
        //Se usuário estiver logado pode prosseguir para página
        if (logado) {
            url = "/acompanhamentoSolicitacao.jsp";
            if (tarefa != null) {
                
                if (tarefa.equals("editando")) {
                    PedidoModel pedidoEditar = pedidoC.PropriedadesPedido(Integer.parseInt(id));
                    List<DetalhePedidoModel> produtos = detalhePedidoC.todosDetalhe(pedidoEditar.getIdPedido());
                    request.setAttribute("tarefa", "editar");
                    request.setAttribute("pedido", pedidoEditar);
                    request.setAttribute("produtoPedido", produtos);
                    request.setAttribute("ID_PEDIDO", id);
                    url = "/cadastroSolicitacao.jsp";
                }
                if (tarefa.equals("Cadastrando")) {
                    request.setAttribute("tarefa", "");
                    url = "/cadastroSolicitacao.jsp";
                }
                if (tarefa.equals("editar")) {
                    if (request.getParameter("filialProduto") != null && request.getParameter("observacaoProduto") != null) {
                        pedido.setIdPedido(Integer.parseInt(request.getParameter("ID_PEDIDO")));
                        pedido.setIdFilial(Integer.parseInt(request.getParameter("filialProduto")));
                        pedido.setIdAcompanhe(Integer.parseInt(request.getParameter("acompanhamento")));
                        pedido.setValor(Double.parseDouble("10"));
                        pedido.setDataInclusao(dataIncl.toInstant().toString().substring(0, 10));
                        pedido.setUserAcompanhamento(Integer.parseInt(cook.getValue()));
                        pedido.setobservacao(request.getParameter("observacaoProduto"));
                        cadastro = pedidoC.update(pedido);
                        url = "/acompanhamentoSolicitacao.jsp";
                    }
                }
                if (tarefa.equals("cadastro")) {
                    
                    if (request.getParameter("filialProduto") != null && request.getParameter("observacaoProduto") != null) {
                        pedido.setIdFilial(Integer.parseInt(request.getParameter("filialProduto")));
                        pedido.setIdAcompanhe(1);
                        pedido.setValor(Double.parseDouble("10"));
                        pedido.setDataInclusao(dataIncl.toInstant().toString().substring(0, 10));
                        pedido.setUserInclusao(Integer.parseInt(cook.getValue()));
                        pedido.setobservacao(request.getParameter("observacaoProduto"));
                        pedido.setUserAcompanhamento(Integer.parseInt(cook.getValue()));
                        cadastro = pedidoC.save(pedido);
                        if (cadastro) {
                            String auxProdutos[] = request.getParameter("produtosSolicitantes").split(";");
                            for (int i = 0; i < auxProdutos.length; i++) {
                                dataIncl = new Date();
                                int id_pedido = pedidoC.UltimoPedido(Integer.parseInt(cook.getValue()));
                                detalhePedido.setIdPedido(id_pedido);
                                
                                String auxProduto[] = auxProdutos[i].split(",");
                                detalhePedido.setIdProduto(Integer.parseInt(auxProduto[0]));
                                detalhePedido.setQtde(Integer.parseInt(auxProduto[1]));
                                
                                detalhePedido.setValor(Double.parseDouble("10"));
                                detalhePedido.setDataInclusao(dataIncl.toInstant().toString().substring(0, 10));
                                detalhePedido.setUserInclusao(Integer.parseInt(cook.getValue()));
                                cadastro = detalhePedidoC.save(detalhePedido);
                            }
                        }
                    }
                    
                }
                
            }
            List<ProdutoModel> produtos = produtoController.ProdutosCadastrados("", "", "");
            List<FilialModel> filiais = FilialController.FiliaisCadastradas("", "");
            
            if (request.getParameter("filtroFiliais") !=null) {
                _filtroFilial = request.getParameter("filtroFiliais");
            }
            if (request.getParameter("filtroSolicitante") !=null) {
                _filtroSolicitante = request.getParameter("filtroSolicitante");
            }
            if (request.getParameter("filtroStatus") !=null) {
                _filtroStatus = request.getParameter("filtroStatus");
            }
            List<PedidoModel> pedidos = pedidoC.todosPedidos(_filtroFilial, _filtroSolicitante, _filtroStatus);
            List<AcompanheModel> acompanhamentos = acompanhamentoC.todosAcompanhes();
            List<UsuarioModel> usuarios = usuarioController.UsuariosCadastrados("", "");
            request.setAttribute("filiais", filiais);
            request.setAttribute("produtos", produtos);
            request.setAttribute("pedidos", pedidos);
            request.setAttribute("acompanhamentos", acompanhamentos);
            request.setAttribute("usuarios", usuarios);
            
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
