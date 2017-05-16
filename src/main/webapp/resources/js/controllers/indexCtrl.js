/**
 * Created by hongcj on 2017/4/19.
 */

// angular.module("sportsStoreAdmin")
//     .constant("authUrl", "http://localhost:2403/users/login")
//     .controller("authCtrl", function ($scope, $http, $location, authUrl) {
//         $scope.authenticate = function (user, pass) {
//             $http.post(authUrl, {
//                 username: user,
//                 password: pass
//             }, {
//                 withCredentials: true
//             }).then(function (data) {
//                 // $location.path("/main");
//                 console.log(data);
//             }, function (error) {
//                 $scope.authenticationError = error;
//                 alert(error);
//             });
//         }
//     });
angular.module("admin")
    .constant('classUserInfoUrl', "http://www.onlinebaoplan.top/user/members")
    .controller('adminCtrl', function ($scope,$http,classUserInfoUrl) {
        // $scope.data = {};
        //
        // var settings={
        //     "async": true,
        //     "crossDomain": true,
        //     "method": "GET",
        //     "headers": {
        //         "uid": "1",
        //         "access-token": "jTW9TEZC/3mbbAgk3YXjWA==",
        //         "cache-control": "no-cache",
        //         "postman-token": "616b8a33-24c0-ae41-92bd-2352703199b7"
        //     }
        // };
        //
        // $http.get(classUserInfoUrl,settings)
        //     .success(function (data) {
        //         $scope.data.classUserInfoUrl = data;
        //     })
        //     .error(function (error) {
        //         $scope.data.error = error;
        //     });
        //
        // $scope.getUserInfo = function () {
        //
        // }
    });