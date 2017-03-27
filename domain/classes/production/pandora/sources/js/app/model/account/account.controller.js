(function () {
    'use strict';

    angular
        .module('pandora')
        .controller('AccountController', AccountController);


    AccountController.$inject = ['$scope', 'Account', 'Principal'];

    function AccountController($scope, Account, Principal) {
        Principal.identity().then(callbackSucces);

        function callbackSucces(account) {
            $scope.identity = angular.copy(account);
        }
    }
})();