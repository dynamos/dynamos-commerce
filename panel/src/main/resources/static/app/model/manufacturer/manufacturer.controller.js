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
        vm.deleteManufacturer = deleteManufacturer;
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

        function deleteManufacturer(manufacturer) {
            openConfirm(manufacturer);
        }

        function openConfirm(manufacturer) {
            swal({
                title: "Are you sure?",
                text: "You will not be able to recover this Manufacturer " + manufacturer.name + "!",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then(function () {
                Manufacturer.delete(manufacturer, loadAll);
            });
        }
        loadAll();
    }
})();