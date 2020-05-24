<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.io.*" %>  
<%@ page import="java.util.*" %>  

<%!
    // --- String Join Function converts from Java array to javascript string.  
    public String join(ArrayList<?> arr, String del) {

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

    public String joinPie(ArrayList<?> arr, String del) {

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {

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
            output.append("  }  ");
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
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                final String host = "jdbc:mysql://localhost:3306/bdprojeto3?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
                final Connection conn = DriverManager.getConnection(host, "root", "");
                final Statement stmt = conn.createStatement();
                final ResultSet rs = stmt.executeQuery("SELECT produto.nome , sum(item_venda.quantidade) as qtde FROM item_venda INNER JOIN produto ON item_venda.id_produto = produto.id_produto group by produto.nome;");
                ArrayList<String> months = new ArrayList<String>();
                ArrayList<Integer> users = new ArrayList<Integer>();
                while (rs.next()) {
                    months.add(rs.getString("produto.nome"));
                    users.add(Integer.parseInt(rs.getString("qtde")));
                }

                final ResultSet rs1 = stmt.executeQuery("select * from venda");

                ArrayList<Double> vendas = new ArrayList<Double>();
                while (rs1.next()) {
                    vendas.add(Double.parseDouble(rs1.getString("total")));
                }

                final ResultSet rs2 = stmt.executeQuery("select fi.nome, sum(ve.total) as total from venda ve inner join filial fi on ve.id_filial = fi.id_filial group by ve.id_filial;");

                ArrayList<Double> filial = new ArrayList<Double>();
                ArrayList<String> filialnome = new ArrayList<String>();
                while (rs2.next()) {
                    filialnome.add(rs2.getString("fi.nome"));
                    filial.add(Double.parseDouble(rs2.getString("total")));
                }
                conn.close();
                
                String Coisa = joinPie(filial, ",");
            %>

            // --- add a comma after each value in the array and convert to javascript string representing an array  
            var monthData = [<%= join(months, ",")%>];
            var userData = [<%= join(users, ",")%>];
            var vendas = [<%= join(vendas, ",")%>];
            var filial = '<%= joinPie(filial, ",")%>';
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
                            "text": "Produtos Vendidos"
                        },
                        "scale-x": {
                            "labels": monthData
                        },
                        "plot": {
                            "line-width": 1
                        },
                        "series": [{
                                "values": userData
                            }]
                    }
                });
                zingchart.render({
                    width: "100%",
                    height: 400,
                    id: 'chart-div',
                    data: {type: 'line',
                        series: [
                            {
                                values: vendas
                            }
                        ]}
                });
                zingchart.render({
                    id: 'chartpie',
                    data: {
                        type: 'pie',
                        "series": [<%=Coisa%>]
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
                    <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
                </div>
            </div>

            <div class="main-content">
                <div class="main-content-inner">


                    <div class="page-content">

                        <div class="col-lg-6">
                            <div id="myChart"></div>  
                        </div>
                        <div class="col-lg-6">
                            <div id="chart-div"></div>
                        </div>
                        <div class="col-lg-6">
                            <div id="chartpie"></div>  
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
                        $('.easy-pie-chart.percentage').each(function () {
                            var $box = $(this).closest('.infobox');
                            var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
                            var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
                            var size = parseInt($(this).data('size')) || 50;
                            $(this).easyPieChart({
                                barColor: barColor,
                                trackColor: trackColor,
                                scaleColor: false,
                                lineCap: 'butt',
                                lineWidth: parseInt(size / 10),
                                animate: ace.vars['old_ie'] ? false : 1000,
                                size: size
                            });
                        })

                        $('.sparkline').each(function () {
                            var $box = $(this).closest('.infobox');
                            var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
                            $(this).sparkline('html', {
                                tagValuesAttribute: 'data-values',
                                type: 'bar',
                                barColor: barColor,
                                chartRangeMin: $(this).data('min') || 0
                            });
                        });
                        //flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
                        //but sometimes it brings up errors with normal resize event handlers
                        $.resize.throttleWindow = false;
                        var placeholder = $('#piechart-placeholder').css({
                            'width': '90%',
                            'min-height': '150px'
                        });
                        var data = [{
                                label: "social networks",
                                data: 38.7,
                                color: "#68BC31"
                            }, {
                                label: "search engines",
                                data: 24.5,
                                color: "#2091CF"
                            }, {
                                label: "ad campaigns",
                                data: 8.2,
                                color: "#AF4E96"
                            }, {
                                label: "direct traffic",
                                data: 18.6,
                                color: "#DA5430"
                            }, {
                                label: "other",
                                data: 10,
                                color: "#FEE074"
                            }]

                        function drawPieChart(placeholder, data, position) {
                            $.plot(placeholder, data, {
                                series: {
                                    pie: {
                                        show: true,
                                        tilt: 0.8,
                                        highlight: {
                                            opacity: 0.25
                                        },
                                        stroke: {
                                            color: '#fff',
                                            width: 2
                                        },
                                        startAngle: 2
                                    }
                                },
                                legend: {
                                    show: true,
                                    position: position || "ne",
                                    labelBoxBorderColor: null,
                                    margin: [-30, 15]
                                },
                                grid: {
                                    hoverable: true,
                                    clickable: true
                                }
                            })
                        }
                        drawPieChart(placeholder, data);
                        /**
                         we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
                         so that's not needed actually.
                         */
                        placeholder.data('chart', data);
                        placeholder.data('draw', drawPieChart);
                        //pie chart tooltip example
                        var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
                        var previousPoint = null;
                        placeholder.on('plothover', function (event, pos, item) {
                            if (item) {
                                if (previousPoint != item.seriesIndex) {
                                    previousPoint = item.seriesIndex;
                                    var tip = item.series['label'] + " : " + item.series['percent'] + '%';
                                    $tooltip.show().children(0).text(tip);
                                }
                                $tooltip.css({
                                    top: pos.pageY + 10,
                                    left: pos.pageX + 10
                                });
                            } else {
                                $tooltip.hide();
                                previousPoint = null;
                            }

                        });
                        /////////////////////////////////////
                        $(document).one('ajaxloadstart.page', function (e) {
                            $tooltip.remove();
                        });
                        var d1 = [];
                        for (var i = 0; i < Math.PI * 2; i += 0.5) {
                            d1.push([i, Math.sin(i)]);
                        }

                        var d2 = [];
                        for (var i = 0; i < Math.PI * 2; i += 0.5) {
                            d2.push([i, Math.cos(i)]);
                        }

                        var d3 = [];
                        for (var i = 0; i < Math.PI * 2; i += 0.2) {
                            d3.push([i, Math.tan(i)]);
                        }


                        var sales_charts = $('#sales-charts').css({
                            'width': '100%',
                            'height': '220px'
                        });
                        $.plot("#sales-charts", [{
                                label: "Domains",
                                data: d1
                            }, {
                                label: "Hosting",
                                data: d2
                            }, {
                                label: "Services",
                                data: d3
                            }], {
                            hoverable: true,
                            shadowSize: 0,
                            series: {
                                lines: {
                                    show: true
                                },
                                points: {
                                    show: true
                                }
                            },
                            xaxis: {
                                tickLength: 0
                            },
                            yaxis: {
                                ticks: 10,
                                min: -2,
                                max: 2,
                                tickDecimals: 3
                            },
                            grid: {
                                backgroundColor: {
                                    colors: ["#fff", "#fff"]
                                },
                                borderWidth: 1,
                                borderColor: '#555'
                            }
                        });
                        $('#recent-box [data-rel="tooltip"]').tooltip({
                            placement: tooltip_placement
                        });
                        function tooltip_placement(context, source) {
                            var $source = $(source);
                            var $parent = $source.closest('.tab-content')
                            var off1 = $parent.offset();
                            var w1 = $parent.width();
                            var off2 = $source.offset();
                            //var w2 = $source.width();

                            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
                                return 'right';
                            return 'left';
                        }


                        $('.dialogs,.comments').ace_scroll({
                            size: 300
                        });
                        //Android's default browser somehow is confused when tapping on label which will lead to dragging the task
                        //so disable dragging when clicking on label
                        var agent = navigator.userAgent.toLowerCase();
                        if (ace.vars['touch'] && ace.vars['android']) {
                            $('#tasks').on('touchstart', function (e) {
                                var li = $(e.target).closest('#tasks li');
                                if (li.length == 0)
                                    return;
                                var label = li.find('label.inline').get(0);
                                if (label == e.target || $.contains(label, e.target))
                                    e.stopImmediatePropagation();
                            });
                        }

                        $('#tasks').sortable({
                            opacity: 0.8,
                            revert: true,
                            forceHelperSize: true,
                            placeholder: 'draggable-placeholder',
                            forcePlaceholderSize: true,
                            tolerance: 'pointer',
                            stop: function (event, ui) {
                                //just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
                                $(ui.item).css('z-index', 'auto');
                            }
                        });
                        $('#tasks').disableSelection();
                        $('#tasks input:checkbox').removeAttr('checked').on('click', function () {
                            if (this.checked)
                                $(this).closest('li').addClass('selected');
                            else
                                $(this).closest('li').removeClass('selected');
                        });
                        //show the dropdowns on top or bottom depending on window height and menu position
                        $('#task-tab .dropdown-hover').on('mouseenter', function (e) {
                            var offset = $(this).offset();
                            var $w = $(window)
                            if (offset.top > $w.scrollTop() + $w.innerHeight() - 100)
                                $(this).addClass('dropup');
                            else
                                $(this).removeClass('dropup');
                        });
                    })
        </script>
    </body>

</html>