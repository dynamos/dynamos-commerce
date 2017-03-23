/**
 * Created by Adelmo on 09/09/2016.
 */
(function () {
    'use strict';

    angular
        .module('pandora')
        .run(runConfig);

    runConfig.$inject = ['stateHandler'];

    function runConfig(stateHandler) {
        stateHandler.initialize();
    }
})();

