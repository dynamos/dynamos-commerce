angular
    .module('pandora')
    .config(['$stateProvider', '$urlRouterProvider', '$ocLazyLoadProvider', '$breadcrumbProvider', function ($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $breadcrumbProvider) {

        $urlRouterProvider.otherwise('/dashboard');

        $ocLazyLoadProvider.config({
            debug: false
        });

        $breadcrumbProvider.setOptions({
            prefixStateName: 'app.main',
            includeAbstract: true,
            template: '<li class="breadcrumb-item" ng-repeat="step in steps" ng-class="{active: $last}" ng-switch="$last || !!step.abstract"><a ng-switch-when="false" href="{{step.ncyBreadcrumbLink}}">{{step.ncyBreadcrumbLabel}}</a><span ng-switch-when="true">{{step.ncyBreadcrumbLabel}}</span></li>'
        });

        $stateProvider
            .state('app', {
                abstract: true,
                templateUrl: 'views/common/layouts/full.html',
                ncyBreadcrumb: {
                    label: 'Root',
                    skip: true
                }
            })
            .state('app.main', {
                url: '/dashboard',
                templateUrl: 'views/main.html',
                ncyBreadcrumb: {
                    label: 'Dashboard'
                },
                resolve: {
                    loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            files: ['js/app/controllers/main.js']
                        });
                    }]
                }
            })

            // Additional Pages
            .state('404', {
                url: '/404',
                templateUrl: 'views/errors/404.html'
            })
            .state('500', {
                url: '/500',
                templateUrl: 'views/errors/500.html'
            })
            .state('401', {
                url: '/401',
                templateUrl: 'views/errors/401.html'
            })
    }]);
