/**
 * Created by hongcj on 2017/4/17.
 */
angular.module("cart", [])
    .factory("cart", function () {
        var cartData = [];

        return {
            addProduct: function (id, name, price) {
                var added2ExistingItem = false;
                for (var i = 0; i < cartData.length; i++) {
                    if (cartData[i].id == id) {
                        cartData[i].count++;
                        added2ExistingItem = true;
                        break;
                    }
                }

                if (!added2ExistingItem) {
                    cartData.push({
                        id: id,
                        count: 1,
                        price: price,
                        name: name
                    });
                }
            },

            removeProduct: function (id) {
                for (var i = 0; i < cartData.length; i++) {
                    if (cartData[i].id == id) {
                        cartData.splice(i, 1);
                        break;
                    }
                }
            },

            getProduct: function () {
                return cartData;
            },

            total: function () {
                var total = 0;
                for (var i = 0; i < cartData.length; i++) {
                    total += (cartData[i].price * cartData[i].count);
                }
                return total;
            }
        }
    })
    .directive("cartSummary", function (cart) {
        return {
            restrict: "E",
            templateUrl: "components/cart/cartSummary.html",
            controller: function ($scope) {
                var cartData = cart.getProduct();

                $scope.total = cart.total;

                $scope.itemCount = function () {
                    var total = 0;
                    for (var i = 0; i < cartData.length; i++) {
                        total += cartData[i].count;
                    }
                    return total;
                };
            }
        }
    });