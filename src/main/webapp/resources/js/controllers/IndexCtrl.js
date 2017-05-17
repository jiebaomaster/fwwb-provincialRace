/**
 * Created by hongcj on 2017/4/19.
 */
angular.module("admin")
    .constant('userInfoUrl', "/user/show")
    .controller('indexCtrl', function ($scope, $http, $cookieStore, userInfoUrl) {
        $scope.data = {};

        $http.get(userInfoUrl,
            {
                "async": true,
                "method": "GET",
                "headers": {
                    "uid": $cookieStore.get("uid"),
                    "access-token": $cookieStore.get("access-token")
                }
            })
            .then(function (response) {
                $scope.data.userInfo = response.data.body;
            }, function (error) {
                $scope.data.userInfoRequestError = error;
            })
    });