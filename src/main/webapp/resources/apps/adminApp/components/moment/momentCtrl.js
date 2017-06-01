/**
 * Created by hongcj on 2017/6/1.
 */
angular.module('momentModule')
    .controller('ClassMomentCtrl', function ($scope, momentService) {
        var self = this;

        momentService.classMomentInit().then(function (res) {
            self.classMoments = res.data.body;

            $scope.$broadcast('momentDataLoaded');
        }, function (error) {
            self.classMomentError = error;
        });
    })
    .controller('MyMomentCtrl', function () {
        var self = this;

        momentService.myMomentInit().then(function (res) {
            self.classMoments = res.data.body;

            $scope.$broadcast('momentDataLoaded');
        }, function (error) {
            self.classMomentError = error;
        });
    });