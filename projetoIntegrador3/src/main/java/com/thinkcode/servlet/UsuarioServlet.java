/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.servlet;

import Controller.EnderecoController;
import Controller.FilialController;
import Controller.PedidoController;
import Controller.PerfilController;
import Controller.UsuarioController;
import com.thinkcode.models.EnderecoModel;
import com.thinkcode.models.FilialModel;
import com.thinkcode.models.PedidoModel;
import com.thinkcode.models.PerfilModel;
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
        PedidoController pedidoC = new PedidoController();
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
            url = "/gerenciamentoUsuarios.jsp";
            //Se houve alguma tarefa a ser feita Seja Edita/Editar/Criando/Criar/Atualizar entra no IF
            if (tarefa != null) {
                if (!tarefa.equals("Cancelar")) {
                    //Se o usuário estiver editando um cadastro o select será feito e passado para o front para ser manipulado
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
                        request.setAttribute("cep", endereco.getCep());
                        request.setAttribute("rua", endereco.getRua());
                        request.setAttribute("bairro", endereco.getBairro());
                        request.setAttribute("numero", endereco.getNumero());
                        request.setAttribute("complemento", endereco.getComplemento());
                        request.setAttribute("tarefa", "Editar");
                        request.setAttribute("ID_ENDERECO", endereco.getId());
                        url = "/cadastroUsuario.jsp";
                    }
                    //Fim carregamento
                    //Se o usuário estiver criando um usuário novo ele é direcionado para a página de criação
                    if (tarefa.equals("Criando")) {

                        url = "/cadastroUsuario.jsp";
                    }
                    //Fim criação
                    //Se o usuário estiver excluindo será encaminhado para mesma página
                    if (tarefa.equals("Excluir")) {

                        url = "/gerenciamentoUsuarios.jsp";
                        usuarioController.Delete(Integer.parseInt(id), Integer.parseInt(cook.getValue()));
                    }
                    //Fim exclusão

                    //Se o usuário tiver preenchido os campos na tela de cadastro mesmo que editando entrar neste if
                    if (request.getParameter("cpf") != null && request.getParameter("rg") != null && request.getParameter("email") != null && request.getParameter("email") != null) {
                        url = "/cadastroUsuario.jsp";

                        //Se o usuário estiver editando ele irá pegar o ID_usuario passado pro front em uma label hiden
                        if (request.getParameter("ID_USUARIO") != null && !request.getParameter("ID_USUARIO").equals("")) {
                            usuario.setId(Integer.parseInt(request.getParameter("ID_USUARIO")));
                        }
                        //Fim resgate de ID

                        //Recuperando informações inputadas ou que consistem na tela
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
                        usuario.setIdFilial(Integer.parseInt(request.getParameter("filial")));
                        usuario.setIdPerfil(Integer.parseInt(request.getParameter("perfil")));
                        //Fim atribuição

                        boolean ok = true;
                        //Cadastro de usuário
                        if (tarefa.equals("Cadastro")) {
                            ok = usuarioController.Save(usuario);
                        }
                        //Fim cadastro
                        //Editando usuário
                        if (tarefa.equals("Editar")) {
                            ok = usuarioController.Update(usuario);
                        }
                        //Fim edição

                        url = "/gerenciamentoUsuarios.jsp";
                        //Se o usuário do cadastro foi efetuado com sucesso ele irá cadastrar/atualizar o endereço
                        if (ok) {

                            //Retorno do usuário cadastrado
                            usuario = usuarioController.UsuarioPropriedades(usuario);
                            //Pegando parâmetros e atribuindo a model

                            //Se estiver editando irá pegar o ID_endereço enviado ao front
                            if (request.getParameter("ID_ENDERECO") != null && !request.getParameter("ID_ENDERECO").equals("")) {
                                endereco.setId(Integer.parseInt(request.getParameter("ID_ENDERECO")));
                            }
                            //Fim get

                            //Recuperando valores e setando na model
                            endereco.setIdUsuario(usuario.getIdUsuario());
                            endereco.setCep(request.getParameter("cep"));
                            endereco.setRua(request.getParameter("rua"));
                            endereco.setBairro(request.getParameter("bairro"));
                            endereco.setNumero(request.getParameter("numero"));
                            endereco.setComplemento(request.getParameter("complemento"));
                            //Fim atribuição

                            //Cadastro endereço
                            boolean okEndereco = false;
                            if (tarefa.equals("Cadastro")) {
                                okEndereco = enderecoController.Save(endereco);
                            }
                            //Fim cadastro

                            //Atualizar endereço
                            if (tarefa.equals("Editar")) {
                                okEndereco = enderecoController.Update(endereco);
                            }
                            //Fim atualização

                            url = "/gerenciamentoUsuarios.jsp";

                        }
                        //Fim cadastro endereço

                    }
                    //Fim preenchimento
                }
            }
            //Fim tarefas
            //Filtro para tela de gerenciamento de usuário
            String filtroFilial = "";
            String filtroPerfil = "";
            if (request.getParameter("filtroFiliais") != null || request.getParameter("filtroPerfil") != null) {
                filtroFilial = request.getParameter("filtroFiliais");
                filtroPerfil = request.getParameter("filtroPerfil");
            }
            List<PedidoModel> pedidos = pedidoC.todosPedidos("", "", "");
            request.setAttribute("pedidos", pedidos);
            List<UsuarioModel> usuarios = usuarioController.UsuariosCadastrados(filtroFilial, filtroPerfil);
            request.setAttribute("usuarios", usuarios);
            FilialController FilialController = new FilialController();
            List<FilialModel> filiais = FilialController.FiliaisCadastradas("", "");
            request.setAttribute("filiais", filiais);
            PerfilController perfilController = new PerfilController();
            List<PerfilModel> perfis = perfilController.PerfisCadastrados("", "");
            request.setAttribute("perfis", perfis);
            
            //Fim filtros

        }
        //Fim usuario Logado

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
