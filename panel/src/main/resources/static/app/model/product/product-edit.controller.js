/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('EditProductController', controller);

    controller.$inject = ['Product', '$stateParams', '$state'];

    function controller(Product, $stateParams, $state) {
        var vm = this;
        vm.save = save;
        vm.selectManufacturer = selectManufacturer;

        Product.get({id: $stateParams.id}).$promise.then(function (result) {
                vm.product = result
            }
        );

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

        function save() {
            Product.update(vm.product).$promise.then(function () {
                $state.go('product');
            });
        }
    }
})();