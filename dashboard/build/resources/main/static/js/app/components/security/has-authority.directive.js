/**
 * Created by Adelmo Alves on 18/01/2017.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .directive('hasAuthority', hasAuthority);

    hasAuthority.$inject = ['Principal'];

    function hasAuthority(Principal) {
        var directive = {
            restrict: 'A',
            link: linkFunc
        };

        return directive;

        function linkFunc(scope, element, attrs) {
            var authority = attrs.hasAuthority.replace(/\s+/g, '');

            var setVisible = function () {
                    element.removeClass('hidden');
                },
                setHidden = function () {
                    element.addClass('hidden');
                },
                defineVisibility = function (reset) {

                    if (reset) {
                        setVisible();
                    }

                    if (Principal.hasAuthority(authority)) {
                        setVisible();
                    } else {
                        setHidden()
                    }
                };

            if (authority.length > 0) {
                defineVisibility(true);

                scope.$watch(function () {
                    return Principal.isAuthenticated();
                }, function () {
                    defineVisibility(true);
                });
            }
        }
    }
})();