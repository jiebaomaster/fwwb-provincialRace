/**
 * Created by hongcj on 2017/4/19.
 */
angular.module("admin")
    .controller('indexCtrl', function ($scope, userService) {
        $scope.data = {};
        $scope.userInfo = userService.userInfoInit();
    });