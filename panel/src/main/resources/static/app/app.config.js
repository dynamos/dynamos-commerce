/**
 * Created by adelmo.pereira on 24/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').config(config);

    config.$inject = ['$stateProvider', '$urlRouterProvider', '$httpProvider', 'httpRequestInterceptorCacheBusterProvider'];

    function config($stateProvider, $urlRouterProvider, $httpProvider, httpRequestInterceptorCacheBusterProvider) {
        $httpProvider.defaults.xsrfCookieName = 'CSRF-TOKEN';
        $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';

        httpRequestInterceptorCacheBusterProvider.setMatchlist([/.*api.*/], true);

        $urlRouterProvider.otherwise('/dashboard');

        $stateProvider.state('default', {
            abstract: true,
            views: {
                'header@': {
                    templateUrl: 'views/main-header.html'
                },
                'sidebar@': {
                    templateUrl: 'views/main-sidebar.html'
                }
            }
        });

        $stateProvider.state('dashboard', {
            parent: 'default',
            url: '/dashboard',
            views: {
                'content@': {
                    templateUrl: 'views/dashboard.html'
                }
            }
        });
    }
})();