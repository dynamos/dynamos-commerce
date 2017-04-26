/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('ListManufacturerController', controller);

    controller.$inject = ['Manufacturer'];

    function controller(Manufacturer) {
        var vm = this;
        vm.loadAll = loadAll;
        vm.manufacturers = [];
        vm.manufacturer = {};

        function loadAll() {
            Manufacturer.query({
                page: vm.currentPage - 1,
                name: vm.manufacturer.name
            }, onSuccess);

            function onSuccess(result) {
                vm.manufacturers = result.content;
                vm.totalItems = result.totalElements;
                vm.currentPage = result.number + 1;
            }
        }

        loadAll();
    }
})();