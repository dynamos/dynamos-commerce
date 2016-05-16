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

/**
 * Created by adelmo on 2/14/16.
 */
(function () {

    'use strict'

    angular.module('rhinoApplication').controller('dashboardController', function ($scope, $http) {

    });
})();


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

/**
 * Created by adelmo on 2/14/16.
 */
(function () {
    'use strict'

    angular.module('rhinoApplication').controller('perfilController', function ($scope, $http, Perfil) {
        $scope.user = Perfil.get();

        $scope.save = function(){
            Perfil.save($scope.user, function(response){
                $scope.messages = [{
                    title : response.title,
                    body  : response.body,
                    messageType: response.messageType
                }];
            }, function(error){
                $scope.messages = error.data;
            });
        }
    });
})();


/**
 * Created by adelmo on 2/14/16.
 */
(function () {

    'use strict'

    angular.module('rhinoApplication').config(function ($stateProvider) {
        $stateProvider.state('perfil', {
            parent: 'default',
            url: '/perfil',
            views: {
                'content@': {
                    templateUrl: '/layout?view=perfil/index',
                    controller: 'perfilController'
                }
            },
            data: {
                pageTitle: 'Dashboard'
            }
        });
    });

})();

/**
 * Created by adelmo on 2/14/16.
 */

(function () {
    'use strict'
    angular.module('rhinoApplication').factory('Perfil', function ($resource) {
        return $resource('/perfil', {
            get: {
                method: 'GET'
            }
        });
    });

})();