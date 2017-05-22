/**
 * Created by hongcj on 2017/5/17.
 */
angular.module("userModule")
    .controller("UserBase",function (userService) {
        this.userInfo=userService.getUserInfo();
    })
    .controller("UserTable", function (userService) {
        // userService.userInfoInit();
        // userService.classUserInfoWithChildInit();
        // userService.classUserInfoTeacherInit();

        this.classUserInfoWithChild = userService.getClassUserInfoWithChild();
        this.classTeacher = userService.getClassTeacher();

        this.addParent = userService.addParent;
        this.addTeacher = userService.addTeacher;
        this.deleteUser = userService.deleteUser;
    });
