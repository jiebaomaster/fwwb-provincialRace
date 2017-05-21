/**
 * Created by hongcj on 2017/5/17.
 */
angular.module("adminApp")
    .controller("userCtrl", function (userService) {
        // userService.userInfoInit();
        // userService.classUserInfoWithChildInit();
        // userService.classUserInfoTeacherInit();

        this.userInfo = userService.getUserInfo();
        this.classUserInfoWithChild = userService.getClassUserInfoWithChild();
        this.classTeacher = userService.getClassTeacher();

        this.addParent = userService.addParent;
        this.addTeacher = userService.addTeacher;
        this.deleteUser = userService.deleteUser;
    });
