/**
 * Created by hongcj on 2017/6/1.
 */
angular.module('momentModule')
    .constant('classMomentUrl', '/moment/class_public_timeline')
    .constant('myMomentUrl', '/moment/user_timeline')
    .constant('deleteMomentUrl', '/moment/delete')
    .factory('momentService', function ($cookieStore, $http, classMomentUrl, myMomentUrl) {
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
            classMomentInit: function () {
                return $http.get(classMomentUrl, httpGetSetting);
            },

            myMomentInit: function () {
                return $http.get(myMomentUrl, httpGetSettingt);
            },

            deleteMoment: function (momentId) {
                return $http.post(deleteMomentUrl, {
                    'moment_id': momentId
                }, httpPostSetting);
            }
        };
    });