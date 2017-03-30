/**
 * Created by adelmo.pereira on 05/01/2017.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {

        $stateProvider.state('account', {
            parent: "app",
            url: '/account',
            ncyBreadcrumb: {
                label: 'Account',
                parent: 'app.main'
            },
            data: {
                authorities: ['ROLE_ADMIN'],
                pageTitle: 'Account'
            },
            templateUrl: 'views/model/account/account.html',
            controller: 'AccountController'
        });
    }
})();
