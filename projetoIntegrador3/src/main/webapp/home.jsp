<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.thinkcode.db.ConnectionDB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.io.*" %>  
<%@ page import="java.util.*" %>  

<%!
    public String joinLine(ArrayList<?> arr, String del) {

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < arr.size(); i++) {

            if (i > 0) {
                output.append(del);
            }

            // --- Quote strings, only, for JS syntax  
            if (arr.get(i) instanceof String) {
                output.append("\"");
            }
            output.append(arr.get(i));
            if (arr.get(i) instanceof String) {
                output.append("\"");
            }
        }

        return output.toString();
    }

    // --- String Join Function converts from Java array to javascript string.  
    public String joinBar(ArrayList<?> arr, ArrayList<?> arr2, String del) {

        StringBuilder output = new StringBuilder();
        Random randColor = new Random();
        for (int i = 0; i < arr.size(); i++) {
            int r = randColor.nextInt(256);
            int g = randColor.nextInt(256);
            int b = randColor.nextInt(256);
            output.append("{  \"values\": ");

            // --- Quote strings, only, for JS syntax  
            if (arr.get(i) instanceof String) {
                output.append("\"");
            }
            output.append("[" + arr.get(i) + "]");
            if (arr.get(i) instanceof String) {
                output.append("\"");
            }
            output.append(", 'alpha': 0.6,'text': '" + arr2.get(i) + "'}, 'rgb(" + r + "," + g + "," + b + ")',");
        }
        return output.toString();
    }

    public String joinPie(ArrayList<?> arr, ArrayList<?> arr2, String del) {
        Random randColor = new Random();

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            int r = randColor.nextInt(256);
            int g = randColor.nextInt(256);
            int b = randColor.nextInt(256);
            if (i > 0) {
                output.append(del);
            }
            output.append("{  \"values\": ");
            // --- Quote strings, only, for JS syntax  
            if (arr.get(i) instanceof String) {
                output.append("\"");
            }
            output.append("[" + arr.get(i) + "]");
            if (arr.get(i) instanceof String) {
                output.append("\"");
            }
            output.append("  , 'background-color': 'rgb(" + r + "," + g + "," + b + ")',  'text':'" + arr2.get(i) + "' }");
        }

        return output.toString();
    }
%>  

<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="UTF-8">
        <title>ThinkCode</title>

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

        <!-- ace settings handler -->
        <script src="assets/js/ace-extra.min.js"></script>

        <script type="text/javascript" src="https://cdn.zingchart.com/zingchart.min.js"></script>  

        <script>
            <%
                //Class.forName("com.mysql.jdbc.Driver").newInstance();
                //final String host = "jdbc:mysql://localhost:3306/bdprojeto3?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
                //final Connection conn = DriverManager.getConnection(host, "root", "");
                //final Statement stmt = conn.createStatement();
                //final ResultSet rs = stmt.executeQuery("SELECT produto.nome , sum(item_venda.quantidade) as qtde FROM item_venda INNER JOIN produto ON item_venda.id_produto = produto.id_produto group by produto.nome;");
                Connection conn = ConnectionDB.obterConexao();
                PreparedStatement ps = conn.prepareStatement("SELECT tb_produto.nome , sum(tb_item_venda.quantidade) as qtde FROM tb_item_venda INNER JOIN tb_produto ON tb_item_venda.id_produto = tb_produto.id_produto group by tb_produto.nome;",
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = ps.executeQuery();
                ArrayList<String> months = new ArrayList<String>();
                ArrayList<Integer> users = new ArrayList<Integer>();
                while (rs.next()) {
                    months.add(rs.getString("tb_produto.nome"));
                    users.add(Integer.parseInt(rs.getString("qtde")));
                }

                final ResultSet rs1 = ps.executeQuery("select * from tb_venda");

                ArrayList<Double> vendas = new ArrayList<Double>();
                while (rs1.next()) {
                    vendas.add(Double.parseDouble(rs1.getString("total")));
                }

                final ResultSet rs2 = ps.executeQuery("select fi.nome, sum(ve.total) as total from tb_venda ve inner join tb_filial fi on ve.id_filial = fi.id_filial group by ve.id_filial;");

                ArrayList<Double> filial = new ArrayList<Double>();
                ArrayList<String> filialnome = new ArrayList<String>();
                while (rs2.next()) {
                    filialnome.add(rs2.getString("fi.nome"));
                    filial.add(Double.parseDouble(rs2.getString("total")));
                }

                ps = conn.prepareStatement("SELECT US.NOME, SUM(VE.TOTAL) as total FROM tb_venda AS VE INNER JOIN tb_usuario AS US ON VE.ID_USUARIO = US.ID_USUARIO GROUP BY VE.ID_USUARIO;",
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs3 = ps.executeQuery();
                ArrayList<String> Vendedores = new ArrayList<String>();
                ArrayList<Double> ValorVendedores = new ArrayList<Double>();
                while (rs3.next()) {
                    Vendedores.add(rs3.getString("US.NOME"));
                    ValorVendedores.add(Double.parseDouble(rs3.getString("total")));
                }

                conn.close();

                String DataPie = joinPie(filial, filialnome, ",");
                String DataBar = joinBar(users, months, ",");
                String DataBarVend = joinBar(ValorVendedores, Vendedores, ",");
                String DataLine = joinLine(vendas, ",");
            %>
        </script> 
        <script>
            window.onload = function () {
                zingchart.render({
                    id: "myChart",
                    width: "100%",
                    height: 400,
                    data: {
                        "type": "bar",
                        "title": {
                            "text": "Produtos"
                        },
                        "plot": {
                            "border-color": "#636363",
                            "border-width": 2,
                            "border-radius": "3px",
                            "line-style": "solid",
                            "line-width": 1
                        },
                        "scale-y": {
                            "line-color": "#7E7E7E",
                            "item": {
                                "font-color": "#7e7e7e"
                            },
                            "values": "0:60:10",
                            "guide": {
                                "visible": true
                            },
                            "label": {
                                "text": " Quantidade",
                                "font-family": "arial",
                                "bold": true,
                                "font-size": "14px",
                                "font-color": "#7E7E7E",
                            },
                        },
                        "scale-x": {
                            "labels": ['Produtos']

                        },
                        "crosshair-x": {
                            "line-width": "100%",
                            "alpha": 0.18,
                            "plot-label": {
                                "header-text": "Quantidade"
                            }
                        },
                        "series": [
            <%=DataBar%>
                        ]
                    }
                });
                zingchart.render({
                    id: "myChart2",
                    width: "100%",
                    height: 450,
                    data: {
                        "type": "bar",
                        "title": {
                            "text": "Vendedores"
                        },
                        "plot": {
                            "border-color": "#636363",
                            "border-width": 2,
                            "border-radius": "3px",
                            "line-style": "solid",
                            "line-width": 1
                        },
                        "scale-y": {
                            "line-color": "#7E7E7E",
                            "item": {
                                "font-color": "#7e7e7e"
                            },
                            "values": "0:10000:10",
                            "guide": {
                                "visible": true
                            },
                            "label": {
                                "text": "Valor",
                                "font-family": "arial",
                                "bold": true,
                                "font-size": "14px",
                                "font-color": "#7E7E7E",
                            },
                        },
                        "scale-x": {
                            "labels": ['Vendedores']

                        },
                        "crosshair-x": {
                            "line-width": "100%",
                            "alpha": 0.18,
                            "plot-label": {
                                "header-text": "Valor"
                            }
                        },
                        "series": [
            <%=DataBarVend%>
                        ]
                    }
                });
                zingchart.render({
                    width: "100%",
                    height: 400,
                    id: 'chart-div',
                    data: {type: 'line',
                        "utc": true,
                        "title": {
                            "text": "Vendas",
                            "font-size": "24px",
                            "adjust-layout": true
                        }, "plotarea": {
                            "margin": "dynamic 45 60 dynamic",
                        },
                        "legend": {
                            "layout": "float",
                            "background-color": "none",
                            "border-width": 0,
                            "shadow": 0,
                            "align": "center",
                            "adjust-layout": true,
                            "toggle-action": "remove",
                            "item": {
                                "padding": 7,
                                "marginRight": 17,
                                "cursor": "hand"
                            }
                        },
                        "scale-y": {
                            "line-color": "#f6f7f8",
                            "shadow": 0,
                            "guide": {
                                "line-style": "dashed"
                            },
                            "label": {
                                "text": "Vendas(R$)",
                            },
                            "minor-ticks": 0,
                            "thousands-separator": ","
                        },
                        "crosshair-x": {
                            "line-color": "#efefef",
                            "plot-label": {
                                "border-radius": "5px",
                                "border-width": "1px",
                                "border-color": "#f6f7f8",
                                "padding": "10px",
                                "font-weight": "bold"
                            },
                            "scale-label": {
                                "font-color": "#000",
                                "background-color": "#f6f7f8",
                                "border-radius": "5px"
                            }
                        },
                        "tooltip": {
                            "visible": false
                        },
                        "plot": {
                            "highlight": true,
                            "tooltip-text": "%t views: R$ %v<br>%k",
                            "shadow": 0,
                            "line-width": "2px",
                            "marker": {
                                "type": "circle",
                                "size": 3
                            },
                            "highlight-state": {
                                "line-width": 3
                            },
                            "animation": {
                                "effect": 1,
                                "sequence": 2,
                                "speed": 100,
                            }
                        },
                        series: [
                            {
                                values: [<%=DataLine%>],
                                "text": "Venda R$",
                                "line-color": "#007790",
                                "legend-item": {
                                    "background-color": "#007790",
                                    "borderRadius": 5,
                                    "font-color": "white"
                                },
                                "legend-marker": {
                                    "visible": false
                                },
                                "marker": {
                                    "background-color": "#007790",
                                    "border-width": 1,
                                    "shadow": 0,
                                    "border-color": "#69dbf1"
                                },
                                "highlight-marker": {
                                    "size": 6,
                                    "background-color": "#007790",
                                }
                            }
                        ]}
                });
                zingchart.render({
                    id: 'chartpie',
                    data: {
                        type: 'pie',
                        "title": {
                            "text": "Venda por Filiais"
                        },
                        "legend": {
                            "x": "75%",
                            "y": "25%",
                            "border-width": 1,
                            "border-color": "gray",
                            "border-radius": "5px",
                            "header": {
                                "text": "Filiais",
                                "font-family": "Verdana",
                                "font-size": 12,
                                "font-color": "#3333cc",
                                "font-weight": "normal"
                            },
                            "marker": {
                                "type": "circle"
                            },
                            "toggle-action": "remove",
                            "minimize": true,
                            "icon": {
                                "line-color": "#9999ff"
                            },
                            "max-items": 8,
                            "overflow": "scroll"
                        },
                        "plot": {
                            "animation": {
                                "on-legend-toggle": true, //set to true to show animation and false to turn off
                                "effect": 5,
                                "method": 1,
                                "sequence": 1,
                                "speed": 2
                            },
                            "value-box": {
                                "text": "%v",
                                "font-size": 12,
                                "font-family": "Georgia",
                                "font-weight": "normal",
                                "placement": "out",
                                "font-color": "gray",
                            },
                            "tooltip": {
                                "text": "%t: R$ %v <br> (%npv%)",
                                "font-color": "black",
                                "font-family": "Verdana",
                                "text-alpha": 1,
                                "background-color": "white",
                                "alpha": 0.7,
                                "border-width": 1,
                                "border-color": "#cccccc",
                                "line-style": "dotted",
                                "border-radius": "10px",
                                "padding": "10%",
                                "placement": "node:center"
                            },
                            "border-width": 1,
                            "border-color": "#cccccc",
                            "line-style": "dotted"
                        },
                        "series": [<%=DataPie%>]
                    }
                });
            };
        </script>

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
                    <a href="#" class="navbar-brand">
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

                            <ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
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
                                                <i class="btn btn-xs btn-primary fa fa-user"></i> Bob just signed up as an editor ...
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

                            <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
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
                <!-- /.nav-list -->
                <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                    <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
                </div>
            </div>

            <div class="main-content">
                <div class="main-content-inner">


                    <div class="page-content">
                        <div class="col-lg-12">
                            <div class="col-lg-6" style="border: 1px solid #dbdbdb; border-radius: 4px;">
                                <div id="myChart"></div>  
                            </div>
                            <div class="col-lg-6" style="border: 1px solid #dbdbdb; border-radius: 4px; ">
                                <div id="chart-div"></div>
                            </div>
                        </div>
                        <div class="col-lg-12" style="margin-top: 10px;">
                            <div class="col-lg-6" style="border: 1px solid #dbdbdb; border-radius: 4px;">
                                <div id="chartpie"></div>  
                            </div>
                            <div class="col-lg-6" style="border: 1px solid #dbdbdb; border-radius: 4px;">
                                <div id="myChart2"></div>  
                            </div>
                        </div>
                        <!-- /.page-header -->


                    </div>
                    <!-- /.page-content -->
                </div>
            </div>
            <!-- /.main-content -->

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
                    })
        </script>
    </body>

</html>