/**
 * Created by adelmo.pereira on 04/01/2017.
 */
(function () {
    'use strict';

    angular.module('pandora').controller('LoginController', LoginController);

    LoginController.$inject = ['$scope', 'Auth', 'Principal', '$state'];

    function LoginController($scope, Auth, Principal, $state) {

        $scope.login = function () {
            var credentials = {
                username: $scope.username,
                password: $scope.password
            };

            Auth.login(credentials).then(successCallback);
        };

        function successCallback() {
            Principal.identity(true);
            $state.go('app.main');
        }
    }
})
();