/**
 * Created by hongcj on 2017/5/17.
 */
/**
 * 用户模块
 */
angular.module("user", ['ngCookies'])
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
