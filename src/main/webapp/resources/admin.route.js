/**
 * Created by hongcj on 2017/5/22.
 */
angular.module('adminApp')
    .config(function ($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix('');

        $routeProvider.when("/userAdmin", {
            templateUrl: "/resources/html/userTable.html",
            controller:"UserTableCtrl",
            controllerAs:"user"
        });

        // $routeProvider.when("/deleteOrSelect", {
        //     templateUrl: "/resources/html/teacherTable.html"
        // });
        //
        // $routeProvider.when("/issuegk", {
        //     templateUrl: "/resources/html/fbgg.html"
        // });
        //
        // $routeProvider.when("/pushScore", {
        //     templateUrl: "/resources/html/pushScore.html"
        // });
        //
        // $routeProvider.when("/redfellow", {
        //     templateUrl: "/resources/html/redfellow.html"
        // });

        $routeProvider.when("/index", {
            templateUrl: "/resources/html/index.html"
        });

        $routeProvider.otherwise({
            // templateUrl: "../../resources/html/index.html"
            templateUrl:"/resources/html/index.html"
        });
    });