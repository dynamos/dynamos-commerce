/**
 * Created by adelmo.pereira on 06/05/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').directive('dynamic', directive);

    directive.$inject = ['$compile'];

    function directive($compile) {
        return {
            restrict: 'A',
            replace: true,
            scope: {dynamic: '=dynamic'},
            link: function postLink(scope, element, attrs) {
                scope.$watch('dynamic', function (html) {
                    element.html(html);
                    $compile(element.contents())(scope);
                });
            }
        };
    }
})();