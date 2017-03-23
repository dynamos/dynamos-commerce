(function () {
    'use strict';

    angular
        .module('pandora')
        .factory('errorHandlerInterceptor', errorHandlerInterceptor);

    errorHandlerInterceptor.$inject = ['$q', 'messageCenterService', '$injector'];

    function errorHandlerInterceptor($q, messageCenterService, $injector) {
        var handler = {
            responseError: responseError
        };

        return handler;

        function responseError(response) {
            var message = response.data.error != undefined ? response.data.error + ' - ' + response.data.message : undefined;

            message = message == undefined ? response.headers('X-ErrorMessage') : message;

            switch (response.status) {
                case 0:
                    messageCenterService.add('Erro', 'O Servidor está fora do ar', {status: messageCenterService.status.shown});
                    break;
                case 400:
                    if (message != null)
                        messageCenterService.add('danger', message, {status: messageCenterService.status.shown});
                    else if (response.data && response.data.fieldErrors) {

                    }
                    break;
                case 404:
                    if (message === null) {
                        var $state = $injector.get('$state');
                        $state.go('404');
                    }
                    else
                        messageCenterService.add('Erro', 'Solicitação Incorreta. ' + message, {status: messageCenterService.status.shown});
                    break;
                case 500:
            }

            return err;
        }
    }
})();