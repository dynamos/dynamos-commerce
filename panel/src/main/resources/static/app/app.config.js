/**
 * Created by adelmo.pereira on 24/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').config(config);

    config.$inject = ['$stateProvider', '$urlRouterProvider', '$httpProvider', '$breadcrumbProvider'];

    function config($stateProvider, $urlRouterProvider, $httpProvider, $breadcrumbProvider) {
        $httpProvider.defaults.xsrfCookieName = 'CSRF-TOKEN';
        $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';

        $urlRouterProvider.otherwise('/dashboard');

        $httpProvider.interceptors.push('notificationInterceptor');


        $breadcrumbProvider.setOptions({
            prefixStateName: 'dashboard',
            includeAbstract: true,
            template: '<li class="breadcrumb-item" ng-repeat="step in steps" ng-class="{active: $last}" ng-switch="$last || !!step.abstract"><a ng-switch-when="false" href="{{step.ncyBreadcrumbLink}}">{{step.ncyBreadcrumbLabel}}</a><span ng-switch-when="true">{{step.ncyBreadcrumbLabel}}</span></li>'
        });

        $stateProvider.state('default', {
            abstract: true,
            ncyBreadcrumb: {
                label: 'Root',
                skip: true
            },
            views: {
                'header@': {
                    templateUrl: 'views/navbar.html'
                },
                'sidebar@': {
                    templateUrl: 'views/sidebar.html'
                }
            }
        });

        $stateProvider.state('dashboard', {
            parent: 'default',
            url: '/dashboard',
            ncyBreadcrumb: {
                label: 'Home'
            },
            views: {
                'content@': {
                    templateUrl: 'views/dashboard.html'
                }
            }
        });
    }
})();