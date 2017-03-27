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
