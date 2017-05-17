/**
 * Created by hongcj on 2017/5/16.
 */
angular.module('admin', ['ngRoute','ngCookies'])
    .config(function ($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix('');

        $routeProvider.when("/parent", {
            templateUrl: "../../html/parentTable.html"
        });
        $routeProvider.when("/deleteOrSelect", {
            templateUrl: "../../html/teacherTable.html"
        });

        $routeProvider.when("/issuegk", {
            templateUrl: "../../html/fbgg.html"
        });
        $routeProvider.when("/pushScore", {
            templateUrl: "../../html/pushScore.html"
        });
        $routeProvider.when("/redfellow", {
            templateUrl: "../../html/redfellow.html"
        });

        $routeProvider.when("/index", {
            templateUrl: "./template/index.html"
        });

        $routeProvider.otherwise({
            templateUrl: "./template/index.html"
        });
    })
    .controller("use", function ($scope) {
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
    })
    .controller("createUser",function (e) {

    })
    .controller("timelineCtrl", function ($scope) {
        $('.timeline-footer a').bind('click', function (e) {
            $(e.target).parent().parent().parent().remove();
            alert("动态删除成功！");
        });
    })
    .controller("fbgg", function ($scope) {
        $('.submitBtn').bind('click', function (e) {
            $('.ggfb').find('input').val('');
            $('.ggfb').find('textarea').val('');
            alert("公告发送成功！");
        });

    })
    .controller("pushScore", function ($scope) {
        $('.submitBtn').bind('click', function (e) {
            alert('模板文件发送成功！');
        });
    })
    .controller("redfollew", function ($scope) {
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
        $('i.fa-star').addClass('fa-star-o').removeClass('fa-star');
        $("i.fa-arrow-circle-up").bind('click', function (e) {
            alert("勋章发布成功！");
        })
    });
