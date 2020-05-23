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
                    <a href="index.html" class="navbar-brand">
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
                                <span class="badge badge-important">8</span>
                            </a>

                            <ul
                                class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
                                <li class="dropdown-header">
                                    <i class="ace-icon fa fa-exclamation-triangle"></i> 8 Notifications
                                </li>

                                <li class="dropdown-content">
                                    <ul class="dropdown-menu dropdown-navbar navbar-pink">
                                        <li>
                                            <a href="#">
                                                <div class="clearfix">
                                                    <span class="pull-left">
                                                        <i class="btn btn-xs no-hover btn-pink fa fa-comment"></i>
                                                        New Comments
                                                    </span>
                                                    <span class="pull-right badge badge-info">+12</span>
                                                </div>
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#">
                                                <i class="btn btn-xs btn-primary fa fa-user"></i> Bob just signed up as an
                                                editor ...
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#">
                                                <div class="clearfix">
                                                    <span class="pull-left">
                                                        <i class="btn btn-xs no-hover btn-success fa fa-shopping-cart"></i>
                                                        New Orders
                                                    </span>
                                                    <span class="pull-right badge badge-success">+8</span>
                                                </div>
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#">
                                                <div class="clearfix">
                                                    <span class="pull-left">
                                                        <i class="btn btn-xs no-hover btn-info fa fa-twitter"></i>
                                                        Followers
                                                    </span>
                                                    <span class="pull-right badge badge-info">+11</span>
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
                        <a href="index.html">
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
                                <a href="#">
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
                                <a href="#">
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
                                <a href="#" >
                                    <i class="menu-icon fa fa-money"></i> Vendas
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
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="widget-box">
                                    <div class="widget-header">
                                        <h4 class="widget-title">Filtros</h4>

                                        <div class="widget-toolbar">
                                            <a href="#" data-action="collapse">
                                                <i class="ace-icon fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <form method="POST" action="ProdutoServlet">
                                        <div class="widget-body">
                                            <div class="widget-main">
                                                <div class="form-group">
                                                    <div class="col-lg-6">
                                                        <label for="number-button" class="block">Filial</label>
                                                        <select class="form-group" style="width: 100%;" name="filtroFiliais">
                                                            <option></option> 
                                                            <c:forEach var="filial" items="${filiais}">                                                                 
                                                                <option value="${filial.idFilial}">
                                                                    ${filial.nome}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>

                                                    <div class="col-lg-6">
                                                        <label for="number-button" class="block">Perfil</label>
                                                        <select class="form-group" style="width: 100%;" name="filtroPerfil">
                                                            <c:forEach var="perfil" items="${perfils}">
                                                                <option></option>
                                                                <option value="${perfil.idPerfil}">
                                                                    ${perfil.tipo}
                                                                </option>
                                                            </c:forEach>
                                                            <option></option>
                                                            <option value="1">
                                                                Administrador
                                                            </option>
                                                            <option value="2">
                                                                Diretoria
                                                            </option>
                                                        </select>
                                                    </div>



                                                </div>

                                                <label>  <button class="btn btn-sm btn-success " href="ProdutoServlet"
                                                                 style="float: right; margin-right: 2px;" name="tarefa" value="Cadastrando" type="submit">
                                                        Novo Produto &nbsp; <i class="ace-icon glyphicon glyphicon-save"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-warning right" style="float: right; margin-right: 2px;" >
                                                        Limpar &nbsp;<i class="ace-icon fa fa-undo"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-info"
                                                            style="float: right; margin-right: 2px;" type="submit" name="tarefa" >
                                                        Buscar &nbsp; <i class="ace-icon glyphicon glyphicon-search"></i>
                                                    </button>

                                                </label>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table  table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th id="id"> ID Produto </th>
                                            <th> Nome </th>
                                            <th> Tipo </th>
                                            <th> Quantidade </th>
                                            <th> Descrição </th>
                                            <th> Valor </th>
                                            <th>Gerenciar</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="produto" items="${produtos}">

                                            <tr>


                                                <td class="center">${produto.idProduto}  </td>

                                                <td>
                                                    ${produto.nome}
                                                </td>
                                                <td>
                                                    ${produto.tipo}
                                                </td>
                                                <td>
                                                    ${produto.quantidade}
                                                </td>
                                                <td>
                                                    ${produto.descricao}
                                                </td>
                                                <td>
                                                    ${produto.valor}
                                                </td>
                                                <td>
                                                    <div class="hidden-sm hidden-xs btn-group">


                                                        <button class="btn btn-xs btn-info btn-edit" value="${produto.idProduto}" onclick="window.displaymessage(${produto.idProduto})" >
                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                        </button>

                                                        <button class="btn btn-xs btn-danger">
                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                        </button>

                                                    </div>


                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <form method="" action="ProdutoServlet" >
                                <input  name="id" style="display: none" type="text" id="valorEditar"/>
                                <input  name="tarefa" style="display: none" type="text" value="Editando" />
                                <button type="submit" style="display: none" id="enviarEditacao"></button>
                            </form>
                            <!-- /.span -->
                        </div>

                        <div class="footer">
                            <div class="footer-inner">
                                <div class="footer-content">
                                    <span class="bigger-120">
                                        <span class="blue bolder">Ace</span> Application &copy; 2013-2014
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