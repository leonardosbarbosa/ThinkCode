package com.thinkcode.servlet;

import Controller.FilialController;
import Controller.PedidoController;
import com.thinkcode.models.FilialModel;
import com.thinkcode.models.PedidoModel;
import com.thinkcode.models.UsuarioModel;
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
@WebServlet(name = "FilialServlet", urlPatterns = {"/FilialServlet"})
public class FilialServlet extends HttpServlet {

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
        FilialModel filial = new FilialModel();
        FilialController filialController = new FilialController();

        PedidoController pedidoC = new PedidoController();
        String url = "/login.html";
        Cookie cook = null;
        List<Cookie> cookies = new ArrayList<Cookie>();
        Date dataIncl = new Date();
        //Fim instância

        //Varredura de cookie para verificar se usuário está logado
        cookies = Arrays.asList(request.getCookies());
        boolean logado = true;

        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName() != null && ck.getName().equals("Id_Usuario")) {
                    if (ck.getValue() != null && !ck.getValue().equals("")) {
                        logado = true;
                        cook = ck;
                    }

                }
            }
        }
        //Fim Varredura
        //Se usuário estiver logado pode prosseguir para página
        if (logado) {
            url = "/gerenciamentoFiliais.jsp";
            if (tarefa != null) {
                //Se ele estiver editando um cadastro irá entra nesta condição e preencher todos campos
                if (tarefa.equals("Editando")) {
                    filial.setIdFilial(Integer.parseInt(id));
                    filial = filialController.FilialPropriedades(filial);
                    url = "/cadastroFilial.jsp";

                    request.setAttribute("ID_FILIAL", filial.getIdFilial());
                    request.setAttribute("nome", filial.getNome());
                    request.setAttribute("telefone", filial.getTelefone());
                    request.setAttribute("cnpj", filial.getCnpj());
                    request.setAttribute("descricao", filial.getDescricao());
                    request.setAttribute("cepFilial", filial.getCep());
                    request.setAttribute("ruaFilial", filial.getRua());
                    request.setAttribute("bairroFilial", filial.getBairro());
                    request.setAttribute("numeroFilial", filial.getNumero());
                    request.setAttribute("complementoFilial", filial.getComplemento());
                    request.setAttribute("tarefa", "Editar");

                }
                //Fim preenchimento
                //Se estiver excluíndo um usuário
                if (tarefa.equals("Excluir")) {
                    filial.setIdFilial(Integer.parseInt(id));
                    boolean ok = filialController.Delete(filial.getIdFilial(), Integer.parseInt(cook.getValue()));
                }
                //Fim exclusão
                //Pegando parâmetros e atribuindo a  model
                if (request.getParameter("cnpj") != null && request.getParameter("nome") != null) {

                    url = "/cadastroFilial.jsp";

                    if (request.getParameter("ID_FILIAL") != null && !request.getParameter("ID_FILIAL").equals("")) {
                        filial.setIdFilial(Integer.parseInt(request.getParameter("ID_FILIAL")));
                    }

                    filial.setUserInclusao(Integer.parseInt(cook.getValue()));
                    filial.setNome(request.getParameter("nome"));
                    filial.setTelefone(Long.parseLong(request.getParameter("telefone").replace("(", "").replace(")", "").replace("-", "").replace(" ", "")));
                    filial.setDescricao(request.getParameter("descricao"));
                    filial.setCnpj(Long.parseLong(request.getParameter("cnpj").replace(".", "").replace("-", "").replace("/", "")));
                    filial.setCep(Integer.parseInt(request.getParameter("cepFilial").replace(".", "").replace("-", "").replace("/", "")));
                    filial.setRua(request.getParameter("ruaFilial"));
                    filial.setBairro(request.getParameter("bairroFilial").replace("(", "").replace(")", "").replace("-", "").replace(" ", ""));
                    filial.setNumero(request.getParameter("numeroFilial"));
                    filial.setComplemento(request.getParameter("complementoFilial"));

                    filial.setDataInclusao(dataIncl.toInstant().toString().substring(0, 10));
                    filial.setUserInclusao(1);

                    //Fim atribuição
                    //Cadastro de usuário
                    boolean ok = true;
                    if (tarefa.equals("Cadastro")) {
                        ok = filialController.Save(filial);
                    }
                    if (tarefa.equals("Editar")) {
                        ok = filialController.Update(filial);
                    }

                    url = "/gerenciamentoFiliais.jsp";
                    //Fim cadastro

                }
            }
            //Filtro para tela de gerenciamento de filial
            String filtroIDFilial = "";
            String filtroNome = "";
            if (request.getParameter("filtroIDFilial") != null || request.getParameter("filtroNome") != null) {
                filtroIDFilial = request.getParameter("filtroIDFilial");
                filtroNome = request.getParameter("filtroNome");
            }
            List<FilialModel> filiais = filialController.FiliaisCadastradas(filtroIDFilial, filtroNome);
            request.setAttribute("filiais", filiais);

            if (tarefa != null) {
                if (tarefa.equals("Editando")) {

                    url = "/cadastroFilial.jsp";
                }
            }
            List<PedidoModel> pedidos = pedidoC.todosPedidos("", "", "");
            request.setAttribute("pedidos", pedidos);
            //Fim filtro
        }
        //Fim logado

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
