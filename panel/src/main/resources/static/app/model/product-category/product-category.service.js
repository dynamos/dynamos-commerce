/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';
    angular.module('dynamos-panel').factory('ProductCategory',
        function ($resource) {
            return $resource('api/product-category/:id', {}, {
                'query': {
                    method: 'GET',
                },
                'update': {
                    method: 'PUT'
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