/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.servlet;

import Controller.EnderecoController;
import Controller.UsuarioController;
import com.thinkcode.models.EnderecoModel;
import com.thinkcode.models.UsuarioModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        //Instância de objetos
        UsuarioModel usuario = new UsuarioModel();
        UsuarioController usuarioController = new UsuarioController();
        EnderecoController enderecoController = new EnderecoController();
        String url = "/login.html";
        //Fim instância

        //Pegando parâmetros e atribuindo a model
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
        boolean ok = usuarioController.Save(usuario);
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
            
            EnderecoModel endereco = new EnderecoModel(usuario.getIdUsuario(), cep, rua, bairro, numero, complemento);
            //Fim atribuição

            //Cadastro endereço
            boolean okEndereco = enderecoController.Save(endereco);
            //Fim cadastro

            if (okEndereco) {
                url = "/index.html";
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
