<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">


    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="UTF-8" />
        <title>Dashboard - Ace Admin</title>

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
                            <img src="assets/images/gallery/reparar.png" width="15%">
                            ThinkCode
                        </small>
                    </a>
                </div>

                <div class="navbar-buttons navbar-header pull-right" role="navigation">
                    <ul class="nav ace-nav">

                        <li class="purple dropdown-modal">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <i class="ace-icon fa fa-bell icon-animated-bell"></i>
                                <span class="badge badge-important">${pedidos.size()}</span>
                            </a>

                            <ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
                                <li class="dropdown-header">
                                    <i class="ace-icon fa fa-exclamation-triangle"></i> ${pedidos.size()} Notifications
                                </li>

                                <li class="dropdown-content">
                                    <ul class="dropdown-menu dropdown-navbar navbar-pink"> 
                                        <li>
                                            <a href="SolicitacaoServlet">
                                                <div class="clearfix">
                                                    <span class="pull-left">
                                                        <i class="btn btn-xs no-hover btn-success fa fa-shopping-cart"></i>
                                                        Solicita��es
                                                    </span>
                                                    <span class="pull-right badge badge-success">${pedidos.size()}</span>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                </li>

                                <li class="dropdown-footer">
                                    <a href="#">
                                        See all notifications
                                        <i class="ace-icon fa fa-arrow-right"></i>
                                    </a>
                                </li>
                            </ul>
                        </li>



                        <li class="light-blue dropdown-modal">
                            <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                                <img class="nav-user-photo" src="assets/images/avatars/user.jpg" alt="Jason's Photo" />
                                <span class="user-info">
                                    <small>Bem-vindo,</small>
                                    <label id="lblNome"></label>
                                </span>

                                <i class="ace-icon fa fa-caret-down"></i>
                            </a>

                            <ul
                                class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                                <li>
                                    <a href="#">
                                        <i class="ace-icon fa fa-cog"></i> Settings
                                    </a>
                                </li>

                                <li>
                                    <a href="profile.html">
                                        <i class="ace-icon fa fa-user"></i> Profile
                                    </a>
                                </li>

                                <li class="divider"></li>

                                <li>
                                    <a href="#">
                                        <i class="ace-icon fa fa-power-off"></i> Logout
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- /.navbar-container -->
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


                <!-- /.sidebar-shortcuts -->
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
                                Relat�rios
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
                                    <i class="menu-icon fa fa-caret-right"></i> Usu�rio
                                </a>

                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="SolicitacaoServlet">
                                    <i class="menu-icon fa fa-caret-right"></i> Solicita��es
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
                                    <i class="menu-icon fa fa-product-hunt"></i> Solicita��es
                                </a>

                                <b class="arrow"></b>
                            </li>

                        </ul>
                    </li>
                </ul>
                <!-- /.nav-list -->

                <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                    <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
                       data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
                </div>
            </div>

            <div class="main-content">
                <div class="main-content-inner">


                    <div class="page-content">
                        <!-- /.ace-settings-container -->
                        <!-- Filtros -->
                        <form action="ProdutoServlet" method="POST" id="formCadProduto">
                            <div>
                                <div>
                                    <div class="col-lg-12">
                                        <p>
                                        <h4>Cadastro de Produtos</h4>
                                        <hr>
                                        </p>
                                    </div>
                                    <div class="col-xs-12 col-sm-12">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="widget-box">
                                                    <div class="widget-header">
                                                        <h4 class="widget-title center">Informa��es Gerais</h4>

                                                        <div class="widget-toolbar">
                                                            <a href="#" data-action="collapse">
                                                                <i class="ace-icon fa fa-chevron-up"></i>
                                                            </a>
                                                        </div>
                                                    </div>

                                                    <div class="widget-body">
                                                        <div class="widget-main">
                                                            <div class="form-group">
                                                                <div class="col-lg-3">
                                                                    <label for="number-button" class="block">Nome</label>
                                                                    <input type="text" id="nomeProduto"
                                                                           placeholder="Nome" class="form-control"
                                                                           name="nomeProduto" required value="${nomeProduto}" />
                                                                </div>
                                                                <div class="col-lg-3">
                                                                    <label for="number-button" class="block">Tipo</label>
                                                                    <input type="text" id="Tipo"
                                                                           class="form-control" name="tipoProduto" required  value="${tipoProduto}"/>
                                                                </div>
                                                                <div class="col-lg-3">
                                                                    <label for="number-button"
                                                                           class="block">Quantidade</label>
                                                                    <input type="number" onkeypress="return event.charCode >= 48" min="1" id="quantidadeProduto"
                                                                           class="form-control" name="quantidadeProduto" onkeypress="return onlynumber()"
                                                                           required value="${quantidadeProduto}"/>
                                                                </div>

                                                                <div class="col-lg-3">
                                                                    <label for="number-button"
                                                                           class="block">Descri��o</label>
                                                                    <input type="text" id="descricaoProduto"
                                                                           class="form-control" name="descricaoProduto"
                                                                           required value="${descricaoProduto}"/>
                                                                </div>
                                                                <div class="col-lg-3">
                                                                    <label for="number-button" class="block">Valor</label>
                                                                    <div class="input-group">
                                                                        <span class="input-group-addon">
                                                                            <i class="ace-icon fa fa-money"></i>
                                                                        </span>

                                                                        <input class="form-control money"
                                                                               type="text" id="valorProduto"
                                                                               placeholder="R$00,00" name="valorProduto" onkeypress="return onlynumber()"
                                                                               required value="${valorProduto}"/>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-3">
                                                                    <label for="number-button" class="block">Filial</label>
                                                                    <select class="form-group" style="width: 100%;" name="filialProduto">
                                                                        <c:forEach var="filial" items="${filiais}">
                                                                            <option value="${filial.idFilial}">
                                                                                ${filial.nome}
                                                                            </option>
                                                                        </c:forEach>

                                                                    </select>
                                                                </div>

                                                            </div>
                                                            <label>
                                                                &nbsp;<br />
                                                                &nbsp;<br />
                                                                &nbsp;<br />


                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <input name="ID_PRODUTO" style="display: none" value="${ID_PRODUTO}"/>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <a href="ProdutoServlet"  class="btn btn-sm btn-danger right" style="float: right;">
                                                Cancelar &nbsp;<i class="ace-icon fa fa-close"></i>
                                            </a>
                                            <c:choose>
                                                <c:when test= "${empty tarefa}">
                                                    <button type="submit" class="btn btn-sm btn-success"
                                                            style="float: right; margin-right: 2px;" name="tarefa" value="cadastro" />
                                                    Registrar &nbsp; <i class="ace-icon fa fa-save"></i>
                                                    </button>
                                                </c:when>
                                                <c:otherwise>
                                                    <button type="submit" class="btn btn-sm btn-success" style="float: right; margin-right: 2px;" value="${tarefa}" name="tarefa">
                                                        Alterar &nbsp; <i class="ace-icon fa fa-save"></i>
                                                    </button>
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                    </div>
                                </div>
                            </div>
                    </div>
                    </form>

                    <div class="footer">
                        <div class="footer-inner">
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
                </div>
                <!-- /.main-container -->

                <!-- basic scripts -->

                <!--[if !IE]> -->
                <script src="assets/js/jquery-2.1.4.min.js"></script>

                <!-- <![endif]-->

                <!--[if IE]>
    <script src="assets/js/jquery-1.11.3.min.js"></script>
    <![endif]-->
                <script type="text/javascript">
                                                                                   if ('ontouchstart' in document.documentElement)
                                                                                       document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
                </script>
                <script src="assets/js/bootstrap.min.js"></script>

                <!-- page specific plugin scripts -->

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
                <script src="assets/js/jquery.mask.js"></script>
                <script src="assets/js/jquery.validate.js"></script>

                <!-- ace scripts -->
                <script src="assets/js/ace-elements.min.js"></script>
                <script src="assets/js/ace.min.js"></script>


                <!-- inline scripts related to this page -->
                <script type="text/javascript">
                                                                                   jQuery(function ($) {

                                                                                       window.displaymessage = function (user)
                                                                                       {
                                                                                           $('#valorEditar').val(user);
                                                                                           $('#enviarEditacao').click();
                                                                                           /*
                                                                                            $.ajax({
                                                                                            url: "UsuarioServlet",
                                                                                            type: "POST",
                                                                                            data: {
                                                                                            tarefa: 'Editar'
                                                                                            },
                                                                                            })
                                                                                            .success(function (e) {
                                                                                            //do success stuff
                                                                                            console.log("Sucessor " + e)
                                                                                            //window.location = "UsuarioServlet?Teste=1";
                                                                                            $(location).attr('href','cadastroUsuario.jsp');
                                                                                            })
                                                                                            .error(function (e) {
                                                                                            //do error handling stuff
                                                                                            console.log('Erro' + e.toString())
                                                                                            })
                                                                                            */
                                                                                       }
                                                                                       $(document).ready(function () {
                                                                                           $('.money').mask('000.000.000.000.000,00', {reverse: true});
                                                                                       });


                    <%
                        Cookie[] cookies = request.getCookies();
                        for (Cookie atual : cookies) {
                            if (atual.getName().equals("Perfil")) {
                                int auxilio = Integer.parseInt(atual.getValue());
                                if (auxilio != 1) {
                    %>
                                                                                       $('#liCadastro').hide()
                    <%
                            }
                        }
                        if (atual.getName().equals("Nome")) {
                            String auxiliado = atual.getValue().substring(0, 8);
                    %>
                                                                                       $('#lblNome').text('<%= auxiliado%>');
                    <%
                            }

                        }
                    %>
                                                                                   });
                </script>
                </body>

                </html>