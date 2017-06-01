/**
 * Created by hongcj on 2017/5/17.
 */
/**
 * 用户模块
 */
angular.module("userModule")
    .constant('userInfoPageSize', 2)
    .directive("userTable", function ($location, userInfoPageSize) {
        return {
            restrict: "E",
            templateUrl: function (element, attrs) {
                var tableName = attrs["tableType"] === "parentWithChildTable" ?
                    "parentWithChildTable" : "teacherTable";
                return '/resources/apps/adminApp/components/user/' + tableName + '.html';
            },
            link: function (scope, element, attrs) {
                var selectUserArr = [];
                var updateArr = [];
                var ele = $(element);
                var userTable = [];
                var pageSelectCount = 0;

                //数据显示相关
                scope.userTable4Show = [];
                scope.pageButtons = [];

                scope.selectPage = function (newPage) {
                    scope.userTable4Show = range(userTable, newPage, userInfoPageSize);
                };

                //数据加载完成时，调用
                scope.$on('userTableDataLoaded', init);

                //根据有无小红花字段动态添加样式
                scope.redFlowerTransform = function (haveRedFlower) {
                    var i = ele.find('i');
                    haveRedFlower ? i.addClass('fa-star') : i.addClass('fa-star-o');
                };


                //按钮动作
                //刷新
                scope.refreshTable = function () {
                    $location.path('/userAdmin');
                };
                //删除用户
                scope.userDelete = function () {
                    userService.deleteUser(selectUserArr);
                };
                //用户数据更新
                scope.update = function () {
                };


                //全选
                ele.find(".checkbox-toggle").bind('click', function () {
                    var $this = $(this);
                    var clicks = $this.data('clicks');
                    if (clicks) {
                        //Uncheck all checkboxes
                        ele.find(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                        $this.find(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
                    } else {
                        //Check all checkboxes
                        ele.find(".mailbox-messages input[type='checkbox']").iCheck("check");
                        $this.find(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
                    }
                    $this.data("clicks", !clicks);
                });

                //选择删除
                ele.find("i.fa-trash-o").bind('click', function (e) {
                    ele.find('.checked').parent().parent().remove();
                    alert("删除用户成功！");
                });

                //数据显示初始化
                function init() {
                    //根据表名得到不同的数据
                    var userScope = scope.$parent.user;
                    userTable = attrs["tableType"] === "parentWithChildTable" ?
                        userScope.classUserInfoWithChild : userScope.classTeacher;

                    scope.pageButtons = pageCount(userTable, userInfoPageSize);
                    pageSelectCount = 1;
                    scope.selectPage(pageSelectCount);
                }

                //得到分页显示的数据
                function range(table, page, size) {
                    if (angular.isArray(table) && angular.isNumber(page) && angular.isNumber(size)) {
                        var data = table.slice();
                        var start_index = (page - 1) * size;
                        if (data.length < start_index) {
                            return [];
                        } else {
                            return data.splice(start_index, size);
                        }
                    } else {
                        return table;
                    }
                }

                //得到分页页码
                function pageCount(data, size) {
                    if (angular.isArray(data)) {
                        var result = [];
                        for (var i = 0; i < Math.ceil(data.length / size); i++) {
                            result.push(data[i]);
                        }
                        return result;
                    } else {
                        return data;
                    }
                }
            },
            controller: function ($scope) {

            },
            scope: true
        };
    })
    .directive('myGoldenStar', function () {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                $(element).bind('click', function (e) {
                    var $this = $(e.target);

                    if ($this.hasClass("fa")) {
                        $this.toggleClass("fa-star");
                        $this.toggleClass("fa-star-o");
                    }
                });
            }
        };
    })
    .directive('myCheckbox', function () {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                $(element).iCheck({
                    checkboxClass: 'icheckbox_flat-blue',
                    radioClass: 'iradio_flat-blue'
                });
            }
        };
    });