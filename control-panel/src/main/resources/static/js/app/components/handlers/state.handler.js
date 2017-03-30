/**
 * Created by adelmo.pereira on 11/11/2016.
 */
(function() {
    'use strict';

    angular
        .module('pandora')
        .factory('stateHandler', stateHandler);

    stateHandler.$inject = ['$rootScope', '$state', '$window', 'Auth', 'Principal'];

    function stateHandler($rootScope, $state,  $window,
                          Auth, Principal) {
        return {
            initialize: initialize
        };

        function initialize() {
            var stateChangeStart = $rootScope.$on('$stateChangeStart', function (event, toState, toStateParams, fromState) {
                $rootScope.toState = toState;
                $rootScope.toStateParams = toStateParams;
                $rootScope.fromState = fromState;

                if (toState.external) {
                    event.preventDefault();
                    $window.open(toState.url, '_self');
                }

                Auth.authorize(true);
            });

            var stateChangeSuccess = $rootScope.$on('$stateChangeSuccess',  function(event, toState, toParams, fromState, fromParams) {
                var titleKey = 'Dynamos Admin' ;

                if (toState.data !== null && angular.isDefined(toState.data) && angular.isDefined(toState.data.pageTitle) ){
                    titleKey = toState.data.pageTitle;
                }
                $window.document.title =  $window.document.title.length > 0 ? $window.document.title + ' - ' + titleKey : titleKey;
            });

            $rootScope.$on('$destroy', function () {
                if(angular.isDefined(stateChangeStart) && stateChangeStart !== null){
                    stateChangeStart();
                }
                if(angular.isDefined(stateChangeSuccess) && stateChangeSuccess !== null){
                    stateChangeSuccess();
                }
            });
        }
    }
})();
