/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular
        .module('dynamos-panel')
        .config(paginationConfig);

    paginationConfig.$inject = ['uibPaginationConfig'];

    function paginationConfig(uibPaginationConfig) {
        uibPaginationConfig.itemsPerPage = 15;
        uibPaginationConfig.maxSize = 5;
        uibPaginationConfig.boundaryLinks = true;
        uibPaginationConfig.firstText = '«';
        uibPaginationConfig.previousText = '‹';
        uibPaginationConfig.nextText = '›';
        uibPaginationConfig.lastText = '»';
    }
})();