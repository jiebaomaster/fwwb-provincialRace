/**
 * Created by hongcj on 2017/4/18.
 */
angular.module("sportsStore")
    .controller("cartSummaryCtrl", function ($scope, cart) {
        $scope.cartData = cart.getProduct();

        $scope.total = cart.total;

        $scope.remove = function (id) {
            cart.removeProduct(id);
        };
    });