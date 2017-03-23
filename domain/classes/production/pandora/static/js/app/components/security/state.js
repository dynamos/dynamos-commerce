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
            resolve:{
                loadCSS: ['$ocLazyLoad', function($ocLazyLoad) {
                    // you can lazy load CSS files
                    return $ocLazyLoad.load([{
                        serie: true,
                        name: 'Font Awesome',
                        files: ['css/font-awesome.min.css']
                    },{
                        serie: true,
                        name: 'Simple Line Icons',
                        files: ['css/simple-line-icons.css']
                    }]);
                }]
            }
        });
        //State
        $stateProvider.state('recovery-password', {
            url: '/recovery-password',
            templateUrl: 'views/security/recovery-password.html'
        });
    }
})();