/**
 * Created by Adelmo Alves on 17/01/2017.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .controller('DetailUserController', detailUserController);

    detailUserController.$inject = ['$scope', 'UserService', '$stateParams'];

    function detailUserController($scope, UserService, $stateParams, $state) {
        getUser();

        function getUser(){
            UserService.get($stateParams.id, getSuccessCallback);
        }

        function getSuccessCallback(response){
            $scope.user = response;
        }

        $scope.save = function () {
            UserService.save($scope.user);
        };
    }
})();