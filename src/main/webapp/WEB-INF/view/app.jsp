<!--<!doctype html>-->
<!--<html lang="en" ng-app="sportsStore">-->
<!--<head>-->
    <!--<meta charset="UTF-8">-->
    <!--<title>SportStore</title>-->
    <!--<link rel="stylesheet" href="../../resources/css/lib/bootstrap.css">-->
    <!--<link rel="stylesheet" href="/resources/css/lib/bootstrap-theme.css">-->
    <!--<script type="text/javascript" src="/resources/js/lib/angular.js"></script>-->
    <!--<script>-->
        <!--angular.module("sportsStore", ["customFilters", "cart", "ngRoute"])-->
            <!--.config(function ($routeProvider, $locationProvider) {-->
                <!--$locationProvider.hashPrefix('');-->

                <!--$routeProvider.when("/complete", {-->
                    <!--templateUrl: "/views/thankYou.html"-->
                <!--});-->

                <!--$routeProvider.when("/placeOrder", {-->
                    <!--templateUrl: "/views/placeOrder.html"-->
                <!--});-->

                <!--$routeProvider.when("/checkout", {-->
                    <!--templateUrl: "/views/checkoutSummary.html"-->
                <!--});-->

                <!--$routeProvider.when("/products", {-->
                    <!--templateUrl: "/views/productList.html"-->
                <!--});-->

                <!--$routeProvider.otherwise({-->
                    <!--templateUrl: "/views/productList.html"-->
                <!--});-->
            <!--});-->
    <!--</script>-->
    <!--<script src="/resources/js/controllers/sportsStore.js"></script>-->
    <!--<script src="/resources/js/filters/customFilters.js"></script>-->
    <!--<script src="/resources/js/controllers/productListCtrl.js"></script>-->
    <!--<script src="/resources/js/components/cart.js"></script>-->
    <!--<script src="/resources/js/lib/angular-route.js"></script>-->
    <!--<script src="/resources/js/controllers/carSummeryCtrl.js"></script>-->
<!--</head>-->
<!--<body ng-controller="sportsStoreCtrl">-->
<!--&lt;!&ndash;<div class="navbar navbar-inverse">&ndash;&gt;-->
    <!--&lt;!&ndash;<a href="#" class="navbar-brand">SPORTS STORE</a>&ndash;&gt;-->
    <!--&lt;!&ndash;<cart-summary></cart-summary>&ndash;&gt;-->
<!--&lt;!&ndash;</div>&ndash;&gt;-->
<!--&lt;!&ndash;<div class="alert alert-danger" ng-show="data.error">&ndash;&gt;-->
    <!--&lt;!&ndash;Error ({{data.error.status}}).The product data was not loaded.&ndash;&gt;-->
    <!--&lt;!&ndash;<a href="app.jsp" class="alert-link">try again</a>&ndash;&gt;-->
<!--&lt;!&ndash;</div>&ndash;&gt;-->
<!--&lt;!&ndash;<ng-view></ng-view>&ndash;&gt;-->
<!--<p>{{"AngularJs"}}</p>-->
<!--</body>-->
<!--</html>-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app>
<head>
    <title>First Test</title>
    <script src="<%=request.getContextPath()%>/resources/js/lib/angular.js"></script>
    <link href="<%=request.getContextPath()%>/resources/css/lib/bootstrap.css" rel="stylesheet" />
</head>
<body>
<div class="btn btn-default">{{"AngularJS"}}</div>
<div class="btn btn-success">Bootstrap</div>
</body>
</html>