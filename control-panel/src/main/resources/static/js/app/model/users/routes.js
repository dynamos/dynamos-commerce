/**
 * Created by adelmo.pereira on 09/09/2016.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {

        $stateProvider.state('users', {
            parent: "app",
            url: '/users',
            ncyBreadcrumb: {
                label: 'Users'
            },
            data: {
                authorities: ['ROLE_ADMIN'],
                pageTitle: 'Users'
            },
            templateUrl: 'views/model/users/search.html',
            controller: 'SearchUsersController'
        });

        $stateProvider.state('users.create', {
            parent: "app",
            url: '/users/create',
            ncyBreadcrumb: {
                parent: 'users',
                label: 'Create User'
            },
            data: {
                authorities: ['ROLE_ADMIN'],
                pageTitle: 'Create User'
            },
            templateUrl: 'views/model/users/create.html',
            controller: 'CreateUserController'
        });

        $stateProvider.state('users.detail', {
            parent: "app",
            url: '/users/:id',
            ncyBreadcrumb: {
                parent: 'users',
                label: 'User Detail'
            },
            data: {
                authorities: ['ROLE_ADMIN'],
                pageTitle: 'User Details'
            },
            templateUrl: 'views/model/users/detail.html',
            controller: 'DetailUserController'
        });
    }
})();