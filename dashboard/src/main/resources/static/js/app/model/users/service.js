/**
 * Created by Adelmo Alves on 09/01/2017.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .factory('UserService', UserService);

    UserService.$inject = ['User', '$q'];

    function UserService(User, $q) {
        var service = {
            query: query,
            save: save,
            update: update,
            delete: del,
            get: get
        };

        return service;

        function get(id, callback){
            var deferred = $q.defer();

            User.get({id: id}).$promise.then(callback);

            return deferred.promise;
        }

        function query(params, callback) {
            var deferred = $q.defer();

            User.query(params).$promise.then(callback);

            return deferred.promise;
        }

        function save(entity, callback) {
            var deferred = $q.defer();

            User.save(entity).$promise.then(callback);

            return deferred.promise;
        }

        function update(entity, callback) {
            var deferred = $q.defer();

            User.update(entity).$promise.then(callback);

            return deferred.promise;
        }

        function del(id, callback) {
            var deferred = $q.defer();

            User.delete({ id: id }).$promise.then(callback);

            return deferred.promise;
        }
    }
})();
