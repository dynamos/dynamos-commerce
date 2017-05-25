/**
 * Created by adelmo.pereira on 04/05/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('ManufacturerModal', controller);

    controller.$inject = ['$uibModalInstance', 'Manufacturer'];

    function controller($uibModalInstance, Manufacturer) {
        var vm = this;
        vm.manufacturers = [];
        vm.manufacturer = {};

        vm.loadAll = loadAll
        vm.select = select;
        vm.cancel = cancel;
        vm.saveAndSelect = saveAndSelect;

        loadAll();

        function loadAll() {
            Manufacturer.query({
                page: vm.currentPage - 1
            }, onSuccess);

            function onSuccess(result) {
                vm.manufacturers = result.content;
                vm.totalItems = result.totalElements;
                vm.currentPage = result.number + 1;
            }
        }

        function saveAndSelect() {
            Manufacturer.save(vm.manufacturer).$promise.then(select);
        }

        function select(manufacturer) {
            $uibModalInstance.close(manufacturer);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();