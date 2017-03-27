/**
 * Created by adelmo on 13/10/16.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .factory('authExpiredInterceptor', authExpiredInterceptor);


    authExpiredInterceptor.$inject = ['$rootScope', '$q', '$injector', '$document'];

    function authExpiredInterceptor($q, $injector, $document) {
        var service = {
            responseError: responseError
        };

        return service;

        function responseError(response) {
            if (response.status === 401 && angular.isDefined(response.data.path) && response.data.path.indexOf('/api/account') === -1) {
                $state.go("login");
            } else if (response.status === 403 && response.config.method !== 'GET' && getCSRF() === '') {
                var $http = $injector.get('$http');
                return $http.get('/').finally(function () {
                    return afterCSRFRenewed(response);
                });
            }
            return $q.reject(response);
        }

        function getCSRF() {
            var doc = $document[0];
            if (doc) {
                var name = 'CSRF-TOKEN=';
                var ca = doc.cookie.split(';');
                for (var i = 0; i < ca.length; i++) {
                    var c = ca[i];
                    while (c.charAt(0) === ' ') {
                        c = c.substring(1);
                    }

                    if (c.indexOf(name) !== -1) {
                        return c.substring(name.length, c.length);
                    }
                }
            }
            return '';
        }

        function afterCSRFRenewed(oldResponse) {
            if (getCSRF() !== '') {
                var $http = $injector.get('$http');
                return $http(oldResponse.config);
            } else {
                return $q.reject(oldResponse);
            }
        }
    }

})();