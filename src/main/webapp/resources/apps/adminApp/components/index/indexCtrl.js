/**
 * Created by hongcj on 2017/4/19.
 */
angular.module("adminApp")
    .controller('IndexCtrl', function (userService) {
        this.userInfo = userService.getUserInfo();
    });