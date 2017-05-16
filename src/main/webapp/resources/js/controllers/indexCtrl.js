/**
 * Created by hongcj on 2017/4/19.
 */
angular.module("admin")
    .constant('classUserInfoUrl', "/user/show")
    .controller('indexCtrl', function ($scope, $http, $cookieStore, classUserInfoUrl) {


        $scope.data = {};

        $http.get(classUserInfoUrl,
            {
                "async": true,
                "method": "GET",
                "headers": {
                    "uid": $cookieStore.get("uid"),
                    "access-token": $cookieStore.get("access-token")
                }
            })
            .then(function (response) {
                console.log(response);
                $scope.data.userInfo = response.data.body;
            }, function (error) {
                console.log(error);
            })
    });