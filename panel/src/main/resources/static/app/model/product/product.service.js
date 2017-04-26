/**
 * Created by adelmo.pereira on 26/04/2017.
 */
(function () {
    'use strict';
    angular.module('dynamos-panel').factory('Product',
        function ($resource) {
            return $resource('api/product/:id', {}, {
                'query': {
                    method: 'GET'
                },
                'get': {
                    method: 'GET',
                    transformResponse: function (data) {
                        if (data) {
                            data = angular.fromJson(data);
                        }
                        return data;
                    }
                }
            });
        });
})();