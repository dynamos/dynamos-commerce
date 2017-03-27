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