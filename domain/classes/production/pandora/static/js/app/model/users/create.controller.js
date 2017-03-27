/**
 * Created by Adelmo on 09/09/2016.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .controller('CreateUserController', createUserController);

    createUserController.$inject = ['$scope', 'UserService'];

    function createUserController($scope, UserService) {
        $scope.user = {};

        $scope.save = function () {
            UserService.save($scope.user, successCallback);
        };

        function successCallback(){
            $scope.user = {};
        }
    }
})();