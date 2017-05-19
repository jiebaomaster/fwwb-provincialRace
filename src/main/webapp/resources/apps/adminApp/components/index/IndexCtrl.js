/**
 * Created by hongcj on 2017/4/19.
 */
angular.module("admin")
    .controller('indexCtrl', function (userService) {
        userService.userInfoInit();
        this.userInfo = userService.getUserInfo();
    });