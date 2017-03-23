/**
 * Created by adelmo.pereira on 11/11/2016.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .factory('Account', Account);

    Account.$inject = ['$resource'];

    function Account($resource) {
        var service = $resource('api/account', {}, {
            'get': {
                method: 'GET', params: {}, isArray: false,
                interceptor: {
                    response: function (response) {
                        return response;
                    }
                }
            }
        });

        return service;
    }
})();
