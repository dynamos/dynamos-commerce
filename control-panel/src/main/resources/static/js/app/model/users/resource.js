/**
 * Created by Adelmo Alves on 09/01/2017.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .factory('User', User);

    User.$inject = ['$resource'];

    function User($resource) {
        var service = $resource('api/users/:id', {}, {
            'get': {method: 'GET', params: {}, isArray: false},
            'query': {method: 'GET', params: {}, isArray: false, cancellable: true},
            'update': {method: 'PUT'},
            'delete': {method: 'DELETE'}
        });

        return service;
    }
})();
