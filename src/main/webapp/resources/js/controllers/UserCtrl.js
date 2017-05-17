/**
 * Created by hongcj on 2017/5/17.
 */
angular.module("admin")
    .controller("userCtrl", function ($scope, userService) {
        userService.userInfoInit();
        userService.classUserInfoWithChildInit();
        userService.classUserInfoTeacherInit();
        $scope.userInfo = userService.getUserInfo();
        $scope.classUserInfoWithChild = userService.getClassUserInfoWithChild();
        $scope.classTeacher = userService.getClassTeacher();

        $scope.addParent = function () {
            userService.addParent(parentInfo);
        };

        $scope.addTeacher = function () {
            userService.addTeacher(teacherInfo);
        };

        $scope.deleteUser = function (userNo) {
            userService.deleteUser(userNo);
        }
    });
