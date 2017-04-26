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
                    case 0:
                        messageCenterService.add('danger', 'Server not reachable', {
                            timeout: 6000
                        });
                    case 400:
                        if (response.data !== undefined && response.data.errors !== undefined) {
                            for (var i = 0; i < response.data.errors.length; i++) {

                                var fieldError = response.data.errors[i];

                                messageCenterService.add('danger', fieldError.field + ' ' + fieldError.defaultMessage, {
                                    timeout: 6000
                                });
                            }
                        }
                        break;
                    case '500':
                        break;
                }
            }
        }
    }
})();