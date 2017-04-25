/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';
    angular.module('dynamos-panel').factory('Manufacturer',
        function ($resource) {
            return $resource('api/manufacturer/:id', {}, {
                'query': {
                    method: 'GET',
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