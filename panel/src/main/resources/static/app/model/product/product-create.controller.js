/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('CreateProductController', controller);

    controller.$inject = ['Product', '$uibModal'];

    function controller(Product, $uibModal) {
        var vm = this;
        vm.product = {};

        vm.save = save;
        vm.selectManufacturer = selectManufacturer;

        function save() {
            Product.save(vm.product);
        }

        function selectManufacturer() {
            $uibModal.open({
                templateUrl: 'app/model/manufacturer/manufacturer-modal.html',
                controller: 'ManufacturerModal',
                controllerAs: 'vm',
                size: 'lg'
            }).result.then(success);

            function success(manufacturer) {
                vm.product.manufacturer = manufacturer;
            }
        }
    }
})();