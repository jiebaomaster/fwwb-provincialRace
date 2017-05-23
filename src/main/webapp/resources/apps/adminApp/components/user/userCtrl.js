/**
 * Created by hongcj on 2017/5/17.
 */
angular.module("userModule")
    .controller("UserTableCtrl", function (userService) {
        var self = this;

        userService.classUserInfoWithChildInit().then(function (res) {
            self.classUserInfoWithChild = res.data.body;
        });
        userService.classUserInfoTeacherInit().then(function (res) {
            self.classTeacher = res.data.body;
        });

        this.addParent = userService.addParent;
        this.addTeacher = userService.addTeacher;
        this.deleteUser = userService.deleteUser;
    });
