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
            var authority = attrs.hasAuthority.replace(/\s+/g, '').split(',');

            var setVisible = function () {
                    element.removeClass("ng-hide");
                },

                setHidden = function () {
                    element.addClass("ng-hide");
                },

                defineVisibility = function (reset) {
                    var result;

                    if (reset) {
                        setVisible();
                    }

                    Principal.hasAuthority(authority).then(function (result) {
                        if (result) {
                            setVisible();
                        } else {
                            setHidden();
                        }
                    });
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