(function() {
    'use strict';

    angular
        .module('pandora')
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