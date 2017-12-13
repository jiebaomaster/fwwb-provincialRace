/**
 * Created by hongcj on 2017/4/19.
 */
angular.module("adminApp")
    .controller('IndexCtrl', function (userService) {
        var self = this;
        userService.userInfoInit().then(function (res) {
            self.userInfo = res.data.body;
        })
    });