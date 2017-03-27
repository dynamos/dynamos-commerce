(function () {
    'use strict';

    angular.module('pandora').factory('authExpiredInterceptor', authExpiredInterceptor);

    authExpiredInterceptor.$inject = ['$rootScope', '$q', '$injector'];

    function authExpiredInterceptor($rootScope, $q, $injector) {
        var service = {
            responseError: responseError
        };

        return service;

        function responseError(response) {
            if (response.status === 401 && angular.isDefined(response.data.path) && response.data.path.indexOf('/api/account') === -1) {
                var Auth = $injector.get('Auth');
                var to = $rootScope.toState;
                var params = $rootScope.toStateParams;
                Auth.logout();

                var state = $injector.get('$state');

                state.go('login');
            }
            return $q.reject(response);
        }
    }
})();