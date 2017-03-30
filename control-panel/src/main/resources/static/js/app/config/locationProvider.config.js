/**
 * Created by adelmo.pereira on 09/09/2016.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .config(locationProviderConfig);

    locationProviderConfig.$inject = ['$locationProvider'];

    function locationProviderConfig($locationProvider) {
        $locationProvider.html5Mode(false);
    }
})();