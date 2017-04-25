/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';
    angular.module('dynamos-panel').factory('notificationInterceptor', notificationInterceptor);

    notificationInterceptor.$inject = ['$q', 'messageCenterService'];

    function notificationInterceptor($q, messageCenterService) {
        return {
            responseError: responseError,
            response: response
        };

        function responseError(response) {
            addMessage(response);
            return $q.reject(response);
        }

        function response(response) {
            addMessage(response);
            return response;
        }

        function addMessage(response) {
            var alert = response.headers('X-dynamosPanel-alert');
            var alertType = response.headers('X-dynamosPanel-alertType');

            if (angular.isString(alert) && angular.isString(alertType)) {
                messageCenterService.add(alertType, alert, {
                    status: messageCenterService.status.shown,
                    timeout: 6000
                });
            } else {
                switch (response.status) {
                    case 400:
                        break;
                    case '500':
                        break;
                }
            }
        }
    }
})();