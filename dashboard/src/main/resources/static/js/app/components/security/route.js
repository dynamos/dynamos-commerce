/**
 * Created by adelmo.pereira on 14/09/2016.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {

        $stateProvider.state('login', {
            url: '/login',
            templateUrl: 'views/security/login.html',
            controller: 'LoginController',
        });
        //State
        $stateProvider.state('recovery-password', {
            url: '/recovery-password',
            templateUrl: 'views/security/recovery-password.html'
        });
    }
})();