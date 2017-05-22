/**
 * Created by hongcj on 2017/5/22.
 */
require.config({
    baseUrl: "",
    paths: {
        //lib
        "jquery": "./lib/plugins/jQuery/jquery203",
        "angular": "./lib/angular/angular",
        "angular-route": "./lib/angular/angular-route",
        "angular-cookies": "./lib/angular/angular-cookies",

        //module
        "adminApp": "../WEB-INF/view/admin.module",

        //service
        "userService": "./apps/adminApp/components/user/userService",

        //controller
        "indexCtrl": "./apps/adminApp/components/index/indexCtrl",
        "userCtrl": "./apps/adminApp/components/user/userCtrl"

    },
    shim: {
        "angular": {
            exports: "angular"
        },
        "angular-route": {
            deps: ["angular"],
            exports: "angular-route"
        },
        "angular-cookies": {
            deps: ["angular"],
            exports: "angular-cookies"
        }
    }
});

require(['jquery', 'angular', 'angular-route', 'angular-cookies', 'adminApp', 'userService', 'indexCtrl', 'userCtrl'], function ($, angular) {
    $(function () {
        angular.bootstrap(document, ["adminApp"]);
    })
});