/**
 * Created by Adelmo on 09/09/2016.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .controller('SearchUsersController', SearchUserController);

    SearchUserController.$inject = ['$scope', 'UserService'];

    function SearchUserController($scope, UserService) {
        $scope.currentPage = 0;

        $scope.list = list;
        $scope.delete = del;

        function list() {
            var params = {
                page: $scope.currentPage
            };

            UserService.query(params, callback);

            function callback(data) {
                $scope.users = data.content;
                $scope.totalItems = data.numberOfElements;
            }
        }

        function del(id) {
            UserService.delete(id, $scope.list);
        }


        $scope.list();
    }
})();