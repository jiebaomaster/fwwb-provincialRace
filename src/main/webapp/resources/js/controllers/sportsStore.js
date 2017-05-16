/**
 * Created by hongcj on 2017/4/17.
 */
angular.module("sportsStore")
    .constant("dataUrl", "http://localhost:2403/products")
    .constant("orderUrl", "http://localhost:2403/orders")
    .controller("sportsStoreCtrl", function ($scope, $http, dataUrl, $location, orderUrl, cart) {
        $scope.data = {};
        $http.get(dataUrl)
            .then(function (data) {
                $scope.data.products = data.data;
            }, function (error) {
                $scope.data.error = error;
            });

        $scope.sendOrder = function (shippingDetails) {
            var order = angular.copy(shippingDetails);
            order.products = cart.getProduct();
            $http.post(orderUrl, order)
                .then(function (data) {
                    $scope.data.orderId = data.products;
                    cart.getProduct().length = 0;
                }, function (error) {
                    $scope.data.orderError = error;
                }).finally(function () {
                $location.path("/complete");
            });
        }
    });
