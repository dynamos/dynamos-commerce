/**
 * Created by adelmo.pereira on 11/11/2016.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .factory('Principal', Principal);

    Principal.$inject = ['Account', '$q'];

    function Principal(Account, $q) {
        var _identity,
            _authenticated = false;

        var service = {
            authenticate: authenticate,
            hasAnyAuthority: hasAnyAuthority,
            hasAuthority: hasAuthority,
            isAuthenticated: isAuthenticated,
            isIdentityResolved: isIdentityResolved,
            deactivate: deactivate,
            identity: identity
        };

        return service;

        function authenticate(identity) {
            _identity = identity;
            _authenticated = identity !== null;
        }

        function hasAuthority(authoritie) {
            if (!_authenticated || !_identity || !_identity.authorities) {
                return false;
            }

            for (var i = 0; i < _identity.authorities.length; i++) {
                if (_identity.authorities[i].name === authoritie) {
                    return true;
                }
            }

            return false;
        }

        function hasAnyAuthority(authorities) {
            if (!_authenticated || !_identity || !_identity.authorities) {
                return false;
            }

            for (var i = 0; i < authorities.length; i++) {
                if (_identity.authorities[i].name.indexOf(authorities[i]) !== -1) {
                    return true;
                }
            }

            return false;
        }

        function identity(force) {
            var deferred = $q.defer();

            if (force === true) {
                _identity = undefined;
            }

            if (angular.isDefined(_identity)) {
                deferred.resolve(_identity);

                return deferred.promise;
            }

            Account.get().$promise.then(getAccountThen, getAccountCatch);

            return deferred.promise;

            function getAccountThen(account) {
                _identity = account.data;
                _authenticated = true;
                deferred.resolve(_identity);
            }

            function getAccountCatch() {
                _identity = null;
                _authenticated = false;
                deferred.resolve(_identity);
            }
        }

        function isAuthenticated() {
            return _authenticated;
        }

        function isIdentityResolved() {
            return angular.isDefined(_identity);
        }

        function deactivate() {
            _identity = null;
            _authenticated = false;
        }
    }
})();
