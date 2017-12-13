/**
 * Created by hongcj on 2017/5/17.
 *
 */
angular.module("userModule")
    .controller("UserTableCtrl", function ($scope, userService) {
        var self = this;
        self.classUserInfoWithChild = [];
        self.classTeacher = [];

        userService.classUserInfoWithChildInit().then(function (res) {
            self.classUserInfoWithChild = res.data.body;
            //通知下层指令数据加载完成
            $scope.$broadcast('userTableDataLoaded');
        }, function (error) {
            self.parentLoadErrorMsg = error;
        });
        userService.classUserInfoTeacherInit().then(function (res) {
            self.classTeacher = res.data.body;
            $scope.$broadcast('userTableDataLoaded');
        }, function (error) {
            self.teacherLoadErrorMsg = error;
        });

        this.addParent = userService.addParent;
        this.addTeacher = userService.addTeacher;
        this.deleteUser = userService.deleteUser;
    });
