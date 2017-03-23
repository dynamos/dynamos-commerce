/**
 * Created by Adelmo Alves on 12/01/2017.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .factory('notificationInterceptor', notificationInterceptor);

    notificationInterceptor.$inject = ['$q', 'messageCenterService'];

    function notificationInterceptor($q, messageCenterService) {
        var service = {
            response: response
        };

        return service;

        function response(response) {
            if (response.headers('X-ErrorMessage') != undefined) {
                showMessage(response.headers('X-ErrorMessage'), 'danger')
            } else if (response.headers('X-SuccessMessage') != undefined) {
                showMessage(response.headers('X-SuccessMessage'), 'success')
            }

            return response;
        }

        function showMessage(message, type) {
            messageCenterService.add(type, message, {status: messageCenterService.shown});
        }
    }
})();