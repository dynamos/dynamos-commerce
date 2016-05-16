/**
 * Created by adelmo on 2/14/16.
 */
angular.module('rhinoApplication', ['ui.bootstrap', 'ngSanitize', 'ui.router',
    'ngResource', 'ngFileUpload', 'ngCacheBuster', 'angular-loading-bar']);


angular.module('rhinoApplication').config(function ($stateProvider, $urlRouterProvider, $httpProvider, httpRequestInterceptorCacheBusterProvider) {

    //Enable CSRF
    $httpProvider.defaults.xsrfCookieName = 'CSRF-TOKEN';
    $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';

    //Evict cache
    httpRequestInterceptorCacheBusterProvider.setMatchlist([/.*/], true);

    $urlRouterProvider.otherwise('/dashboard');

    $stateProvider.state('default',{
        abstract: true,
        views: {
            'nav-header@': {
                templateUrl: '/layout?view=nav-header'
            }
            ,
            'side-bar@': {
                templateUrl: '/layout?view=side-bar'
            }
        },
        data: {
            pageTitle: 'Dashboard'
        }
    });
}).run(function ($rootScope, $state) {
    $rootScope.$state = $state;
});
