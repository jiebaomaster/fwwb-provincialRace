/**
 * Created by hongcj on 2017/5/17.
 */
/**
 * 用户模块
 */
angular.module("userModule")
    .directive("userTable", function () {
        return {
            restrict: "E",
            templateUrl: function (element, attrs) {
                var tableName = attrs["tableType"] === "parentWithChildTable" ?
                    "parentWithChildTable" : "teacherTable";
                return '/resources/apps/adminApp/components/user/' + tableName + '.html';
            },
            link: function (scope, element, attrs) {
                var selectUserArr = [];

                //根据有无小红花字段动态添加样式
                scope.redFlowerTransform = function (haveRedFlower) {
                    var i = $(element).find('i');
                    haveRedFlower ? i.addClass('fa-star') : i.addClass('fa-star-o');
                };

                //
                scope.userDelete = function () {
                    userService.deleteUser(selectUserArr);
                };

                scope.update = function () {

                };

                $('.mailbox-messages input[type="checkbox"]').iCheck({
                    checkboxClass: 'icheckbox_flat-blue',
                    radioClass: 'iradio_flat-blue'
                });

                //Enable check and uncheck all functionality
                $(".checkbox-toggle").click(function () {
                    var clicks = $(this).data('clicks');
                    if (clicks) {
                        //Uncheck all checkboxes
                        $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                        $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
                    } else {
                        //Check all checkboxes
                        $(".mailbox-messages input[type='checkbox']").iCheck("check");
                        $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
                    }
                    $(this).data("clicks", !clicks);
                });

                //Handle starring for glyphicon and font awesome
                $(".mailbox-star").click(function (e) {
                    e.preventDefault();
                    //detect type
                    var $this = $(this).find("a > i");
                    var glyph = $this.hasClass("glyphicon");
                    var fa = $this.hasClass("fa");

                    //Switch states
                    if (glyph) {
                        $this.toggleClass("glyphicon-star");
                        $this.toggleClass("glyphicon-star-empty");
                    }

                    if (fa) {
                        $this.toggleClass("fa-star");
                        $this.toggleClass("fa-star-o");
                    }
                });

                $("i.fa-trash-o").bind('click', function (e) {
                    $(".userInfo-form").find('.checked').parent().parent().remove();
                    alert("删除用户成功！");
                })
            },
            scope: true
        };
    });
