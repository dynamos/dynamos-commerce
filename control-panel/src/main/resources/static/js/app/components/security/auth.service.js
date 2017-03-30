(function () {
    'use strict';

    angular
        .module('pandora')
        .factory('Auth', Auth);

    Auth.$inject = ['$http', '$state', '$rootScope', 'Principal'];

    function Auth($http, $state, $rootScope, Principal) {

        var service = {
            login: login,
            logout: logout,
            authorize: authorize
        };

        return service;

        function login(credentials) {
            var data = 'username=' + encodeURIComponent(credentials.username)
                + '&password=' + encodeURIComponent(credentials.password) + '&submit=Login';

            return $http.post('api/authentication', data, {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            });
        }

        function logout() {
            $http.post('api/logout').then(function (response) {
                Principal.deactivate();
                $state.go("login");
            });
        }

        function authorize(force) {
            var authReturn = Principal.identity(force).then(authThen);

            return authReturn;

            function authThen() {
                var isAuthenticated = Principal.isAuthenticated();

                if (!isAuthenticated) {
                    if($rootScope.toState.name !== 'login'){
                        $state.go('login');
                    }
                } else {
                    if (isAuthenticated && $rootScope.toState.parent === 'account' && ($rootScope.toState.name === 'login' || $rootScope.toState.name === 'resetPassword')) {
                        $state.go('dashboard');
                    }

                    if ($rootScope.toState.data && $rootScope.toState.data.authorities && $rootScope.toState.data.authorities.length > 0 && !Principal.hasAnyAuthority($rootScope.toState.data.authorities)) {
                        if (isAuthenticated) {
                            $state.go('401');
                        }
                        else {
                            $state.go('login');
                        }
                    }
                }
            }
        }
    }
})
();