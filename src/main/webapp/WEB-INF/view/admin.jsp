<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" ng-app="admin">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>班级圈后台管理系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/HtmlSource/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/HtmlSource/dist/css/AdminLTE.min.css">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/resources/HtmlSource/plugins/daterangepicker/daterangepicker.css">
    <!-- bootstrap datepicker -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/HtmlSource/plugins/datepicker/datepicker3.css">
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/HtmlSource/plugins/iCheck/all.css">
    <!-- Bootstrap Color Picker -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/resources/HtmlSource/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <!-- Bootstrap time Picker -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/resources/HtmlSource/plugins/timepicker/bootstrap-timepicker.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/HtmlSource/plugins/select2/select2.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/HtmlSource/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/HtmlSource/plugins/iCheck/flat/blue.css">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <![endif]-->
    <script src="<%=request.getContextPath()%>/resources/js/lib/angular.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/lib/angular-route.js"></script>
    <script>
        angular.module('admin', ['ngRoute'])
            .config(function ($routeProvider, $locationProvider) {
                $locationProvider.hashPrefix('');

                $routeProvider.when("/parent", {
                    templateUrl: "<%=request.getContextPath()%>/resources/html/parentTable.html"
                });
                $routeProvider.when("/deleteOrSelect", {
                    templateUrl: "<%=request.getContextPath()%>/resources/html/teacherTable.html"
                });
                <%--$routeProvider.when("/student", {--%>
                <%--templateUrl: "<%=request.getContextPath()%>/resources/html/studentTable.html"--%>
                <%--});--%>

                $routeProvider.when("/timeline", {
                    templateUrl: "<%=request.getContextPath()%>/resources/html/momentTimeline.html"
                });

                <%--$routeProvider.when("/picTimeline", {--%>
                <%--templateUrl: "<%=request.getContextPath()%>/resources/html/PicTimeline.html"--%>
                <%--});--%>

                $routeProvider.when("/issuegk", {
                    templateUrl: "<%=request.getContextPath()%>/resources/html/fbgg.html"
                });
                $routeProvider.when("/pushScore", {
                    templateUrl: "<%=request.getContextPath()%>/resources/html/pushScore.html"
                });
                $routeProvider.when("/redfellow", {
                    templateUrl: "<%=request.getContextPath()%>/resources/html/redfellow.html"
                });

                $routeProvider.when("/index", {
                    templateUrl: "<%=request.getContextPath()%>/resources/html/index.html"
                });

                $routeProvider.otherwise({
                    templateUrl: "<%=request.getContextPath()%>/resources/html/index.html"
                });
            })
            .controller("use", function ($scope) {
                $('.mailbox-messages input[type="checkbox"]').iCheck({
                    checkboxClass: 'icheckbox_flat-blue',
                    radioClass: 'iradio_flat-blue'
                });

                //Enable check and uncheck all functionality
                $(".checkbox-toggle").click(function () {
                    var clicks = $(this).data('clicks');
                    if (clicks) {
                        //Uncheck all checkboxes
                        $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                        $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
                    } else {
                        //Check all checkboxes
                        $(".mailbox-messages input[type='checkbox']").iCheck("check");
                        $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
                    }
                    $(this).data("clicks", !clicks);
                });

                //Handle starring for glyphicon and font awesome
                $(".mailbox-star").click(function (e) {
                    e.preventDefault();
                    //detect type
                    var $this = $(this).find("a > i");
                    var glyph = $this.hasClass("glyphicon");
                    var fa = $this.hasClass("fa");

                    //Switch states
                    if (glyph) {
                        $this.toggleClass("glyphicon-star");
                        $this.toggleClass("glyphicon-star-empty");
                    }

                    if (fa) {
                        $this.toggleClass("fa-star");
                        $this.toggleClass("fa-star-o");
                    }
                });

                $("i.fa-trash-o").bind('click', function (e) {
                    $(".userInfo-form").find('.checked').parent().parent().remove();
                    alert("删除用户成功！");
                })
            })
            .controller("createUser",function (e) {

            })
            .controller("timelineCtrl", function ($scope) {
                $('.timeline-footer a').bind('click', function (e) {
                    $(e.target).parent().parent().parent().remove();
                    alert("动态删除成功！");
                });
            })
            .controller("fbgg", function ($scope) {
                $('.submitBtn').bind('click', function (e) {
                    $('.ggfb').find('input').val('');
                    $('.ggfb').find('textarea').val('');
                    alert("公告发送成功！");
                });

            })
            .controller("pushScore", function ($scope) {
                $('.submitBtn').bind('click', function (e) {
                    alert('模板文件发送成功！');
                });
            })
            .controller("redfollew", function ($scope) {
                $('.mailbox-messages input[type="checkbox"]').iCheck({
                    checkboxClass: 'icheckbox_flat-blue',
                    radioClass: 'iradio_flat-blue'
                });

                //Enable check and uncheck all functionality
                $(".checkbox-toggle").click(function () {
                    var clicks = $(this).data('clicks');
                    if (clicks) {
                        //Uncheck all checkboxes
                        $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                        $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
                    } else {
                        //Check all checkboxes
                        $(".mailbox-messages input[type='checkbox']").iCheck("check");
                        $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
                    }
                    $(this).data("clicks", !clicks);
                });

                //Handle starring for glyphicon and font awesome
                $(".mailbox-star").click(function (e) {
                    e.preventDefault();
                    //detect type
                    var $this = $(this).find("a > i");
                    var glyph = $this.hasClass("glyphicon");
                    var fa = $this.hasClass("fa");

                    //Switch states
                    if (glyph) {
                        $this.toggleClass("glyphicon-star");
                        $this.toggleClass("glyphicon-star-empty");
                    }

                    if (fa) {
                        $this.toggleClass("fa-star");
                        $this.toggleClass("fa-star-o");
                    }
                });
                $('i.fa-star').addClass('fa-star-o').removeClass('fa-star');
                $("i.fa-arrow-circle-up").bind('click', function (e) {
                    alert("勋章发布成功！");
                })
            });

    </script>
    <script src="<%=request.getContextPath()%>/resources/js/controllers/adminCtrl.indexCtrl.js"></script>
</head>
<!-- ADD THE CLASS fixed TO GET A FIXED HEADER AND SIDEBAR LAYOUT -->
<!-- the fixed layout is not compatible with sidebar-mini -->
<body class="hold-transition skin-green-light fixed sidebar-mini" ng-controller="adminCtrl">
<!-- Site wrapper -->
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="#/index" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini">圈</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>班级</b>圈</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <!-- =============================================== -->

    <!-- Left side column. contains the sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="<%=request.getContextPath()%>/resources/HtmlSource/dist/img/user2-160x160.jpg"
                         class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>小天才 老师</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="treeview">
                    <a>
                        <i class="fa fa-dashboard"></i> <span>用户控制台</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#/parent"><i class="fa fa-circle-o"></i> 增加新用户</a></li>
                        <li><a href="#/deleteOrSelect"><i class="fa fa-circle-o"></i> 查看与删除</a></li>
                        <%--<li><a href="#/sendRedFlower"><i class="fa fa-circle-o"></i> 学生</a></li>--%>
                    </ul>

                </li>
                <li class="treeview">
                    <a>
                        <i class="fa fa-pie-chart"></i>
                        <span>动态管理</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#/timeline"><i class="fa fa-circle-o"></i> 查看动态</a></li>
                        <%--<li><a href="#/picTimeline"><i class="fa fa-circle-o"></i> 查看图片动态</a></li>--%>
                    </ul>
                </li>
                <li class="treeview">
                    <a>
                        <i class="fa fa-files-o"></i>
                        <span>小功能</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#/issuegk"><i class="fa fa-circle-o"></i> 发布公告</a></li>
                        <li><a href="#/pushScore"><i class="fa fa-circle-o"></i> 成绩推送</a></li>
                        <li><a href="#/redfellow"><i class="fa fa-circle-o"></i> 颁发金色勋章</a></li>
                    </ul>
                </li>
                <li>
                    <a href="../widgets.html">
                        <i class="fa fa-th"></i> <span>消息</span>
                        <span class="pull-right-container">
              <small class="label pull-right bg-green">NEW</small>
            </span>
                    </a>
                </li>
                <li class="header">LABELS</li>
                <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
                <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
                <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- =============================================== -->

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <%--<section class="content-header">--%>
        <%--<h1>--%>
        <%--Fixed Layout--%>
        <%--<small>Blank example to the fixed layout</small>--%>
        <%--</h1>--%>
        <%--<ol class="breadcrumb">--%>
        <%--<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>--%>
        <%--<li><a href="#">Layout</a></li>--%>
        <%--<li class="active">Fixed</li>--%>
        <%--</ol>--%>
        <%--</section>--%>

        <!-- Main content -->
        <section class="content">
            <%--<div class="callout callout-info">--%>
            <%--<h4>Tip!</h4>--%>

            <%--<p>Add the fixed class to the body tag to get this layout. The fixed layout is your best option if your sidebar--%>
            <%--is bigger than your content because it prevents extra unwanted scrolling.</p>--%>
            <%--</div>--%>
            <!-- Default box -->
            <%--<div class="box">--%>
            <%--<div class="box-header with-border">--%>
            <%--<h3 class="box-title">Title</h3>--%>

            <%--<div class="box-tools pull-right">--%>
            <%--<button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">--%>
            <%--<i class="fa fa-minus"></i></button>--%>
            <%--<button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">--%>
            <%--<i class="fa fa-times"></i></button>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="box-body">--%>
            <%--Start creating your amazing application!--%>
            <%--</div>--%>
            <%--<!-- /.box-body -->--%>
            <%--<div class="box-footer">--%>
            <%--Footer--%>
            <%--</div>--%>
            <%--<!-- /.box-footer-->--%>
            <%--</div>--%>
            <!-- /.box -->

            <ng-view></ng-view>


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.6
        </div>
        <strong>Copyright &copy; 2014-2016 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights
        reserved.
    </footer>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="<%=request.getContextPath()%>/resources/HtmlSource/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="<%=request.getContextPath()%>/resources/HtmlSource/bootstrap/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="<%=request.getContextPath()%>/resources/HtmlSource/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="<%=request.getContextPath()%>/resources/HtmlSource/plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/HtmlSource/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/resources/HtmlSource/dist/js/demo.js"></script>

<script src="<%=request.getContextPath()%>/resources/HtmlSource/plugins/iCheck/icheck.min.js"></script>

</body>
</html>
