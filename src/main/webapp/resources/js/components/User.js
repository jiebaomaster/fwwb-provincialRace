/**
 * Created by hongcj on 2017/5/17.
 */
angular.module("user", ['ngCookies'])
    .constant('userInfoUrl', '/user/show')
    .constant('classUserInfoUrl','/user/members')
    .factory("user", function (userInfoUrl, $http,$cookieStore) {
        var userInfo = {};
        var classUserInfo=[];

        return {
            userInfoInit: function () {
                $http.get(userInfoUrl,
                    {
                        "async": true,
                        "method": "GET",
                        "headers": {
                            "uid": $cookieStore.get("uid"),
                            "access-token": $cookieStore.get("access-token")
                        }
                    })
                    .then(function (response) {
                        userInfo = response.data.body;
                    }, function (error) {
                        console.log(error);
                    });
            },

            classUserInfoInit:function () {
                $http.get(classUserInfoUrl,
                    {
                        "async": true,
                        "method": "GET",
                        "headers": {
                            "uid": $cookieStore.get("uid"),
                            "access-token": $cookieStore.get("access-token")
                        }
                    })
                    .then(function (response) {
                        classUserInfo = response.data.body;
                    }, function (error) {
                        console.log(error);
                    })
            },

            classUserInfoWithChildInit:function () {

            }

        }
    });
