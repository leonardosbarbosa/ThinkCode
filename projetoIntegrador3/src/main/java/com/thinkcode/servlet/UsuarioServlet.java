/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.servlet;

import Controller.EnderecoController;
import Controller.FilialController;
import Controller.UsuarioController;
import com.thinkcode.models.EnderecoModel;
import com.thinkcode.models.FilialModel;
import com.thinkcode.models.UsuarioModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo Silva
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

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
        EnderecoController enderecoController = new EnderecoController();
        EnderecoModel endereco = new EnderecoModel();
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
                    usuario.setId(Integer.parseInt(id));
                    usuario = usuarioController.UsuarioPropriedades(usuario);
                    endereco = enderecoController.EnderecoUsuario(usuario.getIdUsuario());
                    url = "/cadastroUsuario.jsp";
                    request.setAttribute("ID_USUARIO", usuario.getIdUsuario());
                    request.setAttribute("cpf", usuario.getCpfCnpj());
                    request.setAttribute("dataNasc", usuario.getDataNasc());
                    request.setAttribute("email", usuario.getEmail());
                    request.setAttribute("nome", usuario.getNome());
                    request.setAttribute("rg", usuario.getRg());
                    request.setAttribute("senha", usuario.getSenha());
                    request.setAttribute("sexo", usuario.getSexo());
                    request.setAttribute("telefone", usuario.getTelefone());
                    request.setAttribute("cep",endereco.getCep());
                    request.setAttribute("rua",endereco.getRua());
                    request.setAttribute("bairro",endereco.getBairro());
                    request.setAttribute("numero",endereco.getNumero());
                    request.setAttribute("complemento",endereco.getComplemento());
                    request.setAttribute("tarefa", "Editar");
                    
                }
            }

            String filtroFilial = "";
            String filtroPerfil = "";
            if (request.getParameter("filtroFiliais") != null || request.getParameter("filtroPerfil") != null) {
                filtroFilial = request.getParameter("filtroFiliais");
                filtroPerfil = request.getParameter("filtroPerfil");
            }
            List<UsuarioModel> usuarios = usuarioController.UsuariosCadastrados(filtroFilial, filtroPerfil);
            request.setAttribute("usuarios", usuarios);
            FilialController FilialController = new FilialController();
            List<FilialModel> filiais = FilialController.FiliaisCadastradas("", "");
            request.setAttribute("filiais", filiais);
            url = "/gerenciamentoUsuarios.jsp";
            if (tarefa != null) {
                if (tarefa.equals("Editando")) {
                    
                    url = "/cadastroUsuario.jsp";
                }
            }

            //response.sendRedirect(request.getContextPath() + url);
            //response.sendRedirect(url);
            //Pegando parâmetros e atribuindo a model
            if (request.getParameter("cpf") != null && request.getParameter("rg") != null && request.getParameter("email") != null && request.getParameter("email") != null) {
                url = "/cadastroUsuario.jsp";
                if (request.getParameter("ID_USUARIO") != null) {
                    usuario.setId(Integer.parseInt(request.getParameter("ID_USUARIO")));
                }
                
                usuario.setUserInclusao(Integer.parseInt(cook.getValue()));
                usuario.setCpfCnpj(request.getParameter("cpf").replace("-", ""));
                usuario.setRg(request.getParameter("rg").replace("-", ""));
                usuario.setNome(request.getParameter("nome"));
                usuario.setEmail(request.getParameter("email"));
                usuario.setSenha(request.getParameter("senha"));
                usuario.setTelefone(Long.parseLong(request.getParameter("telefone").replace("(", "").replace(")", "").replace("-", "").replace(" ", "")));
                usuario.setSexo(request.getParameter("sexo"));
                usuario.setEmpresa(1);
                usuario.setDataNasc(request.getParameter("dataNasc"));
                Date dataIncl = new Date();
                usuario.setDataInclusao(dataIncl.toInstant().toString().substring(0, 10));
            //Fim atribuição

                //Cadastro de usuário
                boolean ok = true;
                if (tarefa.equals("Cadastro")) {
                    ok = usuarioController.Save(usuario);
                }
                if (tarefa.equals("Editar")) {
                    ok = usuarioController.Update(usuario);
                }
                url = "/gerenciamentoUsuarios.jsp";
                //Fim cadastro
                if (ok) {
                    //Retorno do usuário cadastrado
                    usuario = usuarioController.UsuarioPropriedades(usuario);
                    //Pegando parâmetros e atribuindo a model
                    String cep = request.getParameter("cep");
                    String rua = request.getParameter("rua");
                    String bairro = request.getParameter("bairro");
                    String numero = request.getParameter("numero");
                    String complemento = request.getParameter("complemento");

                    
                //Fim atribuição

                    //Cadastro endereço
                    boolean okEndereco = enderecoController.Save(endereco);
                    //Fim cadastro

                    if (okEndereco) {
                        url = "/gerenciamentoUsuarios.jsp";
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
