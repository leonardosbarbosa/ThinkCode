<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>Dashboard</title>

        <meta name="description" content="overview &amp; stats" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <!-- bootstrap & fontawesome -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

        <!-- page specific plugin styles -->

        <!-- text fonts -->
        <link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

        <!-- ace styles -->
        <link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

        <!--[if lte IE 9]>
                            <link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
                    <![endif]-->
        <link rel="stylesheet" href="assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

        <!--[if lte IE 9]>
                      <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
                    <![endif]-->

        <!-- inline styles related to this page -->

        <!-- page specific plugin styles -->
        <link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
        <link rel="stylesheet" href="assets/css/chosen.min.css" />
        <link rel="stylesheet" href="assets/css/bootstrap-datepicker3.min.css" />
        <link rel="stylesheet" href="assets/css/bootstrap-timepicker.min.css" />
        <link rel="stylesheet" href="assets/css/daterangepicker.min.css" />
        <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css" />
        <link rel="stylesheet" href="assets/css/bootstrap-colorpicker.min.css" />

        <!-- ace settings handler -->
        <script src="assets/js/ace-extra.min.js"></script>
        <style>
        </style>
        <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

        <!--[if lte IE 8]>
                    <script src="assets/js/html5shiv.min.js"></script>
                    <script src="assets/js/respond.min.js"></script>
                    <![endif]-->
    </head>

    <body class="no-skin">



        <div id="navbar" class="navbar navbar-default          ace-save-state">
            <div class="navbar-container ace-save-state" id="navbar-container">
                <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                    <span class="sr-only">Toggle sidebar</span>

                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>
                </button>

                <div class="navbar-header pull-left">
                    <a href="IndexServlet" class="navbar-brand">
                        <small>
                            <img src="assets/images/gallery/reparar.png" width="12%;">
                            <!-- <i class="fa fa-leaf"></i> -->
                            Portal Tades
                        </small>
                    </a>
                </div>

                <div class="navbar-buttons navbar-header pull-right" role="navigation">
                    <ul class="nav ace-nav">
                        <li class="light-blue dropdown-modal">
                            <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                                <img class="nav-user-photo" src="assets/images/avatars/user.jpg" alt="Jason's Photo" />
                                <span class="user-info">
                                    <small>Bem-Vindo,</small>
                                    <%
                                        Cookie[] cookies = request.getCookies();

                                        for (Cookie cookie : cookies) {
                                            if (cookie.getName().equals("Nome")) {
                                                out.println(cookie.getValue());
                                            }
                                        }

                                    %>
                                </span>

                                <i class="ace-icon fa fa-caret-down"></i>
                            </a>

                            <ul
                                class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                                <li>
                                    <a href="#">
                                        <i class="ace-icon fa fa-cog"></i>
                                        Settings
                                    </a>
                                </li>

                                <li>
                                    <a href="profile.html">
                                        <i class="ace-icon fa fa-user"></i>
                                        Profile
                                    </a>
                                </li>

                                <li class="divider"></li>

                                <li>
                                    <a href="#">
                                        <i class="ace-icon fa fa-power-off"></i>
                                        Logout
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div><!-- /.navbar-container -->
        </div>

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.loadState('main-container')
                } catch (e) {
                }
            </script>

            <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
                <script type="text/javascript">
                    try {
                        ace.settings.loadState('sidebar')
                    } catch (e) {
                    }
                </script>

                <ul class="nav nav-list">
                    <li class="active">
                        <a href="IndexServlet">
                            <i class="menu-icon fa fa-tachometer"></i>
                            <span class="menu-text"> Dashboard </span>
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-book"></i>
                            <span class="menu-text">
                                Relatórios
                            </span>

                            <b class="arrow fa fa-angle-down"></b>
                        </a>

                        <b class="arrow"></b>

                        <ul class="submenu">
                            <li class="">
                                <a href="RelatorioServlet">
                                    <i class="menu-icon fa fa-caret-right"></i> Vendas
                                </a>

                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="e#">
                                    <i class="menu-icon fa fa-caret-right"></i> Estoque
                                </a>

                                <b class="arrow"></b>
                            </li>


                            <li class="">
                                <a href="#">
                                    <i class="menu-icon fa fa-caret-right"></i> Usuário
                                </a>

                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="SolicitacaoServlet">
                                    <i class="menu-icon fa fa-caret-right"></i> Solicitações
                                </a>

                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>

                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-pencil-square-o"></i>
                            <span class="menu-text">
                                Cadastro
                            </span>

                            <b class="arrow fa fa-angle-down"></b>
                        </a>

                        <b class="arrow"></b>

                        <ul class="submenu">
                            <li class="">
                                <a href="FilialServlet">
                                    <i class="menu-icon glyphicon glyphicon-home"></i> Filial
                                </a>

                            </li>
                            <li class="">
                                <a href="PerfilServlet">
                                    <i class="menu-icon glyphicon glyphicon-cog"></i> Perfil

                                </a>

                            </li>
                            <li class="">
                                <a  href="ProdutoServlet">
                                    <i class="menu-icon glyphicon glyphicon-barcode"></i> Produto

                                </a>

                            </li>
                            <li class="">
                                <a href="UsuarioServlet" id="CadastroUsuario">
                                    <i class="menu-icon fa fa-user"></i> Usuario

                                </a>

                            </li>

                        </ul>
                    </li>

                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-desktop"></i>
                            <span class="menu-text">
                                Compra/Venda
                            </span>

                            <b class="arrow fa fa-angle-down"></b>
                        </a>

                        <b class="arrow"></b>

                        <ul class="submenu">

                            <li class="">
                                <a href="VendaServlet" >
                                    <i class="menu-icon fa fa-money"></i> Vendas
                                </a>

                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="SolicitacaoServlet?tarefa=Cadastrando" >
                                    <i class="menu-icon fa fa-product-hunt"></i> Solicitações
                                </a>

                                <b class="arrow"></b>
                            </li>

                        </ul>
                    </li>
                </ul>

                <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                    <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
                       data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
                </div>
            </div>

            <div class="main-content">
                <div class="main-content-inner">

                    <div class="page-content">

                        <div class="widget-box">
                            <div class="widget-header widget-header-blue widget-header-flat">
                                <h4 class="widget-title lighter">Nova venda</h4>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main">
                                    <div id="fuelux-wizard-container">
                                        <div>
                                            <ul class="steps">
                                                <li data-step="1" class="active">
                                                    <span class="step">1</span>
                                                    <span class="title">Dados comprador</span>
                                                </li>

                                                <li data-step="2">
                                                    <span class="step">2</span>
                                                    <span class="title">Dados do produto</span>
                                                </li>

                                                <li data-step="3">
                                                    <span class="step">3</span>
                                                    <span class="title">Informações de pagamento</span>
                                                </li>

                                                <li data-step="4">
                                                    <span class="step">4</span>
                                                    <span class="title">Confirmação</span>
                                                </li>
                                            </ul>
                                        </div>

                                        <hr />

                                        <div class="step-content pos-rel">
                                            <div class="step-pane active" data-step="1">


                                                <form class="form-horizontal" id="formularioCadastro">
                                                    <div class="widget-body">
                                                        <div class="widget-main">
                                                            <div class="form-group">

                                                                <div class="col-lg-12">
                                                                    <label for="number-button" class="block">Usuario
                                                                        cadastrado?</label>
                                                                    <div class="radio">
                                                                        <label>
                                                                            <input name="userRegister" type="radio"
                                                                                   class="ace" id="radio_sim" value="1" />
                                                                            <span class="lbl"> Sim</span>
                                                                        </label>
                                                                    </div>

                                                                    <div class="radio">
                                                                        <label>
                                                                            <input name="userRegister" type="radio"
                                                                                   class="ace" id="radio_nao" value="2" />
                                                                            <span class="lbl"> Não</span>
                                                                        </label>
                                                                    </div>
                                                                </div>

                                                                <div class="col-lg-12" id="buscaCliente"
                                                                     style="display: none;">
                                                                    <div class="row col-lg-3">
                                                                        <br><label for="number-button" class="block"> Buscar CPF </label>
                                                                        <div class="input-group">

                                                                            <input type="text"
                                                                                   class="form-control input-mask-cpf"
                                                                                   name="keywords" id="buscaCPF" placeholder="CPF" />
                                                                            <div class="input-group-btn">
                                                                                <button type="button" id="procurarCliente"
                                                                                        class="btn btn-default no-border btn-sm">
                                                                                    <i
                                                                                        class="ace-icon fa fa-search icon-on-right bigger-110"></i>
                                                                                </button>
                                                                            </div>

                                                                        </div>

                                                                    </div><br><br><br><br><br><br>  
                                                                </div>

                                                                <c:forEach var="usuario" items="${usuario}">
                                                                    <option value="${usuario.idFilial}">
                                                                        ${usuario.nome}
                                                                    </option>
                                                                </c:forEach>

                                                                <div class="row col-lg-12" id="infosClientes"
                                                                     style="display: none;">
                                                                    <div class="row col-lg-12">
                                                                        <div class="col-lg-3">
                                                                            <label for="number-button"
                                                                                   class="block">Nome</label>
                                                                            <input type="text" id="nomeCad"
                                                                                   placeholder="Nome" value="" class="form-control"
                                                                                   name="nomeCad" />

                                                                        </div>

                                                                        <div class="col-lg-3">
                                                                            <label for="number-button"
                                                                                   class="block">CPF</label>
                                                                            <input type="text" id="cpfCad"
                                                                                   placeholder="000-000-000-00"
                                                                                   class="form-control input-mask-cpf"
                                                                                   name="cpfCad" />
                                                                        </div>
                                                                        <div class="col-lg-3">
                                                                            <label for="number-button"
                                                                                   class="block">RG</label>
                                                                            <input type="text" id="rgCad"
                                                                                   placeholder="00-000-000-0"
                                                                                   class="form-control input-mask-rg"
                                                                                   name="rgCad" />
                                                                        </div>
                                                                        <div class="col-lg-3">

                                                                            <label for="number-button" class="block">Data
                                                                                Nascimento</label>

                                                                            <div class="input-group">
                                                                                <input class="form-control date-picker"
                                                                                       id="dataCad" type="text"
                                                                                       data-date-format="dd-mm-yyyy"
                                                                                       name="dataCad" />
                                                                                <span class="input-group-addon">
                                                                                    <i
                                                                                        class="fa fa-calendar bigger-110"></i>
                                                                                </span>
                                                                            </div>


                                                                        </div>
                                                                        <div class="col-lg-3">
                                                                            <label for="number-button"
                                                                                   class="block">Telefone</label>
                                                                            <div class="input-group">
                                                                                <span class="input-group-addon">
                                                                                    <i class="ace-icon fa fa-phone"></i>
                                                                                </span>

                                                                                <input class="form-control input-mask-phone"
                                                                                       type="telCad" id="telCad"
                                                                                       name="telCad" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-lg-3">
                                                                            <label for="number-button"
                                                                                   class="block">E-mail</label>
                                                                            <input type="text" id="emailCad"
                                                                                   placeholder="E-mail" class="form-control"
                                                                                   name="emailCad" />
                                                                        </div>

                                                                        <div class="col-lg-3">
                                                                            <label for="number-button"
                                                                                   class="block">Sexo</label>
                                                                            <div class="radio">
                                                                                <label>
                                                                                    <input name="sexoRadio" type="radio"
                                                                                           class="form-control ace" value="masculino"/>
                                                                                    <span class="lbl"> Masculino</span>
                                                                                </label>
                                                                            </div>

                                                                            <div class="radio">
                                                                                <label>
                                                                                    <input name="sexoRadio" type="radio"
                                                                                           class="form-control ace" value="feminino"/>
                                                                                    <span class="lbl"> Feminino</span>
                                                                                </label>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row  col-lg-12">

                                                                        <div class="col-lg-3">
                                                                            <label for="number-button"
                                                                                   class="block">Rua</label>
                                                                            <div class="input-group">
                                                                                <span class="input-group-addon">
                                                                                    <i class="ace-icon fa fa-map"></i>
                                                                                </span>
                                                                                <input type="text" id="ruaCad"
                                                                                       placeholder="Nome da rua"
                                                                                       class="form-control" name="ruaCad" />
                                                                            </div>
                                                                        </div>

                                                                        <div class="col-lg-3">
                                                                            <label for="number-button"
                                                                                   class="block">CEP</label>

                                                                            <input type="text" id="cepCad"
                                                                                   placeholder="Nome" placeholder="000.00-000"
                                                                                   class="form-control input-mask-cep"
                                                                                   name="cepCad" />
                                                                        </div>

                                                                        <div class="col-lg-3">
                                                                            <label for="number-button"
                                                                                   class="block">Bairro</label>
                                                                            <input type="text" id="bairroCad"
                                                                                   placeholder="Nome do bairro"
                                                                                   class="form-control" name="bairroCad" />
                                                                        </div>
                                                                        <div class="col-lg-3">

                                                                            <label for="number-button" class="block">Numero
                                                                            </label>
                                                                            <input class="form-control" type="number"
                                                                                   placeholder="Número da casa/apto"
                                                                                   id="numeroCad" name="numeroCad" />
                                                                        </div>
                                                                        <div class="col-lg-3">
                                                                            <label for="number-button"
                                                                                   class="block">Complemento</label>

                                                                            <input class="form-control" type="text"
                                                                                   id="complementoCad" name="complementoCad" />

                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <label>
                                                                &nbsp;<br />


                                                            </label>
                                                        </div>
                                                    </div>

                                                </form>

                                            </div>

                                            <div class="step-pane" data-step="2">
                                                <div class="row col-lg-12">
                                                    <div class="row col-lg-3">

                                                        <div class="input-group">
                                                            <input type="text" class="form-control" name="keywords"
                                                                   placeholder="Filtro" id="nome_produto" />
                                                            <div class="input-group-btn">
                                                                <button type="button"
                                                                        class="btn btn-default no-border btn-sm" id="filtroProduto">
                                                                    <i
                                                                        class="ace-icon fa fa-search icon-on-right bigger-110"></i>
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div><br><br><br>
                                                </div>
                                                <div class="col-lg-12">
                                                    <div>
                                                        <span id="mostrarProdutos"></span>
                                                    </div>
                                                </div>
                                                <div class="col-lg-12 thumbnail" style="width: 500px; ">
                                                    <div class="form-group" id="carrinho">
                                                        <div class="col-lg-6">
                                                            <label for="form-field-select-2">Carrinho</label>

                                                            <div id="itens"></div>
                                                            <input type="hidden" id="valida_carrinho" value="0"/>
                                                        </div>
                                                    </div>

                                                    <div class="col-lg-12">
                                                        <div class="col-lg-6">
                                                            <br><label for="number-button" class="block">Valor Total</label>R$: <input id="totalCarrinho" disabled value="0"/>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>

                                            <div class="step-pane" data-step="3">
                                                <form class="form-horizontal" id="formularioPagamento">
                                                    <div class="row col-lg-12">
                                                        <div>
                                                            <label for="form-field-select-3">Selecione o metodo de
                                                                pagamento</label>

                                                            <br />
                                                            <select class="chosen-select form-control" id="selectPagamento">
                                                                <option value="0"> Selecione o metodo de pagamento</option>
                                                                <option value="1">Cartão de crédito</option>
                                                                <option value="2">Cartão de débito</option>
                                                                <option value="3">Dinheiro</option>

                                                            </select>
                                                        </div>
                                                </form>
                                            </div>

                                            <div class="row col-lg-12" id="infoDinheiro" style="display: none;">
                                                <div class="row col-lg-3">
                                                    <label for="number-button" class="block">Valor Recebido</label>
                                                    <input type="text" id="form-field-1-1" placeholder="Valor Recebido"
                                                           class="form-control" name="ValorRecebido" />
                                                </div>
                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">Valor Total</label>
                                                    <input type="text" id="form-field-1-1" placeholder="Valor Recebido"
                                                           class="form-control" name="ValorTotal" />
                                                </div>
                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">Troco</label>
                                                    <input type="text" id="form-field-1-1" placeholder="Troco"
                                                           class="form-control" name="Troco" />
                                                </div>
                                            </div>

                                        </div>

                                        <div class="step-pane" data-step="4">
                                            <div class="col-lg-12">

                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">Nome</label>
                                                    <input type="text" id="nomeFinal" 
                                                           class="form-control" disabled />

                                                </div>

                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">CPF</label>
                                                    <input type="text" id="cpfFinal" 
                                                           class="form-control input-mask-cpf" disabled />

                                                </div>

                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">RG</label>
                                                    <input type="text" id="rgFinal" 
                                                           class="form-control input-mask-rg" disabled />

                                                </div>
                                            </div>

                                            <div class="col-lg-12">

                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">CEP</label>

                                                    <input type="text" id="cepFinal" 
                                                           class="form-control input-mask-cep"
                                                           name="cep" disabled/>

                                                </div>


                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">Rua</label>
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="ace-icon fa fa-map"></i>
                                                        </span>
                                                        <input type="text" id="ruaFinal" disabled class="form-control" name="rua" />
                                                    </div>
                                                </div>

                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">Bairro</label>
                                                    <input type="text" id="bairroFinal" disabled
                                                           class="form-control" name="bairro" />
                                                </div>

                                                <div class="col-lg-3">

                                                    <label for="number-button" class="block">Número </label>
                                                    <input class="form-control" type="text"
                                                           disabled id="numeroFinal"
                                                           name="numero" />
                                                </div>

                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">Complemento</label>

                                                    <input class="form-control" type="text" id="complementoFinal"
                                                           name="complemento" disabled/>

                                                </div>
                                                
                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">Telefone</label>

                                                    <input class="form-control" type="text" id="telefoneFinal"
                                                           name="telefone" disabled/>

                                                </div>
                                            </div>

                                            <div class="col-lg-12">
                                                <div class="col-lg-10">
                                                    <label for="form-field-select-2">Produtos selecionados</label>

                                                    <div id="itensFinal"></div>

                                                </div>

                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">Metodo pagamento</label>
                                                    <input type="text" id="metodoFinal" 
                                                           class="form-control" name="nome" disabled/>

                                                </div>
                                                <div class="col-lg-3">
                                                    <label for="number-button" class="block">Valor total</label>
                                                    <input type="text" id="totalFinal" disabled
                                                           class="form-control" name="nome" />

                                                </div>
                                            </div>



                                        </div>
                                    </div>
                                </div>

                                <hr />
                                <div class="wizard-actions">
                                    <button class="btn btn-white btn-info btn-bold btn-prev" id="btnVoltar">
                                        <i class="ace-icon fa fa-arrow-left"></i>
                                        Voltar
                                    </button>


                                    <button type="submit" class="btn btn-white btn-info btn-bold btn-next" data-last="Finalizar"
                                            id="btnProximo"> Prosseguir <i class="ace-icon fa fa-arrow-right" disabled="false"></i></button>


                                </div>
                            </div><!-- /.widget-main -->
                        </div><!-- /.widget-body -->
                    </div>

                    <div id="modal-wizard" class="modal">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div id="modal-wizard-container">
                                    <div class="modal-header">
                                        <ul class="steps">
                                            <li data-step="1" class="active">
                                                <span class="step">1</span>
                                                <span class="title">Validation states</span>
                                            </li>

                                            <li data-step="2">
                                                <span class="step">2</span>
                                                <span class="title">Alerts</span>
                                            </li>

                                            <li data-step="3">
                                                <span class="step">3</span>
                                                <span class="title">Payment Info</span>
                                            </li>

                                            <li data-step="4">
                                                <span class="step">4</span>
                                                <span class="title">Other Info</span>
                                            </li>
                                        </ul>
                                    </div>

                                    <div class="modal-body step-content">
                                        <div class="step-pane active" data-step="1">
                                            <div class="center">
                                                <h4 class="blue">Step 1</h4>
                                            </div>
                                        </div>

                                        <div class="step-pane" data-step="2">
                                            <div class="center">
                                                <h4 class="blue">Step 2</h4>
                                            </div>
                                        </div>

                                        <div class="step-pane" data-step="3">
                                            <div class="center">
                                                <h4 class="blue">Step 3</h4>
                                            </div>
                                        </div>

                                        <div class="step-pane" data-step="4">
                                            <div class="center">
                                                <h4 class="blue">Step 4</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="modal-footer wizard-actions">
                                    <button class="btn btn-sm btn-prev">
                                        <i class="ace-icon fa fa-arrow-left"></i>
                                        Prev
                                    </button>

                                    <button class="btn btn-success btn-sm btn-next" data-last="Finish">
                                        Next
                                        <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                    </button>

                                    <button class="btn btn-danger btn-sm pull-left" data-dismiss="modal">
                                        <i class="ace-icon fa fa-times"></i>
                                        Cancel
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div><!-- PAGE CONTENT ENDS -->
                </div><!-- /.widget-body -->
            </div>
            <!-- /.ace-settings-container -->
            <div class="footer">
                <div class="footer-inner" >
                     <div class="footer-content">
                            <span class="bigger-120">
                                <span class="blue bolder">ThinkCode
                            </span>
    
                            &nbsp; &nbsp;
                            <span class="action-buttons">
                                <a href="#">
                                    <i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
                                </a>
    
                                <a href="#">
                                    <i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
                                </a>
    
                                <a href="#">
                                    <i class="ace-icon fa fa-rss-square orange bigger-150"></i>
                                </a>
                            </span>
                        </div> 
                </div>
            </div>

            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>

        </div><!-- /.main-container -->


        <!-- basic scripts -->

        <!--[if !IE]> -->
        <script src="assets/js/jquery-2.1.4.min.js"></script>

        <!-- <![endif]-->

        <!--[if IE]>
    <script src="assets/js/jquery-1.11.3.min.js"></script>
    <![endif]-->
        <script type="text/javascript">
                    if ('ontouchstart' in document.documentElement)
                        document.write(
                                "<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");</script>
        <script src="assets/js/bootstrap.min.js"></script>



        <!-- page specific plugin scripts -->
        <script src="assets/js/wizard.min.js"></script>
        <script src="assets/js/jquery.validate.min.js"></script>
        <script src="assets/js/jquery-additional-methods.min.js"></script>
        <script src="assets/js/bootbox.js"></script>
        <script src="assets/js/jquery.maskedinput.min.js"></script>
        <script src="assets/js/select2.min.js"></script>
        <script src="assets/js/jquery.bootstrap-duallistbox.min.js"></script>

        <!--[if lte IE 8]>
                      <script src="assets/js/excanvas.min.js"></script>
                    <![endif]-->
        <script src="assets/js/jquery-ui.custom.min.js"></script>
        <script src="assets/js/jquery.ui.touch-punch.min.js"></script>
        <script src="assets/js/jquery.easypiechart.min.js"></script>
        <script src="assets/js/jquery.sparkline.index.min.js"></script>
        <script src="assets/js/jquery.flot.min.js"></script>
        <script src="assets/js/jquery.flot.pie.min.js"></script>
        <script src="assets/js/jquery.flot.resize.min.js"></script>
        <script src="assets/js/jquery.maskedinput.min.js"></script>
        <script src="assets/js/bootstrap-datepicker.min.js"></script>
        <!-- ace scripts -->
        <script src="assets/js/ace-elements.min.js"></script>
        <script src="assets/js/ace.min.js"></script>
        <script src="assets/js/spinbox.min.js"></script>


        <!-- inline scripts related to this page -->
        <script type="text/javascript">
                    localStorage.clear();
                    var posicaoCarrinho = 1;
                    var pagAtual = 0;
                    jQuery(function ($) {

                        $('#btnProximo').click(function () {
                            pagAtual++;
                            if (pagAtual === 4) {
                                var cpfcnpjSALVAR = $('#cpfCad').val();
                                var rgSALVAR = $('#rgCad').val();                                
                                var nomeSALVAR = $('#nomeCad').val();
                                var emailSALVAR = $('#emailCad').val();
                                var telefoneSALVAR = $('#telCad').val();
                                var sexoSALVAR = $("input[name='sexoRadio']:checked").val();
                                var dataSALVAR = $('#dataCad').val();                                
                                var metodopagSALVAR = $("#selectPagamento option:selected").val();
                                var parcelasSALVAR = "0";
                                var totalSALVAR = $('#totalCarrinho').val();
                                var id_produto = "";
                                var quantidade_produto = "";
                                var valor_produto = "";

                                var ruaSALVAR = $('#ruaCad').val();
                                var cepSALVAR = $('#cepCad').val();
                                var bairroSALVAR = $('#bairroCad').val();
                                var numeroSALVAR = $('#numeroCad').val();
                                var complementoSALVAR = $('#complementoCad').val();

 
                                for (var i = 1; i <= posicaoCarrinho - 1; i++) {
                                    var atual = localStorage.getItem("salvar" + i);
                                    id_produto += atual + ",";
                                    
                                }

                                for (var i = 1; i <= posicaoCarrinho - 1; i++) {
                                    var atual = localStorage.getItem("qtd" + i);
                                    quantidade_produto += atual + ",";
                                }

                                for (var i = 1; i <= posicaoCarrinho - 1; i++) {
                                    var atual = localStorage.getItem("valor" + i);
                                    valor_produto += atual + ",";
                                }
                                radioValue = $("input[name='userRegister']:checked").val();
                                $.ajax({
                                    type: 'POST',
                                    data: {
                                        solicitacao: 'SalvarCompra',
                                        Metodo: metodopagSALVAR,
                                        Parcelas: parcelasSALVAR,
                                        Total: totalSALVAR,
                                        Id_produtos: id_produto,
                                        Qtd_produtos: quantidade_produto,
                                        Cpf_cliente: cpfcnpjSALVAR,
                                        Rg_cliente:  rgSALVAR,
                                        Nome_cliente: nomeSALVAR,
                                        Email_cliente: emailSALVAR,
                                        Telefone_cliente: telefoneSALVAR,
                                        Sexo_cliente: sexoSALVAR,
                                        Data_cliente: dataSALVAR,                                      
                                        Vlrs_produtos: valor_produto,
                                        
                                        Rua_cliente: ruaSALVAR,
                                        Cep_cliente: cepSALVAR,
                                        Bairro_cliente: bairroSALVAR,
                                        Numero_cliente: numeroSALVAR,
                                        Complemento_cliente: complementoSALVAR,
                                                
                                        salvarCliente: radioValue
                                         
                                    },
                                    url: 'VendaServlet',
                                    success: function (result) {
                                        alert("Compra registrada com sucesso !");
                                        document.location.reload(true);
                                        console.log(result);
                                    }
                                });
                            }
                            if (pagAtual == 3) {
                                var nome = $('#nomeCad').val();
                                var cpf = $('#cpfCad').val();
                                var rg = $('#rgCad').val();
                                var data = $('#dataCad').val();
                                var tel = $('#telCad').val();
                                var email = $('#emailCad').val();
                                var rua = $('#ruaCad').val();
                                var cep = $('#cepCad').val();
                                var bairro = $('#bairroCad').val();
                                var numero = $('#numeroCad').val();
                                var metodo = $("#selectPagamento option:selected").val();
                                
                                if(metodo == 1){
                                    metodo = "Cartão de Crédito";
                                }else if (metodo == 2){
                                    metodo = "Cartão de Débito";
                                }else if (metodo == 3){
                                    metodo = "Dinheiro";
                                }

                                var nomeCad = $('#nomeCad').val()
                                $('#nomeFinal').attr('placeholder', nomeCad);
                                
                                var emailCad = $('#emailCad').val()
                                $('#emailFinal').attr('placeholder', emailCad);

                                var cpfCad = $('#cpfCad').val()
                                $('#cpfFinal').attr('placeholder', cpfCad);
                                
                                var dataCad = $('#dataCad').val()
                                $('#dataFinal').attr('placeholder', dataCad);

                                var rgCad = $('#rgCad').val()
                                $('#rgFinal').attr('placeholder', rgCad);

                                var cepCad = $('#cepCad').val()
                                $('#cepFinal').attr('placeholder', rgCad);
                                                                                        
                                $('#telefoneFinal').attr('placeholder', tel);

                                var ruaCad = $('#ruaCad').val()
                                $('#ruaFinal').attr('placeholder', ruaCad);

                                var bairroCad = $('#bairroCad').val()
                                $('#bairroFinal').attr('placeholder', bairroCad);

                                var numeroCad = $('#numeroCad').val()
                                $('#numeroFinal').attr('placeholder', numeroCad);

                                var complementoCad = $('#complementoCad').val()
                                $('#complementoFinal').attr('placeholder', complementoCad);

                                $('#metodoFinal').attr('placeholder', metodo);

                                var totalCarrin = "R$ " + $('#totalCarrinho').val();
                                $('#totalFinal').attr('placeholder', totalCarrin);
                                                         
                            }
                            if (nome == "" || cpf == "" || rg == "" || data == "" || tel == "" || email == "" || rua == "" || cep == "" || bairro == "" || numero == "" || metodo == 0) {
                                $('#btnProximo').attr("disabled", true);
                            } else {
                                $('#btnProximo').attr("disabled", false);
                            }


                        })

                        $('#btnVoltar').click(function () {
                            pagAtual = pagAtual - 1;
                            $('#btnProximo').attr("disabled", false);
                        })

                        $("input[type='radio']").click(function () {
                            var radioValue = $("input[name='userRegister']:checked").val();
                            if (radioValue === '1') {
                                $('#buscaCliente').show();
                                $('#infosClientes').hide();
                            } else {
                                $('#buscaCliente').hide();
                                $('#infosClientes').show();
                            }
                        });
                        $('#procurarCliente').click(function () {
                            var cpf = $('#buscaCPF').val();
                            $.ajax({
                                url: 'VendaServlet',
                                type: 'POST',
                                data: {
                                    BuscarCPF: cpf,
                                    solicitacao: 'BuscarCPF'

                                },
                                success: function (result) {
                                    if (result == "erroPerfil") {
                                        alert("Perfil de usuário não condiz com a ação solicitada!                              -----[Perfil não é comprador]-----")
                                    } else {
                                        $('#infosClientes').html(result);
                                    }
                                }
                            });
                            $("#infosClientes").css("display", "block");
                        })



                        $('#filtroProduto').click(function () {
                            var produtoNome = $('#nome_produto').val();
                            $.ajax({
                                type: 'POST',
                                data: {
                                    Produto: produtoNome,
                                    solicitacao: 'BuscaProduto'

                                },
                                url: 'VendaServlet',
                                success: function (result) {
                                    $('#mostrarProdutos').html(result);
                                }
                            });
                        })



                        $('#selectPagamento').change(function () {
                            var value = $('#selectPagamento').val()
                            if (value === '3') {
                                $('#infoDinheiro').show();
                            } else {
                                $('#infoDinheiro').hide();
                            }
                        })

                        var demo1 = $('select[name="duallistbox_demo1[]"]').bootstrapDualListbox({
                            infoTextFiltered: '<span class="label label-purple label-lg">Filtered</span>'
                        });
                        var container1 = demo1.bootstrapDualListbox('getContainer');
                        $.mask.definitions['~'] = '[+-]';
                        $('.input-mask-phone').mask('(99) 99999-9999');
                        $('.input-mask-cpf').mask('999-999-999-99');
                        $('.input-mask-rg').mask('99-999-999-9');
                        $('.input-mask-cep').mask('999.99-999');
                        $('.date-picker').datepicker({
                            autoclose: true,
                            todayHighlight: true
                        })
                        $('[data-rel=tooltip]').tooltip();
                        $('.select2').css('width', '200px').select2({
                            allowClear: true
                        })
                                .on('change', function () {
                                    $(this).closest('form').validate().element($(this));
                                });
                        var $validation = false;
                        $('#fuelux-wizard-container')
                                .ace_wizard({
                                    //step: 2 //optional argument. wizard will jump to step "2" at first
                                    //buttons: '.wizard-actions:eq(0)'
                                })
                                .on('actionclicked.fu.wizard', function (e, info) {
                                    if (info.step == 1 && $validation) {
                                        if (!$('#validation-form').valid())
                                            e.preventDefault();
                                    }
                                })
                                //.on('changed.fu.wizard', function() {
                                //})
                                .on('finished.fu.wizard', function (e) {

                                }).on('stepclick.fu.wizard', function (e) {
                        });

                        $('#skip-validation').removeAttr('checked').on('click', function () {
                            $validation = this.checked;
                            if (this.checked) {
                                $('#sample-form').hide();
                                $('#validation-form').removeClass('hide');
                            } else {
                                $('#validation-form').addClass('hide');
                                $('#sample-form').show();
                            }
                        })

                        //documentation : http://docs.jquery.com/Plugins/Validation/validate



                        $.mask.definitions['~'] = '[+-]';
                        $('#phone').mask('(999) 999-9999');
                        jQuery.validator.addMethod("phone", function (value, element) {
                            return this.optional(element) || /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
                        }, "Enter a valid phone number.");
                        $('#modal-wizard-container').ace_wizard();
                        $('#modal-wizard .wizard-actions .btn[data-dismiss=modal]').removeAttr('disabled');



                        $(document).one('ajaxloadstart.page', function (e) {
                            //in ajax mode, remove remaining elements before leaving page
                            $('[class*=select2]').remove();
                            $('[class*=select2]').remove();
                            $('select[name="duallistbox_demo1[]"]').bootstrapDualListbox('destroy');
                            $('.rating').raty('destroy');
                            $('.multiselect').multiselect('destroy');
                        })

                        
                        $('#id-file-format').removeAttr('checked').on('change', function () {
                            var whitelist_ext, whitelist_mime;
                            var btn_choose
                            var no_icon
                            if (this.checked) {
                                btn_choose = "Drop images here or click to choose";
                                no_icon = "ace-icon fa fa-picture-o";
                                whitelist_ext = ["jpeg", "jpg", "png", "gif", "bmp"];
                                whitelist_mime = ["image/jpg", "image/jpeg", "image/png", "image/gif",
                                    "image/bmp"
                                ];
                            } else {
                                btn_choose = "Drop files here or click to choose";
                                no_icon = "ace-icon fa fa-cloud-upload";
                                whitelist_ext = null; //all extensions are acceptable
                                whitelist_mime = null; //all mimes are acceptable
                            }
                            var file_input = $('#id-input-file-3');
                            file_input
                                    .ace_file_input('update_settings', {
                                        'btn_choose': btn_choose,
                                        'no_icon': no_icon,
                                        'allowExt': whitelist_ext,
                                        'allowMime': whitelist_mime
                                    })
                            file_input.ace_file_input('reset_input');
                            file_input
                                    .off('file.error.ace')
                                    .on('file.error.ace', function (e, info) {

                                    });
                        });
                        $('.spinner1').ace_spinner({
                            value: 0,
                            min: 0,
                            max: 200,
                            step: 1,
                            btn_up_class: 'btn-info',
                            btn_down_class: 'btn-info'
                        })
                                .closest('.ace-spinner')
                                .on('changed.fu.spinbox', function () {
                                });

                    })


                    function adicionarCarrinho(nome, id, valor)
                    {
                        var quantProd = document.getElementById("quantia" + id).value;
                        var quantCompr = document.getElementById("quantiaCompra" + id).value;
                        var resultCompr = quantProd - quantCompr;
                        if (quantCompr == 0) {
                            document.getElementById("quantiaCompra" + id).value = "";
                        } else if ((resultCompr < 0) || (quantProd == 0)) {
                            alert("Quantidade em estoque: " + quantProd + ". Favor incluir valor menor ou igual ao dísponivel! ")
                            document.getElementById("quantiaCompra" + id).value = "";
                        } else {

                            localStorage.setItem("salvar" + posicaoCarrinho, id);
                            localStorage.setItem("produto" + posicaoCarrinho, nome);
                            localStorage.setItem("qtd" + posicaoCarrinho, document.getElementById("quantiaCompra" + id).value);
                            valor = valor * document.getElementById("quantiaCompra" + id).value;
                            localStorage.setItem("valor" + posicaoCarrinho, valor);
                            // exibe os dados da lista dentro da div itens
                            document.getElementById("itens").innerHTML += localStorage.getItem("qtd" + posicaoCarrinho) + " x ";
                            document.getElementById("itens").innerHTML += localStorage.getItem("produto" + posicaoCarrinho);
                            document.getElementById("itens").innerHTML += " : TOTAL ";
                            document.getElementById("itens").innerHTML += "R$ " + localStorage.getItem("valor" + posicaoCarrinho) + "<hr>";

                            document.getElementById("itensFinal").innerHTML += localStorage.getItem("qtd" + posicaoCarrinho) + " x ";
                            document.getElementById("itensFinal").innerHTML += localStorage.getItem("produto" + posicaoCarrinho);
                            document.getElementById("itensFinal").innerHTML += " : TOTAL ";
                            document.getElementById("itensFinal").innerHTML += "R$ " + localStorage.getItem("valor" + posicaoCarrinho) + "<hr>";
                            // calcula o total dos recheios
                            valor = parseFloat(localStorage.getItem("valor" + posicaoCarrinho)); // valor convertido com o parseFloat()
                            //total = (total + valor); // arredonda para 2 casas decimais com o .toFixed(2)

                            posicaoCarrinho += 1;
                            document.getElementById("quantiaCompra" + id).placeholder = "Qtd disponível: " + resultCompr;
                            var anteriorCarrinho = parseFloat(document.getElementById("totalCarrinho").value);
                            var valorAtual = parseFloat(valor);
                            var totalCarrinho = anteriorCarrinho + valorAtual;
                            document.getElementById("totalCarrinho").value = totalCarrinho;
                            document.getElementById("quantia" + id).value = resultCompr;
                            document.getElementById("quantiaCompra" + id).value = "";


                        }
                    }




        </script>
    </body>

</html>