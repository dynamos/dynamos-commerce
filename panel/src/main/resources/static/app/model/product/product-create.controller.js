/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('CreateProductController', controller);

    controller.$inject = ['Product', '$uibModal', '$state'];

    function controller(Product, $uibModal, $state) {
        var vm = this;
        vm.product = {};

        vm.save = save;
        vm.selectManufacturer = selectManufacturer;
        vm.selectProductCategory = selectProductCategory;

        function save() {
            Product.save(vm.product).$promise.then(function () {
                $state.go('product')
            });
        }

        function selectProductCategory() {
            $uibModal.open({
                templateUrl: 'app/model/product-category/product-category-modal.html',
                controller: 'ProductCategoryModal',
                controllerAs: 'vm',
                size: 'lg'
            }).result.then(success);

            function success(productCategory) {
                vm.product.productCategory = productCategory;
            }
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