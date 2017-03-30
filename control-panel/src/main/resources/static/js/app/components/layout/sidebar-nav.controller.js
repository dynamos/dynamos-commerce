/**
 * Created by adelmo.pereira on 30/03/2017.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .controller('sidebarController', sidebarController);


    sidebarController.$inject = ['$scope', 'Account', 'Principal'];

    function sidebarController($scope, Account, Principal) {
        var vm = this;

        vm.isAuthenticated = Principal.isAuthenticated;
    }
})();