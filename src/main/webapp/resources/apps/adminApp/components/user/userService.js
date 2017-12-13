/**
 * Created by hongcj on 2017/5/19.
 */
angular.module('userModule')
    .constant('userInfoUrl', '/user/show')
    .constant('classUserInfoUrl', '/user/members')
    .constant('classUserInfoWithChildUrl', '/webapp/user/classUserInfoWithChild')
    .constant('classUserInfoTeacherUrl', '/webapp//user/classTeacher')
    .constant('userDeleteUrl', '/webapp/user/delete')
    .constant('teacherAddUrl', '/webapp/user/addTeacher')
    .constant('parentWithChildAddUrl', '/webapp/user/addParentWithChild')
    .factory("userService", function ($http, $cookieStore, userInfoUrl,
                                      classUserInfoUrl, classUserInfoWithChildUrl, classUserInfoTeacherUrl, userDeleteUrl, teacherAddUrl, parentWithChildAddUrl) {
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
            userInfoInit: function () {
                return $http.get(userInfoUrl, httpGetSetting);
            },

            classUserInfoInit: function () {
                return $http.get(classUserInfoUrl, httpGetSetting);
            },

            classUserInfoWithChildInit: function () {
                return $http.get(classUserInfoWithChildUrl, httpGetSetting);

            },

            classUserInfoTeacherInit: function () {
                return $http.get(classUserInfoTeacherUrl, httpGetSetting);
            },

            addParent: function (parentWithChildInfoArr) {
                $http.post(parentWithChildAddUrl, parentWithChildInfoArr, httpPostSetting)
                    .then(function (response) {

                    }, function (error) {

                    });


            },

            addTeacher: function (teacherInfoArr) {
                $http.post(teacherAddUrl, teacherInfoArr, httpPostSetting)
                    .than(function (response) {

                    }, function (error) {

                    });
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
    });
