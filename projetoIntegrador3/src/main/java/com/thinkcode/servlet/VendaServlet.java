/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.servlet;

import Controller.EnderecoController;
import Controller.ItensVendaController;
import Controller.ProdutoController;
import Controller.UsuarioController;
import Controller.VendaController;
import com.thinkcode.DAO.ProdutoDAO;
import com.thinkcode.DAO.UsuarioDAO;
import com.thinkcode.models.EnderecoModel;
import com.thinkcode.models.ItensVenda;
import com.thinkcode.models.ProdutoModel;
import com.thinkcode.models.UsuarioModel;
import com.thinkcode.models.VendaModel;
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
 * @author AlexSandey
 */
@WebServlet(name = "VendaServlet", urlPatterns = {"/VendaServlet"})
public class VendaServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
//
//         //Filtro para tela de gerenciamento de usuário
//            String filtroFilial = "";
//            String filtroPerfil = "";
//            
//            if (request.getParameter("filtroFiliais") != null || request.getParameter("filtroPerfil") != null) {
//                filtroFilial = request.getParameter("filtroFiliais");
//                filtroPerfil = request.getParameter("filtroPerfil");
//            }

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
            url = "/cadastroVenda.jsp";
        }
        ProdutoController produtoC = new ProdutoController();

        //List<ProdutoModel> produtos = produtoC.ProdutosCadastrados("", "");
        //request.setAttribute("produtos", produtos);
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
        Cookie cook = null;
        List<Cookie> cookies = new ArrayList<Cookie>();
        cookies = Arrays.asList(request.getCookies());
        boolean logado = true;

        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName() != null && ck.getName().equals("Id_Usuario")) {
                    cook = ck;
                    logado = true;
                }
            }
        }

        response.setContentType("text/plain");

        String html = "";
        String solicitacao = request.getParameter("solicitacao");

        if ("BuscaProduto".equals(solicitacao)) {
            String nome_produto = request.getParameter("Produto");

            ProdutoController produto = new ProdutoController();
            List<ProdutoModel> produtos = produto.ProdutosCadastrados("", "", nome_produto);
            request.setAttribute("produtos", produtos);

            for (ProdutoModel produtosHTML : produtos) {
                html += "<div class=\"col-xs-6 col-sm-3 col-md-3 thumbnail produtosVenda\" id=\"" + produtosHTML.getIdProduto() + "\">\n"
                        + ""
                        + "                                                                    <div class=\"clearfix\">                                                                    \n"
                        + "                                                                    </div>\n"
                        + "\n"
                        + "                                                                    <h3 class=\"search-title\">\n"
                        + "                                                                        <a href=\"#\" class=\"blue\">" + produtosHTML.getNome() + "</a>\n"
                        + "                                                                    </h3>\n"
                        + "                                                                    <p>" + produtosHTML.getDescricao() + "</p><br><span type=\"text\" id=\"valor_produto\" value=\"" + produtosHTML.getValor() + "\">R$ " + produtosHTML.getValor() + "</span>\n"
                        + "                                                                    <input type=\"hidden\" id=\"id_produto\" value=\"" + produtosHTML.getIdProduto() + "\"\\>\n"
                        + "                                                                    <div class=\"col-lg-12\">\n"
                        + "                                                                        <div class=\"col-lg-6\">\n"
                        + "                                                                            &nbsp;\n"
                        + "                                                                            <br>\n"
                        + "                                                                            <button class=\"btn btn-info btn-adicionar btn-bold\" onclick=\"adicionarCarrinho('" + produtosHTML.getNome() + "'," + produtosHTML.getIdProduto() + "," + produtosHTML.getValor() + ");\" >\n"
                        + "                                                                                <i\n"
                        + "                                                                                    class=\"ace-icon fa fa-plus icon-on-right\"></i>\n"
                        + "                                                                                Adicionar\n"
                        + "                                                                            </button>\n"
                        + "                                                                        </div>\n"
                        + "                                                                        <div class=\"col-lg-6\">\n"
                        + "                                                                            <label for=\"number-button\"\n"
                        + "                                                                                   class=\"block\">Quantidade</label>\n"
                        + "                                                                            <input type=\"text\" id=\"quantiaCompra" + produtosHTML.getIdProduto() + "\" placeholder =\"Qtd disponível: " + produtosHTML.getQuantidade() + "\" class=\"spinner1\" />\n"
                        + "                                                    <input type=\"hidden\" id=\"quantia" + produtosHTML.getIdProduto() + "\" value =\"" + produtosHTML.getQuantidade() + "\" />\n"
                        + "                                                                            <div class=\"space-6\"></div>\n"
                        + "                                                                        </div>\n"
                        + "                                                                    </div>\n"
                        + "                                                                    &nbsp;\n"
                        + "                                                                </div>\n";

            }

        }
        if ("BuscarCPF".equals(solicitacao)) {
            String cpf_cliente = request.getParameter("BuscarCPF");

            if (cpf_cliente != null) {
                cpf_cliente = cpf_cliente.replace("-", "");
            }

            UsuarioController cliente = new UsuarioController();
            UsuarioModel clientes = cliente.selectFromCPFPERFIL(cpf_cliente, "3");
            request.setAttribute("clientes", clientes);

            EnderecoController endereco = new EnderecoController();
            EnderecoModel enderecos = endereco.EnderecoUsuario(clientes.getIdUsuario());
            request.setAttribute("enderecoes", enderecos);

            String htmlDados = "";

            if (clientes.getNome() != null) {
                htmlDados = "<div class=\"row col-lg-12\">\n"
                        + "                                                                        <div class=\"col-lg-3\">\n"
                        + "                                                                            <label for=\"number-button\"\n"
                        + "                                                                                   class=\"block\">Nome</label>\n"
                        + "                                                                            <input type=\"text\" id=\"nomeCad\"\n"
                        + "                                                                                   placeholder=\"Nome\" value=\"" + clientes.getNome() + "\" class=\"form-control\"\n"
                        + "                                                                                   name=\"nomeCad\" disabled = 'true'/>\n"
                        + "\n"
                        + "                                                                        </div><input type='hidden' id='id_cliente' value=\"" + clientes.getIdUsuario() + "\"></input>\n"
                        + "\n"
                        + "                                                                        <div class=\"col-lg-3\">\n"
                        + "                                                                            <label for=\"number-button\"\n"
                        + "                                                                                   class=\"block\">CPF</label>\n"
                        + "                                                                            <input type=\"text\" id=\"cpfCad\"\n"
                        + "                                                                                   placeholder=\"" + cpf_cliente + "\"\n"
                        + "                                                                                   class=\"form-control input-mask-cpf\"\n"
                        + "                                                                                   name=\"cpfCad\" value=\"" + cpf_cliente + "\" disabled = \"true\"/>\n"
                        + "                                                                        </div>\n"
                        + "                                                                        <div class=\"col-lg-3\">\n"
                        + "                                                                            <label for=\"number-button\"\n"
                        + "                                                                                   class=\"block\">RG</label>\n"
                        + "                                                                            <input type=\"text\" id=\"rgCad\"\n"
                        + "                                                                                   placeholder=\"" + clientes.getRg() + "\"\n"
                        + "                                                                                   class=\"form-control\" value=\"" + clientes.getRg() + "\"\n"
                        + "                                                                                   name=\"rgCad\" disabled = \"true\" />\n"
                        + "                                                                        </div>\n"
                        + "                                                                        <div class=\"col-lg-3\">\n"
                        + "\n"
                        + "                                                                            <label for=\"number-button\" class=\"block\">Data\n"
                        + "                                                                                Nascimento</label>\n"
                        + "\n"
                        + "                                                                            <div class=\"input-group\">\n"
                        + "                                                                                <input class=\"form-control date-picker\"\n"
                        + "                                                                                       id=\"dataCad\" type=\"text\"\n"
                        + "                                                                                       placeholder=\"" + clientes.getDataNasc() + "\"\n"
                        + "                                                                                       name=\"dataCad\" value=\"" + clientes.getDataNasc() + "\" disabled = 'true'/>\n"
                        + "                                                                                <span class=\"input-group-addon\">\n"
                        + "                                                                                    <i\n"
                        + "                                                                                        class=\"fa fa-calendar bigger-110\"></i>\n"
                        + "                                                                                </span>\n"
                        + "                                                                            </div>\n"
                        + "\n"
                        + "\n"
                        + "                                                                        </div>\n"
                        + "                                                                        <div class=\"col-lg-3\">\n"
                        + "                                                                            <label for=\"number-button\"\n"
                        + "                                                                                   class=\"block\">Telefone</label>\n"
                        + "                                                                            <div class=\"input-group\">\n"
                        + "                                                                                <span class=\"input-group-addon\">\n"
                        + "                                                                                    <i class=\"ace-icon fa fa-phone\"></i>\n"
                        + "                                                                                </span>\n"
                        + "\n"
                        + "                                                                                <input class=\"form-control input-mask-phone\"\n"
                        + "                                                                                       placeholder = \"" + clientes.getTelefone() + "\"  type=\"telCad\" id=\"telCad\"\n"
                        + "                                                                                       name=\"telCad\" value=\"" + clientes.getTelefone() + "\" disabled = 'true'/>\n"
                        + "                                                                            </div>\n"
                        + "                                                                        </div>\n"
                        + "                                                                        <div class=\"col-lg-3\">\n"
                        + "                                                                            <label for=\"number-button\"\n"
                        + "                                                                                   class=\"block\">E-mail</label>\n"
                        + "                                                                            <input type=\"text\" id=\"emailCad\"\n"
                        + "                                                                                   placeholder=\"" + clientes.getEmail() + "\" class=\"form-control\"\n"
                        + "                                                                                   name=\"emailCad\" value=\"" + clientes.getEmail() + "\" disabled= 'true'/>\n"
                        + "                                                                        </div>\n"
                        + "\n";

                if ("Masculino".equals(clientes.getSexo())) {
                    htmlDados += "<div class=\"col-lg-3\" >\n"
                            + "                                                                            <label for=\"number-button\"\n"
                            + "                                                                                   class=\"block\">Sexo</label>\n"
                            + "                                                                            <div class=\"radio\">\n"
                            + "                                                                                <label>\n"
                            + "                                                                                    <input name=\"sexoRadio\" type=\"radio\"\n"
                            + "                                                                                           class=\"form-control ace\" CHECKED disabled = 'true'/>\n"
                            + "                                                                                    <span class=\"lbl\"> Masculino</span>\n"
                            + "                                                                                </label>\n"
                            + "                                                                            </div>\n"
                            + "\n"
                            + "                                                                            <div class=\"radio\">\n"
                            + "                                                                                <label>\n"
                            + "                                                                                    <input name=\"sexoRadio\" type=\"radio\"\n"
                            + "                                                                                           class=\"form-control ace\" disabled = 'true'/>\n"
                            + "                                                                                    <span class=\"lbl\"> Feminino</span>\n"
                            + "                                                                                </label>\n"
                            + "                                                                            </div>\n"
                            + "                                                                        </div>";

                } else {
                    htmlDados += "<div class=\"col-lg-3\" >\n"
                            + "                                                                            <label for=\"number-button\"\n"
                            + "                                                                                   class=\"block\">Sexo</label>\n"
                            + "                                                                            <div class=\"radio\">\n"
                            + "                                                                                <label>\n"
                            + "                                                                                    <input name=\"sexoRadio\" type=\"radio\"\n"
                            + "                                                                                           class=\"form-control ace\" disabled = 'true' />\n"
                            + "                                                                                    <span class=\"lbl\"> Masculino</span>\n"
                            + "                                                                                </label>\n"
                            + "                                                                            </div>\n"
                            + "\n"
                            + "                                                                            <div class=\"radio\">\n"
                            + "                                                                                <label>\n"
                            + "                                                                                    <input name=\"sexoRadio\" type=\"radio\"\n"
                            + "                                                                                           class=\"form-control ace\" CHECKED disabled = 'true' />\n"
                            + "                                                                                    <span class=\"lbl\"> Feminino</span>\n"
                            + "                                                                                </label>\n"
                            + "                                                                            </div>\n"
                            + "                                                                        </div>";
                }
                htmlDados += "                                                                    <div class=\"row  col-lg-12\">\n"
                        + "\n"
                        + "                                                                        <div class=\"col-lg-3\">\n"
                        + "                                                                            <label for=\"number-button\"\n"
                        + "                                                                                   class=\"block\">Rua</label>\n"
                        + "                                                                            <div class=\"input-group\">\n"
                        + "                                                                                <span class=\"input-group-addon\">\n"
                        + "                                                                                    <i class=\"ace-icon fa fa-map\"></i>\n"
                        + "                                                                                </span>\n"
                        + "                                                                                <input type=\"text\" id=\"ruaCad\"\n"
                        + "                                                                                       placeholder=\"" + enderecos.getRua() + "\"\n"
                        + "                                                                                       class=\"form-control\" name=\"ruaCad\" value=\"" + enderecos.getRua() + "\" disabled = \"true\"/>\n"
                        + "                                                                            </div>\n"
                        + "                                                                        </div>\n"
                        + "\n"
                        + "                                                                        <div class=\"col-lg-3\">\n"
                        + "                                                                            <label for=\"number-button\"\n"
                        + "                                                                                   class=\"block\">CEP</label>\n"
                        + "\n"
                        + "                                                                            <input type=\"text\" id=\"cepCad\"\n"
                        + "                                                                                   placeholder=\"" + enderecos.getCep() + "\"\n"
                        + "                                                                                   class=\"form-control\" value=\"" + enderecos.getCep() + "\" input-mask-cep\"\n"
                        + "                                                                                   name=\"cepCad\" disabled = \"true\" />\n"
                        + "                                                                        </div>\n"
                        + "\n"
                        + "                                                                        <div class=\"col-lg-3\">\n"
                        + "                                                                            <label for=\"number-button\"\n"
                        + "                                                                                   class=\"block\">Bairro</label>\n"
                        + "                                                                            <input type=\"text\" id=\"bairroCad\"\n"
                        + "                                                                                   placeholder=\"" + enderecos.getBairro() + "\"\n"
                        + "                                                                                   class=\"form-control\" name=\"bairroCad\" value=\"" + enderecos.getBairro() + "\" disabled = \"true\"/>\n"
                        + "                                                                        </div>\n"
                        + "                                                                        <div class=\"col-lg-3\">\n"
                        + "\n"
                        + "                                                                            <label for=\"number-button\" class=\"block\">Numero\n"
                        + "                                                                            </label>\n"
                        + "                                                                            <input class=\"form-control\" type=\"number\"\n"
                        + "                                                                                   placeholder=\"" + enderecos.getNumero() + "\"\n"
                        + "                                                                                   id=\"numeroCad\" name=\"numeroCad\" value=\"" + enderecos.getNumero() + "\" disabled = 'true'/>\n"
                        + "                                                                        </div>\n"
                        + "                                                                        <div class=\"col-lg-3\">\n"
                        + "                                                                            <label for=\"number-button\"\n"
                        + "                                                                                   class=\"block\">" + enderecos.getComplemento() + "</label>\n"
                        + "\n"
                        + "                                                                            <input class=\"form-control\" type=\"text\"\n"
                        + "                                                                                   id=\"complementoCad\" name=\"complementoCad\" disabled = 'true' />\n"
                        + "\n"
                        + "                                                                        </div>\n"
                        + "                                                                    </div>";

                html = htmlDados;
            } else {
                html = "erroPerfil";
            }

        } else if ("Teste".equals(solicitacao)) {

            String nome_produto = request.getParameter("BuscarProduto");
            String cpf = request.getParameter("BuscarCPF");

            if (cpf != null) {
                cpf = cpf.replace("-", "");
            }
            UsuarioModel cliente = new UsuarioModel();

            UsuarioController clienteC = new UsuarioController();
            cliente.setCpfCnpj(cpf);

            cliente = clienteC.UsuarioPropriedades(cliente);

            request.setAttribute("nomeUsuario", cliente.getNome());
            UsuarioModel usuarios = UsuarioController.selectFromCPFPERFIL(cpf, "3");
            request.setAttribute("usuario", usuarios);

        }
        if ("SalvarCompra".equals(solicitacao)) {
            int metodoS_produto = Integer.parseInt(request.getParameter("Metodo"));
            String parcelaS_produto = request.getParameter("Parcelas");
            Double totalS_produto = Double.parseDouble(request.getParameter("Total"));
            String idS_produto = request.getParameter("Id_produtos");
            String qtdS_produto = request.getParameter("Qtd_produtos");
            String valrS_produto = request.getParameter("Vlrs_produtos");
            String cpf_produto = request.getParameter("Cpf_cliente").replace("-", "");
            Date data = new Date();

            //ID PRODUTO 
            if (idS_produto.length() > 0) {
                idS_produto = idS_produto.substring(0, idS_produto.length() - 1);
            }

            String[] splitted = idS_produto.split(",");

            int[] array = new int[splitted.length];

            for (int i = 0; i < splitted.length; i++) {
                array[i] = Integer.parseInt(splitted[i]);
            }

            //QTS PRODUTO            
            if (qtdS_produto.length() > 0) {
                qtdS_produto = qtdS_produto.substring(0, qtdS_produto.length() - 1);
            }

            String[] splitted1 = qtdS_produto.split(",");

            int[] array1 = new int[splitted1.length];

            for (int i = 0; i < splitted1.length; i++) {
                array1[i] = Integer.parseInt(splitted1[i]);
            }

            //VLR PRODUTO
            if (valrS_produto.length() > 0) {
                valrS_produto = valrS_produto.substring(0, valrS_produto.length() - 1);
            }
            String[] splitted2 = valrS_produto.split(",");

            float[] array2 = new float[splitted2.length];

            for (int i = 0; i < splitted2.length; i++) {
                array2[i] = Float.parseFloat(splitted2[i]);
            }

            VendaModel venda = new VendaModel();
            venda.setCpfCnpj(cpf_produto);
            venda.setIdUsuario(Integer.parseInt(cook.getValue()));
            venda.setCodRastreio("");
            Date dataIncl = new Date();
            venda.setData(dataIncl.toInstant().toString().substring(0, 10));

            UsuarioController usuarioController = new UsuarioController();

            UsuarioModel usuario = new UsuarioModel();
            usuario.setId(Integer.parseInt(cook.getValue()));
            usuario = usuarioController.UsuarioPropriedades(usuario);

            venda.setIdFilial(usuario.getIdFilial());
            venda.setParcelas(Integer.parseInt(parcelaS_produto));
            venda.setIdEndereco(1);
            venda.setIdStatus(3);
            venda.setTotal(totalS_produto);
            venda.setPagamento(metodoS_produto);

            VendaController vendaC = new VendaController();
            vendaC.save(venda);

            venda.setIdVenda(vendaC.consultaUltimoId());

            ItensVendaController itensC = new ItensVendaController();
            ProdutoController produtosC = new ProdutoController();

            for (int i = 0; i < array.length; i++) {
                ItensVenda item = new ItensVenda();
                item.setIdProduto(array[i]);
                item.setQntd(array1[i]);
                item.setValor(array2[i]);
                item.setIdVenda(venda.getIdVenda());
                boolean bubu = itensC.save(item);
                boolean bubu2 = produtosC.UpdateQtde(array[i], array1[i]);
            }

        }

        PrintWriter out = response.getWriter();
        out.print(html);

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
