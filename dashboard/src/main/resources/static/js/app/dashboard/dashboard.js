/**
 * Created by adelmo on 2/14/16.
 */
(function () {
    'use strict'

    angular.module('rhinoApplication').config(function ($stateProvider) {


        $stateProvider.state('dashboard', {
            parent: 'default',
            url: '/dashboard',
            views: {
                'content@': {
                    templateUrl: '/layout?view=dashboard/index',
                    controller: 'dashboardController'
                }
            },
            data: {
                pageTitle: 'Dashboard'
            }
        });
    });
})();
