/**
 * Created by adelmo.pereira on 04/05/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('ProductCategoryModal', controller);

    controller.$inject = ['$uibModalInstance', 'ProductCategory'];

    function controller($uibModalInstance, ProductCategory) {
        var vm = this;
        vm.productCategories = [];
        vm.productCategory = {};

        vm.loadAll = loadAll
        vm.select = select;
        vm.cancel = cancel;
        vm.saveAndSelect = saveAndSelect;

        loadAll();

        function loadAll() {
            ProductCategory.query({
                page: vm.currentPage - 1
            }, onSuccess);

            function onSuccess(result) {
                vm.productCategories = result.content;
                vm.totalItems = result.totalElements;
                vm.currentPage = result.number + 1;
            }
        }

        function saveAndSelect() {
            ProductCategory.save(vm.productCategory).$promise.then(select);
        }

        function select(productCategory) {
            $uibModalInstance.close(productCategory);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();