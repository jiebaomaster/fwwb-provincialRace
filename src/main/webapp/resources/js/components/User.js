/**
 * Created by hongcj on 2017/5/17.
 */
/**
 * 用户模块
 */
angular.module("user", ['ngCookies'])
    .constant('userInfoUrl', '/user/show')
    .constant('classUserInfoUrl', '/user/members')
    .constant('classUserInfoWithChildUrl', '/user/lassUserInfoWithChild')
    .constant('classUserInfoTeacherUrl', '/user/classTeacher')
    .constant('userDeleteUrl', '/user/delete')
    .factory("userService", function ($http, $cookieStore, userInfoUrl, classUserInfoUrl, classUserInfoWithChildUrl, classUserInfoTeacherUrl, userDeleteUrl) {
        var userInfo = {},
            classUserInfo = [],
            classUserInfoWithChild = [],
            classTeacher = [];

        var httpGetSetting = {
                "async": true,
                "method": "GET",
                "headers": {
                    "uid": $cookieStore.get("uid"),
                    "access-token": $cookieStore.get("access-token")
                }
            },
            httpPostSetting = {
                "async": true,
                "method": "POST",
                "headers": {
                    "uid": $cookieStore.get("uid"),
                    "access-token": $cookieStore.get("access-token")
                }
            };

        return {
            getUserInfo: function () {
                return userInfo;
            },

            getClassUserInfo: function () {
                return classUserInfo;
            },

            getClassUserInfoWithChild: function () {
                return classUserInfoWithChild;
            },

            getClassTeacher: function () {
                return classTeacher;
            },

            userInfoInit: function () {
                $http.get(userInfoUrl, httpGetSetting)
                    .then(function (response) {
                        userInfo = response.data.body;
                    }, function (error) {
                        console.log(error);
                    });
            },

            classUserInfoInit: function () {
                $http.get(classUserInfoUrl, httpGetSetting)
                    .then(function (response) {
                        classUserInfo = response.data.body;
                    }, function (error) {
                        console.log(error);
                    });
            },

            classUserInfoWithChildInit: function () {
                $http.get(classUserInfoWithChildUrl, httpGetSetting)
                    .then(function (response) {
                        classUserInfoWithChild = response.data.body;
                    }, function (error) {
                        console.log(error);
                    });
            },

            classUserInfoTeacherInit: function () {
                $http.get(classUserInfoTeacherUrl, httpGetSetting)
                    .then(function (response) {
                        classTeacher = response.data.body;
                    }, function (error) {
                        console.log(error);
                    });
            },

            addParent: function (parentInfo) {

            },

            addTeacher: function (teacherInfo) {

            },

            deleteUser: function (userNo) {
                $http.post(userDeleteUrl,
                    {
                        "userNo": userNo
                    },
                    httpPostSetting)
                    .then(function (response) {
                        classUserInfoWithChild = response.data.body;
                    }, function (error) {
                        console.log(error);
                    })
            }
        };
    })
    .directive("userTable", function () {
        return {
            restrict: "E",
            templateUrl: function (element, attrs) {
                var tableName = attrs["table"] === "parentWithChildTable" ?
                    "parentWithChildTable" : "teacherTable";
                return './template' + tableName + '.html';
            },
            link: function (scope, element, attrs) {
                var selectUserArr=[];

                //根据有无小红花字段动态添加样式
                scope.redFlowerTransform = function (haveRedFlower) {
                    var i = $(element).find('i');
                    haveRedFlower ? i.addClass('fa-star') : i.addClass('fa-star-o');
                };

                //
                scope.userDelete = function () {
                    userService.deleteUser(selectUserArr);
                };

                scope.update=function () {

                }
            },
            scope: true
        };
    });
