/**
 * Created by adelmo on 2/14/16.
 */
(function () {
    'use strict'

    angular.module('rhinoApplication').controller('perfilController', function ($scope, $http, Perfil) {
        $scope.user = Perfil.get();

        $scope.save = function(){
            Perfil.save($scope.user, function(response){
                $scope.messages = [{
                    title : response.title,
                    body  : response.body,
                    messageType: response.messageType
                }];
            }, function(error){
                $scope.messages = error.data;
            });
        }
    });
})();

